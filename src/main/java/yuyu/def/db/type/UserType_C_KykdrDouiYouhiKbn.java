package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykdrDouiYouhiKbn;

/**
 * {@link C_KykdrDouiYouhiKbn 契約者代理人同意要否区分} の Hibernate ユーザー定義型です。<br />
 * 契約者代理人同意要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykdrDouiYouhiKbn extends AbstractUserType<C_KykdrDouiYouhiKbn> {

    @Override
    protected Class<C_KykdrDouiYouhiKbn> returnType() {
        return C_KykdrDouiYouhiKbn.class;
    }

    @Override
    protected C_KykdrDouiYouhiKbn valueOf(String pValue) {
        return C_KykdrDouiYouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykdrDouiYouhiKbn pValue) {
        return pValue.getValue();
    }
}
