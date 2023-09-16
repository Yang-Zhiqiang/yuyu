package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KessantyouseiKbn;

/**
 * {@link C_KessantyouseiKbn 決算調整区分} の Hibernate ユーザー定義型です。<br />
 * 決算調整区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KessantyouseiKbn extends AbstractUserType<C_KessantyouseiKbn> {

    @Override
    protected Class<C_KessantyouseiKbn> returnType() {
        return C_KessantyouseiKbn.class;
    }

    @Override
    protected C_KessantyouseiKbn valueOf(String pValue) {
        return C_KessantyouseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KessantyouseiKbn pValue) {
        return pValue.getValue();
    }
}
