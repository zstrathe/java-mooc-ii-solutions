
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int placeCol = size / 2;
        int placeRow = 0;
        int value = 1;
        int totalCount = 0;
        
        while (totalCount < size * size) {
            square.placeValue(placeCol, placeRow, value);
            value ++;
            totalCount ++;
            
            // get temporary row and column to check if a normal
            // move is valid next
            int tmpPlaceCol = placeCol + 1;
            // jump edges if outside bounds
            if (tmpPlaceCol > size - 1) {
                tmpPlaceCol = tmpPlaceCol - size;
            }
            int tmpPlaceRow = placeRow - 1;
            // jump edges if outside bounds
            if (tmpPlaceRow < 0) {
                tmpPlaceRow = size + tmpPlaceRow;
            }
            
            // if move valid (no existing value), 
            // then set row and column for next placement
            if (square.readValue(tmpPlaceCol, tmpPlaceRow) == 0) {
                placeRow = tmpPlaceRow;
                placeCol = tmpPlaceCol;
            } else {
                // if move not valid, then increase row instead 
                // (and enforce bound)
                placeRow++;
                if (placeRow > size -1) {
                    placeRow = placeRow - size;
                }
            }
        }
        return square;
    }

}
