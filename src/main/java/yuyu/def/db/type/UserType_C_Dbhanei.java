package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Dbhanei;

/**
 * {@link C_Dbhanei DB反映区分} の Hibernate ユーザー定義型です。<br />
 * DB反映区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Dbhanei extends AbstractUserType<C_Dbhanei> {

    @Override
    protected Class<C_Dbhanei> returnType() {
        return C_Dbhanei.class;
    }

    @Override
    protected C_Dbhanei valueOf(String pValue) {
        return C_Dbhanei.valueOf(pValue);
    }

    @Override
    protected String toString(C_Dbhanei pValue) {
        return pValue.getValue();
    }
}
