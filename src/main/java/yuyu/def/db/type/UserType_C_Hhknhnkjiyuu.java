package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Hhknhnkjiyuu;

/**
 * {@link C_Hhknhnkjiyuu 被保険者変更事由} の Hibernate ユーザー定義型です。<br />
 * 被保険者変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Hhknhnkjiyuu extends AbstractUserType<C_Hhknhnkjiyuu> {

    @Override
    protected Class<C_Hhknhnkjiyuu> returnType() {
        return C_Hhknhnkjiyuu.class;
    }

    @Override
    protected C_Hhknhnkjiyuu valueOf(String pValue) {
        return C_Hhknhnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Hhknhnkjiyuu pValue) {
        return pValue.getValue();
    }
}
