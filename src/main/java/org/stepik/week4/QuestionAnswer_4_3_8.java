package org.stepik.week4;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_4_3_8 {
    /*
     * Вопрос: В этой задаче вам нужно реализовать метод, настраивающий параметры логирования.
     * Конфигурирование в коде позволяет выполнить более тонкую и хитрую настройку,
     * чем при помощи properties-файла.
     *
     * Требуется выставить такие настройки, чтобы:
     *
     * 1.    Логгер с именем "org.stepic.java.logging.ClassA" принимал сообщения всех уровней.
     * 2.    Логгер с именем "org.stepic.java.logging.ClassB" принимал только сообщения уровня WARNING и серьезнее.
     * 3.    Все сообщения, пришедшие от нижестоящих логгеров на уровень "org.stepic.java",
     *       независимо от серьезности сообщения печатались в консоль в формате XML (*) и не
     *       передавались вышестоящим обработчикам на уровнях "org.stepic", "org" и "".
     *
     * Не упомянутые здесь настройки изменяться не должны.
     *
     * (*) В реальных программах мы бы конечно печатали XML не в консоль, а в файл.
     * Но проверяющая система не разрешает создавать файлы на диске, поэтому придется так.
     *
     * Подсказки:
     *     Level есть не только у Logger, но и у Handler.
     *     Передача сообщения на обработку родительскому Handler'у регулируется свойством useParentHandlers.
     *
     *
     * Ответ: см.ниже
     *
     */
    private static void configureLogging() {
        // your implementation here
        Logger logger = Logger.getLogger("org.stepic.java");
        logger.setLevel(Level.ALL);
        XMLFormatter f = new XMLFormatter();
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        ch.setFormatter(f);
        logger.addHandler(ch);
        logger.setUseParentHandlers(false);

        Logger loggerA = Logger.getLogger("org.stepic.java.logging.ClassA");
        loggerA.setLevel(Level.ALL);

        Logger loggerB = Logger.getLogger("org.stepic.java.logging.ClassB");
        loggerB.setLevel(Level.WARNING);

    }

}
