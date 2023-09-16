package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoudakuKbn;

/**
 * {@link C_SyoudakuKbn 承諾区分} の Hibernate ユーザー定義型です。<br />
 * 承諾区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoudakuKbn extends AbstractUserType<C_SyoudakuKbn> {

    @Override
    protected Class<C_SyoudakuKbn> returnType() {
        return C_SyoudakuKbn.class;
    }

    @Override
    protected C_SyoudakuKbn valueOf(String pValue) {
        return C_SyoudakuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoudakuKbn pValue) {
        return pValue.getValue();
    }
}
