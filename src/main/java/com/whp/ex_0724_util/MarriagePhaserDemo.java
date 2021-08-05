package com.whp.ex_0724_util;

/**
 * @Author: wanghp
 * @Date: 2021/7/24 9:37 下午
 * @Describe
 * @Version V1.0
 */
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class MarriagePhaserDemo {

    static MarriagePhaser phaser = new MarriagePhaser();


    public static void main(String[] args) {

        phaser.bulkRegister(7); //  批量注册

        for (int i = 0; i < 5; i++) {
            new Thread(new Person("路人" + i)).start();
        }

        new Thread(new Person("新郎")).start();
        new Thread(new Person("新娘")).start();

        for (;;){
            sleep(1000);
        }

    }

    static void sleep(int milli) {
        try {
            TimeUnit.MILLISECONDS.sleep(milli);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class MarriagePhaser extends Phaser {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("所有人到齐了！" + registeredParties + "人");
                    System.out.println();
                    sleep(2000);
                    return false;
                case 1:
                    System.out.println("所有人吃完了！" + registeredParties + "人");
                    System.out.println();
                    sleep(2000);
                    return false;
                case 2:
                    System.out.println("所有人离开了！" + registeredParties + "人");
                    System.out.println();
                    sleep(2000);
                    return false;
                case 3:
                    System.out.println("婚礼结束！新郎新娘抱抱！" + registeredParties + "人");
                    System.out.println();
                    sleep(2000);
                    return false;
                case 4:
                    System.out.println("活过了第二天" + registeredParties + "人");
                    System.out.println();
                    sleep(2000);
                    return false;
                default:
                    System.out.println("活过了第三天" + registeredParties + "人");
                    System.out.println();
                    sleep(2000);
                    return true;
            }
        }
    }

    static class Person implements Runnable {

        String name;

        public Person(String name) {
            this.name = name;
        }

        public void arrive() {
            System.out.printf("%s 到达现场！\n", name);
            phaser.arriveAndAwaitAdvance(); //  提前到达并等待
        }

        public void eat() {
            System.out.printf("%s 吃完!\n", name);
            phaser.arriveAndAwaitAdvance(); //  提前到达并等待
        }

        public void leave() {
            System.out.printf("%s 离开！\n", name);
            phaser.arriveAndAwaitAdvance(); //  提前到达并等待
        }

        private void hug() {
            if (name.equals("新郎") || name.equals("新娘")) {
                System.out.printf("%s 洞房！\n", name);
                phaser.arriveAndAwaitAdvance(); //  提前到达并等待
            } else {
                phaser.register(); //   登记
                /*try {
                    phaser.arriveAndDeregister();   //  到达和取消注册
                } catch (Exception e) {
                    System.out.printf("%s 度过了第一天时GG了！\n", name);
                }*/
            }
        }

        public void survivedNextDay() {
            sleep(3000);

            try {
                phaser.arriveAndAwaitAdvance(); //  提前到达并等待
                //  phaser.arriveAndDeregister();   //  到达和取消注册
            } catch (Exception e) {
                sleep(2000);
                System.out.printf("%s 度过了第二天时GG了！\n", name);
            }
        }

        public void survivedThirdDay() {
            sleep(3000);

            try {
                phaser.arriveAndDeregister();   //  到达和取消注册
            } catch (Exception e) {
                sleep(3000);
                System.out.printf("%s 度过了第三天时GG了！\n", name);
            }
        }


        @Override
        public void run() {
            arrive();

            eat();

            leave();

            hug();

            survivedNextDay();

            survivedThirdDay();
        }
    }
}



