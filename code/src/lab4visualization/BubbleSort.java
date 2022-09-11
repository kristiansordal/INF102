// package INF102.lab4.sorting;
package lab4visualization;

import java.util.List;
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
        Canvas list = new BubbleSort();
        // final Graphics g = new Graphics();
        list.setSize(400, 400);
        frame.add(list);
        frame.pack();
        frame.setVisible(true);

        // BubbleSort 

    }
}