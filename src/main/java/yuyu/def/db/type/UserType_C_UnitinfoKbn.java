package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_UnitinfoKbn;

/**
 * {@link C_UnitinfoKbn ユニット情報区分} の Hibernate ユーザー定義型です。<br />
 * ユニット情報区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_UnitinfoKbn extends AbstractUserType<C_UnitinfoKbn> {

    @Override
    protected Class<C_UnitinfoKbn> returnType() {
        return C_UnitinfoKbn.class;
    }

    @Override
    protected C_UnitinfoKbn valueOf(String pValue) {
        return C_UnitinfoKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_UnitinfoKbn pValue) {
        return pValue.getValue();
    }
}
