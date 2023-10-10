package yuyu.app.base.system.kinouteigitouroku;

import yuyu.def.db.entity.AS_KinouMode;

import com.google.common.base.Function;

/**
 * 機能モード情報単純ソート処理用クラス
 */
public class KinouModeInfoSortFunction implements Function<AS_KinouMode, Integer>{

    @Override
    public Integer apply(AS_KinouMode pKinouMode) {
        return pKinouMode.getSortNo();
    }

}
