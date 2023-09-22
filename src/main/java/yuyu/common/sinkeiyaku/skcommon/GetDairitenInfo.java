package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.bzdairiten.BzGetBsInfo;
import yuyu.common.biz.bzdairiten.BzGetBsInfoBean;
import yuyu.def.classification.C_DiritenjyouhouKbn;

/**
 * 新契約 新契約共通 代理店情報取得
 */
public class GetDairitenInfo {

    private String tratkiagNm = "";

    private String oyadrtenNm = "";

    private String bosyuuNm = "";

    public GetDairitenInfo() {
        super();
    }

    public String getTratkiagnm() {
        return tratkiagNm;
    }

    public String getOyadrtennm() {
        return oyadrtenNm;
    }

    public String getBosyuunm() {
        return bosyuuNm;
    }

    public void exec(String pTratkiagCd, String pOyadrtenCd, String pBosyuuCd, BizDate pMosymd) {

        tratkiagNm = "";
        oyadrtenNm = "";
        bosyuuNm = "";

        String drtenCd = "";

        if (!BizUtil.isBlank(pOyadrtenCd)) {
            drtenCd = pOyadrtenCd;
        }

        if (!BizUtil.isBlank(pTratkiagCd)) {
            drtenCd = pTratkiagCd;
        }

        if (!BizUtil.isBlank(drtenCd)) {
            List<BzGetAgInfoBean> bzGetAgInfoBeanList = getTratkiagnmFromDairiten(drtenCd, pMosymd);

            for (int i = 0; i < bzGetAgInfoBeanList.size(); i++) {

                if (C_DiritenjyouhouKbn.SHITEIKO.eq(bzGetAgInfoBeanList.get(i).getDiritenJyouhouKbn())) {

                    tratkiagNm = bzGetAgInfoBeanList.get(i).getKanjiDairitenNm();

                    break;
                }
            }

            if (!BizUtil.isBlank(pOyadrtenCd)) {

                for (int i = 0; i < bzGetAgInfoBeanList.size(); i++) {

                    if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBeanList.get(i).getDiritenJyouhouKbn())) {

                        if (pOyadrtenCd.equals(bzGetAgInfoBeanList.get(i).getOyadrtenCd())) {

                            oyadrtenNm = bzGetAgInfoBeanList.get(i).getKanjiDairitenNm();

                            break;
                        }

                        List<BzGetAgInfoBean> oyaBzGetAgInfoBeanList = getTratkiagnmFromDairiten(pOyadrtenCd,
                            pMosymd);

                        for (int j = 0; j < oyaBzGetAgInfoBeanList.size(); j++) {

                            if (C_DiritenjyouhouKbn.SHITEIKO
                                .eq(oyaBzGetAgInfoBeanList.get(j).getDiritenJyouhouKbn())) {

                                oyadrtenNm = oyaBzGetAgInfoBeanList.get(j).getKanjiDairitenNm();

                                break;
                            }
                        }
                    }
                }
            }
        }

        if (!BizUtil.isBlank(pBosyuuCd)) {

            bosyuuNm = getBosyuunmFromDairiten(pBosyuuCd, pMosymd);
        }
    }

    private List<BzGetAgInfoBean> getTratkiagnmFromDairiten(String pTratkiagCd, BizDate pMosymd) {

        BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

        return bzGetAgInfo.exec(pTratkiagCd);
    }

    private String getBosyuunmFromDairiten(String pBosyuuCd, BizDate pMosymd) {

        BzGetBsInfo bzGetBsInfo = SWAKInjector.getInstance(BzGetBsInfo.class);
        String wkBosyuuNm = "";

        BzGetBsInfoBean bzGetBsInfoBean = bzGetBsInfo.exec(pBosyuuCd);

        if (bzGetBsInfoBean != null) {

            wkBosyuuNm = bzGetBsInfoBean.getKanjiBosyuuninNm();
        }

        return wkBosyuuNm;
    }
}