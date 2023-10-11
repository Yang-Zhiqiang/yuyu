/**
 * 単体テスト用のシステム日付変更クラス
 */
package yuyu.testinfr;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

import jp.co.slcs.swak.date.BizDate;

/**
 * 単体テスト用のシステム日付変更クラスです。
 */
public class SystemDateChange {


    private static final String BASE_DIRECTORY_PATH = "src/main/webapp/WEB-INF/classes/conf";

    private static final String SYS_DATE_FILE_NAME = "SysDate.dat";

    private static final String EVACUATE_FILE_NAME = "evacuate.dat";

    private static Object lock = new Object();

    private SystemDateChange(){}

    static void changeSystemDate(BizDate changeDate){

        synchronized (lock) {

            try{
                evacuateSystemDateFile();

                createSystemDateFile(changeDate);
            }
            catch(IOException e){
                throw new RuntimeException(e);
            }

            BizDate.refreshTestSysDate();
        }
    }

    static void revialSystemDateFile(){

        synchronized (lock) {
            File systemDateFile = new File(BASE_DIRECTORY_PATH + File.separator
                    + SYS_DATE_FILE_NAME);

            File evacuateFile = new File(BASE_DIRECTORY_PATH + File.separator
                    + EVACUATE_FILE_NAME);

            systemDateFile.delete();

            boolean result = evacuateFile.renameTo(systemDateFile);

            if (!result) {
                throw new RuntimeException("復帰に失敗");
            }

            systemDateFile.setLastModified(System.currentTimeMillis());

            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            BizDate.refreshTestSysDate();
        }
    }

    private static void createSystemDateFile(BizDate changeDate) throws IOException {
        File systemDateFile = new File(BASE_DIRECTORY_PATH + File.separator
                + SYS_DATE_FILE_NAME);

        FileWriter fw = null;
        BufferedWriter bw = null;

        Calendar cal = Calendar.getInstance();
        BizDate today = BizDate.valueOf(cal);
        int span = changeDate.subtractDays(today);

        try {
            fw = new FileWriter(systemDateFile);
            bw = new BufferedWriter(fw);

            bw.write("UseSetting=true");
            bw.newLine();
            //            bw.write("Year=" + span.getYears());
            bw.write("Year=0");
            bw.newLine();
            //            bw.write("Month=" + span.getMonths());
            bw.write("Month=0");
            bw.newLine();
            //            bw.write("Day=" + span.getDays());
            bw.write("Day=" + span);
            bw.newLine();
            bw.write("Hour=0");
            bw.newLine();
            bw.write("Minute=0");
            bw.newLine();
            bw.write("Second=0");
            bw.newLine();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (fw != null) {
                fw.close();
            }
        }
    }

    private static void evacuateSystemDateFile(){
        File systemDateFile = new File(BASE_DIRECTORY_PATH + File.separator
                + SYS_DATE_FILE_NAME);

        if (!systemDateFile.exists()) {
            return;
        }

        File evacuateFile = new File(BASE_DIRECTORY_PATH + File.separator
                + EVACUATE_FILE_NAME);

        if (evacuateFile.exists()) {
            evacuateFile.delete();
        }

        boolean result = systemDateFile.renameTo(evacuateFile);

        if (!result) {
            throw new RuntimeException("退避に失敗");
        }
    }

    //    public static void main(String[] args){
    //
    //        changeSystemDate(BizDate.valueOf(2004, 3, 14));
    //        System.out.println("日付変更後のシステム日付：" + BizDate.getSysDate().toString());
    //
    //        revialSystemDateFile();
    //        System.out.println("日付復活後のシステム日付：" + BizDate.getSysDate().toString());
    //    }
}
