package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HknkknBunruiKbn;

/**
 * {@link C_HknkknBunruiKbn 保険期間分類区分} の Hibernate ユーザー定義型です。<br />
 * 保険期間分類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HknkknBunruiKbn extends AbstractUserType<C_HknkknBunruiKbn> {

    @Override
    protected Class<C_HknkknBunruiKbn> returnType() {
        return C_HknkknBunruiKbn.class;
    }

    @Override
    protected C_HknkknBunruiKbn valueOf(String pValue) {
        return C_HknkknBunruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HknkknBunruiKbn pValue) {
        return pValue.getValue();
    }
}
