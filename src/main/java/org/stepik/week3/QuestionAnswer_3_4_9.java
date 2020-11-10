package org.stepik.week3;

/**
 * @author Nika Zurbaevi
 */
public class QuestionAnswer_3_4_9 {
    /*
     * Вопрос: Дан класс ComplexNumber. Переопределите в нем методы equals() и hashCode()
     * так, чтобы equals() сравнивал экземпляры ComplexNumber по содержимому полей re и im,
     * а hashCode() был бы согласованным с реализацией equals().
     *
     * Реализация hashCode(), возвращающая константу или не учитывающая дробную часть re и im, засчитана не будет
     *
     *
     * Ответ: см.ниже
     */
    public final class ComplexNumber {
        private final double re;
        private final double im;

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ComplexNumber other = (ComplexNumber) obj;

            return (this.getRe() == other.getRe()) && (this.getIm() == other.getIm());
        }

        @Override
        public int hashCode() {
            long real = Double.doubleToLongBits(this.getRe()); // harmonize NaN bit patterns
            long imag = Double.doubleToLongBits(this.getIm());
            if (real == 1L << 63) real = 0; // convert -0.0 to +0.0
            if (imag == 1L << 63) imag = 0;
            long h = real ^ imag;
            return (int)h ^ (int)(h >>> 32);
        }

    }
}
