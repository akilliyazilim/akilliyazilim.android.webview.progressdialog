package akilliyazilim.webviewprogressdialog;

import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Main extends Activity {

	private WebView mWebView;
	private ProgressDialog mProgressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.activity_main);

		mWebView = (WebView) findViewById(R.id.webView1);

		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);

		mProgressDialog = ProgressDialog.show(this, "Yükleniyor",
				"Ýçerik Yüklenirken Lütfen Bekleyiniz.");

		mWebView.setWebViewClient(new WebViewClient() {

			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}

			public void onPageFinished(WebView view, String url) {
				if (mProgressDialog.isShowing()) {
					mProgressDialog.dismiss();
				}
			}
		});
		mWebView.loadUrl("http://www.akilliyazilim.org");

	}

}
