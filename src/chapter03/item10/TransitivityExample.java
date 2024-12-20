package chapter03.item10;

import java.awt.*;

public class TransitivityExample {
    public static class Point{
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Point))
                return false;
            Point p = (Point)o;
            return x == p.x && y == p.y;
        }
    }

    public static class ColorPoint extends Point{
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        /**
         * 대칭성 위배(Point.equals(ColorPoint) = true 이지만 ColorPoint.equals(Point) = false 일 수 있음)
        @Override
        public boolean equals(Object o) {
            if(!(o instanceof ColorPoint))
                return false;
            return super.equals(o) && color.equals(((ColorPoint)o).color);
        }
        */

        /**
         * 대칭성은 지키지만 추의성은 위반함
        @Override
        public boolean equals(Object o) {
            if(!(o instanceof Point))
                return false;

            //o가 Point이면 색상을 무시하고 비교
            if(!(o instanceof ColorPoint))
                return o.equals(this);

            //o가 ColorPoint면 색상까지 비교
            return super.equals(o) && ((ColorPoint) o).color.equals(color);
        }
        */
    }
}
