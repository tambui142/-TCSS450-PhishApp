package tabui.tcss450.uw.edu.phishapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;



public class UserLogin extends Fragment{
    private OnFragmentInteractionListener mListener;

    EditText username, password;
    String usernameDisplay, passwordDisplay;
    Button bLogin, bRegister;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.activity_user_login, container, false);

        username = v.findViewById(R.id.username_login);
        password = v.findViewById(R.id.password_login);

        String tag = "myFirstFragment";
        Log.d(tag, "mail is null: " + (username == null));
        Log.d(tag, "password is null: " + (password == null));

        bLogin = (Button) v.findViewById(R.id.button_login);
        bLogin.setOnClickListener(view -> login());

        bRegister = (Button) v.findViewById(R.id.button_register);
        bRegister.setOnClickListener(view -> mListener.onFragmentInteractionRegister());
        return v;
    }

    public boolean login(){
        if (validUsername()) {
            mListener.onFragmentInteractionLogin(username.getText().toString(),password.getText().toString());
            return true;
        } else {
            return false;
        }

    }

    public boolean validUsername(){
        String user = username.getText().toString().trim();
        int length = password.getText().length();
        Log.d("VALIDUSERNAME", "username: " + user);
        if(user.isEmpty()){
            username.setError("Field Cannot be Empty");
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
            username.setError("Please enter vaild email");
            return false;
        } else if(length < 6 ){
            password.setError("Please enter more than 5 character");
            return false;
        } else {
            username.setError(null);
            return true;
        }

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteractionLogin(String username, String password);
        void onFragmentInteractionRegister();
    }


    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        bLogin = (Button) findViewById(R.id.button_login);
//        bLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(UserLogin.this, Display.class);
//                username = findViewById(R.id.username_login);
//                password = findViewById(R.id.password_login);
//
//                usernameDisplay = username.getText().toString();
//                passwordDisplay = password.getText().toString();
//
//                intent.putExtra(EXTRA_MYUSERNAME, usernameDisplay);
//                intent.putExtra(EXTRA_MYPASSWORD, passwordDisplay);
//            }
//        });
//
//        bRegister = (Button) findViewById(R.id.button_register);
//        bRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent registerIntent = new Intent(UserLogin.this, UserRegister.class);
//                UserLogin.this.startActivity(registerIntent);
//            }
//        });
//    }
}
