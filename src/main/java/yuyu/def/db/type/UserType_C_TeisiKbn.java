package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TeisiKbn;

/**
 * {@link C_TeisiKbn 停止区分} の Hibernate ユーザー定義型です。<br />
 * 停止区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TeisiKbn extends AbstractUserType<C_TeisiKbn> {

    @Override
    protected Class<C_TeisiKbn> returnType() {
        return C_TeisiKbn.class;
    }

    @Override
    protected C_TeisiKbn valueOf(String pValue) {
        return C_TeisiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TeisiKbn pValue) {
        return pValue.getValue();
    }
}
