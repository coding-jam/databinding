package it.cosenonjaviste.databinding.echo2;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import it.cosenonjaviste.databinding.util.TextWatcherAdapter;

public class Echo {
    public ObservableField<String> text = new ObservableField<>();

    public TextWatcher watcher = new TextWatcherAdapter() {
        @Override public void afterTextChanged(Editable s) {
            System.out.println(s);
            if (!areEquals(text.get(), s.toString())) {
                System.out.println(s);
                text.set(s.toString());
            }
        }
    };

    public static boolean areEquals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
