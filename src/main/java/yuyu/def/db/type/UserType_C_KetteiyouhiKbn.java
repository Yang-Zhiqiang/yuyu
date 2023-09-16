package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KetteiyouhiKbn;

/**
 * {@link C_KetteiyouhiKbn 決定要否区分} の Hibernate ユーザー定義型です。<br />
 * 決定要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KetteiyouhiKbn extends AbstractUserType<C_KetteiyouhiKbn> {

    @Override
    protected Class<C_KetteiyouhiKbn> returnType() {
        return C_KetteiyouhiKbn.class;
    }

    @Override
    protected C_KetteiyouhiKbn valueOf(String pValue) {
        return C_KetteiyouhiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KetteiyouhiKbn pValue) {
        return pValue.getValue();
    }
}
