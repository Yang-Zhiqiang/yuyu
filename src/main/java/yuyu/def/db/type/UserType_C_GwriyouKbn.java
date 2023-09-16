package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_GwriyouKbn;

/**
 * {@link C_GwriyouKbn ＧＷ利用区分} の Hibernate ユーザー定義型です。<br />
 * ＧＷ利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_GwriyouKbn extends AbstractUserType<C_GwriyouKbn> {

    @Override
    protected Class<C_GwriyouKbn> returnType() {
        return C_GwriyouKbn.class;
    }

    @Override
    protected C_GwriyouKbn valueOf(String pValue) {
        return C_GwriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_GwriyouKbn pValue) {
        return pValue.getValue();
    }
}
