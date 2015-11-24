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

        float maxLargeFontSize = 70;
        float maxSmallFontSize = 40;

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
