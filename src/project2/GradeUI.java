package project2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableModel;

/**
 * @author EliF
 * Class to represent the UI for our program.
 */
public class GradeUI {
    private JPanel mainPanel;
    private JFrame frame;

    ArrayList<Student> students;

    SimpleTableModel tableModel;
    JTable table;
    TableRowSorter<TableModel> sorter;

    JPanel buttonPanel;
    JTextField searchBar;
    JCheckBox dropLowestGrade;
    JComboBox schemaSelection;
    JPanel optionPanel;
    JComboBox searchSelection;
    
    final String[] searchSelectionTerms = {"Name", "Grade Number", "Grade Letter"};

    /**
     * Constructs a GradeUI
     */
    public GradeUI()	{
        setUpUI();
        frame.setLocation(300, 25);
        frame.setVisible(true);

    }

    /**
        Will set up the creation of the UI elements and handle sizing and actionListeners for elements.
    */
    private void setUpUI()  {
        frame = new JFrame("Grade Reporter");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200, 258);

        frame.getContentPane().setLayout(new BorderLayout());
        mainPanel = new JPanel();
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        optionPanel = new JPanel(new GridBagLayout());
        searchBar = new JTextField();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridx = 3;
        c.gridy = 0;
        optionPanel.add(searchBar, c);
        c.weightx = 0;
        c.gridx = 0;
        JLabel l = new JLabel("Search by:   ");
        optionPanel.add(l, c);

        searchSelection = new JComboBox(searchSelectionTerms);
        c.gridx = 1;
        optionPanel.add(searchSelection); 


        c.gridx = 2;
        optionPanel.add(Box.createHorizontalStrut(10));


        //TODO:
        //c.gridx = 4;
        //optionPanel.add(Box.createHorizontalStrut(390));

        Schema[] sa = {Schema.ONE, Schema.TWO, Schema.THREE};
        schemaSelection = new JComboBox(sa);
        c.gridx = 5;
        JLabel lblSchema = new JLabel("Grading Schema: ");
        optionPanel.add(lblSchema, c);
        c.gridx = 6;
        optionPanel.add(schemaSelection, c);

        schemaSelection.addActionListener (new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                recalculateGrades();
            }
        });
        
        
        c.gridx = 7;
        optionPanel.add(Box.createHorizontalStrut(30));


        dropLowestGrade = new JCheckBox("Drop Lowest Grade");
        c.gridx = 8;
        optionPanel.add(dropLowestGrade, c);

        dropLowestGrade.addItemListener (new ItemListener () {
            @Override
            public void itemStateChanged(ItemEvent e) {
                recalculateGrades();
            }
        });
        
        
        frame.getContentPane().add(optionPanel, BorderLayout.NORTH);

        // Listen for changes in the text
        searchBar.getDocument().addDocumentListener(new DocumentListener() {
            
            @Override
            public void changedUpdate(DocumentEvent e) {
                    filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                    filter();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                    filter();
            }

            public void filter() {
                    String text = searchBar.getText();
                    if (text.trim().length() == 0) {
                          sorter.setRowFilter(null);
                    } else {
                          int selected = searchSelection.getSelectedIndex();
                          switch (selected) {
                              case 0:
                                  sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text, 0));
                                  break;
                              case 1:
                                  sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text, 17));
                                  break;
                              case 2:
                                  sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text, 18));
                                  break;
                        }

                    }
            }
        });


        GradeReader g = new GradeReader();
        students = g.getGrades();
        tableModel = new SimpleTableModel(students.size());
        populateTableValues();

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sorter = new TableRowSorter<TableModel>(table.getModel());
        table.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);	

        //Set width of name slightly larger than all the other columns
        table.getColumn(tableModel.getColumnName(0)).setPreferredWidth(150);

        mainPanel.add(scrollPane);		

        buttonPanel = new JPanel(new GridBagLayout());
    
        JPanel parentPanel = new JPanel();
        parentPanel.add(buttonPanel, BorderLayout.EAST);

        frame.getContentPane().add(parentPanel, BorderLayout.SOUTH);	  
    }

    ////////////////////////////////////////// Beginning of main method//////////////////////////////////////////////////
    
    public static void main(String[] args)	{
            GradeUI p = new GradeUI();
    }

    /**
     * Populates student values for the JTable.
     */
    private void populateTableValues() {

        for (int i = 0; i < students.size(); ++i)   {

            String name = students.get(i).getName()[0] + " " + students.get(i).getName()[1];
            ArrayList<Double> quiz = students.get(i).getQuiz();
            ArrayList<Double> assignment = students.get(i).getAssignment();
            ArrayList<Double> exam = students.get(i).getExam();
            double project = students.get(i).getProject();
            double attendance = students.get(i).getAttendance();
            tableModel.setValueAt(name, i, 0);

            //adding quizzes
            for (int j = 0; j < quiz.size(); ++j)   {
                tableModel.setValueAt(quiz.get(j), i, j+1);
            }
            //add Quiz avg 
            tableModel.setValueAt(GradeCalculator.calculateQuizAverage(students.get(i), dropLowestGrade.isSelected()), i, 6);

            //adding assignments
            for (int j = 0, h = 7; j < assignment.size(); ++j, ++h)   {
                tableModel.setValueAt(assignment.get(j), i, h);
            }
            //add assignment avg
            tableModel.setValueAt(GradeCalculator.calculateAssignmentAverage(students.get(i), dropLowestGrade.isSelected()), i, 12);

            //adding exams
            for (int j = 0, h = 13; j < exam.size(); ++j, ++h)   {
                tableModel.setValueAt(exam.get(j), i, h);
            }

            tableModel.setValueAt(attendance, i, 15);
            tableModel.setValueAt(project, i, 16);


            //Setting number and letter grade
            double finalGrade = GradeCalculator.calculateFinalGrade(students.get(i), dropLowestGrade.isSelected());
            String letterFinalGrade = GradeCalculator.getLetterGrade(finalGrade, (Schema)schemaSelection.getSelectedItem());

            tableModel.setValueAt(finalGrade, i, 17);
            tableModel.setValueAt(letterFinalGrade, i, 18);          
        }      
    }
    
    /**
     * Method used to recalculate student grades after the dropLowest checkbox or the schema selection has been changed
     */
    private void recalculateGrades()   {
        for (int i = 0; i < students.size(); ++i)   {
            double finalGrade = GradeCalculator.calculateFinalGrade(students.get(i), dropLowestGrade.isSelected());
            String letterFinalGrade = GradeCalculator.getLetterGrade(finalGrade, (Schema)schemaSelection.getSelectedItem());

            tableModel.setValueAt(finalGrade, i, 17);
            tableModel.setValueAt(letterFinalGrade, i, 18);  
        }
    }
}
