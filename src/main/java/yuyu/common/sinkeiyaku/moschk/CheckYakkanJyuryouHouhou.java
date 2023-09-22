package yuyu.common.sinkeiyaku.moschk;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.bzcommon.GetBunsyoNo;
import yuyu.common.biz.bzcommon.GetBunsyoNoOutBean;
import yuyu.common.biz.bzcommon.ICommonKoumoku;
import yuyu.common.sinkeiyaku.skcommon.GetHknsyuruinm;
import yuyu.common.sinkeiyaku.skcommon.GetSkChannelInfo;
import yuyu.common.sinkeiyaku.skcommon.HknsyuruinmBean;
import yuyu.def.MessageId;
import yuyu.def.classification.C_AisyoumeiChannelKbn;
import yuyu.def.classification.C_AisyoumeiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_SkeijimuKbn;
import yuyu.def.classification.C_SysKbn;
import yuyu.def.classification.C_YakkanJyuryouKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.HT_MosDairiten;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 約款受領方法チェック<br/>
 * 約款受領方法のチェック　および　約款文書番号の設定を行う。
 */
public class CheckYakkanJyuryouHouhou {

    private C_YouhiKbn yakkanJyuryouSentakuYouhiKbn;

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public CheckYakkanJyuryouHouhou() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 約款受領方法チェック 開始");
        }

        if (C_SysKbn.ESHIEN.eq(pMp.getSysKbn())) {
            if (logger.isDebugEnabled()) {
                logger.debug("△ 約款受領方法チェック 終了");
            }

            return;
        }

        yakkanJyuryouSentakuYouhiKbn = C_YouhiKbn.HUYOU;

        String yakkanbunsyoNo = "";
        String sioriNo = "";
        String oyadrtencd = null;

        List<HT_MosDairiten> mosDairitenLst = pMp.getDataSyoriControl().getMosDairitens();
        if (mosDairitenLst != null && mosDairitenLst.size() > 0) {
            oyadrtencd = mosDairitenLst.get(0).getOyadrtencd();
        }

        if (!BizUtil.isBlank(oyadrtencd)) {

            hanteiSentakuYouhi(pMp, oyadrtencd);

            check(pMp);
        }

        if (!BizUtil.isBlank(oyadrtencd) &&
            pMp.getDataSyoriControl().getMosKihon().getMosymd() != null &&
            pMp.getDataSyoriControl().getMosKihon().getHknsyuruino() != null &&
            pMp.getDataSyoriControl().getMosKihon().getHknsyuruinosd() != null &&
            !BizUtil.isBlank(pMp.getSyuSyouhnZokusei().getSyouhncd())) {
            GetSkChannelInfo getSkChannelInfo = SWAKInjector.getInstance(GetSkChannelInfo.class);
            getSkChannelInfo.exec(null, oyadrtencd);
            if (getSkChannelInfo.getAisyoumeiChannelKbn() != null &&
                !C_AisyoumeiChannelKbn.BLNK.eq(getSkChannelInfo.getAisyoumeiChannelKbn())) {
                GetHknsyuruinm getHknsyuruinm = SWAKInjector.getInstance(GetHknsyuruinm.class);
                HknsyuruinmBean retBean = getHknsyuruinm.setAisyoumeikbn(
                    pMp.getDataSyoriControl().getMosKihon().getHknsyuruino().getValue(),
                    pMp.getDataSyoriControl().getMosKihon().getHknsyuruinosd(),
                    getSkChannelInfo.getAisyoumeiChannelKbn(),
                    pMp.getSyuSyouhnZokusei().getSyouhncd());
                if (retBean.getAisyoumeikbn() != null && !C_AisyoumeiKbn.BLNK.eq(retBean.getAisyoumeikbn())) {
                    GetBunsyoNo getBunsyoNo = SWAKInjector.getInstance(GetBunsyoNo.class);

                    GetBunsyoNoOutBean getBunsyoNoOutBean = getBunsyoNo.execGetYakkanBunsyoNo(
                        retBean.getAisyoumeikbn(),
                        null,
                        oyadrtencd,
                        pMp.getDataSyoriControl().getMosKihon().getMosymd());

                    yakkanbunsyoNo = getBunsyoNoOutBean.getYakkanbunsyoNo();
                    sioriNo = getBunsyoNoOutBean.getSioriNo();

                }
            }
        }

        pMp.getDataSyoriControl().getMosKihon().setYakkanbunsyono(yakkanbunsyoNo);
        pMp.getDataSyoriControl().getMosKihon().setSiorino(sioriNo);

        if (logger.isDebugEnabled()) {

            logger.debug("｜ MP.申込基本TBL.約款文書番号 = " + pMp.getDataSyoriControl().getMosKihon().getYakkanbunsyono());

            logger.debug("｜ MP.申込基本TBL.しおり番号 = " + pMp.getDataSyoriControl().getMosKihon().getSiorino());

            logger.debug("△ 約款受領方法チェック 終了");
        }
    }

    private void hanteiSentakuYouhi(MosnaiCheckParam pMp, String pOyadrtencd) {

        BizDate mosYmd = pMp.getDataSyoriControl().getMosKihon().getMosymd();
        BizDate yakkandensiTratkiKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getZenchanelYakkandensiTratkiKaisiYmd();

        if (C_SkeijimuKbn.SMBC.eq(pMp.getDataSyoriControl().getSkeijimukbn())) {

            yakkandensiTratkiKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getSmbcYakkandensiTratkiKaisiYmd();
        }

        String kansaimiraiBank = YuyuSinkeiyakuConfig.getInstance().getKansaimiraibank();

        if (pOyadrtencd.equals(kansaimiraiBank)) {

            yakkandensiTratkiKaisiYmd = YuyuSinkeiyakuConfig.getInstance().getKnsimriYakkandensiTratkiKaisiYmd();
        }

        if (BizDateUtil.compareYmd(yakkandensiTratkiKaisiYmd, mosYmd) == BizDateUtil.COMPARE_EQUAL ||
            BizDateUtil.compareYmd(yakkandensiTratkiKaisiYmd, mosYmd) == BizDateUtil.COMPARE_LESSER) {

            yakkanJyuryouSentakuYouhiKbn = C_YouhiKbn.YOU;
        }
    }

    private void check(MosnaiCheckParam pMp) {

        C_YakkanJyuryouKbn yakkanjyuryouhoukbn = pMp.getDataSyoriControl().getMosKihon().getYakkanjyuryouhoukbn();

        if (C_YouhiKbn.YOU.eq(yakkanJyuryouSentakuYouhiKbn)) {

            if (C_YakkanJyuryouKbn.BLNK.eq(yakkanjyuryouhoukbn)) {
                String message = MakeHubiMsg.exec(MessageId.EBA0027, MessageId.EBA0027, ICommonKoumoku.DISP_N_YAKKANJYURYOUHOU);
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, message, pMp);
            }
        }
        else {
            if (!C_YakkanJyuryouKbn.BLNK.eq(yakkanjyuryouhoukbn)) {
                String message = MakeHubiMsg.exec(MessageId.EBC0012, MessageId.EBC0012, ICommonKoumoku.DISP_N_YAKKANJYURYOUHOU);
                setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, message, pMp);
            }
        }

    }
}
