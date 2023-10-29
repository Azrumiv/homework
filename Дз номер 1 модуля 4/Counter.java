/*Если выполнить данную программу несколько раз, можно получить различные результаты. 
Это происходит из-за одновременного доступа обоих потоков к объекту Counter. 
В результате значения счетчика могут увеличиваться на разные величины, 
в зависимости от того, в какой момент времени потоки обращаются к объекту Counter.
Для предотвращения этой ситуации необходимо обеспечить синхронизацию доступа к объекту Counter. 
Это можно сделать с использованием метода synchronized, 
который блокирует объект во время использования другим потоком.*/



public class Counter {
    private int count=0;
    public int getValue(){
        return count;
    }
    public void increment(){
        count++;
    }
    Thread thread0=new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                increment();
            }
        }
    });
    Thread thread1=new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i=0;i<1000;i++){
                increment();
            }
        }
    });

    public static void main(String[] args) {
        Counter myclass=new Counter();
        myclass.thread0.start();
        myclass.thread1.start();
        try {
            myclass.thread0.join();
            myclass.thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(myclass.getValue());
    }
    
}
