//File writed by Florian Trois

package sudoku.ihm.model.data.model;

public class FixedCell extends Cell{
    private byte value;

    public FixedCell(byte x, byte y) throws IllegalArgumentException{
        super(x, y);
    }

    public FixedCell(byte x, byte y, byte value) throws IllegalArgumentException {
        super(x, y);

        if(value < 1 || value > 9){
            throw new IllegalArgumentException(Cell.Errors.Cell_illegal_value);
        }
        this.value = value;
    }
    
    public int getValue() {
            return value;
    }

    public void setValue(byte value) {
        if(value < 1 || value > 9){
            throw new IllegalArgumentException(Cell.Errors.Cell_illegal_value);
        }
        this.value = value;
    }
}
