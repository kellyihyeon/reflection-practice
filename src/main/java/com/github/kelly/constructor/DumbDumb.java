package com.github.kelly.constructor;

public class DumbDumb {

    private String name;
    private long amount;

    // 파라미터를 가지고 있는 생성자
    public DumbDumb(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public DumbDumb(String name) {
        this.name = name;
    }

    public DumbDumb(long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "DumbDumb{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
