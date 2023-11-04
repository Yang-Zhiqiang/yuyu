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
import yuyu.def.classification.C_HozonHousiki;

/**
 * ファイル履歴管理 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_FileRirekiKanriEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHistoryId1 = "RI00000001";
        String pHistoryId2 = "RI00000002";
        String pHistoryId3 = "RI00000003";
        String pHistoryId4 = "RI00000004";
        String pHistoryId5 = "RI00000005";
        C_HozonHousiki pHozonHousiki1 = C_HozonHousiki.LOCAL;
        C_HozonHousiki pHozonHousiki2 = C_HozonHousiki.DB;
        C_HozonHousiki pHozonHousiki3 = C_HozonHousiki.LOCAL;
        C_HozonHousiki pHozonHousiki4 = C_HozonHousiki.FILESERVER;
        C_HozonHousiki pHozonHousiki5 = C_HozonHousiki.DB;

        AT_FileRirekiKanri aT_FileRirekiKanri1 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId1);
        if ( null == aT_FileRirekiKanri1 ){

            aT_FileRirekiKanri1 = new AT_FileRirekiKanri();
            aT_FileRirekiKanri1.setHistoryId(pHistoryId1);
            aT_FileRirekiKanri1.setHozonHousiki(pHozonHousiki1);

            baseDomManager.insert(aT_FileRirekiKanri1);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri2 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId2);
        if ( null == aT_FileRirekiKanri2 ){

            aT_FileRirekiKanri2 = new AT_FileRirekiKanri();
            aT_FileRirekiKanri2.setHistoryId(pHistoryId2);
            aT_FileRirekiKanri2.setHozonHousiki(pHozonHousiki2);

            baseDomManager.insert(aT_FileRirekiKanri2);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri3 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId3);
        if ( null == aT_FileRirekiKanri3 ){

            aT_FileRirekiKanri3 = new AT_FileRirekiKanri();
            aT_FileRirekiKanri3.setHistoryId(pHistoryId3);
            aT_FileRirekiKanri3.setHozonHousiki(pHozonHousiki3);

            baseDomManager.insert(aT_FileRirekiKanri3);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri4 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId4);
        if ( null == aT_FileRirekiKanri4 ){

            aT_FileRirekiKanri4 = new AT_FileRirekiKanri();
            aT_FileRirekiKanri4.setHistoryId(pHistoryId4);
            aT_FileRirekiKanri4.setHozonHousiki(pHozonHousiki4);

            baseDomManager.insert(aT_FileRirekiKanri4);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri5 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId5);
        if ( null == aT_FileRirekiKanri5 ){

            aT_FileRirekiKanri5 = new AT_FileRirekiKanri();
            aT_FileRirekiKanri5.setHistoryId(pHistoryId5);
            aT_FileRirekiKanri5.setHozonHousiki(pHozonHousiki5);

            baseDomManager.insert(aT_FileRirekiKanri5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pHistoryId1 = "RI00000001";
        String pHistoryId2 = "RI00000002";
        String pHistoryId3 = "RI00000003";
        String pHistoryId4 = "RI00000004";
        String pHistoryId5 = "RI00000005";

        AT_FileRirekiKanri aT_FileRirekiKanri1 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId1);
        if ( null != aT_FileRirekiKanri1 ){

            baseDomManager.delete(aT_FileRirekiKanri1);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri2 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId2);
        if ( null != aT_FileRirekiKanri2 ){

            baseDomManager.delete(aT_FileRirekiKanri2);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri3 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId3);
        if ( null != aT_FileRirekiKanri3 ){

            baseDomManager.delete(aT_FileRirekiKanri3);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri4 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId4);
        if ( null != aT_FileRirekiKanri4 ){

            baseDomManager.delete(aT_FileRirekiKanri4);
        }

        AT_FileRirekiKanri aT_FileRirekiKanri5 = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId5);
        if ( null != aT_FileRirekiKanri5 ){

            baseDomManager.delete(aT_FileRirekiKanri5);
        }
    }

    @Override
    @Test
    @Transactional
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pHistoryId = "RI00000001";
        AT_FileRirekiKanri aT_FileRirekiKanri = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId);

        assertEquals(pHistoryId, aT_FileRirekiKanri.getHistoryId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pHistoryId = "RI00000099";
        AT_FileRirekiKanri aT_FileRirekiKanri = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId);

        assertNull(aT_FileRirekiKanri);
    }

    @Override
    @Test
    public void blankCondition() {
        String pHistoryId = "";
        AT_FileRirekiKanri aT_FileRirekiKanri = baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId);

        assertNull(aT_FileRirekiKanri);
    }

    @Override
    @Test
    public void nullCondition() {
        String pHistoryId = "RI00000001";
        try {
            baseDomManager.getFileRirekiKanriByHistoryId(pHistoryId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
