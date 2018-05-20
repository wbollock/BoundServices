package wbollock.com.boundservices;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder buckysBinder = new myLocalBinder(); // the bridge between client and service (localBinder)


    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return buckysBinder;
    }

    public String getCurrentTime(){
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss", Locale.US);
        return (df.format(new Date()));
    }

    public class myLocalBinder extends Binder{ // this class is capable of binding two classes together
        MyService getService(){
            return MyService.this; // whenever we want to a bind a client to a service, need a class that binds the classes
        }
    }
}
