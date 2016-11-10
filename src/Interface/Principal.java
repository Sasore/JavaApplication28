/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JWindow;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;


/**
 *
 * @author soare_000
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException, ParseException {
        SetProtocolo a= new SetProtocolo();
        a.setVisible(true);
               }
    

    }
