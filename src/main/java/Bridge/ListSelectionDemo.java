package Bridge;



import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class ListSelectionDemo extends JPanel {
    JList list;
    ListSelectionModel listSelectionModel;
    AbstractPhone iPhone = new IPhone();
    AbstractPhone huaweiPhone = new HuaweiPhone();

    void refreshAppView(JScrollPane listPane, String curMode) {
        if (curMode.equals("HUAWEI")) {
            if (huaweiPhone.showAll() == null)
                list = new JList();
            else
                list = new JList(huaweiPhone.showAll());
            listPane.setViewportView(list);
            listPane.revalidate();
        } else if (curMode.equals("IPHONE")) {
            if (iPhone.showAll() == null)
                list = new JList();
            else
                list = new JList(iPhone.showAll());
            listPane.setViewportView(
                    list);
            listPane.revalidate();
        }
    }

    public ListSelectionDemo() {
        super(new BorderLayout());

        String[] listData = {"现在没有应用"};
        list = new JList(listData);

        listSelectionModel = list.getSelectionModel();
        listSelectionModel.addListSelectionListener(
                new SharedListSelectionHandler());
        JScrollPane listPane = new JScrollPane(list);
        JPanel controlPane = new JPanel();
        String[] modes = {"HUAWEI",
                "IPHONE"};

        final JComboBox comboBox = new JComboBox(modes);

        comboBox.setSelectedIndex(0);
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String curMode = (String) comboBox.getSelectedItem();
                refreshAppView(listPane, curMode);

            }
        });
        controlPane.add(new JLabel("Selection mode:"));
        controlPane.add(comboBox);

        //Build output area.
//        output = new JTextArea(1, 10);
//        output.setEditable(false);
        JPanel inputPanel = new JPanel(new BorderLayout());
        TextField appName = new TextField("这是输入地方");
        Button appSubmit = new Button("提交");
        inputPanel.add(appName, BorderLayout.WEST);
        inputPanel.add(appSubmit, BorderLayout.EAST);
        appSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String appN = appName.getText();
                String curPhone = (String) comboBox.getSelectedItem();
                if ("应用商城".equals(appN)) {
                    System.out.println("安装应用商城");
                    if ("HUAWEI".equals(curPhone)) {
                        huaweiPhone.install(new ConcreteAppA());
                    } else
                        iPhone.install(new ConcreteAppA());
                    refreshAppView(listPane, curPhone);
                } else if ("OCR扫描王".equals(appN)) {
                    System.out.println("安装OCR扫描王");
                    if ("HUAWEI".equals(curPhone)) {
                        huaweiPhone.install(new ConcreteAppB());
                    } else
                        iPhone.install(new ConcreteAppB());
                    refreshAppView(listPane, curPhone);
                } else {
                    System.out.println("应用不存在");
                }
            }
        });
        JPanel outputPane = new JPanel();
        outputPane.add(inputPanel);
        //Do the layout.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        add(splitPane, BorderLayout.CENTER);

        JPanel topHalf = new JPanel();
        topHalf.setLayout(new BoxLayout(topHalf, BoxLayout.LINE_AXIS));
        JPanel listContainer = new JPanel(new GridLayout(1, 1));
        listContainer.setBorder(BorderFactory.createTitledBorder(
                "List"));
        listContainer.add(listPane);

        topHalf.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));
        topHalf.add(listContainer);
        //topHalf.add(tableContainer);

        topHalf.setMinimumSize(new Dimension(100, 50));
        topHalf.setPreferredSize(new Dimension(100, 110));
        splitPane.add(topHalf);

        JPanel bottomHalf = new JPanel(new BorderLayout());
        bottomHalf.add(controlPane, BorderLayout.PAGE_START);
        bottomHalf.add(outputPane, BorderLayout.CENTER);
        //XXX: next line needed if bottomHalf is ListSelectionDemo scroll pane:
        //bottomHalf.setMinimumSize(new Dimension(400, 50));
        bottomHalf.setPreferredSize(new Dimension(450, 135));
        splitPane.add(bottomHalf);
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("ListSelectionDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        ListSelectionDemo demo = new ListSelectionDemo();
        demo.setOpaque(true);
        frame.setContentPane(demo);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule ListSelectionDemo job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            //System.out.printf("LeadSelectionIndex is %s%n",lsm.getLeadSelectionIndex());
//            output.append("LeadSelectionIndex is " + lsm.getLeadSelectionIndex() + "\n");

            int firstIndex = e.getFirstIndex();
            int lastIndex = e.getLastIndex();
            boolean isAdjusting = e.getValueIsAdjusting();
//            output.append("Event for indexes "
//                    + firstIndex + " - " + lastIndex
//                    + "; isAdjusting is " + isAdjusting
//                    + "; selected indexes:");

            if (lsm.isSelectionEmpty()) {
//                output.append(" <none>");
            } else {
                // Find out which indexes are selected.
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
//                        output.append(" " + i);
                    }
                }
            }
//            output.append(newline);
//            output.setCaretPosition(output.getDocument().getLength());
        }
    }
}