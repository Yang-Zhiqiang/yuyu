package yuyu.infr.file;

import static org.junit.Assert.*;

import java.io.File;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.SWAK;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.testinfr.AbstractTest;
import yuyu.testinfr.TestOrder;

/**
 * 業務帳票基盤を使った各種テスト用クラス
 */
@RunWith(SWAKTestRunner.class)
public class FileHozonUtilTest extends AbstractTest {

    @Inject
    private FileHozonUtil4Online fileHozonUtil;

    @Test
    @TestOrder(10)
    @Transactional
    public void testBase(){

        File file = null;
        try {

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_in");
            if (!file.exists()){
                file.mkdir();
            }

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_out");
            if (!file.exists()){
                file.mkdir();
            }

            //String filePath = SWAK.getApplicationRootFile() + "\\error.html";
            C_FileSyuruiCdKbn fileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
            String haitaKey = BizDate.getSysDateTimeMilli();
            String kinouId = "testKinou";
            String fileNm = "testBase.html";

            fileHozonUtil.putFile("\\test_in\\testBase.html",  fileSyuruiCd, haitaKey, kinouId);

            FileSearchCondition condition = new FileSearchCondition();
            condition.setFileSyuruiCd(fileSyuruiCd);
            condition.setForceCompress(false);

            assertTrue(fileHozonUtil.getFile2Screen(condition, fileNm));

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(11)
    @Transactional
    public void testBase2(){
        File file = null;
        try {

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_in");
            if (!file.exists()){
                file.mkdir();
            }

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_out");
            if (!file.exists()){
                file.mkdir();
            }

            //String filePath = SWAK.getApplicationRootFile() + "\\error.html";
            C_FileSyuruiCdKbn fileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
            String haitaKey = BizDate.getSysDateTimeMilli();
            String kinouId = "testKinou";
            String fileNm = "testBase22.zip";



            fileHozonUtil.putFile("\\test_in\\testBase2.XML",  fileSyuruiCd, haitaKey, kinouId);

            FileSearchCondition condition = new FileSearchCondition();
            condition.setFileSyuruiCd(fileSyuruiCd);
            condition.setForceCompress(true);

            assertTrue(fileHozonUtil.getFile2Screen(condition, fileNm));

        } catch(Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testZipFile(){
        File file = null;
        try {

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_in");
            if (!file.exists()){
                file.mkdir();
            }

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_out");
            if (!file.exists()){
                file.mkdir();
            }


            C_FileSyuruiCdKbn fileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
            String haitaKey = BizDate.getSysDateTimeMilli();
            String kinouId = "testKinou";

            C_FileSyuruiCdKbn fileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;
            String haitaKey2 = BizDate.getSysDateTimeMilli();
            String kinouId2 = "testKinou";

            fileHozonUtil.putFile("\\test_in\\testBase3.XML", fileSyuruiCd, haitaKey, kinouId);
            fileHozonUtil.putFile("\\test_in\\testBase4.CSV", fileSyuruiCd2, haitaKey2, kinouId2);

            String fileNm = "ZipFile.zip";

            FileSearchCondition condition = new FileSearchCondition();
            condition.setFileSyuruiCd(fileSyuruiCd);
            condition.setForceCompress(false);

            fileHozonUtil.getFile2Screen(condition, fileNm);

        } catch(Exception e) {

            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testZipFile2(){
        File file = null;
        try {

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_in");
            if (!file.exists()){
                file.mkdir();
            }

            file =  new File(SWAK.getApplicationRootFile()+ "\\test_out");
            if (!file.exists()){
                file.mkdir();
            }


            C_FileSyuruiCdKbn fileSyuruiCd = C_FileSyuruiCdKbn.BLNK;

            String fileNm = "ZipFile2.zip";

            FileSearchCondition condition = new FileSearchCondition();
            condition.setFileSyuruiCd(fileSyuruiCd);
            condition.setForceCompress(true);

            fileHozonUtil.getFile2Screen(condition, fileNm);

        } catch(Exception e) {

            e.printStackTrace();
            assertTrue(false);
        }
        assertTrue(true);

    }
}
