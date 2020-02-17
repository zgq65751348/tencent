package net.tyrannosaurus.redis.service;

import com.baomidou.mybatisplus.service.IService;
import net.tyrannosaurus.redis.entity.Fire;


import java.util.List;

public interface FireService extends IService<Fire> {

    List<Fire> getFires();

    Fire selectFireById(Long id);

    void  createFire();
}
