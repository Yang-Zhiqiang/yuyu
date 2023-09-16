package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NextjgnndjyutouKbn;

/**
 * {@link C_NextjgnndjyutouKbn 翌事業年度充当区分} の Hibernate ユーザー定義型です。<br />
 * 翌事業年度充当区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NextjgnndjyutouKbn extends AbstractUserType<C_NextjgnndjyutouKbn> {

    @Override
    protected Class<C_NextjgnndjyutouKbn> returnType() {
        return C_NextjgnndjyutouKbn.class;
    }

    @Override
    protected C_NextjgnndjyutouKbn valueOf(String pValue) {
        return C_NextjgnndjyutouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NextjgnndjyutouKbn pValue) {
        return pValue.getValue();
    }
}
