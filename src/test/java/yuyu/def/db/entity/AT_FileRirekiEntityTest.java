package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;

/**
 * ファイル履歴 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_FileRirekiEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUniqueId1 = "UNI0000001";
        String pUniqueId2 = "UNI0000002";
        String pUniqueId3 = "UNI0000003";
        String pUniqueId4 = "UNI0000004";
        String pUniqueId5 = "UNI0000005";
        String pHistoryId = "RI00000001";
        String pFileNm1 = "FN00000001";
        String pFileNm2 = "FN00000002";
        String pFileNm3 = "FN00000003";
        String pFileNm4 = "FN00000004";
        String pFileNm5 = "FN00000005";
        long pFileSize1 = 1;
        long pFileSize2 = 2;
        long pFileSize3 = 3;
        long pFileSize4 = 4;
        long pFileSize5 = 5;
        String pTourokuTime1 = "20150602191552813";
        String pTourokuTime2 = "20150602151552813";
        String pTourokuTime3 = "20150602151552912";
        String pTourokuTime4 = "20150612151552991";
        String pTourokuTime5 = "20150518221552991";
        int pFileNmSuffix1 = 1;
        int pFileNmSuffix2 = 2;
        int pFileNmSuffix3 = 3;
        int pFileNmSuffix4 = 4;
        int pFileNmSuffix5 = 5;

        AT_FileRireki aT_FileRireki1 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId1,
            pHistoryId, pTourokuTime1, pFileNmSuffix1);
        if ( null == aT_FileRireki1 ) {

            aT_FileRireki1 = new AT_FileRireki();
            aT_FileRireki1.setUniqueId(pUniqueId1);
            aT_FileRireki1.setHistoryId(pHistoryId);
            aT_FileRireki1.setFileNm(pFileNm1);
            aT_FileRireki1.setFileSize(pFileSize1);
            aT_FileRireki1.setTourokuTime(pTourokuTime1);
            aT_FileRireki1.setFileNmSuffix(pFileNmSuffix1);

            baseDomManager.insert(aT_FileRireki1);
        }

        AT_FileRireki aT_FileRireki2 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId2,
            pHistoryId, pTourokuTime2, pFileNmSuffix2);
        if ( null == aT_FileRireki2 ) {

            aT_FileRireki2 = new AT_FileRireki();
            aT_FileRireki2.setUniqueId(pUniqueId2);
            aT_FileRireki2.setHistoryId(pHistoryId);
            aT_FileRireki2.setFileNm(pFileNm2);
            aT_FileRireki2.setFileSize(pFileSize2);
            aT_FileRireki2.setTourokuTime(pTourokuTime2);
            aT_FileRireki2.setFileNmSuffix(pFileNmSuffix2);

            baseDomManager.insert(aT_FileRireki2);
        }

        AT_FileRireki aT_FileRireki3 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId3,
            pHistoryId, pTourokuTime3, pFileNmSuffix3);
        if ( null == aT_FileRireki3 ) {

            aT_FileRireki3 = new AT_FileRireki();
            aT_FileRireki3.setUniqueId(pUniqueId3);
            aT_FileRireki3.setHistoryId(pHistoryId);
            aT_FileRireki3.setFileNm(pFileNm3);
            aT_FileRireki3.setFileSize(pFileSize3);
            aT_FileRireki3.setTourokuTime(pTourokuTime3);
            aT_FileRireki3.setFileNmSuffix(pFileNmSuffix3);

            baseDomManager.insert(aT_FileRireki3);
        }

        AT_FileRireki aT_FileRireki4 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId4,
            pHistoryId, pTourokuTime4, pFileNmSuffix4);
        if ( null == aT_FileRireki4 ) {

            aT_FileRireki4 = new AT_FileRireki();
            aT_FileRireki4.setUniqueId(pUniqueId4);
            aT_FileRireki4.setHistoryId(pHistoryId);
            aT_FileRireki4.setFileNm(pFileNm4);
            aT_FileRireki4.setFileSize(pFileSize4);
            aT_FileRireki4.setTourokuTime(pTourokuTime4);
            aT_FileRireki4.setFileNmSuffix(pFileNmSuffix4);

            baseDomManager.insert(aT_FileRireki4);
        }

        AT_FileRireki aT_FileRireki5 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId5,
            pHistoryId, pTourokuTime5, pFileNmSuffix5);
        if ( null == aT_FileRireki5 ) {

            aT_FileRireki5 = new AT_FileRireki();
            aT_FileRireki5.setUniqueId(pUniqueId5);
            aT_FileRireki5.setHistoryId(pHistoryId);
            aT_FileRireki5.setFileNm(pFileNm5);
            aT_FileRireki5.setFileSize(pFileSize5);
            aT_FileRireki5.setTourokuTime(pTourokuTime5);
            aT_FileRireki5.setFileNmSuffix(pFileNmSuffix5);

            baseDomManager.insert(aT_FileRireki5);
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
        String pHistoryId = "RI00000001";
        String pTourokuTime1 = "20150602191552813";
        String pTourokuTime2 = "20150602151552813";
        String pTourokuTime3 = "20150602151552912";
        String pTourokuTime4 = "20150612151552991";
        String pTourokuTime5 = "20150518221552991";
        int pFileNmSuffix1 = 1;
        int pFileNmSuffix2 = 2;
        int pFileNmSuffix3 = 3;
        int pFileNmSuffix4 = 4;
        int pFileNmSuffix5 = 5;

        AT_FileRireki aT_FileRireki1 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId1,
            pHistoryId, pTourokuTime1, pFileNmSuffix1);
        if ( null != aT_FileRireki1 ) {

            baseDomManager.delete(aT_FileRireki1);
        }

        AT_FileRireki aT_FileRireki2 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId2,
            pHistoryId, pTourokuTime2, pFileNmSuffix2);
        if ( null != aT_FileRireki2 ) {

            baseDomManager.delete(aT_FileRireki2);
        }

        AT_FileRireki aT_FileRireki3 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId3,
            pHistoryId, pTourokuTime3, pFileNmSuffix3);
        if ( null != aT_FileRireki3 ) {

            baseDomManager.delete(aT_FileRireki3);
        }

        AT_FileRireki aT_FileRireki4 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId4,
            pHistoryId, pTourokuTime4, pFileNmSuffix4);
        if ( null != aT_FileRireki4 ) {

            baseDomManager.delete(aT_FileRireki4);
        }

        AT_FileRireki aT_FileRireki5 = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId5,
            pHistoryId, pTourokuTime5, pFileNmSuffix5);
        if ( null != aT_FileRireki5 ) {

            baseDomManager.delete(aT_FileRireki5);
        }
    }

    @Override
    @Test
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUniqueId = "UNI0000001";
        String pHistoryId = "RI00000001";
        String pTourokuTime = "20150602191552813";
        Integer pFileNmSuffix = 1;

        AT_FileRireki aT_FileRireki = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId,
            pHistoryId, pTourokuTime, pFileNmSuffix);

        assertEquals(pUniqueId, aT_FileRireki.getUniqueId());
        assertEquals(pHistoryId, aT_FileRireki.getHistoryId());
        assertEquals(pTourokuTime, aT_FileRireki.getTourokuTime());
        assertEquals(pFileNmSuffix, aT_FileRireki.getFileNmSuffix());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUniqueId = "UNI0000099";
        String pHistoryId = "RI00000001";
        String pTourokuTime = "20150602191552813";
        Integer pFileNmSuffix = 1;

        AT_FileRireki aT_FileRireki = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId,
            pHistoryId, pTourokuTime, pFileNmSuffix);

        assertNull(aT_FileRireki);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUniqueId = "";
        String pHistoryId = "RI00000001";
        String pTourokuTime = "20150602191552813";
        Integer pFileNmSuffix = 1;

        AT_FileRireki aT_FileRireki = baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId,
            pHistoryId, pTourokuTime, pFileNmSuffix);

        assertNull(aT_FileRireki);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUniqueId = null;
        String pHistoryId = "RI00000001";
        String pTourokuTime = "20150602191552813";
        Integer pFileNmSuffix = 1;

        try {
            baseDomManager.getFileRirekiByUniqueIdHistoryIdTourokuTimeFileNm(pUniqueId, pHistoryId, pTourokuTime, pFileNmSuffix);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
