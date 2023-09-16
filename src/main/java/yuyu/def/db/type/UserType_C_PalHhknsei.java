package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_PalHhknsei;

/**
 * {@link C_PalHhknsei ＰＡＬ被保険者性別} の Hibernate ユーザー定義型です。<br />
 * ＰＡＬ被保険者性別 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_PalHhknsei extends AbstractUserType<C_PalHhknsei> {

    @Override
    protected Class<C_PalHhknsei> returnType() {
        return C_PalHhknsei.class;
    }

    @Override
    protected C_PalHhknsei valueOf(String pValue) {
        return C_PalHhknsei.valueOf(pValue);
    }

    @Override
    protected String toString(C_PalHhknsei pValue) {
        return pValue.getValue();
    }
}
