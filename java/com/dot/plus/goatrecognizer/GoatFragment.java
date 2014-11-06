package com.dot.plus.goatrecognizer;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GoatFragment extends Fragment {
    Activity activity;

    public GoatFragment() {
    }

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        activity = a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_goat, container, false);

        boolean isUserAGoat;
        UserManager um = (UserManager) activity.getSystemService(Context.USER_SERVICE);;
        TextView tv = (TextView) rootView.findViewById(R.id.goat_detect);

        if (android.os.Build.VERSION.SDK_INT == 21) {
            isUserAGoat = um.isUserAGoat();
        } else {
            PackageManager pm = getActivity().getPackageManager();
            try {
                pm.getPackageInfo("com.coffeestainstudios.goatsimulator", PackageManager.GET_ACTIVITIES);
                isUserAGoat = true;
            } catch (PackageManager.NameNotFoundException e) {
                isUserAGoat = false;
            }
        }

        if (isUserAGoat) {
            tv.setText(getString(R.string.user_is_goat));
        } else {
            tv.setText(getString(R.string.user_is_not_goat));
        }

        return rootView;
    }
}
