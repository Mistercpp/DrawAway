package com.example.app;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;




public class MainActivity extends ActionBarActivity {
    GeometryLayer calque;
    String figure;
    Spinner listForm = null;
    private Button btnValider;
    EditText largeur;
    EditText hauteur;



    //share all informations with other classes (public static variables)
    public static int X, Y;
    public static int figureSize;

    private AdapterView.OnItemSelectedListener figureSelected;
    {
        figureSelected = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                figure = getResources().getStringArray(R.array.form_array)[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
    }

    private void initAvailableForms() {
        Spinner spinner = (Spinner) findViewById(R.id.spin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.form_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        //create the listeners
        spinner.setOnItemSelectedListener(figureSelected);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initialize variables of the class
        X =0;
        Y =0;
        figureSize = 50+10;

        //get the View
        calque  = (GeometryLayer)findViewById(R.id.calque_dessin);

       //initialize the array of figures
       initAvailableForms();

        //initilize touch event
        final View touchView = findViewById(R.id.calque_dessin);
        touchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                //get informations
                int Xpos = (int) motionEvent.getX();
                int Ypos = (int) motionEvent.getY();

                TextView Xtext = (TextView)findViewById(R.id.x);
                Xtext.setText("X : "+Xpos);
                X = Xpos;
                TextView Ytext = (TextView)findViewById(R.id.y);
                Ytext.setText("Y : "+Ypos);
                Y = Ypos;

                view.getId();

                return true;
            }
        });
    }




    public void DrawFigure(View v) {
        largeur = (EditText)findViewById(R.id.largeur);
        hauteur = (EditText)findViewById(R.id.hauteur);
        int ilargeur = Integer.parseInt(largeur.getText().toString());
        int ihauteur = Integer.parseInt(hauteur.getText().toString());
        Figure form;

        if (figure.equals("Rectangle")) {
            form = new Rectangle(ilargeur,ihauteur,X,Y);
            form.setX(X);
            form.setY(Y);
            calque.addFigure(form);
        } else if (figure.equals("Cercle")) {
            form = new Circle(X,Y,ihauteur);
            form.setX(X);
            form.setY(Y);
            calque.addFigure(form);
        } else if (figure.equals("Triangle")) {
            form = new Triangle(X, Y);
            form.setX(X);
            form.setY(Y);
            calque.addFigure(form);
        }

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



    public void onRaz(View view) {
        calque.cleanSlate();
    }



}
