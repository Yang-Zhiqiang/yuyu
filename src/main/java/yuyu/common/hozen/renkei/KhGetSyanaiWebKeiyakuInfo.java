package yuyu.common.hozen.renkei;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import lombok.Getter;

import org.slf4j.Logger;

import yuyu.common.sinkeiyaku.skcommon.SyouhinUtil;
import yuyu.def.biz.bean.webservice.IwssnSyanaiHozenInfoOutputBean;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSyouhn;
import yuyu.def.hozen.manager.HozenDomManager;

/**
 * 契約保全 サブシステム連携 社内Web用保全契約内容情報取得<br />
 */
public class KhGetSyanaiWebKeiyakuInfo {

    @Getter
    private IwssnSyanaiHozenInfoOutputBean iwssnSyanaiHozenInfoOutputBean;

    @Inject
    private static Logger logger;

    @Inject
    private HozenDomManager hozenDomManager;

    public C_IwssnKykSyoukaiKekkaKbn exec(String pSyono) {

        logger.debug("▽ 社内Web用保全契約内容情報取得を開始します。");
        C_IwssnKykSyoukaiKekkaKbn syorikekkaKbn = C_IwssnKykSyoukaiKekkaKbn.NORMAL;
        iwssnSyanaiHozenInfoOutputBean = SWAKInjector.getInstance(IwssnSyanaiHozenInfoOutputBean.class);

        iwssnSyanaiHozenInfoOutputBean.setIwssnSyono(pSyono);

        IT_KykKihon kykKihon = hozenDomManager.getKykKihon(pSyono);

        if (kykKihon == null) {

            syorikekkaKbn = C_IwssnKykSyoukaiKekkaKbn.GAITOUKEIYAKUNASI_ERROR;
            logger.info("△ 社内Web用保全契約内容情報取得を終了します｡");
            return syorikekkaKbn;
        }

        IT_KykSyouhn kykSyouhn = kykKihon.getKykSyouhnsBySyutkkbn(C_SyutkKbn.SYU).get(0);

        iwssnSyanaiHozenInfoOutputBean.setIwssnSyouhncd(kykSyouhn.getSyouhncd());

        int syouhinhanteiKbn = SyouhinUtil.hantei(kykSyouhn.getSyouhncd());

        KhGetSyanaiWebKyoutuuInfo khGetSyanaiWebKyoutuuInfo = null;

        switch(syouhinhanteiKbn) {
            case SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR :
            case SyouhinUtil.GONENRISAHAITOUSITEITUUKASYUUSIN_ITIJIBR_19 :
                khGetSyanaiWebKyoutuuInfo = SWAKInjector.getInstance(KhGetSyanaiWebItijiSyuusinInfo.class);
                break;
            case SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR:
            case SyouhinUtil.GONENRISAHAITOU_SITEITUUKA_NENKIN_ITIJIBR_20:
                khGetSyanaiWebKyoutuuInfo = SWAKInjector.getInstance(KhGetSyanaiWebItijiNenkinInfo.class);
                break;
            case SyouhinUtil.YOTEIRIRITUHENDOU_GONENRISAHAITOU_SITEITUUKA_NENKIN :
                khGetSyanaiWebKyoutuuInfo = SWAKInjector.getInstance(KhGetSyanaiWebHeijyunNenkinInfo.class);
                break;
            case SyouhinUtil.TEIKAIYAKUHRKN_GONENRISAHAITOU_SNTKTUUKA_TKBTSYUUSINHKN :
                khGetSyanaiWebKyoutuuInfo = SWAKInjector.getInstance(KhGetSyanaiWebHeijyunSyuusinInfo.class);
                break;
            default:
                syorikekkaKbn = C_IwssnKykSyoukaiKekkaKbn.SOUGOUSYOUKAI_MITAIOUSYOUHN;
                logger.info("△ 社内Web用保全契約内容情報取得を終了します｡");
                return syorikekkaKbn;
        }

        try {
            syorikekkaKbn = khGetSyanaiWebKyoutuuInfo.exec(iwssnSyanaiHozenInfoOutputBean);
            iwssnSyanaiHozenInfoOutputBean = khGetSyanaiWebKyoutuuInfo.getIwssnSyanaiHozenInfoOutputBean();

        } catch (Exception e) {

            syorikekkaKbn = C_IwssnKykSyoukaiKekkaKbn.EXCEPTION;
        }

        logger.debug("△ 社内Web用保全契約内容情報取得を終了します｡");
        return syorikekkaKbn;
    }
}