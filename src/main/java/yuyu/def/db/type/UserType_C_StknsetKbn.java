package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StknsetKbn;

/**
 * {@link C_StknsetKbn 質権設定区分} の Hibernate ユーザー定義型です。<br />
 * 質権設定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StknsetKbn extends AbstractUserType<C_StknsetKbn> {

    @Override
    protected Class<C_StknsetKbn> returnType() {
        return C_StknsetKbn.class;
    }

    @Override
    protected C_StknsetKbn valueOf(String pValue) {
        return C_StknsetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StknsetKbn pValue) {
        return pValue.getValue();
    }
}
