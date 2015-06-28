package it.cosenonjaviste.databinding.echo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import org.parceler.Parcels;

import it.cosenonjaviste.databinding.R;
import it.cosenonjaviste.databinding.databinding.EchoBinding;

public class EchoActivity extends AppCompatActivity {

    public static final String ECHO = "ECHO";

    private Echo echo;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EchoBinding binding = DataBindingUtil.setContentView(this, R.layout.echo);
        if (savedInstanceState == null) {
            echo = new Echo();
        } else {
            echo = Parcels.unwrap(savedInstanceState.getParcelable(ECHO));
        }
        binding.setEcho(echo);
    }

    @Override protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(ECHO, Parcels.wrap(echo));
    }
}
