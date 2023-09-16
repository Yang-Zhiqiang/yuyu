package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkhjnKbn;

/**
 * {@link C_TkhjnKbn 特定関係法人区分} の Hibernate ユーザー定義型です。<br />
 * 特定関係法人区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkhjnKbn extends AbstractUserType<C_TkhjnKbn> {

    @Override
    protected Class<C_TkhjnKbn> returnType() {
        return C_TkhjnKbn.class;
    }

    @Override
    protected C_TkhjnKbn valueOf(String pValue) {
        return C_TkhjnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkhjnKbn pValue) {
        return pValue.getValue();
    }
}
