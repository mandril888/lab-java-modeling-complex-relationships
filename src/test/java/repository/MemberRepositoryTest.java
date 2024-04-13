package repository;

import static org.junit.jupiter.api.Assertions.*;

import enums.MemberStatus;
import model.Chapter;
import model.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {


    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ChapterRepository chapterRepository;
    Chapter chapter1;
    Chapter chapter2;
    Member member1;
    Member member2;
    Member member3;
    Member member4;


    @BeforeEach
    void setUp() {
        Date date = new Date();
        chapter1 = new Chapter();
        chapter2 = new Chapter();
        chapterRepository.save(chapter1);
        chapterRepository.save(chapter2);
        member1 = new Member("Thais", MemberStatus.ACTIVE, date,chapter1);
        member2 = new Member("Ricard", MemberStatus.LAPSED, date,chapter1);
        member3 = new Member("Monica", MemberStatus.ACTIVE, date,chapter2);
        member4 = new Member("Victor", MemberStatus.ACTIVE, date,chapter2);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
    }

    @AfterEach
    void tearDown() {
        memberRepository.deleteAll();
    }


    @Test
    public void createMember(){
        memberRepository.save(member1);
        Optional<Member> memberFound = memberRepository.findByMemberId(member1.getMemberId());
        assertTrue(memberFound.isPresent());
        assertEquals(member1.getMemberId(),memberFound.get().getMemberId());
    }
}