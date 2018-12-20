package designpattern;

import java.sql.Connection;

class MySqlHelper{
    public static Connection getMysqlDBConnection(){
        System.out.println("get mysql db connection");
        return null;
    }

    public void generateMysqlPDFReport(String tableName,Connection con){
        System.out.println("MYSQL(" + con + "): get data from " + tableName + " and generate pdf");
    }

    public void generateMysqlHTMLReport(String tableName,Connection con){
        System.out.println("MYSQL(" + con + "): get data from " + tableName + " and generate pdf");
    }
}

class OracleHelper{
    public static Connection getOracleDBConnection(){
        System.out.println("get oracle db connection");
        return null;
    }

    public void generateOraclePDFReport(String tableName,Connection con){
        System.out.println("ORACLE(" + con + "): get data from " + tableName + " and generate pdf");
    }

    public void generateOracleHTMLReport(String tableName,Connection con){
        System.out.println("ORACLE(" + con + "): get data from " + tableName + " and generate pdf");
    }
}

class FacadeHepler{
    enum DBType{
        MYSQL,ORACLE
    }

    enum ReportType{
        PDF,HTML
    }

    public static void generateReport(DBType dbType,ReportType reportType,String tableName){
        Connection con = null;
        switch (dbType){
            case MYSQL:
                con = MySqlHelper.getMysqlDBConnection();
                MySqlHelper mySqlHelper = new MySqlHelper();
                switch (reportType){
                    case HTML:
                        mySqlHelper.generateMysqlHTMLReport(tableName,con);
                        break;
                    case PDF:
                        mySqlHelper.generateMysqlPDFReport(tableName,con);
                        break;
                }
                break;
            case ORACLE:
                con = OracleHelper.getOracleDBConnection();
                OracleHelper oracleHelper = new OracleHelper();
                switch (reportType){
                    case HTML:
                        oracleHelper.generateOracleHTMLReport(tableName,con);
                        break;
                    case PDF:
                        oracleHelper.generateOraclePDFReport(tableName,con);
                        break;
                }
                break;
        }
    }
}

public class DemoFacade {
    public static void main(String[] args) {
        String tableName = "Student";

        Connection con = MySqlHelper.getMysqlDBConnection();
        MySqlHelper mySqlHelper = new MySqlHelper();
        mySqlHelper.generateMysqlPDFReport(tableName,con);

        Connection con2 = OracleHelper.getOracleDBConnection();
        OracleHelper oracleHelper = new OracleHelper();
        oracleHelper.generateOraclePDFReport(tableName,con2);

        FacadeHepler.generateReport(
                FacadeHepler.DBType.MYSQL,
                FacadeHepler.ReportType.PDF,
                tableName);
        FacadeHepler.generateReport(
                FacadeHepler.DBType.ORACLE,
                FacadeHepler.ReportType.HTML,
                tableName);
    }
}
