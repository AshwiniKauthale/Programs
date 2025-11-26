import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class MarvellousLogin implements ActionListener, Runnable
{
    // GUI components
    JFrame fobj;
    JButton bobj;
    JTextField tobj;
    JLabel Userlabel, Resultlabel;

    // Networking

    Socket sobj;
    PrintStream pobj;
    BufferedReader bobj1;

    Thread t;  // thread to receive messages from server

    public MarvellousLogin(String title, int width, int height)
    {
        fobj = new JFrame(title);
        fobj.setSize(width, height);

        Userlabel = new JLabel("Message:");
        Userlabel.setBounds(50, 50, 100, 30);

        tobj = new JTextField();
        tobj.setBounds(150, 50, 150, 30);

        bobj = new JButton("SEND");
        bobj.setBounds(150, 100, 100, 30);

        Resultlabel = new JLabel("Connecting to server...");
        Resultlabel.setBounds(50, 150, 400, 30);

        fobj.add(bobj);
        fobj.add(tobj);
        fobj.add(Userlabel);
        fobj.add(Resultlabel);

        bobj.addActionListener(this);

        fobj.setLayout(null);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // connect client to server
        connectToServer();
    }

    // Connect to server
    public void connectToServer()
    {
        try
        {

            sobj = new Socket("localhost", 5100);
            Resultlabel.setText("Connected to server at port 5100");

            pobj = new PrintStream(sobj.getOutputStream());
            bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

            // start thread to receive messages from server
            t = new Thread(this);
            t.start();
        }
        catch(Exception e)
        {
            Resultlabel.setText("Connection failed: " + e.getMessage());
        }
    }

    // Send button logic
    public void actionPerformed(ActionEvent aobj)
    {
        try
        {
            String msg = tobj.getText();
            pobj.println(msg);
            
            Resultlabel.setText("You: " + msg);
            tobj.setText("");
        }
        catch(Exception e)
        {
            Resultlabel.setText("Error sending message!");
        }
    }

    // Background thread to read incoming messages
    public void run()
    {
        try
        {
            String str;
            while((str = bobj1.readLine()) != null)
            {
                Resultlabel.setText("Server: " + str);
            }
        }
        catch(Exception e)
        {
            Resultlabel.setText("Connection closed.");
        }
    }
}

// Main class (acts as Chat Client GUI)
class FrameChatClient
{
    public static void main(String A[])
    {
        new MarvellousLogin("Marvellous Chat Client", 500, 300);
    }
}
