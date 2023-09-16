package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_NenkinVRateGetKbn;

/**
 * {@link C_NenkinVRateGetKbn 年金開始後Ｐ基礎Ｖレート取得区分} の Hibernate ユーザー定義型です。<br />
 * 年金開始後Ｐ基礎Ｖレート取得区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_NenkinVRateGetKbn extends AbstractUserType<C_NenkinVRateGetKbn> {

    @Override
    protected Class<C_NenkinVRateGetKbn> returnType() {
        return C_NenkinVRateGetKbn.class;
    }

    @Override
    protected C_NenkinVRateGetKbn valueOf(String pValue) {
        return C_NenkinVRateGetKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_NenkinVRateGetKbn pValue) {
        return pValue.getValue();
    }
}
