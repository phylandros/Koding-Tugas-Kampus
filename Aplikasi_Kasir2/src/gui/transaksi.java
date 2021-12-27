
package gui;

import controller.koneksi;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.JOptionPane;

public final class transaksi extends javax.swing.JFrame {   
    String tanggal;
    private DefaultTableModel model;
    
    public void totalbayar(){
        int jumlahbaris = tabel_transaksi.getRowCount();
        int pajak = 0, totalbayar = 0, bayar = 0;
        
        int jum_brg, harga_brg;
        for (int i = 0; i< jumlahbaris;i++){
            jum_brg = Integer.parseInt(tabel_transaksi.getValueAt(i, 5).toString());
            harga_brg = Integer.parseInt(tabel_transaksi.getValueAt(i, 6).toString());
            totalbayar = totalbayar + (jum_brg * harga_brg);
            pajak = totalbayar * 10 / 100;
            bayar = totalbayar + pajak;
        }
        txt_totalhargasemua.setText(String.valueOf(totalbayar));
        txt_pajak.setText(String.valueOf(pajak));
        txt_totalbayar.setText(String.valueOf(bayar));
    }
    
    private void autonumber(){
        try{
            Connection con = koneksi.getkoneksi();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM data_transaksi ORDER BY no_faktur Desc";
            ResultSet rs = st.executeQuery(sql);
            
            if (rs.next()){
                String NoFaktur = rs.getString("no_faktur").substring(2);
                String IdCust = rs.getString("id_cust").substring(2);
                String IdBrg = rs.getString("id_brgt").substring(2);
                String TR = "" + (Integer.parseInt(NoFaktur)+1);
                String IC = "" + (Integer.parseInt(IdCust)+1);
                String IB = "" + (Integer.parseInt(IdBrg)+1);
                String Nol = "";
                
                if(TR.length() == 1)
                {Nol = "000";}
                if(TR.length() == 2)
                {Nol = "00";}
                if(TR.length() == 3)
                {Nol = "0";}
                if(TR.length() == 4)
                {Nol = "";}
                txt_noTransaksi.setText("TR" + Nol + TR);
                
                if(IC.length() == 1)
                {Nol = "000";}
                if(IC.length() == 2)
                {Nol = "00";}
                if(IC.length() == 3)
                {Nol = "0";}
                if(IC.length() == 4)
                {Nol = "";}
                txt_idCust.setText("IC" + Nol + IC);
                
                if(IB.length() == 1)
                {Nol = "000";}
                if(IB.length() == 2)
                {Nol = "00";}
                if(IB.length() == 3)
                {Nol = "0";}
                if(IB.length() == 4)
                {Nol = "";}
                txt_idbarang.setText("IB" + Nol + IB);
            } else {
                txt_noTransaksi.setText("TR0001");
                txt_idCust.setText("IC0001");
                txt_idbarang.setText("IB0001");
            }
            rs.close();
            st.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Autoset Error, Database tidak terhubung");
        }
    }
    
    public void loadData(){
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        model.addRow(new Object[]{
            txt_noTransaksi.getText(),
            txt_tanggal.getText(),
            txt_idCust.getText(),
            txt_idbarang.getText(),
            txt_namabrg.getText(),
            txt_jumlah.getText(),
            txt_totalhargasemua.getText()
        });
    }
    
    public void kosong(){
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        
        while (model.getRowCount()>0){
            model.removeRow(0);
        }
    }
    
    public void utama(){
        txt_noTransaksi.setText("");
        txt_idbarang.setText("");
        txt_namabrg.setText("");
        txt_harga.setText("");
        txt_jumlah.setText("");
        autonumber();
    }
    
    public void clear(){
        txt_idCust.setText("");
//        txt_namacust.setText("");
        txt_totalhargasemua.setText("0");
        txt_jumlbayar.setText("0");
        txt_kembalian.setText("0");
        txt_pajak.setText("0");
        txt_totalbayar.setText("0");
    }
    
    public void clear2(){
        txt_namabrg.setText("");
        txt_harga.setText("");
        txt_jumlah.setText("");
    }
    
    public void tambahTransaksi(){
        int jumlah, harga, total, pajak, totalsemua;
        
        jumlah = Integer.valueOf(txt_jumlah.getText());
        harga = Integer.valueOf(txt_harga.getText());
        total = jumlah * harga;

        
        txt_totalhargasemua.setText(String.valueOf(total));

        loadData();
        totalbayar();
        clear2();
        txt_idbarang.requestFocus();
    }
    
    public transaksi() {
        initComponents();
        
        // posisi Aplikasi
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2 - this.getSize().height/2);

        // function add kolom pada tabel
        model = new DefaultTableModel();
        tabel_transaksi.setModel(model);
        model.addColumn("No. Faktur");
        model.addColumn("Tanggal");
        model.addColumn("ID Customer");
        model.addColumn("ID Barang");
        model.addColumn("Nama Barang");
        model.addColumn("Jumlah");
        model.addColumn("Harga Barang");
        
        utama();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        txt_tanggal.setText(sdf.format(date));
        txt_totalhargasemua.setText("0");
        txt_jumlbayar.setText("0");
        txt_kembalian.setText("0");
        txt_idCust.requestFocus();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        label12 = new java.awt.Label();
        txt_noTransaksi = new javax.swing.JTextField();
        label_idCust = new java.awt.Label();
        txt_idCust = new javax.swing.JTextField();
        label14 = new java.awt.Label();
        txt_tanggal = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        scr_totalharga = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        label6 = new java.awt.Label();
        txt_totalhargasemua = new javax.swing.JTextField();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        txt_pajak = new javax.swing.JTextField();
        txt_totalbayar = new javax.swing.JTextField();
        label9 = new java.awt.Label();
        txt_jumlbayar = new javax.swing.JTextField();
        label10 = new java.awt.Label();
        txt_kembalian = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        label13 = new java.awt.Label();
        txt_idbarang = new javax.swing.JTextField();
        label2 = new java.awt.Label();
        txt_harga = new javax.swing.JTextField();
        label3 = new java.awt.Label();
        txt_namabrg = new javax.swing.JTextField();
        label5 = new java.awt.Label();
        txt_jumlah = new javax.swing.JTextField();
        btn_tambahkanbrg = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_bayar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(0, 0));

        label1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        label1.setText("Kasir Rumah Kucing");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setToolTipText("");
        jPanel1.setName(""); // NOI18N

        label12.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label12.setText("No Transaksi :");

        txt_noTransaksi.setEnabled(false);

        label_idCust.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label_idCust.setText("ID Customer :");

        txt_idCust.setEnabled(false);
        txt_idCust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idCustActionPerformed(evt);
            }
        });

        label14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label14.setText("Tanggal :");

        txt_tanggal.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_idCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_idCust, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txt_noTransaksi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tanggal))
                .addContainerGap(135, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_noTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_idCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idCust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {label12, label14, label_idCust, txt_idCust, txt_noTransaksi, txt_tanggal});

        scr_totalharga.setEditable(false);
        scr_totalharga.setBackground(new java.awt.Color(0, 51, 204));
        scr_totalharga.setFont(new java.awt.Font("Calibri", 1, 48)); // NOI18N
        scr_totalharga.setForeground(new java.awt.Color(255, 255, 255));
        scr_totalharga.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        scr_totalharga.setText("Rp 0");
        scr_totalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scr_totalhargaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(scr_totalharga, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(scr_totalharga)
                .addGap(6, 6, 6))
        );

        tabel_transaksi.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel_transaksi);

        label6.setAlignment(java.awt.Label.RIGHT);
        label6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label6.setMinimumSize(new java.awt.Dimension(72, 22));
        label6.setText("Total :");

        txt_totalhargasemua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalhargasemuaActionPerformed(evt);
            }
        });

        label7.setAlignment(java.awt.Label.RIGHT);
        label7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label7.setMinimumSize(new java.awt.Dimension(72, 22));
        label7.setText("Pajak :");

        label8.setAlignment(java.awt.Label.RIGHT);
        label8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label8.setMinimumSize(new java.awt.Dimension(72, 22));
        label8.setText("Total Bayar :");

        label9.setAlignment(java.awt.Label.RIGHT);
        label9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label9.setMinimumSize(new java.awt.Dimension(72, 22));
        label9.setText("Jum Bayar :");

        txt_jumlbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlbayarActionPerformed(evt);
            }
        });

        label10.setAlignment(java.awt.Label.RIGHT);
        label10.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label10.setMinimumSize(new java.awt.Dimension(72, 22));
        label10.setText("Kembalian :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_totalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(txt_totalhargasemua, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(302, 302, 302)
                            .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_jumlbayar))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(txt_pajak, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(302, 302, 302)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_kembalian, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_totalhargasemua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_jumlbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_totalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        label13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label13.setText("ID Barang :");

        txt_idbarang.setEnabled(false);

        label2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label2.setText("Nama Barang :");

        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label3.setText("Harga :");

        label5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        label5.setText("Jumlah :");

        txt_jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlahActionPerformed(evt);
            }
        });

        btn_tambahkanbrg.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btn_tambahkanbrg.setText("Tambahkan");
        btn_tambahkanbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahkanbrgActionPerformed(evt);
            }
        });

        btn_hapus.setText("Hapus");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_bayar.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        btn_bayar.setText("Simpan");
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_idbarang, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_tambahkanbrg, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(btn_hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_idbarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_tambahkanbrg)
                    .addComponent(txt_harga))
                .addGap(9, 9, 9)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_namabrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_jumlah)
                            .addComponent(btn_bayar))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_hapus)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(23, 23, 23))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahkanbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahkanbrgActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_btn_tambahkanbrgActionPerformed

    private void txt_jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlahActionPerformed
        tambahTransaksi();
    }//GEN-LAST:event_txt_jumlahActionPerformed

    private void txt_jumlbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlbayarActionPerformed
        int total, bayar, kembalian;
        
        total = Integer.valueOf(txt_totalbayar.getText());
        bayar = Integer.valueOf(txt_jumlbayar.getText());
        
        if (total > bayar){
            JOptionPane.showMessageDialog(null, "Uang Anda Kurang tidak dapat melakukan pembayaran");
        } else {
            kembalian = bayar - total;
            txt_kembalian.setText(String.valueOf(kembalian));
        }
    }//GEN-LAST:event_txt_jumlbayarActionPerformed

    private void txt_idCustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idCustActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idCustActionPerformed

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();

        String no_faktur = txt_noTransaksi.getText();
        String tanggal = txt_tanggal.getText();
        String idCust = txt_idCust.getText();
        String total = txt_totalbayar.getText();
        String id_barang = txt_idbarang.getText();
        
        
        
        try {
            Connection con = koneksi.getkoneksi();
            String sql = "INSERT INTO data_pengeluaran VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, no_faktur);
            ps.setString(2, tanggal);
            ps.setString(3, idCust);
            ps.setString(4, total);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Input Pengeluaran Error");
        }
        
        try {
            Connection con = koneksi.getkoneksi();
            int baris = tabel_transaksi.getRowCount();
            
            for(int i = 0; i < baris ; i++){
                String sql = "INSERT INTO data_transaksi(no_faktur, tanggal, id_barang, nama_brg, jumlah, harga_brg VALUES('" 
                        + tabel_transaksi.getValueAt(i, 0) + "','" 
                        + tabel_transaksi.getValueAt(i, 1) + "','" 
                        + tabel_transaksi.getValueAt(i, 3) + "','" 
                        + tabel_transaksi.getValueAt(i, 4) + "','" 
                        + tabel_transaksi.getValueAt(i, 5) + "','" 
                        + tabel_transaksi.getValueAt(i, 6) + "')"; 
                PreparedStatement ps = con.prepareStatement(sql);
                ps.executeUpdate();
                ps.close();
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Input Rinci Error");
        }
        clear();
        utama();
        autonumber();
        kosong();
        scr_totalharga.setText("Rp " + total);
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void txt_totalhargasemuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalhargasemuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalhargasemuaActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabel_transaksi.getModel();
        int row = tabel_transaksi.getSelectedRow();
        model.removeRow(row);
        totalbayar();
        txt_totalhargasemua.setText("");
        txt_kembalian.setText("");
        
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void scr_totalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scr_totalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_scr_totalhargaActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi().setVisible(true);
            }
        });
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_bayar;
    public javax.swing.JButton btn_hapus;
    public javax.swing.JButton btn_tambahkanbrg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label10;
    private java.awt.Label label12;
    private java.awt.Label label13;
    private java.awt.Label label14;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    private java.awt.Label label_idCust;
    public javax.swing.JTextField scr_totalharga;
    public javax.swing.JTable tabel_transaksi;
    public javax.swing.JTextField txt_harga;
    public javax.swing.JTextField txt_idCust;
    public javax.swing.JTextField txt_idbarang;
    public javax.swing.JTextField txt_jumlah;
    public javax.swing.JTextField txt_jumlbayar;
    public javax.swing.JTextField txt_kembalian;
    public javax.swing.JTextField txt_namabrg;
    public javax.swing.JTextField txt_noTransaksi;
    public javax.swing.JTextField txt_pajak;
    public javax.swing.JTextField txt_tanggal;
    public javax.swing.JTextField txt_totalbayar;
    private javax.swing.JTextField txt_totalhargasemua;
    // End of variables declaration//GEN-END:variables


}
