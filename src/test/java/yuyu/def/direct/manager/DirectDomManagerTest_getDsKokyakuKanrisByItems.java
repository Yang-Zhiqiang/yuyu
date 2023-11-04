package yuyu.def.direct.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.direct.result.bean.DsKokyakuKanrisByItemsBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKokyakuKanrisByItems() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuKanrisByItems {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        deleteTestSubData();

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳｳ", "李李",
                BizDate.valueOf(20160702), "1234002");
        Assert.assertEquals(0, beanLst.size());

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("0114");
        dsKokyakuKanri1.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri1.setDskokyakunmkj("高李高");
        dsKokyakuKanri1.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri1.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111255");

        MT_DsHonninKakuninCd dsHonninKakuninCd1 = dsKokyakuKanri1.createDsHonninKakuninCd();

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("0113");
        dsKokyakuKanri2.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri2.setDskokyakunmkj("高李高");
        dsKokyakuKanri2.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri2.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri2.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111255");

        MT_DsLoginKanri dsLoginKanri2 = dsKokyakuKanri2.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("0112");
        dsKokyakuKanri3.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri3.setDskokyakunmkj("高李高");
        dsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri3.setDskokyakuyno("1234002");

        MT_DsHonninKakuninCd dsHonninKakuninCd2 = dsKokyakuKanri3.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri1 = dsKokyakuKanri3.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("0010");
        dsKokyakuKanri4.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri4.setDskokyakunmkj("高李高");
        dsKokyakuKanri4.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri4.setDskokyakuyno("1234001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri4.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("11807111211");

        MT_DsHonninKakuninCd dsHonninKakuninCd3 = dsKokyakuKanri4.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri3 = dsKokyakuKanri4.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("0009");
        dsKokyakuKanri5.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri5.setDskokyakunmkj("高李高");
        dsKokyakuKanri5.setDskokyakuseiymd(BizDate.valueOf(20150702));
        dsKokyakuKanri5.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku4 = dsKokyakuKanri5.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku4.setSyono("11807111200");

        MT_DsHonninKakuninCd dsHonninKakuninCd4 = dsKokyakuKanri5.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri4 = dsKokyakuKanri5.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri5);

        MT_DsKokyakuKanri dsKokyakuKanri6 = new MT_DsKokyakuKanri("0008");
        dsKokyakuKanri6.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri6.setDskokyakunmkj("理利莉");
        dsKokyakuKanri6.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri6.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku5 = dsKokyakuKanri6.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku5.setSyono("11807111196");

        MT_DsHonninKakuninCd dsHonninKakuninCd5 = dsKokyakuKanri6.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri5 = dsKokyakuKanri6.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri6);

        MT_DsKokyakuKanri dsKokyakuKanri7 = new MT_DsKokyakuKanri("0007");
        dsKokyakuKanri7.setDskokyakunmkn("ﾘｱｶﾞ");
        dsKokyakuKanri7.setDskokyakunmkj("高李高");
        dsKokyakuKanri7.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri7.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku6 = dsKokyakuKanri7.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku6.setSyono("11807111185");

        MT_DsHonninKakuninCd dsHonninKakuninCd6 = dsKokyakuKanri7.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri6 = dsKokyakuKanri7.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri7);

        MT_DsKokyakuKanri dsKokyakuKanri8 = new MT_DsKokyakuKanri("0006");
        dsKokyakuKanri8.setDskokyakunmkn("ｺｺｺ");
        dsKokyakuKanri8.setDskokyakunmkj("高高高");
        dsKokyakuKanri8.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri8.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku7 = dsKokyakuKanri8.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku7.setSyono("11807111196");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku8 = dsKokyakuKanri8.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku8.setSyono("11807111185");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku9 = dsKokyakuKanri8.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku9.setSyono("11807111174");

        MT_DsHonninKakuninCd dsHonninKakuninCd7 = dsKokyakuKanri8.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri7 = dsKokyakuKanri8.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri8);

        MT_DsKokyakuKanri dsKokyakuKanri9 = new MT_DsKokyakuKanri("0005");
        dsKokyakuKanri9.setDskokyakunmkn("ｳｳｳ");
        dsKokyakuKanri9.setDskokyakunmkj("李李李");
        dsKokyakuKanri9.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri9.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku10 = dsKokyakuKanri9.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku10.setSyono("11807111163");

        MT_DsHonninKakuninCd dsHonninKakuninCd8 = dsKokyakuKanri9.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri8 = dsKokyakuKanri9.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri9);

        MT_DsKokyakuKanri dsKokyakuKanri10 = new MT_DsKokyakuKanri("0004");
        dsKokyakuKanri10.setDskokyakunmkn("ｺ");
        dsKokyakuKanri10.setDskokyakunmkj("高");
        dsKokyakuKanri10.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri10.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku11 = dsKokyakuKanri10.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku11.setSyono("11807111130");

        MT_DsHonninKakuninCd dsHonninKakuninCd9 = dsKokyakuKanri10.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri9 = dsKokyakuKanri10.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri10);

        MT_DsKokyakuKanri dsKokyakuKanri11 = new MT_DsKokyakuKanri("0003");
        dsKokyakuKanri11.setDskokyakunmkn("ｳ");
        dsKokyakuKanri11.setDskokyakunmkj("李");
        dsKokyakuKanri11.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri11.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku12 = dsKokyakuKanri11.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku12.setSyono("11807111130");

        MT_DsHonninKakuninCd dsHonninKakuninCd10 = dsKokyakuKanri11.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri10 = dsKokyakuKanri11.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri11);

        MT_DsKokyakuKanri dsKokyakuKanri12 = new MT_DsKokyakuKanri("0002");
        dsKokyakuKanri12.setDskokyakunmkn("ｳｺｳ");
        dsKokyakuKanri12.setDskokyakunmkj("李高李");
        dsKokyakuKanri12.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri12.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku13 = dsKokyakuKanri12.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku13.setSyono("11807111130");

        MT_DsHonninKakuninCd dsHonninKakuninCd11 = dsKokyakuKanri12.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri11 = dsKokyakuKanri12.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri12);

        MT_DsKokyakuKanri dsKokyakuKanri13 = new MT_DsKokyakuKanri("0001");
        dsKokyakuKanri13.setDskokyakunmkn("ｺｳｺ");
        dsKokyakuKanri13.setDskokyakunmkj("高李高");
        dsKokyakuKanri13.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri13.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku14 = dsKokyakuKanri13.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku14.setSyono("11807111129");

        MT_DsHonninKakuninCd dsHonninKakuninCd12 = dsKokyakuKanri13.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri12 = dsKokyakuKanri13.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri13);

        MT_DsKokyakuKanri dsKokyakuKanri14 = new MT_DsKokyakuKanri("0000");
        dsKokyakuKanri14.setDskokyakunmkn("ﾜｱｴ");
        dsKokyakuKanri14.setDskokyakunmkj("尾迂亜");
        dsKokyakuKanri14.setDskokyakuseiymd(BizDate.valueOf(20160702));
        dsKokyakuKanri14.setDskokyakuyno("1234002");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku15 = dsKokyakuKanri14.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku15.setSyono("11807111118");

        MT_DsHonninKakuninCd dsHonninKakuninCd13 = dsKokyakuKanri14.createDsHonninKakuninCd();

        MT_DsLoginKanri dsLoginKanri13 = dsKokyakuKanri14.createDsLoginKanri();

        directDomManager.insert(dsKokyakuKanri14);

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("イイ", "緒緒", BizDate.valueOf(20110101), "1234111");
        Assert.assertEquals(0, beanLst.size());

    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳｳ", "李李", BizDate.valueOf(20160702), "1234002");
        Assert.assertEquals(1, beanLst.size());

        Assert.assertEquals("0005", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0005", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0005", beanLst.get(0).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0005", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());


    }
    @Test
    @TestOrder(30)
    @Transactional
    public void normal2() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｱ", "迂", BizDate.valueOf(20160702), "1234002");
        Assert.assertEquals(1, beanLst.size());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111118", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());


    }
    @Test
    @TestOrder(40)
    @Transactional
    public void normal3() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳ", "李", BizDate.valueOf(20160702), "1234002");
        Assert.assertEquals(4, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());

    }

    @Test
    @TestOrder(50)
    public void blankCondition1() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("", "李", BizDate.valueOf(20160702), "1234002");
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111185", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
    }
    @Test
    @TestOrder(60)
    public void blankCondition2() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳ", "", BizDate.valueOf(20160702), "1234002");
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111196", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
    }
    @Test
    @TestOrder(70)
    public void blankCondition3() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳ", "李", BizDate.valueOf(20160702), "");
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111211", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
    }
    @Test
    @TestOrder(80)
    public void nullCondition1() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems(null, "李", BizDate.valueOf(20160702),"1234002");
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0007", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111185", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
    }
    @Test
    @TestOrder(90)
    public void nullCondition2() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳ",null,BizDate.valueOf(20160702),"1234002");
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0008", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111196", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());

    }
    @Test
    @TestOrder(100)
    public void nullCondition3() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳ","李",null,"1234002");
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0009", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0009", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0009", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0009", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111200", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
    }
    @Test
    @TestOrder(110)
    public void nullCondition4() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems("ｳ","李",BizDate.valueOf(20160702),null);
        Assert.assertEquals(5, beanLst.size());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0001", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0010", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111211", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
    }
    @Test
    @TestOrder(120)
    public void nullCondition5() {

        List<DsKokyakuKanrisByItemsBean> beanLst = directDomManager.getDsKokyakuKanrisByItems(null,null,null,null);
        Assert.assertEquals(13, beanLst.size());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0001", beanLst.get(1).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(2).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(3).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0004", beanLst.get(4).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(5).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0006", beanLst.get(6).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0006", beanLst.get(7).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0006", beanLst.get(8).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0007", beanLst.get(9).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0008", beanLst.get(10).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0009", beanLst.get(11).getMT_DsKokyakuKanri().getDskokno());
        Assert.assertEquals("0010", beanLst.get(12).getMT_DsKokyakuKanri().getDskokno());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0001", beanLst.get(1).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0002", beanLst.get(2).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0003", beanLst.get(3).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0004", beanLst.get(4).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0005", beanLst.get(5).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0006", beanLst.get(6).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0006", beanLst.get(7).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0006", beanLst.get(8).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0007", beanLst.get(9).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0008", beanLst.get(10).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0009", beanLst.get(11).getMT_DsHonninKakuninCd().getDskokno());
        Assert.assertEquals("0010", beanLst.get(12).getMT_DsHonninKakuninCd().getDskokno());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0001", beanLst.get(1).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0002", beanLst.get(2).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0003", beanLst.get(3).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0004", beanLst.get(4).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0005", beanLst.get(5).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0006", beanLst.get(6).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0006", beanLst.get(7).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0006", beanLst.get(8).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0007", beanLst.get(9).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0008", beanLst.get(10).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0009", beanLst.get(11).getMT_DsLoginKanri().getDskokno());
        Assert.assertEquals("0010", beanLst.get(12).getMT_DsLoginKanri().getDskokno());

        Assert.assertEquals("0000", beanLst.get(0).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111118", beanLst.get(0).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0001", beanLst.get(1).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111129", beanLst.get(1).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0002", beanLst.get(2).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(2).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0003", beanLst.get(3).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(3).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0004", beanLst.get(4).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111130", beanLst.get(4).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0005", beanLst.get(5).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111163", beanLst.get(5).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0006", beanLst.get(6).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111174", beanLst.get(6).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0006", beanLst.get(7).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111185", beanLst.get(7).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0006", beanLst.get(8).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111196", beanLst.get(8).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0007", beanLst.get(9).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111185", beanLst.get(9).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0008", beanLst.get(10).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111196", beanLst.get(10).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0009", beanLst.get(11).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111200", beanLst.get(11).getMT_DsKokyakuKeiyaku().getSyono());
        Assert.assertEquals("0010", beanLst.get(12).getMT_DsKokyakuKeiyaku().getDskokno());
        Assert.assertEquals("11807111211", beanLst.get(12).getMT_DsKokyakuKeiyaku().getSyono());

    }

    @Transactional
    public static void deleteTestSubData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());

        List<MT_DsKokyakuKanri> dsKokyakuKanriLst = directDomManager.getAllDsKokyakuKanri();
        if (dsKokyakuKanriLst.size() > 0) {
            directDomManager.delete(dsKokyakuKanriLst);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }

}
