import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class myFrame extends JFrame implements ActionListener {
    JComboBox comboBox;
    JLabel expln;
    myFrame(){
        JLabel label = new JLabel();
        label.setText("Full Associative + Random Replacement Algorithm");
        label.setFont(new Font("Arial",Font.BOLD, 20));

        JLabel names = new JLabel();
        names.setText("Eugene Guillermo, Paula Pacheco, Johann Uytanlet, Marissa Villaceran ");
        names.setFont(new Font("Arial", Font.BOLD, 15));

        expln = new JLabel();

        expln.setFont(new Font("Arial", Font.BOLD, 10));



        String[] testCases = {"Sequential Sequence" , "Random Sequence", "Mid-repeat blocks"};
        comboBox=new JComboBox(testCases);
        comboBox.addActionListener(this);


        JFrame frame = new JFrame(); //creates a frame
        this.setSize(600, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();



        panel4.setBackground(Color.magenta);

        panel5.setLayout(new FlowLayout());

        panel1.setPreferredSize(new Dimension(100,100));
        panel2.setPreferredSize(new Dimension(100,100));
        panel3.setPreferredSize(new Dimension(100,100));
        panel4.setPreferredSize(new Dimension(100,100));
        panel5.setPreferredSize(new Dimension(100,100));

        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.WEST);
        this.add(panel3, BorderLayout.EAST);
        this.add(panel4, BorderLayout.SOUTH);
        this.add(panel5, BorderLayout.CENTER);

        panel1.add(label);
        panel1.add(names);
        panel5.add(comboBox);
        panel5.add(expln);

        //add button here sa south
        //add condition for going to next frame




    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==comboBox){
            //System.out.println(comboBox.getSelectedItem());
            int index=comboBox.getSelectedIndex();
            if(index==0){
                expln.setText("<html> <h3> Sequential Sequence </h3> <br>" +
                        "up to 2(32) cache block. Repeat the sequence four times. <br> Example: 0,1,2,3,...,63 {4x}</html> ");
                //Condition for setting sequence
            }
            else if(index==1){
                expln.setText("<html> <br> <h3> Random Sequence </h3> <br>" +
                        "containing 4(32) blocks </html>");
                //Condition for setting sequence
            }
            else{
                expln.setText("<html> <h3> Mid-repeat blocks</h3> <br>" +
                                " Start at block 0, repeat the sequence in the middle two times up to n-1 blocks, after\n" +
                        "which continue up to 2n. Then, repeat the sequence four times. <br> Example: if n=8," +
                        "<br> sequence=0, 1,2,3,4,5,6,1,2,3,4,5,6, 7,8,9,10,11,12,13,14,15 {4x} </html>");
                //Condition for setting sequence
            }

        }
    }


}
