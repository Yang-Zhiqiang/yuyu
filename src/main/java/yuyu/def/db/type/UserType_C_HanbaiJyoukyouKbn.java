package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HanbaiJyoukyouKbn;

/**
 * {@link C_HanbaiJyoukyouKbn 販売状況区分} の Hibernate ユーザー定義型です。<br />
 * 販売状況区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HanbaiJyoukyouKbn extends AbstractUserType<C_HanbaiJyoukyouKbn> {

    @Override
    protected Class<C_HanbaiJyoukyouKbn> returnType() {
        return C_HanbaiJyoukyouKbn.class;
    }

    @Override
    protected C_HanbaiJyoukyouKbn valueOf(String pValue) {
        return C_HanbaiJyoukyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HanbaiJyoukyouKbn pValue) {
        return pValue.getValue();
    }
}
