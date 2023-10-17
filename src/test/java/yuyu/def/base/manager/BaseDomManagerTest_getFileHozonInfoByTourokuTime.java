package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getFileHozonInfoByTourokuTime() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getFileHozonInfoByTourokuTime extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if ( null == aS_FileSyurui1 ) {

            aS_FileSyurui1 = new AS_FileSyurui();
            aS_FileSyurui1.setFileSyuruiCd(pFileSyuruiCd1);

            baseDomManager.insert(aS_FileSyurui1);
        }

        AS_FileSyurui aS_FileSyurui2 = baseDomManager.getFileSyurui(pFileSyuruiCd2);
        if ( null == aS_FileSyurui2 ) {

            aS_FileSyurui2 = new AS_FileSyurui();
            aS_FileSyurui2.setFileSyuruiCd(pFileSyuruiCd2);

            baseDomManager.insert(aS_FileSyurui2);
        }

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";
        String pUniqueId6 = "UNI0000006";
        String pUniqueId7 = "UNI0000007";
        String pUniqueId8 = "UNI0000008";
        String pUniqueId9 = "UNI0000009";
        String pUniqueId10 = "UNI0000010";
        String pUniqueId11 = "UNI0000011";
        String pHaitaKey1 = "HK00000001";
        String pHaitaKey2 = "HK00000002";
        String pHaitaKey3 = "HK00000003";
        String pTourokuTime1 = "20150602000000000";
        String pTourokuTime2 = "20150602000000000";
        String pTourokuTime3 = "20150607000000000";
        String pTourokuTime4 = "20150601000000000";
        String pTourokuTime5 = "20150601000000000";
        String pTourokuTime6 = "20150602000000000";
        String pTourokuTime7 = "20150603000000000";
        String pTourokuTime8 = "20150604000000000";
        String pTourokuTime9 = "20150605000000000";
        String pTourokuTime10 = "20150606000000000";
        String pTourokuTime11 = "20150607000000000";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null == aT_FileHozonInfo1 ) {

            aT_FileHozonInfo1 = new AT_FileHozonInfo();
            aT_FileHozonInfo1.setUniqueId(pUniqueId1);
            aT_FileHozonInfo1.setFileSyuruiCd(pFileSyuruiCd1);
            aT_FileHozonInfo1.setHaitaKey(pHaitaKey1);
            aT_FileHozonInfo1.setTourokuTime(pTourokuTime1);

            baseDomManager.insert(aT_FileHozonInfo1);
        }

        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null == aT_FileHozonInfo2 ) {

            aT_FileHozonInfo2 = new AT_FileHozonInfo();
            aT_FileHozonInfo2.setUniqueId(pUniqueId2);
            aT_FileHozonInfo2.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo2.setHaitaKey(pHaitaKey2);
            aT_FileHozonInfo2.setTourokuTime(pTourokuTime2);

            baseDomManager.insert(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null == aT_FileHozonInfo3 ) {

            aT_FileHozonInfo3 = new AT_FileHozonInfo();
            aT_FileHozonInfo3.setUniqueId(pUniqueId3);
            aT_FileHozonInfo3.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo3.setHaitaKey(pHaitaKey2);
            aT_FileHozonInfo3.setTourokuTime(pTourokuTime3);

            baseDomManager.insert(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null == aT_FileHozonInfo4 ) {

            aT_FileHozonInfo4 = new AT_FileHozonInfo();
            aT_FileHozonInfo4.setUniqueId(pUniqueId4);
            aT_FileHozonInfo4.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo4.setHaitaKey(pHaitaKey2);
            aT_FileHozonInfo4.setTourokuTime(pTourokuTime4);

            baseDomManager.insert(aT_FileHozonInfo4);
        }

        AT_FileHozonInfo aT_FileHozonInfo5 = baseDomManager.getFileHozonInfo(pUniqueId5);
        if ( null == aT_FileHozonInfo5 ) {

            aT_FileHozonInfo5 = new AT_FileHozonInfo();
            aT_FileHozonInfo5.setUniqueId(pUniqueId5);
            aT_FileHozonInfo5.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo5.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo5.setTourokuTime(pTourokuTime5);

            baseDomManager.insert(aT_FileHozonInfo5);
        }

        AT_FileHozonInfo aT_FileHozonInfo6 = baseDomManager.getFileHozonInfo(pUniqueId6);
        if ( null == aT_FileHozonInfo6 ) {

            aT_FileHozonInfo6 = new AT_FileHozonInfo();
            aT_FileHozonInfo6.setUniqueId(pUniqueId6);
            aT_FileHozonInfo6.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo6.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo6.setTourokuTime(pTourokuTime6);

            baseDomManager.insert(aT_FileHozonInfo6);
        }

        AT_FileHozonInfo aT_FileHozonInfo7 = baseDomManager.getFileHozonInfo(pUniqueId7);
        if ( null == aT_FileHozonInfo7 ) {

            aT_FileHozonInfo7 = new AT_FileHozonInfo();
            aT_FileHozonInfo7.setUniqueId(pUniqueId7);
            aT_FileHozonInfo7.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo7.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo7.setTourokuTime(pTourokuTime7);

            baseDomManager.insert(aT_FileHozonInfo7);
        }

        AT_FileHozonInfo aT_FileHozonInfo8 = baseDomManager.getFileHozonInfo(pUniqueId8);
        if ( null == aT_FileHozonInfo8 ) {

            aT_FileHozonInfo8 = new AT_FileHozonInfo();
            aT_FileHozonInfo8.setUniqueId(pUniqueId8);
            aT_FileHozonInfo8.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo8.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo8.setTourokuTime(pTourokuTime8);

            baseDomManager.insert(aT_FileHozonInfo8);
        }

        AT_FileHozonInfo aT_FileHozonInfo9 = baseDomManager.getFileHozonInfo(pUniqueId9);
        if ( null == aT_FileHozonInfo9 ) {

            aT_FileHozonInfo9 = new AT_FileHozonInfo();
            aT_FileHozonInfo9.setUniqueId(pUniqueId9);
            aT_FileHozonInfo9.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo9.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo9.setTourokuTime(pTourokuTime9);

            baseDomManager.insert(aT_FileHozonInfo9);
        }

        AT_FileHozonInfo aT_FileHozonInfo10 = baseDomManager.getFileHozonInfo(pUniqueId10);
        if ( null == aT_FileHozonInfo10 ) {

            aT_FileHozonInfo10 = new AT_FileHozonInfo();
            aT_FileHozonInfo10.setUniqueId(pUniqueId10);
            aT_FileHozonInfo10.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo10.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo10.setTourokuTime(pTourokuTime10);

            baseDomManager.insert(aT_FileHozonInfo10);
        }

        AT_FileHozonInfo aT_FileHozonInfo11 = baseDomManager.getFileHozonInfo(pUniqueId11);
        if ( null == aT_FileHozonInfo11 ) {

            aT_FileHozonInfo11 = new AT_FileHozonInfo();
            aT_FileHozonInfo11.setUniqueId(pUniqueId11);
            aT_FileHozonInfo11.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo11.setHaitaKey(pHaitaKey3);
            aT_FileHozonInfo11.setTourokuTime(pTourokuTime11);

            baseDomManager.insert(aT_FileHozonInfo11);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";
        String pUniqueId6 = "UNI0000006";
        String pUniqueId7 = "UNI0000007";
        String pUniqueId8 = "UNI0000008";
        String pUniqueId9 = "UNI0000009";
        String pUniqueId10 = "UNI0000010";
        String pUniqueId11 = "UNI0000011";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null != aT_FileHozonInfo1 ) {

            baseDomManager.delete(aT_FileHozonInfo1);
        }

        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null != aT_FileHozonInfo2 ) {

            baseDomManager.delete(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null != aT_FileHozonInfo3 ) {

            baseDomManager.delete(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null != aT_FileHozonInfo4 ) {

            baseDomManager.delete(aT_FileHozonInfo4);
        }

        AT_FileHozonInfo aT_FileHozonInfo5 = baseDomManager.getFileHozonInfo(pUniqueId5);
        if ( null != aT_FileHozonInfo5 ) {

            baseDomManager.delete(aT_FileHozonInfo5);
        }

        AT_FileHozonInfo aT_FileHozonInfo6 = baseDomManager.getFileHozonInfo(pUniqueId6);
        if ( null != aT_FileHozonInfo6 ) {

            baseDomManager.delete(aT_FileHozonInfo6);
        }

        AT_FileHozonInfo aT_FileHozonInfo7 = baseDomManager.getFileHozonInfo(pUniqueId7);
        if ( null != aT_FileHozonInfo7 ) {

            baseDomManager.delete(aT_FileHozonInfo7);
        }

        AT_FileHozonInfo aT_FileHozonInfo8 = baseDomManager.getFileHozonInfo(pUniqueId8);
        if ( null != aT_FileHozonInfo8 ) {

            baseDomManager.delete(aT_FileHozonInfo8);
        }

        AT_FileHozonInfo aT_FileHozonInfo9 = baseDomManager.getFileHozonInfo(pUniqueId9);
        if ( null != aT_FileHozonInfo9 ) {

            baseDomManager.delete(aT_FileHozonInfo9);
        }

        AT_FileHozonInfo aT_FileHozonInfo10 = baseDomManager.getFileHozonInfo(pUniqueId10);
        if ( null != aT_FileHozonInfo10 ) {

            baseDomManager.delete(aT_FileHozonInfo10);
        }

        AT_FileHozonInfo aT_FileHozonInfo11 = baseDomManager.getFileHozonInfo(pUniqueId11);
        if ( null != aT_FileHozonInfo11 ) {

            baseDomManager.delete(aT_FileHozonInfo11);
        }

        C_FileSyuruiCdKbn pFileSyuruiCd1 = C_FileSyuruiCdKbn.BLNK;
        C_FileSyuruiCdKbn pFileSyuruiCd2 = C_FileSyuruiCdKbn.BLNK;

        AS_FileSyurui aS_FileSyurui1 = baseDomManager.getFileSyurui(pFileSyuruiCd1);
        if ( null != aS_FileSyurui1 ) {

            baseDomManager.delete(aS_FileSyurui1);
        }

        AS_FileSyurui aS_FileSyurui2 = baseDomManager.getFileSyurui(pFileSyuruiCd2);
        if ( null != aS_FileSyurui2 ) {

            baseDomManager.delete(aS_FileSyurui2);
        }
    }

    @Test
    public void test001(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000099";
        String pTourokuTimeFrom = "20150602000000000";
        String pTourokuTimeTo = "20150602000000000";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        assertEquals(0, aT_FileHozonInfoList.size());

    }

    @Test
    public void test002(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000001";
        String pTourokuTimeFrom = "20150602000000000";
        String pTourokuTimeTo = "20150602000000000";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        assertEquals(1, aT_FileHozonInfoList.size());
    }

    @Test
    public void test003(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000002";
        String pTourokuTimeFrom = "20150600000000000";
        String pTourokuTimeTo = "20150608000000000";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        assertEquals(3, aT_FileHozonInfoList.size());
    }

    @Test
    public void test004(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "";
        String pTourokuTimeFrom = "";
        String pTourokuTimeTo = "";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        assertEquals(0, aT_FileHozonInfoList.size());
    }

    @Test
    public void test005(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = null;
        String pHaitaKey = null;
        String pTourokuTimeFrom = null;
        String pTourokuTimeTo = null;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        assertEquals(11, aT_FileHozonInfoList.size());
    }

    @Test
    public void test006(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000003";
        String pTourokuTimeFrom = "20150602000000000";
        String pTourokuTimeTo = "20150606000000000";

        String pTourokuTime1 = "20150602000000000";
        String pTourokuTime2 = "20150603000000000";
        String pTourokuTime3 = "20150604000000000";
        String pTourokuTime4 = "20150605000000000";
        String pTourokuTime5 = "20150606000000000";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        assertEquals(pTourokuTime1, aT_FileHozonInfoList.get(0).getTourokuTime());
        assertEquals(pTourokuTime2, aT_FileHozonInfoList.get(1).getTourokuTime());
        assertEquals(pTourokuTime3, aT_FileHozonInfoList.get(2).getTourokuTime());
        assertEquals(pTourokuTime4, aT_FileHozonInfoList.get(3).getTourokuTime());
        assertEquals(pTourokuTime5, aT_FileHozonInfoList.get(4).getTourokuTime());
    }

    @Test
    public void test007(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        String pHaitaKey = "HK00000002";
        String pTourokuTimeFrom = "20150600000000000";
        String pTourokuTimeTo = "20150608000000000";
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByTourokuTime(pFileSyuruiCd, pHaitaKey, pTourokuTimeFrom, pTourokuTimeTo);

        String pTourokuTime1 = "20150602000000000";
        String pTourokuTime2 = "20150607000000000";
        String pTourokuTime3 = "20150601000000000";

        assertEquals(pTourokuTime3, aT_FileHozonInfoList.get(0).getTourokuTime());
        assertEquals(pTourokuTime1, aT_FileHozonInfoList.get(1).getTourokuTime());
        assertEquals(pTourokuTime2, aT_FileHozonInfoList.get(2).getTourokuTime());
    }
}
