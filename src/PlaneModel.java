import java.util.Arrays;

/**
 * PlaneModel class represents a model of a plane with seat and price matrices.
 */
public class PlaneModel
{
    // 2D array representing the seats in the plane
    public int[][] seatsMatrix;
    // 2D array representing the price of each seat in the plane
    public int[][] priceMatrix;
    // Array representing the labels of each row in the plane
    public final String[] rowLabels = {"A", "B", "C", "D"};

    /**
     * Constructor for PlaneModel class.
     * Initializes the seats and price matrices and populates them.
     */
    public PlaneModel()
    {
        this.seatsMatrix = new int[4][];
        this.priceMatrix = new int[4][];

        this.seatsMatrix[0] = new int[14];
        this.seatsMatrix[1] = new int[12];
        this.seatsMatrix[2] = new int[12];
        this.seatsMatrix[3] = new int[14];

        this.priceMatrix[0] = new int[14];
        this.priceMatrix[1] = new int[12];
        this.priceMatrix[2] = new int[12];
        this.priceMatrix[3] = new int[14];

        this.populateSeatsMatrix();
        this.populatePriceMatrix();
    }

    /**
     * Populates the seats matrix with zeros.
     */
    private void populateSeatsMatrix()
    {
        for (int[] array : seatsMatrix) {
            Arrays.fill(array, 0);
        }
    }

    /**
     * Populates the price matrix with prices based on seat position.
     */
    private void populatePriceMatrix()
    {
        for (int i = 0; i < priceMatrix.length; i++) {
            for (int j = 0; j < priceMatrix[i].length; j++) {
                if (j < 5) {
                    priceMatrix[i][j] = 200;
                } else if (j < 9) {
                    priceMatrix[i][j] = 150;
                } else {
                    priceMatrix[i][j] = 180;
                }
            }
        }
    }
}