package com.example.thomas.biosapp.Util;

import android.app.AlertDialog;
import android.content.Context;

import com.example.thomas.biosapp.R;

/**
 * Created by Julian on 27-3-2018.
 */

public class TicketDataValidator {

    private Context context;

    public TicketDataValidator(Context context) {
        this.context = context;
    }

    public boolean validate(String firstName, String lastName) {

        //Errors
        String errors = "";

        //Controleren of de gegevens zijn ingevuld
        if (firstName.length() == 0)

            errors += context.getString(R.string.firstname_notfilled) + "\n";

        if (lastName.length() == 0)

            errors += context.getString(R.string.lastname_notfilled) + "\n";

        //Controleren of error variabele leeg is
        if (errors.length() == 0) {

            //Goed
            return true;

        } else {

            //Eindbericht toevoegen
            errors += "\n" + context.getString(R.string.improve_feedback);

            //Fout, problemen weergeven
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(context.getString(R.string.feedback_error_title));
            builder.setMessage(errors);
            builder.setPositiveButton(context.getString(R.string.ok), null);
            AlertDialog dialog = builder.create();
            dialog.show();
            return false;
        }
    }
}
