package com.example.yangxiao.googledocstest;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    class DemoJavaScriptInterface {
        @JavascriptInterface
        public void sayHello(String json) {
            try {
                Log.e("sayHello", json);
                JSONObject object = new JSONObject(json);
                Log.e("sayHello:a", object.getInt("a") + "");
                Log.e("sayHello:b", object.getString("b"));
                Log.e("sayHello:c", object.getJSONObject("c").getString("d"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new DemoJavaScriptInterface(), "android");
        webView.setWebViewClient(new MyWebView());
        webView.loadUrl("file:///android_asset/app.html");
//        webView.loadUrl("http://t.wehealth.mobi/web/app.html");

//        final String path = Environment.getExternalStorageDirectory() + File.separator + "testGoogleDoc/";
//        Intent intent = getIntent();
//        if (intent != null) {
//            final Uri uri = intent.getData();
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    InputStream inputStream = null;
//                    OutputStream outputStream = null;
//                    try {
//                        inputStream = getContentResolver().openInputStream(uri);
//                        File file = new File(path);
//                        if (file.exists()) {
//                            file.delete();
//                        }
//                        file.createNewFile();
//                        outputStream = new FileOutputStream(file);
//                        int read = 0;
//                        byte[] bytes = new byte[1024];
//
//                        while ((read = inputStream.read(bytes)) != -1) {
//                            outputStream.write(bytes, 0, read);
//                        }
//
//                        Log.e("GoogleDocs", "success");
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });

//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.os.Debug.stopMethodTracing();
    }

    class MyWebView extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
//            view.loadUrl("javascript:document.getElementById(\"btn\").addEventListener(\"click\", function(){ window.android.onClick1(\"this is a test2\")})");
            super.onPageFinished(view, url);
        }
    }
}
