package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MqConnectionControlKbn;

/**
 * {@link C_MqConnectionControlKbn ＭＱコネクション制御区分} の Hibernate ユーザー定義型です。<br />
 * ＭＱコネクション制御区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MqConnectionControlKbn extends AbstractUserType<C_MqConnectionControlKbn> {

    @Override
    protected Class<C_MqConnectionControlKbn> returnType() {
        return C_MqConnectionControlKbn.class;
    }

    @Override
    protected C_MqConnectionControlKbn valueOf(String pValue) {
        return C_MqConnectionControlKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MqConnectionControlKbn pValue) {
        return pValue.getValue();
    }
}
