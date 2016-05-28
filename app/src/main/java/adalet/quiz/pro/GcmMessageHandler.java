package adalet.quiz.pro;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;

public class GcmMessageHandler extends IntentService {

	NotificationCompat.Builder builder;
	Handler handler;
	Context context;
	SessionManager session;

	public GcmMessageHandler() {
		super("GcmIntentService");
	}

	static final String DISPLAY_MESSAGE_ACTION = "DISPLAY_MESSAGE";

	static final String EXTRA_MESSAGE = "message";
	public static final String TAG = "GCMNotificationIntentService";

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		handler = new Handler();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		context = getApplicationContext();
		session = new SessionManager(context);

		final Bundle extras = intent.getExtras();

		// notifies user
		GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

		if (session.isLoggedIn()) {
			String messageType = gcm.getMessageType(intent);

			if (!extras.isEmpty()) {
				if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR
						.equals(messageType)) {
					// sendNotification("Send error: " + extras.toString());
					Log.i(TAG,
							"GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR @ "
									+ GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR);

				} else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED
						.equals(messageType)) {
					// sendNotification("Deleted messages on server: "
					// + extras.toString());
					Log.i(TAG, "MESSAGE_TYPE_DELETED@ "
							+ GoogleCloudMessaging.MESSAGE_TYPE_DELETED);

				} else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE
						.equals(messageType)) {

					Log.i(TAG,
							"Completed work @ " + SystemClock.elapsedRealtime());

					Log.i(TAG, "Received: " + extras.toString());

					String message = intent.getExtras().getString("message");

					String category = intent.getExtras().getString("title"); // firstname

					generateNotification(context, category, message);
					// dbgroup.addContact(new GroupPojo(groupid, groupname,
					// memberid, membername, date, adminid));

					Intent i = new Intent("CHAT_MESSAGE_RECEIVED");
					i.putExtra("message", extras.getString("message"));

					context.sendBroadcast(i);

				}
			}
		}
		WakefulBroadcastReceiver.completeWakefulIntent(intent);

	}

	public void generateNotification(Context context, String title,
			String message) {
		int icon = R.drawable.ic_stat_name;
		long when = System.currentTimeMillis();
		NotificationManager notificationManager = (NotificationManager) context
				.getSystemService(Context.NOTIFICATION_SERVICE);
		Notification notification = new Notification(icon, message, when);

		// title = context.getString(R.string.app_name);

		Intent notificationIntent = new Intent(context, MainActivity.class);
		notificationIntent.setAction("splash");
		// set intent so it does not start a new activity
		notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
				| Intent.FLAG_ACTIVITY_SINGLE_TOP);
		PendingIntent intent = PendingIntent.getActivity(context, 0,
				notificationIntent, 0);
		//notification.setLatestEventInfo(context, title, message, intent);
		notification.flags |= Notification.FLAG_AUTO_CANCEL;

		// Play default notification sound


		int notificationid = 1111;

		notification.defaults |= Notification.DEFAULT_SOUND;

		System.out.println("notification id==" + notificationid);
		notificationManager.notify(notificationid, notification);

		// new getdata().execute();

	}

}
