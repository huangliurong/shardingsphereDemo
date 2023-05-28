package org.hlr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shardingsphere.api.hint.HintManager;
import org.hlr.entity.Course;
import org.hlr.mapper.CourseMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingTest {

    @Resource
    private CourseMapper courseMapper;

    @Test
    public void addCourse(){
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
//            course.setId("2");
            course.setName("hlr");
            course.setAge(30L);
            courseMapper.insert(course);
        }
    }
    @Test
    public void queryCourse(){

        QueryWrapper<Course> wrapper = new QueryWrapper<>();
//        wrapper.eq("id", 1662672574516510722L);
//        wrapper.between("id", 1662672574516510722L, 1662672574646534146L);
//        wrapper.in("id", 1662705601720258563L, 1662705601850281987L);
//        wrapper.between("age", 10L, 40L);

        HintManager hintManager = HintManager.getInstance();
        hintManager.addTableShardingValue("course", "2");

        List<Course> courses = courseMapper.selectList(wrapper);
        System.out.println("结果如下 -------------- > ");
        for (Course c : courses){
            System.out.println(c);
        }

    }
}
