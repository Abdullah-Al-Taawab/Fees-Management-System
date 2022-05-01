/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Asus
 */
public class Editcourse extends javax.swing.JFrame {
     DefaultTableModel model;

    /**
     * Creates new form Editcourse
     */
    public Editcourse() {
        initComponents();
        setRecordstotable();
    }
    
    
     public void setRecordstotable(){
        try{
            Connection con=DBconnection.getconnection();
            PreparedStatement pst = con.prepareStatement("select * from course");
        ResultSet rs=pst.executeQuery();
        
        while(rs.next()){
            String courseid=rs.getString("Id");
            String cname=rs.getString("CNAME");
            String cost=rs.getString("COST");
            
            Object[] obj={courseid,cname,cost};
            model=(DefaultTableModel)tbl_coursedata.getModel();
            model.addRow(obj);
        }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
     public void addcourse(int id, String cname, double cost){
         
         try{
             
             Connection con=DBconnection.getconnection();
             PreparedStatement pst=con.prepareStatement("insert into course values(?,?,?)");
             pst.setInt(1, id);
             pst.setString(2, cname);
             pst.setDouble(3, cost);
             
             int rowcount=pst.executeUpdate();
             if(rowcount==1){
                 JOptionPane.showMessageDialog(this, "Course added Successfully");
                 cleartable();
                 setRecordstotable();
             }
             else{
                 JOptionPane.showMessageDialog(this, "Course insertion failed");
             }
             
         }
         catch(Exception e){
             e.printStackTrace();
             
         }
     }
     
     public void update(int id, String cname,double cost){
         try{
             
             Connection con=DBconnection.getconnection();
             PreparedStatement pst=con.prepareStatement("update course set cname=?,cost=? where id=?");
            
             pst.setString(1, cname);
             pst.setDouble(2, cost);
             pst.setInt(3, id);
             
             int rowcount=pst.executeUpdate();
             if(rowcount==1){
                 JOptionPane.showMessageDialog(this, "Course updated Successfully");
                 cleartable();
                 setRecordstotable();
             }
             else{
                 JOptionPane.showMessageDialog(this, "Course updation failed");
             }
             
         }
         catch(Exception e){
             e.printStackTrace();
             
         }
     }
     public void delete(int id){
         try{
             
             Connection con=DBconnection.getconnection();
             PreparedStatement pst=con.prepareStatement("delete from course where id=?");
            
            
             pst.setInt(1, id);
             
             int rowcount=pst.executeUpdate();
             if(rowcount==1){
                 JOptionPane.showMessageDialog(this, "Course deleted Successfully");
                 cleartable();
                 setRecordstotable();
             }
             else{
                 JOptionPane.showMessageDialog(this, "Course deletion failed");
             }
             
         }
         catch(Exception e){
             e.printStackTrace();
             
         }
     }
     public void cleartable(){
         DefaultTableModel model=(DefaultTableModel)tbl_coursedata.getModel();
         model.setRowCount(0);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelsidebar = new javax.swing.JPanel();
        panellogout = new javax.swing.JPanel();
        btnlogout = new javax.swing.JLabel();
        panelback = new javax.swing.JPanel();
        btnback = new javax.swing.JLabel();
        panelhome31 = new javax.swing.JPanel();
        btnhome31 = new javax.swing.JLabel();
        panelviewallrecord = new javax.swing.JPanel();
        btnviewallrecord = new javax.swing.JLabel();
        panelhome = new javax.swing.JPanel();
        btnhome = new javax.swing.JLabel();
        panelhome33 = new javax.swing.JPanel();
        btnhome33 = new javax.swing.JLabel();
        panelcourselist = new javax.swing.JPanel();
        btncourselist = new javax.swing.JLabel();
        panelhome35 = new javax.swing.JPanel();
        btnhome35 = new javax.swing.JLabel();
        paneleditcourse = new javax.swing.JPanel();
        btneditcourse = new javax.swing.JLabel();
        panelhome37 = new javax.swing.JPanel();
        btnhome37 = new javax.swing.JLabel();
        panelsearchrecord = new javax.swing.JPanel();
        btnsearchrecord = new javax.swing.JLabel();
        panelhome39 = new javax.swing.JPanel();
        btnhome39 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_coursedata = new javax.swing.JTable();
        txt_courseid = new javax.swing.JTextField();
        txt_coursename = new javax.swing.JTextField();
        txt_courseprice = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelsidebar.setBackground(new java.awt.Color(0, 51, 51));
        panelsidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panellogout.setBackground(new java.awt.Color(0, 51, 51));
        panellogout.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panellogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnlogout.setBackground(new java.awt.Color(255, 255, 255));
        btnlogout.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btnlogout.setForeground(new java.awt.Color(255, 255, 255));
        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/logout.png"))); // NOI18N
        btnlogout.setText("Logout");
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogoutMouseExited(evt);
            }
        });
        panellogout.add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 40));

        panelsidebar.add(panellogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 640, 330, 60));

        panelback.setBackground(new java.awt.Color(0, 51, 51));
        panelback.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelback.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnback.setBackground(new java.awt.Color(255, 255, 255));
        btnback.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btnback.setForeground(new java.awt.Color(255, 255, 255));
        btnback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back1.png"))); // NOI18N
        btnback.setText("  Back");
        btnback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnbackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnbackMouseExited(evt);
            }
        });
        panelback.add(btnback, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 210, 60));

        panelhome31.setBackground(new java.awt.Color(0, 51, 51));
        panelhome31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome31.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome31.setBackground(new java.awt.Color(255, 255, 255));
        btnhome31.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        btnhome31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome31.setText(" Home");
        btnhome31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhome31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhome31MouseExited(evt);
            }
        });
        panelhome31.add(btnhome31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 40));

        panelback.add(panelhome31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 330, 60));

        panelsidebar.add(panelback, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, 330, 60));

        panelviewallrecord.setBackground(new java.awt.Color(0, 51, 51));
        panelviewallrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelviewallrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnviewallrecord.setBackground(new java.awt.Color(255, 255, 255));
        btnviewallrecord.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btnviewallrecord.setForeground(new java.awt.Color(255, 255, 255));
        btnviewallrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/view all record.png"))); // NOI18N
        btnviewallrecord.setText("View All Record");
        btnviewallrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnviewallrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnviewallrecordMouseExited(evt);
            }
        });
        panelviewallrecord.add(btnviewallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 310, 60));

        panelsidebar.add(panelviewallrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, 330, 60));

        panelhome.setBackground(new java.awt.Color(0, 51, 51));
        panelhome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome.setBackground(new java.awt.Color(255, 255, 255));
        btnhome.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btnhome.setForeground(new java.awt.Color(255, 255, 255));
        btnhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome.setText(" Home");
        btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhomeMouseExited(evt);
            }
        });
        panelhome.add(btnhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 40));

        panelhome33.setBackground(new java.awt.Color(0, 51, 51));
        panelhome33.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome33.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome33.setBackground(new java.awt.Color(255, 255, 255));
        btnhome33.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        btnhome33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome33.setText(" Home");
        btnhome33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhome33MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhome33MouseExited(evt);
            }
        });
        panelhome33.add(btnhome33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 40));

        panelhome.add(panelhome33, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 330, 60));

        panelsidebar.add(panelhome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 330, 60));

        panelcourselist.setBackground(new java.awt.Color(0, 51, 51));
        panelcourselist.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelcourselist.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btncourselist.setBackground(new java.awt.Color(255, 255, 255));
        btncourselist.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btncourselist.setForeground(new java.awt.Color(255, 255, 255));
        btncourselist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/list.png"))); // NOI18N
        btncourselist.setText("Course List");
        btncourselist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btncourselistMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btncourselistMouseExited(evt);
            }
        });
        panelcourselist.add(btncourselist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 60));

        panelhome35.setBackground(new java.awt.Color(0, 51, 51));
        panelhome35.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome35.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome35.setBackground(new java.awt.Color(255, 255, 255));
        btnhome35.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        btnhome35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome35.setText(" Home");
        btnhome35.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhome35MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhome35MouseExited(evt);
            }
        });
        panelhome35.add(btnhome35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 40));

        panelcourselist.add(panelhome35, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 330, 60));

        panelsidebar.add(panelcourselist, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 330, 60));

        paneleditcourse.setBackground(new java.awt.Color(0, 51, 51));
        paneleditcourse.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        paneleditcourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btneditcourse.setBackground(new java.awt.Color(255, 255, 255));
        btneditcourse.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btneditcourse.setForeground(new java.awt.Color(255, 255, 255));
        btneditcourse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/edit2.png"))); // NOI18N
        btneditcourse.setText("Edit Course");
        btneditcourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditcourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btneditcourseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btneditcourseMouseExited(evt);
            }
        });
        paneleditcourse.add(btneditcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 300, 60));

        panelhome37.setBackground(new java.awt.Color(0, 51, 51));
        panelhome37.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome37.setBackground(new java.awt.Color(255, 255, 255));
        btnhome37.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        btnhome37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome37.setText(" Home");
        btnhome37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhome37MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhome37MouseExited(evt);
            }
        });
        panelhome37.add(btnhome37, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 40));

        paneleditcourse.add(panelhome37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 330, 60));

        panelsidebar.add(paneleditcourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 330, 60));

        panelsearchrecord.setBackground(new java.awt.Color(0, 51, 51));
        panelsearchrecord.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelsearchrecord.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnsearchrecord.setBackground(new java.awt.Color(255, 255, 255));
        btnsearchrecord.setFont(new java.awt.Font("Courier New", 1, 25)); // NOI18N
        btnsearchrecord.setForeground(new java.awt.Color(255, 255, 255));
        btnsearchrecord.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/search2.png"))); // NOI18N
        btnsearchrecord.setText("Search Record");
        btnsearchrecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsearchrecordMouseExited(evt);
            }
        });
        panelsearchrecord.add(btnsearchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, 50));

        panelhome39.setBackground(new java.awt.Color(0, 51, 51));
        panelhome39.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelhome39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnhome39.setBackground(new java.awt.Color(255, 255, 255));
        btnhome39.setFont(new java.awt.Font("Courier New", 1, 30)); // NOI18N
        btnhome39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/home.png"))); // NOI18N
        btnhome39.setText(" Home");
        btnhome39.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnhome39MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnhome39MouseExited(evt);
            }
        });
        panelhome39.add(btnhome39, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 160, 40));

        panelsearchrecord.add(panelhome39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 640, 330, 60));

        panelsidebar.add(panelsearchrecord, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 330, 60));

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 0, 490, 1030));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_coursedata.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        tbl_coursedata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Course Id", "Course Name", "Course Price"
            }
        ));
        tbl_coursedata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_coursedataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_coursedata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 760, 670));

        txt_courseid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_courseidActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseid, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 170, 40));

        txt_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursenameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 170, 40));

        txt_courseprice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursepriceActionPerformed(evt);
            }
        });
        jPanel1.add(txt_courseprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 170, 40));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Price");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 550, 150, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course ID");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 150, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Course Name");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 150, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 740, 120, 40));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton2.setText("DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 740, 100, 40));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        jButton3.setText("ADD");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 740, 80, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Edit Course Details");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fees_management_system/images/back1.png"))); // NOI18N
        jLabel5.setText("  Back");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 140, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 980));

        setSize(new java.awt.Dimension(1847, 1015));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseEntered
        Color clr=new Color(0,153,153);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseEntered

    private void btnlogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseExited
        Color clr=new Color(0,51,51);
        panellogout.setBackground(clr);
    }//GEN-LAST:event_btnlogoutMouseExited

    private void btnbackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseEntered
        Color clr=new Color(0,153,153);
        panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseEntered

    private void btnbackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnbackMouseExited
        Color clr=new Color(0,51,51);
        panelback.setBackground(clr);
    }//GEN-LAST:event_btnbackMouseExited

    private void btnhome31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome31MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome31MouseEntered

    private void btnhome31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome31MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome31MouseExited

    private void btnviewallrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallrecordMouseEntered
        Color clr=new Color(0,153,153);
        panelviewallrecord.setBackground(clr);
    }//GEN-LAST:event_btnviewallrecordMouseEntered

    private void btnviewallrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallrecordMouseExited
        Color clr=new Color(0,51,51);
        panelviewallrecord.setBackground(clr);
    }//GEN-LAST:event_btnviewallrecordMouseExited

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        Home h=new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnhomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseEntered
        Color clr=new Color(0,153,153);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseEntered

    private void btnhomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseExited
        Color clr=new Color(0,51,51);
        panelhome.setBackground(clr);
    }//GEN-LAST:event_btnhomeMouseExited

    private void btnhome33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome33MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome33MouseEntered

    private void btnhome33MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome33MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome33MouseExited

    private void btncourselistMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncourselistMouseEntered
        Color clr=new Color(0,153,153);
        panelcourselist.setBackground(clr);
    }//GEN-LAST:event_btncourselistMouseEntered

    private void btncourselistMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncourselistMouseExited
        Color clr=new Color(0,51,51);
        panelcourselist.setBackground(clr);
    }//GEN-LAST:event_btncourselistMouseExited

    private void btnhome35MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome35MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome35MouseEntered

    private void btnhome35MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome35MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome35MouseExited

    private void btneditcourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditcourseMouseEntered
        Color clr=new Color(0,153,153);
        paneleditcourse.setBackground(clr);
    }//GEN-LAST:event_btneditcourseMouseEntered

    private void btneditcourseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditcourseMouseExited
        Color clr=new Color(0,51,51);
        paneleditcourse.setBackground(clr);
    }//GEN-LAST:event_btneditcourseMouseExited

    private void btnhome37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome37MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome37MouseEntered

    private void btnhome37MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome37MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome37MouseExited

    private void btnsearchrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseClicked
        Searchrecord s=new Searchrecord();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsearchrecordMouseClicked

    private void btnsearchrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseEntered
        Color clr=new Color(0,153,153);
        panelsearchrecord.setBackground(clr);
    }//GEN-LAST:event_btnsearchrecordMouseEntered

    private void btnsearchrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseExited
        Color clr=new Color(0,51,51);
        panelsearchrecord.setBackground(clr);
    }//GEN-LAST:event_btnsearchrecordMouseExited

    private void btnhome39MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome39MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome39MouseEntered

    private void btnhome39MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome39MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome39MouseExited

    private void txt_courseidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_courseidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_courseidActionPerformed

    private void txt_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursenameActionPerformed

    private void txt_coursepriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursepriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursepriceActionPerformed

    private void tbl_coursedataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_coursedataMouseClicked
        int rowno=tbl_coursedata.getSelectedRow();
        TableModel model=tbl_coursedata.getModel();
        txt_courseid.setText(model.getValueAt(rowno, 0).toString());
        txt_coursename.setText((String)model.getValueAt(rowno, 1));
        txt_courseprice.setText(model.getValueAt(rowno, 2).toString());
    }//GEN-LAST:event_tbl_coursedataMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        int id=Integer.parseInt(txt_courseid.getText());
        String cname=txt_coursename.getText();
        double cost=Double.parseDouble(txt_courseprice.getText());
        addcourse(id,cname,cost);
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       int id=Integer.parseInt(txt_courseid.getText());
        String cname=txt_coursename.getText();
        double cost=Double.parseDouble(txt_courseprice.getText());
        update(id,cname,cost);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int id=Integer.parseInt(txt_courseid.getText());
        delete(id);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       Home H=new Home();
       H.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void btneditcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditcourseMouseClicked
        Editcourse e=new Editcourse();
       e.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btneditcourseMouseClicked

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
            java.util.logging.Logger.getLogger(Editcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editcourse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editcourse().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnback;
    private javax.swing.JLabel btncourselist;
    private javax.swing.JLabel btneditcourse;
    private javax.swing.JLabel btnhome;
    private javax.swing.JLabel btnhome31;
    private javax.swing.JLabel btnhome33;
    private javax.swing.JLabel btnhome35;
    private javax.swing.JLabel btnhome37;
    private javax.swing.JLabel btnhome39;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnsearchrecord;
    private javax.swing.JLabel btnviewallrecord;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel panelcourselist;
    private javax.swing.JPanel paneleditcourse;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelhome31;
    private javax.swing.JPanel panelhome33;
    private javax.swing.JPanel panelhome35;
    private javax.swing.JPanel panelhome37;
    private javax.swing.JPanel panelhome39;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelsearchrecord;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JPanel panelviewallrecord;
    private javax.swing.JTable tbl_coursedata;
    private javax.swing.JTextField txt_courseid;
    private javax.swing.JTextField txt_coursename;
    private javax.swing.JTextField txt_courseprice;
    // End of variables declaration//GEN-END:variables
}
