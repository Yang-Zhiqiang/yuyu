package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyouhnModelKbn;

/**
 * {@link C_SyouhnModelKbn 商品モデル区分} の Hibernate ユーザー定義型です。<br />
 * 商品モデル区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyouhnModelKbn extends AbstractUserType<C_SyouhnModelKbn> {

    @Override
    protected Class<C_SyouhnModelKbn> returnType() {
        return C_SyouhnModelKbn.class;
    }

    @Override
    protected C_SyouhnModelKbn valueOf(String pValue) {
        return C_SyouhnModelKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyouhnModelKbn pValue) {
        return pValue.getValue();
    }
}
