package com.ashcoding.cow.calf;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CreateShortcutActivity extends AppCompatActivity {

    // Take note. This class's launchMode is `singleTask`

    public static final String STRING_EXTRA = CreateShortcutActivity.class.getCanonicalName() + "STRING_EXTRA";

    public Button button1;
    public TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_shortcut);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String textViewString = "onCreate Intent:" + getIntent().toString() + " - Extra:" + getIntent().getStringExtra(STRING_EXTRA);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView1.setText(textViewString);

        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createShortcut();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        String textViewString = "onNewIntent Intent:" + getIntent().toString() + " - Extra:" + getIntent().getStringExtra(STRING_EXTRA);
        textView1.setText(textViewString);
    }

    public void createShortcut() {
        final Intent shortcutIntent = new Intent(this, CreateShortcutActivity.class);
        shortcutIntent.putExtra(STRING_EXTRA, "From Shortcut");

        final Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        // Sets the custom shortcut's title
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "Shortcut");
        // Set the custom shortcut icon
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(this, R.mipmap.ic_launcher));
        // Add the shortcut
        intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        sendBroadcast(intent);
    }

}
