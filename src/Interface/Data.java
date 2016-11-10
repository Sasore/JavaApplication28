/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author soare_000
 */
import com.sun.media.sound.Toolkit;
import java.awt.Image;
import java.net.URL;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

public class Data {

    public String getDatatime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);

    }

    public String getHoraTime() {
        DateFormat HoraFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        return HoraFormat.format(date);

    }
    
}
