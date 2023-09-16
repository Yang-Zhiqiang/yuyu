package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu2;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 市場価格調整用利率マスタ２ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SjkkkTyouseiyouRiritu2 extends AbstractExDBTable<BM_SjkkkTyouseiyouRiritu2> {

    public GenQBM_SjkkkTyouseiyouRiritu2() {
        this("BM_SjkkkTyouseiyouRiritu2");
    }

    public GenQBM_SjkkkTyouseiyouRiritu2(String pAlias) {
        super("BM_SjkkkTyouseiyouRiritu2", BM_SjkkkTyouseiyouRiritu2.class, pAlias);
    }

    public String BM_SjkkkTyouseiyouRiritu2() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, String> sjkkktyouseiriritutkybr1 = new ExDBFieldString<>("sjkkktyouseiriritutkybr1", this);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, String> sjkkktyouseiriritutkybr2 = new ExDBFieldString<>("sjkkktyouseiriritutkybr2", this);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, BizDate> kijyunfromymd = new ExDBFieldString<>("kijyunfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, BizDate> kijyuntoymd = new ExDBFieldString<>("kijyuntoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu2, BizNumber> sjkkktyouseiyouriritu = new ExDBFieldString<>("sjkkktyouseiyouriritu", this, BizNumberType.class);
}
