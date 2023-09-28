package yuyu.common.biz.bznayose;

import com.google.common.base.Function;

/**
 * 別口契約情報単純ソート用クラス
 */
public class SearchBetukutiKeiyakuInfoSortFunction implements Function<BetukutiKeiyakuInfoBean, String>{

    @Override
    public String apply(BetukutiKeiyakuInfoBean  pBetukutiKeiyakuInfoBean) {
        return pBetukutiKeiyakuInfoBean.getBtkyksyono();
    }

}
