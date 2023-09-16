package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ByoumeiGaitouKbn1;

/**
 * {@link C_ByoumeiGaitouKbn1 病名該当区分１} の Hibernate ユーザー定義型です。<br />
 * 病名該当区分１ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ByoumeiGaitouKbn1 extends AbstractUserType<C_ByoumeiGaitouKbn1> {

    @Override
    protected Class<C_ByoumeiGaitouKbn1> returnType() {
        return C_ByoumeiGaitouKbn1.class;
    }

    @Override
    protected C_ByoumeiGaitouKbn1 valueOf(String pValue) {
        return C_ByoumeiGaitouKbn1.valueOf(pValue);
    }

    @Override
    protected String toString(C_ByoumeiGaitouKbn1 pValue) {
        return pValue.getValue();
    }
}
