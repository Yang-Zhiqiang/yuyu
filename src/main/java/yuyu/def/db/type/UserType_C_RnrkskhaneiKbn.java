package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RnrkskhaneiKbn;

/**
 * {@link C_RnrkskhaneiKbn 連絡先反映区分} の Hibernate ユーザー定義型です。<br />
 * 連絡先反映区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RnrkskhaneiKbn extends AbstractUserType<C_RnrkskhaneiKbn> {

    @Override
    protected Class<C_RnrkskhaneiKbn> returnType() {
        return C_RnrkskhaneiKbn.class;
    }

    @Override
    protected C_RnrkskhaneiKbn valueOf(String pValue) {
        return C_RnrkskhaneiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RnrkskhaneiKbn pValue) {
        return pValue.getValue();
    }
}
