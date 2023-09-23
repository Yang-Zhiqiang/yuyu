package yuyu.common.hozen.khcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetYoteiriritu;
import yuyu.common.biz.bzcommon.GetYoteirirituBean;
import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.hozen.khcommon.dba4keisanvheijyun.KeisanVHeijyunDao;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KhSisanSyuruiKbn;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.BM_SibouRitu;

/**
 * 契約保全 契約保全共通 平準払用保険料積立金計算
 */
public class KeisanVHeijyun {

    private BizDateYM tumitateYM;

    private BizCurrency tmttKngk;

    private BizCurrency vTyouseimae;

    private BizCurrency kiharaikomiP;

    private BizNumber yoteiSinkeiyakuhiritu;

    private BizNumber yoteiIjihirituPhirei;

    private BizNumber yoteiIjihirituVhirei;

    private BizNumber yoteiSyuukinhiritu;

    private BizNumber kogakuWaribikiritu;

    private BizNumber zettaiSibouritu;

    private BizNumber soutaiSibouritu;

    private BizNumber soutaiKaiyakuritu;

    private BizNumber yoteiriritu;

    private BizNumber kawaserate;

    @Inject
    private static Logger logger;

    @Inject
    private KeisanVHeijyunDao keisanVHeijyunDao;

    public KeisanVHeijyun() {
        super();
    }

    public BizDateYM getTumitateYM() {
        return tumitateYM;
    }

    public BizCurrency getV() {
        return tmttKngk;
    }

    public BizCurrency getVTyouseimae() {
        return vTyouseimae;
    }

    public BizCurrency getKiharaikomiP() {
        return kiharaikomiP;
    }

    public BizNumber getYoteiSinkeiyakuhiritu() {
        return yoteiSinkeiyakuhiritu;
    }

    public BizNumber getYoteiIjihirituPhirei() {
        return yoteiIjihirituPhirei;
    }

    public BizNumber getYoteiIjihirituVhirei() {
        return yoteiIjihirituVhirei;
    }

    public BizNumber getYoteiSyuukinhiritu() {
        return yoteiSyuukinhiritu;
    }

    public BizNumber getKogakuWaribikiritu() {
        return kogakuWaribikiritu;
    }

    public BizNumber getZettaiSibouritu() {
        return zettaiSibouritu;
    }

    public BizNumber getSoutaiSibouritu() {
        return soutaiSibouritu;
    }

    public BizNumber getSoutaiKaiyakuritu() {
        return soutaiKaiyakuritu;
    }

    public BizNumber getYoteiriritu() {
        return yoteiriritu;
    }

    public BizNumber getKawaserate() {
        return kawaserate;
    }

    public C_ErrorKbn exec(KeisanVHeijyunBean pKeisanVHeijyunBean) {

        logger.debug("▽ 平準払用保険料積立金計算 開始");

        C_ErrorKbn kekkakbn = C_ErrorKbn.OK;

        if (BizUtil.isBlank(pKeisanVHeijyunBean.getSyouhncd())) {
            kekkakbn = C_ErrorKbn.ERROR;

        }
        if (BizUtil.isBlank(pKeisanVHeijyunBean.getRyouritusdno())) {
            kekkakbn = C_ErrorKbn.ERROR;

        }
        if (pKeisanVHeijyunBean.getCalckijyunYm() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getKykymd() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getHokenryou() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getKyktuukasyu() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getHhknsei() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getHknkknsmnkbn() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getHrkkknsmnkbn() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getHrkkaisuu() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getFstpryosyu() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (pKeisanVHeijyunBean.getSitihsyuriritu() == null) {
            kekkakbn = C_ErrorKbn.ERROR;
        }
        if (C_ErrorKbn.ERROR.eq(kekkakbn)) {

            logger.debug("△ 平準払用保険料積立金計算 終了");
            return kekkakbn;
        }

        if (!C_KhSisanSyuruiKbn.JISSEKI.eq(pKeisanVHeijyunBean.getSisansyuruikbn())) {
            if (pKeisanVHeijyunBean.getSisansyoriYmd() == null || pKeisanVHeijyunBean.getSisanyoteiriritu() == null
                || pKeisanVHeijyunBean.getSisankawaserate() == null) {

                logger.debug("△ 平準払用保険料積立金計算 終了");
                return C_ErrorKbn.ERROR;
            }
        }

        if (pKeisanVHeijyunBean.getTmttkntaisyouym() != null) {
            if (BizDateUtil.compareYm(pKeisanVHeijyunBean.getCalckijyunYm(),
                pKeisanVHeijyunBean.getTmttkntaisyouym()) == BizDateUtil.COMPARE_LESSER) {

                logger.debug("△ 平準払用保険料積立金計算 終了");
                return C_ErrorKbn.ERROR;
            }

        }

        int hknkknnensuu = 0;
        if (C_HknkknsmnKbn.SAIMANKI.eq(pKeisanVHeijyunBean.getHknkknsmnkbn())) {
            hknkknnensuu = pKeisanVHeijyunBean.getHknkkn() - pKeisanVHeijyunBean.getHhknnen();

        }
        else {
            hknkknnensuu = pKeisanVHeijyunBean.getHknkkn();
        }

        BizDateYM hknkknManryouYm = pKeisanVHeijyunBean.getKykymd().getBizDateYM().addYears(hknkknnensuu);

        if (BizDateUtil.compareYm(pKeisanVHeijyunBean.getCalckijyunYm(),hknkknManryouYm) == BizDateUtil.COMPARE_GREATER) {

            logger.debug("△ 平準払用保険料積立金計算 終了");
            return C_ErrorKbn.ERROR;
        }

        int calcStarHhknnen = 0;
        BizDateYM jikaiNenKykOutouYm = null;
        BizDateYM calckijyunYmTangetu = null;

        BizCurrency ptumitatekin = null;
        BizCurrency kihrPSoutougk = null;

        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType currencyType = henkanTuuka.henkanTuukaKbnToType(pKeisanVHeijyunBean.getKyktuukasyu());

        if (pKeisanVHeijyunBean.getTmttkntaisyouym() != null) {

            calckijyunYmTangetu = pKeisanVHeijyunBean.getTmttkntaisyouym();
            int nenkeikatukisuu = BizDateUtil.calcDifferenceMonths(pKeisanVHeijyunBean.getTmttkntaisyouym(),
                pKeisanVHeijyunBean.getKykymd().getBizDateYM());
            int nenkeikanensuu = nenkeikatukisuu / 12;
            calcStarHhknnen = pKeisanVHeijyunBean.getHhknnen() + nenkeikanensuu;
            jikaiNenKykOutouYm = pKeisanVHeijyunBean.getKykymd().getBizDateYM().addYears(nenkeikanensuu + 1);

            if (pKeisanVHeijyunBean.getCalckaisiYmjitenv() != null && pKeisanVHeijyunBean.getCalckaisiYmjitenv().compareTo(
                BizCurrency.valueOf(0, pKeisanVHeijyunBean.getCalckaisiYmjitenv().getType())) > 0) {

                ptumitatekin = pKeisanVHeijyunBean.getCalckaisiYmjitenv();
            }
            else {

                ptumitatekin = BizCurrency.valueOf(0, currencyType);
            }

            if (pKeisanVHeijyunBean.getCalckaisiYmjitensump() != null && pKeisanVHeijyunBean.getCalckaisiYmjitensump().compareTo(
                BizCurrency.valueOf(0, pKeisanVHeijyunBean.getCalckaisiYmjitensump().getType())) > 0) {

                kihrPSoutougk = pKeisanVHeijyunBean.getCalckaisiYmjitensump();
            }
            else {

                kihrPSoutougk = BizCurrency.valueOf(0, currencyType);
            }
        }
        else {

            calckijyunYmTangetu = pKeisanVHeijyunBean.getKykymd().getBizDateYM();
            calcStarHhknnen = pKeisanVHeijyunBean.getHhknnen();
            jikaiNenKykOutouYm = pKeisanVHeijyunBean.getKykymd().getBizDateYM().addYears(1);
            ptumitatekin = BizCurrency.valueOf(0, currencyType);
            kihrPSoutougk = BizCurrency.valueOf(0, currencyType);
        }

        int calcEndHhknnen = pKeisanVHeijyunBean.getHhknnen() + hknkknnensuu - 1;
        int sansyou = 0;
        BizDateYM ptumitatekincalcym = calckijyunYmTangetu;

        BizCurrency pkyktuukasyu = BizCurrency.valueOf(0, currencyType);
        int caclcount = BizDateUtil.calcDifferenceMonths(pKeisanVHeijyunBean.getCalckijyunYm(), calckijyunYmTangetu) ;

        BizNumber zettaisibouritu = BizNumber.ZERO;
        BizNumber soutaisibouritu = BizNumber.ZERO;
        BizNumber soutaikaiyakuritu = BizNumber.ZERO;
        List<BM_SibouRitu> sibouRituLst = new ArrayList<>();

        if (caclcount > 0) {

            sibouRituLst = keisanVHeijyunDao.getSibouRitu(pKeisanVHeijyunBean.getRyouritusdno(),
                C_Seibetu.valueOf(pKeisanVHeijyunBean.getHhknsei().getValue()),
                calcStarHhknnen, calcEndHhknnen);

            if (sibouRituLst.size() == 0) {

                logger.debug("△ 平準払用保険料積立金計算 終了");
                return C_ErrorKbn.ERROR;
            }

            zettaisibouritu = sibouRituLst.get(0).getSibouritu1();
            soutaisibouritu = sibouRituLst.get(0).getSibouritu2();
            soutaikaiyakuritu = sibouRituLst.get(0).getKaiyakuritu1();

        }

        KeisanVHeijyunTangetu keisanVHeijyunTangetu = SWAKInjector.getInstance(KeisanVHeijyunTangetu.class);

        BizNumber yoteirrt = null;
        BizNumber kwsrate = null;
        int hrkkknNen = 0;
        BizDateYM hrkmanryouym = null;

        if (C_HrkkknsmnKbn.SAIMANKI.eq(pKeisanVHeijyunBean.getHrkkknsmnkbn())) {
            hrkkknNen = pKeisanVHeijyunBean.getHrkkkn() - pKeisanVHeijyunBean.getHhknnen();
        }
        else {
            hrkkknNen = pKeisanVHeijyunBean.getHrkkkn();
        }

        hrkmanryouym = pKeisanVHeijyunBean.getKykymd().getBizDateYM().addYears(hrkkknNen);

        for (int i = 0; i < caclcount; i++) {

            KeisanGaikaP keisanGaikaP = SWAKInjector.getInstance(KeisanGaikaP.class);
            GetYoteirirituBean getYoteirirituBean = SWAKInjector.getInstance(GetYoteirirituBean.class);
            GetYoteiriritu getYoteiriritu = SWAKInjector.getInstance(GetYoteiriritu.class);

            if (C_KhSisanSyuruiKbn.JISSEKI.eq(pKeisanVHeijyunBean.getSisansyuruikbn())
                || (C_KhSisanSyuruiKbn.JISSEKI_SISAN.eq(pKeisanVHeijyunBean.getSisansyuruikbn()) && BizDateUtil
                    .compareYm(calckijyunYmTangetu, pKeisanVHeijyunBean.getSisansyoriYmd().getBizDateYM()) <= BizDateUtil.COMPARE_EQUAL)) {

                if (BizDateUtil.compareYm(hrkmanryouym, calckijyunYmTangetu) == BizDateUtil.COMPARE_GREATER) {

                    C_ErrorKbn errorKbn = keisanGaikaP.exec(pKeisanVHeijyunBean.getHokenryou(),
                        pKeisanVHeijyunBean.getKyktuukasyu(), calckijyunYmTangetu,
                        pKeisanVHeijyunBean.getKykymd(), pKeisanVHeijyunBean.getFstpryosyu());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {

                        logger.debug("△ 平準払用保険料積立金計算 終了");
                        return C_ErrorKbn.ERROR;
                    }

                    pkyktuukasyu = keisanGaikaP.getP();
                    kwsrate = keisanGaikaP.getKawaseRate();
                }
                else {

                    pkyktuukasyu = BizCurrency.valueOf(0, currencyType);
                }

                getYoteirirituBean.setSyouhncd(pKeisanVHeijyunBean.getSyouhncd());
                BizDate temp = BizDate.valueOf(calckijyunYmTangetu, pKeisanVHeijyunBean.getKykymd().getDay())
                    .getRekijyou();
                getYoteirirituBean.setKijyunymd(temp);
                getYoteirirituBean.setSknnkaisiymd(pKeisanVHeijyunBean.getKykymd());
                getYoteirirituBean.setKykymd(pKeisanVHeijyunBean.getKykymd());
                getYoteirirituBean.setHknkkn(pKeisanVHeijyunBean.getHknkkn());
                getYoteirirituBean.setHknkknsmnkbn(pKeisanVHeijyunBean.getHknkknsmnkbn());
                getYoteirirituBean.setHhknnen(pKeisanVHeijyunBean.getHhknnen());
                getYoteirirituBean.setSitihsyuriritu(pKeisanVHeijyunBean.getSitihsyuriritu());
                C_ErrorKbn errorKbn = getYoteiriritu.exec(getYoteirirituBean);

                if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                    logger.debug("△ 平準払用保険料積立金計算 終了");
                    return C_ErrorKbn.ERROR;
                }

                yoteirrt = getYoteiriritu.getYoteiriritu();
            }
            else {
                if (BizDateUtil.compareYm(hrkmanryouym, calckijyunYmTangetu) == BizDateUtil.COMPARE_GREATER) {

                    C_ErrorKbn errorKbn = keisanGaikaP.execKawaseSitei(pKeisanVHeijyunBean.getHokenryou(),
                        pKeisanVHeijyunBean.getKyktuukasyu(), pKeisanVHeijyunBean.getSisankawaserate());

                    if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                        logger.debug("△ 平準払用保険料積立金計算 終了");
                        return C_ErrorKbn.ERROR;
                    }

                    pkyktuukasyu = keisanGaikaP.getP();

                    kwsrate = pKeisanVHeijyunBean.getSisankawaserate();
                }
                else {

                    pkyktuukasyu = BizCurrency.valueOf(0, currencyType);
                }

                yoteirrt = pKeisanVHeijyunBean.getSisanyoteiriritu();

            }

            C_ErrorKbn errorKbn = keisanVHeijyunTangetu.exec(calckijyunYmTangetu,
                pKeisanVHeijyunBean.getKykymd(),
                pKeisanVHeijyunBean.getHokenryou(),
                pkyktuukasyu,
                pKeisanVHeijyunBean.getHhknnen(),
                pKeisanVHeijyunBean.getHrkkkn(),
                pKeisanVHeijyunBean.getHrkkknsmnkbn(),
                yoteirrt,
                zettaisibouritu,
                soutaisibouritu,
                soutaikaiyakuritu,
                ptumitatekin,
                kihrPSoutougk);

            if (C_ErrorKbn.ERROR.eq(errorKbn)) {
                logger.debug("△ 平準払用保険料積立金計算 終了");
                return C_ErrorKbn.ERROR;
            }

            ptumitatekin = keisanVHeijyunTangetu.getV();
            kihrPSoutougk = keisanVHeijyunTangetu.getKiharaikomiPSoutougk();
            ptumitatekincalcym = keisanVHeijyunTangetu.getTumitateYM();

            calckijyunYmTangetu = calckijyunYmTangetu.addMonths(1);
            if (BizDateUtil.compareYm(calckijyunYmTangetu, hknkknManryouYm) >= BizDateUtil.COMPARE_EQUAL) {
                break;
            }

            if (BizDateUtil.calcDifferenceMonths(jikaiNenKykOutouYm, calckijyunYmTangetu) <= BizDateUtil.COMPARE_EQUAL) {

                jikaiNenKykOutouYm = jikaiNenKykOutouYm.addYears(1);
                sansyou = sansyou + 1;
                zettaisibouritu = sibouRituLst.get(sansyou).getSibouritu1();
                soutaisibouritu = sibouRituLst.get(sansyou).getSibouritu2();
                soutaikaiyakuritu = sibouRituLst.get(sansyou).getKaiyakuritu1();

            }

        }
        tumitateYM = ptumitatekincalcym;
        tmttKngk = ptumitatekin;
        vTyouseimae = keisanVHeijyunTangetu.getVTyouseimae();
        kiharaikomiP = kihrPSoutougk;
        yoteiSinkeiyakuhiritu = keisanVHeijyunTangetu.getYoteiSinkeiyakuhiritu();
        yoteiIjihirituPhirei = keisanVHeijyunTangetu.getYoteiIjihirituPhirei();
        yoteiIjihirituVhirei = keisanVHeijyunTangetu.getYoteiIjihirituVhirei();
        yoteiSyuukinhiritu = keisanVHeijyunTangetu.getYoteiSyuukinhiritu();
        kogakuWaribikiritu = keisanVHeijyunTangetu.getKougakuWaribikiritu();
        zettaiSibouritu = zettaisibouritu;
        soutaiSibouritu = soutaisibouritu;
        soutaiKaiyakuritu = soutaikaiyakuritu;
        yoteiriritu = yoteirrt;
        kawaserate = kwsrate;
        logger.debug("△ 平準払用保険料積立金計算 終了");

        return kekkakbn;
    }
}
