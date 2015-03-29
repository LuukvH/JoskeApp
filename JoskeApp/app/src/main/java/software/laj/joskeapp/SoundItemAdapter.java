package software.laj.joskeapp;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luuk on 29-3-2015.
 */
public class SoundItemAdapter extends ArrayAdapter<SoundItem> {

    private Typeface typeface;
    private int resourceId;

    public SoundItemAdapter(Context context, int resourceId, ArrayList<SoundItem> sounditems) {
        super(context, resourceId, sounditems);
        this.resourceId = resourceId;

        // Use font from asset
        typeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/black_jack.ttf");
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(resourceId, parent, false);

        SoundItem soundItem = super.getItem(position);

        TextView label = (TextView) itemView.findViewById(R.id.label);
        ImageView icon = (ImageView) itemView.findViewById(R.id.icon);

        if (label != null) {
            label.setTypeface(typeface, Typeface.BOLD);
            label.setText(soundItem.getStringResId());
        }

        if (icon != null) {
            icon.setImageResource(soundItem.imageResID);
        }

        return itemView;
    }
}