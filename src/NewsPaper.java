
import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rutul
 */
public class NewsPaper {
    private final String name;
    private final int price;
    private String headline;
    private final String url;
    private final Parser parser;

    public NewsPaper(String name, int price, String url) throws SAXException, IOException, MalformedURLException, ParserConfigurationException {
        this.name = name;
        this.price = price;
        this.url = url;
        parser = new Parser(url);   
    }
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getHeadline() {
        return parser.getHeadline();
    }
    
    public Parser getParser() {
        return this.parser;
    }
    
    
    
}
