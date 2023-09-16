package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsytsyoruiKbn;

/**
 * {@link C_TsytsyoruiKbn 提出書類区分} の Hibernate ユーザー定義型です。<br />
 * 提出書類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsytsyoruiKbn extends AbstractUserType<C_TsytsyoruiKbn> {

    @Override
    protected Class<C_TsytsyoruiKbn> returnType() {
        return C_TsytsyoruiKbn.class;
    }

    @Override
    protected C_TsytsyoruiKbn valueOf(String pValue) {
        return C_TsytsyoruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsytsyoruiKbn pValue) {
        return pValue.getValue();
    }
}
