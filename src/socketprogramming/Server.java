/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Server {
    private static String str="";
public static void main(String args[]) {
int port = 6744;
try {
ServerSocket ss = new ServerSocket(port);
Socket s = ss.accept();
InputStream is = s.getInputStream();
ObjectInputStream ois = new ObjectInputStream(is);
MessageImpl to = (MessageImpl)ois.readObject();
ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
str="";
CountDigits(to);
CountCharecters(to);
oos.writeObject(str);

is.close();
s.close();
ss.close();
}catch(Exception e){System.out.println(e);}
}

private  static void CountDigits( MessageImpl to ) {
    
int c=0;
for(int i=0;i<to.value.length();i++)
{
if(Character.isDigit(to.value.charAt(i)))
{
c++;
}
}
// JOptionPane.showMessageDialog(null, "Number of Digits is : "+c);
str+="Number of Digits is : "+c+ " AND ";
}

private static void CountCharecters( MessageImpl to ) {
int c=0;
for(int i=0;i<to.value.length();i++)
{
if(!Character.isDigit(to.value.charAt(i)))

{
c++;
}
}
// JOptionPane.showMessageDialog(null, "Number of Chars is : "+c);
str+="Number of Chars is : "+c;
}
}