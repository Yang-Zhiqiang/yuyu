package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.db.entity.HT_KnksateiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_MrRiyuucdKbn;
import yuyu.def.db.type.UserType_C_SateiketsyorinmKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TorikesisyousairiyuuCd;

/**
 * 環境査定履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_KnksateiRireki extends AbstractExDBTable<HT_KnksateiRireki> {

    public GenQHT_KnksateiRireki() {
        this("HT_KnksateiRireki");
    }

    public GenQHT_KnksateiRireki(String pAlias) {
        super("HT_KnksateiRireki", HT_KnksateiRireki.class, pAlias);
    }

    public String HT_KnksateiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_KnksateiRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_KnksateiRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_KnksateiRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_SateiketsyorinmKbn> sateiketsyorinmkbn = new ExDBFieldString<>("sateiketsyorinmkbn", this, UserType_C_SateiketsyorinmKbn.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_SyorikekkaKbn> knksateikekkakbn = new ExDBFieldString<>("knksateikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<HT_KnksateiRireki, String> tnsketsyacd = new ExDBFieldString<>("tnsketsyacd", this);

    public final ExDBFieldString<HT_KnksateiRireki, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<HT_KnksateiRireki, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<HT_KnksateiRireki, String> knksateicomment = new ExDBFieldString<>("knksateicomment", this);

    public final ExDBFieldString<HT_KnksateiRireki, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_Ketriyuucd> ketriyuucd1 = new ExDBFieldString<>("ketriyuucd1", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_Ketriyuucd> ketriyuucd2 = new ExDBFieldString<>("ketriyuucd2", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_Ketriyuucd> ketriyuucd3 = new ExDBFieldString<>("ketriyuucd3", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_Ketriyuucd> ketriyuucd4 = new ExDBFieldString<>("ketriyuucd4", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_MrRiyuucdKbn> mrriyuucdkbn = new ExDBFieldString<>("mrriyuucdkbn", this, UserType_C_MrRiyuucdKbn.class);

    public final ExDBFieldString<HT_KnksateiRireki, C_TorikesisyousairiyuuCd> torikesisyousairiyuucd = new ExDBFieldString<>("torikesisyousairiyuucd", this, UserType_C_TorikesisyousairiyuuCd.class);

    public final ExDBFieldString<HT_KnksateiRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_KnksateiRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
