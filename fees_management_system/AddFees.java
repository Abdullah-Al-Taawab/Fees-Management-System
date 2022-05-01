/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;


import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class AddFees extends javax.swing.JFrame {
    private Object Interger;

    /**
     * Creates new form AddFees
     */
    public AddFees() {
        initComponents();
        displaycashfirst();
        fillcombobox();
        int receiptno=getreceiptno();
        txt_receiptno.setText(Integer.toString(receiptno));
    }
    
    public void displaycashfirst(){
        lbl_ddno.setVisible(false);
        lbl_chequeno.setVisible(false);
        lbl_bankname.setVisible(false);
        
        txt_ddno.setVisible(false);
        txt_chequeno.setVisible(false);
        txt_bankname.setVisible(false);
        
        
    }
    
    public boolean validation(){
        
        if(txt_receivedfrom.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please Enter User Name");
            return false;
        }
        if(datechooser.getDate()== null){
            JOptionPane.showMessageDialog(this,"Please Select a Date");
            return false;
        }
         if(txt_amount.getText().equals("") || txt_amount.getText().matches("[0-9]+")== false){
          JOptionPane.showMessageDialog(this,"Please Enter Amount in Numbers");
            return false;
        }
         
         if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("cheque")){
              if(txt_chequeno.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please Enter Cheque Number");
            return false;
        }
              if(txt_rollno.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
            return false;
        }
         } 
         
         if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("dd")){
              if(txt_ddno.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please Enter dd no");
            return false;
        }
              if(txt_rollno.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
            return false;
        }
         }
         
         if(combo_paymentmode.getSelectedItem().toString().equalsIgnoreCase("card")){
            if(txt_rollno.getText().equals("")){
          JOptionPane.showMessageDialog(this,"Please Enter Bank Name ");
            return false;
        } 
         }
         
         
        
        return true;
    }
    
    
    
    public void fillcombobox(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "1234");
           PreparedStatement pst = con.prepareStatement("select CNAME from course");
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               combocourse.addItem(rs.getString("CNAME"));
               
           }
           }
           
        
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public int getreceiptno(){
        int receiptnum=0;
        try{
           Connection con=DBconnection.getconnection();
           PreparedStatement pst = con.prepareStatement("select reciept_no from fees_details");
        ResultSet rs=pst.executeQuery();
        while(rs.next()==true){
            receiptnum= rs.getInt(1)+1;
               
           }
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
        return receiptnum;
    }
    
    
    public String insertData(){
        String status=""; 
        int recieptno= Integer.parseInt(txt_receiptno.getText());
        String studentname=txt_receivedfrom.getText();
        String rollno=(txt_rollno.getText());
        String paymentMode=combo_paymentmode.getSelectedItem().toString();
        String chequeno=txt_chequeno.getText();
        String bankname=txt_bankname.getText();
        String ddno=txt_ddno.getText();
        String coursename=txt_coursename.getText();
        float totalamount=Float.parseFloat(txt_total.getText());
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        String date=new SimpleDateFormat("yyyy-MM-dd").format(datechooser.getDate());
        float initialamount=Float.parseFloat(txt_amount.getText());
        float vat=Float.parseFloat(txt_cgst.getText());
        String totalinwords=txt_totalinwords.getText();
        String remark=txt_remark.getText();
        int year1=Integer.parseInt(txt_year1.getText());
        int year2=Integer.parseInt(txt_year2.getText());
        
        try{
           Connection con=DBconnection.getconnection();
           PreparedStatement pst=con.prepareStatement("insert into fees_details values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
           pst.setInt(1, recieptno);
           pst.setString(2, studentname);
           pst.setString(3, rollno);
           pst.setString(4, paymentMode);
           pst.setString(5, chequeno);
           pst.setString(6, bankname);
           pst.setString(7, ddno);
           pst.setString(8, coursename);
           pst.setFloat(9, totalamount);
           pst.setString(10, date);
           pst.setFloat(11, initialamount);
           pst.setFloat(12, vat);
           pst.setString(13, totalinwords);
           pst.setString(14, remark);
           pst.setInt(15, year1);
           pst.setInt(16, year2);
           
           
           int rowcount=pst.executeUpdate();
           if(rowcount==1){
               status="success";
           }
           else{
               status="failed";
           }
           
        
        }
        catch(Exception e){
            
            e.printStackTrace();
            
        }
        return status;
        
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
        panelparent = new javax.swing.JPanel();
        lbl_receiptno = new javax.swing.JLabel();
        lbl_paymentmode = new javax.swing.JLabel();
        lbl_ddno = new javax.swing.JLabel();
        lbl_chequeno = new javax.swing.JLabel();
        lbl_bankname = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        txt_receiptno = new javax.swing.JTextField();
        txt_ddno = new javax.swing.JTextField();
        txt_chequeno = new javax.swing.JTextField();
        combo_paymentmode = new javax.swing.JComboBox();
        datechooser = new com.toedter.calendar.JDateChooser();
        panelchild = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_year2 = new javax.swing.JTextField();
        lbl_rollno = new javax.swing.JLabel();
        txt_totalinwords = new javax.swing.JTextField();
        combocourse = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_amount = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        txt_year1 = new javax.swing.JTextField();
        txt_cgst = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        txt_coursename = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_remark = new javax.swing.JTextArea();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        btn_print = new javax.swing.JButton();
        txt_receivedfrom = new javax.swing.JTextField();
        lbl_receivedfrom1 = new javax.swing.JLabel();
        lbl_receivedfrom2 = new javax.swing.JLabel();
        txt_rollno = new javax.swing.JTextField();
        txt_bankname = new javax.swing.JTextField();

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

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 1030));

        panelparent.setBackground(new java.awt.Color(51, 51, 51));
        panelparent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_receiptno.setBackground(new java.awt.Color(255, 255, 255));
        lbl_receiptno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_receiptno.setForeground(new java.awt.Color(255, 255, 255));
        lbl_receiptno.setText("Receipt no :");
        panelparent.add(lbl_receiptno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        lbl_paymentmode.setBackground(new java.awt.Color(255, 255, 255));
        lbl_paymentmode.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_paymentmode.setForeground(new java.awt.Color(255, 255, 255));
        lbl_paymentmode.setText("Mode of Payment :");
        panelparent.add(lbl_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        lbl_ddno.setBackground(new java.awt.Color(255, 255, 255));
        lbl_ddno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_ddno.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ddno.setText("DD no :");
        panelparent.add(lbl_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        lbl_chequeno.setBackground(new java.awt.Color(255, 255, 255));
        lbl_chequeno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_chequeno.setForeground(new java.awt.Color(255, 255, 255));
        lbl_chequeno.setText("Cheque no :");
        panelparent.add(lbl_chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        lbl_bankname.setBackground(new java.awt.Color(255, 255, 255));
        lbl_bankname.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_bankname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_bankname.setText("Bank Name :");
        panelparent.add(lbl_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        lbl_date.setBackground(new java.awt.Color(255, 255, 255));
        lbl_date.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_date.setForeground(new java.awt.Color(255, 255, 255));
        lbl_date.setText("Date :");
        panelparent.add(lbl_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 60, -1, -1));

        txt_receiptno.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_receiptno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receiptnoActionPerformed(evt);
            }
        });
        panelparent.add(txt_receiptno, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 160, 30));

        txt_ddno.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_ddno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ddnoActionPerformed(evt);
            }
        });
        panelparent.add(txt_ddno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 30));

        txt_chequeno.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_chequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_chequenoActionPerformed(evt);
            }
        });
        panelparent.add(txt_chequeno, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 150, 30));

        combo_paymentmode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DD", "Cheque", "Cash", "Card" }));
        combo_paymentmode.setSelectedIndex(2);
        combo_paymentmode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_paymentmodeActionPerformed(evt);
            }
        });
        panelparent.add(combo_paymentmode, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 90, -1));
        panelparent.add(datechooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 60, 190, 40));

        panelchild.setBackground(new java.awt.Color(51, 51, 51));
        panelchild.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("The following payment in the university office for the year   :");
        panelchild.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("To");
        panelchild.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 80, -1, -1));

        txt_year2.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_year2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year2ActionPerformed(evt);
            }
        });
        panelchild.add(txt_year2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 80, 100, 30));

        lbl_rollno.setBackground(new java.awt.Color(255, 255, 255));
        lbl_rollno.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_rollno.setForeground(new java.awt.Color(255, 255, 255));
        lbl_rollno.setText("ID no. :");
        panelchild.add(lbl_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 150, -1, -1));

        txt_totalinwords.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_totalinwords.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalinwordsActionPerformed(evt);
            }
        });
        panelchild.add(txt_totalinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 530, 460, 40));

        combocourse.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        combocourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combocourseActionPerformed(evt);
            }
        });
        panelchild.add(combocourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 120, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Amount :");
        panelchild.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 240, -1, -1));
        panelchild.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 430, 220, 0));
        panelchild.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 1150, 10));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Course :");
        panelchild.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Remarks :");
        panelchild.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 700, -1, -1));

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Head :");
        panelchild.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, -1, -1));

        txt_amount.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_amountActionPerformed(evt);
            }
        });
        panelchild.add(txt_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 280, 160, -1));

        txt_total.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        panelchild.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 160, 30));

        txt_year1.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_year1ActionPerformed(evt);
            }
        });
        panelchild.add(txt_year1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 100, 30));

        txt_cgst.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_cgst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cgstActionPerformed(evt);
            }
        });
        panelchild.add(txt_cgst, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 370, 160, 30));
        panelchild.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 590, 270, 10));
        panelchild.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 1150, 10));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Sr No :");
        panelchild.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, -1, -1));

        txt_coursename.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_coursename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coursenameActionPerformed(evt);
            }
        });
        panelchild.add(txt_coursename, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 270, 260, 30));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Receiver Signature :");
        panelchild.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 610, -1, -1));

        txt_remark.setColumns(20);
        txt_remark.setRows(5);
        jScrollPane1.setViewportView(txt_remark);

        panelchild.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 670, 350, -1));
        panelchild.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 430, 270, 10));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Total In Words :");
        panelchild.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, -1));

        btn_print.setFont(new java.awt.Font("Dialog", 1, 17)); // NOI18N
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        panelchild.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 720, -1, -1));

        txt_receivedfrom.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_receivedfrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_receivedfromActionPerformed(evt);
            }
        });
        panelchild.add(txt_receivedfrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 340, 30));

        lbl_receivedfrom1.setBackground(new java.awt.Color(255, 255, 255));
        lbl_receivedfrom1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_receivedfrom1.setForeground(new java.awt.Color(255, 255, 255));
        lbl_receivedfrom1.setText("Received From :");
        panelchild.add(lbl_receivedfrom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        lbl_receivedfrom2.setBackground(new java.awt.Color(255, 255, 255));
        lbl_receivedfrom2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbl_receivedfrom2.setForeground(new java.awt.Color(255, 255, 255));
        lbl_receivedfrom2.setText("Vat   9%");
        panelchild.add(lbl_receivedfrom2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 360, -1, -1));

        txt_rollno.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rollnoActionPerformed(evt);
            }
        });
        panelchild.add(txt_rollno, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 150, 150, 30));

        panelparent.add(panelchild, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 1300, 800));

        txt_bankname.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        txt_bankname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_banknameActionPerformed(evt);
            }
        });
        panelparent.add(txt_bankname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 150, 30));

        getContentPane().add(panelparent, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 1300, 1040));

        pack();
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

    private void btnviewallrecordMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallrecordMouseEntered
       Color clr=new Color(0,153,153);
      panelviewallrecord.setBackground(clr);
    }//GEN-LAST:event_btnviewallrecordMouseEntered

    private void btnviewallrecordMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnviewallrecordMouseExited
       Color clr=new Color(0,51,51);
      panelviewallrecord.setBackground(clr);
    }//GEN-LAST:event_btnviewallrecordMouseExited

    private void btnhome31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome31MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome31MouseEntered

    private void btnhome31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhome31MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnhome31MouseExited

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

    private void txt_rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rollnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rollnoActionPerformed

    private void txt_receiptnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receiptnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receiptnoActionPerformed

    private void txt_ddnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ddnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ddnoActionPerformed

    private void txt_chequenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_chequenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_chequenoActionPerformed

    private void combo_paymentmodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_paymentmodeActionPerformed
       if(combo_paymentmode.getSelectedIndex()==0){
           lbl_ddno.setVisible(true);
           txt_ddno.setVisible(true);
           lbl_chequeno.setVisible(false);
           txt_chequeno.setVisible(false);
           lbl_bankname.setVisible(true);
           txt_bankname.setVisible(true);
       }
       if(combo_paymentmode.getSelectedIndex()==1){
           lbl_ddno.setVisible(false);
           txt_ddno.setVisible(false);
           lbl_chequeno.setVisible(true);
           txt_chequeno.setVisible(true);
           lbl_bankname.setVisible(true);
           txt_bankname.setVisible(true);
       }
       if(combo_paymentmode.getSelectedIndex()==2){
           lbl_ddno.setVisible(false);
           txt_ddno.setVisible(false);
           lbl_chequeno.setVisible(false);
           txt_chequeno.setVisible(false);
           lbl_bankname.setVisible(false);
           txt_bankname.setVisible(false);
       }
       if(combo_paymentmode.getSelectedIndex()==3){
           lbl_ddno.setVisible(false);
           txt_ddno.setVisible(false);
           lbl_chequeno.setVisible(false);
           txt_chequeno.setVisible(false);
           lbl_bankname.setVisible(true);
           txt_bankname.setVisible(true);
       }
    }//GEN-LAST:event_combo_paymentmodeActionPerformed

    private void txt_year2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year2ActionPerformed

    private void txt_totalinwordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalinwordsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalinwordsActionPerformed

    private void combocourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combocourseActionPerformed
       txt_coursename.setText(combocourse.getSelectedItem().toString());
    }//GEN-LAST:event_combocourseActionPerformed

    private void txt_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_amountActionPerformed
        Float amnt= Float.parseFloat(txt_amount.getText());
        float cgst=(float)(amnt*0.09);
        txt_cgst.setText(Float.toString(cgst));
        float total=amnt+cgst;
        txt_total.setText(Float.toString(total));
        
        txt_totalinwords.setText(NumberToWordsConverter.convert((int)total) + " only");
    }//GEN-LAST:event_txt_amountActionPerformed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_year1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_year1ActionPerformed

    private void txt_cgstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cgstActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cgstActionPerformed

    private void txt_coursenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coursenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coursenameActionPerformed

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
       if(validation()==true){
           
           String result=insertData();
           if(result.equals("Success")){
                JOptionPane.showMessageDialog(this, "record inserted successfully");
                printreceipt p= new  printreceipt();
                p.setVisible(true);
                this.dispose();
           }
           else{
               JOptionPane.showMessageDialog(this, "record inserted successfully");
                printreceipt p= new  printreceipt();
                p.setVisible(true);
                this.dispose();
           }
          
           
       }
    }//GEN-LAST:event_btn_printActionPerformed

    private void txt_receivedfromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_receivedfromActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_receivedfromActionPerformed

    private void txt_banknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_banknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_banknameActionPerformed

    private void btnhomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhomeMouseClicked
        Home h=new Home();
        h.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnhomeMouseClicked

    private void btnsearchrecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsearchrecordMouseClicked
        Searchrecord s=new Searchrecord();
        s.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnsearchrecordMouseClicked

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
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFees.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFees().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_print;
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
    private javax.swing.JComboBox combo_paymentmode;
    private javax.swing.JComboBox combocourse;
    private com.toedter.calendar.JDateChooser datechooser;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbl_bankname;
    private javax.swing.JLabel lbl_chequeno;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_ddno;
    private javax.swing.JLabel lbl_paymentmode;
    private javax.swing.JLabel lbl_receiptno;
    private javax.swing.JLabel lbl_receivedfrom1;
    private javax.swing.JLabel lbl_receivedfrom2;
    private javax.swing.JLabel lbl_rollno;
    private javax.swing.JPanel panelback;
    private javax.swing.JPanel panelchild;
    private javax.swing.JPanel panelcourselist;
    private javax.swing.JPanel paneleditcourse;
    private javax.swing.JPanel panelhome;
    private javax.swing.JPanel panelhome31;
    private javax.swing.JPanel panelhome33;
    private javax.swing.JPanel panelhome35;
    private javax.swing.JPanel panelhome37;
    private javax.swing.JPanel panelhome39;
    private javax.swing.JPanel panellogout;
    private javax.swing.JPanel panelparent;
    private javax.swing.JPanel panelsearchrecord;
    private javax.swing.JPanel panelsidebar;
    private javax.swing.JPanel panelviewallrecord;
    private javax.swing.JTextField txt_amount;
    private javax.swing.JTextField txt_bankname;
    private javax.swing.JTextField txt_cgst;
    private javax.swing.JTextField txt_chequeno;
    private javax.swing.JTextField txt_coursename;
    private javax.swing.JTextField txt_ddno;
    private javax.swing.JTextField txt_receiptno;
    private javax.swing.JTextField txt_receivedfrom;
    private javax.swing.JTextArea txt_remark;
    private javax.swing.JTextField txt_rollno;
    private javax.swing.JTextField txt_total;
    private javax.swing.JTextField txt_totalinwords;
    private javax.swing.JTextField txt_year1;
    private javax.swing.JTextField txt_year2;
    // End of variables declaration//GEN-END:variables
}
