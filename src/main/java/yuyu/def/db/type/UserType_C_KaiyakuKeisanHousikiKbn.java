package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KaiyakuKeisanHousikiKbn;

/**
 * {@link C_KaiyakuKeisanHousikiKbn 解約計算方式区分} の Hibernate ユーザー定義型です。<br />
 * 解約計算方式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KaiyakuKeisanHousikiKbn extends AbstractUserType<C_KaiyakuKeisanHousikiKbn> {

    @Override
    protected Class<C_KaiyakuKeisanHousikiKbn> returnType() {
        return C_KaiyakuKeisanHousikiKbn.class;
    }

    @Override
    protected C_KaiyakuKeisanHousikiKbn valueOf(String pValue) {
        return C_KaiyakuKeisanHousikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KaiyakuKeisanHousikiKbn pValue) {
        return pValue.getValue();
    }
}
