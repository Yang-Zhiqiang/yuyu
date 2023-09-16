package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JidousateiriyouKbn;

/**
 * {@link C_JidousateiriyouKbn 自動査定利用区分} の Hibernate ユーザー定義型です。<br />
 * 自動査定利用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JidousateiriyouKbn extends AbstractUserType<C_JidousateiriyouKbn> {

    @Override
    protected Class<C_JidousateiriyouKbn> returnType() {
        return C_JidousateiriyouKbn.class;
    }

    @Override
    protected C_JidousateiriyouKbn valueOf(String pValue) {
        return C_JidousateiriyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JidousateiriyouKbn pValue) {
        return pValue.getValue();
    }
}
