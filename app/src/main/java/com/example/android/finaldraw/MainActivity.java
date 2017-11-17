package com.example.android.finaldraw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity  {
    Spinner spinner;
    ArrayList<String> pot1=new ArrayList<>();
    ArrayList<String> pot2=new ArrayList<>();
    ArrayList<String> pot3=new ArrayList<>();
    ArrayList<String> pot4=new ArrayList<>();
    ArrayList<String> Africa=new ArrayList<>();
    ArrayList<String> Asia=new ArrayList<>();
    ArrayList<String> N_C_America_Caribbean=new ArrayList<>();
    ArrayList<String> South_America=new ArrayList<>();
    ArrayList<String> Europe=new ArrayList<>();
    String TeamPot1,TeamPot2,TeamPot3,TeamPot4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setPotTeams();
        setTeamConfederation();

        Button viewTheTeam=(Button)findViewById(R.id.viewTheTeam);

        spinner = (Spinner) findViewById(R.id.sort_by_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planets_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        viewTheTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
                /*Toast.makeText(MainActivity.this,"Team is "+ String.valueOf(spinner.getSelectedItem()),Toast.LENGTH_SHORT).show(); */
                String Team=String.valueOf(spinner.getSelectedItem());
                String Federation=whichFederation(Team);
               if(pot1.contains(Team)){
                    //Toast.makeText(MainActivity.this, Federation, Toast.LENGTH_SHORT).show();
                    TeamPot1=Team;
                    TeamPot2=ChooseTeam(Federation);
                    TeamPot3=ChooseTeam(Federation,whichFederation(TeamPot2));
                    TeamPot4=ChooseTeam(Federation,whichFederation(TeamPot2),whichFederation(TeamPot3));
                    Toast.makeText(MainActivity.this, whichFederation(TeamPot1)+"\n"+whichFederation(TeamPot2)+"\n"+whichFederation(TeamPot3)+"\n"+whichFederation(TeamPot4), Toast.LENGTH_LONG).show();

                }else if (pot2.contains(Team)){
                    //Toast.makeText(MainActivity.this, Federation, Toast.LENGTH_SHORT).show();
                    TeamPot2=Team;
                   TeamPot1=ChooseTeam(Federation);
                   TeamPot3=ChooseTeam(Federation,whichFederation(TeamPot2));
                   TeamPot4=ChooseTeam(Federation,whichFederation(TeamPot2),whichFederation(TeamPot3));
                   Toast.makeText(MainActivity.this, whichFederation(TeamPot1)+"\n"+whichFederation(TeamPot2)+"\n"+whichFederation(TeamPot3)+"\n"+whichFederation(TeamPot4), Toast.LENGTH_LONG).show();
                }else if (pot3.contains(Team)){
                    //Toast.makeText( MainActivity.this, Federation, Toast.LENGTH_SHORT).show();
                    TeamPot3=Team;

                   TeamPot1=ChooseTeam(Federation);
                   TeamPot2=ChooseTeam(Federation,whichFederation(TeamPot2));
                   TeamPot4=ChooseTeam(Federation,whichFederation(TeamPot2),whichFederation(TeamPot3));
                   Toast.makeText(MainActivity.this, whichFederation(TeamPot1)+"\n"+whichFederation(TeamPot2)+"\n"+whichFederation(TeamPot3)+"\n"+whichFederation(TeamPot4), Toast.LENGTH_LONG).show();
               }else if (pot4.contains(Team)){
                    //Toast.makeText(MainActivity.this, Federation, Toast.LENGTH_SHORT).show();
                   TeamPot4=Team;
                   TeamPot1=ChooseTeam(Federation);
                   TeamPot2=ChooseTeam(Federation,whichFederation(TeamPot1));
                   TeamPot3=ChooseTeam(Federation,whichFederation(TeamPot1),whichFederation(TeamPot2));
                   Toast.makeText(MainActivity.this, whichFederation(TeamPot1)+"\n"+whichFederation(TeamPot2)+"\n"+whichFederation(TeamPot3)+"\n"+whichFederation(TeamPot4), Toast.LENGTH_SHORT).show();
               }
            }
        });
    }

    private String ChooseTeam(String TeamFederation, String TeamFederation2, String TeamFederation3) {
        Random rand = new Random();
        String TeamSelected;
        while (true) {
            int value = rand.nextInt(8);
            TeamSelected= pot3.get(value);
            String TeamSelectedFedration=whichFederation(TeamSelected);
            if(TeamSelectedFedration != TeamFederation &&TeamSelectedFedration !=TeamFederation2 &&TeamSelectedFedration!=TeamFederation3){
                break;
            }
        }
        return TeamSelected;
    }

    private String ChooseTeam(String TeamFederation,String TeamFederation2) {
        Random rand = new Random();
        String TeamSelected;
        while (true) {
            int value = rand.nextInt(8);
            TeamSelected= pot3.get(value);
            String TeamSelectedFedration=whichFederation(TeamSelected);
            if(TeamSelectedFedration != TeamFederation &&TeamSelectedFedration !=TeamFederation2){
                break;
            }
        }
        return TeamSelected;
    }

    private void setTeamConfederation() {
        Africa.add("Egypt");
        Africa.add("Morocco");
        Africa.add("Nigeria");
        Africa.add("Senegal");
        Africa.add("Tunisia");
        Asia.add("Australia");
        Asia.add("Iran");
        Asia.add("Japan");
        Asia.add("Korea Republic");
        Asia.add("Saudi Arabia");
        N_C_America_Caribbean.add("Costa Rica");
        N_C_America_Caribbean.add("Mexico");
        N_C_America_Caribbean.add("Panama");
        South_America.add("Argentina");
        South_America.add("Brazil");
        South_America.add("Colombia");
        South_America.add("Peru");
        South_America.add("Uruguay");
        Europe.add("Russia");
        Europe.add("Germany");
        Europe.add("Portugal");
        Europe.add("Belgium");
        Europe.add("France");
        Europe.add("Poland");
        Europe.add("Iceland");
        Europe.add("Switzerland");
        Europe.add("Spain");
        Europe.add("England");
        Europe.add("Croatia");
        Europe.add("Sweden");
        Europe.add("Denmark");
        Europe.add("Serbia");
    }

    private void setPotTeams() {
        //set pot 1
        pot1.add("Russia") ;
        pot1.add("Germany");
        pot1.add("Brazil");
        pot1.add("Portugal");
        pot1.add("Argentina");
        pot1.add("Belgium");
        pot1.add("Poland");
        pot1.add("France");
        //set pot2
        pot2.add("Spain") ;
        pot2.add("Peru");
        pot2.add("Switzerland");
        pot2.add("England");
        pot2.add("Colombia");
        pot2.add("Mexico");
        pot2.add("Uruguay");
        pot2.add("Croatia");
        //set pot3
        pot3.add("Denmark") ;
        pot3.add("Iceland");
        pot3.add("Costa Rica");
        pot3.add("Sweden");
        pot3.add("Tunisia");
        pot3.add("Egypt");
        pot3.add("Senegal");
        pot3.add("Iran");
        //set pot4
        pot4.add("Serbia") ;
        pot4.add("Nigeria");
        pot4.add("Australia");
        pot4.add("Japan");
        pot4.add("Morocco");
        pot4.add("Panama");
        pot4.add("Korea Republic");
        pot4.add("Saudi Arabia");
    }

    private String whichFederation(String Team){
        if(Africa.contains(Team)){
            return "Africa";
        }else if(Asia.contains(Team)){
            return "Asia";
        }else if(Europe.contains(Team)){
            return "Europe";
        }else if(South_America.contains(Team)){
            return "South_America";
        }else if(N_C_America_Caribbean.contains(Team)){
            return "North, Central America and Caribbean";
        }else{
            return "Error in the name of the team ";
        }

    }

    private String ChooseTeam(String TeamFederation){
        Random rand = new Random();
        String TeamSelected;
        while (true) {
            int value = rand.nextInt(8);
            TeamSelected= pot2.get(value);
            String TeamSelectedFedration=whichFederation(TeamSelected);
            if(TeamSelectedFedration != TeamFederation){
                break;
            }
        }

        return TeamSelected;
    }

}
