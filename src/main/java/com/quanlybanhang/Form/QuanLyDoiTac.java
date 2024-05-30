/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanlybanhang.Form;

import com.quanlybanhang.DAO.HoaDonChiTietDAO;
import com.quanlybanhang.DAO.KhachHangDAO;
import com.quanlybanhang.DAO.LoaiSPDAO;
import com.quanlybanhang.DAO.NhieuNhapCTDAO;
import com.quanlybanhang.DAO.PhieuNhapDAO;
import com.quanlybanhang.DAO.SanPhamDAO;
import com.quanlybanhang.Model.HoaDonChiTiet;
import com.quanlybanhang.Model.KhachHang;
import com.quanlybanhang.Model.LoaiSanPham;
import com.quanlybanhang.Model.NhanVien;
import com.quanlybanhang.Model.PhieuNhap;
import com.quanlybanhang.Model.PhieuNhapChiTiet;
import com.quanlybanhang.Model.SanPham;
import com.quanlybanhang.helper.DateHelper;
import com.quanlybanhang.helper.DialogHelper;
import com.quanlybanhang.helper.ShareHelper;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLyDoiTac extends javax.swing.JInternalFrame {

    LoaiSPDAO lDAO = new LoaiSPDAO();
    SanPhamDAO spDAO = new SanPhamDAO();
    KhachHangDAO khDAO = new KhachHangDAO();
    /**
     * Creates new form DonHangJframe
     */
    public QuanLyDoiTac() {
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI) this.getUI();
        bi.setNorthPane(null);
        loadKhachHang();
        setStatusKhachHang(true);

      

    }

    void loadKhachHang() {
        String header[]= {"Mã KH","Tên KH","SDT","Địa Chỉ"};
        DefaultTableModel model = new DefaultTableModel(header, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;             
            };      
        };
        tblKhachHang.setModel(model);

        model.setRowCount(0);
        try {
            List<KhachHang> list = khDAO.select();
            int i = 0;
            for (KhachHang kh : list) {
                i++;
                model.addRow(new Object[]{
                    kh.getMaKH(),kh.getTenKH(),kh.getSdt(),kh.getDiaChi()
                });
            }
            model.fireTableDataChanged();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();

        }
    }

    void insert_KhachHang() {
        try {
            KhachHang lsp = getKhachHang();
            khDAO.insert_KhachHang(lsp);
            this.loadKhachHang();
            DialogHelper.alert(this, "Thêm Thành Công");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            DialogHelper.alert(this, "Thêm Thất Bại");
        }
    }
    
    void update_KhachHang() {
        try {
            KhachHang lsp = getKhachHang();
            khDAO.update_KhachHang(lsp);
            this.loadKhachHang();
            DialogHelper.alert(this, "Thêm Thành Công");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            DialogHelper.alert(this, "Thêm Thất Bại");
        }
    }
    
    void delete_KhachHang(){
        String id = txtMaKH.getText();
        try {
            khDAO.delete_KhachHang(id);
            DialogHelper.alert(this, "Xóa Thành Công");
            this.loadKhachHang();
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Xóa Thất Bại");
        }
    }
    
    void clearKhachHang(){
        setKhachHang(new KhachHang());
        setStatusKhachHang(true);
    }
    
    void edit_KhachHang(){
        int row = tblKhachHang.getSelectedRow();
        String id = (String) tblKhachHang.getValueAt(row, 0);
        KhachHang kh = khDAO.findById(id);
        if (kh!=null) {
            setKhachHang(kh);
            setStatusKhachHang(false);
        }
    }
    
    void setStatusKhachHang(boolean isertable){
        btnThem.setEnabled(isertable);
        btnSua.setEnabled(!isertable);
        btnXoa.setEnabled(!isertable);
    }
    
    KhachHang getKhachHang(){
        KhachHang kh = new KhachHang();
        kh.setMaKH(txtMaKH.getText());
        kh.setTenKH(txtTenKH.getText());
        kh.setSdt(txtSdt.getText());
        kh.setDiaChi(txtDiaChi.getText());
        return kh;
    }
    
    void setKhachHang(KhachHang kh){
        txtMaKH.setText(kh.getMaKH());
        txtTenKH.setText(kh.getTenKH());
        txtSdt.setText(kh.getSdt());
        txtDiaChi.setText(kh.getDiaChi());
    }
////
////    void update_LoaiSP() {
////        if (DialogHelper.confirm(this, "Bạn có muốn cập nhập không")) {
////            try {
////                LoaiSanPham lsp = getLoai();
////                lDAO.insert_LoaiSP(lsp);
////                this.LoadLoaiSP();
////                DialogHelper.alert(this, "Thêm Thành Công");
////            } catch (Exception e) {
////                System.out.println("Error: " + e.getMessage());
////                e.printStackTrace();
////            }
////        }
////    }
////
////    void delete_Delete_LoaiSP() {
////        if (DialogHelper.confirm(this, "Bạn Có Muốn Xóa Không")) {
////            try {
////                String id = txtMaLoai.getText();
////                lDAO.delete_LoaSP(id);
////                this.LoadLoaiSP();
////                DialogHelper.alert(this, "Đã Xóa Thành Công");
////            } catch (Exception e) {
////                e.printStackTrace();
////                DialogHelper.alert(this, "Xóa thất bại");
////            }
////        }
////    }
////
////    LoaiSanPham getLoai() {
////        LoaiSanPham lsp = new LoaiSanPham();
////        lsp.setMaLoai(txtMaLoai.getText());
////        lsp.setTenLoai(txtTenLoai.getText());
////        return lsp;
////    }
////
////    void setLoai(LoaiSanPham lsp) {
////        txtTenLoai.setText(lsp.getTenLoai());
////        txtMaLoai.setText(lsp.getMaLoai());
////    }
////    int index = 0;
////
////    void editLoai() {
////        try {
////            String id = (String) tblLoaiSP.getValueAt(this.index, 1);
////            System.out.println("id= " + id);
////            LoaiSanPham lsp = lDAO.findByID(id);
////            if (lsp != null) {
////                this.setLoai(lsp);
////                this.setStatusLoai(false);
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            DialogHelper.alert(this, "Lỗi truy vấn dữ liệu");
////        }
////    }
////
////    void setStatusLoai(boolean isertable) {
////        btnAddLoai.setEnabled(isertable);
////        btnUpdateLoai.setEnabled(!isertable);
////        btnDelLoai.setEnabled(!isertable);
////    }
////
////    void loadSPbyIDLoai(String id) {
////        try {
////            DefaultTableModel model = (DefaultTableModel) tblThamChieuSP.getModel();
////            model.setRowCount(0);
////            List<SanPham> list = spDAO.selectID(id);
////            for (SanPham sp : list) {
////                model.addRow(new Object[]{
////                    sp.getMaSP(), sp.getTenSP(), id
////                });
////            }
////            model.fireTableDataChanged();
////        } catch (Exception e) {
////            e.printStackTrace();
////            DialogHelper.alert(this, "Lỗi Truy vấn dữ liệu");
////        }
////    }
////
////    /**
////     * This method is called from within the constructor to initialize the form.
////     * WARNING: Do NOT modify this code. The content of this method is always
////     * regenerated by the Form Editor.
////     */
////    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1046, 705));

        jPanel1.setBackground(new java.awt.Color(52, 152, 219));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quản Lý Khách Hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(729, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addGap(7, 7, 7)))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Danh Sách Khách Hàng");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Thông Tin");

        jLabel3.setText("Mã Khách Hàng:");

        jLabel4.setText("Tên Khách Hàng:");

        jLabel6.setText("Số điện thoại:");

        jLabel7.setText("Địa chỉ:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnNew.setText("Làm Mới");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(177, 177, 177))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(26, 26, 26)
                        .addComponent(btnSua)
                        .addGap(26, 26, 26)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnNew)
                        .addGap(58, 58, 58))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnNew)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Khách hàng", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Khách Hàng");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        edit_KhachHang();
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        clearKhachHang();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        delete_KhachHang();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        update_KhachHang();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        insert_KhachHang();
    }//GEN-LAST:event_btnThemActionPerformed

//    void Load_SP() {
//        try {
//            DefaultTableModel model = (DefaultTableModel) tblSanPham.getModel();
//            model.setRowCount(0);
//            List<SanPham> list = spDAO.select();
//            for (SanPham sp : list) {
//                model.addRow(new Object[]{
//                    sp.getMaSP(), sp.getTenSP(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(), sp.getMaLoai(), sp.getNghiChu()
//                });
//            }
//            model.fireTableDataChanged();
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "lỗi truy vấn dữ liệu");
//        }
//    }
//
//    void insert_SP() {
//        try {
//            SanPham sp = getSP();
//            spDAO.insert_SanPham(sp);
//            this.Load_SP();
//            DialogHelper.alert(this, "Thêm Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Thêm Thất Bại");
//        }
//    }
//
//    void update_SP() {
//        try {
//            SanPham sp = getSP();
//            spDAO.update_SanPham(sp);
//            this.Load_SP();
//            DialogHelper.alert(this, "Cập Nhập Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Cập Nhập Thất Bại");
//        }
//    }
//
//    void delete_SP() {
//        String id = txtMaSP.getText();
//        if (DialogHelper.confirm(this, "Bạn Có Muốn Xóa Sản Phẩm Không")) {
//            try {
//                spDAO.delete_SanPham(id);
//                DialogHelper.alert(this, "Xóa Thành Công");
//            } catch (Exception e) {
//                e.printStackTrace();
//                DialogHelper.alert(this, "Xóa Thấ Bại");
//            }
//        }
//    }
//
//    SanPham getSP() {
//        SanPham sp = new SanPham();
//        sp.setMaSP(txtMaSP.getText());
//        sp.setTenSP(txtTenSP.getText());
//        sp.setSoLuong(Integer.valueOf(txtSoLuong.getText()));
//        sp.setGiaNhap(Float.valueOf(txtGiaNhap.getText()));
//        sp.setGiaBan(Float.valueOf(txtGiaBan.getText()));
//        //sp.setMaLoai(txtLoai.getText());
//        sp.setNghiChu(txtNghiChu.getText());
//        sp.setAnh(lblAnh.getToolTipText());
//
//        LoaiSanPham lsp = (LoaiSanPham) cbbLoaiSP.getSelectedItem();
//        sp.setMaLoai(lsp.getMaLoai());
//
//        return sp;
//    }
//
//    private void setSP(SanPham sp) {
//        txtMaSP.setText(sp.getMaSP());
//        txtTenSP.setText(sp.getTenSP());
//        txtSoLuong.setText(String.valueOf(sp.getSoLuong()));
//        txtGiaBan.setText(String.valueOf(sp.getGiaBan()));
//        txtGiaNhap.setText(String.valueOf(sp.getGiaNhap()));
//        txtNghiChu.setText(sp.getNghiChu());
//
//        // load image lên Jlable
//        lblAnh.setToolTipText(sp.getAnh());
//        if (sp.getAnh() != null) {
//
//            ImageIcon path = ShareHelper.readLogos(sp.getAnh());
//            Image img = path.getImage();
//            Image imgScale = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
//            ImageIcon selectedIcon = new ImageIcon(imgScale);
//            lblAnh.setText(null);
//            lblAnh.setIcon(selectedIcon);
//
//        } else {
//            lblAnh.setIcon(null);
//            lblAnh.setText("No Avata");
//        }
//
//        // load TiptoolText mã loại lên CBB
//        cbbLoaiSP.setToolTipText(String.valueOf(sp.getMaLoai()));
//
//        // List<LoaiSanPham> list = lDAO.findByIDs(cbbLoaiSP.getToolTipText());
////         cbbLoaiSP.setSelectedItem(lDAO.findByID(sp.getMaLoai()));
////        cbbLoaiSP.setSelectedIndex(Integer.parseInt(cbbLoaiSP.getToolTipText()));
//    }
//
//    void loadComboxSP_Loai() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbLoaiSP.getModel();
//        List<LoaiSanPham> list = lDAO.select();
//        model.removeAllElements();
//        for (LoaiSanPham lsp : list) {
//
//            model.addElement(lsp);
//        }
//
//    }
//
//    void selectImage() {
//        JFileChooser fileChooser = new JFileChooser();
//        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            File file = fileChooser.getSelectedFile();
//            if (ShareHelper.saveLogo(file)) {
//                // hiển thị lên form
//                ImageIcon path = ShareHelper.readLogos(file.getName());
//                Image img = path.getImage();
//                Image imgScale = img.getScaledInstance(lblAnh.getWidth(), lblAnh.getHeight(), Image.SCALE_SMOOTH);
//                ImageIcon selectedIcon = new ImageIcon(imgScale);
//                lblAnh.setIcon(selectedIcon);
//                lblAnh.setToolTipText(file.getName());
//
////                lblAnh.setIcon(ShareHelper.readLogos(file.getName()));
////                lblAnh.setToolTipText(file.getName());
//            }
//        }
//    }
//
//    PhieuNhapDAO pnDAO = new PhieuNhapDAO();
//
//    void loadPhieuNhap() {
//        try {
//            DefaultTableModel model = (DefaultTableModel) tblPhieuNhap.getModel();
//            model.setRowCount(0);
//            List<PhieuNhap> list = pnDAO.select();
//            for (PhieuNhap pn : list) {
//                model.addRow(new Object[]{
//                    pn.getMaPN(), pn.getMaNV(), DateHelper.toString(pn.getNgayNhap()),
//                    pn.getNhaPP(), pn.getTongtien()
//                });
//            }
//            model.fireTableDataChanged();
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Lỗi Truy Vấn Dữ Liệu");
//        }
//    }
//
//    void insert_PhieuNhap() {
//        try {
//            PhieuNhap pn = getPhieuNhap();
//            pnDAO.insert_PhieuNhap(pn);
//            loadPhieuNhap();
//            DialogHelper.alert(this, "Thêm Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Thêm Thất Bại");
//        }
//    }
//
//    void update_PhieuNhap() {
//        try {
//            PhieuNhap pn = getPhieuNhap();
//            pnDAO.update_PhieuNhap(pn);
//            loadPhieuNhap();
//            DialogHelper.alert(this, "Thêm Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Thêm Thất Bại");
//        }
//    }
//
//    void delete_PhieuNhap() {
//        try {
//            String id = txtMaPhieu.getText();
//            pnDAO.delete_PhieuNhap(id);
//            loadPhieuNhap();
//            DialogHelper.alert(this, "Thêm Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Thêm Thất Bại");
//        }
//    }
//    
//    void clearPhieuNhap(){
//        setPhieuNhap(new PhieuNhap());
//        txtNhanVien.setText(ShareHelper.USER.getMaNV());
//        setStatusPhieuNhap(true);
//        
//    }
//    
//    void editPhieuNhap(){
//        try {
//            int row = tblPhieuNhap.getSelectedRow();
//            String id = (String) tblPhieuNhap.getValueAt(row, 0);
//            PhieuNhap pn = pnDAO.findByID(id);
//            if (pn != null) {
//                this.setPhieuNhap(pn);
//                this.clearCTPhieu();
//                txtMaPhieuCT1.setText(id);
//                this.setStatusPhieuNhap(false);
//                loadCTPhieu(pn.getMaPN());
//                setStatusCTPhieu(true);
//                
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this,"Lỗi dữ liệu" );
//        }
//    }
//    
//    void setStatusPhieuNhap(boolean isertable){
//        btnAddPhieu.setEnabled(isertable);
//        btnUpdatePhieu.setEnabled(!isertable);
//        btnXoaPhieu.setEnabled(!isertable);
//    }
//    
//    PhieuNhap getPhieuNhap() {
//        PhieuNhap pn = new PhieuNhap();
//        pn.setMaPN(txtMaPhieu.getText());
//        pn.setMaNV(txtNhanVien.getText());
//        pn.setNhaPP(txtNhaPhanPhoi.getText());
//        pn.setGhiChu(txtGhiChu.getText());
//        pn.setNgayNhap(DateHelper.toDae(txtNgayNhap.getText()));
//        if (txtTongTien.getText().equals("")) {
//            pn.setTongtien(0);
//        } else {
//            pn.setTongtien(Float.valueOf(txtTongTien.getText()));
//        }
//        return pn;
//    }
//    
//    void setPhieuNhap(PhieuNhap pn){
//        txtMaPhieu.setText(pn.getMaPN());
//        txtNhanVien.setText(pn.getMaNV());
//        txtNhaPhanPhoi.setText(pn.getNhaPP());
//        txtNgayNhap.setText(DateHelper.toString(pn.getNgayNhap()));
//        txtTongTien.setText(String.valueOf(pn.getTongtien()));
//        txtGhiChu.setText(pn.getGhiChu());
//        
//    }
//   
//    
//    NhieuNhapCTDAO ctDAO = new NhieuNhapCTDAO();
//    void loadCTPhieu(String id){
//        DefaultTableModel model = (DefaultTableModel) tblCTPhieu.getModel();
//        model.setRowCount(0);
//        List<PhieuNhapChiTiet> list = ctDAO.select(id);
//        for (PhieuNhapChiTiet ct : list) {
//            model.addRow(new Object[]{
//                ct.getPhieuNhapCT(),ct.getMaSP(),ct.getSoluong(),ct.getDonGia(),ct.getTongTien()
//            });
//        }
//        model.fireTableDataChanged();
//    }
//    
//    void loadComboBoxSP(){
//        DefaultComboBoxModel model = (DefaultComboBoxModel) cboMaSPPhieu.getModel();
//        model.removeAllElements();
//        List<SanPham> list = spDAO.select();
//        for (SanPham sp : list) {
//            model.addElement(sp);
//        }
//    }
//    
//    void loadThanhTien(){
//        SanPham sp1 = (SanPham) cboMaSPPhieu.getSelectedItem();
//        String id = sp1.getMaSP();
//        SanPham sp = spDAO.findByID(id);
//        if (sp!= null) {
//            int SoLuong = Integer.valueOf(txtPhieuSoLuong.getText());
//            float donGia = sp.getGiaBan();
//            float ThanhTien = donGia * SoLuong;
//            txtPhieuTongTien.setText(String.valueOf(ThanhTien));
//        }
//    }
//    
//    void loadDonGia(){
//        try {
//            SanPham sp1 = (SanPham) cboMaSPPhieu.getSelectedItem();
//        txtPhieuDonGia.setText(String.valueOf(sp1.getGiaBan()));
//        System.out.println("Giá Bán = "+sp1.getGiaBan());
//        } catch (Exception e) {
//            
//        }
//    }
//    
//    void insert_CTPhieu(){
//        String id = txtMaPhieuCT1.getText();
//        try {
//            PhieuNhapChiTiet ct = getCTPhieu();
//            
//            ctDAO.insert_PhieuCT(ct);
//            DialogHelper.alert(this, "Thêm Thành Công");
//            loadCTPhieu(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Thêm Thất Bại");
//        }
//    }
//    
//    void update_CTPhieu(){
//        String id = txtMaPhieuCT1.getText();
//        try {
//            PhieuNhapChiTiet ct = getCTPhieu1();
//            ctDAO.update_PhieuCT(ct);
//            DialogHelper.alert(this, "Cập Nhập Thành Công");
//            loadCTPhieu(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Cập Nhập Thất Bại");
//        }
//    }
//    void del_CTPhieu(){
//        String ids = txtMaPhieuCT1.getText();
//        try {
//            int id = Integer.valueOf(txtMaPhieuCT.getText());
//            ctDAO.delete_PhieuCT(id);
//            this.loadCTPhieu(ids);
//            this.clearCTPhieu();
//            DialogHelper.alert(this, "Xóa Thành Công");
//        } catch (Exception e) {
//            e.printStackTrace();
//            DialogHelper.alert(this, "Xóa Thất Bại");
//        }
//    }
//    
//    void clearCTPhieu(){
//        setCTPhieu(new PhieuNhapChiTiet());
//        
//    }
//    
//    void edit_CTPhieu(){
//        int row = tblCTPhieu.getSelectedRow();
//        int id = (int) tblCTPhieu.getValueAt(row, 0);
//        PhieuNhapChiTiet ct = ctDAO.findById(id);
//        if (ct != null) {
//            setCTPhieu(ct);
//            setStatusCTPhieu(true);
//        }
//    }
//    
//    void setStatusCTPhieu(boolean isertable){
//        btnAddCT.setEnabled(isertable);
//        btnDelCT.setEnabled(isertable);
//        btnUpdateCT.setEnabled(isertable);
//        btnNewCT.setEnabled(isertable);
//    }
//    
//    PhieuNhapChiTiet getCTPhieu(){
//        PhieuNhapChiTiet ct = new PhieuNhapChiTiet();
//        ct.setMaPN(txtMaPhieuCT1.getText());
//        SanPham sp = (SanPham) cboMaSPPhieu.getSelectedItem();
//        ct.setMaSP(sp.getMaSP());
//        ct.setSoluong(Integer.valueOf(txtPhieuSoLuong.getText()));
//        ct.setDonGia(Float.valueOf(txtPhieuDonGia.getText()));
//        ct.setTongTien(Float.valueOf(txtPhieuTongTien.getText()));
//        ct.setChuThich(txtPhieuGhiChu.getText());
//        return ct;
//    }
//    PhieuNhapChiTiet getCTPhieu1(){
//        PhieuNhapChiTiet ct = new PhieuNhapChiTiet();
//        ct.setPhieuNhapCT(Integer.valueOf(txtMaPhieuCT.getText()));
//        ct.setMaPN(txtMaPhieuCT1.getText());
//        SanPham sp = (SanPham) cboMaSPPhieu.getSelectedItem();
//        ct.setMaSP(sp.getMaSP());
//        ct.setSoluong(Integer.valueOf(txtPhieuSoLuong.getText()));
//        ct.setDonGia(Float.valueOf(txtPhieuDonGia.getText()));
//        ct.setTongTien(Float.valueOf(txtPhieuTongTien.getText()));
//        ct.setChuThich(txtPhieuGhiChu.getText());
//        return ct;
//    }
//    
//    void setCTPhieu(PhieuNhapChiTiet ct){
//        txtMaPhieuCT.setText(String.valueOf(ct.getPhieuNhapCT()));
//        
//        txtPhieuSoLuong.setText(String.valueOf(ct.getSoluong()));
//       // txtPhieuDonGia.setText(String.valueOf(ct.getDonGia()));
//        txtPhieuTongTien.setText(String.valueOf(ct.getTongTien()));
//        txtPhieuGhiChu.setText(ct.getChuThich());
//    }
    
    // Quan Ly Nhap Kho

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
