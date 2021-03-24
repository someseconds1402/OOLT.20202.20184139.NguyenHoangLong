package Aims;

public class TestPassingParameter {
    public static void main (String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("cinderella");
        
        swapREAL(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap (Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }

    public static void swapREAL(Object o1, Object o2) {
		DigitalVideoDisc dvd1 = (DigitalVideoDisc) o1;
		DigitalVideoDisc dvd2 = (DigitalVideoDisc) o2;
		if (dvd1 != null && dvd2 != null) {
			String titleTmp = dvd1.getTitle();
			String directorTmp = dvd1.getDirector();
			String categoryTmp = dvd1.getCategory();
			int lengthTmp = dvd1.getLength();
			float costTmp = dvd1.getCost();

			dvd1.setTitle(dvd2.getTitle());
			dvd1.setDirector(dvd2.getDirector());
			dvd1.setCategory(dvd2.getCategory());
			dvd1.setLength(dvd2.getLength());
			dvd1.setCost(dvd2.getCost());

			dvd2.setTitle(titleTmp);
			dvd2.setDirector(directorTmp);
			dvd2.setCategory(categoryTmp);
			dvd2.setLength(lengthTmp);
			dvd2.setCost(costTmp);
		}
		else {
			System.out.println("Error! Could not find the disc!");
		}
	}
}
