/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package de.matthiasmann.coroutines;

import org.junit.Test;


/** @author Elias Naur */
public class InterfaceTest {
  @Test
  public void testSuspend() {
//              final I i = new C();
    Coroutine co =
      new Coroutine(
        new CoRunnable() {
          public final void coExecute()
              throws SuspendExecution {
            // next line causes an error because of incomplete merge in
            // TypeInterpreter SomeInterface i = System.currentTimeMillis() >
            // 0 ? new C() : new C2();
            SomeInterface i = new C();

            System.out.println("i = " + i);
            i.doStuff();
          }
        }
      );

    while (co.getState() != Coroutine.State.FINISHED) {
      System.out.println("State=" + co.getState());
      co.run();
    }

    System.out.println("State=" + co.getState());
  }

  /**
   * DOCUMENT ME!
   *
   * @author  $author$
   * @version $Revision$, $Date$
   */
  public class C2 implements SomeInterface {
    /**
     * DOCUMENT ME!
     *
     * @throws SuspendExecution DOCUMENT ME!
     */
    public void doStuff()
        throws SuspendExecution {}
  }

  /**
   * DOCUMENT ME!
   *
   * @author  $author$
   * @version $Revision$, $Date$
   */
  public class C implements SomeInterface {
    /**
     * DOCUMENT ME!
     *
     * @throws SuspendExecution DOCUMENT ME!
     */
    public void doStuff()
        throws SuspendExecution {
/*                      float time = 0f;
                        float seconds = .8f;
                        do {
                                float t = .06667f;
                                System.out.println("time = " + time + " " + (time + t));
                                //          time = StrictMath.min(time + t, seconds);
                                time = time + t;
                                System.out.println("seconds = " + seconds + " | time = " + time + " | t = " + t);
                                System.out.println("this = " + this);

                                System.out.println("time just not after = " + time);
                                Coroutine.yield();
                                System.out.println("time after = " + time);
                        } while (time < seconds);
                        System.out.println("1 = " + 1);*/
    }
  }

}
