package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NayoseYouhi;

/**
 * {@link C_NayoseYouhi 名寄せ要否} の Hibernate ユーザー定義型です。<br />
 * 名寄せ要否 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NayoseYouhi extends AbstractUserType<C_NayoseYouhi> {

    @Override
    protected Class<C_NayoseYouhi> returnType() {
        return C_NayoseYouhi.class;
    }

    @Override
    protected C_NayoseYouhi valueOf(String pValue) {
        return C_NayoseYouhi.valueOf(pValue);
    }

    @Override
    protected String toString(C_NayoseYouhi pValue) {
        return pValue.getValue();
    }
}
