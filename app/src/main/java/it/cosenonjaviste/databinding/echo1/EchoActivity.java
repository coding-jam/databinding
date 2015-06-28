package it.cosenonjaviste.databinding.echo1;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import it.cosenonjaviste.databinding.R;
import it.cosenonjaviste.databinding.databinding.Echo1Binding;

public class EchoActivity extends AppCompatActivity {
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Echo1Binding binding = DataBindingUtil.setContentView(this, R.layout.echo_1);
        binding.setEcho(new Echo());
    }
}
