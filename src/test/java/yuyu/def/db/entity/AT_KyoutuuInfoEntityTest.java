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
 * 共通情報 エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_KyoutuuInfoEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";
        String pSubSystemId3 = "SSI0000003";
        String pSubSystemId4 = "SSI0000004";
        String pSubSystemId5 = "SSI0000005";
        String pCategoryId1 = "CI00000001";
        String pCategoryId2 = "CI00000002";
        String pCategoryId3 = "CI00000003";
        String pCategoryId4 = "CI00000004";
        String pCategoryId5 = "CI00000005";
        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";
        String pInfoSeqNo1 = "JR00000001";
        String pInfoSeqNo2 = "JR00000002";
        String pInfoSeqNo3 = "JR00000003";
        String pInfoSeqNo4 = "JR00000004";
        String pInfoSeqNo5 = "JR00000005";

        AT_KyoutuuInfo aT_KyoutuuInfo1 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId1, pInfoSeqNo1);
        if ( null == aT_KyoutuuInfo1 ){

            aT_KyoutuuInfo1 = new AT_KyoutuuInfo();
            aT_KyoutuuInfo1.setSubSystemId(pSubSystemId1);
            aT_KyoutuuInfo1.setCategoryId(pCategoryId1);
            aT_KyoutuuInfo1.setKinouId(pKinouId1);
            aT_KyoutuuInfo1.setInfoSeqNo(pInfoSeqNo1);

            baseDomManager.insert(aT_KyoutuuInfo1);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo2 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId2, pInfoSeqNo2);
        if ( null == aT_KyoutuuInfo2 ){

            aT_KyoutuuInfo2 = new AT_KyoutuuInfo();
            aT_KyoutuuInfo2.setSubSystemId(pSubSystemId2);
            aT_KyoutuuInfo2.setCategoryId(pCategoryId2);
            aT_KyoutuuInfo2.setKinouId(pKinouId2);
            aT_KyoutuuInfo2.setInfoSeqNo(pInfoSeqNo2);

            baseDomManager.insert(aT_KyoutuuInfo2);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo3 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId3, pInfoSeqNo3);
        if ( null == aT_KyoutuuInfo3 ){

            aT_KyoutuuInfo3 = new AT_KyoutuuInfo();
            aT_KyoutuuInfo3.setSubSystemId(pSubSystemId3);
            aT_KyoutuuInfo3.setCategoryId(pCategoryId3);
            aT_KyoutuuInfo3.setKinouId(pKinouId3);
            aT_KyoutuuInfo3.setInfoSeqNo(pInfoSeqNo3);

            baseDomManager.insert(aT_KyoutuuInfo3);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo4 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId4, pInfoSeqNo4);
        if ( null == aT_KyoutuuInfo4 ){

            aT_KyoutuuInfo4 = new AT_KyoutuuInfo();
            aT_KyoutuuInfo4.setSubSystemId(pSubSystemId4);
            aT_KyoutuuInfo4.setCategoryId(pCategoryId4);
            aT_KyoutuuInfo4.setKinouId(pKinouId4);
            aT_KyoutuuInfo4.setInfoSeqNo(pInfoSeqNo4);

            baseDomManager.insert(aT_KyoutuuInfo4);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo5 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId5, pInfoSeqNo5);
        if ( null == aT_KyoutuuInfo5 ){

            aT_KyoutuuInfo5 = new AT_KyoutuuInfo();
            aT_KyoutuuInfo5.setSubSystemId(pSubSystemId5);
            aT_KyoutuuInfo5.setCategoryId(pCategoryId5);
            aT_KyoutuuInfo5.setKinouId(pKinouId5);
            aT_KyoutuuInfo5.setInfoSeqNo(pInfoSeqNo5);

            baseDomManager.insert(aT_KyoutuuInfo5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";
        String pInfoSeqNo1 = "JR00000001";
        String pInfoSeqNo2 = "JR00000002";
        String pInfoSeqNo3 = "JR00000003";
        String pInfoSeqNo4 = "JR00000004";
        String pInfoSeqNo5 = "JR00000005";

        AT_KyoutuuInfo aT_KyoutuuInfo1 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId1, pInfoSeqNo1);
        if ( null != aT_KyoutuuInfo1 ){

            baseDomManager.delete(aT_KyoutuuInfo1);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo2 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId2, pInfoSeqNo2);
        if ( null != aT_KyoutuuInfo2 ){

            baseDomManager.delete(aT_KyoutuuInfo2);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo3 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId3, pInfoSeqNo3);
        if ( null != aT_KyoutuuInfo3 ){

            baseDomManager.delete(aT_KyoutuuInfo3);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo4 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId4, pInfoSeqNo4);
        if ( null != aT_KyoutuuInfo4 ){

            baseDomManager.delete(aT_KyoutuuInfo4);
        }

        AT_KyoutuuInfo aT_KyoutuuInfo5 = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId5, pInfoSeqNo5);
        if ( null != aT_KyoutuuInfo5 ){

            baseDomManager.delete(aT_KyoutuuInfo5);
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
        String pKinouId = "KI00000001";
        String pInfoSeqNo = "JR00000001";
        AT_KyoutuuInfo aT_KyoutuuInfo = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId, pInfoSeqNo);

        assertEquals(pKinouId, aT_KyoutuuInfo.getKinouId());
        assertEquals(pInfoSeqNo, aT_KyoutuuInfo.getInfoSeqNo());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000099";
        String pInfoSeqNo = "JR00000099";
        AT_KyoutuuInfo aT_KyoutuuInfo = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId, pInfoSeqNo);

        assertNull(aT_KyoutuuInfo);
    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "";
        String pInfoSeqNo = "";
        AT_KyoutuuInfo aT_KyoutuuInfo = baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId, pInfoSeqNo);

        assertNull(aT_KyoutuuInfo);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = null;
        String pInfoSeqNo = null;
        try {
            baseDomManager.getKyoutuuInfoByKinouIdInfoSeqNo(pKinouId, pInfoSeqNo);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
