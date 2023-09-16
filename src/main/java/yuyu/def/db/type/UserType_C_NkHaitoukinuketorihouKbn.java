package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NkHaitoukinuketorihouKbn;

/**
 * {@link C_NkHaitoukinuketorihouKbn 年金配当金受取方法区分} の Hibernate ユーザー定義型です。<br />
 * 年金配当金受取方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NkHaitoukinuketorihouKbn extends AbstractUserType<C_NkHaitoukinuketorihouKbn> {

    @Override
    protected Class<C_NkHaitoukinuketorihouKbn> returnType() {
        return C_NkHaitoukinuketorihouKbn.class;
    }

    @Override
    protected C_NkHaitoukinuketorihouKbn valueOf(String pValue) {
        return C_NkHaitoukinuketorihouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NkHaitoukinuketorihouKbn pValue) {
        return pValue.getValue();
    }
}
