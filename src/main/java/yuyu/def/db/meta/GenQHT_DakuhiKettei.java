package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_DakuhiktbunruiKbn;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_MrRiyuucdKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.classification.C_TkjysydksyhyKbn;
import yuyu.def.classification.C_TorikesisyousairiyuuCd;
import yuyu.def.db.entity.HT_DakuhiKettei;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_DakuhiktbunruiKbn;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_MrRiyuucdKbn;
import yuyu.def.db.type.UserType_C_SntkinfosakuseiyhKbn;
import yuyu.def.db.type.UserType_C_SyoubyoujyoutaiKbn;
import yuyu.def.db.type.UserType_C_TkjysydksyhyKbn;
import yuyu.def.db.type.UserType_C_TorikesisyousairiyuuCd;

/**
 * 諾否決定テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_DakuhiKettei extends AbstractExDBTable<HT_DakuhiKettei> {

    public GenQHT_DakuhiKettei() {
        this("HT_DakuhiKettei");
    }

    public GenQHT_DakuhiKettei(String pAlias) {
        super("HT_DakuhiKettei", HT_DakuhiKettei.class, pAlias);
    }

    public String HT_DakuhiKettei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_DakuhiKettei, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_DakuhiKettei, Integer> dakuhiktrenno = new ExDBFieldNumber<>("dakuhiktrenno", this);

    public final ExDBFieldString<HT_DakuhiKettei, BizDate> ketymd = new ExDBFieldString<>("ketymd", this, BizDateType.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_DakuhiktbunruiKbn> dakuhiktbunruikbn = new ExDBFieldString<>("dakuhiktbunruikbn", this, UserType_C_DakuhiktbunruiKbn.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_Ketriyuucd> ketriyuucd1 = new ExDBFieldString<>("ketriyuucd1", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_Ketriyuucd> ketriyuucd2 = new ExDBFieldString<>("ketriyuucd2", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_Ketriyuucd> ketriyuucd3 = new ExDBFieldString<>("ketriyuucd3", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_Ketriyuucd> ketriyuucd4 = new ExDBFieldString<>("ketriyuucd4", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_DakuhiKettei, String> syoubyoucd1 = new ExDBFieldString<>("syoubyoucd1", this);

    public final ExDBFieldString<HT_DakuhiKettei, C_SyoubyoujyoutaiKbn> syoubyoujyoutaikbn1 = new ExDBFieldString<>("syoubyoujyoutaikbn1", this, UserType_C_SyoubyoujyoutaiKbn.class);

    public final ExDBFieldString<HT_DakuhiKettei, BizDateYM> kantiym1 = new ExDBFieldString<>("kantiym1", this, BizDateYMType.class);

    public final ExDBFieldString<HT_DakuhiKettei, String> syoubyoucd2 = new ExDBFieldString<>("syoubyoucd2", this);

    public final ExDBFieldString<HT_DakuhiKettei, C_SyoubyoujyoutaiKbn> syoubyoujyoutaikbn2 = new ExDBFieldString<>("syoubyoujyoutaikbn2", this, UserType_C_SyoubyoujyoutaiKbn.class);

    public final ExDBFieldString<HT_DakuhiKettei, BizDateYM> kantiym2 = new ExDBFieldString<>("kantiym2", this, BizDateYMType.class);

    public final ExDBFieldString<HT_DakuhiKettei, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<HT_DakuhiKettei, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldNumber<HT_DakuhiKettei, Integer> tkjysydkno = new ExDBFieldNumber<>("tkjysydkno", this);

    public final ExDBFieldString<HT_DakuhiKettei, BizDate> tkjysydkymd = new ExDBFieldString<>("tkjysydkymd", this, BizDateType.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_TkjysydksyhyKbn> tkjysydksyhykbn = new ExDBFieldString<>("tkjysydksyhykbn", this, UserType_C_TkjysydksyhyKbn.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_SntkinfosakuseiyhKbn> sntkinfosakuseiyhkbn = new ExDBFieldString<>("sntkinfosakuseiyhkbn", this, UserType_C_SntkinfosakuseiyhKbn.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_MrRiyuucdKbn> mrriyuucdkbn = new ExDBFieldString<>("mrriyuucdkbn", this, UserType_C_MrRiyuucdKbn.class);

    public final ExDBFieldString<HT_DakuhiKettei, C_TorikesisyousairiyuuCd> torikesisyousairiyuucd = new ExDBFieldString<>("torikesisyousairiyuucd", this, UserType_C_TorikesisyousairiyuuCd.class);

    public final ExDBFieldString<HT_DakuhiKettei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_DakuhiKettei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
