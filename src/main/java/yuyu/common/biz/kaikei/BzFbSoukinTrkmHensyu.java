package yuyu.common.biz.kaikei;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizPropertyInitializer;
import yuyu.common.biz.bzcommon.FBSoukinDataParam;
import yuyu.def.classification.C_FbSoukinBatchKbn;
import yuyu.def.db.entity.BT_FBSoukinData;

/**
 * 業務共通 経理・会計 ＦＢ送金データ取込編集クラス
 */
public class BzFbSoukinTrkmHensyu {

    @Inject
    private static Logger logger;

    public BzFbSoukinTrkmHensyu() {
        super();
    }

    public BT_FBSoukinData exec(FBSoukinDataParam pFbSoukinDataParam, C_FbSoukinBatchKbn pFbSoukinBatchKbn) {

        logger.debug("▽ ＦＢ送金データ取込編集 開始");

        BT_FBSoukinData fBSoukinData = new BT_FBSoukinData();

        fBSoukinData.setFbsoukindatasikibetukey(pFbSoukinDataParam.getFbsoukindatasikibetukey());
        fBSoukinData.setDenrenno(pFbSoukinDataParam.getDenrenno());
        fBSoukinData.setEdano(pFbSoukinDataParam.getEdano());
        fBSoukinData.setDensyskbn(pFbSoukinDataParam.getDensyskbn());
        fBSoukinData.setGyoumucd(pFbSoukinDataParam.getGyoumucd());
        fBSoukinData.setSyoricd(pFbSoukinDataParam.getSyoricd());
        fBSoukinData.setSyorisosikicd(pFbSoukinDataParam.getSyorisosikicd());
        fBSoukinData.setSyoriYmd(pFbSoukinDataParam.getSyoriYmd());
        fBSoukinData.setDenymd(pFbSoukinDataParam.getDenymd());
        fBSoukinData.setKeirisyono(pFbSoukinDataParam.getSyono());
        fBSoukinData.setShrhousiteikbn(pFbSoukinDataParam.getShrhousiteikbn());
        fBSoukinData.setBankcd(pFbSoukinDataParam.getBankcd());
        fBSoukinData.setSitencd(pFbSoukinDataParam.getSitencd());
        fBSoukinData.setYokinkbn(pFbSoukinDataParam.getYokinkbn());
        fBSoukinData.setKouzano(pFbSoukinDataParam.getKouzano());
        fBSoukinData.setKzmeiginmkn(pFbSoukinDataParam.getKzmeiginmkn());
        fBSoukinData.setSoukingk(pFbSoukinDataParam.getSoukingk());
        fBSoukinData.setKyktuukasyu(pFbSoukinDataParam.getKyktuukasyu());
        fBSoukinData.setGaikataikagk(pFbSoukinDataParam.getGaikataikagk());
        fBSoukinData.setSoukinkwsrate(pFbSoukinDataParam.getSoukinkwsrate());
        fBSoukinData.setFbsoukinbatchkbn(pFbSoukinBatchKbn);

        BizPropertyInitializer.initialize(fBSoukinData);

        logger.debug("△ ＦＢ送金データ取込編集 終了");

        return fBSoukinData;
    }
}
