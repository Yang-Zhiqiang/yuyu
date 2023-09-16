package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AapKbn;

/**
 * {@link C_AapKbn ＡＡＰ区分} の Hibernate ユーザー定義型です。<br />
 * ＡＡＰ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AapKbn extends AbstractUserType<C_AapKbn> {

    @Override
    protected Class<C_AapKbn> returnType() {
        return C_AapKbn.class;
    }

    @Override
    protected C_AapKbn valueOf(String pValue) {
        return C_AapKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AapKbn pValue) {
        return pValue.getValue();
    }
}
