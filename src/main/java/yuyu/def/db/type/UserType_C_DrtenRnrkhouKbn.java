package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DrtenRnrkhouKbn;

/**
 * {@link C_DrtenRnrkhouKbn 代理店連絡方法区分} の Hibernate ユーザー定義型です。<br />
 * 代理店連絡方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DrtenRnrkhouKbn extends AbstractUserType<C_DrtenRnrkhouKbn> {

    @Override
    protected Class<C_DrtenRnrkhouKbn> returnType() {
        return C_DrtenRnrkhouKbn.class;
    }

    @Override
    protected C_DrtenRnrkhouKbn valueOf(String pValue) {
        return C_DrtenRnrkhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DrtenRnrkhouKbn pValue) {
        return pValue.getValue();
    }
}
