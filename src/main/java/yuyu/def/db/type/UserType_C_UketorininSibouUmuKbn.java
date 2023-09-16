package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UketorininSibouUmuKbn;

/**
 * {@link C_UketorininSibouUmuKbn 受取人死亡有無区分} の Hibernate ユーザー定義型です。<br />
 * 受取人死亡有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UketorininSibouUmuKbn extends AbstractUserType<C_UketorininSibouUmuKbn> {

    @Override
    protected Class<C_UketorininSibouUmuKbn> returnType() {
        return C_UketorininSibouUmuKbn.class;
    }

    @Override
    protected C_UketorininSibouUmuKbn valueOf(String pValue) {
        return C_UketorininSibouUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UketorininSibouUmuKbn pValue) {
        return pValue.getValue();
    }
}
