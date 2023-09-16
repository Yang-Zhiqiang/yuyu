package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IwfSyoriKbn;

/**
 * {@link C_IwfSyoriKbn Iwf処理区分} の Hibernate ユーザー定義型です。<br />
 * Iwf処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IwfSyoriKbn extends AbstractUserType<C_IwfSyoriKbn> {

    @Override
    protected Class<C_IwfSyoriKbn> returnType() {
        return C_IwfSyoriKbn.class;
    }

    @Override
    protected C_IwfSyoriKbn valueOf(String pValue) {
        return C_IwfSyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IwfSyoriKbn pValue) {
        return pValue.getValue();
    }
}
