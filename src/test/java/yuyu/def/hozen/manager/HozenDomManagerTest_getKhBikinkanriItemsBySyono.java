package yuyu.def.hozen.manager;

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
import yuyu.def.db.entity.IT_KhBikinkanri;
import yuyu.def.hozen.result.bean.KhBikinkanriItemsBySyonoBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 数理<br />
 * 保有明細情報作成<br />
 * 保有契約保全備金管理情報Beanリスト取得　証券番号指定のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKhBikinkanriItemsBySyono {

    @Inject
    private HozenDomManager hozenDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        List<KhBikinkanriItemsBySyonoBean> khBikinkanriItemsBySyonoBeanList = hozenDomManager
            .getKhBikinkanriItemsBySyono("11807111129");

        Assert.assertEquals(0, khBikinkanriItemsBySyonoBeanList.size());

        IT_KhBikinkanri khBikinkanri1 = new IT_KhBikinkanri("11807111118", BizDate.valueOf(20170115), C_BkncdKbn.GENGK,
            BizDate.valueOf(20170111), 1);
        khBikinkanri1.setBknrigikbn(C_BknrigiKbn.ADD);

        hozenDomManager.insert(khBikinkanri1);

        IT_KhBikinkanri khBikinkanri2 = new IT_KhBikinkanri("11807111141", BizDate.valueOf(20170115), C_BkncdKbn.GENGK,
            BizDate.valueOf(20170111), 1);
        khBikinkanri2.setBknrigikbn(C_BknrigiKbn.ADD);

        hozenDomManager.insert(khBikinkanri2);

        IT_KhBikinkanri khBikinkanri3 = new IT_KhBikinkanri("11807111152", BizDate.valueOf(20170116),
            C_BkncdKbn.KAIYAKU, BizDate.valueOf(20170111), 1);
        khBikinkanri3.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri3);

        IT_KhBikinkanri khBikinkanri4 = new IT_KhBikinkanri("11807111152", BizDate.valueOf(20170117),
            C_BkncdKbn.SIBOUUKETUKE, BizDate.valueOf(20170111), 1);
        khBikinkanri4.setBknrigikbn(C_BknrigiKbn.DEL);

        hozenDomManager.insert(khBikinkanri4);

        IT_KhBikinkanri khBikinkanri5 = new IT_KhBikinkanri("11807111152", BizDate.valueOf(20170118),
            C_BkncdKbn.SIBOUKARIUKETUKE, BizDate.valueOf(20170111), 1);
        khBikinkanri5.setBknrigikbn(C_BknrigiKbn.BLNK);

        hozenDomManager.insert(khBikinkanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKhBikinkanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<KhBikinkanriItemsBySyonoBean> khBikinkanriItemsBySyonoBeanList = hozenDomManager
            .getKhBikinkanriItemsBySyono("11807111130");

        Assert.assertEquals(0, khBikinkanriItemsBySyonoBeanList.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KhBikinkanriItemsBySyonoBean> khBikinkanriItemsBySyonoBeanList = hozenDomManager
            .getKhBikinkanriItemsBySyono("11807111141");

        Assert.assertEquals(1, khBikinkanriItemsBySyonoBeanList.size());
        Assert.assertEquals(BizDate.valueOf(20170115), khBikinkanriItemsBySyonoBeanList.get(0).getKessankijyunymd());
        Assert.assertEquals(C_BknrigiKbn.ADD, khBikinkanriItemsBySyonoBeanList.get(0).getBknrigikbn());
        Assert.assertEquals(C_BkncdKbn.GENGK, khBikinkanriItemsBySyonoBeanList.get(0).getBkncdkbn());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String, String> khBikinkanriItemsBySyonoBeanMap = new HashMap<String, String>();
        khBikinkanriItemsBySyonoBeanMap.put($(BizDate.valueOf(20170116), C_BknrigiKbn.DEL, C_BkncdKbn.KAIYAKU), "1");
        khBikinkanriItemsBySyonoBeanMap.put($(BizDate.valueOf(20170117), C_BknrigiKbn.DEL, C_BkncdKbn.SIBOUUKETUKE),
            "1");
        khBikinkanriItemsBySyonoBeanMap.put(
            $(BizDate.valueOf(20170118), C_BknrigiKbn.BLNK, C_BkncdKbn.SIBOUKARIUKETUKE), "1");

        List<KhBikinkanriItemsBySyonoBean> khBikinkanriItemsBySyonoBeanList = hozenDomManager
            .getKhBikinkanriItemsBySyono("11807111152");

        assertEquals(3, khBikinkanriItemsBySyonoBeanList.size());

        khBikinkanriItemsBySyonoBeanMap.remove($(khBikinkanriItemsBySyonoBeanList.get(0).getKessankijyunymd(),
            khBikinkanriItemsBySyonoBeanList.get(0).getBknrigikbn(),
            khBikinkanriItemsBySyonoBeanList.get(0).getBkncdkbn()));
        khBikinkanriItemsBySyonoBeanMap.remove($(khBikinkanriItemsBySyonoBeanList.get(1).getKessankijyunymd(),
            khBikinkanriItemsBySyonoBeanList.get(1).getBknrigikbn(),
            khBikinkanriItemsBySyonoBeanList.get(1).getBkncdkbn()));
        khBikinkanriItemsBySyonoBeanMap.remove($(khBikinkanriItemsBySyonoBeanList.get(2).getKessankijyunymd(),
            khBikinkanriItemsBySyonoBeanList.get(2).getBknrigikbn(),
            khBikinkanriItemsBySyonoBeanList.get(2).getBkncdkbn()));
        assertTrue(khBikinkanriItemsBySyonoBeanMap.isEmpty());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<KhBikinkanriItemsBySyonoBean> khBikinkanriItemsBySyonoBeanList = hozenDomManager
            .getKhBikinkanriItemsBySyono("");

        assertEquals(0, khBikinkanriItemsBySyonoBeanList.size());
    }
}
