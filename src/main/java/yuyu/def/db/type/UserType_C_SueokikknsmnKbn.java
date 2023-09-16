package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SueokikknsmnKbn;

/**
 * {@link C_SueokikknsmnKbn 据置期間歳満期区分} の Hibernate ユーザー定義型です。<br />
 * 据置期間歳満期区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SueokikknsmnKbn extends AbstractUserType<C_SueokikknsmnKbn> {

    @Override
    protected Class<C_SueokikknsmnKbn> returnType() {
        return C_SueokikknsmnKbn.class;
    }

    @Override
    protected C_SueokikknsmnKbn valueOf(String pValue) {
        return C_SueokikknsmnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SueokikknsmnKbn pValue) {
        return pValue.getValue();
    }
}
