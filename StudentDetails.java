/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac_4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author Atharva
 */
public class StudentDetails extends JFrame implements ActionListener
{
    JLabel l, l1, l2, l3, l4,jlx;
    JTextField tf1[];
    JPanel p,p1,p2,p3,p4;
    JButton b1;
    int a[][],j=0;
    StudentDetails()
    {
        a = new int[5][4];
        p = new JPanel(new GridLayout(4,1,10,10));
        p1 = new JPanel(new FlowLayout());
        p2 = new JPanel(new GridLayout(2,4,10,10));
        p3 = new JPanel(new FlowLayout());
        p4 = new JPanel(new FlowLayout());
        l = new JLabel("Enter Roll No. & Marks of 5 students");
        l1 = new JLabel("Roll No");
        l2 = new JLabel("Marks 1");     
        l3 = new JLabel("Marks 2");
        l4 = new JLabel("Marks 3");
        jlx = new JLabel("");
        tf1 = new JTextField[4];
        for(int i=0;i<4;i++){
            tf1[i] = new JTextField();
            tf1[i].addKeyListener(new KeyAdapter()
            {
	        public void keyTyped(KeyEvent e)
                {
                    char c = e.getKeyChar();
	            if(!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))
                    {
	                e.consume();
	            }
	        }
	    });
        }
        b1 = new JButton("Submit");
        b1.addActionListener(this);
        
        p1.add(l);
        p2.add(l1);  p2.add(l2);  p2.add(l3);  p2.add(l4);
        for(int i=0;i<4;i++){
            p2.add(tf1[i]);
        }        
        p3.add(b1);
        p4.add(jlx);
        
        p.setBorder(new EmptyBorder(10,10,10,10));
        p.add(p1);
        p.add(p2);
        p.add(p3);
        p.add(p4);
        add(p);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Details");
        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new StudentDetails();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int i,i2,temp;
        if(j<5){
            for(i=0;i<4;i++){
                a[j][i]=Integer.parseInt(tf1[i].getText());
                tf1[i].setText("");
            }
            if(j==4){
                for(i=1;i<4;i++){
                    tf1[i].setText("");
                    tf1[i].setEditable(false);
                }
                l.setText("<HTML>Enter the roll no. of student<br>to find out marks he has scored</HTML>");
                j=j+1;
            }
        }       
        j=j+1;

        if(j>6){
            int stats = 0;
            temp = Integer.parseInt(tf1[0].getText());
            for(i=0;i<5;i++){
                if(temp==a[i][0]){
                    stats =1;
                    for(i2=0;i2<4;i2++){
                        tf1[i2].setText(Integer.toString(a[i][i2]));
                        System.out.println(a[i][i2]);
                    }
                }
            }
            if(stats==0){
               jlx.setText("Roll no. does not exist");
            }
        }
    }
}