package com.lk.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws IOException {
		InputStream is = App.class.getClassLoader().getResourceAsStream("test3.json");
		ObjectMapper objectMapper = new ObjectMapper();
		Map map = objectMapper.readValue(is, Map.class);
		String sum = (String) map.get("RESULT_DIS_SUMMARY");
		JSONArray summaryList = JSONArray.fromObject(sum);

		String archiveTaskId = "daa9f34de95c406fb9710133b0f19b3a";
		String originalId = "fb124b34649141fca288acbf939264ca";
		String taskName = "财险业绩日报分机构";
		String workDir = "/home/bea1/tmp/distribution/archive/fb124b34649141fca288acbf939264ca/20180611081000/";
		String errorMailAddress = "";
		String fileName = "";
		String reportId = "421486373712310";
		String reportName = "财险业绩日报分机构";
		JSONArray jsonArray = new JSONArray();

		List<TaskInstance> list = new ArrayList<TaskInstance>();
		Iterator<JSONObject> iterator = summaryList.iterator();
		int i = 0;
		while(iterator.hasNext()){
			JSONObject summary = iterator.next();
			TaskInstance.InstanceStatus status = TaskInstance.InstanceStatus.valueOf(summary.getString("result").toUpperCase());
			String to = summary.getString("mail");

			String attachName = summary.getString("attachName");
			String exceptionMessage = summary.getString("exception");
			Date stringStartDate = Util.timeStmpTodate(summary.getString("startTime"));
			Date stringEndDate = Util.timeStmpTodate(summary.getString("endTime"));
			TaskInstance taskInstance = new TaskInstance(archiveTaskId, originalId, taskName, "EMAIL", status,
					jsonArray.toString(), to, null, null, new Date(), workDir,reportName, attachName,
					exceptionMessage,reportId,stringStartDate,stringEndDate,errorMailAddress,fileName);
			if(taskInstance.getExceptionMessage().length()>4000){
				/*String errorMessage = taskInstance.getExceptionMessage();
				System.out.println("索引：" + i);
				errorMessage = errorMessage.replaceAll(" {2,}", " ").replaceAll("[\\r\\n]", "");
				System.out.println(errorMessage);
				if (errorMessage.length() > 4000) {
					System.out.println(errorMessage);
					// 20181206 李坤 在去掉多空格和换行后长度仍然大于4000，则截取字符串
					errorMessage = errorMessage.substring(0, 4000);
				}
				// 20181206 李坤 将处理后的字符串赋值给原对象
				taskInstance.setExceptionMessage(errorMessage);*/
				StringBuilder builder = new StringBuilder();
				for (int j = 0; j < 2000; j++) {
					builder.append("数");
				}
				String s = builder.toString();
				System.out.println(s.length());
				System.out.println(s.getBytes().length);
				taskInstance.setExceptionMessage(s);
				list.add(taskInstance);
			}
			i++;
//			list.add(taskInstance);
		}
		System.out.println(list.size());

		InstanceDao instanceDao = new InstanceDaoImpl();
		for (TaskInstance taskInstance : list) {
			instanceDao.insert(taskInstance);
		}
	}
}
