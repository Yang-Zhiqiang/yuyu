package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hhknadrhnkjiyuu;

/**
 * {@link C_Hhknadrhnkjiyuu 被保険者住所変更事由} の Hibernate ユーザー定義型です。<br />
 * 被保険者住所変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hhknadrhnkjiyuu extends AbstractUserType<C_Hhknadrhnkjiyuu> {

    @Override
    protected Class<C_Hhknadrhnkjiyuu> returnType() {
        return C_Hhknadrhnkjiyuu.class;
    }

    @Override
    protected C_Hhknadrhnkjiyuu valueOf(String pValue) {
        return C_Hhknadrhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hhknadrhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
