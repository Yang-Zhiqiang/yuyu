package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_ScreeningkekkaKbn;

/**
 * {@link C_ScreeningkekkaKbn スクリーニング結果区分} の Hibernate ユーザー定義型です。<br />
 * スクリーニング結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_ScreeningkekkaKbn extends AbstractUserType<C_ScreeningkekkaKbn> {

    @Override
    protected Class<C_ScreeningkekkaKbn> returnType() {
        return C_ScreeningkekkaKbn.class;
    }

    @Override
    protected C_ScreeningkekkaKbn valueOf(String pValue) {
        return C_ScreeningkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_ScreeningkekkaKbn pValue) {
        return pValue.getValue();
    }
}
