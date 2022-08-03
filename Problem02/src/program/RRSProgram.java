package program;

import java.util.ArrayList;
import java.util.Scanner;

import io.IOBookOnTape;
import io.IOFurniture;
import io.IOVideo;
import model.BookOnTape;
import model.Furniture;
import model.Video;

public class RRSProgram {
	static ArrayList<Video> listVideo = new ArrayList<Video>();
	static ArrayList<BookOnTape> listBookOnTape = new ArrayList<BookOnTape>();
	static ArrayList<Furniture> listFurniture = new ArrayList<Furniture>();

	public static void menu() {
		System.out.println("--- RRS Program ---");
		System.out.println("1.Video");
		System.out.println("2.Book on tape");
		System.out.println("3.Furniture");
		System.out.println("4.End program");
		System.out.println("What do you want?");

		int n = new Scanner(System.in).nextInt();
		if (n == 1) {
			while (true) {
				System.out.println("-- Video manage menu --");
				System.out.println("1.Add new video");
				System.out.println("2.Show list video");
				System.out.println("3.Search video by serial number");
				System.out.println("4.Save file");
				System.out.println("5.Read file");
				System.out.println("6.Back to main menu");
				System.out.println("What do you want?");

				int m = new Scanner(System.in).nextInt();
				switch (m) {
				case 1:
					addNewVideo();
					break;
				case 2:
					showVideos();
					break;
				case 3:
					searchVideoBySN();
					break;
				case 4:
					saveVideoFile();
					break;
				case 5:
					readVideoFile();
					break;
				case 6:
					menu();
					break;
				}
			}
		} else if (n == 2) {
			while (true) {
				System.out.println("-- BookOnTape manage menu --");
				System.out.println("1.Add new BookOnTape");
				System.out.println("2.Show list BookOnTape");
				System.out.println("3.Search BookOnTape by serial number");
				System.out.println("4.Save file");
				System.out.println("5.Read file");
				System.out.println("6.Back to main menu");
				System.out.println("What do you want?");

				int m = new Scanner(System.in).nextInt();
				switch (m) {
				case 1:
					addNewBookOnTape();
					break;
				case 2:
					showBookOnTapes();
					break;
				case 3:
					searchBookOnTapeBySN();
					break;
				case 4:
					saveBookOnTapeFile();
					break;
				case 5:
					readBookOnTapeFile();
					break;
				case 6:
					menu();
					break;
				}
			}
		} else if (n == 3) {
			while (true) {
				System.out.println("-- Furniture manage menu --");
				System.out.println("1.Add new furniture");
				System.out.println("2.Show list furniture");
				System.out.println("3.Search BookOnTape by serial number");
				System.out.println("4.Save file");
				System.out.println("5.Read file");
				System.out.println("6.Back to main menu");
				System.out.println("What do you want?");

				int m = new Scanner(System.in).nextInt();
				switch (m) {
				case 1:
					addNewFurniture();
					break;
				case 2:
					showFurnitures();
					break;
				case 3:
					searchFurnitureBySN();
					break;
				case 4:
					saveFurnitureFile();
					break;
				case 5:
					readFurnitureFile();
					break;
				case 6:
					menu();
					break;
				}
			}
		} else {
			System.err.println("Good bye!");
			System.exit(0);
		}
	}

	private static void searchFurnitureBySN() {
		System.out.print("Input furniture serial number you want to search: ");
		String furSN = new Scanner(System.in).nextLine();
		Furniture furFound = null;

		for (Furniture fur : listFurniture) {
			if (fur.getSerialNumber().equals(furSN)) {
				furFound = fur;
				break;
			}
		}

		if (furFound != null) {
			System.out.println(furFound.getDescription());
		} else {
			System.err.println("Furniture with serial number:" + furSN + ", does not exist!");
		}
	}

	private static void searchBookOnTapeBySN() {
		System.out.print("Input BookOnTape serial number you want to search: ");
		String bSN = new Scanner(System.in).nextLine();
		BookOnTape bFound = null;

		for (BookOnTape b : listBookOnTape) {
			if (b.getSerialNumber().equals(bSN)) {
				bFound = b;
				break;
			}
		}

		if (bFound != null) {
			System.out.println(bFound.getDescription());
		} else {
			System.err.println("BookOnTape with serial number:" + bSN + ", does not exist!");
		}
	}

	private static void searchVideoBySN() {
		System.out.print("Input video serial number you want to search: ");
		String vidSN = new Scanner(System.in).nextLine();
		Video vidFound = null;

		for (Video vid : listVideo) {
			if (vid.getSerialNumber().equals(vidSN)) {
				vidFound = vid;
				break;
			}
		}

		if (vidFound != null) {
			System.out.println(vidFound.getDescription());
		} else {
			System.err.println("Video with serial number:" + vidSN + ", does not exist!");
		}
	}

	private static void readFurnitureFile() {
		listFurniture = IOFurniture.readFile("G:\\data_rrs\\furniture.txt");
		System.out.println("-->Read file furniture.txt into listFurniture success");
	}

	private static void saveFurnitureFile() {
		IOFurniture.saveFile(listFurniture, "G:\\data_rrs\\furniture.txt");
		System.out.println("-->Save listFurniture into file furniture.txt success");
	}

	private static void showFurnitures() {
		for (Furniture fur : listFurniture) {
			System.out.println(fur.getDescription());
		}
	}

	private static void addNewFurniture() {
		System.out.print("Input furniture name: ");
		String furName = new Scanner(System.in).nextLine();
		System.out.print("Input furniture type: ");
		String furType = new Scanner(System.in).nextLine();
		System.out.print("Input furniture material: ");
		String furMaterial = new Scanner(System.in).nextLine();

		Furniture fur = new Furniture();
		if (listFurniture.size() == 0) {
			fur.setSerialNumber("FUR" + 0);
		} else {
			fur.setSerialNumber("FUR" + listFurniture.size());
		}
		fur.setName(furName);
		fur.setType(furType);
		fur.setMaterial(furMaterial);

		if (listFurniture.add(fur)) {
			System.out.println("-->Add new furniture into listFurniture success");
		}
	}

	private static void readBookOnTapeFile() {
		listBookOnTape = IOBookOnTape.readFile("G:\\data_rrs\\bookOnTape.txt");
		System.out.println("-->Read file bookOnTape.txt into listBookOnTape success");
	}

	private static void saveBookOnTapeFile() {
		IOBookOnTape.saveFile(listBookOnTape, "G:\\data_rrs\\bookOnTape.txt");
		System.out.println("-->Save listBookOnTape into file bookOnTape.txt success");
	}

	private static void showBookOnTapes() {
		for (BookOnTape b : listBookOnTape) {
			System.out.println(b.getDescription());
		}
	}

	private static void addNewBookOnTape() {
		System.out.print("Input BookOnTape name: ");
		String bName = new Scanner(System.in).nextLine();
		System.out.print("Input BookOnTape category: ");
		String bCategory = new Scanner(System.in).nextLine();

		BookOnTape b = new BookOnTape();
		if (listBookOnTape.size() == 0) {
			b.setSerialNumber("BOT" + 0);
		} else {
			b.setSerialNumber("BOT" + listBookOnTape.size());
		}
		b.setName(bName);
		b.setCategory(bCategory);

		if (listBookOnTape.add(b)) {
			System.out.println("-->Add new BookOnTape into listBookOnTape success");
		}
	}

	private static void saveVideoFile() {
		IOVideo.saveFile(listVideo, "G:\\data_rrs\\video.txt");
		System.out.println("-->Save listVideo into file video.txt success");
	}

	private static void readVideoFile() {
		listVideo = IOVideo.readFile("G:\\data_rrs\\video.txt");
		System.out.println("-->Read file video.txt into listVideo success");
	}

	private static void showVideos() {
		for (Video vid : listVideo) {
			System.out.println(vid.getDescription());
		}
	}

	private static void addNewVideo() {
		System.out.print("Input video name: ");
		String vidName = new Scanner(System.in).nextLine();
		System.out.print("Input video length: ");
		String vidLength = new Scanner(System.in).nextLine();
		System.out.print("Input video quality: ");
		String vidQuality = new Scanner(System.in).nextLine();

		Video video = new Video();
		if (listVideo.size() == 0) {
			video.setSerialNumber("VID" + 0);
		} else {
			video.setSerialNumber("VID" + listVideo.size());
		}
		video.setName(vidName);
		video.setLength(vidLength);
		video.setQuality(vidQuality);

		if (listVideo.add(video)) {
			System.out.println("-->Add new video into listVideo success");
		}
	}

	public static void main(String[] args) {
		menu();
	}
}
