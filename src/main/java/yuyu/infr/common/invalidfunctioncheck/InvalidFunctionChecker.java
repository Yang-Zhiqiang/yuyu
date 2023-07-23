package yuyu.infr.common.invalidfunctioncheck;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.web.filter.RequestLogFilter.RequestLogProps;
import jp.co.slcs.swak.web.filter.RequestLogFilter.RequestResultCode;
import yuyu.def.classification.C_YuukouKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_KinouMode;

/**
 * 機能有効チェッククラス<br />
 * 機能モード期間テーブルの有効区分　および　有効開始日を参照し、<br />
 * 実行中機能が有効であるかをチェックします。<br />
 * バッチでの有効無効チェック追加に伴い、クラスを分離<br />
 */
public class InvalidFunctionChecker {

    private InvalidFunctionChecker() {
        super();
    }

    public static boolean isValid(AS_Kinou kinou, AS_KinouMode kinouModeTable) {

        if (C_YuukouKbn.DISABLE.equals(kinouModeTable.getYuukouKbn())) {
            return false;
        } else if (C_YuukouKbn.BYDATE.equals(kinouModeTable.getYuukouKbn())) {
            BizDate yuukouKaisiYmd = kinouModeTable.getYuukouKaisiYmd();
            if (yuukouKaisiYmd != null) {
                if (yuukouKaisiYmd.compareTo(BizDate.getSysDate()) > 0) {
                    return false;
                }
            } else {
                RequestLogProps props = SWAKInjector.getInstance(RequestLogProps.class);
                props.setResultCode(RequestResultCode.LogicException);
                props.setForwardName("Exception:InvalidFunctionException");
                throw new RuntimeException("機能モードテーブルのデータが不整合になっています。");
            }
        }
        return true;
    }
}
