package yuyu.def.base.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BatchModeKbn;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.db.entity.AM_Batch;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.testinfr.AbstractTest;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * BaseDomManagerクラスの、<br />
 * getBatchBySubSystem() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getBatchBySubSystem extends AbstractTest {


    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";

        AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
        if ( null == aS_SubSystem1 ) {

            aS_SubSystem1 = new AS_SubSystem();
            aS_SubSystem1.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(aS_SubSystem1);
        }

        AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
        if ( null == aS_SubSystem2 ) {

            aS_SubSystem2 = new AS_SubSystem();
            aS_SubSystem2.setSubSystemId(pSubSystemId2);

            baseDomManager.insert(aS_SubSystem2);
        }

        String pCategoryId1 = "Ca00000001";
        String pCategoryId2 = "Ca00000002";

        AS_Category category1 = baseDomManager.getCategory(pCategoryId1);
        if(category1 == null){

            category1 = new AS_Category();
            category1.setCategoryId(pCategoryId1);
            category1.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(category1);
        }

        AS_Category category2 = baseDomManager.getCategory(pCategoryId2);
        if(category2 == null){

            category2 = new AS_Category();
            category2.setCategoryId(pCategoryId2);
            category2.setSubSystemId(pSubSystemId2);

            baseDomManager.insert(category2);
        }

        String pKinouId1 = "KI00000005";
        String pKinouId2 = "KI00000004";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000002";


        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ) {

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);
            aS_Kinou1.setCategoryId(pCategoryId1);
            aS_Kinou1.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ) {

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);
            aS_Kinou2.setCategoryId(pCategoryId1);
            aS_Kinou2.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null == aS_Kinou3 ) {

            aS_Kinou3 = new AS_Kinou();
            aS_Kinou3.setKinouId(pKinouId3);
            aS_Kinou3.setCategoryId(pCategoryId1);
            aS_Kinou3.setSubSystemId(pSubSystemId1);

            baseDomManager.insert(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null == aS_Kinou4 ) {

            aS_Kinou4 = new AS_Kinou();
            aS_Kinou4.setKinouId(pKinouId4);
            aS_Kinou4.setCategoryId(pCategoryId2);
            aS_Kinou4.setSubSystemId(pSubSystemId2);

            baseDomManager.insert(aS_Kinou4);
        }

        String pBatchClass1 = "BC00000001";
        String pBatchClass2 = "BC00000002";
        String pBatchClass3 = "BC00000003";
        String pBatchClass4 = "BC00000004";
        C_KahiKbn pTajuukidouKahiKbn1 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn2 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn3 = C_KahiKbn.KA;
        C_KahiKbn pTajuukidouKahiKbn4 = C_KahiKbn.KA;
        C_BatchModeKbn pBatchMode1 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode2 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode3 = C_BatchModeKbn .HIDOUKI;
        C_BatchModeKbn pBatchMode4 = C_BatchModeKbn .HIDOUKI;
        C_KahiKbn pTyuudanKahi1 = C_KahiKbn.HUKA;
        C_KahiKbn pTyuudanKahi2 = C_KahiKbn.HUKA;
        C_KahiKbn pTyuudanKahi3 = C_KahiKbn.KA;
        C_KahiKbn pTyuudanKahi4 = C_KahiKbn.KA;

        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if ( null == aM_Batch1 ) {

            aM_Batch1 = new AM_Batch();
            aM_Batch1.setKinouId(pKinouId1);
            aM_Batch1.setBatchClass(pBatchClass1);
            aM_Batch1.setTajuukidouKahiKbn(pTajuukidouKahiKbn1);
            aM_Batch1.setBatchMode(pBatchMode1);
            aM_Batch1.setTyuudanKahi(pTyuudanKahi1);

            baseDomManager.insert(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if ( null == aM_Batch2 ) {

            aM_Batch2 = new AM_Batch();
            aM_Batch2.setKinouId(pKinouId2);
            aM_Batch2.setBatchClass(pBatchClass2);
            aM_Batch2.setTajuukidouKahiKbn(pTajuukidouKahiKbn2);
            aM_Batch2.setBatchMode(pBatchMode2);
            aM_Batch2.setTyuudanKahi(pTyuudanKahi2);

            baseDomManager.insert(aM_Batch2);
        }

        AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
        if ( null == aM_Batch3 ) {

            aM_Batch3 = new AM_Batch();
            aM_Batch3.setKinouId(pKinouId3);
            aM_Batch3.setBatchClass(pBatchClass3);
            aM_Batch3.setTajuukidouKahiKbn(pTajuukidouKahiKbn3);
            aM_Batch3.setBatchMode(pBatchMode3);
            aM_Batch3.setTyuudanKahi(pTyuudanKahi3);

            baseDomManager.insert(aM_Batch3);
        }

        AM_Batch aM_Batch4 = baseDomManager.getBatch(pKinouId4);
        if ( null == aM_Batch4 ) {

            aM_Batch4 = new AM_Batch();
            aM_Batch4.setKinouId(pKinouId4);
            aM_Batch4.setBatchClass(pBatchClass4);
            aM_Batch4.setTajuukidouKahiKbn(pTajuukidouKahiKbn4);
            aM_Batch4.setBatchMode(pBatchMode4);
            aM_Batch4.setTyuudanKahi(pTyuudanKahi4);

            baseDomManager.insert(aM_Batch4);
        }

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pSubSystemId1 = "SSI0000001";
        String pSubSystemId2 = "SSI0000002";

        AS_SubSystem aS_SubSystem1 = baseDomManager.getSubSystem(pSubSystemId1);
        if ( null != aS_SubSystem1 ) {

            baseDomManager.delete(aS_SubSystem1);
        }

        AS_SubSystem aS_SubSystem2 = baseDomManager.getSubSystem(pSubSystemId2);
        if ( null != aS_SubSystem2 ) {

            baseDomManager.delete(aS_SubSystem2);
        }

        String pCategoryId1 = "Ca00000001";
        String pCategoryId2 = "Ca00000002";

        AS_Category category1 = baseDomManager.getCategory(pCategoryId1);
        if(category1 != null){
            baseDomManager.delete(category1);
        }

        AS_Category category2 = baseDomManager.getCategory(pCategoryId2);
        if(category2 != null){
            baseDomManager.delete(category2);
        }

        String pKinouId1 = "KI00000005";
        String pKinouId2 = "KI00000004";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000002";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ) {

            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ) {

            baseDomManager.delete(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null != aS_Kinou3 ) {

            baseDomManager.delete(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null != aS_Kinou4 ) {

            baseDomManager.delete(aS_Kinou4);
        }


        AM_Batch aM_Batch1 = baseDomManager.getBatch(pKinouId1);
        if ( null != aM_Batch1 ) {

            baseDomManager.delete(aM_Batch1);
        }

        AM_Batch aM_Batch2 = baseDomManager.getBatch(pKinouId2);
        if ( null != aM_Batch2 ) {

            baseDomManager.delete(aM_Batch2);
        }

        AM_Batch aM_Batch3 = baseDomManager.getBatch(pKinouId3);
        if ( null != aM_Batch3 ) {

            baseDomManager.delete(aM_Batch3);
        }

        AM_Batch aM_Batch4 = baseDomManager.getBatch(pKinouId4);
        if ( null != aM_Batch4 ) {

            baseDomManager.delete(aM_Batch4);
        }

    }

    @Test
    public void test001(){
        String pSubSystemId = "SSI0000099";
        List<AM_Batch> aM_BatchList = baseDomManager.getBatchBySubSystem(pSubSystemId);

        assertEquals(0, aM_BatchList.size());
    }

    @Test
    public void test002(){
        String pSubSystemId = "SSI0000002";
        List<AM_Batch> aM_BatchList = baseDomManager.getBatchBySubSystem(pSubSystemId);

        assertEquals(1, aM_BatchList.size());
    }

    @Test
    public void test003(){
        String pSubSystemId = "SSI0000001";
        List<AM_Batch> aM_BatchList = baseDomManager.getBatchBySubSystem(pSubSystemId);

        assertEquals(3, aM_BatchList.size());
    }

    @Test
    public void test004(){

        String pSubSystemId = "";
        List<AM_Batch> aM_BatchList = baseDomManager.getBatchBySubSystem(pSubSystemId);

        List<AM_Batch> resultaM_BatchList = ImmutableList.copyOf(Iterables.filter(aM_BatchList, new Predicate<AM_Batch>() {

            @Override
            public boolean apply(AM_Batch paM_BatchEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000005");
                pKinouIdList.add("KI00000004");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000002");

                for (String kinouId : pKinouIdList) {
                    if (kinouId.equals(paM_BatchEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaM_BatchList.size();

        assertEquals(4, count);
    }

    @Test
    public void test005(){
        String pSubSystemId = null;
        List<AM_Batch> aM_BatchList = baseDomManager.getBatchBySubSystem(pSubSystemId);

        List<AM_Batch> resultaM_BatchList = ImmutableList.copyOf(Iterables.filter(aM_BatchList, new Predicate<AM_Batch>() {

            @Override
            public boolean apply(AM_Batch paM_BatchEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000005");
                pKinouIdList.add("KI00000004");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000002");

                for (String kinouId : pKinouIdList) {
                    if (kinouId.equals(paM_BatchEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaM_BatchList.size();

        assertEquals(4, count);
    }

    @Test
    public void test006(){
        String pSubSystemId = "SSI0000001";
        String pKinouId1 = "KI00000005";
        String pKinouId2 = "KI00000004";
        String pKinouId3 = "KI00000003";

        List<AM_Batch> aM_BatchList = baseDomManager.getBatchBySubSystem(pSubSystemId);

        assertEquals(pKinouId3, aM_BatchList.get(0).getKinouId());
        assertEquals(pKinouId2, aM_BatchList.get(1).getKinouId());
        assertEquals(pKinouId1, aM_BatchList.get(2).getKinouId());

    }
}
