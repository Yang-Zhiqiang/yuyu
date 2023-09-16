package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.BM_HaitouRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 配当利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_HaitouRiritu extends AbstractExDBTable<BM_HaitouRiritu> {

    public GenQBM_HaitouRiritu() {
        this("BM_HaitouRiritu");
    }

    public GenQBM_HaitouRiritu(String pAlias) {
        super("BM_HaitouRiritu", BM_HaitouRiritu.class, pAlias);
    }

    public String BM_HaitouRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_HaitouRiritu, BizDate> kijyunfromymd = new ExDBFieldString<>("kijyunfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_HaitouRiritu, BizDate> kijyuntoymd = new ExDBFieldString<>("kijyuntoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_HaitouRiritu, BizNumber> haitouriritu = new ExDBFieldString<>("haitouriritu", this, BizNumberType.class);
}
