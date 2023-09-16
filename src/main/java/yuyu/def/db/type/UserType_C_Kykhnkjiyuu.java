package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kykhnkjiyuu;

/**
 * {@link C_Kykhnkjiyuu 契約者変更事由} の Hibernate ユーザー定義型です。<br />
 * 契約者変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kykhnkjiyuu extends AbstractUserType<C_Kykhnkjiyuu> {

    @Override
    protected Class<C_Kykhnkjiyuu> returnType() {
        return C_Kykhnkjiyuu.class;
    }

    @Override
    protected C_Kykhnkjiyuu valueOf(String pValue) {
        return C_Kykhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kykhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
