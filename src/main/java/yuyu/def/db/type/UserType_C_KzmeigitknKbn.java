package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzmeigitknKbn;

/**
 * {@link C_KzmeigitknKbn 口座名義人特認区分} の Hibernate ユーザー定義型です。<br />
 * 口座名義人特認区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzmeigitknKbn extends AbstractUserType<C_KzmeigitknKbn> {

    @Override
    protected Class<C_KzmeigitknKbn> returnType() {
        return C_KzmeigitknKbn.class;
    }

    @Override
    protected C_KzmeigitknKbn valueOf(String pValue) {
        return C_KzmeigitknKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzmeigitknKbn pValue) {
        return pValue.getValue();
    }
}
