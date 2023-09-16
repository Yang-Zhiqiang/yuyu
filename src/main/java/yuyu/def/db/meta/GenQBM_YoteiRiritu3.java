package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_YoteiRiritu3;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 予定利率マスタ３ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_YoteiRiritu3 extends AbstractExDBTable<BM_YoteiRiritu3> {

    public GenQBM_YoteiRiritu3() {
        this("BM_YoteiRiritu3");
    }

    public GenQBM_YoteiRiritu3(String pAlias) {
        super("BM_YoteiRiritu3", BM_YoteiRiritu3.class, pAlias);
    }

    public String BM_YoteiRiritu3() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_YoteiRiritu3, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_YoteiRiritu3, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_YoteiRiritu3, String> yoteiriritutkybr1 = new ExDBFieldString<>("yoteiriritutkybr1", this);

    public final ExDBFieldString<BM_YoteiRiritu3, String> yoteiriritutkybr2 = new ExDBFieldString<>("yoteiriritutkybr2", this);

    public final ExDBFieldString<BM_YoteiRiritu3, BizDate> kijyunfromymd = new ExDBFieldString<>("kijyunfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizDate> kijyuntoymd = new ExDBFieldString<>("kijyuntoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizNumber> yoteiriritu = new ExDBFieldString<>("yoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizNumber> tumitateriritu = new ExDBFieldString<>("tumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizNumber> tmttknzoukaritujygn = new ExDBFieldString<>("tmttknzoukaritujygn", this, BizNumberType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizNumber> setteibairitu = new ExDBFieldString<>("setteibairitu", this, BizNumberType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizNumber> loadinghnkgtumitateriritu = new ExDBFieldString<>("loadinghnkgtumitateriritu", this, BizNumberType.class);

    public final ExDBFieldString<BM_YoteiRiritu3, BizNumber> rendouritu = new ExDBFieldString<>("rendouritu", this, BizNumberType.class);
}
