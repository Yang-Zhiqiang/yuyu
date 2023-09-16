package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Rulehanteimsg;

/**
 * {@link C_Rulehanteimsg ルール判定結果メッセージ区分} の Hibernate ユーザー定義型です。<br />
 * ルール判定結果メッセージ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Rulehanteimsg extends AbstractUserType<C_Rulehanteimsg> {

    @Override
    protected Class<C_Rulehanteimsg> returnType() {
        return C_Rulehanteimsg.class;
    }

    @Override
    protected C_Rulehanteimsg valueOf(String pValue) {
        return C_Rulehanteimsg.valueOf(pValue);
    }

    @Override
    protected String toString(C_Rulehanteimsg pValue) {
        return pValue.getValue();
    }
}
