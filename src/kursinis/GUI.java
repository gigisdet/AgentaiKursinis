/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kursinis;

import jade.gui.GuiEvent;

/**
 *
 * @author Andrius
 */
public class GUI extends javax.swing.JFrame {

    GuiAgenta myAgent;

    /**
     * Creates new form MyGui
     */
    public GUI(GuiAgenta a) {
        myAgent = a;
        initComponents();
    }

    public void addLine(String line) {
        if (this.jTextArea1.getLineCount() > 1000) {
            this.jTextArea1.setText(line);
        } else {
            this.jTextArea1.append(line);
        }
    }

    public void resetComboLines() {
        jComboBox1.removeAllItems();
    }

    public void addComboLine(String line) {
        jComboBox1.addItem(line);

    }

    public String getComboItem(int i) {
        return jComboBox1.getItemAt(i).toString();
    }

    public int getComboLinesCount() {
        int count = jComboBox1.getItemCount();
        return count;
    }

    public void removeComboLine(String line) {
        jComboBox1.removeItem(line);
    }

    public void resetCombo2Lines() {
        jComboBox2.removeAllItems();
    }

    public void addCombo2Line(String line) {
        jComboBox2.addItem(line);
    }

    public String getCombo2Item(int i) {
        return jComboBox2.getItemAt(i).toString();
    }

    public int getCombo3SelectedIndex() {
        return jComboBox3.getSelectedIndex();
    }

    public void removeCombo2Line(String line) {
        jComboBox2.removeItem(line);

    }

    public int getCombo2LinesCount() {
        int count = jComboBox2.getItemCount();
        return count;
    }

    public void resetCombo3Lines() {
        jComboBox3.removeAllItems();
    }

    public void addCombo3Line(String line) {
        jComboBox3.addItem(line);
    }

    public String getCombo3Item(int i) {
        return jComboBox3.getItemAt(i).toString();
    }

    public void removeCombo3Line(String line) {
        jComboBox3.removeItem(line);

    }

    public int getCombo3LinesCount() {
        int count = jComboBox3.getItemCount();
        return count;
    }

    public void resetCombo4Lines() {
        jComboBox4.removeAllItems();
    }

    public void addCombo4Line(String line) {
        jComboBox4.addItem(line);
    }

    public String getCombo4Item(int i) {
        return jComboBox4.getItemAt(i).toString();
    }

    public void removeCombo4Line(String line) {
        jComboBox3.removeItem(line);

    }

    public int getCombo4LinesCount() {
        int count = jComboBox4.getItemCount();
        return count;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1111 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        Miestas2 = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        Pozicija2 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        Stazas2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Atlyginimas2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Vardas = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Pavarde = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        gautiVisusDarbuotojus = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Ieskoti_darbuotojo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        Atlyginimas = new javax.swing.JTextField();
        Pozicija = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Miestas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Stazas = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        kandidatuotiDarbas = new javax.swing.JButton();
        darbuotojasField = new javax.swing.JTextField();
        darbdavysField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1111.setColumns(1000);
        jTextArea1111.setRows(5);
        jScrollPane1.setViewportView(jTextArea1111);

        Miestas2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alytus", "Marijampolė", "Druskininkai" }));

        jLabel10.setText("Darbo pozicija");

        Pozicija2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mobiliųjų įrenginių konfigūravimo ekspertas", "Inžinierius", "Salono Vadovas" }));

        jLabel11.setText("Stažas");

        Stazas2.setText("3");

        jLabel12.setText("Norimas atlyginimas");

        Atlyginimas2.setText("700");

        jButton3.setText("Siūsti duomenis");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel13.setText("Pasirinkite savo srautą");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pirmiausia paspauskite \"Gauti srautų sąrašą\"" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jButton4.setText("Gauti srautų sąrašą");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel5.setText("Registracija į cv banką");

        Vardas.setText("Andrius");

        jLabel7.setText("Vardas");

        jLabel8.setText("Pavardė");

        Pavarde.setText("Archangelskis");
        Pavarde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PavardeActionPerformed(evt);
            }
        });

        jLabel9.setText("Miestas");

        gautiVisusDarbuotojus.setText("Gauti registruotus darbuotojus");
        gautiVisusDarbuotojus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gautiVisusDarbuotojusActionPerformed(evt);
            }
        });

        jButton6.setText("Gauti darbuotoju informacija");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Vardas)
                    .addComponent(Pavarde)
                    .addComponent(Miestas2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pozicija2, 0, 0, Short.MAX_VALUE)
                    .addComponent(Stazas2)
                    .addComponent(Atlyginimas2)
                    .addComponent(jLabel13)
                    .addComponent(jButton3)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBox2, 0, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(gautiVisusDarbuotojus)
                        .addGap(65, 65, 65))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Vardas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addGap(9, 9, 9)
                                .addComponent(Pavarde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Miestas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel10)
                                .addGap(9, 9, 9)
                                .addComponent(Pozicija2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Stazas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(jLabel12))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(gautiVisusDarbuotojus)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(Atlyginimas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel13))
                    .addComponent(jButton6))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addGap(32, 32, 32)
                .addComponent(jButton3)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registracija", jPanel3);

        jButton1.setText("Ieskoti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Visu darbdaviu paieska");

        jButton5.setText("Gauti visus darbo pasiulymus");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pirmiausia paspauskite \"Gauti darbdavių sąrašą\"" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Gauti įmonių sąrašą iš pasirinkto darbdavio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setText("Darbo paieska pagal kriterijus");

        Ieskoti_darbuotojo.setText("Ieskoti pagal kriterijus");
        Ieskoti_darbuotojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ieskoti_darbuotojoActionPerformed(evt);
            }
        });

        jLabel14.setText("Norimas atlyginimas");

        Pozicija.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mobiliųjų įrenginių konfigūravimo ekspertas", "Inžinierius", "Salono Vadovas" }));

        jLabel1.setText("Pozicija");

        Miestas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alytus", "Marijampole", "Druskininkai" }));

        jLabel2.setText("Miestas");

        jLabel3.setText("Ieskomas darbas");

        jLabel4.setText("Stazas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(Pozicija, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Miestas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Ieskoti_darbuotojo)
                        .addComponent(jLabel14)
                        .addComponent(Atlyginimas)
                        .addComponent(Stazas, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pozicija, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Miestas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Stazas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(9, 9, 9)
                .addComponent(Atlyginimas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Ieskoti_darbuotojo)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(33, 33, 33)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Darbo paieska", jPanel1);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        kandidatuotiDarbas.setText("Kandidatuoti");
        kandidatuotiDarbas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kandidatuotiDarbasActionPerformed(evt);
            }
        });

        darbuotojasField.setText("jTextField1");

        darbdavysField.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(darbuotojasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(187, 187, 187)
                        .addComponent(kandidatuotiDarbas))
                    .addComponent(darbdavysField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kandidatuotiDarbas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(darbuotojasField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(darbdavysField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(527, 527, 527)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Ieskoti_darbuotojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ieskoti_darbuotojoActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.SEARCH);
        ge.addParameter(Pozicija.getSelectedItem());
        ge.addParameter(Miestas.getSelectedItem());
        ge.addParameter(Stazas.getText());
        //  ge.addParameter(jComboBox1.getSelectedItem());
        ge.addParameter(Atlyginimas.getText());
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_Ieskoti_darbuotojoActionPerformed


    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.SEARCHPROV);
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.SEARCHSarasas);
        ge.addParameter(jComboBox1.getSelectedItem());
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.IVESTI);
        ge.addParameter(Vardas.getText());
        ge.addParameter(Pavarde.getText());
        ge.addParameter(Miestas2.getSelectedItem());
        ge.addParameter(Pozicija2.getSelectedItem());
        ge.addParameter(Stazas2.getText());
        ge.addParameter(Atlyginimas2.getText());
        ge.addParameter(jComboBox2.getSelectedItem());
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.SEARCHPROV2);
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void PavardeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PavardeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PavardeActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // gauti visus darbo pasiulymus
        GuiEvent ge = new GuiEvent(this, GuiAgenta.SearchAllDarbdv);
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void gautiVisusDarbuotojusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gautiVisusDarbuotojusActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.GautiVisusDarbuotojus);
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_gautiVisusDarbuotojusActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.SearcAllDarbuotojai);
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void kandidatuotiDarbasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kandidatuotiDarbasActionPerformed
        GuiEvent ge = new GuiEvent(this, GuiAgenta.KandidatuotiDarbas);

        ge.addParameter(darbuotojasField.getText());
        ge.addParameter(darbdavysField.getText());
        myAgent.postGuiEvent(ge);
    }//GEN-LAST:event_kandidatuotiDarbasActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Atlyginimas;
    private javax.swing.JTextField Atlyginimas2;
    private javax.swing.JButton Ieskoti_darbuotojo;
    private javax.swing.JComboBox<String> Miestas;
    private javax.swing.JComboBox<String> Miestas2;
    private javax.swing.JTextField Pavarde;
    private javax.swing.JComboBox<String> Pozicija;
    private javax.swing.JComboBox<String> Pozicija2;
    private javax.swing.JTextField Stazas;
    private javax.swing.JTextField Stazas2;
    private javax.swing.JTextField Vardas;
    private javax.swing.JTextField darbdavysField;
    private javax.swing.JTextField darbuotojasField;
    private javax.swing.JButton gautiVisusDarbuotojus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea1111;
    private javax.swing.JButton kandidatuotiDarbas;
    // End of variables declaration//GEN-END:variables
}
