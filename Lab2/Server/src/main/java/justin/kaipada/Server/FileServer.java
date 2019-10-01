// package justin.kaipada.Server;

import java.io.*;
import java.rmi.*;

public class FileServer {
   public static void main(String argv[]) {
      if(System.getSecurityManager() == null) {
         System.setSecurityManager(new SecurityManager());
      }
      try {
         FileInterface fi = new FileImpl("FileServer");
         Naming.rebind("//192.197.54.29/FileServer", fi);
      } catch(Exception e) {
         System.out.println("FileServer: "+e.getMessage());
         e.printStackTrace();
      }
      System.out.println("Server has started!");
   }
}
