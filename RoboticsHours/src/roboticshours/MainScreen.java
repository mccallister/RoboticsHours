package roboticshours;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Alan
 */
public class MainScreen extends javax.swing.JFrame {
    static JFrame mainScreen;
    private Account account;
    DefaultTableModel dataModel;
    /**
     * Creates new form NewJFrame
     * @param a
     */
    @SuppressWarnings("empty-statement")
    public MainScreen(Account a) {
        initComponents();
        account = a;
        userName.setText(a.getAccountName());
        ArrayList<Entry> entries = a.getEntries();
        Object[][] data = new Object[entries.size()][4];
        for(int i = 0; i < entries.size(); i++){
            Entry e = entries.get(i);
            Calendar d = e.getDate();
            Calendar dm = e.getDateModified();
            data[i][0] = false;
            data[i][1] = (d.get(Calendar.MONTH) + 1 + "/" + d.get(Calendar.DAY_OF_MONTH) + "/" + (d.get(Calendar.YEAR)));
            data[i][2] = e.getHours();
            data[i][3] = (dm.get(Calendar.MONTH) + 1 + "/" + dm.get(Calendar.DAY_OF_MONTH) + "/" + (dm.get(Calendar.YEAR)));
        }
        dataModel = new DefaultTableModel(data, new String [] {"", "Date", "Hours", "Date Modified"})
        {
            Class[] types = new Class [] {java.lang.Boolean.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class};
            boolean[] canEdit = new boolean [] {true, true, true, false};

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        entryTable.setModel(dataModel);
        TableColumn column;
        for (int i = 0; i < 4; i++) {
            column = entryTable.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(5); //third column is bigger
            }
            else if(i == 2){
                column.setPreferredWidth(10);
            }
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        startPanel = new javax.swing.JPanel();
        newButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        greetingLabel = new javax.swing.JLabel();
        viewEditPanel = new javax.swing.JPanel();
        entryTableHeader = new javax.swing.JScrollPane();
        entryTable = new javax.swing.JTable();
        tableBackButton = new javax.swing.JButton();
        newEntryPanel = new javax.swing.JPanel();
        manualDateEntry = new javax.swing.JTextField();
        userName = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        currentDate = new javax.swing.JRadioButton();
        hourSelector = new javax.swing.JSpinner();
        hourLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        submitButton = new javax.swing.JButton();
        newBackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.CardLayout());

        newButton.setText("Enter Hours");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View/Edit Hours");
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        greetingLabel.setText("Hello. What would you like to do?");

        javax.swing.GroupLayout startPanelLayout = new javax.swing.GroupLayout(startPanel);
        startPanel.setLayout(startPanelLayout);
        startPanelLayout.setHorizontalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(greetingLabel)
                .addGap(88, 88, 88))
        );
        startPanelLayout.setVerticalGroup(
            startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startPanelLayout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(greetingLabel)
                .addGap(55, 55, 55)
                .addGroup(startPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newButton)
                    .addComponent(viewButton))
                .addContainerGap())
        );

        mainPanel.add(startPanel, "startPanel");

        entryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Date", "Hours", "Date Modified"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        entryTable.getTableHeader().setReorderingAllowed(false);
        entryTableHeader.setViewportView(entryTable);
        if (entryTable.getColumnModel().getColumnCount() > 0) {
            entryTable.getColumnModel().getColumn(0).setHeaderValue("Date");
            entryTable.getColumnModel().getColumn(1).setHeaderValue("Hours");
            entryTable.getColumnModel().getColumn(2).setHeaderValue("Date Modified");
        }

        tableBackButton.setText("Back");
        tableBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewEditPanelLayout = new javax.swing.GroupLayout(viewEditPanel);
        viewEditPanel.setLayout(viewEditPanelLayout);
        viewEditPanelLayout.setHorizontalGroup(
            viewEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(entryTableHeader, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
            .addGroup(viewEditPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableBackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        viewEditPanelLayout.setVerticalGroup(
            viewEditPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewEditPanelLayout.createSequentialGroup()
                .addComponent(entryTableHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(tableBackButton)
                .addContainerGap())
        );

        mainPanel.add(viewEditPanel, "viewEditPanel");

        manualDateEntry.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        userName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userName.setText(getName());

        nameLabel.setText("Name:");

        currentDate.setText("Use today's date");
        currentDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentDateActionPerformed(evt);
            }
        });

        hourSelector.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));

        hourLabel.setText("Number of hours:");

        dateLabel.setText("Date (MM/DD/YYYY):");

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        newBackButton.setText("Back");
        newBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newEntryPanelLayout = new javax.swing.GroupLayout(newEntryPanel);
        newEntryPanel.setLayout(newEntryPanelLayout);
        newEntryPanelLayout.setHorizontalGroup(
            newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newEntryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEntryPanelLayout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEntryPanelLayout.createSequentialGroup()
                        .addComponent(newBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submitButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEntryPanelLayout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentDate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                        .addComponent(manualDateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(newEntryPanelLayout.createSequentialGroup()
                        .addComponent(hourLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hourSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        newEntryPanelLayout.setVerticalGroup(
            newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newEntryPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hourSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hourLabel))
                .addGap(18, 18, 18)
                .addGroup(newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel)
                    .addComponent(currentDate)
                    .addComponent(manualDateEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(newEntryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBackButton)
                    .addComponent(submitButton))
                .addContainerGap())
        );

        mainPanel.add(newEntryPanel, "newEntryPanel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        getAccessibleContext().setAccessibleName("mainFrame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "newEntryPanel");
    }//GEN-LAST:event_newButtonActionPerformed

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "viewEditPanel");
    }//GEN-LAST:event_viewButtonActionPerformed

    private void newBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBackButtonActionPerformed
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "startPanel");
        hourSelector.setValue(0);
        currentDate.setSelected(false);
        manualDateEntry.setText("");
        manualDateEntry.setEditable(true);
    }//GEN-LAST:event_newBackButtonActionPerformed

    private void tableBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableBackButtonActionPerformed
        ((CardLayout)(mainPanel.getLayout())).show(mainPanel, "startPanel");
    }//GEN-LAST:event_tableBackButtonActionPerformed

    private void currentDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentDateActionPerformed
        if(currentDate.isSelected()){
            Calendar today = Calendar.getInstance();
            if(today.get(Calendar.MONTH) < 9)
                manualDateEntry.setText("0" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.DATE) + "/" + today.get(Calendar.YEAR));
            else
                manualDateEntry.setText(today.get(Calendar.MONTH) + 1 + "/" + today.get(Calendar.DATE) + "/" + today.get(Calendar.YEAR));
            manualDateEntry.setEditable(false);
        }
        else{
            manualDateEntry.setText("");
            manualDateEntry.setEditable(true);
        }
    }//GEN-LAST:event_currentDateActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        Calendar date = new GregorianCalendar();
        String[] datePieces = manualDateEntry.getText().split("/");
        date.set(Integer.parseInt(datePieces[2]), Integer.parseInt(datePieces[0]) - 1, Integer.parseInt(datePieces[1]));//TODO Add error checking
        account.addEntry(new Entry(account, (int)hourSelector.getValue(), date));
        Object[] data = new Object[4];
            data[0] = false;
            data[1] = (date.get(Calendar.MONTH) + 1 + "/" + date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.YEAR)));
            data[2] = (int)hourSelector.getValue();
            data[3] = data[1];
        dataModel.addRow(data);
        //dataModel.fireTableDataChanged();
        System.out.println("New entry added."); //TODO Auto update table
        System.out.println("Last entry in the list:");
        System.out.println(account.getEntries().get(account.getEntries().size() - 1));
        System.out.println("Now exporting the file:");
        ImportExport.exportAll();
        JOptionPane.showMessageDialog(rootPane, "Submitted successfully!", "Success!", JOptionPane.INFORMATION_MESSAGE);
        newBackButtonActionPerformed(evt);
    }//GEN-LAST:event_submitButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton currentDate;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTable entryTable;
    private javax.swing.JScrollPane entryTableHeader;
    private javax.swing.JLabel greetingLabel;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JSpinner hourSelector;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField manualDateEntry;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton newBackButton;
    private javax.swing.JButton newButton;
    private javax.swing.JPanel newEntryPanel;
    private javax.swing.JPanel startPanel;
    private javax.swing.JButton submitButton;
    private javax.swing.JButton tableBackButton;
    private javax.swing.JLabel userName;
    private javax.swing.JButton viewButton;
    private javax.swing.JPanel viewEditPanel;
    // End of variables declaration//GEN-END:variables
}
