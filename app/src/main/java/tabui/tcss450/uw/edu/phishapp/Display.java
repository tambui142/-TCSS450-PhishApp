package tabui.tcss450.uw.edu.phishapp;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;



public class Display extends Fragment{

    String username, password;
    public Display(){
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_display,container,false);
        username = getArguments().getString("Username");
        password = getArguments().getString("Password");

        updateContent(v,username,password);
        return v;
    }

    public void updateContent(View v, String email, String password){
        TextView tvUsername = v.findViewById(R.id.view_username);
        tvUsername.setText(username);
        TextView tvPassword = v.findViewById(R.id.view_password);
        tvPassword.setText(password);

    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_display);
//
//        //Get the Intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String usernameLogin = intent.getStringExtra(UserLogin.EXTRA_MYUSERNAME);
//        //Capture the layout's TextView and set the string as its text
//        TextView viewUsername = findViewById(R.id.view_username);
//        viewUsername.setText(usernameLogin);
//    }
}
