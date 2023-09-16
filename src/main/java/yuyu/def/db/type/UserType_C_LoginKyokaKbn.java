package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LoginKyokaKbn;

/**
 * {@link C_LoginKyokaKbn ログイン許可区分} の Hibernate ユーザー定義型です。<br />
 * ログイン許可区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LoginKyokaKbn extends AbstractUserType<C_LoginKyokaKbn> {

    @Override
    protected Class<C_LoginKyokaKbn> returnType() {
        return C_LoginKyokaKbn.class;
    }

    @Override
    protected C_LoginKyokaKbn valueOf(String pValue) {
        return C_LoginKyokaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LoginKyokaKbn pValue) {
        return pValue.getValue();
    }
}
