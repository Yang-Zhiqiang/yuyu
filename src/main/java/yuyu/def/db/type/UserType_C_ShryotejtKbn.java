package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShryotejtKbn;

/**
 * {@link C_ShryotejtKbn 支払予定状態区分} の Hibernate ユーザー定義型です。<br />
 * 支払予定状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShryotejtKbn extends AbstractUserType<C_ShryotejtKbn> {

    @Override
    protected Class<C_ShryotejtKbn> returnType() {
        return C_ShryotejtKbn.class;
    }

    @Override
    protected C_ShryotejtKbn valueOf(String pValue) {
        return C_ShryotejtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShryotejtKbn pValue) {
        return pValue.getValue();
    }
}
