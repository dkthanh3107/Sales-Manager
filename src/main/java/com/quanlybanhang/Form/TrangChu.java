    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanlybanhang.Form;

import com.quanlybanhang.DAO.NhanVienDAO;
import com.quanlybanhang.Model.DangNhap;
import com.quanlybanhang.Model.NhanVien;
import com.quanlybanhang.helper.DateHelper;
import com.quanlybanhang.helper.DialogHelper;
import com.quanlybanhang.helper.ShareHelper;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class TrangChu extends javax.swing.JFrame {

    NhanVienDAO nvDAO = new NhanVienDAO();
    DefaultTableModel tblModel;
    Color panelDefault;
    Color pannelClick;

    /**
     * Creates new form TrangChu
     */
    public TrangChu() {
        initComponents();
        setLocationRelativeTo(null);
//        initTable();
//        Load();
        panelDefault = new Color(53,92,125);
        pannelClick = new Color(55,100,136);    
        
        init();
        jDesktopPane1.removeAll();
        DonHangJframe kho = new DonHangJframe();
        
        jDesktopPane1.add(kho).setVisible(true);
        pnlClickHD.setBackground(pannelClick);
    }

    void init() {
        //setIconImage(ShareHelper.APP_ICON);

        new Timer(1000, new ActionListener() {
            SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss a");

            @Override
            public void actionPerformed(ActionEvent e) {
                lblClock.setText(format.format(new Date()));
            }
        }).start();
        openChaoDialog();
        this.openLogin();
    }
    void openLogin(){
         new DangNhapDialog(this, true).setVisible(true);
         loadUser();
    }
    
    void openChaoDialog(){
        new ChaoDialog(this, true).setVisible(true);
        //loadUser();
    }
    
    void loadUser(){
        if (ShareHelper.authenticated()) {
            lblLoginName.setText(ShareHelper.USER.getTenNV());
            lblAvata.setToolTipText(ShareHelper.USER.getHinh());
        if (ShareHelper.USER.getHinh()!= null) {
            
            ImageIcon path = ShareHelper.readLogos(ShareHelper.USER.getHinh());
                Image img = path.getImage();
                Image imgScale = img.getScaledInstance(lblAvata.getWidth(), lblAvata.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon selectedIcon = new ImageIcon(imgScale);
            lblAvata.setText(null);
            lblAvata.setIcon(selectedIcon);
        }else{
            lblAvata.setText("No avata");
        }
            lblRole.setText(ShareHelper.USER.isVaiTro()==true?"Quản Lý":"Nhân Viên");
        }
    }
    
    void logout(){
        if (DialogHelper.confirm(this,"Bạn có muốn đăng xuất không")) {
            ShareHelper.logoff();
            //this.dispose();
            this.openLogin();
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblAvata = new javax.swing.JLabel();
        lblLoginName = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        pnlDonHang = new javax.swing.JPanel();
        pnlDon = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlKho = new javax.swing.JPanel();
        pnlClickKho = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        pblThongKe = new javax.swing.JPanel();
        pnlClickThongKe = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pblNhanVien = new javax.swing.JPanel();
        pnlClickNV = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlHuongDan = new javax.swing.JPanel();
        pnlClickHD = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pblKhachHang = new javax.swing.JPanel();
        pnlKhachHang = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        lblLogout = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(53, 92, 125));

        lblAvata.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblAvata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAvata.setText("Avata");
        lblAvata.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblLoginName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLoginName.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLoginName.setText("sss");

        lblRole.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblRole.setForeground(new java.awt.Color(255, 255, 255));
        lblRole.setText("Chức Vụ");

        pnlDonHang.setBackground(new java.awt.Color(53, 92, 125));
        pnlDonHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDonHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlDonHangMousePressed(evt);
            }
        });

        pnlDon.setBackground(new java.awt.Color(53, 92, 125));

        javax.swing.GroupLayout pnlDonLayout = new javax.swing.GroupLayout(pnlDon);
        pnlDon.setLayout(pnlDonLayout);
        pnlDonLayout.setHorizontalGroup(
            pnlDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        pnlDonLayout.setVerticalGroup(
            pnlDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_addchart_white_36dp.png"))); // NOI18N
        jLabel4.setText("QUẢN LÝ ĐƠN HÀNG");

        javax.swing.GroupLayout pnlDonHangLayout = new javax.swing.GroupLayout(pnlDonHang);
        pnlDonHang.setLayout(pnlDonHangLayout);
        pnlDonHangLayout.setHorizontalGroup(
            pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDonHangLayout.createSequentialGroup()
                .addComponent(pnlDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDonHangLayout.setVerticalGroup(
            pnlDonHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlDonHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlKho.setBackground(new java.awt.Color(53, 92, 125));
        pnlKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlKhoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlKhoMousePressed(evt);
            }
        });

        pnlClickKho.setBackground(new java.awt.Color(53, 92, 125));

        javax.swing.GroupLayout pnlClickKhoLayout = new javax.swing.GroupLayout(pnlClickKho);
        pnlClickKho.setLayout(pnlClickKhoLayout);
        pnlClickKhoLayout.setHorizontalGroup(
            pnlClickKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        pnlClickKhoLayout.setVerticalGroup(
            pnlClickKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_domain_white_36dp.png"))); // NOI18N
        jLabel5.setText("QUẢN LÝ KHO");

        javax.swing.GroupLayout pnlKhoLayout = new javax.swing.GroupLayout(pnlKho);
        pnlKho.setLayout(pnlKhoLayout);
        pnlKhoLayout.setHorizontalGroup(
            pnlKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlKhoLayout.createSequentialGroup()
                .addComponent(pnlClickKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlKhoLayout.setVerticalGroup(
            pnlKhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlClickKho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlKhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pblThongKe.setBackground(new java.awt.Color(53, 92, 125));
        pblThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pblThongKeMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pblThongKeMousePressed(evt);
            }
        });

        pnlClickThongKe.setBackground(new java.awt.Color(53, 92, 125));

        javax.swing.GroupLayout pnlClickThongKeLayout = new javax.swing.GroupLayout(pnlClickThongKe);
        pnlClickThongKe.setLayout(pnlClickThongKeLayout);
        pnlClickThongKeLayout.setHorizontalGroup(
            pnlClickThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        pnlClickThongKeLayout.setVerticalGroup(
            pnlClickThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_assessment_white_36dp.png"))); // NOI18N
        jLabel6.setText("THỐNG KÊ");

        javax.swing.GroupLayout pblThongKeLayout = new javax.swing.GroupLayout(pblThongKe);
        pblThongKe.setLayout(pblThongKeLayout);
        pblThongKeLayout.setHorizontalGroup(
            pblThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblThongKeLayout.createSequentialGroup()
                .addComponent(pnlClickThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pblThongKeLayout.setVerticalGroup(
            pblThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlClickThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pblThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pblNhanVien.setBackground(new java.awt.Color(53, 92, 125));
        pblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pblNhanVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pblNhanVienMousePressed(evt);
            }
        });

        pnlClickNV.setBackground(new java.awt.Color(53, 92, 125));

        javax.swing.GroupLayout pnlClickNVLayout = new javax.swing.GroupLayout(pnlClickNV);
        pnlClickNV.setLayout(pnlClickNVLayout);
        pnlClickNVLayout.setHorizontalGroup(
            pnlClickNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        pnlClickNVLayout.setVerticalGroup(
            pnlClickNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_assignment_ind_white_36dp.png"))); // NOI18N
        jLabel7.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout pblNhanVienLayout = new javax.swing.GroupLayout(pblNhanVien);
        pblNhanVien.setLayout(pblNhanVienLayout);
        pblNhanVienLayout.setHorizontalGroup(
            pblNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblNhanVienLayout.createSequentialGroup()
                .addComponent(pnlClickNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel7)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        pblNhanVienLayout.setVerticalGroup(
            pblNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlClickNV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pblNhanVienLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlHuongDan.setBackground(new java.awt.Color(53, 92, 125));
        pnlHuongDan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlHuongDanMousePressed(evt);
            }
        });

        pnlClickHD.setBackground(new java.awt.Color(53, 92, 125));

        javax.swing.GroupLayout pnlClickHDLayout = new javax.swing.GroupLayout(pnlClickHD);
        pnlClickHD.setLayout(pnlClickHDLayout);
        pnlClickHDLayout.setHorizontalGroup(
            pnlClickHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        pnlClickHDLayout.setVerticalGroup(
            pnlClickHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_help_center_white_36dp.png"))); // NOI18N
        jLabel8.setText("HƯỚNG DẪN");
        jLabel8.setToolTipText("");

        javax.swing.GroupLayout pnlHuongDanLayout = new javax.swing.GroupLayout(pnlHuongDan);
        pnlHuongDan.setLayout(pnlHuongDanLayout);
        pnlHuongDanLayout.setHorizontalGroup(
            pnlHuongDanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHuongDanLayout.createSequentialGroup()
                .addComponent(pnlClickHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlHuongDanLayout.setVerticalGroup(
            pnlHuongDanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlClickHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlHuongDanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        pblKhachHang.setBackground(new java.awt.Color(53, 92, 125));
        pblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pblKhachHangMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pblKhachHangMousePressed(evt);
            }
        });

        pnlKhachHang.setBackground(new java.awt.Color(53, 92, 125));

        javax.swing.GroupLayout pnlKhachHangLayout = new javax.swing.GroupLayout(pnlKhachHang);
        pnlKhachHang.setLayout(pnlKhachHangLayout);
        pnlKhachHangLayout.setHorizontalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );
        pnlKhachHangLayout.setVerticalGroup(
            pnlKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_group_white_36dp.png"))); // NOI18N
        jLabel9.setText("KHÁCH HÀNG");

        javax.swing.GroupLayout pblKhachHangLayout = new javax.swing.GroupLayout(pblKhachHang);
        pblKhachHang.setLayout(pblKhachHangLayout);
        pblKhachHangLayout.setHorizontalGroup(
            pblKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pblKhachHangLayout.createSequentialGroup()
                .addComponent(pnlKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pblKhachHangLayout.setVerticalGroup(
            pblKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pblKhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblLogout.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblLogout.setForeground(new java.awt.Color(255, 255, 255));
        lblLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/fpoly/quanlybanhang/icons/outline_exit_to_app_white_24dp.png"))); // NOI18N
        lblLogout.setText("Đăng Xuất");
        lblLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLogoutMouseClicked(evt);
            }
        });

        lblClock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 255, 255));
        lblClock.setText("16:04:03");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblRole)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(lblAvata, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlKho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pblNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pblKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlHuongDan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(lblLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogout)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAvata, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRole, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(pnlDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlKho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pblNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pblThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pblKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlHuongDan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogout)
                    .addComponent(lblClock))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1023, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 757, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pnlDonHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDonHangMouseClicked
        jDesktopPane1.removeAll();
        DonHangJframe DonHang = new DonHangJframe();

        jDesktopPane1.add(DonHang).setVisible(true);
    }//GEN-LAST:event_pnlDonHangMouseClicked

    private void pnlKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhoMouseClicked
        jDesktopPane1.removeAll();
        QuanLyKhoJFrame kho = new QuanLyKhoJFrame();

        jDesktopPane1.add(kho).setVisible(true);
    }//GEN-LAST:event_pnlKhoMouseClicked

    private void pblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pblNhanVienMouseClicked
        jDesktopPane1.removeAll();
        NhanVienForm kho = new NhanVienForm();

        jDesktopPane1.add(kho).setVisible(true);
    }//GEN-LAST:event_pblNhanVienMouseClicked

    private void pblThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pblThongKeMouseClicked
        jDesktopPane1.removeAll();
        ThongKeForm kho = new ThongKeForm();

        jDesktopPane1.add(kho).setVisible(true);
    }//GEN-LAST:event_pblThongKeMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        loadUser();
    }//GEN-LAST:event_formWindowOpened

    private void lblLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLogoutMouseClicked
        logout();
    }//GEN-LAST:event_lblLogoutMouseClicked

    private void pblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pblKhachHangMouseClicked
        jDesktopPane1.removeAll();
        QuanLyDoiTac dt = new QuanLyDoiTac();
        jDesktopPane1.add(dt).setVisible(true);
    }//GEN-LAST:event_pblKhachHangMouseClicked

    private void pnlDonHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDonHangMousePressed
        pnlDon.setBackground(pannelClick);
        pnlClickKho.setBackground(panelDefault);
        pnlClickNV.setBackground(panelDefault);
        pnlClickThongKe.setBackground(panelDefault);
        pnlClickHD.setBackground(panelDefault);
        pnlKhachHang.setBackground(panelDefault);
    }//GEN-LAST:event_pnlDonHangMousePressed

    private void pnlKhoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlKhoMousePressed
        pnlDon.setBackground(panelDefault);
        pnlClickKho.setBackground(pannelClick);
        pnlClickNV.setBackground(panelDefault);
        pnlClickThongKe.setBackground(panelDefault);
        pnlClickHD.setBackground(panelDefault);
        pnlKhachHang.setBackground(panelDefault);
    }//GEN-LAST:event_pnlKhoMousePressed

    private void pblNhanVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pblNhanVienMousePressed
        pnlDon.setBackground(panelDefault);
        pnlClickKho.setBackground(panelDefault);
        pnlClickNV.setBackground(pannelClick);
        pnlClickThongKe.setBackground(panelDefault);
        pnlClickHD.setBackground(panelDefault);
        pnlKhachHang.setBackground(panelDefault);
    }//GEN-LAST:event_pblNhanVienMousePressed

    private void pblThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pblThongKeMousePressed
        pnlDon.setBackground(panelDefault);
        pnlClickKho.setBackground(panelDefault);
        pnlClickNV.setBackground(panelDefault);
        pnlClickThongKe.setBackground(pannelClick);
        pnlClickHD.setBackground(panelDefault);
        pnlKhachHang.setBackground(panelDefault);
    }//GEN-LAST:event_pblThongKeMousePressed

    private void pblKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pblKhachHangMousePressed
        pnlDon.setBackground(panelDefault);
        pnlClickKho.setBackground(panelDefault);
        pnlClickNV.setBackground(panelDefault);
        pnlClickThongKe.setBackground(panelDefault);
        pnlClickHD.setBackground(panelDefault);
        pnlKhachHang.setBackground(pannelClick);
    }//GEN-LAST:event_pblKhachHangMousePressed

    private void pnlHuongDanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlHuongDanMousePressed
        pnlDon.setBackground(panelDefault);
        pnlClickKho.setBackground(panelDefault);
        pnlClickNV.setBackground(panelDefault);
        pnlClickThongKe.setBackground(panelDefault);
        pnlClickHD.setBackground(pannelClick);
        pnlKhachHang.setBackground(panelDefault);
    }//GEN-LAST:event_pnlHuongDanMousePressed

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
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvata;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblLoginName;
    private javax.swing.JLabel lblLogout;
    private javax.swing.JLabel lblRole;
    private javax.swing.JPanel pblKhachHang;
    private javax.swing.JPanel pblNhanVien;
    private javax.swing.JPanel pblThongKe;
    private javax.swing.JPanel pnlClickHD;
    private javax.swing.JPanel pnlClickKho;
    private javax.swing.JPanel pnlClickNV;
    private javax.swing.JPanel pnlClickThongKe;
    private javax.swing.JPanel pnlDon;
    private javax.swing.JPanel pnlDonHang;
    private javax.swing.JPanel pnlHuongDan;
    private javax.swing.JPanel pnlKhachHang;
    private javax.swing.JPanel pnlKho;
    // End of variables declaration//GEN-END:variables
}
