package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuintsnKbn;

/**
 * {@link C_SakuintsnKbn 索引通算区分} の Hibernate ユーザー定義型です。<br />
 * 索引通算区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuintsnKbn extends AbstractUserType<C_SakuintsnKbn> {

    @Override
    protected Class<C_SakuintsnKbn> returnType() {
        return C_SakuintsnKbn.class;
    }

    @Override
    protected C_SakuintsnKbn valueOf(String pValue) {
        return C_SakuintsnKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuintsnKbn pValue) {
        return pValue.getValue();
    }
}
