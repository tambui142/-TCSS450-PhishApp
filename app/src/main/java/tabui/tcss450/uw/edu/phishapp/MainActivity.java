package tabui.tcss450.uw.edu.phishapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements UserLogin.OnFragmentInteractionListener,
        UserRegister.OnFragmentInteractionListener {

    //EditText mail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if(savedInstanceState == null) {
            if (findViewById(R.id.fragment_main) != null) {
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.fragment_main, new UserLogin())
                        .commit();
            }
        }
    }

    @Override
    public void onFragmentInteractionLogin(String email, String password) {
        Display display;

        display = new Display();
        Bundle args = new Bundle();
        args.putSerializable("Email", email);
        args.putSerializable("Password", password);
        display.setArguments(args);
        FragmentTransaction transaction = getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_main, display)
                .addToBackStack(null);
        // Commit the transaction
        transaction.commit();

    }

    @Override
    public void onFragmentInteractionRegister() {

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, new UserRegister())
                .commit();
    }


    @Override
    public void onFragmentInteraction(String username, String password) {
        Display display;

        display = new Display();
        Bundle args = new Bundle();
        args.putSerializable("Username", username);
        args.putSerializable("Password", password);
        display.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_main, display)
                .commit();

    }

}
