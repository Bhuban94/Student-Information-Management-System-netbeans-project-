/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author BHUBAN
 */
public class SHP extends javax.swing.JFrame {
    String ID;
    String NM;
    String PW;
    String BT;
    String BR;
    String C[]=new String[5];
    String P[]=new String[5];
    /**
     * Creates new form SHP
     */
    public SHP() {
        initComponents();
    }
    public SHP(String upass,String uid) {
        initComponents();
        ID=uid;
        PW=upass;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="select * from PersonalDetails where roll='"+ID+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            rs.last();
            if(rs.getRow()==0)
                JOptionPane.showMessageDialog(this, "Invalid Student...");
            rs.beforeFirst();
            while(rs.next())
            {
                System.out.println(rs.getString("name"));
                NM=rs.getString("name");
                name.setText(rs.getString("name"));
                roll.setText(rs.getString("roll"));
                BR=rs.getString("branch");
                branch.setText(rs.getString("branch"));
                BT=rs.getString("batch");
                batch.setText(rs.getString("batch"));
                semester.setText(rs.getString("semester"));
                room.setText(rs.getString("room"));
                hostel.setText(rs.getString("hostel"));
                mob.setText(rs.getString("mob"));
                father.setText(rs.getString("father"));
                mother.setText(rs.getString("mother"));
                parent_mob.setText(rs.getString("parent_mob"));
            }    
            query="select * from registration_courses";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            int row=rs.getRow();
            rs.beforeFirst();
            System.out.println(row);
            String cdetails[]=new String[row];
            int i=0;
            while(rs.next())
            {
                cdetails[i++]="("+rs.getString("id")+") "+rs.getString("name")+"-"+rs.getString("professor");
                System.out.println(cdetails[i-1]);
            }
            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(cdetails));
            jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(cdetails));
            jComboBox2.setSelectedIndex(1);
            jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(cdetails));
            jComboBox3.setSelectedIndex(2);
            jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(cdetails));
            jComboBox4.setSelectedIndex(3);
            jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(cdetails));
            jComboBox5.setSelectedIndex(4);
            String rCourses[]=new String[5];
            query="select * from student where roll='"+ID+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            while(rs.next())
            {
                C[0]=rs.getString("Course1");
                P[0]=rs.getString("prof1");
                C[1]=rs.getString("Course2");
                P[1]=rs.getString("prof2");
                C[2]=rs.getString("Course3");
                P[2]=rs.getString("prof3");
                C[3]=rs.getString("Course4");
                P[3]=rs.getString("prof4");
                C[4]=rs.getString("Course5");
                P[4]=rs.getString("prof5");
                //jTabbedPane2.setTitleAt(0, "("+rs.getString("course1")+")\n"+rs.getString("prof1"));
                //jTabbedPane2.setTitleAt(1, "("+rs.getString("course2")+")\n"+rs.getString("prof2"));
                //jTabbedPane2.setTitleAt(2, "("+rs.getString("course3")+")\n"+rs.getString("prof3"));
                //jTabbedPane2.setTitleAt(3, "("+rs.getString("course4")+")\n"+rs.getString("prof4"));
                //jTabbedPane2.setTitleAt(4, "("+rs.getString("course5")+")\n"+rs.getString("prof5"));
                jTabbedPane4.setTitleAt(0, "("+rs.getString("course1")+")\n"+rs.getString("prof1"));
                jTabbedPane4.setTitleAt(1, "("+rs.getString("course2")+")\n"+rs.getString("prof2"));
                jTabbedPane4.setTitleAt(2, "("+rs.getString("course3")+")\n"+rs.getString("prof3"));
                jTabbedPane4.setTitleAt(3, "("+rs.getString("course4")+")\n"+rs.getString("prof4"));
                jTabbedPane4.setTitleAt(4, "("+rs.getString("course5")+")\n"+rs.getString("prof5"));
            }
            query="select * from preregistration where `sid`='"+ID+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            if(row==0)
            {
                make_payment.setVisible(false);
                //LFApplicable.setVisible(true);
            }
            query="select * from assignment where `courseid`='"+C[0]+"' and `professor`='"+P[0]+"' and `batch`='"+BT+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
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
                ACT1.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[1]+"' and `professor`='"+P[1]+"' and `batch`='"+BT+"'";
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
                }
                ACT2.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[2]+"' and `professor`='"+P[2]+"' and `batch`='"+BT+"'";
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
                }
                ACT3.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[3]+"' and `professor`='"+P[3]+"' and `batch`='"+BT+"'";
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
                }
                ACT4.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from assignment where `courseid`='"+C[4]+"' and `professor`='"+P[4]+"' and `batch`='"+BT+"'";
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
                }
                ACT5.setModel(new javax.swing.table.DefaultTableModel(obj,colName));
            }
            query="select * from grade where `sid`='"+ID+"'";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            rs.beforeFirst();
            Object GCcourse[][]=new Object[row][3];
            i=0;
            while(rs.next())
            {
                GCcourse[i][0]=rs.getString("cid");
                GCcourse[i][2]=rs.getString("grade");
                String query2="select cname from course where `cid`='"+rs.getString("cid")+"'";
                Statement stmt2=con.createStatement();
                ResultSet rs2=stmt2.executeQuery(query2);
                while(rs2.next())
                {
                    GCcourse[i][1]=rs2.getString("cname");
                }
                System.out.println(GCcourse[i][0]+" "+GCcourse[i][1]+" "+GCcourse[i][2]);
                i++;
            }
            String GCcolnm[]={"Course ID","Course Name","Grade"};
            GC.setModel(new javax.swing.table.DefaultTableModel(GCcourse,GCcolnm));
            query="select * from attendance where `sid`='"+ID+"' and (`cid`='"+C[0]+"' or `cid`='"+C[1]+"' or `cid`='"+C[2]+"' or `cid`='"+C[3]+"' or `cid`='"+C[4]+"')";
            System.out.println(query);
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            row=rs.getRow();
            rs.beforeFirst();
            Object AttTab[][]=new Object[row][4];
            i=0;
            while(rs.next())
            {
                AttTab[i][0]=rs.getString("cid");
                AttTab[i][2]=rs.getString("TP");
                AttTab[i][3]=rs.getString("TA");
                String query2="select cname from course where `cid`='"+rs.getString("cid")+"'";
                Statement stmt2=con.createStatement();
                ResultSet rs2=stmt2.executeQuery(query2);
                while(rs2.next())
                {
                    AttTab[i][1]=rs2.getString("cname");
                }
                System.out.println(AttTab[i][0]+" "+AttTab[i][1]+" "+AttTab[i][2]+" "+AttTab[i][3]);
                i++;
            }
            String Attcolnm[]={"Course ID","Course Name","Present","Absent"};
            AttTable.setModel(new javax.swing.table.DefaultTableModel(AttTab,Attcolnm));
            query="Select * from `feepayment` where sid='"+ID+"'";
            stmt=con.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
            int nRows=rs.getRow();
            rs.beforeFirst();
            if(nRows!=0)
                make_payment.setVisible(false);
            LFApplicable.setVisible(false);
        }
        catch(Exception e) {
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
        PersonalDetails = new javax.swing.JPanel();
        LName = new javax.swing.JLabel();
        LRoll = new javax.swing.JLabel();
        LBranch = new javax.swing.JLabel();
        LBatch = new javax.swing.JLabel();
        LHostel = new javax.swing.JLabel();
        LMob = new javax.swing.JLabel();
        LSemester = new javax.swing.JLabel();
        LRoom = new javax.swing.JLabel();
        LFather = new javax.swing.JLabel();
        Lmother = new javax.swing.JLabel();
        LParentContact = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        roll = new javax.swing.JLabel();
        branch = new javax.swing.JLabel();
        batch = new javax.swing.JLabel();
        semester = new javax.swing.JLabel();
        room = new javax.swing.JLabel();
        hostel = new javax.swing.JLabel();
        mob = new javax.swing.JLabel();
        father = new javax.swing.JLabel();
        mother = new javax.swing.JLabel();
        parent_mob = new javax.swing.JLabel();
        PreRegistration = new javax.swing.JPanel();
        course1 = new javax.swing.JLabel();
        course2 = new javax.swing.JLabel();
        course3 = new javax.swing.JLabel();
        course4 = new javax.swing.JLabel();
        course5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jComboBox3 = new javax.swing.JComboBox();
        jComboBox4 = new javax.swing.JComboBox();
        jComboBox5 = new javax.swing.JComboBox();
        bConfirmSubmission = new javax.swing.JButton();
        Payment = new javax.swing.JPanel();
        LFApplicable = new javax.swing.JLabel();
        LCourseF = new javax.swing.JLabel();
        LHostelF = new javax.swing.JLabel();
        LLibraryF = new javax.swing.JLabel();
        LExamF = new javax.swing.JLabel();
        LMiscF = new javax.swing.JLabel();
        LTotalF = new javax.swing.JLabel();
        CourseFAmt = new javax.swing.JLabel();
        HostelFAmt = new javax.swing.JLabel();
        LibraryFAmt = new javax.swing.JLabel();
        ExamFAmt = new javax.swing.JLabel();
        MiscFAmt = new javax.swing.JLabel();
        TotalFAmt = new javax.swing.JLabel();
        make_payment = new javax.swing.JButton();
        Attendance = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        AttTable = new javax.swing.JTable();
        Assignments = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        Assignment_course1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ACT1 = new javax.swing.JTable();
        Assignment_course2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ACT2 = new javax.swing.JTable();
        Assignment_course3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ACT3 = new javax.swing.JTable();
        Assignment_course4 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        ACT4 = new javax.swing.JTable();
        Assignment_course5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ACT5 = new javax.swing.JTable();
        GradeCard = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        GC = new javax.swing.JTable();
        Settings = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        passChange = new javax.swing.JPanel();
        Lcurpass = new javax.swing.JLabel();
        curPass = new javax.swing.JPasswordField();
        Lnewpass = new javax.swing.JLabel();
        Lconpass = new javax.swing.JLabel();
        newPass = new javax.swing.JPasswordField();
        conPass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        Logout = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LName.setText("Name: ");

        LRoll.setText("Roll No: ");

        LBranch.setText("Branch: ");

        LBatch.setText("Batch: ");

        LHostel.setText("Hostel: ");

        LMob.setText("Mob: ");

        LSemester.setText("Semester: ");

        LRoom.setText("Room: ");

        LFather.setText("Father's Name: ");

        Lmother.setText("Mother's name");

        LParentContact.setText("Parent's Contact No:");

        name.setText("name");

        roll.setText("roll");

        branch.setText("branch");

        batch.setText("batch");

        semester.setText("semester");

        room.setText("room");

        hostel.setText("hostel");

        mob.setText("mob");

        father.setText("father");

        mother.setText("mother");

        parent_mob.setText("parent mob");

        javax.swing.GroupLayout PersonalDetailsLayout = new javax.swing.GroupLayout(PersonalDetails);
        PersonalDetails.setLayout(PersonalDetailsLayout);
        PersonalDetailsLayout.setHorizontalGroup(
            PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalDetailsLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PersonalDetailsLayout.createSequentialGroup()
                        .addComponent(LParentContact)
                        .addGap(18, 18, 18)
                        .addComponent(parent_mob)
                        .addContainerGap(304, Short.MAX_VALUE))
                    .addGroup(PersonalDetailsLayout.createSequentialGroup()
                        .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LName)
                            .addComponent(LRoll)
                            .addComponent(Lmother)
                            .addComponent(LFather)
                            .addComponent(LMob)
                            .addComponent(LHostel)
                            .addComponent(LRoom)
                            .addComponent(LBatch)
                            .addComponent(LBranch)
                            .addComponent(LSemester))
                        .addGap(40, 40, 40)
                        .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PersonalDetailsLayout.createSequentialGroup()
                                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(roll)
                                    .addComponent(name))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(PersonalDetailsLayout.createSequentialGroup()
                                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(branch)
                                    .addComponent(batch)
                                    .addComponent(semester)
                                    .addComponent(room)
                                    .addComponent(hostel)
                                    .addComponent(mob)
                                    .addComponent(father)
                                    .addComponent(mother))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        PersonalDetailsLayout.setVerticalGroup(
            PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PersonalDetailsLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LName)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LRoll)
                    .addComponent(roll))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBranch)
                    .addComponent(branch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LBatch)
                    .addComponent(batch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LSemester)
                    .addComponent(semester))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LRoom)
                    .addComponent(room))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LHostel)
                    .addComponent(hostel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LMob)
                    .addComponent(mob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LFather)
                    .addComponent(father))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lmother)
                    .addComponent(mother))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LParentContact)
                    .addComponent(parent_mob))
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Personal Details", PersonalDetails);

        course1.setText("Course 1: ");

        course2.setText("Course 2: ");

        course3.setText("Course 3: ");

        course4.setText("Course 4: ");

        course5.setText("Course 5: ");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bConfirmSubmission.setText("Confirm Submission");
        bConfirmSubmission.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bConfirmSubmissionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PreRegistrationLayout = new javax.swing.GroupLayout(PreRegistration);
        PreRegistration.setLayout(PreRegistrationLayout);
        PreRegistrationLayout.setHorizontalGroup(
            PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PreRegistrationLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bConfirmSubmission)
                    .addGroup(PreRegistrationLayout.createSequentialGroup()
                        .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(course1)
                            .addComponent(course2)
                            .addComponent(course3)
                            .addComponent(course4)
                            .addComponent(course5))
                        .addGap(40, 40, 40)
                        .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(344, Short.MAX_VALUE))
        );
        PreRegistrationLayout.setVerticalGroup(
            PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PreRegistrationLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course2)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course4)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PreRegistrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(course5)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bConfirmSubmission)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("PreRegistration", PreRegistration);

        LFApplicable.setText("*Fee payment not Applicable");

        LCourseF.setText("Course Fee: ");

        LHostelF.setText("Hostel Fee: ");

        LLibraryF.setText("Library Fee:");

        LExamF.setText("Exam Fee:");

        LMiscF.setText("Misc. Fee:");

        LTotalF.setText("Total:");

        CourseFAmt.setText("25000");

        HostelFAmt.setText("15000");

        LibraryFAmt.setText("1000");

        ExamFAmt.setText("2500");

        MiscFAmt.setText("500");

        TotalFAmt.setText("44000");

        make_payment.setText("Make Payment");
        make_payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                make_paymentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaymentLayout = new javax.swing.GroupLayout(Payment);
        Payment.setLayout(PaymentLayout);
        PaymentLayout.setHorizontalGroup(
            PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LFApplicable)
                    .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(make_payment)
                        .addGroup(PaymentLayout.createSequentialGroup()
                            .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LCourseF)
                                .addComponent(LHostelF)
                                .addComponent(LLibraryF)
                                .addComponent(LExamF)
                                .addComponent(LMiscF)
                                .addComponent(LTotalF))
                            .addGap(18, 18, 18)
                            .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TotalFAmt)
                                .addComponent(MiscFAmt)
                                .addComponent(ExamFAmt)
                                .addComponent(LibraryFAmt)
                                .addComponent(HostelFAmt)
                                .addComponent(CourseFAmt)))))
                .addContainerGap(274, Short.MAX_VALUE))
        );
        PaymentLayout.setVerticalGroup(
            PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaymentLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LFApplicable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LCourseF)
                    .addComponent(CourseFAmt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LHostelF)
                    .addComponent(HostelFAmt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LLibraryF)
                    .addComponent(LibraryFAmt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LExamF)
                    .addComponent(ExamFAmt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LMiscF)
                    .addComponent(MiscFAmt))
                .addGap(18, 18, 18)
                .addGroup(PaymentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LTotalF)
                    .addComponent(TotalFAmt))
                .addGap(18, 18, 18)
                .addComponent(make_payment)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Fee Payment", Payment);

        AttTable.setModel(new javax.swing.table.DefaultTableModel(
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
        AttTable.setEnabled(false);
        jScrollPane7.setViewportView(AttTable);

        javax.swing.GroupLayout AttendanceLayout = new javax.swing.GroupLayout(Attendance);
        Attendance.setLayout(AttendanceLayout);
        AttendanceLayout.setHorizontalGroup(
            AttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );
        AttendanceLayout.setVerticalGroup(
            AttendanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Attendance", Attendance);

        jTabbedPane4.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        ACT1.setModel(new javax.swing.table.DefaultTableModel(
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
        ACT1.setEnabled(false);
        jScrollPane1.setViewportView(ACT1);

        javax.swing.GroupLayout Assignment_course1Layout = new javax.swing.GroupLayout(Assignment_course1);
        Assignment_course1.setLayout(Assignment_course1Layout);
        Assignment_course1Layout.setHorizontalGroup(
            Assignment_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Assignment_course1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Assignment_course1Layout.setVerticalGroup(
            Assignment_course1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Assignment_course1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Course 1", Assignment_course1);

        ACT2.setModel(new javax.swing.table.DefaultTableModel(
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
        ACT2.setEnabled(false);
        jScrollPane2.setViewportView(ACT2);

        javax.swing.GroupLayout Assignment_course2Layout = new javax.swing.GroupLayout(Assignment_course2);
        Assignment_course2.setLayout(Assignment_course2Layout);
        Assignment_course2Layout.setHorizontalGroup(
            Assignment_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Assignment_course2Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Assignment_course2Layout.setVerticalGroup(
            Assignment_course2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Assignment_course2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Course 2", Assignment_course2);

        ACT3.setModel(new javax.swing.table.DefaultTableModel(
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
        ACT3.setEnabled(false);
        jScrollPane3.setViewportView(ACT3);

        javax.swing.GroupLayout Assignment_course3Layout = new javax.swing.GroupLayout(Assignment_course3);
        Assignment_course3.setLayout(Assignment_course3Layout);
        Assignment_course3Layout.setHorizontalGroup(
            Assignment_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        Assignment_course3Layout.setVerticalGroup(
            Assignment_course3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("Course 3", Assignment_course3);

        ACT4.setModel(new javax.swing.table.DefaultTableModel(
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
        ACT4.setEnabled(false);
        jScrollPane4.setViewportView(ACT4);

        javax.swing.GroupLayout Assignment_course4Layout = new javax.swing.GroupLayout(Assignment_course4);
        Assignment_course4.setLayout(Assignment_course4Layout);
        Assignment_course4Layout.setHorizontalGroup(
            Assignment_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Assignment_course4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Assignment_course4Layout.setVerticalGroup(
            Assignment_course4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Assignment_course4Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 36, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Course 4", Assignment_course4);

        ACT5.setModel(new javax.swing.table.DefaultTableModel(
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
        ACT5.setEnabled(false);
        jScrollPane5.setViewportView(ACT5);

        javax.swing.GroupLayout Assignment_course5Layout = new javax.swing.GroupLayout(Assignment_course5);
        Assignment_course5.setLayout(Assignment_course5Layout);
        Assignment_course5Layout.setHorizontalGroup(
            Assignment_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Assignment_course5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        Assignment_course5Layout.setVerticalGroup(
            Assignment_course5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Assignment_course5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Course 5", Assignment_course5);

        javax.swing.GroupLayout AssignmentsLayout = new javax.swing.GroupLayout(Assignments);
        Assignments.setLayout(AssignmentsLayout);
        AssignmentsLayout.setHorizontalGroup(
            AssignmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        AssignmentsLayout.setVerticalGroup(
            AssignmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("Assignments", Assignments);

        GC.setModel(new javax.swing.table.DefaultTableModel(
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
        GC.setEnabled(false);
        jScrollPane6.setViewportView(GC);

        javax.swing.GroupLayout GradeCardLayout = new javax.swing.GroupLayout(GradeCard);
        GradeCard.setLayout(GradeCardLayout);
        GradeCardLayout.setHorizontalGroup(
            GradeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );
        GradeCardLayout.setVerticalGroup(
            GradeCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Grade Card", GradeCard);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        Lcurpass.setText("Current Password:");

        Lnewpass.setText("New Password:");

        Lconpass.setText("Confirm Password:");

        newPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPassActionPerformed(evt);
            }
        });

        jButton2.setText("Change");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passChangeLayout = new javax.swing.GroupLayout(passChange);
        passChange.setLayout(passChangeLayout);
        passChangeLayout.setHorizontalGroup(
            passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passChangeLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(passChangeLayout.createSequentialGroup()
                        .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Lcurpass)
                            .addComponent(Lnewpass))
                        .addGap(18, 18, 18)
                        .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(curPass, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(newPass)))
                    .addGroup(passChangeLayout.createSequentialGroup()
                        .addComponent(Lconpass)
                        .addGap(18, 18, 18)
                        .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(conPass, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap(151, Short.MAX_VALUE))
        );
        passChangeLayout.setVerticalGroup(
            passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passChangeLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lcurpass)
                    .addComponent(curPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lnewpass)
                    .addComponent(newPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(passChangeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Lconpass)
                    .addComponent(conPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Change Password", passChange);

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
                .addGap(150, 150, 150)
                .addComponent(jButton1)
                .addContainerGap(154, Short.MAX_VALUE))
        );
        LogoutLayout.setVerticalGroup(
            LogoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogoutLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jButton1)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Logout", Logout);

        javax.swing.GroupLayout SettingsLayout = new javax.swing.GroupLayout(Settings);
        Settings.setLayout(SettingsLayout);
        SettingsLayout.setHorizontalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
            .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane3))
        );
        SettingsLayout.setVerticalGroup(
            SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
            .addGroup(SettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane3))
        );

        jTabbedPane1.addTab("Settings", Settings);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bConfirmSubmissionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bConfirmSubmissionActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String cid[]=new String[5];
            String cname[]=new String[5];
            String cp[]=new String[5];
            for(int i=0;i<5;++i)
            {
                String temp;
                if(i==0)
                    temp=jComboBox1.getSelectedItem().toString();
                else if(i==1)
                    temp=jComboBox2.getSelectedItem().toString();
                else if(i==2)
                    temp=jComboBox3.getSelectedItem().toString();
                else if(i==3)
                    temp=jComboBox4.getSelectedItem().toString();
                else
                    temp=jComboBox5.getSelectedItem().toString();
                int j=0;
                for(j=1;j<6;++j)
                {
                    if(j==1)
                        cid[i]=""+temp.charAt(j);
                    else
                    {
                        cid[i]=cid[i]+temp.charAt(j);
                    }
                }
                for(j=7;temp.charAt(j)!='-';++j)
                {
                    if(j==7)
                        cname[i]=""+temp.charAt(j);
                    else
                    {
                        cname[i]=cname[i]+temp.charAt(j);
                    }
                }
                int k=j+1;
                for(k=j+1;k<temp.length();++k)
                {
                    if(k==j+1)
                        cp[i]=""+temp.charAt(k);
                    else
                    {
                        cp[i]=cp[i]+temp.charAt(k);
                    }
                }
                System.out.println(cid[i]+" "+cname[i]+" "+cp[i]);
            }
            
            String facad="";
            String query="Select * from `facad` where branch='"+BR+"' and batch='"+BT+"'";
            System.out.println(query);
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                facad=rs.getString("prof");
            }
            query="delete from preregistration where `sid`='"+ID+"'";
            System.out.println(query);
            Statement stmt2=con.createStatement();
            int rowsUpdated=stmt2.executeUpdate(query);
            System.out.println(rowsUpdated);
            query="INSERT INTO `preregistration`(`sid`,`name`,`batch`, `course1`, `course2`, `course3`, `course4`, `course5`, `course1name`, `course2name`, `course3name`, `course4name`, `course5name`, `prof1`, `prof2`, `prof3`, `prof4`, `prof5`, `advisor`) VALUES ('"+ID+"','"+NM+"','"+BT+"','"+cid[0]+"','"+cid[1]+"','"+cid[2]+"','"+cid[3]+"','"+cid[4]+"','"+cname[0]+"','"+cname[1]+"','"+cname[2]+"','"+cname[3]+"','"+cname[4]+"','"+cp[0]+"','"+cp[1]+"','"+cp[2]+"','"+cp[3]+"','"+cp[4]+"','"+facad+"')";
            System.out.println(query);
            stmt2=con.createStatement();
            rowsUpdated=stmt2.executeUpdate(query);
            /*if(rowsUpdated>0)
            {
                make_payment.setVisible(true);
            }*/
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bConfirmSubmissionActionPerformed

    private void newPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPassActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="select * from slogin where id='"+ID+"'";
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
                        query="update slogin set `pass`='"+newPass.getText().toString()+"' where `id`='"+ID+"'";
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void make_paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_make_paymentActionPerformed
        // TODO add your handling code here:
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=null;
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/SIMS","root","");
            if(con==null)
                JOptionPane.showMessageDialog(this, "Unable to Connect to server!!!");
            String query="INSERT INTO `feepayment`(`sid`, `amount`) VALUES ('"+ID+"','44000')";
            System.out.println(query);
            Statement stmt=con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(this, "Payment");
            make_payment.setVisible(false);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_make_paymentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.out.println("Logout");
        new mainPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SHP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SHP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ACT1;
    private javax.swing.JTable ACT2;
    private javax.swing.JTable ACT3;
    private javax.swing.JTable ACT4;
    private javax.swing.JTable ACT5;
    private javax.swing.JPanel Assignment_course1;
    private javax.swing.JPanel Assignment_course2;
    private javax.swing.JPanel Assignment_course3;
    private javax.swing.JPanel Assignment_course4;
    private javax.swing.JPanel Assignment_course5;
    private javax.swing.JPanel Assignments;
    private javax.swing.JTable AttTable;
    private javax.swing.JPanel Attendance;
    private javax.swing.JLabel CourseFAmt;
    private javax.swing.JLabel ExamFAmt;
    private javax.swing.JTable GC;
    private javax.swing.JPanel GradeCard;
    private javax.swing.JLabel HostelFAmt;
    private javax.swing.JLabel LBatch;
    private javax.swing.JLabel LBranch;
    private javax.swing.JLabel LCourseF;
    private javax.swing.JLabel LExamF;
    private javax.swing.JLabel LFApplicable;
    private javax.swing.JLabel LFather;
    private javax.swing.JLabel LHostel;
    private javax.swing.JLabel LHostelF;
    private javax.swing.JLabel LLibraryF;
    private javax.swing.JLabel LMiscF;
    private javax.swing.JLabel LMob;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LParentContact;
    private javax.swing.JLabel LRoll;
    private javax.swing.JLabel LRoom;
    private javax.swing.JLabel LSemester;
    private javax.swing.JLabel LTotalF;
    private javax.swing.JLabel Lconpass;
    private javax.swing.JLabel Lcurpass;
    private javax.swing.JLabel LibraryFAmt;
    private javax.swing.JLabel Lmother;
    private javax.swing.JLabel Lnewpass;
    private javax.swing.JPanel Logout;
    private javax.swing.JLabel MiscFAmt;
    private javax.swing.JPanel Payment;
    private javax.swing.JPanel PersonalDetails;
    private javax.swing.JPanel PreRegistration;
    private javax.swing.JPanel Settings;
    private javax.swing.JLabel TotalFAmt;
    private javax.swing.JButton bConfirmSubmission;
    private javax.swing.JLabel batch;
    private javax.swing.JLabel branch;
    private javax.swing.JPasswordField conPass;
    private javax.swing.JLabel course1;
    private javax.swing.JLabel course2;
    private javax.swing.JLabel course3;
    private javax.swing.JLabel course4;
    private javax.swing.JLabel course5;
    private javax.swing.JPasswordField curPass;
    private javax.swing.JLabel father;
    private javax.swing.JLabel hostel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JButton make_payment;
    private javax.swing.JLabel mob;
    private javax.swing.JLabel mother;
    private javax.swing.JLabel name;
    private javax.swing.JPasswordField newPass;
    private javax.swing.JLabel parent_mob;
    private javax.swing.JPanel passChange;
    private javax.swing.JLabel roll;
    private javax.swing.JLabel room;
    private javax.swing.JLabel semester;
    // End of variables declaration//GEN-END:variables
}
