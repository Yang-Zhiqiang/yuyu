package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitouSyoyougakuKeisanKbn;

/**
 * {@link C_HaitouSyoyougakuKeisanKbn 配当所要額計算区分} の Hibernate ユーザー定義型です。<br />
 * 配当所要額計算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitouSyoyougakuKeisanKbn extends AbstractUserType<C_HaitouSyoyougakuKeisanKbn> {

    @Override
    protected Class<C_HaitouSyoyougakuKeisanKbn> returnType() {
        return C_HaitouSyoyougakuKeisanKbn.class;
    }

    @Override
    protected C_HaitouSyoyougakuKeisanKbn valueOf(String pValue) {
        return C_HaitouSyoyougakuKeisanKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitouSyoyougakuKeisanKbn pValue) {
        return pValue.getValue();
    }
}
