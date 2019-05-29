package com.lk.app;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Util {
	// -------------------------------------------------------------------------------------------------------------------

	public static boolean strIsNumeric(String str) {
		try {
			Double.valueOf(str);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	public static String strToUpperCase(String str) {
		if (null == str) {
			return "";
		} else {
			return str.toUpperCase();
		}
	}

	public static String strToTrimedString(CharSequence obj) {

		String rtn = "";

		if (!otIsEmpty(obj)) {

			rtn = obj.toString().trim();
		}

		return rtn;
	}

	public static String strNullToSpace(String str) {
		if (otIsEmpty(str)) {
			return "";
		}

		return str;
	}

	public static int strToInt(String obj) {

		int rtn = 0;

		if (!otIsEmpty(obj)) {

			try {
				rtn = Integer.parseInt(obj.toString().trim());

			} catch (NumberFormatException ex) {
				rtn = 0;
			}
		}
		return rtn;
	}

	public static double strToDouble(String obj) {

		double rtn = 0;

		if (!otIsEmpty(obj)) {

			try {
				rtn = Double.parseDouble(obj.toString().trim());

			} catch (NumberFormatException ex) {
				rtn = 0;
			}
		}
		return rtn;
	}

	// -------------------------------------------------------------------------------------------------------------------
	public static String otXmlEscape(String wrkStr) {

		// 処理対象文字列がない場合は変換処理をしない
		if (otIsEmpty(wrkStr)) {
			return "";
		}

		StringBuffer wrkStrBuff = new StringBuffer();

		for (int i = 0; i < wrkStr.length(); i++) {

			if (wrkStr.charAt(i) == '&') {
				wrkStrBuff.append("&amp;");
			} else if (wrkStr.charAt(i) == '<') {
				wrkStrBuff.append("&lt;");
			} else if (wrkStr.charAt(i) == '>') {
				wrkStrBuff.append("&gt;");
			} else if (wrkStr.charAt(i) == '"') {
				wrkStrBuff.append("&quot;");
			} else if (wrkStr.charAt(i) == '\'') {
				wrkStrBuff.append("&apos;");
			} else {
				wrkStrBuff.append(wrkStr.charAt(i));
			}
		}
		return wrkStrBuff.toString();
	}

	public static boolean otIsEmpty(CharSequence input) {

		if (input != null) {
			return input.toString().trim().length() == 0;
		} else {
			return true;
		}
	}

	public static boolean otIsNotEmpty(Object input) {

		if (input != null) {
			if ("".equals(input.toString().trim())) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * Write object to file
	 * 
	 * @author hansong
	 * @param file
	 * @param obj
	 * @throws IOException
	 */
	public static void fsWriteObject(File file, Object obj) throws IOException {
		FileOutputStream o = new FileOutputStream(file);
		ObjectOutputStream out = new ObjectOutputStream(o);
		out.writeObject(obj);
		out.flush();
		out.close();
	}

	/**
	 * Read object from file
	 * 
	 * @author hansong
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object fsReadObject(File file) throws IOException,
			ClassNotFoundException {
		if (!file.exists()) {
			return null;
		}
		FileInputStream i = new FileInputStream(file);
		ObjectInputStream in = new ObjectInputStream(i);
		Object obj = in.readObject();
		return obj;
	}

	/**
	 * Write object to file
	 * 
	 * @author hansong
	 * @param filepath
	 * @param obj
	 * @throws IOException
	 */
	public static void fsWriteObject(String filepath, Object obj)
			throws IOException {
		fsWriteObject(new File(filepath), obj);
	}

	/**
	 * 
	 * @author hansong
	 * @param filepath
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object fsReadObject(String filepath) throws IOException,
			ClassNotFoundException {
		return fsReadObject(new File(filepath));
	}

	/**
	 * 
	 * @author hansong
	 * @param c
	 * @return
	 */
	public static URL fsUrlAbsolutePath(Class c) {
		return c.getResource("");
	}

	/**
	 * 
	 * @author hansong
	 * @param c
	 * @param encoding
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fsAbsolutePath(Class c, String encoding)
			throws UnsupportedEncodingException {
		String path = c.getResource("").toString();
		path = URLDecoder.decode(path, encoding);
		int start = path.indexOf('/');
		int end = path.lastIndexOf('/');
		if (start != -1 && end != -1 && start != end) {
			start += 1;
			end += 1;
		}
		path = path.substring(start, end).replaceAll("/", "\\\\");
		return path;
	}

	/**
	 * 
	 * @author hansong
	 * @param c
	 * @param relativePath
	 * @param encoding
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String fsRelativePathToAbsolutePath(Class c,
													  String relativePath, String encoding)
			throws UnsupportedEncodingException {
		String path = Util.fsAbsolutePath(c, encoding);
		if (!Util.otIsEmpty(relativePath)) {
			relativePath = relativePath.replaceAll("/", "\\");

			String[] folder = path.split("\\\\");
			int floor = folder.length;
			int start = -3;
			while ((start = relativePath.indexOf("..\\", start + 3)) != -1
					&& floor > 1) {
				floor--;
			}

			path = "";
			for (int i = 0; i < floor; i++) {
				path += folder[i] + "\\";
			}

			int end0 = relativePath.lastIndexOf("..\\");
			int end1 = relativePath.lastIndexOf(".\\");
			int end = 0;
			if (end0 != end1) {
				end = end0 > end1 ? end0 + 3 : end1 + 2;
			}

			path += relativePath.substring(end);// .replaceAll("/", "\\\\");
		}

		return path;
	}

	/**
	 * 
	 * @author hansong
	 * @param c
	 * @return
	 */
	public static String fsAbsolutePath(Class c) {
		String path = c.getResource("").toString();
		int start = path.indexOf('/');
		int end = path.lastIndexOf('/');
		if (start != -1 && end != -1 && start != end) {
			start += 1;
			end += 1;
		}
		path = path.substring(start, end).replaceAll("/", "\\\\");
		return path;
	}

	/**
	 * 
	 * @author hansong
	 * @param c
	 * @param relativePath
	 * @return
	 */
	public static String fsRelativePathToAbsolutePath(Class c,
													  String relativePath) {
		String path = Util.fsAbsolutePath(c);
		if (!Util.otIsEmpty(relativePath)) {
			relativePath = relativePath.replaceAll("/", "\\");

			String[] folder = path.split("\\\\");
			int floor = folder.length;
			int start = -3;
			while ((start = relativePath.indexOf("..\\", start + 3)) != -1
					&& floor > 1) {
				floor--;
			}

			path = "";
			for (int i = 0; i < floor; i++) {
				path += folder[i] + "\\";
			}

			int end0 = relativePath.lastIndexOf("..\\");
			int end1 = relativePath.lastIndexOf(".\\");
			int end = 0;
			if (end0 != end1) {
				end = end0 > end1 ? end0 + 3 : end1 + 2;
			}

			path += relativePath.substring(end);// .replaceAll("/", "\\\\");
		}

		return path;
	}

	public static boolean deleteDir(File dir) {

		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}

		// The directory is now empty so now it can be smoked
		return dir.delete();
	}

	public static File fsFindFile(String baseDirName, String targetFileName,
								  boolean subFolder) {
		Queue<File> subFolders = new LinkedList<File>();

		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || !baseDir.isDirectory()) {
			return null;
		}

		File folder = null;
		subFolders.offer(baseDir);
		while ((folder = subFolders.poll()) != null) {
			File[] allFiles = folder.listFiles();
			for (File file : allFiles) {
				if (subFolder && file.isDirectory()) {
					subFolders.offer(file);
				} else {
					String tempName = file.getName();
					if (wildcardMatch(targetFileName, tempName)) {
						return file;
					}
				}
			}
		}

		return null;
	}

	public static File fsFindForder(String baseDirName, String targetDirName,
									boolean subFolder) {
		Queue<File> subFolders = new LinkedList<File>();

		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || !baseDir.isDirectory()) {
			return null;
		}

		File folder = null;
		subFolders.offer(baseDir);
		while ((folder = subFolders.poll()) != null) {
			File[] allFiles = folder.listFiles();
			for (File file : allFiles) {
				if (file.isDirectory()) {
					String tempName = file.getName();
					if (wildcardMatch(targetDirName, tempName)) {
						return file;
					}

					if (subFolder) {
						subFolders.offer(file);
					}
				}
			}
		}

		return null;
	}

	public static List<File> fsFindFiles(String baseDirName,
										 String targetFileName, boolean subFolder) {
		List<File> fileList = new ArrayList<File>();
		Queue<File> subFolders = new LinkedList<File>();

		File baseDir = new File(baseDirName);
		if (!baseDir.exists() || !baseDir.isDirectory()) {
			return fileList;
		}

		File folder = null;
		subFolders.offer(baseDir);
		while ((folder = subFolders.poll()) != null) {
			File[] allFiles = folder.listFiles();
			for (File file : allFiles) {
				if (subFolder && file.isDirectory()) {
					subFolders.offer(file);
				} else {
					String tempName = file.getName();
					if (wildcardMatch(targetFileName, tempName)) {
						fileList.add(file);
					}
				}
			}
		}

		return fileList;
	}

	public static void writeFile(File filePath, String sets) throws IOException {
		FileWriter fw = new FileWriter(filePath);
		PrintWriter out = new PrintWriter(fw);
		out.write(sets);
		out.println();
		fw.close();
		out.close();
	}

	public static String readFile(File file) {
		BufferedReader reader = null;
		String laststr = "";
		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				laststr = laststr + tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return laststr;
	}

	private static boolean wildcardMatch(String pattern, String str) {
		int patternLength = pattern.length();
		int strLength = str.length();
		int strIndex = 0;
		char ch;
		for (int patternIndex = 0; patternIndex < patternLength; patternIndex++) {
			ch = pattern.charAt(patternIndex);
			if (ch == '*') {
				while (strIndex < strLength) {
					if (wildcardMatch(pattern.substring(patternIndex + 1),
							str.substring(strIndex))) {
						return true;
					}
					strIndex++;
				}
			} else if (ch == '?') {
				strIndex++;
				if (strIndex > strLength) {
					return false;
				}
			} else {
				if ((strIndex >= strLength) || (ch != str.charAt(strIndex))) {
					return false;
				}
				strIndex++;
			}
		}
		return (strIndex == strLength);
	}

	public static Date dtToDate(String yyyymmdd) {
		int[] ymd = dtSplitDateToInt(yyyymmdd);

		return dtCreateDate(ymd[0], ymd[1], ymd[2]);
	}

	public static int[] dtSplitDateToInt(String yyyymmdd) {
		int[] ymd = new int[3];
		ymd[0] = ymd[1] = ymd[2] = 0;

		if (yyyymmdd == null || 8 != yyyymmdd.length()) {
			throw new IllegalArgumentException("yyyymmdd length != 8");
		}

		ymd[0] = Integer.parseInt(yyyymmdd.substring(0, 4));
		ymd[1] = Integer.parseInt(yyyymmdd.substring(4, 6));
		ymd[2] = Integer.parseInt(yyyymmdd.substring(6, 8));
		return ymd;
	}

	public static Date dtCreateDate(int yyyy, int mm, int dd) {
		GregorianCalendar gc = new GregorianCalendar(yyyy, mm - 1, dd);
		gc.setLenient(false);
		return gc.getTime();
	}

	/**
	 * 对输入的字符串进行URL编码, 即转换为%20这种形式
	 * 
	 * @param input
	 *            原文
	 * @return URL编码. 如果编码失败, 则返回原文
	 */
	public static String encode(String input, String charset) {
		if (input == null || input.length() == 0) {
			return "";
		}

		if (charset == null) {
			charset = "UTF-8";
		}

		// Return if already encoded
		// if (MyUtils.strIsAllAlphabet(input)) {
		// return input;
		// }
		// int i = input.indexOf('%');
		// if (i != -1) {
		// char n = input.charAt(i + 1);
		// if (n >= '0' && n <= '9') {
		// return input;
		// }
		// }

		try {
			return URLEncoder.encode(input, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return input;
	}

	public static String encodeUrl(String url, String charset) {
		if (url == null || url.length() == 0) {
			return "";
		}

		int i = url.indexOf('?');
		if (i != -1) {
			Map<String, String> paramsMap = extractParams(url);

			String hostUrl = url.substring(0, i);

			return getUrlWithRequestParams(hostUrl, paramsMap, charset);
		}

		return url;
	}

	public static Map<String, String> extractParams(String url) {
		if (url == null || url.length() == 0) {
			return null;
		}

		Map<String, String> paramsMap = new HashMap<String, String>();

		int i = -1;
		if (url.charAt(0) == '/') { // Relation path
			i = 1;
		} else {
			i = url.indexOf('?'); // http://xx?xxx=xx
		}

		if (i != -1) {
			String param = url.substring(i + 1).trim();
			String[] params = param.split("&");
			for (int j = 0; j < params.length; j++) {
				param = params[j];
				String[] kv = param.split("=");
				if (kv.length == 2) {
					paramsMap.put(kv[0], kv[1]);
				} else if (kv.length == 1) {
					paramsMap.put(kv[0], "");
				}
			}
		}

		return paramsMap;
	}

	public static String getUrlWithRequestParams(String url,
												 Map<String, String> params, String charset) {
		if (params == null || params.size() == 0) {
			return url;
		}

		StringBuilder builder = new StringBuilder(url);
		if (url.contains("?")) {
			builder.append("&");
		} else {
			builder.append("?");
		}

		int i = 0;
		for (String key : params.keySet()) {
			String value = params.get(key);
			if (value == null) { // 过滤空的key
				continue;
			}

			if (i != 0) {
				builder.append('&');
			}

			builder.append(key);
			builder.append('=');
			builder.append(encode(value, charset));
			// builder.append(value);

			i++;
		}

		return builder.toString();
	}

	public static String encode(String input) {
		if (input == null) {
			return input;
		}
		StringBuilder sb = new StringBuilder(input.length());
		for (int i = 0, c = input.length(); i < c; i++) {
			char ch = input.charAt(i);
			switch (ch) {
			case '&':
				sb.append("&amp;");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case '"':
				sb.append("&quot;");
				break;
			case '\'':
				sb.append("&#x27;");
				break;
			case '/':
				sb.append("&#x2F;");
				break;
			default:
				sb.append(ch);
			}
		}
		return sb.toString();
	}
	
	public static Date timeStmpTodate(String dateString) {
		
		String sDate=null;
		Date dateSdate=null;
		 SimpleDateFormat sdf1 = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.UK);
	       try
	       {
	       	    Date date=sdf1.parse(dateString);
	       	    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	       	    sDate=sdf.format(date);
	       	    SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	           dateSdate=sdf2.parse(sDate);
	       }
	       catch (ParseException e)
	       {
	           e.printStackTrace();
	       }
	       
		return dateSdate;
	
		
	}
	
	@SuppressWarnings("all")
	public static Map mapCombine(List<Map> list) {
        Map<Object, List> map = new HashMap();
        for (Map m : list) {
            Iterator<Object> it = m.keySet().iterator();
            while (it.hasNext()) {  
                Object key = it.next();
                if (!map.containsKey(key)) {  
                    List newList = new ArrayList();
                    newList.add(m.get(key));  
                    map.put(key, newList);  
                } else {  
                    map.get(key).add(m.get(key));  
                }  
            }  
        }  
        return map;  
    }  
	
	public static String formatSubstr(String str) {

		String tempstr = "";
		String substriAfter = str;
		String string="],";
		while (substriAfter.toUpperCase().indexOf(string) != -1) {
				int indexOfnumber = substriAfter.toUpperCase().indexOf(string) + 2;
				tempstr = tempstr + substriAfter.substring(0, indexOfnumber)+"<br><br>";
				substriAfter = substriAfter.substring(indexOfnumber,
						substriAfter.length());
		}
		String laststr = tempstr + substriAfter;
		//String laststrReplace=laststr.replace("=", "").replace("[", "").replace("]", "");
		return laststr;
	}
	
	public static String formatSubstrTab(String str) {

		String tempstr = "";
		String substriAfter = str;
		String string="：";
		while (substriAfter.toUpperCase().indexOf(string) != -1) {
				int indexOfnumber = substriAfter.toUpperCase().indexOf(string) +1;
				tempstr = tempstr + substriAfter.substring(0, indexOfnumber)+"<br>&nbsp;&nbsp;&nbsp;&nbsp;";
				substriAfter = substriAfter.substring(indexOfnumber,
						substriAfter.length());
		}
		String laststr = tempstr + substriAfter;
		String laststrReplace=laststr.replace("[", "").replace("]", "");
		return laststrReplace;
	}
	
}
