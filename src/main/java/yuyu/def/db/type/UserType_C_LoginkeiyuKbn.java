package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LoginkeiyuKbn;

/**
 * {@link C_LoginkeiyuKbn ログイン経由区分} の Hibernate ユーザー定義型です。<br />
 * ログイン経由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LoginkeiyuKbn extends AbstractUserType<C_LoginkeiyuKbn> {

    @Override
    protected Class<C_LoginkeiyuKbn> returnType() {
        return C_LoginkeiyuKbn.class;
    }

    @Override
    protected C_LoginkeiyuKbn valueOf(String pValue) {
        return C_LoginkeiyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LoginkeiyuKbn pValue) {
        return pValue.getValue();
    }
}
