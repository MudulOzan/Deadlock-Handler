public class Deadlock {
   public static Object Lock1 = new Object();
   public static Object Lock2 = new Object();
   
   public static void main(String args[]) {
      Thread1 T1 = new Thread1();
      Thread2 T2 = new Thread2();
      T1.start();
      T2.start();
   }
   
   private static class Thread1 extends Thread {
      public void run() {
         synchronized (Lock1) {
            System.out.println("Thread 1: Lock 1 engaged.");
            try { Thread.sleep(10); } 
            catch (InterruptedException e) {} System.out.println("Thread 1: Waiting lock 2.");
            synchronized (Lock2) { System.out.println("Thread 1: Lock 1 & 2 engaged."); }
         }
      }
   }
   private static class Thread2 extends Thread {
      public void run() {
         synchronized (Lock1) {
            System.out.println("Thread 2: Lock 1 engaged.");
            try { Thread.sleep(10); } 
            catch (InterruptedException e) {} System.out.println("Thread 2: Waiting for lock 2.");
            synchronized (Lock2) { System.out.println("Thread 2: Lock 1 & 2 engaged."); }
         }
      }
   } 
}