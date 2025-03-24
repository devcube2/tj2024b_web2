package example.day10._멀티스레드;

import java.time.LocalTime;
import java.util.Scanner;

class MusicThread extends Thread {
    public boolean state = false;
    public boolean exit = false;

    @Override
    public void run() {
        System.out.println("음악 시작!");

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (state) {
                System.out.println("음악 재생 중...");
            }
            if (exit) {
                break;
            }
        }

        System.out.println("음악 종료!");
    }
}

class WebThread extends Thread {
    public boolean state = false;
    public boolean exit = false;

    @Override
    public void run() {
        System.out.println("웹서핑 시작!");

        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (state) {
                System.out.println("웹서핑 중...");
            }
            if (exit) {
                break;
            }
        }

        System.out.println("웹서핑 종료!");
    }
}

public class Homework {
    public static void main(String[] args) {
        MusicThread thread1 = null;
        WebThread thread2 = null;

        // 2. 입력받기
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("1. 뮤직 ON/OFF | 2. 웹서핑 ON/OFF | 0. 종료");
            int ch = scan.nextInt();
            if (ch == 1) {
                if (thread1 == null) {
                    thread1 = new MusicThread();
                    thread1.start();
                    thread1.state = true;
                } else {
                    thread1.exit = true;
                    thread1 = null;
                }
            } else if (ch == 2) {
                if (thread2 == null) {
                    thread2 = new WebThread();
                    thread2.start();
                    thread2.state = true;
                } else {
                    thread2.exit = true;
                    thread2 = null;
                }
            } else if (ch == 0) {
                thread1.exit = true;
                thread2.exit = true;
                break;
            }
        }

        System.out.println("스마트폰 종료...");
    }
}
