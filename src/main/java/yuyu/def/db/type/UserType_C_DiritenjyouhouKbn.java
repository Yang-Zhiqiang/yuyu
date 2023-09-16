package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DiritenjyouhouKbn;

/**
 * {@link C_DiritenjyouhouKbn 代理店情報区分} の Hibernate ユーザー定義型です。<br />
 * 代理店情報区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DiritenjyouhouKbn extends AbstractUserType<C_DiritenjyouhouKbn> {

    @Override
    protected Class<C_DiritenjyouhouKbn> returnType() {
        return C_DiritenjyouhouKbn.class;
    }

    @Override
    protected C_DiritenjyouhouKbn valueOf(String pValue) {
        return C_DiritenjyouhouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DiritenjyouhouKbn pValue) {
        return pValue.getValue();
    }
}
