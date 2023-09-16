package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_MsgHikisuuNaiyouKbn;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.classification.C_SKNaiyouChkKbn;
import yuyu.def.classification.C_YobidasimotoTaskKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.JM_SkNaiyouChk;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_MsgHikisuuNaiyouKbn;
import yuyu.def.db.type.UserType_C_MsgSyubetu;
import yuyu.def.db.type.UserType_C_SKNaiyouChkKbn;
import yuyu.def.db.type.UserType_C_YobidasimotoTaskKbn;
import yuyu.def.db.type.UserType_C_YouhiKbn;

/**
 * 請求内容チェック判定マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJM_SkNaiyouChk extends AbstractExDBTable<JM_SkNaiyouChk> {

    public GenQJM_SkNaiyouChk() {
        this("JM_SkNaiyouChk");
    }

    public GenQJM_SkNaiyouChk(String pAlias) {
        super("JM_SkNaiyouChk", JM_SkNaiyouChk.class, pAlias);
    }

    public String JM_SkNaiyouChk() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JM_SkNaiyouChk, C_SKNaiyouChkKbn> sknaiyouchkkbn = new ExDBFieldString<>("sknaiyouchkkbn", this, UserType_C_SKNaiyouChkKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, C_YobidasimotoTaskKbn> yobidasimototaskkbn = new ExDBFieldString<>("yobidasimototaskkbn", this, UserType_C_YobidasimotoTaskKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, C_MsgSyubetu> msgsyubetu = new ExDBFieldString<>("msgsyubetu", this, UserType_C_MsgSyubetu.class);

    public final ExDBFieldString<JM_SkNaiyouChk, C_YouhiKbn> sateikaisouyouhikbn = new ExDBFieldString<>("sateikaisouyouhikbn", this, UserType_C_YouhiKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, C_KahiKbn> keisankahikbn = new ExDBFieldString<>("keisankahikbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, String> messageId = new ExDBFieldString<>("messageId", this);

    public final ExDBFieldString<JM_SkNaiyouChk, C_MsgHikisuuNaiyouKbn> msghikisuunaiyoukbn1 = new ExDBFieldString<>("msghikisuunaiyoukbn1", this, UserType_C_MsgHikisuuNaiyouKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, String> msghikisuu1 = new ExDBFieldString<>("msghikisuu1", this);

    public final ExDBFieldString<JM_SkNaiyouChk, C_MsgHikisuuNaiyouKbn> msghikisuunaiyoukbn2 = new ExDBFieldString<>("msghikisuunaiyoukbn2", this, UserType_C_MsgHikisuuNaiyouKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, String> msghikisuu2 = new ExDBFieldString<>("msghikisuu2", this);

    public final ExDBFieldString<JM_SkNaiyouChk, C_MsgHikisuuNaiyouKbn> msghikisuunaiyoukbn3 = new ExDBFieldString<>("msghikisuunaiyoukbn3", this, UserType_C_MsgHikisuuNaiyouKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, String> msghikisuu3 = new ExDBFieldString<>("msghikisuu3", this);

    public final ExDBFieldString<JM_SkNaiyouChk, C_MsgHikisuuNaiyouKbn> msghikisuunaiyoukbn4 = new ExDBFieldString<>("msghikisuunaiyoukbn4", this, UserType_C_MsgHikisuuNaiyouKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, String> msghikisuu4 = new ExDBFieldString<>("msghikisuu4", this);

    public final ExDBFieldString<JM_SkNaiyouChk, C_MsgHikisuuNaiyouKbn> msghikisuunaiyoukbn5 = new ExDBFieldString<>("msghikisuunaiyoukbn5", this, UserType_C_MsgHikisuuNaiyouKbn.class);

    public final ExDBFieldString<JM_SkNaiyouChk, String> msghikisuu5 = new ExDBFieldString<>("msghikisuu5", this);
}
