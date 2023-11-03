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

import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;
import yuyu.def.db.entity.AS_KinouModeSiborikomi;
import yuyu.testinfr.AbstractTest;

/**
 * BaseDomManagerクラスの、<br />
 * getKinouModeSiborikomi() メソッドのテストクラスです。
 */
@RunWith(SWAKTestRunner.class)
public class BaseDomManagerTest_getKinouModeSiborikomi extends AbstractTest {

    @Inject
    BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null == aS_Kinou ) {

            aS_Kinou = new AS_Kinou();
            aS_Kinou.setKinouId(pKinouId);

            baseDomManager.insert(aS_Kinou);
        }

        String pKinouModeId1 = "KMI0000001";
        String pKinouModeId2 = "KMI0000002";

        AS_KinouMode aS_KinouMode1 = aS_Kinou.getKinouMode(pKinouModeId1);
        if ( null == aS_KinouMode1 ) {

            aS_KinouMode1 = aS_Kinou.createKinouMode();
            aS_KinouMode1.setKinouModeId(pKinouModeId1);

        }

        AS_KinouMode aS_KinouMode2 = aS_Kinou.getKinouMode(pKinouModeId2);
        if ( null == aS_KinouMode2 ) {

            aS_KinouMode2 = aS_Kinou.createKinouMode();
            aS_KinouMode2.setKinouModeId(pKinouModeId2);

        }

        baseDomManager.update(aS_Kinou);

        String pSiborikomiId1 = "SI00000001";
        String pSiborikomiId2 = "SI00000004";
        String pSiborikomiId3 = "SI00000002";
        String pSiborikomiId4 = "SI00000003";

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi1 = aS_KinouMode1.getKinouModoSiborikomi(pSiborikomiId1);
        if ( null == aS_KinouModeSiborikomi1 ) {

            aS_KinouModeSiborikomi1 = aS_KinouMode1.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi1.setSiborikomiId(pSiborikomiId1);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi2 = aS_KinouMode2.getKinouModoSiborikomi(pSiborikomiId2);
        if ( null == aS_KinouModeSiborikomi2 ) {

            aS_KinouModeSiborikomi2 = aS_KinouMode2.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi2.setSiborikomiId(pSiborikomiId2);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi3 = aS_KinouMode2.getKinouModoSiborikomi(pSiborikomiId3);
        if ( null == aS_KinouModeSiborikomi3 ) {

            aS_KinouModeSiborikomi3 = aS_KinouMode2.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi3.setSiborikomiId(pSiborikomiId3);

        }

        AS_KinouModeSiborikomi aS_KinouModeSiborikomi4 = aS_KinouMode2.getKinouModoSiborikomi(pSiborikomiId4);
        if ( null == aS_KinouModeSiborikomi4 ) {

            aS_KinouModeSiborikomi4 = aS_KinouMode2.createKinouModeSiborikomi();
            aS_KinouModeSiborikomi4.setSiborikomiId(pSiborikomiId4);

        }

        baseDomManager.update(aS_Kinou);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pKinouId = "KI00000001";
        String pKinouModeId1 = "KMI0000001";
        String pKinouModeId2 = "KMI0000002";

        AS_Kinou aS_Kinou = baseDomManager.getKinou(pKinouId);
        if ( null != aS_Kinou ) {

            aS_Kinou.getKinouMode(pKinouModeId1).getKinouModeSiborikomis().removeAll(aS_Kinou.getKinouMode(pKinouModeId1).getKinouModeSiborikomis());
            aS_Kinou.getKinouMode(pKinouModeId2).getKinouModeSiborikomis().removeAll(aS_Kinou.getKinouMode(pKinouModeId2).getKinouModeSiborikomis());
            aS_Kinou.getKinouModes().removeAll(aS_Kinou.getKinouModes());

            baseDomManager.update(aS_Kinou);
            baseDomManager.delete(aS_Kinou);
        }

    }

    @Test
    public void test001(){
        String pKinouId = "KI00000099";
        String pKinouModeId = "KMI0000099";
        List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomiList = baseDomManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);

        assertEquals(0, aS_KinouModeSiborikomiList.size());

    }

    @Test
    public void test002(){
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000001";
        List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomiList = baseDomManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);

        assertEquals(1, aS_KinouModeSiborikomiList.size());


    }

    @Test
    public void test003(){
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000002";
        List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomiList = baseDomManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);

        assertEquals(3, aS_KinouModeSiborikomiList.size());


    }

    @Test
    public void test004(){
        String pKinouId = "";
        String pKinouModeId = "";
        List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomiList = baseDomManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);

        assertEquals(0, aS_KinouModeSiborikomiList.size());


    }

    @Test
    public void test005(){
        String pKinouId = null;
        String pKinouModeId = null;
        List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomiList = baseDomManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);

        assertEquals(0, aS_KinouModeSiborikomiList.size());

    }

    @Test
    public void test006(){
        String pKinouId = "KI00000001";
        String pKinouModeId = "KMI0000002";
        List<AS_KinouModeSiborikomi> aS_KinouModeSiborikomiList = baseDomManager.getKinouModeSiborikomi(pKinouId, pKinouModeId);

        String pSiborikomiId1 = "SI00000004";
        String pSiborikomiId2 = "SI00000002";
        String pSiborikomiId3 = "SI00000003";

        assertEquals(pSiborikomiId2, aS_KinouModeSiborikomiList.get(0).getSiborikomiId());
        assertEquals(pSiborikomiId3, aS_KinouModeSiborikomiList.get(1).getSiborikomiId());
        assertEquals(pSiborikomiId1, aS_KinouModeSiborikomiList.get(2).getSiborikomiId());

    }
}
