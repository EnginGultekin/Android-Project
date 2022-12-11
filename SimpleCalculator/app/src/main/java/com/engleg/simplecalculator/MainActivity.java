package com.engleg.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText  Number1;
    EditText  Number2;
    TextView  Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Number1 = findViewById(R.id.Number1);
        Number2 = findViewById(R.id.Number2);
        Result  = findViewById(R.id.Result);
     }

/* kullanıcıdan alacagımız sayıyı string olarak alırız ancak  birbirleriyle işlem yaptırabilmek için aldığımız
 bu verileri floata dönüştürmemiz gerekmektetir. Bu şekilde "Number1.getText().toString() " String olarak
 alırız ve "Float.parseFloat(Number1.getText().toString()); " bu şekilde de integer bir Sayıya dönüştürebiliriz */
  // Stringlerde "==" yerine "matches" kullanılır eşit mi diğil mi diye kontrol edilir

    public void sum(View view){
        if( (Number1.getText().toString().matches("")) ||  (Number2.getText().toString().matches(""))){
            Result.setText("Enter Second Number!");
        }
        else {
            float Num1 = Float.parseFloat(Number1.getText().toString());
            float Num2 = Float.parseFloat(Number2.getText().toString());
            float Res = Num1 + Num2;
            Result.setText("Result: " + Res);  // Burda normalde Float değeri stringe çevirmemiz gerekli ama
        }                                     // tırnak içinde Result yazdığımız için bilgisayar string olrak algılıyor
    }

    public void deduct(View view){
        if( (Number1.getText().toString().matches("")) ||  (Number2.getText().toString().matches(""))){
            Result.setText("Enter Second Number!");
        }
        else {
            float Num1 = Float.parseFloat(Number1.getText().toString());
            float Num2 = Float.parseFloat(Number2.getText().toString());
            float Res = Num1 - Num2;
            Result.setText("Result: " + Res);
        }
    }

    public void multiply(View view){
        if( (Number1.getText().toString().matches("")) ||  (Number2.getText().toString().matches(""))){
            Result.setText("Enter Second Number!");
        }
        else {
            float Num1 = Float.parseFloat(Number1.getText().toString());
            float Num2 = Float.parseFloat(Number2.getText().toString());
            float Res = Num1 * Num2;
            Result.setText("Result: " + Res);
        }
    }

    public void divide(View view) {
        if( (Number1.getText().toString().matches("")) ||  (Number2.getText().toString().matches(""))){
            Result.setText("Enter Second Number!");
        } else {
            float Num1 = Float.parseFloat(Number1.getText().toString());
            float Num2 = Float.parseFloat(Number2.getText().toString());
            float Res = Num1 / Num2;
            Result.setText("Result: " + Res);
        }
    }
}


          //---------------------------  İnteger için  ---------------------------//

/* kullanıcıdan alacagımız sayıyı string olarak alırız ancak  birbirleriyle işlem yaptırabilmek için aldığımız
 bu verileri integera dönüştürmemiz gerekmektetir. Bu şekilde "Number1.getText().toString() " String olarak
 alırız ve "Integer.parseInt(Number1.getText().toString()); bu şekilde de integer bir Sayıya dönüştürebiliriz"

    public void sum(View view){
        int Num1 = Integer.parseInt(Number1.getText().toString());
        int Num2 = Integer.parseInt(Number2.getText().toString());
        int Res = Num1 + Num2;
        Result.setText("Result: " + Res);  // Burda normalde integer değeri stringe çevirmemiz gerekli ama
        // tırnak içinde Result yazdığımız için bilgisayar string olrak algılıyor
    }

    public void deduct(View view){
        int Num1 = Integer.parseInt(Number1.getText().toString());
        int Num2 = Integer.parseInt(Number2.getText().toString());
        int Res = Num1 - Num2;
        Result.setText("Result: " + Res);
    }
    public void multiply(View view){
        int Num1 = Integer.parseInt(Number1.getText().toString());
        int Num2 = Integer.parseInt(Number2.getText().toString());
        int Res = Num1 * Num2;
        Result.setText("Result: " + Res);
    }
    public void divide(View view){
        int Num1 = Integer.parseInt(Number1.getText().toString());
        int Num2 = Integer.parseInt(Number2.getText().toString());
        int Res = Num1 / Num2;
        Result.setText("Result: " + Res);
    }

 */

            //---------------------------  Double için  ---------------------------//

/*   public void sum(View view){
         double Num1 = Double.parseDouble(Number1.getText().toString());
        double Num2 = Double.parseDouble(Number2.getText().toString());
        Double Res = Num1 + Num2;
        Result.setText("Result: " + Res);
    }
    public void deduct(View view){
        double Num1 = Double.parseDouble(Number1.getText().toString());
        double Num2 = Double.parseDouble(Number2.getText().toString());
        Double Res = Num1 - Num2;
        Result.setText("Result: " + Res);
    }
    public void multiply(View view){
         double Num1 = Double.parseDouble(Number1.getText().toString());
        double Num2 = Double.parseDouble(Number2.getText().toString());
        Double Res = Num1 * Num2;
        Result.setText("Result: " + Res);
    }
    public void divide(View view){
        double Num1 = Double.parseDouble(Number1.getText().toString());
        double Num2 = Double.parseDouble(Number2.getText().toString());
        Double Res = Num1 - Num2;
        Result.setText("Result: " + Res);
    }
*/
