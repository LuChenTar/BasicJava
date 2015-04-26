
/* ShoeSize - Eric McCreath 2015 - GPL 
 * This class stores a persons shoe size.
 * Modified by Lu Chen 16 Mar 2015
 * Store in JSON
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class ShoeSize {
	private static final String SHOESIZEENAME = "SHOESIZE";
	public static final int SHOESIZEMAX = 15;
	public static final int SHOESIZEMIN = 3;

	static final String FILENAME = "shoesize.json";

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
		File f = new File(FILENAME);
		try {
			JSONObject obj = (JSONObject) JSONValue.parse(new FileReader(f));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	void save() {
		// add code here that will load shoe size from a file called "FILENAME"
        File f = new File(FILENAME);
        JSONObject obj = new JSONObject();
        obj.put("size", shoesize);
        
        FileWriter out;
        try {
        	out = new FileWriter(f);
        	obj.writeJSONString(out);
        	out.close();
        }catch(IOException e) {
        	e.printStackTrace();
        }
	}
}
