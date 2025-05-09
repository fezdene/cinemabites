import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

/**
 * First page for CinemaBites GUI
 * Opens a page which can allow user to enter data.
 * The Data consists of Selecting Movie Name - for them then to select things such as snacks and drinks

 */

public class FirstPageGui extends JFrame{

    // Declaring Integers
    public int comboIndex1;
    public int adultQtyIndex;
    public int childQtyIndex;
    public int snackIndex;
    public int snackQtyIndex;
    public int drinkIndex;
    public int drinkQtyIndex;


    // Decaring Doubles
    private double totalToPay;
    private double subTotalTickets;
    private double subTotalFood;
    private double subTotalSeatType;
    private double cashPaid;
    private double changeReturned;


    // Declaring Strings
    private String ticketSubTotal;
    private String seats;
    private String strTotal;
    private String paymentMethod;
    private String change;

    // Progress Bar Initialisation
    final static int interval = 100;
    int endOfTime;
    Timer time;
    JProgressBar progrss;


    // Declaring JLabel For Main UI
    private JLabel lblCinemaTitle;
    private JLabel lblMovieSelection;
    private JLabel lblTheatre_Time;
    private JLabel lblTheatreNo;
    private JLabel lblActualTheatreNo;
    private JLabel lblTimeOfShow;
    private JLabel lblActualTimeOfShow;
    private JLabel lblImgPreview;
    private JLabel lblTicketHeading;
    private JLabel lblAgeRating;
    private JLabel lblActualAgeRating;
    private JLabel lblDateOfFilm;
    private JLabel lblActualDateOfFilm;
    private JLabel lblNoSeats;
    private JLabel lblActualNoSeats;
    private JLabel lblAdultTicket;
    private JLabel lblChildTicket;
    private JLabel lblActualAdultTicket;
    private JLabel lblActualChildTicket;
    private JLabel lblAdultQty;
    private JLabel lblChildQty;
    private JLabel lblTicketSubTtl;
    private JLabel lblActualTicketSubTtl;
    private JLabel lblSnacks_Drinks;
    private JLabel lblSnacksQty;
    private JLabel lblDrinksQty;
    private JLabel lblSDSubTotal;
    private JLabel lblActualSDSubTotal;
    private JLabel lblTotalPrice;
    private JLabel lblActualTotalPrice;
    private JLabel lblCashOrCard;
    private JLabel lblExtraServices;
    private JLabel lblSeatType;
    private JLabel lblBackgroundPic;

    // Declaring JLabel for JPanel 2 - Aka Receipt
    private JLabel lblReceiptTitle;
    private JLabel lblMovieOrdered;
    private JLabel lblActualMovieOrdered;
    private JLabel lblMovieImage;
    private JLabel lblMovieTime;
    private JLabel lblActualMovieTime;
    private JLabel lblMovieTheatre;
    private JLabel lblActualMovieTheatre;
    private JLabel lblActualMovieRating;
    private JLabel lblAdultPrice;
    private JLabel lblActualAdultPrice;
    private JLabel lblChildPrice;
    private JLabel lblActualChildPrice;
    private JLabel lblATicketQty;
    private JLabel lblCTicketQty;
    private JLabel lblSnackName;
    private JLabel lblSnackQty;
    private JLabel lblDrinkName;
    private JLabel lblDrinkQty;
    private JLabel lblMthdOfPayment;
    private JLabel lblActualMtdPayment;
    private JLabel lblTotalPaid;
    private JLabel lblActualTotalPaid;
    private JLabel lblActualDateOfShow;
    private JLabel lblActualSeatType;

    // Declaring JComboBox's 
    private JComboBox<String> cmbMovies;
    private JComboBox<Integer> adultCountDropdown;
    private JComboBox<Integer> childCountDropdown;
    private JComboBox<String> cmbSnacks;
    private JComboBox<String> cmbSnacksQty;
    private JComboBox<String> cmbDrinks;
    private JComboBox<String> cmbDrinksQty;
    private JComboBox<String> cmbSeatType;

    // Declaring JSeparator's
    private JSeparator first_Separator;
    private JSeparator second_Separator;
    private JSeparator third_Separator;
    private JSeparator fourth_Separator;
    private JSeparator fifth_Separator;

    // Declaring Radio Button's
    private JRadioButton radioBtnCard;
    private JRadioButton radioBtnCash;


    // Declaring Button's
    private JButton btnOrderTickets;
    private JButton btnReturnMain;

    // Calling Reader Classes Which Read Data From Txt File And Store the Date Into An Array
    FilmFileReader movieFile = new FilmFileReader();
    SnackFileReader snacksFile = new SnackFileReader();
    DrinkFileReader drinksFile = new DrinkFileReader();

    // Create New JPanels For Different Data
    private JPanel firstPanel;
    private JPanel secondPanel;
    
    //Popup for seat selection   
    private void openSeatSelectionPopup() {
        
        adultCountDropdown = new JComboBox<Integer>();
            childCountDropdown = new JComboBox<Integer>();
            
            // Listening For Any Events Occuring Within The Ticket ComboBox's
                    adultCountDropdown.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            lblSubTotalTicketActionPerformed(evt);
                            cmbTicketQtyActionPerformed(evt);
                            actualTotalPriceActionPerformed(evt);
            
                        }
                    });
            
                    childCountDropdown.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            lblSubTotalTicketActionPerformed(evt);
                            cmbTicketQtyActionPerformed(evt);
                            actualTotalPriceActionPerformed(evt);
            
                        }
                    });
        
        JDialog seatDialog = new JDialog(this, "Select Seats", true);
        seatDialog.setSize(600, 600);
        seatDialog.setLayout(new BorderLayout());
        seatDialog.setLocationRelativeTo(this);
    
        JPanel seatGrid = new JPanel(new GridLayout(8, 8));
        JLabel[][] seats = new JLabel[8][8];
        boolean[][] seatSelected = new boolean[8][8];
    
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                seats[i][j] = new JLabel("Seat " + (i * 8 + j + 1), SwingConstants.CENTER);
                seats[i][j].setOpaque(true);
                seats[i][j].setBackground(Color.LIGHT_GRAY);
                seats[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
    
                int row = i;
                int col = j;
                seats[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (seatSelected[row][col]) {
                            seats[row][col].setBackground(Color.LIGHT_GRAY);
                        } else {
                            seats[row][col].setBackground(Color.GREEN);
                        }
                        seatSelected[row][col] = !seatSelected[row][col];
                    }
                });
    
                seatGrid.add(seats[i][j]);
            }
        }
    
        seatDialog.add(seatGrid, BorderLayout.CENTER);
    
        JButton btnConfirm = new JButton("Confirm Selection");
        btnConfirm.addActionListener(e -> {
            int totalSeatsSelected = 0;
            for (boolean[] row : seatSelected) {
                for (boolean seat : row) {
                    if (seat) {
                        totalSeatsSelected++;
                    }
                }
            }
    
            if (totalSeatsSelected > 0) {
    
                
    
                for (int i = 0; i <= totalSeatsSelected; i++) {
                    adultCountDropdown.addItem(i);
                    childCountDropdown.addItem(i);
                    
                    
                }
    
                Object[] fields = {
                    "Total Seats Selected: " + totalSeatsSelected,
                    "Select number of Adults:", adultCountDropdown,
                    "Select number of Children:", childCountDropdown
                };
    
                int option = JOptionPane.showConfirmDialog(
                    this, fields, "Specify Ticket Distribution", JOptionPane.OK_CANCEL_OPTION
                );
    
                if (option == JOptionPane.OK_OPTION) {
                    int adults = (int) adultCountDropdown.getSelectedIndex();
                    int children = (int) childCountDropdown.getSelectedIndex();
                          
                    if (adults + children == totalSeatsSelected) {
                        // Update lblAdultQty and lblChildQty
                        lblAdultQty.setText("Quantity:    " + adults);
                        lblChildQty.setText("Quantity:    " + children);
                        
                        
    
                        seatDialog.dispose();
                    } else {
                        JOptionPane.showMessageDialog(
                            this, "Total does not match selected seats. Please try again.",
                            "Input Error", JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            } else {
                JOptionPane.showMessageDialog(
                    this, "No seats selected. Please select at least one seat.", "Selection Error", JOptionPane.ERROR_MESSAGE
                );
            }
        });
    
        seatDialog.add(btnConfirm, BorderLayout.SOUTH);
        seatDialog.setVisible(true);
    }
    
    
    
    
    
    // Constructor Class which Call The Method Create Gui
    public FirstPageGui(){
        super("CinemaBites");
        setVisible(true);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        getContentPane().setLayout(null);
        createGui();



    }
    
    // Method Which Builds The GUI
    public void createGui(){

        // Starts The File Reader Function For Movie/Snack/Drink - Then Data To Be Read:
        movieFile.openFile();
        movieFile.readFile();

        snacksFile.openFile();
        snacksFile.readFile();

        drinksFile.openFile();
        drinksFile.readFile();
        ButtonGroup radioGroup = new ButtonGroup();

        // Build JPanel size and properties
        secondPanel = new JPanel();
        secondPanel.setVisible(false);
        secondPanel.setSize(610, 504);
        secondPanel.setBackground(Color.DARK_GRAY);
        getContentPane().add(secondPanel);
        secondPanel.setLayout(null);

        firstPanel = new JPanel();
        firstPanel.setLocation(0, 0);
        firstPanel.setSize(613,540);
        getContentPane().add(firstPanel);
        firstPanel.setBackground(Color.LIGHT_GRAY);
        firstPanel.setLayout(null);

        JPanel thirdPanel = new JPanel();
        thirdPanel.setLocation(0, 0);
        getContentPane().add(thirdPanel);
        thirdPanel.setVisible(false);
        thirdPanel.setSize(417,235);
        thirdPanel.setBackground(Color.DARK_GRAY);
        thirdPanel.setLayout(null);




        // Label Initialisation
        lblCinemaTitle = new JLabel();
        lblMovieSelection = new JLabel();
        lblMovieSelection.setForeground(Color.WHITE);
        lblTheatre_Time = new JLabel();
        lblTheatreNo = new JLabel();
        lblTheatreNo.setForeground(Color.BLACK);
        lblActualTheatreNo = new JLabel();
        lblTimeOfShow = new JLabel();
        lblTimeOfShow.setForeground(Color.BLACK);
        lblActualTimeOfShow = new JLabel();
        lblImgPreview = new JLabel();
        lblTicketHeading = new JLabel();
        lblAgeRating = new JLabel();
        lblActualAgeRating = new JLabel();
        lblAdultTicket = new JLabel();
        lblAdultTicket.setForeground(Color.BLACK);
        lblChildTicket = new JLabel();
        lblChildTicket.setForeground(Color.BLACK);
        lblNoSeats = new JLabel();
        lblNoSeats.setForeground(Color.BLACK);
        lblActualNoSeats = new JLabel();
        lblActualAdultTicket = new JLabel();
        lblActualChildTicket = new JLabel();
        lblDateOfFilm = new JLabel();
        lblDateOfFilm.setForeground(Color.BLACK);
        lblActualDateOfFilm = new JLabel();
        lblAdultQty = new JLabel();
        lblAdultQty.setForeground(Color.BLACK);
        lblChildQty = new JLabel();
        lblChildQty.setForeground(Color.BLACK);
        lblTicketSubTtl = new JLabel();
        lblTicketSubTtl.setForeground(Color.BLACK);
        lblActualTicketSubTtl = new JLabel();
        lblSnacks_Drinks = new JLabel();
        lblSnacksQty = new JLabel();
        lblSnacksQty.setForeground(Color.BLACK);
        lblDrinksQty = new JLabel();
        lblDrinksQty.setForeground(Color.BLACK);
        lblSDSubTotal = new JLabel();
        lblSDSubTotal.setForeground(Color.BLACK);
        lblActualSDSubTotal = new JLabel();
        lblTotalPrice = new JLabel();
        lblTotalPrice.setForeground(Color.BLACK);
        lblActualTotalPrice = new JLabel();
        lblCashOrCard = new JLabel();
        lblCashOrCard.setForeground(Color.BLACK);
        lblExtraServices = new JLabel();
        lblSeatType = new JLabel();
        lblSeatType.setForeground(Color.BLACK);
        lblBackgroundPic = new JLabel();
        lblBackgroundPic.setBackground(Color.GRAY);



        // ComboBox Initialisation
        cmbMovies = new JComboBox<String>();
        
        cmbSnacks = new JComboBox<String>();
        cmbSnacksQty = new JComboBox<String>();
        cmbDrinks = new JComboBox<String>();
        cmbDrinksQty = new JComboBox<String>();
        cmbSeatType = new JComboBox<String>();

        // Separator Initialisation
        first_Separator = new JSeparator();
        second_Separator = new JSeparator();
        third_Separator = new JSeparator();
        fourth_Separator = new JSeparator(SwingConstants.VERTICAL);
        fifth_Separator = new JSeparator();

        // Radio Button Initialisation
        radioBtnCash = new JRadioButton();
        radioBtnCash.setBackground(Color.GRAY);
        radioBtnCard = new JRadioButton();
        radioBtnCard.setBackground(Color.GRAY);
        radioGroup.add(radioBtnCard);
        radioGroup.add(radioBtnCash);

        // Button Initialisation
        btnOrderTickets = new JButton();

    


        // JLabel Initialisation For Second JPanel
        lblReceiptTitle = new JLabel();
        lblMovieOrdered = new JLabel();
        lblActualMovieOrdered = new JLabel();
        lblMovieTime = new JLabel();
        lblActualMovieTime = new JLabel();
        lblMovieImage = new JLabel();
        lblMovieTheatre = new JLabel();
        lblActualMovieTheatre = new JLabel();
        lblActualMovieRating = new JLabel();
        lblAdultPrice = new JLabel();
        lblActualAdultPrice = new JLabel();
        lblChildPrice = new JLabel();
        lblActualChildPrice = new JLabel();
        lblATicketQty = new JLabel();
        lblCTicketQty = new JLabel();
        lblSnackName = new JLabel();
        lblSnackQty = new JLabel();
        lblDrinkName = new JLabel();
        lblDrinkQty = new JLabel();
        lblMthdOfPayment = new JLabel();
        lblActualMtdPayment = new JLabel();
        lblTotalPaid = new JLabel();
        lblActualTotalPaid = new JLabel();
        lblActualDateOfShow = new JLabel();
        lblActualSeatType = new JLabel();
    
        
        // Button Initialisation For Second JPanel
        btnReturnMain = new JButton();
        
        

        // Title Of The Program
        lblCinemaTitle.setFont(new Font("Times New Roman",Font.BOLD,18));
        lblCinemaTitle.setForeground(Color.WHITE);
        lblCinemaTitle.setText("WELCOME TO CINEMABITES");
        firstPanel.add(lblCinemaTitle);
        lblCinemaTitle.setBounds(170,15,309,30);

        // Movie Selection
        lblMovieSelection.setFont(new Font("Times New Roman",0,12));
        lblMovieSelection.setText("Select Movie:");
        firstPanel.add(lblMovieSelection);
        lblMovieSelection.setBounds(12,72,80,15);


        //Combo Box For Movie Selection
        cmbMovies.setModel(new DefaultComboBoxModel<String>(movieFile.displayAllFilms()));

        firstPanel.add(cmbMovies);
    
        cmbMovies.setBounds(93,67,214,25);


        // Listening For Any Events Coming From The Movie Combo Box
        cmbMovies.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                comboIndex1 = cmbMovies.getSelectedIndex();
                cmbMoviesActionPerformed(evt);


            }
        });        


        // Setting Up The Image Preview For When The Program First Runs
        lblImgPreview.setBounds(350,65,250,250);
        lblImgPreview.setVisible(true);
        lblImgPreview.setFont(new Font("Times New Roman", Font.ITALIC + Font.BOLD, 20));
        lblImgPreview.setText("SELECT A MOVIE");
        lblImgPreview.setHorizontalAlignment(SwingConstants.CENTER);
        lblImgPreview.setVerticalAlignment(SwingConstants.CENTER);
        firstPanel.add(lblImgPreview);

        lblImgPreview.setBorder(BorderFactory.createEtchedBorder(Color.BLACK,Color.WHITE));

        // Age Rating Label & The Value It Will Display Depending On The Movie Selected
        lblAgeRating.setFont(new Font ("Times New Roman", Font.BOLD, 10));
        lblAgeRating.setForeground(Color.WHITE);
        lblAgeRating.setText("Age Rating: ");
        firstPanel.add(lblAgeRating);
        lblAgeRating.setBounds(433,314,110,15);

        lblActualAgeRating.setFont(new Font ("Times New Roman", Font.BOLD, 12));
        firstPanel.add(lblActualAgeRating);
        lblActualAgeRating.setBounds(503,314,110,15);


        // Heading With A Separator Between Movie And Theatre Details
        lblTheatre_Time.setFont(new Font("Times New Roman",Font.BOLD,10));
        lblTheatre_Time.setForeground(Color.WHITE);
        lblTheatre_Time.setText("Theatre No & Time");
        firstPanel.add(lblTheatre_Time);
        lblTheatre_Time.setBounds(18,99,110,15);

        firstPanel.add(first_Separator);
        first_Separator.setBounds(128,109,223,10);

        // Setting Up Theater Number Labels
        lblTheatreNo.setFont(new Font("Times New Roman",0,12));
        lblTheatreNo.setText("Theatre No:"); 
        firstPanel.add(lblTheatreNo);
        lblTheatreNo.setBounds(18,120,80,15);

        lblActualTheatreNo.setFont(new Font("Times New Roman", Font.ITALIC,12));
        lblActualTheatreNo.setForeground(Color.WHITE);
        firstPanel.add(lblActualTheatreNo);
        lblActualTheatreNo.setBounds(108,118,230,20);

        // Time of Show
        lblTimeOfShow.setFont(new Font("Times New Roman",0,12));
        lblTimeOfShow.setText("Time Of Show:");
        firstPanel.add(lblTimeOfShow);
        lblTimeOfShow.setBounds(18,150,90,15);

        lblActualTimeOfShow.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualTimeOfShow.setForeground(Color.WHITE);
        firstPanel.add(lblActualTimeOfShow);
        lblActualTimeOfShow.setBounds(118,147,100,20);

        //Date Of Film
        lblDateOfFilm.setFont(new Font("Times New Roman",0,12));
        lblDateOfFilm.setText("Date Of Film:");
        firstPanel.add(lblDateOfFilm);
        lblDateOfFilm.setBounds(190,150,90,15);

        lblActualDateOfFilm.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualDateOfFilm.setForeground(Color.WHITE);
        firstPanel.add(lblActualDateOfFilm);
        lblActualDateOfFilm.setBounds(275,147,100,20);

        // Number Of Seats Available
        lblNoSeats.setFont(new Font("Times New Roman",0,12));
        lblNoSeats.setText("No. Seats: ");
        firstPanel.add(lblNoSeats);
        lblNoSeats.setBounds(190,120,80,15);

        lblActualNoSeats.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualNoSeats.setForeground(Color.WHITE);
        firstPanel.add(lblActualNoSeats);
        lblActualNoSeats.setBounds(257,118,51,20);


        // Ticket Heading
        lblTicketHeading.setFont(new Font("Times New Roman", Font.BOLD,10));
        lblTicketHeading.setForeground(Color.WHITE);
        lblTicketHeading.setText("Ticket Pricing");
        firstPanel.add(lblTicketHeading);
        lblTicketHeading.setBounds(18,177,110,15);

        firstPanel.add(second_Separator);
        second_Separator.setBounds(128,187,223,10);

        // Adult Tickets
        lblAdultTicket.setFont(new Font("Times New Roman",0,12));
        lblAdultTicket.setText("Adult Ticket: ");
        firstPanel.add(lblAdultTicket);
        lblAdultTicket.setBounds(18,207,80,15);

        lblActualAdultTicket.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualAdultTicket.setForeground(Color.WHITE);
        firstPanel.add(lblActualAdultTicket);
        lblActualAdultTicket.setBounds(108,204,51,20);


        // Child Tickets
        lblChildTicket.setFont(new Font("Times New Roman",0,12));
        lblChildTicket.setText("Child Ticket: ");
        firstPanel.add(lblChildTicket);
        lblChildTicket.setBounds(18,244,80,15);

        lblActualChildTicket.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualChildTicket.setForeground(Color.WHITE);
        firstPanel.add(lblActualChildTicket);
        lblActualChildTicket.setBounds(108,241,51,20);

        // Quantity & Combobox's For Tickets
        lblAdultQty.setFont(new Font("Times New Roman", 0,12));
        lblAdultQty.setForeground(Color.WHITE);       
        firstPanel.add(lblAdultQty);
        lblAdultQty.setText("Quantity: ");
        lblAdultQty.setBounds(208,207,80,15);

        lblChildQty.setFont(new Font("Times New Roman", 0,12));
        lblChildQty.setForeground(Color.WHITE); 
        firstPanel.add(lblChildQty);
        lblChildQty.setText("Quantity: ");
        lblChildQty.setBounds(208,242,80,15);


        
    


        // Ticket Sub Total 
        lblTicketSubTtl.setFont(new Font("Times New Roman",0,12));
        lblTicketSubTtl.setText("Sub Total:");
        lblTicketSubTtl.setBounds(105,272,90,15);
        firstPanel.add(lblTicketSubTtl);

        lblActualTicketSubTtl.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualTicketSubTtl.setForeground(Color.WHITE);
        lblActualTicketSubTtl.setText("RM0.00");
        lblActualTicketSubTtl.setBounds(170,272,90,15);
        firstPanel.add(lblActualTicketSubTtl);

        // Heading For Snacks & Drinks Section
        lblSnacks_Drinks.setFont(new Font("Times New Roman",Font.BOLD,10));
        lblSnacks_Drinks.setForeground(Color.WHITE);
        lblSnacks_Drinks.setText("Snacks & Drinks");
        lblSnacks_Drinks.setBounds(18,300,123,15);
        firstPanel.add(lblSnacks_Drinks);

        // Adding Some Design Using JSeparators
        firstPanel.add(third_Separator);
        third_Separator.setBounds(128,309,223,10);

        firstPanel.add(fourth_Separator);
        fourth_Separator.setBounds(350,307,13,244);

        


        //Combo Box For Snacks Selection
        cmbSnacks.setModel(new DefaultComboBoxModel<String>(snacksFile.displayAllSnacks()));
        firstPanel.add(cmbSnacks);
        cmbSnacks.setBounds(18,335,177,25);
        cmbSnacks.setEnabled(false);

        lblSnacksQty.setFont(new Font("Times New Roman",0,12));
        lblSnacksQty.setText("Quantity: ");
        firstPanel.add(lblSnacksQty);
        lblSnacksQty.setBounds(208,338,80,15);

        cmbSnacksQty.setModel(new DefaultComboBoxModel<String>(new String[]{"0","1","2","3",
                "4","5","6","7","8"}));
        firstPanel.add(cmbSnacksQty);
        cmbSnacksQty.setBounds(276,336,40,20);
        cmbSnacksQty.setEnabled(false);

        //Combo Box For Drinks Selection
        cmbDrinks.setModel(new DefaultComboBoxModel<String>(drinksFile.displayAllDrinks()));
        firstPanel.add(cmbDrinks);
        cmbDrinks.setBounds(18,390,177,25);
        cmbDrinks.setEnabled(false);

        lblDrinksQty.setFont(new Font("Times New Roman",0,12));
        lblDrinksQty.setText("Quantity: ");
        firstPanel.add(lblDrinksQty);
        lblDrinksQty.setBounds(208,393,80,15);

        cmbDrinksQty.setModel(new DefaultComboBoxModel<String>(new String[]{"0","1","2","3",
                "4","5","6","7","8"}));
        firstPanel.add(cmbDrinksQty);
        cmbDrinksQty.setBounds(276,391,40,20);
        cmbDrinksQty.setEnabled(false);

        // Sub Total For The Amount of Snacks And Drinks Selected Labels
        lblSDSubTotal.setFont(new Font("Times New Roman",0,12));
        lblSDSubTotal.setText("Sub Total:");
        lblSDSubTotal.setBounds(105,425,90,15);
        firstPanel.add(lblSDSubTotal);

        lblActualSDSubTotal.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualSDSubTotal.setForeground(Color.WHITE);
        lblActualSDSubTotal.setText("RM0.00");
        lblActualSDSubTotal.setBounds(172,425,90,15);
        firstPanel.add(lblActualSDSubTotal);

        // Listening To Any Events Happening Within The Snacks And Drinks ComboBox's
        cmbSnacks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmbSnacksActionPerformed(evt);
            }
        });

        cmbDrinks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cmbDrinksActionPerformed(evt);
            }
        });

        cmbSnacksQty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lblSnackDrinkSubTotalActionPerformed(evt);
                actualTotalPriceActionPerformed(evt);

            }
        });

        cmbDrinksQty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                lblSnackDrinkSubTotalActionPerformed(evt);
                actualTotalPriceActionPerformed(evt);

            }
        });
        
        // Setting A Total Price Which Consists Of All The Costs
        lblTotalPrice.setFont(new Font("Times New Roman",0,12));
        lblTotalPrice.setText("Total To Pay:");
        lblTotalPrice.setBounds(363,340,90,15);
        firstPanel.add(lblTotalPrice);

        lblActualTotalPrice.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualTotalPrice.setForeground(Color.WHITE);
        lblActualTotalPrice.setText("RM0.00");
        lblActualTotalPrice.setBounds(450,340,90,15);
        firstPanel.add(lblActualTotalPrice);

        // Labels And CheckBox's Which Allow The User To Select To Pay By Cash Or Card
        lblCashOrCard.setFont(new Font("Times New Roman",0,11));
        lblCashOrCard.setText("Would You Like To Pay By Cash Or Card:");
        lblCashOrCard.setBounds(360,367,240,25);
        firstPanel.add(lblCashOrCard);


        radioBtnCash.setText("Cash");
        radioBtnCash.setBounds(370,395,73,20);
        firstPanel.add(radioBtnCash);
        radioBtnCash.setEnabled(false);

        radioBtnCard.setText("Card");
        radioBtnCard.setBounds(494,395,73,20);
        firstPanel.add(radioBtnCard);
        radioBtnCard.setEnabled(false);

        // Action Listeners For Radio Button's 
        radioBtnCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cardRdioBtnActionPerformed(evt);
            }
        });

        radioBtnCash.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                cashRdioBtnActionPerformed(evt);
            }
        });

        // Extra Services Section Heading - Seat Type 
        lblExtraServices.setFont(new Font("Times New Roman",Font.BOLD,10));
        lblExtraServices.setForeground(Color.WHITE);
        lblExtraServices.setText("Extra Services");
        lblExtraServices.setBounds(18,445,123,15);
        firstPanel.add(lblExtraServices);

        firstPanel.add(fifth_Separator);
        fifth_Separator.setBounds(128,455,223,10);

        lblSeatType.setFont(new Font("Times New Roman",0,12));
        lblSeatType.setText("Seat Type: ");
        lblSeatType.setBounds(18,470,90,15);
        firstPanel.add(lblSeatType);

        // ComboBox For The User To Select The Seat Type They Want
        cmbSeatType.setModel(new DefaultComboBoxModel<String>(new String[]{"Standard Seats: RM5", "Premier Seats: RM7",
        "Exclusive Seats: RM9"}));
        firstPanel.add(cmbSeatType);
        cmbSeatType.setBounds(93,467,177,20);
        cmbSeatType.setEnabled(false);
        
        

        // Place Order Button - Processes The Whole Transaction
        btnOrderTickets.setText("Place Order");
        firstPanel.add(btnOrderTickets);
        btnOrderTickets.setBounds(416,438,113,20);
        btnOrderTickets.setEnabled(false);

        // Action Listener For Seat Type 
        cmbSeatType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                seatTypeActionPerformed(evt);
                actualTotalPriceActionPerformed(evt);


            }
        });
       


        // Receipt Title - Below Is Receipt Labels
        lblReceiptTitle.setFont(new Font("Times New Roman",Font.BOLD,18));
        lblReceiptTitle.setForeground(Color.LIGHT_GRAY);
        lblReceiptTitle.setText("CBITES RECEIPT");
        secondPanel.add(lblReceiptTitle);
        lblReceiptTitle.setBounds(217,12,198,30);

        // Movie Selection - Receipt
        lblMovieOrdered.setFont(new Font("Times New Roman",0,12));
        lblMovieOrdered.setForeground(Color.WHITE);
        lblMovieOrdered.setText("Movie Ordered:");
        secondPanel.add(lblMovieOrdered);
        lblMovieOrdered.setBounds(18,72,106,15);

        lblActualMovieOrdered.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualMovieOrdered.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualMovieOrdered);
        lblActualMovieOrdered.setBounds(120,67,183,25);

        // Image For The Movie - Receipt
        lblMovieImage.setBounds(350,60,250,250);
        lblMovieImage.setVisible(true);
        secondPanel.add(lblMovieImage);
        lblMovieImage.setBorder(BorderFactory.createEtchedBorder());

        // Time Of Show - Receipt
        lblMovieTime.setFont(new Font("Times New Roman",0,12));
        lblMovieTime.setForeground(Color.WHITE);
        lblMovieTime.setText("Time Of Film:");
        secondPanel.add(lblMovieTime);
        lblMovieTime.setBounds(18,102,106,15);

        lblActualMovieTime.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualMovieTime.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualMovieTime);
        lblActualMovieTime.setBounds(120,97,116,25);

        // Theatre Room - Receipt
        lblMovieTheatre.setFont(new Font("Times New Roman",0,12));
        lblMovieTheatre.setForeground(Color.WHITE);
        lblMovieTheatre.setText("Theatre No:");
        secondPanel.add(lblMovieTheatre);
        lblMovieTheatre.setBounds(18,132,106,15);

        lblActualMovieTheatre.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualMovieTheatre.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualMovieTheatre);
        lblActualMovieTheatre.setBounds(120,127,87,25);

        // Movie Age Rating - Receipt
        lblActualMovieRating.setFont(new Font ("Times New Roman", Font.BOLD, 12));
        lblActualMovieRating.setForeground(Color.WHITE);
        secondPanel.add(lblActualMovieRating);
        lblActualMovieRating.setBounds(227,167,76,40);
        lblActualMovieRating.setBorder(BorderFactory.createEtchedBorder());

        // Adult Tickets - Receipt
        lblAdultPrice.setFont(new Font("Times New Roman",0,12));
        lblAdultPrice.setForeground(Color.WHITE);
        lblAdultPrice.setText("Adult Tickets:");
        secondPanel.add(lblAdultPrice);
        lblAdultPrice.setBounds(18,162,106,15);

        lblActualAdultPrice.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualAdultPrice.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualAdultPrice);
        lblActualAdultPrice.setBounds(120,157,87,25);

        lblATicketQty.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblATicketQty.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblATicketQty);
        lblATicketQty.setBounds(180,157,87,25);

        // Child Tickets - Receipt
        lblChildPrice.setFont(new Font("Times New Roman",0,12));
        lblChildPrice.setForeground(Color.WHITE);
        lblChildPrice.setText("Child Tickets:");
        secondPanel.add(lblChildPrice);
        lblChildPrice.setBounds(18,192,106,15);

        lblActualChildPrice.setFont(new Font("Times New Roman",Font.ITALIC,12));
        lblActualChildPrice.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualChildPrice);
        lblActualChildPrice.setBounds(120,187,87,25);

        lblCTicketQty.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblCTicketQty.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblCTicketQty);
        lblCTicketQty.setBounds(180,187,87,25);

        // Snack Selected - Receipt
        lblSnackName.setFont(new Font("Times New Roman",0,12));
        lblSnackName.setForeground(Color.WHITE);
        secondPanel.add(lblSnackName);
        lblSnackName.setBounds(18,220,218,15);

        lblSnackQty.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblSnackQty.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblSnackQty);
        lblSnackQty.setBounds(153,215,87,25);

        // Drink Selected - Receipt
        lblDrinkName.setFont(new Font("Times New Roman",0,12));
        lblDrinkName.setForeground(Color.WHITE);
        secondPanel.add(lblDrinkName);
        lblDrinkName.setBounds(18,249,218,15);

        lblDrinkQty.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblDrinkQty.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblDrinkQty);
        lblDrinkQty.setBounds(153,244,87,25);

        // Method Of Payment - Receipt
        lblMthdOfPayment.setFont(new Font("Times New Roman",0,12));
        lblMthdOfPayment.setForeground(Color.WHITE);
        lblMthdOfPayment.setText("Method Of Payment:");
        secondPanel.add(lblMthdOfPayment);
        lblMthdOfPayment.setBounds(18,282,150,15);

        lblActualMtdPayment.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblActualMtdPayment.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualMtdPayment);
        lblActualMtdPayment.setBounds(149,278,87,25);
        
        // Date Of Film
        lblActualDateOfShow.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblActualDateOfShow.setForeground(Color.white);
        secondPanel.add(lblActualDateOfShow);
        lblActualDateOfShow.setBounds(274,67,87,25);
        
        // Type Of Seats
        lblActualSeatType.setFont(new Font("Times New Roman",Font.BOLD,12));
        lblActualSeatType.setForeground(Color.WHITE);
        secondPanel.add(lblActualSeatType);
        lblActualSeatType.setBounds(199,97,139,25);
        
        
        
        // Final Price To Pay On The Receipt 
        lblTotalPaid.setFont(new Font("Times New Roman",0,14));
        lblTotalPaid.setForeground(Color.WHITE);
        lblTotalPaid.setText("TOTAL PAID:");
        secondPanel.add(lblTotalPaid);
        lblTotalPaid.setBounds(383,322,150,15);

        lblActualTotalPaid.setFont(new Font("Times New Roman",Font.BOLD,14));
        lblActualTotalPaid.setForeground(new Color(0, 102, 255));
        secondPanel.add(lblActualTotalPaid);
        lblActualTotalPaid.setBounds(485,317,87,25);

        // Button Which Returns User Back To First Panel
        btnReturnMain.setText("New Order");
        secondPanel.add(btnReturnMain);
        btnReturnMain.setBounds(18,309,113,20);

        // Action Listener For Main Menu Button
        btnReturnMain.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                btnNewOrderActionPerformed(evt);

            }
        });

        // Progress Bar Which Creates A Loading Feature In Between The 2 Panels Which Display Information
        progrss = new JProgressBar(0,20);
        progrss.setValue(0);
        progrss.setStringPainted(true);

        thirdPanel.add(progrss);
        progrss.setBounds(94,83,221,50);

        JLabel lblLoading = new JLabel("Generating Receipt....");
        lblLoading.setForeground(Color.WHITE);
        lblLoading.setBounds(114, 48, 176, 30);
        thirdPanel.add(lblLoading);

        // Action Listener For Order Button - When Pressed Run The JProgress Bar
        btnOrderTickets.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                setSize(417,235);
                firstPanel.setVisible(false);
                thirdPanel.setVisible(true);
                endOfTime =0;
                time.start(); 

            }
        });

        // Sorts Out The Time And Length Of The Loading Page 
        time = new Timer(interval, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                if (endOfTime == 20){
                    time.stop();
                    thirdPanel.setVisible(false);
                    btnOrderActionPerformed(evt);

                }else{
                    endOfTime++;
                    progrss.setValue(endOfTime);
                }

            }
        });

        // Sets The Background For The Main Application In The First Panel
        lblBackgroundPic.setIcon(new ImageIcon(getClass().getResource("background.jpg")));
        firstPanel.add(lblBackgroundPic);
        lblBackgroundPic.setBounds(0,0,610,551);
        
        // Closes The File From The File Reader Class
        movieFile.closeFile();
        snacksFile.closeFile();
        drinksFile.closeFile();



    }


    /**
     * When The ComboBox For The Movie Selection Is Changed From It's Current State It Will Change The Behaviour
     * Of All Of Thes Elements Within The GUI
     */
    private void cmbMoviesActionPerformed(ActionEvent evt) {


        lblImgPreview.setText("");
        
                lblMoviesTheatreActionPerformed(evt);
                lblMoviesTimeActionPerformed(evt);
                lblMovieAgeRatingActionPerformed(evt);
                lblNoSeatsActionPerformed(evt);
                lblTicketPriceActionPerformed(evt);
                lblDateOfMovieActionPerformed(evt); 

 
 
                
                 
                 
        // Enable dropdowns when a valid movie is selected
    if (comboIndex1 != 0) {
        cmbSnacks.setEnabled(true);
        cmbSnacksQty.setEnabled(true);
        cmbDrinks.setEnabled(true);
        cmbDrinksQty.setEnabled(true);
        cmbSeatType.setEnabled(true);
        
    } else {
        cmbSnacks.setEnabled(false);
        cmbSnacksQty.setEnabled(false);
        cmbDrinks.setEnabled(false);
        cmbDrinksQty.setEnabled(false);
        cmbSeatType.setEnabled(false);
    }
    

        // Displays The Image Of The Movie From The ComboBox Depending On The Film Selected
        for (int i=0; i < comboIndex1; i++){
            lblImgPreview.setIcon(new ImageIcon(getClass().getResource(movieFile.displayFilmImage(comboIndex1)))); 
            

        }
         
        openSeatSelectionPopup();
        
    
        
        // If ComboBox is 0 Resets Everything As 0 Is Not A Film
        if (comboIndex1 == 0){
            lblImgPreview.setIcon(new ImageIcon(getClass().getResource("")));
            lblImgPreview.setText("SELECT A MOVIE");
            
      
            
            
            cmbSnacks.setEnabled(false);
            cmbSnacks.setSelectedIndex(comboIndex1);
            cmbSnacksQty.setEnabled(false);
            cmbSnacksQty.setSelectedIndex(comboIndex1);

            cmbDrinks.setEnabled(false);
            cmbDrinks.setSelectedIndex(comboIndex1);
            cmbDrinksQty.setEnabled(false);
            cmbDrinksQty.setSelectedIndex(comboIndex1);

            cmbSeatType.setEnabled(false);
            cmbSeatType.setSelectedIndex(0);

           
        
            
        }
      
    }


    // Displays The Theatre In Which The Movie Is Showing In
    private void lblMoviesTheatreActionPerformed(ActionEvent evt){
        lblActualTheatreNo.setText(movieFile.displayTheatreRoom(comboIndex1));

        if (comboIndex1 == 0){
            lblActualTheatreNo.setText("");
        }

    }
    // Displays The Time Of The Film That They Have Selected
    private void lblMoviesTimeActionPerformed(ActionEvent evt){
        if(comboIndex1 == 0){
            lblActualTimeOfShow.setText("");
        } else{
            lblActualTimeOfShow.setText(movieFile.displayTimeOfShow(comboIndex1));
        }
    }

    // Displays The Age Rating Of The Film Selected
    private void lblMovieAgeRatingActionPerformed(ActionEvent evt){
        String ratingF = movieFile.displayFilmRating(comboIndex1);
        lblActualAgeRating.setText(ratingF);

    }

    // Displays The Date Of Show For The Movie Selected
    private void lblDateOfMovieActionPerformed(ActionEvent evt){
        if (comboIndex1 == 0){
            lblActualDateOfFilm.setText("");
        }else{
            lblActualDateOfFilm.setText(movieFile.displayFilmDate(comboIndex1));
        }
    }

    // Displays The Number Of Seats Available For The Current Movie Selected
    private void lblNoSeatsActionPerformed(ActionEvent evt){
        seats = Integer.toString(movieFile.displayNumberOfSeats(comboIndex1));
        lblActualNoSeats.setText(seats);

        if (comboIndex1 == 0){
            lblActualNoSeats.setText("");
        }
    }

    // Displays The Price For The Film Which They Have Currently Selected
        private void lblTicketPriceActionPerformed(ActionEvent evt) {
        if (comboIndex1 > 0) {
            double adultPrice = movieFile.displayAdultTicket(comboIndex1);
            double childPrice = movieFile.displayChildTicket(comboIndex1);
    
            lblActualAdultTicket.setText(String.format("RM%.2f", adultPrice));
            lblActualChildTicket.setText(String.format("RM%.2f", childPrice));
        } else {
            lblActualAdultTicket.setText("RM0.00");
            lblActualChildTicket.setText("RM0.00");
        }
    }

    
    
    
    
    // Calculation To Find Out The Sub Total Of The Both Adult And Child Tickets Purchased
    private void lblSubTotalTicketActionPerformed(ActionEvent evt){
        adultQtyIndex = adultCountDropdown.getSelectedIndex();
        childQtyIndex = childCountDropdown.getSelectedIndex();

        double aFilmPrice = movieFile.displayAdultTicket(comboIndex1);
        double adultSubTtl = (aFilmPrice * adultQtyIndex);

        double cFilmPrice = movieFile.displayChildTicket(comboIndex1);
        double childSubTtl = (cFilmPrice * childQtyIndex);

        subTotalTickets = adultSubTtl + childSubTtl;

        ticketSubTotal = Double.toString(subTotalTickets);

        lblActualTicketSubTtl.setText("RM" +ticketSubTotal+"0");
    }

    // Resets/Disables The Values Of Some Of The Components Within The Gui If No Tickets Have Been Selected
    private void cmbTicketQtyActionPerformed(ActionEvent evt){
        adultQtyIndex = adultCountDropdown.getSelectedIndex();
        childQtyIndex = childCountDropdown.getSelectedIndex();

            if (adultQtyIndex == 0 && childQtyIndex==0){
                cmbSnacks.setEnabled(false);
                cmbSnacks.setSelectedIndex(0);
                cmbDrinks.setEnabled(false);
                cmbDrinks.setSelectedIndex(0);
                radioBtnCard.setEnabled(false);
                radioBtnCash.setEnabled(false);
                cmbSeatType.setEnabled(false);
                cmbSeatType.setSelectedIndex(0);
               
            }else{
                cmbSnacks.setEnabled(true);
                cmbDrinks.setEnabled(true);
                radioBtnCard.setEnabled(true);
                radioBtnCash.setEnabled(true);
                cmbSeatType.setEnabled(true);
        
            }

    }
    // Resets&or Resets The Value Of The Quantity ComboBox For The Snacks
    private void cmbSnacksActionPerformed(ActionEvent evt){
        int snackIndex = cmbSnacks.getSelectedIndex();
        if (snackIndex == 0){
            cmbSnacksQty.setEnabled(false);
            cmbSnacksQty.setSelectedIndex(0);
        }else{
            cmbSnacksQty.setEnabled(true);
            cmbSnacksQty.setSelectedIndex(1);
        }
    }
    
    // Resets&or Resets The Value Of The Quantity ComboBox For The Drinks
    private void cmbDrinksActionPerformed(ActionEvent evt){

        int drinkIndex = cmbDrinks.getSelectedIndex();

        if (drinkIndex == 0){
            cmbDrinksQty.setEnabled(false);
            cmbDrinksQty.setSelectedIndex(0);
        }else{
            cmbDrinksQty.setEnabled(true);
            cmbDrinksQty.setSelectedIndex(1);
        }

    }

    // Creates A SubTotal Which Calculates The Total Price Of The Snacks & Drinks Purchased.
    private void lblSnackDrinkSubTotalActionPerformed(ActionEvent evt){

        snackIndex = cmbSnacks.getSelectedIndex();
        snackQtyIndex = cmbSnacksQty.getSelectedIndex();

        drinkIndex = cmbDrinks.getSelectedIndex();
        drinkQtyIndex = cmbDrinksQty.getSelectedIndex();

        double snackPrice = snacksFile.displaySnackPrice(snackIndex);
        double snackSubTtl = (snackPrice * snackQtyIndex);

        double drinkPrice = drinksFile.displayDrinkPrice(drinkIndex);
        double drinkSubTtl = (drinkPrice * drinkQtyIndex);

        subTotalFood = drinkSubTtl + snackSubTtl;

        String foodSubTotal = Double.toString(subTotalFood);

        lblActualSDSubTotal.setText("RM"+foodSubTotal+"0");

    }

    // Depeneding On Item Selected In The ComboBox; The Price Of Seat Will Change
        private void seatTypeActionPerformed(ActionEvent evt) {
        int seatTypeIndex = cmbSeatType.getSelectedIndex();
    
        // Reset `subTotalSeatType` to avoid accumulation
        if (seatTypeIndex == 0) {
            subTotalSeatType = 5;
        } else if (seatTypeIndex == 1) {
            subTotalSeatType = 7;
        } else if (seatTypeIndex == 2) {
            subTotalSeatType = 9;
        }
    
        // Update total price
        actualTotalPriceActionPerformed(evt);
    }
    
    

    // Totals All The SubTotal To Give The Final Total To The User As To How Much They Need To Pay
    private void actualTotalPriceActionPerformed(ActionEvent evt){
        totalToPay = subTotalTickets + subTotalFood+subTotalSeatType;
        strTotal = Double.toString(totalToPay);
        lblActualTotalPrice.setText("RM"+strTotal+"0"); 
    }

    // If Card Radio Button Has Been Selected Then Set The Payment Method to Card
    private void cardRdioBtnActionPerformed(ActionEvent evt){
        if (radioBtnCard.isSelected()){
            paymentMethod = "Card";
            // Incase Anyone Enters Nothing It Will Catch The Null Pointer Exception And Not Do Anything
            try{
                String cardDetails = JOptionPane.showInputDialog(null, "Please Enter Card Details", "Card Payment"
                        , JOptionPane.OK_CANCEL_OPTION);
                //Checks Too See If What Has Been Entered Is Empty
                if (!cardDetails.isEmpty()){
                    btnOrderTickets.setEnabled(true);
                    disableEverythingActionPerformed(evt);
                }
            } catch(NullPointerException e){
                btnOrderTickets.setEnabled(false);
            }
        }


    }
    
    // A Method Which Disabled All Components On The Screen. This Is After The User Has Paid So Nohting Can Be Changed Until
    // Receipt Has Been Generated.
    private void disableEverythingActionPerformed(ActionEvent evt){
        cmbMovies.setEnabled(false);
        adultCountDropdown.setEnabled(false);
        childCountDropdown.setEnabled(false);
        cmbSnacks.setEnabled(false);
        cmbSnacksQty.setEnabled(false);
        cmbDrinks.setEnabled(false);
        cmbDrinksQty.setEnabled(false);
        cmbSeatType.setEnabled(false);
        
        radioBtnCard.setEnabled(false);
        radioBtnCash.setEnabled(false);
    }
    
    // If Cash Radio Button Has Been Selected Then Set The Payment Method to Cash
    private void cashRdioBtnActionPerformed(ActionEvent evt){
        String cashEntered; 
        // Checks To See If It Is Selected
        if(radioBtnCash.isSelected()){
            // Set Payment Cash
            paymentMethod = "Cash";
            // Tries To Catch's Two Errors - First being if a non-numerical Value Has Been Entered
            // Second If Nothing Has Been Entered At All
            try{
                cashEntered = JOptionPane.showInputDialog(null, "Please Enter Cash Paid:", "Cash Payment"
                        , JOptionPane.OK_CANCEL_OPTION);
                cashPaid = Double.parseDouble(cashEntered);
                changeReturned = cashPaid - totalToPay;
                // Loops If The Cash Entered Is A Smaller Amount Than What They Need To Pay
                while (cashPaid < totalToPay){
                    cashEntered = JOptionPane.showInputDialog(null, "Please Enter The Full Amount Of Cash To Be Paid:",
                            "Cash Payment"
                            , JOptionPane.OK_CANCEL_OPTION);
                    cashPaid = Double.parseDouble(cashEntered);
                    changeReturned = cashPaid - totalToPay;
                }

                // Converts To String After Working Out The Change To Be Presented In A Dialog Box
                change = Double.toString(changeReturned);
                JOptionPane.showMessageDialog(null, "Change Returned: RM"+change+"0");
                btnOrderTickets.setEnabled(true);
                disableEverythingActionPerformed(evt);
            // Dialog Box's IF Non-Numerical Values Have Been Entered
            }catch(NumberFormatException | NullPointerException e){
                JOptionPane.showMessageDialog(null, "Please enter numbers only");
                btnOrderTickets.setEnabled(false);
            }
        }
    }
    // Action Event For When The Order Button Is Pressed -
    public void btnOrderActionPerformed(ActionEvent evt){
        setSize(610,385);
        firstPanel.setVisible(false);
        secondPanel.setVisible(true);
        lblActualMovieOrdered.setText(movieFile.displayFilmName(comboIndex1));
        lblMovieImage.setIcon(new ImageIcon(getClass().getResource(movieFile.displayFilmImage(comboIndex1))));
        lblActualMovieTime.setText(movieFile.displayTimeOfShow(comboIndex1));
        lblActualDateOfShow.setText(movieFile.displayFilmDate(comboIndex1));
        lblActualMovieTheatre.setText(movieFile.displayTheatreRoom(comboIndex1));
        lblActualMovieRating.setText("Rated:"+movieFile.displayFilmRating(comboIndex1));
        lblActualAdultPrice.setText("RM"+movieFile.displayAdultTicket(comboIndex1)+"0");
        lblATicketQty.setText("x"+adultQtyIndex);
        lblActualChildPrice.setText("RM"+movieFile.displayChildTicket(comboIndex1)+"0");
        lblCTicketQty.setText("x"+childQtyIndex);
        if (snackIndex==0){
            lblSnackName.setText("No Snacks Purchased With Ticket/s");
            lblSnackQty.setText("");
        }else{
            lblSnackName.setText(snacksFile.displaySnack(snackIndex));
            lblSnackQty.setText("x"+snackQtyIndex);
        }
        if (drinkIndex == 0){
            lblDrinkName.setText("No Drinks Purchased With Ticket/s");
            lblDrinkQty.setText("");
        }else{
            lblDrinkName.setText(drinksFile.displayDrink(drinkIndex));
            lblDrinkQty.setText("x"+drinkQtyIndex);
        }

        lblActualMtdPayment.setText(paymentMethod);
        lblActualSeatType.setText((String) cmbSeatType.getSelectedItem());
        
    
        

        lblActualTotalPaid.setText("RM"+strTotal+"0");
        int updatedSeats = movieFile.displayNumberOfSeats(comboIndex1) - (adultQtyIndex + childQtyIndex);
        seats = Integer.toString(updatedSeats);

    }

    // Action Event To Display The Original Screen Once User/Customer Have Seen The Receipt
    private void btnNewOrderActionPerformed(ActionEvent evt){
        setSize(610,565);
        firstPanel.setVisible(true);
        secondPanel.setVisible(false);
        cmbMovies.setEnabled(true);
        lblActualNoSeats.setText(seats);
        adultCountDropdown.setSelectedIndex(0);
        childCountDropdown.setSelectedIndex(0);
        cmbDrinks.setSelectedIndex(0);
        cmbSnacks.setSelectedIndex(0);
        btnOrderTickets.setEnabled(false);
        radioBtnCard.setSelected(false);
        radioBtnCash.setSelected(false);
        

    }
    

}    




