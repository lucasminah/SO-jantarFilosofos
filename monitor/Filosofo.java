public class Filosofo implements Runnable {
    private int sleepTime;
    private Object talherEsquerda;
    private Object talherDireita;

    public Filosofo(Object talherEsquerda, Object talherDireita, int sleepTime) {
        this.talherEsquerda = talherEsquerda;
        this.talherDireita = talherDireita;
        this.sleepTime = sleepTime;
    }

    public void fazer(String acao) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + acao);
        Thread.sleep(this.sleepTime);
    }

    @Override
    public void run() {
        try {
            while (true) {
                fazer("pensando");
                synchronized (talherEsquerda) {
                    fazer("pegou o talher esquerdo");
                    synchronized (talherDireita) {
                        fazer("pegou o talher direito - comendo");
                        fazer("largou talher esquerdo");
                    }
                    fazer("largou o talher direito - voltou a pensar");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
}
