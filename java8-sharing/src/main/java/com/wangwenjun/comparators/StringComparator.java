package com.wangwenjun.comparators;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Administrator
 */

public class StringComparator {

    public static void main(String[] args) {
//        StringList();

//        GoodArrays();
        ComparatorSort();
        ComparatorObject();
    }

    private static void ComparatorObject() {
        Goods[] arr=new Goods[5];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",66);
        arr[2] = new Goods("xiaomiMouse",50);
        arr[3] = new Goods("hahaMouse",66);
        arr[4] = new Goods("hahaMouse",166);

        Arrays.sort(arr, new Comparator() {
            //指明商品比较大小的方式，按照产品名称从低到高排序，再按照价格从高到低排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  Goods && o2 instanceof Goods){
                    Goods g1=(Goods)o1;
                    Goods g2=(Goods)o2;
                    if(g1.getName().equals(g2.getName())){

                        return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else {
                        return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    private static void ComparatorSort() {
        String[] arr=new String[] {"GG","MM","AA","CC","DD","KK"};
        Arrays.sort(arr, new Comparator() {

            //按照字符串从大到小的顺序排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String ){
                    String s1=(String)o1;
                    String s2=(String)o2;
                    return  -s1.compareTo(s2);
                }
                //return 0;
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    private static void GoodArrays() {
        Goods[] arr=new Goods[4];
        arr[0] = new Goods("lenovoMouse",34);
        arr[1] = new Goods("dellMouse",66);
        arr[2] = new Goods("xiaomiMouse",50);
        arr[3] = new Goods("hahaMouse",66);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void StringList() {
        String[] arr=new String[] {"GG","MM","AA","CC","DD","KK"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
