package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_NenkinYoteiRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 年金開始後予定利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_NenkinYoteiRiritu extends AbstractExDBTable<BM_NenkinYoteiRiritu> {

    public GenQBM_NenkinYoteiRiritu() {
        this("BM_NenkinYoteiRiritu");
    }

    public GenQBM_NenkinYoteiRiritu(String pAlias) {
        super("BM_NenkinYoteiRiritu", BM_NenkinYoteiRiritu.class, pAlias);
    }

    public String BM_NenkinYoteiRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_NenkinYoteiRiritu, String> nenkinsyu = new ExDBFieldString<>("nenkinsyu", this);

    public final ExDBFieldString<BM_NenkinYoteiRiritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_NenkinYoteiRiritu, BizDate> kykfromymd = new ExDBFieldString<>("kykfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_NenkinYoteiRiritu, BizDate> kyktoymd = new ExDBFieldString<>("kyktoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_NenkinYoteiRiritu, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);
}
