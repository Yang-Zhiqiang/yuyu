package yuyu.common.hozen.khcommon;

import static yuyu.testinfr.YuyuFunctionTestUtil.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.number.BizCurrency;

import org.junit.Test;
import org.junit.runner.RunWith;

import yuyu.common.biz.kaikei.BzSiwakeMeisaiBean;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_KawasetekiyoKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.testinfr.OrderedRunner;
import yuyu.testinfr.TestOrder;

/**
 * 仕訳共通ユーティリティクラスのメソッド {@link CommonSiwakeUtil#execTaisyakuTyousei(C_Tuukasyu,
 * List<BzSiwakeMeisaiBean>)}テスト用クラスです<br />
 */
@RunWith(OrderedRunner.class)
public class CommonSiwakeUtilTest_execTaisyakuTyousei {

    @Inject
    private CommonSiwakeUtil commonSiwakeUtil;

    @Test
    @TestOrder(10)
    public void testExecTaisyakuTyousei_A1() {
        C_Tuukasyu tuukasyu = C_Tuukasyu.USD;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = commonSiwakeUtil.execTaisyakuTyousei(tuukasyu,
            bzSiwakeMeisaiBeanLst);
        exNumericEquals(bzSiwakeMeisaiBeanList.size(), 0, "仕訳明細リスト");
    }

    @Test
    @TestOrder(20)
    public void testExecTaisyakuTyousei_A2() {
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean.setIbTaisyakukbn(C_TaisyakuKbn.BLNK);
        bzSiwakeMeisaiBean.setIbKanjyoukmkcd(C_Kanjyoukmkcd.BLNK);
        bzSiwakeMeisaiBean.setIbSuitoubumoncd("");
        bzSiwakeMeisaiBean.setIbDengaikagk(BizCurrency.valueOf(0));
        bzSiwakeMeisaiBean.setIbDenyenkagk(BizCurrency.valueOf(0));
        bzSiwakeMeisaiBean.setIbSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean.setIbSeg2cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean.setIbKeiyakutuukagk(BizCurrency.valueOf(0));
        bzSiwakeMeisaiBean.setIbKawasetekiyokbn(C_KawasetekiyoKbn.BLNK);
        bzSiwakeMeisaiBean.setIbDenkarikanjyono("");
        bzSiwakeMeisaiBean.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = commonSiwakeUtil.execTaisyakuTyousei(tuukasyu,
            bzSiwakeMeisaiBeanLst);
        exNumericEquals(bzSiwakeMeisaiBeanList.size(), 1, "仕訳明細リスト");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.BLNK, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.BLNK, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(0), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(0), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.BLNK, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");
    }

    @Test
    @TestOrder(30)
    public void testExecTaisyakuTyousei_A3() {
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean1.setIbSuitoubumoncd("A01");
        bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000));
        bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
        bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(45000));
        bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        bzSiwakeMeisaiBean1.setIbDenkarikanjyono("200001");
        bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean1);
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean2.setIbSuitoubumoncd("A02");
        bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000));
        bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20000));
        bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        bzSiwakeMeisaiBean2.setIbDenkarikanjyono("200002");
        bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean2);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = commonSiwakeUtil.execTaisyakuTyousei(tuukasyu,
            bzSiwakeMeisaiBeanLst);
        exNumericEquals(bzSiwakeMeisaiBeanList.size(), 2, "仕訳明細リスト");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "A01", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(10000), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(20000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(45000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "200001", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "A02", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(30000), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(20000), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(35000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "200002", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");
    }

    @Test
    @TestOrder(40)
    public void testExecTaisyakuTyousei_A4() {
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU);
        bzSiwakeMeisaiBean1.setIbSuitoubumoncd("A01");
        bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(10000));
        bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(20000));
        bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(45000));
        bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        bzSiwakeMeisaiBean1.setIbDenkarikanjyono("200001");
        bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean1);

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean2.setIbSuitoubumoncd("A02");
        bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(30000));
        bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(19999));
        bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        bzSiwakeMeisaiBean2.setIbDenkarikanjyono("200002");
        bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean2);

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean3.setIbSuitoubumoncd("A03");
        bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(30001));
        bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(1));
        bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        bzSiwakeMeisaiBean3.setIbDenkarikanjyono("200003");
        bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(false);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean3);

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean4 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean4.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean4.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean4.setIbSuitoubumoncd("A03");
        bzSiwakeMeisaiBean4.setIbDengaikagk(BizCurrency.valueOf(30002));
        bzSiwakeMeisaiBean4.setIbDenyenkagk(BizCurrency.valueOf(1));
        bzSiwakeMeisaiBean4.setIbSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean4.setIbSeg2cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean4.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean4.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        bzSiwakeMeisaiBean4.setIbDenkarikanjyono("200004");
        bzSiwakeMeisaiBean4.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean4);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = commonSiwakeUtil.execTaisyakuTyousei(tuukasyu,
            bzSiwakeMeisaiBeanLst);
        exNumericEquals(bzSiwakeMeisaiBeanList.size(), 2, "仕訳明細リスト");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.HOKENKEIYAKUSIHARAIRISOKU_HUTUU, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "A01", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(10000), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(20001), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(45000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "200001", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "A02", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(90003), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(20001), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(105000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "200002", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

    }

    @Test
    @TestOrder(50)
    public void testExecTaisyakuTyousei_A5() {
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean1.setIbSuitoubumoncd("A00");
        bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(15000));
        bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(40001));
        bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        bzSiwakeMeisaiBean1.setIbDenkarikanjyono("205000");
        bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(false);
        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean1);

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KARIKATA);
        bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean2.setIbSuitoubumoncd("A01");
        bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(10000));
        bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20001));
        bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(45000));
        bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        bzSiwakeMeisaiBean2.setIbDenkarikanjyono("200001");
        bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean2);
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean3 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean3.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean3.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean3.setIbSuitoubumoncd("A02");
        bzSiwakeMeisaiBean3.setIbDengaikagk(BizCurrency.valueOf(30000));
        bzSiwakeMeisaiBean3.setIbDenyenkagk(BizCurrency.valueOf(60001));
        bzSiwakeMeisaiBean3.setIbSeg1cd(C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean3.setIbSeg2cd(C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI);
        bzSiwakeMeisaiBean3.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean3.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTB);
        bzSiwakeMeisaiBean3.setIbDenkarikanjyono("200002");
        bzSiwakeMeisaiBean3.setIbTaisyakutyouseiflg(true);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean3);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = commonSiwakeUtil.execTaisyakuTyousei(tuukasyu,
            bzSiwakeMeisaiBeanLst);
        exNumericEquals(bzSiwakeMeisaiBeanList.size(), 2, "仕訳明細リスト");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KARIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "A00", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(25000), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(60001), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(80000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "205000", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");

        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbSuitoubumoncd(), "A02", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDengaikagk(), BizCurrency.valueOf(30000), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenyenkagk(), BizCurrency.valueOf(60001), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg1cd(), C_Segcd.USDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbSeg2cd(), C_Segcd.AUDKOJINNENKINHIJYNBRJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(1).getIbKeiyakutuukagk(), BizCurrency.valueOf(35000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(1).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTB, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(1).getIbDenkarikanjyono(), "200002", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(1).getIbTaisyakutyouseiflg(), true, "貸借調整フラグ");
    }

    @Test
    @TestOrder(60)
    public void testExecTaisyakuTyousei_A6() {
        C_Tuukasyu tuukasyu = C_Tuukasyu.JPY;
        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanLst = new ArrayList<>();
        BzSiwakeMeisaiBean bzSiwakeMeisaiBean1 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean1.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean1.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean1.setIbSuitoubumoncd("A01");
        bzSiwakeMeisaiBean1.setIbDengaikagk(BizCurrency.valueOf(15000));
        bzSiwakeMeisaiBean1.setIbDenyenkagk(BizCurrency.valueOf(40001));
        bzSiwakeMeisaiBean1.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean1.setIbKeiyakutuukagk(BizCurrency.valueOf(35000));
        bzSiwakeMeisaiBean1.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        bzSiwakeMeisaiBean1.setIbDenkarikanjyono("205000");
        bzSiwakeMeisaiBean1.setIbTaisyakutyouseiflg(false);
        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean1);

        BzSiwakeMeisaiBean bzSiwakeMeisaiBean2 = new BzSiwakeMeisaiBean();
        bzSiwakeMeisaiBean2.setIbTaisyakukbn(C_TaisyakuKbn.KASIKATA);
        bzSiwakeMeisaiBean2.setIbKanjyoukmkcd(C_Kanjyoukmkcd.JIGYOUHI);
        bzSiwakeMeisaiBean2.setIbSuitoubumoncd("A01");
        bzSiwakeMeisaiBean2.setIbDengaikagk(BizCurrency.valueOf(10000));
        bzSiwakeMeisaiBean2.setIbDenyenkagk(BizCurrency.valueOf(20001));
        bzSiwakeMeisaiBean2.setIbSeg1cd(C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbSeg2cd(C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI);
        bzSiwakeMeisaiBean2.setIbKeiyakutuukagk(BizCurrency.valueOf(45000));
        bzSiwakeMeisaiBean2.setIbKawasetekiyokbn(C_KawasetekiyoKbn.TTM);
        bzSiwakeMeisaiBean2.setIbDenkarikanjyono("200001");
        bzSiwakeMeisaiBean2.setIbTaisyakutyouseiflg(false);

        bzSiwakeMeisaiBeanLst.add(bzSiwakeMeisaiBean2);

        List<BzSiwakeMeisaiBean> bzSiwakeMeisaiBeanList = commonSiwakeUtil.execTaisyakuTyousei(tuukasyu,
            bzSiwakeMeisaiBeanLst);
        exNumericEquals(bzSiwakeMeisaiBeanList.size(), 1, "仕訳明細リスト");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakukbn(), C_TaisyakuKbn.KASIKATA, "貸借区分");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKanjyoukmkcd(), C_Kanjyoukmkcd.JIGYOUHI, "勘定科目コード");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbSuitoubumoncd(), "A01", "出納部門コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDengaikagk(), BizCurrency.valueOf(25000), "伝票金額（外貨）");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenyenkagk(), BizCurrency.valueOf(60002), "伝票金額（円）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg1cd(), C_Segcd.USDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント１コード");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbSeg2cd(), C_Segcd.AUDSYUUSINITIJIBARAIJYUNYUUHAI,
            "セグメント２コード");
        exBizCalcbleEquals(bzSiwakeMeisaiBeanList.get(0).getIbKeiyakutuukagk(), BizCurrency.valueOf(80000), "伝票金額（外貨）");
        exClassificationEquals(bzSiwakeMeisaiBeanList.get(0).getIbKawasetekiyokbn(), C_KawasetekiyoKbn.TTM, "為替適用区分");
        exStringEquals(bzSiwakeMeisaiBeanList.get(0).getIbDenkarikanjyono(), "205000", "伝票用仮勘定番号");
        exBooleanEquals(bzSiwakeMeisaiBeanList.get(0).getIbTaisyakutyouseiflg(), false, "貸借調整フラグ");
    }
}