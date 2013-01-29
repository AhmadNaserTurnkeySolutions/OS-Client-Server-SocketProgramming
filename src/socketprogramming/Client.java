/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;
import java.net.*;
import java.io.*;
import javax.print.DocFlavor.INPUT_STREAM;
import javax.swing.JOptionPane;
public class Client {
public static void main(String args[]){
    
String input_data=JOptionPane.showInputDialog("Please Enter String to server");

    while(input_data.trim().equals("")){
        input_data=JOptionPane.showInputDialog("Please Enter String to server");
    }
    
try{
Socket s = new Socket("localhost",6744);
OutputStream os = s.getOutputStream();
InputStream inp = s.getInputStream();
ObjectOutputStream oos = new ObjectOutputStream(os);
MessageImpl to = new MessageImpl(input_data);
oos.writeObject(to);
ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
String input_server = (String)ois.readObject();    
JOptionPane.showMessageDialog(null,"                    For the string "+input_data + "\n" +input_server);
oos.close();
os.close();
s.close();
}catch(Exception e){System.out.println(e);}
}
}