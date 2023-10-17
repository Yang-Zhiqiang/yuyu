package yuyu.def.biz.detacher;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金給付金支払<br />
 * 保険金給付金備金情報抽出<br />
 * 業務用工程情報テーブルエンティティデタッチ(業務用工程情報テーブルエンティティリスト)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BT_GyoumuKouteiInfoDetacherTest_detachGyoumuKouteiInfotouchedList {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager .class);

        bizDomManager.insert(new BT_GyoumuKouteiInfo("KO111"));
        bizDomManager.insert(new BT_GyoumuKouteiInfo("KO222"));
        bizDomManager.insert(new BT_GyoumuKouteiInfo("KO333"));
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        bizDomManager.delete(bizDomManager.getAllGyoumuKouteiInfo());
    }

    @Test
    @TestOrder(10)
    public void testDetach1() {

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = bizDomManager.getAllGyoumuKouteiInfo();

        List<BT_GyoumuKouteiInfo> entityLst = BT_GyoumuKouteiInfoDetacher.detachGyoumuKouteiInfotouched(bT_GyoumuKouteiInfoLst);

        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);

        for(BT_GyoumuKouteiInfo entity : entityLst) {

            Assert.assertFalse(em.getEntityManager().contains(entity));
        }
    }

    @Test
    @TestOrder(20)
    public void testDetach2() {

        List<BT_GyoumuKouteiInfo> bT_GyoumuKouteiInfoLst = new ArrayList<>();
        bT_GyoumuKouteiInfoLst.add(null);
        bT_GyoumuKouteiInfoLst.add(null);

        List<BT_GyoumuKouteiInfo> entityLst = BT_GyoumuKouteiInfoDetacher.detachGyoumuKouteiInfotouched(bT_GyoumuKouteiInfoLst);

        for(BT_GyoumuKouteiInfo entity : entityLst) {

            Assert.assertNull(entity);
        }
    }
}
