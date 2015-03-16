
/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 * Modified by Lu Chen 16 Mar 2015
 * Serializable Storage
 */

import java.io.*;


public class ShoeSize implements Serializable {
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.bin";

	private Integer shoesize;

	public ShoeSize() {
		shoesize = null;
		load();
	}

	public String show() {
		return (shoesize == null ? "" : shoesize.toString());
	}

	public boolean set(Integer v) {
		if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
			shoesize = v;
			save();
			return true;
		} else {
			shoesize = null;
			return false;
		}
	}

	void load() {
		// add code here that will load shoe size into a file called "FILENAME"
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(FILENAME));
//            System.out.println(is.readObject());
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	void save() {
		// add code here that will load shoe size from a file called "FILENAME"
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILENAME));
            oos.writeObject(shoesize);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done saving");
	}
}
