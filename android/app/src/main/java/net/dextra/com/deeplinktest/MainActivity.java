package net.dextra.com.deeplinktest;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webViewId);

        webView.setWebViewClient(new WebViewClient() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                if ("foo://felicidade/atomica".equals(request.getUrl().toString().toLowerCase())) {
                    System.out.println("Teste ok");
                }
                return super.shouldOverrideUrlLoading(view, request);
            }
        });

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("http://10.0.2.2:8081");
    }
}
