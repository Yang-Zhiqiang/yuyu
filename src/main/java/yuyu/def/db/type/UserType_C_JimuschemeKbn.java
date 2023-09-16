package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_JimuschemeKbn;

/**
 * {@link C_JimuschemeKbn 事務スキーム区分} の Hibernate ユーザー定義型です。<br />
 * 事務スキーム区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_JimuschemeKbn extends AbstractUserType<C_JimuschemeKbn> {

    @Override
    protected Class<C_JimuschemeKbn> returnType() {
        return C_JimuschemeKbn.class;
    }

    @Override
    protected C_JimuschemeKbn valueOf(String pValue) {
        return C_JimuschemeKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_JimuschemeKbn pValue) {
        return pValue.getValue();
    }
}
