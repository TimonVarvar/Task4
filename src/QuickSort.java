public  class QuickSort {
    public static <T> void sort(T[] colors, int[] orderNumbers) {
        if (colors == null || colors.length < 2) return;
        sort(colors, orderNumbers, 0, colors.length);
    }

    private static <T> void sort(T[] colors, int[] orderNumbers, int left, int right) {
        if (left < right - 1) {
            int xIndex = partition(colors, orderNumbers, left, right);
            sort(colors, orderNumbers, left, xIndex);
            sort(colors, orderNumbers, xIndex, right);
        }
    }

    private static <T> int partition(T[] colors, int[] orderNumbers, int left, int right) {
        int l = left;
        int r = right - 1;
        int x = orderNumbers[(l + r) / 2];

        while (l <= r) {
            while (orderNumbers[l] < x) l++;
            while (orderNumbers[r] > x) r--;

            if (l <= r) {
                int tmpOrder = orderNumbers[r];
                orderNumbers[r] = orderNumbers[l];
                orderNumbers[l] = tmpOrder;

                T tmpColors = colors[r];
                colors[r] = colors[l];
                colors[l] = tmpColors;

                l++;
                r--;
            }
        }

        if (l == right) l--;
        return l;
    }
}
