package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_Rulehanteimsg;
import yuyu.def.db.entity.HT_RuleHanteiMsg;
import yuyu.def.db.type.UserType_C_Rulehanteimsg;

/**
 * ルール判定結果メッセージテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_RuleHanteiMsg extends AbstractExDBTable<HT_RuleHanteiMsg> {

    public GenQHT_RuleHanteiMsg() {
        this("HT_RuleHanteiMsg");
    }

    public GenQHT_RuleHanteiMsg(String pAlias) {
        super("HT_RuleHanteiMsg", HT_RuleHanteiMsg.class, pAlias);
    }

    public String HT_RuleHanteiMsg() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_RuleHanteiMsg, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_RuleHanteiMsg, C_Rulehanteimsg> rulehanteimsg = new ExDBFieldString<>("rulehanteimsg", this, UserType_C_Rulehanteimsg.class);

    public final ExDBFieldNumber<HT_RuleHanteiMsg, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_RuleHanteiMsg, String> rulehanteimsgid = new ExDBFieldString<>("rulehanteimsgid", this);

    public final ExDBFieldString<HT_RuleHanteiMsg, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_RuleHanteiMsg, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
