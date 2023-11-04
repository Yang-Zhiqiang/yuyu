package yuyu.def.db.entity;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
 * 機能モード基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_KinouModeEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ){

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);

        }

        String pKinouModeId1 = "KMI0000001";
        String pKinouModeId2 = "KMI0000002";
        String pKinouModeId3 = "KMI0000003";
        String pKinouModeId4 = "KMI0000004";
        String pKinouModeId5 = "KMI0000005";

        AS_KinouMode aS_KinouMode1 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId1);
        if ( null == aS_KinouMode1 ){

            aS_KinouMode1 = aS_Kinou.createKinouMode();
            aS_KinouMode1.setKinouModeId(pKinouModeId1);

        }

        AS_KinouMode aS_KinouMode2 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId2);
        if ( null == aS_KinouMode2 ){

            aS_KinouMode2 = aS_Kinou.createKinouMode();
            aS_KinouMode2.setKinouModeId(pKinouModeId2);

        }

        AS_KinouMode aS_KinouMode3 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId3);
        if ( null == aS_KinouMode3 ){

            aS_KinouMode3 = aS_Kinou.createKinouMode();
            aS_KinouMode3.setKinouModeId(pKinouModeId3);

        }

        AS_KinouMode aS_KinouMode4 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId4);
        if ( null == aS_KinouMode4 ){

            aS_KinouMode4 = aS_Kinou.createKinouMode();
            aS_KinouMode4.setKinouModeId(pKinouModeId4);

        }

        AS_KinouMode aS_KinouMode5 = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId5);
        if ( null == aS_KinouMode5 ){

            aS_KinouMode5 = aS_Kinou.createKinouMode();
            aS_KinouMode5.setKinouModeId(pKinouModeId5);

        }

        baseDomManager.update(aS_Kinou);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";
        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);

        if ( null != aS_Kinou ){
            aS_Kinou.getKinouModes().removeAll(aS_Kinou.getKinouModes());

            baseDomManager.update(aS_Kinou);
            baseDomManager.delete(aS_Kinou);
        }
    }

    @Override
    @Test
    public void getAll() {

        String kinouId = "KI00000001";
        Set<AS_KinouMode> kinouModeList = baseDomManager.getKinou(kinouId).getKinouModes();

        List<AS_KinouMode> resultKinouModeList = ImmutableList.copyOf(Iterables.filter(kinouModeList, new Predicate<AS_KinouMode>() {

            @Override
            public boolean apply(AS_KinouMode pKinouModeEntity) {

                List<String> kinouModeIdList = new ArrayList<String>();
                kinouModeIdList.add("KMI0000001");
                kinouModeIdList.add("KMI0000002");
                kinouModeIdList.add("KMI0000003");
                kinouModeIdList.add("KMI0000004");
                kinouModeIdList.add("KMI0000005");

                for (String kinouModeId : kinouModeIdList) {
                    if (kinouModeId.equals(pKinouModeEntity.getKinouModeId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultKinouModeList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);

        assertEquals(pKinouId, aS_KinouMode.getKinouId());
        assertEquals(pKinouModeId, aS_KinouMode.getKinouModeId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000099";
        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);

        assertNull(aS_KinouMode);

    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "";
        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);

        assertNull(aS_KinouMode);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = "KI00000001";
        String pKinouModeId = null;
        try {
            baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
