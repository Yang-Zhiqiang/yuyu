package yuyu.common.biz.bzcommon;

import javax.inject.Inject;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.number.BizNumber;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.dba4getsisuu.BizGetSisuuDao;
import yuyu.def.biz.manager.BizDomManager;
import yuyu.def.classification.C_ErrorKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.BM_Sisuu;

/**
 * 業務共通 業務共通 指数取得クラス
 */
public class GetSisuu {

    private BizNumber sisuu;

    private BizDate sisuushutokuymd;

    @Inject
    private static Logger logger;

    @Inject
    private BizGetSisuuDao bizGetSisuuDao;

    @Inject
    private BizDomManager bizDomManager;

    public GetSisuu() {
        super();
    }

    public C_ErrorKbn exec(C_Sisuukbn pSisuukbn, BizDate pSisuushutokuymd, C_YouhiKbn pYouhiKbn) {

        logger.debug("▽ 指数取得 開始");

        C_ErrorKbn errorKbn = C_ErrorKbn.OK;
        sisuu = BizNumber.valueOf(0);
        sisuushutokuymd = null;

        if (pSisuukbn == null) {

            errorKbn = C_ErrorKbn.ERROR;
        }

        if (pSisuushutokuymd == null) {

            errorKbn = C_ErrorKbn.ERROR;
        }
        if (C_ErrorKbn.ERROR.eq(errorKbn)) {

            logger.debug("△ 指数取得 終了");

            return errorKbn;
        }

        if (C_YouhiKbn.YOU.eq(pYouhiKbn)) {

            BM_Sisuu bM_Sisuu = bizGetSisuuDao.getSisuuPreviousByPK(pSisuukbn, pSisuushutokuymd);

            if (bM_Sisuu != null) {

                sisuushutokuymd = bM_Sisuu.getSisuukouhyouymd();

                sisuu = bM_Sisuu.getSisuu();
            } else {

                errorKbn = C_ErrorKbn.ERROR;
            }
        } else {

            BM_Sisuu bM_Sisuu = bizDomManager.getSisuu(pSisuukbn, pSisuushutokuymd);

            if (bM_Sisuu != null) {

                sisuushutokuymd = pSisuushutokuymd;

                sisuu = bM_Sisuu.getSisuu();

            } else {

                errorKbn = C_ErrorKbn.ERROR;
            }
        }

        logger.debug("△ 指数取得 終了");

        return errorKbn;
    }

    public BizNumber getSisuu() {

        return sisuu;
    }

    public BizDate getSisuushutokuymd() {

        return sisuushutokuymd;
    }
}