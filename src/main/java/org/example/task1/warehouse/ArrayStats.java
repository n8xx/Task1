package org.example.task1.warehouse;

public class ArrayStats {

        private int sum;
        private double avg;
        private int max;
        private int min;
        public ArrayStats(String id, int sum, double avg, int max, int min) {
            this.sum = sum;
            this.avg = avg;
            this.max = max;
            this.min = min;
        }
        public int getSum() {
            return sum;
        }
        public void setSum(int sum) {
            this.sum = sum;
        }
        public double getAvg() {
            return avg;
        }
        public void setAvg(double avg) {
            this.avg = avg;
        }
        public int getMax() {
            return max;
        }
        public void setMax(int max) {
            this.max = max;
        }
        public int getMin() {
            return min;
        }
        public void setMin(int min) {
            this.min = min;
        }
    }

