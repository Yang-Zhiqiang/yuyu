package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、
 * getFileHozonInfoByFileSyuruiCdメソッドのテストクラスです。<br />
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getFileHozonInfoByFileSyuruiCd extends AbstractTest {

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
        String pTourokuTime1 = "20150602000000000";
        String pTourokuTime2 = "20150602000000000";
        String pTourokuTime3 = "20150607000000000";
        String pTourokuTime4 = "20150601000000000";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null == aT_FileHozonInfo1 ) {

            aT_FileHozonInfo1 = new AT_FileHozonInfo();
            aT_FileHozonInfo1.setUniqueId(pUniqueId1);
            aT_FileHozonInfo1.setFileSyuruiCd(pFileSyuruiCd1);
            aT_FileHozonInfo1.setTourokuTime(pTourokuTime1);

            baseDomManager.insert(aT_FileHozonInfo1);
        }

        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null == aT_FileHozonInfo2 ) {

            aT_FileHozonInfo2 = new AT_FileHozonInfo();
            aT_FileHozonInfo2.setUniqueId(pUniqueId2);
            aT_FileHozonInfo2.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo2.setTourokuTime(pTourokuTime2);

            baseDomManager.insert(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null == aT_FileHozonInfo3 ) {

            aT_FileHozonInfo3 = new AT_FileHozonInfo();
            aT_FileHozonInfo3.setUniqueId(pUniqueId3);
            aT_FileHozonInfo3.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo3.setTourokuTime(pTourokuTime3);

            baseDomManager.insert(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null == aT_FileHozonInfo4 ) {

            aT_FileHozonInfo4 = new AT_FileHozonInfo();
            aT_FileHozonInfo4.setUniqueId(pUniqueId4);
            aT_FileHozonInfo4.setFileSyuruiCd(pFileSyuruiCd2);
            aT_FileHozonInfo4.setTourokuTime(pTourokuTime4);

            baseDomManager.insert(aT_FileHozonInfo4);
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
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);

        assertEquals(4, aT_FileHozonInfoList.size());

    }

    @Test
    public void test002(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);

        assertEquals(4, aT_FileHozonInfoList.size());
    }

    @Test
    public void test003(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);

        assertEquals(4, aT_FileHozonInfoList.size());
    }

    @Test
    public void test004(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);

        assertEquals(4, aT_FileHozonInfoList.size());
    }

    @Test
    public void test005(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = null;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);

        assertEquals(4, aT_FileHozonInfoList.size());
    }

    @Test
    public void test006(){
    	C_FileSyuruiCdKbn pFileSyuruiCd = C_FileSyuruiCdKbn.BLNK;
        List<AT_FileHozonInfo> aT_FileHozonInfoList = baseDomManager.getFileHozonInfoByFileSyuruiCd(pFileSyuruiCd);

        String pTourokuTime1 = "20150601000000000";
        String pTourokuTime2 = "20150602000000000";
        String pTourokuTime3 = "20150607000000000";

        assertEquals(pTourokuTime1, aT_FileHozonInfoList.get(0).getTourokuTime());
        assertEquals(pTourokuTime2, aT_FileHozonInfoList.get(1).getTourokuTime());
        assertEquals(pTourokuTime2, aT_FileHozonInfoList.get(2).getTourokuTime());
        assertEquals(pTourokuTime3, aT_FileHozonInfoList.get(3).getTourokuTime());
    }
}
