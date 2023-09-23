package yuyu.common.hozen.khcommon.dba4keisankoujyogaku;

import com.google.common.base.Function;

/**
 * 控除証明内容View（入金実績履歴TBLと結合）情報取得Beanリストソート用クラス
 */
public class KoujyoSymNaiyouNyknJissekiRirekisBeanSortFunction implements Function<KoujyoSymNaiyouNyknJissekiRirekisBean, Integer>{

    @Override
    public Integer apply(KoujyoSymNaiyouNyknJissekiRirekisBean  pBean) {
        return pBean.getSyoumeistartym().intValue();
    }

}
