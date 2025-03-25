package example.day11.Task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Mapper
public interface TaskMapper {
    @Update("UPDATE day11products SET stock_quantity = stock_quantity - 3 WHERE stock_quantity >= 3")
    int task1();

    @Select("select * from day11products")
    List<Map<String, Object>> task2();

    @Update("UPDATE day11products SET stock_quantity = stock_quantity + 20 WHERE stock_quantity < 10")
    int task3();
}
