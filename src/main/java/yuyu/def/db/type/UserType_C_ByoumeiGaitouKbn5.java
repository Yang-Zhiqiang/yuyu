package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ByoumeiGaitouKbn5;

/**
 * {@link C_ByoumeiGaitouKbn5 病名該当区分５} の Hibernate ユーザー定義型です。<br />
 * 病名該当区分５ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ByoumeiGaitouKbn5 extends AbstractUserType<C_ByoumeiGaitouKbn5> {

    @Override
    protected Class<C_ByoumeiGaitouKbn5> returnType() {
        return C_ByoumeiGaitouKbn5.class;
    }

    @Override
    protected C_ByoumeiGaitouKbn5 valueOf(String pValue) {
        return C_ByoumeiGaitouKbn5.valueOf(pValue);
    }

    @Override
    protected String toString(C_ByoumeiGaitouKbn5 pValue) {
        return pValue.getValue();
    }
}
