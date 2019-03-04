/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac_5;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
/**
 *
 * @author kjssc
 */
public class team extends JFrame implements ActionListener
{
    JPanel p1, p2, p3, p4, p5;
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField tf1 ,tf2[], tf3, tf4, tf5;   // 
    JButton b1;
    
    public team()
    {
        p1 = new JPanel(new GridLayout(4,1,5,5));
        p1.setBackground(Color.orange);
        
        p2 = new JPanel(new GridLayout(1,2,20,20));
        p2.setBorder(new EmptyBorder(50,80,50,80));
        l1 = new JLabel("Enter Team Name:");
        tf1 = new JTextField();
        p2.setBackground(Color.orange);
        p2.add(l1);     p2.add(tf1);
        
        p3 = new JPanel(new GridLayout(2,8,10,10));
        p3.setBackground(Color.orange);
        tf2 = new JTextField[4];
        for(int i = 0; i < 4; i++)
        {
            tf2[i] = new JTextField();
            p3.add(tf2[i]);
        }
        l2 = new JLabel("Atharva");
        l3 = new JLabel("Akshay");
        l4 = new JLabel("Aman");
        l5 = new JLabel("Hritik");
        p3.add(l2);     p3.add(l3);     p3.add(l4);     p3.add(l5);
        
        p4 = new JPanel(new FlowLayout());
        b1 = new JButton("Show Statistics");
        b1.addActionListener(this);
        p4.add(b1);
        p4.setBackground(Color.orange);
        
        p5 = new JPanel(new GridLayout(3,2,10,10));
        l6 = new JLabel("Average score");
        l7 = new JLabel("Minimum score");
        l8 = new JLabel("Maximum score");
        tf3 = new JTextField();
        tf3.setEditable(false);
        tf4 = new JTextField();
        tf4.setEditable(false);
        tf5 = new JTextField();
        tf5.setEditable(false);
        p5.add(l6);     p5.add(tf3);     
        p5.add(l7);     p5.add(tf4);     
        p5.add(l8);     p5.add(tf5);
        p5.setBackground(Color.orange);

        p1.setBorder(new EmptyBorder(10,20,20,20));
        p1.add(p2);     p1.add(p3);     p1.add(p4);     p1.add(p5);     
        
        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.orange);
        setTitle("Team");
        setSize(600,600);
        setVisible(true);
    }
    
    public void actionPerformed (ActionEvent e)
    {
        int i,a1[],avg = 0,min = 0,max=0;
        a1=new int[tf2.length];
        for(i=0;i < tf2.length;i++)
        {   
            a1[i] = Integer.parseInt(tf2[i].getText());
            if (i==0)
            {
                min = a1[0];
            }
            
            avg = avg+a1[i];
            if(a1[i]<min)
            {
                System.out.println(i);
                min = a1[i];
            }
            
            if(a1[i]>max)
            {
                max = a1[i];
            }
            //System.out.println(i);
        }
        avg = avg/tf2.length;
        tf3.setText(Integer.toString(avg));
        tf4.setText(Integer.toString(min));
        tf5.setText(Integer.toString(max));
    }
    
    
    public static void main(String[] args) {
        new team();
    }
}
