package puzzle;

import java.util.Arrays;
import java.util.Random;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FramePuzzle extends JFrame implements ActionListener {

    String[] arr = {"1","2","3","4","5","6","7","8"," "};

    JButton [] b = new JButton[9];
    JButton next,reset;
    FramePuzzle() {
        super("JFrame Puzzle");

        for (int i = 0; i < 9; i++) {
            b[i] = new JButton(arr[i]); // Initialize each element with a new JButton
        }
        next=new JButton("solve");
        reset=new JButton("reset");

        b[0].setBounds(30,40,50,40);
        b[1].setBounds(90,40,50,40);
        b[2].setBounds(150,40,50,40);
        b[3].setBounds(30,90,50,40);
        b[4].setBounds(90,90,50,40);
        b[5].setBounds(150,90,50,40);
        b[6].setBounds(30,140,50,40);
        b[7].setBounds(90,140,50,40);
        b[8].setBounds(150,140,50,40);
        next.setBounds(30,210,80,40);
        reset.setBounds(140,210,80,40);

        for (int i = 0; i < 9; i++) {
            add(b[i]);
            b[i].addActionListener(this);
        }
        add(next);
        add(reset);
        next.addActionListener(this);
        reset.addActionListener(this);


//        next.setBackground(Color.black);
        next.setForeground(Color.green);
        reset.setForeground(Color.green);
        setSize(250,300);
        setLayout(null);
        setLocationRelativeTo(null);   // pops the frame in center of screen
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if(e.getSource() == next) {
            Arrays.sort(arr);
            for(int i = 0;i<9;i++){
                b[i].setText(arr[i]);
            }
        }

        if(e.getSource() == reset){
            shuffle(arr);
            for(int i = 0;i<9;i++){
                b[i].setText(arr[i]);
            }
        }

        if(e.getSource()==b[0]) {
            String s=b[0].getText();
            if(b[1].getText().equals(" ")) {b[1].setText(s); b[0].setText(" ");}
            else if(b[3].getText().equals(" ")) {b[3].setText(s); b[0].setText(" ");}

        }

        if(e.getSource()==b[1]) {
            String s=b[1].getText();
            if(b[0].getText().equals(" ")) {b[0].setText(s); b[1].setText(" ");}
            else if(b[2].getText().equals(" ")) {b[2].setText(s); b[1].setText(" ");}
            else if(b[4].getText().equals(" ")) {b[4].setText(s); b[1].setText(" ");}

        }

        if(e.getSource()==b[2]) {
            String s=b[2].getText();
            if(b[1].getText().equals(" ")) {b[1].setText(s); b[2].setText(" ");}
            else if(b[5].getText().equals(" ")) {b[5].setText(s); b[2].setText(" ");}

        }

        if(e.getSource()==b[3]) {
            String s=b[3].getText();
            if(b[0].getText().equals(" ")) {b[0].setText(s); b[3].setText(" ");}
            else if(b[4].getText().equals(" ")) {b[4].setText(s); b[3].setText(" ");}
            else if(b[6].getText().equals(" ")) {b[6].setText(s); b[3].setText(" ");}

        }

        if(e.getSource()==b[4]) {
            String s=b[4].getText();
            if(b[1].getText().equals(" ")) {b[1].setText(s); b[4].setText(" ");}
            else if(b[3].getText().equals(" ")) {b[3].setText(s); b[4].setText(" ");}
            else if(b[5].getText().equals(" ")) {b[5].setText(s); b[4].setText(" ");}
            else if(b[7].getText().equals(" ")) {b[7].setText(s); b[4].setText(" ");}

        }

        if(e.getSource()==b[5]) {
            String s=b[5].getText();
            if(b[2].getText().equals(" ")) {b[2].setText(s); b[5].setText(" ");}
            else if(b[4].getText().equals(" ")) {b[4].setText(s); b[5].setText(" ");}
            else if(b[8].getText().equals(" ")) {b[8].setText(s); b[5].setText(" ");}

        }

        if(e.getSource()==b[6]) {
            String s=b[6].getText();
            if(b[3].getText().equals(" ")) {b[3].setText(s); b[6].setText(" ");}
            else if(b[7].getText().equals(" ")) {b[7].setText(s); b[6].setText(" ");}

        }

        if(e.getSource()==b[7]) {
            String s=b[7].getText();
            if(b[6].getText().equals(" ")) {b[6].setText(s); b[7].setText(" ");}
            else if(b[4].getText().equals(" ")) {b[4].setText(s); b[7].setText(" ");}
            else if(b[8].getText().equals(" ")) {b[8].setText(s); b[7].setText(" ");}

        }

        if(e.getSource()==b[8]) {
            String s=b[8].getText();
            if(b[7].getText().equals(" ")) {b[7].setText(s); b[8].setText(" ");}
            else if(b[5].getText().equals(" ")) {b[5].setText(s); b[8].setText(" ");}
            if(b[0].getText().equals(" ")&&b[1].getText().equals("1")&&
                    b[2].getText().equals("2")&&b[3].getText().equals("3")&&
                    b[4].getText().equals("4")&&b[5].getText().equals("5")&&
                    b[6].getText().equals("6")&&b[7].getText().equals("7")&&
                    b[8].getText().equals("8")) {
                JOptionPane.showMessageDialog(FramePuzzle.this, "You won the game!");
            }
        }
    }

    public static void shuffle(String[] arr){
        Random rand = new Random();
        for(int i = 8;i>=0;i--){
            // generating a random number between 0 and i
            int j = rand.nextInt(i+1);
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        new FramePuzzle();

    }
}
