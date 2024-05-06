package View.Component.Customer_Component;

import RTDRestaurant.Model.ModelKhachHang;
import RTDRestaurant.Model.ModelHoaDon;
import RTDRestaurant.Model.ModelVoucher;
import RTDRestaurant.View.Dialog.MS_ConfirmExchangeVoucher;
import RTDRestaurant.View.Dialog.MS_Warning;
import RTDRestaurant.View.Main_Frame.Main_Customer_Frame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class CardVoucher extends javax.swing.JPanel {

    private final ModelVoucher data;
    private final ModelKhachHang customer;
    private final ModelHoaDon hoadon;
    private MS_Warning warning;
    private MS_ConfirmExchangeVoucher exchange;
    public ModelVoucher getData() {
        return data;
    }

    public CardVoucher(ModelVoucher data,ModelKhachHang customer,ModelHoaDon hoadon) {
        this.data = data;
        this.customer=customer;
        this.hoadon=hoadon;
        warning  = new MS_Warning(Main_Customer_Frame.getFrames()[0], true);
        exchange  = new MS_ConfirmExchangeVoucher(Main_Customer_Frame.getFrames()[0], true);
        initComponents();
        init();
        cmdExchange.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int Vpoint=data.getPoint();
                if(hoadon==null){
                    
                }
                else{
                    if(customer.getPoints()<Vpoint){
                    warning.WarningExchange(Vpoint-customer.getPoints());
                    }else{
                        exchange.ConfirmExchange(hoadon, data);
                    }
                }
            }
        });
        setOpaque(false);
    }
    
    public void init(){
        
        setPreferredSize(new Dimension(300, 325));
        ibDescription.setText(data.getDescription());
        lbQuantity.setText("Số lượng: " + data.getQuantity());
        lbPoint.setText(data.getPoint() + " xu");
        switch (data.getPercent()) {
            case 20 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/20off.jpg")));
            }
            case 30 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/30off.jpg")));
            }
            case 50 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/50off.jpg")));
            }
            case 60 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/60off.jpg")));
            }
            case 100 -> {
                img.setIcon(new ImageIcon(getClass().getResource("/Icons/Voucher/100off.jpg")));
            }
            default -> {
            }
        }
        if (data.getQuantity() == 0) {
            cmdExchange.setText("ĐÃ HẾT");
            cmdExchange.setBackground(Color.decode("#232526"));
            cmdExchange.setEnabled(false);
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
            .addGap(0, 332, Short.MAX_VALUE)
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
