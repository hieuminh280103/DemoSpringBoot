package vn.hieuminh.spring6.Project.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import vn.hieuminh.spring6.Project.entity.*;
import vn.hieuminh.spring6.Project.entity.Class;

import java.util.List;

public interface MyService {
    //CLASS
    public void saveClass(Class aclass);
    public Class findClassById(long id);
    public Class updateClass(Class aclass);
    public void deleteClassById(long id);

    //SCHOOL
    public void saveSchool(School school);
    public School findSchoolById(long id);
    public School updateSchool(School school);
    public void deleteSchoolById(long id);

    //STAFF
    public void saveStaff(Staff staff);
    public Staff findStaffById(long id);
    public Staff updateStaff(Staff staff);
    public void deleteStaffById(long id);
    public Information findInformationByStaffId(long id);

    //STUDENT
    public void saveStudent(Student student);
    public Student findStudentById(long id);
    public Student updateStudent(Student student);
    public void deleteStudentById(long id);

    //SUBJECT
    public void saveSubject(Subject subject);
    public Subject findSubjectById(long id);
    public Subject updateSubject(Subject subject);
    public void deleteSubjectById(long id);

    //SUBJECT_SCORE
    public void saveSubjectScore(SubjectScore subjectScore);
    public SubjectScore findSubjectScoreById(long id);
    public SubjectScore updateSubjectScore(SubjectScore subjectScore);
    public void deleteSubjectScoreById(long id);

    //TRANSCTIPT
    public void saveTranscript(Transcript transcript);
    public Transcript findTranscriptById(long id);
    public Transcript updateTranscript(Transcript transcript);
    public void deleteTranscriptById(long id);

    //NOTEBOOK
    public void saveNotebook(Notebook notebook);
    public Notebook findNotebookById(long id);
    public Notebook updateNotebook(Notebook staff);
    public void deleteNotebookById(long id);

    //SCHOOL_RECORD
    public void saveSchoolRecord(SchoolRecord schoolRecord);
    public SchoolRecord findSchoolRecordById(long id);
    public SchoolRecord updateSchoolRecord(SchoolRecord schoolRecord);
    public void deleteSchoolRecordById(long id);

    //SCORE_CARD
    public void saveScoreCard(ScoreCard scoreCard);
    public ScoreCard findScoreCardById(long id);
    public ScoreCard updateScoreCard(ScoreCard scoreCard);
    public void deleteScoreCardById(long id);

    //PARENT
    public void saveParent(Parent parent);
    public Parent findParentById(long id);
    public Parent updateParent(Parent parent);
    public void deleteParentById(long id);

    //USER
    public void saveUser(User user);
    public List<User> getAllUser();
    public void deleteUserByUsername(String username);
    public User findUserByUsername(String username);
    public void updateUser(User user);
    public Staff findStaffByUsername(String username);

    //INFORMATION
    public Information findInformationById(long id);
    public Information updateInformation(Information information);
}
