package zerobase.weather.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.Domain.Memo;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class JPAMemoRepositoryTest {

  @Autowired
  JPAMemoRepository jpaMemoRepository;

  @Test
  void insertMemoTest(){
    // given 어떤 데이터가 있을때
    Memo  newMemo = new Memo(10,"jpa 테스트 중");

    // when 어떤 동작을 하면
    jpaMemoRepository.save(newMemo);

    // then 어떤 결과가 나와야 한다
    List<Memo> memoList = jpaMemoRepository.findAll();
    assertTrue(memoList.size() >0 );

  }
  @Test
  void findByIdTest(){
    // given 어떤 데이터가 있을때
    Memo newMemo = new Memo(11, "jpa 테스트 중");

    // when 어떤 동작을 하면
    Memo memo = jpaMemoRepository.save(newMemo);
    System.out.println(memo.getId()); // 5
    // ?? db에가서 새로 id를 5를 받아 오게 되어서 바뀜 >>

    // then 어떤 결과가 나와야 한다
    Optional<Memo> result = jpaMemoRepository.findById(memo.getId());
    assertEquals(result.get().getText(), "jpa 테스트 중");

  }
}