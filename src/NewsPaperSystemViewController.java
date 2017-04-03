/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * FXML Controller class
 *
 * @author Rutul
 */
public class NewsPaperSystemViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML    private Button theStarBtn;
    @FXML    private Button torontoSunBtn;
    @FXML    private Button barrieExaminerBtn;
    @FXML    private Button globeAndMailBtn;
    @FXML    private Button totalBtn;
    @FXML    private Label output;
    @FXML    private Label price;
    @FXML    private Label headline;
    @FXML    private Label totalLabel;
    @FXML    private Label date;
    @FXML    private Label tax;
    @FXML    private Label totalAmount; 
    @FXML    private Button printBtn;
    @FXML    private Button cancelBtn;
    
    NewsPaper theStar, torontoSun, barrieExaminer, globeAndMail;
    ArrayList<NewsPaper> newsPapers;
    String order = "", pricedisplay = "";
    double total = 0;
    double taxAmount = 0;
   
    public void buttonPressed(ActionEvent event) {
        Button button = (Button)event.getSource();
        String buttonId = button.getId();
        newsPapers.add(getNewsPaperFromId(buttonId));
        updateOrder(buttonId);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        newsPapers = new ArrayList<>();
        
        try {
                theStar = new NewsPaper("The Star",3 , "http://www.thestar.com/feeds.topstories.rss");
                torontoSun = new NewsPaper("Toronto Sun", 4, "http://www.torontosun.com/home/rss.xml");
                barrieExaminer = new NewsPaper("Barrie Examiner", 2, "http://www.thebarrieexaminer.com/news/local/rss.xml");
                globeAndMail = new NewsPaper("Globe And Mail", 5, "http://www.theglobeandmail.com/?service=rss");
                
                       headline.setText(theStar.getName() + "\n" + theStar.getHeadline()+"\n"+"\n"+
                      (torontoSun.getName() + "\n" + torontoSun.getHeadline())+"\n"+"\n"+
                      (barrieExaminer.getName() + "\n" + barrieExaminer.getHeadline())+"\n"+"\n"+
                      (globeAndMail.getName() + "\n" + globeAndMail.getHeadline()));
                       date.setText(LocalDate.now().toString());
                
                
                
            } catch (SAXException ex) {
                Logger.getLogger(LaunchNewsPaperSystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                Logger.getLogger(LaunchNewsPaperSystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(LaunchNewsPaperSystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(LaunchNewsPaperSystem.class.getName()).log(Level.SEVERE, null, ex);
            }

    }    
   
    private void updateOrder(String buttonId) {
        order += getNewsPaperFromId(buttonId).getName() + "\n";
        pricedisplay += "$" + getNewsPaperFromId(buttonId).getPrice() + "\n";
        output.setText(order);
        price.setText(pricedisplay);
        total += getNewsPaperFromId(buttonId).getPrice();
        totalLabel.setText("$" + Double.toString(total));
        
        taxAmount = (((total)*13)/100);
        tax.setText("$"+taxAmount);
       
    }
    
    public void totalButtonPushed() {
        totalAmount.setText("$"+(total+taxAmount));  
    }
    
    public void printButtonPushed() throws IOException {
         PrintWriter out = new PrintWriter(new FileWriter("Receipt.txt"));
         out.print(output +"\t\t"+ price+"\n");
    }
    
    public void cancelButtonPushed() {
        System.exit(0);
    }
    private NewsPaper getNewsPaperFromId(String buttonId) {
        if (buttonId.equals("theStarBtn"))    
            return theStar;
        else if (buttonId.equals("torontoSunBtn"))    
            return torontoSun;
        else if (buttonId.equals("barrieExaminerBtn"))    
            return barrieExaminer;
        else if (buttonId.equals("globeAndMailBtn"))    
            return globeAndMail;
        return null;
    }
}
