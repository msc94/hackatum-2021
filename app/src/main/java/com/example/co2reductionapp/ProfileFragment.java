package com.example.co2reductionapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.co2reductionapp.backend.Backend;
import com.example.co2reductionapp.backend.User;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ProfileFragment extends Fragment {
    private LinearLayout _linearLayout;
    private TextView _nameTextView;
    private ImageView _profilePictureImageView;
    private TextView _greenGemsTextView;
    private TextView _blueGemsTextView;

    public ProfileFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        List<User> users = Backend.getUsers(getResources());
        User me = users.get(0);

        // Update view
        _linearLayout = view.findViewById(R.id.profile_linearlayout);
        _nameTextView = view.findViewById(R.id.name_textview);
        _profilePictureImageView = view.findViewById(R.id.profile_picture_imageview);
        _greenGemsTextView = view.findViewById(R.id.green_gems_textview);
        _blueGemsTextView = view.findViewById(R.id.blue_gems_textview);

        FloatingActionButton fab = view.findViewById(R.id.add_activity_fab);
        fab.setOnClickListener(this::ShowCreateDialog);

        _nameTextView.setText(me.getName());
        _profilePictureImageView.setImageBitmap(me.getProfilePicture());
        _greenGemsTextView.setText(String.valueOf(me.getGreenGems()));
        _blueGemsTextView.setText(String.valueOf(me.getBlueGems()));
        _linearLayout.requestLayout();

        return view;
    }

    private void ShowCreateDialog(View view) {
        DialogFragment dialog = new CreateActivityDialog();
        dialog.show(getFragmentManager(), "createdialog");
    }
}