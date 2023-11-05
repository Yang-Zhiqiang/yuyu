package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

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

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * 機能基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_KinouEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId1 = "KI00000001";
        String pKinouId2 = "KI00000002";
        String pKinouId3 = "KI00000003";
        String pKinouId4 = "KI00000004";
        String pKinouId5 = "KI00000005";

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null == aS_Kinou1 ){

            aS_Kinou1 = new AS_Kinou();
            aS_Kinou1.setKinouId(pKinouId1);

            baseDomManager.insert(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null == aS_Kinou2 ){

            aS_Kinou2 = new AS_Kinou();
            aS_Kinou2.setKinouId(pKinouId2);

            baseDomManager.insert(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null == aS_Kinou3 ){

            aS_Kinou3 = new AS_Kinou();
            aS_Kinou3.setKinouId(pKinouId3);

            baseDomManager.insert(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null == aS_Kinou4 ){

            aS_Kinou4 = new AS_Kinou();
            aS_Kinou4.setKinouId(pKinouId4);

            baseDomManager.insert(aS_Kinou4);
        }

        AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
        if ( null == aS_Kinou5 ){

            aS_Kinou5 = new AS_Kinou();
            aS_Kinou5.setKinouId(pKinouId5);

            baseDomManager.insert(aS_Kinou5);
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

        AS_Kinou aS_Kinou1 = baseDomManager.getKinou(pKinouId1);
        if ( null != aS_Kinou1 ){

            baseDomManager.delete(aS_Kinou1);
        }

        AS_Kinou aS_Kinou2 = baseDomManager.getKinou(pKinouId2);
        if ( null != aS_Kinou2 ){

            baseDomManager.delete(aS_Kinou2);
        }

        AS_Kinou aS_Kinou3 = baseDomManager.getKinou(pKinouId3);
        if ( null != aS_Kinou3 ){

            baseDomManager.delete(aS_Kinou3);
        }

        AS_Kinou aS_Kinou4 = baseDomManager.getKinou(pKinouId4);
        if ( null != aS_Kinou4 ){

            baseDomManager.delete(aS_Kinou4);
        }

        AS_Kinou aS_Kinou5 = baseDomManager.getKinou(pKinouId5);
        if ( null != aS_Kinou5 ){

            baseDomManager.delete(aS_Kinou5);
        }
    }

    @Override
    @Test
    public void getAll() {

        List<AS_Kinou> kinouList = baseDomManager.getAllKinous();

        List<AS_Kinou> resultKinouList = ImmutableList.copyOf(Iterables.filter(kinouList, new Predicate<AS_Kinou>() {

            @Override
            public boolean apply(AS_Kinou pKinouEntity) {

                List<String> kinouIdList = new ArrayList<String>();
                kinouIdList.add("KI00000001");
                kinouIdList.add("KI00000002");
                kinouIdList.add("KI00000003");
                kinouIdList.add("KI00000004");
                kinouIdList.add("KI00000005");

                for (String kinouId : kinouIdList) {
                    if (kinouId.equals(pKinouEntity.getKinouId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultKinouList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKinouId = "KI00000001";
        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);

        assertEquals(pKinouId, aS_Kinou.getKinouId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000099";
        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);

        assertNull(aS_Kinou);

    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "";
        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);

        assertNull(aS_Kinou);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = null;
        try {
            baseDomManager.getKinou(pKinouId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
