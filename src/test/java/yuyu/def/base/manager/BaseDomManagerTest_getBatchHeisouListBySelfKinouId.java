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

import yuyu.def.db.entity.AS_BatchHeisouList;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchHeisouListBySelfKinouId() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchHeisouListBySelfKinouId extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pTargetKinouId1 = "TK00000001";
        String pTargetKinouId2 = "TK00000002";
        String pTargetKinouId3 = "TK00000003";
        String pTargetKinouId4 = "TK00000004";

        AS_BatchHeisouList aS_BatchHeisouList1 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId1, pTargetKinouId1);
        if ( null == aS_BatchHeisouList1 ) {

            aS_BatchHeisouList1 = new AS_BatchHeisouList();
            aS_BatchHeisouList1.setSelfKinouId(pKinouId1);
            aS_BatchHeisouList1.setTargetKinouId(pTargetKinouId1);

            baseDomManager.insert(aS_BatchHeisouList1);
        }


        AS_BatchHeisouList aS_BatchHeisouList2 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId2, pTargetKinouId2);
        if ( null == aS_BatchHeisouList2 ) {

            aS_BatchHeisouList2 = new AS_BatchHeisouList();
            aS_BatchHeisouList2.setSelfKinouId(pKinouId2);
            aS_BatchHeisouList2.setTargetKinouId(pTargetKinouId2);

            baseDomManager.insert(aS_BatchHeisouList2);
        }

        AS_BatchHeisouList aS_BatchHeisouList3 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId2, pTargetKinouId3);
        if ( null == aS_BatchHeisouList3 ) {

            aS_BatchHeisouList3 = new AS_BatchHeisouList();
            aS_BatchHeisouList3.setSelfKinouId(pKinouId2);
            aS_BatchHeisouList3.setTargetKinouId(pTargetKinouId3);

            baseDomManager.insert(aS_BatchHeisouList3);
        }

        AS_BatchHeisouList aS_BatchHeisouList4 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId2, pTargetKinouId4);
        if ( null == aS_BatchHeisouList4 ) {

            aS_BatchHeisouList4 = new AS_BatchHeisouList();
            aS_BatchHeisouList4.setSelfKinouId(pKinouId2);
            aS_BatchHeisouList4.setTargetKinouId(pTargetKinouId4);

            baseDomManager.insert(aS_BatchHeisouList4);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pTargetKinouId1 = "TK00000001";
        String pTargetKinouId2 = "TK00000002";
        String pTargetKinouId3 = "TK00000003";
        String pTargetKinouId4 = "TK00000004";

        AS_BatchHeisouList aS_BatchHeisouList1 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId1, pTargetKinouId1);
        if ( null != aS_BatchHeisouList1 ) {

            baseDomManager.delete(aS_BatchHeisouList1);
        }

        AS_BatchHeisouList aS_BatchHeisouList2 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId2, pTargetKinouId2);
        if ( null != aS_BatchHeisouList2 ) {

            baseDomManager.delete(aS_BatchHeisouList2);
        }

        AS_BatchHeisouList aS_BatchHeisouList3 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId2, pTargetKinouId3);
        if ( null != aS_BatchHeisouList3 ) {

            baseDomManager.delete(aS_BatchHeisouList3);
        }

        AS_BatchHeisouList aS_BatchHeisouList4 = baseDomManager.getBatchHeisouListBySelfKinouIdTargetKinouId(pKinouId2, pTargetKinouId4);
        if ( null != aS_BatchHeisouList4 ) {

            baseDomManager.delete(aS_BatchHeisouList4);
        }

    }

    @Test
    public void test001(){
        String pSelfKinouId = "KI00000003";
        List<AS_BatchHeisouList> aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouId(pSelfKinouId);

        assertEquals(0, aS_BatchHeisouList.size());
    }


    @Test
    public void test002(){
        String pSelfKinouId = "KI00000001";
        List<AS_BatchHeisouList> aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouId(pSelfKinouId);

        assertEquals(1, aS_BatchHeisouList.size());
    }


    @Test
    public void test003(){
        String pSelfKinouId = "KI00000002";
        List<AS_BatchHeisouList> aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouId(pSelfKinouId);

        assertEquals(3, aS_BatchHeisouList.size());
    }


    @Test
    public void test004(){
        String pSelfKinouId = "";
        List<AS_BatchHeisouList> aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouId(pSelfKinouId);

        assertEquals(0, aS_BatchHeisouList.size());
    }


    @Test
    public void test005(){
        String pSelfKinouId = null;
        List<AS_BatchHeisouList> aS_BatchHeisouList = baseDomManager.getBatchHeisouListBySelfKinouId(pSelfKinouId);

        assertEquals(4, aS_BatchHeisouList.size());
    }

}
