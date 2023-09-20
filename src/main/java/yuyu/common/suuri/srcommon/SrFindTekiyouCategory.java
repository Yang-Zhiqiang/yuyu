package yuyu.common.suuri.srcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.google.common.base.Strings;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_NaibuKeiyakuKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TekiyouKbn;

/**
 *  摘要項目取得クラス
 */
public class SrFindTekiyouCategory {

    @Inject
    private static Logger logger;

    private static final String BLANK = "";

    public SrFindTekiyouCategory() {
        super();
    }

    public SrFindTekiyouCategoryBean getAppropriateTekiyouCom(
        C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TekiyouKbn pTekiyouKbn,
        C_NaibuKeiyakuKbn pNaibuKeiyakuKbn
        ) {

        logger.debug("▽ 摘要項目取得（共通） 開始");

        SrFindTekiyouCategoryBean bean = SWAKInjector.getInstance(SrFindTekiyouCategoryBean.class);

        if (C_Kanjyoukmkcd.JIGYOUHI.eq(pKanjyoukmkcd)) {

        }
        else {
            bean.setTekiyoucd(BLANK);
            bean.setTekiyounm(BLANK);
        }

        logger.debug("△ 摘要項目取得（共通） 終了");

        return bean;
    }

    public SrFindTekiyouCategoryBean getAppropriateTekiyou(
        C_Kanjyoukmkcd pKanjyoukmkcd,
        C_TekiyouKbn pTekiyouKbn,
        C_NaibuKeiyakuKbn pNaibuKeiyakuKbn,
        C_Segcd pSegcd,
        String pSegnm
        ) {

        logger.debug("▽ 摘要項目取得 開始");

        SrFindTekiyouCategoryBean bean = SWAKInjector.getInstance(SrFindTekiyouCategoryBean.class);

        if (C_Kanjyoukmkcd.JIGYOUHI.eq(pKanjyoukmkcd)) {

            bean = this.getAppropriateTekiyouCom(pKanjyoukmkcd, pTekiyouKbn,
                pNaibuKeiyakuKbn);

        }
        else {

            if (pSegcd != null && !Strings.isNullOrEmpty(pSegcd.getValue()) && !C_Segcd.BLNK.eq(pSegcd)) {

                bean.setTekiyoucd(pSegcd.getValue());
                bean.setTekiyounm(pSegnm);
            }
            else {

                bean.setTekiyoucd(BLANK);
                bean.setTekiyounm(BLANK);
            }
        }

        logger.debug("△ 摘要項目取得 終了");

        return bean;
    }

}
