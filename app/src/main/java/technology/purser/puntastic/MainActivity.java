package technology.purser.puntastic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.EditText;
import android.view.View;
import go.puntastic.Puntastic;
import go.puntastic.Puntastic.Pun;
import android.widget.TextView.OnEditorActionListener;

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


        in.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                makePun();
                return true;
            }
        });

    }
    public void makePun(View v){
        makePun();
    }
    public void makePun(){
        String inText = in.getText().toString();
        Pun pun = Puntastic.Get(inText);

        float largeBaseSize = 400;
        float smallBaseSize = 200;

        float maxLargeFontSize = 50;
        float maxSmallFontSize = 25;

        float largeFontSize = 0;
        float smallFontSize = 0;

        if((pun.getPun() != null) && (pun.getPun().length() > 0)){
            largeFontSize = largeBaseSize/pun.getPun().length();
        }

        if((pun.getBaseWord() != null) && (pun.getBaseWord().length() > 0)){
            smallFontSize = smallBaseSize/pun.getBaseWord().length();
        }

        if((largeFontSize > maxLargeFontSize) || (smallFontSize > maxSmallFontSize)){
            largeFontSize = maxLargeFontSize;
            smallFontSize = maxSmallFontSize;
        }

        out_pun.setTextSize(largeFontSize);
        out_base.setTextSize(smallFontSize);

        out_pun.setText(pun.getPun());
        out_base.setText(pun.getBaseWord());

    }

}
