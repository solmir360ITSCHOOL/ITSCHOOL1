package net.snode.itschool2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        findViewById(R.id.calc).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String sa = ((EditText) findViewById(R.id.a)).getText().toString();
                String sb = ((EditText) findViewById(R.id.b)).getText().toString();
                String sc = ((EditText) findViewById(R.id.c)).getText().toString();

                if (sa.length() == 0 || sb.length() == 0 || sc.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Введите значения", Toast.LENGTH_LONG).show();
                    return;
                }

                int a = Integer.parseInt(sa);
                int b = Integer.parseInt(sb);
                int c = Integer.parseInt(sc);

                if (a == 0) {
                    Toast.makeText(getApplicationContext(), "Введите правильные значения", Toast.LENGTH_LONG).show();
                    return;
                }

                int D = b * b - 4 * a * c;
                double x1 = (-b - Math.sqrt(D)) / (2 * a);
                double x2 = (-b + Math.sqrt(D)) / (2 * a);

                if (Double.isNaN(x1) || Double.isNaN(x2)) {
                    Toast.makeText(getApplicationContext(), "Работает только для действительных чисел", Toast.LENGTH_LONG).show();
                    return;
                }

                ((TextView) findViewById(R.id.result1)).setText(String.valueOf(x1));
                ((TextView) findViewById(R.id.result2)).setText(String.valueOf(x2));
            }
        });
    }
}