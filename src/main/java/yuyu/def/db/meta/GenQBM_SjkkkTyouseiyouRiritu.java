package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_HhknNenKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_SjkkkTyouseiyouRiritu;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_HhknNenKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 市場価格調整用利率マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SjkkkTyouseiyouRiritu extends AbstractExDBTable<BM_SjkkkTyouseiyouRiritu> {

    public GenQBM_SjkkkTyouseiyouRiritu() {
        this("BM_SjkkkTyouseiyouRiritu");
    }

    public GenQBM_SjkkkTyouseiyouRiritu(String pAlias) {
        super("BM_SjkkkTyouseiyouRiritu", BM_SjkkkTyouseiyouRiritu.class, pAlias);
    }

    public String BM_SjkkkTyouseiyouRiritu() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu, C_HhknNenKbn> hhknnenkbn = new ExDBFieldString<>("hhknnenkbn", this, UserType_C_HhknNenKbn.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu, BizDate> kykfromymd = new ExDBFieldString<>("kykfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu, BizDate> kyktoymd = new ExDBFieldString<>("kyktoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SjkkkTyouseiyouRiritu, BizNumber> sjkkktyouseiyouriritu = new ExDBFieldString<>("sjkkktyouseiyouriritu", this, BizNumberType.class);
}
