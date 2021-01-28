package ru.job4j.tracker;

public class Doctor extends Profession{
    Diagnosis diagnosis;

    public Doctor(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Diagnosis heal(Pacient pacient) {
        return new Diagnosis(pacient);
    }
}
