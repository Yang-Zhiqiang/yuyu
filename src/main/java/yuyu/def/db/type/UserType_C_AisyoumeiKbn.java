package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AisyoumeiKbn;

/**
 * {@link C_AisyoumeiKbn 愛称名区分} の Hibernate ユーザー定義型です。<br />
 * 愛称名区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AisyoumeiKbn extends AbstractUserType<C_AisyoumeiKbn> {

    @Override
    protected Class<C_AisyoumeiKbn> returnType() {
        return C_AisyoumeiKbn.class;
    }

    @Override
    protected C_AisyoumeiKbn valueOf(String pValue) {
        return C_AisyoumeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AisyoumeiKbn pValue) {
        return pValue.getValue();
    }
}
