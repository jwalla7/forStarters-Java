package Lambdas;

public class RunnableLambdas {
    public static void main(String[] args) {
        Thread thread_0 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Printed inside Runnable");
            }
        });
        thread_0.run();

        Thread lamdaThread = new Thread(() -> System.out.println("Printed inside Lambda Runnable"));
        lamdaThread.run();
    }

}
