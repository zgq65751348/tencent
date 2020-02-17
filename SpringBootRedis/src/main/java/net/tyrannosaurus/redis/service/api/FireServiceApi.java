package net.tyrannosaurus.redis.service.api;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import net.tyrannosaurus.redis.entity.Fire;
import net.tyrannosaurus.redis.repository.FireRepository;
import net.tyrannosaurus.redis.service.FireService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class FireServiceApi extends ServiceImpl<FireRepository, Fire> implements FireService {

    @Resource
    private FireRepository fireRepository;

    @Override
    public List<Fire> getFires() {
        return selectList(null);
    }

    @Cacheable(value = "fire",keyGenerator = "keyGenerator")
    @Override
    public Fire selectFireById(Long id) {
        return fireRepository.selectById(id);
    }

    @Override
    public void createFire() {
        Fire fire = new Fire();
        fire.setName("净莲妖火");
        fire.setOwner("七星斗圣");
        fireRepository.insert(fire);
    }
}
