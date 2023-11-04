package yuyu.def.biz.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_BuntanInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 業務共通<br />
 * 分担情報取得<br />
 * 分担情報テーブルエンティティデタッチ(分担情報テーブルエンティティリスト)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BT_BuntanInfoDetacherTest_detachBuntanInfotouched {

    @Inject
    BizDomManager bizDomManager;

    static String P_DRTENCD_01 = "DRTCD01";
    static String P_DRTENCD_02 = "DRTCD02";
    static String P_DRTENCD_03 = "DRTCD03";
    static String P_DAIRITENSYOUHINCD = "SCD01";
    static String P_TESUURYOUBUNTANAITEDRTENCD = "TSRCD01";
    static BizDateYM P_TESUURYOUBUNTANKAISINENGETU = BizDateYM.valueOf(201603);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.insert(new BT_BuntanInfo(P_DRTENCD_01, P_DAIRITENSYOUHINCD, P_TESUURYOUBUNTANAITEDRTENCD,
                P_TESUURYOUBUNTANKAISINENGETU));

        bizDomManager.insert(new BT_BuntanInfo(P_DRTENCD_02, P_DAIRITENSYOUHINCD, P_TESUURYOUBUNTANAITEDRTENCD,
                P_TESUURYOUBUNTANKAISINENGETU));

        bizDomManager.insert(new BT_BuntanInfo(P_DRTENCD_03, P_DAIRITENSYOUHINCD, P_TESUURYOUBUNTANAITEDRTENCD,
                P_TESUURYOUBUNTANKAISINENGETU));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.delete(bizDomManager.getAllBuntanInfo());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BT_BuntanInfo> buntanInfos = bizDomManager.getAllBuntanInfo();

        List<BT_BuntanInfo> entityList = BT_BuntanInfoDetacher.detachBuntanInfotouched(buntanInfos);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BT_BuntanInfo entity : entityList) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BT_BuntanInfo> buntanInfos = new ArrayList<>();
        buntanInfos.add(null);
        buntanInfos.add(null);

        List<BT_BuntanInfo> entityList = BT_BuntanInfoDetacher.detachBuntanInfotouched(buntanInfos);

        for(BT_BuntanInfo entity : entityList) {

            Assert.assertNull(entity);
        }
    }
}
