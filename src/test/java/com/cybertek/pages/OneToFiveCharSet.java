package com.cybertek.pages;

import org.junit.Test;

public class OneToFiveCharSet {

    @Test
    public void OneToFiveCharSet() {

//        for (int i5 = 'a'; i5 <= 'z'; i5++)
//            System.out.println("" + (char) i5);
//
//        for (int i4 = 'a'; i4 <= 'z'; i4++)
//            for (int i5 = 'a'; i5 <= 'z'; i5++)
//                System.out.println("" + (char) i4 + (char) i5);
//
//        for (int i3 = 'a'; i3 <= 'z'; i3++)
//            for (int i4 = 'a'; i4 <= 'z'; i4++)
//                for (int i5 = 'a'; i5 <= 'z'; i5++)
//                    System.out.println("" + (char) i3 + (char) i4 + (char) i5);

        for (int i2 = 'p'; i2 <= 'z'; i2++)
            for (int i3 = 'a'; i3 <= 'z'; i3++)
                for (int i4 = 'a'; i4 <= 'z'; i4++)
                    for (int i5 = 'a'; i5 <= 'z'; i5++)
                        System.out.println("" + (char) i2 + (char) i3 + (char) i4 + (char) i5);

//        for (int i1 = 'a'; i1 <= 'z'; i1++)
//            for (int i2 = 'a'; i2 <= 'z'; i2++)
//                for (int i3 = 'a'; i3 <= 'z'; i3++)
//                    for (int i4 = 'a'; i4 <= 'z'; i4++)
//                        for (int i5 = 'a'; i5 <= 'z'; i5++)
//                            System.out.println("" + (char) i1 + (char) i2 + (char) i3 + (char) i4 + (char) i5);

    }

//    @After
//    public void teardown() {
//        Driver.closeDriver();
//    }
}


/*

<span data-cy="exact-match-price-main" class="ms7 text-primary-o">$1.00/mo</span>

<span data-cy="exact-match-price-main" class="ms7 text-primary-o">$6,000,000.00</span>

//span

 */

