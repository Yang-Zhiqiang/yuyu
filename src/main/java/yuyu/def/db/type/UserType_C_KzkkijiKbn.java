package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzkkijiKbn;

/**
 * {@link C_KzkkijiKbn 家族記事区分} の Hibernate ユーザー定義型です。<br />
 * 家族記事区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzkkijiKbn extends AbstractUserType<C_KzkkijiKbn> {

    @Override
    protected Class<C_KzkkijiKbn> returnType() {
        return C_KzkkijiKbn.class;
    }

    @Override
    protected C_KzkkijiKbn valueOf(String pValue) {
        return C_KzkkijiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzkkijiKbn pValue) {
        return pValue.getValue();
    }
}
