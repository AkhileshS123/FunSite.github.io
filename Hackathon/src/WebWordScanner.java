import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WebWordScanner {
	private String topic;
	private ArrayList<String> topicWords;
	
	public WebWordScanner(String topic) {
		try {
			String searchTerm = topic;
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/"+searchTerm).get();
			String body = doc.body().wholeText();
			String[] words = body.toLowerCase().split("\\s+");
			
			String commonWords = "a\r\n" + 
					"ability\r\n" + 
					"able\r\n" + 
					"about\r\n" + 
					"above\r\n" + 
					"accept\r\n" + 
					"according\r\n" + 
					"account\r\n" + 
					"across\r\n" + 
					"act\r\n" + 
					"action\r\n" + 
					"activity\r\n" + 
					"actually\r\n" + 
					"add\r\n" + 
					"address\r\n" + 
					"administration\r\n" + 
					"admit\r\n" + 
					"adult\r\n" + 
					"affect\r\n" + 
					"after\r\n" + 
					"again\r\n" + 
					"against\r\n" + 
					"age\r\n" + 
					"agency\r\n" + 
					"agent\r\n" + 
					"ago\r\n" + 
					"agree\r\n" + 
					"agreement\r\n" + 
					"ahead\r\n" + 
					"air\r\n" + 
					"all\r\n" + 
					"allow\r\n" + 
					"almost\r\n" + 
					"alone\r\n" + 
					"along\r\n" + 
					"already\r\n" + 
					"also\r\n" + 
					"although\r\n" + 
					"always\r\n" + 
					"American\r\n" + 
					"among\r\n" + 
					"amount\r\n" + 
					"analysis\r\n" + 
					"and\r\n" + 
					"animal\r\n" + 
					"another\r\n" + 
					"answer\r\n" + 
					"any\r\n" + 
					"anyone\r\n" + 
					"anything\r\n" + 
					"appear\r\n" + 
					"apply\r\n" + 
					"approach\r\n" + 
					"area\r\n" + 
					"argue\r\n" + 
					"arm\r\n" + 
					"around\r\n" + 
					"arrive\r\n" + 
					"art\r\n" + 
					"article\r\n" + 
					"artist\r\n" + 
					"as\r\n" + 
					"ask\r\n" + 
					"assume\r\n" + 
					"at\r\n" + 
					"attack\r\n" + 
					"attention\r\n" + 
					"attorney\r\n" + 
					"audience\r\n" + 
					"author\r\n" + 
					"authority\r\n" + 
					"available\r\n" + 
					"avoid\r\n" + 
					"away\r\n" + 
					"baby\r\n" + 
					"back\r\n" + 
					"bad\r\n" + 
					"bag\r\n" + 
					"ball\r\n" + 
					"bank\r\n" + 
					"bar\r\n" + 
					"base\r\n" + 
					"be\r\n" + 
					"beat\r\n" + 
					"beautiful\r\n" + 
					"because\r\n" + 
					"become\r\n" + 
					"bed\r\n" + 
					"before\r\n" + 
					"begin\r\n" + 
					"behavior\r\n" + 
					"behind\r\n" + 
					"believe\r\n" + 
					"benefit\r\n" + 
					"best\r\n" + 
					"better\r\n" + 
					"between\r\n" + 
					"beyond\r\n" + 
					"big\r\n" + 
					"bill\r\n" + 
					"billion\r\n" + 
					"bit\r\n" + 
					"black\r\n" + 
					"blood\r\n" + 
					"blue\r\n" + 
					"board\r\n" + 
					"body\r\n" + 
					"book\r\n" + 
					"born\r\n" + 
					"both\r\n" + 
					"box\r\n" + 
					"boy\r\n" + 
					"break\r\n" + 
					"bring\r\n" + 
					"brother\r\n" + 
					"budget\r\n" + 
					"build\r\n" + 
					"building\r\n" + 
					"business\r\n" + 
					"but\r\n" + 
					"buy\r\n" + 
					"by\r\n" + 
					"call\r\n" + 
					"camera\r\n" + 
					"campaign\r\n" + 
					"can\r\n" + 
					"cancer\r\n" + 
					"candidate\r\n" + 
					"capital\r\n" + 
					"car\r\n" + 
					"card\r\n" + 
					"care\r\n" + 
					"career\r\n" + 
					"carry\r\n" + 
					"case\r\n" + 
					"catch\r\n" + 
					"cause\r\n" + 
					"cell\r\n" + 
					"center\r\n" + 
					"central\r\n" + 
					"century\r\n" + 
					"certain\r\n" + 
					"certainly\r\n" + 
					"chair\r\n" + 
					"challenge\r\n" + 
					"chance\r\n" + 
					"change\r\n" + 
					"character\r\n" + 
					"charge\r\n" + 
					"check\r\n" + 
					"child\r\n" + 
					"choice\r\n" + 
					"choose\r\n" + 
					"church\r\n" + 
					"citizen\r\n" + 
					"city\r\n" + 
					"civil\r\n" + 
					"claim\r\n" + 
					"class\r\n" + 
					"clear\r\n" + 
					"clearly\r\n" + 
					"close\r\n" + 
					"coach\r\n" + 
					"cold\r\n" + 
					"collection\r\n" + 
					"college\r\n" + 
					"color\r\n" + 
					"come\r\n" + 
					"commercial\r\n" + 
					"common\r\n" + 
					"community\r\n" + 
					"company\r\n" + 
					"compare\r\n" + 
					"computer\r\n" + 
					"concern\r\n" + 
					"condition\r\n" + 
					"conference\r\n" + 
					"Congress\r\n" + 
					"consider\r\n" + 
					"consumer\r\n" + 
					"contain\r\n" + 
					"continue\r\n" + 
					"control\r\n" + 
					"cost\r\n" + 
					"could\r\n" + 
					"country\r\n" + 
					"couple\r\n" + 
					"course\r\n" + 
					"court\r\n" + 
					"cover\r\n" + 
					"create\r\n" + 
					"crime\r\n" + 
					"cultural\r\n" + 
					"culture\r\n" + 
					"cup\r\n" + 
					"current\r\n" + 
					"customer\r\n" + 
					"cut\r\n" + 
					"dark\r\n" + 
					"data\r\n" + 
					"daughter\r\n" + 
					"day\r\n" + 
					"dead\r\n" + 
					"deal\r\n" + 
					"death\r\n" + 
					"debate\r\n" + 
					"decade\r\n" + 
					"decide\r\n" + 
					"decision\r\n" + 
					"deep\r\n" + 
					"defense\r\n" + 
					"degree\r\n" + 
					"Democrat\r\n" + 
					"democratic\r\n" + 
					"describe\r\n" + 
					"design\r\n" + 
					"despite\r\n" + 
					"detail\r\n" + 
					"determine\r\n" + 
					"develop\r\n" + 
					"development\r\n" + 
					"die\r\n" + 
					"difference\r\n" + 
					"different\r\n" + 
					"difficult\r\n" + 
					"dinner\r\n" + 
					"direction\r\n" + 
					"director\r\n" + 
					"discover\r\n" + 
					"discuss\r\n" + 
					"discussion\r\n" + 
					"disease\r\n" + 
					"do\r\n" + 
					"doctor\r\n" + 
					"dog\r\n" + 
					"door\r\n" + 
					"down\r\n" + 
					"draw\r\n" + 
					"dream\r\n" + 
					"drive\r\n" + 
					"drop\r\n" + 
					"drug\r\n" + 
					"during\r\n" + 
					"each\r\n" + 
					"early\r\n" + 
					"east\r\n" + 
					"easy\r\n" + 
					"eat\r\n" + 
					"economic\r\n" + 
					"economy\r\n" + 
					"edge\r\n" + 
					"education\r\n" + 
					"effect\r\n" + 
					"effort\r\n" + 
					"eight\r\n" + 
					"either\r\n" + 
					"election\r\n" + 
					"else\r\n" + 
					"employee\r\n" + 
					"end\r\n" + 
					"energy\r\n" + 
					"enjoy\r\n" + 
					"enough\r\n" + 
					"enter\r\n" + 
					"entire\r\n" + 
					"environment\r\n" + 
					"environmental\r\n" + 
					"especially\r\n" + 
					"establish\r\n" + 
					"even\r\n" + 
					"evening\r\n" + 
					"event\r\n" + 
					"ever\r\n" + 
					"every\r\n" + 
					"everybody\r\n" + 
					"everyone\r\n" + 
					"everything\r\n" + 
					"evidence\r\n" + 
					"exactly\r\n" + 
					"example\r\n" + 
					"executive\r\n" + 
					"exist\r\n" + 
					"expect\r\n" + 
					"experience\r\n" + 
					"expert\r\n" + 
					"explain\r\n" + 
					"eye\r\n" + 
					"face\r\n" + 
					"fact\r\n" + 
					"factor\r\n" + 
					"fail\r\n" + 
					"fall\r\n" + 
					"family\r\n" + 
					"far\r\n" + 
					"fast\r\n" + 
					"father\r\n" + 
					"fear\r\n" + 
					"federal\r\n" + 
					"feel\r\n" + 
					"feeling\r\n" + 
					"few\r\n" + 
					"field\r\n" + 
					"fight\r\n" + 
					"figure\r\n" + 
					"fill\r\n" + 
					"film\r\n" + 
					"final\r\n" + 
					"finally\r\n" + 
					"financial\r\n" + 
					"find\r\n" + 
					"fine\r\n" + 
					"finger\r\n" + 
					"finish\r\n" + 
					"fire\r\n" + 
					"firm\r\n" + 
					"first\r\n" + 
					"fish\r\n" + 
					"five\r\n" + 
					"floor\r\n" + 
					"fly\r\n" + 
					"focus\r\n" + 
					"follow\r\n" + 
					"food\r\n" + 
					"foot\r\n" + 
					"for\r\n" + 
					"force\r\n" + 
					"foreign\r\n" + 
					"forget\r\n" + 
					"form\r\n" + 
					"former\r\n" + 
					"forward\r\n" + 
					"four\r\n" + 
					"free\r\n" + 
					"friend\r\n" + 
					"from\r\n" + 
					"front\r\n" + 
					"full\r\n" + 
					"fund\r\n" + 
					"future\r\n" + 
					"game\r\n" + 
					"garden\r\n" + 
					"gas\r\n" + 
					"general\r\n" + 
					"generation\r\n" + 
					"get\r\n" + 
					"girl\r\n" + 
					"give\r\n" + 
					"glass\r\n" + 
					"go\r\n" + 
					"goal\r\n" + 
					"good\r\n" + 
					"government\r\n" + 
					"great\r\n" + 
					"green\r\n" + 
					"ground\r\n" + 
					"group\r\n" + 
					"grow\r\n" + 
					"growth\r\n" + 
					"guess\r\n" + 
					"gun\r\n" + 
					"guy\r\n" + 
					"hair\r\n" + 
					"half\r\n" + 
					"hand\r\n" + 
					"hang\r\n" + 
					"happen\r\n" + 
					"happy\r\n" + 
					"hard\r\n" + 
					"have\r\n" + 
					"he\r\n" + 
					"head\r\n" + 
					"health\r\n" + 
					"hear\r\n" + 
					"heart\r\n" + 
					"heat\r\n" + 
					"heavy\r\n" + 
					"help\r\n" + 
					"her\r\n" + 
					"here\r\n" + 
					"herself\r\n" + 
					"high\r\n" + 
					"him\r\n" + 
					"himself\r\n" + 
					"his\r\n" + 
					"history\r\n" + 
					"hit\r\n" + 
					"hold\r\n" + 
					"home\r\n" + 
					"hope\r\n" + 
					"hospital\r\n" + 
					"hot\r\n" + 
					"hotel\r\n" + 
					"hour\r\n" + 
					"house\r\n" + 
					"how\r\n" + 
					"however\r\n" + 
					"huge\r\n" + 
					"human\r\n" + 
					"hundred\r\n" + 
					"husband\r\n" + 
					"I\r\n" + 
					"idea\r\n" + 
					"identify\r\n" + 
					"if\r\n" + 
					"image\r\n" + 
					"imagine\r\n" + 
					"impact\r\n" + 
					"important\r\n" + 
					"improve\r\n" + 
					"in\r\n" + 
					"include\r\n" + 
					"including\r\n" + 
					"increase\r\n" + 
					"indeed\r\n" + 
					"indicate\r\n" + 
					"individual\r\n" + 
					"industry\r\n" + 
					"information\r\n" + 
					"inside\r\n" + 
					"instead\r\n" + 
					"institution\r\n" + 
					"interest\r\n" + 
					"interesting\r\n" + 
					"international\r\n" + 
					"interview\r\n" + 
					"into\r\n" + 
					"investment\r\n" + 
					"involve\r\n" + 
					"issue\r\n" + 
					"it\r\n" + 
					"item\r\n" + 
					"its\r\n" + 
					"itself\r\n" + 
					"job\r\n" + 
					"join\r\n" + 
					"just\r\n" + 
					"keep\r\n" + 
					"key\r\n" + 
					"kid\r\n" + 
					"kill\r\n" + 
					"kind\r\n" + 
					"kitchen\r\n" + 
					"know\r\n" + 
					"knowledge\r\n" + 
					"land\r\n" + 
					"language\r\n" + 
					"large\r\n" + 
					"last\r\n" + 
					"late\r\n" + 
					"later\r\n" + 
					"laugh\r\n" + 
					"law\r\n" + 
					"lawyer\r\n" + 
					"lay\r\n" + 
					"lead\r\n" + 
					"leader\r\n" + 
					"learn\r\n" + 
					"least\r\n" + 
					"leave\r\n" + 
					"left\r\n" + 
					"leg\r\n" + 
					"legal\r\n" + 
					"less\r\n" + 
					"let\r\n" + 
					"letter\r\n" + 
					"level\r\n" + 
					"lie\r\n" + 
					"life\r\n" + 
					"light\r\n" + 
					"like\r\n" + 
					"likely\r\n" + 
					"line\r\n" + 
					"list\r\n" + 
					"listen\r\n" + 
					"little\r\n" + 
					"live\r\n" + 
					"local\r\n" + 
					"long\r\n" + 
					"look\r\n" + 
					"lose\r\n" + 
					"loss\r\n" + 
					"lot\r\n" + 
					"love\r\n" + 
					"low\r\n" + 
					"machine\r\n" + 
					"magazine\r\n" + 
					"main\r\n" + 
					"maintain\r\n" + 
					"major\r\n" + 
					"majority\r\n" + 
					"make\r\n" + 
					"man\r\n" + 
					"manage\r\n" + 
					"management\r\n" + 
					"manager\r\n" + 
					"many\r\n" + 
					"market\r\n" + 
					"marriage\r\n" + 
					"material\r\n" + 
					"matter\r\n" + 
					"may\r\n" + 
					"maybe\r\n" + 
					"me\r\n" + 
					"mean\r\n" + 
					"measure\r\n" + 
					"media\r\n" + 
					"medical\r\n" + 
					"meet\r\n" + 
					"meeting\r\n" + 
					"member\r\n" + 
					"memory\r\n" + 
					"mention\r\n" + 
					"message\r\n" + 
					"method\r\n" + 
					"middle\r\n" + 
					"might\r\n" + 
					"military\r\n" + 
					"million\r\n" + 
					"mind\r\n" + 
					"minute\r\n" + 
					"miss\r\n" + 
					"mission\r\n" + 
					"model\r\n" + 
					"modern\r\n" + 
					"moment\r\n" + 
					"money\r\n" + 
					"month\r\n" + 
					"more\r\n" + 
					"morning\r\n" + 
					"most\r\n" + 
					"mother\r\n" + 
					"mouth\r\n" + 
					"move\r\n" + 
					"movement\r\n" + 
					"movie\r\n" + 
					"Mr\r\n" + 
					"Mrs\r\n" + 
					"much\r\n" + 
					"music\r\n" + 
					"must\r\n" + 
					"my\r\n" + 
					"myself\r\n" + 
					"name\r\n" + 
					"nation\r\n" + 
					"national\r\n" + 
					"natural\r\n" + 
					"nature\r\n" + 
					"near\r\n" + 
					"nearly\r\n" + 
					"necessary\r\n" + 
					"need\r\n" + 
					"network\r\n" + 
					"never\r\n" + 
					"new\r\n" + 
					"news\r\n" + 
					"newspaper\r\n" + 
					"next\r\n" + 
					"nice\r\n" + 
					"night\r\n" + 
					"no\r\n" + 
					"none\r\n" + 
					"nor\r\n" + 
					"north\r\n" + 
					"not\r\n" + 
					"note\r\n" + 
					"nothing\r\n" + 
					"notice\r\n" + 
					"now\r\n" + 
					"n't\r\n" + 
					"number\r\n" + 
					"occur\r\n" + 
					"of\r\n" + 
					"off\r\n" + 
					"offer\r\n" + 
					"office\r\n" + 
					"officer\r\n" + 
					"official\r\n" + 
					"often\r\n" + 
					"oh\r\n" + 
					"oil\r\n" + 
					"ok\r\n" + 
					"old\r\n" + 
					"on\r\n" + 
					"once\r\n" + 
					"one\r\n" + 
					"only\r\n" + 
					"onto\r\n" + 
					"open\r\n" + 
					"operation\r\n" + 
					"opportunity\r\n" + 
					"option\r\n" + 
					"or\r\n" + 
					"order\r\n" + 
					"organization\r\n" + 
					"other\r\n" + 
					"others\r\n" + 
					"our\r\n" + 
					"out\r\n" + 
					"outside\r\n" + 
					"over\r\n" + 
					"own\r\n" + 
					"owner\r\n" + 
					"page\r\n" + 
					"pain\r\n" + 
					"painting\r\n" + 
					"paper\r\n" + 
					"parent\r\n" + 
					"part\r\n" + 
					"participant\r\n" + 
					"particular\r\n" + 
					"particularly\r\n" + 
					"partner\r\n" + 
					"party\r\n" + 
					"pass\r\n" + 
					"past\r\n" + 
					"patient\r\n" + 
					"pattern\r\n" + 
					"pay\r\n" + 
					"peace\r\n" + 
					"people\r\n" + 
					"per\r\n" + 
					"perform\r\n" + 
					"performance\r\n" + 
					"perhaps\r\n" + 
					"period\r\n" + 
					"person\r\n" + 
					"personal\r\n" + 
					"phone\r\n" + 
					"physical\r\n" + 
					"pick\r\n" + 
					"picture\r\n" + 
					"piece\r\n" + 
					"place\r\n" + 
					"plan\r\n" + 
					"plant\r\n" + 
					"play\r\n" + 
					"player\r\n" + 
					"PM\r\n" + 
					"point\r\n" + 
					"police\r\n" + 
					"policy\r\n" + 
					"political\r\n" + 
					"politics\r\n" + 
					"poor\r\n" + 
					"popular\r\n" + 
					"population\r\n" + 
					"position\r\n" + 
					"positive\r\n" + 
					"possible\r\n" + 
					"power\r\n" + 
					"practice\r\n" + 
					"prepare\r\n" + 
					"present\r\n" + 
					"president\r\n" + 
					"pressure\r\n" + 
					"pretty\r\n" + 
					"prevent\r\n" + 
					"price\r\n" + 
					"private\r\n" + 
					"probably\r\n" + 
					"problem\r\n" + 
					"process\r\n" + 
					"produce\r\n" + 
					"product\r\n" + 
					"production\r\n" + 
					"professional\r\n" + 
					"professor\r\n" + 
					"program\r\n" + 
					"project\r\n" + 
					"property\r\n" + 
					"protect\r\n" + 
					"prove\r\n" + 
					"provide\r\n" + 
					"public\r\n" + 
					"pull\r\n" + 
					"purpose\r\n" + 
					"push\r\n" + 
					"put\r\n" + 
					"quality\r\n" + 
					"question\r\n" + 
					"quickly\r\n" + 
					"quite\r\n" + 
					"race\r\n" + 
					"radio\r\n" + 
					"raise\r\n" + 
					"range\r\n" + 
					"rate\r\n" + 
					"rather\r\n" + 
					"reach\r\n" + 
					"read\r\n" + 
					"ready\r\n" + 
					"real\r\n" + 
					"reality\r\n" + 
					"realize\r\n" + 
					"really\r\n" + 
					"reason\r\n" + 
					"receive\r\n" + 
					"recent\r\n" + 
					"recently\r\n" + 
					"recognize\r\n" + 
					"record\r\n" + 
					"red\r\n" + 
					"reduce\r\n" + 
					"reflect\r\n" + 
					"region\r\n" + 
					"relate\r\n" + 
					"relationship\r\n" + 
					"religious\r\n" + 
					"remain\r\n" + 
					"remember\r\n" + 
					"remove\r\n" + 
					"report\r\n" + 
					"represent\r\n" + 
					"Republican\r\n" + 
					"require\r\n" + 
					"research\r\n" + 
					"resource\r\n" + 
					"respond\r\n" + 
					"response\r\n" + 
					"responsibility\r\n" + 
					"rest\r\n" + 
					"result\r\n" + 
					"return\r\n" + 
					"reveal\r\n" + 
					"rich\r\n" + 
					"right\r\n" + 
					"rise\r\n" + 
					"risk\r\n" + 
					"road\r\n" + 
					"rock\r\n" + 
					"role\r\n" + 
					"room\r\n" + 
					"rule\r\n" + 
					"run\r\n" + 
					"safe\r\n" + 
					"same\r\n" + 
					"save\r\n" + 
					"say\r\n" + 
					"scene\r\n" + 
					"school\r\n" + 
					"science\r\n" + 
					"scientist\r\n" + 
					"score\r\n" + 
					"sea\r\n" + 
					"season\r\n" + 
					"seat\r\n" + 
					"second\r\n" + 
					"section\r\n" + 
					"security\r\n" + 
					"see\r\n" + 
					"seek\r\n" + 
					"seem\r\n" + 
					"sell\r\n" + 
					"send\r\n" + 
					"senior\r\n" + 
					"sense\r\n" + 
					"series\r\n" + 
					"serious\r\n" + 
					"serve\r\n" + 
					"service\r\n" + 
					"set\r\n" + 
					"seven\r\n" + 
					"several\r\n" + 
					"sex\r\n" + 
					"sexual\r\n" + 
					"shake\r\n" + 
					"share\r\n" + 
					"she\r\n" + 
					"shoot\r\n" + 
					"short\r\n" + 
					"shot\r\n" + 
					"should\r\n" + 
					"shoulder\r\n" + 
					"show\r\n" + 
					"side\r\n" + 
					"sign\r\n" + 
					"significant\r\n" + 
					"similar\r\n" + 
					"simple\r\n" + 
					"simply\r\n" + 
					"since\r\n" + 
					"sing\r\n" + 
					"single\r\n" + 
					"sister\r\n" + 
					"sit\r\n" + 
					"site\r\n" + 
					"situation\r\n" + 
					"six\r\n" + 
					"size\r\n" + 
					"skill\r\n" + 
					"skin\r\n" + 
					"small\r\n" + 
					"smile\r\n" + 
					"so\r\n" + 
					"social\r\n" + 
					"society\r\n" + 
					"soldier\r\n" + 
					"some\r\n" + 
					"somebody\r\n" + 
					"someone\r\n" + 
					"something\r\n" + 
					"sometimes\r\n" + 
					"son\r\n" + 
					"song\r\n" + 
					"soon\r\n" + 
					"sort\r\n" + 
					"sound\r\n" + 
					"source\r\n" + 
					"south\r\n" + 
					"southern\r\n" + 
					"space\r\n" + 
					"speak\r\n" + 
					"special\r\n" + 
					"specific\r\n" + 
					"speech\r\n" + 
					"spend\r\n" + 
					"sport\r\n" + 
					"spring\r\n" + 
					"staff\r\n" + 
					"stage\r\n" + 
					"stand\r\n" + 
					"standard\r\n" + 
					"star\r\n" + 
					"start\r\n" + 
					"state\r\n" + 
					"statement\r\n" + 
					"station\r\n" + 
					"stay\r\n" + 
					"step\r\n" + 
					"still\r\n" + 
					"stock\r\n" + 
					"stop\r\n" + 
					"store\r\n" + 
					"story\r\n" + 
					"strategy\r\n" + 
					"street\r\n" + 
					"strong\r\n" + 
					"structure\r\n" + 
					"student\r\n" + 
					"study\r\n" + 
					"stuff\r\n" + 
					"style\r\n" + 
					"subject\r\n" + 
					"success\r\n" + 
					"successful\r\n" + 
					"such\r\n" + 
					"suddenly\r\n" + 
					"suffer\r\n" + 
					"suggest\r\n" + 
					"summer\r\n" + 
					"support\r\n" + 
					"sure\r\n" + 
					"surface\r\n" + 
					"system\r\n" + 
					"table\r\n" + 
					"take\r\n" + 
					"talk\r\n" + 
					"task\r\n" + 
					"tax\r\n" + 
					"teach\r\n" + 
					"teacher\r\n" + 
					"team\r\n" + 
					"technology\r\n" + 
					"television\r\n" + 
					"tell\r\n" + 
					"ten\r\n" + 
					"tend\r\n" + 
					"term\r\n" + 
					"test\r\n" + 
					"than\r\n" + 
					"thank\r\n" + 
					"that\r\n" + 
					"the\r\n" + 
					"their\r\n" + 
					"them\r\n" + 
					"themselves\r\n" + 
					"then\r\n" + 
					"theory\r\n" + 
					"there\r\n" + 
					"these\r\n" + 
					"they\r\n" + 
					"thing\r\n" + 
					"think\r\n" + 
					"third\r\n" + 
					"this\r\n" + 
					"those\r\n" + 
					"though\r\n" + 
					"thought\r\n" + 
					"thousand\r\n" + 
					"threat\r\n" + 
					"three\r\n" + 
					"through\r\n" + 
					"throughout\r\n" + 
					"throw\r\n" + 
					"thus\r\n" + 
					"time\r\n" + 
					"to\r\n" + 
					"today\r\n" + 
					"together\r\n" + 
					"tonight\r\n" + 
					"too\r\n" + 
					"top\r\n" + 
					"total\r\n" + 
					"tough\r\n" + 
					"toward\r\n" + 
					"town\r\n" + 
					"trade\r\n" + 
					"traditional\r\n" + 
					"training\r\n" + 
					"travel\r\n" + 
					"treat\r\n" + 
					"treatment\r\n" + 
					"tree\r\n" + 
					"trial\r\n" + 
					"trip\r\n" + 
					"trouble\r\n" + 
					"true\r\n" + 
					"truth\r\n" + 
					"try\r\n" + 
					"turn\r\n" + 
					"TV\r\n" + 
					"two\r\n" + 
					"type\r\n" + 
					"under\r\n" + 
					"understand\r\n" + 
					"unit\r\n" + 
					"until\r\n" + 
					"up\r\n" + 
					"upon\r\n" + 
					"us\r\n" + 
					"use\r\n" + 
					"usually\r\n" + 
					"value\r\n" + 
					"various\r\n" + 
					"very\r\n" + 
					"victim\r\n" + 
					"view\r\n" + 
					"violence\r\n" + 
					"visit\r\n" + 
					"voice\r\n" + 
					"vote\r\n" + 
					"wait\r\n" + 
					"walk\r\n" + 
					"wall\r\n" + 
					"want\r\n" + 
					"war\r\n" + 
					"watch\r\n" + 
					"water\r\n" + 
					"way\r\n" + 
					"we\r\n" + 
					"weapon\r\n" + 
					"wear\r\n" + 
					"week\r\n" + 
					"weight\r\n" + 
					"well\r\n" + 
					"west\r\n" + 
					"western\r\n" + 
					"what\r\n" + 
					"whatever\r\n" + 
					"when\r\n" + 
					"where\r\n" + 
					"whether\r\n" + 
					"which\r\n" + 
					"while\r\n" + 
					"white\r\n" + 
					"who\r\n" + 
					"whole\r\n" + 
					"whom\r\n" + 
					"whose\r\n" + 
					"why\r\n" + 
					"wide\r\n" + 
					"wife\r\n" + 
					"will\r\n" + 
					"win\r\n" + 
					"wind\r\n" + 
					"window\r\n" + 
					"wish\r\n" + 
					"with\r\n" + 
					"within\r\n" + 
					"without\r\n" + 
					"woman\r\n" + 
					"wonder\r\n" + 
					"word\r\n" + 
					"work\r\n" + 
					"worker\r\n" + 
					"world\r\n" + 
					"worry\r\n" + 
					"would\r\n" + 
					"write\r\n" + 
					"writer\r\n" + 
					"wrong\r\n" + 
					"yard\r\n" + 
					"yeah\r\n" + 
					"year\r\n" + 
					"yes\r\n" + 
					"yet\r\n" + 
					"you\r\n" + 
					"young\r\n" + 
					"your\r\n" + 
					"yourself\r\n" +
					"wikipedia\r\n" +
					"encyclopedia";
			
			
			
			for(int i=0;i<words.length;i++) {
				words[i] = words[i].replaceAll("\\W", "");
				if(commonWords.contains(words[i]) || words[i].contains("0") || words[i].contains("1") || words[i].contains("2") || 
						words[i].contains("3") || words[i].contains("4") || words[i].contains("5") || words[i].contains("6") || 
						words[i].contains("7") || words[i].contains("8") || words[i].contains("9")) {
					words[i]="";
				}
			}
			
			
			
			boolean[] visited = new boolean[words.length]; 
			ArrayList<FrequencyObject> freqList = new ArrayList<FrequencyObject>();
		      
		    Arrays.fill(visited, false); 
		  
		    // Traverse through array elements and 
		    // count frequencies 
		    for (int n = 0; n < words.length; n++) { 
		  
		        // Skip this element if already processed 
		        if (visited[n] == true) 
		            continue; 
		  
		        // Count frequency 
		        int count = 1; 
		        for (int j = n + 1; j < words.length; j++) { 
		            if (words[n].equals(words[j])) { 
		                visited[j] = true; 
		                count++; 
		            } 
		        } 
		        if(!(words[n].equals(""))) {
		        freqList.add(new FrequencyObject(words[n], count));
		        }
		    }
		    
		    
		    
		    
		    
			ArrayList<String> wordsList = new ArrayList<String>();
			for(int i=0;i<freqList.size();i++) {
				if(freqList.get(i).getFreq()>3) {
					wordsList.add(freqList.get(i).getWord());
				}
			}

			topicWords = wordsList;		
			}
			catch(Exception e) {
				System.out.println("Error");
				topicWords = new ArrayList<String>();
			}
	}
	
	public ArrayList<String> getTopicWords() {
		return topicWords;
	}

}

 class FrequencyObject {
	private String word;
	private int freq;
	
	public FrequencyObject(String s, int n) {
		word = s;
		freq = n;
	}
	
	public String getWord() {
		return word;
	}
	
	public int getFreq() {
		return freq;
	}
}
