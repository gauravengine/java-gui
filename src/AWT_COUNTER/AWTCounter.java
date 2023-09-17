package AWT_COUNTER;
import java.awt.*;
import java.awt.event.*;
public class AWTCounter extends Frame{
    private Label myLabel;
    private TextField countDisplay;
    private Button btnCount;
    private int count =0;
    public AWTCounter() {
        this.setLayout(new FlowLayout());
        myLabel=new Label("Counter");
        this.add(myLabel);

        countDisplay=new TextField(count+" ",10);
        countDisplay.setEditable(false);
        this.add(countDisplay);

        btnCount=new Button("Increment Count");
        this.add(btnCount);

        BtnCountListener listener=new BtnCountListener();
        btnCount.addActionListener(listener);

        this.setTitle("COUNTER");

        this.setSize(400,100);


        this.addWindowListener(new MyWindowListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("through windows adapter :: "+ super.toString());
            }
        });
        this.setVisible(true);
        System.out.println(this);
    }
    public static void main(String[] args) {
        new AWTCounter();
    }

    private class BtnCountListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            ++count;
            System.out.println(e);
            countDisplay.setText(count + "");
        }
    }

    private class MyWindowListener implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {
            System.out.println("Window Opened");

        }

        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println(this);

            dispose();
            System.out.println(this);
            System.out.println("Closing Window");
//            System.exit(69);

        }

        @Override
        public void windowClosed(WindowEvent e) {
            System.out.println("Window closed");
        }

        @Override
        public void windowIconified(WindowEvent e) {
            System.out.println("Icon Added");
        }

        @Override
        public void windowDeiconified(WindowEvent e) {
            System.out.println("Icon Removed");
        }

        @Override
        public void windowActivated(WindowEvent e) {
            System.out.println("Window Activated");
        }

        @Override
        public void windowDeactivated(WindowEvent e) {
            System.out.println("Window Deactivated");
        }
    }
}