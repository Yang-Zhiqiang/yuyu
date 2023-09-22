package yuyu.common.sinkeiyaku.skcommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzdairiten.BzGetAgInfo;
import yuyu.common.biz.bzdairiten.BzGetAgInfoBean;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_DiritenjyouhouKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_TyhyrenrakusikibetuKbn;
import yuyu.def.db.entity.BM_Tyouhyourenrakusaki;
import yuyu.def.db.entity.HM_SkChannel;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 新契約 新契約共通 新契約チャネル情報取得
 */
public class GetSkChannelInfo {

    private final String COMMON_OYADAIRITENCD = "0000000";

    private C_Channelcd channelCd = C_Channelcd.BLNK;

    private C_SkeijimuKbn skeiJimuKbn = C_SkeijimuKbn.BLNK;

    private C_AisyoumeiChannelKbn aisyoumeiChannelKbn = C_AisyoumeiChannelKbn.BLNK;

    private C_Channelcd kiteiChkChannelCd = C_Channelcd.BLNK;

    private C_TyhyrenrakusikibetuKbn tyhyRenrakusikibetuKbn = C_TyhyrenrakusikibetuKbn.BLNK;

    private Integer sortNo = 0;

    private String ccTelno = "";

    private String ccImagePath = "";

    private String sapodeTelno = "";

    private String sapodeImagePath = "";

    private String sapodeFaxno = "";

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    public GetSkChannelInfo() {
        super();
    }

    public C_SkeijimuKbn getSkeiJimuKbn() {
        return skeiJimuKbn;
    }

    public C_AisyoumeiChannelKbn getAisyoumeiChannelKbn() {
        return aisyoumeiChannelKbn;
    }

    public C_Channelcd getKiteichkchannelcd() {
        return kiteiChkChannelCd;
    }

    public C_TyhyrenrakusikibetuKbn getTyhyrenrakusikibetukbn() {
        return tyhyRenrakusikibetuKbn;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public String getCctelno() {
        return ccTelno;
    }

    public String getCcimagepath() {
        return ccImagePath;
    }

    public String getSapodetelno() {
        return sapodeTelno;
    }

    public String getSapodeimagepath() {
        return sapodeImagePath;
    }

    public String getSapodefaxno() {
        return sapodeFaxno;
    }

    public void exec(C_Channelcd pChannelCd, String pDairitenCd) {

        boolean result = getSkeiChannelInfo(pChannelCd, pDairitenCd);

        if (!result) {

            result = getSkeiChannelInfo(C_Channelcd.TIGIN, "");

            if (!result) {

                throw new CommonBizAppException();
            }
        }
    }

    private boolean getSkeiChannelInfo(C_Channelcd pChannelCd, String pDairitenCd) {

        String oyaDrtenCd = "";

        if (BizUtil.isBlank(pDairitenCd) && pChannelCd == null) {

            return false;
        }

        if (pChannelCd == null) {

            BzGetAgInfo bzGetAgInfo = SWAKInjector.getInstance(BzGetAgInfo.class);

            List<BzGetAgInfoBean> bzGetAgInfoBeanList = bzGetAgInfo.exec(pDairitenCd);

            if (bzGetAgInfoBeanList == null || bzGetAgInfoBeanList.size() == 0) {

                return false;
            }

            for (int i = 0; i < bzGetAgInfoBeanList.size(); i++) {

                if (C_DiritenjyouhouKbn.SHITEIOYA.eq(bzGetAgInfoBeanList.get(i).getDiritenJyouhouKbn())) {

                    channelCd = bzGetAgInfoBeanList.get(i).getChannelCd();

                    oyaDrtenCd = bzGetAgInfoBeanList.get(i).getDrtenCd();

                    break;
                }
            }
        }
        else {

            channelCd = pChannelCd;

            oyaDrtenCd = pDairitenCd;
        }

        List<HM_SkChannel> skChannelList = sinkeiyakuDomManager.getSkChannelsByChannelcd(channelCd);

        HM_SkChannel skChannel = null;

        if (skChannelList.size() == 0) {

            return false;
        }
        else if (skChannelList.size() == 1) {

            skChannel = skChannelList.get(0);
        }
        else {

            for (int i = 0; i < skChannelList.size(); i++) {

                if (skChannelList.get(i).getOyadrtencd().equals(oyaDrtenCd)) {

                    skChannel = skChannelList.get(i);

                    break;
                }
            }

            if (skChannel == null) {

                for (int i = 0; i < skChannelList.size(); i++) {

                    if (COMMON_OYADAIRITENCD.equals(skChannelList.get(i).getOyadrtencd())) {

                        skChannel = skChannelList.get(i);

                        break;
                    }
                }
            }
        }

        if (skChannel == null) {

            return false;
        }

        BM_Tyouhyourenrakusaki tyouhyouRenrakusaki = skChannel.getTyouhyourenrakusaki();
        skeiJimuKbn = skChannel.getSkeijimukbn();
        aisyoumeiChannelKbn = skChannel.getAisyoumeichannelkbn();
        kiteiChkChannelCd = skChannel.getKiteichkchannelcd();
        tyhyRenrakusikibetuKbn = skChannel.getTyhyrenrakusikibetukbn();
        sortNo = skChannel.getSortNo();
        ccTelno = tyouhyouRenrakusaki.getCctelno();
        ccImagePath = tyouhyouRenrakusaki.getCcimagepath();
        sapodeTelno = tyouhyouRenrakusaki.getSapodetelno();
        sapodeImagePath = tyouhyouRenrakusaki.getSapodeimagepath();
        sapodeFaxno = tyouhyouRenrakusaki.getSapodefaxno();

        return true;
    }
}