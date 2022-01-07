package biz_frnt.common;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.Session;
import org.springframework.stereotype.Component;

import biz_frnt.security.EncryptUtils;
import net.sf.json.JSONObject;

@Component
public class EncryptionUtil {
			
	/**
	 * session 에서 복호화된 값을 가져온다.
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public String getSessionInstance(String param, HttpSession session) throws Exception {
		EncryptUtils encUtil = new EncryptUtils();
		String result = (String) session.getAttribute(param);
		return encUtil.aesDecrypt(result);
	}
	
	/**
	 * session 암호화된 값을 입력한다.
	 * @param param
	 * @throws Exception
	 */
	public void setSessionInstance(Map<String, Object> param, HttpSession session) throws Exception {
		EncryptUtils encUtil = new EncryptUtils();
		for (Entry<String, Object> entrySet : param.entrySet()) {
			session.setAttribute(entrySet.getKey(), encUtil.aesEncrypt((String) entrySet.getValue()));
		}
	}
	
	/**
	 * Map 암호화
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> setEncryptToMap(Map<String, Object> paramMap) throws Exception {
		EncryptUtils encUtil = new EncryptUtils();
		Map<String, Object> resultMap = new HashMap<>();
		for (Entry<String, Object> entrySet : paramMap.entrySet()) {
			resultMap.put(entrySet.getKey(), encUtil.aesEncrypt((String) entrySet.getValue()));
		}
		return resultMap;
	}
	
	
	/**
	 * Map 복호화
	 * @param paramMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> getDecryptForMap(Map<String, Object> paramMap) throws Exception {
		EncryptUtils encUtil = new EncryptUtils();
		Map<String, Object> resultMap = new HashMap<>();
		for(Entry<String, Object> entrySet : paramMap.entrySet()) {
			resultMap.put(entrySet.getKey(), encUtil.aesDecrypt((String) entrySet.getValue()));
		}
		return resultMap;
	}
	
	/**
	 * String 암호화
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String setEncryptToString(String str) throws Exception {
		EncryptUtils encUtil = new EncryptUtils();
		return (String) encUtil.aesEncrypt(str);
	}
	
	/**
	 * String 복호화
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public String getDecryptForString(String str) throws Exception {
		EncryptUtils encUtil = new EncryptUtils();
		return (String) encUtil.aesDecrypt(str);
	}
	
	

}
