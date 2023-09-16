package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknnendoKbn;

/**
 * {@link C_HknnendoKbn 保険年度区分} の Hibernate ユーザー定義型です。<br />
 * 保険年度区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknnendoKbn extends AbstractUserType<C_HknnendoKbn> {

    @Override
    protected Class<C_HknnendoKbn> returnType() {
        return C_HknnendoKbn.class;
    }

    @Override
    protected C_HknnendoKbn valueOf(String pValue) {
        return C_HknnendoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknnendoKbn pValue) {
        return pValue.getValue();
    }
}
