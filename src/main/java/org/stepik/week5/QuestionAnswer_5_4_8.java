package org.stepik.week5;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_5_4_8 {
    /*
     * Вопрос: Дан сериализуемый класс Animal:
     *
     * class Animal implements Serializable {
     *     private final String name;
     *
     *     public Animal(String name) {
     *         this.name = name;
     *     }
     *
     *     @Override
     *     public boolean equals(Object obj) {
     *         if (obj instanceof Animal) {
     *             return Objects.equals(name, ((Animal) obj).name);
     *         }
     *         return false;
     *     }
     * }
     *
     * Реализуйте метод, который из переданного массива байт восстановит массив
     * объектов Animal. Массив байт устроен следующим образом. Сначала идет число типа int,
     * записанное при помощи ObjectOutputStream.writeInt(size). Далее подряд записано указанное
     * количество объектов типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).
     *
     * Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
     * то метод должен бросить исключение java.lang.IllegalArgumentException.
     *
     * Причины некорректности могут быть разные. Попробуйте подать на вход методу разные некорректные
     * данные и посмотрите, какие исключения будут возникать. Вот их-то и нужно превратить в
     * IllegalArgumentException и выбросить. Если что-то забудете, то проверяющая система подскажет.
     * Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
     *
     *
     * Ответ: см.ниже - с 45 по 64 без //
     *
     */
//    public static Animal[] deserializeAnimalArray(byte[] data) {
//        // your implementation here
//        Animal[] animals=null;
//        try(ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))){
//            Integer numAnimals = ois.readInt();
//            animals = new Animal[numAnimals];
//            for (int i = 0; i < numAnimals; i++) {
//                animals[i] = (Animal) ois.readObject();
//            }
//        } catch (EOFException e) {
//            throw new IllegalArgumentException(e);
//        } catch (ClassNotFoundException e) {
//            throw new IllegalArgumentException(e);
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        } catch (ClassCastException e){
//            throw new IllegalArgumentException(e);
//        }
//        return animals;
//    }
}
