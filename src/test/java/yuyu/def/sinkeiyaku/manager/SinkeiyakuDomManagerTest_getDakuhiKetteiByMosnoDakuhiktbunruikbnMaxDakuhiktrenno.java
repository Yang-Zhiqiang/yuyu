package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.db.entity.HT_DakuhiKettei;
import yuyu.def.db.entity.HT_SyoriCTL;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 新契約選択情報作成<br />
 * 諾否決定テーブルエンティティ取得　諾否決定連番(最大)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_MOSNO_01 = "791112220";
    static String P_MOSNO_02 = "791112238";
    static String P_MOSNO_03 = "791112246";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.
            getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(P_MOSNO_01, C_DakuhiktbunruiKbn.BLNK);

        Assert.assertEquals(null, hT_DakuhiKettei);

        HT_SyoriCTL syoriCTL1 = new HT_SyoriCTL(P_MOSNO_01);

        HT_DakuhiKettei dakuhiKettei1 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei1.setDakuhiktrenno(new Integer(12));
        dakuhiKettei1.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.BLNK);

        HT_DakuhiKettei dakuhiKettei2 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei2.setDakuhiktrenno(new Integer(13));
        dakuhiKettei2.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.BLNK);

        HT_DakuhiKettei dakuhiKettei3 = syoriCTL1.createDakuhiKettei();
        dakuhiKettei3.setDakuhiktrenno(new Integer(15));
        dakuhiKettei3.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL1);

        HT_SyoriCTL syoriCTL2 = new HT_SyoriCTL(P_MOSNO_02);

        HT_DakuhiKettei dakuhiKettei4 = syoriCTL2.createDakuhiKettei();
        dakuhiKettei4.setDakuhiktrenno(new Integer(15));
        dakuhiKettei4.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.DAKUHIKETTEI);

        sinkeiyakuDomManager.insert(syoriCTL2);

        HT_SyoriCTL syoriCTL3 = new HT_SyoriCTL(P_MOSNO_03);

        HT_DakuhiKettei dakuhiKettei5 = syoriCTL3.createDakuhiKettei();
        dakuhiKettei5.setDakuhiktrenno(new Integer(16));
        dakuhiKettei5.setDakuhiktbunruikbn(C_DakuhiktbunruiKbn.BLNK);

        sinkeiyakuDomManager.insert(syoriCTL3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllSyoriCTL());
    }

    @Test
    @TestOrder(10)
    public void noResult() {

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.
            getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(P_MOSNO_02, C_DakuhiktbunruiKbn.BLNK);

        Assert.assertEquals(null, hT_DakuhiKettei);
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.
            getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno(P_MOSNO_01, C_DakuhiktbunruiKbn.BLNK);


        Assert.assertEquals(P_MOSNO_01, hT_DakuhiKettei.getMosno());
        Assert.assertEquals(new Integer(15), hT_DakuhiKettei.getDakuhiktrenno());
        Assert.assertEquals(C_DakuhiktbunruiKbn.BLNK, hT_DakuhiKettei.getDakuhiktbunruikbn());
    }

    @Test
    @TestOrder(30)
    public void blankCondition() {

        HT_DakuhiKettei hT_DakuhiKettei = sinkeiyakuDomManager.
            getDakuhiKetteiByMosnoDakuhiktbunruikbnMaxDakuhiktrenno("", C_DakuhiktbunruiKbn.BLNK);

        Assert.assertEquals(null, hT_DakuhiKettei);
    }
}
