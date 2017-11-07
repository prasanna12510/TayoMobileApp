package practice.com.tayomobileapp;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import im.delight.android.webview.AdvancedWebView;

public class MainActivity extends AppCompatActivity {

    private AdvancedWebView mWebView=null;
    private static ViewGroup webViewParentViewGroup = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(mWebView != null){
            webViewParentViewGroup.removeView(mWebView);
            setContentView(R.layout.activity_main_no_webview);

            webViewParentViewGroup = (ViewGroup) findViewById(R.id.secondViewGroup);
            webViewParentViewGroup.addView(this.mWebView);

        }else {

            setContentView(R.layout.activity_main);
            webViewParentViewGroup = (ViewGroup) findViewById(R.id.firstViewGroup);
            mWebView = (AdvancedWebView) findViewById(R.id.webview);

            mWebView.setWebViewClient(new WebViewClient());
            mWebView.getSettings().setJavaScriptEnabled(true);

            mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
            mWebView.getSettings().setSupportZoom(true);
            mWebView.getSettings().setBuiltInZoomControls(true);
            mWebView.getSettings().setGeolocationEnabled(true);
            mWebView.clearCache(true);


            mWebView.loadUrl("https://tayo.casa/");


        }


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && this.mWebView.canGoBack()) {
            this.mWebView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


}
