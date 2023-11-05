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
import yuyu.def.hozen.result.bean.KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * ダイレクトサービス<br />
 * ダイレクトサービス共通DBアクセス<br />
 * 契約基本テーブルエンティティリスト取得(処理年月日FROM、処理年月日TO)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class HozenDomManagerTest_getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj {

    @Inject
    HozenDomManager hozenDomManager;

    static BizDate P_TYSYTYMDFROM_01 = BizDate.valueOf(20160310);
    static BizDate P_TYSYTYMDFROM_02 = BizDate.valueOf(20160110);
    static BizDate P_TYSYTYMDTO_01 = BizDate.valueOf(20160320);
    static BizDate P_TYSYTYMDTO_02 = BizDate.valueOf(20160310);
    static BizDate P_TYSYTYMDTO_03 = BizDate.valueOf(20160120);
    static String P_SYONO_01 = "11807111118";
    static String P_SYONO_02 = "11807111152";
    static String P_SYONO_03 = "11807111163";
    static String P_SYONO_04 = "11807111129";
    static String P_SYONO_05 = "11807111130";
    static String P_SYONO_06 = "11807111141";
    static String P_SYONO_07 = "11807111174";
    static String P_SYONO_08 = "11807111185";
    static String P_SYONO_09 = "11807111196";
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_01 = BizDate.valueOf(20160310);
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_02 = BizDate.valueOf(20160311);
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_03 = BizDate.valueOf(20160312);
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_04 = BizDate.valueOf(20160319);
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_05 = BizDate.valueOf(20160320);
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_06 = BizDate.valueOf(20160309);
    static BizDate P_LASTKYKNMSEIYMDHENKOUYMD_07 = BizDate.valueOf(20160321);
    static BizDate P_LASTKYKNMKANAKJTEIYMD_01 = BizDate.valueOf(20160310);
    static BizDate P_LASTKYKNMKANAKJTEIYMD_02 = BizDate.valueOf(20160311);
    static BizDate P_LASTKYKNMKANAKJTEIYMD_03 = BizDate.valueOf(20160312);
    static BizDate P_LASTKYKNMKANAKJTEIYMD_04 = BizDate.valueOf(20160319);
    static BizDate P_LASTKYKNMKANAKJTEIYMD_05 = BizDate.valueOf(20160320);
    static BizDate P_LASTKYKNMKANAKJTEIYMD_06 = BizDate.valueOf(20160309);

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        DirectDomManager directDomManager = SWAKInjector.getInstance(DirectDomManager.class);

        List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> iT_KykKihonLst = hozenDomManager
            .getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_01, P_TYSYTYMDTO_02);

        Assert.assertEquals(0, iT_KykKihonLst.size());

        IT_KykKihon iT_KykKihon1 = new IT_KykKihon(P_SYONO_01);
        iT_KykKihon1.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_06);
        iT_KykKihon1.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_06);

        IT_KykSya iT_KykSha1 = iT_KykKihon1.createKykSya();
        iT_KykSha1.setKyknmkn("アアア");
        iT_KykSha1.setKyknmkj("亜亜亜");
        iT_KykSha1.setKykseiymd(BizDate.valueOf(20000101));

        hozenDomManager.insert(iT_KykKihon1);

        IT_KykKihon iT_KykKihon2 = new IT_KykKihon(P_SYONO_02);
        iT_KykKihon2.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_01);
        iT_KykKihon2.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_01);

        IT_KykSya iT_KykSha2 =iT_KykKihon2.createKykSya();
        iT_KykSha2.setKyknmkn("イイイ");
        iT_KykSha2.setKyknmkj("伊伊伊");
        iT_KykSha2.setKykseiymd(BizDate.valueOf(20000102));


        hozenDomManager.insert(iT_KykKihon2);

        IT_KykKihon iT_KykKihon3 = new IT_KykKihon(P_SYONO_03);
        iT_KykKihon3.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_02);
        iT_KykKihon3.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_02);

        IT_KykSya iT_KykSha3 =iT_KykKihon3.createKykSya();
        iT_KykSha3.setKyknmkn("ウウウ");
        iT_KykSha3.setKyknmkj("雨雨雨");
        iT_KykSha3.setKykseiymd(BizDate.valueOf(20000103));

        hozenDomManager.insert(iT_KykKihon3);

        IT_KykKihon iT_KykKihon4 = new IT_KykKihon(P_SYONO_04);
        iT_KykKihon4.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_03);
        iT_KykKihon4.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_03);

        IT_KykSya iT_KykSha4 =iT_KykKihon4.createKykSya();
        iT_KykSha4.setKyknmkn("エエエ");
        iT_KykSha4.setKyknmkj("得得得");
        iT_KykSha4.setKykseiymd(BizDate.valueOf(20000104));

        hozenDomManager.insert(iT_KykKihon4);

        IT_KykKihon iT_KykKihon5 = new IT_KykKihon(P_SYONO_05);
        iT_KykKihon5.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_03);
        iT_KykKihon5.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_03);

        IT_KykSya iT_KykSha5 =iT_KykKihon5.createKykSya();
        iT_KykSha5.setKyknmkn("オオオ");
        iT_KykSha5.setKyknmkj("尾尾尾");
        iT_KykSha5.setKykseiymd(BizDate.valueOf(20000105));

        hozenDomManager.insert(iT_KykKihon5);

        IT_KykKihon iT_KykKihon6 = new IT_KykKihon(P_SYONO_06);
        iT_KykKihon6.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_03);
        iT_KykKihon6.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_03);

        hozenDomManager.insert(iT_KykKihon6);

        IT_KykKihon iT_KykKihon7 = new IT_KykKihon(P_SYONO_07);
        iT_KykKihon7.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_04);
        iT_KykKihon7.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_04);

        IT_KykSya iT_KykSha7 =iT_KykKihon7.createKykSya();
        iT_KykSha7.setKyknmkn("カカカ");
        iT_KykSha7.setKyknmkj("火火火");
        iT_KykSha7.setKykseiymd(BizDate.valueOf(20000106));

        hozenDomManager.insert(iT_KykKihon7);

        IT_KykKihon iT_KykKihon8 = new IT_KykKihon(P_SYONO_08);
        iT_KykKihon8.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_05);
        iT_KykKihon8.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_05);

        IT_KykSya iT_KykSha8 =iT_KykKihon8.createKykSya();
        iT_KykSha8.setKyknmkn("キキキ");
        iT_KykSha8.setKyknmkj("気気気");
        iT_KykSha8.setKykseiymd(BizDate.valueOf(20000107));

        hozenDomManager.insert(iT_KykKihon8);

        IT_KykKihon iT_KykKihon9 = new IT_KykKihon(P_SYONO_09);
        iT_KykKihon9.setLastkyknmseiymdhenkouymd(P_LASTKYKNMSEIYMDHENKOUYMD_07);
        iT_KykKihon9.setLastkyknmkanakjteiymd(P_LASTKYKNMKANAKJTEIYMD_05);

        IT_KykSya iT_KykSha9 =iT_KykKihon9.createKykSya();
        iT_KykSha9.setKyknmkn("ククク");
        iT_KykSha9.setKyknmkj("区区区");
        iT_KykSha9.setKykseiymd(BizDate.valueOf(20000108));


        hozenDomManager.insert(iT_KykKihon9);

        MT_DsKokyakuKanri mT_DsKokyakuKanri1 = new MT_DsKokyakuKanri("111");
        mT_DsKokyakuKanri1.setDskokyakujtkbn(C_DsKokyakuJtKbn.BLANK);
        mT_DsKokyakuKanri1.setDskokyakunmkn("ア");
        mT_DsKokyakuKanri1.setDskokyakunmkj("亜");
        mT_DsKokyakuKanri1.setDskokyakuseiymd(BizDate.valueOf(20010101));
        mT_DsKokyakuKanri1.setDskokyakuyno("1600023");

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku11 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku11.setSyono(P_SYONO_01);
        mT_DsKokyakuKeiyaku11.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku13 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku13.setSyono(P_SYONO_03);
        mT_DsKokyakuKeiyaku13.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku14 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku14.setSyono(P_SYONO_04);
        mT_DsKokyakuKeiyaku14.setDskykmukouhyj(C_MukouHyj.MUKOU);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku15 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku15.setSyono(P_SYONO_06);
        mT_DsKokyakuKeiyaku15.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku16 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku16.setSyono(P_SYONO_07);
        mT_DsKokyakuKeiyaku16.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku18 = mT_DsKokyakuKanri1.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku18.setSyono(P_SYONO_09);
        mT_DsKokyakuKeiyaku18.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd1 = mT_DsKokyakuKanri1.createDsHonninKakuninCd();
        mT_DsHonninKakuninCd1.setDskrhnnkakcd("0002");
        mT_DsHonninKakuninCd1.setDshnnkakcd("0001");

        directDomManager.insert(mT_DsKokyakuKanri1);

        MT_DsKokyakuKanri mT_DsKokyakuKanri2 = new MT_DsKokyakuKanri("222");
        mT_DsKokyakuKanri2.setDskokyakujtkbn(C_DsKokyakuJtKbn.YUUKOU);
        mT_DsKokyakuKanri2.setDskokyakunmkn("イ");
        mT_DsKokyakuKanri2.setDskokyakunmkj("伊");
        mT_DsKokyakuKanri2.setDskokyakuseiymd(BizDate.valueOf(20010102));
        mT_DsKokyakuKanri2.setDskokyakuyno("1600024");

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku12 = mT_DsKokyakuKanri2.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku12.setSyono(P_SYONO_02);
        mT_DsKokyakuKeiyaku12.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd2 = mT_DsKokyakuKanri2.createDsHonninKakuninCd();
        mT_DsHonninKakuninCd2.setDskrhnnkakcd("0012");
        mT_DsHonninKakuninCd2.setDshnnkakcd("0011");
        directDomManager.insert(mT_DsHonninKakuninCd2);

        directDomManager.insert(mT_DsKokyakuKanri2);

        MT_DsKokyakuKanri mT_DsKokyakuKanri3 = new MT_DsKokyakuKanri("333");
        mT_DsKokyakuKanri3.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
        mT_DsKokyakuKanri3.setDskokyakunmkn("ウ");
        mT_DsKokyakuKanri3.setDskokyakunmkj("雨");
        mT_DsKokyakuKanri3.setDskokyakuseiymd(BizDate.valueOf(20010103));
        mT_DsKokyakuKanri3.setDskokyakuyno("1600025");

        MT_DsKokyakuKeiyaku mT_DsKokyakuKeiyaku17 = mT_DsKokyakuKanri3.createDsKokyakuKeiyaku();
        mT_DsKokyakuKeiyaku17.setSyono(P_SYONO_08);
        mT_DsKokyakuKeiyaku17.setDskykmukouhyj(C_MukouHyj.BLANK);

        MT_DsHonninKakuninCd mT_DsHonninKakuninCd3 = mT_DsKokyakuKanri3.createDsHonninKakuninCd();
        mT_DsHonninKakuninCd3.setDskrhnnkakcd("0022");
        mT_DsHonninKakuninCd3.setDshnnkakcd("0021");

        directDomManager.insert(mT_DsKokyakuKanri3);

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

        List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> iT_KykKihonLst =
            hozenDomManager.getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_02, P_TYSYTYMDTO_03);

        Assert.assertEquals(0, iT_KykKihonLst.size());
    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> beanList =
            hozenDomManager.getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_01, P_TYSYTYMDTO_02);

        Assert.assertEquals(1, beanList.size());

        Assert.assertEquals(P_LASTKYKNMSEIYMDHENKOUYMD_01, beanList.get(0).getLastkyknmseiymdhenkouymd());
        Assert.assertEquals(P_LASTKYKNMKANAKJTEIYMD_01, beanList.get(0).getLastkyknmkanakjteiymd());
        Assert.assertEquals("伊伊伊", beanList.get(0).getKyknmkj());
        Assert.assertEquals("イイイ", beanList.get(0).getKyknmkn());
        Assert.assertEquals(BizDate.valueOf(20000102), beanList.get(0).getKykseiymd());
        Assert.assertEquals("11807111152", beanList.get(0).getSyono());
        Assert.assertEquals("222", beanList.get(0).getDskokno());
        Assert.assertEquals("伊", beanList.get(0).getDskokyakunmkj());
        Assert.assertEquals("イ", beanList.get(0).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf(20010102), beanList.get(0).getDskokyakuseiymd());
        Assert.assertEquals("1600024", beanList.get(0).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.YUUKOU, beanList.get(0).getDskokyakujtkbn());
        Assert.assertEquals("0011", beanList.get(0).getDshnnkakcd());
        Assert.assertEquals("0012", beanList.get(0).getDskrhnnkakcd());
    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<KykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyjBean> iT_KykKihonLst =
            hozenDomManager.getKykKihonsBySyoriYmdFromSyoriYmdToDskykmukouhyj(P_TYSYTYMDFROM_01, P_TYSYTYMDTO_01);

        Assert.assertEquals(BizDate.valueOf(20160311), iT_KykKihonLst.get(0).getLastkyknmseiymdhenkouymd());
        Assert.assertEquals(BizDate.valueOf(20160311), iT_KykKihonLst.get(0).getLastkyknmkanakjteiymd());
        Assert.assertEquals("雨雨雨", iT_KykKihonLst.get(0).getKyknmkj());
        Assert.assertEquals("ウウウ", iT_KykKihonLst.get(0).getKyknmkn());
        Assert.assertEquals(BizDate.valueOf(20000103), iT_KykKihonLst.get(0).getKykseiymd());
        Assert.assertEquals("11807111163", iT_KykKihonLst.get(0).getSyono());
        Assert.assertEquals("111", iT_KykKihonLst.get(0).getDskokno());
        Assert.assertEquals("亜", iT_KykKihonLst.get(0).getDskokyakunmkj());
        Assert.assertEquals("ア", iT_KykKihonLst.get(0).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf(20010101), iT_KykKihonLst.get(0).getDskokyakuseiymd());
        Assert.assertEquals("1600023", iT_KykKihonLst.get(0).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.BLANK, iT_KykKihonLst.get(0).getDskokyakujtkbn());
        Assert.assertEquals("0001", iT_KykKihonLst.get(0).getDshnnkakcd());
        Assert.assertEquals("0002", iT_KykKihonLst.get(0).getDskrhnnkakcd());

        Assert.assertEquals(BizDate.valueOf(20160319), iT_KykKihonLst.get(1).getLastkyknmseiymdhenkouymd());
        Assert.assertEquals(BizDate.valueOf(20160319), iT_KykKihonLst.get(1).getLastkyknmkanakjteiymd());
        Assert.assertEquals("火火火", iT_KykKihonLst.get(1).getKyknmkj());
        Assert.assertEquals("カカカ", iT_KykKihonLst.get(1).getKyknmkn());
        Assert.assertEquals(BizDate.valueOf(20000106), iT_KykKihonLst.get(1).getKykseiymd());
        Assert.assertEquals("11807111174", iT_KykKihonLst.get(1).getSyono());
        Assert.assertEquals("111", iT_KykKihonLst.get(1).getDskokno());
        Assert.assertEquals("亜", iT_KykKihonLst.get(1).getDskokyakunmkj());
        Assert.assertEquals("ア", iT_KykKihonLst.get(1).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf(20010101), iT_KykKihonLst.get(1).getDskokyakuseiymd());
        Assert.assertEquals("1600023", iT_KykKihonLst.get(1).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.BLANK, iT_KykKihonLst.get(1).getDskokyakujtkbn());
        Assert.assertEquals("0001", iT_KykKihonLst.get(1).getDshnnkakcd());
        Assert.assertEquals("0002", iT_KykKihonLst.get(1).getDskrhnnkakcd());

        Assert.assertEquals(BizDate.valueOf(20160321), iT_KykKihonLst.get(2).getLastkyknmseiymdhenkouymd());
        Assert.assertEquals(BizDate.valueOf(20160320), iT_KykKihonLst.get(2).getLastkyknmkanakjteiymd());
        Assert.assertEquals("区区区", iT_KykKihonLst.get(2).getKyknmkj());
        Assert.assertEquals("ククク", iT_KykKihonLst.get(2).getKyknmkn());
        Assert.assertEquals(BizDate.valueOf(20000108), iT_KykKihonLst.get(2).getKykseiymd());
        Assert.assertEquals("11807111196", iT_KykKihonLst.get(2).getSyono());
        Assert.assertEquals("111", iT_KykKihonLst.get(2).getDskokno());
        Assert.assertEquals("亜", iT_KykKihonLst.get(2).getDskokyakunmkj());
        Assert.assertEquals("ア", iT_KykKihonLst.get(2).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf(20010101), iT_KykKihonLst.get(2).getDskokyakuseiymd());
        Assert.assertEquals("1600023", iT_KykKihonLst.get(2).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.BLANK, iT_KykKihonLst.get(2).getDskokyakujtkbn());
        Assert.assertEquals("0001", iT_KykKihonLst.get(2).getDshnnkakcd());
        Assert.assertEquals("0002", iT_KykKihonLst.get(2).getDskrhnnkakcd());

        Assert.assertEquals(P_LASTKYKNMSEIYMDHENKOUYMD_01, iT_KykKihonLst.get(3).getLastkyknmseiymdhenkouymd());
        Assert.assertEquals(P_LASTKYKNMKANAKJTEIYMD_01, iT_KykKihonLst.get(3).getLastkyknmkanakjteiymd());
        Assert.assertEquals("伊伊伊", iT_KykKihonLst.get(3).getKyknmkj());
        Assert.assertEquals("イイイ", iT_KykKihonLst.get(3).getKyknmkn());
        Assert.assertEquals(BizDate.valueOf(20000102), iT_KykKihonLst.get(3).getKykseiymd());
        Assert.assertEquals("11807111152", iT_KykKihonLst.get(3).getSyono());
        Assert.assertEquals("222", iT_KykKihonLst.get(3).getDskokno());
        Assert.assertEquals("伊", iT_KykKihonLst.get(3).getDskokyakunmkj());
        Assert.assertEquals("イ", iT_KykKihonLst.get(3).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf(20010102), iT_KykKihonLst.get(3).getDskokyakuseiymd());
        Assert.assertEquals("1600024", iT_KykKihonLst.get(3).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.YUUKOU, iT_KykKihonLst.get(3).getDskokyakujtkbn());
        Assert.assertEquals("0011", iT_KykKihonLst.get(3).getDshnnkakcd());
        Assert.assertEquals("0012", iT_KykKihonLst.get(3).getDskrhnnkakcd());

        Assert.assertEquals(BizDate.valueOf(20160320), iT_KykKihonLst.get(4).getLastkyknmseiymdhenkouymd());
        Assert.assertEquals(BizDate.valueOf(20160320), iT_KykKihonLst.get(4).getLastkyknmkanakjteiymd());
        Assert.assertEquals("気気気", iT_KykKihonLst.get(4).getKyknmkj());
        Assert.assertEquals("キキキ", iT_KykKihonLst.get(4).getKyknmkn());
        Assert.assertEquals(BizDate.valueOf(20000107), iT_KykKihonLst.get(4).getKykseiymd());
        Assert.assertEquals("11807111185", iT_KykKihonLst.get(4).getSyono());
        Assert.assertEquals("333", iT_KykKihonLst.get(4).getDskokno());
        Assert.assertEquals("雨", iT_KykKihonLst.get(4).getDskokyakunmkj());
        Assert.assertEquals("ウ", iT_KykKihonLst.get(4).getDskokyakunmkn());
        Assert.assertEquals(BizDate.valueOf(20010103), iT_KykKihonLst.get(4).getDskokyakuseiymd());
        Assert.assertEquals("1600025", iT_KykKihonLst.get(4).getDskokyakuyno());
        Assert.assertEquals(C_DsKokyakuJtKbn.ITIJI_TEISI, iT_KykKihonLst.get(4).getDskokyakujtkbn());
        Assert.assertEquals("0021", iT_KykKihonLst.get(4).getDshnnkakcd());
        Assert.assertEquals("0022", iT_KykKihonLst.get(4).getDskrhnnkakcd());
    }
}
