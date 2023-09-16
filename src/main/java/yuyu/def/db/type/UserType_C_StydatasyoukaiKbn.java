package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StydatasyoukaiKbn;

/**
 * {@link C_StydatasyoukaiKbn 進捗データ照会区分} の Hibernate ユーザー定義型です。<br />
 * 進捗データ照会区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StydatasyoukaiKbn extends AbstractUserType<C_StydatasyoukaiKbn> {

    @Override
    protected Class<C_StydatasyoukaiKbn> returnType() {
        return C_StydatasyoukaiKbn.class;
    }

    @Override
    protected C_StydatasyoukaiKbn valueOf(String pValue) {
        return C_StydatasyoukaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StydatasyoukaiKbn pValue) {
        return pValue.getValue();
    }
}
