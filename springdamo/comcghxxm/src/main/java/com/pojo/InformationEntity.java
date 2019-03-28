package com.pojo;

import javax.persistence.*;

@Entity
@Table(name = "information_", schema = "cgh1", catalog = "")
public class InformationEntity {
    private int no;
    private String professional;
    private int score;

    public InformationEntity() {
    }

    public InformationEntity(int no, String professional, int score) {
        this.no = no;
        this.professional = professional;
        this.score = score;
    }

    @Id
    @Column(name = "no")
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Basic
    @Column(name = "professional")
    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    @Basic
    @Column(name = "score")
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InformationEntity that = (InformationEntity) o;

        if (no != that.no) return false;
        if (score != that.score) return false;
        if (professional != null ? !professional.equals(that.professional) : that.professional != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = no;
        result = 31 * result + (professional != null ? professional.hashCode() : 0);
        result = 31 * result + score;
        return result;
    }
}
