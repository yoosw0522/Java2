package ai1103;

// 과제1 - 메뉴 항목 및 기능 업데이트
// 학번: 2601110293 / 이름: 유성원

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class MenuTest2 extends JFrame {
    private final Color ink = new Color(35, 43, 61);
    private final Color muted = new Color(119, 130, 149);
    private final Color accent = new Color(65, 99, 235);
    private final Color background = new Color(244, 246, 250);

    private final JTextArea textArea = new JTextArea();
    private final JFileChooser fileChooser = new JFileChooser();
    private final JLabel fileLabel = new JLabel("새로운 메모");
    private final JLabel countLabel = new JLabel("0자  ·  1줄");
    private final JLabel statusLabel = new JLabel("작성 준비 완료");

    private File currentFile;

    public MenuTest2() {
        setTitle("메모장");
        setSize(860, 640);
        setMinimumSize(new Dimension(700, 480));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorder(BorderFactory.createEmptyBorder(6, 18, 6, 18));
        setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        addMenuItem(fileMenu, "New", KeyEvent.VK_N);
        addMenuItem(fileMenu, "Open", KeyEvent.VK_O);
        addMenuItem(fileMenu, "Save", KeyEvent.VK_S);
        addMenuItem(fileMenu, "Save as temporary", 0);
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "Close", 0);

        addMenuItem(editMenu, "White", 0);
        addMenuItem(editMenu, "Blue", 0);
        addMenuItem(editMenu, "Magenta", 0);

        JPanel root = new JPanel(new BorderLayout(0, 20));
        root.setBackground(background);
        root.setBorder(BorderFactory.createEmptyBorder(28, 30, 18, 30));
        setContentPane(root);

        // 제목과 파일명
        JPanel header = new JPanel(new BorderLayout(20, 0));
        header.setOpaque(false);

        JPanel heading = new JPanel(new GridLayout(2, 1, 0, 5));
        heading.setOpaque(false);

        JLabel title = new JLabel("메모장");
        title.setFont(new Font("맑은 고딕", Font.BOLD, 28));
        title.setForeground(ink);
        fileLabel.setForeground(muted);

        heading.add(title);
        heading.add(fileLabel);
        header.add(heading, BorderLayout.WEST);

        // 상단 버튼
        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 8, 12));
        actions.setOpaque(false);
        actions.add(makeButton("새 메모", "New", false));
        actions.add(makeButton("열기", "Open", false));
        actions.add(makeButton("저장", "Save", true));

        header.add(actions, BorderLayout.EAST);
        root.add(header, BorderLayout.NORTH);

        // 메모 편집 영역
        JPanel paper = new JPanel(new BorderLayout());
        paper.setBackground(Color.WHITE);
        paper.setBorder(
                BorderFactory.createLineBorder(new Color(225, 230, 239))
        );

        JPanel paperHeader = new JPanel(new BorderLayout());
        paperHeader.setBackground(Color.WHITE);
        paperHeader.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, background),
                BorderFactory.createEmptyBorder(12, 22, 12, 22)
        ));

        JLabel noteLabel = new JLabel("NOTE");
        noteLabel.setFont(new Font("SansSerif", Font.BOLD, 11));
        noteLabel.setForeground(accent);

        JLabel hint = new JLabel("자유롭게 작성해 보세요");
        hint.setForeground(muted);
        hint.setFont(new Font("맑은 고딕", Font.PLAIN, 12));

        paperHeader.add(noteLabel, BorderLayout.WEST);
        paperHeader.add(hint, BorderLayout.EAST);
        paper.add(paperHeader, BorderLayout.NORTH);

        textArea.setFont(new Font("맑은 고딕", Font.PLAIN, 17));
        textArea.setForeground(ink);
        textArea.setCaretColor(accent);
        textArea.setSelectionColor(new Color(216, 226, 255));
        textArea.setSelectedTextColor(ink);
        textArea.setMargin(new Insets(22, 24, 22, 24));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setTabSize(4);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(18);
        paper.add(scrollPane, BorderLayout.CENTER);

        // 글자 수와 줄 수
        JPanel paperFooter = new JPanel(new BorderLayout());
        paperFooter.setBackground(Color.WHITE);
        paperFooter.setBorder(
                BorderFactory.createEmptyBorder(10, 22, 14, 22)
        );

        countLabel.setForeground(muted);
        paperFooter.add(countLabel, BorderLayout.WEST);

        JLabel encoding = new JLabel("UTF-8");
        encoding.setForeground(muted);
        paperFooter.add(encoding, BorderLayout.EAST);

        paper.add(paperFooter, BorderLayout.SOUTH);
        root.add(paper, BorderLayout.CENTER);

        // 하단 상태 표시
        JPanel footer = new JPanel(new BorderLayout());
        footer.setOpaque(false);

        statusLabel.setForeground(muted);
        footer.add(statusLabel, BorderLayout.WEST);

        JLabel shortcut = new JLabel("Ctrl + S로 저장");
        shortcut.setForeground(muted);
        footer.add(shortcut, BorderLayout.EAST);

        root.add(footer, BorderLayout.SOUTH);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateCount();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateCount();
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
        textArea.requestFocusInWindow();
    }

    // 모서리가 둥근 버튼
    private JButton makeButton(String text, String command, boolean primary) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                Color fill = primary ? accent : Color.WHITE;

                if (getModel().isPressed()) {
                    fill = fill.darker();
                } else if (getModel().isRollover()) {
                    fill = primary
                            ? new Color(52, 81, 211)
                            : new Color(233, 237, 246);
                }

                g2.setColor(fill);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 14, 14);

                if (hasFocus()) {
                    g2.setColor(primary ? Color.WHITE : accent);
                    g2.drawRoundRect(
                            3, 3, getWidth() - 7, getHeight() - 7, 10, 10
                    );
                }

                g2.dispose();
                super.paintComponent(g);
            }
        };

        button.setUI(new BasicButtonUI());
        button.setContentAreaFilled(false);
        button.setBorder(
                BorderFactory.createEmptyBorder(11, 22, 11, 22)
        );
        button.setForeground(primary ? Color.WHITE : ink);
        button.setFont(new Font("맑은 고딕", Font.BOLD, 13));
        button.setFocusPainted(false);
        button.setRolloverEnabled(true);
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.addActionListener(e -> runCommand(command));

        return button;
    }

    private void addMenuItem(JMenu menu, String name, int key) {
        JMenuItem item = new JMenuItem(name);

        if (key != 0) {
            item.setAccelerator(
                    KeyStroke.getKeyStroke(key, InputEvent.CTRL_DOWN_MASK)
            );
        }

        item.addActionListener(e -> runCommand(name));
        menu.add(item);
    }

    // 메뉴와 버튼에서 같은 기능을 사용한다.
    private void runCommand(String command) {
        switch (command) {
            case "New":
                textArea.setText("");
                currentFile = null;
                updateFileName();
                statusLabel.setText("새 메모를 만들었습니다");
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
                changeColor(Color.WHITE, ink);
                break;

            case "Blue":
                changeColor(
                        new Color(236, 243, 255),
                        new Color(36, 65, 110)
                );
                break;

            case "Magenta":
                changeColor(
                        new Color(253, 237, 251),
                        new Color(100, 42, 91)
                );
                break;
        }

        textArea.requestFocusInWindow();
    }

    private void changeColor(Color bg, Color fg) {
        textArea.setBackground(bg);
        textArea.setForeground(fg);
        textArea.setCaretColor(fg);
    }

    private void updateCount() {
        String text = textArea.getText();

        countLabel.setText(
                text.codePointCount(0, text.length())
                        + "자  ·  " + textArea.getLineCount() + "줄"
        );

        statusLabel.setText("편집 중");
    }

    private void updateFileName() {
        String name = currentFile == null
                ? "새로운 메모"
                : currentFile.getName();

        fileLabel.setText(name);
        fileLabel.setToolTipText(
                currentFile == null ? null : currentFile.getAbsolutePath()
        );
        setTitle(name + " - 메모장");
    }

    private void openFile() {
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File selectedFile = fileChooser.getSelectedFile();

        try {
            String content = readFile(selectedFile);
            textArea.setText(content);
            textArea.setCaretPosition(0);
            statusLabel.setText("파일을 열었습니다");
            currentFile = selectedFile;
            updateFileName();
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

        // 새 문서는 저장 위치를 선택한다.
        if (selectedFile == null) {
            fileChooser.setSelectedFile(new File("memo.txt"));

            if (fileChooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
                return;
            }

            selectedFile = fileChooser.getSelectedFile();

            if (selectedFile.exists()) {
                int answer = JOptionPane.showConfirmDialog(
                        this,
                        "같은 이름의 파일이 있습니다. 덮어쓰시겠습니까?",
                        "저장 확인",
                        JOptionPane.YES_NO_OPTION
                );

                if (answer != JOptionPane.YES_OPTION) {
                    return;
                }
            }
        }

        try {
            writeFile(selectedFile, textArea.getText());
            currentFile = selectedFile;
            updateFileName();
            statusLabel.setText("저장 완료");
        } catch (IOException e) {
            showFileError("파일을 저장할 수 없습니다.", e);
        }
    }

    public void saveDraftFile(String currentString) {
        try {
            writeFile(new File("temp.txt"), currentString);
            statusLabel.setText("temp.txt에 임시 저장 완료");
        } catch (IOException e) {
            showFileError("임시 저장할 수 없습니다.", e);
        }
    }

    private void writeFile(File file, String content) throws IOException {
        Files.write(file.toPath(), content.getBytes(StandardCharsets.UTF_8));
    }

    private void showFileError(String message, IOException e) {
        JOptionPane.showMessageDialog(
                this,
                message + "\n" + e.getMessage(),
                "파일 오류",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Font font = new Font("맑은 고딕", Font.PLAIN, 13);

            for (Object key : UIManager.getDefaults().keySet().toArray()) {
                if (UIManager.get(key) instanceof Font) {
                    UIManager.put(key, font);
                }
            }

            new MenuTest2();
        });
    }
}