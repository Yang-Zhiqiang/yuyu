package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinidouPKbn;

/**
 * {@link C_SikinidouPKbn 資金移動用保険料区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動用保険料区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinidouPKbn extends AbstractUserType<C_SikinidouPKbn> {

    @Override
    protected Class<C_SikinidouPKbn> returnType() {
        return C_SikinidouPKbn.class;
    }

    @Override
    protected C_SikinidouPKbn valueOf(String pValue) {
        return C_SikinidouPKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinidouPKbn pValue) {
        return pValue.getValue();
    }
}
