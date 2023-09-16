package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HubikaisyoujoutaiKbn;

/**
 * {@link C_HubikaisyoujoutaiKbn 不備解消状態区分} の Hibernate ユーザー定義型です。<br />
 * 不備解消状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HubikaisyoujoutaiKbn extends AbstractUserType<C_HubikaisyoujoutaiKbn> {

    @Override
    protected Class<C_HubikaisyoujoutaiKbn> returnType() {
        return C_HubikaisyoujoutaiKbn.class;
    }

    @Override
    protected C_HubikaisyoujoutaiKbn valueOf(String pValue) {
        return C_HubikaisyoujoutaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HubikaisyoujoutaiKbn pValue) {
        return pValue.getValue();
    }
}
