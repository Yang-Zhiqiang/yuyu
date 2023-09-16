package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_RatesyutokukekkaKbn;

/**
 * {@link C_RatesyutokukekkaKbn 換算用為替レート取得結果区分} の Hibernate ユーザー定義型です。<br />
 * 換算用為替レート取得結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_RatesyutokukekkaKbn extends AbstractUserType<C_RatesyutokukekkaKbn> {

    @Override
    protected Class<C_RatesyutokukekkaKbn> returnType() {
        return C_RatesyutokukekkaKbn.class;
    }

    @Override
    protected C_RatesyutokukekkaKbn valueOf(String pValue) {
        return C_RatesyutokukekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_RatesyutokukekkaKbn pValue) {
        return pValue.getValue();
    }
}
