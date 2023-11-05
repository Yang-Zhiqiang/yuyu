package yuyu.def.sinkeiyaku.manager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SinkeiyakuDomManagerクラスの、<br />
 * getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SinkeiyakuDomManagerTest_getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn {
    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);

        HT_YuukoukknKykList yuukoukknKykList1 = sinkeiyakuDomManager.getYuukoukknKykList("791112220", BizDate.valueOf("20160412"));

        if (yuukoukknKykList1 == null) {

            List<HT_YuukoukknKykListAtukaiSya> list = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate.valueOf("20160412"), C_KeikaKbn.YOKOKUKIKAN_WEB);
            Assert.assertEquals(0, list.size());

            yuukoukknKykList1 = new HT_YuukoukknKykList("791112220", BizDate.valueOf(20160412));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya1 = yuukoukknKykList1.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya1.setKeikakbn(C_KeikaKbn.YOKOKUKIKAN_WEB);
            yuukoukknKykListAtukaiSya1.setRenno(1);
            yuukoukknKykListAtukaiSya1.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya1.setOyadrtennm("代理店1");

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya3 = yuukoukknKykList1.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya3.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA);
            yuukoukknKykListAtukaiSya3.setRenno(1);
            yuukoukknKykListAtukaiSya3.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya3.setOyadrtennm("代理店1");

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya4 = yuukoukknKykList1.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya4.setKeikakbn(C_KeikaKbn.YOKOKUKIKAN_WEB);
            yuukoukknKykListAtukaiSya4.setRenno(2);
            yuukoukknKykListAtukaiSya4.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya4.setOyadrtennm("代理店1");

            sinkeiyakuDomManager.insert(yuukoukknKykList1);
        }

        HT_YuukoukknKykList yuukoukknKykList2 = sinkeiyakuDomManager.getYuukoukknKykList("791112220", BizDate.valueOf("20150708"));
        if (yuukoukknKykList2 == null) {

            yuukoukknKykList2 = new HT_YuukoukknKykList("791112220", BizDate.valueOf("20150708"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya2 = yuukoukknKykList2.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya2.setKeikakbn(C_KeikaKbn.YOKOKUKIKAN_WEB);
            yuukoukknKykListAtukaiSya2.setRenno(1);
            yuukoukknKykListAtukaiSya2.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya2.setOyadrtennm("代理店1");

            sinkeiyakuDomManager.insert(yuukoukknKykList2);
        }


        HT_YuukoukknKykList yuukoukknKykList3 = sinkeiyakuDomManager.getYuukoukknKykList("791112238", BizDate.valueOf("20160411"));
        if (yuukoukknKykList3 == null) {

            yuukoukknKykList3 = new HT_YuukoukknKykList("791112238", BizDate.valueOf("20160411"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya5 = yuukoukknKykList3.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya5.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA_WEB);
            yuukoukknKykListAtukaiSya5.setRenno(1);
            yuukoukknKykListAtukaiSya5.setOyadrtencd("5200003");
            yuukoukknKykListAtukaiSya5.setOyadrtennm("代理店2");

            sinkeiyakuDomManager.insert(yuukoukknKykList3);

        }

        HT_YuukoukknKykList yuukoukknKykList4 = sinkeiyakuDomManager.getYuukoukknKykList("791112246", BizDate.valueOf("20160411"));
        if (yuukoukknKykList4 == null) {

            yuukoukknKykList4 = new HT_YuukoukknKykList("791112246", BizDate.valueOf("20160411"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya6 = yuukoukknKykList4.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya6.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA_WEB);
            yuukoukknKykListAtukaiSya6.setRenno(1);
            yuukoukknKykListAtukaiSya6.setOyadrtencd("5200001");
            yuukoukknKykListAtukaiSya6.setOyadrtennm("代理店1");

            sinkeiyakuDomManager.insert(yuukoukknKykList4);
        }

        HT_YuukoukknKykList yuukoukknKykList5 = sinkeiyakuDomManager.getYuukoukknKykList("791112253", BizDate.valueOf("20160411"));
        if (yuukoukknKykList5 == null) {

            yuukoukknKykList5 = new HT_YuukoukknKykList("791112253", BizDate.valueOf("20160411"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya7 = yuukoukknKykList5.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya7.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA_WEB);
            yuukoukknKykListAtukaiSya7.setRenno(1);
            yuukoukknKykListAtukaiSya7.setOyadrtencd("5200001");
            yuukoukknKykListAtukaiSya7.setOyadrtennm("代理店1");

            sinkeiyakuDomManager.insert(yuukoukknKykList5);
        }

        HT_YuukoukknKykList yuukoukknKykList6 = sinkeiyakuDomManager.getYuukoukknKykList("791112261", BizDate.valueOf("20160411"));
        if (yuukoukknKykList6 == null) {

            yuukoukknKykList6 = new HT_YuukoukknKykList("791112261", BizDate.valueOf("20160411"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya8 = yuukoukknKykList6.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya8.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA_WEB);
            yuukoukknKykListAtukaiSya8.setRenno(1);
            yuukoukknKykListAtukaiSya8.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya8.setOyadrtennm("代理店2");

            sinkeiyakuDomManager.insert(yuukoukknKykList6);
        }

        HT_YuukoukknKykList yuukoukknKykList7 = sinkeiyakuDomManager.getYuukoukknKykList("791112279", BizDate.valueOf("20160411"));
        if (yuukoukknKykList7 == null) {

            yuukoukknKykList7 = new HT_YuukoukknKykList("791112279", BizDate.valueOf("20160411"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya9 = yuukoukknKykList7.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya9.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA_WEB);
            yuukoukknKykListAtukaiSya9.setRenno(1);
            yuukoukknKykListAtukaiSya9.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya9.setOyadrtennm("代理店1");

            sinkeiyakuDomManager.insert(yuukoukknKykList7);
        }

        HT_YuukoukknKykList yuukoukknKykList8 = sinkeiyakuDomManager.getYuukoukknKykList("791112287", BizDate.valueOf("20160411"));
        if (yuukoukknKykList8 == null) {

            yuukoukknKykList8 = new HT_YuukoukknKykList("791112287", BizDate.valueOf("20160411"));

            HT_YuukoukknKykListAtukaiSya yuukoukknKykListAtukaiSya10 = yuukoukknKykList8.createYuukoukknKykListAtukaiSya();
            yuukoukknKykListAtukaiSya10.setKeikakbn(C_KeikaKbn.YKKIKANTYOUKA_WEB);
            yuukoukknKykListAtukaiSya10.setRenno(1);
            yuukoukknKykListAtukaiSya10.setOyadrtencd("5200002");
            yuukoukknKykListAtukaiSya10.setOyadrtennm("代理店2");

            sinkeiyakuDomManager.insert(yuukoukknKykList8);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        SinkeiyakuDomManager sinkeiyakuDomManager = SWAKInjector.getInstance(SinkeiyakuDomManager.class);
        sinkeiyakuDomManager.delete(sinkeiyakuDomManager.getAllYuukoukknKykList());
    }

    @Test
    @TestOrder(20)
    public void noResult1() {
        List<HT_YuukoukknKykListAtukaiSya> list = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate.valueOf("20160410"), C_KeikaKbn.YOKOKUKIKAN_WEB);
        Assert.assertEquals(0, list.size());
    }

    @Test
    @TestOrder(30)
    public void normal1() {
        List<HT_YuukoukknKykListAtukaiSya> list = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate.valueOf("20160412"), C_KeikaKbn.YOKOKUKIKAN_WEB);
        Assert.assertEquals(1, list.size());

        Assert.assertEquals("791112220", list.get(0).getMosno());
        Assert.assertEquals(1, list.get(0).getRenno().intValue());
        Assert.assertEquals(C_KeikaKbn.YOKOKUKIKAN_WEB, list.get(0).getKeikakbn());
        Assert.assertEquals("5200002", list.get(0).getOyadrtencd());
        Assert.assertEquals("代理店1", list.get(0).getOyadrtennm());
    }

    @Test
    @TestOrder(40)
    public void normal2() {
        Map<String,String> yuukoukknKykListAtukaiSyaMap = new HashMap<String, String>();
        yuukoukknKykListAtukaiSyaMap.put($("791112279",BizDate.valueOf("20160411"),C_KeikaKbn.YKKIKANTYOUKA_WEB,Integer.valueOf(1),"5200002","代理店1"),"1");
        yuukoukknKykListAtukaiSyaMap.put($("791112287",BizDate.valueOf("20160411"),C_KeikaKbn.YKKIKANTYOUKA_WEB,Integer.valueOf(1),"5200002","代理店2"),"1");

        List<HT_YuukoukknKykListAtukaiSya> list = sinkeiyakuDomManager.getYuukoukknKykListAtukaiSyasByTyouhyouymdKeikakbn(BizDate.valueOf("20160411"), C_KeikaKbn.YKKIKANTYOUKA_WEB);
        Assert.assertEquals(4, list.size());

        Assert.assertEquals("791112253", list.get(0).getMosno());
        Assert.assertEquals(BizDate.valueOf("20160411"), list.get(0).getTyouhyouymd());
        Assert.assertEquals(C_KeikaKbn.YKKIKANTYOUKA_WEB, list.get(0).getKeikakbn());
        Assert.assertEquals(Integer.valueOf(1), list.get(0).getRenno());
        Assert.assertEquals("5200001", list.get(0).getOyadrtencd());
        Assert.assertEquals("代理店1", list.get(0).getOyadrtennm());

        assertTrue(yuukoukknKykListAtukaiSyaMap.containsKey($(list.get(1).getMosno(),list.get(1).getTyouhyouymd(),list.get(1).getKeikakbn(),list.get(1).getRenno(),list.get(1).getOyadrtencd(),list.get(1).getOyadrtennm())));
        yuukoukknKykListAtukaiSyaMap.remove($(list.get(1).getMosno(),list.get(1).getTyouhyouymd(),list.get(1).getKeikakbn(),list.get(1).getRenno(),list.get(1).getOyadrtencd(),list.get(1).getOyadrtennm()));
        assertTrue(yuukoukknKykListAtukaiSyaMap.containsKey($(list.get(2).getMosno(),list.get(2).getTyouhyouymd(),list.get(2).getKeikakbn(),list.get(2).getRenno(),list.get(2).getOyadrtencd(),list.get(2).getOyadrtennm())));
        yuukoukknKykListAtukaiSyaMap.remove($(list.get(2).getMosno(),list.get(2).getTyouhyouymd(),list.get(2).getKeikakbn(),list.get(2).getRenno(),list.get(2).getOyadrtencd(),list.get(2).getOyadrtennm()));

        Assert.assertEquals("791112238", list.get(3).getMosno());
        Assert.assertEquals(BizDate.valueOf("20160411"), list.get(3).getTyouhyouymd());
        Assert.assertEquals(C_KeikaKbn.YKKIKANTYOUKA_WEB, list.get(3).getKeikakbn());
        Assert.assertEquals(Integer.valueOf(1), list.get(3).getRenno());
        Assert.assertEquals("5200003", list.get(3).getOyadrtencd());
        Assert.assertEquals("代理店2", list.get(3).getOyadrtennm());
    }
}