package ru.job4j.oop;

public class Doctor extends Profession {
    private Diagnosis diagnosis;

    public Doctor(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis(pacient);
    }
}
