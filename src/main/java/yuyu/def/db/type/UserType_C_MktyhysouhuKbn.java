package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MktyhysouhuKbn;

/**
 * {@link C_MktyhysouhuKbn 満期用帳票送付区分} の Hibernate ユーザー定義型です。<br />
 * 満期用帳票送付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MktyhysouhuKbn extends AbstractUserType<C_MktyhysouhuKbn> {

    @Override
    protected Class<C_MktyhysouhuKbn> returnType() {
        return C_MktyhysouhuKbn.class;
    }

    @Override
    protected C_MktyhysouhuKbn valueOf(String pValue) {
        return C_MktyhysouhuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MktyhysouhuKbn pValue) {
        return pValue.getValue();
    }
}
