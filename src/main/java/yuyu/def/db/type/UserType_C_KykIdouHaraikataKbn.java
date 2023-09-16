package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KykIdouHaraikataKbn;

/**
 * {@link C_KykIdouHaraikataKbn 保険契約異動情報払方区分} の Hibernate ユーザー定義型です。<br />
 * 保険契約異動情報払方区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KykIdouHaraikataKbn extends AbstractUserType<C_KykIdouHaraikataKbn> {

    @Override
    protected Class<C_KykIdouHaraikataKbn> returnType() {
        return C_KykIdouHaraikataKbn.class;
    }

    @Override
    protected C_KykIdouHaraikataKbn valueOf(String pValue) {
        return C_KykIdouHaraikataKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KykIdouHaraikataKbn pValue) {
        return pValue.getValue();
    }
}
