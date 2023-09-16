package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ByoumeiGaitouKbn2;

/**
 * {@link C_ByoumeiGaitouKbn2 病名該当区分２} の Hibernate ユーザー定義型です。<br />
 * 病名該当区分２ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ByoumeiGaitouKbn2 extends AbstractUserType<C_ByoumeiGaitouKbn2> {

    @Override
    protected Class<C_ByoumeiGaitouKbn2> returnType() {
        return C_ByoumeiGaitouKbn2.class;
    }

    @Override
    protected C_ByoumeiGaitouKbn2 valueOf(String pValue) {
        return C_ByoumeiGaitouKbn2.valueOf(pValue);
    }

    @Override
    protected String toString(C_ByoumeiGaitouKbn2 pValue) {
        return pValue.getValue();
    }
}
