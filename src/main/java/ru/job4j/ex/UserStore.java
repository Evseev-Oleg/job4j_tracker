package ru.job4j.ex;

public class UserStore {
    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserInvalidException("No found Username");
    }

    public static boolean validate(User user) throws UserInvalidException {
       if(user.isValid() && user.getUsername().length() >= 3) {
           return true;
       }
       throw new UserInvalidException("User not valid");
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {

            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        }catch (UserInvalidException e){
            e.printStackTrace();
        }catch (UserNotFoundException e){
            e.printStackTrace();
        }
    }
}
