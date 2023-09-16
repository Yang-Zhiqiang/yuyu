package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UktKyksyaTdk;

/**
 * {@link C_UktKyksyaTdk 受取人契約者続柄} の Hibernate ユーザー定義型です。<br />
 * 受取人契約者続柄 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UktKyksyaTdk extends AbstractUserType<C_UktKyksyaTdk> {

    @Override
    protected Class<C_UktKyksyaTdk> returnType() {
        return C_UktKyksyaTdk.class;
    }

    @Override
    protected C_UktKyksyaTdk valueOf(String pValue) {
        return C_UktKyksyaTdk.valueOf(pValue);
    }

    @Override
    protected String toString(C_UktKyksyaTdk pValue) {
        return pValue.getValue();
    }
}
