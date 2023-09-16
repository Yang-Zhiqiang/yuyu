package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SekmossakuseiKbn;

/**
 * {@link C_SekmossakuseiKbn 設計書申込書作成区分} の Hibernate ユーザー定義型です。<br />
 * 設計書申込書作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SekmossakuseiKbn extends AbstractUserType<C_SekmossakuseiKbn> {

    @Override
    protected Class<C_SekmossakuseiKbn> returnType() {
        return C_SekmossakuseiKbn.class;
    }

    @Override
    protected C_SekmossakuseiKbn valueOf(String pValue) {
        return C_SekmossakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SekmossakuseiKbn pValue) {
        return pValue.getValue();
    }
}
