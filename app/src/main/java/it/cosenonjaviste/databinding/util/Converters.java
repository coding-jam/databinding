package it.cosenonjaviste.databinding.util;

import android.databinding.BindingAdapter;
import android.databinding.BindingConversion;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import it.cosenonjaviste.databinding.R;

public class Converters {
    @BindingConversion
    public static String convertBindableToString(BindableString bindableString) {
        return bindableString.get();
    }

    @BindingConversion
    public static boolean convertBindableToBoolean(BindableBoolean bindableBoolean) {
        return bindableBoolean.get();
    }

    @BindingAdapter({"app:binding"})
    public static void bindEditText(EditText view, final BindableString bindableString) {
        Pair<BindableString, TextWatcherAdapter> pair = (Pair) view.getTag(R.id.bound_observable);
        if (pair == null || pair.first != bindableString) {
            if (pair != null) {
                view.removeTextChangedListener(pair.second);
            }
            TextWatcherAdapter watcher = new TextWatcherAdapter() {
                @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                    bindableString.set(s.toString());
                }
            };
            view.setTag(R.id.bound_observable, new Pair<>(bindableString, watcher));
            view.addTextChangedListener(watcher);
        }
        String newValue = bindableString.get();
        if (!view.getText().toString().equals(newValue)) {
            view.setText(newValue);
        }
    }

    @BindingAdapter({"app:binding"})
    public static void bindRadioGroup(RadioGroup view, final BindableBoolean bindableBoolean) {
        if (view.getTag(R.id.bound_observable) != bindableBoolean) {
            view.setTag(R.id.bound_observable, bindableBoolean);
            view.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override public void onCheckedChanged(RadioGroup group, int checkedId) {
                    bindableBoolean.set(checkedId == group.getChildAt(1).getId());
                }
            });
        }
        Boolean newValue = bindableBoolean.get();
        ((RadioButton) view.getChildAt(newValue ? 1 : 0)).setChecked(true);
    }

    @BindingAdapter({"app:onClick"})
    public static void bindOnClick(View view, final Runnable runnable) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                runnable.run();
            }
        });
    }
}
