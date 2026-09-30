
package com.cyberencuentro.gamermode;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

public class GamerModeService extends Service {
    @Override
    public IBinder onBind(Intent intent) { return null; }
    @Override
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("gamer_channel", "Gamer Mode", NotificationManager.IMPORTANCE_LOW);
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
            Notification notif = new Notification.Builder(this, "gamer_channel")
                .setContentTitle("Cyber Gamer Activo")
                .setContentText("Optimizando para Free Fire")
                .setSmallIcon(android.R.drawable.ic_media_play)
                .build();
            startForeground(1, notif);
        }
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) { return START_STICKY; }
}
