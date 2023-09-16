package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AuthorissnKbn;

/**
 * {@link C_AuthorissnKbn オーソリ送信区分} の Hibernate ユーザー定義型です。<br />
 * オーソリ送信区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AuthorissnKbn extends AbstractUserType<C_AuthorissnKbn> {

    @Override
    protected Class<C_AuthorissnKbn> returnType() {
        return C_AuthorissnKbn.class;
    }

    @Override
    protected C_AuthorissnKbn valueOf(String pValue) {
        return C_AuthorissnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AuthorissnKbn pValue) {
        return pValue.getValue();
    }
}
