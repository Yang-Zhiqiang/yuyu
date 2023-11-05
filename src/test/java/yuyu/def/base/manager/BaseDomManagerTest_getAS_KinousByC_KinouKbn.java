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

import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.testinfr.AbstractTest;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * BaseDomManagerクラスの、<br />
 * getAS_KinousByC_KinouKbn() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getAS_KinousByC_KinouKbn extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        C_KinouKbn pKinouKbn1 = C_KinouKbn.ONLINE;
        C_KinouKbn pKinouKbn2 = C_KinouKbn.BATCH;

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ) {

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);
            aS_Kinou1.setKinouKbn(pKinouKbn1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ) {

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);
            aS_Kinou2.setKinouKbn(pKinouKbn2);

            baseDomManager.insert(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null == aS_Kinou3 ) {

            aS_Kinou3 = new AS_Kinou();
            aS_Kinou3.setKinouId(pKinouId3);
            aS_Kinou3.setKinouKbn(pKinouKbn2);

            baseDomManager.insert(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null == aS_Kinou4 ) {

            aS_Kinou4 = new AS_Kinou();
            aS_Kinou4.setKinouId(pKinouId4);
            aS_Kinou4.setKinouKbn(pKinouKbn2);

            baseDomManager.insert(aS_Kinou4);
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

    }

    @Test
    public void test001(){

        C_KinouKbn pC_KinouKbn = C_KinouKbn.ONLINEBATCH;
        List<AS_Kinou> aS_KinouList = baseDomManager.getAS_KinousByC_KinouKbn(pC_KinouKbn);

        List<AS_Kinou> resultaS_KinouList = ImmutableList.copyOf(Iterables.filter(aS_KinouList, new Predicate<AS_Kinou>() {

            @Override
            public boolean apply(AS_Kinou paS_KinouEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000001");
                pKinouIdList.add("KI00000002");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000004");

                for (String kinouId : pKinouIdList) {
                    if (kinouId.equals(paS_KinouEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaS_KinouList.size();

        assertEquals(0, count);

    }

    @Test
    public void test002(){
        C_KinouKbn pC_KinouKbn = C_KinouKbn.ONLINE;
        List<AS_Kinou> aS_KinouList = baseDomManager.getAS_KinousByC_KinouKbn(pC_KinouKbn);

        List<AS_Kinou> resultaS_KinouList = ImmutableList.copyOf(Iterables.filter(aS_KinouList, new Predicate<AS_Kinou>() {

            @Override
            public boolean apply(AS_Kinou paS_KinouEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000001");
                pKinouIdList.add("KI00000002");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000004");

                for (String kinouId : pKinouIdList) {
                    if (kinouId.equals(paS_KinouEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaS_KinouList.size();

        assertEquals(1, count);
    }

    @Test
    public void test003(){
        C_KinouKbn pC_KinouKbn = C_KinouKbn.BATCH;
        List<AS_Kinou> aS_KinouList = baseDomManager.getAS_KinousByC_KinouKbn(pC_KinouKbn);

        List<AS_Kinou> resultaS_KinouList = ImmutableList.copyOf(Iterables.filter(aS_KinouList, new Predicate<AS_Kinou>() {

            @Override
            public boolean apply(AS_Kinou paS_KinouEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000001");
                pKinouIdList.add("KI00000002");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000004");

                for (String kinouId : pKinouIdList) {
                    if (kinouId.equals(paS_KinouEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaS_KinouList.size();

        assertEquals(3, count);

    }

    @Test
    public void test004(){
        List<AS_Kinou> aS_KinouList = baseDomManager.getAS_KinousByC_KinouKbn(null);

        List<AS_Kinou> resultaS_KinouList = ImmutableList.copyOf(Iterables.filter(aS_KinouList, new Predicate<AS_Kinou>() {

            @Override
            public boolean apply(AS_Kinou paS_KinouEntity) {

                List<String> pKinouIdList = new ArrayList<String>();
                pKinouIdList.add("KI00000001");
                pKinouIdList.add("KI00000002");
                pKinouIdList.add("KI00000003");
                pKinouIdList.add("KI00000004");

                for (String kinouId : pKinouIdList) {
                    if (kinouId.equals(paS_KinouEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultaS_KinouList.size();

        assertEquals(4, count);

    }

}
