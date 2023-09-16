package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_LinchhknseiKbn;

/**
 * {@link C_LinchhknseiKbn ＬＩＮＣ用被保険者性別区分} の Hibernate ユーザー定義型です。<br />
 * ＬＩＮＣ用被保険者性別区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_LinchhknseiKbn extends AbstractUserType<C_LinchhknseiKbn> {

    @Override
    protected Class<C_LinchhknseiKbn> returnType() {
        return C_LinchhknseiKbn.class;
    }

    @Override
    protected C_LinchhknseiKbn valueOf(String pValue) {
        return C_LinchhknseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_LinchhknseiKbn pValue) {
        return pValue.getValue();
    }
}
