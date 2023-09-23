package yuyu.common.hozen.ascommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkBean;
import yuyu.common.hozen.khcommon.KeisanIkkatuNyuukinGkSyouhnBean;
import yuyu.common.hozen.khcommon.KeisanTukiIkkatuNyuukinGk;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Nykkeiro;
import yuyu.def.classification.C_NyknaiyouKbn;
import yuyu.def.classification.C_TkiktbrisyuruiKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;

/**
 * 契約保全 案内収納共通 領収金額計算
 */
public class KeisanRsgaku {

    private String errorRiyuu;

    private List<String> errorCd;

    private KeisanRsgkOutBean keisanRsgkOutBean;

    @Inject
    private static Logger logger;

    public String getErrorRiyuu() {
        return errorRiyuu;
    }

    public List<String> getErrorCd() {
        return errorCd;
    }

    public KeisanRsgkOutBean getKeisanRsgkOutBean() {
        return keisanRsgkOutBean;
    }

    public C_ErrorKbn exec(KeisanRsgakuBean pKeisanRsgakuBean) {

        logger.debug("▽ 領収金額計算 開始");

        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKeisanRsgakuBean == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getHrkkaisuu() == null ||
            C_Hrkkaisuu.BLNK.eq(pKeisanRsgakuBean.getHrkkaisuu())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getNykkeiro() == null ||
            C_Nykkeiro.BLNK.eq(pKeisanRsgakuBean.getNykkeiro())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getNyknaiyoukbn() == null ||
            C_NyknaiyouKbn.BLNK.eq(pKeisanRsgakuBean.getNyknaiyoukbn())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getRsymd() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getJyutoustartym() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getJyuutoutukisuu() == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getRstuukasyu() == null ||
            C_Tuukasyu.BLNK.eq(pKeisanRsgakuBean.getRstuukasyu())) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pKeisanRsgakuBean.getKeisanRsgakuSyouhinBeanLst() == null ||
            pKeisanRsgakuBean.getKeisanRsgakuSyouhinBeanLst().size() == 0) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        for (KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean : pKeisanRsgakuBean.getKeisanRsgakuSyouhinBeanLst()) {

            if (BizUtil.isBlank(keisanRsgakuSyouhinBean.getSyouhncd())) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 領収金額計算 終了");

                return resultKbn;
            }

            if (keisanRsgakuSyouhinBean.getSyouhnsdno() == null) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 領収金額計算 終了");

                return resultKbn;
            }

            if (BizUtil.isBlank(keisanRsgakuSyouhinBean.getRyouritusdno())) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 領収金額計算 終了");

                return resultKbn;
            }

            if (keisanRsgakuSyouhinBean.getHokenryou() == null ||
                keisanRsgakuSyouhinBean.getHokenryou().isOptional()) {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
                errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

                logger.debug("△ 領収金額計算 終了");

                return resultKbn;
            }
        }

        if (C_Hrkkaisuu.HALFY.eq(pKeisanRsgakuBean.getHrkkaisuu())||
            C_Hrkkaisuu.NEN.eq(pKeisanRsgakuBean.getHrkkaisuu())) {

            KeisanNenHalfyRsgakuBean keisanNenHalfyRsgakuBean = SWAKInjector.getInstance(KeisanNenHalfyRsgakuBean.class);

            keisanNenHalfyRsgakuBean.setHrkkaisuu(pKeisanRsgakuBean.getHrkkaisuu());
            keisanNenHalfyRsgakuBean.setNykkeiro(pKeisanRsgakuBean.getNykkeiro());
            keisanNenHalfyRsgakuBean.setNyknaiyoukbn(pKeisanRsgakuBean.getNyknaiyoukbn());
            keisanNenHalfyRsgakuBean.setRsymd(pKeisanRsgakuBean.getRsymd());
            keisanNenHalfyRsgakuBean.setJyutoustartym(pKeisanRsgakuBean.getJyutoustartym());
            keisanNenHalfyRsgakuBean.setJyuutounensuu(pKeisanRsgakuBean.getJyuutounensuu());
            keisanNenHalfyRsgakuBean.setJyuutoutukisuu(pKeisanRsgakuBean.getJyuutoutukisuu());
            keisanNenHalfyRsgakuBean.setRstuukasyu(pKeisanRsgakuBean.getRstuukasyu());
            keisanNenHalfyRsgakuBean.setKeisanRsgakuSyouhinBeanLst(
                pKeisanRsgakuBean.getKeisanRsgakuSyouhinBeanLst());

            KeisanNenHalfyRsgaku keisanNenHalfyRsgaku = SWAKInjector.getInstance(KeisanNenHalfyRsgaku.class);

            C_ErrorKbn ksNenHalfyRsgakuResultKbn = keisanNenHalfyRsgaku.exec(keisanNenHalfyRsgakuBean);

            if (C_ErrorKbn.OK.eq(ksNenHalfyRsgakuResultKbn)) {

                keisanRsgkOutBean = keisanNenHalfyRsgaku.getKeisanRsgkOutBean();
            }
            else {

                resultKbn = C_ErrorKbn.ERROR;

                errorRiyuu = pKeisanRsgakuBean.getHrkkaisuu().getContent() + keisanNenHalfyRsgaku.getErrorRiyuu();
                errorCd.addAll(keisanNenHalfyRsgaku.getErrorCd());
            }
        }
        else if (C_Hrkkaisuu.TUKI.eq(pKeisanRsgakuBean.getHrkkaisuu())) {

            if (pKeisanRsgakuBean.getTikiktbrisyuruikbn() != null &&
                (C_TkiktbrisyuruiKbn.TEIKI_6MONTHS.eq(pKeisanRsgakuBean.getTikiktbrisyuruikbn()) ||
                    C_TkiktbrisyuruiKbn.TEIKI_12MONTHS.eq(pKeisanRsgakuBean.getTikiktbrisyuruikbn()))) {

                List<KeisanIkkatuNyuukinGkSyouhnBean> itkyKsRsgakuSyouhinBeanLst =
                    new ArrayList<KeisanIkkatuNyuukinGkSyouhnBean>();

                for (KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean : pKeisanRsgakuBean.getKeisanRsgakuSyouhinBeanLst()) {

                    KeisanIkkatuNyuukinGkSyouhnBean itkyKeisanRsgakuSyouhinBean =
                        SWAKInjector.getInstance(KeisanIkkatuNyuukinGkSyouhnBean.class);

                    itkyKeisanRsgakuSyouhinBean.setSyouhnCd(keisanRsgakuSyouhinBean.getSyouhncd());
                    itkyKeisanRsgakuSyouhinBean.setSyouhnsdNo(keisanRsgakuSyouhinBean.getSyouhnsdno());
                    itkyKeisanRsgakuSyouhinBean.setRyouritusdNo(keisanRsgakuSyouhinBean.getRyouritusdno());
                    itkyKeisanRsgakuSyouhinBean.setYoteiRiritu(keisanRsgakuSyouhinBean.getYoteiRiritu());
                    itkyKeisanRsgakuSyouhinBean.setHokenryou(keisanRsgakuSyouhinBean.getHokenryou());

                    itkyKsRsgakuSyouhinBeanLst.add(itkyKeisanRsgakuSyouhinBean);
                }

                int keisanIkkatuNyuukinGkJttk = Integer.valueOf(pKeisanRsgakuBean.getTikiktbrisyuruikbn().getValue());
                int utiwakeKensuu = pKeisanRsgakuBean.getJyuutoutukisuu() / keisanIkkatuNyuukinGkJttk;

                KeisanIkkatuNyuukinGkBean keisanIkkatuNyuukinGkBean =
                    SWAKInjector.getInstance(KeisanIkkatuNyuukinGkBean.class);

                keisanIkkatuNyuukinGkBean.setKeisanIkkatuNyuukinGkSyouhnBeanLst(itkyKsRsgakuSyouhinBeanLst);
                keisanIkkatuNyuukinGkBean.setJyuutoutuKisuu(keisanIkkatuNyuukinGkJttk);
                keisanIkkatuNyuukinGkBean.setTkiktbrisyuruiKbn(pKeisanRsgakuBean.getTikiktbrisyuruikbn());
                keisanIkkatuNyuukinGkBean.setRstuukasyu(pKeisanRsgakuBean.getRstuukasyu());
                keisanIkkatuNyuukinGkBean.setNyknaiyouKbn(pKeisanRsgakuBean.getNyknaiyoukbn());
                keisanIkkatuNyuukinGkBean.setNykkeiro(pKeisanRsgakuBean.getNykkeiro());
                keisanIkkatuNyuukinGkBean.setSyokaiprsYmd(pKeisanRsgakuBean.getRsymd());
                keisanIkkatuNyuukinGkBean.setJyutoustartYm(pKeisanRsgakuBean.getJyutoustartym());

                KeisanTukiIkkatuNyuukinGk keisanTukiIkkatuNyuukinGk = SWAKInjector.getInstance(KeisanTukiIkkatuNyuukinGk.class);

                C_ErrorKbn ksIkkatuNyuukinGkResultKbn = keisanTukiIkkatuNyuukinGk.exec(keisanIkkatuNyuukinGkBean, false);

                if (C_ErrorKbn.OK.eq(ksIkkatuNyuukinGkResultKbn)) {

                    List<KeisanRsgkUtiwakeBean> keisanRsgkUtiwakeBeanLst = new ArrayList<KeisanRsgkUtiwakeBean>();

                    BizDateYM jyutoustartYm = pKeisanRsgakuBean.getJyutoustartym();
                    BizCurrency rsGakukei = BizCurrency.valueOf(0, keisanTukiIkkatuNyuukinGk.getIktnyknkgk().getType());
                    BizCurrency iktwaribikikgkGoukei = BizCurrency.valueOf(0, keisanTukiIkkatuNyuukinGk.getIktwaribikikgk().getType());
                    for (int i = 0; i < utiwakeKensuu; i++) {

                        KeisanRsgkUtiwakeBean keisanRsgkUtiwakeBean = SWAKInjector.getInstance(KeisanRsgkUtiwakeBean.class);

                        keisanRsgkUtiwakeBean.setJyutoustartym(jyutoustartYm);
                        keisanRsgkUtiwakeBean.setJyuutounensuu(0);
                        keisanRsgkUtiwakeBean.setJyuutoutukisuu(keisanIkkatuNyuukinGkJttk);
                        keisanRsgkUtiwakeBean.setRsgaku(keisanTukiIkkatuNyuukinGk.getIktnyknkgk());
                        keisanRsgkUtiwakeBean.setRyosyukwsratekjymd(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRateKjYmd());
                        keisanRsgkUtiwakeBean.setRyosyukwsrate(keisanTukiIkkatuNyuukinGk.getRyosyuKwsRate());
                        keisanRsgkUtiwakeBean.setIktnyuukinnumu(C_UmuKbn.ARI);
                        keisanRsgkUtiwakeBean.setIktwaribikikgk(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk());

                        keisanRsgkUtiwakeBeanLst.add(keisanRsgkUtiwakeBean);

                        jyutoustartYm = jyutoustartYm.addMonths(keisanIkkatuNyuukinGkJttk);
                        rsGakukei = rsGakukei.add(keisanTukiIkkatuNyuukinGk.getIktnyknkgk());
                        iktwaribikikgkGoukei = iktwaribikikgkGoukei.add(keisanTukiIkkatuNyuukinGk.getIktwaribikikgk());
                    }

                    keisanRsgkOutBean = SWAKInjector.getInstance(KeisanRsgkOutBean.class);
                    keisanRsgkOutBean.setRsgakuGoukei(rsGakukei);
                    keisanRsgkOutBean.setIktwaribikikgkGoukei(iktwaribikikgkGoukei);
                    keisanRsgkOutBean.setKeisanRsgkUtiwakeBeanLst(keisanRsgkUtiwakeBeanLst);
                }
                else {

                    resultKbn = C_ErrorKbn.ERROR;

                    errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_IKKATUNYUUKINGK_ERR;
                    errorCd.add(KeisanRsgakuConstants.ERRCD_IKKATUNYUUKINGK_ERR);
                }
            }
            else {

                KeisanTukiRsgakuBean keisanTukiRsgakuBean = SWAKInjector.getInstance(KeisanTukiRsgakuBean.class);

                keisanTukiRsgakuBean.setNykkeiro(pKeisanRsgakuBean.getNykkeiro());
                keisanTukiRsgakuBean.setNyknaiyoukbn(pKeisanRsgakuBean.getNyknaiyoukbn());
                keisanTukiRsgakuBean.setRsymd(pKeisanRsgakuBean.getRsymd());
                keisanTukiRsgakuBean.setJyutoustartym(pKeisanRsgakuBean.getJyutoustartym());
                keisanTukiRsgakuBean.setJyuutoutukisuu(pKeisanRsgakuBean.getJyuutoutukisuu());
                keisanTukiRsgakuBean.setRstuukasyu(pKeisanRsgakuBean.getRstuukasyu());
                keisanTukiRsgakuBean.setKeisanRsgakuSyouhinBeanLst(pKeisanRsgakuBean.getKeisanRsgakuSyouhinBeanLst());

                KeisanTukiRsgaku keisanTukiRsgaku = SWAKInjector.getInstance(KeisanTukiRsgaku.class);

                C_ErrorKbn keisanTukiRsgakuResultKbn = keisanTukiRsgaku.exec(keisanTukiRsgakuBean);

                if (C_ErrorKbn.OK.eq(keisanTukiRsgakuResultKbn)) {

                    keisanRsgkOutBean = keisanTukiRsgaku.getKeisanRsgkOutBean();
                }
                else {

                    resultKbn = C_ErrorKbn.ERROR;

                    errorRiyuu = pKeisanRsgakuBean.getHrkkaisuu().getContent() + keisanTukiRsgaku.getErrorRiyuu();
                    errorCd.addAll(keisanTukiRsgaku.getErrorCd());
                }
            }
        }

        logger.debug("△ 領収金額計算 終了");

        return resultKbn;
    }

    public C_ErrorKbn exec(IT_KykKihon pKykKihon, C_Nykkeiro pNykkeiro, C_NyknaiyouKbn pNyknaiyouKbn,
        BizDate pRsymd, BizDateYM pJyutoustartym, Integer pJyuutounensuu, Integer pJyuutoutukisuu) {

        logger.debug("▽ 領収金額計算 開始");

        C_ErrorKbn resultKbn = C_ErrorKbn.OK;

        errorCd = new ArrayList<String>();

        if (pKykKihon == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pNykkeiro == null || C_Nykkeiro.BLNK.eq(pNykkeiro)) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pNyknaiyouKbn == null || C_NyknaiyouKbn.BLNK.eq(pNyknaiyouKbn)) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pRsymd == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pJyutoustartym == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pJyuutounensuu == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        if (pJyuutoutukisuu == null) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_MINYUURYOKUERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_MINYUURYOKUERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        List<IT_KykSyouhn> kykSyouhnList = pKykKihon.getKykSyouhns();

        List<KeisanRsgakuSyouhinBean> keisanTukiRsgakuBeanList = new ArrayList<KeisanRsgakuSyouhinBean>();

        for (IT_KykSyouhn kykSyouhn: kykSyouhnList) {

            KeisanRsgakuSyouhinBean keisanRsgakuSyouhinBean = SWAKInjector.getInstance(KeisanRsgakuSyouhinBean.class);

            keisanRsgakuSyouhinBean.setSyouhncd(kykSyouhn.getSyouhncd());
            keisanRsgakuSyouhinBean.setSyouhnsdno(kykSyouhn.getSyouhnsdno());
            keisanRsgakuSyouhinBean.setRyouritusdno(kykSyouhn.getRyouritusdno());
            keisanRsgakuSyouhinBean.setYoteiRiritu(kykSyouhn.getYoteiriritu());
            keisanRsgakuSyouhinBean.setHokenryou(kykSyouhn.getHokenryou());

            keisanTukiRsgakuBeanList.add(keisanRsgakuSyouhinBean);
        }

        GetasPRsTuuka getasPRsTuuka = SWAKInjector.getInstance(GetasPRsTuuka.class);

        C_ErrorKbn getasPRsTuukaResult = getasPRsTuuka.exec(pKykKihon.getSyono());

        if (C_ErrorKbn.ERROR.eq(getasPRsTuukaResult)) {

            resultKbn = C_ErrorKbn.ERROR;

            errorRiyuu = KeisanRsgakuConstants.ERRRIYUU_PRSTUUKA_ERR;
            errorCd.add(KeisanRsgakuConstants.ERRCD_PRSTUUKA_ERR);

            logger.debug("△ 領収金額計算 終了");

            return resultKbn;
        }

        KeisanRsgakuBean keisanRsgakuBean = SWAKInjector.getInstance(KeisanRsgakuBean.class);

        keisanRsgakuBean.setHrkkaisuu(pKykKihon.getHrkkaisuu());
        keisanRsgakuBean.setTikiktbrisyuruikbn(pKykKihon.getTikiktbrisyuruikbn());
        keisanRsgakuBean.setNykkeiro(pNykkeiro);
        keisanRsgakuBean.setNyknaiyoukbn(pNyknaiyouKbn);
        keisanRsgakuBean.setRsymd(pRsymd);
        keisanRsgakuBean.setJyutoustartym(pJyutoustartym);
        keisanRsgakuBean.setJyuutounensuu(pJyuutounensuu);
        keisanRsgakuBean.setJyuutoutukisuu(pJyuutoutukisuu);
        keisanRsgakuBean.setRstuukasyu(getasPRsTuuka.getRstuukasyu());
        keisanRsgakuBean.setKeisanRsgakuSyouhinBeanLst(keisanTukiRsgakuBeanList);

        C_ErrorKbn keisanRsgakuResult = exec(keisanRsgakuBean);

        if (C_ErrorKbn.ERROR.eq(keisanRsgakuResult)) {

            resultKbn = C_ErrorKbn.ERROR;
        }

        logger.debug("△ 領収金額計算 終了");

        return resultKbn;
    }
}
