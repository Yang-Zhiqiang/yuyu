package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HtysyoruiumuKbn;

/**
 * {@link C_HtysyoruiumuKbn 必要書類有無区分} の Hibernate ユーザー定義型です。<br />
 * 必要書類有無区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HtysyoruiumuKbn extends AbstractUserType<C_HtysyoruiumuKbn> {

    @Override
    protected Class<C_HtysyoruiumuKbn> returnType() {
        return C_HtysyoruiumuKbn.class;
    }

    @Override
    protected C_HtysyoruiumuKbn valueOf(String pValue) {
        return C_HtysyoruiumuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HtysyoruiumuKbn pValue) {
        return pValue.getValue();
    }
}
