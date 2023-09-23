package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import yuyu.def.db.entity.IT_Suiihyou;

/**
 * 契約保全 契約保全共通 解約返戻金推移表作成
 */
public class WSuiihyou2 {

    //    private final static String errorMsg = "解約返戻金計算が実行できませんでした。";
    //
    //    private final static String SUIIHYOUSYUBETU_SYSN = "01";
    //
    //    private final static String SUIIHYOUSYUBETU_YENDTSYSNHNK = "04";
    //
    //    private C_YouhiKbn yenkansannYhKbn = C_YouhiKbn.YOU;
    //
    //    @Inject
    //    private static Logger logger;

    /**
     * コンストラクタ
     */
    public WSuiihyou2() {
        super();
    }

    //    public void setYenkansannYhKbn(C_YouhiKbn pYenkansannYhKbn) {
    //        yenkansannYhKbn = pYenkansannYhKbn;
    //    }

    /**
     * メイン処理
     * @param pWSuiihyouParam  解約返戻金推移表作成パラメータ
     * @return                 解約返戻金リスト
     */
    public List<IT_Suiihyou> exec(WSuiihyouParam pWSuiihyouParam) {

        //        logger.debug("▽ 解約返戻金推移表作成 開始");
        //
        //        int rekijyouSyuuseiUmu = 0;
        //
        //        BizDate hoseiKijyunYmd = BizDate.valueOf(pWSuiihyouParam.getCalcKijyunYmd().getYear(), pWSuiihyouParam.getKeisanWExtBean().getKykymd().getBizDateMD());
        //
        //        if (!hoseiKijyunYmd.isRekijyou()) {
        //            hoseiKijyunYmd = hoseiKijyunYmd.getRekijyou().getNextDay();
        //            rekijyouSyuuseiUmu = 1;
        //        }
        //
        //        BizDate nenoutouYmd;
        //
        //        if (BizDateUtil.compareYmd(hoseiKijyunYmd, pWSuiihyouParam.getCalcKijyunYmd()) == BizDateUtil.COMPARE_LESSER ||
        //            BizDateUtil.compareYmd(hoseiKijyunYmd, pWSuiihyouParam.getCalcKijyunYmd()) == BizDateUtil.COMPARE_EQUAL) {
        //
        //            nenoutouYmd = BizDate.valueOf((pWSuiihyouParam.getCalcKijyunYmd().getYear() + 1), pWSuiihyouParam.getKeisanWExtBean().getKykymd().getBizDateMD());
        //
        //            if (!nenoutouYmd.isRekijyou()) {
        //                nenoutouYmd = nenoutouYmd.getRekijyou().getNextDay();
        //                rekijyouSyuuseiUmu = 1;
        //            }
        //        }
        //        else {
        //            nenoutouYmd = hoseiKijyunYmd;
        //        }
        //
        //        BizDate calcKijyunYmd = nenoutouYmd;
        //
        //        BizDate calcKijyunMaeYmd = calcKijyunYmd.getPreviousDay();
        //
        //        int wkKeikaNensuu = 0;
        //        int wkKeikaNensuuMax = 0;
        //
        //        if (C_SinsaihkKbn.SIN.eq(pWSuiihyouParam.getSinsaihkKbn()) ||
        //            (C_SinsaihkKbn.SAI.eq(pWSuiihyouParam.getSinsaihkKbn()) &&
        //                C_SyoukensaihkKbn.SINKEIYAKUSAISAKUSEI.eq(pWSuiihyouParam.getSyoukensaihkKbn()))) {
        //            wkKeikaNensuu = 1;
        //            wkKeikaNensuuMax = 105 - pWSuiihyouParam.getKeisanWExtBean().getHhknnen();
        //        }
        //        else {
        //            wkKeikaNensuu = BizDateUtil.calcDifference(calcKijyunYmd, pWSuiihyouParam.getKeisanWExtBean().getKykymd()).getYears();
        //            wkKeikaNensuuMax = 105 - pWSuiihyouParam.getKeisanWExtBean().getHhknnen() - (wkKeikaNensuu - 1);
        //        }
        //
        //        GetKawaseRate getKawaseRate = SWAKInjector.getInstance(GetKawaseRate.class);
        //
        //        BizNumber kawaserateCenter = BizNumber.ZERO;
        //        BizNumber kawaserateEndaka = BizNumber.ZERO;
        //        BizNumber kawaserateEnyasi = BizNumber.ZERO;
        //
        //        if (C_YouhiKbn.YOU.eq(yenkansannYhKbn)) {
        //
        //            getKawaseRate.exec(
        //                pWSuiihyouParam.getKwsratekjymd(),
        //                C_KawaserateSyuruiKbn.KOUJIKAWASERATE,
        //                pWSuiihyouParam.getKeisanWExtBean().getTuukasyu(),
        //                C_Tuukasyu.JPY,
        //                C_KawasetekiyoKbn.TTM,
        //                C_KawasetsryKbn.SYUKKINRATE,
        //                C_EigyoubiHoseiKbn.BLNK,
        //                C_YouhiKbn.HUYOU
        //                );
        //
        //            kawaserateCenter = getKawaseRate.getKawaserate();
        //            kawaserateEndaka = kawaserateCenter.subtract(YuyuHozenConfig.getInstance().getKawaserateHendouYenup());
        //            kawaserateEnyasi = kawaserateCenter.add(YuyuHozenConfig.getInstance().getKawaserateHendouYendown());
        //        }
        //
        //        BizNumber kaiyakuSjkTsRitu = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu();
        //        BizNumber kaiyakuSjkTsRituUp = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu().add(YuyuHozenConfig.getInstance().getSuiihyouSjkkktusirrtUp());
        //        BizNumber kaiyakuSjkTsRituDown = pWSuiihyouParam.getKeisanWExtBean().getKyksjkkktyouseiriritu().subtract(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
        //
        List<IT_Suiihyou> suiihyouList = new ArrayList<>();

        //        for (int cnt = 0; cnt < wkKeikaNensuuMax; cnt++) {
        //
        //            KeisanWKijunYM keisanWKijunYM = SWAKInjector.getInstance(KeisanWKijunYM.class);
        //
        //            BizDateYM kijyunYm = keisanWKijunYM.exec(
        //                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
        //                calcKijyunMaeYmd);
        //
        //            KeisanW keisanW = SWAKInjector.getInstance(KeisanW.class);
        //
        //            pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRitu);
        //
        //            C_ErrorKbn errorKbn = keisanW.exec(calcKijyunMaeYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());
        //            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //                throw new CommonBizAppException(errorMsg);
        //            }
        //
        //            BizCurrency kaiyakuhrSame = keisanW.getW();
        //            BizCurrency tsumitateKngk = keisanW.getV();
        //
        //            C_MvaTekiyoujyoutaiKbn  mvaTekiyoujyoutaiKbn = setMvatekijyoutaikbn(
        //                calcKijyunMaeYmd,
        //                pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
        //                pWSuiihyouParam.getKeisanWExtBean().getHknkkn(),
        //                pWSuiihyouParam.getMvaTekiUmu(),
        //                pWSuiihyouParam.getMvaTekiKkn());
        //
        //            KeisanGaikakanzan keisanGaikakanzan = SWAKInjector.getInstance(KeisanGaikakanzan.class);
        //            HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        //            BizCurrency mvaariwyensameyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvanonewyensameyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvanonewsame = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));
        //            BizCurrency mvanoneptumitatekin = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));
        //            BizCurrency mvaariwyensameyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvanonewyensameyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwyensameyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvanonewyensameyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //
        //            keisanGaikakanzan.exec(
        //                C_Tuukasyu.JPY,
        //                kaiyakuhrSame,
        //                kawaserateCenter,
        //                C_HasuusyoriKbn.AGE
        //                );
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn) ||
        //                C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                mvaariwyensameyenkijyun = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                mvanonewyensameyenkijyun = keisanGaikakanzan.getKanzanGaku();
        //                mvanonewsame = kaiyakuhrSame;
        //                mvanoneptumitatekin = tsumitateKngk;
        //            }
        //
        //            keisanGaikakanzan.exec(
        //                C_Tuukasyu.JPY,
        //                kaiyakuhrSame,
        //                kawaserateEndaka,
        //                C_HasuusyoriKbn.AGE
        //                );
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn) ||
        //                C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                mvaariwyensameyendaka = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                mvanonewyensameyendaka = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            keisanGaikakanzan.exec(
        //                C_Tuukasyu.JPY,
        //                kaiyakuhrSame,
        //                kawaserateEnyasi,
        //                C_HasuusyoriKbn.AGE
        //                );
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn) ||
        //                C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                mvaariwyensameyenyasu = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                mvanonewyensameyenyasu = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            BizCurrency mvaariwyenupyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwyenupyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwyenupyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwup = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn) ||
        //                C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //
        //                pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituUp);
        //
        //                errorKbn = keisanW.exec(calcKijyunMaeYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());
        //                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //                    throw new CommonBizAppException(errorMsg);
        //                }
        //
        //                mvaariwup = keisanW.getW();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvaariwup,
        //                    kawaserateCenter,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvaariwyenupyenkijyun = keisanGaikakanzan.getKanzanGaku();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvaariwup,
        //                    kawaserateEndaka,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvaariwyenupyendaka = keisanGaikakanzan.getKanzanGaku();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvaariwup,
        //                    kawaserateEnyasi,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvaariwyenupyenyasu = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            BizCurrency mvaariwyendownyenkijyun = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwyendownyendaka = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwyendownyenyasu = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(C_Tuukasyu.JPY));
        //            BizCurrency mvaariwdown = BizCurrency.valueOf(0, henkanTuuka.henkanTuukaKbnToType(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu()));
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn) ||
        //                C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //
        //                pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(kaiyakuSjkTsRituDown);
        //
        //                errorKbn = keisanW.exec(calcKijyunMaeYmd, kijyunYm, pWSuiihyouParam.getKeisanWExtBean());
        //                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //                    throw new CommonBizAppException(errorMsg);
        //                }
        //
        //                mvaariwdown = keisanW.getW();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvaariwdown,
        //                    kawaserateCenter,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvaariwyendownyenkijyun = keisanGaikakanzan.getKanzanGaku();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvaariwdown,
        //                    kawaserateEndaka,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvaariwyendownyendaka = keisanGaikakanzan.getKanzanGaku();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvaariwdown,
        //                    kawaserateEnyasi,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvaariwyendownyenyasu = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //
        //                BizDateYM kijyunMvaYm = keisanWKijunYM.exec(
        //                    pWSuiihyouParam.getKeisanWExtBean().getKykymd(),
        //                    calcKijyunYmd);
        //
        //                pWSuiihyouParam.getKeisanWExtBean().setKaiyakusjkkktyouseiriritu(BizNumber.ZERO);
        //
        //                errorKbn = keisanW.exec(calcKijyunYmd, kijyunMvaYm, pWSuiihyouParam.getKeisanWExtBean());
        //                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
        //                    throw new CommonBizAppException(errorMsg);
        //                }
        //
        //                mvanonewsame = keisanW.getW();
        //                mvanoneptumitatekin = keisanW.getV();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvanonewsame,
        //                    kawaserateCenter,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvanonewyensameyenkijyun = keisanGaikakanzan.getKanzanGaku();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvanonewsame,
        //                    kawaserateEndaka,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvanonewyensameyendaka = keisanGaikakanzan.getKanzanGaku();
        //
        //                keisanGaikakanzan.exec(
        //                    C_Tuukasyu.JPY,
        //                    mvanonewsame,
        //                    kawaserateEnyasi,
        //                    C_HasuusyoriKbn.AGE
        //                    );
        //                mvanonewyensameyenyasu = keisanGaikakanzan.getKanzanGaku();
        //            }
        //
        //            IT_Suiihyou suiihyou = new IT_Suiihyou();
        //
        //            suiihyou.setKeikanensuu(wkKeikaNensuu);
        //            suiihyou.setCalckijyunymd(calcKijyunMaeYmd);
        //
        //            if (rekijyouSyuuseiUmu == 1) {
        //                suiihyou.setCalcym(calcKijyunYmd.getPreviousMonth().getBizDateYM());
        //            }
        //            else {
        //                suiihyou.setCalcym(calcKijyunYmd.getBizDateYM());
        //            }
        //
        //            suiihyou.setYenknsnkwsrateyendaka(kawaserateEndaka);
        //            suiihyou.setYenknsnkwsrateyenkijyun(kawaserateCenter);
        //            suiihyou.setYenknsnkwsrateyenyasu(kawaserateEnyasi);
        //            suiihyou.setYenknsnkwsrategkyendaka(
        //                BizCurrency.valueOf(new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYenup().toString()),
        //                    BizCurrencyTypes.YEN));
        //            suiihyou.setYenknsnkwsrategkyenyasu(
        //                BizCurrency.valueOf(new BigDecimal(YuyuHozenConfig.getInstance().getKawaserateHendouYendown().toString()),
        //                    BizCurrencyTypes.YEN));
        //            suiihyou.setMvatekijyoutaikbn(mvaTekiyoujyoutaiKbn);
        //
        //            if (C_Tuukasyu.JPY.eq(pWSuiihyouParam.getKeisanWExtBean().getTuukasyu())) {
        //                suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_YENDTSYSNHNK);
        //            }
        //            else {
        //                suiihyou.setSuiihyousyubetu(SUIIHYOUSYUBETU_SYSN);
        //
        //            }
        //
        //            if (C_MvaTekiyoujyoutaiKbn.MVAARI.eq(mvaTekiyoujyoutaiKbn)) {
        //                suiihyou.setSjkkktusirrtup(kaiyakuSjkTsRituUp);
        //                suiihyou.setSjkkktusirrtsame(kaiyakuSjkTsRitu);
        //                suiihyou.setSjkkktusirrtdown(kaiyakuSjkTsRituDown);
        //                suiihyou.setSjkkktusirrthendouup(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
        //                suiihyou.setSjkkktusirrthendoudown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
        //                suiihyou.setMvaariwup(mvaariwup);
        //                suiihyou.setMvaariwsame(kaiyakuhrSame);
        //                suiihyou.setMvaariwdown(mvaariwdown);
        //                suiihyou.setMvaariwyenupyendaka(mvaariwyenupyendaka);
        //                suiihyou.setMvaariwyenupyenkijyun(mvaariwyenupyenkijyun);
        //                suiihyou.setMvaariwyenupyenyasu(mvaariwyenupyenyasu);
        //                suiihyou.setMvaariwyensameyendaka(mvaariwyensameyendaka);
        //                suiihyou.setMvaariwyensameyenkijyun(mvaariwyensameyenkijyun);
        //                suiihyou.setMvaariwyensameyenyasu(mvaariwyensameyenyasu);
        //                suiihyou.setMvaariwyendownyendaka(mvaariwyendownyendaka);
        //                suiihyou.setMvaariwyendownyenkijyun(mvaariwyendownyenkijyun);
        //                suiihyou.setMvaariwyendownyenyasu(mvaariwyendownyenyasu);
        //                suiihyou.setMvaariptumitatekin(tsumitateKngk);
        //            }
        //            else if (C_MvaTekiyoujyoutaiKbn.MVANONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                suiihyou.setMvanonewsame(mvanonewsame);
        //                suiihyou.setMvanonewyensameyendaka(mvanonewyensameyendaka);
        //                suiihyou.setMvanonewyensameyenkijyun(mvanonewyensameyenkijyun);
        //                suiihyou.setMvanonewyensameyenyasu(mvanonewyensameyenyasu);
        //                suiihyou.setMvanoneptumitatekin(mvanoneptumitatekin);
        //            }
        //            else if (C_MvaTekiyoujyoutaiKbn.MVAARINONE.eq(mvaTekiyoujyoutaiKbn)) {
        //                suiihyou.setSjkkktusirrtup(kaiyakuSjkTsRituUp);
        //                suiihyou.setSjkkktusirrtsame(kaiyakuSjkTsRitu);
        //                suiihyou.setSjkkktusirrtdown(kaiyakuSjkTsRituDown);
        //                suiihyou.setSjkkktusirrthendouup(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituUp());
        //                suiihyou.setSjkkktusirrthendoudown(YuyuHozenConfig.getInstance().getSuiihyouYoteirirituDown());
        //                suiihyou.setMvaariwup(mvaariwup);
        //                suiihyou.setMvaariwsame(kaiyakuhrSame);
        //                suiihyou.setMvaariwdown(mvaariwdown);
        //                suiihyou.setMvaariwyenupyendaka(mvaariwyenupyendaka);
        //                suiihyou.setMvaariwyenupyenkijyun(mvaariwyenupyenkijyun);
        //                suiihyou.setMvaariwyenupyenyasu(mvaariwyenupyenyasu);
        //                suiihyou.setMvaariwyensameyendaka(mvaariwyensameyendaka);
        //                suiihyou.setMvaariwyensameyenkijyun(mvaariwyensameyenkijyun);
        //                suiihyou.setMvaariwyensameyenyasu(mvaariwyensameyenyasu);
        //                suiihyou.setMvaariwyendownyendaka(mvaariwyendownyendaka);
        //                suiihyou.setMvaariwyendownyenkijyun(mvaariwyendownyenkijyun);
        //                suiihyou.setMvaariwyendownyenyasu(mvaariwyendownyenyasu);
        //                suiihyou.setMvaariptumitatekin(tsumitateKngk);
        //                suiihyou.setMvanonewsame(mvanonewsame);
        //                suiihyou.setMvanonewyensameyendaka(mvanonewyensameyendaka);
        //                suiihyou.setMvanonewyensameyenkijyun(mvanonewyensameyenkijyun);
        //                suiihyou.setMvanonewyensameyenyasu(mvanonewyensameyenyasu);
        //                suiihyou.setMvanoneptumitatekin(mvanoneptumitatekin);
        //            }
        //
        //            suiihyouList.add(suiihyou);
        //
        //            calcKijyunYmd = BizDate.valueOf((calcKijyunYmd.getYear() + 1), pWSuiihyouParam.getKeisanWExtBean().getKykymd().getBizDateMD());
        //
        //            if (!calcKijyunYmd.isRekijyou()) {
        //                calcKijyunYmd = calcKijyunYmd.getRekijyou().getNextDay();
        //
        //                rekijyouSyuuseiUmu = 1;
        //            }
        //            else {
        //                rekijyouSyuuseiUmu = 0;
        //            }
        //
        //            calcKijyunMaeYmd = calcKijyunYmd.getPreviousDay();
        //
        //            wkKeikaNensuu = wkKeikaNensuu + 1;
        //        }
        //
        //        logger.debug("△ 解約返戻金推移表作成 終了");
        return suiihyouList;
    }

    //    private C_MvaTekiyoujyoutaiKbn setMvatekijyoutaikbn(
    //        BizDate  pCalcKijyunYmd,
    //        BizDate  pKykYmd,
    //        int      pHknkkn,
    //        C_UmuKbn pMvaTekiUmu,
    //        int      pMvaTekiKkn){
    //
    //        C_MvaTekiyoujyoutaiKbn mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.BLNK;
    //        int wkMvaTekikkn = pMvaTekiKkn;
    //
    //        if (pMvaTekiKkn > pHknkkn){
    //            wkMvaTekikkn = pHknkkn;
    //        }
    //
    //        BizDateSpan mvaKeikaYm = BizDateUtil.calcDifference(pCalcKijyunYmd, pKykYmd);
    //        int mvaKeikaNensuu = mvaKeikaYm.getYears();
    //
    //        if (C_UmuKbn.ARI.eq(pMvaTekiUmu) && mvaKeikaNensuu == wkMvaTekikkn -1) {
    //            mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARINONE;
    //        }
    //        else if(C_UmuKbn.ARI.eq(pMvaTekiUmu) && mvaKeikaNensuu < wkMvaTekikkn -1) {
    //            mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVAARI;
    //        }
    //        else if((C_UmuKbn.ARI.eq(pMvaTekiUmu) && mvaKeikaNensuu >= wkMvaTekikkn) ||
    //            C_UmuKbn.NONE.eq(pMvaTekiUmu)){
    //            mvaTekiyoujyoutaiKbn = C_MvaTekiyoujyoutaiKbn.MVANONE;
    //        }
    //
    //        return mvaTekiyoujyoutaiKbn;
    //
    //    }
}
