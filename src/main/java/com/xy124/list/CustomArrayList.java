package com.xy124.list;

public class CustomArrayList {

    final static int MAX_SIZE = 100;
    private int[] data;
    int length;

    public CustomArrayList() {
        super();
        this.length = 0;
        data = new int[MAX_SIZE];
    }

    public CustomArrayList(int size) {
        this.length = 0;
        data = new int[size];

    }

    public void add(int data) {
        int size = this.data.length;

        if (this.length == size) {
            copyArray(data, size);
        } else {
            this.data[this.length] = data;

        }
        this.length++;
    }

    private void copyArray(int data, int size) {
        int newSize = size + 1;
        int[] newArray = new int[newSize];
        newArray[newSize - 1] = data;

        for (int i = 0; i < size; i++) {
            newArray[i] = this.data[i];
        }

        this.data = newArray;


    }

    public void add(int index, int data) {
        int size = this.data.length;

        if (this.length == size) {
            copyArrayWithIndex(index, data, size);

        } else {
            for (int i = this.length - 1; i > index - 1; i--) {
                this.data[i + 1] = this.data[i];
            }
            this.data[index - 1] = data;

        }
        this.length++;
    }

    private void copyArrayWithIndex(int index, int data, int size) {

        int newSize = size + 1;
        int[] newArray = new int[newSize];
        newArray[index - 1] = data;

        //인덱스 전으로는 그대로 데이터 복사
        for (int i = 0; i < index - 1; i++) {
            newArray[i] = this.data[i - 1];

        }
        //인덱스 이후
        for (int i = newSize - 1; i > index - 1; i--) {
            newArray[i] = this.data[i - 1];
        }

        this.data = newArray;


    }

    public void remove() {
        if (this.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data[this.length - 1] = 0;

        this.length--;
    }

    public void remove(int index) {
        if (this.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.data[index - 1] = 0;

        for (int i = index - 1; i < this.length - 1; i++) {
            this.data[i] = this.data[i + 1];
        }

        this.length--;

    }

    public int[] getData() {
        return this.data;
    }


}
