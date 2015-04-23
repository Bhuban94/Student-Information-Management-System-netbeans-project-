/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author BHUBAN
 */
public class PHP extends javax.swing.JFrame {
    String PID;
    String C[]=new String[5];
    String B[]=new String[5];
    String N[]=new String[5];
    /**
     * Creates new form PHP
     */
    public PHP() {
        initComponents();
    }
    public PHP(String pID) {
        initComponents();
        PID=pID;
        jPanelLeft.setVisible(false);
        jPanelLeft.setBorder(BorderFactory.createTitledBorder("Personal Details"));
        jPanelRight.setBorder(BorderFactory.createTitledBorder("Course Details"));
        jPanelRight.setVisible(false);
        newAssignment.setBorder(BorderFactory.createTitledBorder("New Assignment"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="select * from professor where name='"+PID+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            int i=0;
            while(rs.next())
            {
                C[0]=rs.getString("course1");
                N[0]=rs.getString("course1name");
                B[0]=rs.getString("batch1");
                C[1]=rs.getString("course2");
                N[1]=rs.getString("course2name");
                B[1]=rs.getString("batch2");
                C[2]=rs.getString("course3");
                N[2]=rs.getString("course3name");
                B[2]=rs.getString("batch3");
                C[3]=rs.getString("course4");
                N[3]=rs.getString("course4name");
                B[3]=rs.getString("batch4");
                C[4]=rs.getString("course5");
                N[4]=rs.getString("course5name");
                B[4]=rs.getString("batch5");
                System.out.println(C[0]+" "+N[0]+" "+B[0]);
            }
            jTabbedPane2.setTitleAt(0,N[0]+"("+B[0]+")");
            jTabbedPane3.setTitleAt(0,N[0]+"("+B[0]+")");
            jTabbedPane5.setTitleAt(0,N[0]+"("+B[0]+")");
            jTabbedPane2.setTitleAt(1,N[1]+"("+B[1]+")");
            jTabbedPane3.setTitleAt(1,N[1]+"("+B[1]+")");
            jTabbedPane5.setTitleAt(1,N[1]+"("+B[1]+")");
            jTabbedPane2.setTitleAt(2,N[2]+"("+B[2]+")");
            jTabbedPane3.setTitleAt(2,N[2]+"("+B[2]+")");
            jTabbedPane5.setTitleAt(2,N[2]+"("+B[2]+")");
            jTabbedPane2.setTitleAt(3,N[3]+"("+B[3]+")");
            jTabbedPane3.setTitleAt(3,N[3]+"("+B[3]+")");
            jTabbedPane5.setTitleAt(3,N[3]+"("+B[3]+")");
            jTabbedPane2.setTitleAt(4,N[4]+"("+B[4]+")");
            jTabbedPane3.setTitleAt(4,N[4]+"("+B[4]+")");
            jTabbedPane5.setTitleAt(4,N[4]+"("+B[4]+")");
            query="select * from assignment where `courseid`='"+C[0]+"' and `professor`='"+PID+"' and `batch`='"+B[0]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            int row=rs.getRow();
            rs.beforeFirst();
            if(row==0)
                jScrollPane1.setVisible(false);
            else
            {
                String colName[]={"Assignemnt Details","Dead Line"};
                Object obj[][]=new Object[row][2];
                i=0;
                while(rs.next())
                {
                    obj[i][0]=rs.getString("details");
                    obj[i++][1]=rs.getString("deadline");
                    System.out.println(obj[i-1][0]+" "+obj[i-1][1]);
                }
                UACT1.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[1]+"' and `professor`='"+PID+"' and `batch`='"+B[1]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            rs.beforeFirst();
            if(row==0)
                jScrollPane2.setVisible(false);
            else
            {
                String colName[]={"Assignemnt Details","Dead Line"};
                Object obj[][]=new Object[row][2];
                i=0;
                while(rs.next())
                {
                    obj[i][0]=rs.getString("details");
                    obj[i++][1]=rs.getString("deadline");
                    System.out.println(obj[i-1][0]+" "+obj[i-1][1]);
                }
                UACT2.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[2]+"' and `professor`='"+PID+"' and `batch`='"+B[2]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            rs.beforeFirst();
            if(row==0)
                jScrollPane3.setVisible(false);
            else
            {
                String colName[]={"Assignemnt Details","Dead Line"};
                Object obj[][]=new Object[row][2];
                i=0;
                while(rs.next())
                {
                    obj[i][0]=rs.getString("details");
                    obj[i++][1]=rs.getString("deadline");
                    System.out.println(obj[i-1][0]+" "+obj[i-1][1]);
                }
                UACT3.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[3]+"' and `professor`='"+PID+"' and `batch`='"+B[3]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            rs.beforeFirst();
            if(row==0)
                jScrollPane4.setVisible(false);
            else
            {
                String colName[]={"Assignemnt Details","Dead Line"};
                Object obj[][]=new Object[row][2];
                i=0;
                while(rs.next())
                {
                    obj[i][0]=rs.getString("details");
                    obj[i++][1]=rs.getString("deadline");
                    System.out.println(obj[i-1][0]+" "+obj[i-1][1]);
                }
                UACT4.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[4]+"' and `professor`='"+PID+"' and `batch`='"+B[4]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            rs.beforeFirst();
            if(row==0)
                jScrollPane5.setVisible(false);
            else
            {
                String colName[]={"Assignemnt Details","Dead Line"};
                Object obj[][]=new Object[row][2];
                i=0;
                while(rs.next())
                {
                    obj[i][0]=rs.getString("details");
                    obj[i++][1]=rs.getString("deadline");
                    System.out.println(obj[i-1][0]+" "+obj[i-1][1]);
                }
                UACT5.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from `preregistration` where advisor='"+PID+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData();
            rs.last();
            int nRows=rs.getRow();
            rs.beforeFirst();
            int nCols=rsmd.getColumnCount();
            String[]colnm=new String[nCols];
            Object obj[][]=new Object[nRows][nCols];
            for(i=0;i<nCols;++i)
            {
                colnm[i]=rsmd.getColumnName(i+1);
            }
            i=0;
            while(rs.next())
            {
                for(int j=0;j<nCols;++j)
                {
                    obj[i][j]=rs.getString(j+1);
                    System.out.print(obj[i][j]+" ");
                }
                i++;
                System.out.println();
            }
            TableConfirmReg.setModel(new javax.swing.table.DefaultTableModel(obj,colnm));
            if(nRows>0)
                ConfirmReg.setVisible(true);
            query="select roll from `student` where (course1='"+C[0]+"' or course2='"+C[0]+"' or course3='"+C[0]+"' or course4='"+C[0]+"' or course5='"+C[0]+"') and batch='"+B[0]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            nRows=rs.getRow();
            rs.beforeFirst();
            if(nRows==0)
            {
                AC1.setVisible(false);
                GC1.setVisible(false);
            }
            else
            {
                System.out.println("hello");
                String colNm1[]={"Roll","Add present","Add Absent"};
                Object obj2[][]=new Object[nRows][3];
                String colNmG1[]={"Roll","Grade"};
                Object objG2[][]=new Object[nRows][2];
                i=0;
                while(rs.next())
                {
                    obj2[i][0]=rs.getString("roll");
                    obj2[i][1]=1;
                    obj2[i][2]=0;
                    objG2[i][0]=rs.getString("roll");
                    objG2[i][1]='A';
                    i++;
                }
                TableAtt1.setModel(new javax.swing.table.DefaultTableModel(obj2,colNm1));
                TableGra1.setModel(new javax.swing.table.DefaultTableModel(objG2,colNmG1));
            }
            query="select roll from `student` where (course1='"+C[1]+"' or course2='"+C[1]+"' or course3='"+C[1]+"' or course4='"+C[1]+"' or course5='"+C[1]+"') and batch='"+B[1]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            nRows=rs.getRow();
            rs.beforeFirst();
            if(nRows==0)
            {
                AC2.setVisible(false);
                GC2.setVisible(false);
            }
            else
            {
                String colNm2[]={"Roll","Add present","Add Absent"};
                Object obj3[][]=new Object[nRows][3];
                String colNmG2[]={"Roll","Grade"};
                Object objG3[][]=new Object[nRows][2];
                while(rs.next())
                {
                    obj3[i][0]=rs.getString("roll");
                    obj3[i][1]=1;
                    obj3[i][2]=0;
                    objG3[i][0]=rs.getString("roll");
                    objG3[i][1]='A';
                }
                TableAtt2.setModel(new javax.swing.table.DefaultTableModel(obj3,colNm2));
                TableGra2.setModel(new javax.swing.table.DefaultTableModel(objG3,colNmG2));
            }
            query="select roll from `student` where (course1='"+C[2]+"' or course2='"+C[2]+"' or course3='"+C[2]+"' or course4='"+C[2]+"' or course5='"+C[2]+"') and batch='"+B[2]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            nRows=rs.getRow();
            rs.beforeFirst();
            if(nRows==0)
            {
                AC3.setVisible(false);
                GC3.setVisible(false);
            }
            else
            {
                String colNm3[]={"Roll","Add present","Add Absent"};
                Object obj4[][]=new Object[nRows][3];
                String colNmG3[]={"Roll","Grade"};
                Object objG4[][]=new Object[nRows][2];
                i=0;
                while(rs.next())
                {
                    obj4[i][0]=rs.getString("roll");
                    obj4[i][1]=1;
                    obj4[i][2]=0;
                    objG4[i][0]=rs.getString("roll");
                    objG4[i][1]='A';
                    i++;
                }
                TableAtt3.setModel(new javax.swing.table.DefaultTableModel(obj4,colNm3));
                TableGra3.setModel(new javax.swing.table.DefaultTableModel(objG4,colNmG3));
            }
            query="select roll from `student` where (course1='"+C[3]+"' or course2='"+C[3]+"' or course3='"+C[3]+"' or course4='"+C[3]+"' or course5='"+C[3]+"') and batch='"+B[3]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            nRows=rs.getRow();
            rs.beforeFirst();
            if(nRows==0)
            {
                AC4.setVisible(false);
                GC4.setVisible(false);
            }
            else
            {
                String colNm4[]={"Roll","Add present","Add Absent"};
                Object obj5[][]=new Object[nRows][3];
                String colNmG4[]={"Roll","Grade"};
                Object objG5[][]=new Object[nRows][2];
                i=0;
                while(rs.next())
                {
                    obj5[i][0]=rs.getString("roll");
                    obj5[i][1]=1;
                    obj5[i][2]=0;
                    objG5[i][0]=rs.getString("roll");
                    objG5[i][1]='A';
                    i++;
                }
                TableAtt4.setModel(new javax.swing.table.DefaultTableModel(obj5,colNm4));
                TableGra4.setModel(new javax.swing.table.DefaultTableModel(objG5,colNmG4));
            }
            query="select roll from `student` where (course1='"+C[4]+"' or course2='"+C[4]+"' or course3='"+C[4]+"' or course4='"+C[4]+"' or course5='"+C[4]+"') and batch='"+B[4]+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            nRows=rs.getRow();
            rs.beforeFirst();
            if(nRows==0)
            {
                AC5.setVisible(false);
                GC5.setVisible(false);
            }
            else
            {
                String colNm5[]={"Roll","Add present","Add Absent"};
                Object obj6[][]=new Object[nRows][3];
                String colNmG5[]={"Roll","Grade"};
                Object objG6[][]=new Object[nRows][2];
                i=0;
                while(rs.next())
                {
                    obj6[i][0]=rs.getString("sid");
                    obj6[i][1]=1;
                    obj6[i][2]=0;
                    objG6[i][0]=rs.getString("roll");
                    objG6[i][1]='A';
                    i++;
                }
                TableAtt5.setModel(new javax.swing.table.DefaultTableModel(obj6,colNm5));
                TableGra5.setModel(new javax.swing.table.DefaultTableModel(objG6,colNmG5));
            }
        }
        catch(Exception e)
        {
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        Student_details = new javax.swing.JPanel();
        LRoll = new javax.swing.JLabel();
        rollInput = new javax.swing.JTextField();
        bShow = new javax.swing.JButton();
        jPanelLeft = new javax.swing.JPanel();
        LHostel = new javax.swing.JLabel();
        branch = new javax.swing.JLabel();
        LMob = new javax.swing.JLabel();
        batch = new javax.swing.JLabel();
        LSemester = new javax.swing.JLabel();
        semester = new javax.swing.JLabel();
        LRoom = new javax.swing.JLabel();
        room = new javax.swing.JLabel();
        LFather = new javax.swing.JLabel();
        hostel = new javax.swing.JLabel();
        Lmother = new javax.swing.JLabel();
        mob = new javax.swing.JLabel();
        father = new javax.swing.JLabel();
        LName = new javax.swing.JLabel();
        LParentContact = new javax.swing.JLabel();
        mother = new javax.swing.JLabel();
        parent_mob = new javax.swing.JLabel();
        LBranch = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        LBatch = new javax.swing.JLabel();
        jPanelRight = new javax.swing.JPanel();
        L_SD_course1 = new javax.swing.JLabel();
        L_SD_course2 = new javax.swing.JLabel();
        L_SD_course3 = new javax.swing.JLabel();
        L_SD_course4 = new javax.swing.JLabel();
        L_SD_course5 = new javax.swing.JLabel();
        SD_course1 = new javax.swing.JLabel();
        SD_course2 = new javax.swing.JLabel();
        SD_course3 = new javax.swing.JLabel();
        SD_course4 = new javax.swing.JLabel();
        SD_course5 = new javax.swing.JLabel();
        Registration = new javax.swing.JPanel();
        ConfirmReg = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TableConfirmReg = new javax.swing.JTable();
        bConfirmReg = new javax.swing.JButton();
        Attendance_upload = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        UAtt_course1 = new javax.swing.JPanel();
        AC1 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TableAtt1 = new javax.swing.JTable();
        bSubmitAtt1 = new javax.swing.JButton();
        UAtt_course2 = new javax.swing.JPanel();
        AC2 = new javax.swing.JPanel();
        bSubmitAtt2 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        TableAtt2 = new javax.swing.JTable();
        UAtt_course3 = new javax.swing.JPanel();
        AC3 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TableAtt3 = new javax.swing.JTable();
        bSubmitAtt3 = new javax.swing.JButton();
        UAtt_course4 = new javax.swing.JPanel();
        AC4 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TableAtt4 = new javax.swing.JTable();
        bSubmitAtt4 = new javax.swing.JButton();
        UAtt_course5 = new javax.swing.JPanel();
        AC5 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TableAtt5 = new javax.swing.JTable();
        bSubmitAtt5 = new javax.swing.JButton();
        Assignment_upload = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        UAss_course1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        UACT1 = new javax.swing.JTable();
        newAssignment = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        ADescription = new javax.swing.JTextArea();
        DDescription = new javax.swing.JTextField();
        LADescription = new javax.swing.JLabel();
        LDDescription = new javax.swing.JLabel();
        bConfirmAss = new javax.swing.JButton();
        UAss_course2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        UACT2 = new javax.swing.JTable();
        UAss_course3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        UACT3 = new javax.swing.JTable();
        UAss_course4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        UACT4 = new javax.swing.JTable();
        UAss_course5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        UACT5 = new javax.swing.JTable();
        Grade_upload = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        UGra_course1 = new javax.swing.JPanel();
        GC1 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TableGra1 = new javax.swing.JTable();
        bSubmitGra1 = new javax.swing.JButton();
        UGra_course2 = new javax.swing.JPanel();
        GC2 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TableGra2 = new javax.swing.JTable();
        bSubmitGra2 = new javax.swing.JButton();
        UGra_course3 = new javax.swing.JPanel();
        GC3 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        TableGra3 = new javax.swing.JTable();
        bSubmitGra3 = new javax.swing.JButton();
        UGra_course4 = new javax.swing.JPanel();
        GC4 = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
        TableGra4 = new javax.swing.JTable();
        bSubmitGra4 = new javax.swing.JButton();
        UGra_course5 = new javax.swing.JPanel();
        GC5 = new javax.swing.JPanel();
        jScrollPane18 = new javax.swing.JScrollPane();
        TableGra5 = new javax.swing.JTable();
        bSubmitGra5 = new javax.swing.JButton();
        Settings = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        ChangePass = new javax.swing.JPanel();
        Lnewpass = new javax.swing.JLabel();
        Lconpass = new javax.swing.JLabel();
        newPass = new javax.swing.JPasswordField();
        conPass = new javax.swing.JPasswordField();
        bChangepass = new javax.swing.JButton();
        Lcurpass = new javax.swing.JLabel();
        curPass = new javax.swing.JPasswordField();
        Logout = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LRoll.setText("Student ID: ");

        bShow.setText("Show");
        bShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bShowActionPerformed(evt);
            }
        });

        LHostel.setText("Hostel: ");

        branch.setText("branch");

        LMob.setText("Mob: ");

        batch.setText("batch");

        LSemester.setText("Semester: ");

        semester.setText("semester");

        LRoom.setText("Room: ");

        room.setText("room");

        LFather.setText("Father's Name: ");

        hostel.setText("hostel");

        Lmother.setText("Mother's name");

        mob.setText("mob");

        father.setText("father");

        LName.setText("Name: ");

        LParentContact.setText("Parent's Contact No:");

        mother.setText("mother");

        parent_mob.setText("parent mob");

        LBranch.setText("Branch: ");

        name.setText("name");

        LBatch.setText("Batch: ");

        javax.swing.GroupLayout jPanelLeftLayout = new javax.swing.GroupLayout(jPanelLeft);
        jPanelLeft.setLayout(jPanelLeftLayout);
        jPanelLeftLayout.setHorizontalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 193, Short.MAX_VALUE)
            .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLeftLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelLeftLayout.createSequentialGroup()
                            .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LName)
                                .addComponent(Lmother)
                                .addComponent(LFather)
                                .addComponent(LMob)
                                .addComponent(LHostel)
                                .addComponent(LRoom)
                                .addComponent(LBatch)
                                .addComponent(LBranch)
                                .addComponent(LSemester))
                            .addGap(40, 40, 40)
                            .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(name)
                                .addComponent(branch)
                                .addComponent(batch)
                                .addComponent(semester)
                                .addComponent(room)
                                .addComponent(hostel)
                                .addComponent(mob)
                                .addComponent(father)
                                .addComponent(mother)))
                        .addGroup(jPanelLeftLayout.createSequentialGroup()
                            .addComponent(LParentContact)
                            .addGap(18, 18, 18)
                            .addComponent(parent_mob)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanelLeftLayout.setVerticalGroup(
            jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
            .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelLeftLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LName)
                        .addComponent(name))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LBranch)
                        .addComponent(branch))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LBatch)
                        .addComponent(batch))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LSemester)
                        .addComponent(semester))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LRoom)
                        .addComponent(room))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LHostel)
                        .addComponent(hostel))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LMob)
                        .addComponent(mob))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LFather)
                        .addComponent(father))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Lmother)
                        .addComponent(mother))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanelLeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(LParentContact)
                        .addComponent(parent_mob))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        L_SD_course1.setText("Course 1:");

        L_SD_course2.setText("Course 2:");

        L_SD_course3.setText("Course 3:");

        L_SD_course4.setText("Course 4:");

        L_SD_course5.setText("Course 5:");

        SD_course1.setText("course1");

        SD_course2.setText("course2");

        SD_course3.setText("course3");

        SD_course4.setText("course4");

        SD_course5.setText("course5");

        javax.swing.GroupLayout jPanelRightLayout = new javax.swing.GroupLayout(jPanelRight);
        jPanelRight.setLayout(jPanelRightLayout);
        jPanelRightLayout.setHorizontalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addComponent(L_SD_course1)
                        .addGap(18, 18, 18)
                        .addComponent(SD_course1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addComponent(L_SD_course2)
                        .addGap(18, 18, 18)
                        .addComponent(SD_course2))
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addComponent(L_SD_course3)
                        .addGap(18, 18, 18)
                        .addComponent(SD_course3))
                    .addGroup(jPanelRightLayout.createSequentialGroup()
                        .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(L_SD_course4)
                            .addComponent(L_SD_course5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SD_course4)
                            .addComponent(SD_course5)))))
        );
        jPanelRightLayout.setVerticalGroup(
            jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRightLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_SD_course1)
                    .addComponent(SD_course1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_SD_course2)
                    .addComponent(SD_course2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_SD_course3)
                    .addComponent(SD_course3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_SD_course4)
                    .addComponent(SD_course4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_SD_course5)
                    .addComponent(SD_course5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout Student_detailsLayout = new javax.swing.GroupLayout(Student_details);
        Student_details.setLayout(Student_detailsLayout);
        Student_detailsLayout.setHorizontalGroup(
            Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Student_detailsLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Student_detailsLayout.createSequentialGroup()
                        .addComponent(jPanelLeft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanelRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LRoll)
                    .addGroup(Student_detailsLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(rollInput, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bShow)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        Student_detailsLayout.setVerticalGroup(
            Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Student_detailsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LRoll)
                    .addComponent(rollInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Student_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelLeft, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelRight, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(442, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student Details", Student_details);

        TableConfirmReg.setModel(new javax.swing.table.DefaultTableModel(
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
        TableConfirmReg.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane7.setViewportView(TableConfirmReg);

        bConfirmReg.setText("Confirm registration");
        bConfirmReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ConfirmRegLayout = new javax.swing.GroupLayout(ConfirmReg);
        ConfirmReg.setLayout(ConfirmRegLayout);
        ConfirmRegLayout.setHorizontalGroup(
            ConfirmRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
            .addGroup(ConfirmRegLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(bConfirmReg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConfirmRegLayout.setVerticalGroup(
            ConfirmRegLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmRegLayout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bConfirmReg)
                .addGap(0, 582, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RegistrationLayout = new javax.swing.GroupLayout(Registration);
        Registration.setLayout(RegistrationLayout);
        RegistrationLayout.setHorizontalGroup(
            RegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConfirmReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RegistrationLayout.setVerticalGroup(
            RegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ConfirmReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Registration", Registration);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        TableAtt1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(TableAtt1);

        bSubmitAtt1.setText("Submit");
        bSubmitAtt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitAtt1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AC1Layout = new javax.swing.GroupLayout(AC1);
        AC1.setLayout(AC1Layout);
        AC1Layout.setHorizontalGroup(
            AC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(AC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(AC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AC1Layout.createSequentialGroup()
                            .addGap(387, 387, 387)
                            .addComponent(bSubmitAtt1)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AC1Layout.setVerticalGroup(
            AC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(AC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(bSubmitAtt1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UAtt_course1Layout = new javax.swing.GroupLayout(UAtt_course1);
        UAtt_course1.setLayout(UAtt_course1Layout);
        UAtt_course1Layout.setHorizontalGroup(
            UAtt_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course1Layout.createSequentialGroup()
                .addComponent(AC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UAtt_course1Layout.setVerticalGroup(
            UAtt_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course1Layout.createSequentialGroup()
                .addComponent(AC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 329, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Course 1", UAtt_course1);

        bSubmitAtt2.setText("Submit");
        bSubmitAtt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitAtt2ActionPerformed(evt);
            }
        });

        TableAtt2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(TableAtt2);

        javax.swing.GroupLayout AC2Layout = new javax.swing.GroupLayout(AC2);
        AC2.setLayout(AC2Layout);
        AC2Layout.setHorizontalGroup(
            AC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(AC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC2Layout.createSequentialGroup()
                    .addGap(397, 397, 397)
                    .addComponent(bSubmitAtt2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(AC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AC2Layout.setVerticalGroup(
            AC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(AC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC2Layout.createSequentialGroup()
                    .addGap(341, 341, 341)
                    .addComponent(bSubmitAtt2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(AC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC2Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UAtt_course2Layout = new javax.swing.GroupLayout(UAtt_course2);
        UAtt_course2.setLayout(UAtt_course2Layout);
        UAtt_course2Layout.setHorizontalGroup(
            UAtt_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course2Layout.createSequentialGroup()
                .addGap(0, 58, Short.MAX_VALUE)
                .addComponent(AC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
        );
        UAtt_course2Layout.setVerticalGroup(
            UAtt_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Course 2", UAtt_course2);

        TableAtt3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(TableAtt3);

        bSubmitAtt3.setText("Submit");
        bSubmitAtt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitAtt3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AC3Layout = new javax.swing.GroupLayout(AC3);
        AC3.setLayout(AC3Layout);
        AC3Layout.setHorizontalGroup(
            AC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(AC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(AC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bSubmitAtt3)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AC3Layout.setVerticalGroup(
            AC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(AC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(bSubmitAtt3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UAtt_course3Layout = new javax.swing.GroupLayout(UAtt_course3);
        UAtt_course3.setLayout(UAtt_course3Layout);
        UAtt_course3Layout.setHorizontalGroup(
            UAtt_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course3Layout.createSequentialGroup()
                .addComponent(AC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UAtt_course3Layout.setVerticalGroup(
            UAtt_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course3Layout.createSequentialGroup()
                .addComponent(AC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 329, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Course 3", UAtt_course3);

        TableAtt4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(TableAtt4);

        bSubmitAtt4.setText("Submit");
        bSubmitAtt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitAtt4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AC4Layout = new javax.swing.GroupLayout(AC4);
        AC4.setLayout(AC4Layout);
        AC4Layout.setHorizontalGroup(
            AC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(AC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(AC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bSubmitAtt4)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        AC4Layout.setVerticalGroup(
            AC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
            .addGroup(AC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(AC4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bSubmitAtt4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UAtt_course4Layout = new javax.swing.GroupLayout(UAtt_course4);
        UAtt_course4.setLayout(UAtt_course4Layout);
        UAtt_course4Layout.setHorizontalGroup(
            UAtt_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course4Layout.createSequentialGroup()
                .addComponent(AC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UAtt_course4Layout.setVerticalGroup(
            UAtt_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course4Layout.createSequentialGroup()
                .addComponent(AC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 337, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Course 4", UAtt_course4);

        TableAtt5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane13.setViewportView(TableAtt5);

        bSubmitAtt5.setText("Submit");
        bSubmitAtt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitAtt5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AC5Layout = new javax.swing.GroupLayout(AC5);
        AC5.setLayout(AC5Layout);
        AC5Layout.setHorizontalGroup(
            AC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AC5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AC5Layout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addComponent(bSubmitAtt5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        AC5Layout.setVerticalGroup(
            AC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AC5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bSubmitAtt5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout UAtt_course5Layout = new javax.swing.GroupLayout(UAtt_course5);
        UAtt_course5.setLayout(UAtt_course5Layout);
        UAtt_course5Layout.setHorizontalGroup(
            UAtt_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course5Layout.createSequentialGroup()
                .addComponent(AC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UAtt_course5Layout.setVerticalGroup(
            UAtt_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAtt_course5Layout.createSequentialGroup()
                .addComponent(AC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 336, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Course 5", UAtt_course5);

        javax.swing.GroupLayout Attendance_uploadLayout = new javax.swing.GroupLayout(Attendance_upload);
        Attendance_upload.setLayout(Attendance_uploadLayout);
        Attendance_uploadLayout.setHorizontalGroup(
            Attendance_uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        Attendance_uploadLayout.setVerticalGroup(
            Attendance_uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Upload Attendance", Attendance_upload);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        UACT1.setModel(new javax.swing.table.DefaultTableModel(
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
        UACT1.setEnabled(false);
        jScrollPane1.setViewportView(UACT1);

        ADescription.setColumns(20);
        ADescription.setRows(5);
        jScrollPane6.setViewportView(ADescription);

        DDescription.setText("YYYY-MM-DD");

        LADescription.setText("Assignment Description: ");

        LDDescription.setText("Deadline: ");

        bConfirmAss.setText("Confirm Assignment");
        bConfirmAss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmAssActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newAssignmentLayout = new javax.swing.GroupLayout(newAssignment);
        newAssignment.setLayout(newAssignmentLayout);
        newAssignmentLayout.setHorizontalGroup(
            newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
            .addGroup(newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(newAssignmentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LADescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(newAssignmentLayout.createSequentialGroup()
                            .addComponent(LDDescription)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addGap(18, 18, 18)
                    .addGroup(newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(DDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bConfirmAss))
                    .addContainerGap()))
        );
        newAssignmentLayout.setVerticalGroup(
            newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
            .addGroup(newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(newAssignmentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LADescription))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(newAssignmentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LDDescription))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bConfirmAss)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UAss_course1Layout = new javax.swing.GroupLayout(UAss_course1);
        UAss_course1.setLayout(UAss_course1Layout);
        UAss_course1Layout.setHorizontalGroup(
            UAss_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UAss_course1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(newAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(UAss_course1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UAss_course1Layout.setVerticalGroup(
            UAss_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course 1", UAss_course1);

        UACT2.setModel(new javax.swing.table.DefaultTableModel(
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
        UACT2.setEnabled(false);
        jScrollPane2.setViewportView(UACT2);

        javax.swing.GroupLayout UAss_course2Layout = new javax.swing.GroupLayout(UAss_course2);
        UAss_course2.setLayout(UAss_course2Layout);
        UAss_course2Layout.setHorizontalGroup(
            UAss_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UAss_course2Layout.setVerticalGroup(
            UAss_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 455, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course 2", UAss_course2);

        UACT3.setModel(new javax.swing.table.DefaultTableModel(
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
        UACT3.setEnabled(false);
        jScrollPane3.setViewportView(UACT3);

        javax.swing.GroupLayout UAss_course3Layout = new javax.swing.GroupLayout(UAss_course3);
        UAss_course3.setLayout(UAss_course3Layout);
        UAss_course3Layout.setHorizontalGroup(
            UAss_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UAss_course3Layout.setVerticalGroup(
            UAss_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 455, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course 3", UAss_course3);

        UACT4.setModel(new javax.swing.table.DefaultTableModel(
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
        UACT4.setEnabled(false);
        jScrollPane4.setViewportView(UACT4);

        javax.swing.GroupLayout UAss_course4Layout = new javax.swing.GroupLayout(UAss_course4);
        UAss_course4.setLayout(UAss_course4Layout);
        UAss_course4Layout.setHorizontalGroup(
            UAss_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UAss_course4Layout.setVerticalGroup(
            UAss_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 455, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course 4", UAss_course4);

        UACT5.setModel(new javax.swing.table.DefaultTableModel(
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
        UACT5.setEnabled(false);
        jScrollPane5.setViewportView(UACT5);

        javax.swing.GroupLayout UAss_course5Layout = new javax.swing.GroupLayout(UAss_course5);
        UAss_course5.setLayout(UAss_course5Layout);
        UAss_course5Layout.setHorizontalGroup(
            UAss_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        UAss_course5Layout.setVerticalGroup(
            UAss_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UAss_course5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 455, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Course 5", UAss_course5);

        javax.swing.GroupLayout Assignment_uploadLayout = new javax.swing.GroupLayout(Assignment_upload);
        Assignment_upload.setLayout(Assignment_uploadLayout);
        Assignment_uploadLayout.setHorizontalGroup(
            Assignment_uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        );
        Assignment_uploadLayout.setVerticalGroup(
            Assignment_uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Upload Assignemnt", Assignment_upload);

        jTabbedPane5.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        TableGra1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane14.setViewportView(TableGra1);

        bSubmitGra1.setText("Submit");
        bSubmitGra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitGra1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GC1Layout = new javax.swing.GroupLayout(GC1);
        GC1.setLayout(GC1Layout);
        GC1Layout.setHorizontalGroup(
            GC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(GC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(GC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GC1Layout.createSequentialGroup()
                            .addGap(387, 387, 387)
                            .addComponent(bSubmitGra1)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        GC1Layout.setVerticalGroup(
            GC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(GC1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(bSubmitGra1)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UGra_course1Layout = new javax.swing.GroupLayout(UGra_course1);
        UGra_course1.setLayout(UGra_course1Layout);
        UGra_course1Layout.setHorizontalGroup(
            UGra_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course1Layout.createSequentialGroup()
                .addComponent(GC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UGra_course1Layout.setVerticalGroup(
            UGra_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course1Layout.createSequentialGroup()
                .addComponent(GC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 329, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Course 1", UGra_course1);

        TableGra2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane15.setViewportView(TableGra2);

        bSubmitGra2.setText("Submit");
        bSubmitGra2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitGra2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GC2Layout = new javax.swing.GroupLayout(GC2);
        GC2.setLayout(GC2Layout);
        GC2Layout.setHorizontalGroup(
            GC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(GC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(GC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bSubmitGra2)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        GC2Layout.setVerticalGroup(
            GC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(GC2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(bSubmitGra2)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UGra_course2Layout = new javax.swing.GroupLayout(UGra_course2);
        UGra_course2.setLayout(UGra_course2Layout);
        UGra_course2Layout.setHorizontalGroup(
            UGra_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course2Layout.createSequentialGroup()
                .addComponent(GC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UGra_course2Layout.setVerticalGroup(
            UGra_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course2Layout.createSequentialGroup()
                .addComponent(GC2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 329, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Course 2", UGra_course2);

        TableGra3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane16.setViewportView(TableGra3);

        bSubmitGra3.setText("Submit");
        bSubmitGra3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitGra3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GC3Layout = new javax.swing.GroupLayout(GC3);
        GC3.setLayout(GC3Layout);
        GC3Layout.setHorizontalGroup(
            GC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(GC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(GC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bSubmitGra3)
                        .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        GC3Layout.setVerticalGroup(
            GC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
            .addGroup(GC3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(bSubmitGra3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UGra_course3Layout = new javax.swing.GroupLayout(UGra_course3);
        UGra_course3.setLayout(UGra_course3Layout);
        UGra_course3Layout.setHorizontalGroup(
            UGra_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course3Layout.createSequentialGroup()
                .addComponent(GC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UGra_course3Layout.setVerticalGroup(
            UGra_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course3Layout.createSequentialGroup()
                .addComponent(GC3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 329, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Course 3", UGra_course3);

        TableGra4.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane17.setViewportView(TableGra4);

        bSubmitGra4.setText("Submit");
        bSubmitGra4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitGra4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GC4Layout = new javax.swing.GroupLayout(GC4);
        GC4.setLayout(GC4Layout);
        GC4Layout.setHorizontalGroup(
            GC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(GC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(GC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(bSubmitGra4)
                        .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        GC4Layout.setVerticalGroup(
            GC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
            .addGroup(GC4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bSubmitGra4)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UGra_course4Layout = new javax.swing.GroupLayout(UGra_course4);
        UGra_course4.setLayout(UGra_course4Layout);
        UGra_course4Layout.setHorizontalGroup(
            UGra_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course4Layout.createSequentialGroup()
                .addComponent(GC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UGra_course4Layout.setVerticalGroup(
            UGra_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course4Layout.createSequentialGroup()
                .addComponent(GC4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 337, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Course 4", UGra_course4);

        TableGra5.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane18.setViewportView(TableGra5);

        bSubmitGra5.setText("Submit");
        bSubmitGra5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitGra5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout GC5Layout = new javax.swing.GroupLayout(GC5);
        GC5.setLayout(GC5Layout);
        GC5Layout.setHorizontalGroup(
            GC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
            .addGroup(GC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(GC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, GC5Layout.createSequentialGroup()
                            .addGap(387, 387, 387)
                            .addComponent(bSubmitGra5)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        GC5Layout.setVerticalGroup(
            GC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
            .addGroup(GC5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(GC5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(bSubmitGra5)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout UGra_course5Layout = new javax.swing.GroupLayout(UGra_course5);
        UGra_course5.setLayout(UGra_course5Layout);
        UGra_course5Layout.setHorizontalGroup(
            UGra_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course5Layout.createSequentialGroup()
                .addComponent(GC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 117, Short.MAX_VALUE))
        );
        UGra_course5Layout.setVerticalGroup(
            UGra_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UGra_course5Layout.createSequentialGroup()
                .addComponent(GC5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 336, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Course 5", UGra_course5);

        javax.swing.GroupLayout Grade_uploadLayout = new javax.swing.GroupLayout(Grade_upload);
        Grade_upload.setLayout(Grade_uploadLayout);
        Grade_uploadLayout.setHorizontalGroup(
            Grade_uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        Grade_uploadLayout.setVerticalGroup(
            Grade_uploadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        jTabbedPane1.addTab("Upload Grade", Grade_upload);

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        Lnewpass.setText("New Password:");

        Lconpass.setText("Confirm Password:");

        newPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassActionPerformed(evt);
            }
        });

        bChangepass.setText("Change");
        bChangepass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChangepassActionPerformed(evt);
            }
        });

        Lcurpass.setText("Current Password:");

        javax.swing.GroupLayout ChangePassLayout = new javax.swing.GroupLayout(ChangePass);
        ChangePass.setLayout(ChangePassLayout);
        ChangePassLayout.setHorizontalGroup(
            ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePassLayout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(ChangePassLayout.createSequentialGroup()
                        .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lcurpass)
                            .addComponent(Lnewpass))
                        .addGap(18, 18, 18)
                        .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(curPass)
                            .addComponent(newPass, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ChangePassLayout.createSequentialGroup()
                        .addComponent(Lconpass)
                        .addGap(18, 18, 18)
                        .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bChangepass)
                            .addComponent(conPass, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        ChangePassLayout.setVerticalGroup(
            ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePassLayout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lcurpass)
                    .addComponent(curPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lnewpass)
                    .addComponent(newPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ChangePassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lconpass)
                    .addComponent(conPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bChangepass)
                .addContainerGap(486, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Change Password", ChangePass);

        jButton1.setText("Confirm Logout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LogoutLayout = new javax.swing.GroupLayout(Logout);
        Logout.setLayout(LogoutLayout);
        LogoutLayout.setHorizontalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(221, 221, 221)
                .addComponent(jButton1)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(jButton1)
                .addContainerGap(557, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Logout", Logout);

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings);
        Settings.setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
            .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane4))
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 709, Short.MAX_VALUE)
            .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane4))
        );

        jTabbedPane1.addTab("Settings", Settings);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bShowActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="select * from PersonalDetails where roll='"+rollInput.getText().toString()+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                System.out.println(rs.getString("name"));
                name.setText(rs.getString("name"));
                branch.setText(rs.getString("branch"));
                batch.setText(rs.getString("batch"));
                semester.setText(rs.getString("semester"));
                room.setText(rs.getString("room"));
                hostel.setText(rs.getString("hostel"));
                mob.setText(rs.getString("mob"));
                father.setText(rs.getString("father"));
                mother.setText(rs.getString("mother"));
                parent_mob.setText(rs.getString("parent_mob"));
                /*LBatch.setVisible(true);
                LBranch.setVisible(true);
                LFather.setVisible(true);
                LHostel.setVisible(true);
                LMob.setVisible(true);
                LName.setVisible(true);
                LParentContact.setVisible(true);
                LRoom.setVisible(true);
                LSemester.setVisible(true);
                Lmother.setVisible(true);
                batch.setVisible(true);
                branch.setVisible(true);
                father.setVisible(true);
                hostel.setVisible(true);
                mob.setVisible(true);
                mother.setVisible(true);
                name.setVisible(true);
                parent_mob.setVisible(true);
                room.setVisible(true);
                semester.setVisible(true);*/
                jPanelLeft.setVisible(true);
                jPanelRight.setVisible(true);
            }
            String rCourses[]=new String[5];
            query="select * from student where roll='"+rollInput.getText().toString()+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                SD_course1.setText("("+rs.getString("course1")+")"+rs.getString("course1name")+"-"+rs.getString("prof1"));
                SD_course2.setText("("+rs.getString("course2")+")"+rs.getString("course2name")+"-"+rs.getString("prof2"));
                SD_course3.setText("("+rs.getString("course3")+")"+rs.getString("course3name")+"-"+rs.getString("prof3"));
                SD_course4.setText("("+rs.getString("course4")+")"+rs.getString("course4name")+"-"+rs.getString("prof4"));
                SD_course5.setText("("+rs.getString("course5")+")"+rs.getString("course5name")+"-"+rs.getString("prof5"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bShowActionPerformed

    private void bConfirmAssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmAssActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="INSERT INTO `assignment`(`courseid`, `professor`, `batch`, `details`, `deadline`) VALUES ('"+C[0]+"','"+PID+"','"+B[0]+"','"+ADescription.getText().toString()+"','"+DDescription.getText().toString()+"')";
            System.out.println(query);
            Statement stmt2=con.createStatement();
            int rowsUpdated=stmt2.executeUpdate(query);
            if(rowsUpdated>0)
            {
                JOptionPane.showMessageDialog(this, "Assignment Uploaded");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bConfirmAssActionPerformed

    private void newPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassActionPerformed

    private void bChangepassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChangepassActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
            JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="select * from plogin where name='"+PID+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                if(rs.getString("pass").equals(curPass.getText().toString()))
                {
                    System.out.println("current pass match");
                    if(newPass.getText().toString().equals(conPass.getText().toString()))
                    {
                        query="update slogin set `pass`='"+newPass.getText().toString()+"' where `name`='"+PID+"'";
                        System.out.println(query);
                        Statement stmt2=con.createStatement();
                        int rowsUpdated=stmt2.executeUpdate(query);
                        System.out.println("Password Changed");
                    }
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bChangepassActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Logout");
        new mainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bConfirmRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmRegActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int selRow=TableConfirmReg.getSelectedRow();
            String sid=TableConfirmReg.getModel().getValueAt(selRow, 0).toString();
            String name=TableConfirmReg.getModel().getValueAt(selRow, 1).toString();
            String batch=TableConfirmReg.getModel().getValueAt(selRow, 2).toString();
            String course1=TableConfirmReg.getModel().getValueAt(selRow, 3).toString();
            String course2=TableConfirmReg.getModel().getValueAt(selRow, 4).toString();
            String course3=TableConfirmReg.getModel().getValueAt(selRow, 5).toString();
            String course4=TableConfirmReg.getModel().getValueAt(selRow, 6).toString();
            String course5=TableConfirmReg.getModel().getValueAt(selRow, 7).toString();
            String course1name=TableConfirmReg.getModel().getValueAt(selRow, 8).toString();
            String course2name=TableConfirmReg.getModel().getValueAt(selRow, 9).toString();
            String course3name=TableConfirmReg.getModel().getValueAt(selRow, 10).toString();
            String course4name=TableConfirmReg.getModel().getValueAt(selRow, 11).toString();
            String course5name=TableConfirmReg.getModel().getValueAt(selRow, 12).toString();
            String prof1=TableConfirmReg.getModel().getValueAt(selRow, 13).toString();
            String prof2=TableConfirmReg.getModel().getValueAt(selRow, 14).toString();
            String prof3=TableConfirmReg.getModel().getValueAt(selRow, 15).toString();
            String prof4=TableConfirmReg.getModel().getValueAt(selRow, 16).toString();
            String prof5=TableConfirmReg.getModel().getValueAt(selRow, 17).toString();
            String query="delete from `student` where roll='"+sid+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            query="INSERT INTO `student`(`roll`, `name`,`batch`, `course1`, `course2`, `course3`, `course4`, `course5`, `prof1`, `prof2`, `prof3`, `prof4`, `prof5`, `course1name`, `course2name`, `course3name`, `course4name`, `course5name`) VALUES ('"+sid+"','"+name+"','"+batch+"','"+course1+"','"+course2+"','"+course3+"','"+course4+"','"+course5+"','"+prof1+"','"+prof2+"','"+prof3+"','"+prof4+"','"+prof5+"','"+course1name+"','"+course2name+"','"+course3name+"','"+course4name+"','"+course5name+"')";
            System.out.println(query);
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            query="delete from `preregistration` where sid='"+sid+"'";
            System.out.println(query);
            stmt=con.createStatement();
            stmt.executeUpdate(query);
            query="select * from `preregistration` where advisor='"+PID+"'";
            stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            ResultSetMetaData rsmd=rs.getMetaData();
            rs.last();
            int nRows=rs.getRow();
            rs.beforeFirst();
            int nCols=rsmd.getColumnCount();
            String[]colnm=new String[nCols];
            Object obj[][]=new Object[nRows][nCols];
            int i=0;
            for(i=0;i<nCols;++i)
            {
                colnm[i]=rsmd.getColumnName(i+1);
            }
            i=0;
            while(rs.next())
            {
                for(int j=0;j<nCols;++j)
                {
                    obj[i][j]=rs.getString(j+1);
                    System.out.print(obj[i][j]+" ");
                }
                i++;
                System.out.println();
            }
            TableConfirmReg.setModel(new javax.swing.table.DefaultTableModel(obj,colnm));
            if(nRows>0)
                ConfirmReg.setVisible(true);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bConfirmRegActionPerformed

    private void bSubmitAtt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitAtt1ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableAtt1.getModel().getRowCount();
            String query="Select * from `attendance` where sid='";
            Statement stmt=con.createStatement();
            ResultSet rs;
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableAtt1.getModel().getValueAt(i, 0)+"' and cid='"+C[0]+"'";
                System.out.println(tQuery);
                rs=stmt.executeQuery(tQuery);
                rs.last();
                int n=rs.getRow();
                rs.beforeFirst();;
                if(n==0)
                {
                    String tQuery2="INSERT INTO `attendance`(`sid`, `batch`, `cid`, `TP`, `TA`) VALUES ('"+TableAtt1.getModel().getValueAt(i,0)+"','"+B[0]+"','"+C[0]+"','"+TableAtt1.getModel().getValueAt(i,1)+"','"+TableAtt1.getModel().getValueAt(i,2)+"')";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                else
                {
                    String tQuery2="UPDATE `attendance` SET `TP`=`TP`+"+TableAtt1.getModel().getValueAt(i,1)+", `TA`=`TA`+"+TableAtt1.getModel().getValueAt(i,2)+" where `sid`='"+TableAtt1.getModel().getValueAt(i, 0)+"' and `batch`='"+B[0]+"' and `cid`='"+C[0]+"'";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitAtt1ActionPerformed

    private void bSubmitAtt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitAtt2ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableAtt2.getModel().getRowCount();
            String query="Select * from `attendance` where sid='";
            Statement stmt=con.createStatement();
            ResultSet rs;
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableAtt2.getModel().getValueAt(i, 0)+"' and cid='"+C[1]+"'";
                System.out.println(tQuery);
                rs=stmt.executeQuery(tQuery);
                rs.last();
                int n=rs.getRow();
                rs.beforeFirst();;
                if(n==0)
                {
                    String tQuery2="INSERT INTO `attendance`(`sid`, `batch`, `cid`, `TP`, `TA`) VALUES ('"+TableAtt2.getModel().getValueAt(i,0)+"','"+B[1]+"','"+C[1]+"','"+TableAtt2.getModel().getValueAt(i,1)+"','"+TableAtt2.getModel().getValueAt(i,2)+"')";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                else
                {
                    String tQuery2="UPDATE `attendance` SET `TP`=`TP`+"+TableAtt2.getModel().getValueAt(i,1)+", `TA`=`TA`+"+TableAtt2.getModel().getValueAt(i,2)+" where `sid`='"+TableAtt2.getModel().getValueAt(i, 0)+"' and `batch`='"+B[1]+"' and `cid`='"+C[1]+"'";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitAtt2ActionPerformed

    private void bSubmitAtt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitAtt3ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableAtt3.getModel().getRowCount();
            String query="Select * from `attendance` where sid='";
            Statement stmt=con.createStatement();
            ResultSet rs;
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableAtt3.getModel().getValueAt(i, 0)+"' and cid='"+C[2]+"'";
                System.out.println(tQuery);
                rs=stmt.executeQuery(tQuery);
                rs.last();
                int n=rs.getRow();
                rs.beforeFirst();;
                if(n==0)
                {
                    String tQuery2="INSERT INTO `attendance`(`sid`, `batch`, `cid`, `TP`, `TA`) VALUES ('"+TableAtt3.getModel().getValueAt(i,0)+"','"+B[2]+"','"+C[2]+"','"+TableAtt3.getModel().getValueAt(i,1)+"','"+TableAtt3.getModel().getValueAt(i,2)+"')";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                else
                {
                    String tQuery2="UPDATE `attendance` SET `TP`=`TP`+"+TableAtt3.getModel().getValueAt(i,1)+", `TA`=`TA`+"+TableAtt3.getModel().getValueAt(i,2)+" where `sid`='"+TableAtt3.getModel().getValueAt(i, 0)+"' and `batch`='"+B[2]+"' and `cid`='"+C[2]+"'";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitAtt3ActionPerformed

    private void bSubmitAtt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitAtt4ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableAtt4.getModel().getRowCount();
            String query="Select * from `attendance` where sid='";
            Statement stmt=con.createStatement();
            ResultSet rs;
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableAtt4.getModel().getValueAt(i, 0)+"' and cid='"+C[3]+"'";
                System.out.println(tQuery);
                rs=stmt.executeQuery(tQuery);
                rs.last();
                int n=rs.getRow();
                rs.beforeFirst();;
                if(n==0)
                {
                    String tQuery2="INSERT INTO `attendance`(`sid`, `batch`, `cid`, `TP`, `TA`) VALUES ('"+TableAtt4.getModel().getValueAt(i,0)+"','"+B[3]+"','"+C[3]+"','"+TableAtt4.getModel().getValueAt(i,1)+"','"+TableAtt4.getModel().getValueAt(i,2)+"')";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                else
                {
                    String tQuery2="UPDATE `attendance` SET `TP`=`TP`+"+TableAtt4.getModel().getValueAt(i,1)+", `TA`=`TA`+"+TableAtt4.getModel().getValueAt(i,2)+" where `sid`='"+TableAtt4.getModel().getValueAt(i, 0)+"' and `batch`='"+B[3]+"' and `cid`='"+C[3]+"'";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitAtt4ActionPerformed

    private void bSubmitGra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitGra1ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableGra1.getModel().getRowCount();
            //System.out.println(nRows);
            String query="INSERT INTO `grade`(`sid`, `cid`, `grade`) VALUES ('";
            Statement stmt=con.createStatement();
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableGra1.getModel().getValueAt(i, 0).toString()+"','"+C[0]+"','"+TableGra1.getModel().getValueAt(i, 1).toString()+"')";
                System.out.println(tQuery);
                try{
                    stmt.executeUpdate(tQuery);
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
            System.out.println("hello");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitGra1ActionPerformed

    private void bSubmitGra2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitGra2ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableGra2.getModel().getRowCount();
            String query="INSERT INTO `grade`(`sid`, `cid`, `grade`) VALUES ('";
            Statement stmt=con.createStatement();
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableGra2.getModel().getValueAt(i, 0).toString()+"','"+C[1]+"','"+TableGra2.getModel().getValueAt(i, 1).toString()+"')";
                System.out.println(tQuery);
                try{
                    stmt.executeUpdate(tQuery);
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitGra2ActionPerformed

    private void bSubmitGra3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitGra3ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableGra3.getModel().getRowCount();
            String query="INSERT INTO `grade`(`sid`, `cid`, `grade`) VALUES ('";
            Statement stmt=con.createStatement();
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableGra3.getModel().getValueAt(i, 0).toString()+"','"+C[2]+"','"+TableGra3.getModel().getValueAt(i, 1).toString()+"')";
                System.out.println(tQuery);
                try{
                    stmt.executeUpdate(tQuery);
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitGra3ActionPerformed

    private void bSubmitGra4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitGra4ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableGra4.getModel().getRowCount();
            String query="INSERT INTO `grade`(`sid`, `cid`, `grade`) VALUES ('";
            Statement stmt=con.createStatement();
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableGra4.getModel().getValueAt(i, 0).toString()+"','"+C[3]+"','"+TableGra4.getModel().getValueAt(i, 1).toString()+"')";
                System.out.println(tQuery);
                try{
                    stmt.executeUpdate(tQuery);
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitGra4ActionPerformed

    private void bSubmitGra5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitGra5ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableGra5.getModel().getRowCount();
            String query="INSERT INTO `grade`(`sid`, `cid`, `grade`) VALUES ('";
            Statement stmt=con.createStatement();
            for(int i=0;i<nRows;++i)
            {
                if(!TableGra5.getModel().getValueAt(i, 1).toString().equals("A") && !TableGra5.getModel().getValueAt(i, 1).toString().equals("B") && !TableGra5.getModel().getValueAt(i, 1).toString().equals("C") && !TableGra5.getModel().getValueAt(i, 1).toString().equals("D") && !TableGra5.getModel().getValueAt(i, 1).toString().equals("E") && !TableGra5.getModel().getValueAt(i, 1).toString().equals("F"))
                {
                    JOptionPane.showMessageDialog(this, "Invalid Grade at row "+Integer.toString(i+1));
                    return;
                }
            }
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableGra5.getModel().getValueAt(i, 0).toString()+"','"+C[4]+"','"+TableGra5.getModel().getValueAt(i, 1).toString()+"')";
                System.out.println(tQuery);
                try{
                    stmt.executeUpdate(tQuery);
                }
                catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitGra5ActionPerformed

    private void bSubmitAtt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitAtt5ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            int nRows=TableAtt5.getModel().getRowCount();
            String query="Select * from `attendance` where sid='";
            Statement stmt=con.createStatement();
            ResultSet rs;
            for(int i=0;i<nRows;++i)
            {
                String tQuery=query+TableAtt5.getModel().getValueAt(i, 0)+"' and cid='"+C[4]+"'";
                System.out.println(tQuery);
                rs=stmt.executeQuery(tQuery);
                rs.last();
                int n=rs.getRow();
                rs.beforeFirst();;
                if(n==0)
                {
                    String tQuery2="INSERT INTO `attendance`(`sid`, `batch`, `cid`, `TP`, `TA`) VALUES ('"+TableAtt5.getModel().getValueAt(i,0)+"','"+B[4]+"','"+C[4]+"','"+TableAtt5.getModel().getValueAt(i,1)+"','"+TableAtt5.getModel().getValueAt(i,2)+"')";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
                else
                {
                    String tQuery2="UPDATE `attendance` SET `TP`=`TP`+"+TableAtt5.getModel().getValueAt(i,1)+", `TA`=`TA`+"+TableAtt5.getModel().getValueAt(i,2)+" where `sid`='"+TableAtt5.getModel().getValueAt(i, 0)+"' and `batch`='"+B[4]+"' and `cid`='"+C[4]+"'";
                    System.out.println(tQuery2);
                    try{
                        stmt.executeUpdate(tQuery2);
                    }catch(SQLException e)
                    {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_bSubmitAtt5ActionPerformed

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
            java.util.logging.Logger.getLogger(PHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PHP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AC1;
    private javax.swing.JPanel AC2;
    private javax.swing.JPanel AC3;
    private javax.swing.JPanel AC4;
    private javax.swing.JPanel AC5;
    private javax.swing.JTextArea ADescription;
    private javax.swing.JPanel Assignment_upload;
    private javax.swing.JPanel Attendance_upload;
    private javax.swing.JPanel ChangePass;
    private javax.swing.JPanel ConfirmReg;
    private javax.swing.JTextField DDescription;
    private javax.swing.JPanel GC1;
    private javax.swing.JPanel GC2;
    private javax.swing.JPanel GC3;
    private javax.swing.JPanel GC4;
    private javax.swing.JPanel GC5;
    private javax.swing.JPanel Grade_upload;
    private javax.swing.JLabel LADescription;
    private javax.swing.JLabel LBatch;
    private javax.swing.JLabel LBranch;
    private javax.swing.JLabel LDDescription;
    private javax.swing.JLabel LFather;
    private javax.swing.JLabel LHostel;
    private javax.swing.JLabel LMob;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LParentContact;
    private javax.swing.JLabel LRoll;
    private javax.swing.JLabel LRoom;
    private javax.swing.JLabel LSemester;
    private javax.swing.JLabel L_SD_course1;
    private javax.swing.JLabel L_SD_course2;
    private javax.swing.JLabel L_SD_course3;
    private javax.swing.JLabel L_SD_course4;
    private javax.swing.JLabel L_SD_course5;
    private javax.swing.JLabel Lconpass;
    private javax.swing.JLabel Lcurpass;
    private javax.swing.JLabel Lmother;
    private javax.swing.JLabel Lnewpass;
    private javax.swing.JPanel Logout;
    private javax.swing.JPanel Registration;
    private javax.swing.JLabel SD_course1;
    private javax.swing.JLabel SD_course2;
    private javax.swing.JLabel SD_course3;
    private javax.swing.JLabel SD_course4;
    private javax.swing.JLabel SD_course5;
    private javax.swing.JPanel Settings;
    private javax.swing.JPanel Student_details;
    private javax.swing.JTable TableAtt1;
    private javax.swing.JTable TableAtt2;
    private javax.swing.JTable TableAtt3;
    private javax.swing.JTable TableAtt4;
    private javax.swing.JTable TableAtt5;
    private javax.swing.JTable TableConfirmReg;
    private javax.swing.JTable TableGra1;
    private javax.swing.JTable TableGra2;
    private javax.swing.JTable TableGra3;
    private javax.swing.JTable TableGra4;
    private javax.swing.JTable TableGra5;
    private javax.swing.JTable UACT1;
    private javax.swing.JTable UACT2;
    private javax.swing.JTable UACT3;
    private javax.swing.JTable UACT4;
    private javax.swing.JTable UACT5;
    private javax.swing.JPanel UAss_course1;
    private javax.swing.JPanel UAss_course2;
    private javax.swing.JPanel UAss_course3;
    private javax.swing.JPanel UAss_course4;
    private javax.swing.JPanel UAss_course5;
    private javax.swing.JPanel UAtt_course1;
    private javax.swing.JPanel UAtt_course2;
    private javax.swing.JPanel UAtt_course3;
    private javax.swing.JPanel UAtt_course4;
    private javax.swing.JPanel UAtt_course5;
    private javax.swing.JPanel UGra_course1;
    private javax.swing.JPanel UGra_course2;
    private javax.swing.JPanel UGra_course3;
    private javax.swing.JPanel UGra_course4;
    private javax.swing.JPanel UGra_course5;
    private javax.swing.JButton bChangepass;
    private javax.swing.JButton bConfirmAss;
    private javax.swing.JButton bConfirmReg;
    private javax.swing.JButton bShow;
    private javax.swing.JButton bSubmitAtt1;
    private javax.swing.JButton bSubmitAtt2;
    private javax.swing.JButton bSubmitAtt3;
    private javax.swing.JButton bSubmitAtt4;
    private javax.swing.JButton bSubmitAtt5;
    private javax.swing.JButton bSubmitGra1;
    private javax.swing.JButton bSubmitGra2;
    private javax.swing.JButton bSubmitGra3;
    private javax.swing.JButton bSubmitGra4;
    private javax.swing.JButton bSubmitGra5;
    private javax.swing.JLabel batch;
    private javax.swing.JLabel branch;
    private javax.swing.JPasswordField conPass;
    private javax.swing.JPasswordField curPass;
    private javax.swing.JLabel father;
    private javax.swing.JLabel hostel;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JLabel mob;
    private javax.swing.JLabel mother;
    private javax.swing.JLabel name;
    private javax.swing.JPanel newAssignment;
    private javax.swing.JPasswordField newPass;
    private javax.swing.JLabel parent_mob;
    private javax.swing.JTextField rollInput;
    private javax.swing.JLabel room;
    private javax.swing.JLabel semester;
    // End of variables declaration//GEN-END:variables
}
