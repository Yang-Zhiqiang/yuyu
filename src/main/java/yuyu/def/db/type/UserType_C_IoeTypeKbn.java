package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IoeTypeKbn;

/**
 * {@link C_IoeTypeKbn ＩＯＥタイプ区分} の Hibernate ユーザー定義型です。<br />
 * ＩＯＥタイプ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IoeTypeKbn extends AbstractUserType<C_IoeTypeKbn> {

    @Override
    protected Class<C_IoeTypeKbn> returnType() {
        return C_IoeTypeKbn.class;
    }

    @Override
    protected C_IoeTypeKbn valueOf(String pValue) {
        return C_IoeTypeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IoeTypeKbn pValue) {
        return pValue.getValue();
    }
}
