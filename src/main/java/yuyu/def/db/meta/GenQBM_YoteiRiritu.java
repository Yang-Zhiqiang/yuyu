package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HhknNenKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 予定利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_YoteiRiritu extends AbstractExDBTable<BM_YoteiRiritu> {

    public GenQBM_YoteiRiritu() {
        this("BM_YoteiRiritu");
    }

    public GenQBM_YoteiRiritu(String pAlias) {
        super("BM_YoteiRiritu", BM_YoteiRiritu.class, pAlias);
    }

    public String BM_YoteiRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_YoteiRiritu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_YoteiRiritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_YoteiRiritu, C_HhknNenKbn> hhknnenkbn = new ExDBFieldString<>("hhknnenkbn", this, UserType_C_HhknNenKbn.class);

    public final ExDBFieldString<BM_YoteiRiritu, BizDate> kykfromymd = new ExDBFieldString<>("kykfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_YoteiRiritu, BizDate> kyktoymd = new ExDBFieldString<>("kyktoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_YoteiRiritu, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);
}
