package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.testinfr.TestOrder;

/**
 * BaseDomManagerクラスの、<br />
 * getFileHozonInfosByFileSyuruiCdTourokuTime() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getFileHozonInfosByFileSyuruiCdTourokuTime {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AT_FileHozonInfo> fileHozonInfoLst = baseDomManager.getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, "20151105");

        Assert.assertEquals(0,fileHozonInfoLst.size());

        fileHozonInfoLst =  baseDomManager.getAllFileHozonInfo();

        if (fileHozonInfoLst.size() == 0) {
            AT_FileHozonInfo fileHozonInfo = new AT_FileHozonInfo();
            fileHozonInfo.setUniqueId("10000000001");
            fileHozonInfo.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
            fileHozonInfo.setTourokuTime("20171103");
            baseDomManager.insert(fileHozonInfo);

            AT_FileHozonInfo fileHozonInfo2 = new AT_FileHozonInfo();
            fileHozonInfo2.setUniqueId("10000000002");
            fileHozonInfo2.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
            fileHozonInfo2.setTourokuTime("20171128");
            baseDomManager.insert(fileHozonInfo2);

            AT_FileHozonInfo fileHozonInfo3 = new AT_FileHozonInfo();
            fileHozonInfo3.setUniqueId("10000000003");
            fileHozonInfo3.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
            fileHozonInfo3.setTourokuTime("20171129");
            baseDomManager.insert(fileHozonInfo3);

            AT_FileHozonInfo fileHozonInfo4 = new AT_FileHozonInfo();
            fileHozonInfo4.setUniqueId("10000000004");
            fileHozonInfo4.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
            fileHozonInfo4.setTourokuTime("20171111");
            baseDomManager.insert(fileHozonInfo4);

            AT_FileHozonInfo fileHozonInfo5 = new AT_FileHozonInfo();
            fileHozonInfo5.setUniqueId("10000000005");
            fileHozonInfo5.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST);
            fileHozonInfo5.setTourokuTime("20171112");
            baseDomManager.insert(fileHozonInfo5);

            AT_FileHozonInfo fileHozonInfo6 = new AT_FileHozonInfo();
            fileHozonInfo6.setUniqueId("10000000006");
            fileHozonInfo6.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_HUBIMIKAISYOLST);
            fileHozonInfo6.setTourokuTime("20171111");
            baseDomManager.insert(fileHozonInfo6);

            AT_FileHozonInfo fileHozonInfo7 = new AT_FileHozonInfo();
            fileHozonInfo7.setUniqueId("10000000007");
            fileHozonInfo7.setFileSyuruiCd(C_FileSyuruiCdKbn.SK_HUBIBUNSEKILST);
            fileHozonInfo7.setTourokuTime("20171112");
            baseDomManager.insert(fileHozonInfo7);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllFileHozonInfo());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<AT_FileHozonInfo> fileHozonInfoLst = baseDomManager.getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, "20151101");

        assertEquals(0, fileHozonInfoLst.size());

    }

    @Test
    @TestOrder(20)
    public void blankCondition1() {

        List<AT_FileHozonInfo> fileHozonInfoLst = baseDomManager.getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, "");

        assertEquals(0, fileHozonInfoLst.size());

    }

    @Test
    @TestOrder(30)
    public void normal1(){

        List<AT_FileHozonInfo> fileHozonInfoLst = baseDomManager.getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, "20171105");

        assertEquals(1, fileHozonInfoLst.size());
        assertEquals("10000000001", fileHozonInfoLst.get(0).getUniqueId());
        assertEquals("20171103", fileHozonInfoLst.get(0).getTourokuTime());
        assertEquals(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, fileHozonInfoLst.get(0).getFileSyuruiCd());
    }

    @Test
    @TestOrder(40)
    public void normal2(){

        List<AT_FileHozonInfo> fileHozonInfoLst = baseDomManager.getFileHozonInfosByFileSyuruiCdTourokuTime(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, "20171128");

        assertEquals(3, fileHozonInfoLst.size());
        assertEquals("10000000001", fileHozonInfoLst.get(0).getUniqueId());
        assertEquals("20171103", fileHozonInfoLst.get(0).getTourokuTime());
        assertEquals(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, fileHozonInfoLst.get(0).getFileSyuruiCd());

        assertEquals("10000000004", fileHozonInfoLst.get(1).getUniqueId());
        assertEquals("20171111", fileHozonInfoLst.get(1).getTourokuTime());
        assertEquals(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, fileHozonInfoLst.get(1).getFileSyuruiCd());

        assertEquals("10000000005", fileHozonInfoLst.get(2).getUniqueId());
        assertEquals("20171112", fileHozonInfoLst.get(2).getTourokuTime());
        assertEquals(C_FileSyuruiCdKbn.SK_TEISEIKOUMOKULST, fileHozonInfoLst.get(2).getFileSyuruiCd());
    }
}
