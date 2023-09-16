package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtenkeitaiKbn;

/**
 * {@link C_DrtenkeitaiKbn 代理店形態区分} の Hibernate ユーザー定義型です。<br />
 * 代理店形態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtenkeitaiKbn extends AbstractUserType<C_DrtenkeitaiKbn> {

    @Override
    protected Class<C_DrtenkeitaiKbn> returnType() {
        return C_DrtenkeitaiKbn.class;
    }

    @Override
    protected C_DrtenkeitaiKbn valueOf(String pValue) {
        return C_DrtenkeitaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtenkeitaiKbn pValue) {
        return pValue.getValue();
    }
}
