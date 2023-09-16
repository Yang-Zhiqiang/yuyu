package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GwmodeKbn;

/**
 * {@link C_GwmodeKbn ＧＷモード区分} の Hibernate ユーザー定義型です。<br />
 * ＧＷモード区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GwmodeKbn extends AbstractUserType<C_GwmodeKbn> {

    @Override
    protected Class<C_GwmodeKbn> returnType() {
        return C_GwmodeKbn.class;
    }

    @Override
    protected C_GwmodeKbn valueOf(String pValue) {
        return C_GwmodeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GwmodeKbn pValue) {
        return pValue.getValue();
    }
}
