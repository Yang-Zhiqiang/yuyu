package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Seikyuujiyuu;

/**
 * {@link C_Seikyuujiyuu 請求事由} の Hibernate ユーザー定義型です。<br />
 * 請求事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Seikyuujiyuu extends AbstractUserType<C_Seikyuujiyuu> {

    @Override
    protected Class<C_Seikyuujiyuu> returnType() {
        return C_Seikyuujiyuu.class;
    }

    @Override
    protected C_Seikyuujiyuu valueOf(String pValue) {
        return C_Seikyuujiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Seikyuujiyuu pValue) {
        return pValue.getValue();
    }
}
