package it.cosenonjaviste.databinding.util;

import android.databinding.BindingAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import it.cosenonjaviste.databinding.R;
import it.cosenonjaviste.twowaydatabinding.ObservableBoolean;

public class Converters {

    @BindingAdapter({"app:binding"})
    public static void bindRadioGroup(RadioGroup view, final ObservableBoolean bindableBoolean) {
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
}
