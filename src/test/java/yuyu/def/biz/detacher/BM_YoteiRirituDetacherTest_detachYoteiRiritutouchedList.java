package yuyu.def.biz.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金情報取込<br />
 * 予定利率マスタエンティティリストデタッチ(予定利率マスタエンティティリスト)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BM_YoteiRirituDetacherTest_detachYoteiRiritutouchedList {

    @Inject
    BizDomManager bizDomManager;

    static String P_SYOUHNCD_01 = "SHC1";
    static String P_SYOUHNCD_02 = "SHC2";
    static String P_SYOUHNCD_03 = "SHC3";
    static BizDate P_KYKFROMYMD_01 = BizDate.valueOf("20160331");
    static BizDate P_KYKTOYMD_01 = BizDate.valueOf("20160401");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.insert(new BM_YoteiRiritu(P_SYOUHNCD_01, C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, P_KYKFROMYMD_01, P_KYKTOYMD_01));
        bizDomManager.insert(new BM_YoteiRiritu(P_SYOUHNCD_02, C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, P_KYKFROMYMD_01, P_KYKTOYMD_01));
        bizDomManager.insert(new BM_YoteiRiritu(P_SYOUHNCD_03, C_Tuukasyu.JPY, C_HhknNenKbn.BLNK, P_KYKFROMYMD_01, P_KYKTOYMD_01));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllYoteiRiritu());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BM_YoteiRiritu> bM_YoteiRirituLst = bizDomManager.getAllYoteiRiritu();

        List<BM_YoteiRiritu> entityList = BM_YoteiRirituDetacher.detachYoteiRiritutouched(bM_YoteiRirituLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BM_YoteiRiritu entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BM_YoteiRiritu> bM_YoteiRirituLst = new ArrayList<>();
        bM_YoteiRirituLst.add(null);
        bM_YoteiRirituLst.add(null);

        List<BM_YoteiRiritu> entityList = BM_YoteiRirituDetacher.detachYoteiRiritutouched(bM_YoteiRirituLst);

        for(BM_YoteiRiritu entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
