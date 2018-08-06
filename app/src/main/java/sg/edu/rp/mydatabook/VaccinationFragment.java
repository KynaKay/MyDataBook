package sg.edu.rp.mydatabook;


import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VaccinationFragment extends Fragment {

    private TextView tvVac;
    private Button btnFragVac;

    public VaccinationFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.anniversaryfragment, container, false);
        btnFragVac = (Button)view.findViewById(R.id.btnFragAnn);
        tvVac = (TextView)view.findViewById(R.id.tvAnn);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        String anniversary = prefs.getString("", "");
        tvVac.setText(anniversary);

        btnFragVac.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout linearLayout = (LinearLayout)inflater.inflate(R.layout.dialog, null);
                final EditText etDialog = (EditText) linearLayout.findViewById(R.id.etDialog);

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setView(linearLayout)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                tvVac.setText(etDialog.getText().toString());
                                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
                                SharedPreferences.Editor editor = prefs.edit();
                                editor.putString("", etDialog.getText().toString());
                                editor.commit();
                            }
                        });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.vaccinationfragment, container, false);
    }

}
