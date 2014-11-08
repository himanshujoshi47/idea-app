package com.phoenixtechnoz.idea;

import java.io.OutputStream;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SignatureRecorderActivity extends Activity {

	SignatureView sv;

	static Bitmap bitmap;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Signature sigView = new Signature(this, null);
		setContentView(sigView);


	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		View v = getWindow().getDecorView().getRootView();
	    v.setDrawingCacheEnabled(true);
	    Bitmap b = v.getDrawingCache();
	    int width = b.getWidth();
	    int height = b.getHeight();
	    int newWidth = 200;
	    int newHeight = 200;
	    float scaleWidth = ((float) newWidth) / width;
	    float scaleHeight = ((float) newHeight) / height;
	    Matrix matrix = new Matrix();
	    matrix.postScale(scaleWidth, scaleHeight);
	    Bitmap resizedBitmap = Bitmap.createBitmap(b, 0, 0, 
                width, height, matrix, true);
	    String locatin = MediaStore.Images.Media.insertImage(
				getContentResolver(), resizedBitmap, "STORED FILE", "");

		Toast.makeText(this, "saved to gallery please check!",
				Toast.LENGTH_SHORT).show();
		Uri SignatureUri = Uri.parse(locatin);
		String sig = getRealPathFromURI(SignatureUri);

		Form.signature = sig;

		Form.signaurebitmap = b;
	}
	private void saveStuff() {

		this.bitmap = Bitmap.createBitmap(sv.getBitmap());

		String locatin = MediaStore.Images.Media.insertImage(
				getContentResolver(), bitmap, "STORED FILE", "");

		Toast.makeText(this, "saved to gallery please check!",
				Toast.LENGTH_SHORT).show();
		Log.e("SSS", locatin);
		Uri SignatureUri = Uri.parse(locatin);
		String sig = getRealPathFromURI(SignatureUri);

		Form.signature = sig;

		Form.signaurebitmap = this.bitmap;

	}

	private String getRealPathFromURI(Uri contentUri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		CursorLoader loader = new CursorLoader(getBaseContext(), contentUri,
				proj, null, null, null);
		Cursor cursor = loader.loadInBackground();
		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}
}