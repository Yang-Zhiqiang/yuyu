package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PWaribikitekiyouKbn;

/**
 * {@link C_PWaribikitekiyouKbn 保険料割引適用区分} の Hibernate ユーザー定義型です。<br />
 * 保険料割引適用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PWaribikitekiyouKbn extends AbstractUserType<C_PWaribikitekiyouKbn> {

    @Override
    protected Class<C_PWaribikitekiyouKbn> returnType() {
        return C_PWaribikitekiyouKbn.class;
    }

    @Override
    protected C_PWaribikitekiyouKbn valueOf(String pValue) {
        return C_PWaribikitekiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_PWaribikitekiyouKbn pValue) {
        return pValue.getValue();
    }
}
