package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykhnkKbn;

/**
 * {@link C_KykhnkKbn 契約変更区分} の Hibernate ユーザー定義型です。<br />
 * 契約変更区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykhnkKbn extends AbstractUserType<C_KykhnkKbn> {

    @Override
    protected Class<C_KykhnkKbn> returnType() {
        return C_KykhnkKbn.class;
    }

    @Override
    protected C_KykhnkKbn valueOf(String pValue) {
        return C_KykhnkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykhnkKbn pValue) {
        return pValue.getValue();
    }
}
