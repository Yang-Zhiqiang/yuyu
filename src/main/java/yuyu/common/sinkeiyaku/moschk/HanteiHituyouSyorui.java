package yuyu.common.sinkeiyaku.moschk;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BzGetImageProps;
import yuyu.common.biz.bzcommon.BzGetImagePropsBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsInBean;
import yuyu.common.biz.bzcommon.BzGetImagePropsOutBean;
import yuyu.common.sinkeiyaku.koutei.SkHituyousyoruiHantei;
import yuyu.def.MessageId;
import yuyu.def.classification.C_HubisyubetusyousaiKbn;
import yuyu.def.classification.C_KetsrhkosKbn;
import yuyu.def.classification.C_MsgKbn;
import yuyu.def.classification.C_SpKeisanKahiKbn;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.classification.C_TknKbn;
import yuyu.def.db.entity.BT_GyoumuKouteiInfo;
import yuyu.def.db.entity.BT_HituyouSyoruiKanri;
import yuyu.def.sinkeiyaku.configuration.YuyuSinkeiyakuConfig;

/**
 * 新契約 申込内容チェック 必要書類判定
 */
public class HanteiHituyouSyorui {

    @Inject
    private static Logger logger;

    @Inject
    private SetHubiMsg setHubiMsg;

    public HanteiHituyouSyorui() {
        super();
    }

    public void exec(MosnaiCheckParam pMp) {

        if (logger.isDebugEnabled()) {
            logger.debug("▽ 必要書類判定 開始");
        }

        SkHituyousyoruiHantei skHituyousyoruiHantei = SWAKInjector.getInstance(SkHituyousyoruiHantei.class);
        skHituyousyoruiHantei.exec(pMp);

        List<BT_HituyouSyoruiKanri> hituyouSyoruiKanriList = pMp.getGyoumuKouteiInfo().getHituyouSyoruiKanris();
        BT_GyoumuKouteiInfo gyoumuKouteiInfo = pMp.getGyoumuKouteiInfo();

        BzGetImageProps getImageProps = SWAKInjector.getInstance(BzGetImageProps.class);
        BzGetImagePropsInBean bzGetImagePropsInBean = SWAKInjector.getInstance(BzGetImagePropsInBean.class);
        List<String> torikomiSyoruiList = new ArrayList<String>();

        bzGetImagePropsInBean.setJimuTetuzukiCd(gyoumuKouteiInfo.getJimutetuzukicd());
        bzGetImagePropsInBean.setKouteiKanriId(gyoumuKouteiInfo.getKouteikanriid());

        List<String> huyousyoruiValueList = skHituyousyoruiHantei.getHuyousyoruiValueList();

        BzGetImagePropsOutBean bzGetImagePropsOutBean = getImageProps.exec(bzGetImagePropsInBean);

        if ("0".equals(bzGetImagePropsOutBean.getKekkaStatus())) {

            List<BzGetImagePropsBean> bzGetImagePropsBeanLst = bzGetImagePropsOutBean.getBzGetImagePropsBeanLst();

            for (BzGetImagePropsBean bzGetImagePropsBean : bzGetImagePropsBeanLst) {

                torikomiSyoruiList.add(bzGetImagePropsBean.getSyoruiCd().getValue());
            }
        }

        List<String> daisansyauktKnrnSyoruiList = new ArrayList<String>();

        daisansyauktKnrnSyoruiList = YuyuSinkeiyakuConfig.getInstance().getDaisansyauktKnrnSyoruiList();

        if (hituyouSyoruiKanriList.size() > 0) {

            for (BT_HituyouSyoruiKanri hituyouSyoruiKanri : hituyouSyoruiKanriList) {

                if (!torikomiSyoruiList.contains(hituyouSyoruiKanri.getSyoruiCd().getValue())) {

                    if (daisansyauktKnrnSyoruiList.contains(hituyouSyoruiKanri.getSyoruiCd().getValue())) {

                        String msg = MessageId.WHC0069 + " " + MessageUtil.getMessage(MessageId.WHC0069,
                            hituyouSyoruiKanri.getSyoruiCd().getContent());

                        setHubiMsg.exec(C_KetsrhkosKbn.WARNING, hituyouSyoruiKanri.getSyoruiCd(), msg, pMp,
                            C_TknKbn.NONE, C_MsgKbn.WARNING);
                    }
                    else {

                        String msg = MessageId.EHA0530 + " " + MessageUtil.getMessage(MessageId.EHA0530,
                            hituyouSyoruiKanri.getSyoruiCd().getContent());

                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, hituyouSyoruiKanri.getSyoruiCd(), msg, pMp,
                            C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }
                }
            }
        }

        if (huyousyoruiValueList.size() > 0) {

            for (int i = 0; i < huyousyoruiValueList.size(); i++) {
                if (torikomiSyoruiList.contains(huyousyoruiValueList.get(i))) {
                    if (C_SyoruiCdKbn.SK_SEIMEIPKZHURIKAEMOSSYO.getValue().equals(huyousyoruiValueList.get(i))) {

                        String msg = MessageId.EHC1133 + " " + MessageUtil.getMessage(MessageId.EHC1133);

                        setHubiMsg.exec(C_KetsrhkosKbn.SRHORYU_HUBI, C_SpKeisanKahiKbn.MISETTEI, C_HubisyubetusyousaiKbn.NONE,
                            C_SyoruiCdKbn.BLNK, msg, pMp,C_TknKbn.NONE, C_MsgKbn.ERROR);
                    }

                    break;
                }
            }
        }

        if (logger.isDebugEnabled()) {
            logger.debug("△ 必要書類判定 終了");
        }
    }
}