
public class Main {
    public static void main(String[] args) {
        //get [ min, avg, max ]

        short[] a = getRandomArray();
        for(short result : a ){
            System.out.println( result );
        }

        System.out.println("sorted:");

        a = getMinAvgMaxArray(a);
        for(short result : a ){
            System.out.println( result );
        }
    }

    public static short[] getMinAvgMaxArray(short[] array){
        short[] result = { array[0], array[0], array[0] };

        if( array.length == 1 )
            return result;

        short avg = 0;

        for( short i = 0; i < array.length - 1; i++ ){
            short minTmp = (short)Math.min( array[i], array[ i + 1 ] );
            short maxTmp = (short)Math.max( array[i], array[ i + 1 ] );
            if( minTmp < result[ 0 ] ) {
                result[ 0 ] = minTmp;
            }
            if( i == array.length - 2 )
                avg += array[ i + 1 ];
            avg += array[ i ];
            if( maxTmp > result[ 2 ] ) {
                result[ 2 ] = maxTmp;
            }
        }
        result[1] = (short)(avg / array.length);
        //For debugging:
//        System.out.println( "Array length: " + (array.length ) );
//        System.out.println( "Avg: " + avg );
        return result;
    }

    public static short[] getRandomArray(){
        short arrayRange = (short)( 1 + Math.random() * 9 );
        short[] array = new short[arrayRange];
        for(short i = 0; i < array.length; i++ ) {
            array[i] = (short)( 1 + Math.random() * 99 );
        }
        return array;
    }
}