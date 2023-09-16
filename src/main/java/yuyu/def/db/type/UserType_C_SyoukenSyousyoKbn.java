package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoukenSyousyoKbn;

/**
 * {@link C_SyoukenSyousyoKbn 証券・証書区分} の Hibernate ユーザー定義型です。<br />
 * 証券・証書区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoukenSyousyoKbn extends AbstractUserType<C_SyoukenSyousyoKbn> {

    @Override
    protected Class<C_SyoukenSyousyoKbn> returnType() {
        return C_SyoukenSyousyoKbn.class;
    }

    @Override
    protected C_SyoukenSyousyoKbn valueOf(String pValue) {
        return C_SyoukenSyousyoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoukenSyousyoKbn pValue) {
        return pValue.getValue();
    }
}
