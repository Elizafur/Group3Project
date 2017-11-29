package project2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.SortOrder;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;

public class PhonebookUI {
	private JPanel mainPanel;
	private JFrame frame;
	
	SimpleTableModel tableModel = new SimpleTableModel(0);
	JTable table;
	TableRowSorter<TableModel> sorter;
	
	JPanel buttonPanel;
	JTextField searchBar;
	JButton searchButton;
	JPanel searchPanel;
	
	JButton addContactButton;
	JButton removeContactButton;
	JButton resetContactsButton;
	JButton exportToCSVButton;
	
	public PhonebookUI()	{
		frame = new JFrame("Phonebook");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(600, 801);
		
		frame.getContentPane().setLayout(new BorderLayout());
		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		
		searchPanel = new JPanel(new GridBagLayout());
		searchBar = new JTextField();
		searchButton = new JButton("Search");
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 1;
		c.gridy = 0;
		searchPanel.add(searchBar, c);
		c.weightx = 0;
		c.gridx = 0;
		JLabel l = new JLabel("Search: ");
		searchPanel.add(l, c);
		
		frame.getContentPane().add(searchPanel, BorderLayout.NORTH);
		
		// Listen for changes in the text
		searchBar.getDocument().addDocumentListener(new DocumentListener() {
		  public void changedUpdate(DocumentEvent e) {
			  filter();
		  }
		  public void removeUpdate(DocumentEvent e) {
			  filter();
		  }
		  public void insertUpdate(DocumentEvent e) {
			  filter();
		  }

		  public void filter() {
			  String text = searchBar.getText();
			  if (text.trim().length() == 0) {
				  sorter.setRowFilter(null);
			  } else {
				  sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
			  }
		  }
		});
		
		
		table = new JTable(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);	
		
		mainPanel.add(scrollPane);
				
		addContactButton = new JButton();
		removeContactButton = new JButton();

		addContactButton.setText("<html><div style='text-align: center;'>Add<br>Contact</div></html>");
		removeContactButton.setText("<html><div style='text-align: center;'>Remove<br>Contact</div></html>");
		
		resetContactsButton = new JButton();
		exportToCSVButton = new JButton();
		
		resetContactsButton.setText("Reset");
		exportToCSVButton.setText("<html><div style='text-align: center;'>Export<br>to<br>CSV</div></html>");
		
		buttonPanel = new JPanel(new GridBagLayout());
		c = new GridBagConstraints();
		addContactButton.setPreferredSize(new Dimension(100,50));
		removeContactButton.setPreferredSize(new Dimension(100,50));
		resetContactsButton.setPreferredSize(new Dimension(100,50));
		exportToCSVButton.setPreferredSize(new Dimension(100,50));
		
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		buttonPanel.add(addContactButton, c);
		c.gridx = 1;
		buttonPanel.add(removeContactButton, c);
		c.gridx = 2;
		buttonPanel.add(resetContactsButton, c);
		
		JPanel parentPanel = new JPanel();
		parentPanel.add(buttonPanel, BorderLayout.EAST);
		
		frame.getContentPane().add(parentPanel, BorderLayout.SOUTH);
		
		/*addContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				addNewContact();
			}
		});*/
		removeContactButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				int selected = checkUserSelectedRow();
				if (selected == -1) return;
				
				tableModel.setValueAt("", selected, 0);
				tableModel.setValueAt("", selected, 1);
				tableModel.setValueAt("", selected, 2);
				tableModel.setValueAt("", selected, 3);
			}
		});
		resetContactsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)	{
				int n = JOptionPane.showConfirmDialog(
					    frame,
					    "Are you sure you would like to reset all entries?",
					    "Confirmation",
					    JOptionPane.YES_NO_OPTION);
				
				if (n == JOptionPane.NO_OPTION)
					return;
				
				
				for (int i = 0; i < tableModel.rowLength; ++i)	{
					tableModel.setValueAt("", i, 0);
					tableModel.setValueAt("", i, 1);
					tableModel.setValueAt("", i, 2);
					tableModel.setValueAt("", i, 3);
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent me) {
		        JTable table =(JTable) me.getSource();
		        Point p = me.getPoint();
		        int row = table.rowAtPoint(p);
		        if (me.getClickCount() == 2 && row != -1) {
		        	//addNewContact();
		        }
		    }
		});
		
		
		//Setting up the file menu bar.
		//Creation of toolbar.
		JMenuBar menubar = new JMenuBar();

        JMenu file = new JMenu("File");
        file.setMnemonic(KeyEvent.VK_F1);
        
        JMenuItem saveToFile = new JMenuItem("Save table");
        JMenuItem loadFromFile = new JMenuItem("Load table");
        
        JMenuItem exportToCSV = new JMenuItem("Export to CSV");
        JMenuItem importFromCSV = new JMenuItem("Import from CSV");
        exportToCSV.addActionListener((ActionEvent event) -> {
        		writeCSVFile();
        	}
        );
        
        importFromCSV.addActionListener((ActionEvent event) -> {
        		readCSVFile();
    		}
        );
        
        saveToFile.addActionListener((ActionEvent event) -> {
    			writeXMLFile();
	    	}
	    );
    
	    loadFromFile.addActionListener((ActionEvent event) -> {
	    		readXMLFile();
			}
	    );
        
        file.add(saveToFile);
        file.add(loadFromFile);
        file.add(exportToCSV);
        file.add(importFromCSV);
        menubar.add(file);
        
        JMenu sort = new JMenu("Sort");
        file.setMnemonic(KeyEvent.VK_F2);
        JMenu sortBySubMenu = new JMenu("Sort by");
        JMenuItem sortByFirstName = new JMenuItem("First Name");
        JMenuItem sortByLastName = new JMenuItem("Last Name");
        JMenuItem sortByPhone = new JMenuItem("Phone Number");
        JMenuItem sortByEmail = new JMenuItem("Email Address");
        
        
        sortByFirstName.addActionListener((ActionEvent event) -> {
	        	tableSortColumn(0);
			}
	    );
	    
	   	sortByLastName.addActionListener((ActionEvent event) -> {
		   		tableSortColumn(1);
	    	}
	    );
	
	   	sortByPhone.addActionListener((ActionEvent event) -> {
	   			tableSortColumn(3);
	   		}
	   	);	
	   	
	    sortByEmail.addActionListener((ActionEvent event) -> {
		    	tableSortColumn(3);
			}
	    );
        
        
        sortBySubMenu.add(sortByFirstName);
        sortBySubMenu.add(sortByLastName);
        sortBySubMenu.add(sortByPhone);
        sortBySubMenu.add(sortByEmail);
        sort.add(sortBySubMenu);
        menubar.add(sort);
        
        frame.setJMenuBar(menubar);
        
		frame.setLocation(300, 25);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args)	{
		PhonebookUI p = new PhonebookUI();
	}
	
	public void tableSortColumn(int col)	{
		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
    	sortKeys.add(new RowSorter.SortKey(col, SortOrder.ASCENDING));
    	sorter.setSortKeys(sortKeys);
    	
    	
    	//Note since the default Java RowSorter decides to sort blank rows as well as filled ones.
    	//The array needs to be reversed so that blank rows will not show up first.
    	//reverseTableArray();
    	
	}
	
	public void reverseTableArray()	{
		Object[][] o = new Object[tableModel.rowLength][4];
		for (int i = 0; i < tableModel.rowLength; ++i)	{
			o[i][0] = tableModel.getValueAt(i, 0);
			o[i][1] = tableModel.getValueAt(i, 1);
			o[i][2] = tableModel.getValueAt(i, 2);
			o[i][3] = tableModel.getValueAt(i, 3);
		}
		
		for (int i = 0; i < tableModel.rowLength / 2; ++i)	{
			for (int j = 0; j < 4; ++j)	{
				Object temp = tableModel.getValueAt(i, j);
				tableModel.setValueAt(o[tableModel.rowLength - i - 1][j], i, j);
				tableModel.setValueAt(temp, tableModel.rowLength - i - 1, j);
			}
		}
		
	}
	
	/*public void addNewContact()	{
		int selected = checkUserSelectedRow();
		if (selected == -1)	return;
		
		Contact c = new Contact();
		new AddContactDialog(frame, c);
		
		tableModel.setValueAt(c.firstName, selected, 0);
		tableModel.setValueAt(c.lastName, selected, 1);
		tableModel.setValueAt(c.phoneNumber, selected, 2);
		tableModel.setValueAt(c.emailAddress, selected, 3);
	}
	*/
	public int checkUserSelectedRow()	{
		int selected = table.getSelectedRow();		
		if (selected == -1)	{
			JOptionPane.showMessageDialog(frame,
				"You must select a row to add a contact to.",
				"Error",
				JOptionPane.ERROR_MESSAGE
			);
		}
		
		return selected;
	}
	
	public void readCSVFile()	{	
		JFileChooser fileChooser = new JFileChooser();
        
        try {
        	File f = new File(PhonebookUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "\\saved tables");
        	f.mkdir();
			fileChooser.setCurrentDirectory(f);
		} catch (Exception e1) {
			//This really shouldnt break.
			e1.printStackTrace();
		}
        
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	File selectedFile = fileChooser.getSelectedFile();
			BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ",";
	
	        try {
	            br = new BufferedReader(new FileReader(selectedFile));
	            br.readLine(); //Use a fake readline here to consume the column names that are in the CSV file.
	            int row = 0;
	            while (row < tableModel.rowLength) {
	            	line = br.readLine();
	            	
	            	Pattern p = Pattern.compile("\"([^\"]*)\""); //Using regex to get values in between the quotes.
	            	Matcher m = p.matcher(line);
	            	int i = 0;
	            	while (m.find()) {  
	            	  table.setValueAt(m.group(1), row, i);
	            	  ++i;
	            	}
	                ++row;	                
	            }
	
	        } catch (FileNotFoundException e) {
	        	displayFileReadingError(selectedFile);
	            e.printStackTrace();
	        } catch (IOException e) {
	        	displayFileReadingError(selectedFile);
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
        }
	}
	
	public void writeCSVFile()	{
		JFileChooser fileChooser = new JFileChooser();
        
        try {
        	File f = new File(PhonebookUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "\\saved tables");
        	f.mkdir();
			fileChooser.setCurrentDirectory(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
        fileChooser.setSelectedFile(new File("CSVTableData.csv"));
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	File selectedFile = fileChooser.getSelectedFile();
        	try	{
	        	selectedFile.createNewFile();
			  	String saveName = selectedFile.getAbsolutePath();
			  	PrintWriter fo = new PrintWriter(saveName);
			  	
			  	for (int i = 0; i < tableModel.columnNames.length; ++i)	{
			  		fo.print("\"" + tableModel.columnNames[i] + ":\",");
			  	}
			  	fo.print("\n");
			  	
				for (int i = 0; i < tableModel.rowLength; ++i)	{
					fo.print("\"" + tableModel.getValueAt(i, 0) + "\",");
					fo.print("\"" + tableModel.getValueAt(i, 1) + "\",");
					fo.print("\"" + tableModel.getValueAt(i, 2) + "\",");
					fo.print("\"" + tableModel.getValueAt(i, 3) + "\"\n");
				}
				fo.close();
	        } catch (FileNotFoundException e)	{
	        	displayFileReadingError(selectedFile);
				e.printStackTrace(System.err);
			} catch (IOException e)	{
				displayFileReadingError(selectedFile);
				e.printStackTrace(System.err);
			}
        }
	}
	
	public void writeXMLFile()	{
		JFileChooser fileChooser = new JFileChooser();
        
        try {
        	File f = new File(PhonebookUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "\\saved tables");
        	f.mkdir();
			fileChooser.setCurrentDirectory(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
        fileChooser.setSelectedFile(new File("tableData.xml"));
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	File selectedFile = fileChooser.getSelectedFile();
        	try	{
			  	selectedFile.createNewFile();
			  	String saveName = selectedFile.getAbsolutePath();
				
			  	XMLEncoder e = new XMLEncoder(
			            new BufferedOutputStream(
			                new FileOutputStream(saveName)));

		  		for (int i = 0; i < tableModel.rowLength; ++i)	{
		  			Object[] o = new Object[4];
		  			o[0] = tableModel.getValueAt(i, 0);
		  			o[1] = tableModel.getValueAt(i, 1);
		  			o[2] = tableModel.getValueAt(i, 2);
		  			o[3] = tableModel.getValueAt(i, 3);
		  			e.writeObject(o);
		  		}
		  		
		  		e.close();
    		} catch (FileNotFoundException e)	{
    			displayFileReadingError(selectedFile);
    			e.printStackTrace(System.err);
    		} catch (IOException e)	{
    			displayFileReadingError(selectedFile);
    			e.printStackTrace(System.err);
    		}       
        }
	}
	
	public void readXMLFile()	{
		JFileChooser fileChooser = new JFileChooser();
        
        try {
        	File f = new File(PhonebookUI.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath() + "\\saved tables");
        	f.mkdir();
			fileChooser.setCurrentDirectory(f);
		} catch (Exception e1) {
			//This really shouldnt break.
			e1.printStackTrace();
		}
        
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	File selectedFile = fileChooser.getSelectedFile();
        	try	{
			  	selectedFile.createNewFile();
			  	String saveName = selectedFile.getAbsolutePath();
				
			  	XMLDecoder e = new XMLDecoder(
			            new BufferedInputStream(
			                new FileInputStream(saveName)));
		  		for (int i = 0; i < tableModel.rowLength; ++i)	{
		  			Object[] o = (Object[])e.readObject();
		  			for (int j = 0; j < 4; ++j)	{
		  				tableModel.setValueAt(o[j], i, j);
		  			}
		  			
		  		}
		  		
		  		e.close();
    		} catch (FileNotFoundException e)	{
    			displayFileReadingError(selectedFile);
    			e.printStackTrace(System.err);
    		} catch (IOException e)	{
    			displayFileReadingError(selectedFile);
    			e.printStackTrace(System.err);
    		}       
        }
	}
	
	public void displayFileReadingError(File f)	{
		JOptionPane.showMessageDialog(frame,
			    "Error reading file: " + f.getName(),
			    "File reading error",
			    JOptionPane.ERROR_MESSAGE);
	}
	/*public Object[][] convertListOfListsToArray(ArrayList<ArrayList<Object>> a)	{
		Object[][] x = new Object[a.size()][4];	//4 is used here since that is the number  of rows.
		for (int i = 0; i < a.size(); ++i)	{
			x[i] = a.get(i).stream().toArray(String[]::new);
		}
		
		return x;
	}*/
	
	
}
