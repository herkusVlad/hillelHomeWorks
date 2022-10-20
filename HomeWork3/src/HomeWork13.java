
public class HomeWork13 {
    public static void main(String[] args) {
        char[][] arr = new char[8][8];
        char[] symbolsArr = {'W','B'};
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(i%2==0){
                    symbolsArr[0] = 'W';
                    symbolsArr[1] = 'B';
                }else{
                    symbolsArr[1] = 'W';
                    symbolsArr[0] = 'B';
                }
                    if(j%2 == 0){
                        arr[i][j] = symbolsArr[0];
                    }else{
                        arr[i][j] = symbolsArr[1];
                    }
            }
        }

        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
