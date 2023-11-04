package yuyu.common.suuri.srcommon;

import static org.junit.Assert.*;
import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.hozen.khcommon.IKhozenCommonConstants;
import yuyu.def.classification.C_HaitoukinsksKbn;
import yuyu.def.classification.C_HaitoumeisaiKbn;
import yuyu.def.classification.C_Hrkkeiro;
import yuyu.def.classification.C_Kykjyoutai;
import yuyu.def.classification.C_NaiteiKakuteiKbn;
import yuyu.def.classification.C_SyoriKbn;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_TumitateDSakuseiKbn;
import yuyu.def.db.entity.IT_KhDshrTuki;
import yuyu.def.db.entity.IT_KhHaitouKanri;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.entity.JT_SiDshrTuki;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * Ｄ支払統計データ作成クラスのメソッド {@link SrDshrTukiDataSks#exec(String)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class SrDshrTukiDataSksTest_exec {

    @Inject
    private SrDshrTukiDataSks srDshrTukiDataSks;

    @Test
    @TestOrder(10)
    public void testExec_A1() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSkno("no1");
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setSeikyuurirekiNo(8);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        List<BizNumber> ganrikincalcKariwariatedRirituLst = new ArrayList<>();
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0872));
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0592));

        List<BizNumber> ganrikincalcTumitatedRirituLst = new ArrayList<>();
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0564));
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0214));

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(ganrikincalcKariwariatedRirituLst);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(ganrikincalcTumitatedRirituLst);

        JT_SiDshrTuki jtSiDshrTuki = srDshrTukiDataSks.execSi(pEditDshrTukiTanKoumokuBean, pEditDshrTukiDKoumokuBean);

        exNumericEquals(jtSiDshrTuki.getRenno(), 1, "連番");
        exStringEquals(jtSiDshrTuki.getSkno(), "no1", "請求番号");
        exStringEquals(jtSiDshrTuki.getSyono(), "10806000016", "証券番号");
        exNumericEquals(jtSiDshrTuki.getSeikyuurirekino(), 8, "請求履歴番号");
        exStringEquals(jtSiDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(jtSiDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(jtSiDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(jtSiDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(jtSiDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(jtSiDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(jtSiDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(jtSiDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(jtSiDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(jtSiDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(jtSiDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", jtSiDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(jtSiDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(jtSiDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(jtSiDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(jtSiDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(jtSiDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(jtSiDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", jtSiDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(jtSiDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(jtSiDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(jtSiDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(jtSiDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(jtSiDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(jtSiDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(jtSiDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(jtSiDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(jtSiDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(jtSiDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(jtSiDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(jtSiDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(jtSiDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(jtSiDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0.0872),
            "仮割当Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0.0592),
            "仮割当Ｄ利率２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0.0564),
            "積立Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0.0214),
            "積立Ｄ利率２");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(20)
    public void testExec_A2() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSkno("no1");
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setSeikyuurirekiNo(8);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = null;

        JT_SiDshrTuki jtSiDshrTuki = srDshrTukiDataSks.execSi(pEditDshrTukiTanKoumokuBean, pEditDshrTukiDKoumokuBean);

        assertNull(jtSiDshrTuki);
    }

    @Test
    @TestOrder(30)
    public void testExec_A3() {
        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(null);
        pEditDshrTukiTanKoumokuBean.setSkno(null);
        pEditDshrTukiTanKoumokuBean.setSyono(null);
        pEditDshrTukiTanKoumokuBean.setSeikyuurirekiNo(null);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        List<BizNumber> ganrikincalcKariwariatedRirituLst = new ArrayList<>();
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0872));
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0592));

        List<BizNumber> ganrikincalcTumitatedRirituLst = new ArrayList<>();
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0564));
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0214));

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(ganrikincalcKariwariatedRirituLst);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(ganrikincalcTumitatedRirituLst);

        JT_SiDshrTuki jtSiDshrTuki = srDshrTukiDataSks.execSi(pEditDshrTukiTanKoumokuBean, pEditDshrTukiDKoumokuBean);

        exNumericEquals(jtSiDshrTuki.getRenno(), 1, "連番");
        exStringEquals(jtSiDshrTuki.getSkno(), "0", "請求番号");
        exStringEquals(jtSiDshrTuki.getSyono(), "0", "証券番号");
        exNumericEquals(jtSiDshrTuki.getSeikyuurirekino(), 0, "請求履歴番号");
        exStringEquals(jtSiDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(jtSiDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(jtSiDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(jtSiDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(jtSiDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(jtSiDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(jtSiDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(jtSiDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(jtSiDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(jtSiDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(jtSiDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", jtSiDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(jtSiDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(jtSiDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(jtSiDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(jtSiDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(jtSiDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(jtSiDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", jtSiDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(jtSiDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(jtSiDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(jtSiDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(jtSiDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(jtSiDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(jtSiDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(jtSiDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(jtSiDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(jtSiDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(jtSiDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(jtSiDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(jtSiDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(jtSiDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(jtSiDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0.0872),
            "仮割当Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0.0592),
            "仮割当Ｄ利率２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0.0564),
            "積立Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0.0214),
            "積立Ｄ利率２");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(40)
    public void testExec_A4() {
        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(null);
        pEditDshrTukiTanKoumokuBean.setSkno(null);
        pEditDshrTukiTanKoumokuBean.setSyono(null);
        pEditDshrTukiTanKoumokuBean.setSeikyuurirekiNo(null);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = null;

        JT_SiDshrTuki jtSiDshrTuki = srDshrTukiDataSks.execSi(pEditDshrTukiTanKoumokuBean, pEditDshrTukiDKoumokuBean);

        assertNull(jtSiDshrTuki);
    }

    @Test
    @TestOrder(50)
    public void testExec_A5() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSkno("no1");
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setSeikyuurirekiNo(8);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));

        JT_SiDshrTuki jtSiDshrTuki = srDshrTukiDataSks.execSi(pEditDshrTukiTanKoumokuBean, pEditDshrTukiDKoumokuBean);

        exNumericEquals(jtSiDshrTuki.getRenno(), 1, "連番");
        exStringEquals(jtSiDshrTuki.getSkno(), "no1", "請求番号");
        exStringEquals(jtSiDshrTuki.getSyono(), "10806000016", "証券番号");
        exNumericEquals(jtSiDshrTuki.getSeikyuurirekino(), 8, "請求履歴番号");
        exStringEquals(jtSiDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(jtSiDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(jtSiDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(jtSiDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(jtSiDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(jtSiDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(jtSiDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(jtSiDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(jtSiDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(jtSiDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(jtSiDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", jtSiDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(jtSiDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(jtSiDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(jtSiDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(jtSiDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(jtSiDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(jtSiDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", jtSiDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(jtSiDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(jtSiDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(jtSiDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(jtSiDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(jtSiDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(jtSiDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(jtSiDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(jtSiDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(jtSiDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(jtSiDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(jtSiDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(jtSiDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(jtSiDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(jtSiDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0), "仮割当Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0), "仮割当Ｄ利率２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0), "積立Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0), "積立Ｄ利率２");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(60)
    public void testExec_A6() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSkno("no1");
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setSeikyuurirekiNo(8);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        List<BizNumber> ganrikincalcKariwariatedRirituLst = new ArrayList<>();
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0872));

        List<BizNumber> ganrikincalcTumitatedRirituLst = new ArrayList<>();
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0564));

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(ganrikincalcKariwariatedRirituLst);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(ganrikincalcTumitatedRirituLst);

        JT_SiDshrTuki jtSiDshrTuki = srDshrTukiDataSks.execSi(pEditDshrTukiTanKoumokuBean, pEditDshrTukiDKoumokuBean);

        exNumericEquals(jtSiDshrTuki.getRenno(), 1, "連番");
        exStringEquals(jtSiDshrTuki.getSkno(), "no1", "請求番号");
        exStringEquals(jtSiDshrTuki.getSyono(), "10806000016", "証券番号");
        exNumericEquals(jtSiDshrTuki.getSeikyuurirekino(), 8, "請求履歴番号");
        exStringEquals(jtSiDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(jtSiDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(jtSiDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(jtSiDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(jtSiDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(jtSiDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(jtSiDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(jtSiDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(jtSiDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(jtSiDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(jtSiDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", jtSiDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(jtSiDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(jtSiDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(jtSiDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(jtSiDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(jtSiDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(jtSiDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", jtSiDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(jtSiDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(jtSiDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(jtSiDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(jtSiDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(jtSiDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(jtSiDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(jtSiDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(jtSiDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(jtSiDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(jtSiDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(jtSiDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(jtSiDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(jtSiDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(jtSiDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(jtSiDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0.0872),
            "仮割当Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0), "仮割当Ｄ利率２");
        exBizCalcbleEquals(jtSiDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0.0564),
            "積立Ｄ利率１");
        exBizCalcbleEquals(jtSiDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0), "積立Ｄ利率２");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(jtSiDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(70)
    public void testExec_B1() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        List<BizNumber> ganrikincalcKariwariatedRirituLst = new ArrayList<>();
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0872));
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0592));

        List<BizNumber> ganrikincalcTumitatedRirituLst = new ArrayList<>();
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0564));
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0214));

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(ganrikincalcKariwariatedRirituLst);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(ganrikincalcTumitatedRirituLst);

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnAri(pEditDshrTukiTanKoumokuBean,
            pEditDshrTukiDKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "10806000016", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(itKhDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(itKhDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(itKhDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(itKhDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(itKhDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", itKhDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(itKhDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(itKhDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(itKhDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(itKhDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(itKhDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0.0872),
            "仮割当Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0.0592),
            "仮割当Ｄ利率２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0.0564),
            "積立Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0.0214),
            "積立Ｄ利率２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(80)
    public void testExec_B2() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(null);
        pEditDshrTukiTanKoumokuBean.setSyono(null);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("khkanikeiyakunaiyouteisei");

        List<BizNumber> ganrikincalcKariwariatedRirituLst = new ArrayList<>();
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0872));
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0592));

        List<BizNumber> ganrikincalcTumitatedRirituLst = new ArrayList<>();
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0564));
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0214));

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(ganrikincalcKariwariatedRirituLst);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(ganrikincalcTumitatedRirituLst);

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnAri(pEditDshrTukiTanKoumokuBean,
            pEditDshrTukiDKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "0", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.MKHGKTTTYENDTHNKTORIKESI, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(itKhDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(itKhDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(itKhDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(itKhDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(itKhDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", itKhDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(itKhDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(itKhDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(itKhDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(itKhDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(itKhDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0.0872),
            "仮割当Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0.0592),
            "仮割当Ｄ利率２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0.0564),
            "積立Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0.0214),
            "積立Ｄ利率２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "khkanikeiyakunaiyouteisei", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(90)
    public void testExec_B3() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnAri(pEditDshrTukiTanKoumokuBean,
            pEditDshrTukiDKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "10806000016", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(itKhDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(itKhDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(itKhDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(itKhDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(itKhDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", itKhDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(itKhDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(itKhDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(itKhDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(itKhDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(itKhDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0), "仮割当Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0), "仮割当Ｄ利率２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0), "積立Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0), "積立Ｄ利率２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(100)
    public void testExec_B4() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        List<BizNumber> ganrikincalcKariwariatedRirituLst = new ArrayList<>();
        ganrikincalcKariwariatedRirituLst.add(BizNumber.valueOf(0.0872));

        List<BizNumber> ganrikincalcTumitatedRirituLst = new ArrayList<>();
        ganrikincalcTumitatedRirituLst.add(BizNumber.valueOf(0.0564));

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = SWAKInjector.getInstance(EditDshrTukiDKoumokuBean.class);
        pEditDshrTukiDKoumokuBean.setCalckijyunYmd(BizDate.valueOf("20200110"));
        pEditDshrTukiDKoumokuBean.setSyoriYmd2(BizDate.valueOf("20200109"));
        pEditDshrTukiDKoumokuBean.setJkipjytYm(BizDateYM.valueOf("202001"));
        pEditDshrTukiDKoumokuBean.setKinoubetukijyunYmd(BizDate.valueOf("20200111"));
        pEditDshrTukiDKoumokuBean.setGengkwari(BizNumber.valueOf(0.022));
        pEditDshrTukiDKoumokuBean.setItibushrGk(BizCurrency.valueOf(1690908));
        pEditDshrTukiDKoumokuBean.setHaitoushrKin(BizCurrency.valueOf(1690907));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk(BizCurrency.valueOf(1690906));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk(BizCurrency.valueOf(1690905));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk(BizCurrency.valueOf(1690904));
        pEditDshrTukiDKoumokuBean.setDkeisanhaitouKin(BizCurrency.valueOf(1549998));
        pEditDshrTukiDKoumokuBean.setDkeisannaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitounendo(BizDateY.valueOf(2018));
        pEditDshrTukiDKoumokuBean.setHaitoushrkinGk(BizCurrency.valueOf(1690903));
        pEditDshrTukiDKoumokuBean.setKariwariatedganrikinDshr(BizCurrency.valueOf(1690902));
        pEditDshrTukiDKoumokuBean.setTumitated(BizCurrency.valueOf(9));
        pEditDshrTukiDKoumokuBean.setTumitatedModosimae(BizCurrency.valueOf(8));
        pEditDshrTukiDKoumokuBean.setTumitatedModosigo(BizCurrency.valueOf(7));
        pEditDshrTukiDKoumokuBean.setTkbtHaitou(BizCurrency.valueOf(6));
        pEditDshrTukiDKoumokuBean.setHaitounendo2(BizDateY.valueOf(2020));
        pEditDshrTukiDKoumokuBean.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        pEditDshrTukiDKoumokuBean.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        pEditDshrTukiDKoumokuBean.setFstkariwariatedNendo(BizDateY.valueOf(2019));
        pEditDshrTukiDKoumokuBean.setTounendod(BizCurrency.valueOf(567));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setKariwariatedshrYmd(BizDate.valueOf(20130303));
        pEditDshrTukiDKoumokuBean.setKariwariatedruiGk2(BizCurrency.valueOf(123));
        pEditDshrTukiDKoumokuBean.setKariwariatedgngkknGk2(BizCurrency.valueOf(234));
        pEditDshrTukiDKoumokuBean.setKariwariatedshrGk2(BizCurrency.valueOf(456));
        pEditDshrTukiDKoumokuBean.setTumitatedtumitateYmd(BizDate.valueOf(20180802));
        pEditDshrTukiDKoumokuBean.setTumitatedsksKbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        pEditDshrTukiDKoumokuBean.setTumitated2(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setTumitatedshrkrkYmd(BizDate.valueOf(20180801));
        pEditDshrTukiDKoumokuBean.setNaiteikakuteiKbn2(C_NaiteiKakuteiKbn.KAKUTEI);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcKari(BizCurrency.valueOf(954));
        pEditDshrTukiDKoumokuBean.setGanrikincalcKariwariatedRirituLst(ganrikincalcKariwariatedRirituLst);
        pEditDshrTukiDKoumokuBean.setHaitouganrikincalcTumi(BizCurrency.valueOf(2));
        pEditDshrTukiDKoumokuBean.setGanrikincalcTumitatedRirituLst(ganrikincalcTumitatedRirituLst);

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnAri(pEditDshrTukiTanKoumokuBean,
            pEditDshrTukiDKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "10806000016", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exBizCalcbleEquals(itKhDshrTuki.getSiharaid(), BizCurrency.valueOf(0), "支払Ｄ");
        exDateEquals(itKhDshrTuki.getCalckijyunymd(), BizDate.valueOf("20200110"), "計算基準日");
        exDateEquals(itKhDshrTuki.getSyoriymd2(), BizDate.valueOf("20200109"), "処理年月日２");
        exDateYMEquals(itKhDshrTuki.getJkipjytym(), BizDateYM.valueOf("202001"), "次回Ｐ充当年月");
        exDateEquals(itKhDshrTuki.getKinoubetukijyunymd(), BizDate.valueOf("20200111"), "機能別基準日");
        assertEquals("減額割合", itKhDshrTuki.getGengkwari(), BizNumber.valueOf(0.022));
        exBizCalcbleEquals(itKhDshrTuki.getItibushrgk(), BizCurrency.valueOf(1690908),
            "一部支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkin(), BizCurrency.valueOf(1690907),
            "配当支払金");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk(), BizCurrency.valueOf(1690906),
            "仮割当Ｄ累計額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk(), BizCurrency.valueOf(1690905),
            "仮割当Ｄ減額金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk(), BizCurrency.valueOf(1690904),
            "仮割当Ｄ支払額");
        exBizCalcbleEquals(itKhDshrTuki.getDkeisanhaitoukin(), BizCurrency.valueOf(1549998), "配当金計算配当金");
        exClassificationEquals(itKhDshrTuki.getDkeisannaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI,
            "配当金計算内定確定区分");
        exDateYEquals(itKhDshrTuki.getHaitounendo(), BizDateY.valueOf(2018), "配当年度");
        exBizCalcbleEquals(itKhDshrTuki.getHaitoushrkingk(), BizCurrency.valueOf(1690903),
            "配当支払金額");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedganrikindshr(), BizCurrency.valueOf(1690902),
            "仮割当Ｄ元利金（配当支払金用）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated(), BizCurrency.valueOf(9), "積立Ｄ");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosimae(), BizCurrency.valueOf(8), "積立Ｄ（割戻し前）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedmodosigo(), BizCurrency.valueOf(7), "積立Ｄ（割戻し後）");
        exBizCalcbleEquals(itKhDshrTuki.getTkbthaitou(), BizCurrency.valueOf(6), "特別配当");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalckari(), BizCurrency.valueOf(954),
            "配当元利金計算（仮割当Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu1(), BizNumber.valueOf(0.0872),
            "仮割当Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedriritu2(), BizNumber.valueOf(0), "仮割当Ｄ利率２");
        exBizCalcbleEquals(itKhDshrTuki.getHaitouganrikincalctumi(), BizCurrency.valueOf(2),
            "配当元利金計算（積立Ｄ元利金）");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu1(), BizNumber.valueOf(0.0564),
            "積立Ｄ利率１");
        exBizCalcbleEquals(itKhDshrTuki.getTumitatedriritu2(), BizNumber.valueOf(0), "積立Ｄ利率２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(110)
    public void testExec_B5() {

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.KAIJO);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setSiharaid(BizCurrency.valueOf(0));
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou(IKhozenCommonConstants.KINOUID_KANIKEIYAKUNAIYOUTEISEI);

        EditDshrTukiDKoumokuBean pEditDshrTukiDKoumokuBean = null;

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnAri(pEditDshrTukiTanKoumokuBean,
            pEditDshrTukiDKoumokuBean);

        assertNull(itKhDshrTuki);
    }

    @Test
    @TestOrder(120)
    public void testExec_C1() {

        IT_KhHaitouKanri itKhHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        itKhHaitouKanri.setHaitounendo(BizDateY.valueOf(2020));
        itKhHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        itKhHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        itKhHaitouKanri.setFstkariwariatednendo(BizDateY.valueOf(2019));
        itKhHaitouKanri.setTounendod(BizCurrency.valueOf(567));
        itKhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        itKhHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20130303));
        itKhHaitouKanri.setKariwariatedruigk(BizCurrency.valueOf(123));
        itKhHaitouKanri.setKariwariatedgngkkngk(BizCurrency.valueOf(234));
        itKhHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(456));

        IT_KhTumitateDKanri itKhTumitateDKanri = SWAKInjector.getInstance(IT_KhTumitateDKanri.class);
        itKhTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180802));
        itKhTumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        itKhTumitateDKanri.setTumitated(BizCurrency.valueOf(2));
        itKhTumitateDKanri.setTumitatedshrkrkymd(BizDate.valueOf(20180801));
        itKhTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setKhHaitouKanri(itKhHaitouKanri);
        pEditDshrTukiTanKoumokuBean.setKhTumitateDKanri(itKhTumitateDKanri);
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnNasi(pEditDshrTukiTanKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "10806000016", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(130)
    public void testExec_C2() {
        IT_KhHaitouKanri itKhHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        itKhHaitouKanri.setHaitounendo(BizDateY.valueOf(2020));
        itKhHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        itKhHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        itKhHaitouKanri.setFstkariwariatednendo(BizDateY.valueOf(2019));
        itKhHaitouKanri.setTounendod(BizCurrency.valueOf(567));
        itKhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        itKhHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20130303));
        itKhHaitouKanri.setKariwariatedruigk(BizCurrency.valueOf(123));
        itKhHaitouKanri.setKariwariatedgngkkngk(BizCurrency.valueOf(234));
        itKhHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(456));

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(null);
        pEditDshrTukiTanKoumokuBean.setSyono(null);
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setKhHaitouKanri(itKhHaitouKanri);
        pEditDshrTukiTanKoumokuBean.setKhTumitateDKanri(null);
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnNasi(pEditDshrTukiTanKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "0", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), null, "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.BLNK, "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(0), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), null, "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.BLNK, "内定確定区分２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(140)
    public void testExec_C3() {

        IT_KhTumitateDKanri itKhTumitateDKanri = SWAKInjector.getInstance(IT_KhTumitateDKanri.class);
        itKhTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180802));
        itKhTumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        itKhTumitateDKanri.setTumitated(BizCurrency.valueOf(2));
        itKhTumitateDKanri.setTumitatedshrkrkymd(BizDate.valueOf(20180801));
        itKhTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setKhHaitouKanri(null);
        pEditDshrTukiTanKoumokuBean.setKhTumitateDKanri(itKhTumitateDKanri);
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("SrDshrTukiDataSks");

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnNasi(pEditDshrTukiTanKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "10806000016", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), null, "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.BLNK, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.BLNK, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), null, "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(0), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.BLNK, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), null, "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(0), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(0), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(0), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "SrDshrTukiDataSks", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }

    @Test
    @TestOrder(150)
    public void testExec_C4() {

        IT_KhTumitateDKanri itKhTumitateDKanri = SWAKInjector.getInstance(IT_KhTumitateDKanri.class);
        itKhTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180802));
        itKhTumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        itKhTumitateDKanri.setTumitated(BizCurrency.valueOf(2));
        itKhTumitateDKanri.setTumitatedshrkrkymd(BizDate.valueOf(20180801));
        itKhTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setKhHaitouKanri(null);
        pEditDshrTukiTanKoumokuBean.setKhTumitateDKanri(itKhTumitateDKanri);
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("khdhanei");

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnNasi(pEditDshrTukiTanKoumokuBean);

        assertNull(itKhDshrTuki);
    }

    @Test
    @TestOrder(160)
    public void testExec_C5() {

        IT_KhHaitouKanri itKhHaitouKanri = SWAKInjector.getInstance(IT_KhHaitouKanri.class);
        itKhHaitouKanri.setHaitounendo(BizDateY.valueOf(2020));
        itKhHaitouKanri.setHaitoukinskskbn(C_HaitoukinsksKbn.KARIWARIATE5);
        itKhHaitouKanri.setHaitoumeisaikbn(C_HaitoumeisaiKbn.SYU);
        itKhHaitouKanri.setFstkariwariatednendo(BizDateY.valueOf(2019));
        itKhHaitouKanri.setTounendod(BizCurrency.valueOf(567));
        itKhHaitouKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);
        itKhHaitouKanri.setKariwariatedshrymd(BizDate.valueOf(20130303));
        itKhHaitouKanri.setKariwariatedruigk(BizCurrency.valueOf(123));
        itKhHaitouKanri.setKariwariatedgngkkngk(BizCurrency.valueOf(234));
        itKhHaitouKanri.setKariwariatedshrgk(BizCurrency.valueOf(456));

        IT_KhTumitateDKanri itKhTumitateDKanri = SWAKInjector.getInstance(IT_KhTumitateDKanri.class);
        itKhTumitateDKanri.setTumitatedtumitateymd(BizDate.valueOf(20180802));
        itKhTumitateDKanri.setTumitatedskskbn(C_TumitateDSakuseiKbn.YENDTHNKSEISIKI);
        itKhTumitateDKanri.setTumitated(BizCurrency.valueOf(2));
        itKhTumitateDKanri.setTumitatedshrkrkymd(BizDate.valueOf(20180801));
        itKhTumitateDKanri.setNaiteikakuteikbn(C_NaiteiKakuteiKbn.KAKUTEI);

        EditDshrTukiTanKoumokuBean pEditDshrTukiTanKoumokuBean = SWAKInjector
            .getInstance(EditDshrTukiTanKoumokuBean.class);
        pEditDshrTukiTanKoumokuBean.setRenno(1);
        pEditDshrTukiTanKoumokuBean.setSyono("10806000016");
        pEditDshrTukiTanKoumokuBean.setHenkousikibetuKey("30");
        pEditDshrTukiTanKoumokuBean.setSyoriYmd(BizDate.valueOf("20200107"));
        pEditDshrTukiTanKoumokuBean.setSyoriKbn(C_SyoriKbn.BLNK);
        pEditDshrTukiTanKoumokuBean.setHrkkeiro(C_Hrkkeiro.KOUHURI);
        pEditDshrTukiTanKoumokuBean.setSyouhnCd("M120");
        pEditDshrTukiTanKoumokuBean.setSyouhnsdNo(1);
        pEditDshrTukiTanKoumokuBean.setKykjyoutai(C_Kykjyoutai.HRKMTYUU);
        pEditDshrTukiTanKoumokuBean.setSyoumetujiyuu(C_Syoumetujiyuu.KYKTORIKESI);
        pEditDshrTukiTanKoumokuBean.setKykymd(BizDate.valueOf("20200101"));
        pEditDshrTukiTanKoumokuBean.setYendthnkYmd(BizDate.valueOf("20200105"));
        pEditDshrTukiTanKoumokuBean.setKihons(BizCurrency.valueOf(1690901));
        pEditDshrTukiTanKoumokuBean.setYoteiriritu(BizNumber.valueOf(0.022));
        pEditDshrTukiTanKoumokuBean.setDenymd(BizDate.valueOf("20200106"));
        pEditDshrTukiTanKoumokuBean.setKhHaitouKanri(itKhHaitouKanri);
        pEditDshrTukiTanKoumokuBean.setKhTumitateDKanri(itKhTumitateDKanri);
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinsyaId("Junit");
        pEditDshrTukiTanKoumokuBean.setGyoumuKousinKinou("khdhanei");

        IT_KhDshrTuki itKhDshrTuki = srDshrTukiDataSks.execKhKsnNasi(pEditDshrTukiTanKoumokuBean);

        exNumericEquals(itKhDshrTuki.getRenno(), 1, "連番");
        exStringEquals(itKhDshrTuki.getSyono(), "10806000016", "証券番号");
        exStringEquals(itKhDshrTuki.getHenkousikibetukey(), "30", "変更識別キー");
        exDateEquals(itKhDshrTuki.getSyoriYmd(), BizDate.valueOf("20200107"), "処理年月日");
        exClassificationEquals(itKhDshrTuki.getSyorikbn(), C_SyoriKbn.BLNK, "処理区分");
        exClassificationEquals(itKhDshrTuki.getHrkkeiro(), C_Hrkkeiro.KOUHURI, "払込経路");
        exStringEquals(itKhDshrTuki.getSyouhncd(), "M120", "商品コード");
        exNumericEquals(itKhDshrTuki.getSyouhnsdno(), 1, "商品世代番号");
        exClassificationEquals(itKhDshrTuki.getKykjyoutai(), C_Kykjyoutai.HRKMTYUU, "契約状態");
        exClassificationEquals(itKhDshrTuki.getSyoumetujiyuu(), C_Syoumetujiyuu.KYKTORIKESI, "消滅事由");
        exDateEquals(itKhDshrTuki.getKykymd(), BizDate.valueOf("20200101"), "契約日");
        exDateEquals(itKhDshrTuki.getYendthnkymd(), BizDate.valueOf("20200105"), "円建変更日");
        exBizCalcbleEquals(itKhDshrTuki.getKihons(), BizCurrency.valueOf(1690901), "基本Ｓ");
        assertEquals("予定利率", itKhDshrTuki.getYoteiriritu(), BizNumber.valueOf(0.022));
        exDateEquals(itKhDshrTuki.getDenymd(), BizDate.valueOf("20200106"), "伝票日付");
        exDateYEquals(itKhDshrTuki.getHaitounendo2(), BizDateY.valueOf(2020), "配当年度２");
        exClassificationEquals(itKhDshrTuki.getHaitoukinskskbn(), C_HaitoukinsksKbn.KARIWARIATE5, "配当金作成区分");
        exClassificationEquals(itKhDshrTuki.getHaitoumeisaikbn(), C_HaitoumeisaiKbn.SYU, "配当明細区分");
        exDateYEquals(itKhDshrTuki.getFstkariwariatednendo(), BizDateY.valueOf(2019), "初回仮割当Ｄ年度");
        exBizCalcbleEquals(itKhDshrTuki.getTounendod(), BizCurrency.valueOf(567), "当年度Ｄ");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分");
        exDateEquals(itKhDshrTuki.getKariwariatedshrymd(), BizDate.valueOf(20130303), "仮割当Ｄ支払年月日");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedruigk2(), BizCurrency.valueOf(123), "仮割当Ｄ累計額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedgngkkngk2(), BizCurrency.valueOf(234), "仮割当Ｄ減額金額２");
        exBizCalcbleEquals(itKhDshrTuki.getKariwariatedshrgk2(), BizCurrency.valueOf(456), "仮割当Ｄ支払額２");
        exDateEquals(itKhDshrTuki.getTumitatedtumitateymd(), BizDate.valueOf(20180802), "積立Ｄ積立年月日");
        exClassificationEquals(itKhDshrTuki.getTumitatedskskbn(), C_TumitateDSakuseiKbn.YENDTHNKSEISIKI,
            "積立Ｄ作成区分");
        exBizCalcbleEquals(itKhDshrTuki.getTumitated2(), BizCurrency.valueOf(2), "積立Ｄ２");
        exDateEquals(itKhDshrTuki.getTumitatedshrkrkymd(), BizDate.valueOf(20180801), "積立Ｄ支払効力日");
        exClassificationEquals(itKhDshrTuki.getNaiteikakuteikbn2(), C_NaiteiKakuteiKbn.KAKUTEI, "内定確定区分２");
        exStringEquals(itKhDshrTuki.getGyoumuKousinsyaId(), "Junit", "業務用更新者ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinKinou(), "khdhanei", "業務用更新機能ＩＤ");
        exStringEquals(itKhDshrTuki.getGyoumuKousinTime().substring(0, 8),
            BizDate.getSysDateTimeMilli().substring(0, 8), "業務用更新時間");
    }
}