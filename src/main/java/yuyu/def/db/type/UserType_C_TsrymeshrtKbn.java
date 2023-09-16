package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrymeshrtKbn;

/**
 * {@link C_TsrymeshrtKbn 手数料明細配列区分} の Hibernate ユーザー定義型です。<br />
 * 手数料明細配列区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrymeshrtKbn extends AbstractUserType<C_TsrymeshrtKbn> {

    @Override
    protected Class<C_TsrymeshrtKbn> returnType() {
        return C_TsrymeshrtKbn.class;
    }

    @Override
    protected C_TsrymeshrtKbn valueOf(String pValue) {
        return C_TsrymeshrtKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrymeshrtKbn pValue) {
        return pValue.getValue();
    }
}
