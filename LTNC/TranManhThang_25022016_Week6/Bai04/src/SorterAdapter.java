class SorterAdapter implements Sorter {
    private LegacySorter legacySorter;

    // Tiêm (inject) thư viện cũ vào Adapter
    public SorterAdapter(LegacySorter legacySorter) {
        this.legacySorter = legacySorter;
    }

    @Override
    public int[] sort(int[] arr) {
        // Chuyển đổi lời gọi hàm từ hệ thống mới sang thư viện cũ
        return legacySorter.quickSort(arr);
    }
}