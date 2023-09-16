package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.HT_MosMikakuteiSyorui;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;

/**
 * 申込未確定書類テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_MosMikakuteiSyorui extends AbstractExDBTable<HT_MosMikakuteiSyorui> {

    public GenQHT_MosMikakuteiSyorui() {
        this("HT_MosMikakuteiSyorui");
    }

    public GenQHT_MosMikakuteiSyorui(String pAlias) {
        super("HT_MosMikakuteiSyorui", HT_MosMikakuteiSyorui.class, pAlias);
    }

    public String HT_MosMikakuteiSyorui() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_MosMikakuteiSyorui, String> documentid = new ExDBFieldString<>("documentid", this);

    public final ExDBFieldString<HT_MosMikakuteiSyorui, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_MosMikakuteiSyorui, C_SyoruiCdKbn> syoruiCd = new ExDBFieldString<>("syoruiCd", this, UserType_C_SyoruiCdKbn.class);

    public final ExDBFieldString<HT_MosMikakuteiSyorui, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_MosMikakuteiSyorui, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
