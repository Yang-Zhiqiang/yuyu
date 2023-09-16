package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_StydatasyoukaitaisyouKbn;

/**
 * {@link C_StydatasyoukaitaisyouKbn 進捗データ照会対象区分} の Hibernate ユーザー定義型です。<br />
 * 進捗データ照会対象区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_StydatasyoukaitaisyouKbn extends AbstractUserType<C_StydatasyoukaitaisyouKbn> {

    @Override
    protected Class<C_StydatasyoukaitaisyouKbn> returnType() {
        return C_StydatasyoukaitaisyouKbn.class;
    }

    @Override
    protected C_StydatasyoukaitaisyouKbn valueOf(String pValue) {
        return C_StydatasyoukaitaisyouKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_StydatasyoukaitaisyouKbn pValue) {
        return pValue.getValue();
    }
}
