/**   
 * @Title: PageData.java 
 * @Package cn.hwadee.core.dto 
 * @Description: 页面传输对象
 * @author xiangping
 * @date 2016年6月23日 下午2:19:54 
 * @version V1.0   
 */
package utils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.map.CaseInsensitiveMap;
import org.apache.commons.lang3.StringUtils;



/**
 * @author wuyang
 *
 */
public class PageData extends HashMap<Object, Object> implements
		Map<Object, Object>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Map<Object, Object> map;

	@SuppressWarnings("unchecked")
	public PageData(HttpServletRequest request) {
		Map<String, String[]> properties = request.getParameterMap();
		Map<Object, Object> returnMap = new CaseInsensitiveMap();
		Iterator<Entry<String, String[]>> entries = properties.entrySet()
				.iterator();
		Map.Entry<String, String[]> entry;

		while (entries.hasNext()) {
			String name = StringUtils.EMPTY;
			String value = StringUtils.EMPTY;
			entry = entries.next();
			name = entry.getKey();
			value = StringUtils.EMPTY;
			String[] valueObj = entry.getValue();
			if (null == valueObj) {
				value = StringUtils.EMPTY;
			} else if (valueObj instanceof String[]) {
				for (int i = 0; i < valueObj.length; i++) {
					value += valueObj[i] + ",";
				}
				value = value.substring(0, value.length() - 1);
			} else {
				value = String.valueOf(valueObj);
			}

			value = StringUtils.trim(value);
			returnMap.put(name, value);
		}

		map = returnMap;
	}

	@SuppressWarnings("unchecked")
	public PageData() {
		map = new CaseInsensitiveMap();
	}

	@Override
	public Object get(Object key) {
		Object obj = null;
		// 第一种情况，不包含Key
		if (!map.containsKey(key)) {
			return null;
		}
		if (map.get(key) instanceof Object[]) {
			Object[] objArr = (Object[]) map.get(key);
			obj = objArr[0];
		} else {
			obj = map.get(key);
		}
		return obj;
	}

	public String getString(Object key) {
		if (null == get(key)) {
			return null;
		} else {
			return String.valueOf(get(key));
		}
	}

	@Override
	public Object put(Object key, Object value) {
		return map.put(key, value);
	}

	@Override
	public Object remove(Object key) {
		return map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Set<Entry<Object, Object>> entrySet() {
		return map.entrySet();
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Set<Object> keySet() {
		return map.keySet();
	}

	@Override
	public void putAll(Map<? extends Object, ? extends Object> m) {
		map.putAll(m);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Collection<Object> values() {
		return map.values();
	}
}
