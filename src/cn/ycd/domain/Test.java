package cn.ycd.domain;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.setId(1);
        test.setName("gy");
        System.out.println(test);
    }

    private int id;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
