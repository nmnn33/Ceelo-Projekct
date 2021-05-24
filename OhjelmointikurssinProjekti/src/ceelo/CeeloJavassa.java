package ceelo;
import java.util.Scanner;
public class CeeloJavassa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//tarvittavat muuuttujat	
		String nimi;
		//raha1= sin‰, raha2= vastustaja
		Double raha1=0.0, raha2=0.0, panos = 0.0;
		//Aloittava on pankki ja sitten vaihtelevasti
		int pankkina=0, tulos1=0, tulos2=0, toistot=3;
		//Ohjelma alkaa
		nimi = Esitys();
		JatkaPeliToiminto();
		S‰‰nnˆt(nimi);
		JatkaPeliToiminto();
		//Pelaaja syˆtt‰‰ summan, botti saa 3X
		raha1 = Rahanen(nimi);
		raha2 = raha1 * 3;
		PrintRahatilanne(raha1, raha2);
		pankkina = Ekapelaaja();
		if (pankkina == 1) {
		System.out.println("T‰m‰n pelin aloittaa pankkina arvon henkilˆ: " + nimi + ".");
		} else {
			System.out.println("T‰m‰n pelin aloittaa pankkina arvon herra: Mandariini."); 
			}
		
		//Pelin kulku, aluksi pelaaja syˆtt‰‰ panoksen, miss‰ pankkina = 1 on sin‰ ja pankkina = 2 on botti
		while (raha1 >= 1000 && raha2 >= 1000) {
			if (pankkina == 2) {
				do { 
					System.out.print("Pankkina toimii Mandariini \nPelaaja " + nimi + " esitt‰‰ panoksen: ");
					panos = sc.nextDouble();  //alaraja 1000 ja yl‰raja 500000 sek‰ oma raha yl‰rajana
					if (panos < 1000) {
						System.out.println("Tonni on minimi, t‰m‰ taidettin jo sinulle kertoakin gweilo." + "\nSyˆt‰ uudestaan panos: ");
					}
					if (panos > raha1) {
						System.out.println("Lis‰‰ sitten emme laina, koita esitt‰‰ panos, johon sinulla on varaa.");
					}
					else if (panos > 500000) {
						System.out.println("Ei peli saa loppua liian aikaisin tunari, j‰nnit‰ meit‰ pidemp‰‰n kamu. 50 tonnia on max panos." + "\nSyˆt‰ uudestaan panos: ");
					}
				} while (panos < 1000 || panos > 500000 || panos > raha1);
			} 
			if (pankkina == 1) { 
				System.out.print("Pankkina toimii " + nimi + " \nPelaaja Mandariini " + " esitt‰‰ panoksen: ");
				panos = (double)(Math.random() * ((250000-1000)+1)+1000);  //Botti syˆtt‰‰ vain 250000-0 panoksen v‰lill‰
				if (panos > raha1 ) {	//Syˆtt‰‰ panoksesksi pelaajan rahat, jos on yli random
					panos = raha1;
				} 
				if (panos > raha2) {	//Syˆtt‰‰ panokseksi omat rahat, jos on yli random.
					panos = raha2;
				}
			}
			System.out.print("Panoksena on t‰lle kierrokselle: " + panos + "\n");
			//Pankki heitt‰‰ 3 noppaa
			do {
				System.out.println("Pankki heitt‰‰ nopat: ");
				int noppa1 = (int)(Math.random() * 6 +1);
				int noppa2 = (int)(Math.random() * 6 +1);
				int noppa3 = (int)(Math.random() * 6 +1);
				System.out.println("Nopat ovat: " + noppa1 + " " + noppa2 + " " + noppa3);
				
				//kolme eri noppaa tulos 0
				if (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 != noppa3 ) {
					tulos1 = 0;
				}
				//Kaikki nopat samat, tulos on 7
				if (noppa1 == noppa2 && noppa1 == noppa3 && noppa2 == noppa3 ) {
					tulos1 = 7;
				}
				//normi tilanne, tulos on noppa joka on eri kuin muut
				if (noppa1 == noppa2 && noppa1 != noppa3 && noppa2 != noppa3) {
					tulos1 = noppa3;
				}
				//normi tilanne, tulos on noppa joka on eri kuin muut
				if (noppa1 != noppa2 && noppa1 == noppa3 && noppa2 != noppa3) {
					tulos1 = noppa2;
				}
				//normi tilanne, tulos on noppa joka on eri kuin muut
				if (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 == noppa3) {
					tulos1 = noppa1;
				}
				//456 noppa, tulos on 8
				if ((noppa1 + noppa2 + noppa3 == 15) && (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 != noppa3 )) {
					tulos1 = 8;
				}
				//123 noppa, tulos = -1
				if ((noppa1 + noppa2 + noppa3 == 6) && (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 != noppa3 )) {
					tulos1 = -1;
				}
				//111 noppa, tulos 111
				if (noppa1 == 1 && noppa2 == 1 && noppa3 == 1) {
					tulos1 = 111;
				}
				--toistot;
			} while (tulos1 == 0 && toistot > 0);
			
			//Toistojen palautus takaisin arvoon 3
			toistot = 3;
			
			//Jatka toiminto
			JatkaPeliToiminto();
			
			//Pelaaja, eli ei pankki heitt‰‰ 3 noppaa
			do {
				System.out.println("Pelaaja heitt‰‰ nopat: ");
				int noppa1 = (int)(Math.random() * 6 +1);
				int noppa2 = (int)(Math.random() * 6 +1);
				int noppa3 = (int)(Math.random() * 6 +1);
				System.out.println("Nopat ovat: " + noppa1 + " " + noppa2 + " " + noppa3);
				
				//kolme eri noppaa tulos 0
				if (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 != noppa3 ) {
					tulos2 = 0;
				}
				//Kaikki nopat samat, tulos on 7
				if (noppa1 == noppa2 && noppa1 == noppa3 && noppa2 == noppa3 ) {
					tulos2 = 7;
				}
				//normi tilanne, tulos on noppa joka on eri kuin muut
				if (noppa1 == noppa2 && noppa1 != noppa3 && noppa2 != noppa3) {
					tulos2 = noppa3;
				}
				//normi tilanne, tulos on noppa joka on eri kuin muut
				if (noppa1 != noppa2 && noppa1 == noppa3 && noppa2 != noppa3) {
					tulos2 = noppa2;
				}
				//normi tilanne, tulos on noppa joka on eri kuin muut
				if (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 == noppa3) {
					tulos2 = noppa1;
				}
				//456 noppa, tulos on 8
				if ((noppa1 + noppa2 + noppa3 == 15) && (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 != noppa3 )) {
					tulos2 = 8;
				}
				//123 noppa, tulos = -1
				if ((noppa1 + noppa2 + noppa3 == 6) && (noppa1 != noppa2 && noppa1 != noppa3 && noppa2 != noppa3 )) {
					tulos2 = -1;
				}
				//111 noppa, tulos 111
				if (noppa1 == 1 && noppa2 == 1 && noppa3 == 1) {
					tulos2 = 111;
				}
				--toistot;
			} while (tulos2 == 0 && toistot > 0);
			
			//Toistojen palautus takaisin arvoon 3
			toistot = 3;
			
			//Jatka toiminto
			JatkaPeliToiminto();
			
			//Panoksen jako, kierroksen voittaja ja h‰vi‰j‰n selvitys normitilanteessa, eli tulos ei ole 123,456,111
			if ((tulos1 > tulos2) && tulos1 != 8 && tulos1 !=111 && tulos1 != -1) {
				if (pankkina == 1) {
					raha1 = raha1 + panos;
					raha2 = raha2 - panos;
				} 
				else if (pankkina ==2) {
					raha2 = raha2 + panos;
					raha1 = raha1 - panos;
				}
				System.out.println("Pankki voitti!");
			}
			if ((tulos2 >= tulos1) && tulos2 != 8 && tulos2 !=111) {
				if (pankkina == 1) {
					raha2 = raha2 + panos;
					raha1 = raha1 - panos;
				}
				else if (pankkina == 2) {
					raha1 = raha1 + panos;
					raha2 = raha2 - panos;
				}
				System.out.println("Pelaaja voitti!");
			}
			//123,456,111 noppien selvitys pankin n‰kˆkulmasta
			if (tulos1 == -1) {
				if (pankkina == 1) {
					raha1 = raha1 - panos*2;
					raha2 = raha2 + panos*2;
				} 
				else if (pankkina == 2) {
					raha1 = raha1 + panos*2;
					raha2 = raha2 - panos*2;
				} 
				System.out.println("Pelaaja voitti!");
			}
			if ((tulos1 > tulos2) && tulos1 == 8) {
				if (pankkina == 1) {
					raha1 = raha1 + panos*2;
					raha2 = raha2 - panos*2;
				} 
				else if (pankkina == 2) {
					raha1 = raha1 - panos*2;
					raha2 = raha2 + panos*2;
				} 
				System.out.println("Pankki Voitti!");
			}
			if ((tulos1 > tulos2) && tulos1 == 111) {
				if (pankkina == 1) {
					raha1 = raha1 + panos*3;
					raha2 = raha2 - panos*3;
				}
				else if (pankkina == 2) {
					raha1 = raha1 - panos*3;
					raha2 = raha2 + panos*3;
				} 
				System.out.println("Pankki voitti!");
			}
			//123,456,111 noppien selvitys pelaajan n‰kˆkulmasta
			if (tulos2 == -1 && tulos1 != -1) {
				if (pankkina == 1) {
					raha1 = raha1 + panos*2;
					raha2 = raha2 - panos*2;
				}
				else if (pankkina == 2) {
					raha1 = raha1 - panos*2;
					raha2 = raha2 + panos*2;
					}
				System.out.println("Pankki Voitti!");
			}
			if ((tulos2 >= tulos1) && tulos2 == 8) {
				if (pankkina == 1) {
					raha2 = raha2 + panos*2;
					raha1 = raha1 - panos*2;
				} 
				else if (pankkina == 2) {
					raha2 = raha2 - panos*2;
					raha1 = raha1 + panos*2;
				}
				System.out.println("Pelaaja voitti!");
			}
			if ((tulos2 >= tulos1) && tulos2 == 111) {
				if (pankkina == 1) {
					raha2 = raha2 + panos*3;
					raha1 = raha1 - panos*3;
				}
				else if (pankkina == 2) {
					raha2 = raha2 - panos*3;
					raha1 = raha1 + panos*3;
				}
				System.out.println("Pelaaja voitti!");
			}
			
			//Pankin vaihto
			if (pankkina == 1) {
				pankkina = 2;
			} else {
				pankkina = 1;
			}
			PrintRahatilanne(raha1, raha2);
			
			//Jatka toiminto
			JatkaPeliToiminto();
			
		}
		//Ohjelman lopetus
		LopetusCredits(nimi, raha1, raha2);
	}
	
	//Paina nappia jatkaaksesi pelia toiminto
	private static void JatkaPeliToiminto() {
		Scanner sc = new Scanner(System.in);
		String dNappi = "d";
		System.out.println("Paina d-n‰pp‰imistˆ‰ jatkaaksesi peli‰.");
		do {
			dNappi = sc.nextLine();
		} while (!dNappi.equals("d"));
	}

	//Lopputeksti pelin p‰‰ttyess‰
	private static void LopetusCredits(String nimi, double raha1, double raha2) {
		if (raha1 > raha2) {
		System.out.println("\n****Voitit pelin!*****\n"
			+	"Onnea teille, " + nimi + "! Kehhehehehehe, p‰rj‰sit meid‰n perasta Cee-lo pelaaja vastaan todella mainionsti, liiankin hyvin. Ulkona odottaa taksi, joka vie teid‰t suoraan lentokent‰lle ja antaa samaten liput sinne mist‰ tulitkin. Toivottavsti emme en‰‰ tapaa, " + nimi);
		} else {
			System.out.println("\nK‰tesi, kiitos...\n"
			+ "ja jalanne...\n"
			+ "ja loput elimesi...\n"
			+ "...\n"
			+ "...\n"
			+ "...\n"
			+ "H‰visit pelin, sek‰ el‰m‰si. Ruumiisi syˆtet‰‰n koirille, jotka syˆtet‰‰n Triadin jengil‰isille. El‰m‰nkierre on ainiain kaunis.");
		}
	}
		

	//M‰‰ritell‰‰n kuka aloittaa pankkina
	private static int Ekapelaaja() {
		int p1 = (int)(Math.random() * 6);
		int p2 = (int)(Math.random() * 6);
		if (p1 > p2) {
			p1 = 1;
			return p1;
		} else {
			p1 = 2;
			return p1;
		}
	}
	
	//Pelaajan ja bottien rahat esitet‰‰n
	private static void PrintRahatilanne(Double raha1, Double raha2) {
		System.out.println("\n\n****J‰ljell‰ oleva rahasi= " + raha1 + " ja Herra Mandariinin j‰ljell‰ oleva raha= " + raha2 + " ****");	
	}
	
	//Aloitusrahan m‰‰ritys
	private static Double Rahanen(String nimi) {
		Scanner sc = new Scanner(System.in);
		double raha;
		System.out.println("\n" + nimi + " , Cee-lo ei ole hauskaa ilman panoksia. Olet pennitˆn ja viel‰p‰ vihollisten alueella, kaikki asiat t‰n‰‰n ovat sinua vastaan, eikˆs?"
		+ "\nMuttei h‰t‰‰, voit lainata meilt‰ Triadeilta muutaman yuanin, sanotaanko ett‰ miljoonaa yunia voisit lainata enimm‰kseen. Miten olisi, " + nimi
		+ "\n**Syˆt‰ lainaamasi raham‰‰r‰ peli‰ varten**");
		do {
		raha = sc.nextDouble();
		if (raha <= 1000) {
			System.out.println("Selk‰rangaton roska, luuletko ett‰ t‰‰ll‰ pelataan Japanin rahoilla?!? Haluatko Menett‰‰ nen‰si paskiainen?"
			+ "\nKokeilla uudestaan syˆtt‰‰ raha m‰‰r‰:");
		} 
		if (raha < 100000 && raha > 1000) {
			System.out.println("Uhkapeluu sielusi on yht‰ laimea kuin kest‰vyytesi s‰ngyss‰ gweilo... Mutta mik‰s siin‰, jos h‰vi‰t, niin joutunet vain enimm‰kseen maksamaan kaikki sormesi.");
		}
		if (raha >= 100000 && raha <= 1000000){
			System.out.println(nimi + " ...Heh, t‰m‰n takia jouduitkin t‰nne. MAHTAVAA!");
		} 
		if ( raha > 1000000){
			System.out.println("Rauhoitus v‰h‰n, meh‰n voimme h‰vit‰ t‰ss‰. Lainata saa vain miljoonaan yuaniin asti.");
		}
		} while (raha <= 1000 || raha > 1000000);
		System.out.println("Herra Mandariini saa summakseen kolminkertaisen m‰‰r‰n sinuun verraten. ƒl‰ pist‰ sit‰ pahaksesi, talon pit‰‰ olla paremmassa asemassa kuin pelaajat.");
		return raha;
	}
	
	//S‰‰ntˆjen tulostus
	private static void S‰‰nnˆt(String nimi) {
		System.out.println("\nKuunteleshan nyt kunnolla " + nimi + ", sill‰' tyhmi‰ ulkomaalaisia emme miss‰‰n nimess‰ sied‰, ainakaan t‰ysiraajaisina, kweh kweh kweh."
		+ " \n1. Peli pelataan pelaajien ja pankin v‰lill‰. Ottelet t‰ll‰ hetkell‰ meid‰n kovinta uhkapeluria Mandariini Ye Qiu:ta vastaan."
		+ "\n2. Vuorotellen pelaajat vaihtavat pankin roolia kellonsuuntaan, mutta koska t‰ll‰ kertaa on vain 2 pelaajaa, joten vaihdatte pankin roolia kesken‰nne joka kieroksen v‰lein."
		+ "\n3. Pelaaja aluksi esitt‰‰ panoksen. Pankki heitt‰‰ siten kolme noppaa ja saa siit‰ tuloksen. Sitten pelaajat heitt‰v‰t kolme noppaa ja saavat siit‰ tuloksen"
		+ "\n4. Tulokset verrataan kesken‰‰n kuten pokerissa, se jolla on paremmat, voittaa koko potin."
		+ "\n5. Tietyiss‰ tuloksissa voi voittaa tupla, tripla tai h‰vit‰ tuplasti panokseen verraten."
		+ "\n6. Pelaajalla on etu Triadien s‰‰nnˆill‰. Jos Pelaajalla ja pankilla on sama tulos, pelaaja voittaa."
		+ "\n"
		+ "\n** Tulokset saadaan n‰ist‰ nopan luvuista:**"
		+ "\n"
		+ "\n1. Kaksi samaa noppaa, yksi eri = tulos on eri‰v‰ noppa."
		+ "\n2. Kaikki nopat eri = tulos 0.Jos n‰in k‰y, saa heitt‰‰ viel‰ kahdesti uudestaan, kunnes tulee tulos. Jos ei tulosta, h‰vi‰‰ kieroksen."
		+ "\n3. Kolme samaa noppaa = tulos kolmanneksi paras, vain 111 ja 456 p‰ihitt‰‰."
		+ "\n4. 456 noppa = tulos toiseksi paras. Pelaaja/pankki tienaa tuplasti panoksen verran"
		+ "\n5. 111 noppa = Paras tulos ja jos pelaaja saa 111 nopan, voittaa h‰n aina. Pelaaja/pankki tienaa triplasti panoksen verran."
		+ "\n6. 123 noppa = Heti h‰vi‰‰ ja menett‰‰ tuplasti panoksensa."
		);
		
	}
	
	//Alkupuhe ja nimi selvitys
	public static String Esitys() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Hey! Her‰sit vihdoin gweilo. Tied‰t varmasti miksi olet t‰‰ll‰ t‰n‰‰n, etkˆ? Herra/Rouva...");
		System.out.print("Anna etunimesi ");
		String nimi = sc.nextLine();
		System.out.println("Nyt, hyv‰ vieraamme " + nimi + ", taitanet olla tutustunut Cee-lo nimiseen peliin. T‰‰ll‰ p‰in Hong Kongia pelataan Triad s‰‰nnˆill‰.\n"
		+ "Haluannet kuulla s‰‰nnˆt kuitenkin?");
		return nimi;
	}
}
