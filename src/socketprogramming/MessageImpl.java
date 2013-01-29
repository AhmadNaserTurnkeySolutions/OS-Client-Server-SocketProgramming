/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketprogramming;

 
import java.net.*;
import java.io.*;
class MessageImpl implements Serializable {

String value;
public  MessageImpl(String v ){
this.value=v;
}
}