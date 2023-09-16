package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KktNkGnsritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 確定年金原資率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KktNkGnsritu extends AbstractExDBTable<BM_KktNkGnsritu> {

    public GenQBM_KktNkGnsritu() {
        this("BM_KktNkGnsritu");
    }

    public GenQBM_KktNkGnsritu(String pAlias) {
        super("BM_KktNkGnsritu", BM_KktNkGnsritu.class, pAlias);
    }

    public String BM_KktNkGnsritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KktNkGnsritu, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BM_KktNkGnsritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<BM_KktNkGnsritu, Integer> shrkkn = new ExDBFieldNumber<>("shrkkn", this);

    public final ExDBFieldString<BM_KktNkGnsritu, BizNumber> nkgnsritu = new ExDBFieldString<>("nkgnsritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_KktNkGnsritu, BizNumber> nkgnsritu2 = new ExDBFieldString<>("nkgnsritu2", this, BizNumberType.class);
}
