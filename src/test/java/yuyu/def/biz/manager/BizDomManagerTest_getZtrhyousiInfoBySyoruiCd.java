package yuyu.def.biz.manager;


import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.result.bean.ZtrhyousiInfoBySyoruiCdBean;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.BM_TorikomiSyoruiHukaInfo;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 保険金<br />
 * AKS連動ファイル作成<br />
 * 取込用表紙情報取得　書類コードのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getZtrhyousiInfoBySyoruiCd {

    @Inject
    BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        ZtrhyousiInfoBySyoruiCdBean ztrhyousiInfoBySyoruiCdBean = bizDomManager.getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);
        Assert.assertNull(ztrhyousiInfoBySyoruiCdBean);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo1 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_HYOUSI);

        bizDomManager.insert(torikomiSyoruiHukaInfo1);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo2 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.WF_QRSEAL);

        bizDomManager.insert(torikomiSyoruiHukaInfo2);

        BM_TorikomiSyoruiHukaInfo torikomiSyoruiHukaInfo3 = new BM_TorikomiSyoruiHukaInfo(C_SyoruiCdKbn.USERITIRANHYOU);

        bizDomManager.insert(torikomiSyoruiHukaInfo3);

        AM_SyoruiZokusei syoruiZokusei1 = new AM_SyoruiZokusei(C_SyoruiCdKbn.WF_HYOUSI);

        baseDomManager.insert(syoruiZokusei1);

        AM_SyoruiZokusei syoruiZokusei2 = new AM_SyoruiZokusei(C_SyoruiCdKbn.WF_QRSEAL);

        baseDomManager.insert(syoruiZokusei2);

        AM_SyoruiZokusei syoruiZokusei3 = new AM_SyoruiZokusei(C_SyoruiCdKbn.BLNK);

        baseDomManager.insert(syoruiZokusei3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        bizDomManager.delete(bizDomManager.getAllTorikomiSyoruiHukaInfo());
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        ZtrhyousiInfoBySyoruiCdBean ztrhyousiInfoBySyoruiCdBean = bizDomManager.getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn.HK_SB_HOKEN_SKS);

        Assert.assertNull(ztrhyousiInfoBySyoruiCdBean);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        ZtrhyousiInfoBySyoruiCdBean ztrhyousiInfoBySyoruiCdBean = bizDomManager.getZtrhyousiInfoBySyoruiCd(C_SyoruiCdKbn.WF_HYOUSI);

        Assert.assertEquals(C_SyoruiCdKbn.WF_HYOUSI, ztrhyousiInfoBySyoruiCdBean.getAM_SyoruiZokusei().getSyoruiCd());
        Assert.assertEquals(C_SyoruiCdKbn.WF_HYOUSI, ztrhyousiInfoBySyoruiCdBean.getBM_TorikomiSyoruiHukaInfo().getSyoruiCd());
    }
}