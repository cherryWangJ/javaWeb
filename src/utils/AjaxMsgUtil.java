/**   
 * @Title: AjaxMsgUtil.java 
 * @Package cn.hwadee.core.util 
 * @Description: Ajax消息返回工具类
 * @author xiangping
 * @date 2016年6月3日 上午11:46:30 
 * @version V1.0   
 */
package utils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author wuyang
 * 依赖包：/Day3/WebContent/WEB-INF/lib/fastjson-1.2.12.jar
 *
 */
public class AjaxMsgUtil {

	// 返回的状态值：200-代表成功 300-代表失败
	private final static String STATUSCODE = "statusCode";
	// 返回的描述信息
	private final static String MESSAGE = "message";

	/**
	 * ajax提交成功返回值
	 * 
	 * @param msg
	 * @return
	 */
	public static String ajaxSuccess(Object msg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(STATUSCODE, 200);
		jsonObject.put(MESSAGE, msg);
		return jsonObject.toJSONString();
	}

	/**
	 * ajax提交失败返回值
	 * 
	 * @param msg
	 * @return
	 */
	public static String ajaxFail(String msg) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(STATUSCODE, 300);
		jsonObject.put(MESSAGE, msg);
		return jsonObject.toJSONString();
	}
}
