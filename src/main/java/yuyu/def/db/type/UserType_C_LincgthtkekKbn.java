package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LincgthtkekKbn;

/**
 * {@link C_LincgthtkekKbn ＬＩＮＣ該当判定結果区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ該当判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LincgthtkekKbn extends AbstractUserType<C_LincgthtkekKbn> {

    @Override
    protected Class<C_LincgthtkekKbn> returnType() {
        return C_LincgthtkekKbn.class;
    }

    @Override
    protected C_LincgthtkekKbn valueOf(String pValue) {
        return C_LincgthtkekKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LincgthtkekKbn pValue) {
        return pValue.getValue();
    }
}
