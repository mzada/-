package com.my.barrage_unite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Cmd {
	public void unite(String cmdPath, int tot) {
		File ans = new File(cmdPath, "process.txt");
		if(ans.exists())
			ans.delete();
		try {
			FileOutputStream fos = new FileOutputStream(ans);
			String s;
			for(int i = 1; i <= tot; ++i) {
				s = "ffmpeg -i " + i + ".flv -vf subtitles=" + i + ".ass -vcodec libx264 out" + i + ".flv\n";
				for(int j = 0; j < s.length(); ++j)
					fos.write(s.charAt(j));
			}
			fos.close();
			File result = new File(cmdPath, "process.bat");
			if(result.exists())
				result.delete();
			ans.renameTo(result);
			Runtime.getRuntime().exec("cmd /k start process.bat", null, new File(cmdPath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}