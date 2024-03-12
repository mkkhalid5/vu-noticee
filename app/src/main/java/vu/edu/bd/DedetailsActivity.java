package vu.edu.bd;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class DedetailsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private ScrollView vscroll1;
	private ImageView imageview1;
	private TextView textview28;
	private LinearLayout linear6;
	private LinearLayout khalid;
	private LinearLayout sagor;
	private LinearLayout rakhiul;
	private LinearLayout linear44;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private CircleImageView circleimageview7;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private TextView textview14;
	private TextView textview15;
	private TextView textview16;
	private TextView textview17;
	private LinearLayout linear31;
	private ImageView imageview13;
	private ImageView imageview14;
	private ImageView imageview19;
	private LinearLayout linear33;
	private LinearLayout linear34;
	private CircleImageView circleimageview8;
	private LinearLayout linear35;
	private LinearLayout linear36;
	private TextView textview18;
	private TextView textview19;
	private TextView textview20;
	private TextView textview21;
	private LinearLayout linear37;
	private ImageView imageview15;
	private ImageView imageview16;
	private ImageView imageview20;
	private LinearLayout linear39;
	private LinearLayout linear40;
	private CircleImageView circleimageview9;
	private LinearLayout linear41;
	private LinearLayout linear42;
	private TextView textview22;
	private TextView textview23;
	private TextView textview24;
	private TextView textview25;
	private LinearLayout linear43;
	private ImageView imageview17;
	private ImageView imageview18;
	private TextView textview27;
	private TextView textview26;
	
	private Intent i = new Intent();
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.dedetails);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear5 = findViewById(R.id.linear5);
		vscroll1 = findViewById(R.id.vscroll1);
		imageview1 = findViewById(R.id.imageview1);
		textview28 = findViewById(R.id.textview28);
		linear6 = findViewById(R.id.linear6);
		khalid = findViewById(R.id.khalid);
		sagor = findViewById(R.id.sagor);
		rakhiul = findViewById(R.id.rakhiul);
		linear44 = findViewById(R.id.linear44);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		circleimageview7 = findViewById(R.id.circleimageview7);
		linear29 = findViewById(R.id.linear29);
		linear30 = findViewById(R.id.linear30);
		textview14 = findViewById(R.id.textview14);
		textview15 = findViewById(R.id.textview15);
		textview16 = findViewById(R.id.textview16);
		textview17 = findViewById(R.id.textview17);
		linear31 = findViewById(R.id.linear31);
		imageview13 = findViewById(R.id.imageview13);
		imageview14 = findViewById(R.id.imageview14);
		imageview19 = findViewById(R.id.imageview19);
		linear33 = findViewById(R.id.linear33);
		linear34 = findViewById(R.id.linear34);
		circleimageview8 = findViewById(R.id.circleimageview8);
		linear35 = findViewById(R.id.linear35);
		linear36 = findViewById(R.id.linear36);
		textview18 = findViewById(R.id.textview18);
		textview19 = findViewById(R.id.textview19);
		textview20 = findViewById(R.id.textview20);
		textview21 = findViewById(R.id.textview21);
		linear37 = findViewById(R.id.linear37);
		imageview15 = findViewById(R.id.imageview15);
		imageview16 = findViewById(R.id.imageview16);
		imageview20 = findViewById(R.id.imageview20);
		linear39 = findViewById(R.id.linear39);
		linear40 = findViewById(R.id.linear40);
		circleimageview9 = findViewById(R.id.circleimageview9);
		linear41 = findViewById(R.id.linear41);
		linear42 = findViewById(R.id.linear42);
		textview22 = findViewById(R.id.textview22);
		textview23 = findViewById(R.id.textview23);
		textview24 = findViewById(R.id.textview24);
		textview25 = findViewById(R.id.textview25);
		linear43 = findViewById(R.id.linear43);
		imageview17 = findViewById(R.id.imageview17);
		imageview18 = findViewById(R.id.imageview18);
		textview27 = findViewById(R.id.textview27);
		textview26 = findViewById(R.id.textview26);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		imageview13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.facebook.com/mrsilent55i?mibextid=ZbWKwL"));
				_openChrome();
				startActivity(i);
			}
		});
		
		imageview14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/m-k-khalid-mahamud-77473b2b9?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"));
				_openLinkedIn();
				startActivity(i);
			}
		});
		
		imageview19.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://github.com/mkkhalid5"));
				_openChrome();
				startActivity(i);
			}
		});
		
		imageview15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.facebook.com/aktaruzzaman.sagorhs/"));
				_openChrome();
				startActivity(i);
			}
		});
		
		imageview16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/md-aktaruzzaman-872485273/"));
				_openLinkedIn();
				startActivity(i);
			}
		});
		
		imageview20.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://github.com/AK329"));
				_openChrome();
				startActivity(i);
			}
		});
		
		imageview17.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.facebook.com/rakhiul6?mibextid=ZbWKwL"));
				_openChrome();
				startActivity(i);
			}
		});
		
		imageview18.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://www.linkedin.com/in/md-rakhiul-hasan-02071725a?utm_source=share&utm_campaign=share_via&utm_content=profile&utm_medium=android_app"));
				_openLinkedIn();
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		linear1.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
		_SetCornerRadius(khalid, 15, 5, "#FFFFFF");
		_SetCornerRadius(sagor, 15, 5, "#FFFFFF");
		_SetCornerRadius(rakhiul, 15, 5, "#FFFFFF");
	}
	
	public void _SetCornerRadius(final View _view, final double _radius, final double _shadow, final String _color) {
		
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable(); ab.setColor(Color.parseColor(_color)); ab.setCornerRadius((float) _radius); _view.setElevation((float) _shadow); _view.setBackground(ab); 
		
	}
	
	
	public void _openChrome() {
		i.setPackage("com.android.chrome");
	}
	
	
	public void _openLinkedIn() {
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.setPackage("com.linkedin.android");
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}