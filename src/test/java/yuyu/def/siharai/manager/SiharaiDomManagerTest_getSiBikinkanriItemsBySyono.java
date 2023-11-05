package yuyu.def.siharai.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_BkncdKbn;
import yuyu.def.classification.C_BknrigiKbn;
import yuyu.def.db.entity.JT_SiBikinkanri;
import yuyu.def.siharai.result.bean.SiBikinkanriItemsBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 保有明細情報作成<br />
 * 保保有保険金給付金備金管理情報Beanリスト取得　証券番号指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class SiharaiDomManagerTest_getSiBikinkanriItemsBySyono {

    @Inject
    private SiharaiDomManager siharaiDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        List<SiBikinkanriItemsBySyonoBean> siBikinkanriItemsBySyonoBeanList = siharaiDomManager
            .getSiBikinkanriItemsBySyono("11807111129");

        Assert.assertEquals(0, siBikinkanriItemsBySyonoBeanList.size());

        JT_SiBikinkanri siBikinkanri1 = new JT_SiBikinkanri("B001", "11807111118", BizDate.valueOf(20170112),
            C_BkncdKbn.GENGK, BizDate.valueOf(20170120), "A001");
        siBikinkanri1.setBknrigikbn(C_BknrigiKbn.BLNK);

        siharaiDomManager.insert(siBikinkanri1);

        JT_SiBikinkanri siBikinkanri2 = new JT_SiBikinkanri("B002", "11807111141", BizDate.valueOf(20170113),
            C_BkncdKbn.GENGK, BizDate.valueOf(20170120), "A001");
        siBikinkanri2.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri2);

        JT_SiBikinkanri siBikinkanri3 = new JT_SiBikinkanri("B003", "11807111152", BizDate.valueOf(20170114),
            C_BkncdKbn.KAIYAKU, BizDate.valueOf(20170120), "A001");
        siBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri3);

        JT_SiBikinkanri siBikinkanri4 = new JT_SiBikinkanri("B004", "11807111152", BizDate.valueOf(20170115),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20170120), "A001");
        siBikinkanri4.setBknrigikbn(C_BknrigiKbn.DEL);

        siharaiDomManager.insert(siBikinkanri4);

        JT_SiBikinkanri siBikinkanri5 = new JT_SiBikinkanri("B005", "11807111152", BizDate.valueOf(20170116),
            C_BkncdKbn.SIBOUKARIUKETUKE, BizDate.valueOf(20170120), "A001");
        siBikinkanri5.setBknrigikbn(C_BknrigiKbn.ADD);

        siharaiDomManager.insert(siBikinkanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        SiharaiDomManager siharaiDomManager = SWAKInjector.getInstance(SiharaiDomManager.class);

        siharaiDomManager.delete(siharaiDomManager.getAllSiBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<SiBikinkanriItemsBySyonoBean> siBikinkanriItemsBySyonoBeanList = siharaiDomManager
            .getSiBikinkanriItemsBySyono("11807111130");

        Assert.assertEquals(0, siBikinkanriItemsBySyonoBeanList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<SiBikinkanriItemsBySyonoBean> siBikinkanriItemsBySyonoBeanList = siharaiDomManager
            .getSiBikinkanriItemsBySyono("11807111141");

        Assert.assertEquals(1, siBikinkanriItemsBySyonoBeanList.size());
        Assert.assertEquals(BizDate.valueOf(20170113), siBikinkanriItemsBySyonoBeanList.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BknrigiKbn.DEL, siBikinkanriItemsBySyonoBeanList.get(0).getBknrigikbn());
        Assert.assertEquals(C_BkncdKbn.GENGK, siBikinkanriItemsBySyonoBeanList.get(0).getBkncdkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> siBikinkanriItemsBySyonoBeanMap = new HashMap<String, String>();
        siBikinkanriItemsBySyonoBeanMap.put($(BizDate.valueOf(20170114), C_BknrigiKbn.DEL, C_BkncdKbn.KAIYAKU), "1");
        siBikinkanriItemsBySyonoBeanMap.put($(BizDate.valueOf(20170115), C_BknrigiKbn.DEL, C_BkncdKbn.SIBOUUKETUKE),"1");
        siBikinkanriItemsBySyonoBeanMap.put($(BizDate.valueOf(20170116), C_BknrigiKbn.ADD, C_BkncdKbn.SIBOUKARIUKETUKE), "1");

        List<SiBikinkanriItemsBySyonoBean> siBikinkanriItemsBySyonoBeanList = siharaiDomManager
            .getSiBikinkanriItemsBySyono("11807111152");

        assertEquals(3, siBikinkanriItemsBySyonoBeanList.size());

        siBikinkanriItemsBySyonoBeanMap.remove($(siBikinkanriItemsBySyonoBeanList.get(0).getKessankijyunymd(),
            siBikinkanriItemsBySyonoBeanList.get(0).getBknrigikbn(),
            siBikinkanriItemsBySyonoBeanList.get(0).getBkncdkbn()));
        siBikinkanriItemsBySyonoBeanMap.remove($(siBikinkanriItemsBySyonoBeanList.get(1).getKessankijyunymd(),
            siBikinkanriItemsBySyonoBeanList.get(1).getBknrigikbn(),
            siBikinkanriItemsBySyonoBeanList.get(1).getBkncdkbn()));
        siBikinkanriItemsBySyonoBeanMap.remove($(siBikinkanriItemsBySyonoBeanList.get(2).getKessankijyunymd(),
            siBikinkanriItemsBySyonoBeanList.get(2).getBknrigikbn(),
            siBikinkanriItemsBySyonoBeanList.get(2).getBkncdkbn()));

        assertTrue(siBikinkanriItemsBySyonoBeanMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<SiBikinkanriItemsBySyonoBean> siBikinkanriItemsBySyonoBeanList = siharaiDomManager
            .getSiBikinkanriItemsBySyono("");

        assertEquals(0, siBikinkanriItemsBySyonoBeanList.size());
    }
}
