public class main {

    public static void main(String[] args) {
	// write your code here
        Matrix x = new Matrix(5,3);
        System.out.println(x.toString());
        x.echForm();
        System.out.println(x.toString());
	    x.RREF();
        System.out.println(x.toString());
    }
}
