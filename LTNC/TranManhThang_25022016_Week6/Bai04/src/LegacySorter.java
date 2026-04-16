class LegacySorter {
    public int[] quickSort(int[] arr) {
        System.out.println("  [LegacySorter] Đang sắp xếp bằng thuật toán quickSort cũ...");
        // Giả lập thuật toán quickSort bằng Arrays.sort cho gọn
        int[] result = arr.clone(); 
        Arrays.sort(result);
        return result;
    }
}