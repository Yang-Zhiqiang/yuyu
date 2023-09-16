package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinidouJtKbn;

/**
 * {@link C_SikinidouJtKbn 資金移動状態区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動状態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinidouJtKbn extends AbstractUserType<C_SikinidouJtKbn> {

    @Override
    protected Class<C_SikinidouJtKbn> returnType() {
        return C_SikinidouJtKbn.class;
    }

    @Override
    protected C_SikinidouJtKbn valueOf(String pValue) {
        return C_SikinidouJtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinidouJtKbn pValue) {
        return pValue.getValue();
    }
}
