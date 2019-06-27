package enumm;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Objects;

public class EnumerationServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8999);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        ColorEnumCustomerial colorEnum = (ColorEnumCustomerial) objectInputStream.readObject();
        if (colorEnum == ColorEnumCustomerial.BLUE) {
            System.out.println("color is ==");
        } else if (Objects.equals(ColorEnumCustomerial.BLUE, colorEnum))
            System.out.println("color is equals");
        else
            System.out.println("color is different");
        switch (colorEnum) {
            case BLUE:
                System.out.println("color is ==");
                break;
            default:
                System.out.println("color is different");
                break;
        }
    }
}
