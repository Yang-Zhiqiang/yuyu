package yuyu.batch.siharai.sisharaiks.simakeaksrendoufile;

import jp.co.slcs.swak.batch.annotation.BatchScoped;
import yuyu.common.biz.bzcommon.BzBatchParam;

/**
 * 保険金給付金支払 支払後検証 AKS連動ファイル作成バッチパラメータ
 */
@BatchScoped
public class SiMakeAKSRendouFileBatchParam extends BzBatchParam {

    private static final long serialVersionUID = 1L;

    public final String flieNmSiSyrImageInfoMae = "KQZRCB02Z";

    public final String flieNmSiSyrImageInfoGo = "00001";

    public final String flieNmSiSkKykInfoMae = "KQZRCB01Z";

    public final String flieNmSiSkKykInfoGo = "00001";

}
