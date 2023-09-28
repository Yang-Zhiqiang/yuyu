package yuyu.common.biz.bznayose;

import javax.inject.Inject;

import jp.co.slcs.swak.sequence.RenbanUtil;

import org.slf4j.Logger;

import yuyu.def.classification.C_NosyuruiKbn;

/**
 * 業務共通 名寄せ 採番名寄せクラス
 */
public class BzSaibanNayose {

    private final int NOSYURUIKBN_YOUKYUUNO = Integer.valueOf(C_NosyuruiKbn.YOUKYUUNO.getValue());

    @Inject
    private static Logger logger;

    public BzSaibanNayose() {
        super();
    }

    public String exec() {

        logger.debug("▽ 採番名寄せ 開始");

        String youkyuuNo = RenbanUtil.getRenbanAsString(NOSYURUIKBN_YOUKYUUNO);

        logger.debug("△ 採番名寄せ 終了");

        return youkyuuNo;
    }
}
