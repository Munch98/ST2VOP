package java;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erso Created on 08-02-2010, 09:34:25
 */
class Producer implements Runnable {
   private CircularBuff q;
   private int initVal;

   Producer(CircularBuff q, int number) {
      this.q = q;
      initVal = number*100;
      new Thread(this, "Producer_"+number).start();
   }

   public void run() {
      int i = initVal;
      while(true) {
         q.put(i++);
//          try {
//              Thread.sleep((long) (Math.random() * 100));
//          } catch (InterruptedException ex) {
//              System.out.println(ex);
//          }
      }
   }
}

