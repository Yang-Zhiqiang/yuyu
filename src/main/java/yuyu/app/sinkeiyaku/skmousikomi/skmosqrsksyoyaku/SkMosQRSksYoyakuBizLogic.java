package yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku;
import static yuyu.app.sinkeiyaku.skmousikomi.skmosqrsksyoyaku.GenSkMosQRSksYoyakuConstants.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.sinkeiyaku.skcommon.SkConvKbn;
import yuyu.def.MessageId;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_MosnoSaibanKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNoAisyou;
import yuyu.def.db.entity.HT_GaibuQrYoyaku2;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;
import yuyu.def.sinkeiyaku.manager.SinkeiyakuDomManager;

/**
 * 申込書類用QR作成予約 のビジネスロジックです。
 */
public class SkMosQRSksYoyakuBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private SkMosQRSksYoyakuUiBean uiBean;

    @Inject
    private SinkeiyakuDomManager sinkeiyakuDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    void init() {

        clear();

        List<HM_SkHokenSyuruiNo> skHokenSyuruiNoLst =
            sinkeiyakuDomManager.getSkHokenSyuruiNosByHyoujitoymdGt(BizDate.getSysDate());

        UserDefsList userDefsList = new UserDefsList();

        userDefsList.add(new LabelValuePair());

        for (HM_SkHokenSyuruiNo skHokenSyuruiNo : skHokenSyuruiNoLst) {

            LabelValuePair labelValuePair = new LabelValuePair();
            labelValuePair.setLabel(C_HknsyuruiNo.getContentByValue(
                C_HknsyuruiNo.PATTERN_QRSKSYOYAKU, skHokenSyuruiNo.getHknsyuruino().getValue()));
            labelValuePair.setValue(String.valueOf(skHokenSyuruiNo.getHknsyuruino()));

            userDefsList.add(labelValuePair);
        }

        uiBean.setHknsyuruinmOptionBeanList(userDefsList);

        editYoyakuList();
    }

    void clear() {

        uiBean.setSkeijimukbn(C_SkeijimuKbn.BLNK);
        uiBean.setHknsyuruinm("");
        uiBean.setSakuseikensuu(null);

        BizPropertyInitializer.initialize(uiBean);
    }

    @Transactional
    void kakuteiBtnOnClick() {

        C_HknsyuruiNo hknsyuruiNo = C_HknsyuruiNo.valueOf(uiBean.getHknsyuruinm());

        SkConvKbn skConvKbn = SWAKInjector.getInstance(SkConvKbn.class);

        C_AisyoumeiChannelKbn aisyoumeiChannelKbn = skConvKbn.getAisyoumeiChannelKbn(uiBean.getSkeijimukbn());

        List<HM_SkHokenSyuruiNoAisyou> skHokenSyuruiNoAisyouLst = sinkeiyakuDomManager.
            getSkHokenSyuruiNoAisyousByHknsyuruinoAisyoumeichannelkbn(hknsyuruiNo, aisyoumeiChannelKbn);

        if (skHokenSyuruiNoAisyouLst.size() == 0) {

            throw new BizLogicException(
                MessageId.EHA1036,
                MessageUtil.getMessage(DDID_INPUTYOYAKUINFO_HKNSYURUINM.getErrorResourceKey()),
                MessageUtil.getMessage(DDID_INPUTYOYAKUINFO_SKEIJIMUKBN.getErrorResourceKey()));
        }

        boolean qrSksYoyaku = true;

        if (C_MosnoSaibanKbn.KIT.eq(uiBean.getMosnosaibankbn())) {
            if (C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(hknsyuruiNo)) {
                qrSksYoyaku = false;
            }
        }
        else if (C_MosnoSaibanKbn.KIT2KEN.eq(uiBean.getMosnosaibankbn())) {
            if (!C_HknsyuruiNo.GAIKARIRITUHENDOUNK.eq(hknsyuruiNo)) {
                qrSksYoyaku = false;
            }
        }
        else if (C_MosnoSaibanKbn.PPLESSNIT.eq(uiBean.getMosnosaibankbn())) {
            if (!C_SkeijimuKbn.TIGINSINKIN.eq(uiBean.getSkeijimukbn())) {
                qrSksYoyaku = false;
            }
        }

        if (!qrSksYoyaku) {
            throw new BizLogicException(MessageId.EHA1105);
        }

        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst =
            sinkeiyakuDomManager.getGaibuQrYoyaku2sBySkeijimukbnHknsyuruinoMosnosaibankbnQrsakuseiymd(
                uiBean.getSkeijimukbn(), hknsyuruiNo, uiBean.getMosnosaibankbn(), null);

        if (gaibuQrYoyaku2Lst.size() >= 1) {

            throw new BizLogicException(MessageId.EHF1004);
        }

        if (uiBean.getSakuseikensuu() < YuyuSinkeiyakuConfig.getInstance().getQrsakuseikensuuMin()) {

            throw new BizLogicException(
                MessageId.EHA1027,
                String.valueOf(YuyuSinkeiyakuConfig.getInstance().getQrsakuseikensuuMin()));
        }

        HT_GaibuQrYoyaku2 gaibuQrYoyaku2 = new HT_GaibuQrYoyaku2();

        gaibuQrYoyaku2.setSyoriYmd(BizDate.getSysDate());

        gaibuQrYoyaku2.setSkeijimukbn(uiBean.getSkeijimukbn());

        gaibuQrYoyaku2.setHknsyuruino(hknsyuruiNo);

        gaibuQrYoyaku2.setMosnosaibankbn(uiBean.getMosnosaibankbn());

        if (C_MosnoSaibanKbn.KIT2KEN.eq(uiBean.getMosnosaibankbn())) {
            gaibuQrYoyaku2.setMosnosaibansuu(2);
        }
        else {
            gaibuQrYoyaku2.setMosnosaibansuu(1);
        }

        gaibuQrYoyaku2.setSakuseikensuu(uiBean.getSakuseikensuu());

        gaibuQrYoyaku2.setGyoumuKousinsyaId(baseUserInfo.getUserId());

        gaibuQrYoyaku2.setGyoumuKousinTime(BizDate.getSysDateTime());

        BizPropertyInitializer.initialize(gaibuQrYoyaku2);

        sinkeiyakuDomManager.insert(gaibuQrYoyaku2);

        clear();

        editYoyakuList();
    }

    @Transactional
    void sakujyoLinkOnClick() {

        HT_GaibuQrYoyaku2 gaibuQrYoyaku = sinkeiyakuDomManager.getGaibuQrYoyaku2(
            uiBean.getYoyakuInfoListDataSource().getSelectedBean().getDisptrkymd(),
            uiBean.getYoyakuInfoListDataSource().getSelectedBean().getDispskeijimukbn(),
            uiBean.getYoyakuInfoListDataSource().getSelectedBean().getDisphknsyuruino(),
            uiBean.getYoyakuInfoListDataSource().getSelectedBean().getDispmosnosaibankbn());

        sinkeiyakuDomManager.delete(gaibuQrYoyaku);

        clear();

        editYoyakuList();
    }

    private void editYoyakuList() {

        List<HT_GaibuQrYoyaku2> gaibuQrYoyaku2Lst = sinkeiyakuDomManager.getGaibuQrYoyaku2sByQrsakuseiymd(null);

        List<YoyakuInfoListDataSourceBean> yoyakuInfoListDataSourceBeanLst = new
            ArrayList<YoyakuInfoListDataSourceBean>();

        for (HT_GaibuQrYoyaku2 gaibuQrYoyaku2 : gaibuQrYoyaku2Lst) {

            YoyakuInfoListDataSourceBean yoyakuInfoListDataSourceBean = SWAKInjector.getInstance(
                YoyakuInfoListDataSourceBean.class);

            yoyakuInfoListDataSourceBean.setDisptrkymd(gaibuQrYoyaku2.getSyoriYmd());

            yoyakuInfoListDataSourceBean.setDispqryoyakutime(gaibuQrYoyaku2.getGyoumuKousinTime().substring(8, 10)
                + ":" + gaibuQrYoyaku2.getGyoumuKousinTime().substring(10, 12));

            yoyakuInfoListDataSourceBean.setDispskeijimukbn(gaibuQrYoyaku2.getSkeijimukbn());

            yoyakuInfoListDataSourceBean.setDisphknsyuruino(gaibuQrYoyaku2.getHknsyuruino());

            yoyakuInfoListDataSourceBean.setDispmosnosaibankbn(gaibuQrYoyaku2.getMosnosaibankbn());

            yoyakuInfoListDataSourceBean.setDispsakuseikensuu(gaibuQrYoyaku2.getSakuseikensuu());

            yoyakuInfoListDataSourceBean.setSakujyoLink(MessageUtil.getMessage(
                DDID_YOYAKUINFOLIST_SAKUJYOLINK.getErrorResourceKey()));

            yoyakuInfoListDataSourceBeanLst.add(yoyakuInfoListDataSourceBean);

        }

        uiBean.setYoyakuInfoList(yoyakuInfoListDataSourceBeanLst);

    }
}
