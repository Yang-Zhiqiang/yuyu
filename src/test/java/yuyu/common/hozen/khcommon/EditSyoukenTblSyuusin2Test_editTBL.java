package yuyu.common.hozen.khcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.siharai.sicommon.CalcHkShrKngk;
import yuyu.common.siharai.sicommon.CalcHkShrKngkMockForHozen;
import yuyu.common.siharai.sicommon.CalcJdkghkKngk;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkMockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HokenkinsyuruiKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_InsizeiShryouhiKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SiinKbn;
import yuyu.def.classification.C_StdrsktkyhnkKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tkhukaumu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UktsyuKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 保険証券TBL編集（終身２）クラスのメソッド {@link EditSyoukenTblSyuusin2#editTBL(IT_HokenSyouken,IT_KykKihon,IT_KykSya,IT_HhknSya,List,List,IT_KykSonotaTkyk,IT_KykUkt,List,EditHokenSyoukenParam,BizDate,C_KjkhukaKbn,C_UmuKbn,int,BM_SyouhnZokusei)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblSyuusin2Test_editTBL {

    @Inject
    private EditSyoukenTblSyuusin2 editSyoukenTblSyuusin;

    @Inject
    private BizDomManager manager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private EditHokenSyoukenParam editHokenSyoukenParam;

    private static final int SINKEIYAKUHOKENSYOUKEN = 1;

    private static final int SAIHAKKOUHOKENSYOUKEN = 2;

    private final static String fileName = "UT-SP_単体テスト仕様書_保険証券TBL編集（終身２）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanKijyungk.class).to(KeisanKijyungkMockForHozen.class);
                bind(CalcHkShrKngk.class).to(CalcHkShrKngkMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
                bind(CalcJdkghkKngk.class).to(CalcJdkghkKngkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanKijyungkMockForHozen.caller = EditSyoukenTblSyuusin2Test_editTBL.class;
        CalcHkShrKngkMockForHozen.caller = EditSyoukenTblSyuusin2Test_editTBL.class;
        KeisanGaikakanzanMockForHozen.caller = EditSyoukenTblSyuusin2Test_editTBL.class;
        CalcJdkghkKngkMockForHozen.caller = EditSyoukenTblSyuusin2Test_editTBL.class;

    }

    @AfterClass
    public static void testClear() {
        KeisanKijyungkMockForHozen.caller = null;
        CalcHkShrKngkMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        CalcJdkghkKngkMockForHozen.caller = null;

        KeisanKijyungkMockForHozen.SYORIPTN = null;
        CalcHkShrKngkMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
        CalcJdkghkKngkMockForHozen.SYORIPTN = null;

        MockObjectManager.initialize();
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblSyuusin2Test_editTBL.class, fileName, sheetName);
            testDataMaker.insDataByDataId("データ001", testDataAndTblMap);
        } catch (TestDataMakerException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        hozenDomManager.delete(hozenDomManager.getAllKykKihon());

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllSyouhnZokusei());
        bizDomManager.delete(bizDomManager.getAllDairiten());
        bizDomManager.delete(bizDomManager.getAllTantouCd());
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(10)
    public void testEditTBL_A1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000019");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;
        try {
            editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
                kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
                gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        } catch (Exception e) {

            exDateEquals((BizDate) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 0),
                BizDate.valueOf(20170801), "保険料領収日");
            exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 1),
                BizCurrency.valueOf(10000), "領収金額");
            exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 2),
                BizCurrency.valueOf(20000), "保険料");
            exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 3),
                C_Tuukasyu.USD, "契約通貨種類");
            exClassificationEquals((C_Tkhukaumu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 4),
                C_Tkhukaumu.HUKA, "円入金特約付加区分");

            exStringEquals(e.getMessage(), "システム整合性エラーです。基準金額が取得できませんでした。", "エラーメッセージ");

            throw e;
        }
    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000020");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 0),
            BizDate.valueOf(20170801), "保険料領収日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(10000), "領収金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 2),
            BizCurrency.valueOf(20000), "保険料");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 3),
            C_Tuukasyu.AUD, "契約通貨種類");
        exClassificationEquals((C_Tkhukaumu) MockObjectManager.getArgument(KeisanKijyungkMockForHozen.class, "exec", 0, 4),
            C_Tkhukaumu.NONE, "円入金特約付加区分");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000031");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000042");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(21003), "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000053");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(31004), "解約返戻金円換算一時払保険料");
    }


    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000064");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }



    @Test
    @TestOrder(70)
    public void testEditTBL_B1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000112");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02026", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02023", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02490", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd8(), null, "表示欄左メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd9(), null, "表示欄左メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd10(), null, "表示欄左メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd11(), null, "表示欄左メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd12(), null, "表示欄左メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd13(), null, "表示欄左メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd14(), null, "表示欄左メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd15(), null, "表示欄左メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd16(), null, "表示欄左メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd17(), null, "表示欄左メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd18(), null, "表示欄左メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd19(), null, "表示欄左メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd20(), null, "表示欄左メッセージコード２０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02511", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd3(), null, "表示欄右メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd4(), null, "表示欄右メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd5(), null, "表示欄右メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd6(), null, "表示欄右メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd7(), null, "表示欄右メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd8(), null, "表示欄右メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd9(), null, "表示欄右メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd10(), null, "表示欄右メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd11(), null, "表示欄右メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd12(), null, "表示欄右メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd13(), null, "表示欄右メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd14(), null, "表示欄右メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd15(), null, "表示欄右メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd16(), null, "表示欄右メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd17(), null, "表示欄右メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd18(), null, "表示欄右メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd19(), null, "表示欄右メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd20(), null, "表示欄右メッセージコード２０");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180808), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.1), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(1.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20271031), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(80)
    public void testEditTBL_B2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000123");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02026", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02023", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02051", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "02060", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd8(), null, "表示欄左メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd9(), null, "表示欄左メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd10(), null, "表示欄左メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd11(), null, "表示欄左メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd12(), null, "表示欄左メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd13(), null, "表示欄左メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd14(), null, "表示欄左メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd15(), null, "表示欄左メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd16(), null, "表示欄左メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd17(), null, "表示欄左メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd18(), null, "表示欄左メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd19(), null, "表示欄左メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd20(), null, "表示欄左メッセージコード２０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd3(), null, "表示欄右メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd4(), null, "表示欄右メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd5(), null, "表示欄右メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd6(), null, "表示欄右メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd7(), null, "表示欄右メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd8(), null, "表示欄右メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd9(), null, "表示欄右メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd10(), null, "表示欄右メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd11(), null, "表示欄右メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd12(), null, "表示欄右メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd13(), null, "表示欄右メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd14(), null, "表示欄右メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd15(), null, "表示欄右メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd16(), null, "表示欄右メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd17(), null, "表示欄右メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd18(), null, "表示欄右メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd19(), null, "表示欄右メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd20(), null, "表示欄右メッセージコード２０");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), null, "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(1.2), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(1.2), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), BizNumber.valueOf(1.02), "表示欄市場価格調整用利率");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20271031), "死亡保障第１保険期間年月日（至）");

    }

    @Test
    @TestOrder(70)
    public void testEditTBL_B3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02023", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(),null, "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd8(), null, "表示欄左メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd9(), null, "表示欄左メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd10(), null, "表示欄左メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd11(), null, "表示欄左メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd12(), null, "表示欄左メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd13(), null, "表示欄左メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd14(), null, "表示欄左メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd15(), null, "表示欄左メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd16(), null, "表示欄左メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd17(), null, "表示欄左メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd18(), null, "表示欄左メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd19(), null, "表示欄左メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd20(), null, "表示欄左メッセージコード２０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02511", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "02520", "表示欄右メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd3(), null, "表示欄右メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd4(), null, "表示欄右メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd5(), null, "表示欄右メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd6(), null, "表示欄右メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd7(), null, "表示欄右メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd8(), null, "表示欄右メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd9(), null, "表示欄右メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd10(), null, "表示欄右メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd11(), null, "表示欄右メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd12(), null, "表示欄右メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd13(), null, "表示欄右メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd14(), null, "表示欄右メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd15(), null, "表示欄右メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd16(), null, "表示欄右メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd17(), null, "表示欄右メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd18(), null, "表示欄右メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd19(), null, "表示欄右メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd20(), null, "表示欄右メッセージコード２０");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20170601), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.1), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), null, "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(), null, "表示欄市場価格調整用利率");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), null, "死亡保障第１保険期間年月日（至）");


    }

    @Test
    @TestOrder(80)
    public void testEditTBL_B4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02053", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), null, "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd8(), null, "表示欄左メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd9(), null, "表示欄左メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd10(), null, "表示欄左メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd11(), null, "表示欄左メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd12(), null, "表示欄左メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd13(), null, "表示欄左メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd14(), null, "表示欄左メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd15(), null, "表示欄左メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd16(), null, "表示欄左メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd17(), null, "表示欄左メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd18(), null, "表示欄左メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd19(), null, "表示欄左メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd20(), null, "表示欄左メッセージコード２０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd3(), null, "表示欄右メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd4(), null, "表示欄右メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd5(), null, "表示欄右メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd6(), null, "表示欄右メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd7(), null, "表示欄右メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd8(), null, "表示欄右メッセージコード８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd9(), null, "表示欄右メッセージコード９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd10(), null, "表示欄右メッセージコード１０");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd11(), null, "表示欄右メッセージコード１１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd12(), null, "表示欄右メッセージコード１２");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd13(), null, "表示欄右メッセージコード１３");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd14(), null, "表示欄右メッセージコード１４");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd15(), null, "表示欄右メッセージコード１５");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd16(), null, "表示欄右メッセージコード１６");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd17(), null, "表示欄右メッセージコード１７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd18(), null, "表示欄右メッセージコード１８");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd19(), null, "表示欄右メッセージコード１９");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd20(), null, "表示欄右メッセージコード２０");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), null, "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.1), "表示欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), null, "その他内容欄積立利率");
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0.1), "その他内容欄予定利率");
        exBizCalcbleEquals(hokenSyouken.getHyoujiransjkkktusirrt(),null, "表示欄市場価格調整用利率");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), null, "死亡保障第１保険期間年月日（至）");
    }


    @Test
    @TestOrder(130)
    public void testEditTBL_C1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000215");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));


        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn1(), null, "（証券）受取人見出し区分１");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn2(), null, "（証券）受取人見出し区分２");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn3(), null, "（証券）受取人見出し区分３");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn4(), null, "（証券）受取人見出し区分４");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn5(), null, "（証券）受取人見出し区分５");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn6(), null, "（証券）受取人見出し区分６");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn7(), null, "（証券）受取人見出し区分７");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn8(), null, "（証券）受取人見出し区分８");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn9(), null, "（証券）受取人見出し区分９");
        exClassificationEquals(hokenSyouken.getSyoukenuktmidasikbn10(), null, "（証券）受取人見出し区分１０");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn1(), null, "（証券）受取人区分１");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn2(), null, "（証券）受取人区分２");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn3(), null, "（証券）受取人区分３");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn4(), null, "（証券）受取人区分４");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn5(), null, "（証券）受取人区分５");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn6(), null, "（証券）受取人区分６");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn7(), null, "（証券）受取人区分７");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn8(), null, "（証券）受取人区分８");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn9(), null, "（証券）受取人区分９");
        exClassificationEquals(hokenSyouken.getSyoukenuktkbn10(), null, "（証券）受取人区分１０");
        exStringEquals(hokenSyouken.getSyoukenuktnm1(), null, "（証券）受取人名１");
        exStringEquals(hokenSyouken.getSyoukenuktnm2(), null, "（証券）受取人名２");
        exStringEquals(hokenSyouken.getSyoukenuktnm3(), null, "（証券）受取人名３");
        exStringEquals(hokenSyouken.getSyoukenuktnm4(), null, "（証券）受取人名４");
        exStringEquals(hokenSyouken.getSyoukenuktnm5(), null, "（証券）受取人名５");
        exStringEquals(hokenSyouken.getSyoukenuktnm6(), null, "（証券）受取人名６");
        exStringEquals(hokenSyouken.getSyoukenuktnm7(), null, "（証券）受取人名７");
        exStringEquals(hokenSyouken.getSyoukenuktnm8(), null, "（証券）受取人名８");
        exStringEquals(hokenSyouken.getSyoukenuktnm9(), null, "（証券）受取人名９");
        exStringEquals(hokenSyouken.getSyoukenuktnm10(), null, "（証券）受取人名１０");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari1(), null, "（証券）受取人分割割合１");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari2(), null, "（証券）受取人分割割合２");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari3(), null, "（証券）受取人分割割合３");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari4(), null, "（証券）受取人分割割合４");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari5(), null, "（証券）受取人分割割合５");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari6(), null, "（証券）受取人分割割合６");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari7(), null, "（証券）受取人分割割合７");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari8(), null, "（証券）受取人分割割合８");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari9(), null, "（証券）受取人分割割合９");
        exBizCalcbleEquals(hokenSyouken.getSyoukenuktbnwari10(), null, "（証券）受取人分割割合１０");
    }

    @Test
    @TestOrder(240)
    public void testEditTBL_D1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000411");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(50001), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05021", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
    }

    @Test
    @TestOrder(250)
    public void testEditTBL_D2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000422");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(50002), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05030", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
    }
    @Test
    @TestOrder(260)
    public void testEditTBL_D3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000433");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(50003), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
    }
    @Test
    @TestOrder(270)
    public void testEditTBL_D4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000444");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05020", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(20004), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05041", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
    }
    @Test
    @TestOrder(280)
    public void testEditTBL_D5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000455");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(20005), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05051", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
    }
    @Test
    @TestOrder(290)
    public void testEditTBL_D6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000466");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05010", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05020", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(20006), "保険料");
        exStringEquals(hokenSyouken.getPtuuka(), "", "保険料通貨");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getPhrkktuki(), "＊", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "込方法メッセージ区分");
    }

    @Test
    @TestOrder(290)
    public void testEditTBL_D7() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getPmsgcd1(), "05011", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
    }

    @Test
    @TestOrder(340)
    public void testEditTBL_E1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000514");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "03", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "04", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "05", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120001), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "08021", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "08031", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "08051", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.JPY, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), BizCurrency.valueOf(21005), "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(350)
    public void testEditTBL_E2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000525");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "01", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "02", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "05", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120002), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "08022", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "08041", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), null, "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(360)
    public void testEditTBL_E3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000536");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20250802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "05", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "06", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "06", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120003), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), BizDate.valueOf("20271031"), "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "08022", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "08051", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "08061", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.JPY, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), BizCurrency.valueOf(21005), "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(370)
    public void testEditTBL_E4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000547");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "04", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), null, "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "03", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), null, "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120004), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08041", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), null, "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(380)
    public void testEditTBL_E5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000558");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20380802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), null, "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), null, "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), null, "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), null, "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120005), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), null, "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(390)
    public void testEditTBL_E6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000569");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "01", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "02", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "06", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120006), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), BizDate.valueOf("20271031"), "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08010", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "08021", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "08031", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), null, "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(400)
    public void testEditTBL_E7() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000570");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "04", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "04", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), null, "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "03", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), null, "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120007), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08041", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), null, "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(410)
    public void testEditTBL_E8() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000581");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20380802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), null, "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), null, "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), null, "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), null, "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), BizCurrency.valueOf(120008), "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), null, "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto1(), null, "主契約特約第２保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai2hknkknymdto2(), null, "主契約特約第２保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exClassificationEquals(hokenSyouken.getKykniyustitjbrptuuktype(), C_Tuukasyu.BLNK, "契約内容欄下一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getKykniyustitjbrp(), null, "契約内容欄下一時払保険料");
    }

    @Test
    @TestOrder(410)
    public void testEditTBL_E9() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "05", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "04", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "03", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08023", "契約内容欄下メッセージコード１");
    }


    @Test
    @TestOrder(420)
    public void testEditTBL_F1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000617");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20200401);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09021", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09032", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09038", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09040", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09050", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09091", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09100", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(430)
    public void testEditTBL_F2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000628");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20200401);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09034", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09050", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09081", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09091", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09100", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(440)
    public void testEditTBL_F3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000639");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09051", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09010", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09060", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09091", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09100", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(450)
    public void testEditTBL_F4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000640");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20200331);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09034", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09050", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09071", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09091", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09100", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }

    @Test
    @TestOrder(460)
    public void testEditTBL_F5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000651");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09048", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09051", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09010", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09021", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09022", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09024", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09030", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09032", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09034", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "09080", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "09038", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "09040", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "09060", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.61), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(470)
    public void testEditTBL_F6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000662");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09021", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09024", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09030", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09034", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09084", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09071", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "09074", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.61), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(480)
    public void testEditTBL_F7() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000673");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09060", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.61), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(490)
    public void testEditTBL_F8() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000684");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09082", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09038", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09071", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09073", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.61), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }

    @Test
    @TestOrder(500)
    public void testEditTBL_F9() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000695");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09086", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09038", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09071", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09074", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.61), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(510)
    public void testEditTBL_F10() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000709");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09034", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09050", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09081", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09091", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09100", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }

    @Test
    @TestOrder(520)
    public void testEditTBL_F11() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000477");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09082", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09038", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09071", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09074", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.61), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }

    @Test
    @TestOrder(521)
    public void testEditTBL_F12() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("17806000013");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09010", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09060", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09091", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09100", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(), BizNumber.valueOf(0.52), "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(522)
    public void testEditTBL_F13() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_MKHGKTTT;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09051", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09021", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09030", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09047", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09040", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09060", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09092", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(),null, "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), BizDate.valueOf(20180424), "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(523)
    public void testEditTBL_F14() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011053");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09051", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09053", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09040", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09092", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(),null, "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), BizDate.valueOf(20180424), "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(524)
    public void testEditTBL_F15() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011064");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.BLNK;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09051", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09021", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09040", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09092", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "", "その他内容欄メッセージコード８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd9(), "", "その他内容欄メッセージコード９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd10(), "", "その他内容欄メッセージコード１０");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd11(), "", "その他内容欄メッセージコード１１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd12(), "", "その他内容欄メッセージコード１２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd13(), "", "その他内容欄メッセージコード１３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd14(), "", "その他内容欄メッセージコード１４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd15(), "", "その他内容欄メッセージコード１５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd16(), "", "その他内容欄メッセージコード１６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd17(), "", "その他内容欄メッセージコード１７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd18(), "", "その他内容欄メッセージコード１８");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd19(), "", "その他内容欄メッセージコード１９");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd20(), "", "その他内容欄メッセージコード２０");
        exBizCalcbleEquals(hokenSyouken.getSonotanyrantumitateriritu(),null, "その他内容欄積立利率");
        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), BizDate.valueOf(20180424), "その他内容欄円建終身保険変更日");
    }


    @Test
    @TestOrder(530)
    public void testEditTBL_G1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000710");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12071", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12111", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "12100", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }

    @Test
    @TestOrder(540)
    public void testEditTBL_G2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000721");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12071", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12111", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12030", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "12020", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(550)
    public void testEditTBL_G3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000732");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12071", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12111", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12040", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "12020", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(),  BizCurrency.valueOf(11000), "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(560)
    public void testEditTBL_G4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000743");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "12090", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(570)
    public void testEditTBL_G5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000754");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "12012", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(580)
    public void testEditTBL_G6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000765");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12074", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12054", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12115", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(590)
    public void testEditTBL_G7() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000776");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(600)
    public void testEditTBL_G8() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000787");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20380802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "12014", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(610)
    public void testEditTBL_G9() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000798");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "12016", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.JPY, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(620)
    public void testEditTBL_G10() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000802");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(630)
    public void testEditTBL_G11() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000503");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "12090", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12074", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12054", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12115", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(640)
    public void testEditTBL_G12() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000134");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "12090", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(650)
    public void testEditTBL_G13() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000145");

        IT_HokenSyouken hokenSyouken =   kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20181001));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "12070", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12081", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12110", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12051", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12020", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "12072", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "12113", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12010", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "12012", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }

    @Test
    @TestOrder(650)
    public void testEditTBL_G14() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknhrsmsgcd2(), "", "死亡保障第１保険期間不慮Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd2(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd2(), "", "死亡保障第２保険期間Ｓ表メッセージコード２");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12011", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exClassificationEquals(hokenSyouken.getSibouitjbrpyentuuktype(), C_Tuukasyu.BLNK, "死亡保障一時払保険料相当円換算額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSibouitjbrpyentuukgk(), null, "死亡保障一時払保険料相当円換算額");

    }
    @Test
    @TestOrder(660)
    public void testEditTBL_H1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000813");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), null, "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), null, "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), null, "第１死亡保険金額為替レート（円安） ");
        assertNull( "第１死亡保険金額経過年数０１", hokenSyouken.getDai1skeikanensuu01());
        assertNull( "第１死亡保険金額経過年数０２", hokenSyouken.getDai1skeikanensuu02());
        assertNull( "第１死亡保険金額経過年数０３", hokenSyouken.getDai1skeikanensuu03());
        assertNull( "第１死亡保険金額経過年数０４", hokenSyouken.getDai1skeikanensuu04());
        assertNull( "第１死亡保険金額経過年数０５", hokenSyouken.getDai1skeikanensuu05());
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), null, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), null, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), null, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), null, "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), null, "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), null, "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), null, "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), null, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), null, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), null, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), null, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), null, "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), null, "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), null, "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), null, "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), null, "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), null, "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), null, "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), null, "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), null, "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), null, "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), null, "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), null, "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), null, "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), null, "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), null, "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), null, "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), null, "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), null, "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), null, "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), null, "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), null, "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), null, "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), null, "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), null, "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), null, "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), null, "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), null, "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), null, "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), null, "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), null, "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), null, "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), null, "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), null, "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), null, "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), null, "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), null, "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), null, "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), null, "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), null, "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), null, "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), null, "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), null, "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");

    }

//    @Test
//    @TestOrder(670)
//    public void testEditTBL_H2() {
//
//        MockObjectManager.initialize();
//
//        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
//        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
//        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
//        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
//        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;
//
//        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000824");
//
//        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
//
//        IT_KykSya kykSya = null;
//
//        IT_HhknSya hhknSya = null;
//
//        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
//
//        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();
//
//        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
//
//        IT_KykUkt siteiDairi = null;
//
//        List<IT_KykUkt> sibouhokenLst = null;
//
//        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));
//
//        BizDate syoriYmd = BizDate.valueOf(20180802);
//
//        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
//
//        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
//
//        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
//
//        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
//        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
//        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
//        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
//            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
//            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei);
//
//        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
//        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
//        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), null, "第１死亡保険金額通貨タイプ０１");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), null, "第１死亡保険金額通貨タイプ０２");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), null, "第１死亡保険金額通貨タイプ０３");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
//        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), null, "第１死亡保険金額通貨タイプ０１");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), null, "第１死亡保険金額通貨タイプ０２");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), null, "第１死亡保険金額通貨タイプ０３");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
//        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
//        exBizCalcbleEquals(hokenSyouken.getDai1s01(), null, "第１死亡保険金額０１");
//        exBizCalcbleEquals(hokenSyouken.getDai1s02(), null, "第１死亡保険金額０２");
//        exBizCalcbleEquals(hokenSyouken.getDai1s03(), null, "第１死亡保険金額０３");
//        exBizCalcbleEquals(hokenSyouken.getDai1s04(), null, "第１死亡保険金額０４");
//        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
//        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
//        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
//        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
//        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
//        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), null, "第１死亡保険金額（円貨）通貨タイプ０１");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), null, "第１死亡保険金額（円貨）通貨タイプ０２");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), null, "第１死亡保険金額（円貨）通貨タイプ０３");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), null, "第１死亡保険金額（円貨）通貨タイプ０４");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), null, "第１死亡保険金額（円貨）（円高）０１");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), null, "第１死亡保険金額（円貨）（円高）０２");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), null, "第１死亡保険金額（円貨）（円高）０３");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), null, "第１死亡保険金額（円貨）（円高）０４");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), null, "第１死亡保険金額（円貨）（中央値）０１");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), null, "第１死亡保険金額（円貨）（中央値）０２");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), null, "第１死亡保険金額（円貨）（中央値）０３");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), null, "第１死亡保険金額（円貨）（中央値）０４");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
//        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), null, "第１死亡保険金額（円貨）（円安）０１");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), null, "第１死亡保険金額（円貨）（円安）０２");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), null, "第１死亡保険金額（円貨）（円安）０３");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), null, "第１死亡保険金額（円貨）（円安）０４");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");
//
//        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
//        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
//        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
//        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
//        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
//        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");
//
//        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
//        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
//        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）（不慮）");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
//        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
//        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
//        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
//        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");
//
//        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
//        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), null, "死亡保障第２基準金額");
//
//        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
//        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
//        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
//
//        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
//            C_Tuukasyu.JPY, "通貨種類");
//        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
//            BizCurrency.valueOf(130000), "金額");
//        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
//            BizNumber.valueOf(20), "レート");
//        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
//            C_HasuusyoriKbn.AGE, "端数処理区分");
//        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
//            C_Tuukasyu.JPY, "通貨種類");
//        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
//            BizCurrency.valueOf(130000), "金額");
//        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
//            BizNumber.valueOf(30), "レート");
//        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
//            C_HasuusyoriKbn.AGE, "端数処理区分");
//        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
//            C_Tuukasyu.JPY, "通貨種類");
//        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
//            BizCurrency.valueOf(130000), "金額");
//        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
//            BizNumber.valueOf(40), "レート");
//        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
//            C_HasuusyoriKbn.AGE, "端数処理区分");
//        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 0),
//            C_Tuukasyu.JPY, "通貨種類");
//        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 1),
//            BizCurrency.valueOf(130000), "金額");
//        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 2),
//            BizNumber.valueOf(20), "レート");
//        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 3, 3),
//            C_HasuusyoriKbn.AGE, "端数処理区分");
//        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 0),
//            C_Tuukasyu.JPY, "通貨種類");
//        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 1),
//            BizCurrency.valueOf(130000), "金額");
//        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 2),
//            BizNumber.valueOf(30), "レート");
//        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 4, 3),
//            C_HasuusyoriKbn.AGE, "端数処理区分");
//        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 0),
//            C_Tuukasyu.JPY, "通貨種類");
//        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 1),
//            BizCurrency.valueOf(130000), "金額");
//        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 2),
//            BizNumber.valueOf(40), "レート");
//        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 5, 3),
//            C_HasuusyoriKbn.AGE, "端数処理区分");
//
//
//    }

	@Test
	@TestOrder(680)
	public void testEditTBL_H3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000835");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        assertNull( "第１死亡保険金額経過年数０２", hokenSyouken.getDai1skeikanensuu02());
        assertNull( "第１死亡保険金額経過年数０３", hokenSyouken.getDai1skeikanensuu03());
        assertNull( "第１死亡保険金額経過年数０４", hokenSyouken.getDai1skeikanensuu04());
        assertNull( "第１死亡保険金額経過年数０５", hokenSyouken.getDai1skeikanensuu05());
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), null, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), null, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), null, "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), null, "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), null, "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), null, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), null, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), null, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), null, "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), null, "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), null, "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), null, "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), null, "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), null, "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), null, "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), null, "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), null, "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(101), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12074", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), BizCurrency.valueOf(101), "死亡保障第１基準金額");

        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 0),
            "B002", "商品コード");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 1),
            11, "商品世代番号");
        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 2),
            "123", "料率世代番号");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 3),
            BizNumber.valueOf(0.63), "予定利率");
        exClassificationEquals((C_Hrkkaisuu) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 4),
            C_Hrkkaisuu.NEN, "払込回数");
        exClassificationEquals((C_HknkknsmnKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 5),
            C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 6),
            10, "保険期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 7),
            12, "払込期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 8),
            13, "被保険者年齢");
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 9),
            C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 10),
            BizCurrency.valueOf(130000), "基本Ｓ");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 11),
            BizDate.valueOf(20171101), "契約日");
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 12),
            BizDate.valueOf(20171101), "計算基準日");
        exStringEquals((String) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 13),
            "20806000835", "証券番号");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 14),
            C_Tuukasyu.USD, "通貨種類");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 15),
            1, "第１保険期間");
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 16),
            20, "ＭＶＡ適用期間");
        exClassificationEquals((C_SiinKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 17),
            C_SiinKbn.SP, "死因区分");
        exClassificationEquals((C_HokenkinsyuruiKbn) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 18),
            C_HokenkinsyuruiKbn.SBHOKENKIN, "保険金種類区分");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 19),
            BizCurrency.valueOf(150000), "保険料");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 20),
            BizNumber.valueOf(2.01), "解約時市場価格調整用利率");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 21),
            BizNumber.valueOf(2.01), "契約時市場価格調整用利率");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 22),
            null, "積立金対象年月");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 23),
            null, "定率積立金額");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 24),
            null, "指数連動積立金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcHkShrKngkMockForHozen.class, "exec", 0, 25),
            BizNumber.valueOf(1.45), "積立利率");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1),
            BizCurrency.valueOf(10010), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2),
            BizNumber.valueOf(20), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1),
            BizCurrency.valueOf(10010), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2),
            BizNumber.valueOf(30), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0),
            C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1),
            BizCurrency.valueOf(10010), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2),
            BizNumber.valueOf(40), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3),
            C_HasuusyoriKbn.AGE, "端数処理区分");

    }

    @Test
    @TestOrder(690)
    public void testEditTBL_H4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000846");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        assertNull( "第１死亡保険金額経過年数０３", hokenSyouken.getDai1skeikanensuu03());
        assertNull( "第１死亡保険金額経過年数０４", hokenSyouken.getDai1skeikanensuu04());
        assertNull( "第１死亡保険金額経過年数０５", hokenSyouken.getDai1skeikanensuu05());
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), BizDate.valueOf("20171101"), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), BizDate.valueOf("20181101"), "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), null, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), null, "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), null, "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), null, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), null, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), null, "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), null, "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), null, "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), null, "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), null, "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), null, "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(102), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12078", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), BizCurrency.valueOf(102), "死亡保障第１基準金額");

    }

    @Test
    @TestOrder(700)
    public void testEditTBL_H5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000857");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 1, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 2, "第１死亡保険金額経過年数０３");
        assertNull( "第１死亡保険金額経過年数０４", hokenSyouken.getDai1skeikanensuu04());
        assertNull( "第１死亡保険金額経過年数０５", hokenSyouken.getDai1skeikanensuu05());
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), null, "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), null, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), null, "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), null, "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), null, "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(103), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }


    @Test
    @TestOrder(710)
    public void testEditTBL_H6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000868");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        assertNull( "第１死亡保険金額経過年数０５", hokenSyouken.getDai1skeikanensuu05());
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), BizDate.valueOf("20171101"), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), BizDate.valueOf("20181101"), "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), BizDate.valueOf("20191101"), "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), BizDate.valueOf("20201101"), "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(104), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12076", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }

    @Test
    @TestOrder(720)
    public void testEditTBL_H7() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000879");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 1, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 2, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 3, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 4, "第１死亡保険金額経過年数０５");
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(105), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(105), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }

    @Test
    @TestOrder(730)
    public void testEditTBL_H8() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000880");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 1, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 2, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 3, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 4, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 5, "第１死亡保険金額経過年数０６");
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), BizCurrency.valueOf(10010), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(106), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(106), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }


    @Test
    @TestOrder(740)
    public void testEditTBL_H9() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000891");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 1, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 2, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 3, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 4, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 5, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu07(), 6, "第１死亡保険金額経過年数０７");
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), BizCurrency.valueOf(10010), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), BizCurrency.valueOf(10010), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(107), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(107), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }


    @Test
    @TestOrder(750)
    public void testEditTBL_H10() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000905");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 1, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 2, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 3, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 4, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 5, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu07(), 6, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu08(), 7, "第１死亡保険金額経過年数０８");
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), BizCurrency.valueOf(10010), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), BizCurrency.valueOf(10010), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), BizCurrency.valueOf(10010), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(108), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(108), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }

    @Test
    @TestOrder(760)
    public void testEditTBL_H11() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000916");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 1, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 2, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 3, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 4, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 5, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu07(), 6, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu08(), 7, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu09(), 8, "第１死亡保険金額経過年数０９");
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), BizCurrency.valueOf(10010), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), BizCurrency.valueOf(10010), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), BizCurrency.valueOf(10010), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), BizCurrency.valueOf(10010), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(109), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(109), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12072", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }

    @Test
    @TestOrder(770)
    public void testEditTBL_H12() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000927");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), BizDate.valueOf("20171101"), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), BizDate.valueOf("20181101"), "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), BizDate.valueOf("20191101"), "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), BizDate.valueOf("20201101"), "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), BizDate.valueOf("20211101"), "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), BizDate.valueOf("20221101"), "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), BizDate.valueOf("20231101"), "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), BizDate.valueOf("20241101"), "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), BizDate.valueOf("20251101"), "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), BizDate.valueOf("20261101"), "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), BizCurrency.valueOf(10010), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), BizCurrency.valueOf(10010), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), BizCurrency.valueOf(10010), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), BizCurrency.valueOf(10010), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), BizCurrency.valueOf(10010), "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "1", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "1", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "1", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "1", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), BizCurrency.valueOf(130000), "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), BizCurrency.valueOf(110), "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "1", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "1", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "1", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(110), "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "12076", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }


    @Test
    @TestOrder(780)
    public void testEditTBL_H13() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000938");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        assertNull( "第１死亡保険金額経過年数０１", hokenSyouken.getDai1skeikanensuu01());
        assertNull( "第１死亡保険金額経過年数０２", hokenSyouken.getDai1skeikanensuu02());
        assertNull( "第１死亡保険金額経過年数０３", hokenSyouken.getDai1skeikanensuu03());
        assertNull( "第１死亡保険金額経過年数０４", hokenSyouken.getDai1skeikanensuu04());
        assertNull( "第１死亡保険金額経過年数０５", hokenSyouken.getDai1skeikanensuu05());
        assertNull( "第１死亡保険金額経過年数０６", hokenSyouken.getDai1skeikanensuu06());
        assertNull( "第１死亡保険金額経過年数０７", hokenSyouken.getDai1skeikanensuu07());
        assertNull( "第１死亡保険金額経過年数０８", hokenSyouken.getDai1skeikanensuu08());
        assertNull( "第１死亡保険金額経過年数０９", hokenSyouken.getDai1skeikanensuu09());
        assertNull( "第１死亡保険金額経過年数１０", hokenSyouken.getDai1skeikanensuu10());
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), null, "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), null, "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), null, "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), null, "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), null, "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), null, "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), null, "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), null, "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), null, "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), null, "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), null, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), null, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), null, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), null, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), null, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), null, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), null, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), null, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), null, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), null, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), null, "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), null, "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), null, "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), null, "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), null, "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), null, "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), null, "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), null, "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), null, "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), null, "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), null, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), null, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), null, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), null, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), null, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), null, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), null, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), null, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), null, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), null, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), null, "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), null, "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), null, "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), null, "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), null, "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), null, "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), null, "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), null, "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), null, "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), null, "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), null, "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), null, "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), null, "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), null, "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), null, "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), null, "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), null, "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), null, "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), null, "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), null, "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), null, "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), null, "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), null, "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), null, "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), null, "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), null, "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), null, "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), null, "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), null, "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), null, "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), null, "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), null, "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), null, "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), null, "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), null, "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), null, "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), null, "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), null, "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), null, "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), null, "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), null, "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), null, "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), null, "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), null, "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), null, "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), null, "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), null, "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), null, "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), null, "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), null, "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), null, "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), null, "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(130000), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(105), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(106), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(107), "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), null, "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), null, "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), null, "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), null, "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), null, "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }


    @Test
    @TestOrder(790)
    public void testEditTBL_H14() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806000949");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(20), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(30), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(40), "第１死亡保険金額為替レート（円安） ");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 0, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 0, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 0, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 0, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 0, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu07(), 0, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu08(), 0, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu09(), 0, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu10(), 0, "第１死亡保険金額経過年数１０");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd01(), BizDate.valueOf("20171101"), "第１死亡保険金額年単位応当年月日０１");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd02(), BizDate.valueOf("20181101"), "第１死亡保険金額年単位応当年月日０２");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd03(), BizDate.valueOf("20191101"), "第１死亡保険金額年単位応当年月日０３");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd04(), BizDate.valueOf("20201101"), "第１死亡保険金額年単位応当年月日０４");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd05(), BizDate.valueOf("20211101"), "第１死亡保険金額年単位応当年月日０５");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd06(), BizDate.valueOf("20221101"), "第１死亡保険金額年単位応当年月日０６");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd07(), BizDate.valueOf("20231101"), "第１死亡保険金額年単位応当年月日０７");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd08(), BizDate.valueOf("20241101"), "第１死亡保険金額年単位応当年月日０８");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd09(), BizDate.valueOf("20251101"), "第１死亡保険金額年単位応当年月日０９");
        exDateEquals(hokenSyouken.getDai1sibousnenoutouymd10(), BizDate.valueOf("20261101"), "第１死亡保険金額年単位応当年月日１０");
        exClassificationEquals(hokenSyouken.getDai1stuuktype01(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1stuuktype02(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1stuuktype03(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1stuuktype04(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1stuuktype05(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1stuuktype06(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1stuuktype07(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1stuuktype08(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1stuuktype09(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1stuuktype10(), C_Tuukasyu.USD, "第１死亡保険金額通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1s01(), BizCurrency.valueOf(10010), "第１死亡保険金額０１");
        exBizCalcbleEquals(hokenSyouken.getDai1s02(), BizCurrency.valueOf(10010), "第１死亡保険金額０２");
        exBizCalcbleEquals(hokenSyouken.getDai1s03(), BizCurrency.valueOf(10010), "第１死亡保険金額０３");
        exBizCalcbleEquals(hokenSyouken.getDai1s04(), BizCurrency.valueOf(10010), "第１死亡保険金額０４");
        exBizCalcbleEquals(hokenSyouken.getDai1s05(), BizCurrency.valueOf(10010), "第１死亡保険金額０５");
        exBizCalcbleEquals(hokenSyouken.getDai1s06(), BizCurrency.valueOf(10010), "第１死亡保険金額０６");
        exBizCalcbleEquals(hokenSyouken.getDai1s07(), BizCurrency.valueOf(10010), "第１死亡保険金額０７");
        exBizCalcbleEquals(hokenSyouken.getDai1s08(), BizCurrency.valueOf(10010), "第１死亡保険金額０８");
        exBizCalcbleEquals(hokenSyouken.getDai1s09(), BizCurrency.valueOf(10010), "第１死亡保険金額０９");
        exBizCalcbleEquals(hokenSyouken.getDai1s10(), BizCurrency.valueOf(10010), "第１死亡保険金額１０");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype01(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０１");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype02(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０２");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype03(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０３");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype04(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０４");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype05(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０５");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype06(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０６");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype07(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０７");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype08(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０８");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype09(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ０９");
        exClassificationEquals(hokenSyouken.getDai1syentuuktype10(), C_Tuukasyu.JPY, "第１死亡保険金額（円貨）通貨タイプ１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka01(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka02(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka03(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka04(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka05(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka06(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka07(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka08(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka09(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendaka10(), BizCurrency.valueOf(102), "第１死亡保険金額（円貨）（円高）１０");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu01(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu02(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu03(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu04(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu05(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu06(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu07(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu08(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu09(), "0", "第１死亡保険金額（円貨）（円高）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyendakaumu10(), "0", "第１死亡保険金額（円貨）（円高）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun01(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun02(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun03(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun04(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun05(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun06(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun07(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun08(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun09(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyun10(), BizCurrency.valueOf(103), "第１死亡保険金額（円貨）（中央値）１０");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu01(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu02(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu03(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu04(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu05(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu06(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu07(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu08(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu09(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenkijyunumu10(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無１０");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu01(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０１");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu02(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０２");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu03(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０３");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu04(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０４");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu05(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０５");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu06(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０６");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu07(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０７");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu08(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０８");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu09(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）０９");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasu10(), BizCurrency.valueOf(104), "第１死亡保険金額（円貨）（円安）１０");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu01(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０１");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu02(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０２");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu03(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０３");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu04(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０４");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu05(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０５");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu06(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０６");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu07(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０７");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu08(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０８");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu09(), "0", "第１死亡保険金額（円貨）（円安）丸印有無０９");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumu10(), "0", "第１死亡保険金額（円貨）（円安）丸印有無１０");

        exClassificationEquals(hokenSyouken.getDai2stuuktype(),  C_Tuukasyu.BLNK, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), null, "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), null, "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), null, "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), null, "第２死亡保険金額（円貨）（円安）");

        exClassificationEquals(hokenSyouken.getDai1stuuktypehuryo(), C_Tuukasyu.BLNK, "第１死亡保険金額通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1shuryo(), null, "第１死亡保険金額（不慮）");
        exClassificationEquals(hokenSyouken.getDai1syentuuktypehuryo(),C_Tuukasyu.BLNK, "第１死亡保険金額（円貨）通貨タイプ（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyendakahuryo(), null, "第１死亡保険金額（円貨）（円高）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenkijyunhuryo(), null, "第１死亡保険金額（円貨）（中央値）（不慮）");
        exBizCalcbleEquals(hokenSyouken.getDai1syenyenyasuhuryo(), null, "第１死亡保険金額（円貨）（円安）（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyendakaumuhuryo(), "0", "第１死亡保険金額（円貨）（円高）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenkjnumuhuryo(), "0", "第１死亡保険金額（円貨）（中央値）丸印有無（不慮）");
        exStringEquals(hokenSyouken.getDai1syenyenyasuumuhuryo(), "0", "第１死亡保険金額（円貨）（円安）丸印有無（不慮）");

        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), null, "死亡保障第２基準金額");

        exStringEquals(hokenSyouken.getSiboudai1hknkknsmrmsgcd(), "", "死亡保障第１保険期間Ｓ表丸印メッセージコード");
        exClassificationEquals(hokenSyouken.getSiboudai1kjnkngktuuktype(), C_Tuukasyu.BLNK, "死亡保障第１基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai1kjnkngk(), null, "死亡保障第１基準金額");
    }


    @Test
    @TestOrder(800)
    public void testEditTBL_I1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001010");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13011", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13081", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13083", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "13084", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "05", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(810)
    public void testEditTBL_I2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001021");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13021", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13081", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13084", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "06", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15042", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(820)
    public void testEditTBL_I3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001032");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13081", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13084", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "04", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13200", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15042", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(830)
    public void testEditTBL_I4() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001043");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13011", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "13021", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), BizNumber.valueOf(1), "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13096", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(840)
    public void testEditTBL_I5() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001054");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13011", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13096", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "02", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(850)
    public void testEditTBL_I6() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001065");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13011", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "13022", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13096", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "03", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(860)
    public void testEditTBL_I7() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001076");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13094", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13096", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "04", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(870)
    public void testEditTBL_I8() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001087");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13094", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13096", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "05", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(880)
    public void testEditTBL_I9() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20806001098");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13011", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "13012", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "13022", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.JPY, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13096", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(890)
    public void testEditTBL_I10() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011008");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13084", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13122", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "02", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13210", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(900)
    public void testEditTBL_I11() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000096");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13087", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13094", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13095", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "13096", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "06", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }
    @Test
    @TestOrder(910)
    public void testEditTBL_I12() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000100");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13083", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13084", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13124", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "03", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
    }
    @Test
    @TestOrder(920)
    public void testEditTBL_I13() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000111");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13084", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
    }
    @Test
    @TestOrder(930)
    public void testEditTBL_I14() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000122");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13081", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "13084", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13110", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "04", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13200", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15042", "控除証明説明メッセージコード１");
    }
    @Test
    @TestOrder(940)
    public void testEditTBL_I15() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000133");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;
        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "13021", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13084", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15042", "控除証明説明メッセージコード１");
    }
    @Test
    @TestOrder(950)
    public void testEditTBL_I16() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000144");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        IT_KykSya kykSya = null;

        IT_HhknSya hhknSya = null;

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20180808));

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;
        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13071", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13084", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13120", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "01", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(10000), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15044", "控除証明説明メッセージコード１");
    }

    @Test
    @TestOrder(950)
    public void testEditTBL_I17() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd(), "", "目標到達時円建終身保険移行特約メッセージコード");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd2(), "", "目標到達時円建終身保険移行特約メッセージコード２");
        exStringEquals(hokenSyouken.getMkhyouyensysnikoumsgcd3(), "", "目標到達時円建終身保険移行特約メッセージコード３");
        exClassificationEquals(hokenSyouken.getMkhyouyensysnikougktype(), C_Tuukasyu.BLNK, "目標到達時円建終身保険移行特約目標額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getMkhyouyensysnikouwra(), null, "目標到達時円建終身保険移行特約目標割合");
        exStringEquals(hokenSyouken.getStdstmmsgcd(), null, "指定代理請求特約説明欄メッセージコード");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13200", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード１");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード２");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");
    }
    @Test
    @TestOrder(1010)
    public void testEditTBL_J1() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000012");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.ARI);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13200", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), null, "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), null, "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), null, "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), null, "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exBizCalcbleEquals(hokenSyouken.getTeiritutmtthbnwr(), BizNumber.valueOf(101), "定率積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getSisuutmtthbnwr(), BizNumber.valueOf(-1), "指数積立部分配分割合");
        exBizCalcbleEquals(hokenSyouken.getHutanhiyustmytijihiritu(), BizNumber.valueOf(1), "ご負担費用説明欄予定維持費率");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14022", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14031", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");

    }

    @Test
    @TestOrder(1020)
    public void testEditTBL_J2() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000023");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200401);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13060", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");


        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14022", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14041", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14063", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");

    }

    @Test
    @TestOrder(1030)
    public void testEditTBL_J3() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000034");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13190", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14022", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14041", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14070", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(0), "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1040)
    public void testEditTBL_J4() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000045");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "13220", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 70, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 75, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 80, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 85, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 90, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 95, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 100, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 105, "介護前払請求日時点被保険者年齢０８");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14022", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14041", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(100000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1050)
    public void testEditTBL_J5() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000056");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13061", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), null, "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), null, "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1060)
    public void testEditTBL_J6() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000067");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20290802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "ユーロ", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.EUR, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), null, "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), null, "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "14061", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "14065", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "EUR", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14037", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14045", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14042", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.EUR, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(10000), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");
    }
    @Test
    @TestOrder(1070)
    public void testEditTBL_J7() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000078");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20190301));
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13035", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1080)
    public void testEditTBL_J8() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000089");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13035", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1090)
    public void testEditTBL_J9() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000090");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13035", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "14082", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(),BizDate.valueOf(20180424), "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1110)
    public void testEditTBL_J10() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000104");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13035", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");


        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1120)
    public void testEditTBL_J11() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000115");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), null, "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), null, "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), null, "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), null, "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "14061", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14037", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14045", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14042", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1130)
    public void testEditTBL_J12() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000126");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14036", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14065", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1140)
    public void testEditTBL_J13() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000137");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14037", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1150)
    public void testEditTBL_J14() {
        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000148");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14037", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1160)
    public void testEditTBL_J15() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN2;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000159");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14036", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.JPY, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), BizCurrency.valueOf(10000), "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1170)
    public void testEditTBL_J16() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000160");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14035", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14037", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14062", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.USD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(0), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), BizCurrency.valueOf(11000), "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1180)
    public void testEditTBL_J17() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000171");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1190)
    public void testEditTBL_J18() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000182");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20290802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "14062", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1200)
    public void testEditTBL_J19() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000193");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14065", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1210)
    public void testEditTBL_J20() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000207");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14062", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1220)
    public void testEditTBL_J21() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000218");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14062", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1230)
    public void testEditTBL_J22() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000229");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));
        hokenSyouken.setSonotanyranpenknsngk(BizCurrency.valueOf(1000));
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14065", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1240)
    public void testEditTBL_J23() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000230");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1250)
    public void testEditTBL_J24() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20807000241");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13035", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1260)
    public void testEditTBL_J25() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000018");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1270)
    public void testEditTBL_J26() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000029");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1280)
    public void testEditTBL_J27() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000030");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1290)
    public void testEditTBL_J28() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000041");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1300)
    public void testEditTBL_J29() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000052");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1310)
    public void testEditTBL_J30() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000063");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        assertNull("介護前払請求日時点被保険者年齢０２", hokenSyouken.getKaigomaehrsikuhhknnen02());
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), null, "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), null, "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1320)
    public void testEditTBL_J31() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000074");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13033", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日点被保険者年齢０１");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), null, "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), null, "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), null, "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), null, "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), null, "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), null, "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), null, "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), null, "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), null, "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), null, "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), null, "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), null, "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), null, "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), null, "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), null, "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), null, "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1330)
    public void testEditTBL_J32() {

        MockObjectManager.initialize();
        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;


        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20809000085");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = null;

        List<IT_KykUkt> sibouhokenLst = null;

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20280802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "13035", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 5, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 10, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 15, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 20, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 25, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 30, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 35, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 40, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 45, "介護前払請求日時点被保険者年齢１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(11), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(110000), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "14014", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");

        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "USD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14023", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14045", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14042", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
    }

    @Test
    @TestOrder(1340)
    public void testEditTBL_J33() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011019");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20180802);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd1(), "", "商品付帯サービスメッセージコード1");
        exStringEquals(hokenSyouken.getSyouhnhutaimsgcd2(), "", "商品付帯サービスメッセージコード2");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13031", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13051", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst2(), null, "介護前払特約メッセージコード表下２");
        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "豪ドル", "介護前払特約契約通貨");
        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.AUD, "介護前払受領額通貨タイプ");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), null, "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(110000), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(110000), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(110000), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(110000), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(110000), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(110000), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(110000), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(110000), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(110000), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), null, "介護前払受領額１０");

        exStringEquals(hokenSyouken.getWmsgcd1(), "14011", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");


        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");

        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");

        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");

        exDateEquals(hokenSyouken.getSonotanyranyensysnhkhnkymd(), null, "その他内容欄円建終身保険変更日");
        exStringEquals(hokenSyouken.getSonotanyrantmttkngktuktype(), "AUD", "その他内容欄積立金額通貨タイプ");
        exDateEquals(hokenSyouken.getKgmaehrtkdai1hknkknmnryymd(), null, "介護前払特約第１保険期間満了日");

        exStringEquals(hokenSyouken.getSiorino(), null, "しおり番号");
        exStringEquals(hokenSyouken.getTnknmissmsg(), null, "転換ミスメッセージ");

        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14022", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "14041", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "14051", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "14061", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");

        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.AUD, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), BizCurrency.valueOf(1000.00, BizCurrencyTypes.AU_DOLLAR), "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.JPY, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");

    }

    @Test
    @TestOrder(1350)
    public void testEditTBL_J34() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011020");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13061", "介護前払特約指定代理メッセージコード");

    }

    @Test
    @TestOrder(1360)
    public void testEditTBL_J35() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011031");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200331);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13060", "介護前払特約指定代理メッセージコード");

    }

    @Test
    @TestOrder(1370)
    public void testEditTBL_J36() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SINKEIYAKUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13060", "介護前払特約指定代理メッセージコード");

    }

    @Test
    @TestOrder(1370)
    public void testEditTBL_J37() {

        MockObjectManager.initialize();

        KeisanKijyungkMockForHozen.SYORIPTN = KeisanKijyungkMockForHozen.TESTPATTERN2;
        CalcHkShrKngkMockForHozen.SYORIPTN = CalcHkShrKngkMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;
        EditSuiihyouTblMock.SYORIPTN = EditSuiihyouTblMock.TESTPATTERN1;

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("20808011042");

        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20170427));

        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);

        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();

        IT_KykSya kykSya = kykKihon.getKykSya();

        IT_HhknSya hhknSya = kykKihon.getHhknSya();

        IT_KykUkt siteiDairi = kykKihon.getKykUktsByUktsyukbnUktsyurenno(C_UktsyuKbn.STDRSK, 1);

        List<IT_KykUkt> sibouhokenLst = kykKihon.getKykUktsByUktsyukbn(C_UktsyuKbn.SBUKT);

        List<IT_NyknJissekiRireki> nyknJissekiRireki = kykKihon.getNyknJissekiRirekis();

        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        editHokenSyoukenParam.setStdrsktkyhnkKbn(C_StdrsktkyhnkKbn.HUKA);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20170901));
        editHokenSyoukenParam.setKariukeUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setHukusuuUmu(C_UmuKbn.NONE);
        editHokenSyoukenParam.setInsizeiShryouhi(C_InsizeiShryouhiKbn.YOU);

        BizDate syoriYmd = BizDate.valueOf(20200330);

        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;

        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;

        int pSksyoukenskskbn = SAIHAKKOUHOKENSYOUKEN;
        int sinkykjyoutai = 2;
        String syuSyouhnCd = syuKykSyouhnLst.get(0).getSyouhncd();
        Integer syuSyouhnsdNo = syuKykSyouhnLst.get(0).getSyouhnsdno();
        BM_SyouhnZokusei syouhnZokusei = manager.getSyouhnZokusei(syuSyouhnCd, syuSyouhnsdNo);
        C_SyoriKbn yendthnkSyoriKbn = C_SyoriKbn.YENDTHNK_NINISEIKYUU;

        editSyoukenTblSyuusin.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykjyoutai, syouhnZokusei, yendthnkSyoriKbn);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "14082", "解約返戻金メッセージコード表下");

    }
}
