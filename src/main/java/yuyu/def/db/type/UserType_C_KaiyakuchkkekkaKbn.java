package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KaiyakuchkkekkaKbn;

/**
 * {@link C_KaiyakuchkkekkaKbn 解約共通チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 解約共通チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KaiyakuchkkekkaKbn extends AbstractUserType<C_KaiyakuchkkekkaKbn> {

    @Override
    protected Class<C_KaiyakuchkkekkaKbn> returnType() {
        return C_KaiyakuchkkekkaKbn.class;
    }

    @Override
    protected C_KaiyakuchkkekkaKbn valueOf(String pValue) {
        return C_KaiyakuchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KaiyakuchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
