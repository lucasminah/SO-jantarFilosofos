public class FilosofoSemaforo extends Thread {
    private String name;
    private int sleepTime;
    private TalherSemaforo talherEsquerda;
    private TalherSemaforo talherDireita;

    public FilosofoSemaforo(TalherSemaforo talherEsquerda, TalherSemaforo talherDireita, String name, int sleepTime) {
        this.talherEsquerda = talherEsquerda;
        this.talherDireita = talherDireita;
        this.name = name;
        this.sleepTime = sleepTime;
    }

    public void fazer(String acao) throws InterruptedException {
        System.out.println(this.name + " " + acao);
        Thread.sleep(this.sleepTime);
    }

    public void run() {
        try {
            while (true) {
                if (talherEsquerda.sem.tryAcquire()) {
                    if (talherDireita.sem.tryAcquire()) {
                        fazer("pegou talher esquerdo");
                        fazer("pegou talher direito - comendo");
                        talherDireita.sem.release();
                        fazer("largou talher direito");
                        talherEsquerda.sem.release();
                        fazer("largou talher esquerdo - pensando");
                    } else {
                        talherEsquerda.sem.release();
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
