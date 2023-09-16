package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RiyousyaKbn;

/**
 * {@link C_RiyousyaKbn 利用者区分} の Hibernate ユーザー定義型です。<br />
 * 利用者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RiyousyaKbn extends AbstractUserType<C_RiyousyaKbn> {

    @Override
    protected Class<C_RiyousyaKbn> returnType() {
        return C_RiyousyaKbn.class;
    }

    @Override
    protected C_RiyousyaKbn valueOf(String pValue) {
        return C_RiyousyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RiyousyaKbn pValue) {
        return pValue.getValue();
    }
}
