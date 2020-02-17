package net.tyrannosaurus.redis.controller;

import net.yrannosaurus.common.core.ResultDataBean;
import net.tyrannosaurus.redis.service.FireService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value="/fire")
public class FireController {

    @Resource
    private FireService fireService;

    @GetMapping(value ="/select/{id}")
    public ResultDataBean selectOne(@PathVariable("id") Long id){
        return ResultDataBean.builderEntity(fireService.selectFireById(id)) ;
    }

    @GetMapping(value="/create")
    public void createFire(){
        fireService.createFire();
    }
}
