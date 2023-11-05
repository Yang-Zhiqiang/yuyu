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
 * バッチ並走リスト基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_BatchHeisouListEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";
        String pTargetKinouId1 = "TK00000001";
        String pTargetKinouId2 = "TK00000002";
        String pTargetKinouId3 = "TK00000003";
        String pTargetKinouId4 = "TK00000004";
        String pTargetKinouId5 = "TK00000005";

        AS_BatchHeisouList aS_BatchHeisouList1 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId1);
        if ( null == aS_BatchHeisouList1 ) {

            aS_BatchHeisouList1 = new AS_BatchHeisouList();
            aS_BatchHeisouList1.setSelfKinouId(pKinouId);
            aS_BatchHeisouList1.setTargetKinouId(pTargetKinouId1);

            baseDomManager.insert(aS_BatchHeisouList1);
        }

        AS_BatchHeisouList aS_BatchHeisouList2 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId2);
        if ( null == aS_BatchHeisouList2 ) {

            aS_BatchHeisouList2 = new AS_BatchHeisouList();
            aS_BatchHeisouList2.setSelfKinouId(pKinouId);
            aS_BatchHeisouList2.setTargetKinouId(pTargetKinouId2);

            baseDomManager.insert(aS_BatchHeisouList2);
        }

        AS_BatchHeisouList aS_BatchHeisouList3 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId3);
        if ( null == aS_BatchHeisouList3 ) {

            aS_BatchHeisouList3 = new AS_BatchHeisouList();
            aS_BatchHeisouList3.setSelfKinouId(pKinouId);
            aS_BatchHeisouList3.setTargetKinouId(pTargetKinouId3);

            baseDomManager.insert(aS_BatchHeisouList3);
        }

        AS_BatchHeisouList aS_BatchHeisouList4 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId4);
        if ( null == aS_BatchHeisouList4 ) {

            aS_BatchHeisouList4 = new AS_BatchHeisouList();
            aS_BatchHeisouList4.setSelfKinouId(pKinouId);
            aS_BatchHeisouList4.setTargetKinouId(pTargetKinouId4);

            baseDomManager.insert(aS_BatchHeisouList4);
        }

        AS_BatchHeisouList aS_BatchHeisouList5 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId5);
        if ( null == aS_BatchHeisouList5 ) {

            aS_BatchHeisouList5 = new AS_BatchHeisouList();
            aS_BatchHeisouList5.setSelfKinouId(pKinouId);
            aS_BatchHeisouList5.setTargetKinouId(pTargetKinouId5);

            baseDomManager.insert(aS_BatchHeisouList5);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";
        String pTargetKinouId1 = "TK00000001";
        String pTargetKinouId2 = "TK00000002";
        String pTargetKinouId3 = "TK00000003";
        String pTargetKinouId4 = "TK00000004";
        String pTargetKinouId5 = "TK00000005";

        AS_BatchHeisouList aS_BatchHeisouList1 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId1);
        if ( null != aS_BatchHeisouList1 ) {

            baseDomManager.delete(aS_BatchHeisouList1);
        }

        AS_BatchHeisouList aS_BatchHeisouList2 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId2);
        if ( null != aS_BatchHeisouList2 ) {

            baseDomManager.delete(aS_BatchHeisouList2);
        }

        AS_BatchHeisouList aS_BatchHeisouList3 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId3);
        if ( null != aS_BatchHeisouList3 ) {

            baseDomManager.delete(aS_BatchHeisouList3);
        }

        AS_BatchHeisouList aS_BatchHeisouList4 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId4);
        if ( null != aS_BatchHeisouList4 ) {

            baseDomManager.delete(aS_BatchHeisouList4);
        }

        AS_BatchHeisouList aS_BatchHeisouList5 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId5);
        if ( null != aS_BatchHeisouList5 ) {

            baseDomManager.delete(aS_BatchHeisouList5);
        }
    }

    @Override
    @Test
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKinouId = "KI00000001";
        String pTargetKinouId = "TK00000001";
        AS_BatchHeisouList aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId);

        assertEquals(pKinouId, aS_BatchHeisouList.getSelfKinouId());
        assertEquals(pTargetKinouId, aS_BatchHeisouList.getTargetKinouId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000099";
        String pTargetKinouId = "TK00000099";
        AS_BatchHeisouList aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId);

        assertNull(aS_BatchHeisouList);
    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "";
        String pTargetKinouId = "";
        AS_BatchHeisouList aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId);

        assertNull(aS_BatchHeisouList);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = null;
        String pTargetKinouId = null;
        try {
            baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId, pTargetKinouId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
