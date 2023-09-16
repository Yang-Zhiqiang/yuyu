package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsTmttknitenchkkekkaKbn;

/**
 * {@link C_DsTmttknitenchkkekkaKbn ＤＳ積立金移転共通チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳ積立金移転共通チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsTmttknitenchkkekkaKbn extends AbstractUserType<C_DsTmttknitenchkkekkaKbn> {

    @Override
    protected Class<C_DsTmttknitenchkkekkaKbn> returnType() {
        return C_DsTmttknitenchkkekkaKbn.class;
    }

    @Override
    protected C_DsTmttknitenchkkekkaKbn valueOf(String pValue) {
        return C_DsTmttknitenchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsTmttknitenchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
