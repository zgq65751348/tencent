package net.tyrannosaurus.redis.repository;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import net.tyrannosaurus.redis.entity.Fire;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FireRepository  extends BaseMapper<Fire> {


}
