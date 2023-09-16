package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzhuritourokuhouKbn;

/**
 * {@link C_KzhuritourokuhouKbn 口座振替登録方法区分} の Hibernate ユーザー定義型です。<br />
 * 口座振替登録方法区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzhuritourokuhouKbn extends AbstractUserType<C_KzhuritourokuhouKbn> {

    @Override
    protected Class<C_KzhuritourokuhouKbn> returnType() {
        return C_KzhuritourokuhouKbn.class;
    }

    @Override
    protected C_KzhuritourokuhouKbn valueOf(String pValue) {
        return C_KzhuritourokuhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzhuritourokuhouKbn pValue) {
        return pValue.getValue();
    }
}
