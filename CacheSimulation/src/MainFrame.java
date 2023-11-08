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
    public int PLAY_TIME = 1000;
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
            cacheBlocks[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
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
            mainMemory[i].setAlignmentX(JLabel.CENTER_ALIGNMENT);
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
                replaceCache(false);

                if(model.mainMemory.nCurr == model.mainMemory.nArray.length)
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
                    replaceCache(true);

                nextButton.setEnabled(false);
                skipButton.setEnabled(false);
            }
        });

        southPanel.add(nextButton, BorderLayout.WEST);
        southPanel.add(skipButton, BorderLayout.EAST);

        this.add(southPanel,BorderLayout.SOUTH);
    }

    public void replaceCache(boolean isSkip)
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

        if (!(num2 == mainMemory.length) && !(isSkip))
        {
            skipButton.setEnabled(false);
            nextButton.setEnabled(false);
            animateLabel(mainMemory[num2], cacheBlocks[num]);
        }


        this.revalidate();
        this.repaint();
    }

    //https://stackoverflow.com/questions/16577415/jlabel-move-to-coordinate
    public void animateLabel(JLabel startLabel, JLabel destinationLabel)
    {
        animatedLabel = new JLabel();
        animatedLabel.setText(destinationLabel.getText());
        animatedLabel.setOpaque(true);
        animatedLabel.setBackground(Color.CYAN);
        animatedLabel.setFont(new Font("Arial", Font.BOLD, 16));
        animatedLabel.setSize(animatedLabel.getPreferredSize());
        animatedLabel.setVisible(false);
        centerPanel.add(animatedLabel);

        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animatedLabel.setVisible(true);
                animatedLabel.repaint();
                animatedLabel.revalidate();

                double x1 = startLabel.getLocationOnScreen().getX(), y1 = startLabel.getLocationOnScreen().getY();
                double x2 = destinationLabel.getLocationOnScreen().getX(), y2 = destinationLabel.getLocationOnScreen().getY();

                long duration = System.currentTimeMillis() - startTime;
                float progress = (float) duration / (float) PLAY_TIME;
                if (progress > 1f) {
                    progress = 1f;

                    skipButton.setEnabled(true);
                    nextButton.setEnabled(true);

                    centerPanel.remove(animatedLabel);
                    centerPanel.repaint();
                    centerPanel.revalidate();
                    ((Timer)(e.getSource())).stop();
                }

                double x = x1 + (int) Math.round((x2 - x1) * progress);
                double y = y1 + (int) Math.round((y2 - y1) * progress);

                x -= centerPanel.getLocationOnScreen().getX();
                y -= centerPanel.getLocationOnScreen().getY();

                animatedLabel.setLocation((int) x, (int) y);
            }
        });
        startTime = System.currentTimeMillis();
        timer.start();
    }
}
