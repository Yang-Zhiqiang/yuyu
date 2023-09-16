package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ByoumeiGaitouKbn3;

/**
 * {@link C_ByoumeiGaitouKbn3 病名該当区分３} の Hibernate ユーザー定義型です。<br />
 * 病名該当区分３ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ByoumeiGaitouKbn3 extends AbstractUserType<C_ByoumeiGaitouKbn3> {

    @Override
    protected Class<C_ByoumeiGaitouKbn3> returnType() {
        return C_ByoumeiGaitouKbn3.class;
    }

    @Override
    protected C_ByoumeiGaitouKbn3 valueOf(String pValue) {
        return C_ByoumeiGaitouKbn3.valueOf(pValue);
    }

    @Override
    protected String toString(C_ByoumeiGaitouKbn3 pValue) {
        return pValue.getValue();
    }
}
