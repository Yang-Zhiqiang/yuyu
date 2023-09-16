package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kykadrhnkjiyuu;

/**
 * {@link C_Kykadrhnkjiyuu 契約者住所変更事由} の Hibernate ユーザー定義型です。<br />
 * 契約者住所変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kykadrhnkjiyuu extends AbstractUserType<C_Kykadrhnkjiyuu> {

    @Override
    protected Class<C_Kykadrhnkjiyuu> returnType() {
        return C_Kykadrhnkjiyuu.class;
    }

    @Override
    protected C_Kykadrhnkjiyuu valueOf(String pValue) {
        return C_Kykadrhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kykadrhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
