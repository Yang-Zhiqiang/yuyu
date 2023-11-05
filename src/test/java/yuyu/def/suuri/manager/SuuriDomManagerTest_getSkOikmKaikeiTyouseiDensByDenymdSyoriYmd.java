package yuyu.def.suuri.manager;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.ExDBResults;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_DensyoriKbn;
import yuyu.def.classification.C_DensysKbn;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_TantouCdKbn;
import yuyu.def.classification.C_TekiyouKbn;
import yuyu.def.db.entity.BM_KanjyouKamoku;
import yuyu.def.db.entity.ST_SkOikmKaikei;
import yuyu.def.suuri.result.bean.SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * SuuriDomManagerクラスの、<br />
 * getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd() メソッドのテストクラスです。
 */
@RunWith(OrderedRunner.class)
public class SuuriDomManagerTest_getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd {

    @Inject
    SuuriDomManager suuriDomManager;

    @BeforeClass
    @Transactional
    public static void preProcess() {

        deleteTestSubData();

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);


        ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> beans = suuriDomManager.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate.valueOf(20160301), BizDate.valueOf(20160301));

        int iCount = 0;
        for (SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean SKTDbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);

        insertSubData();
    }

    @Transactional
    public static void insertSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);

        ST_SkOikmKaikei skOikmKaikei1 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A110", 10);
        skOikmKaikei1.setMosno("791112220");
        skOikmKaikei1.setHuridenatesakicd("150");
        skOikmKaikei1.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei1.setDenymd(BizDate.valueOf(20170301));
        skOikmKaikei1.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmKaikei1.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        skOikmKaikei1.setSuitoubumoncd("100");
        skOikmKaikei1.setDenyenkagk(BizCurrency.valueOf(10));
        skOikmKaikei1.setSyoriYmd(BizDate.valueOf(20170301));
        skOikmKaikei1.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei1.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei1.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei1.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei1);

        ST_SkOikmKaikei skOikmKaikei2 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A111", 10);
        skOikmKaikei2.setMosno("791112220");
        skOikmKaikei2.setHuridenatesakicd("150");
        skOikmKaikei2.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei2.setDenymd(BizDate.valueOf(20170201));
        skOikmKaikei2.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei2.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei2.setSuitoubumoncd("100");
        skOikmKaikei2.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei2.setSyoriYmd(BizDate.valueOf(20170301));
        skOikmKaikei2.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei2.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei2.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei2.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei2);

        ST_SkOikmKaikei skOikmKaikei3 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A112", 10);
        skOikmKaikei3.setMosno("791112220");
        skOikmKaikei3.setHuridenatesakicd("150");
        skOikmKaikei3.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei3.setDenymd(BizDate.valueOf(20170301));
        skOikmKaikei3.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei3.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei3.setSuitoubumoncd("100");
        skOikmKaikei3.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei3.setSyoriYmd(BizDate.valueOf(20170401));
        skOikmKaikei3.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei3.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei3.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei3.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei3);

        ST_SkOikmKaikei skOikmKaikei4 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A113", 10);
        skOikmKaikei4.setMosno("791112220");
        skOikmKaikei4.setHuridenatesakicd("150");
        skOikmKaikei4.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei4.setDenymd(BizDate.valueOf(20170301));
        skOikmKaikei4.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei4.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei4.setSuitoubumoncd("100");
        skOikmKaikei4.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei4.setSyoriYmd(BizDate.valueOf(20170301));
        skOikmKaikei4.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei4.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei4.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei4.setDensyorikbn(C_DensyoriKbn.valueOf("2010"));

        suuriDomManager.insert(skOikmKaikei4);

        ST_SkOikmKaikei skOikmKaikei5 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A114", 10);
        skOikmKaikei5.setMosno("791112253");
        skOikmKaikei5.setHuridenatesakicd("150");
        skOikmKaikei5.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei5.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei5.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei5.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei5.setSuitoubumoncd("100");
        skOikmKaikei5.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei5.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei5.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei5.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei5.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei5.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei5);

        ST_SkOikmKaikei skOikmKaikei6 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A115", 10);
        skOikmKaikei6.setMosno("791112246");
        skOikmKaikei6.setHuridenatesakicd("150");
        skOikmKaikei6.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei6.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei6.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei6.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei6.setSuitoubumoncd("100");
        skOikmKaikei6.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei6.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei6.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei6.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei6.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei6.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei6);

        ST_SkOikmKaikei skOikmKaikei7 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A116", 10);
        skOikmKaikei7.setMosno("791112238");
        skOikmKaikei7.setHuridenatesakicd("150");
        skOikmKaikei7.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei7.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei7.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei7.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        skOikmKaikei7.setSuitoubumoncd("100");
        skOikmKaikei7.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei7.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei7.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei7.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei7.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei7.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei7);

        ST_SkOikmKaikei skOikmKaikei8 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A117", 10);
        skOikmKaikei8.setMosno("791112238");
        skOikmKaikei8.setHuridenatesakicd("150");
        skOikmKaikei8.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei8.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei8.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei8.setKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY);
        skOikmKaikei8.setSuitoubumoncd("100");
        skOikmKaikei8.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei8.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei8.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei8.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei8.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei8.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei8);

        ST_SkOikmKaikei skOikmKaikei9 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A118", 10);
        skOikmKaikei9.setMosno("791112238");
        skOikmKaikei9.setHuridenatesakicd("150");
        skOikmKaikei9.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei9.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei9.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei9.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei9.setSuitoubumoncd("100");
        skOikmKaikei9.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei9.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei9.setSeg1cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei9.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei9.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei9.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei9);

        ST_SkOikmKaikei skOikmKaikei10 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A119", 10);
        skOikmKaikei10.setMosno("791112238");
        skOikmKaikei10.setHuridenatesakicd("150");
        skOikmKaikei10.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei10.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei10.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei10.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei10.setSuitoubumoncd("100");
        skOikmKaikei10.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei10.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei10.setSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        skOikmKaikei10.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei10.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei10.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei10);

        ST_SkOikmKaikei skOikmKaikei11 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A120", 10);
        skOikmKaikei11.setMosno("791112238");
        skOikmKaikei11.setHuridenatesakicd("150");
        skOikmKaikei11.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei11.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei11.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei11.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei11.setSuitoubumoncd("100");
        skOikmKaikei11.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei11.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei11.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei11.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei11.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei11.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei11);

        ST_SkOikmKaikei skOikmKaikei12 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A121", 10);
        skOikmKaikei12.setMosno("791112238");
        skOikmKaikei12.setHuridenatesakicd("140");
        skOikmKaikei12.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei12.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei12.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei12.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei12.setSuitoubumoncd("100");
        skOikmKaikei12.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei12.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei12.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei12.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei12.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei12.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei12);

        ST_SkOikmKaikei skOikmKaikei13 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A122", 10);
        skOikmKaikei13.setMosno("791112238");
        skOikmKaikei13.setHuridenatesakicd("130");
        skOikmKaikei13.setTantocd(C_TantouCdKbn.IMUIMU);
        skOikmKaikei13.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei13.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei13.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei13.setSuitoubumoncd("100");
        skOikmKaikei13.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei13.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei13.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei13.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei13.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei13.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei13);

        ST_SkOikmKaikei skOikmKaikei14 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A123", 10);
        skOikmKaikei14.setMosno("791112238");
        skOikmKaikei14.setHuridenatesakicd("130");
        skOikmKaikei14.setTantocd(C_TantouCdKbn.KIKAKUIMU);
        skOikmKaikei14.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei14.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei14.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei14.setSuitoubumoncd("100");
        skOikmKaikei14.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei14.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei14.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei14.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei14.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei14.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei14);

        ST_SkOikmKaikei skOikmKaikei15 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A124", 10);
        skOikmKaikei15.setMosno("791112238");
        skOikmKaikei15.setHuridenatesakicd("130");
        skOikmKaikei15.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei15.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei15.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei15.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei15.setSuitoubumoncd("120");
        skOikmKaikei15.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei15.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei15.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei15.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei15.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei15.setDensyorikbn(C_DensyoriKbn.FP_GNKHRKM);

        suuriDomManager.insert(skOikmKaikei15);

        ST_SkOikmKaikei skOikmKaikei16 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A125", 10);
        skOikmKaikei16.setMosno("791112238");
        skOikmKaikei16.setHuridenatesakicd("130");
        skOikmKaikei16.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei16.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei16.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei16.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei16.setSuitoubumoncd("110");
        skOikmKaikei16.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei16.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei16.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei16.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei16.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei16.setDensyorikbn(C_DensyoriKbn.FP_ONLINENYKN);

        suuriDomManager.insert(skOikmKaikei16);

        ST_SkOikmKaikei skOikmKaikei17 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A126", 10);
        skOikmKaikei17.setMosno("791112238");
        skOikmKaikei17.setHuridenatesakicd("130");
        skOikmKaikei17.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei17.setDenymd(BizDate.valueOf(20160310));
        skOikmKaikei17.setTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        skOikmKaikei17.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei17.setSuitoubumoncd("100");
        skOikmKaikei17.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei17.setSyoriYmd(BizDate.valueOf(20160210));
        skOikmKaikei17.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei17.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei17.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei17.setDensyorikbn(C_DensyoriKbn.SEIRITU);

        suuriDomManager.insert(skOikmKaikei17);

        ST_SkOikmKaikei skOikmKaikei18 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A127", 10);
        skOikmKaikei18.setMosno("791112238");
        skOikmKaikei18.setHuridenatesakicd("130");
        skOikmKaikei18.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei18.setDenymd(BizDate.valueOf(20160301));
        skOikmKaikei18.setTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        skOikmKaikei18.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei18.setSuitoubumoncd("100");
        skOikmKaikei18.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei18.setSyoriYmd(BizDate.valueOf(20160210));
        skOikmKaikei18.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei18.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei18.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei18.setDensyorikbn(C_DensyoriKbn.FP_HNKNKB);

        suuriDomManager.insert(skOikmKaikei18);

        ST_SkOikmKaikei skOikmKaikei19 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A128", 10);
        skOikmKaikei19.setMosno("791112238");
        skOikmKaikei19.setHuridenatesakicd("130");
        skOikmKaikei19.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei19.setDenymd(BizDate.valueOf(20160310));
        skOikmKaikei19.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmKaikei19.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei19.setSuitoubumoncd("100");
        skOikmKaikei19.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei19.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei19.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei19.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei19.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei19.setDensyorikbn(C_DensyoriKbn.FP_KKN);

        suuriDomManager.insert(skOikmKaikei19);

        ST_SkOikmKaikei skOikmKaikei20 = new ST_SkOikmKaikei(C_DensysKbn.SKEI, "A129", 10);
        skOikmKaikei20.setMosno("791112261");
        skOikmKaikei20.setHuridenatesakicd("130");
        skOikmKaikei20.setTantocd(C_TantouCdKbn.IMUSATEI);
        skOikmKaikei20.setDenymd(BizDate.valueOf(20160310));
        skOikmKaikei20.setTaisyakukbn(C_TaisyakuKbn.BLNK);
        skOikmKaikei20.setKanjyoukmkcd(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        skOikmKaikei20.setSuitoubumoncd("100");
        skOikmKaikei20.setDenyenkagk(BizCurrency.valueOf(10,BizCurrencyTypes.YEN));
        skOikmKaikei20.setSyoriYmd(BizDate.valueOf(20160301));
        skOikmKaikei20.setSeg1cd(C_Segcd.BLNK);
        skOikmKaikei20.setNaibukeiyakukbn(C_NaibuKeiyakuKbn.BLNK);
        skOikmKaikei20.setTekiyoukbn(C_TekiyouKbn.BLNK);
        skOikmKaikei20.setDensyorikbn(C_DensyoriKbn.FP_CREDITNYKN);

        suuriDomManager.insert(skOikmKaikei20);

        BM_KanjyouKamoku kanjyouKamoku1 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD);
        kanjyouKamoku1.setDenkanjokamokucd("10000");

        bizDomManager.insert(kanjyouKamoku1);

        BM_KanjyouKamoku kanjyouKamoku2 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO);
        kanjyouKamoku2.setDenkanjokamokucd("10002");

        bizDomManager.insert(kanjyouKamoku2);

        BM_KanjyouKamoku kanjyouKamoku3 = new BM_KanjyouKamoku(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD);
        kanjyouKamoku3.setDenkanjokamokucd("10004");

        bizDomManager.insert(kanjyouKamoku3);
    }

    @Test
    @TestOrder(10)
    public void noResult1(){

        ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> beans = suuriDomManager.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate.valueOf(20180301), BizDate.valueOf(20160301));

        int iCount = 0;
        for (SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean SKTDbean : beans) {
            iCount++;
        }
        Assert.assertEquals(0, iCount);
    }

    @Test
    @TestOrder(20)
    public void normal1(){

        ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> beans = suuriDomManager.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate.valueOf(20170301), BizDate.valueOf(20170301));

        int iCount = 0;
        for (SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean SKTDbean : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112220", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_AUD, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10004", SKTDbean.getDenkanjokamokucd());
            }
        }
        Assert.assertEquals(1, iCount);
    }

    @Test
    @TestOrder(30)
    public void normal2(){

        ExDBResults<SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean> beans = suuriDomManager.getSkOikmKaikeiTyouseiDensByDenymdSyoriYmd(BizDate.valueOf(20160301), BizDate.valueOf(20160301));

        int iCount = 0;
        for (SkOikmKaikeiTyouseiDensByDenymdSyoriYmdBean SKTDbean : beans) {
            iCount++;

            if (1 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (2 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (3 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KASIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (4 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("110", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (5 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("120", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (6 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.KIKAKUIMU, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (7 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUIMU, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (8 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("140", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (9 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (10 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (11 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (12 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_JPY, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals(null, SKTDbean.getDenkanjokamokucd());
            }

            if (13 == iCount) {
                Assert.assertEquals("791112238", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.HOKENKEIYAKU_SYOKAI_GAIHO_USD, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10000", SKTDbean.getDenkanjokamokucd());
            }

            if (14 == iCount) {
                Assert.assertEquals("791112246", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (15 == iCount) {
                Assert.assertEquals("791112253", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.KARIKATA, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI, SKTDbean.getSeg1cd());
                Assert.assertEquals("150", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }

            if (16 == iCount) {
                Assert.assertEquals("791112261", SKTDbean.getMosno());
                Assert.assertEquals(C_Kanjyoukmkcd.SONOTAKARIBARAIKIN_GAIHO, SKTDbean.getKanjyoukmkcd());
                Assert.assertEquals(C_TaisyakuKbn.BLNK, SKTDbean.getTaisyakukbn());
                Assert.assertEquals(C_NaibuKeiyakuKbn.BLNK, SKTDbean.getNaibukeiyakukbn());
                Assert.assertEquals(C_TekiyouKbn.BLNK, SKTDbean.getTekiyoukbn());
                Assert.assertEquals(C_Segcd.BLNK, SKTDbean.getSeg1cd());
                Assert.assertEquals("130", SKTDbean.getHuridenatesakicd());
                Assert.assertEquals(C_TantouCdKbn.IMUSATEI, SKTDbean.getTantocd());
                Assert.assertEquals("100", SKTDbean.getSuitoubumoncd());
                Assert.assertEquals(BizCurrency.valueOf(10,BizCurrencyTypes.YEN), SKTDbean.getDenyenkagk());
                Assert.assertEquals("10002", SKTDbean.getDenkanjokamokucd());
            }
        }
        Assert.assertEquals(16, iCount);

    }

    @Transactional
    public static void deleteTestSubData() {

        SuuriDomManager suuriDomManager = SWAKInjector.getInstance(SuuriDomManager.class);
        List<ST_SkOikmKaikei> skOikmKaikeiList = suuriDomManager.getAllSkOikmKaikei();
        if(skOikmKaikeiList.size() > 0){
            suuriDomManager.delete(skOikmKaikeiList);
        }
        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        List<BM_KanjyouKamoku> kanjyouKamokuList = bizDomManager.getAllKanjyouKamoku();
        if(kanjyouKamokuList.size() > 0){
            bizDomManager.delete(kanjyouKamokuList);
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {
        deleteTestSubData();
    }
}
