package ejemplo2.tse.myejemplo2;

import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity implements SendDataDialogFragment.DialogListener {

    private boolean favorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * <p/>
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.</p>
     *
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to
     * proceed, true to consume it here.
     * @see #onCreateOptionsMenu
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch(item.getItemId()){
            case R.id.action_fav:
                Drawable icon = null;
                if(favorite){
                    icon = getResources().getDrawable(R.mipmap.ic_action_not_important);
                }else{
                    icon = getResources().getDrawable(R.mipmap.ic_action_important);
                }
                favorite = !favorite;
                item.setIcon(icon);
                return true;
            case R.id.action_share:
                Intent share = new Intent();
                String msg = getResources().getString(R.string.msg_share);
                share.putExtra(Intent.EXTRA_TEXT, msg);
                Uri img_res = Uri.parse("android.resource://" + getPackageName() + "/mipmap/" + R.mipmap.hotel1);
                // verificar esta parte ya que en el tuto esta drawble
                Log.e("TAG_ERROR",img_res.toString());
                share.putExtra(Intent.EXTRA_STREAM, img_res);
                share.setType("image/jpeg");
                startActivity(Intent.createChooser(share,"Compartir"));
                return true;
            case R.id.action_dialog:
                SendDataDialogFragment f = new SendDataDialogFragment();
                f.show(getFragmentManager(),"dialogo");
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void toggleClicked(View v){

        Log.e("TAG_TOO","toogle");

    }


    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Log.e("TAG","DIJO QUE SI");
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }
}




