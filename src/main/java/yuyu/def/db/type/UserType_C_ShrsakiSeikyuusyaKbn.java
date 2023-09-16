package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ShrsakiSeikyuusyaKbn;

/**
 * {@link C_ShrsakiSeikyuusyaKbn 支払先請求者区分} の Hibernate ユーザー定義型です。<br />
 * 支払先請求者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ShrsakiSeikyuusyaKbn extends AbstractUserType<C_ShrsakiSeikyuusyaKbn> {

    @Override
    protected Class<C_ShrsakiSeikyuusyaKbn> returnType() {
        return C_ShrsakiSeikyuusyaKbn.class;
    }

    @Override
    protected C_ShrsakiSeikyuusyaKbn valueOf(String pValue) {
        return C_ShrsakiSeikyuusyaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ShrsakiSeikyuusyaKbn pValue) {
        return pValue.getValue();
    }
}
