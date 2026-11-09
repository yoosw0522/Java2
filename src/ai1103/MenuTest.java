package ai1103;

import center.SetFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class MenuTest extends JFrame {
    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JFrame frame;
    JButton[] btns = new JButton[7];
    String[] iconFileNames = {"new", "open", "close", "save", "White", "Blue", "Magenta"};
    Color[] colorNames = {Color.WHITE, Color.BLUE, Color.MAGENTA};

    public MenuTest() {
        frame = this;

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);

        JToolBar toolBar = new JToolBar();
        add("North", toolBar);

        for (int i = 0; i < btns.length; i++) {
            btns[i] = new JButton(new ImageIcon("toolbar/" + iconFileNames[i] + ".png"));
            btns[i].addActionListener(btnListener);
            toolBar.add(btns[i]);
        }

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem closeMenuItem = new JMenuItem("Close");
        JMenuItem saveDraftMenuItem = new JMenuItem("Save as temporary");

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(closeMenuItem);
        fileMenu.add(saveDraftMenuItem);

        JMenuItem whiteMenuItem = new JMenuItem("White");
        JMenuItem blueMenuItem = new JMenuItem("Blue");
        JMenuItem magentaMenuItem = new JMenuItem("Magenta");

        editMenu.add(whiteMenuItem);
        editMenu.add(blueMenuItem);
        editMenu.add(magentaMenuItem);

        newMenuItem.addActionListener(fileListener);
        openMenuItem.addActionListener(fileListener);
        closeMenuItem.addActionListener(fileListener);
        saveDraftMenuItem.addActionListener(fileListener);

        whiteMenuItem.addActionListener(backgroundListener);
        blueMenuItem.addActionListener(backgroundListener);
        magentaMenuItem.addActionListener(backgroundListener);

        SetFrame.setFrame(this, "메뉴 만들기", 500, 500);
    }

    ActionListener backgroundListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem eItem = (JMenuItem) e.getSource();

            switch (eItem.getText()) {
                case "White":
                    textArea.setBackground(Color.WHITE);
                    break;
                case "Blue":
                    textArea.setBackground(Color.BLUE);
                    break;
                case "Magenta":
                    textArea.setBackground(Color.MAGENTA);
                    break;
            }

        }
    };

    public String readFile(File selectedFile) {
        String totalLines = "";
        try {
            String line = "";
            FileReader fr = new FileReader(selectedFile);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null) {
                totalLines += line + "\n";
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return totalLines;
    }

    public void saveDraftFile(String currentString) {
        try {
            FileWriter fw = new FileWriter("temp.txt");
            fw.write(currentString);

            fw.close();
            System.out.println("temp.txt에 내용이 저장되었습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    ActionListener fileListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File selectedFile;
            JMenuItem eItem = (JMenuItem) e.getSource();

            switch (eItem.getText()) {
                case "New":
                    textArea.setText(null);
                    break;
                case "Open":
                    fileChooser.showOpenDialog(frame);
                    selectedFile = fileChooser.getSelectedFile();
                    textArea.setText(readFile(selectedFile));
                    break;
                case "Close":
                    System.exit(0);
                    break;
                case "Save as temporary":
                    saveDraftFile(textArea.getText());
                    break;
            }
        }
    };

    ActionListener btnListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            File selectedFile;
            JButton eBtn = (JButton) e.getSource();

            if (eBtn == btns[0]) {
                textArea.setText(null);
            } else if (eBtn == btns[1]) {
                fileChooser.showOpenDialog(frame);
                selectedFile = fileChooser.getSelectedFile();
                textArea.setText(readFile(selectedFile));
            } else if (eBtn == btns[2]) {
                System.exit(0);
            } else if (eBtn == btns[3]) {
                saveDraftFile(textArea.getText());
            }

            for (int i = 0; i < colorNames.length; i++) {
                if (eBtn == btns[i + 4]) {
                    textArea.setBackground(colorNames[i]);
                }
            }
        }
    };

    public static void main(String[] args) {
        new MenuTest();
    }
}