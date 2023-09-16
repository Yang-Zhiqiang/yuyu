package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubiteiseiPtnKbn;

/**
 * {@link C_HubiteiseiPtnKbn 不備訂正書作成パターン区分} の Hibernate ユーザー定義型です。<br />
 * 不備訂正書作成パターン区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubiteiseiPtnKbn extends AbstractUserType<C_HubiteiseiPtnKbn> {

    @Override
    protected Class<C_HubiteiseiPtnKbn> returnType() {
        return C_HubiteiseiPtnKbn.class;
    }

    @Override
    protected C_HubiteiseiPtnKbn valueOf(String pValue) {
        return C_HubiteiseiPtnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubiteiseiPtnKbn pValue) {
        return pValue.getValue();
    }
}
