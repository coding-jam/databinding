package it.cosenonjaviste.databinding.echo2;

import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;

import it.cosenonjaviste.databinding.util.Objects;
import it.cosenonjaviste.databinding.util.TextWatcherAdapter;

public class Echo {
    public ObservableField<String> text = new ObservableField<>();

    public TextWatcher watcher = new TextWatcherAdapter() {
        @Override public void afterTextChanged(Editable s) {
            if (!Objects.equals(text.get(), s.toString())) {
                text.set(s.toString());
            }
        }
    };
}
