package vu.edu.bd;

import android.animation.*;
import android.app.*;
import android.app.AlertDialog;
import android.content.*;
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
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class NotificationActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<String> list2 = new ArrayList<>();
	private ArrayList<String> list3 = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout nonet;
	private LinearLayout secnotic;
	private LinearLayout developer;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview1;
	private MaterialButton materialbutton1;
	private LinearLayout linear3;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private LinearLayout linear12;
	private LinearLayout linear11;
	private TextView textview3;
	private TextView sec;
	private Spinner spnsemi;
	private LinearLayout linear14;
	private LinearLayout linear13;
	private TextView textview4;
	private TextView sem;
	private Spinner spnsec;
	private ImageView imageview2;
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
	
	private Intent i = new Intent();
	private TimerTask t;
	private AlertDialog.Builder d;
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
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.notification);
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
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(NotificationActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear1 = findViewById(R.id.linear1);
		nonet = findViewById(R.id.nonet);
		secnotic = findViewById(R.id.secnotic);
		developer = findViewById(R.id.developer);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		textview1 = findViewById(R.id.textview1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		linear3 = findViewById(R.id.linear3);
		linear6 = findViewById(R.id.linear6);
		linear7 = findViewById(R.id.linear7);
		linear8 = findViewById(R.id.linear8);
		linear10 = findViewById(R.id.linear10);
		linear12 = findViewById(R.id.linear12);
		linear11 = findViewById(R.id.linear11);
		textview3 = findViewById(R.id.textview3);
		sec = findViewById(R.id.sec);
		spnsemi = findViewById(R.id.spnsemi);
		linear14 = findViewById(R.id.linear14);
		linear13 = findViewById(R.id.linear13);
		textview4 = findViewById(R.id.textview4);
		sem = findViewById(R.id.sem);
		spnsec = findViewById(R.id.spnsec);
		imageview2 = findViewById(R.id.imageview2);
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
		reqnet = new RequestNetwork(this);
		fauth = FirebaseAuth.getInstance();
		
		spnsemi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					sec.setText("1st");
				}
				if (_position == 1) {
					sec.setText("2nd");
				}
				if (_position == 2) {
					sec.setText("3rd");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		spnsec.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					sem.setText("A");
				}
				if (_position == 1) {
					sem.setText("B");
				}
				if (_position == 2) {
					sem.setText("C");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								i.setClass(getApplicationContext(), HomeActivity.class);
								startActivity(i);
								finish();
							}
						});
					}
				};
				_timer.schedule(t, (int)(10));
			}
		});
		
		profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								i.setClass(getApplicationContext(), ProfileActivity.class);
								startActivity(i);
								finish();
							}
						});
					}
				};
				_timer.schedule(t, (int)(10));
			}
		});
		
		_reqnet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				secnotic.setVisibility(View.VISIBLE);
				nonet.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				secnotic.setVisibility(View.GONE);
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
				d.setTitle("Log Out?");
				d.setIcon(R.drawable.ic_help_black);
				d.setMessage("Are you want to logout ?");
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
		secnotic.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
		h1.setAlpha((float)(0.5d));
		h2.setAlpha((float)(0.5d));
		h3.setAlpha((float)(1));
		h4.setAlpha((float)(1));
		h5.setAlpha((float)(0.5d));
		h6.setAlpha((float)(0.5d));
		h2.setVisibility(View.VISIBLE);
		h4.setVisibility(View.VISIBLE);
		h6.setVisibility(View.VISIBLE);
		setTitle("Section Notice ");
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
			secnotic.setVisibility(View.VISIBLE);
			nonet.setVisibility(View.GONE);
		}
		else {
			secnotic.setVisibility(View.GONE);
			nonet.setVisibility(View.VISIBLE);
		}
		_SetCornerRadius(linear7, 15, 10, "#FFFFFF");
		_SetCornerRadius(linear8, 15, 10, "#FFFFFF");
		_SetCornerRadius(linear10, 15, 10, "#FFFFFF");
		list.add("1st");
		list.add("2nd");
		list.add("3rd");
		spnsemi.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list));
		list2.add("  A  ");
		list2.add("  B  ");
		list2.add("  C  ");
		spnsec.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, list2));
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
	public void _SetCornerRadius(final View _view, final double _radius, final double _shadow, final String _color) {
		
		android.graphics.drawable.GradientDrawable ab = new android.graphics.drawable.GradientDrawable(); ab.setColor(Color.parseColor(_color)); ab.setCornerRadius((float) _radius); _view.setElevation((float) _shadow); _view.setBackground(ab); 
		
	}
	
	public class SpnsecAdapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public SpnsecAdapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.section, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			
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