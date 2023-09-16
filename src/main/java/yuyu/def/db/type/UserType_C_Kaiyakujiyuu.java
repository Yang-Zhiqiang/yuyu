package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kaiyakujiyuu;

/**
 * {@link C_Kaiyakujiyuu 解約事由} の Hibernate ユーザー定義型です。<br />
 * 解約事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kaiyakujiyuu extends AbstractUserType<C_Kaiyakujiyuu> {

    @Override
    protected Class<C_Kaiyakujiyuu> returnType() {
        return C_Kaiyakujiyuu.class;
    }

    @Override
    protected C_Kaiyakujiyuu valueOf(String pValue) {
        return C_Kaiyakujiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kaiyakujiyuu pValue) {
        return pValue.getValue();
    }
}
