package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SyoruihanteiKbn;

/**
 * {@link C_SyoruihanteiKbn 書類判定区分} の Hibernate ユーザー定義型です。<br />
 * 書類判定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SyoruihanteiKbn extends AbstractUserType<C_SyoruihanteiKbn> {

    @Override
    protected Class<C_SyoruihanteiKbn> returnType() {
        return C_SyoruihanteiKbn.class;
    }

    @Override
    protected C_SyoruihanteiKbn valueOf(String pValue) {
        return C_SyoruihanteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SyoruihanteiKbn pValue) {
        return pValue.getValue();
    }
}
