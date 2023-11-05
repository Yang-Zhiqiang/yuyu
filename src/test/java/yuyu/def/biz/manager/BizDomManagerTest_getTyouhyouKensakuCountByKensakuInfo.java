package yuyu.def.biz.manager;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.TestOrder;


import yuyu.testinfr.OrderedRunner;

/**
 * 帳票検索テーブルエンティティ件数取得(検索項目)のテストクラス<br />
 */
@RunWith(OrderedRunner.class)
public class BizDomManagerTest_getTyouhyouKensakuCountByKensakuInfo {

    @Inject
    private BizDomManager bizDomManager;

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        Long tyouhyouKensakuCount = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(0), tyouhyouKensakuCount);

        AT_TyouhyouKensaku tyouhyouKensaku1 = new AT_TyouhyouKensaku();
        tyouhyouKensaku1.setUniqueId("UID01");
        tyouhyouKensaku1.setReportKey("TK00000001");
        tyouhyouKensaku1.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku1.setSubSystemId("SubID01");
        tyouhyouKensaku1.setKensakuKey1("kk101");
        tyouhyouKensaku1.setKensakuKey2("kk201");
        tyouhyouKensaku1.setKensakuKey3("kk301");
        tyouhyouKensaku1.setKensakuKey4("kk401");
        tyouhyouKensaku1.setKensakuKey5("kk501");
        tyouhyouKensaku1.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku2 = new AT_TyouhyouKensaku();
        tyouhyouKensaku2.setUniqueId("UID02");
        tyouhyouKensaku2.setReportKey("TK00000001");
        tyouhyouKensaku2.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku2.setSubSystemId("SubID01");
        tyouhyouKensaku2.setKensakuKey1("kk101");
        tyouhyouKensaku2.setKensakuKey2("kk201");
        tyouhyouKensaku2.setKensakuKey3("kk301");
        tyouhyouKensaku2.setKensakuKey4("kk401");
        tyouhyouKensaku2.setKensakuKey5("kk501");
        tyouhyouKensaku2.setSyoriYmd(BizDate.valueOf(20150515));

        AT_TyouhyouKensaku tyouhyouKensaku3 = new AT_TyouhyouKensaku();
        tyouhyouKensaku3.setUniqueId("UID03");
        tyouhyouKensaku3.setReportKey("TK00000001");
        tyouhyouKensaku3.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku3.setSubSystemId("SubID01");
        tyouhyouKensaku3.setKensakuKey1("kk101");
        tyouhyouKensaku3.setKensakuKey2("kk201");
        tyouhyouKensaku3.setKensakuKey3("kk301");
        tyouhyouKensaku3.setKensakuKey4("kk401");
        tyouhyouKensaku3.setKensakuKey5("kk501");
        tyouhyouKensaku3.setSyoriYmd(BizDate.valueOf(20150516));

        AT_TyouhyouKensaku tyouhyouKensaku4 = new AT_TyouhyouKensaku();
        tyouhyouKensaku4.setUniqueId("UID04");
        tyouhyouKensaku4.setReportKey("TK00000001");
        tyouhyouKensaku4.setSyoruiCd(C_SyoruiCdKbn.HK_SHMEISAI_SDS);
        tyouhyouKensaku4.setSubSystemId("SubID01");
        tyouhyouKensaku4.setKensakuKey1("kk101");
        tyouhyouKensaku4.setKensakuKey2("kk201");
        tyouhyouKensaku4.setKensakuKey3("kk301");
        tyouhyouKensaku4.setKensakuKey4("kk401");
        tyouhyouKensaku4.setKensakuKey5("kk501");
        tyouhyouKensaku4.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku5 = new AT_TyouhyouKensaku();
        tyouhyouKensaku5.setUniqueId("UID05");
        tyouhyouKensaku5.setReportKey("TK00000001");
        tyouhyouKensaku5.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku5.setSubSystemId("SubID02");
        tyouhyouKensaku5.setKensakuKey1("kk101");
        tyouhyouKensaku5.setKensakuKey2("kk201");
        tyouhyouKensaku5.setKensakuKey3("kk301");
        tyouhyouKensaku5.setKensakuKey4("kk401");
        tyouhyouKensaku5.setKensakuKey5("kk501");
        tyouhyouKensaku5.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku6 = new AT_TyouhyouKensaku();
        tyouhyouKensaku6.setReportKey("TK00000001");
        tyouhyouKensaku6.setUniqueId("UID06");
        tyouhyouKensaku6.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku6.setSubSystemId("SubID01");
        tyouhyouKensaku6.setKensakuKey1("kk102");
        tyouhyouKensaku6.setKensakuKey2("kk201");
        tyouhyouKensaku6.setKensakuKey3("kk301");
        tyouhyouKensaku6.setKensakuKey4("kk401");
        tyouhyouKensaku6.setKensakuKey5("kk501");
        tyouhyouKensaku6.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku7 = new AT_TyouhyouKensaku();
        tyouhyouKensaku7.setUniqueId("UID07");
        tyouhyouKensaku7.setReportKey("TK00000001");
        tyouhyouKensaku7.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku7.setSubSystemId("SubID01");
        tyouhyouKensaku7.setKensakuKey1("kk101");
        tyouhyouKensaku7.setKensakuKey2("kk202");
        tyouhyouKensaku7.setKensakuKey3("kk301");
        tyouhyouKensaku7.setKensakuKey4("kk401");
        tyouhyouKensaku7.setKensakuKey5("kk501");
        tyouhyouKensaku7.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku8 = new AT_TyouhyouKensaku();
        tyouhyouKensaku8.setUniqueId("UID08");
        tyouhyouKensaku8.setReportKey("TK00000001");
        tyouhyouKensaku8.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku8.setSubSystemId("SubID01");
        tyouhyouKensaku8.setKensakuKey1("kk101");
        tyouhyouKensaku8.setKensakuKey2("kk201");
        tyouhyouKensaku8.setKensakuKey3("kk302");
        tyouhyouKensaku8.setKensakuKey4("kk401");
        tyouhyouKensaku8.setKensakuKey5("kk501");
        tyouhyouKensaku8.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku9 = new AT_TyouhyouKensaku();
        tyouhyouKensaku9.setUniqueId("UID09");
        tyouhyouKensaku9.setReportKey("TK00000001");
        tyouhyouKensaku9.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku9.setSubSystemId("SubID01");
        tyouhyouKensaku9.setKensakuKey1("kk101");
        tyouhyouKensaku9.setKensakuKey2("kk201");
        tyouhyouKensaku9.setKensakuKey3("kk301");
        tyouhyouKensaku9.setKensakuKey4("kk402");
        tyouhyouKensaku9.setKensakuKey5("kk501");
        tyouhyouKensaku9.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku10 = new AT_TyouhyouKensaku();
        tyouhyouKensaku10.setUniqueId("UID10");
        tyouhyouKensaku10.setReportKey("TK00000001");
        tyouhyouKensaku10.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku10.setSubSystemId("SubID01");
        tyouhyouKensaku10.setKensakuKey1("kk101");
        tyouhyouKensaku10.setKensakuKey2("kk201");
        tyouhyouKensaku10.setKensakuKey3("kk301");
        tyouhyouKensaku10.setKensakuKey4("kk401");
        tyouhyouKensaku10.setKensakuKey5("kk502");
        tyouhyouKensaku10.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku11 = new AT_TyouhyouKensaku();
        tyouhyouKensaku11.setUniqueId("UID11");
        tyouhyouKensaku11.setReportKey("TK00000001");
        tyouhyouKensaku11.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku11.setSubSystemId("SubID01");
        tyouhyouKensaku11.setKensakuKey1("kk101");
        tyouhyouKensaku11.setKensakuKey2("kk201");
        tyouhyouKensaku11.setKensakuKey3("kk301");
        tyouhyouKensaku11.setKensakuKey4("kk401");
        tyouhyouKensaku11.setKensakuKey5("kk501");
        tyouhyouKensaku11.setSyoriYmd(BizDate.valueOf(20150513));

        AT_TyouhyouKensaku tyouhyouKensaku12 = new AT_TyouhyouKensaku();
        tyouhyouKensaku12.setUniqueId("UID12");
        tyouhyouKensaku12.setReportKey("TK00000001");
        tyouhyouKensaku12.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku12.setSubSystemId("SubID01");
        tyouhyouKensaku12.setKensakuKey1("kk101");
        tyouhyouKensaku12.setKensakuKey2("kk201");
        tyouhyouKensaku12.setKensakuKey3("kk301");
        tyouhyouKensaku12.setKensakuKey4("kk401");
        tyouhyouKensaku12.setKensakuKey5("kk501");
        tyouhyouKensaku12.setSyoriYmd(BizDate.valueOf(20150517));

        AT_TyouhyouKensaku tyouhyouKensaku13 = new AT_TyouhyouKensaku();
        tyouhyouKensaku13.setUniqueId("UID13");
        tyouhyouKensaku13.setReportKey("TK00000001");
        tyouhyouKensaku13.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku13.setSubSystemId("SubID03");
        tyouhyouKensaku13.setKensakuKey1("kk101");
        tyouhyouKensaku13.setKensakuKey2("kk201");
        tyouhyouKensaku13.setKensakuKey3("kk301");
        tyouhyouKensaku13.setKensakuKey4("kk401");
        tyouhyouKensaku13.setKensakuKey5("kk501");
        tyouhyouKensaku13.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku14 = new AT_TyouhyouKensaku();
        tyouhyouKensaku14.setUniqueId("UID14");
        tyouhyouKensaku14.setReportKey("TK00000001");
        tyouhyouKensaku14.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku14.setSubSystemId("SubID03");
        tyouhyouKensaku14.setKensakuKey1("kk101");
        tyouhyouKensaku14.setKensakuKey2("kk201");
        tyouhyouKensaku14.setKensakuKey3("kk301");
        tyouhyouKensaku14.setKensakuKey4("kk401");
        tyouhyouKensaku14.setKensakuKey5("kk501");
        tyouhyouKensaku14.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku15 = new AT_TyouhyouKensaku();
        tyouhyouKensaku15.setUniqueId("UID15");
        tyouhyouKensaku15.setReportKey("TK00000001");
        tyouhyouKensaku15.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku15.setSubSystemId("SubID03");
        tyouhyouKensaku15.setKensakuKey1("kk101");
        tyouhyouKensaku15.setKensakuKey2("kk201");
        tyouhyouKensaku15.setKensakuKey3("kk301");
        tyouhyouKensaku15.setKensakuKey4("kk401");
        tyouhyouKensaku15.setKensakuKey5("kk501");
        tyouhyouKensaku15.setSyoriYmd(BizDate.valueOf(20150514));

        baseDomManager.insert(tyouhyouKensaku1);
        baseDomManager.insert(tyouhyouKensaku2);
        baseDomManager.insert(tyouhyouKensaku3);
        baseDomManager.insert(tyouhyouKensaku4);
        baseDomManager.insert(tyouhyouKensaku5);
        baseDomManager.insert(tyouhyouKensaku6);
        baseDomManager.insert(tyouhyouKensaku7);
        baseDomManager.insert(tyouhyouKensaku8);
        baseDomManager.insert(tyouhyouKensaku9);
        baseDomManager.insert(tyouhyouKensaku10);
        baseDomManager.insert(tyouhyouKensaku11);
        baseDomManager.insert(tyouhyouKensaku12);
        baseDomManager.insert(tyouhyouKensaku13);
        baseDomManager.insert(tyouhyouKensaku14);
        baseDomManager.insert(tyouhyouKensaku15);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String str = "delete from AT_TyouhyouKensaku";

        em.createNativeSQL(str).executeUpdate();

    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        Long tyouhyouKensakuCount = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID20", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(0), tyouhyouKensakuCount);

        Long tyouhyouKensakuCount2 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150520), null);
        Assert.assertEquals(Long.valueOf(0), tyouhyouKensakuCount2);


    }

    @Test
    @TestOrder(20)
    public void normal1() {

        Long tyouhyouKensakuCount = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHMEISAI_SDS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount);

        Long tyouhyouKensakuCount2 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), null);
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount2);

        Long tyouhyouKensakuCount3 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "", "kk202","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount3);

        Long tyouhyouKensakuCount4 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "","kk302", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount4);

        Long tyouhyouKensakuCount5 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","", "kk402", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount5);

        Long tyouhyouKensakuCount6 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "", "kk502", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount6);

        Long tyouhyouKensakuCount7 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk102", "kk201","kk301", "kk401", "", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(1), tyouhyouKensakuCount7);

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Long tyouhyouKensakuCount = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(3), tyouhyouKensakuCount);

        Long tyouhyouKensakuCount2 = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("SubID03", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), null);
        Assert.assertEquals(Long.valueOf(3), tyouhyouKensakuCount2);


    }

    @Test
    @TestOrder(120)
    public void blankCondition1() {

        Long tyouhyouKensakuCount = bizDomManager.getTyouhyouKensakuCountByKensakuInfo("", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201", "kk301", "kk401", "kk501",  BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(Long.valueOf(0), tyouhyouKensakuCount);
    }
}
