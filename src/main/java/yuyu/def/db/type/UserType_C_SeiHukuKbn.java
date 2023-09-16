package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SeiHukuKbn;

/**
 * {@link C_SeiHukuKbn 正副区分} の Hibernate ユーザー定義型です。<br />
 * 正副区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SeiHukuKbn extends AbstractUserType<C_SeiHukuKbn> {

    @Override
    protected Class<C_SeiHukuKbn> returnType() {
        return C_SeiHukuKbn.class;
    }

    @Override
    protected C_SeiHukuKbn valueOf(String pValue) {
        return C_SeiHukuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SeiHukuKbn pValue) {
        return pValue.getValue();
    }
}
