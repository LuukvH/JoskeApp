package software.laj.joskeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gv_sounds = (GridView) findViewById(R.id.gv_sounds);
        gv_sounds.setAdapter(new SoundItemAdapter(getApplicationContext(), R.layout.sounditem_layout, SoundItemFactory.create()));

        gv_sounds.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SoundItem soundItem = (SoundItem)parent.getItemAtPosition(position);

                mediaPlayer = MediaPlayer.create(getApplicationContext(), soundItem.getSoundResId());
                mediaPlayer.start();
            }
        });
    }
}