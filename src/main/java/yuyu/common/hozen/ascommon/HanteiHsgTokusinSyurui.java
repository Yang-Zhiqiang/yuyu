package yuyu.common.hozen.ascommon;

import java.util.List;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.def.classification.C_HsigiTkbtTaiouSyuruiKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.hozen.configuration.HsigiTksnTeigiBean;
import yuyu.def.hozen.configuration.YuyuHozenConfig;

/**
 * 契約保全 案内収納共通 被災害特伸種類判定
 */
public class HanteiHsgTokusinSyurui {

    @Inject
    private static Logger logger;

    public HsigiTksnInfoBean exec(BizDate pHsgymd) {

        logger.debug("▽ 被災害特伸種類判定 開始");

        HsigiTksnInfoBean hsigiTksnInfoBean = null;

        List<HsigiTksnTeigiBean> hsigiTksnTeigiBeanList = YuyuHozenConfig.getInstance().getHsigiTksnTeigiBeanList();

        for (HsigiTksnTeigiBean hsigiTksnTeigiBean : hsigiTksnTeigiBeanList) {

            if (BizDateUtil.compareYmd(hsigiTksnTeigiBean.getHsgymd(), pHsgymd) == BizDateUtil.COMPARE_EQUAL) {

                hsigiTksnInfoBean = SWAKInjector.getInstance(HsigiTksnInfoBean.class);

                hsigiTksnInfoBean.setHsigiTkbtTaiouSyurui(hsigiTksnTeigiBean.getHsigitkbttaiousyurui());
                hsigiTksnInfoBean.setKoujyoSyoumeiTkbtTaiouUmu(hsigiTksnTeigiBean.getKoujyosyoumeitkbttaiouumu());
                hsigiTksnInfoBean.setBnktAnnaiKaisiYmd(hsigiTksnTeigiBean.getBnktannaikaisiymd());
                hsigiTksnInfoBean.setBnktAnnaiEndYmd(hsigiTksnTeigiBean.getBnktannaiendymd());

                break;
            }
        }

        if (hsigiTksnInfoBean == null) {

            hsigiTksnInfoBean = SWAKInjector.getInstance(HsigiTksnInfoBean.class);

            hsigiTksnInfoBean.setHsigiTkbtTaiouSyurui(C_HsigiTkbtTaiouSyuruiKbn.BLNK);
            hsigiTksnInfoBean.setKoujyoSyoumeiTkbtTaiouUmu(C_UmuKbn.NONE);
            hsigiTksnInfoBean.setBnktAnnaiKaisiYmd(null);
            hsigiTksnInfoBean.setBnktAnnaiEndYmd(null);
        }

        logger.debug("△ 被災害特伸種類判定 終了");

        return hsigiTksnInfoBean;
    }
}
