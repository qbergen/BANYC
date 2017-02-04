package com.example.queenabergen.banyc.sportsresources;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.queenabergen.banyc.R;

import java.util.ArrayList;
import java.util.List;

public class SportsRv extends Activity {

    private List<Sports> sport;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.sports_rv);

        rv = (RecyclerView) findViewById(R.id.sprts_rv);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        sport = new ArrayList<>();

        sport.add(new Sports("5050 Skatepark", "Athletic Program", "40.628039,-74.074661", "N/A", "Staten Island", "N/A", "4yr - Adult", "718-123-4567"));
        /*
        Address: 354 Front Street Staten Island NY 10304
        Website: http://www.5050skatepark.com/
        */

        sport.add(new Sports("92nd Street Y", "Athletic", "40.782934,-73.952515", "N/A", "Manhattan", "Sports", "0yr - Adult", "212-415-5714"));
                /*
                Address: 1395 Lexington Avenue New York NY 10128
                Website: http://www.92y.org/sports
                */


        sport.add(new Sports("A-Game Sports", "Athletic", "40.900443,-73.793853", "N/A", "New Rochelle", "N/A", "0yr - Adult", "914-278-9477"));
        /*
                Address: 856 Main Street New Rochelle NY NY 10801
                Website: http://www.agamesports.net/
                */

        sport.add(new Sports("Achilles Kids", "Athletic", "40.7515852,-73.9869758", "N/A", "Manhattan", "Walking/Disabilities", "0yr - 18yr", "212-354-0300"));
        /*
                Address: 42 West 38th Street, 4th Floor, New York, NY 10018
                Website: http://www.achillesinternational.org/achilles-kids/
                */

        sport.add(new Sports("Advantage Tennis Clubs", "Athletic", "40.75986,-73.994349", "N/A", "Manhattan", "Tennis", "4yr - 18yr", "212-594-0554"));
        /*
                Address: 450 West 43rd Street, NY, NY 10036
                Website:http://www.advantagetennisclubs.com/
                */

        sport.add(new Sports("Adventure Scuba", "Athletic", "40.779019,-73.945232", "N/A", "Manhattan", "Scuba", "11yr - Adult", "212-876-3483"));
        /*
                Address: 1737 York Avenue New York NY 10128
                Website: http://www.adventurescubany.com/
                */

        sport.add(new Sports("Al Oerter Recreation Center", "Athletic", "40.751389,-73.833723", "NYC Parks", "Queens", "Sports", "8yr - Adult", "(718) 353-7853"));
        /*
                Address: 131-40 Fowler Avenue Flushing NY 11355
                Website: http://www.nycgovparks.org/facilities/recreationcenters/Q099-NMD01
                */

        sport.add(new Sports("All Star Volleyball", "Athletic", "40.889211,-73.906251", "N/A", "Bronx", "Program", "11yr - 18yr", "347.494.3002"));
        /*
                Address: Fieldston Campus, 3901 Fieldston Road Bronx NY 10471
                Website: http://www.asvba.org/
                */

        sport.add(new Sports("Anderson’s Martial Arts Academy", "Athletic", "40.7184,-74.002496", "N/A", "Manhattan", "Martial Arts", "4yr - Adult", "888-478-9627"));
        /*
                Address: 394 Broadway, Ground Fl. New York NY 10013
                Website: www.andersonsmartialarts2-px.rtrk.com
                */

        sport.add(new Sports("APEX Age Group Swim Club", "Athletic", "Bronx", "N/A", "Bronx", "Swimming", "8yr - 18yr", "718-960-7123"));
        /*
                Address: 250 Bedford Park Boulevard Bronx NY 10468
                Website: http://www.lehman.edu/vpstud/apexathletics/uss_club/uss.html
                */

        sport.add(new Sports("Artistic Stitch Sports Complex", "Athletic", "40.702319,-73.884803", "N/A", "Glendale", "Sports", "4yr - 18yr", "718-416-1380"));
        /*
                Address: 79-08 Cooper Avenue Glendale NY 11385
                Website: http://www.artisticstitchsportscomplex.com/
                */

    }

    private void initializeAdapter() {
        SportsAdapter adapter = new SportsAdapter(sport);
        rv.setAdapter(adapter);
    }
}
