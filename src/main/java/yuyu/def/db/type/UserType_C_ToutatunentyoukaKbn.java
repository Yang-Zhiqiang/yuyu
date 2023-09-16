package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ToutatunentyoukaKbn;

/**
 * {@link C_ToutatunentyoukaKbn 最終到達年齢超過区分} の Hibernate ユーザー定義型です。<br />
 * 最終到達年齢超過区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ToutatunentyoukaKbn extends AbstractUserType<C_ToutatunentyoukaKbn> {

    @Override
    protected Class<C_ToutatunentyoukaKbn> returnType() {
        return C_ToutatunentyoukaKbn.class;
    }

    @Override
    protected C_ToutatunentyoukaKbn valueOf(String pValue) {
        return C_ToutatunentyoukaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ToutatunentyoukaKbn pValue) {
        return pValue.getValue();
    }
}
