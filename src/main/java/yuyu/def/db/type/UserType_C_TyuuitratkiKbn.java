package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyuuitratkiKbn;

/**
 * {@link C_TyuuitratkiKbn 注意取扱区分} の Hibernate ユーザー定義型です。<br />
 * 注意取扱区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyuuitratkiKbn extends AbstractUserType<C_TyuuitratkiKbn> {

    @Override
    protected Class<C_TyuuitratkiKbn> returnType() {
        return C_TyuuitratkiKbn.class;
    }

    @Override
    protected C_TyuuitratkiKbn valueOf(String pValue) {
        return C_TyuuitratkiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyuuitratkiKbn pValue) {
        return pValue.getValue();
    }
}
