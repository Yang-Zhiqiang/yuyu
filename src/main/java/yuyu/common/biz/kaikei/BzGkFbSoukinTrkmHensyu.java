package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.GkFBSoukinDataParam;
import yuyu.def.db.entity.BT_GkFBSoukinData;

/**
 * 業務共通 経理・会計 外貨ＦＢ送金データ取込編集クラス
 */
public class BzGkFbSoukinTrkmHensyu {

    @Inject
    private static Logger logger;

    public BzGkFbSoukinTrkmHensyu() {
        super();
    }

    public BT_GkFBSoukinData exec(GkFBSoukinDataParam pGkFBSoukinDataParam) {

        logger.debug("▽ 外貨ＦＢ送金データ取込編集 開始");

        BT_GkFBSoukinData gkFBSoukinData = new BT_GkFBSoukinData();

        gkFBSoukinData.setFbsoukindatasikibetukey(pGkFBSoukinDataParam.getFbsoukindatasikibetukey());
        gkFBSoukinData.setDenrenno(pGkFBSoukinDataParam.getDenrenno());
        gkFBSoukinData.setEdano(pGkFBSoukinDataParam.getEdano());
        gkFBSoukinData.setDensyskbn(pGkFBSoukinDataParam.getDensyskbn());
        gkFBSoukinData.setGkgyoumucd(pGkFBSoukinDataParam.getGkgyoumucd());
        gkFBSoukinData.setSyoricd(pGkFBSoukinDataParam.getSyoricd());
        gkFBSoukinData.setSyorisosikicd(pGkFBSoukinDataParam.getSyorisosikicd());
        gkFBSoukinData.setSyoriYmd(pGkFBSoukinDataParam.getSyoriYmd());
        gkFBSoukinData.setDenymd(pGkFBSoukinDataParam.getDenymd());
        gkFBSoukinData.setKeirisyono(pGkFBSoukinDataParam.getSyono());
        gkFBSoukinData.setShrhousiteikbn(pGkFBSoukinDataParam.getShrhousiteikbn());
        gkFBSoukinData.setBankcd(pGkFBSoukinDataParam.getBankcd());
        gkFBSoukinData.setBanknmej(pGkFBSoukinDataParam.getBanknmej());
        gkFBSoukinData.setSitencd(pGkFBSoukinDataParam.getSitencd());
        gkFBSoukinData.setSitennmej(pGkFBSoukinDataParam.getSitennmej());
        gkFBSoukinData.setKouzano(pGkFBSoukinDataParam.getKouzano());
        gkFBSoukinData.setKzmeiginmei(pGkFBSoukinDataParam.getKzmeiginmei());
        gkFBSoukinData.setShrtuukasyu(pGkFBSoukinDataParam.getShrtuukasyu());
        gkFBSoukinData.setGaikashrgk(pGkFBSoukinDataParam.getGaikashrgk());
        gkFBSoukinData.setKyktuukasyu(pGkFBSoukinDataParam.getKyktuukasyu());
        gkFBSoukinData.setCrossrateshrgk(pGkFBSoukinDataParam.getCrossrateshrgk());
        gkFBSoukinData.setSoukinkwsrate(pGkFBSoukinDataParam.getSoukinkwsrate());
        gkFBSoukinData.setIrninnmei(pGkFBSoukinDataParam.getIrninnmei());

        BizPropertyInitializer.initialize(gkFBSoukinData);

        logger.debug("△ 外貨ＦＢ送金データ取込編集 終了");

        return gkFBSoukinData;
    }
}
