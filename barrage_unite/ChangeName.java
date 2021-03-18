package com.my.barrage_unite;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ChangeName {
	private int tot = 0;
	Map<String, Integer> newName = new HashMap<>();
	
	public int changeName(String floderPath) {
		File floder = new File(floderPath);
		String[] files = floder.list();
		for(String item : files) {
			File file = new File(floderPath, item);
			//获取后缀
			String lstName = item.substring(item.indexOf("."));
			if(lstName.equals(".ass") || lstName.equals(".flv")) {
				String name = item.substring(0, item.indexOf("."));
				if(newName.containsKey(name)) { //存在对应文件名
					//修改名称
					file.renameTo(new File(floderPath + "\\" + newName.get(name) + lstName));
				} else {
					//添加
					newName.put(name, ++tot);
					//修改名称
					File after = new File(floderPath + "\\" + newName.get(name) + lstName);
					file.renameTo(after);
				}
			}
		}
		return this.tot;
	}
}