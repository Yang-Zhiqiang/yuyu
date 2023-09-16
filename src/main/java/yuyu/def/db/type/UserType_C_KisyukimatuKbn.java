package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KisyukimatuKbn;

/**
 * {@link C_KisyukimatuKbn 期首期末区分} の Hibernate ユーザー定義型です。<br />
 * 期首期末区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KisyukimatuKbn extends AbstractUserType<C_KisyukimatuKbn> {

    @Override
    protected Class<C_KisyukimatuKbn> returnType() {
        return C_KisyukimatuKbn.class;
    }

    @Override
    protected C_KisyukimatuKbn valueOf(String pValue) {
        return C_KisyukimatuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KisyukimatuKbn pValue) {
        return pValue.getValue();
    }
}
