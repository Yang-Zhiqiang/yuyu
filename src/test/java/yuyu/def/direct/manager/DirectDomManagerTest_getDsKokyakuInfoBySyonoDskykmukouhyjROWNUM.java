package yuyu.def.direct.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.direct.result.bean.DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * DirectDomManagerクラスの、<br />
 * getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class DirectDomManagerTest_getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM {

    @Inject
    DirectDomManager directDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean beans = directDomManager.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM("11807111118");
        Assert.assertNull(beans);

        MT_DsKokyakuKanri dsKokyakuKanri1 = new MT_DsKokyakuKanri("M1001");
        dsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("0"));
        dsKokyakuKanri1.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.valueOf("0"));
        dsKokyakuKanri1.setDskokyakunmkn("ラアラ");
        dsKokyakuKanri1.setDskokyakunmkj("新契新");
        dsKokyakuKanri1.setDskokyakuseiymd(BizDate.valueOf(20160215));
        dsKokyakuKanri1.setDskokyakuyno("100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku1 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku1.setSyono("11807111118");
        dsKokyakuKeiyaku1.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku2 = dsKokyakuKanri1.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku2.setSyono("11807111129");
        dsKokyakuKeiyaku2.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        directDomManager.insert(dsKokyakuKanri1);

        MT_DsKokyakuKanri dsKokyakuKanri2 = new MT_DsKokyakuKanri("M1002");
        dsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("0"));
        dsKokyakuKanri2.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.valueOf("0"));
        dsKokyakuKanri2.setDskokyakunmkn("ラアラ");
        dsKokyakuKanri2.setDskokyakunmkj("新契新");
        dsKokyakuKanri2.setDskokyakuseiymd(BizDate.valueOf(20160215));
        dsKokyakuKanri2.setDskokyakuyno("100001");

        directDomManager.insert(dsKokyakuKanri2);

        MT_DsKokyakuKanri dsKokyakuKanri3 = new MT_DsKokyakuKanri("M1003");
        dsKokyakuKanri3.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("0"));
        dsKokyakuKanri3.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.valueOf("0"));
        dsKokyakuKanri3.setDskokyakunmkn("ラアラ");
        dsKokyakuKanri3.setDskokyakunmkj("新契新");
        dsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf(20160215));
        dsKokyakuKanri3.setDskokyakuyno("100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku3 = dsKokyakuKanri3.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku3.setSyono("11807111118");
        dsKokyakuKeiyaku3.setDskykmukouhyj(C_MukouHyj.valueOf("1"));

        directDomManager.insert(dsKokyakuKanri3);

        MT_DsKokyakuKanri dsKokyakuKanri4 = new MT_DsKokyakuKanri("M1004");
        dsKokyakuKanri4.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("0"));
        dsKokyakuKanri4.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.valueOf("0"));
        dsKokyakuKanri4.setDskokyakunmkn("ラアラ");
        dsKokyakuKanri4.setDskokyakunmkj("新契新");
        dsKokyakuKanri4.setDskokyakuseiymd(BizDate.valueOf(20160215));
        dsKokyakuKanri4.setDskokyakuyno("100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku4 = dsKokyakuKanri4.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku4.setSyono("11807111118");
        dsKokyakuKeiyaku4.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        directDomManager.insert(dsKokyakuKanri4);

        MT_DsKokyakuKanri dsKokyakuKanri5 = new MT_DsKokyakuKanri("M1005");
        dsKokyakuKanri5.setDskokyakujtkbn(C_DsKokyakuJtKbn.valueOf("0"));
        dsKokyakuKanri5.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.valueOf("0"));
        dsKokyakuKanri5.setDskokyakunmkn("ラアラ");
        dsKokyakuKanri5.setDskokyakunmkj("新契新");
        dsKokyakuKanri5.setDskokyakuseiymd(BizDate.valueOf(20160215));
        dsKokyakuKanri5.setDskokyakuyno("100001");

        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku5 = dsKokyakuKanri5.createDsKokyakuKeiyaku();
        dsKokyakuKeiyaku5.setSyono("11807111118");
        dsKokyakuKeiyaku5.setDskykmukouhyj(C_MukouHyj.valueOf("0"));

        directDomManager.insert(dsKokyakuKanri5);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void noResult1() {

        DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean beans = directDomManager.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM("11807111130");

        Assert.assertNull(beans);
    }
    @Test
    @TestOrder(20)
    @Transactional
    public void normal1() {

        DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean beans = directDomManager.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM("11807111118");

        Assert.assertEquals("M1005", beans.getDskokno());
        Assert.assertEquals("ラアラ", beans.getDskokyakunmkn());
        Assert.assertEquals("新契新", beans.getDskokyakunmkj());
        Assert.assertEquals(BizDate.valueOf(20160215), beans.getDskokyakuseiymd());
        Assert.assertEquals("100001", beans.getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.BLANK, beans.getDskokyakujtkbn());
        Assert.assertEquals(C_DsTeisiRiyuuKbn.BLANK, beans.getDsteisiriyuukbn());

    }
    @Test
    @TestOrder(30)
    @Transactional
    public void blank1() {


        DsKokyakuInfoBySyonoDskykmukouhyjROWNUMBean beans = directDomManager.getDsKokyakuInfoBySyonoDskykmukouhyjROWNUM("");

        Assert.assertNull(beans);
    }
}
