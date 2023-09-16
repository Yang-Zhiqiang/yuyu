package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouhuristatusKbn;

/**
 * {@link C_KouhuristatusKbn 口振ステータス区分} の Hibernate ユーザー定義型です。<br />
 * 口振ステータス区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouhuristatusKbn extends AbstractUserType<C_KouhuristatusKbn> {

    @Override
    protected Class<C_KouhuristatusKbn> returnType() {
        return C_KouhuristatusKbn.class;
    }

    @Override
    protected C_KouhuristatusKbn valueOf(String pValue) {
        return C_KouhuristatusKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouhuristatusKbn pValue) {
        return pValue.getValue();
    }
}
