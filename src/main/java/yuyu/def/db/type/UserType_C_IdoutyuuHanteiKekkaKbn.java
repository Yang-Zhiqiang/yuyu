package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IdoutyuuHanteiKekkaKbn;

/**
 * {@link C_IdoutyuuHanteiKekkaKbn 異動中判定結果区分} の Hibernate ユーザー定義型です。<br />
 * 異動中判定結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IdoutyuuHanteiKekkaKbn extends AbstractUserType<C_IdoutyuuHanteiKekkaKbn> {

    @Override
    protected Class<C_IdoutyuuHanteiKekkaKbn> returnType() {
        return C_IdoutyuuHanteiKekkaKbn.class;
    }

    @Override
    protected C_IdoutyuuHanteiKekkaKbn valueOf(String pValue) {
        return C_IdoutyuuHanteiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IdoutyuuHanteiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
