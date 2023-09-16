package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TsrykikanhanteiKbn;

/**
 * {@link C_TsrykikanhanteiKbn 手数料期間判定区分} の Hibernate ユーザー定義型です。<br />
 * 手数料期間判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TsrykikanhanteiKbn extends AbstractUserType<C_TsrykikanhanteiKbn> {

    @Override
    protected Class<C_TsrykikanhanteiKbn> returnType() {
        return C_TsrykikanhanteiKbn.class;
    }

    @Override
    protected C_TsrykikanhanteiKbn valueOf(String pValue) {
        return C_TsrykikanhanteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_TsrykikanhanteiKbn pValue) {
        return pValue.getValue();
    }
}
