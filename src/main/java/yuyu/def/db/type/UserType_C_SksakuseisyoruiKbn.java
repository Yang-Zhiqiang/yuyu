package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SksakuseisyoruiKbn;

/**
 * {@link C_SksakuseisyoruiKbn 新契約請求書作成書類区分} の Hibernate ユーザー定義型です。<br />
 * 新契約請求書作成書類区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SksakuseisyoruiKbn extends AbstractUserType<C_SksakuseisyoruiKbn> {

    @Override
    protected Class<C_SksakuseisyoruiKbn> returnType() {
        return C_SksakuseisyoruiKbn.class;
    }

    @Override
    protected C_SksakuseisyoruiKbn valueOf(String pValue) {
        return C_SksakuseisyoruiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SksakuseisyoruiKbn pValue) {
        return pValue.getValue();
    }
}
