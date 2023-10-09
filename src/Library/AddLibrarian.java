package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLibrarian extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5;
    JPasswordField pf1;
    Font f1,f2;
    AddLibrarian(){
        super("Add Librarian");
        setLocation(450,200);
        setSize(650,400);

        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Add Librarian");
        l2=new JLabel("Name*");
        l3=new JLabel("Password*");
        l4=new JLabel("Email*");
        l5=new JLabel("Contact*");
        l6=new JLabel("Address");
        l7=new JLabel("City");

        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();

        pf1=new JPasswordField();

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);

        tf1.setFont(f2);
        tf2.setFont(f2);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);

        pf1.setFont(f2);

        b1=new JButton("Add Librarian");
        b2=new JButton("Cancel");

        b1.setFont(f2);
        b2.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,0,0));
        p1.add(l1);
        p1.setBackground(Color.black);

        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(b1);
        p2.add(b2);


        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }
    public void actionPerformed(ActionEvent ae){
        String name=tf1.getText();
        String password=pf1.getText();
        String email=tf2.getText();
        String contactNo=tf3.getText();
        String address=tf4.getText();
        String city=tf5.getText();

        if(ae.getSource()==b1){
            try{
                ConnectionClass obj=new ConnectionClass();
                String query="insert into librarian(name,password,contact,address,city,email) values ('"+name+"','"+password+"','"+contactNo+"','"+address+"','"+city+"','"+email+"')";
                int a=obj.stm.executeUpdate(query);
                if(a==1){

                        JOptionPane.showMessageDialog(null,"Your data  Successfully inserted");
                        this.setVisible(false);
                    }
                else {
                    JOptionPane.showMessageDialog(null,"Please! Fill all details carefully!");
                    this.setVisible(true);

                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(ae.getSource()==b2){
            this.setVisible(false);

        }



    }

    public static void main(String[] args) {
        new AddLibrarian().setVisible(true);
    }
}
