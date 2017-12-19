package com.birjot.gndec_sports.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.birjot.gndec_sports.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class introduction extends Fragment {


    public introduction() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_introduction, container, false);


        WebView webView = (WebView) v.findViewById(R.id.webviewintro);

        WebView webViewtwo = (WebView) v.findViewById(R.id.webviewintrotwo);
/*
        WebView webViewthree = (WebView) v.findViewById(R.id.webviewintrothree);*/

        String text = "   The Sports Department was established in 1956"+
                "with the aim to inculcate sports culture among staff"+
                "and students of the college. Guided by Guru Nanak"+
                "Dev Jis values and our commitment to diversity,"+
                "we are leading sports department that inspires"+
                "the student by fostering healthy lifestyles through"+
                "involvement in physical education and sports"+
                "activities that cultivate lifelong health."+
                ""+
                "Our institute prepares student to face rapidly"+
                ""+
                "changing world with confidence and a sense of"+
                "responsibility to make the world a better place."+
                "To that end, the sports department views its"+
                "interaction with students through physical education"+
                "programmes that help them discover, develop and"+
                "test their skills to create a positive change."+
                ""+
                "We provide adequate environment, infrastructure"+
                "to persue sports activities and provide playing"+
                "opportunities to the wide range of students" +
                "regardless of the gender or cultural backgrounds."+
                "The department simultaneously prepare teams for"+
                "inter-college and inter-varsity competition. Various"+
                "tournaments / meet, intramural activity are organized"+
                "throughout the session."+
                ""+
                "The campus intramural sports component"+
                "strives to provide a variety of opportunities that"+
                "contribute to and promote the six dimensions of"+
                "wellness: physical, emotional, social, spiritual,"+
                "intellectual and environmental. We are dedicated"+
                "to make intramural part of campus life. Our goal is"+
                "to continuously create and provide a competitive,"+
                "safe and enjoyable atmosphere that encourages"+
                "teamwork, leadership development as well as"+
                "lifelong pattern of positive activity.";

        String texttwo ="Promoting the personal and professional development of student at par international standards through designing and implementing programs that support healthy lifestyles and academic success.";

        /*        String textthree ="\\u2022  To honor academic mission of the college by promoting general welfare of the students.\n" +
                        "\n" +
                        "        \\u2022  To promote physical activity and help individuals enhance their health, fitness and quality of life.\n" +
                        "\n" +
                        "        \\u2022  To develop state of art infrastructure of international standard.\n" +
                        "\n" +
                        "        \\u2022  To develop overall personality of the students with focus on core values like teamwork, respect, integrity, balance, humility, accountability, sportsmanship.\n" +
                        "\n" +
                        "        \\u2022  To inculcate moral, ethical and spiritual values through intramural and extramural activities.\n" +
                        "\n" +
                        "        \\u2022  To engage the mind, to elevate the spirit and stimulate the best effort of all who are associated with the college.";
*/

        webView.loadData("<p style=\"text-align:justify\">"+ text + "</p>", "text/html" , "UTF-8");

        webViewtwo.loadData("<p style=\"text-align:justify\">"+ texttwo + "</p>", "text/html" , "UTF-8");
/*
        webViewthree.loadData("<p style=\"text-align:justify\">"+ textthree + "</p>", "text/html" , "UTF-8");*/

        return v;
    }
}


