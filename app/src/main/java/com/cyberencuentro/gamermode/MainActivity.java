
package com.cyberencuentro.gamermode;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(50,100,50,100);
        layout.setBackgroundColor(Color.parseColor("#0F0F0F"));
        
        TextView title = new TextView(this);
        title.setText("CYBER ENCUENTRO\nGAMER MODE");
        title.setTextSize(28f);
        title.setTextColor(Color.parseColor("#39FF14"));
        title.setGravity(Gravity.CENTER);
        
        TextView status = new TextView(this);
        status.setText("Listo para activar");
        status.setTextColor(Color.WHITE);
        status.setGravity(Gravity.CENTER);
        status.setPadding(0,40,0,40);
        
        Button btn = new Button(this);
        btn.setText("ACTIVAR MODO GAMER");
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GamerModeService.class);
            startForegroundService(intent);
            status.setText("MODO GAMER ACTIVADO\nOptimizando para Free Fire");
        });
        
        layout.addView(title);
        layout.addView(status);
        layout.addView(btn);
        setContentView(layout);
    }
}
