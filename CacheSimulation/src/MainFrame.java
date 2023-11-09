import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MainFrame extends JFrame
{
    // Arrays of JLabels to represent the blocks in the cache and main memory
    public BlockLabel[] cacheBlocks, mainMemory;
    // JPanels used
    public JPanel northPanel, westPanel, cachePanel, eastPanel, mainMemoryPanel, southPanel, centerPanel;
    // JLabels used
    public JLabel titleLabel;
    public BlockLabel animatedLabel;
    // JScrollPane for scrolling feature
    public JScrollPane cacheScroll, mainMemoryScroll;
    // JButtons for manipulating the steps
    public JButton playButton, skipButton, speedUpButton;
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
            }
        });

        speedUpButton = new JButton();
        speedUpButton.setText("▶▶");

        speedUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PLAY_TIME -= 250;
                if (PLAY_TIME == 250)
                    speedUpButton.setEnabled(false);
            }
        });

        southPanel.add(playButton);
        southPanel.add(speedUpButton);
        southPanel.add(skipButton);

        this.add(southPanel,BorderLayout.SOUTH);
    }

    // Function that transfers the blocks from main memory
    public void replaceCache(boolean isSkip)
    {
        // Get the position in the cache to be replaced
        int num = model.replaceCache();

        // Get the current block to be moved into the cache
        int num2 = model.mainMemory.nCurr;

        // Change the current scroll position to the second to the latest cache block
        if (num > 1)
            if (num % 4 == 0)
                cacheScroll.getViewport().setViewPosition(cacheBlocks[num - 1].getLocation());

        // If it is not yet at the end then change the current scroll position to the latest main memory block
        if (!(num2 == mainMemory.length) && num2 != 1)
            mainMemoryScroll.getViewport().setViewPosition(mainMemory[num2 - 1].getLocation());

        // Change all the background of the blocks
        for (int i = 0; i < cacheBlocks.length; i++)
        {
            cacheBlocks[i].color = "Silver";
            cacheBlocks[i].update();
        }

        // Highlight the block from the main memory moved or found in the cache
        cacheBlocks[num].color = "Yellow";

        cacheBlocks[num].update();

        // If it is not beyond the last main memory then highlight it yellow
        if (!(num2 == mainMemory.length))
            mainMemory[num2].color = "Yellow";
        // If the last one is a hit then highlight it green
        if (model.mainMemory.nArray[num2 - 1].cHit.equals("Hit"))
            mainMemory[num2 - 1].color = "Lime";
        // If the last one is a miss then highlight it red
        else if (model.mainMemory.nArray[num2 - 1].cHit.equals("Miss"))
            mainMemory[num2 - 1].color = "Red";

        if (num2 != model.mainMemory.nArray.length)
            mainMemory[num2].update();
        mainMemory[num2 - 1].update();

        // Replace the number inside the JLabel inside the cache
        cacheBlocks[num].number = model.cache.nArray[num];

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
        animatedLabel.color = "Aqua";
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
    String color = "Silver";

    public BlockLabel(Integer number)
    {
        this.number = number;
        super.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        this.update();
    }
    public void update()
    {
        if (this.number == null)
            super.setText("<html><p style=\"font-size: 12px; font-weight: bold; background-color:" + this.color + "; border: 1px; border-radius: 2px; border-style: solid; border-color: black; padding: 2px 8px; margin: 2px; text-shadow: 1px;\">Empty</p></html>");
        else
            super.setText("<html><p style=\"font-size: 12px; font-weight: bold; background-color:" + this.color + "; border: 1px; border-radius: 2px; border-style: solid; border-color: black;  padding: 2px 8px; margin: 2px; text-shadow: 1px;\">"+ this.number +"</p></html>");
    }
}
