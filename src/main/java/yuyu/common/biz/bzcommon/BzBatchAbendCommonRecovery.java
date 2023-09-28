package yuyu.common.biz.bzcommon;

import jp.co.slcs.swak.core.inject.SWAKInjector;

/**
 * 業務共通  共通 バッチ異常終了時共通処理（リカバリ対応用）
 */
public class BzBatchAbendCommonRecovery {

    public BzBatchAbendCommonRecovery() {
        super();
    }

    public void exec() {

        BzSkipKeyTableKakunou bzSkipKeyTableKakunou = SWAKInjector.getInstance(BzSkipKeyTableKakunou.class);
        bzSkipKeyTableKakunou.exec();

    }

}