package org.stepik.week4;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_4_2_7 {
    /*
     * Вопрос: Вспомним нашего старого знакомого робота из этой задачи.
     * Теперь мы будем давать роботу команды удаленно, подключаясь к нему по беспроводному каналу связи.
     *
     * Подключение к роботу представляется в программе интерфейсом RobotConnection:
     *
     * public interface RobotConnection extends AutoCloseable {
     *     void moveRobotTo(int x, int y);
     *     @Override
     *     void close();
     * }
     *
     * Да, робот с тех пор поумнел и стал понимать команду на перемещение в заданную
     * точку (метод moveRobotTo). Ему больше не нужны пошаговые инструкции.
     *
     * RobotConnection — это временно устанавливаемое соединение, которое надо закрывать,
     * когда оно больше не нужно. Для закрытия соединения в интерфейсе есть метод close().
     *
     * За установку соединения отвечает RobotConnectionManager:
     *
     * public interface RobotConnectionManager {
     *     RobotConnection getConnection();
     * }
     *
     * Метод getConnection() делает попытку соединиться с роботом и возвращает
     * установленное соединение, через которое можно отдавать роботу команды.
     *
     * Установка соединения может завершиться неуспешно, а также уже установленное
     * соединение может внезапно разорваться. Всякое бывает. Поэтому любой метод
     * RobotConnectionManager и RobotConnection может бросить непроверяемое исключение RobotConnectionException:
     *
     * public class RobotConnectionException extends RuntimeException {
     *
     *     public RobotConnectionException(String message) {
     *         super(message);
     *     }
     *
     *     public RobotConnectionException(String message, Throwable cause) {
     *         super(message, cause);
     *     }
     * }
     *
     * Ваша задача — реализовать метод который устанавливает соединение с роботом, отдает
     * ему команду на перемещение в заданную точку и затем закрывает соединение, выполняя
     * при необходимости повтор этой последовательности до трех раз.
     *
     * При этом:
     *
     * 1)     Попытка отдать команду роботу считается успешной, если удалось установить соединение
     * и выполнить метод RobotConnection.moveRobotTo() без исключений. Ошибка закрытия соединения
     * не важна и должна игнорироваться.
     * 2)     Если первая попытка подключиться и отдать команду оказалась неуспешной, то закрываем
     * соединение и выполняем вторую попытку. Если вторая тоже не удалась, то выполняется третья.
     * После третьей неудачи метод должен бросить исключение RobotConnectionException.
     * 3)     Метод отвечает за открытие и закрытие соединения. Если соединение удалось установить,
     * то оно обязательно должно быть закрыто несмотря на возможные исключения, случившиеся в дальнейшем
     * во время работы метода.
     * 4)     Если во время работы метода случилось исключение любого типа, отличного от
     * RobotConnectionException, метод должен завершиться и выбросить это исключение, не выполняя
     * повторных попыток пообщаться с роботом. Единственное, что метод должен сделать перед
     * выбросом этого исключения — закрыть открытое соединение RobotConnection.
     *
     *
     *
     * Ответ: см. ниже, скопировать внутри /* */

    /*
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        // your implementation here
        boolean success = false;
        for (int i = 0; !success && (i < 3); ++i) {
            try (RobotConnection connection = robotConnectionManager.getConnection()) {
                connection.moveRobotTo(toX, toY);
                success = true;
            } catch (RobotConnectionException e) {}
        }
        if (!success) {
            throw new RobotConnectionException("3 attempts failed");
        }
    }

     */
}
