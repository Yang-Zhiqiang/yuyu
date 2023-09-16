package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Saihoum;

/**
 * {@link C_Saihoum 再保有無} の Hibernate ユーザー定義型です。<br />
 * 再保有無 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Saihoum extends AbstractUserType<C_Saihoum> {

    @Override
    protected Class<C_Saihoum> returnType() {
        return C_Saihoum.class;
    }

    @Override
    protected C_Saihoum valueOf(String pValue) {
        return C_Saihoum.valueOf(pValue);
    }

    @Override
    protected String toString(C_Saihoum pValue) {
        return pValue.getValue();
    }
}
