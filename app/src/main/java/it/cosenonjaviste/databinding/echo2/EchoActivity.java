package it.cosenonjaviste.databinding.echo2;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.cosenonjaviste.databinding.R;
import it.cosenonjaviste.databinding.databinding.Echo2Binding;

public class EchoActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Echo2Binding binding = DataBindingUtil.setContentView(this, R.layout.echo_2);
        binding.setEcho(new Echo());
    }
}
