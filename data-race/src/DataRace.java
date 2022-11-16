public class DataRace {
    public static void main(String[] args) {
        Resource resource = new Resource();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                resource.increase();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                resource.checkValue();
            }
        });

        thread1.start();
        thread2.start();
    }

    public static class Resource {
        private int x = 0;
        private int y = 0;

        public void increase() {
            x++;
            y++;
        }

        public void checkValue() {
            if (y > x) {
                System.out.println("detect x < y data race");
            }
        }
    }
}
