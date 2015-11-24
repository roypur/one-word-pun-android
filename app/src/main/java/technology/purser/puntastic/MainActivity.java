package technology.purser.puntastic;

import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import go.puntastic.Puntastic;
import go.puntastic.Puntastic.Pun;

public class MainActivity extends AppCompatActivity {

    private EditText in;
    private TextView out_pun;
    private TextView out_base;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        in = (EditText)findViewById(R.id.in_text);
        out_pun = (TextView)findViewById(R.id.pun_text);
        out_base = (TextView)findViewById(R.id.base_text);

        Puntastic.Load("dictionary.gob");

    }
    public void makePun(View v){
        String inText = in.getText().toString();
        Pun pun = Puntastic.Get(inText);

        float largeBaseSize = 500;
        float smallBaseSize = 300;

        out_pun.setTextSize(largeBaseSize/pun.getPun().length());
        out_base.setTextSize(smallBaseSize/pun.getBaseWord().length());


        out_pun.setText(pun.getPun());
        out_base.setText(pun.getBaseWord());


    }
}
