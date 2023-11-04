package yuyu.def.biz.manager;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.test.SWAKTestRunner;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBEntityManager;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.AM_SyoruiZokusei;
import yuyu.def.db.entity.AT_TyouhyouKensaku;
import yuyu.testinfr.TestOrder;

/**
 * 帳票検索テーブルエンティティリスト取得(検索項目)のテストクラス<br />
 */
@RunWith(SWAKTestRunner.class)
public class BizDomManagerTest_getTyouhyouKensakusByKensakuInfo {

    @Inject
    private BizDomManager bizDomManager;



    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BaseDomManager baseDomManager = SWAKInjector.getInstance(BaseDomManager.class);

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(0, tyouhyouKensakuLst.size());

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
        tyouhyouKensaku4.setSyoruiCd(C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);
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
        tyouhyouKensaku6.setUniqueId("UID06");
        tyouhyouKensaku6.setReportKey("TK00000001");
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

        AT_TyouhyouKensaku tyouhyouKensaku16 = new AT_TyouhyouKensaku();
        tyouhyouKensaku16.setUniqueId("UID16");
        tyouhyouKensaku16.setReportKey("TK00000001");
        tyouhyouKensaku16.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku16.setSubSystemId("SubID04");
        tyouhyouKensaku16.setKensakuKey1("kk101");
        tyouhyouKensaku16.setKensakuKey2("kk202");
        tyouhyouKensaku16.setKensakuKey3("kk301");
        tyouhyouKensaku16.setKensakuKey4("kk401");
        tyouhyouKensaku16.setKensakuKey5("kk501");
        tyouhyouKensaku16.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku17 = new AT_TyouhyouKensaku();
        tyouhyouKensaku17.setUniqueId("UID17");
        tyouhyouKensaku17.setReportKey("TK00000001");
        tyouhyouKensaku17.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku17.setSubSystemId("SubID04");
        tyouhyouKensaku17.setKensakuKey1("kk102");
        tyouhyouKensaku17.setKensakuKey2("kk202");
        tyouhyouKensaku17.setKensakuKey3("kk301");
        tyouhyouKensaku17.setKensakuKey4("kk401");
        tyouhyouKensaku17.setKensakuKey5("kk501");
        tyouhyouKensaku17.setSyoriYmd(BizDate.valueOf(20150515));

        AT_TyouhyouKensaku tyouhyouKensaku18 = new AT_TyouhyouKensaku();
        tyouhyouKensaku18.setUniqueId("UID18");
        tyouhyouKensaku18.setReportKey("TK00000001");
        tyouhyouKensaku18.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku18.setSubSystemId("SubID04");
        tyouhyouKensaku18.setKensakuKey1("kk103");
        tyouhyouKensaku18.setKensakuKey2("kk202");
        tyouhyouKensaku18.setKensakuKey3("kk301");
        tyouhyouKensaku18.setKensakuKey4("kk401");
        tyouhyouKensaku18.setKensakuKey5("kk501");
        tyouhyouKensaku18.setSyoriYmd(BizDate.valueOf(20150516));

        AT_TyouhyouKensaku tyouhyouKensaku19 = new AT_TyouhyouKensaku();
        tyouhyouKensaku19.setUniqueId("UID19");
        tyouhyouKensaku19.setReportKey("TK00000001");
        tyouhyouKensaku19.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku19.setSubSystemId("SubID04");
        tyouhyouKensaku19.setKensakuKey1("kk104");
        tyouhyouKensaku19.setKensakuKey2("kk202");
        tyouhyouKensaku19.setKensakuKey3("kk301");
        tyouhyouKensaku19.setKensakuKey4("kk401");
        tyouhyouKensaku19.setKensakuKey5("kk501");
        tyouhyouKensaku19.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku20 = new AT_TyouhyouKensaku();
        tyouhyouKensaku20.setUniqueId("UID20");
        tyouhyouKensaku20.setReportKey("TK00000001");
        tyouhyouKensaku20.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku20.setSubSystemId("SubID04");
        tyouhyouKensaku20.setKensakuKey1("kk105");
        tyouhyouKensaku20.setKensakuKey2("kk202");
        tyouhyouKensaku20.setKensakuKey3("kk301");
        tyouhyouKensaku20.setKensakuKey4("kk401");
        tyouhyouKensaku20.setKensakuKey5("kk501");
        tyouhyouKensaku20.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku21 = new AT_TyouhyouKensaku();
        tyouhyouKensaku21.setUniqueId("UID21");
        tyouhyouKensaku21.setReportKey("TK00000001");
        tyouhyouKensaku21.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku21.setSubSystemId("SubID04");
        tyouhyouKensaku21.setKensakuKey1("kk101");
        tyouhyouKensaku21.setKensakuKey2("kk201");
        tyouhyouKensaku21.setKensakuKey3("kk302");
        tyouhyouKensaku21.setKensakuKey4("kk401");
        tyouhyouKensaku21.setKensakuKey5("kk501");
        tyouhyouKensaku21.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku22 = new AT_TyouhyouKensaku();
        tyouhyouKensaku22.setUniqueId("UID22");
        tyouhyouKensaku22.setReportKey("TK00000001");
        tyouhyouKensaku22.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku22.setSubSystemId("SubID04");
        tyouhyouKensaku22.setKensakuKey1("kk101");
        tyouhyouKensaku22.setKensakuKey2("kk202");
        tyouhyouKensaku22.setKensakuKey3("kk302");
        tyouhyouKensaku22.setKensakuKey4("kk401");
        tyouhyouKensaku22.setKensakuKey5("kk501");
        tyouhyouKensaku22.setSyoriYmd(BizDate.valueOf(20150515));

        AT_TyouhyouKensaku tyouhyouKensaku23 = new AT_TyouhyouKensaku();
        tyouhyouKensaku23.setUniqueId("UID23");
        tyouhyouKensaku23.setReportKey("TK00000001");
        tyouhyouKensaku23.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku23.setSubSystemId("SubID04");
        tyouhyouKensaku23.setKensakuKey1("kk101");
        tyouhyouKensaku23.setKensakuKey2("kk203");
        tyouhyouKensaku23.setKensakuKey3("kk302");
        tyouhyouKensaku23.setKensakuKey4("kk401");
        tyouhyouKensaku23.setKensakuKey5("kk501");
        tyouhyouKensaku23.setSyoriYmd(BizDate.valueOf(20150516));

        AT_TyouhyouKensaku tyouhyouKensaku24 = new AT_TyouhyouKensaku();
        tyouhyouKensaku24.setUniqueId("UID24");
        tyouhyouKensaku24.setReportKey("TK00000001");
        tyouhyouKensaku24.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku24.setSubSystemId("SubID04");
        tyouhyouKensaku24.setKensakuKey1("kk101");
        tyouhyouKensaku24.setKensakuKey2("kk204");
        tyouhyouKensaku24.setKensakuKey3("kk302");
        tyouhyouKensaku24.setKensakuKey4("kk401");
        tyouhyouKensaku24.setKensakuKey5("kk501");
        tyouhyouKensaku24.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku25 = new AT_TyouhyouKensaku();
        tyouhyouKensaku25.setUniqueId("UID25");
        tyouhyouKensaku25.setReportKey("TK00000001");
        tyouhyouKensaku25.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku25.setSubSystemId("SubID04");
        tyouhyouKensaku25.setKensakuKey1("kk101");
        tyouhyouKensaku25.setKensakuKey2("kk205");
        tyouhyouKensaku25.setKensakuKey3("kk302");
        tyouhyouKensaku25.setKensakuKey4("kk401");
        tyouhyouKensaku25.setKensakuKey5("kk501");
        tyouhyouKensaku25.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku26 = new AT_TyouhyouKensaku();
        tyouhyouKensaku26.setUniqueId("UID26");
        tyouhyouKensaku26.setReportKey("TK00000001");
        tyouhyouKensaku26.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku26.setSubSystemId("SubID04");
        tyouhyouKensaku26.setKensakuKey1("kk101");
        tyouhyouKensaku26.setKensakuKey2("kk201");
        tyouhyouKensaku26.setKensakuKey3("kk301");
        tyouhyouKensaku26.setKensakuKey4("kk402");
        tyouhyouKensaku26.setKensakuKey5("kk501");
        tyouhyouKensaku26.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku27 = new AT_TyouhyouKensaku();
        tyouhyouKensaku27.setUniqueId("UID27");
        tyouhyouKensaku27.setReportKey("TK00000001");
        tyouhyouKensaku27.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku27.setSubSystemId("SubID04");
        tyouhyouKensaku27.setKensakuKey1("kk101");
        tyouhyouKensaku27.setKensakuKey2("kk201");
        tyouhyouKensaku27.setKensakuKey3("kk302");
        tyouhyouKensaku27.setKensakuKey4("kk402");
        tyouhyouKensaku27.setKensakuKey5("kk501");
        tyouhyouKensaku27.setSyoriYmd(BizDate.valueOf(20150515));

        AT_TyouhyouKensaku tyouhyouKensaku28 = new AT_TyouhyouKensaku();
        tyouhyouKensaku28.setUniqueId("UID28");
        tyouhyouKensaku28.setReportKey("TK00000001");
        tyouhyouKensaku28.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku28.setSubSystemId("SubID04");
        tyouhyouKensaku28.setKensakuKey1("kk101");
        tyouhyouKensaku28.setKensakuKey2("kk201");
        tyouhyouKensaku28.setKensakuKey3("kk303");
        tyouhyouKensaku28.setKensakuKey4("kk402");
        tyouhyouKensaku28.setKensakuKey5("kk501");
        tyouhyouKensaku28.setSyoriYmd(BizDate.valueOf(20150516));

        AT_TyouhyouKensaku tyouhyouKensaku29 = new AT_TyouhyouKensaku();
        tyouhyouKensaku29.setUniqueId("UID29");
        tyouhyouKensaku29.setReportKey("TK00000001");
        tyouhyouKensaku29.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku29.setSubSystemId("SubID04");
        tyouhyouKensaku29.setKensakuKey1("kk101");
        tyouhyouKensaku29.setKensakuKey2("kk201");
        tyouhyouKensaku29.setKensakuKey3("kk304");
        tyouhyouKensaku29.setKensakuKey4("kk402");
        tyouhyouKensaku29.setKensakuKey5("kk501");
        tyouhyouKensaku29.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku30 = new AT_TyouhyouKensaku();
        tyouhyouKensaku30.setUniqueId("UID30");
        tyouhyouKensaku30.setReportKey("TK00000001");
        tyouhyouKensaku30.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku30.setSubSystemId("SubID04");
        tyouhyouKensaku30.setKensakuKey1("kk101");
        tyouhyouKensaku30.setKensakuKey2("kk201");
        tyouhyouKensaku30.setKensakuKey3("kk305");
        tyouhyouKensaku30.setKensakuKey4("kk402");
        tyouhyouKensaku30.setKensakuKey5("kk501");
        tyouhyouKensaku30.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku31 = new AT_TyouhyouKensaku();
        tyouhyouKensaku31.setUniqueId("UID31");
        tyouhyouKensaku31.setReportKey("TK00000001");
        tyouhyouKensaku31.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku31.setSubSystemId("SubID04");
        tyouhyouKensaku31.setKensakuKey1("kk101");
        tyouhyouKensaku31.setKensakuKey2("kk201");
        tyouhyouKensaku31.setKensakuKey3("kk301");
        tyouhyouKensaku31.setKensakuKey4("kk401");
        tyouhyouKensaku31.setKensakuKey5("kk502");
        tyouhyouKensaku31.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku32 = new AT_TyouhyouKensaku();
        tyouhyouKensaku32.setUniqueId("UID32");
        tyouhyouKensaku32.setReportKey("TK00000001");
        tyouhyouKensaku32.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku32.setSubSystemId("SubID04");
        tyouhyouKensaku32.setKensakuKey1("kk101");
        tyouhyouKensaku32.setKensakuKey2("kk201");
        tyouhyouKensaku32.setKensakuKey3("kk301");
        tyouhyouKensaku32.setKensakuKey4("kk402");
        tyouhyouKensaku32.setKensakuKey5("kk502");
        tyouhyouKensaku32.setSyoriYmd(BizDate.valueOf(20150515));

        AT_TyouhyouKensaku tyouhyouKensaku33 = new AT_TyouhyouKensaku();
        tyouhyouKensaku33.setUniqueId("UID33");
        tyouhyouKensaku33.setReportKey("TK00000001");
        tyouhyouKensaku33.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku33.setSubSystemId("SubID04");
        tyouhyouKensaku33.setKensakuKey1("kk101");
        tyouhyouKensaku33.setKensakuKey2("kk201");
        tyouhyouKensaku33.setKensakuKey3("kk301");
        tyouhyouKensaku33.setKensakuKey4("kk403");
        tyouhyouKensaku33.setKensakuKey5("kk502");
        tyouhyouKensaku33.setSyoriYmd(BizDate.valueOf(20150516));

        AT_TyouhyouKensaku tyouhyouKensaku34 = new AT_TyouhyouKensaku();
        tyouhyouKensaku34.setUniqueId("UID34");
        tyouhyouKensaku34.setReportKey("TK00000001");
        tyouhyouKensaku34.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku34.setSubSystemId("SubID04");
        tyouhyouKensaku34.setKensakuKey1("kk101");
        tyouhyouKensaku34.setKensakuKey2("kk201");
        tyouhyouKensaku34.setKensakuKey3("kk301");
        tyouhyouKensaku34.setKensakuKey4("kk404");
        tyouhyouKensaku34.setKensakuKey5("kk502");
        tyouhyouKensaku34.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku35 = new AT_TyouhyouKensaku();
        tyouhyouKensaku35.setUniqueId("UID35");
        tyouhyouKensaku35.setReportKey("TK00000001");
        tyouhyouKensaku35.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku35.setSubSystemId("SubID04");
        tyouhyouKensaku35.setKensakuKey1("kk101");
        tyouhyouKensaku35.setKensakuKey2("kk201");
        tyouhyouKensaku35.setKensakuKey3("kk301");
        tyouhyouKensaku35.setKensakuKey4("kk405");
        tyouhyouKensaku35.setKensakuKey5("kk502");
        tyouhyouKensaku35.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku36 = new AT_TyouhyouKensaku();
        tyouhyouKensaku36.setUniqueId("UID36");
        tyouhyouKensaku36.setReportKey("TK00000001");
        tyouhyouKensaku36.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku36.setSubSystemId("SubID04");
        tyouhyouKensaku36.setKensakuKey1("kk102");
        tyouhyouKensaku36.setKensakuKey2("kk201");
        tyouhyouKensaku36.setKensakuKey3("kk301");
        tyouhyouKensaku36.setKensakuKey4("kk401");
        tyouhyouKensaku36.setKensakuKey5("kk501");
        tyouhyouKensaku36.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku37 = new AT_TyouhyouKensaku();
        tyouhyouKensaku37.setUniqueId("UID37");
        tyouhyouKensaku37.setReportKey("TK00000001");
        tyouhyouKensaku37.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku37.setSubSystemId("SubID04");
        tyouhyouKensaku37.setKensakuKey1("kk102");
        tyouhyouKensaku37.setKensakuKey2("kk201");
        tyouhyouKensaku37.setKensakuKey3("kk301");
        tyouhyouKensaku37.setKensakuKey4("kk401");
        tyouhyouKensaku37.setKensakuKey5("kk502");
        tyouhyouKensaku37.setSyoriYmd(BizDate.valueOf(20150515));

        AT_TyouhyouKensaku tyouhyouKensaku38 = new AT_TyouhyouKensaku();
        tyouhyouKensaku38.setUniqueId("UID38");
        tyouhyouKensaku38.setReportKey("TK00000001");
        tyouhyouKensaku38.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku38.setSubSystemId("SubID04");
        tyouhyouKensaku38.setKensakuKey1("kk102");
        tyouhyouKensaku38.setKensakuKey2("kk201");
        tyouhyouKensaku38.setKensakuKey3("kk301");
        tyouhyouKensaku38.setKensakuKey4("kk401");
        tyouhyouKensaku38.setKensakuKey5("kk503");
        tyouhyouKensaku38.setSyoriYmd(BizDate.valueOf(20150516));

        AT_TyouhyouKensaku tyouhyouKensaku39 = new AT_TyouhyouKensaku();
        tyouhyouKensaku39.setUniqueId("UID39");
        tyouhyouKensaku39.setReportKey("TK00000001");
        tyouhyouKensaku39.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku39.setSubSystemId("SubID04");
        tyouhyouKensaku39.setKensakuKey1("kk102");
        tyouhyouKensaku39.setKensakuKey2("kk201");
        tyouhyouKensaku39.setKensakuKey3("kk301");
        tyouhyouKensaku39.setKensakuKey4("kk401");
        tyouhyouKensaku39.setKensakuKey5("kk504");
        tyouhyouKensaku39.setSyoriYmd(BizDate.valueOf(20150514));

        AT_TyouhyouKensaku tyouhyouKensaku40 = new AT_TyouhyouKensaku();
        tyouhyouKensaku40.setUniqueId("UID40");
        tyouhyouKensaku40.setReportKey("TK00000001");
        tyouhyouKensaku40.setSyoruiCd(C_SyoruiCdKbn.HK_SHRMESS);
        tyouhyouKensaku40.setSubSystemId("SubID04");
        tyouhyouKensaku40.setKensakuKey1("kk102");
        tyouhyouKensaku40.setKensakuKey2("kk201");
        tyouhyouKensaku40.setKensakuKey3("kk301");
        tyouhyouKensaku40.setKensakuKey4("kk401");
        tyouhyouKensaku40.setKensakuKey5("kk505");
        tyouhyouKensaku40.setSyoriYmd(BizDate.valueOf(20150514));

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
        baseDomManager.insert(tyouhyouKensaku16);
        baseDomManager.insert(tyouhyouKensaku17);
        baseDomManager.insert(tyouhyouKensaku18);
        baseDomManager.insert(tyouhyouKensaku19);
        baseDomManager.insert(tyouhyouKensaku20);
        baseDomManager.insert(tyouhyouKensaku21);
        baseDomManager.insert(tyouhyouKensaku22);
        baseDomManager.insert(tyouhyouKensaku23);
        baseDomManager.insert(tyouhyouKensaku24);
        baseDomManager.insert(tyouhyouKensaku25);
        baseDomManager.insert(tyouhyouKensaku26);
        baseDomManager.insert(tyouhyouKensaku27);
        baseDomManager.insert(tyouhyouKensaku28);
        baseDomManager.insert(tyouhyouKensaku29);
        baseDomManager.insert(tyouhyouKensaku30);
        baseDomManager.insert(tyouhyouKensaku31);
        baseDomManager.insert(tyouhyouKensaku32);
        baseDomManager.insert(tyouhyouKensaku33);
        baseDomManager.insert(tyouhyouKensaku34);
        baseDomManager.insert(tyouhyouKensaku35);
        baseDomManager.insert(tyouhyouKensaku36);
        baseDomManager.insert(tyouhyouKensaku37);
        baseDomManager.insert(tyouhyouKensaku38);
        baseDomManager.insert(tyouhyouKensaku39);
        baseDomManager.insert(tyouhyouKensaku40);

        AM_SyoruiZokusei aM_SyoruiZokusei1 = new AM_SyoruiZokusei(C_SyoruiCdKbn.HK_SHRMESS);
        baseDomManager.insert(aM_SyoruiZokusei1);
        AM_SyoruiZokusei aM_SyoruiZokusei2 = new AM_SyoruiZokusei(C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI);
        baseDomManager.insert(aM_SyoruiZokusei2);

    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        ExDBEntityManager em = SWAKInjector.getInstance(ExDBEntityManager.class);
        String str = "delete from AT_TyouhyouKensaku";

        em.createNativeSQL(str).executeUpdate();

        String str1 = "delete from AM_SyoruiZokusei";

        em.createNativeSQL(str1).executeUpdate();

    }


    @Test
    @TestOrder(10)
    public void noResult1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID20", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(0, tyouhyouKensakuLst.size());

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst2 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150520), null);
        Assert.assertEquals(0, tyouhyouKensakuLst2.size());

    }

    @Test
    @TestOrder(20)
    public void normal1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID01", C_SyoruiCdKbn.CM_BATCH_GKFBSOUKINMEISAI,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(1, tyouhyouKensakuLst.size());
        Assert.assertEquals("UID04", tyouhyouKensakuLst.get(0).getUniqueId());

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst2 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), null);
        Assert.assertEquals(1, tyouhyouKensakuLst2.size());
        Assert.assertEquals("UID01", tyouhyouKensakuLst2.get(0).getUniqueId());

    }

    @Test
    @TestOrder(30)
    public void normal2() {

        Map<String,String> map1 = new HashMap<String,String>();
        map1.put($("UID03"), "1");
        map1.put($("UID02"), "1");
        map1.put($("UID01"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID01", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));

        for(AT_TyouhyouKensaku tyouhyouKensaku:tyouhyouKensakuLst){
            map1.remove($(tyouhyouKensaku.getUniqueId()));
        }
        Assert.assertEquals(3, tyouhyouKensakuLst.size());
        assertTrue(map1.isEmpty());

        Map<String,String> map2 = new HashMap<String,String>();
        map2.put($("UID13"), "1");
        map2.put($("UID14"), "1");
        map2.put($("UID15"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst2 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID03", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), null);

        for(AT_TyouhyouKensaku tyouhyouKensaku2:tyouhyouKensakuLst2){
            map2.remove($(tyouhyouKensaku2.getUniqueId()));
        }

        Assert.assertEquals(3, tyouhyouKensakuLst2.size());
        assertTrue(map2.isEmpty());

    }

    @Test
    @TestOrder(40)
    public void normal5() {

        Map<String,String> map1 = new HashMap<String,String>();
        map1.put($("UID18"), "1");
        map1.put($("UID17"), "1");
        map1.put($("UID16"), "1");
        map1.put($("UID19"), "1");
        map1.put($("UID20"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID04", C_SyoruiCdKbn.HK_SHRMESS,
            "", "kk202","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));

        for(AT_TyouhyouKensaku tyouhyouKensaku1:tyouhyouKensakuLst){
            map1.remove($(tyouhyouKensaku1.getUniqueId()));
        }

        Assert.assertEquals(5, tyouhyouKensakuLst.size());
        assertTrue(map1.isEmpty());

        Map<String,String> map2 = new HashMap<String,String>();
        map2.put($("UID23"), "1");
        map2.put($("UID22"), "1");
        map2.put($("UID21"), "1");
        map2.put($("UID24"), "1");
        map2.put($("UID25"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst2 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID04", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "","kk302", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));

        for(AT_TyouhyouKensaku tyouhyouKensaku2:tyouhyouKensakuLst2){
            map2.remove($(tyouhyouKensaku2.getUniqueId()));
        }

        Assert.assertEquals(5, tyouhyouKensakuLst2.size());
        assertTrue(map2.isEmpty());

        Map<String,String> map3 = new HashMap<String,String>();
        map3.put($("UID28"), "1");
        map3.put($("UID27"), "1");
        map3.put($("UID26"), "1");
        map3.put($("UID29"), "1");
        map3.put($("UID30"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst3 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID04", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","", "kk402", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));

        for(AT_TyouhyouKensaku tyouhyouKensaku3:tyouhyouKensakuLst3){
            map3.remove($(tyouhyouKensaku3.getUniqueId()));
        }

        Assert.assertEquals(5, tyouhyouKensakuLst3.size());
        assertTrue(map3.isEmpty());

        Map<String,String> map4 = new HashMap<String,String>();
        map4.put($("UID33"), "1");
        map4.put($("UID32"), "1");
        map4.put($("UID31"), "1");
        map4.put($("UID34"), "1");
        map4.put($("UID35"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst4 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID04", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "", "kk502", BizDate.valueOf(20150514), BizDate.valueOf(20150516));

        for(AT_TyouhyouKensaku tyouhyouKensaku4:tyouhyouKensakuLst4){
            map4.remove($(tyouhyouKensaku4.getUniqueId()));
        }

        Assert.assertEquals(5, tyouhyouKensakuLst4.size());
        assertTrue(map4.isEmpty());

        Map<String,String> map5 = new HashMap<String,String>();
        map5.put($("UID38"), "1");
        map5.put($("UID37"), "1");
        map5.put($("UID36"), "1");
        map5.put($("UID39"), "1");
        map5.put($("UID40"), "1");

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst5 = bizDomManager.getTyouhyouKensakusByKensakuInfo("SubID04", C_SyoruiCdKbn.HK_SHRMESS,
            "kk102", "kk201","kk301", "kk401", "", BizDate.valueOf(20150514), BizDate.valueOf(20150516));

        for(AT_TyouhyouKensaku tyouhyouKensaku5:tyouhyouKensakuLst5){
            map5.remove($(tyouhyouKensaku5.getUniqueId()));
        }

        Assert.assertEquals(5, tyouhyouKensakuLst5.size());
        assertTrue(map5.isEmpty());


    }

    @Test
    @TestOrder(130)
    public void blankCondition1() {

        List<AT_TyouhyouKensaku> tyouhyouKensakuLst = bizDomManager.getTyouhyouKensakusByKensakuInfo("", C_SyoruiCdKbn.HK_SHRMESS,
            "kk101", "kk201","kk301", "kk401", "kk501", BizDate.valueOf(20150514), BizDate.valueOf(20150516));
        Assert.assertEquals(0, tyouhyouKensakuLst.size());
    }
}
