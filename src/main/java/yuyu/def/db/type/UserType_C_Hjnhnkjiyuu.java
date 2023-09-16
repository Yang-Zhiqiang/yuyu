package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hjnhnkjiyuu;

/**
 * {@link C_Hjnhnkjiyuu 法人代表者変更事由} の Hibernate ユーザー定義型です。<br />
 * 法人代表者変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hjnhnkjiyuu extends AbstractUserType<C_Hjnhnkjiyuu> {

    @Override
    protected Class<C_Hjnhnkjiyuu> returnType() {
        return C_Hjnhnkjiyuu.class;
    }

    @Override
    protected C_Hjnhnkjiyuu valueOf(String pValue) {
        return C_Hjnhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hjnhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
