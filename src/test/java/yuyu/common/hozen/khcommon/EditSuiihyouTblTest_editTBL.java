package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_Hhknsei;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_MvaTekiyoujyoutaiKbn;
import yuyu.def.classification.C_SinsaihkKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_SyoukensaihkKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import yuyu.def.db.entity.IT_HhknSya;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSonotaTkyk;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;
import yuyu.testinfr.inject.MockModuleBinder;

import com.google.inject.AbstractModule;

/**
 * 推移表ＴＢＬ編集のメソッド {@link EditSuiihyouTbl#editTBL(KhozenCommonParam, IT_KykKihon, List<IT_KykSyouhn>, List<IT_KykSyouhn>, IT_HhknSya, BizDate)} テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class EditSuiihyouTblTest_editTBL {

    @Inject
    private EditSuiihyouTbl editSuiihyouTbl;

    @Inject
    BaseUserInfo baseUserInfo;

    @Before
    public void before(){
        MockModuleBinder.bind(new AbstractModule(){
            @Override
            protected void configure() {
                bind(WSuiihyou.class).to(WSuiihyouMockForHozen.class);
                bind(KeisanWExt.class).to(KeisanWExtMockForHozen.class);
            }
        });
    }

    @BeforeClass
    public static void testInit() {
        KeisanWExtMockForHozen.caller = EditSuiihyouTblTest_editTBL.class;
        WSuiihyouMockForHozen.caller = EditSuiihyouTblTest_editTBL.class;
    }

    @AfterClass
    public static void testClear() {
        MockObjectManager.initialize();
        WSuiihyouMockForHozen.caller = null;
        WSuiihyouMockForHozen.SYORIPTN = null;
        KeisanWExtMockForHozen.caller = null;
        KeisanWExtMockForHozen.SYORIPTN = null;
    }

    @Test
    @TestOrder(10)
    public void testEditTBL_A1() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN1;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User１");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160808));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123132));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.JPY);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160608));
        kykSyouhn.setHhknnen(26);
        kykSyouhn.setSyouhncd("1001");
        kykSyouhn.setSyouhnsdno(11);
        kykSyouhn.setRyouritusdno("21");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.SAIMANKI);
        kykSyouhn.setHknkkn(13);
        kykSyouhn.setHrkkkn(8);
        kykSyouhn.setHhknsei(C_Hhknsei.MALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(40));
        kykSyouhn.setHokenryou(BizCurrency.valueOf(30));
        kykSyouhn.setSetteibairitu(BizNumber.valueOf(1));
        kykSyouhn.setTmttknzoukaritujygn(BizNumber.valueOf(2));
        kykSyouhn.setKykjisisuurendourate(BizNumber.valueOf(3));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20160608);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160608));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SIN,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 1, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20160608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 99, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), null, "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), null, "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.BLNK, "契約通貨種類");
        exStringEquals(kykKihon.getSuiihyous().get(0).getSuiihyousyubetu(), "00", "推移表種別");

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouMockForHozen.class, "exec", 0, 0);

        KeisanWExtBean keisanWExtBean = wSuiihyouParam.getKeisanWExtBean();
        exStringEquals(keisanWExtBean.getSyouhncd(), "1001", "商品コード");
        exNumericEquals(keisanWExtBean.getSyouhnsdno(), 11, "商品世代番号");
        exStringEquals(keisanWExtBean.getRyouritusdno(), "21", "料率世代番号");
        exBizCalcbleEquals(keisanWExtBean.getYoteiriritu(), BizNumber.valueOf(40), "予定利率");
        exClassificationEquals(keisanWExtBean.getHrkkaisuu(), C_Hrkkaisuu.ITIJI, "払込回数");
        exClassificationEquals(keisanWExtBean.getHknkknsmnkbn(), C_HknkknsmnKbn.SAIMANKI, "保険期間歳満期区分");
        exNumericEquals(keisanWExtBean.getHknkkn(), 13, "保険期間");
        exNumericEquals(keisanWExtBean.getHrkkkn(), 8, "払込期間");
        exNumericEquals(keisanWExtBean.getHhknnen(), 26, "被保険者年齢");
        exClassificationEquals(keisanWExtBean.getHhknsei(), C_Hhknsei.MALE, "被保険者性別");
        exBizCalcbleEquals(keisanWExtBean.getKihons(), BizCurrency.valueOf(123132), "基本Ｓ");
        exBizCalcbleEquals(keisanWExtBean.getHokenryou(), BizCurrency.valueOf(30), "保険料");
        exDateEquals(keisanWExtBean.getKykymd(), BizDate.valueOf(20160608), "契約日");
        exClassificationEquals(keisanWExtBean.getTuukasyu(), C_Tuukasyu.JPY, "通貨種類");
        exBizCalcbleEquals(keisanWExtBean.getKyksjkkktyouseiriritu(), BizNumber.valueOf(40), "契約時市場価格調整用利率");

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20160808), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20160608), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SIN, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.ARI, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 20, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(1), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(2), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(3), "指数連動部分割合");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(200), "ターゲット特約基準金額");

    }

    @Test
    @TestOrder(20)
    public void testEditTBL_A2() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN6;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(2);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20150608);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SIN,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 1, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getSuiihyousyubetu(), "1", "推移表種別");

    }

    @Test
    @TestOrder(30)
    public void testEditTBL_A3() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN2;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(2);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20160507);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 7, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(1).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(1).getKeikanensuu(), 2, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(1).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(1).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtup(), BizNumber.valueOf(20), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtsame(), BizNumber.valueOf(21), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtdown(), BizNumber.valueOf(22), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendouup(), BizNumber.valueOf(23), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendoudown(), BizNumber.valueOf(24), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyendaka(), BizNumber.valueOf(25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(26), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(27), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMkhyouyensysnikougk(), BizCurrency.valueOf(28), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(2).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(2).getKeikanensuu(), 3, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(2).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(2).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtup(), BizNumber.valueOf(30), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtsame(), BizNumber.valueOf(31), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtdown(), BizNumber.valueOf(32), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendouup(), BizNumber.valueOf(33), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendoudown(), BizNumber.valueOf(34), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyendaka(), BizNumber.valueOf(35), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(36), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(37), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMkhyouyensysnikougk(), BizCurrency.valueOf(38), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(3).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(3).getKeikanensuu(), 4, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(3).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(3).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtup(), BizNumber.valueOf(40), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtsame(), BizNumber.valueOf(41), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtdown(), BizNumber.valueOf(42), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendouup(), BizNumber.valueOf(43), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendoudown(), BizNumber.valueOf(44), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyendaka(), BizNumber.valueOf(45), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(46), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(47), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMkhyouyensysnikougk(), BizCurrency.valueOf(48), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(4).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(4).getKeikanensuu(), 5, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(4).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(4).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtup(), BizNumber.valueOf(50), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtsame(), BizNumber.valueOf(51), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtdown(), BizNumber.valueOf(52), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendouup(), BizNumber.valueOf(53), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendoudown(), BizNumber.valueOf(54), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyendaka(), BizNumber.valueOf(55), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(56), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(57), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMkhyouyensysnikougk(), BizCurrency.valueOf(58), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(5).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(5).getKeikanensuu(), 6, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(5).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(5).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtup(), BizNumber.valueOf(60), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtsame(), BizNumber.valueOf(61), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtdown(), BizNumber.valueOf(62), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendouup(), BizNumber.valueOf(63), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendoudown(), BizNumber.valueOf(64), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyendaka(), BizNumber.valueOf(65), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(66), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(67), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMkhyouyensysnikougk(), BizCurrency.valueOf(68), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(6).getTyouhyouymd(), BizDate.valueOf(20160507), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(6).getKeikanensuu(), 11, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(6).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(6).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtup(), BizNumber.valueOf(110), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtsame(), BizNumber.valueOf(111), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtdown(), BizNumber.valueOf(112), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendouup(), BizNumber.valueOf(113), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendoudown(), BizNumber.valueOf(114), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyendaka(), BizNumber.valueOf(115), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(116), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(117), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMkhyouyensysnikougk(), BizCurrency.valueOf(118), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");
    }

    @Test
    @TestOrder(40)
    public void testEditTBL_A4() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN3;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("11807111118");
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(22);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhn.setSetteibairitu(BizNumber.valueOf(3));
        kykSyouhn.setTmttknzoukaritujygn(BizNumber.valueOf(4));
        kykSyouhn.setKykjisisuurendourate(BizNumber.valueOf(5));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20160508);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.NONE);
        syouhnZokusei.setMvatekikkn(10);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(300));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 14, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(1).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(1).getKeikanensuu(), 2, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(1).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(1).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtup(), BizNumber.valueOf(20), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtsame(), BizNumber.valueOf(21), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtdown(), BizNumber.valueOf(22), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendouup(), BizNumber.valueOf(23), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendoudown(), BizNumber.valueOf(24), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyendaka(), BizNumber.valueOf(25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(26), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(27), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMkhyouyensysnikougk(), BizCurrency.valueOf(28), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(2).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(2).getKeikanensuu(), 3, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(2).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(2).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtup(), BizNumber.valueOf(30), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtsame(), BizNumber.valueOf(31), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtdown(), BizNumber.valueOf(32), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendouup(), BizNumber.valueOf(33), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendoudown(), BizNumber.valueOf(34), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyendaka(), BizNumber.valueOf(35), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(36), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(37), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMkhyouyensysnikougk(), BizCurrency.valueOf(38), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(3).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(3).getKeikanensuu(), 4, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(3).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(3).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtup(), BizNumber.valueOf(40), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtsame(), BizNumber.valueOf(41), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtdown(), BizNumber.valueOf(42), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendouup(), BizNumber.valueOf(43), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendoudown(), BizNumber.valueOf(44), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyendaka(), BizNumber.valueOf(45), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(46), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(47), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMkhyouyensysnikougk(), BizCurrency.valueOf(48), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(4).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(4).getKeikanensuu(), 5, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(4).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(4).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtup(), BizNumber.valueOf(50), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtsame(), BizNumber.valueOf(51), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtdown(), BizNumber.valueOf(52), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendouup(), BizNumber.valueOf(53), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendoudown(), BizNumber.valueOf(54), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyendaka(), BizNumber.valueOf(55), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(56), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(57), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMkhyouyensysnikougk(), BizCurrency.valueOf(58), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(5).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(5).getKeikanensuu(), 10, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(5).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(5).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtup(), BizNumber.valueOf(100), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtsame(), BizNumber.valueOf(101), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtdown(), BizNumber.valueOf(102), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendouup(), BizNumber.valueOf(103), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendoudown(), BizNumber.valueOf(104), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyendaka(), BizNumber.valueOf(105), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(106), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(107), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMkhyouyensysnikougk(), BizCurrency.valueOf(108), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(6).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(6).getKeikanensuu(), 15, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(6).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(6).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtup(), BizNumber.valueOf(150), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtsame(), BizNumber.valueOf(151), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtdown(), BizNumber.valueOf(152), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendouup(), BizNumber.valueOf(153), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendoudown(), BizNumber.valueOf(154), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyendaka(), BizNumber.valueOf(155), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(156), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(157), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMkhyouyensysnikougk(), BizCurrency.valueOf(158), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(7).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(7).getKeikanensuu(), 20, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(7).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(7).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(7).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(7).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtup(), BizNumber.valueOf(200), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtsame(), BizNumber.valueOf(201), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtdown(), BizNumber.valueOf(202), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrthendouup(), BizNumber.valueOf(203), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrthendoudown(), BizNumber.valueOf(204), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyendaka(), BizNumber.valueOf(205), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(206), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(207), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMkhyouyensysnikougk(), BizCurrency.valueOf(208), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(7).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(7).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(8).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(8).getKeikanensuu(), 25, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(8).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(8).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(8).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(8).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrtup(), BizNumber.valueOf(250), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrtsame(), BizNumber.valueOf(251), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrtdown(), BizNumber.valueOf(252), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrthendouup(), BizNumber.valueOf(253), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrthendoudown(), BizNumber.valueOf(254), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrateyendaka(), BizNumber.valueOf(255), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(256), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(257), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMkhyouyensysnikougk(), BizCurrency.valueOf(258), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(8).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(8).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(9).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(9).getKeikanensuu(), 30, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(9).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(9).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(9).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(9).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrtup(), BizNumber.valueOf(300), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrtsame(), BizNumber.valueOf(301), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrtdown(), BizNumber.valueOf(302), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrthendouup(), BizNumber.valueOf(303), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrthendoudown(), BizNumber.valueOf(304), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrateyendaka(), BizNumber.valueOf(305), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(306), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(307), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMkhyouyensysnikougk(), BizCurrency.valueOf(308), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(9).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(9).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(10).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(10).getKeikanensuu(), 35, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(10).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(10).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(10).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(10).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrtup(), BizNumber.valueOf(350), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrtsame(), BizNumber.valueOf(351), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrtdown(), BizNumber.valueOf(352), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrthendouup(), BizNumber.valueOf(353), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrthendoudown(), BizNumber.valueOf(354), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrateyendaka(), BizNumber.valueOf(355), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(356), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(357), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMkhyouyensysnikougk(), BizCurrency.valueOf(358), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(10).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(10).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(11).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(11).getKeikanensuu(), 40, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(11).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(11).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(11).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(11).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrtup(), BizNumber.valueOf(400), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrtsame(), BizNumber.valueOf(401), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrtdown(), BizNumber.valueOf(402), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrthendouup(), BizNumber.valueOf(403), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrthendoudown(), BizNumber.valueOf(404), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrateyendaka(), BizNumber.valueOf(405), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(406), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(407), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMkhyouyensysnikougk(), BizCurrency.valueOf(408), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(11).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(11).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(12).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(12).getKeikanensuu(), 45, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(12).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(12).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(12).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(12).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrtup(), BizNumber.valueOf(450), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrtsame(), BizNumber.valueOf(451), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrtdown(), BizNumber.valueOf(452), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrthendouup(), BizNumber.valueOf(453), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrthendoudown(), BizNumber.valueOf(454), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrateyendaka(), BizNumber.valueOf(455), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(456), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(457), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMkhyouyensysnikougk(), BizCurrency.valueOf(458), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(12).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(12).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(13).getTyouhyouymd(), BizDate.valueOf(20160508), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(13).getKeikanensuu(), 50, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(13).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(13).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(13).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(13).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrtup(), BizNumber.valueOf(500), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrtsame(), BizNumber.valueOf(501), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrtdown(), BizNumber.valueOf(502), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrthendouup(), BizNumber.valueOf(503), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrthendoudown(), BizNumber.valueOf(504), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrateyendaka(), BizNumber.valueOf(505), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(506), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(507), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMkhyouyensysnikougk(), BizCurrency.valueOf(508), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(13).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(13).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exStringEquals((String) MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 0), "11807111118",
            "証券番号");
        exDateEquals((BizDate) MockObjectManager.getArgument(KeisanWExtMockForHozen.class, "exec", 0, 1),
            BizDate.valueOf(20160508), "計算基準日");

        WSuiihyouParam wSuiihyouParam =  (WSuiihyouParam) MockObjectManager.getArgument(WSuiihyouMockForHozen.class, "exec", 0, 0);

        exDateEquals(wSuiihyouParam.getKwsratekjymd(), BizDate.valueOf(20160608), "為替レート基準日");
        exDateEquals(wSuiihyouParam.getCalcKijyunYmd(), BizDate.valueOf(20160508), "計算基準日");
        exClassificationEquals(wSuiihyouParam.getSinsaihkKbn(), C_SinsaihkKbn.SAI, "新規再発行区分");
        exClassificationEquals(wSuiihyouParam.getSyoukensaihkKbn(), C_SyoukensaihkKbn.SYOUKENSAIHAKKOU, "証券再発行区分");
        exClassificationEquals(wSuiihyouParam.getMvaTekiUmu(), C_UmuKbn.NONE, "ＭＶＡ適用有無");
        exNumericEquals(wSuiihyouParam.getMvaTekiKkn(), 10, "ＭＶＡ適用期間");
        exBizCalcbleEquals(wSuiihyouParam.getSetteiBairitu(), BizNumber.valueOf(3), "設定倍率");
        exBizCalcbleEquals(wSuiihyouParam.getTmttknZoukarituJygn(), BizNumber.valueOf(4), "積立金増加率上限");
        exBizCalcbleEquals(wSuiihyouParam.getSisuurendourate(), BizNumber.valueOf(5), "指数連動部分割合");
        exBizCalcbleEquals(wSuiihyouParam.getTargetTkykKijyungk(), BizCurrency.valueOf(300), "ターゲット特約基準金額");

    }

    @Test
    @TestOrder(50)
    public void testEditTBL_A5() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN4;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User２");
        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(22);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20150608);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 14, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARINONE, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");


        exDateEquals(kykKihon.getSuiihyous().get(1).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(1).getKeikanensuu(), 2, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(1).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(1).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtup(), BizNumber.valueOf(20), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtsame(), BizNumber.valueOf(21), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtdown(), BizNumber.valueOf(22), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendouup(), BizNumber.valueOf(23), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendoudown(), BizNumber.valueOf(24), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyendaka(), BizNumber.valueOf(25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(26), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(27), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMkhyouyensysnikougk(), BizCurrency.valueOf(28), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(2).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(2).getKeikanensuu(), 3, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(2).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(2).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtup(), BizNumber.valueOf(30), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtsame(), BizNumber.valueOf(31), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtdown(), BizNumber.valueOf(32), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendouup(), BizNumber.valueOf(33), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendoudown(), BizNumber.valueOf(34), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyendaka(), BizNumber.valueOf(35), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(36), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(37), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMkhyouyensysnikougk(), BizCurrency.valueOf(38), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(3).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(3).getKeikanensuu(), 4, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(3).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(3).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtup(), BizNumber.valueOf(40), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtsame(), BizNumber.valueOf(41), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtdown(), BizNumber.valueOf(42), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendouup(), BizNumber.valueOf(43), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendoudown(), BizNumber.valueOf(44), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyendaka(), BizNumber.valueOf(45), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(46), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(47), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMkhyouyensysnikougk(), BizCurrency.valueOf(48), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(4).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(4).getKeikanensuu(), 5, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(4).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(4).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtup(), BizNumber.valueOf(50), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtsame(), BizNumber.valueOf(51), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtdown(), BizNumber.valueOf(52), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendouup(), BizNumber.valueOf(53), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendoudown(), BizNumber.valueOf(54), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyendaka(), BizNumber.valueOf(55), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(56), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(57), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMkhyouyensysnikougk(), BizCurrency.valueOf(58), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(5).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(5).getKeikanensuu(), 10, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(5).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(5).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtup(), BizNumber.valueOf(100), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtsame(), BizNumber.valueOf(101), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtdown(), BizNumber.valueOf(102), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendouup(), BizNumber.valueOf(103), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendoudown(), BizNumber.valueOf(104), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyendaka(), BizNumber.valueOf(105), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(106), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(107), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMkhyouyensysnikougk(), BizCurrency.valueOf(108), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(6).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(6).getKeikanensuu(), 15, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(6).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(6).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtup(), BizNumber.valueOf(150), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtsame(), BizNumber.valueOf(151), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtdown(), BizNumber.valueOf(152), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendouup(), BizNumber.valueOf(153), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendoudown(), BizNumber.valueOf(154), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyendaka(), BizNumber.valueOf(155), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(156), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(157), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMkhyouyensysnikougk(), BizCurrency.valueOf(158), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(7).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(7).getKeikanensuu(), 20, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(7).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(7).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(7).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(7).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtup(), BizNumber.valueOf(200), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtsame(), BizNumber.valueOf(201), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtdown(), BizNumber.valueOf(202), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrthendouup(), BizNumber.valueOf(203), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrthendoudown(), BizNumber.valueOf(204), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyendaka(), BizNumber.valueOf(205), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(206), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(207), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMkhyouyensysnikougk(), BizCurrency.valueOf(208), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(7).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(7).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(8).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(8).getKeikanensuu(), 25, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(8).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(8).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(8).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(8).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrtup(), BizNumber.valueOf(250), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrtsame(), BizNumber.valueOf(251), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrtdown(), BizNumber.valueOf(252), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrthendouup(), BizNumber.valueOf(253), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getSjkkktusirrthendoudown(), BizNumber.valueOf(254), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrateyendaka(), BizNumber.valueOf(255), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(256), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(257), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(8).getMkhyouyensysnikougk(), BizCurrency.valueOf(258), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(8).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(8).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(9).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(9).getKeikanensuu(), 30, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(9).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(9).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(9).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(9).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrtup(), BizNumber.valueOf(300), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrtsame(), BizNumber.valueOf(301), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrtdown(), BizNumber.valueOf(302), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrthendouup(), BizNumber.valueOf(303), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getSjkkktusirrthendoudown(), BizNumber.valueOf(304), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrateyendaka(), BizNumber.valueOf(305), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(306), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(307), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(9).getMkhyouyensysnikougk(), BizCurrency.valueOf(308), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(9).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(9).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(10).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(10).getKeikanensuu(), 35, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(10).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(10).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(10).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(10).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrtup(), BizNumber.valueOf(350), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrtsame(), BizNumber.valueOf(351), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrtdown(), BizNumber.valueOf(352), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrthendouup(), BizNumber.valueOf(353), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getSjkkktusirrthendoudown(), BizNumber.valueOf(354), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrateyendaka(), BizNumber.valueOf(355), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(356), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(357), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(10).getMkhyouyensysnikougk(), BizCurrency.valueOf(358), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(10).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(10).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(11).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(11).getKeikanensuu(), 40, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(11).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(11).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(11).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(11).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrtup(), BizNumber.valueOf(400), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrtsame(), BizNumber.valueOf(401), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrtdown(), BizNumber.valueOf(402), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrthendouup(), BizNumber.valueOf(403), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getSjkkktusirrthendoudown(), BizNumber.valueOf(404), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrateyendaka(), BizNumber.valueOf(405), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(406), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(407), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(11).getMkhyouyensysnikougk(), BizCurrency.valueOf(408), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(11).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(11).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(12).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(12).getKeikanensuu(), 45, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(12).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(12).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(12).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(12).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrtup(), BizNumber.valueOf(450), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrtsame(), BizNumber.valueOf(451), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrtdown(), BizNumber.valueOf(452), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrthendouup(), BizNumber.valueOf(453), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getSjkkktusirrthendoudown(), BizNumber.valueOf(454), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrateyendaka(), BizNumber.valueOf(455), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(456), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(457), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(12).getMkhyouyensysnikougk(), BizCurrency.valueOf(458), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(12).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(12).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(13).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(13).getKeikanensuu(), 50, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(13).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(13).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(13).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(13).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrtup(), BizNumber.valueOf(500), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrtsame(), BizNumber.valueOf(501), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrtdown(), BizNumber.valueOf(502), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrthendouup(), BizNumber.valueOf(503), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getSjkkktusirrthendoudown(), BizNumber.valueOf(504), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrateyendaka(), BizNumber.valueOf(505), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(506), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(507), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(13).getMkhyouyensysnikougk(), BizCurrency.valueOf(508), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(13).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(13).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

    }

    @Test
    @TestOrder(60)
    public void testEditTBL_A6() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN5;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(22);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20150608);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 8, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(1).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(1).getKeikanensuu(), 2, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(1).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(1).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(1).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtup(), BizNumber.valueOf(20), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtsame(), BizNumber.valueOf(21), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrtdown(), BizNumber.valueOf(22), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendouup(), BizNumber.valueOf(23), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getSjkkktusirrthendoudown(), BizNumber.valueOf(24), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyendaka(), BizNumber.valueOf(25), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(26), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(27), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(1).getMkhyouyensysnikougk(), BizCurrency.valueOf(28), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(1).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(2).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(2).getKeikanensuu(), 3, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(2).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(2).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(2).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtup(), BizNumber.valueOf(30), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtsame(), BizNumber.valueOf(31), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrtdown(), BizNumber.valueOf(32), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendouup(), BizNumber.valueOf(33), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getSjkkktusirrthendoudown(), BizNumber.valueOf(34), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyendaka(), BizNumber.valueOf(35), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(36), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(37), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(2).getMkhyouyensysnikougk(), BizCurrency.valueOf(38), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(2).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(3).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(3).getKeikanensuu(), 4, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(3).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(3).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.BLNK, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(3).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtup(), BizNumber.valueOf(40), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtsame(), BizNumber.valueOf(41), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrtdown(), BizNumber.valueOf(42), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendouup(), BizNumber.valueOf(43), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getSjkkktusirrthendoudown(), BizNumber.valueOf(44), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyendaka(), BizNumber.valueOf(45), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(46), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(47), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(3).getMkhyouyensysnikougk(), BizCurrency.valueOf(48), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(3).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(4).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(4).getKeikanensuu(), 5, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(4).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(4).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARINONE, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(4).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtup(), BizNumber.valueOf(50), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtsame(), BizNumber.valueOf(51), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrtdown(), BizNumber.valueOf(52), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendouup(), BizNumber.valueOf(53), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getSjkkktusirrthendoudown(), BizNumber.valueOf(54), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyendaka(), BizNumber.valueOf(55), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(56), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(57), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(4).getMkhyouyensysnikougk(), BizCurrency.valueOf(58), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(4).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(5).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(5).getKeikanensuu(), 6, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(5).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(5).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(5).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtup(), BizNumber.valueOf(60), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtsame(), BizNumber.valueOf(61), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrtdown(), BizNumber.valueOf(62), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendouup(), BizNumber.valueOf(63), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getSjkkktusirrthendoudown(), BizNumber.valueOf(64), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyendaka(), BizNumber.valueOf(65), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(66), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(67), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(5).getMkhyouyensysnikougk(), BizCurrency.valueOf(68), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(5).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(6).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(6).getKeikanensuu(), 10, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(6).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(6).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVANONE, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(6).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtup(), BizNumber.valueOf(100), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtsame(), BizNumber.valueOf(101), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrtdown(), BizNumber.valueOf(102), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendouup(), BizNumber.valueOf(103), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getSjkkktusirrthendoudown(), BizNumber.valueOf(104), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyendaka(), BizNumber.valueOf(105), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(106), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(107), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(6).getMkhyouyensysnikougk(), BizCurrency.valueOf(108), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(6).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

        exDateEquals(kykKihon.getSuiihyous().get(7).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(7).getKeikanensuu(), 11, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(7).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(7).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(7).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARINONE, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(7).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtup(), BizNumber.valueOf(110), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtsame(), BizNumber.valueOf(111), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrtdown(), BizNumber.valueOf(112), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrthendouup(), BizNumber.valueOf(113), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getSjkkktusirrthendoudown(), BizNumber.valueOf(114), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyendaka(), BizNumber.valueOf(115), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(116), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(117), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(7).getMkhyouyensysnikougk(), BizCurrency.valueOf(118), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(7).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(7).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

    }
    @Test
    @TestOrder(70)
    public void testEditTBL_A7() {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN7;
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(22);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20150608);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 1, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSisuuupritu1(), BizNumber.ZERO, "指数上昇率１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTmttknzoukaritu1(), BizNumber.ZERO, "積立金増加率１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTutmttknutiwake11(), BizCurrency.valueOf(0), "積立金内訳（１）１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTutmttknutiwake21(), BizCurrency.valueOf(0), "積立金内訳（２）１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaeup1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaesame1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaedown1(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）１");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup2(), BizNumber.ZERO, "市場価格調整用利率（上昇）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame2(), BizNumber.ZERO, "市場価格調整用利率（同水準）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown2(), BizNumber.ZERO, "市場価格調整用利率（低下）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup2(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown2(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka2(), BizNumber.ZERO, "円換算適用為替レート（円高）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun2(), BizNumber.ZERO, "円換算適用為替レート（中央値）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu2(), BizNumber.ZERO, "円換算適用為替レート（円安）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu2(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSisuuupritu2(), BizNumber.ZERO, "指数上昇率２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTmttknzoukaritu2(), BizNumber.ZERO, "積立金増加率２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaeup2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaesame2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaedown2(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu2(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin2(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTutmttknutiwake12(), BizCurrency.valueOf(0), "積立金内訳（１）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTutmttknutiwake22(), BizCurrency.valueOf(0), "積立金内訳（２）２");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup3(), BizNumber.ZERO, "市場価格調整用利率（上昇）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame3(), BizNumber.ZERO, "市場価格調整用利率（同水準）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown3(), BizNumber.ZERO, "市場価格調整用利率（低下）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup3(), BizNumber.ZERO, "市場価格調整用利率変動幅（上）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown3(), BizNumber.ZERO, "市場価格調整用利率変動幅（下）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka3(), BizNumber.ZERO, "円換算適用為替レート（円高）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun3(), BizNumber.ZERO, "円換算適用為替レート（中央値）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu3(), BizNumber.ZERO, "円換算適用為替レート（円安）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円高）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu3(), BizCurrency.valueOf(0), "円換算適用為替レート変動額（円安）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSisuuupritu3(), BizNumber.ZERO, "指数上昇率３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTmttknzoukaritu3(), BizNumber.ZERO, "積立金増加率３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaeup3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（上昇）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaesame3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（同水準）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaaritmttkgkkykkjmaedown3(), BizCurrency.valueOf(0), "ＭＶＡ適用積立金額（解約控除前）（低下）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（上昇）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（同水準）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（低下）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用保険料積立金３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円高）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu3(), BizCurrency.valueOf(0), "ＭＶＡ適用外解約返戻金額（円貨）（円安）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin3(), BizCurrency.valueOf(0), "ＭＶＡ適用外保険料積立金３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTutmttknutiwake13(), BizCurrency.valueOf(0), "積立金内訳（１）３");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getTutmttknutiwake23(), BizCurrency.valueOf(0), "積立金内訳（２）３");
        exStringEquals(kykKihon.getSuiihyous().get(0).getSuiihyousyubetu(), "05", "推移表種別");

    }

    @Test
    @TestOrder(80)
    public void testEditTBL_A8() {

        MockObjectManager.initialize();
        KeisanWExtMockForHozen.SYORIPTN = KeisanWExtMockForHozen.TESTPATTERN2;
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN7;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(22);
        kykSyouhn.setSyouhncd("ﾕｹ");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(6);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhn.setHokenryou(BizCurrency.valueOf(200));
        kykSyouhn.setKykjisisuurendourate(BizNumber.valueOf(5));
        kykSyouhn.setSisuukbn(C_Sisuukbn.BLCON1);
        kykSyouhn.setSetteibairitu(BizNumber.valueOf(3));
        kykSyouhn.setTmttknzoukaritujygn(BizNumber.valueOf(4));
        kykSyouhn.setTumitateriritu(BizNumber.valueOf(6));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20150608);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        editSuiihyouTbl.editTBL(
            khozenCommonParam,
            kykKihon,
            kykSyouhnLst,
            kykSyouhnTkLst,
            hhknSya,
            syoriYmd,
            editHokenSyoukenParam,
            C_SinsaihkKbn.SAI,
            syouhnZokusei,
            kykSonotaTkyk);

        exNumericEquals(kykKihon.getSuiihyous().size(), 1, "推移表テーブルエンティティリストの件数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getTyouhyouymd(), BizDate.valueOf(20150608), "帳票作成日");
        exNumericEquals(kykKihon.getSuiihyous().get(0).getKeikanensuu(), 1, "経過年数");
        exDateEquals(kykKihon.getSuiihyous().get(0).getCalckijyunymd(), BizDate.valueOf(20160505), "計算基準日");
        exDateYMEquals(kykKihon.getSuiihyous().get(0).getCalcym(), BizDateYM.valueOf(201605), "計算年月");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getMvatekijyoutaikbn(), C_MvaTekiyoujyoutaiKbn.MVAARI, "ＭＶＡ適用種類区分");
        exClassificationEquals(kykKihon.getSuiihyous().get(0).getKyktuukasyu(), C_Tuukasyu.USD, "契約通貨種類");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtup(), BizNumber.valueOf(10), "市場価格調整用利率（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtsame(), BizNumber.valueOf(11), "市場価格調整用利率（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrtdown(), BizNumber.valueOf(12), "市場価格調整用利率（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendouup(), BizNumber.valueOf(13), "市場価格調整用利率変動幅（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getSjkkktusirrthendoudown(), BizNumber.valueOf(14), "市場価格調整用利率変動幅（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyendaka(), BizNumber.valueOf(15), "円換算適用為替レート（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenkijyun(), BizNumber.valueOf(16), "円換算適用為替レート（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrateyenyasu(), BizNumber.valueOf(17), "円換算適用為替レート（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyendaka(), BizCurrency.valueOf(200000), "円換算適用為替レート変動額（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getYenknsnkwsrategkyenyasu(), BizCurrency.valueOf(201010), "円換算適用為替レート変動額（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwup(), BizCurrency.valueOf(101010), "ＭＶＡ適用解約返戻金額（上昇）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwsame(), BizCurrency.valueOf(100000), "ＭＶＡ適用解約返戻金額（同水準）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwdown(), BizCurrency.valueOf(212121), "ＭＶＡ適用解約返戻金額（低下）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyendaka(), BizCurrency.valueOf(202222), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenkijyun(), BizCurrency.valueOf(454544), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyenupyenyasu(), BizCurrency.valueOf(555555), "ＭＶＡ適用解約返戻金額（円貨）（上昇）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyendaka(), BizCurrency.valueOf(414141), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenkijyun(), BizCurrency.valueOf(575755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyensameyenyasu(), BizCurrency.valueOf(577755), "ＭＶＡ適用解約返戻金額（円貨）（同水準）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyendaka(), BizCurrency.valueOf(847474), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenkijyun(), BizCurrency.valueOf(785757), "ＭＶＡ適用解約返戻金額（円貨）（低下）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariwyendownyenyasu(), BizCurrency.valueOf(456343), "ＭＶＡ適用解約返戻金額（円貨）（低下）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvaariptumitatekin(), BizCurrency.valueOf(421758), "ＭＶＡ適用保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewsame(), BizCurrency.valueOf(453444), "ＭＶＡ適用外解約返戻金額");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyendaka(), BizCurrency.valueOf(444444), "ＭＶＡ適用外解約返戻金額（円貨）（円高）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenkijyun(), BizCurrency.valueOf(788787), "ＭＶＡ適用外解約返戻金額（円貨）（中央値）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanonewyensameyenyasu(), BizCurrency.valueOf(787878), "ＭＶＡ適用外解約返戻金額（円貨）（円安）");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMvanoneptumitatekin(), BizCurrency.valueOf(787878), "ＭＶＡ適用外保険料積立金");
        exBizCalcbleEquals(kykKihon.getSuiihyous().get(0).getMkhyouyensysnikougk(), BizCurrency.valueOf(18), "目標到達時円建終身保険移行特約目標額");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinKinou(), "EditSuiihyouTbl", "業務用更新機能ＩＤ");
        exStringEquals(kykKihon.getSuiihyous().get(0).getGyoumuKousinsyaId(), "User２", "業務用更新者ＩＤ");

    }

    @Test(expected = CommonBizAppException.class)
    @TestOrder(90)
    public void testEditTBL_A9() throws Exception {

        MockObjectManager.initialize();
        WSuiihyouMockForHozen.SYORIPTN = WSuiihyouMockForHozen.TESTPATTERN3;
        KeisanWExtMockForHozen.SYORIPTN= KeisanWExtMockForHozen.TESTPATTERN1;

        baseUserInfo.getUser().setUserId("User２");

        KhozenCommonParam khozenCommonParam = SWAKInjector.getInstance(KhozenCommonParam.class);
        khozenCommonParam.setFunctionId("EditSuiihyouTbl");

        IT_KykKihon kykKihon = new IT_KykKihon();
        kykKihon.setSyono("11807111118");
        kykKihon.setHrkkaisuu(C_Hrkkaisuu.ITIJI);
        kykKihon.setFstpnyknymd(BizDate.valueOf(20160608));

        List<IT_KykSyouhn> kykSyouhnLst = new ArrayList<>();
        IT_KykSyouhn kykSyouhn = new IT_KykSyouhn();
        kykSyouhn.setKihons(BizCurrency.valueOf(123000));
        kykSyouhn.setKyktuukasyu(C_Tuukasyu.USD);
        kykSyouhn.setYoteiriritu(BizNumber.valueOf(40));
        kykSyouhn.setKykymd(BizDate.valueOf(20160508));
        kykSyouhn.setHhknnen(22);
        kykSyouhn.setSyouhncd("1101");
        kykSyouhn.setSyouhnsdno(12);
        kykSyouhn.setRyouritusdno("22");
        kykSyouhn.setHknkknsmnkbn(C_HknkknsmnKbn.NENMANKI);
        kykSyouhn.setHknkkn(15);
        kykSyouhn.setHrkkkn(4);
        kykSyouhn.setHhknsei(C_Hhknsei.FEMALE);
        kykSyouhn.setKyksjkkktyouseiriritu(BizNumber.valueOf(20));
        kykSyouhnLst.add(kykSyouhn);

        List<IT_KykSyouhn> kykSyouhnTkLst = null;

        IT_HhknSya hhknSya = null;

        BizDate syoriYmd = BizDate.valueOf(20160509);

        EditHokenSyoukenParam editHokenSyoukenParam = SWAKInjector.getInstance(EditHokenSyoukenParam.class);
        editHokenSyoukenParam.setCalckijyunYMD(BizDate.valueOf(20160508));
        editHokenSyoukenParam.setSyoukenSaihk(C_SyoukensaihkKbn.SYOUKENSAIHAKKOU);

        BM_SyouhnZokusei syouhnZokusei = new BM_SyouhnZokusei();
        syouhnZokusei.setMvatekiumu(C_UmuKbn.ARI);
        syouhnZokusei.setMvatekikkn(20);

        IT_KykSonotaTkyk kykSonotaTkyk = new IT_KykSonotaTkyk();
        kykSonotaTkyk.setTargettkykkijyungk(BizCurrency.valueOf(200));

        try{
            editSuiihyouTbl.editTBL(
                khozenCommonParam,
                kykKihon,
                kykSyouhnLst,
                kykSyouhnTkLst,
                hhknSya,
                syoriYmd,
                editHokenSyoukenParam,
                C_SinsaihkKbn.SAI,
                syouhnZokusei,
                kykSonotaTkyk);
        } catch (CommonBizAppException e) {
            exStringEquals(e.getMessage(), "システム整合性エラーです。解約返戻金計算拡張情報作成が実行できませんでした。", "メッセージ内容");
            throw e;
        }
    }
}
