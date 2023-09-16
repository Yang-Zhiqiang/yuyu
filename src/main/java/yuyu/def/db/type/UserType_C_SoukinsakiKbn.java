package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SoukinsakiKbn;

/**
 * {@link C_SoukinsakiKbn 送金先区分} の Hibernate ユーザー定義型です。<br />
 * 送金先区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SoukinsakiKbn extends AbstractUserType<C_SoukinsakiKbn> {

    @Override
    protected Class<C_SoukinsakiKbn> returnType() {
        return C_SoukinsakiKbn.class;
    }

    @Override
    protected C_SoukinsakiKbn valueOf(String pValue) {
        return C_SoukinsakiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SoukinsakiKbn pValue) {
        return pValue.getValue();
    }
}
