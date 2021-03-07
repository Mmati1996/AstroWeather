package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.astrocalculator.AstroCalculator;
import com.astrocalculator.AstroDateTime;

import java.time.LocalDate;
import java.util.Date;

import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private OnFragmentInteractionListener mListener;

    public Tab1() {

        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }

    }

    TextView cl;
    int hh;
    int mm;
    int ss;
    Thread clock;
    Thread refresh;
    TextView val1,val2,val3,val4,val5,val6,val7,val8,val9,val10,val11,val12;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);



        val1 = (TextView) view.findViewById(R.id.val1);
        val2 = (TextView) view.findViewById(R.id.val2);
        val3 = (TextView) view.findViewById(R.id.val3);
        val4 = (TextView) view.findViewById(R.id.val4);
        val5 = (TextView) view.findViewById(R.id.val5);
        val6 = (TextView) view.findViewById(R.id.val6);
        val7 = (TextView) view.findViewById(R.id.val8);
        val8 = (TextView) view.findViewById(R.id.val9);
        val9 = (TextView) view.findViewById(R.id.val10);
        val10 = (TextView) view.findViewById(R.id.val11);
        val11 = (TextView) view.findViewById(R.id.val12);

        cl = (TextView) view.findViewById(R.id.clock);




        refresh = new Thread(){
            @Override
            public void run(){
                Date date = new Date();
                LocalDate localDate = LocalDate.now();
                AstroCalculator.Location location = new AstroCalculator.Location(Settings.x,Settings.y);
                AstroDateTime astroDateTime = new AstroDateTime(localDate.getYear(),localDate.getMonthValue(), localDate.getDayOfMonth(),
                        date.getHours(),date.getMinutes(),date.getSeconds(),0,true);
                AstroCalculator astroCalculator = new AstroCalculator(astroDateTime,location);
                val1.setText((astroCalculator.getSunInfo().getSunrise()).toString());
                val2.setText(((Double)astroCalculator.getSunInfo().getAzimuthRise()).toString());
                val3.setText((astroCalculator.getSunInfo().getSunset()).toString());
                val4.setText(((Double)astroCalculator.getSunInfo().getAzimuthSet()).toString());
                val5.setText(astroCalculator.getSunInfo().getTwilightEvening().toString());
                val6.setText(astroCalculator.getSunInfo().getTwilightMorning().toString());

                val7.setText(astroCalculator.getMoonInfo().getMoonrise().toString());
                val8.setText(astroCalculator.getMoonInfo().getMoonset().toString());
                val9.setText(astroCalculator.getMoonInfo().getNextNewMoon().toString());
                val10.setText(astroCalculator.getMoonInfo().getNextFullMoon().toString());
                val11.setText(((Double)((astroCalculator.getMoonInfo().getIllumination())*100)).toString()+"%");
                try{
                    sleep(1000*60*Settings.getR());
                }catch(Exception e){
                }


            }
        };
        refresh.start();



        clock = new Thread(){
            @Override
            public void run(){
                while(true){
                    Date date = new Date();
                    hh=date.getHours();
                    mm=date.getMinutes();
                    ss=date.getSeconds();
                    handler.sendMessage(new Message());
                    try{
                        sleep(1000);
                    }catch(Exception e){
                    }


                }
            }
        };
        clock.start();


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            cl.setText(((Integer)(hh)).toString()+":"+((Integer)(mm)).toString()+":"+((Integer)(ss)).toString());
        }

    };

}
