package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YakuwariKbn;

/**
 * {@link C_YakuwariKbn 役割区分} の Hibernate ユーザー定義型です。<br />
 * 役割区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YakuwariKbn extends AbstractUserType<C_YakuwariKbn> {

    @Override
    protected Class<C_YakuwariKbn> returnType() {
        return C_YakuwariKbn.class;
    }

    @Override
    protected C_YakuwariKbn valueOf(String pValue) {
        return C_YakuwariKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YakuwariKbn pValue) {
        return pValue.getValue();
    }
}
