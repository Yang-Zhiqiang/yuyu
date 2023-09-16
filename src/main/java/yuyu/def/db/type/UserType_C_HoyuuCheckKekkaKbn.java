package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_HoyuuCheckKekkaKbn;

/**
 * {@link C_HoyuuCheckKekkaKbn 保有判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 保有判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_HoyuuCheckKekkaKbn extends AbstractUserType<C_HoyuuCheckKekkaKbn> {

    @Override
    protected Class<C_HoyuuCheckKekkaKbn> returnType() {
        return C_HoyuuCheckKekkaKbn.class;
    }

    @Override
    protected C_HoyuuCheckKekkaKbn valueOf(String pValue) {
        return C_HoyuuCheckKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_HoyuuCheckKekkaKbn pValue) {
        return pValue.getValue();
    }
}
