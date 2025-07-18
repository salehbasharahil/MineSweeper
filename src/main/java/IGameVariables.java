public interface IGameVariables {
    int getSideLength();

    int getTotalNoMines();

    Square[][] grid();

    int count();

    void incrementCount();

}
