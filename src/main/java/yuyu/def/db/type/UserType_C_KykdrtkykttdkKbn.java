package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykdrtkykttdkKbn;

/**
 * {@link C_KykdrtkykttdkKbn 契約者代理特約手続区分} の Hibernate ユーザー定義型です。<br />
 * 契約者代理特約手続区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykdrtkykttdkKbn extends AbstractUserType<C_KykdrtkykttdkKbn> {

    @Override
    protected Class<C_KykdrtkykttdkKbn> returnType() {
        return C_KykdrtkykttdkKbn.class;
    }

    @Override
    protected C_KykdrtkykttdkKbn valueOf(String pValue) {
        return C_KykdrtkykttdkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykdrtkykttdkKbn pValue) {
        return pValue.getValue();
    }
}
