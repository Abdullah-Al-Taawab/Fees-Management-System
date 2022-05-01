/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fees_management_system;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static org.apache.poi.hemf.hemfplus.record.HemfPlusRecordType.object;
import static org.apache.poi.hssf.usermodel.HeaderFooter.file;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Asus
 */
public class GenerateReport extends javax.swing.JFrame {
        DefaultTableModel model;
    /**
     * Creates new form GenerateReport
     */
    public GenerateReport() {
        initComponents();
        fillcombobox();
    }
    
    
    public void fillcombobox(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees_management", "root", "1234");
           PreparedStatement pst = con.prepareStatement("select CNAME from course");
           ResultSet rs=pst.executeQuery();
           while(rs.next()){
               combo_coursedetails.addItem(rs.getString("CNAME"));
               
           }
           }
           
        
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void setRecordstotable(){
        String cname=combo_coursedetails.getSelectedItem().toString();
        SimpleDateFormat dateformat=new SimpleDateFormat("YYYY-MM-dd");
        String fromdate=dateformat.format(datechooser_from.getDate());
        String todate=dateformat.format(datechooser_to.getDate());
        
        Float amounttotal=0.0f;
        try{
            Connection con=DBconnection.getconnection();
            PreparedStatement pst = con.prepareStatement("select * from fees_details where date between ? and ? and course_name=?");
            pst.setString(1, fromdate);
            pst.setString(2, todate);
            pst.setString(3, cname);
            
            ResultSet rs=pst.executeQuery();
        
        while(rs.next()){
            String receiptno=rs.getString("reciept_no");
            String rollNo=rs.getString("roll_no");
            String studentname=rs.getString("student_name");
             String coursename=rs.getString("course_name");
             float amount=rs.getFloat("total_amount");
             String remark=rs.getString("remark");
             amounttotal=amounttotal+amount;
            
            Object[] obj={receiptno,rollNo,studentname,coursename,amount,remark};
            model=(DefaultTableModel)tbl_record.getModel();
            model.addRow(obj);
        }
        lbl_course.setText(cname);
        lbl_totalamount.setText(amounttotal.toString());
        lbl_totalamountinwords.setText(NumberToWordsConverter.convert(amounttotal.intValue()));
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    public void cleartable(){
         DefaultTableModel model=(DefaultTableModel)tbl_record.getModel();
         model.setRowCount(1);
     }
    
    public void exporttoexcel(){
        XSSFWorkbook wb=new XSSFWorkbook();
        XSSFSheet ws=wb.createSheet();
        DefaultTableModel model=(DefaultTableModel)tbl_record.getModel();
        TreeMap<String,Object[]>map=new TreeMap<>();
        map.put("0",new Object[]{model.getColumnName(0),model.getColumnName(1),model.getColumnName(2),model.getColumnName(3),model.getColumnName(4),model.getColumnName(5)});
        for(int i=1; i< model.getRowCount();i++){
            map.put(Integer.toString(i), new Object[]{model.getValueAt(i, 0),model.getValueAt(i,1),
            model.getValueAt(i,2),model.getValueAt(i,3),model.getValueAt(i,4),model.getValueAt(i,5)});
            
        }
        Set<String> id=map.keySet();
        XSSFRow fRow;
        int rowId=0;
        
        for(String key: id){
            fRow=ws.createRow(rowId++);
            Object[] value=map.get(key);
            int cellId=0;
            for(Object object : value){
                XSSFCell cell=fRow.createCell(cellId++);
                cell.setCellValue(object.toString());
            }
            
        }
        try{
        FileOutputStream fos=new FileOutputStream(new File(txt_filepath.getText()));
        wb.write(fos);
        fos.close();
        JOptionPane.showMessageDialog(this, "file exported successfully : " + txt_filepath.getText());
        }
        catch(Exception e){
            e.printStackTrace();
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
        jLabel1 = new javax.swing.JLabel();
        combo_coursedetails = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datechooser_from = new com.toedter.calendar.JDateChooser();
        datechooser_to = new com.toedter.calendar.JDateChooser();
        btn_browse = new javax.swing.JButton();
        btn_print = new javax.swing.JButton();
        txt_filepath = new javax.swing.JTextField();
        btn_submit = new javax.swing.JButton();
        btn_browse1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_record = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbl_totalamountinwords = new javax.swing.JLabel();
        lbl_course = new javax.swing.JLabel();
        lbl_totalamount = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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

        getContentPane().add(panelsidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 1030));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("To date");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        combo_coursedetails.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel1.add(combo_coursedetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 290, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Select Course :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Select Date :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("from date");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, -1, -1));
        jPanel1.add(datechooser_from, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 170, -1));
        jPanel1.add(datechooser_to, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 180, -1));

        btn_browse.setBackground(new java.awt.Color(51, 51, 51));
        btn_browse.setForeground(new java.awt.Color(255, 255, 255));
        btn_browse.setText("Export to Excel");
        btn_browse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browseActionPerformed(evt);
            }
        });
        jPanel1.add(btn_browse, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 140, -1));

        btn_print.setBackground(new java.awt.Color(51, 51, 51));
        btn_print.setForeground(new java.awt.Color(255, 255, 255));
        btn_print.setText("Print");
        btn_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_printActionPerformed(evt);
            }
        });
        jPanel1.add(btn_print, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 120, -1));

        txt_filepath.setText("jTextField1");
        jPanel1.add(txt_filepath, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 370, -1));

        btn_submit.setBackground(new java.awt.Color(51, 51, 51));
        btn_submit.setForeground(new java.awt.Color(255, 255, 255));
        btn_submit.setText("Submit");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });
        jPanel1.add(btn_submit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 120, -1));

        btn_browse1.setBackground(new java.awt.Color(51, 51, 51));
        btn_browse1.setForeground(new java.awt.Color(255, 255, 255));
        btn_browse1.setText("Browse");
        btn_browse1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_browse1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn_browse1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 120, -1));

        tbl_record.setBackground(new java.awt.Color(51, 51, 51));
        tbl_record.setForeground(new java.awt.Color(255, 255, 255));
        tbl_record.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Receipt No", "ID no", "Student Name", "Course", "Amount", "Remark"
            }
        ));
        jScrollPane1.setViewportView(tbl_record);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 1240, 590));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_totalamountinwords.setBackground(new java.awt.Color(51, 51, 51));
        lbl_totalamountinwords.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(lbl_totalamountinwords, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 410, 20));

        lbl_course.setBackground(new java.awt.Color(51, 51, 51));
        lbl_course.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(lbl_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 250, 20));

        lbl_totalamount.setBackground(new java.awt.Color(51, 51, 51));
        lbl_totalamount.setForeground(new java.awt.Color(51, 51, 51));
        jPanel2.add(lbl_totalamount, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 250, 20));

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Course Selected :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 130, 20));

        jLabel9.setBackground(new java.awt.Color(51, 51, 51));
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Total Amount Collected :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 150, 20));

        jLabel10.setBackground(new java.awt.Color(51, 51, 51));
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Total Amount in Words :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 150, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 30, 460, 270));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 1380, 1000));

        setSize(new java.awt.Dimension(1888, 1047));
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

    private void btneditcourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditcourseMouseClicked
        Editcourse e=new Editcourse();
        e.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btneditcourseMouseClicked

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

    private void btn_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_printActionPerformed
       SimpleDateFormat Date_Format = new SimpleDateFormat("YYYY-MM-dd"); 
        String datefrom=  Date_Format.format(datechooser_from.getDate());
      String dateto=  Date_Format.format(datechooser_to.getDate());
       
        MessageFormat header=new MessageFormat("Report From "+datefrom+" To " +dateto);
        MessageFormat footer=new MessageFormat("page{0,number,integer}");
        try {
            tbl_record.print(JTable.PrintMode.FIT_WIDTH, header, footer);
            
        } catch (Exception e) {
            e.getMessage();
        } 
    }//GEN-LAST:event_btn_printActionPerformed

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        cleartable();
        setRecordstotable();
    }//GEN-LAST:event_btn_submitActionPerformed

    private void btn_browse1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browse1ActionPerformed
       JFileChooser filechooser= new JFileChooser();
       filechooser.showOpenDialog(this);
       SimpleDateFormat dateformat=new  SimpleDateFormat("YYYY-MM-dd");
       String date=dateformat.format(new Date());
       try{
           File f=filechooser.getSelectedFile();
           String path=f.getAbsolutePath();
           path=path+""+date+".xlsx";
           txt_filepath.setText(path);
           
           
           
           
       }
       catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_btn_browse1ActionPerformed

    private void btn_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_browseActionPerformed
        exporttoexcel();
    }//GEN-LAST:event_btn_browseActionPerformed

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
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GenerateReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerateReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_browse;
    private javax.swing.JButton btn_browse1;
    private javax.swing.JButton btn_print;
    private javax.swing.JButton btn_submit;
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
    private javax.swing.JComboBox combo_coursedetails;
    private com.toedter.calendar.JDateChooser datechooser_from;
    private com.toedter.calendar.JDateChooser datechooser_to;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_course;
    private javax.swing.JLabel lbl_totalamount;
    private javax.swing.JLabel lbl_totalamountinwords;
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
    private javax.swing.JTable tbl_record;
    private javax.swing.JTextField txt_filepath;
    // End of variables declaration//GEN-END:variables
}
