package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NknengkhnkKbn;

/**
 * {@link C_NknengkhnkKbn 年金年額変更区分} の Hibernate ユーザー定義型です。<br />
 * 年金年額変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NknengkhnkKbn extends AbstractUserType<C_NknengkhnkKbn> {

    @Override
    protected Class<C_NknengkhnkKbn> returnType() {
        return C_NknengkhnkKbn.class;
    }

    @Override
    protected C_NknengkhnkKbn valueOf(String pValue) {
        return C_NknengkhnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NknengkhnkKbn pValue) {
        return pValue.getValue();
    }
}
