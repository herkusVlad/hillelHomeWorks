package Collection;

public class HandCollection implements MyCollection{

    private String[] strArr;
    //Индекс для расширения массива
    private int extensionIndex;
    //Указатель на текущий элемент в массиве
    private int actualIndex = 0;

    public HandCollection(){
        strArr = new String[10];
        extensionIndex = strArr.length - 3;
    }

    public HandCollection(int size){
        strArr = new String[size];
        extensionIndex = size >= 5 ? size -3 : size - 1;
    }

    //Метод для тестирования позиционирования NULL.
//    public String[] toArrayWithNull(){
//        return strArr;
//    }

    @Override
    public String toString() {
        String toString = "";
        for(String str : strArr){
            if(str!=null){
                toString+= str + " ";
            }
        }
        return toString;
    }

    //Добавляет элемент по заданному индексу в коллекцию.
    //Создает +10 пустых элементов в коллекцию если свободных ячеек становится мало.
    //Если индекс меньше нуля или выходит за границы размера коллекции, метод вернет false.
    @Override
    public boolean add(int index, String value) {
        try{
            if(strArr[index] == null){
                strArr[index]= value;
                checkNeedAndExtensionArray();
                replaceNullToValue();
                return true;
            }else {
                traveledArray(index);
            }
            strArr[index] = value;
            replaceNullToValue();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Метод для добавления элемента в конец коллекции.
    //Создает +10 пустых элементов в коллекцию если свободных ячеек становится мало.
    @Override
    public boolean add(String value) {
        try{
            if(strArr[actualIndex+1] == null){
                strArr[actualIndex++] = value;
            }else{
                while (strArr[actualIndex] != null){
                    actualIndex++;
                    if(actualIndex >= strArr.length) extensionArray();
                }
                strArr[actualIndex++] = value;
            }
            checkNeedAndExtensionArray();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Удаление элемента коллекции с помощью заданного индекса.
    //Если индекс меньше нуля или больше размера коллекции, метод вернет false.
    @Override
    public boolean delete(int index) {
        try{
            strArr[index] = null;
            replaceNullToValue();
            findFirstNull();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Удаление первого найденного элемента по значению с коллекции.
    //Даже если ничего не было найдено для удаления с коллекции, метод вернет true, как знак о успешной операции.
    @Override
    public boolean delete(String value) {
        try{
            for (int i=0;i<strArr.length;i++){
                if(strArr[i].equals(value)){
                    strArr[i] = null;
                    replaceNullToValue();
                    findFirstNull();
                    break;
                }
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Удаление всех найденных элементов по значению с коллекции.
    //Даже если ничего не было найдено для удаления с коллекции, метод вернет true, как знак о успешной операции.
    public boolean deleteAll(String value) {
        try{
            for (int i=0;i<strArr.length;i++){
                if(value.equals(strArr[i])){
                    strArr[i] = null;
                }
            }
            replaceNullToValue();
            findFirstNull();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    //Возвращает элемент по индексу.
    //Если индекс выходит за рамки размера коллекции,метод вернет NULL.
    @Override
    public String get(int index) {
        if(index < 0 || index >= strArr.length){
            return null;
        }
        return strArr[index];
    }

    private void checkNeedAndExtensionArray(){
        if(strArr.length - nullCounter() >= extensionIndex) {
            extensionArray();
        }
    }

    private int nullCounter(){
        int counter = 0;
        for(int i=0;i<strArr.length;i++){
            if(strArr[i] == null){
                counter++;
            }
        }
        return counter;
    }

    private void extensionArray(){
            String[] newArr = new String[strArr.length+10];
            for(int i=0;i<strArr.length;i++){
                newArr[i] = strArr[i];
            }
            strArr = newArr;
            extensionIndex = strArr.length -3;
    }

    //Traveled array - потому что поехавший
    private void traveledArray(int index){
        String firstItem = strArr[index];
        String secondItem = strArr[index+1];
        boolean needCheck = true;
        int travelLength = strArr.length;
        for(int i=index;i<travelLength;i++){
            if(needCheck && i+2 >= strArr.length){
                extensionArray();
                needCheck = false;
            }

            if(secondItem == null){
                strArr[i+1] =firstItem;
                break;
            }

            strArr[i+1] = firstItem;
            firstItem = secondItem;
            secondItem = strArr[i+2];
        }
    }

    private void replaceNullToValue(){
        String[] newArr = new String[strArr.length-nullCounter()];
        for(int i=0, j=0;i<strArr.length && j < newArr.length;i++){
            if(strArr[i]!=null){
                newArr[j++] = strArr[i];
            }
        }
        for(int i=0;i<strArr.length;i++){
            if(i < newArr.length){
                strArr[i] = newArr[i];
            }else{
                strArr[i] = null;
            }
        }
    }

    private void findFirstNull(){
        for(int i=0;i< strArr.length;i++){
            if(strArr[i] == null){
                actualIndex = i;
                break;
            }
        }
    }
}
