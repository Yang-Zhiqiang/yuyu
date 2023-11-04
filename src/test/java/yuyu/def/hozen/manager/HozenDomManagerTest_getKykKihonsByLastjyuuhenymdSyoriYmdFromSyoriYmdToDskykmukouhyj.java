package yuyu.def.hozen.manager;

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

import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_MukouHyj;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_DsHonninKakuninCd;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.hozen.result.bean.KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * 契約基本テーブルエンティティリスト取得(処理年月日FROM、処理年月日TO)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj {

    @Inject
    HozenDomManager hozenDomManager;

    static BizDate P_TYSYTYMDFROM_01 = BizDate.valueOf(20160310);
    static BizDate P_TYSYTYMDTO_01 = BizDate.valueOf(20160320);
    static BizDate P_TYSYTYMDTO_02 = BizDate.valueOf(20160310);
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111152";
    static String P_SYONO_03 = "11807111163";
    static String P_SYONO_04 = "11807111129";
    static String P_SYONO_05 = "11807111130";
    static String P_SYONO_06 = "11807111141";
    static String P_SYONO_07 = "11807111174";
    static String P_SYONO_08 = "11807111185";
    static String P_SYONO_09 = "11807111196";
    static BizDate P_LASTTSINYNOHENKOUYMD_01 = BizDate.valueOf(20160310);
    static BizDate P_LASTTSINYNOHENKOUYMD_02 = BizDate.valueOf(20160311);
    static BizDate P_LASTTSINYNOHENKOUYMD_03 = BizDate.valueOf(20160312);
    static BizDate P_LASTTSINYNOHENKOUYMD_04 = BizDate.valueOf(20160319);
    static BizDate P_LASTTSINYNOHENKOUYMD_05 = BizDate.valueOf(20160320);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> beanLst = hozenDomManager
            .getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_01, P_TYSYTYMDTO_02);

        Assert.assertEquals(0, beanLst.size());

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);
        iT_KykKihon1.setLasttsinynohenkouymd(BizDate.valueOf(20160309));

        IT_KykSya iT_KykSya1 = iT_KykKihon1.createKykSya();
        iT_KykSya1.setTsinyno("1230001");

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);
        iT_KykKihon2.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_01);

        IT_KykSya iT_KykSya2 = iT_KykKihon2.createKykSya();
        iT_KykSya2.setTsinyno("1230002");

        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);
        iT_KykKihon3.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_02);

        IT_KykSya iT_KykSya3 = iT_KykKihon3.createKykSya();
        iT_KykSya3.setTsinyno("1230003");

        hozenDomManager.insert(iT_KykKihon3);

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon(P_SYONO_04);
        iT_KykKihon4.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_03);

        IT_KykSya iT_KykSya4 = iT_KykKihon4.createKykSya();
        iT_KykSya4.setTsinyno("1230004");

        hozenDomManager.insert(iT_KykKihon4);

        IT_KykKihon iT_KykKihon5 = new IT_KykKihon(P_SYONO_05);
        iT_KykKihon5.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_03);

        IT_KykSya iT_KykSya5 = iT_KykKihon5.createKykSya();
        iT_KykSya5.setTsinyno("1230005");

        hozenDomManager.insert(iT_KykKihon5);

        IT_KykKihon iT_KykKihon6 = new IT_KykKihon(P_SYONO_06);
        iT_KykKihon6.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_03);

        hozenDomManager.insert(iT_KykKihon6);

        IT_KykKihon iT_KykKihon7 = new IT_KykKihon(P_SYONO_07);
        iT_KykKihon7.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_04);

        IT_KykSya iT_KykSya7 = iT_KykKihon7.createKykSya();
        iT_KykSya7.setTsinyno("1230006");

        hozenDomManager.insert(iT_KykKihon7);

        IT_KykKihon iT_KykKihon8 = new IT_KykKihon(P_SYONO_08);
        iT_KykKihon8.setLasttsinynohenkouymd(P_LASTTSINYNOHENKOUYMD_05);

        IT_KykSya iT_KykSya8 = iT_KykKihon8.createKykSya();
        iT_KykSya8.setTsinyno("1230007");

        hozenDomManager.insert(iT_KykKihon8);

        IT_KykKihon iT_KykKihon9 = new IT_KykKihon(P_SYONO_09);
        iT_KykKihon9.setLasttsinynohenkouymd(BizDate.valueOf(20160321));

        IT_KykSya iT_KykSya9 = iT_KykKihon9.createKykSya();
        iT_KykSya9.setTsinyno("1230008");

        hozenDomManager.insert(iT_KykKihon9);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri("222");
        mT_DsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        mT_DsKokyakuKanri2.setDskokyakunmkn("サササ");
        mT_DsKokyakuKanri2.setDskokyakunmkj("顧客顧客顧客");
        mT_DsKokyakuKanri2.setDskokyakuseiymd(BizDate.valueOf("19801010"));
        mT_DsKokyakuKanri2.setDskokyakuyno("4445555");

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku11 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku11.setSyono(P_SYONO_01);
        mT_DsKokyakuKeiyaku11.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku12 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku12.setSyono(P_SYONO_02);
        mT_DsKokyakuKeiyaku12.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku13 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku13.setSyono(P_SYONO_03);
        mT_DsKokyakuKeiyaku13.setDskykmukouhyj(C_MukouHyj.MUKOU);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku14 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku14.setSyono(P_SYONO_04);
        mT_DsKokyakuKeiyaku14.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd2 = mT_DsKokyakuKanri2.createDsHonninKakuninCd();
        mT_DsHonninKakuninCd2.setDskrhnnkakcd("1002");
        mT_DsHonninKakuninCd2.setDshnnkakcd("9002");

        directDomManager.insert(mT_DsKokyakuKanri2);

        MT_DsKokyakuKanri mT_DsKokyakuKanri3 = new MT_DsKokyakuKanri("333");
        mT_DsKokyakuKanri3.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        mT_DsKokyakuKanri3.setDskokyakunmkn("タタタ");
        mT_DsKokyakuKanri3.setDskokyakunmkj("顧客顧客");
        mT_DsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf("19801111"));
        mT_DsKokyakuKanri3.setDskokyakuyno("5556666");

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku15 = mT_DsKokyakuKanri3.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku15.setSyono(P_SYONO_06);
        mT_DsKokyakuKeiyaku15.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku16 = mT_DsKokyakuKanri3.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku16.setSyono(P_SYONO_07);
        mT_DsKokyakuKeiyaku16.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd3 = mT_DsKokyakuKanri3.createDsHonninKakuninCd();
        mT_DsHonninKakuninCd3.setDskrhnnkakcd("1003");
        mT_DsHonninKakuninCd3.setDshnnkakcd("9003");

        directDomManager.insert(mT_DsKokyakuKanri3);

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri("111");
        mT_DsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        mT_DsKokyakuKanri1.setDskokyakunmkn("カカカ");
        mT_DsKokyakuKanri1.setDskokyakunmkj("顧客");
        mT_DsKokyakuKanri1.setDskokyakuseiymd(BizDate.valueOf("19801212"));
        mT_DsKokyakuKanri1.setDskokyakuyno("3334444");


        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku17 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku17.setSyono(P_SYONO_08);
        mT_DsKokyakuKeiyaku17.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku18 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku18.setSyono(P_SYONO_09);
        mT_DsKokyakuKeiyaku18.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd1 = mT_DsKokyakuKanri1.createDsHonninKakuninCd();
        mT_DsHonninKakuninCd1.setDskrhnnkakcd("1001");
        mT_DsHonninKakuninCd1.setDshnnkakcd("9001");

        directDomManager.insert(mT_DsKokyakuKanri1);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        hozenDomManager.delete(hozenDomManager.getAllKykKihon());
        directDomManager.delete(directDomManager.getAllDsKokyakuKanri());
    }

    @Test
    @TestOrder(10)
    public void noResult1() {

        List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> beanLst = hozenDomManager
            .getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(BizDate.valueOf(20160110), BizDate.valueOf(20160120));
        Assert.assertEquals(0, beanLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> beanLst = hozenDomManager
            .getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_01, P_TYSYTYMDTO_02);
        Assert.assertEquals(1, beanLst.size());

        Assert.assertEquals(P_LASTTSINYNOHENKOUYMD_01, beanLst.get(0).getLasttsinynohenkouymd());
        Assert.assertEquals("1230002", beanLst.get(0).getTsinyno());
        Assert.assertEquals(P_SYONO_02, beanLst.get(0).getSyono());
        Assert.assertEquals("222", beanLst.get(0).getDskokno());
        Assert.assertEquals("顧客顧客顧客", beanLst.get(0).getDskokyakunmkj());
        Assert.assertEquals("サササ", beanLst.get(0).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf("19801010"), beanLst.get(0).getDskokyakuseiymd());
        Assert.assertEquals("4445555", beanLst.get(0).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.YUUKOU, beanLst.get(0).getDskokyakujtkbn());
        Assert.assertEquals("9002", beanLst.get(0).getDshnnkakcd());
        Assert.assertEquals("1002", beanLst.get(0).getDskrhnnkakcd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean> beanLst = hozenDomManager
            .getKykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_01, P_TYSYTYMDTO_01);


        int iCount = 0;
        for (KykKihonsByLastjyuuhenymdSyoriYmdFromSyoriYmdToDskykmukouhyjBean bean : beanLst) {
            iCount++;

            if (1 == iCount) {

                Assert.assertEquals(P_LASTTSINYNOHENKOUYMD_05, bean.getLasttsinynohenkouymd());
                Assert.assertEquals("1230007", bean.getTsinyno());
                Assert.assertEquals(P_SYONO_08, bean.getSyono());
                Assert.assertEquals("111", bean.getDskokno());
                Assert.assertEquals("顧客", bean.getDskokyakunmkj());
                Assert.assertEquals("カカカ", bean.getDskokyakunmkn());
                Assert.assertEquals(BizDate.valueOf("19801212"), bean.getDskokyakuseiymd());
                Assert.assertEquals("3334444", bean.getDskokyakuyno());
                Assert.assertEquals(C_DsKokyakuJtKbn.BLANK, bean.getDskokyakujtkbn());
                Assert.assertEquals("9001", bean.getDshnnkakcd());
                Assert.assertEquals("1001", bean.getDskrhnnkakcd());
            }

            if (2 == iCount) {

                Assert.assertEquals(P_LASTTSINYNOHENKOUYMD_03, bean.getLasttsinynohenkouymd());
                Assert.assertEquals("1230004", bean.getTsinyno());
                Assert.assertEquals(P_SYONO_04, bean.getSyono());
                Assert.assertEquals("222", bean.getDskokno());
                Assert.assertEquals("顧客顧客顧客", bean.getDskokyakunmkj());
                Assert.assertEquals("サササ", bean.getDskokyakunmkn());
                Assert.assertEquals(BizDate.valueOf("19801010"), bean.getDskokyakuseiymd());
                Assert.assertEquals("4445555", bean.getDskokyakuyno());
                Assert.assertEquals(C_DsKokyakuJtKbn.YUUKOU, bean.getDskokyakujtkbn());
                Assert.assertEquals("9002", bean.getDshnnkakcd());
                Assert.assertEquals("1002", bean.getDskrhnnkakcd());
            }

            if (3 == iCount) {

                Assert.assertEquals(P_LASTTSINYNOHENKOUYMD_01, bean.getLasttsinynohenkouymd());
                Assert.assertEquals("1230002", bean.getTsinyno());
                Assert.assertEquals(P_SYONO_02, bean.getSyono());
                Assert.assertEquals("222", bean.getDskokno());
                Assert.assertEquals("顧客顧客顧客", bean.getDskokyakunmkj());
                Assert.assertEquals("サササ", bean.getDskokyakunmkn());
                Assert.assertEquals(BizDate.valueOf("19801010"), bean.getDskokyakuseiymd());
                Assert.assertEquals("4445555", bean.getDskokyakuyno());
                Assert.assertEquals(C_DsKokyakuJtKbn.YUUKOU, bean.getDskokyakujtkbn());
                Assert.assertEquals("9002", bean.getDshnnkakcd());
                Assert.assertEquals("1002", bean.getDskrhnnkakcd());
            }

            if (4 == iCount) {

                Assert.assertEquals(P_LASTTSINYNOHENKOUYMD_04, bean.getLasttsinynohenkouymd());
                Assert.assertEquals("1230006", bean.getTsinyno());
                Assert.assertEquals(P_SYONO_07, bean.getSyono());
                Assert.assertEquals("333", bean.getDskokno());
                Assert.assertEquals("顧客顧客", bean.getDskokyakunmkj());
                Assert.assertEquals("タタタ", bean.getDskokyakunmkn());
                Assert.assertEquals(BizDate.valueOf("19801111"), bean.getDskokyakuseiymd());
                Assert.assertEquals("5556666", bean.getDskokyakuyno());
                Assert.assertEquals(C_DsKokyakuJtKbn.ITIJI_TEISI, bean.getDskokyakujtkbn());
                Assert.assertEquals("9003", bean.getDshnnkakcd());
                Assert.assertEquals("1003", bean.getDskrhnnkakcd());
            }
        }
        Assert.assertEquals(4, iCount);



    }
}
