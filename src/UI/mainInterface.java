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
        setSize(1024, 768);
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
        tabbedPane = new javax.swing.JTabbedPane();
        CustomerPane = new javax.swing.JPanel();
        tableScroller = new javax.swing.JScrollPane();
        cusTable = new javax.swing.JTable();
        custInfoAddScroller = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
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
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        sampleTxtField = new javax.swing.JTextField();
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
        updateBtn1 = new javax.swing.JButton();
        addBtn1 = new javax.swing.JButton();
        clearBtn1 = new javax.swing.JButton();
        deleteBtn1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        loadCustDetailStaff = new javax.swing.JButton();
        roomTypesFrm = new javax.swing.JScrollPane();
        roomTypeContainer = new javax.swing.JPanel();
        custIdStaff = new javax.swing.JComboBox<>();
        stafflCustName = new javax.swing.JTextField();
        test = new javax.swing.JButton();
        BillingPane = new javax.swing.JPanel();
        custInfoAddScroller2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        bilCustName = new javax.swing.JTextField();
        checkoutBtnBil = new javax.swing.JButton();
        generateBillBtn = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        extraChargeTick = new javax.swing.JCheckBox();
        jScrollPane4 = new javax.swing.JScrollPane();
        roomChargesBil = new javax.swing.JTable();
        jLabel24 = new javax.swing.JLabel();
        extraChargesBil = new javax.swing.JTextField();
        totalRoomCharges = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        packageChargesBil = new javax.swing.JTable();
        jLabel30 = new javax.swing.JLabel();
        bilCustId = new javax.swing.JComboBox<>();
        totalChargeBil = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        totalPackageChargeBil = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        menusPane = new javax.swing.JPanel();
        CustomerBtnPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reservationBtnPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BillingBtnPane = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        StaffAssignBtnPane1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1024, 768));

        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titlePane.setBackground(new java.awt.Color(0, 51, 204));

        javax.swing.GroupLayout titlePaneLayout = new javax.swing.GroupLayout(titlePane);
        titlePane.setLayout(titlePaneLayout);
        titlePaneLayout.setHorizontalGroup(
            titlePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        titlePaneLayout.setVerticalGroup(
            titlePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        jPanel1.add(titlePane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1030, 90));

        CustomerPane.setBackground(new java.awt.Color(102, 255, 102));

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
        custInfoAddScroller.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        custInfoAddScroller.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        custIDTxt.setEditable(false);
        custIDTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custIDTxtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Customer ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("NIC no");

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Address");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        email.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Country");

        phoneNo2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
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
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(custIDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(sampleTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateBtn)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn)
                                .addGap(30, 30, 30)
                                .addComponent(clearBtn))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(nicTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(fNamTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(phoneNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(156, 156, 156))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(phoneNo2Txt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(phoneNo1Txt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emailTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(countryList, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(313, Short.MAX_VALUE))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(phoneNo1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phoneNo2)
                    .addComponent(phoneNo2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(countryList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn)
                    .addComponent(addBtn)
                    .addComponent(clearBtn)
                    .addComponent(deleteBtn))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        custInfoAddScroller.setViewportView(jPanel2);

        javax.swing.GroupLayout CustomerPaneLayout = new javax.swing.GroupLayout(CustomerPane);
        CustomerPane.setLayout(CustomerPaneLayout);
        CustomerPaneLayout.setHorizontalGroup(
            CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPaneLayout.createSequentialGroup()
                .addComponent(custInfoAddScroller, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CustomerPaneLayout.setVerticalGroup(
            CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custInfoAddScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(CustomerPaneLayout.createSequentialGroup()
                        .addComponent(tableScroller, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabbedPane.addTab("tab1", CustomerPane);

        reservationPane.setBackground(new java.awt.Color(255, 255, 102));

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

        Reservation.setBackground(new java.awt.Color(0, 255, 204));

        resPackageSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Full board", "Half board" }));
        resPackageSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resPackageSelectorActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Reservation ID");

        reservationIdTxt.setEditable(false);
        reservationIdTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationIdTxtActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Customer ID");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Package");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setText("Check Out Date");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                                .addGap(18, 18, 18)
                                .addComponent(resUpdateBtn)
                                .addGap(18, 18, 18)
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
                                .addGap(34, 34, 34)
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(reskidsTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(resAdultTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                                    .addComponent(resPackageSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(totalGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ReservationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reservationIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resIDSearchJcombo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(custIdOK, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resCustNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(ReservationLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(ReservationLayout.createSequentialGroup()
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(arrivalDate, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                    .addComponent(departDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
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
                .addGap(34, 34, 34)
                .addGroup(ReservationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resSubmitBtn)
                    .addComponent(resUpdateBtn)
                    .addComponent(resClearBtn)
                    .addComponent(resDeleteBtn))
                .addGap(18, 18, 18))
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
            resReservationTbl.getColumnModel().getColumn(10).setResizable(false);
        }

        jLabel32.setText("Reservations");

        jLabel33.setText("Rooms");

        javax.swing.GroupLayout reservationPaneLayout = new javax.swing.GroupLayout(reservationPane);
        reservationPane.setLayout(reservationPaneLayout);
        reservationPaneLayout.setHorizontalGroup(
            reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPaneLayout.createSequentialGroup()
                        .addGroup(reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(reservationPaneLayout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPaneLayout.createSequentialGroup()
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPaneLayout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(211, 211, 211))))
        );
        reservationPaneLayout.setVerticalGroup(
            reservationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reservationPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
            .addGroup(reservationPaneLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("tab2", reservationPane);

        StaffAssign.setBackground(new java.awt.Color(102, 255, 102));

        custInfoAddScroller1.setBackground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller1.setBorder(null);
        custInfoAddScroller1.setForeground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        custInfoAddScroller1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setText("Customer ID");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Customer Name");

        updateBtn1.setText("Update");

        addBtn1.setText("Add");

        clearBtn1.setText("Clear");

        deleteBtn1.setText("Delete");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setText("rooms reserved");

        loadCustDetailStaff.setText("load");
        loadCustDetailStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadCustDetailStaffMouseClicked(evt);
            }
        });
        loadCustDetailStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadCustDetailStaffActionPerformed(evt);
            }
        });

        roomTypesFrm.setBackground(new java.awt.Color(255, 0, 51));
        roomTypesFrm.setForeground(new java.awt.Color(51, 255, 51));

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

        test.setText("test");
        test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testActionPerformed(evt);
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
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(addBtn1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateBtn1)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBtn1)
                                .addGap(30, 30, 30)
                                .addComponent(clearBtn1))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(custIdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(loadCustDetailStaff)
                                .addGap(66, 66, 66)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stafflCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(roomTypesFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 824, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(155, 155, 155)
                                .addComponent(test)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(custIdStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadCustDetailStaff)
                    .addComponent(stafflCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(test))
                .addGap(18, 18, 18)
                .addComponent(roomTypesFrm, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateBtn1)
                    .addComponent(addBtn1)
                    .addComponent(clearBtn1)
                    .addComponent(deleteBtn1))
                .addGap(16, 16, 16))
        );

        custInfoAddScroller1.setViewportView(jPanel3);

        javax.swing.GroupLayout StaffAssignLayout = new javax.swing.GroupLayout(StaffAssign);
        StaffAssign.setLayout(StaffAssignLayout);
        StaffAssignLayout.setHorizontalGroup(
            StaffAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(custInfoAddScroller1)
        );
        StaffAssignLayout.setVerticalGroup(
            StaffAssignLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StaffAssignLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custInfoAddScroller1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("tab1", StaffAssign);

        BillingPane.setBackground(new java.awt.Color(102, 255, 102));

        custInfoAddScroller2.setBackground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller2.setBorder(null);
        custInfoAddScroller2.setForeground(new java.awt.Color(204, 204, 204));
        custInfoAddScroller2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        custInfoAddScroller2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanel4.setBackground(new java.awt.Color(153, 0, 153));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setText("Customer ID");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setText("Customer Name");

        bilCustName.setEditable(false);
        bilCustName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bilCustNameActionPerformed(evt);
            }
        });

        checkoutBtnBil.setText("Checkout");
        checkoutBtnBil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutBtnBilActionPerformed(evt);
            }
        });

        generateBillBtn.setText("Generate");
        generateBillBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generateBillBtnActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setText("Charges for the reserved rooms");

        extraChargeTick.setText("Liable Charges if any");
        extraChargeTick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                extraChargeTickActionPerformed(evt);
            }
        });

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

        jLabel24.setText("Total Charge for the rooms");

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

        totalRoomCharges.setEditable(false);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setText("Charges for Selected Package");

        packageChargesBil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Reservation ID", "Package Type", "Charge"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
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

        jLabel30.setText("Total Amount is ");

        jButton2.setText("Load");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        totalPackageChargeBil.setEditable(false);
        totalPackageChargeBil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPackageChargeBilActionPerformed(evt);
            }
        });

        jLabel31.setText("Total Charge for the Packages");

        CustomerIdComboGenerator.loadCustomerID(bilCustId);  AutoCompletion.enable(bilCustId);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel23)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(82, 82, 82)
                                            .addComponent(bilCustName, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addGap(94, 94, 94)
                                            .addComponent(bilCustId, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(27, 27, 27)
                                            .addComponent(jButton2))))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(142, 142, 142)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269))
                            .addComponent(totalRoomCharges, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)))
                .addGap(0, 1044, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(totalChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(checkoutBtnBil))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalPackageChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(extraChargeTick, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(extraChargesBil, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(generateBillBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(bilCustId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(bilCustName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalRoomCharges, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPackageChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(extraChargeTick)
                    .addComponent(extraChargesBil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generateBillBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(totalChargeBil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkoutBtnBil))
                .addGap(25, 25, 25))
        );

        custInfoAddScroller2.setViewportView(jPanel4);

        javax.swing.GroupLayout BillingPaneLayout = new javax.swing.GroupLayout(BillingPane);
        BillingPane.setLayout(BillingPaneLayout);
        BillingPaneLayout.setHorizontalGroup(
            BillingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingPaneLayout.createSequentialGroup()
                .addComponent(custInfoAddScroller2, javax.swing.GroupLayout.DEFAULT_SIZE, 874, Short.MAX_VALUE)
                .addContainerGap())
        );
        BillingPaneLayout.setVerticalGroup(
            BillingPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BillingPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(custInfoAddScroller2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabbedPane.addTab("tab1", BillingPane);

        jPanel1.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 880, 710));

        menusPane.setBackground(new java.awt.Color(153, 255, 51));

        CustomerBtnPane.setToolTipText("");
        CustomerBtnPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerBtnPaneMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel1.setText("Customer");

        javax.swing.GroupLayout CustomerBtnPaneLayout = new javax.swing.GroupLayout(CustomerBtnPane);
        CustomerBtnPane.setLayout(CustomerBtnPaneLayout);
        CustomerBtnPaneLayout.setHorizontalGroup(
            CustomerBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerBtnPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        CustomerBtnPaneLayout.setVerticalGroup(
            CustomerBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerBtnPaneLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(22, 22, 22))
        );

        reservationBtnPane.setToolTipText("");
        reservationBtnPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationBtnPaneMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel2.setText("Reservations");

        javax.swing.GroupLayout reservationBtnPaneLayout = new javax.swing.GroupLayout(reservationBtnPane);
        reservationBtnPane.setLayout(reservationBtnPaneLayout);
        reservationBtnPaneLayout.setHorizontalGroup(
            reservationBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationBtnPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );
        reservationBtnPaneLayout.setVerticalGroup(
            reservationBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reservationBtnPaneLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        BillingBtnPane.setToolTipText("");
        BillingBtnPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BillingBtnPaneMouseClicked(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel26.setText("Billing");

        javax.swing.GroupLayout BillingBtnPaneLayout = new javax.swing.GroupLayout(BillingBtnPane);
        BillingBtnPane.setLayout(BillingBtnPaneLayout);
        BillingBtnPaneLayout.setHorizontalGroup(
            BillingBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingBtnPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        BillingBtnPaneLayout.setVerticalGroup(
            BillingBtnPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BillingBtnPaneLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel26)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        StaffAssignBtnPane1.setToolTipText("");
        StaffAssignBtnPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StaffAssignBtnPane1MouseClicked(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        jLabel28.setText("Staff Assign");

        javax.swing.GroupLayout StaffAssignBtnPane1Layout = new javax.swing.GroupLayout(StaffAssignBtnPane1);
        StaffAssignBtnPane1.setLayout(StaffAssignBtnPane1Layout);
        StaffAssignBtnPane1Layout.setHorizontalGroup(
            StaffAssignBtnPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffAssignBtnPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        StaffAssignBtnPane1Layout.setVerticalGroup(
            StaffAssignBtnPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffAssignBtnPane1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel28)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout menusPaneLayout = new javax.swing.GroupLayout(menusPane);
        menusPane.setLayout(menusPaneLayout);
        menusPaneLayout.setHorizontalGroup(
            menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CustomerBtnPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(reservationBtnPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BillingBtnPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(StaffAssignBtnPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menusPaneLayout.setVerticalGroup(
            menusPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menusPaneLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(CustomerBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(reservationBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(StaffAssignBtnPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(BillingBtnPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        jPanel1.add(menusPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 140, 720));

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

    }//GEN-LAST:event_CustomerBtnPaneMouseClicked

    private void reservationBtnPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationBtnPaneMouseClicked
        refreshReservation();
        tabbedPane.setSelectedIndex(1);

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
    }//GEN-LAST:event_BillingBtnPaneMouseClicked

    private void bilCustNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bilCustNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bilCustNameActionPerformed

    private void StaffAssignBtnPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StaffAssignBtnPane1MouseClicked
        tabbedPane.setSelectedIndex(2);
        refreshStaff();
    }//GEN-LAST:event_StaffAssignBtnPane1MouseClicked

    private void loadCustDetailStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadCustDetailStaffMouseClicked


    }//GEN-LAST:event_loadCustDetailStaffMouseClicked

    private void loadCustDetailStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadCustDetailStaffActionPerformed
        //loads customer name to the text field
        CustomerIdComboGenerator.loadCustomerName(stafflCustName, custIdStaff.getSelectedItem().toString());
        
        databaseConnections newConnectionstaff = new databaseConnections();
        ArrayList allRooms     = newConnectionstaff.getUnassignedRoomsByCustId(custIdStaff.getSelectedItem().toString());
        Iterator<Integer> iter = allRooms.iterator();
        
        System.out.println(allRooms.toString());
       
        int count = 0;
        
       GridBagLayout grid = new GridBagLayout();  
            GridBagConstraints gbc = new GridBagConstraints();  
            setLayout(grid);  
           
            GridBagLayout layout = new GridBagLayout();  
    roomTypeContainer.setLayout(layout);
         gbc.fill = GridBagConstraints.VERTICAL;  //HORIZONTAL
        
         
        while (iter.hasNext()) {            
            System.out.println("next");
             System.out.print(iter.next() + " ");
             
                     
    gbc.gridx = 0;  
    gbc.gridy = count;  
    count++;
    jPanel1.add(new roomTypes(), gbc);  
    /*gbc.gridx = 0;  
    gbc.gridy = 1;  
    jPanel1.add(new Button("Button two"), gbc);  
    gbc.fill = GridBagConstraints.HORIZONTAL;  
    gbc.ipadx = 20;  
    gbc.gridx = 0;  
    gbc.gridy = 2;  
    jPanel1.add(new Button("Button Three"), gbc); */
    
    validate();
    repaint();
             
             
             
        }
        
        /*
       
        
       // generates rooms assigned 
        roomTypes newpanel = new roomTypes();
        roomTypeContainer.add(newpanel);
        newpanel.indexSetter(0);
        newpanel.setSize(500, 410);
        newpanel.setVisible(true);
        //newpanel.setLocation(WIDTH, WIDTH);

       
                roomTypes panel = new roomTypes();

                
                    
                    GridBagConstraints gbc = new GridBagConstraints();
                   // roomTypeContainer.add(panel);
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.weightx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    roomTypeContainer.add(panel, gbc, 0);
      //  panel.setSize(500, 410);
        panel.setVisible(true);
                   /* gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.weightx = 1;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    roomTypeContainer.add(panel, gbc, 0);*/

                   // validate();
                    //repaint();
        
        System.out.println("created");


    }//GEN-LAST:event_loadCustDetailStaffActionPerformed

    private void extraChargeTickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_extraChargeTickActionPerformed
        if (extraChargeTick.isSelected()) {
           extraChargesBil.setEditable(true); 
        }else{
             extraChargesBil.setEditable(false);
             extraChargesBil.setText("");
        }
        
    }//GEN-LAST:event_extraChargeTickActionPerformed

    private void generateBillBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateBillBtnActionPerformed
        if (bilCustName.getText().matches("")) {
          JOptionPane.showMessageDialog(null, "Please Load the data first !", "Data Not Loaded!", JOptionPane.ERROR_MESSAGE);

        }else{
            
        if (dataValidator.numberValidator(extraChargesBil) && extraChargesBil.getText().matches("[0-9]+") && extraChargeTick.isSelected()) {       
            totalChargeBil.setText(String.valueOf(Double.parseDouble(totalRoomCharges.getText()) +Double.parseDouble(totalPackageChargeBil.getText()) + Double.parseDouble(extraChargesBil.getText())));
        }
        else if (extraChargesBil.getText().matches("") && dataValidator.numberValidator(extraChargesBil)) {       
            totalChargeBil.setText(String.valueOf(Double.parseDouble(totalRoomCharges.getText()) +Double.parseDouble(totalPackageChargeBil.getText())));
        }
        else{
            totalChargeBil.setText(String.valueOf(Double.parseDouble(totalRoomCharges.getText()) +Double.parseDouble(totalPackageChargeBil.getText()) ));

        }
        
        }
        
        
        
        
    }//GEN-LAST:event_generateBillBtnActionPerformed

    private void checkoutBtnBilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutBtnBilActionPerformed
        checkoutPage checkoutPg = new checkoutPage();

        checkoutPg.setResizable(false);
        checkoutPg.setLocation(100, 200);
        checkoutPg.setVisible(true);
      
        
        this.setEnabled(false);
        
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
     
        reservationIdTxt.setText(ResID);
        databaseConnections DBobj = new databaseConnections();
        
        // BELOW 3 LINES ARE USED TO SELECT THE CUSTOMER ID IN THE JCOMBOBOX WHEN UPDATING.BUT IT IS NOT COMPLETE !!!! ITS TEMPORARY WORKAROUND 
        DBobj.getCustID(custNameRes);
        
       resIDSearchJcombo.addItem(DBobj.getCustID(custNameRes));
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
//        roomTypeContainer.repaint();
        
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
        
        
    }//GEN-LAST:event_testActionPerformed

    
    
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
    private javax.swing.JPanel BillingBtnPane;
    private javax.swing.JPanel BillingPane;
    private javax.swing.JPanel CustomerBtnPane;
    private javax.swing.JPanel CustomerPane;
    private javax.swing.JPanel Reservation;
    private javax.swing.JPanel StaffAssign;
    private javax.swing.JPanel StaffAssignBtnPane1;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton addBtn1;
    private javax.swing.JTextArea addressTxt;
    private com.toedter.calendar.JDateChooser arrivalDate;
    private javax.swing.JComboBox<String> bilCustId;
    private javax.swing.JTextField bilCustName;
    private javax.swing.JButton checkoutBtnBil;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton clearBtn1;
    private javax.swing.JComboBox<Country> countryList;
    private javax.swing.JTable cusTable;
    private javax.swing.JTextField custIDTxt;
    private javax.swing.JButton custIdOK;
    private javax.swing.JComboBox<String> custIdStaff;
    private javax.swing.JScrollPane custInfoAddScroller;
    private javax.swing.JScrollPane custInfoAddScroller1;
    private javax.swing.JScrollPane custInfoAddScroller2;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton deleteBtn1;
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
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
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
    private javax.swing.JButton loadCustDetailStaff;
    private javax.swing.JPanel menusPane;
    private javax.swing.JTextField nicTxt;
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
    private javax.swing.JButton updateBtn1;
    // End of variables declaration//GEN-END:variables
}

//branch test

