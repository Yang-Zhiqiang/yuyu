package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SindansyoSksSiteiKbn;

/**
 * {@link C_SindansyoSksSiteiKbn 診断書作成指定区分} の Hibernate ユーザー定義型です。<br />
 * 診断書作成指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SindansyoSksSiteiKbn extends AbstractUserType<C_SindansyoSksSiteiKbn> {

    @Override
    protected Class<C_SindansyoSksSiteiKbn> returnType() {
        return C_SindansyoSksSiteiKbn.class;
    }

    @Override
    protected C_SindansyoSksSiteiKbn valueOf(String pValue) {
        return C_SindansyoSksSiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SindansyoSksSiteiKbn pValue) {
        return pValue.getValue();
    }
}
