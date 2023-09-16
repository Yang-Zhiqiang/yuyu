package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Seibetu;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_HsykkntkSysnNkGnsritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Seibetu;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 保証期間付終身年金原資率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_HsykkntkSysnNkGnsritu extends AbstractExDBTable<BM_HsykkntkSysnNkGnsritu> {

    public GenQBM_HsykkntkSysnNkGnsritu() {
        this("BM_HsykkntkSysnNkGnsritu");
    }

    public GenQBM_HsykkntkSysnNkGnsritu(String pAlias) {
        super("BM_HsykkntkSysnNkGnsritu", BM_HsykkntkSysnNkGnsritu.class, pAlias);
    }

    public String BM_HsykkntkSysnNkGnsritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_HsykkntkSysnNkGnsritu, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BM_HsykkntkSysnNkGnsritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_HsykkntkSysnNkGnsritu, C_Seibetu> seibetu = new ExDBFieldString<>("seibetu", this, UserType_C_Seibetu.class);

    public final ExDBFieldNumber<BM_HsykkntkSysnNkGnsritu, Integer> nkshrstartnen = new ExDBFieldNumber<>("nkshrstartnen", this);

    public final ExDBFieldNumber<BM_HsykkntkSysnNkGnsritu, Integer> hsykkn = new ExDBFieldNumber<>("hsykkn", this);

    public final ExDBFieldString<BM_HsykkntkSysnNkGnsritu, BizNumber> nkgnsritu = new ExDBFieldString<>("nkgnsritu", this, BizNumberType.class);
}
