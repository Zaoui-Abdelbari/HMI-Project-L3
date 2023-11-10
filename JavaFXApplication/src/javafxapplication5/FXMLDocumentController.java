/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication5;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author pc
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField forget_answer;
    
    @FXML
    private Button rmstudent_Btn;

    @FXML
    private Button forget_backbtn;

    @FXML
    private AnchorPane forget_form;

    @FXML
    private Button forget_procedbtn;

    @FXML
    private ComboBox<?> forget_selectQ;

    @FXML
    private TextField forget_username;

    @FXML
    private Button login_btn;

    @FXML
    private Button login_createAccount;

    @FXML
    private Hyperlink login_forgetpassword;

    @FXML
    private AnchorPane login_form;

    @FXML
    private PasswordField login_password;

    @FXML
    private CheckBox login_selectshowpassword;

    @FXML
    private TextField login_showpassword;

    @FXML
    private TextField login_username;

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button recover_backbtn;

    @FXML
    private PasswordField recover_confirmp;

    @FXML
    private AnchorPane recover_form;

    @FXML
    private PasswordField recover_newp;

    @FXML
    private Button recover_procedbtn;

    @FXML
    private TextField signup_answer;

    @FXML
    private Button signup_btn;

    @FXML
    private PasswordField signup_confirmp;

    @FXML
    private TextField signup_email;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_loginAccount;

    @FXML
    private PasswordField signup_password;

    @FXML
    private ComboBox<?> signup_selecQ;

    @FXML
    private TextField signup_username;

    @FXML
    private Button home_Cbtn;

    @FXML
    private Button home_lobtn;

    @FXML
    private AnchorPane home_page;
    
    @FXML
    private TableColumn<?, ?> ADhome_page;

    @FXML
    private TableColumn<?, ?> bthhome_page;

    @FXML
    private TableColumn<?, ?> emhome_page;
    @FXML
    private TextField addaddress_home;

    @FXML
    private DatePicker adddatebirth_home;

    @FXML
    private TextField addemail_page;

    @FXML
    private Button addstudent_btn;

    @FXML
    private TextField addstudent_home;

    @FXML
    private TableColumn<?, ?> namehome_page;
    
    @FXML
    private TableView<?> studentTable;

    private Connection connect;
    private PreparedStatement prepare;
    private ResultSet result;
    private Statement statement;
    
    
    
    
    public Connection connectDB() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccount", "root", "");
            return connect;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void login() {
        printMessage print = new printMessage();

        if (login_username.getText().isEmpty() || login_password.getText().isEmpty()) {
            print.errorMessage("Make Sure to entre your Username and Password");
        } else {
            String selectData = "SELECT * FROM users WHERE "
                    + "username = ? and password = ?";
            connect = connectDB();
            if(login_selectshowpassword.isSelected()){
                login_password.setText(login_showpassword.getText());
            }else{
                login_showpassword.setText(login_password.getText());
            }
            try {

                prepare = connect.prepareStatement(selectData);
                prepare.setString(1, login_username.getText());
                prepare.setString(2, login_password.getText());

                result = prepare.executeQuery();
                if (result.next()) {
                    print.successMessage("Successfully Login!");
                    signup_form.setVisible(false);
                    login_form.setVisible(false);
                    forget_form.setVisible(false);
                    recover_form.setVisible(false);
                    home_page.setVisible(true);
                } else {
                    print.errorMessage("Incorrect Username/Password");

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
    
    
    
    

    /*public void switchhome(ActionEvent event){
               if(event.getSource() == login_btn){
                    signup_form.setVisible(false);
                    login_form.setVisible(false);
                    forget_form.setVisible(false);
                    recover_form.setVisible(false);
                    home_page.setVisible(true);
               }
                   
     }*/
   public void home() {

        printMessage print = new printMessage();

        if (home_Cbtn.isHover()) {

            print.successMessage("its Worked 100% Hello Wolrd");
        }

    }

    public void forgetpassword() {

        printMessage print = new printMessage();

        if (forget_username.getText().isEmpty()
                || forget_selectQ.getSelectionModel().getSelectedItem() == null
                || forget_answer.getText().isEmpty()) {

            print.errorMessage("Please entre your information!");
        } else {
            String cheakData = "SELECT username, question, answer FROM users "
                    + "WHERE username = ? AND question = ? AND answer = ?";

            connect = connectDB();

            try {
                prepare = connect.prepareStatement(cheakData);
                prepare.setString(1, forget_username.getText());
                prepare.setString(2, (String) forget_selectQ.getSelectionModel().getSelectedItem());
                prepare.setString(3, forget_answer.getText());

                result = prepare.executeQuery();

                if (result.next()) {
                    print.successMessage("Correct information!");
                    signup_form.setVisible(false);
                    login_form.setVisible(false);
                    forget_form.setVisible(false);
                    recover_form.setVisible(true);
                    home_page.setVisible(false);
                   

                } else {
                    print.errorMessage("Incorrect inormation!");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void forgetListQuestion() {
        List<String> ListQ = new ArrayList<>();
        for (String data : questionList) {
            ListQ.add(data);
        }

        ObservableList ListData = FXCollections.observableArrayList(ListQ);
        forget_selectQ.setItems(ListData);

    }

    public void register() {
        
        
        
        printMessage print = new printMessage();

        if (signup_email.getText().isEmpty() || signup_username.getText().isEmpty()
                || signup_password.getText().isEmpty() || signup_confirmp.getText().isEmpty()
                || signup_selecQ.getSelectionModel().getSelectedItem() == null
                || signup_answer.getText().isEmpty()) {

            print.errorMessage("Make sure to entre you're all information");

        } else if (!signup_confirmp.getText().equals(signup_password.getText())) {
            // here we gonna cheak if the value of password and cheak password are equal
            print.errorMessage("Password does not Much!");
        } else if (signup_password.getText().length() < 8) {
            print.errorMessage("ivalid Password, at least 8 Charcters needed");
        } else {
            String checkUsername = "SELECT * FROM users WHERE username = '"
                    + signup_username.getText() + "'";
            connect = connectDB();
            try {
            
                statement = connect.createStatement();
                result = statement.executeQuery(checkUsername);

                if (result.next()) {
                    print.errorMessage(signup_username.getText() + "is already taken");
                } else {
                    String insertData = "INSERT INTO users "
                            + "(email, username, password, passwordconf, question, answer, date) "
                            + "VALUES(?,?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, signup_email.getText());
                    prepare.setString(2, signup_username.getText());
                    prepare.setString(3, signup_password.getText());
                    prepare.setString(4, signup_confirmp.getText());
                    prepare.setString(5,
                            (String) signup_selecQ.getSelectionModel().getSelectedItem());
                    prepare.setString(6, signup_answer.getText());
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());

                    prepare.setString(7, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    print.successMessage("Registred successfully");

                    registerClearFields();

                    signup_form.setVisible(false);
                    login_form.setVisible(true);

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void showPassword() {

        if (login_selectshowpassword.isSelected()) {
            login_showpassword.setText(login_password.getText());
            login_showpassword.setVisible(true);
            login_password.setVisible(false);

        } else {
            login_password.setText(login_showpassword.getText());
            login_showpassword.setVisible(false);
            login_password.setVisible(true);
        }

    }

    public void registerClearFields() {
        signup_email.setText("");
        signup_username.setText("");
        signup_password.setText("");
        signup_confirmp.setText("");
        signup_selecQ.getSelectionModel().clearSelection();
        signup_answer.setText("");

    }

    public void loginClearFields() {

        login_username.setText("");
        login_password.setVisible(true);
        login_password.setText("");
        login_selectshowpassword.setSelected(false);
        login_showpassword.setVisible(false);

    }
    
    public void forgetClearFeilds(){
        forget_username.setText("");
        forget_answer.setText("");
    }
    
    public void Update_new_Password(){
        printMessage print = new printMessage();
        if(recover_newp.getText().isEmpty() || recover_confirmp.getText().isEmpty()){
            
            print.errorMessage("Please entre your New Password!");
            
        }else if(! recover_newp.getText().equals(recover_confirmp.getText())) {
            print.errorMessage("Password does not Much!");
        }else if(recover_newp.getText().length() < 8){
            
            print.errorMessage("ivalid Password, at least 8 Charcters needed!!");
            
        }else{
            String updateData = "UPDATE users SET password = ?   , update_date = ?"
                    + "WHERE username = '"+forget_username.getText()+ "'";
            connect = connectDB();
            
            try{
                prepare = connect.prepareStatement(updateData);
                
                prepare.setString(1, recover_newp.getText());
                
                
                Date date = new Date();
                
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                
                prepare.setString(2, String.valueOf(sqlDate));
                
                prepare.executeUpdate();
                
                print.successMessage("recover your new password are Succesfully");
                
                signup_form.setVisible(false);
                login_form.setVisible(true);
                forget_form.setVisible(false);
                recover_form.setVisible(false);
                home_page.setVisible(false);
                
                recover_newp.setText("");
                recover_confirmp.setText("");
                
                
            }catch(Exception e){e.printStackTrace();}
        }
    }
   
    
   

    public void switchForm(ActionEvent event) {

        if (event.getSource() == signup_loginAccount || event.getSource() == forget_backbtn) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
            forget_form.setVisible(false);
            recover_form.setVisible(false);
            home_page.setVisible(false);

            registerClearFields();
        } else if (event.getSource() == login_createAccount) {
            signup_form.setVisible(true);
            login_form.setVisible(false);
            forget_form.setVisible(false);
            recover_form.setVisible(false);
            home_page.setVisible(false);

        } else if (event.getSource() == login_forgetpassword) {
            signup_form.setVisible(false);
            login_form.setVisible(false);
            forget_form.setVisible(true);
            recover_form.setVisible(false);
            home_page.setVisible(false);
            forgetListQuestion();

        } else if (event.getSource() == recover_backbtn) {
            signup_form.setVisible(false);
            login_form.setVisible(false);
            forget_form.setVisible(true);
            recover_form.setVisible(false);
            home_page.setVisible(false);
            forgetClearFeilds();
        } else if (event.getSource() == home_lobtn) {
            signup_form.setVisible(false);
            login_form.setVisible(true);
            forget_form.setVisible(false);
            recover_form.setVisible(false);
            home_page.setVisible(false);
            loginClearFields();
        } 
            
    }

    private String[] questionList = {"What's you're favorite food?", "Where do you live now?",
        "What's the name of your college?", "What is your favorite sport?"};

    public void questions() {
        List<String> ListQ = new ArrayList<>();
        for (String data : questionList) {
            ListQ.add(data);
        }

        ObservableList ListData = FXCollections.observableArrayList(ListQ);
        signup_selecQ.setItems(ListData);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        questions();
        forgetListQuestion();
    }

}
