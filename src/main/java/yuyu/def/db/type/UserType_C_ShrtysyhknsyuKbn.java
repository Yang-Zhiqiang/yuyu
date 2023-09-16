package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;

/**
 * {@link C_ShrtysyhknsyuKbn 支払調書保険種類区分} の Hibernate ユーザー定義型です。<br />
 * 支払調書保険種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrtysyhknsyuKbn extends AbstractUserType<C_ShrtysyhknsyuKbn> {

    @Override
    protected Class<C_ShrtysyhknsyuKbn> returnType() {
        return C_ShrtysyhknsyuKbn.class;
    }

    @Override
    protected C_ShrtysyhknsyuKbn valueOf(String pValue) {
        return C_ShrtysyhknsyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrtysyhknsyuKbn pValue) {
        return pValue.getValue();
    }
}
