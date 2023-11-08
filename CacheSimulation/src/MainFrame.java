import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame
{
    // Arrays of JLabels to represent the blocks in the cache and main memory
    public JLabel[] cacheBlocks, mainMemory;
    // JPanels used
    public JPanel northPanel, westPanel, cachePanel, eastPanel, mainMemoryPanel, southPanel, centerPanel;
    // JLabels used
    public JLabel titleLabel, animatedLabel;
    // JScrollPane for scrolling feature
    public JScrollPane cacheScroll, mainMemoryScroll;
    // JButtons for manipulating the steps
    public JButton nextButton, skipButton;
    // Amount of milliseconds in the animation
    public int PLAY_TIME = 1000;
    // Time for animation
    public long startTime;
    // The model to be used for storing data and using functions
    public Main model;

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

        this.add(centerPanel, BorderLayout.CENTER);

        // Set the JFrame to be visible
        super.setVisible(true);
    }

    // Initialize the north panel
    public void initializeNorth()
    {
        northPanel = new JPanel(new BorderLayout());

        // Placing the type of algorithms used for the title
        titleLabel = new JLabel();
        titleLabel.setText("Full Associative + Random Replacement Algorithm");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        northPanel.add(titleLabel, BorderLayout.CENTER);

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

        // Initializing the JLabels signifying the cache blocks
        cacheBlocks = new JLabel[model.cache.nBlock];
        for (int i = 0; i < model.cache.nBlock; i++)
        {
            // Initially set the JLabels to empty
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

    // Initialize the east panel
    public void initializeEast()
    {
        eastPanel = new JPanel(new BorderLayout());

        // Adding the panel for visualizing the numbers to be moved from the main memory with a scroll pane
        mainMemoryPanel = new JPanel();
        mainMemoryPanel.setLayout(new BoxLayout(mainMemoryPanel, BoxLayout.Y_AXIS));
        mainMemoryScroll = new JScrollPane(mainMemoryPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainMemoryScroll.getVerticalScrollBar().setUnitIncrement(16);

        // Initializing the JLabels to signify the blocks to be transferred in the main memory
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

    // Initialize the south panel
    public void initializeSouth()
    {
        southPanel = new JPanel(new BorderLayout());

        // Add a next button
        nextButton = new JButton();
        nextButton.setText("Next");

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the replace cache function
                replaceCache(false);

                // Disable both buttons if it is the last block already
                if(model.mainMemory.nCurr == model.mainMemory.nArray.length)
                {
                    nextButton.setEnabled(false);
                    skipButton.setEnabled(false);
                }
            }
        });

        // Add a skip button
        skipButton = new JButton();
        skipButton.setText("Skip");

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Replace the cache until there is no more blocks to be transferred in the main memory
                while (model.mainMemory.nCurr < model.mainMemory.nArray.length)
                    replaceCache(true);

                // Disable both buttons since there is no more blocks to be transferred
                nextButton.setEnabled(false);
                skipButton.setEnabled(false);
            }
        });

        southPanel.add(nextButton, BorderLayout.WEST);
        southPanel.add(skipButton, BorderLayout.EAST);

        this.add(southPanel,BorderLayout.SOUTH);
    }

    // Function that transfers the blocks from main memory
    public void replaceCache(boolean isSkip)
    {
        // Get the position in the cache to be replaced
        int num = model.replaceCache();
        // Replace the number inside the JLabel inside the cache
        cacheBlocks[num].setText(String.valueOf(model.cache.nArray[num]));
        // Change all the background of the blocks
        for (int i = 0; i < cacheBlocks.length; i++)
            cacheBlocks[i].setBackground(Color.WHITE);
        // Highlight the block from the main memory moved or found in the cache
        cacheBlocks[num].setBackground(Color.YELLOW);

        // Change the current scroll position to the latest cache block
        cacheScroll.getViewport().setViewPosition(cacheBlocks[num].getLocation());

        // Get the current block to be moved into the cache
        int num2 = model.mainMemory.nCurr;
        // If it is not beyond the last main memory then highlight it yellow
        if (!(num2 == mainMemory.length))
            mainMemory[num2].setBackground(Color.YELLOW);
        // If the last one is a hit then highlight it green
        if (model.mainMemory.nArray[num2 - 1].cHit.equals("Hit"))
            mainMemory[num2 - 1].setBackground(Color.GREEN);
        // If the last one is a miss then highlight it red
        else if (model.mainMemory.nArray[num2 - 1].cHit.equals("Miss"))
            mainMemory[num2 - 1].setBackground(Color.RED);

        // If it is not yet at the end then change the current scroll position to the latest main memory block
        if (!(num2 == mainMemory.length))
            mainMemoryScroll.getViewport().setViewPosition(mainMemory[num].getLocation());

        // If the skip button is not pressed and it isn't at the last main memory block
        if (!(num2 == mainMemory.length) && !(isSkip))
        {
            // Temporarily disable the buttons and animate
            skipButton.setEnabled(false);
            nextButton.setEnabled(false);
            animateLabel(mainMemory[num2], cacheBlocks[num]);
        }

        // Refresh the view
        this.revalidate();
        this.repaint();
    }

    // Reference to base the animation on
    //https://stackoverflow.com/questions/16577415/jlabel-move-to-coordinate
    public void animateLabel(JLabel startLabel, JLabel destinationLabel)
    {
        // Create the animated label
        animatedLabel = new JLabel();
        animatedLabel.setText(destinationLabel.getText());
        animatedLabel.setOpaque(true);
        animatedLabel.setBackground(Color.CYAN);
        animatedLabel.setFont(new Font("Arial", Font.BOLD, 16));
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

                // Get the time and progress
                long duration = System.currentTimeMillis() - startTime;
                float progress = (float) duration / (float) PLAY_TIME;

                // Check if the progress is complete
                if (progress > 1f) {
                    progress = 1f;

                    // Re-enable the buttons
                    skipButton.setEnabled(true);
                    nextButton.setEnabled(true);

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

                // Remove the position of the center panel
                x -= centerPanel.getLocationOnScreen().getX();
                y -= centerPanel.getLocationOnScreen().getY();

                // Set the location
                animatedLabel.setLocation((int) x, (int) y);
            }
        });
        // Start the timer loop
        startTime = System.currentTimeMillis();
        timer.start();
    }
}
