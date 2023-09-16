package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KhnkyhkgbairituKbn;

/**
 * {@link C_KhnkyhkgbairituKbn 基本給付金額倍率区分} の Hibernate ユーザー定義型です。<br />
 * 基本給付金額倍率区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KhnkyhkgbairituKbn extends AbstractUserType<C_KhnkyhkgbairituKbn> {

    @Override
    protected Class<C_KhnkyhkgbairituKbn> returnType() {
        return C_KhnkyhkgbairituKbn.class;
    }

    @Override
    protected C_KhnkyhkgbairituKbn valueOf(String pValue) {
        return C_KhnkyhkgbairituKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KhnkyhkgbairituKbn pValue) {
        return pValue.getValue();
    }
}
