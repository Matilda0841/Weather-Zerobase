package zerobase.weather.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.Domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class JDBCMemoRepositoryTest {

  @Autowired
  JDBCMemoRepository jdbcMemoRepository;

  @Test
  void insertMemoTest(){
    // given 어떤 데이터가 있을때
    Memo newMemo = new Memo(2, "새로운 메모 2번째");

    // when 어떤 동작을 하면
    jdbcMemoRepository.save(newMemo);

    // then 어떤 결과가 나와야 한다
    Optional<Memo> result = jdbcMemoRepository.findById(2);
    assertEquals("새로운 메모 2번째", result.get().getText());


  }

  @Test
  void findAllMemoTest(){
    // given 어떤 데이터가 있을때
    List <Memo> memoList = jdbcMemoRepository.findAll();


    // when 어떤 동작을 하면
    System.out.println(memoList);


    // then 어떤 결과가 나와야 한다
    assertNotNull(memoList);


  }


}