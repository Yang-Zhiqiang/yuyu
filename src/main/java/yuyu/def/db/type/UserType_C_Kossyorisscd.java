package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Kossyorisscd;

/**
 * {@link C_Kossyorisscd 更新処理詳細コード} の Hibernate ユーザー定義型です。<br />
 * 更新処理詳細コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Kossyorisscd extends AbstractUserType<C_Kossyorisscd> {

    @Override
    protected Class<C_Kossyorisscd> returnType() {
        return C_Kossyorisscd.class;
    }

    @Override
    protected C_Kossyorisscd valueOf(String pValue) {
        return C_Kossyorisscd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Kossyorisscd pValue) {
        return pValue.getValue();
    }
}
