package yuyu.common.sinkeiyaku.moschk;

import javax.inject.Inject;

import org.slf4j.Logger;

import yuyu.def.classification.C_NyuukinjyoutaiKbn;
import yuyu.def.db.entity.HT_SyoriCTL;

/**
 * 新契約 申込内容チェック 入金TBL・返金TBLチェック
 */
public class CheckTblNyuukinHenkin {

    @Inject
    private static Logger logger;

    public CheckTblNyuukinHenkin() {
        super();
    }

    public void exec(MosnaiCheckParam pMP) {

        logger.debug("▽ 入金TBL・返金TBLチェック 開始");

        HT_SyoriCTL syoriCTL = pMP.getDataSyoriControl();

        syoriCTL.setNyuukinjoutaikbn(C_NyuukinjyoutaiKbn.NYUUKINCHKMIRYOU);

        logger.debug("△ 入金TBL・返金TBLチェック 終了");
    }

}
