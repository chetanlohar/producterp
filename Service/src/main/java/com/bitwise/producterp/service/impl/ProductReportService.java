/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitwise.producterp.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

/**
 *
 * @author edb
 */
public class ProductReportService {

    public static void main(String[] args) throws FileNotFoundException {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/TestDB", "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
            return;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Customer Id", "id", DataTypes.integerType()),
                        Columns.column("First Name", "first_name", DataTypes.stringType()),
                        Columns.column("Last Name", "last_name", DataTypes.stringType()),
                        Columns.column("Date", "bdate", DataTypes.dateType()))
                .title(//title of the report
                        Components.text("SimpleReportExample")
                                .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource("SELECT id, first_name, last_name, bdate FROM customers",
                        connection);

        try {
            //show the report
            //report.show();

            //export the report to a pdf file
            report.toPdf(new FileOutputStream("/Users/edb/git/MyProjects/producterp/report.pdf"));
        } catch (DRException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
