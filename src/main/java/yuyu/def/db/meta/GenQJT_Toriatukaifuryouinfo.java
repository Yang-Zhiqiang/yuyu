package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_NoinitSyorizumiKbn;
import yuyu.def.classification.C_NoinitUmuKbn;
import yuyu.def.classification.C_NoinitYouhiKbn;
import yuyu.def.db.entity.JT_Toriatukaifuryouinfo;
import yuyu.def.db.type.UserType_C_NoinitSyorizumiKbn;
import yuyu.def.db.type.UserType_C_NoinitUmuKbn;
import yuyu.def.db.type.UserType_C_NoinitYouhiKbn;

/**
 * 取扱不良情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_Toriatukaifuryouinfo extends AbstractExDBTable<JT_Toriatukaifuryouinfo> {

    public GenQJT_Toriatukaifuryouinfo() {
        this("JT_Toriatukaifuryouinfo");
    }

    public GenQJT_Toriatukaifuryouinfo(String pAlias) {
        super("JT_Toriatukaifuryouinfo", JT_Toriatukaifuryouinfo.class, pAlias);
    }

    public String JT_Toriatukaifuryouinfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_Toriatukaifuryouinfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, C_NoinitUmuKbn> tratkihuryouumukbn = new ExDBFieldString<>("tratkihuryouumukbn", this, UserType_C_NoinitUmuKbn.class);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, C_NoinitYouhiKbn> gyousinkaisouyouhikbn = new ExDBFieldString<>("gyousinkaisouyouhikbn", this, UserType_C_NoinitYouhiKbn.class);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, C_NoinitSyorizumiKbn> aireqdaityoukisaikbn = new ExDBFieldString<>("aireqdaityoukisaikbn", this, UserType_C_NoinitSyorizumiKbn.class);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> tratkihuryoucomment = new ExDBFieldString<>("tratkihuryoucomment", this);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_Toriatukaifuryouinfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
