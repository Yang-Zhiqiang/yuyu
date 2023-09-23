package yuyu.common.hozen.khcommon;

import com.google.common.base.Function;

/**
 * 契約商品共通パラメータリストソート用クラス
 */
public class SearchKykSyouhnCommonParamSortFunction implements Function<KykSyouhnCommonParam, String>{

    @Override
    public String apply(KykSyouhnCommonParam  pKykSyouhnCommonParam) {
        return pKykSyouhnCommonParam.getSyouhncd();
    }

}
