package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuintsnTaisyouKbn;

/**
 * {@link C_SakuintsnTaisyouKbn 索引通算対象者区分} の Hibernate ユーザー定義型です。<br />
 * 索引通算対象者区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuintsnTaisyouKbn extends AbstractUserType<C_SakuintsnTaisyouKbn> {

    @Override
    protected Class<C_SakuintsnTaisyouKbn> returnType() {
        return C_SakuintsnTaisyouKbn.class;
    }

    @Override
    protected C_SakuintsnTaisyouKbn valueOf(String pValue) {
        return C_SakuintsnTaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuintsnTaisyouKbn pValue) {
        return pValue.getValue();
    }
}
