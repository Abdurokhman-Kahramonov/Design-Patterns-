package solid.dependencyInversionPrinciple.example1;

import javax.xml.crypto.Data;

public class DependencyInversionExample {
    public static void main(String[] args) {
        Database postgres = new PostgresDatabase();
        Database mysql = new MySQLDatabase();
        UserRepository userRepositoryForPostgres = new UserRepository(postgres);
        UserRepository userRepositoryForMySQL = new UserRepository(mysql);
        Database postgres2 = new PostgresDatabase();
    }

}


interface Database{
    void connect();
}

class PostgresDatabase implements Database {
    @Override
    public void connect(){
        System.out.println("Connected to Postgres Database");
    }
}
class MySQLDatabase implements Database{
    @Override
    public void connect(){
        System.out.println("Connected to MySQL Database");
    }
}

class UserRepository{
    Database database;
    UserRepository(Database database){
        this.database = database;
    }
    void getUserById(int id){
        database.connect();
        System.out.println("Getting user by id: " + id);
    }
}
class UserService{
    UserRepository userRepository;
    UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    void getUserById(int id){
        userRepository.getUserById(id);
    }
}