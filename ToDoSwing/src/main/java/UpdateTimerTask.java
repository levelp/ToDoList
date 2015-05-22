import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Обновление таймера
 */
public class UpdateTimerTask extends TimerTask {
    private final ActionListener actionListener;

    public UpdateTimerTask(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    @Override
    public void run() {
        if (TimerForm.timerForm.timeGo) {
            Timer timer = new Timer();
            timer.schedule(new UpdateTimerTask(actionListener), TimerForm.DELAY);
        }
        TimerForm.timerForm.updateTime();
    }
}
