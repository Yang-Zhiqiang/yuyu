package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ByoumeiGaitouKbn4;

/**
 * {@link C_ByoumeiGaitouKbn4 病名該当区分４} の Hibernate ユーザー定義型です。<br />
 * 病名該当区分４ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ByoumeiGaitouKbn4 extends AbstractUserType<C_ByoumeiGaitouKbn4> {

    @Override
    protected Class<C_ByoumeiGaitouKbn4> returnType() {
        return C_ByoumeiGaitouKbn4.class;
    }

    @Override
    protected C_ByoumeiGaitouKbn4 valueOf(String pValue) {
        return C_ByoumeiGaitouKbn4.valueOf(pValue);
    }

    @Override
    protected String toString(C_ByoumeiGaitouKbn4 pValue) {
        return pValue.getValue();
    }
}
