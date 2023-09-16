package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IsatoukeiHokensyuruicd;

/**
 * {@link C_IsatoukeiHokensyuruicd 医査統計用保険種類コード} の Hibernate ユーザー定義型です。<br />
 * 医査統計用保険種類コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IsatoukeiHokensyuruicd extends AbstractUserType<C_IsatoukeiHokensyuruicd> {

    @Override
    protected Class<C_IsatoukeiHokensyuruicd> returnType() {
        return C_IsatoukeiHokensyuruicd.class;
    }

    @Override
    protected C_IsatoukeiHokensyuruicd valueOf(String pValue) {
        return C_IsatoukeiHokensyuruicd.valueOf(pValue);
    }

    @Override
    protected String toString(C_IsatoukeiHokensyuruicd pValue) {
        return pValue.getValue();
    }
}
