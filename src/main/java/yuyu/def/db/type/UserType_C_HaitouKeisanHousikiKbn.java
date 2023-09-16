package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HaitouKeisanHousikiKbn;

/**
 * {@link C_HaitouKeisanHousikiKbn 配当計算方式区分} の Hibernate ユーザー定義型です。<br />
 * 配当計算方式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HaitouKeisanHousikiKbn extends AbstractUserType<C_HaitouKeisanHousikiKbn> {

    @Override
    protected Class<C_HaitouKeisanHousikiKbn> returnType() {
        return C_HaitouKeisanHousikiKbn.class;
    }

    @Override
    protected C_HaitouKeisanHousikiKbn valueOf(String pValue) {
        return C_HaitouKeisanHousikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HaitouKeisanHousikiKbn pValue) {
        return pValue.getValue();
    }
}
