package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HukusuusyouhnumuKbn;

/**
 * {@link C_HukusuusyouhnumuKbn 複数商品有無区分} の Hibernate ユーザー定義型です。<br />
 * 複数商品有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HukusuusyouhnumuKbn extends AbstractUserType<C_HukusuusyouhnumuKbn> {

    @Override
    protected Class<C_HukusuusyouhnumuKbn> returnType() {
        return C_HukusuusyouhnumuKbn.class;
    }

    @Override
    protected C_HukusuusyouhnumuKbn valueOf(String pValue) {
        return C_HukusuusyouhnumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HukusuusyouhnumuKbn pValue) {
        return pValue.getValue();
    }
}
