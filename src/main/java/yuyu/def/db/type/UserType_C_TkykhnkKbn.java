package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkykhnkKbn;

/**
 * {@link C_TkykhnkKbn 特約変更区分} の Hibernate ユーザー定義型です。<br />
 * 特約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkykhnkKbn extends AbstractUserType<C_TkykhnkKbn> {

    @Override
    protected Class<C_TkykhnkKbn> returnType() {
        return C_TkykhnkKbn.class;
    }

    @Override
    protected C_TkykhnkKbn valueOf(String pValue) {
        return C_TkykhnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkykhnkKbn pValue) {
        return pValue.getValue();
    }
}
