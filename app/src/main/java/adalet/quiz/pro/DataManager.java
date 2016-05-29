package adalet.quiz.pro;

import java.util.ArrayList;

import adalet.quiz.pro.pojo.CategoryList;
import adalet.quiz.pro.pojo.ChallenegePojo;
import adalet.quiz.pro.pojo.HistoryPojo;
import adalet.quiz.pro.pojo.MyProfilePojo;
import adalet.quiz.pro.pojo.OpponentUser;
import adalet.quiz.pro.pojo.QuestionsPojo;

public class DataManager {
	
	
	//Change url....
	public static String url = "http://cunediogluyazilim.com/adalet/";
	public static String photourl = "http://cunediogluyazilim.com/adalet/upload/";
	
	public static String PROJECT_NUMBER = "728018798055";  // GCM Project number Replace with yours
	
	
	public  static  String timer = "21" ;
//ADMOB ALANLARINI YORUMLADIM
	//public static int addcounter = 7;  // show interstial ads after every 4 questions
	public static String appurl = "https://play.google.com/store/apps/details?id=adalet.quiz.pro";
	//public static String admobid = "ca-app-pub-6192865524332826/5593641192";
	public static String share = "Uygulamayı buradan indirebilirsiniz...hadi karşılıklı oynayalım : "+appurl;

	public static String username = "";
	public static ArrayList<CategoryList> categorylist;
	public static ArrayList<QuestionsPojo> questionlist;
	public static ArrayList<OpponentUser> opponenetuser;
	public static ArrayList<ChallenegePojo> challenegelist;
	public static ArrayList<HistoryPojo> historylist;
	public  static  ArrayList<CategoryList> categorynamelist ;
	public static ArrayList<MyProfilePojo> userprofilelist;
	public static String gameid = "";
	public static String status = "";
	public static String message = "";
	public static String myxp = "";
	

	
	public static boolean ismanual = false;
			
	public static boolean ischallenege = false;
	
	
	
	public static String selectedgameid = "";
	public static String selectedoppid = "";
	public static String selectedcategory = "";
	public static String selecteduserid = "";
	
	public static String endgamescore = "";
	public static String gameresult = "";
	public static int currentxp = 0;
}
