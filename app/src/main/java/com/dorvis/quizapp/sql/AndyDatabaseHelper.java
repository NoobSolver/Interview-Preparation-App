package com.dorvis.quizapp.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.dorvis.quizapp.model.Question;
import com.dorvis.quizapp.model.Question2;
import com.dorvis.quizapp.model.Question3;
import com.dorvis.quizapp.model.Question4;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by sai on 15/2/18.
 */


public class AndyDatabaseHelper extends SQLiteOpenHelper {
    private static final String TAG = "AndyDatabaseHelper";
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "triviaQuiz.db";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    private static final String TABLE_JAVA = "java";
    private static final String TABLE_PYTHON = "python";
    private static final String TABLE_CPROGRAM= "cprogram";
    // Android Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c
    // Java Table Columns names
    private static final String JAVAKEY_ID = "id";
    private static final String JAVAKEY_QUES = "question";
    private static final String JAVAKEY_ANSWER = "answer"; //correct option
    private static final String JAVAKEY_OPTA= "opta"; //option a
    private static final String JAVAKEY_OPTB= "optb"; //option b
    private static final String JAVAKEY_OPTC= "optc"; //option c
    //python Table columns names
    private static final String PYTHONKEY_ID = "id";
    private static final String PYTHONKEY_QUES = "question";
    private static final String PYTHONKEY_ANSWER = "answer"; //correct option
    private static final String PYTHONKEY_OPTA= "opta"; //option a
    private static final String PYTHONKEY_OPTB= "optb"; //option b
    private static final String PYTHONKEY_OPTC= "optc"; //option c
    //cprogram table columns names
    private static final String CKEY_ID = "id";
    private static final String CKEY_QUES = "question";
    private static final String CKEY_ANSWER = "answer"; //correct option
    private static final String CKEY_OPTA= "opta"; //option a
    private static final String CKEY_OPTB= "optb"; //option b
    private static final String CKEY_OPTC= "optc"; //option c
    private SQLiteDatabase dbase;
    public AndyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = " CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " INTEGER, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);
        addAndroidQuestions();
        String sql2 = " CREATE TABLE IF NOT EXISTS " + TABLE_JAVA + " ( "
                + JAVAKEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + JAVAKEY_QUES
                + " TEXT, " + JAVAKEY_ANSWER+ " TEXT, "+JAVAKEY_OPTA +" TEXT, "
                +JAVAKEY_OPTB +" TEXT, "+JAVAKEY_OPTC+" TEXT)";
        db.execSQL(sql2);
       addJavaQuestions();

        String sql3 = " CREATE TABLE IF NOT EXISTS " + TABLE_PYTHON + " ( "
                + PYTHONKEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +PYTHONKEY_QUES
                + " TEXT, " + PYTHONKEY_ANSWER+ " TEXT, "+PYTHONKEY_OPTA +" TEXT, "
                +PYTHONKEY_OPTB +" TEXT, "+PYTHONKEY_OPTC+" TEXT)";
        db.execSQL(sql3);
        addPythonQuestions();

        String sql4 = " CREATE TABLE IF NOT EXISTS " + TABLE_CPROGRAM + " ( "
                + CKEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +CKEY_QUES
                + " TEXT, " + CKEY_ANSWER+ " TEXT, "+CKEY_OPTA +" TEXT, "
                +CKEY_OPTB +" TEXT, "+CKEY_OPTC+" TEXT)";
        db.execSQL(sql4);
        addCprogramQuestion();



        //db.close();
    }

    private void addAndroidQuestions()
    {
        Question a1=new Question("If permissions are missing the application will get this at runtime","Parser", "SQLiteOpenHelper ", "Security Exception", 3);
        this.addQuestion(a1);
        Question a2=new Question("An open source standalone database", "SQLite", "BackupHelper", "NetworkInfo", 1);
        this.addQuestion(a2);
        Question a3=new Question("Sharing of data in Android is done via?","Wi-Fi radio", "Service Content Provider","Ducking", 2);
        this.addQuestion(a3);
        Question a4=new Question("Main class through which your application can access location services on Android", "LocationManager", "AttributeSet", "SQLiteOpenHelper",1);
        this.addQuestion(a4);
        Question a5=new Question("How to pass the data between activities in Android?","Intent","Content Provider","Broadcast receiver",1);
        this.addQuestion(a5);
        Question a6=new Question("What are the functionalities in asyncTask in android?","onPostExecution()","OnGetExecution()","doInBackground()",3);
        this.addQuestion(a6);
        Question a7=new Question("How to store heavy structured data in android?","Shared Preferences","Sqlite Database","Cursor",2);
        this.addQuestion(a7);
        Question a8=new Question("Fragment in Android can be found through?","findByID()","findViewById()","findFragmentByID()",2);
        this.addQuestion(a8);
        Question a9=new Question("What are the return values of onStartCommand() in android services?","START_NOT_STICKY AND START_STICKY","START_REDELIVER_INTENT","All of the above",3);
        this.addQuestion(a9);
        Question a10=new Question(" Which method is used to find GPS enabled or disabled pro-grammatically in android?","onProviderDisable()","getGPSStatus()","getGPS()",1);
        this.addQuestion(a10);




    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);

    }


    //getting quiz in to table
    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();

        // Select All Query
        String selectQuery = " SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getInt(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        Log.w((String) TAG,
                "Upgrading the database from version " + oldV + " to "+ newV);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JAVA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PYTHON);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CPROGRAM);
        // Create tables again
        onCreate(db);
    }


   //add quiz java quiz in table
    private void addJavaQuestions()
    {
        Question2 j1 = new Question2("Java language has support for which of the following types of comment ?","Block,Line and Javadoc", "Javadoc Literal and String ", "Javadoc, Char and String", 1);
        this.addQuestion1(j1);
        Question2 j2 = new Question2("Command to execute a compiled java program is","javac ", "run  ", "java", 3);
        this.addQuestion1(j2);
        Question2 j3 = new Question2("The order of the three top level elements of the java source file are","Import,Package,Class", "Package, Import, Class ", "Class, Import, Package", 2);
        this.addQuestion1(j3);
        Question2 j4 = new Question2("Which one is not supported by OOP?","Global variables", "Polymorphism ", "Encapsulation", 1);
        this.addQuestion1(j4);
        Question2 j5 = new Question2("Java uses ___ to represent characters"," Unicode ", "ASCII code ", "Byte code", 1);
        this.addQuestion1(j5);
        Question2 j6 = new Question2("Which declaration of the main method below would allow a class to be started as a standalone program.","public static void MAIN(String args[])", "public static void main(String args)", " public static void main(String args[])", 3);
        this.addQuestion1(j6);
        Question2 j7 = new Question2("What is the meaning of the return data type void ?","void is not supported in Java", " void returns no data type", "void return null", 2);
        this.addQuestion1(j7);
        Question2 j8 = new Question2("Which of the following statements about the Java language is true ?","Both procedural and OOP are supported in Java", " Java supports only procedural", "Java supports only OOP approach", 1);
        this.addQuestion1(j8);
        Question2 j9 = new Question2("Which of the following statements is false about objects?","Objects can access both static and instance data", "Objects do not permit encapsulation", "Object is the super class of all other classes", 2);
        this.addQuestion1(j9);
        Question2 j10 = new Question2("TreeMap class is used to implement which collection interface. Select the one correct answer?","set", "SortedSet", "SortedMap",3);
        this.addQuestion1(j10);



    }
    //insert value into java table
    public void addQuestion1(Question2 quest) {

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getJavaQUESTION());
        values.put(KEY_ANSWER, quest.getjANSWER());
        values.put(KEY_OPTA, quest.getjOPTA());
        values.put(KEY_OPTB, quest.getjOPTB());
        values.put(KEY_OPTC, quest.getjOPTC());
        // Inserting Row
        dbase.insert(TABLE_JAVA, null, values);

    }

// get all java table quiz into list
    public List<Question2> getAllQuestionj() {

        List<Question2> questList = new ArrayList<Question2>();
        // Select All Query
        String selectQuery = " SELECT  * FROM " + TABLE_JAVA;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question2 quests = new Question2();
                quests.setJAVAID(cursor.getInt(0));
                quests.setJavaQUESTION(cursor.getString(1));
                quests.setjANSWER(cursor.getInt(2));
                quests.setjOPTA(cursor.getString(3));
                quests.setjOPTB(cursor.getString(4));
                quests.setjOPTC(cursor.getString(5));
                questList.add(quests);
            } while (cursor.moveToNext());
        }
        // return quest list
        return questList;
    }

    private void addPythonQuestions()
    {
        Question3 p1 = new Question3("Given a function that does not return any value, What value is thrown by default when executed in shell?","bool", "void", "none", 3);
        this.addQuestion3(p1);
        Question3 p2 = new Question3("Which of the following is not a keyword?","assert", "eval", " nonlocal", 2);
        this.addQuestion3(p2);
        Question3 p3 = new Question3("Which of the following function returns the max alphabetical character from the string str?","max(str)", "lower()", "min(str)", 1);
        this.addQuestion3(p3);
        Question3 p4 = new Question3("In order to store values in terms of key and value we use what core datatype?","tuple", "dictionary", "list", 2);
        this.addQuestion3(p4);
        Question3 p5 = new Question3("What is the maximum possible length of an identifier?","32 characters", "52characters", "none of the mentioned", 3);
        this.addQuestion3(p5);
        Question3 p6 = new Question3("Which of the following is correct about Python?","supports automatic garbage collection", "easily integrated with C,C++,Java", "Both of the above", 3);
        this.addQuestion3(p6);
        Question3 p7 = new Question3("What is the output of print str[0] if str = 'Hello World! ?","Hello World!", "ello World!", "H", 3);
        this.addQuestion3(p7);
        Question3 p8 = new Question3("Which of the following function convert a String to a tuple in python?","repr(x)", "tuple(s)", "list(s)", 2);
        this.addQuestion3(p8);
        Question3 p9 = new Question3("Which of the following function randomizes the items of a list in place?","shuffle(lst)", "capitalize()", "isalnum()", 1);
        this.addQuestion3(p9);
        Question3 p10 = new Question3("Which of the following function checks in a string that all characters are numeric?","isspace()", "isnumeric()", "islower()", 2);
        this.addQuestion3(p10);




    }

    //insert value into python table
    public void addQuestion3(Question3 quest) {

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getPythonQUESTION());
        values.put(KEY_ANSWER, quest.getpANSWER());
        values.put(KEY_OPTA, quest.getpOPTA());
        values.put(KEY_OPTB, quest.getpOPTB());
        values.put(KEY_OPTC, quest.getpOPTC());
        // Inserting Row
        dbase.insert(TABLE_PYTHON, null, values);

    }
    // get all java table quiz into list
    public List<Question3> getAllQuestionp() {

        List<Question3> quetList = new ArrayList<Question3>();
        // Select All Query
        String selectQuery = " SELECT  * FROM " + TABLE_PYTHON;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question3 quests = new Question3();
                quests.setPYTHONID(cursor.getInt(0));
                quests.setPythonQUESTION(cursor.getString(1));
                quests.setpANSWER(cursor.getInt(2));
                quests.setpOPTA(cursor.getString(3));
                quests.setpOPTB(cursor.getString(4));
                quests.setpOPTC(cursor.getString(5));
                quetList.add(quests);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quetList;
    }


    private void addCprogramQuestion()
    {
        Question4 c1 = new Question4("The keyword used to transfer control from a function back to the calling function is?","switch", "return", "goto", 2);
        this.addQuestion4(c1);
        Question4 c2 = new Question4("A name having a few letters, numbers and special character _(underscore) is called?","reserved keywords", "tokens ", "identifiers ", 3);
        this.addQuestion4(c2);
        Question4 c3 = new Question4("Which operators are used to compare the values of operands to produce logical value in C language?","Relational operator", "Logical operator", " Assignment operator",1);
        this.addQuestion4(c3);
        Question4 c4 = new Question4("While assigning a value to a variable, which operators are used to perform artithmetic operations?","Logical operator", "Assignment operator", "Increment operator", 2);
        this.addQuestion4(c4);
        Question4 c5 = new Question4("An operator used to check a condition and select a value depending on the value of the condition is called?","Conditional or Ternary operator", "Decrement operator", "Logical operator", 1);
        this.addQuestion4(c5);
        Question4 c6 = new Question4("Which library function can convert an unsigned long to a string?","ltoa()", "ultoa()", "system()", 2);
        this.addQuestion4(c6);
        Question4 c7 = new Question4("By default a real number is treated as a","float", "double", "long double", 2);
        this.addQuestion4(c7);
        Question4 c8 = new Question4("Input/output function prototypes and macros are defined in which header file?","conio.h", "stdio.h", "stdlib.h", 2);
        this.addQuestion4(c8);
        Question4 c9 = new Question4("Which of the following correctly represents a long double constant?","6.68L", "6.68f", "6.68LF", 1);
        this.addQuestion4(c9);
        Question4 c10 = new Question4("Which bitwise operator is suitable for turning off a particular bit in a number?","|| operator", "& operator", "&& operator", 2);
        this.addQuestion4(c10);





    }

    //insert value into cprogram table
    public void addQuestion4(Question4 quest) {

        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getCQUESTION());
        values.put(KEY_ANSWER, quest.getcANSWER());
        values.put(KEY_OPTA, quest.getcOPTA());
        values.put(KEY_OPTB, quest.getcOPTB());
        values.put(KEY_OPTC, quest.getcOPTC());
        // Inserting Row
        dbase.insert(TABLE_CPROGRAM, null, values);

    }
    // get all cprogram table quiz into list
    public List<Question4> getAllQuestionc() {

        List<Question4> quetList = new ArrayList<Question4>();
        // Select All Query
        String selectQuery = " SELECT  * FROM " + TABLE_CPROGRAM;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question4 quests = new Question4();
                quests.setCID(cursor.getInt(0));
                quests.setCQUESTION(cursor.getString(1));
                quests.setcANSWER(cursor.getInt(2));
                quests.setcOPTA(cursor.getString(3));
                quests.setcOPTB(cursor.getString(4));
                quests.setcOPTC(cursor.getString(5));
                quetList.add(quests);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quetList;
    }

    public int rowcount()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
    public int rowcounts()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_JAVA;
        SQLiteDatabase dbs = this.getWritableDatabase();
        Cursor cursor = dbs.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
    public int rowcountes()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_PYTHON;
        SQLiteDatabase dbs = this.getWritableDatabase();
        Cursor cursor = dbs.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
    public int rowcout()
    {
        int row=0;
        String selectQuery = "SELECT  * FROM " + TABLE_CPROGRAM;
        SQLiteDatabase dbs = this.getWritableDatabase();
        Cursor cursor = dbs.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }


}
