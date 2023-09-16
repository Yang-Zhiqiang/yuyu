package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KzkTrkServicettdkKbn;

/**
 * {@link C_KzkTrkServicettdkKbn 家族登録サービス手続内容区分} の Hibernate ユーザー定義型です。<br />
 * 家族登録サービス手続内容区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KzkTrkServicettdkKbn extends AbstractUserType<C_KzkTrkServicettdkKbn> {

    @Override
    protected Class<C_KzkTrkServicettdkKbn> returnType() {
        return C_KzkTrkServicettdkKbn.class;
    }

    @Override
    protected C_KzkTrkServicettdkKbn valueOf(String pValue) {
        return C_KzkTrkServicettdkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KzkTrkServicettdkKbn pValue) {
        return pValue.getValue();
    }
}
