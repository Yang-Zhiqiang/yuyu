package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GengkhouKbn;

/**
 * {@link C_GengkhouKbn 減額方法区分} の Hibernate ユーザー定義型です。<br />
 * 減額方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GengkhouKbn extends AbstractUserType<C_GengkhouKbn> {

    @Override
    protected Class<C_GengkhouKbn> returnType() {
        return C_GengkhouKbn.class;
    }

    @Override
    protected C_GengkhouKbn valueOf(String pValue) {
        return C_GengkhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GengkhouKbn pValue) {
        return pValue.getValue();
    }
}
