package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TtdkIsihyouziKbn;

/**
 * {@link C_TtdkIsihyouziKbn 手続意思表示区分} の Hibernate ユーザー定義型です。<br />
 * 手続意思表示区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TtdkIsihyouziKbn extends AbstractUserType<C_TtdkIsihyouziKbn> {

    @Override
    protected Class<C_TtdkIsihyouziKbn> returnType() {
        return C_TtdkIsihyouziKbn.class;
    }

    @Override
    protected C_TtdkIsihyouziKbn valueOf(String pValue) {
        return C_TtdkIsihyouziKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TtdkIsihyouziKbn pValue) {
        return pValue.getValue();
    }
}
