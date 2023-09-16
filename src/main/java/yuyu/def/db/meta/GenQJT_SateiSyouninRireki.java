package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HigaitouRiyuuKbn;
import yuyu.def.classification.C_HushrGeninKbn;
import yuyu.def.classification.C_SyorikekkaKbn;
import yuyu.def.classification.C_YouhiblnkKbn;
import yuyu.def.db.entity.JT_SateiSyouninRireki;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HigaitouRiyuuKbn;
import yuyu.def.db.type.UserType_C_HushrGeninKbn;
import yuyu.def.db.type.UserType_C_SyorikekkaKbn;
import yuyu.def.db.type.UserType_C_YouhiblnkKbn;

/**
 * 査定承認履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SateiSyouninRireki extends AbstractExDBTable<JT_SateiSyouninRireki> {

    public GenQJT_SateiSyouninRireki() {
        this("JT_SateiSyouninRireki");
    }

    public GenQJT_SateiSyouninRireki(String pAlias) {
        super("JT_SateiSyouninRireki", JT_SateiSyouninRireki.class, pAlias);
    }

    public String JT_SateiSyouninRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SateiSyouninRireki, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> sateisyouninskbtkey = new ExDBFieldString<>("sateisyouninskbtkey", this);

    public final ExDBFieldNumber<JT_SateiSyouninRireki, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, C_SyorikekkaKbn> syorikekkakbn = new ExDBFieldString<>("syorikekkakbn", this, UserType_C_SyorikekkaKbn.class);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> tennousakisousasyacd = new ExDBFieldString<>("tennousakisousasyacd", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, C_HushrGeninKbn> hushrgeninkbn = new ExDBFieldString<>("hushrgeninkbn", this, UserType_C_HushrGeninKbn.class);

    public final ExDBFieldString<JT_SateiSyouninRireki, C_HigaitouRiyuuKbn> higaitouriyuukbn = new ExDBFieldString<>("higaitouriyuukbn", this, UserType_C_HigaitouRiyuuKbn.class);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> reportcomment = new ExDBFieldString<>("reportcomment", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, C_YouhiblnkKbn> sessyouyhkbn = new ExDBFieldString<>("sessyouyhkbn", this, UserType_C_YouhiblnkKbn.class);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> sessyousisyacd = new ExDBFieldString<>("sessyousisyacd", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, BizDate> kaiketuymd = new ExDBFieldString<>("kaiketuymd", this, BizDateType.class);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SateiSyouninRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
