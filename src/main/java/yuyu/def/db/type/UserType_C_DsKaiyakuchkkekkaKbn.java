package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsKaiyakuchkkekkaKbn;

/**
 * {@link C_DsKaiyakuchkkekkaKbn ＤＳ解約共通チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ解約共通チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsKaiyakuchkkekkaKbn extends AbstractUserType<C_DsKaiyakuchkkekkaKbn> {

    @Override
    protected Class<C_DsKaiyakuchkkekkaKbn> returnType() {
        return C_DsKaiyakuchkkekkaKbn.class;
    }

    @Override
    protected C_DsKaiyakuchkkekkaKbn valueOf(String pValue) {
        return C_DsKaiyakuchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsKaiyakuchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
