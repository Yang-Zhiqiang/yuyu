package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KeiukeDouKbn;

/**
 * {@link C_KeiukeDouKbn 契受同一区分} の Hibernate ユーザー定義型です。<br />
 * 契受同一区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KeiukeDouKbn extends AbstractUserType<C_KeiukeDouKbn> {

    @Override
    protected Class<C_KeiukeDouKbn> returnType() {
        return C_KeiukeDouKbn.class;
    }

    @Override
    protected C_KeiukeDouKbn valueOf(String pValue) {
        return C_KeiukeDouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KeiukeDouKbn pValue) {
        return pValue.getValue();
    }
}
