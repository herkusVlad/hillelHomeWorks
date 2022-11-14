package MyArrayList.MyArray;

import java.util.Iterator;

public class MyArrayList implements MyCollection, Iterator {

    private String[] strArr;
    //Указатель на текущий элемент в массиве
    private int currentSize = 0;
    private int itrCounter = 0;
    public MyArrayList(){
        strArr = createArray(10);
    }

    public MyArrayList(int size){
        strArr = createArray(size);
    }


    @Override
    public boolean add(String o) {
        try{
            strArr[currentSize++] = o;
        }catch (Exception e ){
            return false;
        }
        if(needExtension()){
            strArr = mergeArray(strArr,createArray(10));
        }
        return true;
    }

    public String [] getArray(){
        return strArr;
    }

    @Override
    public boolean add(int index, String o) {
        try{
            if(index >= strArr.length){
                return false;
            }
            if(index == strArr.length -1 && strArr[index] == null && currentSize < index){
                strArr[index] = o;
                currentSize++;
                convertArrayToCorrectSize();
                if(needExtension()){
                    strArr = mergeArray(strArr,createArray(10));
                }
                return true;
            }

            String[] startArr = index == 0 ?
                    cutArray(strArr,index,strArr.length):
                    cutArray(strArr,0,index) ;

            if(index == 0){
                strArr = new String[]{o};
                strArr = mergeArray(strArr,startArr);
                currentSize++;
            }else{
                String[] endArr = cutArray(strArr,index,strArr.length);
                strArr = mergeArray(startArr,new String[1]);
                strArr[index] = o;
                strArr=mergeArray(strArr,endArr);
                currentSize++;
            }
            convertArrayToCorrectSize();
        }catch (Exception e ){
            return false;
        }
        if(needExtension()){
            strArr = mergeArray(strArr,createArray(10));
        }
        return true;
    }

    @Override
    public boolean delete(String o) {
        int indexFoundElement = -1;
        for(int i =0;i<strArr.length;i++){
            if(o == null && strArr[i]==null){
                indexFoundElement = i;
                break;
            } else if(strArr[i].equals(o)) {
                indexFoundElement = i;
                break;
            }
        }
        if(indexFoundElement == -1){
            return false;
        }

        try{

            if(indexFoundElement == strArr.length -1){
                strArr = cutArray(strArr,0,strArr.length-1);
                currentSize--;
                return true;
            }

            String[] startArr = indexFoundElement == 0 ?
                    cutArray(strArr,indexFoundElement + 1,strArr.length):
                    cutArray(strArr,0,indexFoundElement) ;

            if(indexFoundElement == 0){
                strArr = startArr;
                currentSize--;
            }else{
                String[] endArr = cutArray(strArr,indexFoundElement+1,strArr.length);
                strArr = mergeArray(startArr,endArr);
                currentSize--;
            }
        }catch (Exception e ){
            return false;
        }
        return true;
    }

    @Override
    public String get(int index) {
        try{
            String tmp = strArr[index];
        }catch (Exception e){
           return e.toString();
        }
        return strArr[index];
    }

    @Override
    public boolean contain(String o) {
        for (int i=0;i<currentSize;i++){
            if(o != null && strArr[i] != null){
                if(o.equals(strArr[i])){
                    return true;
                }
            }else if(o == strArr[i]){
                return true;
            }

        }
        return false;
    }

    @Override
    public boolean equals(MyCollection str) {
        if(str.size() != currentSize){
            return false;
        }
        for(int i=0;i<currentSize;i++){
            if(str.get(i) != null && strArr[i] != null){
                if(!str.get(i).equals(strArr[i])){
                    return false;
                }
            }else{
                if(str.get(i) != strArr[i]){
                    return false;
                }
            }

        }
        return true;
    }

    @Override
    public boolean clear() {
        try {
            strArr = createArray(10);
            currentSize=0;
        }catch (Exception e ){
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public String toString() {
        String res = "";
        for(int i=0;i<currentSize;i++){
            res= res + " " + strArr[i];
        }
        return res.trim();
    }

    private String[] createArray(int size){
        return new String[size];
    }

    private String[] cutArray(String[] arr, int start, int end){
        String[] startArr = end == 0 ?
                new String[1] :
                new String[end - start ] ;
        for(int i=0, j = start;i<startArr.length;i++){
            startArr[i] = arr[j++];
        }
        return startArr;
    }

    private String[] mergeArray(String[] arr1, String[] arr2){
        String[] arr = new String[arr1.length + arr2.length];
        int counter = 0;
        for(int i=0;i<arr1.length;i++){
            arr[i] =arr1[counter++];
        }
        for(int i=0;i<arr2.length;i++){
            arr[counter++] =arr2[i];
        }
        return arr;
    }

    private void convertArrayToCorrectSize(){
        int size = currentSize == countNotNull() ? countNotNull() : currentSize;
        int strArrayLength = strArr.length;
        int counterNULL = currentSize - countNotNull();
        String[] arr = new String[size];
        for(int i=0,j=0;i< strArr.length && j< arr.length;i++){
            if(strArr[i] != null){
               arr[j++] = strArr[i];
            }
            if(counterNULL > 0 && strArr[i]==null){
                arr[j++] = null;
                counterNULL--;
            }
        }
        strArr = mergeArray(arr, createArray(strArrayLength - arr.length));
    }

    private int countNotNull(){
        int counter =0 ;
        for(String str : strArr){
            if(str != null){
               counter++;
            }
        }
        return counter;
    }
    private boolean needExtension(){
        return currentSize + 3 >= strArr.length;
    }


    @Override
    public boolean hasNext() {
        if(itrCounter >= size()){
            itrCounter = 0;
            return false;
        }
        return itrCounter < size();
    }

    @Override
    public Object next() {
        return get(itrCounter++);
    }

    @Override
    public void remove() {
        delete(get(itrCounter));
        currentSize--;
    }

    public MyArrayList getUnique(){
        MyArrayList list = new MyArrayList();
        for(int i=0;i<currentSize;i++){
            if(!list.contain(get(i))){
                list.add(get(i));
            }
        }
        return list;
    }

    private boolean isUnique(MyArrayList list, String str){
        if(list.size() == 0){
            return true;
        }
        for(int i=0;i<list.size();i++){
            if(str.equals(list.get(i))){
                return false;
            }
        }
        return true;
    }
}
