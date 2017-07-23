package com.mosquito.utils;

public class Tools {


	/**
	 * 获取文章摘要
	 * @param content
	 * @return
	 */
	public static String findAbstractEnd(String content){
		String abstractcintent = "";
		int loc = 0;
		for(int i=0;i<3;i++){
			loc=content.indexOf("</p>",loc+4);
		}
		if(loc<300){
			abstractcintent=content;
		}else{
			abstractcintent=content.substring(0, loc+4);
		}
		return abstractcintent;
	}
}
