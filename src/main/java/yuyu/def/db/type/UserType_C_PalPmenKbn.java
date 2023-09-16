package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalPmenKbn;

/**
 * {@link C_PalPmenKbn ＰＡＬＰ免区分} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬＰ免区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalPmenKbn extends AbstractUserType<C_PalPmenKbn> {

    @Override
    protected Class<C_PalPmenKbn> returnType() {
        return C_PalPmenKbn.class;
    }

    @Override
    protected C_PalPmenKbn valueOf(String pValue) {
        return C_PalPmenKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalPmenKbn pValue) {
        return pValue.getValue();
    }
}
