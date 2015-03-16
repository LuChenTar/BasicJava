
/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 * Modified by Lu Chen 16 Mar 2015
 * TXT database
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public class ShoeSize {
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.txt";

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
            BufferedReader lr = Files.newBufferedReader(
                    new File(FILENAME).toPath(), Charset.forName("US-ASCII"));
            System.out.println(lr.readLine().split(":"));//print if data is loaded
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	void save() {
		// add code here that will save shoe size from a file called "FILENAME"
        try {
            BufferedWriter lw = Files.newBufferedWriter(
                    new File(FILENAME).toPath(), Charset.forName("US-ASCII"));
            lw.append(shoesize.toString());
            lw.newLine();
            lw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
