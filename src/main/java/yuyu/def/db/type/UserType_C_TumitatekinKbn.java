package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TumitatekinKbn;

/**
 * {@link C_TumitatekinKbn 積立金区分} の Hibernate ユーザー定義型です。<br />
 * 積立金区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TumitatekinKbn extends AbstractUserType<C_TumitatekinKbn> {

    @Override
    protected Class<C_TumitatekinKbn> returnType() {
        return C_TumitatekinKbn.class;
    }

    @Override
    protected C_TumitatekinKbn valueOf(String pValue) {
        return C_TumitatekinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TumitatekinKbn pValue) {
        return pValue.getValue();
    }
}
