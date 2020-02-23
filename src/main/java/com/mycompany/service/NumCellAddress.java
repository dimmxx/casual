package com.mycompany.service;

public class NumCellAddress {

    private Integer row;
    private Integer cell;

    public NumCellAddress(Integer row, Integer cell) {
        this.row = row;
        this.cell = cell;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getCell() {
        return cell;
    }

    public void setCell(Integer cell) {
        this.cell = cell;
    }

    @Override
    public String toString() {
        return "NumCellAddress{" +
            "row=" + row +
            ", cell=" + cell +
            '}';
    }

}
