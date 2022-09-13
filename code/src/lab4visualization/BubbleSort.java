// package INF102.lab4.sorting;
package lab4visualization;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.*;
import java.awt.Graphics;
import javax.swing.JFrame;

// import javax.swing.GrayFilter;
// import javax.swing.JFrame;

public class BubbleSort extends Canvas{
    public static final Color BLACK = Color.BLACK;
    public static final Color WHITE = Color.WHITE;
    public static final Color RED = Color.RED;
    public static final Color BLUE = Color.BLUE;


    public static <T extends Comparable<T>> void sort(List<T> list, Graphics g) {
        int size = list.size();

        // --- outer loop loops through the entire list once
        // --- inner loop loops one iteration less each time, because
        // --- one element is sorted each iteration
        for (int i = 0; i < size; i++) {
            g.drawRect(i * 10, 0, 10, (int) list.get(i));
            // repaint(1000);
        }
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T first = list.get(j);
                T second = list.get(j + 1);

                if (first.compareTo(second) > 0) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    public static <T extends Comparable<T>> void drawList(List<T> list) {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bubble Sort");
        Canvas canvas = new BubbleSort();
        Graphics g = getGraphics();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        canvas.setSize(400, 400);
        frame.add(canvas);
        frame.add(canvas.sort(list, ))
        frame.pack();
        frame.setVisible(true);

        // BubbleSort 

    }
}