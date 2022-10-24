package zerobase.weather;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.domain.Memo;
import zerobase.weather.repository.JdbcMemorepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
// @Transactional
public class JdbcMemorepositoryTest {

    @Autowired
    JdbcMemorepository jdbcMemorepository;

    @Test
    void insertMemoTest(){

        //given
        Memo newMemo = new Memo(3, "insertMemoTest2"); //주어지는거

        //when
        jdbcMemorepository.save(newMemo); // 언제

        //then
        Optional<Memo> result = jdbcMemorepository.findById(3);
        assertEquals(result.get().getText(), "insertMemoTest2"); // 예상되는 결과값
    }

    @Test
    void findAllMemoTest(){
        List<Memo> memoList = jdbcMemorepository.findAll();
        System.out.println(memoList);
        assertNotNull(memoList);

    }
}
