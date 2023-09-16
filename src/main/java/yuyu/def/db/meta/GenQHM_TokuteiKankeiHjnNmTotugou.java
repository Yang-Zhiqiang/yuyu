package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.HM_TokuteiKankeiHjnNmTotugou;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 特定関係法人名突合マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_TokuteiKankeiHjnNmTotugou extends AbstractExDBTable<HM_TokuteiKankeiHjnNmTotugou> {

    public GenQHM_TokuteiKankeiHjnNmTotugou() {
        this("HM_TokuteiKankeiHjnNmTotugou");
    }

    public GenQHM_TokuteiKankeiHjnNmTotugou(String pAlias) {
        super("HM_TokuteiKankeiHjnNmTotugou", HM_TokuteiKankeiHjnNmTotugou.class, pAlias);
    }

    public String HM_TokuteiKankeiHjnNmTotugou() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_TokuteiKankeiHjnNmTotugou, String> tkhjnkinyuucd = new ExDBFieldString<>("tkhjnkinyuucd", this);

    public final ExDBFieldString<HM_TokuteiKankeiHjnNmTotugou, BizNumber> meisaino = new ExDBFieldString<>("meisaino", this, BizNumberType.class);

    public final ExDBFieldNumber<HM_TokuteiKankeiHjnNmTotugou, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HM_TokuteiKankeiHjnNmTotugou, String> totugoutkhjnnmkj = new ExDBFieldString<>("totugoutkhjnnmkj", this);
}
