package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_SynypTukiYkgtIkouHozon;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;

/**
 * 収入Ｐ統計翌月以降保存テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQST_SynypTukiYkgtIkouHozon extends AbstractExDBTable<ST_SynypTukiYkgtIkouHozon> {

    public GenQST_SynypTukiYkgtIkouHozon() {
        this("ST_SynypTukiYkgtIkouHozon");
    }

    public GenQST_SynypTukiYkgtIkouHozon(String pAlias) {
        super("ST_SynypTukiYkgtIkouHozon", ST_SynypTukiYkgtIkouHozon.class, pAlias);
    }

    public String ST_SynypTukiYkgtIkouHozon() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, String> srkijyunym = new ExDBFieldString<>("srkijyunym", this);

    public final ExDBFieldNumber<ST_SynypTukiYkgtIkouHozon, Integer> sequenceno = new ExDBFieldNumber<>("sequenceno", this);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, BizDateYM> jyutoustartym = new ExDBFieldString<>("jyutoustartym", this, BizDateYMType.class);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, BizDateYM> jyutouendym = new ExDBFieldString<>("jyutouendym", this, BizDateYMType.class);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, C_TaisyakuKbn> taisyakukbn = new ExDBFieldString<>("taisyakukbn", this, UserType_C_TaisyakuKbn.class);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, BizDate> denymd = new ExDBFieldString<>("denymd", this, BizDateType.class);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, String> syoricd = new ExDBFieldString<>("syoricd", this);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldNumber<ST_SynypTukiYkgtIkouHozon, Long> zennoujiikkatubaraijytgk = new ExDBFieldNumber<>("zennoujiikkatubaraijytgk", this);

    public final ExDBFieldString<ST_SynypTukiYkgtIkouHozon, String> denrenno = new ExDBFieldString<>("denrenno", this);
}
