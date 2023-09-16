package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SakuintaisyoukykKbn;

/**
 * {@link C_SakuintaisyoukykKbn 索引対象契約区分} の Hibernate ユーザー定義型です。<br />
 * 索引対象契約区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SakuintaisyoukykKbn extends AbstractUserType<C_SakuintaisyoukykKbn> {

    @Override
    protected Class<C_SakuintaisyoukykKbn> returnType() {
        return C_SakuintaisyoukykKbn.class;
    }

    @Override
    protected C_SakuintaisyoukykKbn valueOf(String pValue) {
        return C_SakuintaisyoukykKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SakuintaisyoukykKbn pValue) {
        return pValue.getValue();
    }
}
