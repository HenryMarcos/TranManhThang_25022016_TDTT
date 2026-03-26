public class Main {
    public static void main(String[] args) {
        Integer[] iArr = {5, 1, 3, 2};
        String[] sArr = {"Java", "C++", "Python"};
        ArrayUtils.sort(iArr);
        ArrayUtils.sort(sArr);
        for (int i = 0; i < iArr.length; i++) {
            System.out.printf("%d ", iArr[i]);
        }
        System.out.println();
        for (int i = 0; i < sArr.length; i ++) {
            System.out.printf("%s ", sArr[i]);
        }
    }
}
