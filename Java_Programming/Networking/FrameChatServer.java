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
    ServerSocket ssobj;
    Socket sobj;
    PrintStream pobj;
    BufferedReader bobj1;

    Thread t;  // Thread to read messages from client

    public MarvellousLogin(String title,int width,int height)
    {
        fobj = new JFrame(title);
        fobj.setSize(width,height);

        Userlabel = new JLabel("Message :");
        Userlabel.setBounds(50,50,100,30);

        tobj = new JTextField();
        tobj.setBounds(150,50,150,30);

        bobj = new JButton("SEND");
        bobj.setBounds(150,100,100,30);

        Resultlabel = new JLabel("Waiting for client...");
        Resultlabel.setBounds(50,150,400,30);

        fobj.add(bobj);
        fobj.add(tobj);
        fobj.add(Userlabel);
        fobj.add(Resultlabel);

        bobj.addActionListener(this);

        fobj.setLayout(null);
        fobj.setVisible(true);
        fobj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Start server socket in background
        startServer();
    }

    public void startServer()
    {
        try
        {
            ssobj = new ServerSocket(5100);
            Resultlabel.setText("Server started. Waiting for client...");
            sobj = ssobj.accept();
            Resultlabel.setText("Client connected!");

            pobj = new PrintStream(sobj.getOutputStream());
            bobj1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));

            // Start background thread to read client messages
            t = new Thread(this);
            t.start();
        }
        catch(Exception e)
        {
            Resultlabel.setText("Error: " + e.getMessage());
        }
    }

    // Handle SEND button click
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
                Resultlabel.setText("Client: " + str);
            }
        }
        catch(Exception e)
        {
            Resultlabel.setText("Connection closed.");
        }
    }
}

class FrameChatServer
{
    public static void main(String A[])
    {
        new MarvellousLogin("Marvellous Chat Server", 500, 300);
    }
}