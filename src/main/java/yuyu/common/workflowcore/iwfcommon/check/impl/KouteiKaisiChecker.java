package yuyu.common.workflowcore.iwfcommon.check.impl;

import yuyu.common.workflowcore.iwfcommon.check.Checker;

/**
 * 工程開始可否チェッカーです。
 */
public class KouteiKaisiChecker implements Checker<String>{

    private static final KouteiKaisiChecker INSTANCE = new KouteiKaisiChecker();

    private KouteiKaisiChecker(){
    }

    public static KouteiKaisiChecker getInstance(){
        return INSTANCE;
    }

    @Override
    public Boolean check(String...torikomiSyoruiCd) {

        return false;
    }
}
