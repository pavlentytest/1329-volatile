package com.company;

public class Main {

    /*
    Класс Thread
    Интерфейс Runnable
    synchronized (по блоку с помощью объекта)
    wait() - поток в режиме ожидания
    notify() и notifyAll() - возобновление потока(ов), наход. в режиме ожидания
    join() - ждем завершения потока
    volatile (изменчивость)
     */

    private volatile boolean flagExit = false;

    public static void main(String[] args) {
        new Main().start();
    }

    public void start() {
        new Thread(gui).start();
        System.out.println("Поток интерфейса - запущен!");
        new Thread(game).start();
        System.out.println("Поток игры - запущен!");
    }
    //  поток интерфейса
    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flagExit = true;
            System.out.println("Поток интерфейса - остановлен!");
        }
    };
    // поток игры
    Runnable game = new Runnable() {
        @Override
        public void run() {
            while(!flagExit) {
                // бесконечно что-то делаем
            }
            System.out.println("Поток игры - остановлен!");
        }
    };
}
