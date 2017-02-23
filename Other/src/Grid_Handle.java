
public interface Grid_Handle {
	
	int setGridSize(int cells_x, int cells_y);
	
	int getGridSizeX();
	
	int getGridSizeY();
	
	int getCell(int pos_x, int pos_y);
	
	int setCell(int pos_x, int pos_y);
}
