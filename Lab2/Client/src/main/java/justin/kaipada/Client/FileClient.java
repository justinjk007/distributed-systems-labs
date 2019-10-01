import java.io.*;
import java.rmi.*;

public class FileClient{
    public static void main(String argv[]) {
        if(argv.length == 3){
            try{
                String name = "//127.0.0.1/FileServer";
                FileInterface fi = (FileInterface) Naming.lookup(name);
                File file = new File(argv[0]);

                byte buffer[] = new byte[(int)file.length()];
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(argv[0]));
                input.read(buffer,0,buffer.length);
                fi.uploadFile(buffer, argv[0]);


                input.close();
            } catch (Exception e){

            }
        }
        else if(argv.length == 2) {


            try {
                String name = "//" + argv[1] + "/FileServer";
                FileInterface fi = (FileInterface) Naming.lookup(name);
                byte[] filedata = fi.downloadFile(argv[0]);
                File file = new File(argv[0]);
                BufferedOutputStream output = new
                        BufferedOutputStream(new FileOutputStream(file.getName()));
                output.write(filedata,0,filedata.length);
                output.flush();
                System.out.println("File download complete");
                output.close();
            } catch(Exception e) {
                System.err.println("FileServer exception: "+ e.getMessage());
                e.printStackTrace();
            }

        }

    }
}
