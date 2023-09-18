package yuyu.common.workflowcore.iwfcommon.check;

import yuyu.common.workflowcore.iwfcommon.check.impl.CanCreateNewTokenChecker;
import yuyu.common.workflowcore.iwfcommon.check.impl.CanCreateNewTokenCheckerInBean;
import yuyu.common.workflowcore.iwfcommon.check.impl.KouteiKaisiChecker;

/**
 * チェックユーティリティです。
 */
public class Checks{

    public static boolean checkCanKouteikaisiByTorikomisyoruiCd(String psTorikomisyoruicd){
        return KouteiKaisiChecker.getInstance().check(psTorikomisyoruicd);
    }

    public static boolean checkCanCreateNewToken(CanCreateNewTokenCheckerInBean poInBean){
        return CanCreateNewTokenChecker.getInstance().check(poInBean);
    }
}
