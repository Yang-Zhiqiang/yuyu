package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakugenshrkakKbn;

/**
 * {@link C_SakugenshrkakKbn 削減支払確認区分} の Hibernate ユーザー定義型です。<br />
 * 削減支払確認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakugenshrkakKbn extends AbstractUserType<C_SakugenshrkakKbn> {

    @Override
    protected Class<C_SakugenshrkakKbn> returnType() {
        return C_SakugenshrkakKbn.class;
    }

    @Override
    protected C_SakugenshrkakKbn valueOf(String pValue) {
        return C_SakugenshrkakKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakugenshrkakKbn pValue) {
        return pValue.getValue();
    }
}
