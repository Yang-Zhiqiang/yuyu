package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kkukthnkjiyuu;

/**
 * {@link C_Kkukthnkjiyuu 契約管理受取人変更事由} の Hibernate ユーザー定義型です。<br />
 * 契約管理受取人変更事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kkukthnkjiyuu extends AbstractUserType<C_Kkukthnkjiyuu> {

    @Override
    protected Class<C_Kkukthnkjiyuu> returnType() {
        return C_Kkukthnkjiyuu.class;
    }

    @Override
    protected C_Kkukthnkjiyuu valueOf(String pValue) {
        return C_Kkukthnkjiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kkukthnkjiyuu pValue) {
        return pValue.getValue();
    }
}
