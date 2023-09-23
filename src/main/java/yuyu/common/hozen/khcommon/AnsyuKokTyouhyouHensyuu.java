package yuyu.common.hozen.khcommon;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.common.biz.bzcommon.BizUtil;
import yuyu.common.biz.exception.CommonBizAppException;
import yuyu.def.classification.C_AsTyouhyoukigouKbn;

/**
 * 契約保全 契約保全共通 案内収納用顧客帳票共通編集
 */
public class AnsyuKokTyouhyouHensyuu {

    private String sclatosyono;

    private String sakuseino;

    @Inject
    private static Logger logger;

    public void exec(String pSyono, String pRenno, C_AsTyouhyoukigouKbn pAsTyouhyoukigouKbn, String pHnskaRiyuu) {

        logger.debug("▽ 案内収納用顧客帳票共通編集 開始");

        sclatosyono = "";
        sakuseino = "";

        sclatosyono = pSyono.substring(3, 11).concat(pSyono.substring(0, 3));

        if (pAsTyouhyoukigouKbn == null || C_AsTyouhyoukigouKbn.BLNK.eq(pAsTyouhyoukigouKbn)) {

            throw new CommonBizAppException("帳票記号が設定できませんでした。証券番号：" + pSyono);
        }
        String renno = BizUtil.zeroNum(pRenno, 7, 0);

        sakuseino = renno + "-" + pAsTyouhyoukigouKbn.getValue() + "-" + pHnskaRiyuu;

        logger.debug("△ 案内収納用顧客帳票共通編集 終了");
    }

    public String getSclatoSyono() {

        return sclatosyono;
    }

    public String getSakuseino() {

        return sakuseino;
    }
}
