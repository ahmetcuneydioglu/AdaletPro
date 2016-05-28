package adalet.quiz.pro.view;

import android.app.ProgressDialog;
import android.content.Context;

import adalet.quiz.pro.R;


public class GoogleProgress {

	public static ProgressDialog progress;
	public static ProgressDialog Progressshow(Context context)
	{
		progress = new ProgressDialog(context, R.style.MyTheme);
		progress.setCancelable(false);
		progress.getWindow().setBackgroundDrawable(null);

		progress.setIndeterminateDrawable(context.getResources().getDrawable(R.anim.progressbar));
		
		return progress;
	}
}
