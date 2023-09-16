package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_MsgSyubetu;
import yuyu.def.db.entity.JT_SkHubiMsg;
import yuyu.def.db.type.UserType_C_MsgSyubetu;

/**
 * 請求不備テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SkHubiMsg extends AbstractExDBTable<JT_SkHubiMsg> {

    public GenQJT_SkHubiMsg() {
        this("JT_SkHubiMsg");
    }

    public GenQJT_SkHubiMsg(String pAlias) {
        super("JT_SkHubiMsg", JT_SkHubiMsg.class, pAlias);
    }

    public String JT_SkHubiMsg() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SkHubiMsg, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SkHubiMsg, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SkHubiMsg, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldNumber<JT_SkHubiMsg, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldNumber<JT_SkHubiMsg, Integer> uketukeno = new ExDBFieldNumber<>("uketukeno", this);

    public final ExDBFieldString<JT_SkHubiMsg, C_MsgSyubetu> msgsyubetu = new ExDBFieldString<>("msgsyubetu", this, UserType_C_MsgSyubetu.class);

    public final ExDBFieldString<JT_SkHubiMsg, String> hubimsgid = new ExDBFieldString<>("hubimsgid", this);

    public final ExDBFieldString<JT_SkHubiMsg, String> hubimsg = new ExDBFieldString<>("hubimsg", this);

    public final ExDBFieldString<JT_SkHubiMsg, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SkHubiMsg, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);
}
