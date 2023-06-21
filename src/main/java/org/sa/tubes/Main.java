package org.sa.tubes;
public class Main {
    public static void main(String[] args) {
        int[][] parkingLot = {
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1},
                {1, 1, 1, 1}
        };

        int emptyParkingLot = findEmptyParkingLot(parkingLot, 0, parkingLot.length - 1, 0, parkingLot[0].length - 1);

        if (emptyParkingLot != -1) {
            int row = emptyParkingLot / parkingLot[0].length;
            int col = emptyParkingLot % parkingLot[0].length;
            System.out.println("Lahan parkir kosong ditemukan pada koordinat (" + row + ", " + col + ")");
        } else {
            System.out.println("Tidak ada lahan parkir kosong");
        }
    }

    public static int findEmptyParkingLot(int[][] parkingLot, int startRow, int endRow, int startCol, int endCol) {
        if (startRow >= endRow || startCol >= endCol) {
            return -1;
        }

        int midRow = (startRow + endRow) / 2;
        int midCol = (startCol + endCol) / 2;

        if (isParkingLotEmpty(parkingLot, startRow, midRow, startCol, midCol)) {
            return (midRow * parkingLot[0].length) + midCol;
        }

        int result = findEmptyParkingLot(parkingLot, startRow, midRow, startCol, midCol);  // Bagian pertama
        if (result != -1) {
            return result;
        }

        result = findEmptyParkingLot(parkingLot, midRow + 1, endRow, startCol, midCol);  // Bagian kedua
        if (result != -1) {
            return result;
        }

        result = findEmptyParkingLot(parkingLot, startRow, midRow, midCol + 1, endCol);  // Bagian ketiga
        if (result != -1) {
            return result;
        }

        result = findEmptyParkingLot(parkingLot, midRow + 1, endRow, midCol + 1, endCol);  // Bagian keempat
        return result;
    }

    public static boolean isParkingLotEmpty(int[][] parkingLot, int startRow, int endRow, int startCol, int endCol) {
        for (int i = startRow; i <= endRow; i++) {
            for (int j = startCol; j <= endCol; j++) {
                if (parkingLot[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
