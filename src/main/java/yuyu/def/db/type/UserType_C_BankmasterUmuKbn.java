package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BankmasterUmuKbn;

/**
 * {@link C_BankmasterUmuKbn 銀行マスタ有無区分} の Hibernate ユーザー定義型です。<br />
 * 銀行マスタ有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BankmasterUmuKbn extends AbstractUserType<C_BankmasterUmuKbn> {

    @Override
    protected Class<C_BankmasterUmuKbn> returnType() {
        return C_BankmasterUmuKbn.class;
    }

    @Override
    protected C_BankmasterUmuKbn valueOf(String pValue) {
        return C_BankmasterUmuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BankmasterUmuKbn pValue) {
        return pValue.getValue();
    }
}
