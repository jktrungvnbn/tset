package View.Component.Customer_Component;

import BiA.javamodel.ModelHoaDon;
import BiA.javamodel.ModelSanPham;
import View.Dialog.MS_ConfirmOrderFood;
import View.Main.Main_Customer_Frame;
import View.Main.Main_Frame.Main_Customer_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CardSanPham extends javax.swing.JPanel {

    private  ModelSanPham data;
    private MS_ConfirmOrderFood obj;
    private ModelHoaDon HoaDon;
   
    public CardSanPham(ModelSanPham data,ModelHoaDon HoaDon) {
        this.HoaDon=HoaDon;
        this.data = data;
        initComponents();
        init();
        setOpaque(false);
    }

    public void init() {
        obj = new MS_ConfirmOrderFood(Main_Customer_Frame.getFrames()[0], true);
        setPreferredSize(new Dimension(300, 300));
        lbTitle.setText(data.getTenSP());
        DecimalFormat df = new DecimalFormat("##,###,###");
        lbValue.setText(df.format(data.getGia()) + "đ");
        cmdOrder.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                obj.ConfirmOrder(data, Integer.parseInt(txtNum.getText()),HoaDon.getIdHoaDon());
                txtNum.setText("0");
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitle = new javax.swing.JLabel();
        lbValue = new javax.swing.JLabel();
        img = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(108, 91, 123));
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("Title");

        lbValue.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbValue.setForeground(new java.awt.Color(108, 91, 123));
        lbValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValue.setText("Value");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbValue, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdMinusActionPerformed
        int num = Integer.parseInt(txtNum.getText());
        if (num > 0) {
            txtNum.setText((num - 1) + "");
        } else {
            txtNum.setText("0");
        }
    }//GEN-LAST:event_cmdMinusActionPerformed

    private void cmdAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAddActionPerformed
        int num = Integer.parseInt(txtNum.getText());
        txtNum.setText((num + 1) + "");
    }//GEN-LAST:event_cmdAddActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20,20);
        
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel img;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    // End of variables declaration//GEN-END:variables
}
