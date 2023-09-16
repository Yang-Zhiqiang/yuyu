package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_YykidouuktkKbn;

/**
 * {@link C_YykidouuktkKbn 予約異動受付区分} の Hibernate ユーザー定義型です。<br />
 * 予約異動受付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_YykidouuktkKbn extends AbstractUserType<C_YykidouuktkKbn> {

    @Override
    protected Class<C_YykidouuktkKbn> returnType() {
        return C_YykidouuktkKbn.class;
    }

    @Override
    protected C_YykidouuktkKbn valueOf(String pValue) {
        return C_YykidouuktkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_YykidouuktkKbn pValue) {
        return pValue.getValue();
    }
}
