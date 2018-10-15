package tabui.tcss450.uw.edu.phishapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class UserRegister extends Fragment {
    private OnFragmentInteractionListener mListener;

    Button bRegister;
    EditText username, password, confirmPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_register, container, false);
        username = v.findViewById(R.id.register_username);
        password = v.findViewById(R.id.register_password);
        confirmPassword = v.findViewById(R.id.register_password_confirm);
        Log.d("REGISTER", "username is null: " + (username == null));
        Log.d("REGISTER", "password is null: " + (password == null));
        Log.d("REGISTER", "password confirm is null: " + (confirmPassword == null));

        bRegister = (Button) v.findViewById(R.id.button_user_register);
        bRegister.setOnClickListener(view -> login());
        return v;
    }
    public boolean login() {

        if (validUsername()) {
            mListener.onFragmentInteraction(username.getText().toString(), password.getText().toString());

            return true;
        } else {
            return false;
        }

    }

    public boolean validUsername(){
        String user= username.getText().toString().trim();
        int length = password.getText().length();
        String tag = "validEmail";
        if(user.isEmpty()){
            username.setError("Field Cannot be Empty");
            return false;
        } else if(!Patterns.EMAIL_ADDRESS.matcher(user).matches()) {
            username.setError("Please enter vaild email");
            return false;
        } else if(length < 6 ) {
            password.setError("Please enter more than 5 character");
            return false;
        } else if (!samePassword()){
            password.setError("Please enter same password");
            confirmPassword.setError("Please enter same password");
            return false;

        } else {
            username.setError(null);
            return true;
        }
    }
    public boolean samePassword(){
        boolean same = false;
        int length = password.getText().length();
        int length2 = confirmPassword.getText().length();
        if(length == length2) {
            for(int i= 0; i < length; i++){
                if (password.getText().charAt(i) == confirmPassword.getText().charAt(i)) {
                    same = true;
                }
            }

        }
        return same;
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
        void onFragmentInteraction(String username, String password);
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_user_register);
//        bRegister = (Button) findViewById(R.id.button_user_register);
//
//        bRegister.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(UserRegister.this, Display.class);
//
//                username = (EditText) findViewById(R.id.register_username);
//                password = (EditText) findViewById(R.id.register_password);
//                confirmPassword = (EditText) findViewById(R.id.register_password_confirm);
//                usernameRDisplay = username.getText().toString();
//                passwordRDisplay = password.getText().toString();
//                intent.putExtra(EXTRA_MYUSERNAMEREGISTER,usernameRDisplay);
//                intent.putExtra(EXTRA_MYPASSWORDREGISTER,passwordRDisplay);
//            }
//        });
//    }

}
