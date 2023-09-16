package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_AngoukaHousikiKbn;

/**
 * {@link C_AngoukaHousikiKbn 暗号化方式区分} の Hibernate ユーザー定義型です。<br />
 * 暗号化方式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_AngoukaHousikiKbn extends AbstractUserType<C_AngoukaHousikiKbn> {

    @Override
    protected Class<C_AngoukaHousikiKbn> returnType() {
        return C_AngoukaHousikiKbn.class;
    }

    @Override
    protected C_AngoukaHousikiKbn valueOf(String pValue) {
        return C_AngoukaHousikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_AngoukaHousikiKbn pValue) {
        return pValue.getValue();
    }
}
