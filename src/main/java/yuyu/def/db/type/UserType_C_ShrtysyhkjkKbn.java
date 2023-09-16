package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrtysyhkjkKbn;

/**
 * {@link C_ShrtysyhkjkKbn 支払調書保険事故区分} の Hibernate ユーザー定義型です。<br />
 * 支払調書保険事故区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrtysyhkjkKbn extends AbstractUserType<C_ShrtysyhkjkKbn> {

    @Override
    protected Class<C_ShrtysyhkjkKbn> returnType() {
        return C_ShrtysyhkjkKbn.class;
    }

    @Override
    protected C_ShrtysyhkjkKbn valueOf(String pValue) {
        return C_ShrtysyhkjkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrtysyhkjkKbn pValue) {
        return pValue.getValue();
    }
}
