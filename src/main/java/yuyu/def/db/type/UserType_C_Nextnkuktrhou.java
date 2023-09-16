package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Nextnkuktrhou;

/**
 * {@link C_Nextnkuktrhou 次回年金受取方法} の Hibernate ユーザー定義型です。<br />
 * 次回年金受取方法 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Nextnkuktrhou extends AbstractUserType<C_Nextnkuktrhou> {

    @Override
    protected Class<C_Nextnkuktrhou> returnType() {
        return C_Nextnkuktrhou.class;
    }

    @Override
    protected C_Nextnkuktrhou valueOf(String pValue) {
        return C_Nextnkuktrhou.valueOf(pValue);
    }

    @Override
    protected String toString(C_Nextnkuktrhou pValue) {
        return pValue.getValue();
    }
}
