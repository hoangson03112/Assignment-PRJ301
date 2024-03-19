/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import entity.score.Active_learning;
import entity.score.Ass_1;
import entity.score.Ass_2;
import entity.score.Computer_Project;
import entity.score.FE;
import entity.score.PE;
import entity.score.PT_1;
import entity.score.PT_2;
import entity.score.PT_3;
import entity.score.Presentation;
import entity.score.Project;
import entity.score.Total;

/**
 *
 * @author Hoàng Sơn
 */
public class Score {

    private Student student;
    private Active_learning Active_learning;
    private Presentation Presentation;
    private Computer_Project Computer_Project;
    private Ass_1 Assignment_1;
    private Ass_2 Assignment_2;
    private PT_1 PT_1;
    private PT_2 PT_2;
    private PT_3 PT_3;
    private Project Project;
    private PE PE;
    private FE FE;
    private Subject subject;
    private Total total;

    public Score(Active_learning Active_learning, Presentation Presentation, Computer_Project Computer_Project, Ass_1 Assignment_1, Ass_2 Assignment_2, PT_1 PT_1, PT_2 PT_2, PT_3 PT_3, Project Project, PE PE, FE FE) {
        this.Active_learning = Active_learning;
        this.Presentation = Presentation;
        this.Computer_Project = Computer_Project;
        this.Assignment_1 = Assignment_1;
        this.Assignment_2 = Assignment_2;
        this.PT_1 = PT_1;
        this.PT_2 = PT_2;
        this.PT_3 = PT_3;
        this.Project = Project;
        this.PE = PE;
        this.FE = FE;
    }

    public Score() {
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public PE getPE() {
        return PE;
    }

    public void setPE(PE PE) {
        this.PE = PE;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Ass_1 getAssignment_1() {
        return Assignment_1;
    }

    public void setAssignment_1(Ass_1 Assignment_1) {
        this.Assignment_1 = Assignment_1;
    }

    public Computer_Project getComputer_Project() {
        return Computer_Project;
    }

    public void setComputer_Project(Computer_Project Computer_Project) {
        this.Computer_Project = Computer_Project;
    }

    public Ass_2 getAssignment_2() {
        return Assignment_2;
    }

    public void setAssignment_2(Ass_2 Assignment_2) {
        this.Assignment_2 = Assignment_2;
    }

    public PT_1 getPT_1() {
        return PT_1;
    }

    public void setPT_1(PT_1 PT_1) {
        this.PT_1 = PT_1;
    }

    public PT_2 getPT_2() {
        return PT_2;
    }

    public void setPT_2(PT_2 PT_2) {
        this.PT_2 = PT_2;
    }

    public PT_3 getPT_3() {
        return PT_3;
    }

    public void setPT_3(PT_3 PT_3) {
        this.PT_3 = PT_3;
    }

    public FE getFE() {
        return FE;
    }

    public void setFE(FE FE) {
        this.FE = FE;
    }

    public Active_learning getActive_learning() {
        return Active_learning;
    }

    public void setActive_learning(Active_learning Active_learning) {
        this.Active_learning = Active_learning;
    }

    public Presentation getPresentation() {
        return Presentation;
    }

    public void setPresentation(Presentation Presentation) {
        this.Presentation = Presentation;
    }

    public Project getProject() {
        return Project;
    }

    public void setProject(Project Project) {
        this.Project = Project;
    }

}
