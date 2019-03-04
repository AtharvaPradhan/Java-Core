/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prac_4;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.*;
/**
 *
 * @author Atharva
 */
public class StringOperations extends JFrame implements ActionListener 
{
    Label l1[];
    TextField tf1, tf2, tf3[];
    Button b1;
    Panel p1, p2, p3;
    StringOperations(){
        p1 = new Panel(new GridLayout(9,2,5,5));
        p2 = new Panel(new GridLayout(3,2,5,5));
        p3 = new Panel(new GridLayout(2,1,5,5));

        l1 = new Label[11];
               
        l1[9] = new Label("Please Enter 1st string");
        l1[10] = new Label("Please Enter 2nd string");
        tf1 = new TextField();
        tf2 = new TextField();
        tf3 = new TextField[7];
        b1 = new Button("Go");
        b1.addActionListener(this);
        p2.add(l1[9]);      p2.add(tf1);
        p2.add(l1[10]);      p2.add(tf2);
        p2.add(b1);
        p3.add(p2);
        
        l1[0] = new Label("String Methods :");       
        l1[1] = new Label("     Character At 7 : ");
        l1[2] = new Label("     Concatinating 1st and 2nd string : ");
        l1[3] = new Label("     Index of Letter 'c' : ");
        l1[4] = new Label("     Substring from index 4 to 9 : ");
        
        l1[5] = new Label("String Buffer Methods :");
        l1[6] = new Label("     Appending 'Hello' to 1st string :");
        l1[7] = new Label("     Reversing 1st String :");
        l1[8] = new Label("     Inserting 'Hello' to 1st string :");
        Label a; 
        for(int i=0;i<9;i++){
            p1.add(l1[i]);
            if(i==5||i==0){
                p1.add(a = new Label(""));
            }
            else if(i>0&&i<5){
                p1.add(tf3[i-1] = new TextField());
            }
            else if(i>5){
                p1.add(tf3[i-2] = new TextField());
            }
            else{}
            
        }
        p3.add(p1);
        add(p3);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("String & String Buffer");
        setSize(600,500);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String s[];
        s = new String[7];
        StringBuffer s2[] = new StringBuffer[4];
        s[0] = tf1.getText().charAt(7)+"";
        s[1] = tf1.getText().concat(tf2.getText());
        s[2] = String.valueOf(tf1.getText().indexOf("c"));
        s[3] = tf1.getText().substring(4,9);
        
        StringBuffer s1 = new StringBuffer(tf1.getText());
        s2[0] = s1.append(" Hello");
        s[4] = s2[0].toString();
        
        s1 = new StringBuffer(tf1.getText());
        s2[1] = s1.reverse();
        s[5] = s2[1].toString();
        
        s1 = new StringBuffer(tf1.getText());
        s2[2] = s1.insert(7," Hello");
        s[6] = s2[2].toString();
        for(int i =0;i<7;i++){
            System.out.println(s[i]);
            tf3[i].setText(s[i]);
        }
    }
    public static void main(String[] args) {
        new StringOperations();
    }
}