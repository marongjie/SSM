package org.fkit.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.cache.decorators.LruCache;
import org.fkit.domain.User;

@CacheNamespace(eviction=LruCache.class,flushInterval=60000,size=512,
readWrite=true)
public interface UserMapper {
	
	// 根据id查询User
	@Select("SELECT * FROM TB_USER WHERE id = #{id}")
	@Options(useCache=true)
	User selectUserById(Integer id);
	
	// 根据id删除User
	@Delete("DELETE FROM TB_USER WHERE id = #{id}")
	void deleteUserById(Integer id);

}
