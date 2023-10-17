package yuyu.def.biz.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouHozon;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.TestOrder;

/**
 * 帳票検索テーブルエンティティリスト取得（書類コード、サブシステムID、処理年月日、出力回数）のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount {

    @Inject
    private BizDomManager bizDomManager;



    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn.HK_SHRMESS,
            "SubID01", BizDate.valueOf(20150514), 0);

        Assert.assertEquals(0, tyouhyouKensakuLst.size());

        AT_TyouhyouHozon tyouhyouHozon1 = baseDomManager.getTyouhyouHozon("TK00000001");
        if (null == tyouhyouHozon1) {

            tyouhyouHozon1 = new AT_TyouhyouHozon("TK00000001");

            baseDomManager.insert(tyouhyouHozon1);
        }

        AT_TyouhyouKensaku tyouhyouKensaku1 = new AT_TyouhyouKensaku();
        tyouhyouKensaku1.setUniqueId("UID01");
        tyouhyouKensaku1.setReportKey("TK00000001");
        tyouhyouKensaku1.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku1.setSubSystemId("SubID01");
        tyouhyouKensaku1.setKensakuKey1("kk101");
        tyouhyouKensaku1.setKensakuKey2("kk210");
        tyouhyouKensaku1.setKensakuKey3("kk303");
        tyouhyouKensaku1.setKensakuKey4("kk404");
        tyouhyouKensaku1.setKensakuKey5("kk505");
        tyouhyouKensaku1.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku1.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku2 = new AT_TyouhyouKensaku();
        tyouhyouKensaku2.setUniqueId("UID02");
        tyouhyouKensaku2.setReportKey("TK00000001");
        tyouhyouKensaku2.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku2.setSubSystemId("SubID01");
        tyouhyouKensaku2.setKensakuKey1("kk102");
        tyouhyouKensaku2.setKensakuKey2("kk202");
        tyouhyouKensaku2.setKensakuKey3("kk303");
        tyouhyouKensaku2.setKensakuKey4("kk404");
        tyouhyouKensaku2.setKensakuKey5("kk505");
        tyouhyouKensaku2.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku2.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku3 = new AT_TyouhyouKensaku();
        tyouhyouKensaku3.setUniqueId("UID03");
        tyouhyouKensaku3.setReportKey("TK00000001");
        tyouhyouKensaku3.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku3.setSubSystemId("SubID01");
        tyouhyouKensaku3.setKensakuKey1("kk103");
        tyouhyouKensaku3.setKensakuKey2("kk203");
        tyouhyouKensaku3.setKensakuKey3("kk320");
        tyouhyouKensaku3.setKensakuKey4("kk404");
        tyouhyouKensaku3.setKensakuKey5("kk505");
        tyouhyouKensaku3.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku3.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku4 = new AT_TyouhyouKensaku();
        tyouhyouKensaku4.setUniqueId("UID04");
        tyouhyouKensaku4.setReportKey("TK00000001");
        tyouhyouKensaku4.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku4.setSubSystemId("SubID01");
        tyouhyouKensaku4.setKensakuKey1("kk103");
        tyouhyouKensaku4.setKensakuKey2("kk204");
        tyouhyouKensaku4.setKensakuKey3("kk303");
        tyouhyouKensaku4.setKensakuKey4("kk404");
        tyouhyouKensaku4.setKensakuKey5("kk505");
        tyouhyouKensaku4.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku4.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku5 = new AT_TyouhyouKensaku();
        tyouhyouKensaku5.setUniqueId("UID05");
        tyouhyouKensaku5.setReportKey("TK00000001");
        tyouhyouKensaku5.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku5.setSubSystemId("SubID01");
        tyouhyouKensaku5.setKensakuKey1("kk103");
        tyouhyouKensaku5.setKensakuKey2("kk205");
        tyouhyouKensaku5.setKensakuKey3("kk305");
        tyouhyouKensaku5.setKensakuKey4("kk430");
        tyouhyouKensaku5.setKensakuKey5("kk505");
        tyouhyouKensaku5.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku5.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku6 = new AT_TyouhyouKensaku();
        tyouhyouKensaku6.setReportKey("TK00000001");
        tyouhyouKensaku6.setUniqueId("UID06");
        tyouhyouKensaku6.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku6.setSubSystemId("SubID01");
        tyouhyouKensaku6.setKensakuKey1("kk103");
        tyouhyouKensaku6.setKensakuKey2("kk205");
        tyouhyouKensaku6.setKensakuKey3("kk306");
        tyouhyouKensaku6.setKensakuKey4("kk404");
        tyouhyouKensaku6.setKensakuKey5("kk505");
        tyouhyouKensaku6.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku6.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku7 = new AT_TyouhyouKensaku();
        tyouhyouKensaku7.setUniqueId("UID07");
        tyouhyouKensaku7.setReportKey("TK00000001");
        tyouhyouKensaku7.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku7.setSubSystemId("SubID01");
        tyouhyouKensaku7.setKensakuKey1("kk103");
        tyouhyouKensaku7.setKensakuKey2("kk205");
        tyouhyouKensaku7.setKensakuKey3("kk307");
        tyouhyouKensaku7.setKensakuKey4("kk407");
        tyouhyouKensaku7.setKensakuKey5("kk540");
        tyouhyouKensaku7.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku7.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku8 = new AT_TyouhyouKensaku();
        tyouhyouKensaku8.setUniqueId("UID08");
        tyouhyouKensaku8.setReportKey("TK00000001");
        tyouhyouKensaku8.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku8.setSubSystemId("SubID01");
        tyouhyouKensaku8.setKensakuKey1("kk103");
        tyouhyouKensaku8.setKensakuKey2("kk205");
        tyouhyouKensaku8.setKensakuKey3("kk307");
        tyouhyouKensaku8.setKensakuKey4("kk408");
        tyouhyouKensaku8.setKensakuKey5("kk505");
        tyouhyouKensaku8.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku8.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku9 = new AT_TyouhyouKensaku();
        tyouhyouKensaku9.setUniqueId("UID09");
        tyouhyouKensaku9.setReportKey("TK00000001");
        tyouhyouKensaku9.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku9.setSubSystemId("SubID01");
        tyouhyouKensaku9.setKensakuKey1("kk103");
        tyouhyouKensaku9.setKensakuKey2("kk205");
        tyouhyouKensaku9.setKensakuKey3("kk307");
        tyouhyouKensaku9.setKensakuKey4("kk409");
        tyouhyouKensaku9.setKensakuKey5("kk509");
        tyouhyouKensaku9.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku9.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku10 = new AT_TyouhyouKensaku();
        tyouhyouKensaku10.setUniqueId("UID10");
        tyouhyouKensaku10.setReportKey("TK00000001");
        tyouhyouKensaku10.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku10.setSubSystemId("SubID01");
        tyouhyouKensaku10.setKensakuKey1("kk103");
        tyouhyouKensaku10.setKensakuKey2("kk205");
        tyouhyouKensaku10.setKensakuKey3("kk307");
        tyouhyouKensaku10.setKensakuKey4("kk409");
        tyouhyouKensaku10.setKensakuKey5("kk510");
        tyouhyouKensaku10.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku10.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku11 = new AT_TyouhyouKensaku();
        tyouhyouKensaku11.setUniqueId("UID11");
        tyouhyouKensaku11.setReportKey("TK00000001");
        tyouhyouKensaku11.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku11.setSubSystemId("SubID01");
        tyouhyouKensaku11.setKensakuKey1("kk103");
        tyouhyouKensaku11.setKensakuKey2("kk205");
        tyouhyouKensaku11.setKensakuKey3("kk307");
        tyouhyouKensaku11.setKensakuKey4("kk409");
        tyouhyouKensaku11.setKensakuKey5("kk511");
        tyouhyouKensaku11.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku11.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku12 = new AT_TyouhyouKensaku();
        tyouhyouKensaku12.setUniqueId("UID12");
        tyouhyouKensaku12.setReportKey("TK00000001");
        tyouhyouKensaku12.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);
        tyouhyouKensaku12.setSubSystemId("SubID01");
        tyouhyouKensaku12.setKensakuKey1("kk101");
        tyouhyouKensaku12.setKensakuKey2("kk201");
        tyouhyouKensaku12.setKensakuKey3("kk301");
        tyouhyouKensaku12.setKensakuKey4("kk401");
        tyouhyouKensaku12.setKensakuKey5("kk501");
        tyouhyouKensaku12.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku12.setOutCount(0);

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
        tyouhyouKensaku13.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku14 = new AT_TyouhyouKensaku();
        tyouhyouKensaku14.setUniqueId("UID14");
        tyouhyouKensaku14.setReportKey("TK00000001");
        tyouhyouKensaku14.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku14.setSubSystemId("SubID01");
        tyouhyouKensaku14.setKensakuKey1("kk101");
        tyouhyouKensaku14.setKensakuKey2("kk201");
        tyouhyouKensaku14.setKensakuKey3("kk301");
        tyouhyouKensaku14.setKensakuKey4("kk401");
        tyouhyouKensaku14.setKensakuKey5("kk501");
        tyouhyouKensaku14.setSyoriYmd(BizDate.valueOf(20150515));
        tyouhyouKensaku14.setOutCount(0);

        AT_TyouhyouKensaku tyouhyouKensaku15 = new AT_TyouhyouKensaku();
        tyouhyouKensaku15.setUniqueId("UID15");
        tyouhyouKensaku15.setReportKey("TK00000001");
        tyouhyouKensaku15.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku15.setSubSystemId("SubID01");
        tyouhyouKensaku15.setKensakuKey1("kk101");
        tyouhyouKensaku15.setKensakuKey2("kk201");
        tyouhyouKensaku15.setKensakuKey3("kk301");
        tyouhyouKensaku15.setKensakuKey4("kk401");
        tyouhyouKensaku15.setKensakuKey5("kk501");
        tyouhyouKensaku15.setSyoriYmd(BizDate.valueOf(20150514));
        tyouhyouKensaku15.setOutCount(1);

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

        AM_SyoruiZokusei syoruiZokusei1 = new AM_SyoruiZokusei();
        syoruiZokusei1.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);

        AM_SyoruiZokusei syoruiZokusei2 = new AM_SyoruiZokusei();
        syoruiZokusei2.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);

        baseDomManager.insert(syoruiZokusei1);
        baseDomManager.insert(syoruiZokusei2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        AT_TyouhyouKensaku aT_TyouhyouKensaku = null;
        for(int i=1;i<16;i++) {
            aT_TyouhyouKensaku = baseDomManager.getTyouhyouKensaku("UID"+String.format("%02d", i));
            if (aT_TyouhyouKensaku!=null) {
                baseDomManager.delete(aT_TyouhyouKensaku);
            }

        }
        AT_TyouhyouHozon tyouhyouHozon1 = baseDomManager.getTyouhyouHozon("TK00000001");

        if (null != tyouhyouHozon1) {

            baseDomManager.delete(tyouhyouHozon1);
        }

        baseDomManager.delete(baseDomManager.getAllSyoruiZokuseis());

    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn.HK_SHRMESS,
            "SubID09", BizDate.valueOf(20150518), 3);
        Assert.assertEquals(0, tyouhyouKensakuLst.size());



    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn.HK_SHRMESS,
            "SubID01", BizDate.valueOf(20150514), 1);
        Assert.assertEquals(1, tyouhyouKensakuLst.size());
        Assert.assertEquals("UID15", tyouhyouKensakuLst.get(0).getUniqueId());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn.HK_SHRMESS,
            "SubID01", BizDate.valueOf(20150514), 0);
        Assert.assertEquals(11, tyouhyouKensakuLst.size());
        Assert.assertEquals("UID01", tyouhyouKensakuLst.get(0).getUniqueId());
        Assert.assertEquals("UID02", tyouhyouKensakuLst.get(1).getUniqueId());
        Assert.assertEquals("UID03", tyouhyouKensakuLst.get(2).getUniqueId());
        Assert.assertEquals("UID04", tyouhyouKensakuLst.get(3).getUniqueId());
        Assert.assertEquals("UID05", tyouhyouKensakuLst.get(4).getUniqueId());
        Assert.assertEquals("UID06", tyouhyouKensakuLst.get(5).getUniqueId());
        Assert.assertEquals("UID07", tyouhyouKensakuLst.get(6).getUniqueId());
        Assert.assertEquals("UID08", tyouhyouKensakuLst.get(7).getUniqueId());
        Assert.assertEquals("UID09", tyouhyouKensakuLst.get(8).getUniqueId());
        Assert.assertEquals("UID10", tyouhyouKensakuLst.get(9).getUniqueId());
        Assert.assertEquals("UID11", tyouhyouKensakuLst.get(10).getUniqueId());

    }

    @Test
    @TestOrder(80)
    public void blankCondition1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusBySyoruiCdSubSystemIdSyoriYmdOutCount(C_SyoruiCdKbn.HK_SHRMESS,
            "", BizDate.valueOf(20150514), 0);
        Assert.assertEquals(0, tyouhyouKensakuLst.size());
    }
}
