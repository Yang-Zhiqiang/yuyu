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
 * 個別情報テーブル エンティティのテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class AT_KobetuInfoEntityTest implements EntityTestInterface {

    @Inject
    private BaseDomManager baseDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId = "UI00000001";
        String pInfoSeqNo1 = "JR00000001";
        String pInfoSeqNo2 = "JR00000002";
        String pInfoSeqNo3 = "JR00000003";
        String pInfoSeqNo4 = "JR00000004";
        String pInfoSeqNo5 = "JR00000005";

        AT_KobetuInfo aT_KobetuInfo1 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo1);
        if ( null == aT_KobetuInfo1 ){

            aT_KobetuInfo1 = new AT_KobetuInfo();
            aT_KobetuInfo1.setUserId(pUserId);
            aT_KobetuInfo1.setInfoSeqNo(pInfoSeqNo1);

            baseDomManager.insert(aT_KobetuInfo1);
        }

        AT_KobetuInfo aT_KobetuInfo2 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo2);
        if ( null == aT_KobetuInfo2 ){

            aT_KobetuInfo2 = new AT_KobetuInfo();
            aT_KobetuInfo2.setUserId(pUserId);
            aT_KobetuInfo2.setInfoSeqNo(pInfoSeqNo2);

            baseDomManager.insert(aT_KobetuInfo2);
        }

        AT_KobetuInfo aT_KobetuInfo3 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo3);
        if ( null == aT_KobetuInfo3 ){

            aT_KobetuInfo3 = new AT_KobetuInfo();
            aT_KobetuInfo3.setUserId(pUserId);
            aT_KobetuInfo3.setInfoSeqNo(pInfoSeqNo3);

            baseDomManager.insert(aT_KobetuInfo3);
        }

        AT_KobetuInfo aT_KobetuInfo4 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo4);
        if ( null == aT_KobetuInfo4 ){

            aT_KobetuInfo4 = new AT_KobetuInfo();
            aT_KobetuInfo4.setUserId(pUserId);
            aT_KobetuInfo4.setInfoSeqNo(pInfoSeqNo4);

            baseDomManager.insert(aT_KobetuInfo4);
        }

        AT_KobetuInfo aT_KobetuInfo5 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo5);
        if ( null == aT_KobetuInfo5 ){

            aT_KobetuInfo5 = new AT_KobetuInfo();
            aT_KobetuInfo5.setUserId(pUserId);
            aT_KobetuInfo5.setInfoSeqNo(pInfoSeqNo5);

            baseDomManager.insert(aT_KobetuInfo5);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        String pUserId = "UI00000001";
        String pInfoSeqNo1 = "JR00000001";
        String pInfoSeqNo2 = "JR00000002";
        String pInfoSeqNo3 = "JR00000003";
        String pInfoSeqNo4 = "JR00000004";
        String pInfoSeqNo5 = "JR00000005";

        AT_KobetuInfo aT_KobetuInfo1 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo1);
        if ( null != aT_KobetuInfo1 ){

            baseDomManager.delete(aT_KobetuInfo1);
        }

        AT_KobetuInfo aT_KobetuInfo2 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo2);
        if ( null != aT_KobetuInfo2 ){

            baseDomManager.delete(aT_KobetuInfo2);
        }

        AT_KobetuInfo aT_KobetuInfo3 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo3);
        if ( null != aT_KobetuInfo3 ){

            baseDomManager.delete(aT_KobetuInfo3);
        }

        AT_KobetuInfo aT_KobetuInfo4 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo4);
        if ( null != aT_KobetuInfo4 ){

            baseDomManager.delete(aT_KobetuInfo4);
        }

        AT_KobetuInfo aT_KobetuInfo5 = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo5);
        if ( null != aT_KobetuInfo5 ){

            baseDomManager.delete(aT_KobetuInfo5);
        }
    }

    @Override
    @Test
    public void getAll() {
    }

    @Override
    @Test
    public void getUniqueEntity() {
        String pUserId = "UI00000001";
        String pInfoSeqNo = "JR00000001";
        AT_KobetuInfo aT_KobetuInfo = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo);

        assertEquals(pUserId, aT_KobetuInfo.getUserId());
        assertEquals(pInfoSeqNo, aT_KobetuInfo.getInfoSeqNo());
    }

    @Override
    @Test
    public void noUniqueEntity() {
        String pUserId = "UI00000001";
        String pInfoSeqNo = "JR00000099";
        AT_KobetuInfo aT_KobetuInfo = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo);

        assertNull(aT_KobetuInfo);
    }

    @Override
    @Test
    public void blankCondition() {
        String pUserId = "UI00000001";
        String pInfoSeqNo = "";
        AT_KobetuInfo aT_KobetuInfo = baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo);

        assertNull(aT_KobetuInfo);
    }

    @Override
    @Test
    public void nullCondition() {
        String pUserId = "UI00000001";
        String pInfoSeqNo = null;
        try {
            baseDomManager.getKobetuInfoByUserId(pUserId, pInfoSeqNo);
        } catch (Exception e) {
            assertThat(e, instanceOf(NonUniqueResultException.class));
        }
    }
}
