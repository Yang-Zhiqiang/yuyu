package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TratkidrtenKbn;

/**
 * {@link C_TratkidrtenKbn 取扱代理店区分} の Hibernate ユーザー定義型です。<br />
 * 取扱代理店区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TratkidrtenKbn extends AbstractUserType<C_TratkidrtenKbn> {

    @Override
    protected Class<C_TratkidrtenKbn> returnType() {
        return C_TratkidrtenKbn.class;
    }

    @Override
    protected C_TratkidrtenKbn valueOf(String pValue) {
        return C_TratkidrtenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TratkidrtenKbn pValue) {
        return pValue.getValue();
    }
}
