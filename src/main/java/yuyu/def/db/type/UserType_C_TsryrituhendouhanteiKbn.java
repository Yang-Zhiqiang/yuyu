package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsryrituhendouhanteiKbn;

/**
 * {@link C_TsryrituhendouhanteiKbn 手数料率変動判定区分} の Hibernate ユーザー定義型です。<br />
 * 手数料率変動判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsryrituhendouhanteiKbn extends AbstractUserType<C_TsryrituhendouhanteiKbn> {

    @Override
    protected Class<C_TsryrituhendouhanteiKbn> returnType() {
        return C_TsryrituhendouhanteiKbn.class;
    }

    @Override
    protected C_TsryrituhendouhanteiKbn valueOf(String pValue) {
        return C_TsryrituhendouhanteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsryrituhendouhanteiKbn pValue) {
        return pValue.getValue();
    }
}
