package View.Component.Customer_Component;

import BiA.javamodel.ModelKhachHang;
import BiA.javamodel.ModelBan;
import View.Dialog.MS_Confirm;
import View.Main.Main_Customer_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardBan extends javax.swing.JPanel {
    private  View.Swing.Button cmdBook;
     private javax.swing.JLabel img;
     private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbValue;
    private View.Swing.PanelRound panelRound1;
    private final ModelBan data;
    private final ModelKhachHang customer;
    private MS_Confirm obj;
    private String TThai;
    public CardBan(ModelBan data,ModelKhachHang customer) {
        this.data = data;
        this.customer=customer;
        initComponents();
        init();
        setOpaque(false);
    }
    
    public void init(){
        MS_Confirm obj = new MS_Confirm(Main_Customer_Frame.getFrames()[0], true);
        setPreferredSize(new Dimension(300, 325));
        lbTitle.setText("Mã bàn: "+data.getSoBan()+" - "+data.getViTri());
        if (data.getTrangThai()){
            TThai = "Dang dung";
        }
        else {
           TThai = "con trong";
        }
        
        lbValue.setText(TThai);
        switch (TThai) {
            case "con trong" -> {
                img.setBackground(Color.decode("#E9E4F0"));
                //Nếu bàn trống thì thêm event xử lý đặt bàn
                cmdBook.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                       obj.Cus_ConfirmBook(data,customer);
                    }
                });
            }
            case "Dang dung" -> {
                img.setBackground(Color.decode("#605C3C"));
                cmdBook.setText("KHÔNG THỂ ĐẶT");
                cmdBook.setBackground(Color.decode("#232526"));
                cmdBook.setEnabled(false);
            }
            
            default -> {
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
