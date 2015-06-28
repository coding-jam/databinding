package it.cosenonjaviste.databinding.util;

import org.parceler.Parcel;

@Parcel
public class BindableString extends BaseObservable {
    String mValue;

    public String get() {
        return mValue != null ? mValue : "";
    }

    public void set(String value) {
        if (!equals(mValue, value)) {
            this.mValue = value;
            notifyChange();
        }
    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }

    public boolean isEmpty() {
        return mValue == null || mValue.isEmpty();
    }
}