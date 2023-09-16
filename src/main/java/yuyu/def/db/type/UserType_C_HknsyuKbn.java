package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknsyuKbn;

/**
 * {@link C_HknsyuKbn 保険種類区分} の Hibernate ユーザー定義型です。<br />
 * 保険種類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknsyuKbn extends AbstractUserType<C_HknsyuKbn> {

    @Override
    protected Class<C_HknsyuKbn> returnType() {
        return C_HknsyuKbn.class;
    }

    @Override
    protected C_HknsyuKbn valueOf(String pValue) {
        return C_HknsyuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknsyuKbn pValue) {
        return pValue.getValue();
    }
}
