package ejemplo2.tse.myejemplo2;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by TSE on 14/05/2015.
 */
public class SendDataDialogFragment extends DialogFragment {

    public interface DialogListener{
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    DialogListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            listener = (DialogListener)activity;
        }catch (ClassCastException e){

        }
    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Titulo").setSingleChoiceItems(R.array.dialog_option,-1,null).setPositiveButton(R.string.msg_yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onDialogPositiveClick(SendDataDialogFragment.this);
            }
        });

        return builder.create();

    }
}
