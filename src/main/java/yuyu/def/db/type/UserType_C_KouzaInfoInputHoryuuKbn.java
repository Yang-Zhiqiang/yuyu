package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouzaInfoInputHoryuuKbn;

/**
 * {@link C_KouzaInfoInputHoryuuKbn 口座情報入力保留区分} の Hibernate ユーザー定義型です。<br />
 * 口座情報入力保留区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouzaInfoInputHoryuuKbn extends AbstractUserType<C_KouzaInfoInputHoryuuKbn> {

    @Override
    protected Class<C_KouzaInfoInputHoryuuKbn> returnType() {
        return C_KouzaInfoInputHoryuuKbn.class;
    }

    @Override
    protected C_KouzaInfoInputHoryuuKbn valueOf(String pValue) {
        return C_KouzaInfoInputHoryuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouzaInfoInputHoryuuKbn pValue) {
        return pValue.getValue();
    }
}
