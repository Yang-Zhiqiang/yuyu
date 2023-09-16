package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_TienrisokuRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 遅延利息利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_TienrisokuRiritu extends AbstractExDBTable<BM_TienrisokuRiritu> {

    public GenQBM_TienrisokuRiritu() {
        this("BM_TienrisokuRiritu");
    }

    public GenQBM_TienrisokuRiritu(String pAlias) {
        super("BM_TienrisokuRiritu", BM_TienrisokuRiritu.class, pAlias);
    }

    public String BM_TienrisokuRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_TienrisokuRiritu, String> tekiyoukknfrom = new ExDBFieldString<>("tekiyoukknfrom", this);

    public final ExDBFieldString<BM_TienrisokuRiritu, String> tekiyoukknkto = new ExDBFieldString<>("tekiyoukknkto", this);

    public final ExDBFieldString<BM_TienrisokuRiritu, BizNumber> tienrisokuriritu = new ExDBFieldString<>("tienrisokuriritu", this, BizNumberType.class);
}
