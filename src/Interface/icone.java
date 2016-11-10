/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

/**
 *
 * @author Adriano
 */

  
import java.awt.Image;  
import java.awt.Toolkit;  
import java.net.URL;  
import javax.swing.JFrame;  
  
/** 
* 
* @author rhuan 
*/  
public class icone extends JFrame {  
    URL caminhoImagem;  
    Image iconeTitulo;  
      
    public icone(){  
        super("MUDANDO ICONE DO JAVA!");  
          
        caminhoImagem = this.getClass().getClassLoader().getResource("src\\icones\1.png");  
        iconeTitulo = Toolkit.getDefaultToolkit().getImage(caminhoImagem);  
          
        setIconImage(iconeTitulo);  
        setResizable(false);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(400, 300);  
        setLocationRelativeTo(null);  
        setVisible(true);  
    }  
      
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String[] args) {  
        icone novaJanela = new icone();  
    }  
}  