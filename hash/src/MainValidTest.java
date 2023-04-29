import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainValidTest {
//All test data without a source is something I made up
	@Test
	void testValidName() {
		//https://gist.github.com/ruanbekker/a1506f06aa1df06c5a9501cb393626ea - array of first names to test
		String[] names = {"Aaran", "Aaren", "Aarez", "Aarman", "Aaron", "Aarron", "Aaryan", "Aaryn", "Aayan", "Aazaan", "Abaan", "Abbas", "Abdallah", "Abdalroof", "Abdihakim", "Abdirahman", "Abdisalam", "Abdul", "Abdulbasir", "Abdulkadir", "Abdulkarem", "Abdulkhader", "Abdullah", "Abdulmalik", "Abdur", "Abdurraheem", "Abel", "Abhinav", "Abhisumant", "Abid", "Abir", "Abraham", "Abu", "Abubakar", "Ace", "Adain", "Adam", "Addison", "Addisson", "Adegbola", "Adegbolahan", "Aden", "Adenn", "Adie", "Adil", "Aditya", "Adnan", "Adrian", "Adrien", "Aedan", "Aedin", "Aedyn", "Aeron", "Afonso", "Ahmad", "Ahmed", "Ahoua", "Ahtasham", "Aiadan", "Aidan", "Aiden", "Aidian", "Aidy", "Ailin", "Aiman", "Ainsley", "Ainslie", "Airen", "Airidas", "Airlie", "AJ", "Ajay", "Ajayraj", "Akan", "Akram", "Al", "Ala", "Alan", "Alanas", "Alasdair", "Alastair", "Alber", "Albert", "Albie", "Aldred", "Alec", "Aled", "Aleem", "Aleksandar", "Aleksander", "Aleksandr", "Aleksandrs", "Alekzander", "Alessandro", "Alessio", "Alex", "Alexander", "Alexei", "Alexx", "Amro"};		
		for (int i = 0; i < names.length; i++) {
			if(!MainValid.validName(names[i])) {
				fail("Rejected valid name: " + names[i]);
			}
		}
	}
	
	@Test
	void testInValidName() {
		//Add numbers and other symbols to names to make sure they are rejected
		String[] names = {"A@ran", "A-aren", "", "Aa23r", "23frt2tgaron", "Aaafqrr32on", "A1aryan", "Aar32ryn", "Aa234yan", "Aa111zaan", "Ab...aan", "A//bbas", "A]]bdallah", "Abda||lroof", "A=bdihakim", "Abd+irahman", "Abd)isalam", "&Abdul", "A#@bdulbasir", "A!bdulkadir", "A%bdulkarem", "Abd^ulkhader", "Abdull$ah", "Abd(ulmalik", "Abd%ur", "Abdurrah*eem", "Abe#l", "Abhi2nav", "Ab12hisumant", "Abi24d", "Ab42ir", "Abrah<am", "Abu>", "Abubakar;", "Ac:e", "Adai0n", "Ad@m", "Add:son", "Addiss0n", "Ad3gbola", "Adegbolah@n", "Ad13en", "Ade62nn", "Adi1e", "Adi1", "Adity@", "Adnan,", "Ad..rian", "Adrie-n", "Aedan_", "__Aedin", "Aedyn__00", "A13eron", "Afons213o", "Ahma132d", "A346hmed", "Aho34ua", "Aht34asham", "A23iadan", "A78idan", "A97iden", "Aidian79", "45Aidy", "Ai345lin", "Aim235an", "A   2insley", "Ains352lie", "Aire235n", "A777iridas", "   ____Airlie", "AJ000", "Aj13ray", "Aj235ayraj", "A13kan", "Akra13m", "25Al", "A111la", "Alan000", "Alanas$$$", "Ala12sdair", "Alas142tair", "Albe124r", "36Albert", "A47lbie", "Aldred547", "Ale243c", "Ale23d", "Al33m", "Aleksanq3rdar", "A13leksander", "Aleks1121andr", "Ale1345ksandrs", "Al14ekzander", "A142lessandro", "Ales124sio", "Alex124", "Alex`ander", "A``lexei", "Al\\exx", "Amr0000"};
		for (int i = 0; i < names.length; i++) {
			if(MainValid.validName(names[i])) {
				fail("Not a name: " + names[i]);
			}
		}
	}

	@Test
	void testIsSSn() {
		//https://www.coolgenerator.com/ssn-generator - website used to generate 100 fake ssn numbers for testing
		String[] ssn = {"214-74-7855", "544-47-6274", "049-24-7932","002-90-5710","469-27-2277","525-20-9996","770-76-7902","541-19-4312","514-14-4843","555-67-4639","218-51-2800","444-80-6289","577-08-8935","520-15-1865","440-16-6912","255-78-7304","485-32-4702","575-22-5105","517-44-6097","480-42-0208","343-56-4224","380-08-1661","031-09-7395","429-98-0623","487-05-3603","576-23-6158","003-30-4720","428-40-2580","529-89-3619","673-01-7476","751-16-6033","235-53-6468","475-32-5730","038-24-9052","073-76-7788","424-08-9423","501-37-9697","040-24-8531","234-33-9619","648-01-6966","425-71-2933","470-05-9956","426-24-6054","517-07-0298","411-90-7699","772-98-4171","506-64-1796","484-09-9581","488-10-3762","430-04-9361","585-19-8483","423-64-4889","238-13-7631","530-34-3272","665-07-4116","630-22-8599","470-56-6940","246-09-7881","006-36-7443","481-60-3427","648-54-2919","678-12-7431","249-07-4797","311-34-0708","768-46-2872","184-16-4008","425-68-6305","006-12-8432","529-35-2043","574-90-3394","468-43-8281","760-10-2839","006-58-4992","482-37-1737","658-14-4067","503-02-3833","142-66-0407","303-96-2493","472-62-2878","489-25-9319","477-35-7915","517-54-6018","046-26-4700","038-10-7092","233-90-1227","574-52-7471","426-87-2382","435-69-7897","260-90-1171","651-16-7491","303-92-9457","574-55-3035","577-54-0049","428-64-9609","517-02-0073","540-81-8657","520-98-4428","485-07-0997","221-01-1996","501-50-2308"};
		for (int i = 0; i < ssn.length; i++) {
			if(!MainValid.validSsn(ssn[i])) {
				fail("Rejected valid ssn: " + ssn[i]);
			}
		}
	}
	
	@Test
	void testIsNotSSn() {
		//Mess of ssns with letters, extra numbers, and missing hyphens
		String[] ssn = {"de77-88-9999","7qw8-88-9999","7q77-88-9998","7517-88-9969","767-883-9999","77188-1999","772-88-929119","70237-88-9119","177889399","377-88-39","-88-3999","727--9999","777-88-39","777-88-th099","777-8w8-1111","755-883-9999","766-889199","1188-9399","988-9899","222288-9499","751-8823r-5539","762r37-38-9919","732-93gr8-9119","227-5sfdb8-7709","767-66][9979","737-98-{9992","007-8we1-9929","870-181g3r3-0099","111234g-08-0099","883-43g48-1249","907-18-99gr339","127gr3888029","700-1gr32-9809","0sdf07-18-9939","3113r7-00-9919","312-48-921gwr9","3471wge1w9959","733ktu-13-6399","000-11-2ahgrs222","237-sdhbf98-9991","237-   5-9231","337_18_5429","137_64-9319","316+80-1319","347-90=3219","999-00wve1111","234vsd90-9119","790vds-0019","237rbv53-9921","920-51wb2140","7vsd7-88-9999","77tjr8-88-9999","777jtr-8hf8-9998","757-88hea-9969","767-88-sreh9999","771-snd88-1999","772-aerb88-9299","707-88-9kyrms119","177-8abfa8-9399","377-889999-3999","777-88-3909799","72785-88-9999","777-88-0799139","777344-88-0099","754577-88-1111","755-88-1439999","766-fd88-9199","11457-88-9399","999-434388-9899","222-234388-9499","75154-88-5539","76fhn7-38-9919","732..-98-9119","227-5==8-7709","76347-66-9979","737-98,,,-9992","007-81-","-18-","0099","88wr-1249","907weg9939","12wge-8029","700-1grw809","007wg939","31werg919","312gwrg19","347-rwg959","7gwe13-6399","00ykr1-2222","2   saa8-9991","237-58sgse31","33gwgw429","13jli9319","31pmi319","34wef219","999-00rg3gr-1111","234-90000-9119","790-1rf288-0019","237-53-qfqf9921","92fa0-51-2140"};
		for (int i = 0; i < ssn.length; i++) {
			if(MainValid.validSsn(ssn[i])) {
				fail("Not a valid ssn: " + ssn[i]);
			}
		}
	}

	@Test
	void testIsNumbers() {
		//Tests to make all integers are valid
		String[] nums = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100"};
		for (int i = 0; i < nums.length; i++) {
			if(!MainValid.isNumbers(nums[i])) {
				fail("Rejected valid number: " + nums[i]);
			}
		}
	}
	
	@Test
	void testIsNotNumbers() {
		//Checks to make sure that anything that has nonNumbers is rejected
		String[] nums = {"a1","b2","c3","d4","e5","f6","g7","h8","i9","j10","k11","l12","m13","n14","o15","p16","q17","r18","s19","t20","u21","v22","w23","x24","y25","z26","a27","b28","c29","d30","e31","f32","g33","h34","i35","j36","k37","l38","m39","n40","o41","p42","q43","r44","s45","t46","u47","v48","w49","x50","5l","5:","5e","5a","wfeg","31a","342g","44j4","ll34","2v2","1v1","9b1","87bg","09hj","2f23","twenty","12sa","2321wwe","69lol","7oo","oo7","7tree","7le","bored","72fff","FFF","jq","AJ","129tt","jil","811ee","82sdds","83{}","84.2f","85we","86g3","87,,","88+22e","89e2n","90^5","g23e^2","92+50=","23t=23","94i=?","0n3","two","13gb","avc","HVAC","DONE!!"};
		for (int i = 0; i < nums.length; i++) {
			if(MainValid.isNumbers(nums[i])) {
				fail("Not a number: " + nums[i]);
			}
		}
	}
}
