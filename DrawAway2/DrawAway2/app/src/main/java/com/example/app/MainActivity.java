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

    public static boolean boolDessin = false;


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

                //Coordonnées optenuent du tactile
                int Xpos = (int) motionEvent.getX();
                int Ypos = (int) motionEvent.getY();

                int ilargeur = 0;
                int ihauteur = 0;

                if(boolDessin == true){
                    //Coordonnées taper
                    largeur = (EditText)findViewById(R.id.largeur);
                    hauteur = (EditText)findViewById(R.id.hauteur);
                    ilargeur = Integer.parseInt(largeur.getText().toString());
                    ihauteur = Integer.parseInt(hauteur.getText().toString());
                }


            if (figure.equals("Rectangle")) {
                if(boolDessin == true){
                    Figure form;
                    form = new Rectangle(ilargeur,ihauteur,Xpos,Ypos);
                    form.setX(Xpos);
                    form.setY(Ypos);
                    calque.addFigure(form);
                    boolDessin = false;
                }
            }else if (figure.equals("Cercle")) {
                if(boolDessin == true){
                    Figure form;
                    form = new Circle(Xpos,Ypos,ihauteur);
                    form.setX(Xpos);
                    form.setY(Ypos);
                    calque.addFigure(form);
                    boolDessin = false;
                }
            } else if (figure.equals("Triangle")) {
                if(boolDessin == true){
                    Figure form;
                    form = new Triangle(Xpos, Ypos,ilargeur,ihauteur);
                    form.setX(Xpos);
                    form.setY(Ypos);
                    calque.addFigure(form);
                    boolDessin = false;
                }
            }

                view.getId();

                return true;
            }
        });
    }




    public void DrawFigure(View v) {

        //On passe le booleen a vrai et on donne le droit de dessiner
        boolDessin = true;

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
