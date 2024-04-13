package repository;

import static org.junit.jupiter.api.Assertions.*;

import model.Association;
import model.Chapter;
import model.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChapterRepositoryTest {

    @Autowired
    private AssociationRepository associationRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private ChapterRepository chapterRepository;

    Association association;
    Chapter chapter1;
    Chapter chapter2;
    Member president;
    Member president2;
    Member member1;
    Member member2;
    Member member3;
    Member member4;


    @BeforeEach
    void setUp() {
        List<Chapter> setChapters = new ArrayList<Chapter>();
        List<Member> setMembers1 = new ArrayList<Member>();
        List<Member> setMembers2 = new ArrayList<Member>();
        association = new Association("Nurse association",setChapters);
        associationRepository.save(association);
        president = new Member();
        president2 = new Member();
        member1 = new Member();
        member2 = new Member();
        member3 = new Member();
        member4 = new Member();
        memberRepository.save(president);
        memberRepository.save(president2);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        setMembers1.add(member1);
        setMembers1.add(member2);
        setMembers2.add(member3);
        setMembers2.add(member4);
        chapter1 = new Chapter("Chapter 1", "Distrito 1", president, association, setMembers1);
        chapter2 = new Chapter("Chapter 2", "Distrito 2", president2, association, setMembers2);
        setChapters.add(chapter1);
        setChapters.add(chapter2);
        chapterRepository.save(chapter1);
        chapterRepository.save(chapter2);
    }

    @AfterEach
    void tearDown() {
        chapterRepository.deleteAll();
    }


    @Test
    public void createChapter(){
        Optional<Chapter> chapterFound = chapterRepository.findById(String.valueOf(chapter1.getChapterId()));
        assertTrue(chapterFound.isPresent());
        assertEquals(chapter1.getChapterId(),chapterFound.get().getChapterId());
    }
}