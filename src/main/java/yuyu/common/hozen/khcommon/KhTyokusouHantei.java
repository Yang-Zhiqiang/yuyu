package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.SetNenrei;
import yuyu.def.classification.C_TsindousiteiKbn;
import yuyu.def.classification.C_TyokusouhtkekKbn;

/**
 * 契約保全 契約保全共通 契約保全直送判定
 */
public class KhTyokusouHantei {

    @Inject
    private static Logger logger;

    public KhTyokusouHantei() {
        super();
    }

    public C_TyokusouhtkekKbn execTrkkzkTyokusouHantei(TrkkzkTyokusouhtBean pTrkkzkTyokusouhtBean) {
        logger.debug("▽ 登録家族直送判定 開始");

        C_TyokusouhtkekKbn tyokusouhtkekKbn = C_TyokusouhtkekKbn.BLNK;

        if (C_TsindousiteiKbn.BLNK.eq(pTrkkzkTyokusouhtBean.getTrkkzktsindousiteikbn())) {

            SetNenrei setNenrei = SWAKInjector.getInstance(SetNenrei.class);
            int kykNenrei = setNenrei.exec(pTrkkzkTyokusouhtBean.getKijyunymd(), pTrkkzkTyokusouhtBean.getKykseiymd());

            if (kykNenrei >= 70) {
                tyokusouhtkekKbn = C_TyokusouhtkekKbn.TYOKUSOUTSY;
            }
            else {
                tyokusouhtkekKbn = C_TyokusouhtkekKbn.TYOKUSOUTSYGAI;
            }
        }
        else {
            tyokusouhtkekKbn = C_TyokusouhtkekKbn.TYOKUSOUTSYGAI;
        }

        logger.debug("△ 登録家族直送判定 終了");

        return tyokusouhtkekKbn;
    }
}
