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
        description.add("A program to develop the skills necessary for positions in the growing information technology and business industries. Students assume corporate roles and gain practical experience by applying skills and techniques learned in real world situations.");
        description.add("Students learn about the arts through hands-on experience, written work and art creation. Field trips take advantage of the rich cultural environment of New York City. Students visit art galleries and museums and attend dramatic productions both on and off Broadway. Students also learn the business end of promoting music, drama, creative writing and visual arts through direct involvement in hands-on projects taking place at concerts, art galleries, poetry slams and play productions.");
        description.add("College & career preparatory program for careers related to the business and finance sectors; curriculum developed by the National Academy Foundation (NAF); receives support from corporate partners.");
        description.add("The Business and Technology Institute offers dedicated students a concentration in introductory business and computer science courses. This three year sequence includes project based explorations of business and management structures and an introduction to computer science. Included in this sequence are courses in web design, coding, programming and computer data anaylsis.");
        description.add("An interdisciplinary program combining business and technology courses with a real hands-on working experience. The curriculum includes courses directed towards completing professional and academic certifications.");
        description.add("Business courses including accounting, career and financial management, computer repair, entrepreneurship, and graphic arts");
        description.add("Virtual Enterprise (VE) is a simulated business that is set up and run by students with the guidance of a teacher/facilitator and a business partner. Students will understand how employees, work-group teams and departments interact with each other and work together for the goal of the company.");
        description.add("Accounting, Electronic Information Processing, Desktop Publishing, Web Page Design, e-commerce, Microsoft Office certification training.");

        initializeAdapter();
    }

    private static void initializeAdapter() {

        BusinessAdapter adapter = new BusinessAdapter(description);
        rview.setAdapter(adapter);
    }
}
