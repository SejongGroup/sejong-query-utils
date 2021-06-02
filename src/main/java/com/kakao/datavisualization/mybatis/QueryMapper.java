/**
 * 
 */
package com.kakao.datavisualization.mybatis;

import java.util.List;
import java.util.Map;

/**
 * @FileName	: QueryMapper.java
 * @Project		: QueryUtil
 * @Date		: 2021. 6. 2.
 * @Author		: JH.KIM
 * @Description : 
 * ==========================================================
 * DATE				AUTHOR				NOTE
 * ==========================================================
 *
 */
public interface QueryMapper {
	List<Map<String, Object>> selectAll();
}
