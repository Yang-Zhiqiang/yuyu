package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PrttaisyouKbn;

/**
 * {@link C_PrttaisyouKbn 印刷対象区分} の Hibernate ユーザー定義型です。<br />
 * 印刷対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PrttaisyouKbn extends AbstractUserType<C_PrttaisyouKbn> {

    @Override
    protected Class<C_PrttaisyouKbn> returnType() {
        return C_PrttaisyouKbn.class;
    }

    @Override
    protected C_PrttaisyouKbn valueOf(String pValue) {
        return C_PrttaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PrttaisyouKbn pValue) {
        return pValue.getValue();
    }
}
