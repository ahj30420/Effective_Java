package chapter03.item10;

import java.util.Objects;

public class SymmetryExample {
    public final static class CaseInsensitiveString{
        private final String s;

        public CaseInsensitiveString(String s) {
            this.s = Objects.requireNonNull(s);
        }


        /**
         * 잘못된 예시(CaseInsensitiveString의 equals를 String과 연동 하겠다는 허황된 꿈을 버려야 한다.)
        @Override
        public boolean equals(Object o) {
            if(o instanceof CaseInsensitiveString)
                return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
            if(o instanceof String)
                return s.equalsIgnoreCase((String) o);
            return false;
        }
        */

        @Override
        public boolean equals(Object o) {
            return o instanceof CaseInsensitiveString && s.equals(((CaseInsensitiveString) o).s);
        }
    }

    public static void main(String[] args){
        CaseInsensitiveString cis = new CaseInsensitiveString("Polish");
        String s = "polish";

        System.out.println(cis.equals(s)); // true
        System.out.println(s.equals(cis)); // false

        //대칭성 (x.equals(y)가 true이면 y.equals(x)도 true여야 한다.) 만족시키지 못함.
    }
}
