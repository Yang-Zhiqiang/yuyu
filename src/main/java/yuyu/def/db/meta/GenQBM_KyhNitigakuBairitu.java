package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_KyhNitigakuBairitu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_KataKbn;

/**
 * 給付日額倍率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KyhNitigakuBairitu extends AbstractExDBTable<BM_KyhNitigakuBairitu> {

    public GenQBM_KyhNitigakuBairitu() {
        this("BM_KyhNitigakuBairitu");
    }

    public GenQBM_KyhNitigakuBairitu(String pAlias) {
        super("BM_KyhNitigakuBairitu", BM_KyhNitigakuBairitu.class, pAlias);
    }

    public String BM_KyhNitigakuBairitu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KyhNitigakuBairitu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_KyhNitigakuBairitu, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BM_KyhNitigakuBairitu, C_KataKbn> katakbn = new ExDBFieldString<>("katakbn", this, UserType_C_KataKbn.class);

    public final ExDBFieldString<BM_KyhNitigakuBairitu, BizNumber> kyhngbairitu = new ExDBFieldString<>("kyhngbairitu", this, BizNumberType.class);
}
