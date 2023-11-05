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
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 年金支払<br />
 * 年金情報取込<br />
 * 年金開始後予定利率マスタエンティティリストをアンマネージド取得のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BM_NenkinYoteiRirituDetacherTest_detachNenkinYoteiRiritutouchedList {

    @Inject
    BizDomManager bizDomManager;

    static String P_NENKINSYU_01 = "NK01";
    static BizDate P_KYKFROMYMD_01 = BizDate.valueOf("20160328");
    static BizDate P_KYKTOYMD_01 = BizDate.valueOf("20160331");

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        BM_NenkinYoteiRiritu bM_NenkinYoteiRiritu1 = new BM_NenkinYoteiRiritu(P_NENKINSYU_01, C_Tuukasyu.JPY, P_KYKFROMYMD_01, P_KYKTOYMD_01);

        bizDomManager.insert(bM_NenkinYoteiRiritu1);

        BM_NenkinYoteiRiritu bM_NenkinYoteiRiritu2 = new BM_NenkinYoteiRiritu(P_NENKINSYU_01, C_Tuukasyu.AUD, P_KYKFROMYMD_01, P_KYKTOYMD_01);

        bizDomManager.insert(bM_NenkinYoteiRiritu2);

        BM_NenkinYoteiRiritu bM_NenkinYoteiRiritu3 = new BM_NenkinYoteiRiritu(P_NENKINSYU_01, C_Tuukasyu.USD, P_KYKFROMYMD_01, P_KYKTOYMD_01);

        bizDomManager.insert(bM_NenkinYoteiRiritu3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllNenkinYoteiRiritu());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BM_NenkinYoteiRiritu> bM_NenkinYoteiRirituLst = bizDomManager.getAllNenkinYoteiRiritu();

        List<BM_NenkinYoteiRiritu> entityList = BM_NenkinYoteiRirituDetacher.detachNenkinYoteiRiritutouched(bM_NenkinYoteiRirituLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BM_NenkinYoteiRiritu entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BM_NenkinYoteiRiritu> bM_NenkinYoteiRirituLst = new ArrayList<>();
        bM_NenkinYoteiRirituLst.add(null);
        bM_NenkinYoteiRirituLst.add(null);

        List<BM_NenkinYoteiRiritu> entityList = BM_NenkinYoteiRirituDetacher.detachNenkinYoteiRiritutouched(bM_NenkinYoteiRirituLst);

        for(BM_NenkinYoteiRiritu entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
