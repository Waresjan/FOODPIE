package lanou.foodpie.volly;

import android.app.Application;
import android.content.Context;

/**
 * !!!!!!写完 MyApp 一定 一定 一定 要注册!!!!
 *
 */

public class MyApp extends Application {
    //所有跟界面无关的 都可以用这个全局的Context
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext(){
        return sContext;
    }
}
