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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import de.hdodenhof.circleimageview.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ProfileActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> m = new HashMap<>();
	private String name = "";
	private String email = "";
	private String number = "";
	private String usern = "";
	private String dob = "";
	
	private LinearLayout linear1;
	private LinearLayout nonet;
	private LinearLayout profiles;
	private LinearLayout developer;
	private LinearLayout linear5;
	private ImageView imageview1;
	private TextView textview2;
	private TextView textview1;
	private MaterialButton materialbutton1;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private LinearLayout linear13;
	private LinearLayout updbutton;
	private LinearLayout linear12;
	private ImageView imageview3;
	private LinearLayout linear7;
	private TextView textview3;
	private CircleImageView circleimageview1;
	private TextView username;
	private TextView usermail;
	private EditText usmail;
	private EditText usphone;
	private EditText usname;
	private EditText usdob;
	private TextView textview6;
	private TextView textview7;
	private LinearLayout home;
	private LinearLayout noti;
	private LinearLayout profile;
	private ImageView h1;
	private TextView h2;
	private ImageView h3;
	private TextView h4;
	private ImageView h5;
	private TextView h6;
	
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
	
	private DatabaseReference fdb = _firebase.getReference("users");
	private ChildEventListener _fdb_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		nonet = findViewById(R.id.nonet);
		profiles = findViewById(R.id.profiles);
		developer = findViewById(R.id.developer);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		textview1 = findViewById(R.id.textview1);
		materialbutton1 = findViewById(R.id.materialbutton1);
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		linear11 = findViewById(R.id.linear11);
		linear13 = findViewById(R.id.linear13);
		updbutton = findViewById(R.id.updbutton);
		linear12 = findViewById(R.id.linear12);
		imageview3 = findViewById(R.id.imageview3);
		linear7 = findViewById(R.id.linear7);
		textview3 = findViewById(R.id.textview3);
		circleimageview1 = findViewById(R.id.circleimageview1);
		username = findViewById(R.id.username);
		usermail = findViewById(R.id.usermail);
		usmail = findViewById(R.id.usmail);
		usphone = findViewById(R.id.usphone);
		usname = findViewById(R.id.usname);
		usdob = findViewById(R.id.usdob);
		textview6 = findViewById(R.id.textview6);
		textview7 = findViewById(R.id.textview7);
		home = findViewById(R.id.home);
		noti = findViewById(R.id.noti);
		profile = findViewById(R.id.profile);
		h1 = findViewById(R.id.h1);
		h2 = findViewById(R.id.h2);
		h3 = findViewById(R.id.h3);
		h4 = findViewById(R.id.h4);
		h5 = findViewById(R.id.h5);
		h6 = findViewById(R.id.h6);
		d = new AlertDialog.Builder(this);
		reqnet = new RequestNetwork(this);
		fauth = FirebaseAuth.getInstance();
		
		updbutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "coming soon....");
			}
		});
		
		linear12.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Log out ?");
				d.setIcon(R.drawable.ic_help_black);
				d.setMessage("are you want to logout?");
				d.setPositiveButton("yes", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						FirebaseAuth.getInstance().signOut();
						i.setClass(getApplicationContext(), MainActivity.class);
						startActivity(i);
						finish();
					}
				});
				d.setNeutralButton("no", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
				finish();
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
				_timer.schedule(t, (int)(100));
			}
		});
		
		noti.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								i.setClass(getApplicationContext(), NotificationActivity.class);
								startActivity(i);
								finish();
							}
						});
					}
				};
				_timer.schedule(t, (int)(100));
			}
		});
		
		h5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		_reqnet_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				profiles.setVisibility(View.VISIBLE);
				nonet.setVisibility(View.GONE);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				profiles.setVisibility(View.GONE);
				nonet.setVisibility(View.VISIBLE);
			}
		};
		
		_fdb_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				number = _childValue.get("number").toString();
				username.setText(number);
				usermail.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());
				usmail.setText(number);
				usmail.setEnabled(false);
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
		fdb.addChildEventListener(_fdb_child_listener);
		
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
		profiles.setBackgroundDrawable(getResources().getDrawable(R.drawable.background));
		h1.setAlpha((float)(0.5d));
		h2.setAlpha((float)(0.5d));
		h3.setAlpha((float)(0.5d));
		h4.setAlpha((float)(0.5d));
		h5.setAlpha((float)(1));
		h6.setAlpha((float)(1));
		h2.setVisibility(View.VISIBLE);
		h4.setVisibility(View.VISIBLE);
		h6.setVisibility(View.VISIBLE);
		setTitle("Profile ");
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
			profiles.setVisibility(View.VISIBLE);
			nonet.setVisibility(View.GONE);
		}
		else {
			profiles.setVisibility(View.GONE);
			nonet.setVisibility(View.VISIBLE);
		}
		_SetCornerRadius(linear9, 15, 10, "#FFFFFF");
		_SetCornerRadius(linear10, 15, 10, "#FFFFFF");
		_SetCornerRadius(linear11, 15, 10, "#FFFFFF");
		_SetCornerRadius(linear12, 15, 10, "#FFFFFF");
		_SetCornerRadius(linear13, 15, 10, "#FFFFFF");
		_SetCornerRadius(updbutton, 15, 10, "#85FC8585");
		_SetCornerRadius(linear12, 15, 10, "#85FC8585");
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