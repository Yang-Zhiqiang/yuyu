package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Tienrskhasuusyori;

/**
 * {@link C_Tienrskhasuusyori 遅延利息端数処理} の Hibernate ユーザー定義型です。<br />
 * 遅延利息端数処理 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Tienrskhasuusyori extends AbstractUserType<C_Tienrskhasuusyori> {

    @Override
    protected Class<C_Tienrskhasuusyori> returnType() {
        return C_Tienrskhasuusyori.class;
    }

    @Override
    protected C_Tienrskhasuusyori valueOf(String pValue) {
        return C_Tienrskhasuusyori.valueOf(pValue);
    }

    @Override
    protected String toString(C_Tienrskhasuusyori pValue) {
        return pValue.getValue();
    }
}
