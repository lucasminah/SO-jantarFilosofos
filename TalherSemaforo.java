import java.util.concurrent.Semaphore;

public class TalherSemaforo {
    public Semaphore sem;

    TalherSemaforo() {
        this.sem = new Semaphore(1);
    }
}
