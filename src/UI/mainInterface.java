package UI;

import Classes.CustomerIdComboGenerator;
import Classes.Country;
import Classes.dataValidator;
import java.awt.Color;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import Classes.databaseConnections;
import Classes.IDGenerators;
import javax.swing.JOptionPane;
import Classes.globalVars;
import Classes.AutoCompletion;


import static Classes.tableDataLoading.customerTableRefresh;
import static Classes.tableDataLoading.reservationTableRefresh;
import static Classes.tableDataLoading.roomTypeTblRefresh;
import static Classes.tableDataLoading.billPackagesTblRefresh;
import static Classes.tableDataLoading.billRoomChargeTblrefresh;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.table.DefaultTableModel;

public class mainInterface extends javax.swing.JFrame {
    
    //used to calculate the total guest count
    public  void totalGuestCount(){
        int kids = 0;
        int adults = 0;
    if (resAdultTxt.getText().matches("[0-9]+") && dataValidator.oneValidator(resAdultTxt)) {
                adults = Integer.parseInt(resAdultTxt.getText());
            } else{
                adults = 0;
            }
    if (reskidsTxt.getText().matches("[0-9]+") && dataValidator.oneValidator(reskidsTxt)) {
                kids = Integer.parseInt(reskidsTxt.getText());
            } else{
                kids = 0;
            }
        
     totalGuests.setText(Integer.toString(adults+kids));
    
    }
    

    //used to refresh panes when switching from one tab to another
    public void refreshCustomer() {
        customerTableRefresh(cusTable.getModel());

    }

    public void refreshReservation() {
        resIDSearchJcombo.removeAllItems();
        CustomerIdComboGenerator.loadCustomerID(resIDSearchJcombo);
        reservationTableRefresh(resReservationTbl.getModel());

    }
    
    
    public void refreshStaff() {
        custIdStaff.removeAllItems();
        CustomerIdComboGenerator.loadCustomerIDStaffAssign(custIdStaff);
        

    }
    
    public void setAllPaneNotSelected(){
        custPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); 
        resPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png")));
        staffPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png")));
        BillPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png")));
    
    }

    // use to set the border to red usue a hidden sample border to get and set attributes
    public static Border BorderError() {
        Border border;
        return border = new LineBorder(Color.RED, 2, true);
    }

    public static Border Bordergood() {

        return sampleTxtField.getBorder();

    }

    public void clearCustomerPane() {
        clearFlds(Arrays.asList(custIDTxt, nicTxt, fNamTxt, lNameTxt, phoneNo1Txt, phoneNo2Txt, emailTxt));
        addressTxt.setText("");
        addressTxt.setBorder(Bordergood());

    }
    public  void clearReservationPane(){
        clearFlds(Arrays.asList(reservationIdTxt,resCustNameTxt,resAdultTxt,reskidsTxt,resPremiumRoomTxt,resRoyalRoomTxt,resExecutiveRoomTxt,totalGuests));
        arrivalDate.setDate(null);
        departDate.setDate(null);
        
        // cleans the global variables as it may cause errors if not cleared
        globalVars.exeSelected.clear();
        globalVars.premiumSelected.clear();
        globalVars.royalSelected.clear();
        
        DefaultTableModel rooms = (DefaultTableModel) resAvailableRoomTbl.getModel();
        rooms.setRowCount(0);
        
        roomTypes.clearSelection();
        
        
        reservationTableRefresh(resReservationTbl.getModel());
        
        
         resRoyalTick.setForeground(Color.BLACK);
         resPremiumtick.setForeground(Color.BLACK);
         resExecutiveTick.setForeground(Color.BLACK);
         
        
        refreshReservation();

        //use arrivalDate.setDate(new Date()); to set to today
        
      
         
        

    }
    
    // used to remove the temporarily selected room types from the table
    public void remTempSelected(ArrayList<String> releventArrLst){
                   DefaultTableModel removeRowTep = (DefaultTableModel) resAvailableRoomTbl.getModel();
           
               if(!releventArrLst.isEmpty()){
             for (String roomNo : releventArrLst) {
                 
           	for (int i = 0; i < resAvailableRoomTbl.getRowCount(); i++) {
                    
                if (resAvailableRoomTbl.getValueAt(i, 0).toString().matches(roomNo)) {
                    removeRowTep.removeRow(i);
                    
                }
              }
             }
                  }
    
    }
    

// use for clearing the text fields
    public void clearFlds(List<JTextField> textFields) {
        for (JTextField jflds : textFields) {
            jflds.setText("");
            jflds.setBorder(Bordergood());
        }
    }

    private Country[] createCountryList() {
        String[] countryCodes = Locale.getISOCountries();
        Country[] listCountry = new Country[countryCodes.length];

        for (int i = 0; i < countryCodes.length; i++) {
            Locale locale = new Locale("", countryCodes[i]);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            listCountry[i] = new Country(code, name);
        }

        Arrays.sort(listCountry);

        return listCountry;
    }
    Country[] listCountry = createCountryList();

   
    public mainInterface() {
        initComponents();
        setResizable(false);
        setSize(1030, 768);
        Classes.tableDataLoading.customerTableRefresh(cusTable.getModel());
        
        
        
        
        
       
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        roomTypes = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        titlePane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        CustomerPane = new javax.swing.JPanel();
        tableScroller = new javax.swing.JScrollPane();
        cusTable = new javax.swing.JTable();
        custInfoAddScroller = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        clearBtn = new javax.swing.JButton();
        custIDTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nicTxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fNamTxt = new javax.swing.JTextField();
        lNameTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        phoneNo1Txt = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        phoneNo2 = new javax.swing.JLabel();
        phoneNo2Txt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        addressTxt = new javax.swing.JTextArea();
        countryList = new javax.swing.JComboBox<>(listCountry);
        countryList.setSelectedItem(listCountry[201]);
AutoCompletion.enable(countryList);
        updateBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        sampleTxtField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reservationPane = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        resAvailableRoomTbl = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        Reservation = new javax.swing.JPanel();
        resPackageSelector = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        reservationIdTxt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        resCustNameTxt = new javax.swing.JTextField();
        resPremiumRoomTxt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        resAdultTxt = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        resPremiumtick = new javax.swing.JCheckBox();
        resExecutiveTick = new javax.swing.JCheckBox();
        resRoyalTick = new javax.swing.JCheckBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        reskidsTxt = new javax.swing.JTextField();
        resRoyalRoomTxt = new javax.swing.JTextField();
        resUpdateBtn = new javax.swing.JButton();
        resExecutiveRoomTxt = new javax.swing.JTextField();
        resSubmitBtn = new javax.swing.JButton();
        resClearBtn = new javax.swing.JButton();
        resAddRoomBtn = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        arrivalDate = new com.toedter.calendar.JDateChooser();
        JTextFieldDateEditor arrivalDateTxt = (JTextFieldDateEditor) arrivalDate.getDateEditor();
        arrivalDateTxt.setEditable(false);

        resIDSearchJcombo = new javax.swing.JComboBox<>();
        custIdOK = new javax.swing.JButton();
        departDate = new com.toedter.calendar.JDateChooser();
        JTextFieldDateEditor departDateTxt = (JTextFieldDateEditor) departDate.getDateEditor();
        departDateTxt.setEditable(false);
        jLabel34 = new javax.swing.JLabel();
        royalRemoveBtn = new javax.swing.JButton();
        premiumRemoveBtn = new javax.swing.JButton();
        executRemoveBtn = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        totalGuests = new javax.swing.JTextField();
        resDeleteBtn = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        resReservationTbl = new javax.swing.JTable();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        StaffAssign = new javax.swing.JPanel();
        custInfoAddScroller1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        roomTypesFrm = new javax.swing.JScrollPane();
        roomTypeContainer = new javax.swing.JPanel();
        custIdStaff = new javax.swing.JComboBox<>();
        stafflCustName = new javax.swing.JTextField();
        test = new javax.swing.JButton();
        notifyStaffBtn = new javax.swing.JButton();
        BillingPane = new javax.swing.JPanel();
        custInfoAddScroller2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        bilCustId = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        bilCustName = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        roomChargesBil = new javax.swing.JTable();
        totalRoomCharges = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        packageChargesBil = new javax.swing.JTable();
        totalPackageChargeBil = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        extraChargeTick = new javax.swing.JCheckBox();
        extraChargesBil = new javax.swing.JTextField();
        generateBillBtn = new javax.swing.JButton();
        totalChargeBil = new javax.swing.JTextField();
        checkoutBtnBil = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        menusPane = new javax.swing.JPanel();
        CustomerBtnPane = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        custPaneLbl = new javax.swing.JLabel();
        reservationBtnPane = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        resPaneLbl = new javax.swing.JLabel();
        BillingBtnPane = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        BillPaneLbl = new javax.swing.JLabel();
        StaffAssignBtnPane1 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        staffPaneLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hotel Management System");
        setMinimumSize(new java.awt.Dimension(1024, 768));

        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titlePane.setBackground(new java.awt.Color(255, 255, 255));
        titlePane.setEnabled(false);
        titlePane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(210, 210, 210));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        titlePane.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, 10));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saii holiday inn.png"))); // NOI18N
        jLabel28.setText("jLabel28");
        titlePane.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 362, 95));

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/particle.png"))); // NOI18N
        jLabel37.setText("jLabel36");
        titlePane.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, -30, 190, 180));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/particle.png"))); // NOI18N
        jLabel38.setText("jLabel36");
        titlePane.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, -30, 190, 180));

        jPanel1.add(titlePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1030, 130));

        CustomerPane.setBackground(new java.awt.Color(255, 255, 255));

        tableScroller.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableScrollerMouseClicked(evt);
            }
        });

        cusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "First Name", "Last Name", "NIC No", "Address", "Country", "E-mail", "Contact No 1", "Contact No 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        cusTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        cusTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cusTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cusTable.getTableHeader().setReorderingAllowed(false);
        cusTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cusTableMouseClicked(evt);
            }
        });
        tableScroller.setViewportView(cusTable);
        if (cusTable.getColumnModel().getColumnCount() > 0) {
            cusTable.getColumnModel().getColumn(0).setMinWidth(100);
            cusTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(1).setMinWidth(100);
            cusTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(2).setMinWidth(100);
            cusTable.getColumnModel().getColumn(2).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(3).setMinWidth(100);
            cusTable.getColumnModel().getColumn(3).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(4).setMinWidth(100);
            cusTable.getColumnModel().getColumn(4).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(5).setMinWidth(100);
            cusTable.getColumnModel().getColumn(5).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(6).setMinWidth(100);
            cusTable.getColumnModel().getColumn(6).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(7).setMinWidth(100);
            cusTable.getColumnModel().getColumn(7).setPreferredWidth(100);
            cusTable.getColumnModel().getColumn(8).setMinWidth(100);
            cusTable.getColumnModel().getColumn(8).setPreferredWidth(100);
        }

        custInfoAddScroller.setBackground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller.setBorder(null);
        custInfoAddScroller.setForeground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        custInfoAddScroller.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        custIDTxt.setEditable(false);
        custIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIDTxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel3.setText("Customer ID");

        jLabel4.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel4.setText("NIC no / Passport no");

        nicTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicTxtActionPerformed(evt);
            }
        });
        nicTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nicTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nicTxtKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel5.setText("Customer Name");

        fNamTxt.setText("First Name");
        fNamTxt.setToolTipText("First Name");
        fNamTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fNamTxtActionPerformed(evt);
            }
        });

        lNameTxt.setText("Last Name");
        lNameTxt.setToolTipText("Last Name");
        lNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lNameTxtActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel7.setText("Address");

        jLabel8.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel8.setText("Contact no 1");

        phoneNo1Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNo1TxtActionPerformed(evt);
            }
        });
        phoneNo1Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNo1TxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNo1TxtKeyReleased(evt);
            }
        });

        email.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        email.setText("Email");

        emailTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTxtActionPerformed(evt);
            }
        });
        emailTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                emailTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                emailTxtKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel10.setText("Country");

        phoneNo2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        phoneNo2.setText("Contact no 2");

        phoneNo2Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneNo2TxtActionPerformed(evt);
            }
        });
        phoneNo2Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneNo2TxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                phoneNo2TxtKeyReleased(evt);
            }
        });

        addressTxt.setColumns(20);
        addressTxt.setRows(5);
        jScrollPane1.setViewportView(addressTxt);

        countryList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryListActionPerformed(evt);
            }
        });

        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        sampleTxtField.setText("jTextField3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(117, 117, 117)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(fNamTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nicTxt)))))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(phoneNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phoneNo1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(phoneNo2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(addBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(updateBtn)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(229, 229, 229)
                                        .addComponent(sampleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(deleteBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(clearBtn))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(emailTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(countryList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(416, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sampleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nicTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNamTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(phoneNo1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNo2)
                    .addComponent(phoneNo2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(countryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(addBtn)
                    .addComponent(clearBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(173, Short.MAX_VALUE))
        );

        custInfoAddScroller.setViewportView(jPanel2);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/saiLogoSmall.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/customerLogo_1.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout CustomerPaneLayout = new javax.swing.GroupLayout(CustomerPane);
        CustomerPane.setLayout(CustomerPaneLayout);
        CustomerPaneLayout.setHorizontalGroup(
            CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custInfoAddScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(CustomerPaneLayout.createSequentialGroup()
                            .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPaneLayout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(74, 74, 74)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPaneLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        CustomerPaneLayout.setVerticalGroup(
            CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerPaneLayout.createSequentialGroup()
                        .addComponent(custInfoAddScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(CustomerPaneLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        tabbedPane.addTab("tab1", CustomerPane);

        reservationPane.setBackground(new java.awt.Color(255, 255, 255));

        resAvailableRoomTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Room Number", "Price Per night (Rs.)", "No of Guests"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resAvailableRoomTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        resAvailableRoomTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resAvailableRoomTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resAvailableRoomTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(resAvailableRoomTbl);
        if (resAvailableRoomTbl.getColumnModel().getColumnCount() > 0) {
            resAvailableRoomTbl.getColumnModel().getColumn(0).setPreferredWidth(50);
            resAvailableRoomTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            resAvailableRoomTbl.getColumnModel().getColumn(2).setPreferredWidth(75);
        }

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Reservation.setBackground(new java.awt.Color(210, 210, 210));

        resPackageSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full board", "Half board" }));
        resPackageSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resPackageSelectorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel6.setText("Reservation ID");

        reservationIdTxt.setEditable(false);
        reservationIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationIdTxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel9.setText("Customer ID");

        jLabel11.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel11.setText("Customer Name");

        resCustNameTxt.setEditable(false);
        resCustNameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resCustNameTxtActionPerformed(evt);
            }
        });

        resPremiumRoomTxt.setEditable(false);
        resPremiumRoomTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resPremiumRoomTxtActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel12.setText("Package");

        jLabel13.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel13.setText("Guests");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setText("Adults");

        resAdultTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resAdultTxtActionPerformed(evt);
            }
        });
        resAdultTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                resAdultTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                resAdultTxtKeyReleased(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Type");

        roomTypes.add(resPremiumtick);
        resPremiumtick.setText("Premium");
        resPremiumtick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resPremiumtickActionPerformed(evt);
            }
        });

        roomTypes.add(resExecutiveTick);
        resExecutiveTick.setText("Executive");
        resExecutiveTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resExecutiveTickActionPerformed(evt);
            }
        });

        roomTypes.add(resRoyalTick);
        resRoyalTick.setText("Royal");
        resRoyalTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resRoyalTickActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel16.setText("Rooms");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Rooms");

        reskidsTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reskidsTxtActionPerformed(evt);
            }
        });
        reskidsTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                reskidsTxtKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                reskidsTxtKeyReleased(evt);
            }
        });

        resRoyalRoomTxt.setEditable(false);
        resRoyalRoomTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resRoyalRoomTxtActionPerformed(evt);
            }
        });

        resUpdateBtn.setText("Update");
        resUpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resUpdateBtnActionPerformed(evt);
            }
        });

        resExecutiveRoomTxt.setEditable(false);
        resExecutiveRoomTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resExecutiveRoomTxtActionPerformed(evt);
            }
        });

        resSubmitBtn.setText("Submit");
        resSubmitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resSubmitBtnActionPerformed(evt);
            }
        });

        resClearBtn.setText("Clear");
        resClearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resClearBtnActionPerformed(evt);
            }
        });

        resAddRoomBtn.setText("<< Add room");
        resAddRoomBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resAddRoomBtnActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel18.setText("Check Out Date");

        jLabel19.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel19.setText("Check IN Date");

        arrivalDate.setDateFormatString("yyyy-MM-dd");
        arrivalDate.setMaxSelectableDate(new java.util.Date(253370748685000L));

        resIDSearchJcombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resIDSearchJcomboActionPerformed(evt);
            }
        });

        custIdOK.setText("Load");
        custIdOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIdOKActionPerformed(evt);
            }
        });

        departDate.setDateFormatString("yyyy-MM-dd");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setText("Kids");

        royalRemoveBtn.setText("X");
        royalRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                royalRemoveBtnActionPerformed(evt);
            }
        });

        premiumRemoveBtn.setText("X");
        premiumRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                premiumRemoveBtnActionPerformed(evt);
            }
        });

        executRemoveBtn.setText("X");
        executRemoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                executRemoveBtnActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel35.setText("Total Guests");

        totalGuests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalGuestsActionPerformed(evt);
            }
        });

        resDeleteBtn.setText("Delete");
        resDeleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resDeleteBtnActionPerformed(evt);
            }
        });

        CustomerIdComboGenerator.loadCustomerID(resIDSearchJcombo);  AutoCompletion.enable(resIDSearchJcombo);

        javax.swing.GroupLayout ReservationLayout = new javax.swing.GroupLayout(Reservation);
        Reservation.setLayout(ReservationLayout);
        ReservationLayout.setHorizontalGroup(
            ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationLayout.createSequentialGroup()
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReservationLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(resSubmitBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resClearBtn)
                                .addGap(24, 24, 24)
                                .addComponent(resUpdateBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(resDeleteBtn))
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(resPremiumtick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(resExecutiveTick, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(resRoyalTick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(ReservationLayout.createSequentialGroup()
                                        .addComponent(resPremiumRoomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(premiumRemoveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReservationLayout.createSequentialGroup()
                                        .addComponent(resRoyalRoomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(royalRemoveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(ReservationLayout.createSequentialGroup()
                                        .addComponent(resExecutiveRoomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(executRemoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resAddRoomBtn))
                            .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(ReservationLayout.createSequentialGroup()
                                    .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ReservationLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(19, 19, 19)))
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(73, 73, 73)
                                    .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(resAdultTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(resPackageSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(ReservationLayout.createSequentialGroup()
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(reskidsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(ReservationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reservationIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ReservationLayout.createSequentialGroup()
                                        .addComponent(resIDSearchJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(custIdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(ReservationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resCustNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(arrivalDate, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                        .addComponent(departDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        ReservationLayout.setVerticalGroup(
            ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReservationLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(reservationIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(custIdOK)
                    .addComponent(resIDSearchJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(resCustNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(arrivalDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(departDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resAdultTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reskidsTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalGuests, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resPackageSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resPremiumtick)
                    .addComponent(resPremiumRoomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(premiumRemoveBtn))
                .addGap(18, 18, 18)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resExecutiveTick)
                    .addComponent(resExecutiveRoomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resAddRoomBtn)
                    .addComponent(executRemoveBtn))
                .addGap(18, 18, 18)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resRoyalTick)
                    .addComponent(resRoyalRoomTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(royalRemoveBtn))
                .addGap(18, 18, 18)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resSubmitBtn)
                    .addComponent(resClearBtn)
                    .addComponent(resUpdateBtn)
                    .addComponent(resDeleteBtn))
                .addGap(34, 34, 34))
        );

        jScrollPane3.setViewportView(Reservation);

        resReservationTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "Customer Name", "Premium Rooms Count", "Executive Rooms Count", "Royal Rooms Count", "Check In Date", "Check Out Date", "Adult Guest Count", "Child Guest Count", "Package Type", "Customer ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        resReservationTbl.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        resReservationTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resReservationTbl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        resReservationTbl.getTableHeader().setReorderingAllowed(false);
        resReservationTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resReservationTblMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(resReservationTbl);
        if (resReservationTbl.getColumnModel().getColumnCount() > 0) {
            resReservationTbl.getColumnModel().getColumn(0).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(1).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(2).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(3).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(4).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(5).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(6).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(7).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(8).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(9).setPreferredWidth(100);
            resReservationTbl.getColumnModel().getColumn(10).setMinWidth(0);
            resReservationTbl.getColumnModel().getColumn(10).setPreferredWidth(0);
            resReservationTbl.getColumnModel().getColumn(10).setMaxWidth(0);
        }

        jLabel32.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel32.setText("Reservations");

        jLabel33.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel33.setText("Rooms");

        javax.swing.GroupLayout reservationPaneLayout = new javax.swing.GroupLayout(reservationPane);
        reservationPane.setLayout(reservationPaneLayout);
        reservationPaneLayout.setHorizontalGroup(
            reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(reservationPaneLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reservationPaneLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reservationPaneLayout.createSequentialGroup()
                        .addGroup(reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reservationPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reservationPaneLayout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, reservationPaneLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );
        reservationPaneLayout.setVerticalGroup(
            reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPaneLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel33)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPaneLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        tabbedPane.addTab("tab2", reservationPane);

        StaffAssign.setBackground(new java.awt.Color(217, 217, 217));

        custInfoAddScroller1.setBackground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller1.setBorder(null);
        custInfoAddScroller1.setForeground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        custInfoAddScroller1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel20.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel20.setText("Customer ID");

        jLabel21.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel21.setText("Customer Name");

        jLabel25.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel25.setText("Rooms reserved :");

        roomTypesFrm.setBackground(new java.awt.Color(255, 255, 255));
        roomTypesFrm.setForeground(new java.awt.Color(255, 255, 255));
        roomTypesFrm.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        roomTypeContainer.setBackground(new java.awt.Color(210, 210, 210));

        javax.swing.GroupLayout roomTypeContainerLayout = new javax.swing.GroupLayout(roomTypeContainer);
        roomTypeContainer.setLayout(roomTypeContainerLayout);
        roomTypeContainerLayout.setHorizontalGroup(
            roomTypeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 862, Short.MAX_VALUE)
        );
        roomTypeContainerLayout.setVerticalGroup(
            roomTypeContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        roomTypesFrm.setViewportView(roomTypeContainer);

        stafflCustName.setEditable(false);
        stafflCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stafflCustNameActionPerformed(evt);
            }
        });

        test.setText("Load");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
            }
        });

        notifyStaffBtn.setText("Notify the staff");
        notifyStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notifyStaffBtnActionPerformed(evt);
            }
        });

        CustomerIdComboGenerator.loadCustomerIDStaffAssign(custIdStaff);  AutoCompletion.enable(custIdStaff);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(custIdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(test)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stafflCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(roomTypesFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(notifyStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(custIdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stafflCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(test))
                .addGap(24, 24, 24)
                .addComponent(jLabel25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(roomTypesFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(notifyStaffBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        custInfoAddScroller1.setViewportView(jPanel3);

        javax.swing.GroupLayout StaffAssignLayout = new javax.swing.GroupLayout(StaffAssign);
        StaffAssign.setLayout(StaffAssignLayout);
        StaffAssignLayout.setHorizontalGroup(
            StaffAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(custInfoAddScroller1, javax.swing.GroupLayout.DEFAULT_SIZE, 830, Short.MAX_VALUE)
        );
        StaffAssignLayout.setVerticalGroup(
            StaffAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StaffAssignLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custInfoAddScroller1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("tab1", StaffAssign);

        BillingPane.setBackground(new java.awt.Color(210, 210, 210));

        custInfoAddScroller2.setBackground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller2.setBorder(null);
        custInfoAddScroller2.setForeground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        custInfoAddScroller2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(210, 210, 210));

        jLabel22.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel22.setText("Customer ID");

        jButton2.setText("Load");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel23.setText("Customer Name");

        bilCustName.setEditable(false);
        bilCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilCustNameActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel27.setText("Charges for the reserved rooms");

        roomChargesBil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "Room Number", "Charge Per Night (Rs.)", "Check In Date", "Check Out Date", "Number of Nights", "Total Room Charge (Rs.)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        roomChargesBil.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        roomChargesBil.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomChargesBil.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        roomChargesBil.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(roomChargesBil);
        if (roomChargesBil.getColumnModel().getColumnCount() > 0) {
            roomChargesBil.getColumnModel().getColumn(0).setPreferredWidth(100);
            roomChargesBil.getColumnModel().getColumn(1).setPreferredWidth(100);
            roomChargesBil.getColumnModel().getColumn(2).setPreferredWidth(100);
            roomChargesBil.getColumnModel().getColumn(3).setPreferredWidth(100);
            roomChargesBil.getColumnModel().getColumn(4).setPreferredWidth(100);
            roomChargesBil.getColumnModel().getColumn(5).setPreferredWidth(100);
            roomChargesBil.getColumnModel().getColumn(6).setPreferredWidth(100);
        }

        totalRoomCharges.setEditable(false);

        jLabel24.setText("Total Charge For The Rooms            Rs.");

        jLabel29.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jLabel29.setText("Charges for Selected Package");

        packageChargesBil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Reservation ID", "Package Type", "Charge per Night", "Total Nights", "Total Charge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        packageChargesBil.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(packageChargesBil);
        if (packageChargesBil.getColumnModel().getColumnCount() > 0) {
            packageChargesBil.getColumnModel().getColumn(0).setPreferredWidth(100);
            packageChargesBil.getColumnModel().getColumn(1).setPreferredWidth(100);
            packageChargesBil.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        totalPackageChargeBil.setEditable(false);
        totalPackageChargeBil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPackageChargeBilActionPerformed(evt);
            }
        });

        jLabel31.setText("Total Charge for the Packages  Rs.");

        extraChargeTick.setText("Liable Charges if any");
        extraChargeTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraChargeTickActionPerformed(evt);
            }
        });

        extraChargesBil.setEditable(false);
        extraChargesBil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraChargesBilActionPerformed(evt);
            }
        });
        extraChargesBil.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                extraChargesBilKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                extraChargesBilKeyReleased(evt);
            }
        });

        generateBillBtn.setText("Generate");
        generateBillBtn.setEnabled(false);
        generateBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillBtnActionPerformed(evt);
            }
        });

        checkoutBtnBil.setText("Checkout");
        checkoutBtnBil.setEnabled(false);
        checkoutBtnBil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnBilActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Montserrat", 1, 13)); // NOI18N
        jLabel41.setText("TOTAL CHARGE Rs.");

        CustomerIdComboGenerator.loadCustomerID(bilCustId);  AutoCompletion.enable(bilCustId);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(bilCustId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton2))
                            .addComponent(bilCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addGap(31, 31, 31)
                                .addComponent(totalRoomCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(totalChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(extraChargeTick, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(extraChargesBil, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(generateBillBtn)
                                            .addComponent(checkoutBtnBil))))
                                .addGap(214, 214, 214))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalPackageChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(bilCustId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(8, 8, 8)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(bilCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalRoomCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPackageChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extraChargeTick)
                    .addComponent(extraChargesBil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateBillBtn))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkoutBtnBil, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 16, 780, 670));

        custInfoAddScroller2.setViewportView(jPanel4);

        javax.swing.GroupLayout BillingPaneLayout = new javax.swing.GroupLayout(BillingPane);
        BillingPane.setLayout(BillingPaneLayout);
        BillingPaneLayout.setHorizontalGroup(
            BillingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingPaneLayout.createSequentialGroup()
                .addComponent(custInfoAddScroller2, javax.swing.GroupLayout.PREFERRED_SIZE, 816, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        BillingPaneLayout.setVerticalGroup(
            BillingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custInfoAddScroller2, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        tabbedPane.addTab("tab1", BillingPane);

        jPanel1.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 68, 830, 710));

        menusPane.setBackground(new java.awt.Color(210, 210, 210));

        CustomerBtnPane.setBackground(new java.awt.Color(210, 210, 210));
        CustomerBtnPane.setForeground(new java.awt.Color(210, 210, 210));
        CustomerBtnPane.setToolTipText("");
        CustomerBtnPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerBtnPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CustomerBtnPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CustomerBtnPaneMouseExited(evt);
            }
        });
        CustomerBtnPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setBackground(new java.awt.Color(0, 0, 0));
        jLabel26.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        jLabel26.setText("CUSTOMER");
        CustomerBtnPane.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 160, 60));

        custPaneLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        custPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/selected.png"))); // NOI18N
        custPaneLbl.setText("Customer");
        CustomerBtnPane.add(custPaneLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 10, 240, 80));

        reservationBtnPane.setBackground(new java.awt.Color(210, 210, 210));
        reservationBtnPane.setForeground(new java.awt.Color(210, 210, 210));
        reservationBtnPane.setToolTipText("");
        reservationBtnPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationBtnPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reservationBtnPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reservationBtnPaneMouseExited(evt);
            }
        });
        reservationBtnPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel36.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        jLabel36.setText("RESERVATIONS");
        reservationBtnPane.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 230, 50));

        resPaneLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        resPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        resPaneLbl.setText("Reservations");
        reservationBtnPane.add(resPaneLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 230, 110));

        BillingBtnPane.setBackground(new java.awt.Color(210, 210, 210));
        BillingBtnPane.setForeground(new java.awt.Color(210, 210, 210));
        BillingBtnPane.setToolTipText("");
        BillingBtnPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillingBtnPaneMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                BillingBtnPaneMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BillingBtnPaneMouseExited(evt);
            }
        });
        BillingBtnPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel39.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        jLabel39.setText("PAYMENTS");
        BillingBtnPane.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 30, 120, 50));

        BillPaneLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        BillPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        BillPaneLbl.setText("Billing");
        BillingBtnPane.add(BillPaneLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 240, 110));

        StaffAssignBtnPane1.setBackground(new java.awt.Color(210, 210, 210));
        StaffAssignBtnPane1.setForeground(new java.awt.Color(210, 210, 210));
        StaffAssignBtnPane1.setToolTipText("");
        StaffAssignBtnPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StaffAssignBtnPane1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StaffAssignBtnPane1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                StaffAssignBtnPane1MouseExited(evt);
            }
        });
        StaffAssignBtnPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel40.setFont(new java.awt.Font("Montserrat SemiBold", 1, 18)); // NOI18N
        jLabel40.setText(" ASSIGN STAFF");
        StaffAssignBtnPane1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 33, 150, 30));

        staffPaneLbl.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        staffPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        staffPaneLbl.setText("Staff Assign");
        StaffAssignBtnPane1.add(staffPaneLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, -10, 240, 120));

        javax.swing.GroupLayout menusPaneLayout = new javax.swing.GroupLayout(menusPane);
        menusPane.setLayout(menusPaneLayout);
        menusPaneLayout.setHorizontalGroup(
            menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reservationBtnPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(StaffAssignBtnPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(menusPaneLayout.createSequentialGroup()
                .addGroup(menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(BillingBtnPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menusPaneLayout.setVerticalGroup(
            menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusPaneLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(CustomerBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(reservationBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(StaffAssignBtnPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(BillingBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jPanel1.add(menusPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 200, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void CustomerBtnPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerBtnPaneMouseClicked
        refreshCustomer();
        tabbedPane.setSelectedIndex(0);
        //custPaneLbl.setIcon(new ImageIcon(ImageIO.read( new File() ) ) );
        setAllPaneNotSelected();
        custPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/selected.png"))); 

    }//GEN-LAST:event_CustomerBtnPaneMouseClicked

    private void reservationBtnPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationBtnPaneMouseClicked
        refreshReservation();
        tabbedPane.setSelectedIndex(1);
        
        setAllPaneNotSelected();
        resPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/selected.png")));

    }//GEN-LAST:event_reservationBtnPaneMouseClicked

    private void custIDTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIDTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custIDTxtActionPerformed

    private void nicTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicTxtActionPerformed

    private void fNamTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fNamTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fNamTxtActionPerformed

    private void lNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lNameTxtActionPerformed

    private void phoneNo1TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNo1TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNo1TxtActionPerformed

    private void emailTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTxtActionPerformed

    private void phoneNo2TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneNo2TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneNo2TxtActionPerformed

    private void reservationIdTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservationIdTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reservationIdTxtActionPerformed

    private void resCustNameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resCustNameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resCustNameTxtActionPerformed

    private void resPremiumRoomTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resPremiumRoomTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resPremiumRoomTxtActionPerformed

    private void resAdultTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resAdultTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resAdultTxtActionPerformed

    private void resPremiumtickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resPremiumtickActionPerformed
        if (resPremiumtick.isSelected()) {
                    //resAvailableRoomTbl.removeAll();
                   roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.premium_room_calc;");
                   remTempSelected(globalVars.premiumSelected);
                   
        }else{
        DefaultTableModel dtm = (DefaultTableModel) resAvailableRoomTbl.getModel();
           dtm.setRowCount(0);
        }
    }//GEN-LAST:event_resPremiumtickActionPerformed

    private void reskidsTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reskidsTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reskidsTxtActionPerformed

    private void resRoyalRoomTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resRoyalRoomTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resRoyalRoomTxtActionPerformed

    private void resExecutiveRoomTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resExecutiveRoomTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resExecutiveRoomTxtActionPerformed

    private void resUpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resUpdateBtnActionPerformed
      
        //below line is added to fix the not updating bug
        resPremiumtick.setSelected(true);
        
        
        if (dataValidator.DateValidator(arrivalDate) && dataValidator.DateValidator(departDate) &&
         dataValidator.adultKidsValidate(resAdultTxt, reskidsTxt) 
        && dataValidator.isRoomAssigned(resPremiumtick, resPremiumRoomTxt,resRoyalTick,resRoyalRoomTxt,resExecutiveTick,resExecutiveRoomTxt)                 
        ) {
            System.out.println("all data valid");
            
            String packageId ;
            if (resPackageSelector.getSelectedItem().toString().matches("Full board")) {
                packageId = "FB";
            }else{
                packageId = "HB";
            }
            
            //BUG:THE ROOMS AVAILABLE IS NOT LOADING CORRECTLY DURING UPDATE PROCESS AS THE CURRENTLY ASSIGNED ROOMS ARE STILL IN THE DATABASE.
            //BUT IT IS NOT A BIG DEAL.TO FIX THAT WE NEED TO READ THAT DATA FROM THE DB AND ADD IT TO THE LOCAL TABLE
            
            databaseConnections resNew = new databaseConnections();
            
            String reservationId = reservationIdTxt.getText().toString();
            
            String arrivalDate = ((JTextField)this.arrivalDate.getDateEditor().getUiComponent()).getText();
            String departDate = ((JTextField)this.departDate.getDateEditor().getUiComponent()).getText();
            int kids,adults;
            
            ArrayList<String>  allRoomsSelected = new ArrayList<String>();
            allRoomsSelected.addAll(globalVars.premiumSelected);
            allRoomsSelected.addAll(globalVars.royalSelected);
            allRoomsSelected.addAll(globalVars.exeSelected);
            
            //Integer.parseInt(resAdultTxt.getText())
            
            if (resAdultTxt.getText().matches("[0-9]+")) {
                adults = Integer.parseInt(resAdultTxt.getText());
            } else{
                adults = 0;
            }
            
            
            if (reskidsTxt.getText().matches("[0-9]+")) {
                kids = Integer.parseInt(reskidsTxt.getText());
            } else{
                kids = 0;
            }
            
            
            
            //BELOW QUERIES NEED TO BE EDITED IN ORDER TO UPDATE!!!
            
            
           
            resNew.databaseConnectionNoMessage("DELETE FROM `hotelmanagementsystem`.`reservation` WHERE (`Reservation_ID` = '"+reservationId+"');");
            
            
           
            resNew.databaseConnectionMessage("INSERT INTO `hotelmanagementsystem`.`reservation` "
                    + "VALUES ('"+reservationId+"','"+arrivalDate+"','"+departDate+"', "+adults+", "+kids+", '"+resIDSearchJcombo.getSelectedItem().toString()+"', '"+packageId+"')", 
                    "Reservation updated Successfully !", "Updated Successfully");
            
            // looping through the all room numbers to add them all to reservation room table
            for(String roomName : allRoomsSelected){
                resNew.databaseConnectionNoMessage("INSERT INTO `hotelmanagementsystem`.`reservationroom` VALUES ('"+reservationId+"','"+roomName+"') ;");
               
            }
            
            
            
            clearReservationPane();
            
        

           
               
        }
        else{
        
        JOptionPane.showMessageDialog(null, "Please fill all the data Correctly!", "Update Error!", JOptionPane.ERROR_MESSAGE);

           

        }
      
        
  
        
        
      
        
        
    }//GEN-LAST:event_resUpdateBtnActionPerformed

    private void resSubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resSubmitBtnActionPerformed
    
        if (dataValidator.DateValidator(arrivalDate) && dataValidator.DateValidator(departDate) &&
         dataValidator.adultKidsValidate(resAdultTxt, reskidsTxt) 
        && dataValidator.isRoomAssigned(resPremiumtick, resPremiumRoomTxt,resRoyalTick,resRoyalRoomTxt,resExecutiveTick,resExecutiveRoomTxt)                 
        ) {
            System.out.println("all data valid");
            
            String packageId ;
            if (resPackageSelector.getSelectedItem().toString().matches("Full board")) {
                packageId = "FB";
            }else{
                packageId = "HB";
            }
            
            
            databaseConnections resNew = new databaseConnections();
            IDGenerators resId = new IDGenerators();
            String reservationId = resId.newResID();
            
            String arrivalDate = ((JTextField)this.arrivalDate.getDateEditor().getUiComponent()).getText();
            String departDate = ((JTextField)this.departDate.getDateEditor().getUiComponent()).getText();
            int kids,adults;
            
            ArrayList<String>  allRoomsSelected = new ArrayList<String>();
            allRoomsSelected.addAll(globalVars.premiumSelected);
            allRoomsSelected.addAll(globalVars.royalSelected);
            allRoomsSelected.addAll(globalVars.exeSelected);
            
            //Integer.parseInt(resAdultTxt.getText())
            
            if (resAdultTxt.getText().matches("[0-9]+")) {
                adults = Integer.parseInt(resAdultTxt.getText());
            } else{
                adults = 0;
            }
            
            
            if (reskidsTxt.getText().matches("[0-9]+")) {
                kids = Integer.parseInt(reskidsTxt.getText());
            } else{
                kids = 0;
            }
            
            
           
            resNew.databaseConnectionMessage("INSERT INTO `hotelmanagementsystem`.`reservation` "
                    + "VALUES ('"+reservationId+"','"+arrivalDate+"','"+departDate+"', "+adults+", "+kids+", '"+resIDSearchJcombo.getSelectedItem().toString()+"', '"+packageId+"')", 
                    "Reservation added Successfully !", "Reserved Successfully");
            
            // looping through the all room numbers to add them all to reservation room table
            for(String roomName : allRoomsSelected){
                resNew.databaseConnectionNoMessage("INSERT INTO `hotelmanagementsystem`.`reservationroom` VALUES ('"+reservationId+"','"+roomName+"') ;");
               
            }
            
            
            
            clearReservationPane();
            

            

               
        }
        else{
        
            JOptionPane.showMessageDialog(null, "Please Fill all the Data Correctly!", "Reservation Unsuccessfull", JOptionPane.ERROR_MESSAGE);

        
           

        }
      
        
  
        
        
       
    }//GEN-LAST:event_resSubmitBtnActionPerformed

    private void resClearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resClearBtnActionPerformed
       clearReservationPane();
    }//GEN-LAST:event_resClearBtnActionPerformed

    private void resAddRoomBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resAddRoomBtnActionPerformed
        if (resAvailableRoomTbl.getSelectedRowCount() == 1) {
            
        DefaultTableModel reserveModel = (DefaultTableModel) resAvailableRoomTbl.getModel();

        String romType = reserveModel.getValueAt(resAvailableRoomTbl.getSelectedRow(), 0).toString();
        
        if (romType.matches("^P.*$")) {
            System.out.println("premium");
            resPremiumRoomTxt.setText(resPremiumRoomTxt.getText()+ romType+",");
            
           globalVars.premiumSelected.add(romType); //adds the selected item to the array
           
          roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.premium_room_calc;");
           remTempSelected(globalVars.premiumSelected);
           
            
           
           
           
            
           
        }
        else if (romType.matches("^E.*$")) {
             resExecutiveRoomTxt.setText(resExecutiveRoomTxt.getText()+romType+",");
            globalVars.exeSelected.add(romType); //adds the selected item to the array
           
          roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.executive_room_calc;");
           remTempSelected(globalVars.exeSelected);
            
        }else{
            resRoyalRoomTxt.setText(resRoyalRoomTxt.getText()+romType+",");
            globalVars.royalSelected.add(romType); //adds the selected item to the array
           
          roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.royal_room_calc;");
           remTempSelected(globalVars.royalSelected);
        }
        }else{
          JOptionPane.showMessageDialog(null, "A room is not selected !", "Room not selected", JOptionPane.INFORMATION_MESSAGE);

        
        }
        
     
     
      
    }//GEN-LAST:event_resAddRoomBtnActionPerformed

    private void BillingBtnPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillingBtnPaneMouseClicked
        tabbedPane.setSelectedIndex(3);
        
         setAllPaneNotSelected();
        BillPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/selected.png"))); 
    }//GEN-LAST:event_BillingBtnPaneMouseClicked

    private void bilCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bilCustNameActionPerformed

    private void StaffAssignBtnPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffAssignBtnPane1MouseClicked
        tabbedPane.setSelectedIndex(2);
        refreshStaff();
        
         setAllPaneNotSelected();
        staffPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/selected.png"))); 
    }//GEN-LAST:event_StaffAssignBtnPane1MouseClicked

    private void extraChargeTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraChargeTickActionPerformed
        if (extraChargeTick.isSelected()) {
           extraChargesBil.setEditable(true); 
        }else{
             extraChargesBil.setEditable(false);
             extraChargesBil.setText("");
        }
        
    }//GEN-LAST:event_extraChargeTickActionPerformed

    private void generateBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillBtnActionPerformed
        if (roomChargesBil.getRowCount() ==0) {
          JOptionPane.showMessageDialog(null, "No charges associated with the customer !", "No associated Data!", JOptionPane.ERROR_MESSAGE);
          checkoutBtnBil.setEnabled(false); 
        }
        
        else if (bilCustName.getText().matches("")) {
          JOptionPane.showMessageDialog(null, "Please Load the data first !", "Data Not Loaded!", JOptionPane.ERROR_MESSAGE);
          checkoutBtnBil.setEnabled(false);
          

        }else{
            
        if (dataValidator.numberValidator(extraChargesBil) && extraChargesBil.getText().matches("[0-9]+") && extraChargeTick.isSelected()) {       
            totalChargeBil.setText(String.valueOf(Double.parseDouble(totalRoomCharges.getText()) +Double.parseDouble(totalPackageChargeBil.getText()) + Double.parseDouble(extraChargesBil.getText())));
            checkoutBtnBil.setEnabled(true);
            
        }
        else if (extraChargesBil.getText().matches("") && dataValidator.numberValidator(extraChargesBil)) {       
            totalChargeBil.setText(String.valueOf(Double.parseDouble(totalRoomCharges.getText()) +Double.parseDouble(totalPackageChargeBil.getText())));
            checkoutBtnBil.setEnabled(true);
           
        }
        else{
            totalChargeBil.setText(String.valueOf(Double.parseDouble(totalRoomCharges.getText()) +Double.parseDouble(totalPackageChargeBil.getText()) ));
            checkoutBtnBil.setEnabled(true);
           

        }
        
        }
        
        
        
        
    }//GEN-LAST:event_generateBillBtnActionPerformed

    private void checkoutBtnBilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnBilActionPerformed
        checkoutPage checkoutPg = new checkoutPage();

        checkoutPg.setResizable(false);
        checkoutPg.setLocation(100, 200);
        checkoutPg.setVisible(true);
      
        
        this.setEnabled(false);
        
        globalVars.CustIdBill =  bilCustId.getSelectedItem().toString();
        globalVars.totalChargesBill = totalChargeBil.getText();
        
        if(extraChargeTick.isSelected()){
             globalVars.liableChargesBill = extraChargesBil.getText();
        }else{
            globalVars.liableChargesBill = "0";
            }
       
        
        // below action will disble and enable the main interface when checkout is opened and closed
        checkoutPg.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        mainInterface.this.setEnabled(true);
        e.getWindow().dispose();
         mainInterface.this.toFront();
        
       }
});
    }//GEN-LAST:event_checkoutBtnBilActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        if (nicTxt.getText().matches(globalVars.lastlyAddedNIC) || nicTxt.getText().matches(globalVars.selectedNIC)) {

            JOptionPane.showMessageDialog(null, "You cant add the customer with Same NIC twice!", "NIC Duplicate", JOptionPane.ERROR_MESSAGE);
        } else {

            if (phoneNo1Txt.getText().matches(phoneNo2Txt.getText())) {

                JOptionPane.showMessageDialog(null, "The 2 phone numbers must be different from each other! ", "Phone Number Duplicated", JOptionPane.ERROR_MESSAGE);

            } else {

                if (phoneNo2Txt.getText().length() == 0) {
                    if (dataValidator.NICvalidator(nicTxt) && dataValidator.PhoneNumberValidator(phoneNo1Txt)
                            && dataValidator.eMailValidator(emailTxt)) {

                        // THE CODE NEEDED WHEN VALID.AND THE SAME GOES TO THE BELOW
                        databaseConnections newConnection = new databaseConnections();
                        IDGenerators custID = new IDGenerators();
                        String customerID = custID.newCustID();

                        newConnection.databaseConnectionMessage("INSERT INTO hotelmanagementsystem.customer VALUES('" + customerID + "',"
                                + "'" + fNamTxt.getText() + "'," + "'" + lNameTxt.getText() + "','" + nicTxt.getText() + "',"
                                + "" + "'" + addressTxt.getText() + "','" + countryList.getSelectedItem().toString() + "',"
                                + "" + "'" + emailTxt.getText() + "');", "Data Entered Successfully!", "Success!");

                        newConnection.databaseConnectionNoMessage("INSERT INTO hotelmanagementsystem.Customer_Contact_Number VALUES('" + customerID + "',"
                                + "'" + phoneNo1Txt.getText() + "');");

                        globalVars.lastlyAddedNIC = nicTxt.getText(); // stores lastly added nic,so when the user accidently press add twice the second time will be stopped.

                        customerTableRefresh(cusTable.getModel());
                        clearCustomerPane();
                    } else {

                        JOptionPane.showMessageDialog(null, "Please Fill all the data correctly !", "Invalid Data", JOptionPane.INFORMATION_MESSAGE);

                    }

                } else {

                    if (dataValidator.NICvalidator(nicTxt) && dataValidator.PhoneNumberValidator(phoneNo1Txt)
                            && dataValidator.PhoneNumberValidator(phoneNo2Txt)
                            && dataValidator.eMailValidator(emailTxt)) {

                        // THE CODE NEEDED WHEN VALID.AND THE SAME GOES FROM THE UP
                        databaseConnections newConnection = new databaseConnections();

                        //get the new customer id
                        IDGenerators custID = new IDGenerators();
                        String customerID = custID.newCustID();

                        newConnection.databaseConnectionMessage("INSERT INTO hotelmanagementsystem.customer VALUES('" + customerID + "',"
                                + "'" + fNamTxt.getText() + "'," + "'" + lNameTxt.getText() + "','" + nicTxt.getText() + "',"
                                + "" + "'" + addressTxt.getText() + "','" + countryList.getSelectedItem().toString() + "',"
                                + "" + "'" + emailTxt.getText() + "');", "Data Entered Successfully!", "Success!");

                        newConnection.databaseConnectionNoMessage("INSERT INTO hotelmanagementsystem.Customer_Contact_Number VALUES('" + customerID + "',"
                                + "'" + phoneNo1Txt.getText() + "');");
                        newConnection.databaseConnectionNoMessage("INSERT INTO hotelmanagementsystem.Customer_Contact_Number VALUES('" + customerID + "',"
                                + "'" + phoneNo2Txt.getText() + "');");

                        globalVars.lastlyAddedNIC = nicTxt.getText();

                        customerTableRefresh(cusTable.getModel());
                        clearCustomerPane();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please Fill all the data correctly !", "Invalid Data", JOptionPane.INFORMATION_MESSAGE);

                    }

                }
            }

        }


    }//GEN-LAST:event_addBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed

        clearCustomerPane();

        // ADD A WAY TO SET THE DEFAULT COUNTRY TO SRI LANKA
    }//GEN-LAST:event_clearBtnActionPerformed

    private void nicTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicTxtKeyPressed
        dataValidator.NICvalidator(nicTxt);
    }//GEN-LAST:event_nicTxtKeyPressed

    private void nicTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nicTxtKeyReleased
        dataValidator.NICvalidator(nicTxt);
    }//GEN-LAST:event_nicTxtKeyReleased

    private void phoneNo1TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNo1TxtKeyPressed
        dataValidator.PhoneNumberValidator(phoneNo1Txt);

    }//GEN-LAST:event_phoneNo1TxtKeyPressed

    private void phoneNo1TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNo1TxtKeyReleased
        dataValidator.PhoneNumberValidator(phoneNo1Txt);

    }//GEN-LAST:event_phoneNo1TxtKeyReleased

    private void phoneNo2TxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNo2TxtKeyPressed
        if (phoneNo2Txt.getText().matches("")) {
            phoneNo2Txt.setBorder(Bordergood());

        } else {
            dataValidator.PhoneNumberValidator(phoneNo2Txt);

        }
    }//GEN-LAST:event_phoneNo2TxtKeyPressed

    private void phoneNo2TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneNo2TxtKeyReleased
        if (phoneNo2Txt.getText().matches("")) {
            phoneNo2Txt.setBorder(Bordergood());
        } else {
            dataValidator.PhoneNumberValidator(phoneNo2Txt);

        }
    }//GEN-LAST:event_phoneNo2TxtKeyReleased

    private void emailTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyPressed
        dataValidator.eMailValidator(emailTxt);
    }//GEN-LAST:event_emailTxtKeyPressed

    private void emailTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTxtKeyReleased
        dataValidator.eMailValidator(emailTxt);
    }//GEN-LAST:event_emailTxtKeyReleased

    private void tableScrollerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableScrollerMouseClicked

    }//GEN-LAST:event_tableScrollerMouseClicked

    private void cusTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cusTableMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) cusTable.getModel();

        String custTblID = tblModel.getValueAt(cusTable.getSelectedRow(), 0).toString();
        String custTblFname = tblModel.getValueAt(cusTable.getSelectedRow(), 1).toString();
        String custTblLName = tblModel.getValueAt(cusTable.getSelectedRow(), 2).toString();
        String custTblNIC = tblModel.getValueAt(cusTable.getSelectedRow(), 3).toString();
        String custTblAdr = tblModel.getValueAt(cusTable.getSelectedRow(), 4).toString();
        String custTblCntry = tblModel.getValueAt(cusTable.getSelectedRow(), 5).toString();
        String custTblMail = tblModel.getValueAt(cusTable.getSelectedRow(), 6).toString();
        String custTblPNO1 = tblModel.getValueAt(cusTable.getSelectedRow(), 7).toString();
        String custTblPNO2 = tblModel.getValueAt(cusTable.getSelectedRow(), 8).toString();

        //set values in the text fields
        globalVars.selectedCustID = custTblID; // assign customer id to global variable

        globalVars.previousPhoneNum1 = custTblPNO1;
        globalVars.previousPhoneNum2 = custTblPNO2;

        globalVars.selectedNIC = custTblNIC;

        custIDTxt.setText(custTblID);
        fNamTxt.setText(custTblFname);
        lNameTxt.setText(custTblLName);
        nicTxt.setText(custTblNIC);
        addressTxt.setText(custTblAdr);
        phoneNo1Txt.setText(custTblPNO1);
        phoneNo2Txt.setText(custTblPNO2);
        emailTxt.setText(custTblMail);
        countryList.setSelectedIndex(Country.getcountryIndex(custTblCntry)); 

    }//GEN-LAST:event_cusTableMouseClicked

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed

        //code for deletion
        if (cusTable.getSelectedRowCount() == 1) {

            databaseConnections deletingConnection = new databaseConnections();
            deletingConnection.databaseConnectionMessage("delete from hotelmanagementsystem.customer where Customer_ID ='" + custIDTxt.getText() + "';", "The customer Record deleted Successfully!", "Customer Removed");
            customerTableRefresh(cusTable.getModel());

            clearCustomerPane();

        } else {
            if (cusTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is Empty..", "Empty Table", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a single row to Delete", "No Row Selected", JOptionPane.INFORMATION_MESSAGE);

            }
        }


    }//GEN-LAST:event_deleteBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed

        if (cusTable.getSelectedRowCount() == 1) {

            
     if (phoneNo1Txt.getText().matches(phoneNo2Txt.getText())) {

                JOptionPane.showMessageDialog(null, "The 2 phone numbers must be different from each other! ", "Phone Number Duplicated", JOptionPane.ERROR_MESSAGE);

            } else {
     
     
            
            //check whether phone2 is present 
            if (phoneNo2Txt.getText().length() == 0) {

                //validate the data
                if (dataValidator.NICvalidator(nicTxt) && dataValidator.PhoneNumberValidator(phoneNo1Txt)
                        && dataValidator.eMailValidator(emailTxt)) {

                    // THE CODE NEEDED WHEN VALID.AND THE SAME GOES TO THE BELOW
                    databaseConnections updateConnection = new databaseConnections();

                    updateConnection.databaseConnectionMessage(
                            "UPDATE hotelmanagementsystem.customer SET  First_Name ='" + fNamTxt.getText() + "',"
                            + " Last_Name = '" + lNameTxt.getText() + "', NIC = '" + nicTxt.getText() + "', Address ='" + addressTxt.getText() + "' , "
                            + "Country = '" + countryList.getSelectedItem().toString() + "', Email = '" + emailTxt.getText() + "' "
                            + "WHERE Customer_ID = '" + custIDTxt.getText() + "';", "Data Updated Successfully!", "Update Success!");

                    if (globalVars.previousPhoneNum1.matches("")) {
                        updateConnection.databaseConnectionNoMessage("UPDATE hotelmanagementsystem.Customer_Contact_Number SET Contact_number ='" + phoneNo1Txt.getText() + "' WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum1 + "';");

                    } else {
                        updateConnection.databaseConnectionNoMessage("UPDATE hotelmanagementsystem.Customer_Contact_Number SET Contact_number ='" + phoneNo1Txt.getText() + "' WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum1 + "';");
                        updateConnection.databaseConnectionNoMessage("DELETE FROM hotelmanagementsystem.Customer_Contact_Number  WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum2 + "';");

                    }

                    customerTableRefresh(cusTable.getModel());
                    clearCustomerPane();
                } else {

                    JOptionPane.showMessageDialog(null, "Please Fill all the data correctly !", "Invalid Data", JOptionPane.INFORMATION_MESSAGE);

                }

            } //check whether phone2 is present 
            else {

                if (dataValidator.NICvalidator(nicTxt) && dataValidator.PhoneNumberValidator(phoneNo1Txt)
                        && dataValidator.PhoneNumberValidator(phoneNo2Txt)
                        && dataValidator.eMailValidator(emailTxt)) {

                    // THE CODE NEEDED WHEN VALID.AND THE SAME GOES FROM THE UP
                    databaseConnections updateConnection = new databaseConnections();

                    updateConnection.databaseConnectionMessage(
                            "UPDATE hotelmanagementsystem.customer SET  First_Name ='" + fNamTxt.getText() + "',"
                            + " Last_Name = '" + lNameTxt.getText() + "', NIC = '" + nicTxt.getText() + "', Address ='" + addressTxt.getText() + "' , "
                            + "Country = '" + countryList.getSelectedItem().toString() + "', Email = '" + emailTxt.getText() + "' "
                            + "WHERE Customer_ID = '" + custIDTxt.getText() + "';", "Data Updated Successfully!", "Update Success!");

                    updateConnection.databaseConnectionNoMessage("UPDATE hotelmanagementsystem.Customer_Contact_Number SET Contact_number ='" + phoneNo1Txt.getText() + "' WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum1 + "';");

                    System.out.println("UPDATE hotelmanagementsystem.Customer_Contact_Number SET Contact_number ='" + phoneNo1Txt.getText() + "' WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum1 + "';");

                    if (globalVars.previousPhoneNum2.matches("")) {
                        updateConnection.databaseConnectionNoMessage("INSERT INTO hotelmanagementsystem.Customer_Contact_Number VALUES('" + custIDTxt.getText() + "',"
                                + "'" + phoneNo2Txt.getText() + "');");
                    } else {
                        updateConnection.databaseConnectionNoMessage("UPDATE hotelmanagementsystem.Customer_Contact_Number SET Contact_number ='" + phoneNo2Txt.getText() + "' WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum2 + "';");

                    }

                    System.out.println("UPDATE hotelmanagementsystem.Customer_Contact_Number SET Contact_number ='" + phoneNo2Txt.getText() + "' WHERE Customer_ID = '" + custIDTxt.getText() + "' AND Contact_number ='" + globalVars.previousPhoneNum2 + "';");

                    System.out.println(globalVars.previousPhoneNum1 + "  " + globalVars.previousPhoneNum2);

                    customerTableRefresh(cusTable.getModel());
                    clearCustomerPane();
                } else {
                    JOptionPane.showMessageDialog(null, "Please Fill all the data correctly !", "Invalid Data", JOptionPane.INFORMATION_MESSAGE);

                }

            }
 }

            
            
            
        } else {
            if (cusTable.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is Empty..", "Empty Table", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a single row to Delete", "No Row Selected", JOptionPane.INFORMATION_MESSAGE);

            }
        }

    }//GEN-LAST:event_updateBtnActionPerformed

    private void custIdOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custIdOKActionPerformed
                CustomerIdComboGenerator.loadCustomerName(resCustNameTxt, resIDSearchJcombo.getSelectedItem().toString());
                


    }//GEN-LAST:event_custIdOKActionPerformed

    private void resAdultTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resAdultTxtKeyPressed
        dataValidator.oneValidator(resAdultTxt);
        
    }//GEN-LAST:event_resAdultTxtKeyPressed

    private void resAdultTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_resAdultTxtKeyReleased
               dataValidator.oneValidator(resAdultTxt);
               totalGuestCount();
    }//GEN-LAST:event_resAdultTxtKeyReleased

    private void reskidsTxtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reskidsTxtKeyPressed
               dataValidator.oneValidator(reskidsTxt);
             
    }//GEN-LAST:event_reskidsTxtKeyPressed

    private void reskidsTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_reskidsTxtKeyReleased
                      dataValidator.oneValidator(reskidsTxt);
                      totalGuestCount();
    }//GEN-LAST:event_reskidsTxtKeyReleased

    private void resExecutiveTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resExecutiveTickActionPerformed
       if (resExecutiveTick.isSelected()) {
                    
                   roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.executive_room_calc;");
                   remTempSelected(globalVars.exeSelected);
        }else{
           // used to clear table
           DefaultTableModel dtm = (DefaultTableModel) resAvailableRoomTbl.getModel();
           dtm.setRowCount(0);
       }
    }//GEN-LAST:event_resExecutiveTickActionPerformed

    private void resRoyalTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resRoyalTickActionPerformed
         if (resRoyalTick.isSelected()) {
                    //resAvailableRoomTbl.removeAll();
                   roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.royal_room_calc;");
                   remTempSelected(globalVars.royalSelected);
        }else{
        DefaultTableModel dtm = (DefaultTableModel) resAvailableRoomTbl.getModel();
           dtm.setRowCount(0);
        }
    }//GEN-LAST:event_resRoyalTickActionPerformed

    private void resPackageSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resPackageSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resPackageSelectorActionPerformed

    private void royalRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_royalRemoveBtnActionPerformed
       resRoyalRoomTxt.setText("");
       globalVars.royalSelected.clear();
       roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.royal_room_calc;");
       
    }//GEN-LAST:event_royalRemoveBtnActionPerformed

    private void premiumRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_premiumRemoveBtnActionPerformed
        resPremiumRoomTxt.setText("");
        globalVars.premiumSelected.clear();
        roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.premium_room_calc;");

    }//GEN-LAST:event_premiumRemoveBtnActionPerformed

    private void executRemoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_executRemoveBtnActionPerformed
        resExecutiveRoomTxt.setText("");
        globalVars.exeSelected.clear();
        roomTypeTblRefresh(resAvailableRoomTbl.getModel(),"hotelmanagementsystem.executive_room_calc;");
        
    }//GEN-LAST:event_executRemoveBtnActionPerformed

    private void totalGuestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalGuestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalGuestsActionPerformed

    private void resReservationTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resReservationTblMouseClicked
        
        globalVars.exeSelected.clear();
        globalVars.premiumSelected.clear();
        globalVars.royalSelected.clear();
        
        DefaultTableModel tblModel = (DefaultTableModel) resReservationTbl.getModel();
       
        String ResID = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 0).toString();
        String custNameRes = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 1).toString();
        String arrivalDate = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 5).toString();
        String departDate = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 6).toString();
        String adultCnt = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 7).toString();
        String kicCount = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 8).toString();
        String packageType = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 9).toString();
        String custId = tblModel.getValueAt(resReservationTbl.getSelectedRow(), 10).toString();
     
        reservationIdTxt.setText(ResID);
        databaseConnections DBobj = new databaseConnections();
        
        // BELOW 3 LINES ARE USED TO SELECT THE CUSTOMER ID IN THE JCOMBOBOX WHEN UPDATING.BUT IT IS NOT COMPLETE !!!! ITS TEMPORARY WORKAROUND 
       // DBobj.getCustID(custNameRes);
        
       resIDSearchJcombo.addItem(custId);
       resIDSearchJcombo.setSelectedIndex(resIDSearchJcombo.getItemCount()-1);
       
       
        //countryList.setSelectedIndex(Country.getcountryIndex(custTblCntry)); 
        
        
        resCustNameTxt.setText(custNameRes);
        
        //JTextFieldDateEditor arrivalDateTxt = (JTextFieldDateEditor) arrivalDate.getDateEditor();
        //arrivalDateTxt.setEditable(false);
         ((JTextField)this.arrivalDate.getDateEditor().getUiComponent()).setText(arrivalDate);
         ((JTextField)this.departDate.getDateEditor().getUiComponent()).setText(departDate);
         
         resAdultTxt.setText(adultCnt);
         reskidsTxt.setText(kicCount);
         totalGuestCount();
         
         //resPackageSelector.getSelectedItem().toString().matches("Full board")
         
         if(packageType.matches("Full board")){
             resPackageSelector.setSelectedIndex(0);
         }
         else{
             resPackageSelector.setSelectedIndex(1);
         }
          
         //DBobj.getRooms(ResID);
         //if (romType.matches("^P.*$"))
         
         clearFlds(Arrays.asList(resPremiumRoomTxt,resRoyalRoomTxt,resExecutiveRoomTxt));
                 
         for (String roomNo : DBobj.getRooms(ResID)){
         if(roomNo.matches("^P.*$")){
             resPremiumRoomTxt.setText(resPremiumRoomTxt.getText().toString()+roomNo+",");
             globalVars.premiumSelected.add(roomNo);
             
         }
         if(roomNo.matches("^R.*$")){
             resRoyalRoomTxt.setText(resRoyalRoomTxt.getText().toString()+roomNo+",");
             globalVars.royalSelected.add(roomNo);
         }
         if(roomNo.matches("^E.*$")){
             resExecutiveRoomTxt.setText(resExecutiveRoomTxt.getText().toString()+roomNo+",");
             globalVars.exeSelected.add(roomNo);
         }
 
         }
         
       

        
        
    }//GEN-LAST:event_resReservationTblMouseClicked

    private void countryListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryListActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryListActionPerformed

    private void resDeleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resDeleteBtnActionPerformed
         if (resReservationTbl.getSelectedRowCount() == 1) {

            databaseConnections deletingConnection = new databaseConnections();
           
            deletingConnection.databaseConnectionMessage("DELETE FROM `hotelmanagementsystem`.`reservation` WHERE (`Reservation_ID` = '"+reservationIdTxt.getText().toString()+"');", "The Reservation Record deleted Successfully!", "Reservation Removed");
            
            clearReservationPane();

       

        } else {
            if (resReservationTbl.getRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Table is Empty..", "Empty Table", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please Select a single row to Delete", "No Row Selected", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        
    }//GEN-LAST:event_resDeleteBtnActionPerformed

    private void resIDSearchJcomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resIDSearchJcomboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_resIDSearchJcomboActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       CustomerIdComboGenerator.loadCustomerName(bilCustName, bilCustId.getSelectedItem().toString());
       
        Double totalPackCharge = billPackagesTblRefresh(packageChargesBil.getModel(), bilCustId.getSelectedItem().toString());
        totalPackageChargeBil.setText(totalPackCharge.toString());
        
        Double totalRoomCharge = billRoomChargeTblrefresh(roomChargesBil.getModel(), bilCustId.getSelectedItem().toString());
        totalRoomCharges.setText(totalRoomCharge.toString());
        
        totalChargeBil.setText("");
        extraChargesBil.setBorder(Bordergood());
        extraChargesBil.setText("");
        
        checkoutBtnBil.setEnabled(false);
        generateBillBtn.setEnabled(true);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void totalPackageChargeBilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPackageChargeBilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPackageChargeBilActionPerformed

    private void extraChargesBilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraChargesBilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_extraChargesBilActionPerformed

    private void extraChargesBilKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_extraChargesBilKeyPressed
        dataValidator.numberValidator(extraChargesBil);
    }//GEN-LAST:event_extraChargesBilKeyPressed

    private void extraChargesBilKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_extraChargesBilKeyReleased
         dataValidator.numberValidator(extraChargesBil);
    }//GEN-LAST:event_extraChargesBilKeyReleased

    private void stafflCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stafflCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stafflCustNameActionPerformed

    private void loadAssignedStaffDetails(){
    
      
                       
                       
 databaseConnections newConnectionstaff2 = new databaseConnections();
        ArrayList allAssignedRooms     = newConnectionstaff2.getAssignedRoomsByCustId(custIdStaff.getSelectedItem().toString());                       
                       
            
             // if not empty we have to continue loading them
             databaseConnections test = new databaseConnections();
        

        roomTypeContainer.setLayout(new GridLayout(allAssignedRooms.size(),1));
        int count =0;
        
//        System.out.println(allAssignedRooms.size());
//        System.out.println(allAssignedRooms.toString());
        
        while(count < allAssignedRooms.size()){
            
        roomTypes pan1 = new roomTypes();
        pan1.valueSetter(allAssignedRooms.get(count).toString());
        roomTypeContainer.add(pan1);
        count++;
        
    
    }}
    
    
    
    private void testActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testActionPerformed
        
        // clear all room details when loading new one and multiple same room loading error
        
        roomTypeContainer.removeAll();
//        roomTypeContainer.revalidate();
        roomTypeContainer.repaint();
        
        CustomerIdComboGenerator.loadCustomerName(stafflCustName, custIdStaff.getSelectedItem().toString());
        
        databaseConnections newConnectionstaff = new databaseConnections();
        ArrayList allUnassignedRooms     = newConnectionstaff.getUnassignedRoomsByCustId(custIdStaff.getSelectedItem().toString());
        Iterator<Integer> iter = allUnassignedRooms.iterator();
        
        
        if (allUnassignedRooms.isEmpty()) { // check whether 
            
            loadAssignedStaffDetails();
          /*             
                       
 databaseConnections newConnectionstaff2 = new databaseConnections();
        ArrayList allAssignedRooms     = newConnectionstaff2.getAssignedRoomsByCustId(custIdStaff.getSelectedItem().toString());                       
                       
            
             // if not empty we have to continue loading them
             databaseConnections test = new databaseConnections();
        

        roomTypeContainer.setLayout(new GridLayout(allAssignedRooms.size(),1));
        int count =0;
        
        while(count < allAssignedRooms.size()){
            
        roomTypes pan1 = new roomTypes();
        pan1.valueSetter(allAssignedRooms.get(count).toString());
        roomTypeContainer.add(pan1);
        count++;
        
        }*/
    
        }else{
            
            
            
             // if room list empty then we have to add data
            // create a method to automatically insert data into the table
            
      databaseConnections assigner = new databaseConnections();
            System.out.println("athuleeeeee");
         assigner.assignStaffAutomatic(custIdStaff.getSelectedItem().toString());
           
          loadAssignedStaffDetails();
        
        }
        
       
        /*
        pan1 = new roomTypes();
        pan1.indexSetter(2);
        pan2 = new roomTypes();
        pan2.indexSetter(0);
        
        roomTypeContainer.add(pan1);
        roomTypeContainer.add(pan2);
   */
        validate();
        repaint();
        
        globalVars.isStaffLoaded = true;
        notifyStaffBtn.setEnabled(true);
    }//GEN-LAST:event_testActionPerformed

    private void notifyStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notifyStaffBtnActionPerformed
        if (globalVars.isStaffLoaded) {
                    JOptionPane.showMessageDialog(null, "The staff was notified successfully!", "Staff Notified", JOptionPane.INFORMATION_MESSAGE);
                    globalVars.isStaffLoaded =false;
                    notifyStaffBtn.setEnabled(false);
        }else{
                    JOptionPane.showMessageDialog(null, "Staff is not assigned yet!", "Staff Not Assigned", JOptionPane.ERROR_MESSAGE);

        }
        
    }//GEN-LAST:event_notifyStaffBtnActionPerformed

    private void CustomerBtnPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerBtnPaneMouseEntered
        if (tabbedPane.getSelectedIndex() != 0) {
            custPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hoover.png"))); // NOI18N
        }
        
    }//GEN-LAST:event_CustomerBtnPaneMouseEntered

    private void CustomerBtnPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerBtnPaneMouseExited
      if (tabbedPane.getSelectedIndex() != 0) {
            custPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        }
        
        
    }//GEN-LAST:event_CustomerBtnPaneMouseExited

    private void reservationBtnPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationBtnPaneMouseEntered
        if (tabbedPane.getSelectedIndex() != 1) {
            resPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hoover.png"))); // NOI18N
        }
    }//GEN-LAST:event_reservationBtnPaneMouseEntered

    private void reservationBtnPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationBtnPaneMouseExited
      if (tabbedPane.getSelectedIndex() != 1) {
            resPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        }
    }//GEN-LAST:event_reservationBtnPaneMouseExited

    private void BillingBtnPaneMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillingBtnPaneMouseEntered
        if (tabbedPane.getSelectedIndex() != 3) {
            BillPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hoover.png"))); // NOI18N
        }
        
    }//GEN-LAST:event_BillingBtnPaneMouseEntered

    private void BillingBtnPaneMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BillingBtnPaneMouseExited
        if (tabbedPane.getSelectedIndex() != 3) {
            BillPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        }
    }//GEN-LAST:event_BillingBtnPaneMouseExited

    private void StaffAssignBtnPane1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffAssignBtnPane1MouseEntered
       if (tabbedPane.getSelectedIndex() != 2) {
            staffPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hoover.png"))); // NOI18N
        }
    }//GEN-LAST:event_StaffAssignBtnPane1MouseEntered

    private void StaffAssignBtnPane1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffAssignBtnPane1MouseExited
      if (tabbedPane.getSelectedIndex() != 2) {
            staffPaneLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/normal.png"))); // NOI18N
        }
    }//GEN-LAST:event_StaffAssignBtnPane1MouseExited

    
    
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
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
           new mainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BillPaneLbl;
    private javax.swing.JPanel BillingBtnPane;
    private javax.swing.JPanel BillingPane;
    private javax.swing.JPanel CustomerBtnPane;
    private javax.swing.JPanel CustomerPane;
    private javax.swing.JPanel Reservation;
    private javax.swing.JPanel StaffAssign;
    private javax.swing.JPanel StaffAssignBtnPane1;
    private javax.swing.JButton addBtn;
    private javax.swing.JTextArea addressTxt;
    private com.toedter.calendar.JDateChooser arrivalDate;
    private javax.swing.JComboBox<String> bilCustId;
    private javax.swing.JTextField bilCustName;
    private javax.swing.JButton checkoutBtnBil;
    private javax.swing.JButton clearBtn;
    private javax.swing.JComboBox<Country> countryList;
    private javax.swing.JTable cusTable;
    private javax.swing.JTextField custIDTxt;
    private javax.swing.JButton custIdOK;
    private javax.swing.JComboBox<String> custIdStaff;
    private javax.swing.JScrollPane custInfoAddScroller;
    private javax.swing.JScrollPane custInfoAddScroller1;
    private javax.swing.JScrollPane custInfoAddScroller2;
    private javax.swing.JLabel custPaneLbl;
    private javax.swing.JButton deleteBtn;
    private com.toedter.calendar.JDateChooser departDate;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JButton executRemoveBtn;
    private javax.swing.JCheckBox extraChargeTick;
    private javax.swing.JTextField extraChargesBil;
    private javax.swing.JTextField fNamTxt;
    private javax.swing.JButton generateBillBtn;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField lNameTxt;
    private javax.swing.JPanel menusPane;
    private javax.swing.JTextField nicTxt;
    private javax.swing.JButton notifyStaffBtn;
    private javax.swing.JTable packageChargesBil;
    private javax.swing.JTextField phoneNo1Txt;
    private javax.swing.JLabel phoneNo2;
    private javax.swing.JTextField phoneNo2Txt;
    private javax.swing.JButton premiumRemoveBtn;
    private javax.swing.JButton resAddRoomBtn;
    private javax.swing.JTextField resAdultTxt;
    private javax.swing.JTable resAvailableRoomTbl;
    private javax.swing.JButton resClearBtn;
    private javax.swing.JTextField resCustNameTxt;
    private javax.swing.JButton resDeleteBtn;
    private javax.swing.JTextField resExecutiveRoomTxt;
    private javax.swing.JCheckBox resExecutiveTick;
    private javax.swing.JComboBox<String> resIDSearchJcombo;
    private javax.swing.JComboBox<String> resPackageSelector;
    private javax.swing.JLabel resPaneLbl;
    private javax.swing.JTextField resPremiumRoomTxt;
    private javax.swing.JCheckBox resPremiumtick;
    private javax.swing.JTable resReservationTbl;
    private javax.swing.JTextField resRoyalRoomTxt;
    private javax.swing.JCheckBox resRoyalTick;
    private javax.swing.JButton resSubmitBtn;
    private javax.swing.JButton resUpdateBtn;
    private javax.swing.JPanel reservationBtnPane;
    private javax.swing.JTextField reservationIdTxt;
    private javax.swing.JPanel reservationPane;
    private javax.swing.JTextField reskidsTxt;
    private javax.swing.JTable roomChargesBil;
    public javax.swing.JPanel roomTypeContainer;
    private javax.swing.ButtonGroup roomTypes;
    private javax.swing.JScrollPane roomTypesFrm;
    private javax.swing.JButton royalRemoveBtn;
    public static javax.swing.JTextField sampleTxtField;
    private javax.swing.JLabel staffPaneLbl;
    private javax.swing.JTextField stafflCustName;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JScrollPane tableScroller;
    private javax.swing.JButton test;
    private javax.swing.JPanel titlePane;
    private javax.swing.JTextField totalChargeBil;
    private javax.swing.JTextField totalGuests;
    private javax.swing.JTextField totalPackageChargeBil;
    private javax.swing.JTextField totalRoomCharges;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}

//branch test

