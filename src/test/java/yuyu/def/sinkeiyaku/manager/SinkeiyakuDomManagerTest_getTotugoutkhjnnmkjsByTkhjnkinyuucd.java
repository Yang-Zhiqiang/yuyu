package yuyu.def.sinkeiyaku.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 新契約<br />
 * 突合用特定関係法人名（漢字）リスト取得　特定関係法人金融機関コードのテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getTotugoutkhjnnmkjsByTkhjnkinyuucd {

    @Inject
    SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        List<String> totugoutkhjnnmkjList = sinkeiyakuDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd("NO01");
        Assert.assertEquals(totugoutkhjnnmkjList.size(), 0);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou1 = new HM_TokuteiKankeiHjnNmTotugou("NO01", BizNumber.ONE, 1);
        tokuteiKankeiHjnNmTotugou1.setTotugoutkhjnnmkj("突合用特定関係法人名01");
        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou1);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou2 = new HM_TokuteiKankeiHjnNmTotugou("NO02", BizNumber.ONE, 1);
        tokuteiKankeiHjnNmTotugou2.setTotugoutkhjnnmkj("突合用特定関係法人名02");
        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou2);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou3 = new HM_TokuteiKankeiHjnNmTotugou("NO02", BizNumber.ONE, 2);
        tokuteiKankeiHjnNmTotugou3.setTotugoutkhjnnmkj("突合用特定関係法人名03");
        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou3);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou4 = new HM_TokuteiKankeiHjnNmTotugou("NO02", BizNumber.ONE, 3);
        tokuteiKankeiHjnNmTotugou4.setTotugoutkhjnnmkj("突合用特定関係法人名04");
        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou4);

        HM_TokuteiKankeiHjnNmTotugou tokuteiKankeiHjnNmTotugou5 = new HM_TokuteiKankeiHjnNmTotugou("NO02", BizNumber.ONE, 4);
        tokuteiKankeiHjnNmTotugou5.setTotugoutkhjnnmkj("突合用特定関係法人名05");
        sinkeiyakuDomManager.insert(tokuteiKankeiHjnNmTotugou5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllTokuteiKankeiHjnNmTotugou());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<String> totugoutkhjnnmkjList = sinkeiyakuDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd("NO99");
        Assert.assertEquals(totugoutkhjnnmkjList.size(), 0);
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<String> totugoutkhjnnmkjList = sinkeiyakuDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd("NO01");
        Assert.assertEquals(totugoutkhjnnmkjList.size(), 1);
        Assert.assertEquals(totugoutkhjnnmkjList.get(0), "突合用特定関係法人名01");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        HashMap<String,String> datamap = new HashMap<String,String>();
        datamap.put($("突合用特定関係法人名02"), "1");
        datamap.put($("突合用特定関係法人名03"), "1");
        datamap.put($("突合用特定関係法人名04"), "1");
        datamap.put($("突合用特定関係法人名05"), "1");

        List<String> totugoutkhjnnmkjList = sinkeiyakuDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd("NO02");

        datamap.remove($(totugoutkhjnnmkjList.get(0)));
        datamap.remove($(totugoutkhjnnmkjList.get(1)));
        datamap.remove($(totugoutkhjnnmkjList.get(2)));
        datamap.remove($(totugoutkhjnnmkjList.get(3)));

        Assert.assertEquals(totugoutkhjnnmkjList.size(), 4);
        Assert.assertTrue(datamap.isEmpty());
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void normal3() {

        List<String> totugoutkhjnnmkjList = sinkeiyakuDomManager.getTotugoutkhjnnmkjsByTkhjnkinyuucd("");
        Assert.assertEquals(totugoutkhjnnmkjList.size(), 0);
    }
}
