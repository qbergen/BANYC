package com.example.queenabergen.banyc.retrofit;

import android.support.v7.widget.RecyclerView;

import com.example.queenabergen.banyc.recyclerview.BusinessAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hyun on 2/4/17.
 */

public class BusinessCenter {

    private static List<String> description = new ArrayList<>();
    private static RecyclerView rview;

    public static void start(RecyclerView rv) {
        rview=rv;
        description.add("Students with limited English are taught by bilingual Mandarin speaking teachers in all core subjects and get extra support during Academic Intervention Services (AIS).");
        description.add("University Neighborhood Early College (UNEC) is designed for students interested in pursuing a career in business. UNEC provides rigorous curriculum with individualized academic supports, enabling students to earn a High School diploma and up to 24 college credits through City University of New York (CUNY) Baruch College within 4 years.");
        description.add("This is a four year program designed to develop our students' ability to compete in today's business market as professional, global, 21st century leaders. Our curriculum includes partnerships with Edelman, Zurich and NASDAQ that focus on competing in business programs, shadowing professionals and participating in workshops focused on professional skills development, all supported by courses focused on business, economics and entrepreneurship.");
        description.add("In-depth coursework in Economics and Finance, AP and college courses, Weill Institute with financial industry professionals providing seminars and internships, after-school and Saturday academic and extracurricular opportunities.");
        description.add("Analysis of business structures such as International Marketing, Computer Applications, Foreign Trade and Virtual Enterprise.");
        description.add("All students applying to the High School of Fashion Industries are required to audition for the school online at www.fashionhighschool.net or in person. The audition includes an admissions examination and submission of a portfolio for the program major(s) in which they are interested. Students may submit up to three portfolios (one for each program major of interest).");
        description.add("Business simulation program that allows students to operate their own virtual business on a global scale. Internships and mentorships in firms throughout New York City.");
        description.add("Through a focus on business administration and entrepreneurship, students prepare for success at competitive colleges and universities.");
        description.add("In addition to the Stand Alone ESL program, our school offers a Bilingual Education Program in Spanish.");
        description.add("Students are exposed to the foundational aspects of business and teaching via their advisory class and are then placed in either the Education or the Business track.");

        initializeAdapter();
    }

    private static void initializeAdapter() {

        BusinessAdapter adapter = new BusinessAdapter(description);
        rview.setAdapter(adapter);
    }
}
