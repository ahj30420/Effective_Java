package chapter02.item02;

public class JavaBeansExample {
    private  int servingSize = -1;      //필수
    private  int servings = -1;         //필수
    private  int calories = 0;         //선택
    private  int fat = 0;              //선택
    private  int sodium = 0;           //선택
    private  int carbohydrate = 0;     //선택

    public JavaBeansExample() {}

    //세터 메서드들
    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        this.carbohydrate = carbohydrate;
    }

    public static void main(String[] args){
        JavaBeansExample bean = new JavaBeansExample();
        bean.setServingSize(240);
        bean.setServings(8);
        bean.setCalories(100);
        bean.setFat(35);
        bean.setSodium(27);
        bean.setCarbohydrate(10);
    }
}
