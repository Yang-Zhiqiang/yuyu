package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SosysaiyouhiKbn;

/**
 * {@link C_SosysaiyouhiKbn 証書再発行要否区分} の Hibernate ユーザー定義型です。<br />
 * 証書再発行要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SosysaiyouhiKbn extends AbstractUserType<C_SosysaiyouhiKbn> {

    @Override
    protected Class<C_SosysaiyouhiKbn> returnType() {
        return C_SosysaiyouhiKbn.class;
    }

    @Override
    protected C_SosysaiyouhiKbn valueOf(String pValue) {
        return C_SosysaiyouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SosysaiyouhiKbn pValue) {
        return pValue.getValue();
    }
}
