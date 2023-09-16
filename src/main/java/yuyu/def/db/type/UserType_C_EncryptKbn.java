package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_EncryptKbn;

/**
 * {@link C_EncryptKbn 暗号化区分} の Hibernate ユーザー定義型です。<br />
 * 暗号化区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_EncryptKbn extends AbstractUserType<C_EncryptKbn> {

    @Override
    protected Class<C_EncryptKbn> returnType() {
        return C_EncryptKbn.class;
    }

    @Override
    protected C_EncryptKbn valueOf(String pValue) {
        return C_EncryptKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_EncryptKbn pValue) {
        return pValue.getValue();
    }
}
