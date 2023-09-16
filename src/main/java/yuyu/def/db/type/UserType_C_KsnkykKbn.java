package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KsnkykKbn;

/**
 * {@link C_KsnkykKbn 更新契約区分} の Hibernate ユーザー定義型です。<br />
 * 更新契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KsnkykKbn extends AbstractUserType<C_KsnkykKbn> {

    @Override
    protected Class<C_KsnkykKbn> returnType() {
        return C_KsnkykKbn.class;
    }

    @Override
    protected C_KsnkykKbn valueOf(String pValue) {
        return C_KsnkykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KsnkykKbn pValue) {
        return pValue.getValue();
    }
}
