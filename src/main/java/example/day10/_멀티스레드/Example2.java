package example.day10._멀티스레드;

class 작업스레드A extends Thread {
    @Override
    public void run() {
        try {
            int count = 1;
            while (true) {
                Thread.sleep(1000); // 해당 스레드가 밀리초만큼 일시정지
                Thread.currentThread().setName("작업스레드A");
                count++;
                System.out.println("현재 스레드명 : " + Thread.currentThread().getName() + " count : " + count);
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}

public class Example2 {
    // (1) main스레드
    public static void main(String[] args) {
        // (2) 작업스레드 생성
        작업스레드A thread1 = new 작업스레드A();
        thread1.start();

        try {
            int count = 1;
            while (true) {
                Thread.sleep(1000); // 해당 스레드가 밀리초만큼 일시정지
                count++;
                System.out.println("현재 스레드명 : " + Thread.currentThread().getName() + " count : " + count);
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}
