package MarkdownEditor;

import javafx.scene.web.WebView;
import org.markdownj.MarkdownProcessor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by desolate on 15/1/26.
 */
public class MarkdownEditor extends JFrame implements KeyListener {
    MarkdownProcessor markdownProcessor;

    JTextArea markdownTextArea;
    JEditorPane previewView;

    JScrollPane textScroll;
    JScrollPane previewScroll;
    public MarkdownEditor (String title){
        super(title);
        setLayout(new GridLayout(1, 2));

        markdownProcessor = new MarkdownProcessor();

        markdownTextArea = new JTextArea();
        markdownTextArea.setBackground(new Color(45, 45, 45));
        markdownTextArea.setForeground(new Color(255, 255, 255));
        markdownTextArea.setCaretColor(new Color(255, 255, 255));
        markdownTextArea.setLineWrap(true);
        markdownTextArea.setDragEnabled(true);
        markdownTextArea.setBorder(new EmptyBorder(new Insets(40, 20, 40, 20)));
        markdownTextArea.setFont(new Font("", Font.PLAIN, 13));
        markdownTextArea.addKeyListener(this);
        markdownTextArea.setText("# Markdown Editor\n\n## Java Application Homework \n\n#### This is a simple markdown editor written by Xinbao Dong. \n\n* sample1\n* sample2\n* sample3");

        textScroll = new JScrollPane(markdownTextArea);

        textScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textScroll.setBorder(null);
        add(textScroll);



        previewView = new JEditorPane();
        previewView.setContentType("text/html");
        previewView.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));
        previewView.setEnabled(false);
        previewView.setText(markdownProcessor.markdown(markdownTextArea.getText()));


        previewScroll = new JScrollPane(previewView);
        previewScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        previewScroll.setBorder(null);
        add(previewScroll);



    }

    @Override
    public void keyReleased(KeyEvent e) {
        previewView.setText(markdownProcessor.markdown(markdownTextArea.getText()));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }
}
