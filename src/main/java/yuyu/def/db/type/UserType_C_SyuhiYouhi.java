package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyuhiYouhi;

/**
 * {@link C_SyuhiYouhi 守秘要否} の Hibernate ユーザー定義型です。<br />
 * 守秘要否 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyuhiYouhi extends AbstractUserType<C_SyuhiYouhi> {

    @Override
    protected Class<C_SyuhiYouhi> returnType() {
        return C_SyuhiYouhi.class;
    }

    @Override
    protected C_SyuhiYouhi valueOf(String pValue) {
        return C_SyuhiYouhi.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyuhiYouhi pValue) {
        return pValue.getValue();
    }
}
