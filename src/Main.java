import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    //        Константа с регулярными выражениями, для проверки допустимых символов
    private static final String CHECK_SYMBOLS = "^[a-zA-Z0-9_]+$";

    public static void main(String[] args) {
    //        Проверяем как работает метод по проверке логина и пароля
        checkLoginAndPasswords("Ivan", "123", "123");
        checkLoginAndPasswords("Иван", "123", "123");
        checkLoginAndPasswords("Ivan", "123ф", "123");
        checkLoginAndPasswords("Ivan", "1233", "123");

    }

    //        Метод для проверки логина и пароля с обработкой исключений
    public static void checkLoginAndPasswords(String login, String password, String confirmPassword) {
        try {
            checkLogin(login);
            checkPasswords(password, confirmPassword);
        } catch (WrongLoginException e) {
            System.out.println("Логин: " + e.getMessage());
        } catch (WrongPasswordException e) {
            System.out.println("Пароль: " + e.getMessage());
        }
    }

    //            Метод для проверки логина
    public static void checkLogin(String login) throws WrongLoginException {
        if (!login.matches(CHECK_SYMBOLS)) {
            throw new WrongLoginException("Недопустимые символы в логине.");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Нельзя больше 20 символов в логине.");
        }
    }

    //        Метод для проверки паролей
    public static void checkPasswords(String password, String confirmPassword) throws WrongPasswordException {
        if (!password.matches(CHECK_SYMBOLS)) {
            throw new WrongPasswordException("Недопустимые символы в пароле.");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Нельзя больше 20 символов в пароле.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
}