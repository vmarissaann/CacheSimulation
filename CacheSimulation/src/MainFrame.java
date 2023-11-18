import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;

class MainFrame extends JFrame {
    // Arrays of JLabels to represent the blocks in the cache and main memory
    public BlockLabel[] cacheBlocks, mainMemory;
    // JPanels used
    public JPanel compContainer, titleContainer, northPanel, westPanel, cachePanel, eastPanel, mainMemoryPanel, southPanel, centerPanel;
    // JLabels used
    public JLabel endLabel, titleLabel, algorithmLabel, testLabel, cacheLabel, memoryLabel;
    // BlockLabel for aanimattion
    public BlockLabel animatedLabel;
    // JScrollPane for scrolling feature
    public JScrollPane cacheScroll, mainMemoryScroll;
    // JButtons for manipulating the steps
    public JButton playButton, skipButton, speedUpButton;
    // Amount of milliseconds in the animation
    public int PLAY_TIME = 1000;
    // Time for animation
    public long startTime;
    //dropdown
    public JComboBox comboBox;
    // submit button
    public JButton submit;
    //input for main memory
    public TextField textMainMemory;
    // cache block sequence
    public ArrayList<Integer> sequence;
    // The model to be used for storing data and using functions
    public Main model;
    public MainMemory memory;

    // Constructor
    public MainFrame(Main model) {
        // Placing usual settings for the JFrame
        super("Main");
        super.setSize(600, 800);
        super.setResizable(false);
        super.setLayout(new BorderLayout());
        super.setDefaultCloseOperation(super.EXIT_ON_CLOSE);

        // Initialize the model
        this.model = model;

        // Initialize all the needed things
        initializeNorth();
        initializeWest();
        initializeEast();
        initializeSouth();

        // Placing a null panel for viewing the JLabel moving around
        centerPanel = new JPanel();
        centerPanel.setLayout(null);
        centerPanel.setBackground(Color.white);

        this.add(centerPanel, BorderLayout.CENTER);

        // Set the JFrame to be visible
        super.setVisible(true);
    }

    public void editFont(JLabel labelName, int size) {
        try {
            InputStream is = MainFrame.class.getResourceAsStream("ArchitypeAubettte.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            labelName.setFont(font.deriveFont(Font.PLAIN, size));
        } catch (Exception e) {
        }
    }

    // Initialize the north panel
    public void initializeNorth() {
        northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

        // Container for title and algorithm labels
        titleContainer = new JPanel();
        titleContainer.setLayout(new BoxLayout(titleContainer, BoxLayout.Y_AXIS));
        titleContainer.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        titleContainer.setBackground(Color.white);

        // Cache simulator title
        titleLabel = new JLabel();
        titleLabel.setText("CACHE SIMULATOR");
        titleLabel.setForeground(Color.decode("#24231D"));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        editFont(titleLabel, 22);

        // Type of algorithms title
        algorithmLabel = new JLabel();
        algorithmLabel.setText("FULL ASSOCIATIVE RANDOM REPLACEMENT");
        algorithmLabel.setForeground(Color.decode("#C6624F"));
        algorithmLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        editFont(algorithmLabel, 18);

        // Type of test case
        testLabel = new JLabel();
        switch (model.testCase()) {
            case 0:
            testLabel.setText("SEQUENTIAL SEQUENCE");
            break;
            case 1:
            testLabel.setText("RANDOM SEQUENCE");
            break;
            case 2:
            testLabel.setText("MID-REPEAT BLOCKS");
            break;
        }
        testLabel.setForeground(Color.decode("#24231D"));
        testLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        editFont(testLabel, 16);

        // Container for cache and memory label
        compContainer = new JPanel();
        compContainer.setLayout(new BorderLayout());
        compContainer.setBackground(Color.white);
        Border emptyBorderLR = BorderFactory.createEmptyBorder(0, 30, 0, 40);
        Border matteBorderTB = BorderFactory.createMatteBorder(2, 0, 2, 0, Color.decode("#24231D"));
        compContainer.setBorder(BorderFactory.createCompoundBorder(matteBorderTB, emptyBorderLR));

        // Cache title
        cacheLabel = new JLabel();
        cacheLabel.setText("CACHE");
        cacheLabel.setForeground(Color.decode("#24231D"));
        editFont(cacheLabel, 14);

        // Memory title
        memoryLabel = new JLabel();
        memoryLabel.setText("MEMORY");
        memoryLabel.setForeground(Color.decode("#24231D"));
        editFont(memoryLabel, 14);

        // Add labels to the containers
        titleContainer.add(titleLabel);
        titleContainer.add(algorithmLabel);
        titleContainer.add(testLabel);
        compContainer.add(cacheLabel, BorderLayout.WEST);
        compContainer.add(Box.createHorizontalGlue());
        compContainer.add(memoryLabel, BorderLayout.EAST);

        // Add the containers to the NORTH region of northPanel
        northPanel.add(titleContainer);
        northPanel.add(compContainer);

        // Set the maximum width of titleContainer to be the same as its parent container
        titleContainer.setMaximumSize(new Dimension(Integer.MAX_VALUE, titleContainer.getPreferredSize().height));
        northPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, northPanel.getPreferredSize().height));

        this.add(northPanel, BorderLayout.NORTH);
    }
    
    
    // Initialize the west panel
    public void initializeWest()
    {
        westPanel = new JPanel(new BorderLayout());

        // Adding the panel for visualizing the cache with a scroll pane
        cachePanel = new JPanel();
        cachePanel.setLayout(new BoxLayout(cachePanel, BoxLayout.Y_AXIS));
        cacheScroll = new JScrollPane(cachePanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        cacheScroll.getVerticalScrollBar().setUnitIncrement(16);
        cacheScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Initializing the JLabels signifying the cache blocks
        cacheBlocks = new BlockLabel[model.cache.nBlock];
        for (int i = 0; i < model.cache.nBlock; i++)
        {
            // Initially set the JLabels to empty
            cacheBlocks[i] = new BlockLabel(null);
            cachePanel.add(cacheBlocks[i]);
        }

        westPanel.add(cacheScroll, BorderLayout.CENTER);

        this.add(westPanel, BorderLayout.WEST);
    }

    // Initialize the east panel
    public void initializeEast()
    {
        eastPanel = new JPanel(new BorderLayout());

        // Adding the panel for visualizing the numbers to be moved from the main memory with a scroll pane
        mainMemoryPanel = new JPanel();
        mainMemoryPanel.setLayout(new BoxLayout(mainMemoryPanel, BoxLayout.Y_AXIS));
        mainMemoryScroll = new JScrollPane(mainMemoryPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainMemoryScroll.getVerticalScrollBar().setUnitIncrement(16);
        mainMemoryScroll.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        // Initializing the JLabels to signify the blocks to be transferred in the main memory
        mainMemory = new BlockLabel[model.mainMemory.nArray.length];
        for (int i = 0; i < model.mainMemory.nArray.length; i++)
        {
            mainMemory[i] = new BlockLabel(model.mainMemory.nArray[i].nNum);
            mainMemoryPanel.add(mainMemory[i]);
        }

        eastPanel.add(mainMemoryScroll, BorderLayout.CENTER);

        this.add(eastPanel, BorderLayout.EAST);
    }

    // Initialize the south panel
    public void initializeSouth()
    {
        southPanel = new JPanel(new FlowLayout());
        southPanel.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));

        // Add a play button
        playButton = new JButton();
        playButton.setText("▶");

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Disable play button
                playButton.setEnabled(false);

                Timer timer = new Timer(PLAY_TIME + 150, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        // Call the replace cache function
                        try
                        {
                            replaceCache(false);
                        } catch (Exception exception)
                        {
                            skipButton.setEnabled(false);
                            ((Timer)(e.getSource())).stop();
                        }

                        // Disable both buttons if it is the last block already
                        if(model.mainMemory.nCurr == model.mainMemory.nArray.length)
                        {
                            skipButton.setEnabled(false);

                            model.outputTextFile();
                            displayOutput();
                            ((Timer)(e.getSource())).stop();
                        }
                    }
                });
                startTime = System.currentTimeMillis();
                timer.start();
            }
        });

        // Add a skip button
        skipButton = new JButton();
        skipButton.setText("▶▶|");

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace the cache until there is no more blocks to be transferred in the main memory
                while (model.mainMemory.nCurr < model.mainMemory.nArray.length)
                    replaceCache(true);

                // Disable both buttons since there is no more blocks to be transferred
                playButton.setEnabled(false);
                skipButton.setEnabled(false);
                speedUpButton.setEnabled(false);

                model.outputTextFile();
                displayOutput();
            }
        });

        speedUpButton = new JButton();
        speedUpButton.setText("▶▶");

        speedUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PLAY_TIME -= 400;
                if (PLAY_TIME == 250)
                    speedUpButton.setEnabled(false);
            }
        });

        southPanel.add(playButton);
        southPanel.add(speedUpButton);
        southPanel.add(skipButton);

        this.add(southPanel,BorderLayout.SOUTH);
    }

    public void resultLabel(JPanel panel, String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.decode("#24231D"));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(new EmptyBorder(0, 0, 5, 0));
        panel.add(label);
    }

    public void resultAnswer(JPanel panel, String text) {
        JLabel label = new JLabel();
        label.setText(text);
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.decode("#24231D"));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setBorder(new EmptyBorder(0, 0, 10, 0));
        panel.add(label);
    }

    public void displayOutput()
    {
        int memoryAccessCount = model.memoryAccessCount();
        int missCount = model.missCnt();
        int hitCount = model.hitCnt();
        double avgAccessTime = model.averageAccessTime();
        double totalAccessTime = model.totalAccessTime();
        
        // Set center panel so it is not null
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));

        // Display title
        endLabel = new JLabel();
        endLabel.setText("RESULTS");
        endLabel.setForeground(Color.decode("#24231D"));
        endLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        endLabel.setBorder(new EmptyBorder(45, 0, 15, 0));
        editFont(endLabel, 32);

        // Add labels into panel
        centerPanel.add(endLabel);

        // Display results
        resultLabel(centerPanel, "Memory Access Count");
        resultAnswer(centerPanel, "" + memoryAccessCount);
        resultLabel(centerPanel, "Cache Hit Count");
        resultAnswer(centerPanel, "" + hitCount);
        resultLabel(centerPanel, "Cache Miss Count");
        resultAnswer(centerPanel, "" + missCount);
        resultLabel(centerPanel, "Cache Hit Rate");
        resultAnswer(centerPanel,  hitCount + "/" + memoryAccessCount);
        resultLabel(centerPanel, "Cache Miss Rate");
        resultAnswer(centerPanel, missCount + "/" + memoryAccessCount);
        resultLabel(centerPanel, "Average Memory Access Time");
        resultAnswer(centerPanel, avgAccessTime + "ns");
        resultLabel(centerPanel, "Total Memory Access Time");
        resultAnswer(centerPanel, totalAccessTime + "ns");

        MainFrame.this.revalidate();
        MainFrame.this.repaint();
    }

    // Function that transfers the blocks from main memory
    public void replaceCache(boolean isSkip)
    {
        // Get the position in the cache to be replaced
        int num = model.replaceCache();

        // Get the current block to be moved into the cache
        int num2 = model.mainMemory.nCurr;

        // Change the current scroll position to the second to the latest cache block
        if (num >= model.cache.nBlock / 2)
            cacheScroll.getViewport().setViewPosition(cacheBlocks[num - model.cache.nBlock / 2].getLocation());
        else
            cacheScroll.getViewport().setViewPosition(cacheBlocks[0].getLocation());

        // If it is not yet at the end then change the current scroll position to the latest main memory block
        if (!(num2 == mainMemory.length) && num2 != 1)
            mainMemoryScroll.getViewport().setViewPosition(mainMemory[num2 - 1].getLocation());

        // Change all the background of the blocks
        for (int i = 0; i < cacheBlocks.length; i++)
        {
            cacheBlocks[i].hexColor = "#EFE9F4";
            cacheBlocks[i].update();
        }

        // Highlight the block from the main memory moved or found in the cache
        cacheBlocks[num].hexColor = "#FFE68F";
        cacheBlocks[num].update();

        // If it is not beyond the last main memory then highlight it yellow
        if (!(num2 == mainMemory.length))
            mainMemory[num2].hexColor = "#FFE68F";
        // If the last one is a hit then highlight it green
        if (model.mainMemory.nArray[num2 - 1].cHit.equals("Hit"))
            mainMemory[num2 - 1].hexColor = "#3CA064";
        // If the last one is a miss then highlight it red
        else if (model.mainMemory.nArray[num2 - 1].cHit.equals("Miss"))
            mainMemory[num2 - 1].hexColor = "#C6624F";

        if (num2 != model.mainMemory.nArray.length)
            mainMemory[num2].update();
        mainMemory[num2 - 1].update();

        // Replace the number inside the JLabel inside the cache
        cacheBlocks[num].number = model.cache.nArray[num];
        //System.out.println(cacheBlocks[num].number);
        if(num2 == mainMemory.length){
            cacheBlocks[num].update();
        }

        // If the skip button is not pressed and it isn't at the last main memory block
        if (!(num2 == mainMemory.length) && !(isSkip))
        {
            // Temporarily disable the buttons and animate
            playButton.setEnabled(false);
            animateLabel(mainMemory[num2 - 1], cacheBlocks[num]);
        }

        // Refresh the view
        this.revalidate();
        this.repaint();
    }

    // Reference to base the animation on
    //https://stackoverflow.com/questions/16577415/jlabel-move-to-coordinate
    public void animateLabel(BlockLabel startLabel, BlockLabel destinationLabel)
    {
        // Create the animated label
        animatedLabel = new BlockLabel(destinationLabel.number);
        animatedLabel.hexColor = "#1FA1D1";
        animatedLabel.update();
        animatedLabel.setSize(animatedLabel.getPreferredSize());

        // Add the animated label and have it be invisible for now
        animatedLabel.setVisible(false);
        centerPanel.add(animatedLabel);

        // Use the timer to repeatedly change the postition with a delay
        Timer timer = new Timer(50, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Change it to be visible and refresh its view
                animatedLabel.setVisible(true);
                animatedLabel.repaint();
                animatedLabel.revalidate();

                // Get the position of the JLabel of the starting position and destination position
                double x1 = startLabel.getLocationOnScreen().getX(), y1 = startLabel.getLocationOnScreen().getY();
                double x2 = destinationLabel.getLocationOnScreen().getX(), y2 = destinationLabel.getLocationOnScreen().getY();

                double offsetX = centerPanel.getLocationOnScreen().getX();
                double offsetY = centerPanel.getLocationOnScreen().getY();

                // Get the time and progress
                long duration = System.currentTimeMillis() - startTime;
                float progress = (float) duration / (float) PLAY_TIME;

                // Check if the progress is complete
                if (progress > 1f) {
                    progress = 1f;

                    // Re-enable the buttons
                    skipButton.setEnabled(true);

                    // Remove the animated Label and refresh the view
                    centerPanel.remove(animatedLabel);
                    centerPanel.repaint();
                    centerPanel.revalidate();

                    // Stop the loop
                    ((Timer)(e.getSource())).stop();
                }

                // Get the current position of the animated label by its progress
                double x = x1 + (int) Math.round((x2 - x1) * progress);
                double y = y1 + (int) Math.round((y2 - y1) * progress);

                x -= offsetX;
                y -= offsetY;

                // Set the location
                animatedLabel.setLocation((int) x, (int) y);
            }
        });
        // Start the timer loop
        startTime = System.currentTimeMillis();
        timer.start();
    }
}

class BlockLabel extends JLabel {
    Integer number;
    String hexColor = "#EFE9F4";

    public BlockLabel(Integer number)
    {
        this.number = number;
        super.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        this.update();
    }
    public void update()
    {
        if (this.number == null)
            super.setText("<html><p style=\"text-align: center; font-size: 10px; background-color:" + this.hexColor + "; border: 1px; border-style: solid; border-color: black; width: 85px; margin-top: 2px; margin-left: 2px; padding: 4px 8px;\">&nbsp;</p></html>");
        else
            super.setText("<html><p style=\"text-align: center; font-size: 10px; background-color:" + this.hexColor + "; border: 1px; border-style: solid; border-color: black; width: 85px; margin-top: 2px; margin-left: 2px; padding: 4px 8px;\">"+ this.number +"</p></html>");
    }
}
