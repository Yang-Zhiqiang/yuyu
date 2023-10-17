package yuyu.def.base.manager;

import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.AT_FileHozonInfo;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、
 * getFileHozonInfoCountByFileNm() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getFileHozonInfoCountByFileNm extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pFileNm1 = "FN00000001";
        String pFileNm2 = "FN00000002";

        AT_FileHozonInfo aT_FileHozonInfo1 = baseDomManager.getFileHozonInfo(pUniqueId1);
        if ( null == aT_FileHozonInfo1 ) {

            aT_FileHozonInfo1 = new AT_FileHozonInfo();
            aT_FileHozonInfo1.setUniqueId(pUniqueId1);
            aT_FileHozonInfo1.setFileNm(pFileNm1);

            baseDomManager.insert(aT_FileHozonInfo1);
        }

        AT_FileHozonInfo aT_FileHozonInfo2 = baseDomManager.getFileHozonInfo(pUniqueId2);
        if ( null == aT_FileHozonInfo2 ) {

            aT_FileHozonInfo2 = new AT_FileHozonInfo();
            aT_FileHozonInfo2.setUniqueId(pUniqueId2);
            aT_FileHozonInfo2.setFileNm(pFileNm2);

            baseDomManager.insert(aT_FileHozonInfo2);
        }

        AT_FileHozonInfo aT_FileHozonInfo3 = baseDomManager.getFileHozonInfo(pUniqueId3);
        if ( null == aT_FileHozonInfo3 ) {

            aT_FileHozonInfo3 = new AT_FileHozonInfo();
            aT_FileHozonInfo3.setUniqueId(pUniqueId3);
            aT_FileHozonInfo3.setFileNm(pFileNm2);

            baseDomManager.insert(aT_FileHozonInfo3);
        }

        AT_FileHozonInfo aT_FileHozonInfo4 = baseDomManager.getFileHozonInfo(pUniqueId4);
        if ( null == aT_FileHozonInfo4 ) {

            aT_FileHozonInfo4 = new AT_FileHozonInfo();
            aT_FileHozonInfo4.setUniqueId(pUniqueId4);
            aT_FileHozonInfo4.setFileNm(pFileNm2);

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
    }

    @Test
    public void test001(){
        String pFileNm = "FN00000099";
        long count = baseDomManager.getFileHozonInfoCountByFileNm(pFileNm);

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        String pFileNm = "FN00000001";
        long count = baseDomManager.getFileHozonInfoCountByFileNm(pFileNm);

        assertEquals(1, count);
    }

    @Test
    public void test003(){
        String pFileNm = "FN00000002";
        long count = baseDomManager.getFileHozonInfoCountByFileNm(pFileNm);

        assertEquals(3, count);
    }

    @Test
    public void test004(){
        String pFileNm = "";
        long count = baseDomManager.getFileHozonInfoCountByFileNm(pFileNm);

        assertEquals(0, count);
    }

    @Test
    public void test005(){
        String pFileNm = null;
        long count = baseDomManager.getFileHozonInfoCountByFileNm(pFileNm);

        assertEquals(0, count);
    }

}
