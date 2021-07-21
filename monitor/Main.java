public class Main {
    public static void main(String[] args) throws Exception {
        Filosofo[] filosofos = new Filosofo[6];
        Object[] talheres = new Object[6];

        for (int i = 0; i < 6; i++) {
            talheres[i] = new Object();
        }

        for (int i = 0; i < 6; i++) {
            Object talherEsquerda = talheres[i];
            Object talherDireita = talheres[(i + 1) % 6];
            if (i == 5) {
                filosofos[i] = new Filosofo(talherEsquerda, talherDireita, 500);
            } else {
                filosofos[i] = new Filosofo(talherDireita, talherEsquerda, 500);
            }
            Thread t = new Thread(filosofos[i], "Filosofo " + (i + 1));
            t.start();
        }
    }
}
