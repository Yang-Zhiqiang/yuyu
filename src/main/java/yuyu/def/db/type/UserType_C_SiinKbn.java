package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SiinKbn;

/**
 * {@link C_SiinKbn 死因区分} の Hibernate ユーザー定義型です。<br />
 * 死因区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SiinKbn extends AbstractUserType<C_SiinKbn> {

    @Override
    protected Class<C_SiinKbn> returnType() {
        return C_SiinKbn.class;
    }

    @Override
    protected C_SiinKbn valueOf(String pValue) {
        return C_SiinKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SiinKbn pValue) {
        return pValue.getValue();
    }
}
