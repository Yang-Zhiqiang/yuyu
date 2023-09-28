package yuyu.common.biz.kaikei;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.number.BizCurrency;
import jp.co.slcs.swak.number.currencytype.CurrencyType;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.HenkanTuuka;
import yuyu.common.biz.kaikei.dba4bzjkusymtgosknidougkkeisan.BzJkuSymtgoSknidougkKeisanDao;
import yuyu.common.biz.kaikei.dba4bzjkusymtgosknidougkkeisan.SknidouzmgkBean;
import yuyu.common.hozen.khcommon.SetOutoubi;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Hrkkaisuu;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TykzentykgoKbn;
import yuyu.def.classification.C_UmuKbn;

/**
 * 業務共通 経理・会計 時効消滅後資金移動額計算
 */
public class BzJkuSymtgoSknidougkKeisan {

    private BizCurrency jkuSymtgoShrjSknidougk;

    @Inject
    private String errorMsgid;

    @Inject
    private String errorMsgInfo;

    @Inject
    private BzJkuSymtgoSknidougkKeisanDao bzJkuSymtgoSknidougkKeisanDao;

    @Inject
    private static Logger logger;

    public BzJkuSymtgoSknidougkKeisan() {
        super();
    }

    public C_ErrorKbn keisanJkuSymtgoSknidougk(BzJkuSymtgoSknidougkKeisanmtBean pBzJkuSymtgoSknidougkKeisanmtBean) {

        logger.debug("▽ 時効消滅後資金移動額計算処理 開始");

        C_Tuukasyu kyktuukasyu = pBzJkuSymtgoSknidougkKeisanmtBean.getKyktuukasyu();
        HenkanTuuka henkanTuuka = SWAKInjector.getInstance(HenkanTuuka.class);
        CurrencyType tuukaType = henkanTuuka.henkanTuukaKbnToType(kyktuukasyu);

        jkuSymtgoShrjSknidougk = BizCurrency.valueOf(0, tuukaType);
        C_Segcd segCd = C_Segcd.BLNK;
        C_UmuKbn itijibrUmu = C_UmuKbn.NONE;
        C_HijynnykzndkkouzaKbn hijynnykzndkkouzaKbn = C_HijynnykzndkkouzaKbn.BLNK;
        BizCurrency mikeikapZennouSeisankin = BizCurrency.valueOf(0, tuukaType);
        BizCurrency zennouSeisankin = BizCurrency.valueOf(0, tuukaType);
        BizCurrency mikeikap = BizCurrency.valueOf(0, tuukaType);
        C_ErrorKbn errorKbn = C_ErrorKbn.OK;

        if (C_Tuukasyu.JPY.eq(kyktuukasyu)) {

            logger.debug("△ 時効消滅後資金移動額計算処理 終了");
            return errorKbn;
        }

        BzSegmentCdSyutoku bzSegmentCdSyutoku = SWAKInjector.getInstance(BzSegmentCdSyutoku.class);
        SyouhinbetuSegmentBean syouhinbetuSegmentBean = bzSegmentCdSyutoku
            .exec(pBzJkuSymtgoSknidougkKeisanmtBean.getSyouhncd(), kyktuukasyu);

        if (C_ErrorKbn.ERROR.eq(syouhinbetuSegmentBean.getErrorKbn())) {

            errorKbn = C_ErrorKbn.ERROR;
            errorMsgid = "EBA1056";
            errorMsgInfo = "時効消滅後資金移動額計算";

            logger.debug("△ 時効消滅後資金移動額計算処理 終了");
            return errorKbn;
        }

        segCd = syouhinbetuSegmentBean.getSegcd1();

        BzSikinIdouHanteiInfoSyutoku bzSikinIdouHanteiInfoSyutoku = SWAKInjector
            .getInstance(BzSikinIdouHanteiInfoSyutoku.class);
        SikinIdouHanteiInfoDataBean sikinIdouHanteiInfoDataBean = bzSikinIdouHanteiInfoSyutoku
            .getSikinIdouHanteiInfoDataBean(segCd);

        if (C_ErrorKbn.ERROR.eq(sikinIdouHanteiInfoDataBean.getErrorKbn())) {

            errorKbn = C_ErrorKbn.ERROR;
            errorMsgid = "EBA1056";
            errorMsgInfo = "時効消滅後資金移動額計算";

            logger.debug("△ 時効消滅後資金移動額計算処理 終了");
            return errorKbn;
        }

        itijibrUmu = sikinIdouHanteiInfoDataBean.getItijibrUmu();
        hijynnykzndkkouzaKbn = sikinIdouHanteiInfoDataBean.getHijynnykZndkkouzaKbn();

        if (C_UmuKbn.ARI.eq(itijibrUmu)) {

            jkuSymtgoShrjSknidougk = pBzJkuSymtgoSknidougkKeisanmtBean.getHokenkngkgoukeiKyktuuka();
        }
        else {

            if (C_HijynnykzndkkouzaKbn.YENHONKZ.eq(hijynnykzndkkouzaKbn)) {

                if (zennouSeisankin.compareTo(pBzJkuSymtgoSknidougkKeisanmtBean.getZennouseisankinKyktuuka()) != 0
                    || mikeikap.compareTo(pBzJkuSymtgoSknidougkKeisanmtBean.getMikeikapKyktuuka()) != 0) {

                    mikeikapZennouSeisankin = keisanSikinIdouzuMikeikapZennouSeisangk(
                        pBzJkuSymtgoSknidougkKeisanmtBean.getSyono(), mikeikapZennouSeisankin,
                        pBzJkuSymtgoSknidougkKeisanmtBean.getMikeikapKyktuuka(),
                        pBzJkuSymtgoSknidougkKeisanmtBean.getMikeikapjyuutouym(),
                        pBzJkuSymtgoSknidougkKeisanmtBean.getZennouseisankijyunymd(),
                        pBzJkuSymtgoSknidougkKeisanmtBean.getKykymd(), mikeikap);
                }
            }
            else if (C_HijynnykzndkkouzaKbn.GKHONKZ.eq(hijynnykzndkkouzaKbn)) {

                mikeikapZennouSeisankin = pBzJkuSymtgoSknidougkKeisanmtBean.getZennouseisankinKyktuuka()
                    .add(pBzJkuSymtgoSknidougkKeisanmtBean.getMikeikapKyktuuka());
            }
            else {

                errorKbn = C_ErrorKbn.ERROR;
                errorMsgid = "EBA1056";
                errorMsgInfo = "時効消滅後資金移動額計算";

                logger.debug("△ 時効消滅後資金移動額計算処理 終了");
                return errorKbn;
            }

            jkuSymtgoShrjSknidougk = pBzJkuSymtgoSknidougkKeisanmtBean.getHokenkngkgoukeiKyktuuka()
                .subtract(pBzJkuSymtgoSknidougkKeisanmtBean.getMisyuupKyktuuka()).add(mikeikapZennouSeisankin)
                .add(pBzJkuSymtgoSknidougkKeisanmtBean.getZitkazkrknstituka());
        }

        logger.debug("△ 時効消滅後資金移動額計算処理 終了");

        return errorKbn;
    }

    public BizCurrency keisanSikinIdouzuMikeikapZennouSeisangk(String pSyono, BizCurrency pMikeikapZennouSeisankin,
        BizCurrency pMisyuupKyktuuka, BizDateYM pMikeikapjyuutouym,
        BizDate pZennouseisankijyunymd, BizDate pKykymd, BizCurrency pMikeikap) {

        logger.debug("▽ 資金移動済未経過Ｐ前納精算金算出 開始");

        BizDateYM mkkpZennouseisanJyuutouym = null;
        BizDate zennouseisanTykgooutouymd = null;
        BizCurrency mikeikapZennouSeisankin = pMikeikapZennouSeisankin;

        if (pMisyuupKyktuuka.compareTo(pMikeikap) != 0) {

            mkkpZennouseisanJyuutouym = pMikeikapjyuutouym;
        }
        else {

            SetOutoubi setOutoubi = SWAKInjector.getInstance(SetOutoubi.class);
            zennouseisanTykgooutouymd = setOutoubi.exec(C_TykzentykgoKbn.TYKGO, pKykymd, C_Hrkkaisuu.NEN,
                pZennouseisankijyunymd);
            mkkpZennouseisanJyuutouym = zennouseisanTykgooutouymd.getBizDateYM();
        }

        List<SknidouzmgkBean> sknidouzmgkBeanLst = bzJkuSymtgoSknidougkKeisanDao.getSknidouzmgkBeans(pSyono,
            mkkpZennouseisanJyuutouym);

        for (SknidouzmgkBean sknidouzmgkBean : sknidouzmgkBeanLst) {

            mikeikapZennouSeisankin = mikeikapZennouSeisankin.add(sknidouzmgkBean.getSiteituukagk());
        }

        logger.debug("△ 資金移動済未経過Ｐ前納精算金算出 終了");
        return mikeikapZennouSeisankin;
    }

    public BizCurrency getJkuSymtgoShrjSknidougk() {

        return this.jkuSymtgoShrjSknidougk;
    }

    public String getErrorMsgid() {

        return this.errorMsgid;
    }

    public String getErrorMsgInfo() {

        return this.errorMsgInfo;
    }

}
