package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kengenlv;

/**
 * {@link C_Kengenlv 権限レベル} の Hibernate ユーザー定義型です。<br />
 * 権限レベル 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kengenlv extends AbstractUserType<C_Kengenlv> {

    @Override
    protected Class<C_Kengenlv> returnType() {
        return C_Kengenlv.class;
    }

    @Override
    protected C_Kengenlv valueOf(String pValue) {
        return C_Kengenlv.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kengenlv pValue) {
        return pValue.getValue();
    }
}
