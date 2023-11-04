package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.BizCurrencyTypes;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.AbstractModule;

import yuyu.app.base.ref.TestDataMaker;
import yuyu.app.base.ref.TestDataMakerException;
import yuyu.common.siharai.sicommon.CalcJdkghkKngk;
import yuyu.common.siharai.sicommon.CalcJdkghkKngkMockForHozen;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_JydkgmbHkKsnKbn;
import yuyu.def.classification.C_KjkhukaKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_HokenSyouken;
import yuyu.def.db.entity.IT_HokenSyoukenHukaInfo;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.db.entity.IT_KykUkt;
import yuyu.def.db.entity.IT_NyknJissekiRireki;
import yuyu.def.db.entity.IT_Zennou;
import yuyu.def.hozen.manager.HozenDomManager;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

/**
 * 保険証券TBL編集（終身３）クラスのメソッド {@link EditSyoukenTblSyuusin3#editTBL(IT_HokenSyouken,IT_KykKihon,IT_KykSya,IT_HhknSya,List<IT_KykSyouhn>,List<IT_NyknJissekiRireki>,IT_KykSonotaTkyk,IT_KykUkt,List<IT_KykUkt>,EditHokenSyoukenParam,BizDate,C_KjkhukaKbn,C_UmuKbn,int,int,BM_SyouhnZokuse, C_SyoriKbn,IT_Zennoui)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSyoukenTblSyuusin3Test_editTBL {

    private final static String fileName = "UT-SP_単体テスト仕様書（共通）_保険証券TBL編集（終身３）";

    private final static String sheetName = "INデータ";

    @Before
    public void before(){

        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(CalcJdkghkKngk.class).to(CalcJdkghkKngkMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        CalcJdkghkKngkMockForHozen.caller = EditSyoukenTblSyuusin3Test_editTBL.class;

    }

    @AfterClass
    public static void testClear() {
        CalcJdkghkKngkMockForHozen.caller = null;
        CalcJdkghkKngkMockForHozen.SYORIPTN = null;

        MockObjectManager.initialize();
    }
    @BeforeClass
    @Transactional
    public static void insertTestData() {
        try {
            TestDataMaker testDataMaker = new TestDataMaker();
            HashMap<String, Map<String, List<Map<String, String>>>> testDataAndTblMap;
            testDataAndTblMap = testDataMaker.getInData(EditSyoukenTblSyuusin3Test_editTBL.class, fileName, sheetName);
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
    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testEditTBL_A1() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030410");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030410").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02030", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02490", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "01021", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), "01022", "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), "01023", "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), "01024", "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02513", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), "01510", "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180801), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.038), "表示欄予定利率");
        exStringEquals(hokenSyouken.getPmsgcd1(), "05017", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05019", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "保険料");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05023", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getHrkkknmsgkbn(), "1", "払込期間メッセージ区分");
        exStringEquals(hokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(hokenSyouken.getPhrkktuki(), "毎月１日から末日まで", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "01", "払込方法メッセージ区分");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), BizCurrency.valueOf(100000.00, BizCurrencyTypes.DOLLAR), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "05", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "05", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exNumericEquals(hokenSyouken.getSyukyktkykdai1hknkkn1(), 1, "主契約特約第１保険期間１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto2(), BizDate.valueOf(20190901), "主契約特約第１保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08074", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20190831), "死亡保障第１保険期間年月日（至）");
        exDateEquals(hokenSyouken.getSiboudai2hknkknymdto(), BizDate.valueOf(20190901), "死亡保障第２保険期間年月日（至）");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exStringEquals(hokenSyoukenHukaInfo.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(hokenSyoukenHukaInfo.getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.USD, "前納定期一括払円貨払込額通貨タイプ");
        exClassificationEquals(hokenSyoukenHukaInfo.getFstpznnkngktuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄前納金額通貨タイプ");
        exNumericEquals(hokenSyoukenHukaInfo.getZnnkai2(), 10, "前納回数（２桁）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(119316972), "前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(20)
    @Transactional
    public void testEditTBL_A2() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030421");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030421").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02490", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), null, "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), "02513", "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180801), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.038), "表示欄予定利率");
        exStringEquals(hokenSyouken.getPmsgcd1(), "05017", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05018", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exStringEquals(hokenSyouken.getPtuuka(), "円", "保険料通貨");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(40189696), "保険料");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getHrkkknmsgkbn(), "0", "払込期間メッセージ区分");
        exStringEquals(hokenSyouken.getHrkkaisuumsgkbn(), "1", "払込回数メッセージ区分");
        exStringEquals(hokenSyouken.getPhrkktuki(), "毎年９月", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "04", "払込方法メッセージ区分");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), BizCurrency.valueOf(10000000), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "07", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "05", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "05", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exNumericEquals(hokenSyouken.getSyukyktkykdai1hknkkn1(), 0, "主契約特約第１保険期間１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto2(), BizDate.valueOf(20180901), "主契約特約第１保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08074", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
        exDateEquals(hokenSyouken.getSiboudai2hknkknymdto(), BizDate.valueOf(20180901), "死亡保障第２保険期間年月日（至）");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exStringEquals(hokenSyoukenHukaInfo.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(hokenSyoukenHukaInfo.getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exClassificationEquals(hokenSyoukenHukaInfo.getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exNumericEquals(hokenSyoukenHukaInfo.getZnnkai2(), 10, "前納回数（２桁）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(119316972), "前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(30)
    @Transactional
    public void testEditTBL_A3() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030432");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030432").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02032", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02031", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), "02054", "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180801), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.038), "表示欄予定利率");
        exStringEquals(hokenSyouken.getPmsgcd1(), "05017", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), "05019", "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "保険料");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05023", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getHrkkknmsgkbn(), "0", "払込期間メッセージ区分");
        exStringEquals(hokenSyouken.getHrkkaisuumsgkbn(), "2", "払込回数メッセージ区分");
        exStringEquals(hokenSyouken.getPhrkktuki(), "毎年６月・１２月", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "00", "払込方法メッセージ区分");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), BizCurrency.valueOf(100000.00, BizCurrencyTypes.DOLLAR), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "03", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "07", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exNumericEquals(hokenSyouken.getSyukyktkykdai1hknkkn1(), 0, "主契約特約第１保険期間１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), BizDate.valueOf(20180531), "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto2(), BizDate.valueOf(20180601), "主契約特約第１保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08074", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180531), "死亡保障第１保険期間年月日（至）");
        exDateEquals(hokenSyouken.getSiboudai2hknkknymdto(), BizDate.valueOf(20180601), "死亡保障第２保険期間年月日（至）");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exStringEquals(hokenSyoukenHukaInfo.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(hokenSyoukenHukaInfo.getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.USD, "前納定期一括払円貨払込額通貨タイプ");
        exClassificationEquals(hokenSyoukenHukaInfo.getFstpznnkngktuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄前納金額通貨タイプ");
        exNumericEquals(hokenSyoukenHukaInfo.getZnnkai2(), 10, "前納回数（２桁）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(119316972), "前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(40)
    @Transactional
    public void testEditTBL_A4() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030443");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030443").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), "02031", "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), "02054", "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180801), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.038), "表示欄予定利率");
        exStringEquals(hokenSyouken.getPmsgcd1(), "05017", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.JPY, "保険料通貨タイプ");
        exStringEquals(hokenSyouken.getPtuuka(), "円", "保険料通貨");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(40189696), "保険料");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "05024", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getHrkkknmsgkbn(), "0", "払込期間メッセージ区分");
        exStringEquals(hokenSyouken.getHrkkaisuumsgkbn(), "2", "払込回数メッセージ区分");
        exStringEquals(hokenSyouken.getPhrkktuki(), "毎年９月・３月", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "", "払込方法メッセージ区分");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), BizCurrency.valueOf(10000000), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.JPY, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "01", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "02", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), "09", "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), "03", "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), "01", "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), "07", "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exNumericEquals(hokenSyouken.getSyukyktkykdai1hknkkn1(), 0, "主契約特約第１保険期間１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), BizDate.valueOf(20180831), "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto2(), BizDate.valueOf(20180901), "主契約特約第１保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08074", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
        exDateEquals(hokenSyouken.getSiboudai2hknkknymdto(), BizDate.valueOf(20180901), "死亡保障第２保険期間年月日（至）");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exStringEquals(hokenSyoukenHukaInfo.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(hokenSyoukenHukaInfo.getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.JPY, "前納定期一括払円貨払込額通貨タイプ");
        exClassificationEquals(hokenSyoukenHukaInfo.getFstpznnkngktuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄前納金額通貨タイプ");
        exNumericEquals(hokenSyoukenHukaInfo.getZnnkai2(), 0, "前納回数（２桁）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(50)
    @Transactional
    public void testEditTBL_A5() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030454");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030454").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd1(), "02010", "表示欄左メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd2(), null, "表示欄左メッセージコード２");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd3(), null, "表示欄左メッセージコード３");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd4(), null, "表示欄左メッセージコード４");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd5(), null, "表示欄左メッセージコード５");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd6(), null, "表示欄左メッセージコード６");
        exStringEquals(hokenSyouken.getHyoujiranhidarimsgcd7(), null, "表示欄左メッセージコード７");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd1(), null, "表示欄右メッセージコード１");
        exStringEquals(hokenSyouken.getHyoujiranmigiimsgcd2(), null, "表示欄右メッセージコード２");
        exDateEquals(hokenSyouken.getHyoujiransknnkaisiymd(), BizDate.valueOf(20180801), "表示欄責任開始日");
        exBizCalcbleEquals(hokenSyouken.getHyoujiranyoteiriritu(), BizNumber.valueOf(0.038), "表示欄予定利率");
        exStringEquals(hokenSyouken.getPmsgcd1(), "05017", "保険料メッセージコード１");
        exStringEquals(hokenSyouken.getPmsgcd2(), null, "保険料メッセージコード２");
        exClassificationEquals(hokenSyouken.getPtuukatype(), C_Tuukasyu.USD, "保険料通貨タイプ");
        exStringEquals(hokenSyouken.getPtuuka(), "米ドル", "保険料通貨");
        exBizCalcbleEquals(hokenSyouken.getHokenryou(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "保険料");
        exStringEquals(hokenSyouken.getPtokuyakumsgcd(), "", "保険料特約メッセージコード");
        exStringEquals(hokenSyouken.getHrkkknmsgkbn(), "0", "払込期間メッセージ区分");
        exStringEquals(hokenSyouken.getHrkkaisuumsgkbn(), "12", "払込回数メッセージ区分");
        exStringEquals(hokenSyouken.getPhrkktuki(), "", "保険料払込期月");
        exStringEquals(hokenSyouken.getHrkhouhoumsgkbn(), "", "払込方法メッセージ区分");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk1(), null, "主契約特約保険金額１");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk2(), BizCurrency.valueOf(100000.00, BizCurrencyTypes.DOLLAR), "主契約特約保険金額２");
        exBizCalcbleEquals(hokenSyouken.getSyukyktkykhknkngk3(), null, "主契約特約保険金額３");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype1(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ１");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype2(), C_Tuukasyu.USD, "主契約特約保険金額通貨タイプ２");
        exClassificationEquals(hokenSyouken.getSyukyktkykstuukatype3(), C_Tuukasyu.BLNK, "主契約特約保険金額通貨タイプ３");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn1(), "", "主契約特約メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn2(), "", "主契約特約メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykmsgkbn3(), "", "主契約特約メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn1(), null, "主契約特約保険金額メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn2(), null, "主契約特約保険金額メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkyksmsgkbn3(), null, "主契約特約保険金額メッセージ区分３");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn1(), null, "主契約特約保険期間メッセージ区分１");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn2(), null, "主契約特約保険期間メッセージ区分２");
        exStringEquals(hokenSyouken.getSyukyktkykhknkknmsgkbn3(), null, "主契約特約保険期間メッセージ区分３");
        exNumericEquals(hokenSyouken.getSyukyktkykdai1hknkkn1(), 0, "主契約特約第１保険期間１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto1(), null, "主契約特約第１保険期間年月日（至）１");
        exDateEquals(hokenSyouken.getSyutkdai1hknkknymdto2(), null, "主契約特約第１保険期間年月日（至）２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd1(), "08074", "契約内容欄下メッセージコード１");
        exStringEquals(hokenSyouken.getKykniyustmsgcd2(), "", "契約内容欄下メッセージコード２");
        exStringEquals(hokenSyouken.getKykniyustmsgcd3(), "", "契約内容欄下メッセージコード３");
        exStringEquals(hokenSyouken.getKykniyustmsgcd4(), "", "契約内容欄下メッセージコード４");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), null, "死亡保障第１保険期間年月日（至）");
        exDateEquals(hokenSyouken.getSiboudai2hknkknymdto(), null, "死亡保障第２保険期間年月日（至）");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exStringEquals(hokenSyoukenHukaInfo.getHenkousikibetukey(), "000000000000000010", "変更識別キー");
        exClassificationEquals(hokenSyoukenHukaInfo.getZnntikiktbriyhrkgktuktype(), C_Tuukasyu.USD, "前納定期一括払円貨払込額通貨タイプ");
        exClassificationEquals(hokenSyoukenHukaInfo.getFstpznnkngktuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄前納金額通貨タイプ");
        exNumericEquals(hokenSyoukenHukaInfo.getZnnkai2(), 0, "前納回数（２桁）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getZnntikiktbriyenhrkgk(), BizCurrency.valueOf(0), "前納定期一括払円貨払込額");
    }

    @Test
    @TestOrder(1010)
    @Transactional
    public void testEditTBL_B1() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030513");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030513").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09024", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09040", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09041", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09047", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09051", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09060", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09090", "その他内容欄メッセージコード８");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0.038), "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1020)
    @Transactional
    public void testEditTBL_B2() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030524");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030524").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09022", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09041", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09090", "その他内容欄メッセージコード５");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0.038), "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1030)
    @Transactional
    public void testEditTBL_B3() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030535");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030535").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09060", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09090", "その他内容欄メッセージコード３");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0.038), "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1040)
    @Transactional
    public void testEditTBL_B4() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030546");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030546").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09060", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09090", "その他内容欄メッセージコード３");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), BizNumber.valueOf(0.038), "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1050)
    @Transactional
    public void testEditTBL_B5() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030557");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030557").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09029", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09039", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09040", "その他内容欄メッセージコード４");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd5(), "09041", "その他内容欄メッセージコード５");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd6(), "09048", "その他内容欄メッセージコード６");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd7(), "09052", "その他内容欄メッセージコード７");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd8(), "09060", "その他内容欄メッセージコード８");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), null, "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1060)
    @Transactional
    public void testEditTBL_B6() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030568");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030568").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09029", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09041", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), null, "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1070)
    @Transactional
    public void testEditTBL_B7() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030579");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.ARI;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030579").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09027", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09028", "その他内容欄メッセージコード３");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd4(), "09060", "その他内容欄メッセージコード４");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), null, "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1080)
    @Transactional
    public void testEditTBL_B8() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030580");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030580").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "09027", "その他内容欄メッセージコード２");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd3(), "09060", "その他内容欄メッセージコード３");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), null, "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1090)
    @Transactional
    public void testEditTBL_B9() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030591");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030591").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09012", "その他内容欄メッセージコード１");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), null, "その他内容欄予定利率");
    }

    @Test
    @TestOrder(1100)
    @Transactional
    public void testEditTBL_B10() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030605");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030605").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getStnaiyouranmsgcd1(), "09060", "その他内容欄メッセージコード１");
        exStringEquals(hokenSyouken.getStnaiyouranmsgcd2(), "", "その他内容欄メッセージコード２");
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
        exBizCalcbleEquals(hokenSyouken.getSonotanyranytirrt(), null, "その他内容欄予定利率");
    }

    @Test
    @TestOrder(2010)
    @Transactional
    public void testEditTBL_C1() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030616");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030616").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12012", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12024", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12084", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12054", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2020)
    @Transactional
    public void testEditTBL_C2() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030627");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030627").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12012", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12026", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12085", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12054", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2030)
    @Transactional
    public void testEditTBL_C3() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030638");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030638").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12016", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12023", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12083", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12053", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12112", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2040)
    @Transactional
    public void testEditTBL_C4() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030649");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030649").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12012", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12025", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12082", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2050)
    @Transactional
    public void testEditTBL_C5() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030650");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030650").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), null, "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12016", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12022", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12082", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12052", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 1, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20190831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2060)
    @Transactional
    public void testEditTBL_C6() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030661");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030661").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12015", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12024", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12084", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12056", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12116", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20200831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2070)
    @Transactional
    public void testEditTBL_C7() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030672");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030672").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12015", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12026", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12085", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12057", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12116", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2080)
    @Transactional
    public void testEditTBL_C8() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030683");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030683").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12013", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12023", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12083", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12053", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "12116", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2090)
    @Transactional
    public void testEditTBL_C9() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030694");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030694").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12015", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12025", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12082", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12055", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2100)
    @Transactional
    public void testEditTBL_C10() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030708");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030708").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "12013", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "12022", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "12082", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "12055", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), BizDate.valueOf(20180831), "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(2110)
    @Transactional
    public void testEditTBL_C11() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030719");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030719").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHosyounymsgcd(), "99001", "保障内容メッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd(), "", "死亡保障見出しメッセージコード");
        exStringEquals(hokenSyouken.getSiboumidasimsgcd2(), "", "死亡保障見出しメッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd1(), "", "死亡保障第１保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai1hknkknmsgcd2(), "", "死亡保障第１保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd1(), "", "死亡保障第２保険期間メッセージコード１");
        exStringEquals(hokenSyouken.getSiboudai2hknkknmsgcd2(), "", "死亡保障第２保険期間メッセージコード２");
        exStringEquals(hokenSyouken.getSiboudai1hknkknigimsgcd(), "", "死亡保障第１保険期間不慮以外Ｓ表メッセージコード");
        exStringEquals(hokenSyouken.getSiboudai2hknkknsmsgcd(), "", "死亡保障第２保険期間Ｓ表メッセージコード");
        exNumericEquals(hokenSyouken.getSiboudai1hknkkn(), 0, "死亡保障第１保険期間");
        exDateEquals(hokenSyouken.getSiboudai1hknkknymdto(), null, "死亡保障第１保険期間年月日（至）");
    }

    @Test
    @TestOrder(3010)
    @Transactional
    public void testEditTBL_D1() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030915");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030915").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 0, "第１死亡保険金額経過年数０１");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu02() == null, true, "第１死亡保険金額経過年数０２");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu03() == null, true, "第１死亡保険金額経過年数０３");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu04() == null, true, "第１死亡保険金額経過年数０４");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu05() == null, true, "第１死亡保険金額経過年数０５");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu06() == null, true, "第１死亡保険金額経過年数０６");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu07() == null, true, "第１死亡保険金額経過年数０７");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu08() == null, true, "第１死亡保険金額経過年数０８");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu09() == null, true, "第１死亡保険金額経過年数０９");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu10() == null, true, "第１死亡保険金額経過年数１０");
        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(13.45, BizCurrencyTypes.DOLLAR), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(119.39), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(109.39), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(129.39), "第１死亡保険金額為替レート（円安） ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(1472), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(1606), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(1741), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.USD, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(13.45, BizCurrencyTypes.DOLLAR), "死亡保障第２基準金額");
    }

    @Test
    @TestOrder(3020)
    @Transactional
    public void testEditTBL_D2() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030926");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030926").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exNumericEquals(hokenSyouken.getDai1skeikanensuu01(), 1, "第１死亡保険金額経過年数０１");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu02(), 2, "第１死亡保険金額経過年数０２");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu03(), 3, "第１死亡保険金額経過年数０３");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu04(), 4, "第１死亡保険金額経過年数０４");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu05(), 5, "第１死亡保険金額経過年数０５");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu06(), 6, "第１死亡保険金額経過年数０６");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu07(), 7, "第１死亡保険金額経過年数０７");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu08(), 8, "第１死亡保険金額経過年数０８");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu09(), 9, "第１死亡保険金額経過年数０９");
        exNumericEquals(hokenSyouken.getDai1skeikanensuu10(), 10, "第１死亡保険金額経過年数１０");
        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(1345), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), null, "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), null, "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), null, "第１死亡保険金額為替レート（円安） ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), null, "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), null, "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), null, "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(1345), "死亡保障第２基準金額");
    }

    @Test
    @TestOrder(3030)
    @Transactional
    public void testEditTBL_D3() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030937");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030937").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

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
        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(1345), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), null, "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), null, "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), null, "第１死亡保険金額為替レート（円安） ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), null, "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), null, "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), null, "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.JPY, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(1345), "死亡保障第２基準金額");
    }

    @Test
    @TestOrder(3040)
    @Transactional
    public void testEditTBL_D4() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030948");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030948").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exBooleanEquals(hokenSyouken.getDai1skeikanensuu01() == null, true, "第１死亡保険金額経過年数０１");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu02() == null, true, "第１死亡保険金額経過年数０２");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu03() == null, true, "第１死亡保険金額経過年数０３");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu04() == null, true, "第１死亡保険金額経過年数０４");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu05() == null, true, "第１死亡保険金額経過年数０５");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu06() == null, true, "第１死亡保険金額経過年数０６");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu07() == null, true, "第１死亡保険金額経過年数０７");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu08() == null, true, "第１死亡保険金額経過年数０８");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu09() == null, true, "第１死亡保険金額経過年数０９");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu10() == null, true, "第１死亡保険金額経過年数１０");
        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.USD, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), BizCurrency.valueOf(13.45, BizCurrencyTypes.DOLLAR), "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.JPY, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(119.39), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(109.39), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(129.39), "第１死亡保険金額為替レート（円安） ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), BizCurrency.valueOf(1472), "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), BizCurrency.valueOf(1606), "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), BizCurrency.valueOf(1741), "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.USD, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), BizCurrency.valueOf(13.45, BizCurrencyTypes.DOLLAR), "死亡保障第２基準金額");
    }

    @Test
    @TestOrder(3050)
    @Transactional
    public void testEditTBL_D5() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030959");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030959").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exBooleanEquals(hokenSyouken.getDai1skeikanensuu01() == null, true, "第１死亡保険金額経過年数０１");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu02() == null, true, "第１死亡保険金額経過年数０２");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu03() == null, true, "第１死亡保険金額経過年数０３");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu04() == null, true, "第１死亡保険金額経過年数０４");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu05() == null, true, "第１死亡保険金額経過年数０５");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu06() == null, true, "第１死亡保険金額経過年数０６");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu07() == null, true, "第１死亡保険金額経過年数０７");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu08() == null, true, "第１死亡保険金額経過年数０８");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu09() == null, true, "第１死亡保険金額経過年数０９");
        exBooleanEquals(hokenSyouken.getDai1skeikanensuu10() == null, true, "第１死亡保険金額経過年数１０");
        exClassificationEquals(hokenSyouken.getDai2stuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai2s(), null, "第２死亡保険金額");
        exClassificationEquals(hokenSyouken.getDai2syentuuktype(), C_Tuukasyu.BLNK, "第２死亡保険金額（円貨）通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenkijyun(), BizNumber.valueOf(119.39), "第１死亡保険金額為替レート（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyendaka(), BizNumber.valueOf(109.39), "第１死亡保険金額為替レート（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai1skwsrateyenyasu(), BizNumber.valueOf(129.39), "第１死亡保険金額為替レート（円安） ");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyendaka(), null, "第２死亡保険金額（円貨）（円高）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenkijyun(), null, "第２死亡保険金額（円貨）（中央値）");
        exBizCalcbleEquals(hokenSyouken.getDai2syenyenyasu(), null, "第２死亡保険金額（円貨）（円安）");
        exClassificationEquals(hokenSyouken.getSiboudai2kjnkngktuuktype(), C_Tuukasyu.USD, "死亡保障第２基準金額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getSiboudai2kjnkngk(), null, "死亡保障第２基準金額");
    }

    @Test
    @TestOrder(4010)
    @Transactional
    public void testEditTBL_E1() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031019");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031019").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13072", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "13", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13112", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13151", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(119316972), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), BizCurrency.valueOf(119316972), "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4020)
    @Transactional
    public void testEditTBL_E2() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031020");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031020").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13074", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "12", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13112", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4030)
    @Transactional
    public void testEditTBL_E3() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031031");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031031").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13074", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "11", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13111", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.USD, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15048", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), BizCurrency.valueOf(401896.96, BizCurrencyTypes.DOLLAR), "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4040)
    @Transactional
    public void testEditTBL_E4() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031042");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031042").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.JPY, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), BizCurrency.valueOf(40189696), "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "15040", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), BizCurrency.valueOf(40189696), "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4050)
    @Transactional
    public void testEditTBL_E5() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031053");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031053").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13101", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "13", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13112", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), null, "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4060)
    @Transactional
    public void testEditTBL_E6() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031064");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031064").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13102", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "12", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13112", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), null, "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4070)
    @Transactional
    public void testEditTBL_E7() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031075");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031075").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "13102", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "13092", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "11", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "13100", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "13111", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), null, "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4080)
    @Transactional
    public void testEditTBL_E8() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031086");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031086").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), null, "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(4090)
    @Transactional
    public void testEditTBL_E9() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031097");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031097").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue01(), "", "ご負担費用説明欄メッセージコード表上１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue02(), "", "ご負担費用説明欄メッセージコード表上２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue03(), "", "ご負担費用説明欄メッセージコード表上３");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdue04(), "", "ご負担費用説明欄メッセージコード表上４");
        exStringEquals(hokenSyouken.getHutanhiyustmknsnhyuptn(), "", "ご負担費用説明欄換算費用パターン");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst01(), "", "ご負担費用説明欄メッセージコード表下１");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst02(), "", "ご負担費用説明欄メッセージコード表下２");
        exStringEquals(hokenSyouken.getHutanhiyustmmsgcdst03(), "", "ご負担費用説明欄メッセージコード表下３");
        exStringEquals(hokenSyouken.getFstpmsgcd(), "13150", "初回Ｐご確認欄メッセージコード");
        exClassificationEquals(hokenSyouken.getFstphrkpkngkkeituuktype(), C_Tuukasyu.BLNK, "初回Ｐご確認欄払込保険料合計通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getFstphrkpkngkkei(), null, "初回Ｐご確認欄払込保険料合計");
        exStringEquals(hokenSyouken.getKoujyosyoumeimsgcd1(), "", "控除証明説明メッセージコード１");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getFstpznnkngk(), null, "初回Ｐご確認欄前納金額");
    }

    @Test
    @TestOrder(5010)
    @Transactional
    public void testEditTBL_F1() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031112");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031112").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13061", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), BizCurrency.valueOf(12154433), "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), BizCurrency.valueOf(12154433), "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), BizCurrency.valueOf(12154433), "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), BizCurrency.valueOf(13265543), "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), BizCurrency.valueOf(13265543), "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), BizCurrency.valueOf(13265543), "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), BizCurrency.valueOf(14376653), "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), BizCurrency.valueOf(14376653), "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), BizCurrency.valueOf(14376653), "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");

        exClassificationEquals((C_JydkgmbHkKsnKbn) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 0), C_JydkgmbHkKsnKbn.NENREISITEI, "重度介護前払保険金計算区分" );
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 1), BizCurrency.valueOf(10000, BizCurrencyTypes.DOLLAR), "特約基準保険金額" );
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 2), BizCurrency.valueOf(0, BizCurrencyTypes.DOLLAR), "解約返戻金" );
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 3), BizNumber.valueOf(0.038), "予定利率" );
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 4), null, "契約日" );
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 5), null, "計算基準日" );
        exDateEquals((BizDate) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 6), null, "被保険者生年月日" );
        exNumericEquals((Integer) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 7), 65, "年齢" );
        exClassificationEquals((C_Hhknsei) MockObjectManager.getArgument(CalcJdkghkKngkMockForHozen.class, "exec", 0, 8), C_Hhknsei.MALE, "被保険者性別" );
    }

    @Test
    @TestOrder(5020)
    @Transactional
    public void testEditTBL_F2() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN2;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031123");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031123").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13032", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13052", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "円", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 65, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 70, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 75, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 80, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 85, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 90, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 95, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 100, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 105, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(11), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(111111), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(111111), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), null, "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), null, "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), null, "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5030)
    @Transactional
    public void testEditTBL_F3() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031134");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031134").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(0), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(0), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), null, "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), null, "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), null, "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5040)
    @Transactional
    public void testEditTBL_F4() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031145");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031145").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13039", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13054", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "13062", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 70, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 75, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 80, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 85, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 90, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 95, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 100, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 105, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), BizCurrency.valueOf(12154433), "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), BizCurrency.valueOf(12154433), "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), BizCurrency.valueOf(13265543), "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), BizCurrency.valueOf(13265543), "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), BizCurrency.valueOf(14376653), "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), BizCurrency.valueOf(14376653), "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5050)
    @Transactional
    public void testEditTBL_F5() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN2;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031156");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031156").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13037", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "円", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.JPY, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 70, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 75, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 80, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 85, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 90, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 95, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 100, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 105, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(11), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(111111), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), null, "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), null, "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), null, "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5060)
    @Transactional
    public void testEditTBL_F6() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031167");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031167").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.BLNK, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 0, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(0), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(0), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), null, "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), null, "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), null, "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5070)
    @Transactional
    public void testEditTBL_F7() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN3;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031178");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031178").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "豪ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.AUD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 70, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 75, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 80, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 85, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 90, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 95, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 100, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 105, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(0), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(0), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), null, "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), null, "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), null, "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5080)
    @Transactional
    public void testEditTBL_F8() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031189");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031189").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), BizCurrency.valueOf(12154433), "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), BizCurrency.valueOf(13265543), "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), BizCurrency.valueOf(14376653), "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5090)
    @Transactional
    public void testEditTBL_F9() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031190");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031190").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), BizCurrency.valueOf(12154433), "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), BizCurrency.valueOf(13265543), "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), BizCurrency.valueOf(14376653), "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5100)
    @Transactional
    public void testEditTBL_F10() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031204");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031204").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 75, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 80, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 85, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 90, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 95, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 100, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 105, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(11), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), BizCurrency.valueOf(12154433), "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), BizCurrency.valueOf(13265543), "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), BizCurrency.valueOf(14376653), "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5110)
    @Transactional
    public void testEditTBL_F11() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031215");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031215").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5120)
    @Transactional
    public void testEditTBL_F12() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031226");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031226").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5130)
    @Transactional
    public void testEditTBL_F13() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031237");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031237").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 80, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 85, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 90, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 95, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 100, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 105, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(11), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(12154433), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(13265543), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(14376653), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5140)
    @Transactional
    public void testEditTBL_F14() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031248");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031248").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5150)
    @Transactional
    public void testEditTBL_F15() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031259");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031259").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5160)
    @Transactional
    public void testEditTBL_F16() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031260");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031260").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 85, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 90, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 95, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 100, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 105, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(11), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(12154433), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(13265543), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(14376653), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5170)
    @Transactional
    public void testEditTBL_F17() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031271");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031271").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5180)
    @Transactional
    public void testEditTBL_F18() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031282");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031282").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5190)
    @Transactional
    public void testEditTBL_F19() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031293");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031293").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 90, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 95, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 100, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 105, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(11), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(12154433), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(13265543), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(14376653), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5200)
    @Transactional
    public void testEditTBL_F20() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031307");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031307").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5210)
    @Transactional
    public void testEditTBL_F21() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031318");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031318").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5220)
    @Transactional
    public void testEditTBL_F22() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031329");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031329").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 95, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 100, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 105, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(11), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(12154433), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(13265543), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(14376653), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5230)
    @Transactional
    public void testEditTBL_F23() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031330");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031330").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5240)
    @Transactional
    public void testEditTBL_F24() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031341");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031341").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5250)
    @Transactional
    public void testEditTBL_F25() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031352");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031352").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 100, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 105, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(11), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(12154433), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(13265543), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(14376653), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5260)
    @Transactional
    public void testEditTBL_F26() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031363");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031363").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5270)
    @Transactional
    public void testEditTBL_F27() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031374");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031374").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5280)
    @Transactional
    public void testEditTBL_F28() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN1;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031385");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031385").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen01(), 105, "介護前払請求日時点被保険者年齢０１");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen02(), 0, "介護前払請求日時点被保険者年齢０２");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen03(), 0, "介護前払請求日時点被保険者年齢０３");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen04(), 0, "介護前払請求日時点被保険者年齢０４");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen05(), 0, "介護前払請求日時点被保険者年齢０５");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen06(), 0, "介護前払請求日時点被保険者年齢０６");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen07(), 0, "介護前払請求日時点被保険者年齢０７");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen08(), 0, "介護前払請求日時点被保険者年齢０８");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen09(), 0, "介護前払請求日時点被保険者年齢０９");
        exNumericEquals(hokenSyouken.getKaigomaehrsikuhhknnen10(), 0, "介護前払請求日時点被保険者年齢１０");

        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn01(), BizNumber.valueOf(11), "介護前払所定期間０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(0), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(0), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(0), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(0), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(0), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(0), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(0), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(0), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(0), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(0), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(0), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(0), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(0), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(0), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(0), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(0), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(0), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(0), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "1", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), null, "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), null, "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), null, "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), null, "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), null, "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), null, "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), null, "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), null, "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), null, "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), null, "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), null, "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), null, "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), null, "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), null, "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), null, "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), null, "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), null, "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), null, "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), null, "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), null, "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), null, "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), null, "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), null, "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), null, "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), null, "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), null, "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), null, "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(5290)
    @Transactional
    public void testEditTBL_F29() {

        MockObjectManager.initialize();
        CalcJdkghkKngkMockForHozen.SYORIPTN  = CalcJdkghkKngkMockForHozen.TESTPATTERN4;

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806031396");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806031396").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd1(), "13033", "介護前払特約メッセージコード１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcd2(), "", "介護前払特約メッセージコード２");
        exStringEquals(hokenSyouken.getKaigomaehrtkykmsgcdst1(), "13053", "介護前払特約メッセージコード表下１");
        exStringEquals(hokenSyouken.getKaigomaehrtkykkyktuuka(), "米ドル", "介護前払特約契約通貨");
        exClassificationEquals(hokenSyouken.getKaigomaehrjrugktype(), C_Tuukasyu.USD, "介護前払受領額通貨タイプ");

        exStringEquals(hokenSyouken.getKaigomaehrtkykstdmsgcd(), "", "介護前払特約指定代理メッセージコード");
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
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn02(), BizNumber.valueOf(12), "介護前払所定期間０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn03(), BizNumber.valueOf(13), "介護前払所定期間０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn04(), BizNumber.valueOf(14), "介護前払所定期間０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn05(), BizNumber.valueOf(15), "介護前払所定期間０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn06(), BizNumber.valueOf(16), "介護前払所定期間０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn07(), BizNumber.valueOf(17), "介護前払所定期間０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn08(), BizNumber.valueOf(18), "介護前払所定期間０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn09(), BizNumber.valueOf(19), "介護前払所定期間０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrstikkn10(), BizNumber.valueOf(20), "介護前払所定期間１０");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk01(), BizCurrency.valueOf(111111, BizCurrencyTypes.DOLLAR), "介護前払受領額０１");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk02(), BizCurrency.valueOf(222222, BizCurrencyTypes.DOLLAR), "介護前払受領額０２");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk03(), BizCurrency.valueOf(333333, BizCurrencyTypes.DOLLAR), "介護前払受領額０３");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk04(), BizCurrency.valueOf(444444, BizCurrencyTypes.DOLLAR), "介護前払受領額０４");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk05(), BizCurrency.valueOf(555555, BizCurrencyTypes.DOLLAR), "介護前払受領額０５");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk06(), BizCurrency.valueOf(666666, BizCurrencyTypes.DOLLAR), "介護前払受領額０６");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk07(), BizCurrency.valueOf(777777, BizCurrencyTypes.DOLLAR), "介護前払受領額０７");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk08(), BizCurrency.valueOf(888888, BizCurrencyTypes.DOLLAR), "介護前払受領額０８");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk09(), BizCurrency.valueOf(999999, BizCurrencyTypes.DOLLAR), "介護前払受領額０９");
        exBizCalcbleEquals(hokenSyouken.getKaigomaehrjrugk10(), BizCurrency.valueOf(1234567, BizCurrencyTypes.DOLLAR), "介護前払受領額１０");

        exStringEquals(hokenSyouken.getKaigomaehruktgkumu(), "0", "介護前払特約受取額一覧有無");

        IT_HokenSyoukenHukaInfo hokenSyoukenHukaInfo = hokenSyouken.getHokenSyoukenHukaInfo();
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka01(), BizCurrency.valueOf(12154433), "介護前払受領額０１（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka02(), BizCurrency.valueOf(24308865), "介護前払受領額０２（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka03(), BizCurrency.valueOf(36463297), "介護前払受領額０３（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka04(), BizCurrency.valueOf(48617730), "介護前払受領額０４（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka05(), BizCurrency.valueOf(60772162), "介護前払受領額０５（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka06(), BizCurrency.valueOf(72926594), "介護前払受領額０６（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka07(), BizCurrency.valueOf(85081027), "介護前払受領額０７（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka08(), BizCurrency.valueOf(97235459), "介護前払受領額０８（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka09(), BizCurrency.valueOf(109389891), "介護前払受領額０９（円高）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkydaka10(), BizCurrency.valueOf(135049285), "介護前払受領額１０（円高）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun01(), BizCurrency.valueOf(13265543), "介護前払受領額０１（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun02(), BizCurrency.valueOf(26531085), "介護前払受領額０２（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun03(), BizCurrency.valueOf(39796627), "介護前払受領額０３（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun04(), BizCurrency.valueOf(53062170), "介護前払受領額０４（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun05(), BizCurrency.valueOf(66327712), "介護前払受領額０５（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun06(), BizCurrency.valueOf(79593254), "介護前払受領額０６（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun07(), BizCurrency.valueOf(92858797), "介護前払受領額０７（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun08(), BizCurrency.valueOf(106124339), "介護前払受領額０８（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun09(), BizCurrency.valueOf(119389881), "介護前払受領額０９（中央値）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkykijyun10(), BizCurrency.valueOf(147394955), "介護前払受領額１０（中央値）");

        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu01(), BizCurrency.valueOf(14376653), "介護前払受領額０１（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu02(), BizCurrency.valueOf(28753305), "介護前払受領額０２（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu03(), BizCurrency.valueOf(43129957), "介護前払受領額０３（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu04(), BizCurrency.valueOf(57506610), "介護前払受領額０４（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu05(), BizCurrency.valueOf(71883262), "介護前払受領額０５（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu06(), BizCurrency.valueOf(86259914), "介護前払受領額０６（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu07(), BizCurrency.valueOf(100636567), "介護前払受領額０７（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu08(), BizCurrency.valueOf(115013219), "介護前払受領額０８（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu09(), BizCurrency.valueOf(129389871), "介護前払受領額０９（円安）");
        exBizCalcbleEquals(hokenSyoukenHukaInfo.getKaigomaehrjrugkyyasu10(), BizCurrency.valueOf(159740625), "介護前払受領額１０（円安）");
    }

    @Test
    @TestOrder(6010)
    @Transactional
    public void testEditTBL_G1() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030812");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030812").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14026", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14075", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6020)
    @Transactional
    public void testEditTBL_G2() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030823");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030823").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14026", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14079", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6030)
    @Transactional
    public void testEditTBL_G3() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030834");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030834").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14026", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14064", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6040)
    @Transactional
    public void testEditTBL_G4() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030845");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 1;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030845").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14012", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6050)
    @Transactional
    public void testEditTBL_G5() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030856");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030856").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14078", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6060)
    @Transactional
    public void testEditTBL_G6() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030867");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030867").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14085", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6070)
    @Transactional
    public void testEditTBL_G7() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030878");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030878").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14010", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "14077", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6080)
    @Transactional
    public void testEditTBL_G8() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030889");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030889").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "14021", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6090)
    @Transactional
    public void testEditTBL_G9() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030890");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030890").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }

    @Test
    @TestOrder(6100)
    @Transactional
    public void testEditTBL_G10() {

        MockObjectManager.initialize();

        HozenDomManager hozenDomManager = SWAKInjector.getInstance(HozenDomManager.class);
        IT_KykKihon kykKihon = hozenDomManager.getKykKihon("99806030904");
        IT_HokenSyouken hokenSyouken = kykKihon.getHokenSyoukenByTyouhyouymd(BizDate.valueOf(20220202));
        IT_KykSya kykSya = null;
        IT_HhknSya hhknSya = kykKihon.getHhknSya();
        List<IT_KykSyouhn> syuKykSyouhnLst = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU);
        List<IT_NyknJissekiRireki> nyknJissekiRireki = null;
        IT_KykSonotaTkyk kykSonotaTkyk = kykKihon.getKykSonotaTkyk();
        IT_KykUkt siteiDairi = null;
        List<IT_KykUkt> sibouhokenLst = null;
        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20210101));
        BizDate syoriYmd = BizDate.valueOf(20210202);
        C_KjkhukaKbn sbUktNmKjHukaKbn = C_KjkhukaKbn.BLNK;
        C_UmuKbn gengakuExistsCheck = C_UmuKbn.NONE;
        int pSksyoukenskskbn = 2;
        int sinkykJyoutai = 1;
        BM_SyouhnZokusei syouhnZokusei = syuKykSyouhnLst.get(0).getSyouhnZokusei();
        C_SyoriKbn syoriKbn = C_SyoriKbn.MUKOU;
        IT_Zennou zennou = hozenDomManager.getAnsyuKihon("99806030904").getZennous().get(0);

        EditSyoukenTblSyuusin3 editSyoukenTblSyuusin3 = SWAKInjector.getInstance(EditSyoukenTblSyuusin3.class);
        editSyoukenTblSyuusin3.editTBL(hokenSyouken, kykKihon, kykSya, hhknSya, syuKykSyouhnLst, nyknJissekiRireki,
            kykSonotaTkyk, siteiDairi, sibouhokenLst, editHokenSyoukenParam, syoriYmd, sbUktNmKjHukaKbn,
            gengakuExistsCheck, pSksyoukenskskbn, sinkykJyoutai, syouhnZokusei, syoriKbn, zennou);

        exStringEquals(hokenSyouken.getWmsgcd1(), "", "解約返戻金メッセージコード１");
        exStringEquals(hokenSyouken.getWmsgcd2(), "", "解約返戻金メッセージコード２");
        exStringEquals(hokenSyouken.getWmsgcd3(), "", "解約返戻金メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd1(), "", "解約返戻金注意事項メッセージコード１");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd2(), "", "解約返戻金注意事項メッセージコード２");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd3(), "", "解約返戻金注意事項メッセージコード３");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd4(), "", "解約返戻金注意事項メッセージコード４");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd5(), "", "解約返戻金注意事項メッセージコード５");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd6(), "", "解約返戻金注意事項メッセージコード６");
        exStringEquals(hokenSyouken.getWtyuuijikoumsgcd7(), "", "解約返戻金注意事項メッセージコード７");
        exClassificationEquals(hokenSyouken.getWitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWitijibrp(), null, "解約返戻金一時払保険料");
        exClassificationEquals(hokenSyouken.getWyenhrkgktuktype(), C_Tuukasyu.BLNK, "解約返戻金円貨払込額通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenhrkgk(), null, "解約返戻金円貨払込額");
        exClassificationEquals(hokenSyouken.getWyenitijibrptuktype(), C_Tuukasyu.BLNK, "解約返戻金円換算一時払保険料通貨タイプ");
        exBizCalcbleEquals(hokenSyouken.getWyenitijibrp(), null, "解約返戻金円換算一時払保険料");
        exStringEquals(hokenSyouken.getWmsgcd21(), "", "解約返戻金メッセージコード２＿１ ");
        exStringEquals(hokenSyouken.getWmsgcd22(), "", "解約返戻金メッセージコード２＿２");
        exStringEquals(hokenSyouken.getWmsgcd31(), "", "解約返戻金メッセージコード３＿１");
        exStringEquals(hokenSyouken.getWmsgcdst1(), "", "解約返戻金メッセージコード表下１");
    }
}
