package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnptsgtknKbn;

/**
 * {@link C_KnptsgtknKbn 健保対象外（治験）区分} の Hibernate ユーザー定義型です。<br />
 * 健保対象外（治験）区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnptsgtknKbn extends AbstractUserType<C_KnptsgtknKbn> {

    @Override
    protected Class<C_KnptsgtknKbn> returnType() {
        return C_KnptsgtknKbn.class;
    }

    @Override
    protected C_KnptsgtknKbn valueOf(String pValue) {
        return C_KnptsgtknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnptsgtknKbn pValue) {
        return pValue.getValue();
    }
}
