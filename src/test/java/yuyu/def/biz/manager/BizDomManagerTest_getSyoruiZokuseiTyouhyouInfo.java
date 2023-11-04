package yuyu.def.biz.manager;

import static org.junit.Assert.*;

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

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.biz.result.bean.SyoruiZokuseiTyouhyouInfoBean;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.def.db.entity.BT_TyouhyouOutputKengen;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * BizDomManagerクラスの、<br />
 * getSyoruiZokuseiTyouhyouInfo() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getSyoruiZokuseiTyouhyouInfo {

    @Inject
    BizDomManager bizDomManager;
    @Inject
    BaseDomManager baseDomManager;

    private static final String[] roleCd1 = {"Administrators", "Admin"};
    private static final String[] roleCd2 = {"system", "systemId", "systemIdCd"};
    private static final String[] roleCd3 = {"SystemUsers", "roleCd02", "roleCd03", "roleCd04"};
    private static final String[] roleCd4 = {""};

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<SyoruiZokuseiTyouhyouInfoBean>  syoruiZokuseiTyouhyouInfoBeanList= bizDomManager.
            getSyoruiZokuseiTyouhyouInfo("biz", BizDate.valueOf(20161107), roleCd1, C_SyoruiCdKbn.HK_SHRMESS);

        Assert.assertEquals(0, syoruiZokuseiTyouhyouInfoBeanList.size());

        AM_SyoruiZokusei syoruiZokusei1 = new AM_SyoruiZokusei(C_SyoruiCdKbn.HK_SHRMESS);
        syoruiZokusei1.setSyoruinm("支払明細書");
        syoruiZokusei1.setSortNo(1);
        syoruiZokusei1.setKensakuKey1("key1");
        syoruiZokusei1.setKensakuKey2("key2");
        syoruiZokusei1.setKensakuKey3("key3");
        syoruiZokusei1.setKensakuKey4("key4");
        syoruiZokusei1.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei1);

        AM_SyoruiZokusei syoruiZokusei2 = new AM_SyoruiZokusei(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        syoruiZokusei2.setSyoruinm("支払明細書");
        syoruiZokusei2.setSortNo(2);
        syoruiZokusei2.setKensakuKey1("key1");
        syoruiZokusei2.setKensakuKey2("key2");
        syoruiZokusei2.setKensakuKey3("key3");
        syoruiZokusei2.setKensakuKey4("key4");
        syoruiZokusei2.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei2);

        AM_SyoruiZokusei syoruiZokusei3 = new AM_SyoruiZokusei(C_SyoruiCdKbn.CM_KARIUKEMEISAI_1);
        syoruiZokusei3.setSyoruinm("支払明細書");
        syoruiZokusei3.setSortNo(3);
        syoruiZokusei3.setKensakuKey1("key1");
        syoruiZokusei3.setKensakuKey2("key2");
        syoruiZokusei3.setKensakuKey3("key3");
        syoruiZokusei3.setKensakuKey4("key4");
        syoruiZokusei3.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei3);

        AM_SyoruiZokusei syoruiZokusei4 = new AM_SyoruiZokusei(C_SyoruiCdKbn.SK_HENKINMISYORILIST);
        syoruiZokusei4.setSyoruinm("返金未処理リスト");
        syoruiZokusei4.setSortNo(5);
        syoruiZokusei4.setKensakuKey1("key1");
        syoruiZokusei4.setKensakuKey2("key2");
        syoruiZokusei4.setKensakuKey3("key3");
        syoruiZokusei4.setKensakuKey4("key4");
        syoruiZokusei4.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei4);

        AT_TyouhyouKensaku tyouhyouKensaku1 = new AT_TyouhyouKensaku("UID01");
        tyouhyouKensaku1.setReportKey("TK00000001");
        tyouhyouKensaku1.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku1.setSubSystemId("biz");
        tyouhyouKensaku1.setSyoriYmd(BizDate.valueOf(20161107));
        tyouhyouKensaku1.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku1);

        AT_TyouhyouKensaku tyouhyouKensaku2 = new AT_TyouhyouKensaku("UID02");
        tyouhyouKensaku2.setReportKey("TK00000001");
        tyouhyouKensaku2.setSyoruiCd(C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        tyouhyouKensaku2.setSubSystemId("hozen");
        tyouhyouKensaku2.setSyoriYmd(BizDate.valueOf(20161107));
        tyouhyouKensaku2.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku2);

        AT_TyouhyouKensaku tyouhyouKensaku3 = new AT_TyouhyouKensaku("UID03");
        tyouhyouKensaku3.setReportKey("TK00000001");
        tyouhyouKensaku3.setSyoruiCd(C_SyoruiCdKbn.CM_KARIUKEMEISAI_1);
        tyouhyouKensaku3.setSubSystemId("biz");
        tyouhyouKensaku3.setSyoriYmd(BizDate.valueOf(20161108));
        tyouhyouKensaku3.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku3);

        AT_TyouhyouKensaku tyouhyouKensaku4 = new AT_TyouhyouKensaku("UID04");
        tyouhyouKensaku4.setReportKey("TK00000001");
        tyouhyouKensaku4.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku4.setSubSystemId("biz");
        tyouhyouKensaku4.setSyoriYmd(BizDate.valueOf(20161107));
        tyouhyouKensaku4.setOutCount(1);

        baseDomManager.insert(tyouhyouKensaku4);

        AT_TyouhyouHozon tyouhyouHozon1 = new AT_TyouhyouHozon("TK00000001");

        baseDomManager.insert(tyouhyouHozon1);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen1 = new BT_TyouhyouOutputKengen("Administrators", C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouOutputKengen1.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen1);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen2 = new BT_TyouhyouOutputKengen("Administrators", C_SyoruiCdKbn.CM_JIMURENRAKUHYOU);
        tyouhyouOutputKengen2.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen2);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen3 = new BT_TyouhyouOutputKengen("Administrators", C_SyoruiCdKbn.CM_KARIUKEMEISAI_1);
        tyouhyouOutputKengen3.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen3);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen4 = new BT_TyouhyouOutputKengen("Administrators", C_SyoruiCdKbn.SK_HENKINMISYORILIST);
        tyouhyouOutputKengen4.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen4);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);
        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID01"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID02"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID03"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID04"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID05"));
        baseDomManager.delete(baseDomManager.getTyouhyouHozon("TK00000001"));
        bizDomManager.delete(bizDomManager.getAllTyouhyouOutputKengen());
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        List<SyoruiZokuseiTyouhyouInfoBean>  syoruiZokuseiTyouhyouInfoBeanList= bizDomManager.
            getSyoruiZokuseiTyouhyouInfo("biz", BizDate.valueOf(20161107), roleCd2, C_SyoruiCdKbn.HK_SHRMESS);

        Assert.assertEquals(0, syoruiZokuseiTyouhyouInfoBeanList.size());

    }

    @Test
    @TestOrder(20)
    @Transactional
    public void normal10(){

        List<SyoruiZokuseiTyouhyouInfoBean>  syoruiZokuseiTyouhyouInfoBeanList= bizDomManager.
            getSyoruiZokuseiTyouhyouInfo("biz", BizDate.valueOf(20161107), roleCd1, C_SyoruiCdKbn.HK_SHRMESS);

        Assert.assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.size());

        assertEquals(C_SyoruiCdKbn.HK_SHRMESS, syoruiZokuseiTyouhyouInfoBeanList.get(0).getSyoruiCd());
        assertEquals("支払明細書", syoruiZokuseiTyouhyouInfoBeanList.get(0).getSyoruinm());
        assertEquals("key1", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey1());
        assertEquals("key2", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey2());
        assertEquals("key3", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey3());
        assertEquals("key4", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey4());
        assertEquals("key5", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey5());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(0).getSortNo().intValue());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(0).getNotOutputCount());
        assertEquals(2, syoruiZokuseiTyouhyouInfoBeanList.get(0).getAmount());
    }

    @Test
    @TestOrder(21)
    @Transactional
    public void normal11(){

        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID01"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID02"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID03"));
        baseDomManager.delete(baseDomManager.getTyouhyouKensaku("UID04"));
        baseDomManager.delete(baseDomManager.getTyouhyouHozon("TK00000001"));
        bizDomManager.delete(bizDomManager.getAllTyouhyouOutputKengen());

        AM_SyoruiZokusei syoruiZokusei1 = new AM_SyoruiZokusei(C_SyoruiCdKbn.HK_SHRMESS);
        syoruiZokusei1.setSyoruinm("支払明細書");
        syoruiZokusei1.setSortNo(4);
        syoruiZokusei1.setKensakuKey1("key1");
        syoruiZokusei1.setKensakuKey2("key2");
        syoruiZokusei1.setKensakuKey3("key3");
        syoruiZokusei1.setKensakuKey4("key4");
        syoruiZokusei1.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei1);

        AM_SyoruiZokusei syoruiZokusei2 = new AM_SyoruiZokusei(C_SyoruiCdKbn.KK_GENGAKU_SKS);
        syoruiZokusei2.setSyoruinm("減額請求書");
        syoruiZokusei2.setSortNo(1);
        syoruiZokusei2.setKensakuKey1("key1");
        syoruiZokusei2.setKensakuKey2("key2");
        syoruiZokusei2.setKensakuKey3("key3");
        syoruiZokusei2.setKensakuKey4("key4");
        syoruiZokusei2.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei2);

        AM_SyoruiZokusei syoruiZokusei3 = new AM_SyoruiZokusei(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);
        syoruiZokusei3.setSyoruinm("支払明細書");
        syoruiZokusei3.setSortNo(4);
        syoruiZokusei3.setKensakuKey1("key1");
        syoruiZokusei3.setKensakuKey2("key2");
        syoruiZokusei3.setKensakuKey3("key3");
        syoruiZokusei3.setKensakuKey4("key4");
        syoruiZokusei3.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei3);

        AM_SyoruiZokusei syoruiZokusei4 = new AM_SyoruiZokusei(C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR);
        syoruiZokusei4.setSyoruinm("支払明細書");
        syoruiZokusei4.setSortNo(4);
        syoruiZokusei4.setKensakuKey1("key1");
        syoruiZokusei4.setKensakuKey2("key2");
        syoruiZokusei4.setKensakuKey3("key3");
        syoruiZokusei4.setKensakuKey4("key4");
        syoruiZokusei4.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei4);

        AM_SyoruiZokusei syoruiZokusei5 = new AM_SyoruiZokusei(C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);
        syoruiZokusei5.setSyoruinm("名義変更");
        syoruiZokusei5.setSortNo(3);
        syoruiZokusei5.setKensakuKey1("key1");
        syoruiZokusei5.setKensakuKey2("key2");
        syoruiZokusei5.setKensakuKey3("key3");
        syoruiZokusei5.setKensakuKey4("key4");
        syoruiZokusei5.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei5);

        AM_SyoruiZokusei syoruiZokusei6 = new AM_SyoruiZokusei(C_SyoruiCdKbn.KK_SYOSAIHK_HB);
        syoruiZokusei6.setSyoruinm("不備訂正書");
        syoruiZokusei6.setSortNo(2);
        syoruiZokusei6.setKensakuKey1("key1");
        syoruiZokusei6.setKensakuKey2("key2");
        syoruiZokusei6.setKensakuKey3("key3");
        syoruiZokusei6.setKensakuKey4("key4");
        syoruiZokusei6.setKensakuKey5("key5");

        baseDomManager.insert(syoruiZokusei6);

        AT_TyouhyouKensaku tyouhyouKensaku1 = new AT_TyouhyouKensaku("UID01");
        tyouhyouKensaku1.setReportKey("TK00000001");
        tyouhyouKensaku1.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku1.setSubSystemId("biz");
        tyouhyouKensaku1.setSyoriYmd(BizDate.valueOf(20150817));
        tyouhyouKensaku1.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku1);

        AT_TyouhyouKensaku tyouhyouKensaku2 = new AT_TyouhyouKensaku("UID02");
        tyouhyouKensaku2.setReportKey("TK00000001");
        tyouhyouKensaku2.setSyoruiCd(C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);
        tyouhyouKensaku2.setSubSystemId("biz");
        tyouhyouKensaku2.setSyoriYmd(BizDate.valueOf(20150817));
        tyouhyouKensaku2.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku2);

        AT_TyouhyouKensaku tyouhyouKensaku3 = new AT_TyouhyouKensaku("UID03");
        tyouhyouKensaku3.setReportKey("TK00000001");
        tyouhyouKensaku3.setSyoruiCd(C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR);
        tyouhyouKensaku3.setSubSystemId("biz");
        tyouhyouKensaku3.setSyoriYmd(BizDate.valueOf(20150817));
        tyouhyouKensaku3.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku3);

        AT_TyouhyouKensaku tyouhyouKensaku4 = new AT_TyouhyouKensaku("UID04");
        tyouhyouKensaku4.setReportKey("TK00000001");
        tyouhyouKensaku4.setSyoruiCd(C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);
        tyouhyouKensaku4.setSubSystemId("biz");
        tyouhyouKensaku4.setSyoriYmd(BizDate.valueOf(20150817));
        tyouhyouKensaku4.setOutCount(0);

        baseDomManager.insert(tyouhyouKensaku4);

        AT_TyouhyouKensaku tyouhyouKensaku5 = new AT_TyouhyouKensaku("UID05");
        tyouhyouKensaku5.setReportKey("TK00000001");
        tyouhyouKensaku5.setSyoruiCd(C_SyoruiCdKbn.KK_SYOSAIHK_HB);
        tyouhyouKensaku5.setSubSystemId("biz");
        tyouhyouKensaku5.setSyoriYmd(BizDate.valueOf(20150817));
        tyouhyouKensaku5.setOutCount(1);

        baseDomManager.insert(tyouhyouKensaku5);

        AT_TyouhyouHozon tyouhyouHozon1 = new AT_TyouhyouHozon("TK00000001");

        baseDomManager.insert(tyouhyouHozon1);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen1 = new BT_TyouhyouOutputKengen("SystemUsers", C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouOutputKengen1.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen1);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen2 = new BT_TyouhyouOutputKengen("SystemUsers", C_SyoruiCdKbn.KK_MEIGIHNK_HB);
        tyouhyouOutputKengen2.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen2);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen3 = new BT_TyouhyouOutputKengen("roleCd01", C_SyoruiCdKbn.KK_SEINENGAPPISEI_SKS);
        tyouhyouOutputKengen3.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen3);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen4 = new BT_TyouhyouOutputKengen("roleCd02", C_SyoruiCdKbn.KK_CLGOFF_KYKTRKSTTDKKR);
        tyouhyouOutputKengen4.setIkkatuoutputkahikbn(C_KahiKbn.HUKA);

        bizDomManager.insert(tyouhyouOutputKengen4);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen5 = new BT_TyouhyouOutputKengen("roleCd03", C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR);
        tyouhyouOutputKengen5.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen5);

        BT_TyouhyouOutputKengen tyouhyouOutputKengen6 = new BT_TyouhyouOutputKengen("roleCd04", C_SyoruiCdKbn.KK_SYOSAIHK_HB);
        tyouhyouOutputKengen6.setIkkatuoutputkahikbn(C_KahiKbn.KA);

        bizDomManager.insert(tyouhyouOutputKengen6);

    }
    @Test
    @TestOrder(30)
    public void normal2(){

        List<SyoruiZokuseiTyouhyouInfoBean>  syoruiZokuseiTyouhyouInfoBeanList= bizDomManager.
            getSyoruiZokuseiTyouhyouInfo("biz", BizDate.valueOf(20150817), roleCd3, null);

        Assert.assertEquals(3, syoruiZokuseiTyouhyouInfoBeanList.size());

        assertEquals(C_SyoruiCdKbn.KK_SYOSAIHK_HB, syoruiZokuseiTyouhyouInfoBeanList.get(0).getSyoruiCd());
        assertEquals("不備訂正書", syoruiZokuseiTyouhyouInfoBeanList.get(0).getSyoruinm());
        assertEquals("key1", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey1());
        assertEquals("key2", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey2());
        assertEquals("key3", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey3());
        assertEquals("key4", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey4());
        assertEquals("key5", syoruiZokuseiTyouhyouInfoBeanList.get(0).getKensakuKey5());
        assertEquals(2, syoruiZokuseiTyouhyouInfoBeanList.get(0).getSortNo().intValue());
        assertEquals(0, syoruiZokuseiTyouhyouInfoBeanList.get(0).getNotOutputCount());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(0).getAmount());

        assertEquals(C_SyoruiCdKbn.KK_MEIGIHNK_TTDKKR, syoruiZokuseiTyouhyouInfoBeanList.get(1).getSyoruiCd());
        assertEquals("名義変更", syoruiZokuseiTyouhyouInfoBeanList.get(1).getSyoruinm());
        assertEquals("key1", syoruiZokuseiTyouhyouInfoBeanList.get(1).getKensakuKey1());
        assertEquals("key2", syoruiZokuseiTyouhyouInfoBeanList.get(1).getKensakuKey2());
        assertEquals("key3", syoruiZokuseiTyouhyouInfoBeanList.get(1).getKensakuKey3());
        assertEquals("key4", syoruiZokuseiTyouhyouInfoBeanList.get(1).getKensakuKey4());
        assertEquals("key5", syoruiZokuseiTyouhyouInfoBeanList.get(1).getKensakuKey5());
        assertEquals(3, syoruiZokuseiTyouhyouInfoBeanList.get(1).getSortNo().intValue());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(1).getNotOutputCount());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(1).getAmount());

        assertEquals(C_SyoruiCdKbn.HK_SHRMESS, syoruiZokuseiTyouhyouInfoBeanList.get(2).getSyoruiCd());
        assertEquals("支払明細書", syoruiZokuseiTyouhyouInfoBeanList.get(2).getSyoruinm());
        assertEquals("key1", syoruiZokuseiTyouhyouInfoBeanList.get(2).getKensakuKey1());
        assertEquals("key2", syoruiZokuseiTyouhyouInfoBeanList.get(2).getKensakuKey2());
        assertEquals("key3", syoruiZokuseiTyouhyouInfoBeanList.get(2).getKensakuKey3());
        assertEquals("key4", syoruiZokuseiTyouhyouInfoBeanList.get(2).getKensakuKey4());
        assertEquals("key5", syoruiZokuseiTyouhyouInfoBeanList.get(2).getKensakuKey5());
        assertEquals(4, syoruiZokuseiTyouhyouInfoBeanList.get(2).getSortNo().intValue());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(2).getNotOutputCount());
        assertEquals(1, syoruiZokuseiTyouhyouInfoBeanList.get(2).getAmount());
    }

    @Test
    @TestOrder(40)
    public void blankCondition1() {

        List<SyoruiZokuseiTyouhyouInfoBean>  syoruiZokuseiTyouhyouInfoBeanList= bizDomManager.
            getSyoruiZokuseiTyouhyouInfo("", BizDate.valueOf(20150817), roleCd3, C_SyoruiCdKbn.HK_SHRMESS);

        Assert.assertEquals(0, syoruiZokuseiTyouhyouInfoBeanList.size());
    }

    @Test
    @TestOrder(50)
    public void blankCondition2() {

        List<SyoruiZokuseiTyouhyouInfoBean>  syoruiZokuseiTyouhyouInfoBeanList= bizDomManager.
            getSyoruiZokuseiTyouhyouInfo("biz", BizDate.valueOf(20150817), roleCd4, C_SyoruiCdKbn.HK_SHRMESS);

        Assert.assertEquals(0, syoruiZokuseiTyouhyouInfoBeanList.size());
    }
}
