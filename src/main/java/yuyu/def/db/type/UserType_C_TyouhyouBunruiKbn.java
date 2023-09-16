package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TyouhyouBunruiKbn;

/**
 * {@link C_TyouhyouBunruiKbn 帳票分類区分} の Hibernate ユーザー定義型です。<br />
 * 帳票分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TyouhyouBunruiKbn extends AbstractUserType<C_TyouhyouBunruiKbn> {

    @Override
    protected Class<C_TyouhyouBunruiKbn> returnType() {
        return C_TyouhyouBunruiKbn.class;
    }

    @Override
    protected C_TyouhyouBunruiKbn valueOf(String pValue) {
        return C_TyouhyouBunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TyouhyouBunruiKbn pValue) {
        return pValue.getValue();
    }
}
