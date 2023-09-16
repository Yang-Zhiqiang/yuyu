package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Syorikngn;

/**
 * {@link C_Syorikngn 処理権限区分} の Hibernate ユーザー定義型です。<br />
 * 処理権限区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Syorikngn extends AbstractUserType<C_Syorikngn> {

    @Override
    protected Class<C_Syorikngn> returnType() {
        return C_Syorikngn.class;
    }

    @Override
    protected C_Syorikngn valueOf(String pValue) {
        return C_Syorikngn.valueOf(pValue);
    }

    @Override
    protected String toString(C_Syorikngn pValue) {
        return pValue.getValue();
    }
}
