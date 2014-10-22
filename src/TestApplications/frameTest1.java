/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TestApplications;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author artemsamsonov
 */
class frameTest1 extends javax.swing.JFrame {
    static JSONObject obj;
    static Object test;
    static JSONArray questions;
    static int step = 0;
    static ArrayList answersList = new ArrayList();
    static int[] results = new int[12];
    JSONObject usr;
    
    /**
     * Creates new form frameTest1
     */
    private JSONArray toJSONArr(int[] arr) {
        JSONArray temp = new JSONArray();
        for (int i : arr) {
            temp.add(i);
        }
        return temp;
    }
    public void finishTest() throws IOException, Exception {
        for (int i = 0; i < 33; i++) {
            JSONObject temp = (JSONObject)questions.get(i);
            JSONObject temp2 = (JSONObject) temp.get("a");
            int [] temp3 = (int []) answersList.get(i);
            int j = toInt(temp2, "fact");
            results[j] += (int) temp3[0];
            temp2 = (JSONObject) temp.get("b");
            j = toInt(temp2, "fact");
            results[j] += (int) temp3[1];
            temp2 = (JSONObject) temp.get("c");
            j = toInt(temp2, "fact");
            results[j] += (int) temp3[2];
            temp2 = (JSONObject) temp.get("d");
            j = toInt(temp2, "fact");
            results[j] += (int) temp3[3];
        } 
        JSONArray res = (JSONArray) usr.get("testsResults");
        JSONArray temp = (JSONArray) usr.get("testsArray");
        Long i = (Long) obj.get("number");
        int j = i.intValue();
        res.set(j, toJSONArr(results));
        usr.put("testsResults", res);
        temp.set(j, 1);
        usr.put("testsArray", temp);
        FileReader file = new FileReader("users/users.json");
        JSONParser parser = new JSONParser();
        JSONArray x = (JSONArray) parser.parse(file);
        file.close();
        int l = ((Long)usr.get("ID")).intValue();
        x.set(l, usr);
        FileWriter fileW = new FileWriter("users/users.json");
        fileW.append(x.toString());
        fileW.flush();
        this.setVisible(false);
    }
    
    private int toInt(JSONObject o, String s) {
        return ((Long)o.get(s)).intValue() - 1;
    }
    
    public void updateLabels(){
        if (step == 0) {
            this.buttonPrev.setEnabled(false);
        } else {
            this.buttonPrev.setEnabled(true);
        }
        if (step == 32) {
            this.buttonNext.setText("Завершить тест");
            
        } else {
            this.buttonNext.setText("Next >");
        }
        JSONObject x = (JSONObject) questions.get(step);
        this.labelQuestion.setText((String) x.get("question"));
        JSONObject y = (JSONObject) x.get("a");
        this.labelAns1.setText((String) y.get("ans"));
        y = (JSONObject) x.get("b");
        this.labelAns2.setText((String) y.get("ans"));
        y = (JSONObject) x.get("c");
        this.labelAns3.setText((String) y.get("ans"));
        y = (JSONObject) x.get("d");
        this.labelAns4.setText((String) y.get("ans"));
        int [] temp = (int[]) answersList.get(step);
        this.text1.setText(Integer.toString(temp[0]));
        this.text2.setText(Integer.toString(temp[1]));
        this.text3.setText(Integer.toString(temp[2]));
        this.text4.setText(Integer.toString(temp[3]));
    }
    
    public frameTest1() {
    
    }
    
    public frameTest1(JSONObject test, JSONObject usr) throws IOException, Exception {
        initComponents();
        this.usr = usr;
        obj  = test;
        questions = (JSONArray) obj.get("questions");
        for(Object i : questions) {
            int [] temp = new int[4];
            answersList.add(temp);
        }
        this.updateLabels();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelQuestion = new javax.swing.JLabel();
        labelAns1 = new javax.swing.JLabel();
        text1 = new javax.swing.JTextField();
        labelAns2 = new javax.swing.JLabel();
        text2 = new javax.swing.JTextField();
        labelAns3 = new javax.swing.JLabel();
        text3 = new javax.swing.JTextField();
        labelAns4 = new javax.swing.JLabel();
        text4 = new javax.swing.JTextField();
        buttonNext = new javax.swing.JButton();
        buttonPrev = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelQuestion.setText("Вопрос");

        labelAns1.setText("Ответ 1: ");

        text1.setColumns(3);

        labelAns2.setText("Ответ 2: ");

        text2.setColumns(3);

        labelAns3.setText("Ответ 3: ");

        text3.setColumns(3);

        labelAns4.setText("Ответ 4: ");

        text4.setColumns(3);

        buttonNext.setText("Next >");
        buttonNext.setToolTipText("");
        buttonNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonNextMousePressed(evt);
            }
        });
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        buttonPrev.setText("< Prev");
        buttonPrev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                buttonPrevMousePressed(evt);
            }
        });
        buttonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrevActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelQuestion)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAns1)
                        .addGap(41, 41, 41)
                        .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAns4)
                        .addGap(41, 41, 41)
                        .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAns3)
                        .addGap(41, 41, 41)
                        .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelAns2)
                        .addGap(41, 41, 41)
                        .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(buttonPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNext)
                .addGap(0, 472, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelQuestion)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAns1)
                    .addComponent(text1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAns2)
                    .addComponent(text2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAns3)
                    .addComponent(text3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAns4)
                    .addComponent(text4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPrev)
                    .addComponent(buttonNext))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        int [] temp = new int[4];
        temp[0] = (Integer.parseInt(this.text1.getText()));
        temp[1] = (Integer.parseInt(this.text2.getText()));
        temp[2] = (Integer.parseInt(this.text3.getText()));
        temp[3] = (Integer.parseInt(this.text4.getText()));
        int sum = (int) temp[0] + (int) temp[1]
                + (int) temp[2] + (int) temp[3];
        if (sum == 11){
            answersList.set(step, temp);
            step++;
            if(step == 2) {
                try {
                    finishTest();
                } catch (Exception ex) {
                    Logger.getLogger(frameTest1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }        
            this.updateLabels();
        } else {
            JOptionPane.showMessageDialog(null, "Распределите баллы корректно БЛЕАТЬ!");
        }    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonNextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonNextMousePressed
      
    }//GEN-LAST:event_buttonNextMousePressed

    private void buttonPrevMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonPrevMousePressed


    }//GEN-LAST:event_buttonPrevMousePressed

    private void buttonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrevActionPerformed
        step--;
        updateLabels();
    }//GEN-LAST:event_buttonPrevActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // new frameTest1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPrev;
    private javax.swing.JLabel labelAns1;
    private javax.swing.JLabel labelAns2;
    private javax.swing.JLabel labelAns3;
    private javax.swing.JLabel labelAns4;
    private javax.swing.JLabel labelQuestion;
    private javax.swing.JTextField text1;
    private javax.swing.JTextField text2;
    private javax.swing.JTextField text3;
    private javax.swing.JTextField text4;
    // End of variables declaration//GEN-END:variables
}