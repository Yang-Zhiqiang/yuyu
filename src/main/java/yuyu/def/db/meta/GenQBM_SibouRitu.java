package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.db.entity.BM_SibouRitu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Seibetu;

/**
 * 死亡率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SibouRitu extends AbstractExDBTable<BM_SibouRitu> {

    public GenQBM_SibouRitu() {
        this("BM_SibouRitu");
    }

    public GenQBM_SibouRitu(String pAlias) {
        super("BM_SibouRitu", BM_SibouRitu.class, pAlias);
    }

    public String BM_SibouRitu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SibouRitu, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BM_SibouRitu, C_Seibetu> seibetu = new ExDBFieldString<>("seibetu", this, UserType_C_Seibetu.class);

    public final ExDBFieldNumber<BM_SibouRitu, Integer> nenrei = new ExDBFieldNumber<>("nenrei", this);

    public final ExDBFieldString<BM_SibouRitu, BizNumber> sibouritu1 = new ExDBFieldString<>("sibouritu1", this, BizNumberType.class);

    public final ExDBFieldString<BM_SibouRitu, BizNumber> sibouritu2 = new ExDBFieldString<>("sibouritu2", this, BizNumberType.class);

    public final ExDBFieldString<BM_SibouRitu, BizNumber> kaiyakuritu1 = new ExDBFieldString<>("kaiyakuritu1", this, BizNumberType.class);
}
