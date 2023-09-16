package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Ketkekkacd;
import yuyu.def.classification.C_Ketriyuucd;
import yuyu.def.classification.C_SateiketsyorinmKbn;
import yuyu.def.classification.C_SntkinfosakuseiyhKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_SyoubyoujyoutaiKbn;
import yuyu.def.db.entity.HT_ImusateiRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import yuyu.def.db.type.UserType_C_Ketkekkacd;
import yuyu.def.db.type.UserType_C_Ketriyuucd;
import yuyu.def.db.type.UserType_C_SateiketsyorinmKbn;
import yuyu.def.db.type.UserType_C_SntkinfosakuseiyhKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_SyoubyoujyoutaiKbn;

/**
 * 医務査定履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_ImusateiRireki extends AbstractExDBTable<HT_ImusateiRireki> {

    public GenQHT_ImusateiRireki() {
        this("HT_ImusateiRireki");
    }

    public GenQHT_ImusateiRireki(String pAlias) {
        super("HT_ImusateiRireki", HT_ImusateiRireki.class, pAlias);
    }

    public String HT_ImusateiRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_ImusateiRireki, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldNumber<HT_ImusateiRireki, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_ImusateiRireki, BizDate> syoriYmd = new ExDBFieldString<>("syoriYmd", this, BizDateType.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_SateiketsyorinmKbn> sateiketsyorinmkbn = new ExDBFieldString<>("sateiketsyorinmkbn", this, UserType_C_SateiketsyorinmKbn.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_SyorikekkaKbn> imusateikekkakbn = new ExDBFieldString<>("imusateikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<HT_ImusateiRireki, String> tnsketsyacd = new ExDBFieldString<>("tnsketsyacd", this);

    public final ExDBFieldString<HT_ImusateiRireki, String> ketsyacd = new ExDBFieldString<>("ketsyacd", this);

    public final ExDBFieldString<HT_ImusateiRireki, String> palketsyacd = new ExDBFieldString<>("palketsyacd", this);

    public final ExDBFieldString<HT_ImusateiRireki, String> imusateicomment = new ExDBFieldString<>("imusateicomment", this);

    public final ExDBFieldString<HT_ImusateiRireki, C_Ketkekkacd> ketkekkacd = new ExDBFieldString<>("ketkekkacd", this, UserType_C_Ketkekkacd.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_Ketriyuucd> ketriyuucd1 = new ExDBFieldString<>("ketriyuucd1", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_Ketriyuucd> ketriyuucd2 = new ExDBFieldString<>("ketriyuucd2", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_Ketriyuucd> ketriyuucd3 = new ExDBFieldString<>("ketriyuucd3", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_Ketriyuucd> ketriyuucd4 = new ExDBFieldString<>("ketriyuucd4", this, UserType_C_Ketriyuucd.class);

    public final ExDBFieldString<HT_ImusateiRireki, String> syoubyoucd1 = new ExDBFieldString<>("syoubyoucd1", this);

    public final ExDBFieldString<HT_ImusateiRireki, C_SyoubyoujyoutaiKbn> syoubyoujyoutaikbn1 = new ExDBFieldString<>("syoubyoujyoutaikbn1", this, UserType_C_SyoubyoujyoutaiKbn.class);

    public final ExDBFieldString<HT_ImusateiRireki, BizDateYM> kantiym1 = new ExDBFieldString<>("kantiym1", this, BizDateYMType.class);

    public final ExDBFieldString<HT_ImusateiRireki, String> syoubyoucd2 = new ExDBFieldString<>("syoubyoucd2", this);

    public final ExDBFieldString<HT_ImusateiRireki, C_SyoubyoujyoutaiKbn> syoubyoujyoutaikbn2 = new ExDBFieldString<>("syoubyoujyoutaikbn2", this, UserType_C_SyoubyoujyoutaiKbn.class);

    public final ExDBFieldString<HT_ImusateiRireki, BizDateYM> kantiym2 = new ExDBFieldString<>("kantiym2", this, BizDateYMType.class);

    public final ExDBFieldString<HT_ImusateiRireki, C_SntkinfosakuseiyhKbn> sntkinfosakuseiyhkbn = new ExDBFieldString<>("sntkinfosakuseiyhkbn", this, UserType_C_SntkinfosakuseiyhKbn.class);

    public final ExDBFieldString<HT_ImusateiRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_ImusateiRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
