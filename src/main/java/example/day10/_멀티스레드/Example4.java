package example.day10._멀티스레드;

class User1 extends Thread {
    public Calulator calulator;

    @Override
    public void run() {
        calulator.setMemory(100);
    }
}

class User2 extends Thread {
    public Calulator calulator;

    @Override
    public void run() {
        calulator.setMemory(200);
    }
}

class Calulator {
    public int memory;

    public void setMemory(int memory) {
        this.memory = memory;
        try {
            Thread.sleep(2000);
            System.out.println(this.memory);
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }
}

public class Example4 {
    public static void main(String[] args) {
        // 1. 계산기
        Calulator calulator = new Calulator();

        // 2. 각 객체에 동일한 계산기를 대입
        User1 user1 = new User1();
        user1.calulator = calulator;
        User2 user2 = new User2();
        user2.calulator = calulator;

        // 3. 각 객체가 계산기에 대입하는 병렬처리
        user1.start();
        user2.start();


    }
}
