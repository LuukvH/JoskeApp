package software.laj.joskeapp;

public class SoundItem {

    int stringResId;
    int soundResId;
    int imageResID;

    public SoundItem(int stringResId, int soundResId, int imageResId){
        this.stringResId = stringResId;
        this.soundResId = soundResId;
        this.imageResID = imageResId;
    }

    public int getStringResId() {
        return stringResId;
    }

    public int getSoundResId() {
        return soundResId;
    }

    public int getImageResID() {
        return imageResID;
    }
}