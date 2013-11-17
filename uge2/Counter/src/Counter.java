import java.util.*;
import javax.swing.event.*;

public class Counter {
    private int value;

    private ArrayList<ChangeListener> listeners =
        new ArrayList<ChangeListener>();
    
    public Counter(int initialValue) {
        value = initialValue;
    }

    public void change(int diff) {
        value += diff;
        for (ChangeListener listener: listeners) {
            listener.stateChanged(new ChangeEvent(this));
        }
    }
    
    public int getValue() {
        return value;
    }
    
    public void addChangeListener(ChangeListener l) {
        listeners.add(l);
    }
}