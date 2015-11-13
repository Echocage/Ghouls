/*
 * Created by JFormDesigner on Wed Nov 04 17:42:55 PST 2015
 */

package Ghouls;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Gui extends JFrame {
    public Gui() {
        initComponents();
    }

    private void button1MouseClicked(MouseEvent e) {
        if (!Ghouls.guiFinished){
            Ghouls.guiFinished = true;
            this.tabbedPane1.setSelectedIndex(1);
            this.button1.setText("Stop");
        }else{
            Ghouls.guiFinished = false;
            this.button1.setText("Start");
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - John Smith
        frame1 = new JFrame();
        tabbedPane1 = new JTabbedPane();
        panel3 = new JPanel();
        panel2 = new JPanel();
        comboBox2 = new JComboBox<>();
        panel1 = new JPanel();
        comboBoxFood = new JComboBox<>();
        spinnerEatPercent = new JSpinner();
        label1 = new JLabel();
        label2 = new JLabel();
        spinnerFoodCount = new JSpinner();
        label3 = new JLabel();
        panel5 = new JPanel();
        radioGold = new JRadioButton();
        radioGreen = new JRadioButton();
        radioCrimson = new JRadioButton();
        radioBlue = new JRadioButton();
        button1 = new JButton();
        panel4 = new JPanel();
        panel6 = new JPanel();
        label4 = new JLabel();
        labelXp = new JLabel();
        labelXpHour = new JLabel();
        label13 = new JLabel();
        labelUptime = new JLabel();
        labelCharmsHour = new JLabel();
        labelCharms = new JLabel();
        label6 = new JLabel();

        //======== frame1 ========
        {
            frame1.setResizable(false);
            Container frame1ContentPane = frame1.getContentPane();

            //======== tabbedPane1 ========
            {

                //======== panel3 ========
                {

                    // JFormDesigner evaluation mark
                    panel3.setBorder(new javax.swing.border.CompoundBorder(
                        new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), panel3.getBorder())); panel3.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


                    //======== panel2 ========
                    {
                        panel2.setBorder(new TitledBorder("Area"));

                        //---- comboBox2 ----
                        comboBox2.setModel(new DefaultComboBoxModel<>(new String[] {
                            "North-West",
                            "South-West"
                        }));

                        GroupLayout panel2Layout = new GroupLayout(panel2);
                        panel2.setLayout(panel2Layout);
                        panel2Layout.setHorizontalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                        panel2Layout.setVerticalGroup(
                            panel2Layout.createParallelGroup()
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(comboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap(13, Short.MAX_VALUE))
                        );
                    }

                    //======== panel1 ========
                    {
                        panel1.setBorder(new TitledBorder("Food"));

                        //---- comboBoxFood ----
                        comboBoxFood.setModel(new DefaultComboBoxModel<>(new String[] {
                            "Shrimps",
                            "Anchovies",
                            "Sardine",
                            "Salmon",
                            "Trout",
                            "Cod",
                            "Raw herring",
                            "Herring",
                            "Pike",
                            "Mackerel",
                            "Tuna",
                            "Bass",
                            "Swordfish",
                            "Lobster",
                            "Shark",
                            "Manta ray",
                            "Sea turtle",
                            "Pitta bread",
                            "Cooked chicken",
                            "Cooked meat",
                            "Bread dough",
                            "Bread",
                            "Cooked oomlie wrap",
                            "Cooked chompy",
                            "Cooked karambwan",
                            "Cooked rabbit",
                            "Cooked slimy eel",
                            "Cooked chicken",
                            "Cooked meat",
                            "Potato with butter",
                            "Potato with cheese",
                            "Tuna potato",
                            "Tuna and corn",
                            "Chopped tuna",
                            "Cooked chompy",
                            "Cooked crab meat",
                            "Cooked jubbly",
                            "Monkfish",
                            "Mint cake",
                            "Leaping trout",
                            "Leaping salmon",
                            "Crayfish",
                            "Cavefish",
                            "Rocktail"
                        }));

                        //---- spinnerEatPercent ----
                        spinnerEatPercent.setModel(new SpinnerNumberModel(30, 0, 99, 1));

                        //---- label1 ----
                        label1.setText("Eat %");

                        //---- label2 ----
                        label2.setText("Bank At");

                        //---- spinnerFoodCount ----
                        spinnerFoodCount.setModel(new SpinnerNumberModel(2, null, 27, 1));

                        //---- label3 ----
                        label3.setText("food left");

                        GroupLayout panel1Layout = new GroupLayout(panel1);
                        panel1.setLayout(panel1Layout);
                        panel1Layout.setHorizontalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel1Layout.createParallelGroup()
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label2)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spinnerFoodCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(label3))
                                        .addGroup(panel1Layout.createSequentialGroup()
                                            .addComponent(label1)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(spinnerEatPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(comboBoxFood, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
                        );
                        panel1Layout.setVerticalGroup(
                            panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                    .addComponent(comboBoxFood, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label1)
                                        .addComponent(spinnerEatPercent, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label2)
                                        .addComponent(spinnerFoodCount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(label3)))
                        );
                    }

                    //======== panel5 ========
                    {
                        panel5.setBorder(new TitledBorder("Looting"));

                        //---- radioGold ----
                        radioGold.setText("Gold Charms");

                        //---- radioGreen ----
                        radioGreen.setText("Green Charms");

                        //---- radioCrimson ----
                        radioCrimson.setText("Crimson Charms");

                        //---- radioBlue ----
                        radioBlue.setText("Blue Charms");

                        GroupLayout panel5Layout = new GroupLayout(panel5);
                        panel5.setLayout(panel5Layout);
                        panel5Layout.setHorizontalGroup(
                            panel5Layout.createParallelGroup()
                                .addGroup(panel5Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel5Layout.createParallelGroup()
                                        .addComponent(radioGold, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(radioGreen, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(radioCrimson, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                        .addComponent(radioBlue, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                                    .addContainerGap())
                        );
                        panel5Layout.setVerticalGroup(
                            panel5Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                                    .addComponent(radioGold)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioGreen)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioCrimson)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioBlue)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );
                    }

                    //---- button1 ----
                    button1.setText("Start");
                    button1.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            button1MouseClicked(e);
                        }
                    });

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(panel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                                        .addGap(0, 293, Short.MAX_VALUE)
                                        .addComponent(button1)))
                                .addContainerGap())
                    );
                    panel3Layout.setVerticalGroup(
                        panel3Layout.createParallelGroup()
                            .addGroup(panel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panel3Layout.createSequentialGroup()
                                        .addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button1))
                    );
                }
                tabbedPane1.addTab("Config", panel3);

                //======== panel4 ========
                {

                    //======== panel6 ========
                    {
                        panel6.setBorder(new TitledBorder("Stats"));

                        //---- label4 ----
                        label4.setText("Xp:");

                        //---- labelXp ----
                        labelXp.setText("0");

                        //---- labelXpHour ----
                        labelXpHour.setText("(0)");

                        //---- label13 ----
                        label13.setText("Time Running:");

                        //---- labelUptime ----
                        labelUptime.setText("0:0:0");

                        //---- labelCharmsHour ----
                        labelCharmsHour.setText("(0)");

                        //---- labelCharms ----
                        labelCharms.setText("0");

                        //---- label6 ----
                        label6.setText("Charms:");

                        GroupLayout panel6Layout = new GroupLayout(panel6);
                        panel6.setLayout(panel6Layout);
                        panel6Layout.setHorizontalGroup(
                            panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addComponent(label13)
                                            .addGap(6, 6, 6)
                                            .addComponent(labelUptime))
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addComponent(label4)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelXp)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(labelXpHour))
                                        .addGroup(panel6Layout.createSequentialGroup()
                                            .addComponent(label6)
                                            .addGap(6, 6, 6)
                                            .addComponent(labelCharms)
                                            .addGap(6, 6, 6)
                                            .addComponent(labelCharmsHour)))
                                    .addContainerGap(20, Short.MAX_VALUE))
                        );
                        panel6Layout.setVerticalGroup(
                            panel6Layout.createParallelGroup()
                                .addGroup(panel6Layout.createSequentialGroup()
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(label13)
                                        .addComponent(labelUptime))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel6Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(label4)
                                        .addComponent(labelXp)
                                        .addComponent(labelXpHour))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(panel6Layout.createParallelGroup()
                                        .addComponent(label6)
                                        .addComponent(labelCharms)
                                        .addComponent(labelCharmsHour)))
                        );
                    }

                    GroupLayout panel4Layout = new GroupLayout(panel4);
                    panel4.setLayout(panel4Layout);
                    panel4Layout.setHorizontalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(198, Short.MAX_VALUE))
                    );
                    panel4Layout.setVerticalGroup(
                        panel4Layout.createParallelGroup()
                            .addGroup(panel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(panel6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(139, Short.MAX_VALUE))
                    );
                }
                tabbedPane1.addTab("Stats", panel4);
            }

            GroupLayout frame1ContentPaneLayout = new GroupLayout(frame1ContentPane);
            frame1ContentPane.setLayout(frame1ContentPaneLayout);
            frame1ContentPaneLayout.setHorizontalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(tabbedPane1, GroupLayout.Alignment.TRAILING)
            );
            frame1ContentPaneLayout.setVerticalGroup(
                frame1ContentPaneLayout.createParallelGroup()
                    .addComponent(tabbedPane1, GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
            );
            frame1.pack();
            frame1.setLocationRelativeTo(frame1.getOwner());
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - John Smith
    public JFrame frame1;
    public JTabbedPane tabbedPane1;
    public JPanel panel3;
    public JPanel panel2;
    public JComboBox<String> comboBox2;
    public JPanel panel1;
    public JComboBox<String> comboBoxFood;
    public JSpinner spinnerEatPercent;
    public JLabel label1;
    public JLabel label2;
    public JSpinner spinnerFoodCount;
    public JLabel label3;
    public JPanel panel5;
    public JRadioButton radioGold;
    public JRadioButton radioGreen;
    public JRadioButton radioCrimson;
    public JRadioButton radioBlue;
    public JButton button1;
    public JPanel panel4;
    public JPanel panel6;
    public JLabel label4;
    public JLabel labelXp;
    public JLabel labelXpHour;
    public JLabel label13;
    public JLabel labelUptime;
    public JLabel labelCharmsHour;
    public JLabel labelCharms;
    public JLabel label6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
