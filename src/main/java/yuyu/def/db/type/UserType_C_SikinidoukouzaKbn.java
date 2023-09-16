package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SikinidoukouzaKbn;

/**
 * {@link C_SikinidoukouzaKbn 資金移動口座区分} の Hibernate ユーザー定義型です。<br />
 * 資金移動口座区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SikinidoukouzaKbn extends AbstractUserType<C_SikinidoukouzaKbn> {

    @Override
    protected Class<C_SikinidoukouzaKbn> returnType() {
        return C_SikinidoukouzaKbn.class;
    }

    @Override
    protected C_SikinidoukouzaKbn valueOf(String pValue) {
        return C_SikinidoukouzaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SikinidoukouzaKbn pValue) {
        return pValue.getValue();
    }
}
