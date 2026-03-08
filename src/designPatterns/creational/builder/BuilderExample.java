package designPatterns.creational.builder;

public class BuilderExample {
    public static void main(String[] args) {
        User user = new User.Builder().setName("Abdurokhman").setEmail("sdf").setAge(34).build();

    }
}

class User{
    private String name;
    private String email;
    private String phone;
    private int age;

    private User(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phone = builder.phone;
        this.age = builder.age;
    }
    public static class Builder{
        private String name;
        private String email;
        private String phone;
        private int age;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

}
