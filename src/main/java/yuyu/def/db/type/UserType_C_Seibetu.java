package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Seibetu;

/**
 * {@link C_Seibetu 性別} の Hibernate ユーザー定義型です。<br />
 * 性別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Seibetu extends AbstractUserType<C_Seibetu> {

    @Override
    protected Class<C_Seibetu> returnType() {
        return C_Seibetu.class;
    }

    @Override
    protected C_Seibetu valueOf(String pValue) {
        return C_Seibetu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Seibetu pValue) {
        return pValue.getValue();
    }
}
