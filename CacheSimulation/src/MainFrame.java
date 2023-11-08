import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame
{
    public JLabel[] cacheBlocks, mainMemory;
    public JPanel northPanel, westPanel, cachePanel, eastPanel, mainMemoryPanel, southPanel;
    public JLabel titleLabel;
    public JScrollPane cacheScroll, mainMemoryScroll;
    public JButton nextButton, skipButton;
    public Main model;

    public MainFrame(Main model) {
        super("Main");
        super.setSize(600, 800);
        super.setResizable(false);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);

        this.model = model;

        initializeNorth();
        initializeWest();
        initializeEast();
        initializeSouth();

        super.setVisible(true);
    }

    public void initializeNorth()
    {
        northPanel = new JPanel(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setText("Full Associative + Random Replacement Algorithm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        northPanel.add(titleLabel, BorderLayout.CENTER);

        this.add(northPanel, BorderLayout.NORTH);
    }

    public void initializeWest()
    {
        westPanel = new JPanel(new BorderLayout());

        cachePanel = new JPanel();
        cachePanel.setLayout(new BoxLayout(cachePanel, BoxLayout.Y_AXIS));
        cacheScroll = new JScrollPane(cachePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cacheScroll.getVerticalScrollBar().setUnitIncrement(16);

        cacheBlocks = new JLabel[model.cache.nBlock];

        for (int i = 0; i < model.cache.nBlock; i++)
        {
            cacheBlocks[i] = new JLabel();
            cacheBlocks[i].setText(">Empty<");
            cacheBlocks[i].setOpaque(true);
            cacheBlocks[i].setFont(new Font("Arial", Font.BOLD, 16));
            cachePanel.add(cacheBlocks[i]);
        }

        westPanel.add(cacheScroll, BorderLayout.CENTER);

        this.add(westPanel, BorderLayout.WEST);
    }

    public void initializeEast()
    {
        eastPanel = new JPanel(new BorderLayout());

        mainMemoryPanel = new JPanel();
        mainMemoryPanel.setLayout(new BoxLayout(mainMemoryPanel, BoxLayout.Y_AXIS));
        mainMemoryScroll = new JScrollPane(mainMemoryPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainMemoryScroll.getVerticalScrollBar().setUnitIncrement(16);

        mainMemory = new JLabel[model.mainMemory.nArray.length];
        for (int i = 0; i < model.mainMemory.nArray.length; i++)
        {
            mainMemory[i] = new JLabel();
            mainMemory[i].setText(String.valueOf(model.mainMemory.nArray[i].nNum));
            mainMemory[i].setOpaque(true);
            mainMemory[i].setFont(new Font("Arial", Font.BOLD, 16));
            mainMemoryPanel.add(mainMemory[i]);
        }

        eastPanel.add(mainMemoryScroll, BorderLayout.CENTER);

        this.add(eastPanel, BorderLayout.EAST);
    }

    public void initializeSouth()
    {
        southPanel = new JPanel(new BorderLayout());

        nextButton = new JButton();
        nextButton.setText("Next");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replaceCache();

                if(model.mainMemory.nCurr == model.mainMemory.nArray.length - 1)
                {
                    nextButton.setEnabled(false);
                    skipButton.setEnabled(false);
                }
            }
        });

        skipButton = new JButton();
        skipButton.setText("Skip");

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (model.mainMemory.nCurr < model.mainMemory.nArray.length)
                    replaceCache();

                nextButton.setEnabled(false);
                skipButton.setEnabled(false);
            }
        });


        southPanel.add(nextButton, BorderLayout.WEST);
        southPanel.add(nextButton, BorderLayout.EAST);

        this.add(southPanel,BorderLayout.SOUTH);
    }

    public void replaceCache()
    {
        int num = model.replaceCache();
        cacheBlocks[num].setText(String.valueOf(model.cache.nArray[num]));
        for (int i = 0; i < cacheBlocks.length; i++)
            cacheBlocks[i].setBackground(Color.WHITE);
        cacheBlocks[num].setBackground(Color.YELLOW);

        cacheScroll.getViewport().setViewPosition(cacheBlocks[num].getLocation());

        num = model.mainMemory.nCurr;
        mainMemory[num].setBackground(Color.YELLOW);
        if (model.mainMemory.nArray[num - 1].cHit.equals("Hit"))
            mainMemory[num - 1].setBackground(Color.GREEN);
        else if (model.mainMemory.nArray[num - 1].cHit.equals("Miss"))
            mainMemory[num - 1].setBackground(Color.RED);

        mainMemoryScroll.getViewport().setViewPosition(mainMemory[num].getLocation());

        this.revalidate();
        this.repaint();
    }
}