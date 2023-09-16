package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KktNk1stNkBigkGnsritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 確定年金（第１回年金倍額型）原資率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KktNk1stNkBigkGnsritu extends AbstractExDBTable<BM_KktNk1stNkBigkGnsritu> {

    public GenQBM_KktNk1stNkBigkGnsritu() {
        this("BM_KktNk1stNkBigkGnsritu");
    }

    public GenQBM_KktNk1stNkBigkGnsritu(String pAlias) {
        super("BM_KktNk1stNkBigkGnsritu", BM_KktNk1stNkBigkGnsritu.class, pAlias);
    }

    public String BM_KktNk1stNkBigkGnsritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KktNk1stNkBigkGnsritu, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldString<BM_KktNk1stNkBigkGnsritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldNumber<BM_KktNk1stNkBigkGnsritu, Integer> shrkkn = new ExDBFieldNumber<>("shrkkn", this);

    public final ExDBFieldString<BM_KktNk1stNkBigkGnsritu, BizNumber> nkgnsritu = new ExDBFieldString<>("nkgnsritu", this, BizNumberType.class);
}
