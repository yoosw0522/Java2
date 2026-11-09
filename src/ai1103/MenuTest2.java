package ai1103;

// 과제1 - 메뉴 항목 및 기능 업데이트
// 학번: 2601110293 / 이름: 유성원

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class MenuTest2 extends JFrame {
    JTextArea textArea = new JTextArea();
    JFileChooser fileChooser = new JFileChooser();
    JButton[] btns = new JButton[7];
    String[] iconFileNames = {"new", "open", "close", "save", "White", "Blue", "Magenta"};
    String[] commands = {"New", "Open", "Close", "Save", "White", "Blue", "Magenta"};
    File currentFile = null;

    public MenuTest2() {
        JScrollPane scrollPane = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        JToolBar toolBar = new JToolBar();
        add(toolBar, BorderLayout.NORTH);

        for (int i = 0; i < btns.length; i++) {
            ImageIcon icon = new ImageIcon("toolbar/" + iconFileNames[i] + ".png");

            // 아이콘 파일이 없으면 버튼에 기능 이름을 표시한다.
            if (icon.getIconWidth() > 0) {
                btns[i] = new JButton(icon);
            } else {
                btns[i] = new JButton(commands[i]);
            }

            btns[i].setToolTipText(commands[i]);
            btns[i].setActionCommand(commands[i]);
            btns[i].addActionListener(menuListener);
            toolBar.add(btns[i]);
        }

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        addMenuItem(fileMenu, "New");
        addMenuItem(fileMenu, "Open");
        addMenuItem(fileMenu, "Save"); // 새로 추가한 메뉴
        addMenuItem(fileMenu, "Save as temporary");
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "Close");

        addMenuItem(editMenu, "White");
        addMenuItem(editMenu, "Blue");
        addMenuItem(editMenu, "Magenta");

        setTitle("간단한 메모장");
        setSize(650, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addMenuItem(JMenu menu, String name) {
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.addActionListener(menuListener);
        menu.add(menuItem);
    }

    // 메뉴와 도구 모음에서 같은 기능을 사용한다.
    ActionListener menuListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "New":
                    textArea.setText("");
                    currentFile = null;
                    setTitle("간단한 메모장");
                    break;

                case "Open":
                    openFile();
                    break;

                case "Save":
                    saveFile();
                    break;

                case "Save as temporary":
                    saveDraftFile(textArea.getText());
                    break;

                case "Close":
                    dispose();
                    break;

                case "White":
                    textArea.setBackground(Color.WHITE);
                    textArea.setForeground(Color.BLACK);
                    textArea.setCaretColor(Color.BLACK);
                    break;

                case "Blue":
                    textArea.setBackground(Color.BLUE);
                    textArea.setForeground(Color.WHITE);
                    textArea.setCaretColor(Color.WHITE);
                    break;

                case "Magenta":
                    textArea.setBackground(Color.MAGENTA);
                    textArea.setForeground(Color.BLACK);
                    textArea.setCaretColor(Color.BLACK);
                    break;
            }
        }
    };

    private void openFile() {
        // 취소한 경우에는 파일을 읽지 않는다.
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File selectedFile = fileChooser.getSelectedFile();

        try {
            String content = readFile(selectedFile);
            textArea.setText(content);
            currentFile = selectedFile;
            setTitle("간단한 메모장 - " + currentFile.getName());
        } catch (IOException e) {
            showFileError("파일을 열 수 없습니다.", e);
        }
    }

    public String readFile(File selectedFile) throws IOException {
        byte[] content = Files.readAllBytes(selectedFile.toPath());
        return new String(content, StandardCharsets.UTF_8);
    }

    private void saveFile() {
        File selectedFile = currentFile;

        // 새 문서는 저장 위치를 선택하고, 열었던 문서는 같은 파일에 저장한다.
        if (selectedFile == null) {
            fileChooser.setSelectedFile(new File("memo.txt"));

            if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            selectedFile = fileChooser.getSelectedFile();

            if (selectedFile.exists()) {
                int answer = JOptionPane.showConfirmDialog(this,
                        "같은 이름의 파일이 있습니다. 덮어쓰시겠습니까?",
                        "저장 확인", JOptionPane.YES_NO_OPTION);

                if (answer != JOptionPane.YES_OPTION) {
                    return;
                }
            }
        }

        try {
            writeFile(selectedFile, textArea.getText());
            currentFile = selectedFile;
            setTitle("간단한 메모장 - " + currentFile.getName());
            JOptionPane.showMessageDialog(this, "파일이 저장되었습니다.");
        } catch (IOException e) {
            showFileError("파일을 저장할 수 없습니다.", e);
        }
    }

    public void saveDraftFile(String currentString) {
        try {
            writeFile(new File("temp.txt"), currentString);
            JOptionPane.showMessageDialog(this, "temp.txt에 임시 저장되었습니다.");
        } catch (IOException e) {
            showFileError("임시 저장할 수 없습니다.", e);
        }
    }

    private void writeFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
    }

    private void showFileError(String message, IOException e) {
        JOptionPane.showMessageDialog(this,
                message + "\n" + e.getMessage(),
                "파일 오류", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MenuTest());
    }
}