import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        validateLoginAndPassword(login, password, confirmPassword);
    }
    public static void validateLoginAndPassword(String login, String password, String confirmPassword) {
        try {

            if (!login.matches("[a-zA-Z0-9_]+")) {
                System.out.println("Логин должен содержать только латинские буквы, цифры и символы подчеркивания");
            }
            if (login.length() > 20) {
                throw new WrongLoginException("Длина логина не должна превышать 20 символов");
            }

            if (!password.matches("[a-zA-Z0-9_]+")) {
                System.out.println("Пароль должен содержать только латинские буквы, цифры и символы подчеркивания");
            }
            if (password.length() >= 20) {
                System.out.println("Длина пароля должна быть менее 20 символов");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароль и подтверждение пароля должны быть равны");
            }

        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка");
        } finally {
            System.out.println("Метод завершил работу.");
        }

    }
}