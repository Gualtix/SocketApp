package Server;
import Model.Vehicle;
import java.net.*;
import java.io.*;

/**
 *
 * @author walter.morales03
 */
public class Server implements Runnable{

    private Socket socket = null;
    private ServerSocket server = null;
    int port;


    @Override
    public void run() {

        try {

            server = new ServerSocket(port);
            System.out.println("Server Started!");

            System.out.println("Waiting for Client...");
            socket = server.accept();

            System.out.println("Client Accepted!");

            InputStream inputStream = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            Vehicle Obj = (Vehicle) objectInputStream.readObject();

            System.out.println("Object Received!");
            FileStorage(Obj);

            Obj.ShowDemostration();

            System.out.println("Closing connection");
            socket.close();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void FileStorage(Vehicle v) throws IOException{

        File file = new File("c:\\files\\Vehicle.bin");
        file.getParentFile().mkdirs(); // Will create parent directories if not exists
        file.createNewFile();
        FileOutputStream s = new FileOutputStream(file, false);

        ObjectOutputStream tmp = new ObjectOutputStream(s);
        tmp.writeObject(v);
        tmp.close();
    }

    public Server(int port) {
        this.port = port;
    }    
}
