package yuyu.common.sinkeiyaku.skcommon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;
import yuyu.def.sinkeiyaku.sorter.SortHM_SkHokenSyuruiNo;

/**
 * 新契約 新契約共通 保険種類名取得
 */
public class GetHknsyuruinm {

    @Inject
    private static Logger logger;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public HknsyuruinmBean getHknsyuruinm(C_HknsyuruiNo pHknnsyuruiNo,
        Integer PHknsyuruinosd, C_AisyoumeiKbn pAisyoumeikbn) {

        logger.debug("▽ 保険種類名取得 開始");

        C_HknsyuruiNo hknnsyuruiNo = pHknnsyuruiNo;

        Integer hknsyuruinosd = PHknsyuruinosd;

        C_AisyoumeiKbn aisyoumeikbn = pAisyoumeikbn;

        HknsyuruinmBean hknsyuruinmBean = SWAKInjector.getInstance(HknsyuruinmBean.class);

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst = new ArrayList<>();

        if (hknnsyuruiNo == null || C_HknsyuruiNo.BLNK.eq(hknnsyuruiNo) ||
            aisyoumeikbn == null || C_AisyoumeiKbn.BLNK.eq(aisyoumeikbn)) {

            throw new CommonBizAppException("パラメーター不正");
        }

        if ((hknsyuruinosd == null) || hknsyuruinosd == 0) {

            skHokenSyuruiNoLst = sinkeiyakuDomManager.getSkHokenSyuruiNosByHknsyuruino(hknnsyuruiNo);

            SortHM_SkHokenSyuruiNo sortHM_SkHokenSyuruiNo = SWAKInjector.getInstance(SortHM_SkHokenSyuruiNo.class);

            skHokenSyuruiNoLst = sortHM_SkHokenSyuruiNo.OrderHM_SkHokenSyuruiNoByPkDesc(skHokenSyuruiNoLst);
        }
        else {

            HM_SkHokenSyuruiNo hmSkHokenSyuruiNo = sinkeiyakuDomManager.getSkHokenSyuruiNo(
                hknnsyuruiNo, hknsyuruinosd);

            skHokenSyuruiNoLst.add(hmSkHokenSyuruiNo);
        }

        String hknsyuruinm = "";
        String aisyoumei = "";
        String aisyoumeikakko = "";

        if (skHokenSyuruiNoLst.size() == 0) {

            throw new CommonBizAppException("保険種類番号="
                + hknnsyuruiNo.toString() + "　保険種類番号世代="
                + hknsyuruinosd);
        }

        hknsyuruinm = skHokenSyuruiNoLst.get(0).getHknsyuruinm();

        aisyoumei = aisyoumeikbn.getContent();

        if (!BizUtil.isBlank(aisyoumei)) {

            aisyoumeikakko = "「" + aisyoumei + "」";

        }

        hknsyuruinmBean.setHknsyuruinm(hknsyuruinm);
        hknsyuruinmBean.setAisyoumei(aisyoumei);
        hknsyuruinmBean.setAisyoumeikakko(aisyoumeikakko);
        hknsyuruinmBean.setAisyoumeikbn(aisyoumeikbn);
        hknsyuruinmBean.setKokyakuhknnsyuruinm(hknsyuruinm+" "+aisyoumeikakko);
        hknsyuruinmBean.setKokyakuhknnsyuruinmtwogyou1(hknsyuruinm);
        hknsyuruinmBean.setKokyakuhknnsyuruinmtwogyou2(aisyoumeikakko);

        logger.debug("△ 保険種類名取得 終了");

        return hknsyuruinmBean;
    }

    public  HknsyuruinmBean getAisyoumeiMosnrk(String pHknsyuruino,
        Integer pHknsyuruinosd, C_SkeijimuKbn pSkeijimuKbn, String pSyouhncd) {

        logger.debug("▽ 愛称名取得（申込書入力用） 開始");

        String hknsyuruino = pHknsyuruino;

        Integer hknsyuruinosd = pHknsyuruinosd;

        C_SkeijimuKbn skeijimuKbn = pSkeijimuKbn;

        String syouhncd = pSyouhncd;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.MADOHAN;

        HknsyuruinmBean hknsyuruinmBean = null;

        if (BizUtil.isBlank(hknsyuruino) || hknsyuruinosd == null || syouhncd == null) {

            throw new CommonBizAppException("パラメーター不正");
        }

        SkConvKbn skconvKbn = SWAKInjector.getInstance(SkConvKbn.class);

        aisyoumeiChannelKbn = skconvKbn.getAisyoumeiChannelKbn(skeijimuKbn);

        hknsyuruinmBean = setAisyoumeikbn(hknsyuruino, hknsyuruinosd, aisyoumeiChannelKbn, syouhncd);

        logger.debug("△ 愛称名取得（申込書入力用） 終了");

        return hknsyuruinmBean;
    }

    public HknsyuruinmBean setAisyoumeikbn(String pHknsyuruino,
        Integer pHknsyuruinosd, C_AisyoumeiChannelKbn pAisyoumeiChannelKbn, String pSyouhncd) {

        logger.debug("▽ 愛称名区分設定 開始");

        String hknsyuruino = pHknsyuruino;

        Integer hknsyuruinosd = pHknsyuruinosd;

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = pAisyoumeiChannelKbn;

        HknsyuruinmBean hknsyuruinmBean =  SWAKInjector.getInstance(HknsyuruinmBean.class);

        SyouhinUtil syouhinUtil = SWAKInjector.getInstance(SyouhinUtil.class);

        String hknsyuruinoBetukey1 = "";

        if (BizUtil.isBlank(hknsyuruino) || (hknsyuruinosd == null) ||
            ((pAisyoumeiChannelKbn == null) || C_AisyoumeiChannelKbn.BLNK.eq(aisyoumeiChannelKbn))) {

            throw new CommonBizAppException("パラメーター不正");
        }

        hknsyuruinoBetukey1 = syouhinUtil.getHknsyuNoKeyToAisyou(pSyouhncd, C_HknsyuruiNo.valueOf(hknsyuruino));

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouLst = sinkeiyakuDomManager
            .getSkHokenSyuruiNoAisyousByPK(
                C_HknsyuruiNo.valueOf(pHknsyuruino),
                hknsyuruinosd, aisyoumeiChannelKbn, hknsyuruinoBetukey1);

        HM_SkHokenSyuruiNoAisyou skHokenSyuruiNoAisyou = SWAKInjector.getInstance(HM_SkHokenSyuruiNoAisyou.class);

        if (skHokenSyuruiNoAisyouLst.size() == 0) {

            hknsyuruinmBean.setAisyoumeikbn(C_AisyoumeiKbn.BLNK);

            hknsyuruinmBean.setAisyoumei("");

            logger.debug("△ 愛称名区分設定 終了");

            return hknsyuruinmBean;
        }

        skHokenSyuruiNoAisyou = skHokenSyuruiNoAisyouLst.get(0);

        hknsyuruinmBean.setAisyoumeikbn(skHokenSyuruiNoAisyou.getAisyoumeikbn());

        hknsyuruinmBean.setAisyoumei(skHokenSyuruiNoAisyou.getAisyoumei());

        logger.debug("△ 愛称名区分設定 終了");

        return hknsyuruinmBean;
    }
}