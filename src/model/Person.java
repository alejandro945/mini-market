package model;

public class Person {
    private int id;
    private DocumentType dt;

    public Person(int id, DocumentType dt) {
        this.id = id;
        this.dt = dt;
    }

    public DocumentType getDt() {
        return this.dt;
    }

    public void setDt(DocumentType dt) {
        this.dt = dt;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
