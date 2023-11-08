import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame
{
    public JLabel[] cacheBlocks, mainMemory;
    public JPanel northPanel, westPanel, cachePanel, eastPanel, mainMemoryPanel, southPanel, centerPanel;
    public JLabel titleLabel, animatedLabel;
    public JScrollPane cacheScroll, mainMemoryScroll;
    public JButton nextButton, skipButton;
    public int PLAY_TIME = 2000;
    public long startTime;
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

        centerPanel = new JPanel();
        centerPanel.setLayout(null);

        this.add(centerPanel, BorderLayout.CENTER);

        super.setVisible(true);
    }
    //Title in upper screen
    public void initializeNorth()
    {
        northPanel = new JPanel(new BorderLayout());

        titleLabel = new JLabel();
        titleLabel.setText("Full Associative + Random Replacement Algorithm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
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
                // disabled if memory count == size of main memory
                if(model.mainMemory.nCurr == model.mainMemory.nArray.length)
                {
                    nextButton.setEnabled(false);
                    skipButton.setEnabled(false);
                }
            }
        });

        skipButton = new JButton();
        skipButton.setText("Skip");

        // iterates through the entire main memory until finished
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
        southPanel.add(skipButton, BorderLayout.EAST);

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

        int num2 = model.mainMemory.nCurr;
        if (!(num2 == mainMemory.length))
            mainMemory[num2].setBackground(Color.YELLOW);
        if (model.mainMemory.nArray[num2 - 1].cHit.equals("Hit"))
            mainMemory[num2 - 1].setBackground(Color.GREEN);
        else if (model.mainMemory.nArray[num2 - 1].cHit.equals("Miss"))
            mainMemory[num2 - 1].setBackground(Color.RED);

        if (!(num2 == mainMemory.length))
            mainMemoryScroll.getViewport().setViewPosition(mainMemory[num].getLocation());

        if (!(num2 == mainMemory.length))
            animateLabel(mainMemory[num2], cacheBlocks[num]);

        this.revalidate();
        this.repaint();
    }

    //https://stackoverflow.com/questions/16577415/jlabel-move-to-coordinate
    public void animateLabel(JLabel startLabel, JLabel destinationLabel)
    {
        animatedLabel = new JLabel();
        animatedLabel.setText(destinationLabel.getText());
        animatedLabel.setOpaque(true);
        animatedLabel.setFont(new Font("Arial", Font.BOLD, 16));
        animatedLabel.setSize(animatedLabel.getPreferredSize());
        centerPanel.add(animatedLabel);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animatedLabel.repaint();
                animatedLabel.revalidate();
                double x1 = startLabel.getLocationOnScreen().getX(), y1 = startLabel.getLocationOnScreen().getY();
                double x2 = destinationLabel.getLocationOnScreen().getX(), y2 = destinationLabel.getLocationOnScreen().getY();

                long duration = System.currentTimeMillis() - startTime;
                float progress = (float)duration / (float)PLAY_TIME;
                if (progress > 1f) {
                    progress = 1f;
                    centerPanel.remove(animatedLabel);
                    centerPanel.repaint();
                    centerPanel.revalidate();
                    ((Timer)(e.getSource())).stop();
                }

                double x = x1 + (int)Math.round((x2 - x1) * progress);
                double y = y1 + (int)Math.round((y2 - y1) * progress);

                x -= centerPanel.getLocation().getX();
                y -= centerPanel.getLocation().getY();

                animatedLabel.setLocation((int) x, (int) y);
            }
        });
        startTime = System.currentTimeMillis();
        timer.start();
    }
}