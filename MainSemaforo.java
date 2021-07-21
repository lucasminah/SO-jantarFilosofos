public class MainSemaforo {
    public static void main(String[] args) throws Exception {
        int numeroFilosofos = 6;
        int tempoEspera = 500;
        FilosofoSemaforo[] filosofos = new FilosofoSemaforo[numeroFilosofos];
        TalherSemaforo[] talheres = new TalherSemaforo[numeroFilosofos];

        for (int i = 0; i < 6; i++) {
            talheres[i] = new TalherSemaforo();
        }

        for (int i = 0; i < numeroFilosofos; i++) {
            TalherSemaforo talherEsquerda = talheres[i];
            TalherSemaforo talherDireita = talheres[(i + 1) % numeroFilosofos];
            if (i == numeroFilosofos - 1) {
                filosofos[i] = new FilosofoSemaforo(talherEsquerda, talherDireita, "Filosofo " + Integer.toString(i + 1), tempoEspera);
            } else {
                filosofos[i] = new FilosofoSemaforo(talherDireita, talherEsquerda, "Filosofo " + Integer.toString(i + 1), tempoEspera);
            }
            filosofos[i].start();
        }
    }
}
