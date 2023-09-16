package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KyktrksKbn;

/**
 * {@link C_KyktrksKbn 契約取消区分} の Hibernate ユーザー定義型です。<br />
 * 契約取消区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KyktrksKbn extends AbstractUserType<C_KyktrksKbn> {

    @Override
    protected Class<C_KyktrksKbn> returnType() {
        return C_KyktrksKbn.class;
    }

    @Override
    protected C_KyktrksKbn valueOf(String pValue) {
        return C_KyktrksKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KyktrksKbn pValue) {
        return pValue.getValue();
    }
}
