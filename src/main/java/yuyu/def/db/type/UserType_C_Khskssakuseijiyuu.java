package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Khskssakuseijiyuu;

/**
 * {@link C_Khskssakuseijiyuu 契約保全請求書作成事由} の Hibernate ユーザー定義型です。<br />
 * 契約保全請求書作成事由 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Khskssakuseijiyuu extends AbstractUserType<C_Khskssakuseijiyuu> {

    @Override
    protected Class<C_Khskssakuseijiyuu> returnType() {
        return C_Khskssakuseijiyuu.class;
    }

    @Override
    protected C_Khskssakuseijiyuu valueOf(String pValue) {
        return C_Khskssakuseijiyuu.valueOf(pValue);
    }

    @Override
    protected String toString(C_Khskssakuseijiyuu pValue) {
        return pValue.getValue();
    }
}
