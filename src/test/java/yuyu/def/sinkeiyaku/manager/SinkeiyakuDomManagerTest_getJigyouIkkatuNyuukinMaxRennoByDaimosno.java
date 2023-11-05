package yuyu.def.sinkeiyaku.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HT_JigyouIkkatu;
import yuyu.def.db.entity.HT_JigyouIkkatuNyuukin;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 入金入力<br />
 * 事業一括入金TBL最大連番取得（代表申込番号）のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getJigyouIkkatuNyuukinMaxRennoByDaimosno {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    static String P_DAIMOSNO_001 = "10000000060";
    static String P_DAIMOSNO_002 = "10000000070";

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        Integer maxDaimosno = sinkeiyakuDomManager.getJigyouIkkatuNyuukinMaxRennoByDaimosno(P_DAIMOSNO_001);
        Assert.assertEquals(null, maxDaimosno);

        HT_JigyouIkkatu jigyouIkkatu = sinkeiyakuDomManager.getJigyouIkkatu(P_DAIMOSNO_001);
        if (jigyouIkkatu == null) {
            jigyouIkkatu = new HT_JigyouIkkatu(P_DAIMOSNO_001);

            HT_JigyouIkkatuNyuukin jigyouIkkatuNyuukin1 = jigyouIkkatu.createJigyouIkkatuNyuukin();
            jigyouIkkatuNyuukin1.setRenno(1);

            HT_JigyouIkkatuNyuukin jigyouIkkatuNyuukin2 = jigyouIkkatu.createJigyouIkkatuNyuukin();
            jigyouIkkatuNyuukin2.setRenno(2);

            HT_JigyouIkkatuNyuukin jigyouIkkatuNyuukin3 = jigyouIkkatu.createJigyouIkkatuNyuukin();
            jigyouIkkatuNyuukin3.setRenno(3);

            sinkeiyakuDomManager.insert(jigyouIkkatu);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllJigyouIkkatu());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        Integer maxDaimosno = sinkeiyakuDomManager.getJigyouIkkatuNyuukinMaxRennoByDaimosno(P_DAIMOSNO_002);

        Assert.assertEquals(null, maxDaimosno);
    }

    @Test
    @TestOrder(20)
    public void blankCondition() {

        Integer maxDaimosno = sinkeiyakuDomManager.getJigyouIkkatuNyuukinMaxRennoByDaimosno("");

        Assert.assertEquals(null, maxDaimosno);
    }

    @Test
    @TestOrder(30)
    public void normal1() {

        Integer maxDaimosno = sinkeiyakuDomManager.getJigyouIkkatuNyuukinMaxRennoByDaimosno(P_DAIMOSNO_001);

        Assert.assertEquals(3, maxDaimosno.intValue());
    }
}
