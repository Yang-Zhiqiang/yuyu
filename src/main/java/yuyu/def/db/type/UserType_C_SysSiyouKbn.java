package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SysSiyouKbn;

/**
 * {@link C_SysSiyouKbn システム使用区分} の Hibernate ユーザー定義型です。<br />
 * システム使用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SysSiyouKbn extends AbstractUserType<C_SysSiyouKbn> {

    @Override
    protected Class<C_SysSiyouKbn> returnType() {
        return C_SysSiyouKbn.class;
    }

    @Override
    protected C_SysSiyouKbn valueOf(String pValue) {
        return C_SysSiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SysSiyouKbn pValue) {
        return pValue.getValue();
    }
}
