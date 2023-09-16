package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Syoumetujiyuu;
import yuyu.def.classification.C_YuukoujyotaikahiKbn;
import yuyu.def.db.entity.IM_Syoumetukahi;
import yuyu.def.db.type.UserType_C_Syoumetujiyuu;
import yuyu.def.db.type.UserType_C_YuukoujyotaikahiKbn;

/**
 * 消滅状態処理可否マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIM_Syoumetukahi extends AbstractExDBTable<IM_Syoumetukahi> {

    public GenQIM_Syoumetukahi() {
        this("IM_Syoumetukahi");
    }

    public GenQIM_Syoumetukahi(String pAlias) {
        super("IM_Syoumetukahi", IM_Syoumetukahi.class, pAlias);
    }

    public String IM_Syoumetukahi() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IM_Syoumetukahi, String> kinouId = new ExDBFieldString<>("kinouId", this);

    public final ExDBFieldString<IM_Syoumetukahi, C_Syoumetujiyuu> syoumetujiyuu = new ExDBFieldString<>("syoumetujiyuu", this, UserType_C_Syoumetujiyuu.class);

    public final ExDBFieldString<IM_Syoumetukahi, C_YuukoujyotaikahiKbn> yuukoujyotaikahikbn = new ExDBFieldString<>("yuukoujyotaikahikbn", this, UserType_C_YuukoujyotaikahiKbn.class);

    public final ExDBFieldString<IM_Syoumetukahi, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IM_Syoumetukahi, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IM_Syoumetukahi, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
