package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriHaraikataKbn;

/**
 * {@link C_SuuriHaraikataKbn 数理払方区分} の Hibernate ユーザー定義型です。<br />
 * 数理払方区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriHaraikataKbn extends AbstractUserType<C_SuuriHaraikataKbn> {

    @Override
    protected Class<C_SuuriHaraikataKbn> returnType() {
        return C_SuuriHaraikataKbn.class;
    }

    @Override
    protected C_SuuriHaraikataKbn valueOf(String pValue) {
        return C_SuuriHaraikataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriHaraikataKbn pValue) {
        return pValue.getValue();
    }
}
