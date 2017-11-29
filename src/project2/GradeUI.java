/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2;

/**
 *
 * @author EliF
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.Box;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    JButton exportGradesButton;

    final String[] searchSelectionTerms = {"Name", "Grade"};

    public GradeUI()	{
        setUpUI();
        frame.setLocation(300, 25);
        frame.setVisible(true);

    }

    private void setUpUI()  {
        frame = new JFrame("Grade Reporter");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1200, 308);

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

        c.gridx = 7;
        optionPanel.add(Box.createHorizontalStrut(30));


        dropLowestGrade = new JCheckBox("Drop Lowest Grade");
        c.gridx = 8;
        optionPanel.add(dropLowestGrade, c);

        frame.getContentPane().add(optionPanel, BorderLayout.NORTH);

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
                        int selected = searchSelection.getSelectedIndex();
                        if (selected == 0)  {
                            sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text, 0));
                        }
                        else    {
                            /*List<RowFilter<Object,Object>> rfs = 
                                new ArrayList<RowFilter<Object,Object>>(2);
                            rfs.add(RowFilter.regexFilter(text, 17));
                            rfs.add(RowFilter.regexFilter(text, 18));
                            RowFilter<Object,Object> af = RowFilter.andFilter(rfs);*/

                            //TODO, doesn't work for number grade.
                            sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text, 17));
                            sorter.setRowFilter(RowFilter.regexFilter("(?i)^" + text, 18));
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

        mainPanel.add(scrollPane);		

        exportGradesButton = new JButton();
        exportGradesButton.setText("<html><div style='text-align: center;'>Print Grades</html>");

        buttonPanel = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 0;
        buttonPanel.add(Box.createHorizontalStrut(1070));

        c.gridx = 1;
        exportGradesButton.setPreferredSize(new Dimension(100,50));
        buttonPanel.add(exportGradesButton, c);

        JPanel parentPanel = new JPanel();
        parentPanel.add(buttonPanel, BorderLayout.EAST);

        frame.getContentPane().add(parentPanel, BorderLayout.SOUTH);	

        /*table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2 && row != -1) {
                        //addNewContact();
                }
            }
        });*/
    }

    public static void main(String[] args)	{
            GradeUI p = new GradeUI();
    }

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
            tableModel.setValueAt(GradeCalculator.calculateQuizAverage(students.get(i)), i, 6);

            //adding assignments
            for (int j = 0, h = 7; j < assignment.size(); ++j, ++h)   {
                tableModel.setValueAt(assignment.get(j), i, h);
            }
            //add assignment avg
            tableModel.setValueAt(GradeCalculator.calculateAssignmentAverage(students.get(i)), i, 12);

            //adding exams
            for (int j = 0, h = 13; j < exam.size(); ++j, ++h)   {
                tableModel.setValueAt(exam.get(j), i, h);
            }

            tableModel.setValueAt(attendance, i, 15);
            tableModel.setValueAt(project, i, 16);


            //Setting number and letter grade
            double finalGrade = GradeCalculator.calculateFinalGrade(students.get(i));
            String letterFinalGrade = GradeCalculator.getLetterGrade(finalGrade, (Schema)schemaSelection.getSelectedItem());

            tableModel.setValueAt(finalGrade, i, 17);
            tableModel.setValueAt(letterFinalGrade, i, 18);          
        }      
    }
}
