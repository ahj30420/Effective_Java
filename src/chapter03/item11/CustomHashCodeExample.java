package chapter03.item11;

import java.util.HashMap;
import java.util.Map;

public class CustomHashCodeExample {
    public static class PhoneNumber{
        private final short areaCode, prefix, lineNum;
        private int hashCode;

        public PhoneNumber(int areaCode, int prefix, int lineNum) {
            this.areaCode = rangeCheck(areaCode, 999, "지역코드");
            this.prefix = rangeCheck(prefix, 999, "프리픽스");
            this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
        }

        private static short rangeCheck(int value, int max, String arg) {
            if(value < 0 || value > max)
                throw new IllegalArgumentException(arg + ": " + value);
            return (short) value;
        }

        @Override
        public boolean equals(Object o) {
            if(o == this)
                return true;
            if(!(o instanceof PhoneNumber))
                return false;
            PhoneNumber pn = (PhoneNumber) o;
            return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode == areaCode;
        }

        /**
         * 해시코드 재정의
        @Override
        public int hashCode() {
            int result = hashCode;
            if(result == 0){
                result = Short.hashCode(areaCode);
                result = 31 * result + Short.hashCode(prefix);
                result = 31 * result + Short.hashCode(lineNum);
                hashCode = result;
            }
            return result;
        }
        */
    }

    public static void main(String[] args) {
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumber(707, 867, 5309), "제니");

        //"제니"가 나와야 할 거 같지만 null이 출력됨 (hashcode를 재정의하지 않았기 때문)
        System.out.println(m.get(new PhoneNumber(707, 867, 5309)));
    }
}
