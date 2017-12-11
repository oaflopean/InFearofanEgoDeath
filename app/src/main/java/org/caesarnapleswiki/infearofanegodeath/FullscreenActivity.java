package org.caesarnapleswiki.infearofanegodeath;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class FullscreenActivity extends Activity {
    private WebView mWebView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        mWebView = (WebView) findViewById(R.id.myWebView);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.getSettings().setDisplayZoomControls(false);
        mWebView.loadUrl("http://sites.google.com/site/clonecopy2/");
        mWebView.setWebViewClient(new MyBrowser());
       // mWebView.setWebViewClient(new WebViewClient() {
       //     @Override
         //   public boolean shouldOverrideUrlLoading(WebView view, String url) {
         //       view.loadUrl(url);
         //       return true;
        //    }
      //  });

       // this.setContentView(mWebView);
    //}
}
    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }


}
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (keyCode) {
                case KeyEvent.KEYCODE_BACK:
                    if (mWebView.canGoBack()) {
                        mWebView.loadUrl("http://sites.google.com/site/clonecopy2/");
                    } else {
                        finish();
                    }
                    return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}