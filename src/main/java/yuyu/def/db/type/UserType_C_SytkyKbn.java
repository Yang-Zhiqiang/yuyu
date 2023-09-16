package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SytkyKbn;

/**
 * {@link C_SytkyKbn 種別適用区分} の Hibernate ユーザー定義型です。<br />
 * 種別適用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SytkyKbn extends AbstractUserType<C_SytkyKbn> {

    @Override
    protected Class<C_SytkyKbn> returnType() {
        return C_SytkyKbn.class;
    }

    @Override
    protected C_SytkyKbn valueOf(String pValue) {
        return C_SytkyKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SytkyKbn pValue) {
        return pValue.getValue();
    }
}
