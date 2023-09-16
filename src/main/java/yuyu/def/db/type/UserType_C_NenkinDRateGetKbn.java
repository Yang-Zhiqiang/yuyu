package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenkinDRateGetKbn;

/**
 * {@link C_NenkinDRateGetKbn 年金開始後Ｄレート取得区分} の Hibernate ユーザー定義型です。<br />
 * 年金開始後Ｄレート取得区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenkinDRateGetKbn extends AbstractUserType<C_NenkinDRateGetKbn> {

    @Override
    protected Class<C_NenkinDRateGetKbn> returnType() {
        return C_NenkinDRateGetKbn.class;
    }

    @Override
    protected C_NenkinDRateGetKbn valueOf(String pValue) {
        return C_NenkinDRateGetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenkinDRateGetKbn pValue) {
        return pValue.getValue();
    }
}
