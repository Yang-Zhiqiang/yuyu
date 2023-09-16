package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKinouidKbn;

/**
 * {@link C_DsKinouidKbn ＤＳ機能ＩＤ区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ機能ＩＤ区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKinouidKbn extends AbstractUserType<C_DsKinouidKbn> {

    @Override
    protected Class<C_DsKinouidKbn> returnType() {
        return C_DsKinouidKbn.class;
    }

    @Override
    protected C_DsKinouidKbn valueOf(String pValue) {
        return C_DsKinouidKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKinouidKbn pValue) {
        return pValue.getValue();
    }
}
