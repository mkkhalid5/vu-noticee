package vu.edu.bd;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.os.Vibrator;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout nonet;
	private LinearLayout main;
	private LinearLayout developer;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview1;
	private MaterialButton materialbutton1;
	private ListView scroll;
	private LinearLayout linear3;
	private ProgressBar progressbar1;
	private LinearLayout home;
	private LinearLayout noti;
	private LinearLayout profile;
	private ImageView h1;
	private TextView h2;
	private ImageView h3;
	private TextView h4;
	private ImageView h5;
	private TextView h6;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_home_d;
	private LinearLayout _drawer_profile_d;
	private LinearLayout _drawer_noti_d;
	private LinearLayout _drawer_repbug;
	private LinearLayout _drawer_dedetail;
	private LinearLayout _drawer_logout;
	private LinearLayout _drawer_linear10;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear20;
	private LinearLayout _drawer_linear19;
	private LinearLayout _drawer_linear18;
	private LinearLayout _drawer_linear17;
	private ImageView _drawer_imageview14;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview13;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview8;
	private TextView _drawer_textview1;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview7;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview8;
	private ImageView _drawer_imageview6;
	private TextView _drawer_textview9;
	private ImageView _drawer_imageview7;
	private TextView _drawer_textview10;
	private TextView _drawer_textview3;
	
	private AlertDialog.Builder d;
	private TimerTask t;
	private Intent i = new Intent();
	private Vibrator v;
	private DatabaseReference Home = _firebase.getReference("home");
	private ChildEventListener _Home_child_listener;
	private RequestNetwork reqnet;
	private RequestNetwork.RequestListener _reqnet_request_listener;
	private FirebaseAuth fauth;
	private OnCompleteListener<AuthResult> _fauth_create_user_listener;
	private OnCompleteListener<AuthResult> _fauth_sign_in_listener;
	private OnCompleteListener<Void> _fauth_reset_password_listener;
	private OnCompleteListener<Void> fauth_updateEmailListener;
	private OnCompleteListener<Void> fauth_updatePasswordListener;
	private OnCompleteListener<Void> fauth_emailVerificationSentListener;
	private OnCompleteListener<Void> fauth_deleteUserListener;
	private OnCompleteListener<Void> fauth_updateProfileListener;
	private OnCompleteListener<AuthResult> fauth_phoneAuthListener;
	private OnCompleteListener<AuthResult> fauth_googleSignInListener;
	
	private Calendar c = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		nonet = findViewById(R.id.nonet);
		main = findViewById(R.id.main);
		developer = findViewById(R.id.developer);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		textview1 = findViewById(R.id.textview1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		scroll = findViewById(R.id.scroll);
		linear3 = findViewById(R.id.linear3);
		progressbar1 = findViewById(R.id.progressbar1);
		home = findViewById(R.id.home);
		noti = findViewById(R.id.noti);
		profile = findViewById(R.id.profile);
		h1 = findViewById(R.id.h1);
		h2 = findViewById(R.id.h2);
		h3 = findViewById(R.id.h3);
		h4 = findViewById(R.id.h4);
		h5 = findViewById(R.id.h5);
		h6 = findViewById(R.id.h6);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_home_d = _nav_view.findViewById(R.id.home_d);
		_drawer_profile_d = _nav_view.findViewById(R.id.profile_d);
		_drawer_noti_d = _nav_view.findViewById(R.id.noti_d);
		_drawer_repbug = _nav_view.findViewById(R.id.repbug);
		_drawer_dedetail = _nav_view.findViewById(R.id.dedetail);
		_drawer_logout = _nav_view.findViewById(R.id.logout);
		_drawer_linear10 = _nav_view.findViewById(R.id.linear10);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear20 = _nav_view.findViewById(R.id.linear20);
		_drawer_linear19 = _nav_view.findViewById(R.id.linear19);
		_drawer_linear18 = _nav_view.findViewById(R.id.linear18);
		_drawer_linear17 = _nav_view.findViewById(R.id.linear17);
		_drawer_imageview14 = _nav_view.findViewById(R.id.imageview14);
		_drawer_textview12 = _nav_view.findViewById(R.id.textview12);
		_drawer_imageview12 = _nav_view.findViewById(R.id.imageview12);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_imageview13 = _nav_view.findViewById(R.id.imageview13);
		_drawer_textview13 = _nav_view.findViewById(R.id.textview13);
		_drawer_imageview8 = _nav_view.findViewById(R.id.imageview8);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_imageview6 = _nav_view.findViewById(R.id.imageview6);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		_drawer_imageview7 = _nav_view.findViewById(R.id.imageview7);
		_drawer_textview10 = _nav_view.findViewById(R.id.textview10);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		d = new AlertDialog.Builder(this);
		v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
		reqnet = new RequestNetwork(this);
		fauth = FirebaseAuth.getInstance();
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		noti.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NotificationActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_Home_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				maplist.add((int)0, _childValue);
				scroll.setAdapter(new ScrollAdapter(maplist));
				((BaseAdapter)scroll.getAdapter()).notifyDataSetChanged();
				linear3.setVisibility(View.GONE);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		Home.addChildEventListener(_Home_child_listener);
		
		_reqnet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				main.setVisibility(View.VISIBLE);
				nonet.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				main.setVisibility(View.GONE);
				nonet.setVisibility(View.VISIBLE);
			}
		};
		
		_drawer_home_d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_drawer_profile_d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NotificationActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_drawer_noti_d.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_drawer_repbug.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				v.vibrate((long)(200));
				SketchwareUtil.showMessage(getApplicationContext(), "coming 🔜");
			}
		});
		
		_drawer_dedetail.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), DedetailsActivity.class);
				startActivity(i);
				finish();
			}
		});
		
		_drawer_logout.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Log Out ?");
				d.setIcon(R.drawable.ic_help_black);
				d.setMessage("Are you want to log out ?");
				d.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.setClass(getApplicationContext(), MainActivity.class);
						startActivity(i);
						finish();
					}
				});
				d.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
				FirebaseAuth.getInstance().signOut();
			}
		});
		
		fauth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		fauth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		fauth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_fauth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_fauth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		h1.setAlpha((float)(1));
		h2.setAlpha((float)(1));
		h3.setAlpha((float)(0.5d));
		h4.setAlpha((float)(0.5d));
		h5.setAlpha((float)(0.5d));
		h6.setAlpha((float)(0.5d));
		h2.setVisibility(View.VISIBLE);
		h4.setVisibility(View.VISIBLE);
		h6.setVisibility(View.VISIBLE);
		_hide_scroll_bar(scroll);
		scroll.setAdapter(new ScrollAdapter(maplist));
		((BaseAdapter)scroll.getAdapter()).notifyDataSetChanged();
		setTitle("VU Notice");
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						reqnet.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "get", _reqnet_request_listener);
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(500));
		if (SketchwareUtil.isConnected(getApplicationContext())) {
			main.setVisibility(View.VISIBLE);
			nonet.setVisibility(View.GONE);
		}
		else {
			main.setVisibility(View.GONE);
			nonet.setVisibility(View.VISIBLE);
		}
	}
	
	@Override
	public void onBackPressed() {
		d.setMessage("What do you want?");
		d.setIcon(R.drawable.ic_help_black);
		d.setTitle("Exit App");
		d.setPositiveButton("Exit?", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finish();
			}
		});
		d.setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				
			}
		});
		d.create().show();
	}
	public void _hide_scroll_bar(final View _scroll) {
		scroll.setVerticalScrollBarEnabled(false);
		scroll.setHorizontalScrollBarEnabled(false);
	}
	
	
	public void _SetCornerRadius(final View _view, final double _radius, final double _shadow, final String _color) {
		
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable(); ab.setColor(Color.parseColor(_color)); ab.setCornerRadius((float) _radius); _view.setElevation((float) _shadow); _view.setBackground(ab); 
		
	}
	
	
	public void _openChrome() {
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.setPackage("com.android.chrome");
	}
	
	
	public void _openLinkedIn() {
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		i.setPackage("com.linkedin.android");
	}
	
	public class ScrollAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public ScrollAdapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.notice, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView Date = _view.findViewById(R.id.Date);
			final TextView notice = _view.findViewById(R.id.notice);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			if (_data.get((int)_position).get("banner").toString().equals("")) {
				imageview1.setVisibility(View.GONE);
			}
			else {
				imageview1.setVisibility(View.VISIBLE);
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("banner").toString())).into(imageview1);
			}
			textview4.setText(_data.get((int)_position).get("date").toString());
			notice.setText(_data.get((int)_position).get("notices").toString());
			Date.setText(_data.get((int)_position).get("title").toString());
			
			return _view;
		}
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