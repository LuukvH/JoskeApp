package software.laj.joskeapp;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;

public class SoundItemAdapter extends ArrayAdapter<SoundItem> {

    private Typeface typeface;
    private int resourceId;

    public SoundItemAdapter(Context context, int resourceId, ArrayList<SoundItem> sounditems) {
        super(context, resourceId, sounditems);
        this.resourceId = resourceId;

        // Use custom font
        typeface = ResourcesCompat.getFont(context, R.font.black_jack);
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