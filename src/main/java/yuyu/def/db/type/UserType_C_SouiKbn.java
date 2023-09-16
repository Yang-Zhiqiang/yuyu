package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SouiKbn;

/**
 * {@link C_SouiKbn 相違区分} の Hibernate ユーザー定義型です。<br />
 * 相違区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SouiKbn extends AbstractUserType<C_SouiKbn> {

    @Override
    protected Class<C_SouiKbn> returnType() {
        return C_SouiKbn.class;
    }

    @Override
    protected C_SouiKbn valueOf(String pValue) {
        return C_SouiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SouiKbn pValue) {
        return pValue.getValue();
    }
}
