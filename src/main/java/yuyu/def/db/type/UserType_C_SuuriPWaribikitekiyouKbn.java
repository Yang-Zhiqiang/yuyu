package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SuuriPWaribikitekiyouKbn;

/**
 * {@link C_SuuriPWaribikitekiyouKbn 数理保険料割引適用区分} の Hibernate ユーザー定義型です。<br />
 * 数理保険料割引適用区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SuuriPWaribikitekiyouKbn extends AbstractUserType<C_SuuriPWaribikitekiyouKbn> {

    @Override
    protected Class<C_SuuriPWaribikitekiyouKbn> returnType() {
        return C_SuuriPWaribikitekiyouKbn.class;
    }

    @Override
    protected C_SuuriPWaribikitekiyouKbn valueOf(String pValue) {
        return C_SuuriPWaribikitekiyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SuuriPWaribikitekiyouKbn pValue) {
        return pValue.getValue();
    }
}
