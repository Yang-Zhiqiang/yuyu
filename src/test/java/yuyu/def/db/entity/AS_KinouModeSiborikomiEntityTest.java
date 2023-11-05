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
 * 機能モード絞込み基幹テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AS_KinouModeSiborikomiEntityTest implements EntityTestInterface {

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

        String pKinouModeId = "KMI0000001";

        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);
        if( null == aS_KinouMode ){

            aS_KinouMode = aS_Kinou.createKinouMode();
            aS_KinouMode.setKinouModeId(pKinouModeId);

            baseDomManager.update(aS_Kinou);
        }

        String pSiborikomiId1 = "SI00000001";
        String pSiborikomiId2 = "SI00000002";
        String pSiborikomiId3 = "SI00000003";
        String pSiborikomiId4 = "SI00000004";
        String pSiborikomiId5 = "SI00000005";

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi1 = aS_KinouMode.getKinouModoSiborikomi(pSiborikomiId1);
        if ( null == aS_KinouModeSiborikomi1 ){

            aS_KinouModeSiborikomi1 = aS_KinouMode.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi1.setSiborikomiId(pSiborikomiId1);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi2 = aS_KinouMode.getKinouModoSiborikomi(pSiborikomiId2);
        if ( null == aS_KinouModeSiborikomi2 ){

            aS_KinouModeSiborikomi2 = aS_KinouMode.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi2.setSiborikomiId(pSiborikomiId2);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi3 = aS_KinouMode.getKinouModoSiborikomi(pSiborikomiId3);
        if ( null == aS_KinouModeSiborikomi3 ){

            aS_KinouModeSiborikomi3 = aS_KinouMode.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi3.setSiborikomiId(pSiborikomiId3);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi4 = aS_KinouMode.getKinouModoSiborikomi(pSiborikomiId4);
        if ( null == aS_KinouModeSiborikomi4 ){

            aS_KinouModeSiborikomi4 = aS_KinouMode.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi4.setSiborikomiId(pSiborikomiId4);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi5 = aS_KinouMode.getKinouModoSiborikomi(pSiborikomiId5);
        if ( null == aS_KinouModeSiborikomi5 ){

            aS_KinouModeSiborikomi5 = aS_KinouMode.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi5.setSiborikomiId(pSiborikomiId5);

        }
        baseDomManager.update(aS_Kinou);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        AS_KinouMode aS_KinouMode = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId);
        if ( null != aS_KinouMode ){

            aS_KinouMode.getKinouModeSiborikomis().removeAll(aS_KinouMode.getKinouModeSiborikomis());
            aS_Kinou.getKinouModes().remove(aS_KinouMode);

            baseDomManager.update(aS_Kinou);
            baseDomManager.delete(aS_Kinou);
        }
    }

    @Override
    @Test
    public void getAll() {

        String kinouId = "KI00000001";
        String kinouModeId = "KMI0000001";
        List<AS_KinouModeSiborikomi> kinouModeSiborikomiList = baseDomManager.getKinou(kinouId).getKinouMode(kinouModeId).getKinouModeSiborikomis();

        List<AS_KinouModeSiborikomi> resultKinouModeSiborikomiList = ImmutableList.copyOf(Iterables.filter(kinouModeSiborikomiList, new Predicate<AS_KinouModeSiborikomi>() {

            @Override
            public boolean apply(AS_KinouModeSiborikomi pKinouModeSiborikomiEntity) {

                List<String> siborikomiIdList = new ArrayList<String>();
                siborikomiIdList.add("SI00000001");
                siborikomiIdList.add("SI00000002");
                siborikomiIdList.add("SI00000003");
                siborikomiIdList.add("SI00000004");
                siborikomiIdList.add("SI00000005");

                for (String siborikomiId : siborikomiIdList) {
                    if (siborikomiId.equals(pKinouModeSiborikomiEntity.getSiborikomiId())) {
                        return true;
                    }
                }

                return false;
            }

        }));

        long count = resultKinouModeSiborikomiList.size();
        assertEquals(5, count);
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pSiborikomiId = "SI00000001";
        AS_KinouModeSiborikomi aS_KinouModeSiborikomi = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouModoSiborikomi(pSiborikomiId);

        assertEquals(pKinouId, aS_KinouModeSiborikomi.getKinouId());
        assertEquals(pKinouModeId, aS_KinouModeSiborikomi.getKinouModeId());
        assertEquals(pSiborikomiId, aS_KinouModeSiborikomi.getSiborikomiId());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pSiborikomiId = "SI00000099";
        AS_KinouModeSiborikomi aS_KinouModeSiborikomi = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouModoSiborikomi(pSiborikomiId);

        assertNull(aS_KinouModeSiborikomi);

    }

    @Override
    @Test
    public void blankCondition() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pSiborikomiId = "";
        AS_KinouModeSiborikomi aS_KinouModeSiborikomi = baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouModoSiborikomi(pSiborikomiId);

        assertNull(aS_KinouModeSiborikomi);
    }

    @Override
    @Test
    public void nullCondition() {
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        String pSiborikomiId = null;
        try {
            baseDomManager.getKinou(pKinouId).getKinouMode(pKinouModeId).getKinouModoSiborikomi(pSiborikomiId);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
