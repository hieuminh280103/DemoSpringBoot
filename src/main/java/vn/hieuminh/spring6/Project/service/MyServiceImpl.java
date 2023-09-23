package vn.hieuminh.spring6.Project.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.hieuminh.spring6.Project.dao.*;
import vn.hieuminh.spring6.Project.entity.*;
import vn.hieuminh.spring6.Project.entity.Class;

import java.util.List;

@Service
public class MyServiceImpl implements MyService{
    private ClassRepository classRepository;
    private SchoolRepository schoolRepository;
    private StaffRepository staffRepository;
    private StudentRepository studentRepository;
    private SubjectRepository subjectRepository;
    private SubjectScoreRepository subjectScoreRepository;
    private TranscriptRepository transcriptRepository;
    private NoteBookRepository noteBookRepository;
    private SchoolRecordRepository schoolRecordRepository;
    private ScoreCardRepository scoreCardRepository;
    private ParentRepository parentRepository;
    private UserRepository userRepository;
    private InformationRepository informationRepository;

    @Autowired
    public MyServiceImpl(ClassRepository classRepository, SchoolRepository schoolRepository, StaffRepository staffRepository, StudentRepository studentRepository, SubjectRepository subjectRepository, SubjectScoreRepository subjectScoreRepository, TranscriptRepository transcriptRepository, NoteBookRepository noteBookRepository, SchoolRecordRepository schoolRecordRepository, ScoreCardRepository scoreCardRepository, ParentRepository parentRepository, UserRepository userRepository, InformationRepository informationRepository) {
        this.classRepository = classRepository;
        this.schoolRepository = schoolRepository;
        this.staffRepository = staffRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.subjectScoreRepository = subjectScoreRepository;
        this.transcriptRepository = transcriptRepository;
        this.noteBookRepository = noteBookRepository;
        this.schoolRecordRepository = schoolRecordRepository;
        this.scoreCardRepository = scoreCardRepository;
        this.parentRepository = parentRepository;
        this.userRepository = userRepository;
        this.informationRepository = informationRepository;
    }

    //CLASS
    @Override
    public void saveClass(Class aclass) {
        this.classRepository.save(aclass);
    }
    @Override
    public Class findClassById(long id) {
        return this.classRepository.findClassById(id);
    }
    @Override
    public Class updateClass(Class aclass) {
        return this.classRepository.saveAndFlush(aclass);
    }
    @Override
    public void deleteClassById(long id) {
        this.classRepository.deleteById(id);
    }

    //SCHOOL
    @Override
    public void saveSchool(School school) {
        this.schoolRepository.save(school);
    }
    @Override
    public School findSchoolById(long id) {
        return this.schoolRepository.findSchoolById(id);
    }
    @Override
    public School updateSchool(School school) {
        return this.schoolRepository.saveAndFlush(school);
    }
    @Override
    public void deleteSchoolById(long id) {
        this.schoolRepository.deleteById(id);
    }

    //STAFF
    @Override
    public void saveStaff(Staff staff) {
        this.staffRepository.save(staff);
    }
    @Override
    public Staff findStaffById(long id) {
        return this.staffRepository.findStaffById(id);
    }
    @Override
    public Staff updateStaff(Staff staff) {
        return this.staffRepository.saveAndFlush(staff);
    }
    @Override
    public void deleteStaffById(long id) {
        this.staffRepository.deleteById(id);
    }
    @Override
    public Information findInformationByStaffId(long id){
        return this.staffRepository.findInformationByStaffId(id);
    }

    //STUDENT
    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }
    @Override
    public Student findStudentById(long id) {
        return this.studentRepository.findStudentById(id);
    }
    @Override
    public Student updateStudent(Student student) {
        return this.studentRepository.saveAndFlush(student);
    }
    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }

    //SUBJECT
    @Override
    public void saveSubject(Subject subject) {
        this.subjectRepository.save(subject);
    }
    @Override
    public Subject findSubjectById(long id) {
        return this.subjectRepository.findSubjectById(id);
    }
    @Override
    public Subject updateSubject(Subject subject) {
        return this.subjectRepository.saveAndFlush(subject);
    }
    @Override
    public void deleteSubjectById(long id) {
        this.subjectRepository.deleteById(id);
    }

    //SUBJECT_SCORE
    @Override
    public void saveSubjectScore(SubjectScore subjectScore) {
        this.subjectScoreRepository.save(subjectScore);
    }
    @Override
    public SubjectScore findSubjectScoreById(long id) {
        return this.subjectScoreRepository.findSubjectScoreById(id);
    }
    @Override
    public SubjectScore updateSubjectScore(SubjectScore subjectScore) {
        return this.subjectScoreRepository.saveAndFlush(subjectScore);
    }
    @Override
    public void deleteSubjectScoreById(long id) {
        this.subjectScoreRepository.deleteById(id);
    }

    //TRANSCRIPT
    @Override
    public void saveTranscript(Transcript transcript) {
        this.transcriptRepository.save(transcript);
    }
    @Override
    public Transcript findTranscriptById(long id) {
        return this.transcriptRepository.findTranscriptById(id);
    }
    @Override
    public Transcript updateTranscript(Transcript transcript) {
        return this.transcriptRepository.saveAndFlush(transcript);
    }
    @Override
    public void deleteTranscriptById(long id) {
        this.transcriptRepository.deleteById(id);
    }

    //NOTEBOOK
    @Override
    public void saveNotebook(Notebook notebook) {
        this.noteBookRepository.save(notebook);
    }
    @Override
    public Notebook findNotebookById(long id) {
        return this.noteBookRepository.findNotebookById(id);
    }
    @Override
    public Notebook updateNotebook(Notebook notebook) {
        return this.noteBookRepository.saveAndFlush(notebook);
    }
    @Override
    public void deleteNotebookById(long id) {
        this.noteBookRepository.deleteById(id);
    }

    //SCHOOL_RECORD
    @Override
    public void saveSchoolRecord(SchoolRecord schoolRecord) {
        this.schoolRecordRepository.save(schoolRecord);
    }
    @Override
    public SchoolRecord findSchoolRecordById(long id) {
        return this.schoolRecordRepository.findSchoolRecordById(id);
    }
    @Override
    public SchoolRecord updateSchoolRecord(SchoolRecord schoolRecord) {
        return this.schoolRecordRepository.saveAndFlush(schoolRecord);
    }
    @Override
    public void deleteSchoolRecordById(long id) {
        this.schoolRecordRepository.deleteById(id);
    }

    //SCORE_CARD
    @Override
    public void saveScoreCard(ScoreCard scoreCard) {
        this.scoreCardRepository.save(scoreCard);
    }
    @Override
    public ScoreCard findScoreCardById(long id) {
        return this.scoreCardRepository.findScoreCardById(id);
    }
    @Override
    public ScoreCard updateScoreCard(ScoreCard scoreCard) {
        return this.scoreCardRepository.saveAndFlush(scoreCard);
    }
    @Override
    public void deleteScoreCardById(long id) {
        this.scoreCardRepository.deleteById(id);
    }

    //PARENT
    @Override
    public void saveParent(Parent parent) {
        this.parentRepository.save(parent);
    }
    @Override
    public Parent findParentById(long id) {
        return this.parentRepository.findParentById(id);
    }
    @Override
    public Parent updateParent(Parent parent) {
        return this.parentRepository.saveAndFlush(parent);
    }
    @Override
    public void deleteParentById(long id) {
        this.parentRepository.deleteById(id);
    }

    //USER
    @Override
    public void saveUser(User user) {
        this.userRepository.saveAndFlush(user);
    }
    @Override
    public List<User> getAllUser(){
        return this.userRepository.findAllUser();
    }
    @Override
    public void deleteUserByUsername(String username){
        this.userRepository.deleteById(username);
    }
    @Override
    public User findUserByUsername(String username){
        return this.userRepository.findUserByUsername(username);
    }
    @Override
    public void updateUser(User user){
        this.userRepository.saveAndFlush(user);
    }
    @Override
    public Staff findStaffByUsername(String username){
        return this.userRepository.findStaffByUsername(username);
    }

    //INFORMATION
    @Override
    public Information findInformationById(long id){
        return this.informationRepository.findInformationById(id);
    }
    @Override
    public Information updateInformation(Information information){
        return this.informationRepository.saveAndFlush(information);
    }
}
