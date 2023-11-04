package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import jp.co.dgic.testing.common.virtualmock.MockObjectManager;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.bzcommon.GetKawaseRateMock;
import yuyu.common.biz.bzcommon.KeisanGaikakanzan;
import yuyu.common.biz.bzcommon.KeisanGaikakanzanMockForHozen;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2;
import yuyu.common.hozen.ascommon.KeisanZennouSeisanGk2MockForHozen;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_HasuusyoriKbn;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_KawasetsryKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_KwsrendouKbn;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_KawaseRate;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import yuyu.def.db.entity.IT_Suiihyou;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 解約返戻金推移表作成（年金２）クラスのメソッド {@link WSuiihyouNenkin2#exec(WSuiihyouParam)}
 * テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class WSuiihyouNenkin2Test_exec {

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(KeisanZennouSeisanGk2.class).to(KeisanZennouSeisanGk2MockForHozen.class);
                bind(KeisanW.class).to(KeisanWMockForHozen.class);
                bind(KeisanGaikakanzan.class).to(KeisanGaikakanzanMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanZennouSeisanGk2MockForHozen.caller = WSuiihyouNenkin2Test_exec.class;
        KeisanWMockForHozen.caller = WSuiihyouNenkin2Test_exec.class;
        KeisanGaikakanzanMockForHozen.caller = WSuiihyouNenkin2Test_exec.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.caller = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = null;
        KeisanWMockForHozen.caller = null;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.caller = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;
    }

    @BeforeClass
    @Transactional
    public static void insertTestData() {

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        BM_KawaseRate kawaseRate1 = new BM_KawaseRate(BizDate.valueOf("20170403"), C_KwsrendouKbn.KOUJIKAWASERATE2,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.NYUKINRATE);
        kawaseRate1.setKawaserate(BizNumber.valueOf(11));
        bizDomManager.insert(kawaseRate1);
        BM_KawaseRate kawaseRate2 = new BM_KawaseRate(BizDate.valueOf("20170403"), C_KwsrendouKbn.KOUJIKAWASERATE2,
            C_Tuukasyu.JPY, C_Tuukasyu.JPY, C_KawasetekiyoKbn.TTM, C_KawasetsryKbn.SYUKKINRATE);
        kawaseRate2.setKawaserate(BizNumber.valueOf(11));
        bizDomManager.insert(kawaseRate2);
        BM_YoteiRiritu3 yoteiRiritu3 = new BM_YoteiRiritu3(
            "ﾕｱ",C_Tuukasyu.USD ,"","",BizDate.valueOf("20180101"), BizDate.valueOf("20191201"));
        yoteiRiritu3.setYoteiriritu(BizNumber.valueOf(0.033));
        bizDomManager.insert(yoteiRiritu3);
    }

    @AfterClass
    @Transactional
    public static void deleteTestData() {

        MockObjectManager.initialize();

        BizDomManager bizDomManager = SWAKInjector.getInstance(BizDomManager.class);
        bizDomManager.delete(bizDomManager.getAllKawaseRate());
        bizDomManager.delete(bizDomManager.getAllYoteiRiritu3());

    }

    @Test
    @TestOrder(10)
    @Transactional
    public void testExec_A1() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(1));
        yoteiRirituList.add(BizNumber.valueOf(2));
        yoteiRirituList.add(BizNumber.valueOf(3));

        keisanWExtBean.setSisankawaserate(BizNumber.ZERO);
        keisanWExtBean.setHknkkn(27);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180311));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.YOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.YOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 0), BizDate.valueOf(20190311), "前納精算基準日");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 1), BizDate.valueOf(20180311), "契約日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 2), BizCurrency.valueOf(100), "前納時払込保険料");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 3), BizDate.valueOf(20190309), "前納開始年月日");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 4), BizDate.valueOf(20190308), "領収日");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanZennouSeisanGk2MockForHozen.class, "exec", 0, 5), BizCurrency.valueOf(200), "前納入金額");

        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 1), BizCurrency.valueOf(654.67), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 2), BizNumber.valueOf(11), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 0, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 1), BizCurrency.valueOf(654.67), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 2), BizNumber.valueOf(1), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 1, 3), C_HasuusyoriKbn.AGE, "端数処理区分");
        exClassificationEquals((C_Tuukasyu) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 0), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals((BizCurrency) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 1), BizCurrency.valueOf(654.67), "金額");
        exBizCalcbleEquals((BizNumber) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 2), BizNumber.valueOf(21), "レート");
        exClassificationEquals((C_HasuusyoriKbn) MockObjectManager.getArgument(KeisanGaikakanzanMockForHozen.class, "exec", 2, 3), C_HasuusyoriKbn.AGE, "端数処理区分");

        exNumericEquals(wSuiihyouLst.size(), 3, "推移表テーブルエンティティリストの件数");

        IT_Suiihyou suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20190310), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(201903), "計算年月");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "06", "推移表種別");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(1), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(21), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(140000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(88110000), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(2), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(1), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(21), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(140000), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(88110000), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(3), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(1), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(21), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(140000), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(1234.56), "既払込保険料３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(88110000), "前納残高（円貨）３");

        exClassificationEquals(suiihyou.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用状態区分");
        exClassificationEquals(suiihyou.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyou.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou.getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou.getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup2(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame2(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown2(), BizNumber.valueOf(0), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtup3(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrtdown3(), BizNumber.valueOf(0), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendouup3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou.getSjkkktusirrthendoudown3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou.getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");

        IT_Suiihyou suiihyou1 = wSuiihyouLst.get(1);

        exNumericEquals(suiihyou1.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou1.getCalckijyunymd(), BizDate.valueOf(20190311), "計算基準日");
        exDateYMEquals(suiihyou1.getCalcym(), BizDateYM.valueOf(201903), "計算年月");
        exStringEquals(suiihyou1.getSuiihyousyubetu(), "06", "推移表種別");
        exClassificationEquals(suiihyou1.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(1), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(21), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen1(), BizCurrency.valueOf(140000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou1.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(2), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(1), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(21), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen2(), BizCurrency.valueOf(140000), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou1.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka2(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(3), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(1), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(21), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen3(), BizCurrency.valueOf(140000), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou1.getKihrkmp3(), BizCurrency.valueOf(1234.56), "既払込保険料３");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame3(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka3(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin3(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");

        IT_Suiihyou suiihyou2 = wSuiihyouLst.get(2);

        exNumericEquals(suiihyou2.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou2.getCalckijyunymd(), BizDate.valueOf(20200310), "計算基準日");
        exDateYMEquals(suiihyou2.getCalcym(), BizDateYM.valueOf(202003), "計算年月");
        exStringEquals(suiihyou2.getSuiihyousyubetu(), "06", "推移表種別");
        exClassificationEquals(suiihyou2.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou2.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(1), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyendaka(), BizNumber.valueOf(1), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(21), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou2.getKihrkmpyen1(), BizCurrency.valueOf(140000), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou2.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou2.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyendaka(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyenyasu(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou2.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou2.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou2.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(2), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(1), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(21), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou2.getKihrkmpyen2(), BizCurrency.valueOf(140000), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou2.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou2.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyendaka2(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou2.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou2.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou2.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(3), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(1), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(11), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(21), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou2.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou2.getKihrkmpyen3(), BizCurrency.valueOf(140000), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou2.getKihrkmp3(), BizCurrency.valueOf(1234.56), "既払込保険料３");
        exBizCalcbleEquals(suiihyou2.getMvanonewsame3(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyendaka3(), BizCurrency.valueOf(850000), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(780000), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou2.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(960000), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou2.getMvanoneptumitatekin3(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou2.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");

        exClassificationEquals(suiihyou2.getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用状態区分");
        exClassificationEquals(suiihyou2.getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtup(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtdown(), BizNumber.valueOf(0), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrthendouup(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrthendoudown(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）");
        exBizCalcbleEquals(suiihyou2.getMvaariwup(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(suiihyou2.getMvaariwsame(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(suiihyou2.getMvaariwdown(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyendaka(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyenkijyun(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyenyasu(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(suiihyou2.getMvaariptumitatekin(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(suiihyou2.getMkhyouyensysnikougk(), BizCurrency.valueOf(0), "目標到達時円建終身保険移行特約目標額");
        exBizCalcbleEquals(suiihyou2.getTmttknzoukaritu1(), BizNumber.valueOf(0), "積立金増加率１");
        exBizCalcbleEquals(suiihyou2.getTmttknzoukaritu2(), BizNumber.valueOf(0), "積立金増加率２");
        exBizCalcbleEquals(suiihyou2.getTmttknzoukaritu3(), BizNumber.valueOf(0), "積立金増加率３");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtup2(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtsame2(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtdown2(), BizNumber.valueOf(0), "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrthendouup2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrthendoudown2(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(suiihyou2.getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtup3(), BizNumber.valueOf(0), "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtsame(), BizNumber.valueOf(0), "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrtdown3(), BizNumber.valueOf(0), "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrthendouup3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(suiihyou2.getSjkkktusirrthendoudown3(), BizNumber.valueOf(0), "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(suiihyou2.getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(suiihyou2.getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(suiihyou2.getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(suiihyou2.getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(suiihyou2.getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(suiihyou2.getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
        exBizCalcbleEquals(suiihyou2.getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(suiihyou2.getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
        exBizCalcbleEquals(suiihyou2.getSisuuupritu1(), BizNumber.valueOf(0), "指数上昇率１");
        exBizCalcbleEquals(suiihyou2.getSisuuupritu2(), BizNumber.valueOf(0), "指数上昇率２");
        exBizCalcbleEquals(suiihyou2.getSisuuupritu3(), BizNumber.valueOf(0), "指数上昇率３");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(suiihyou2.getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");

    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        MockObjectManager.initialize();
        GetKawaseRateMock.SYORIPTN = null;
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN2;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(26);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180312));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SIN);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.BLNK);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 1, 0), BizDate.valueOf(20190311), "計算基準日");
        exDateYMEquals((BizDateYM) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 1, 1), BizDateYM.valueOf(201903), "基準年月");
        KeisanWExtBean keisanWExtBean2 = (KeisanWExtBean) MockObjectManager.getArgument(KeisanWMockForHozen.class, "exec", 1, 2);
        exStringEquals(keisanWExtBean2.getSyouhncd(), "ﾕｱ", "商品コード");
        exNumericEquals(keisanWExtBean2.getSyouhnsdno(), 1, "商品世代番号");
        exStringEquals(keisanWExtBean2.getRyouritusdno(), "10", "料率世代番号");
        exDateEquals(keisanWExtBean2.getKykymd(), BizDate.valueOf(20180312), "契約日");
        exBizCalcbleEquals(keisanWExtBean2.getHokenryou(), BizCurrency.valueOf(12300), "保険料");
        exClassificationEquals(keisanWExtBean2.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exClassificationEquals(keisanWExtBean2.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exNumericEquals(keisanWExtBean2.getHhknnen(), 25, "被保険者年齢");
        exNumericEquals(keisanWExtBean2.getHknkkn(), 26, "保険期間");
        exClassificationEquals(keisanWExtBean2.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean2.getHrkkkn(), 26, "払込期間");
        exClassificationEquals(keisanWExtBean2.getHrkkknsmnkbn(), C_HrkkknsmnKbn.SAIMANKI, "払込期間歳満期区分");
        exClassificationEquals(keisanWExtBean2.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exDateEquals(keisanWExtBean2.getFstpryosyuymd(), BizDate.valueOf(20190209), "初回保険料領収日");
        exBizCalcbleEquals(keisanWExtBean2.getYoteirrthendohosyurrt(), BizNumber.valueOf(0.1), "予定利率変動時保証利率");
        exDateYMEquals(keisanWExtBean2.getTmttkntaisyouym(), BizDateYM.valueOf(201904), "積立金対象年月");
        exBizCalcbleEquals(keisanWExtBean2.getPtmttkngk(), BizCurrency.valueOf(963852), "保険料積立金額");
        exBizCalcbleEquals(keisanWExtBean2.getKihrkmpstgk(), BizCurrency.valueOf(1234.555), "既払込保険料相当額");
        exClassificationEquals(keisanWExtBean2.getSisansyuruikbn(), C_KhSisanSyuruiKbn.SISAN, "（試算用）計算種類");
        exDateEquals(keisanWExtBean2.getSisansyoriymd(), BizDate.valueOf(20190312), "（試算用）処理日");
        exBizCalcbleEquals(keisanWExtBean2.getSisanyoteiriritu(), BizNumber.valueOf(10), "（試算用）予定利率");
        exBizCalcbleEquals(keisanWExtBean2.getSisankawaserate(), BizNumber.valueOf(0.5), "（試算用）為替レート");

        exNumericEquals(wSuiihyouLst.size(), 2, "推移表テーブルエンティティリストの件数");

        IT_Suiihyou suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20190311), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(201903), "計算年月");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "06", "推移表種別");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(10), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(148140), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(88111111), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");

        IT_Suiihyou suiihyou1 = wSuiihyouLst.get(1);

        exNumericEquals(suiihyou1.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou1.getCalckijyunymd(), BizDate.valueOf(20190312), "計算基準日");
        exDateYMEquals(suiihyou1.getCalcym(), BizDateYM.valueOf(201903), "計算年月");
        exStringEquals(suiihyou1.getSuiihyousyubetu(), "06", "推移表種別");
        exClassificationEquals(suiihyou1.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(10), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen1(), BizCurrency.valueOf(148140), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou1.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(0), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen2(), BizCurrency.valueOf(0), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou1.getKihrkmp2(), BizCurrency.valueOf(0), "既払込保険料２");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou1.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN3;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));
        yoteiRirituList.add(BizNumber.valueOf(20));
        yoteiRirituList.add(BizNumber.valueOf(30));
        yoteiRirituList.add(BizNumber.valueOf(40));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(26);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20190229));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 2, "推移表テーブルエンティティリストの件数");

        IT_Suiihyou suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(suiihyou.getKeikanensuu(), 0, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20200228), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202002), "計算年月");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "08", "推移表種別");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(10), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(148140), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(88111111), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(20), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(148140), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(88111111), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(30), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(148140), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(1234.56), "既払込保険料３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(88111111), "前納残高（円貨）３");

        IT_Suiihyou suiihyou1 = wSuiihyouLst.get(1);

        exNumericEquals(suiihyou1.getKeikanensuu(), 1, "経過年数");
        exDateEquals(suiihyou1.getCalckijyunymd(), BizDate.valueOf(20200229), "計算基準日");
        exDateYMEquals(suiihyou1.getCalcym(), BizDateYM.valueOf(202002), "計算年月");
        exStringEquals(suiihyou1.getSuiihyousyubetu(), "08", "推移表種別");
        exClassificationEquals(suiihyou1.getHrkkknmnryumukbn(), C_UmuKbn.ARI, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(10), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen1(), BizCurrency.valueOf(148140), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou1.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(20), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen2(), BizCurrency.valueOf(148140), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou1.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka2(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou1.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(30), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou1.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou1.getKihrkmpyen3(), BizCurrency.valueOf(148140), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou1.getKihrkmp3(), BizCurrency.valueOf(1234.56), "既払込保険料３");
        exBizCalcbleEquals(suiihyou1.getMvanonewsame3(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyendaka3(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou1.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou1.getMvanoneptumitatekin3(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou1.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));
        yoteiRirituList.add(BizNumber.valueOf(20));
        yoteiRirituList.add(BizNumber.valueOf(30));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(27);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180310));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190311));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.NONE);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 1, "推移表テーブルエンティティリストの件数");

        IT_Suiihyou suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20200309), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202003), "計算年月");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "07", "推移表種別");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(10), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(148140), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(20), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(148140), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(30), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(148140), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(1234.56), "既払込保険料３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));
        yoteiRirituList.add(BizNumber.valueOf(20));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(27);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180310));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190311));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.NONE);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 1, "推移表テーブルエンティティリストの件数");

        IT_Suiihyou suiihyou = wSuiihyouLst.get(0);

        exNumericEquals(suiihyou.getKeikanensuu(), 2, "経過年数");
        exDateEquals(suiihyou.getCalckijyunymd(), BizDate.valueOf(20200309), "計算基準日");
        exDateYMEquals(suiihyou.getCalcym(), BizDateYM.valueOf(202003), "計算年月");
        exStringEquals(suiihyou.getSuiihyousyubetu(), "09", "推移表種別");
        exClassificationEquals(suiihyou.getHrkkknmnryumukbn(), C_UmuKbn.NONE, "払込期間満了有無区分");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt1(), BizNumber.valueOf(10), "予定利率計算基準利率１");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka(), BizNumber.valueOf(0), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu(), BizNumber.valueOf(0), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen1(), BizCurrency.valueOf(148140), "既払込保険料（円貨）１");
        exBizCalcbleEquals(suiihyou.getKihrkmp1(), BizCurrency.valueOf(1234.56), "既払込保険料１");
        exBizCalcbleEquals(suiihyou.getMvanonewsame(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen1(), BizCurrency.valueOf(0), "前納残高（円貨）１");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt2(), BizNumber.valueOf(20), "予定利率計算基準利率２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka2(), BizNumber.valueOf(0), "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun2(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu2(), BizNumber.valueOf(0), "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(10), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen2(), BizCurrency.valueOf(148140), "既払込保険料（円貨）２");
        exBizCalcbleEquals(suiihyou.getKihrkmp2(), BizCurrency.valueOf(1234.56), "既払込保険料２");
        exBizCalcbleEquals(suiihyou.getMvanonewsame2(), BizCurrency.valueOf(654.67), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka2(), BizCurrency.valueOf(856957), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(789654), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu2(), BizCurrency.valueOf(963274), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin2(), BizCurrency.valueOf(963852), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen2(), BizCurrency.valueOf(0), "前納残高（円貨）２");

        exBizCalcbleEquals(suiihyou.getYtirrtcalckijyunrrt3(), BizNumber.valueOf(0), "予定利率計算基準利率３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyendaka3(), BizNumber.valueOf(0), "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenkijyun3(), BizNumber.valueOf(0), "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrateyenyasu3(), BizNumber.valueOf(0), "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(suiihyou.getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(suiihyou.getKihrkmpyen3(), BizCurrency.valueOf(0), "既払込保険料（円貨）３");
        exBizCalcbleEquals(suiihyou.getKihrkmp3(), BizCurrency.valueOf(0), "既払込保険料３");
        exBizCalcbleEquals(suiihyou.getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(suiihyou.getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(suiihyou.getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(suiihyou.getZennouzndkyen3(), BizCurrency.valueOf(0), "前納残高（円貨）３");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(10);
        keisanWExtBean.setHrkkkn(30);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180313));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setSinsaihkKbn(C_SinsaihkKbn.SAI);
        wSuiihyouParam.setSyoukensaihkKbn(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 0, "推移表テーブルエンティティリストの件数");
    }

    @Test
    @TestOrder(70)
    public void testExec_A7() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = KeisanGaikakanzanMockForHozen.TESTPATTERN1;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();
        yoteiRirituList.add(BizNumber.valueOf(10));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(10);
        keisanWExtBean.setHrkkkn(30);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180313));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        List<IT_Suiihyou> wSuiihyouLst = wSuiihyouNenkin2.exec(wSuiihyouParam);

        exNumericEquals(wSuiihyouLst.size(), 0, "推移表テーブルエンティティリストの件数");
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(80)
    public void testExec_A8() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN4;
        KeisanWMockForHozen.SYORIPTN = null;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(26);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180312));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        try {

            wSuiihyouNenkin2.exec(wSuiihyouParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。前納精算額計算が実行できませんでした。",
                "エラーメッセージ(CommonBizAppException)");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testExec_A9() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN2;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(26);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180312));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        try {

            wSuiihyouNenkin2.exec(wSuiihyouParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。解約返戻金計算が実行できませんでした。",
                "エラーメッセージ(CommonBizAppException)");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(100)
    public void testExec_A10() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN3;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(26);
        keisanWExtBean.setHrkkkn(26);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180312));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.SAIMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("ﾕｱ");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        try {

            wSuiihyouNenkin2.exec(wSuiihyouParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。解約返戻金計算が実行できませんでした。",
                "エラーメッセージ(CommonBizAppException)");
            throw e;
        }
    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(100)
    public void testExec_A11() {

        MockObjectManager.initialize();
        KeisanZennouSeisanGk2MockForHozen.SYORIPTN = KeisanZennouSeisanGk2MockForHozen.TESTPATTERN1;
        KeisanWMockForHozen.SYORIPTN = KeisanWMockForHozen.TESTPATTERN1;
        KeisanGaikakanzanMockForHozen.SYORIPTN = null;

        WSuiihyouNenkin2 wSuiihyouNenkin2 = SWAKInjector.getInstance(WSuiihyouNenkin2.class);

        WSuiihyouParam wSuiihyouParam = SWAKInjector.getInstance(WSuiihyouParam.class);

        KeisanWExtBean keisanWExtBean = SWAKInjector.getInstance(KeisanWExtBean.class);

        List<BizNumber> yoteiRirituList = new ArrayList<>();

        yoteiRirituList.add(BizNumber.valueOf(10));

        keisanWExtBean.setSisankawaserate(BizNumber.valueOf(0.5));
        keisanWExtBean.setHknkkn(10);
        keisanWExtBean.setHrkkkn(30);
        keisanWExtBean.setKykymd(BizDate.valueOf(20180311));
        keisanWExtBean.setHhknnen(25);
        keisanWExtBean.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        keisanWExtBean.setHrkkknsmnkbn(C_HrkkknsmnKbn.NENMANKI);
        keisanWExtBean.setTuukasyu(C_Tuukasyu.JPY);
        keisanWExtBean.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        keisanWExtBean.setTmttkntaisyouym(BizDateYM.valueOf(201903));
        keisanWExtBean.setPtmttkngk(BizCurrency.valueOf(147258));
        keisanWExtBean.setKihrkmpstgk(BizCurrency.valueOf(258963));
        keisanWExtBean.setSyouhncd("A100");
        keisanWExtBean.setSyouhnsdno(1);
        keisanWExtBean.setRyouritusdno("10");
        keisanWExtBean.setHokenryou(BizCurrency.valueOf(12300));
        keisanWExtBean.setHhknsei(C_Hhknsei.MALE);
        keisanWExtBean.setFstpryosyuymd(BizDate.valueOf(20190209));
        keisanWExtBean.setYoteirrthendohosyurrt(BizNumber.valueOf(0.1));

        wSuiihyouParam.setHeijyunP(BizCurrency.valueOf(12345));
        wSuiihyouParam.setZennoujiHrkP(BizCurrency.valueOf(100));
        wSuiihyouParam.setZennouKaisiYmd(BizDate.valueOf(20190309));
        wSuiihyouParam.setRyosyuYmd(BizDate.valueOf(20190308));
        wSuiihyouParam.setZennouNyuukingk(BizCurrency.valueOf(200));
        wSuiihyouParam.setKwsratekjymd(BizDate.valueOf(20170401));
        wSuiihyouParam.setCalcKijyunYmd(BizDate.valueOf(20190301));
        wSuiihyouParam.setZennouUmuKbn(C_UmuKbn.ARI);
        wSuiihyouParam.setKeisanWExtBean(keisanWExtBean);
        wSuiihyouParam.setYoteiRirituList(yoteiRirituList);

        wSuiihyouNenkin2.setYenkansannYhKbn(C_YouhiKbn.HUYOU);
        wSuiihyouNenkin2.setHasuusyoriYhKbn(C_YouhiKbn.HUYOU);

        try {

            wSuiihyouNenkin2.exec(wSuiihyouParam);

        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(),
                "システム整合性エラーです。契約時の予定利率が取得できませんでした。",
                "エラーメッセージ(CommonBizAppException)");
            throw e;
        }
    }
}
