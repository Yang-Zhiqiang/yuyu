package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KaikeitantousyaKbn;

/**
 * {@link C_KaikeitantousyaKbn 会計担当者区分} の Hibernate ユーザー定義型です。<br />
 * 会計担当者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KaikeitantousyaKbn extends AbstractUserType<C_KaikeitantousyaKbn> {

    @Override
    protected Class<C_KaikeitantousyaKbn> returnType() {
        return C_KaikeitantousyaKbn.class;
    }

    @Override
    protected C_KaikeitantousyaKbn valueOf(String pValue) {
        return C_KaikeitantousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KaikeitantousyaKbn pValue) {
        return pValue.getValue();
    }
}
