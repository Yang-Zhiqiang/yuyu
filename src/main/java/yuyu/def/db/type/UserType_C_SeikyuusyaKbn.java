package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeikyuusyaKbn;

/**
 * {@link C_SeikyuusyaKbn 請求者区分} の Hibernate ユーザー定義型です。<br />
 * 請求者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeikyuusyaKbn extends AbstractUserType<C_SeikyuusyaKbn> {

    @Override
    protected Class<C_SeikyuusyaKbn> returnType() {
        return C_SeikyuusyaKbn.class;
    }

    @Override
    protected C_SeikyuusyaKbn valueOf(String pValue) {
        return C_SeikyuusyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeikyuusyaKbn pValue) {
        return pValue.getValue();
    }
}
