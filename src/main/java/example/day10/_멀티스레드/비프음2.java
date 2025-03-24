package example.day10._멀티스레드;

import java.awt.*;

public class 비프음2 extends Thread {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 1; i <= 5; i++) {
            toolkit.beep();
            try {
                Thread.sleep(1000); // Thread.sleep(밀리초); 예외발생
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
