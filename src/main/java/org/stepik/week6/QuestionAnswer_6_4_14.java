package org.stepik.week6;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_6_4_14 {
    /*
     * Вопрос: В этой задаче вам предстоит самостоятельно написать набор классов таким
     * образом, чтобы данный код успешно компилировался и выполнялся.
     *
     * Вам предстоит использовать новые знания про generics, коллекции и Stream API.
     *
     * В приведенном коде используется оператор assert. Этот оператор используется для того,
     * чтобы проверять определенные инварианты в коде. С помощью него возможно писать небольшие
     * тесты и следить за корректностью своей программы (в обычной ситуации предпочтительно для
     * этих целей использовать библиотеки для модульного тестирования, которые выходят за рамки базового курса).
     * (https://stepik.org/lesson/12781/step/14?unit=3128)
     *
     *
     * Ответ: см. ниже, с 23 по 98 стр.
     *
     */
    public static interface Sendable<T> {
        String getFrom();
        String getTo();
        T getContent();
    }

    public static class Storage<T> implements Sendable<T> {
        private final String from;
        private final String to;
        private final T content;

        public Storage(String from, String to, T content) {
            this.from = from;
            this.to = to;
            this.content = content;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public T getContent() {
            return content;
        }
    }

    public static class MailMessage extends Storage<String> {
        public MailMessage(String from, String to, String content) {
            super(from, to, content);
        }
    }

    public static class Salary extends Storage<Integer> {
        public Salary(String from, String to, Integer content) {
            super(from, to, content);
        }
    }

    public static class MailService<T> implements Consumer<Storage<T>> {
        private final Map<String, List<T>> contentMap = new HashMap<String, List<T>>() {
            @Override
            public List<T> get(Object key) {
                if (this.containsKey(key)) {
                    return super.get(key); // up to default
                } else {
                    return Collections.emptyList(); // somewhat difficulty there, very iffy/unsure
                }
            }
        };

        @Override
        public void accept(Storage<T> storage) {
            String to = storage.getTo();
            List<T> content = contentMap.get(to);

            if (content.size() == 0) {
                content = new ArrayList<T>();
            }

            T storageContent = storage.getContent();
            content.add(storageContent);

            contentMap.put(to, content);
        }

        public Map<String, List<T>> getMailBox() {
            return contentMap;
        }
    }
}
