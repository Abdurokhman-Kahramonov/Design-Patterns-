package designPatterns.creational.builder;

public class BuilderExample1 {
    public static void main(String[] args) {

    }
}

class PatientRegistration{
    private String name;
    private String surname;
    private String DateOfBirth;
    private String prescription;

    private PatientRegistration(Builder builder){
        this.name = builder.name;
        this.surname = builder.surname;
        this.DateOfBirth = builder.DateOfBirth;
        this.prescription = builder.prescription;
    }
    class Builder {
        private String name;
        private String surname;
        private String DateOfBirth;
        private String prescription;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }
        public Builder setSurname(String surname){
            this.surname = surname;
            return this;
        }
        public Builder setDateOfBirth(String DateOfBirth){
            this.DateOfBirth = DateOfBirth;
            return this;
        }
        public Builder setPrescription(String prescription){
            this.prescription = prescription;
            return this;
        }
        public PatientRegistration build(){return new PatientRegistration(this);}
    }














}

