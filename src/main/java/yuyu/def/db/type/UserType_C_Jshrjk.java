package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Jshrjk;

/**
 * {@link C_Jshrjk 自動支払状況} の Hibernate ユーザー定義型です。<br />
 * 自動支払状況 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Jshrjk extends AbstractUserType<C_Jshrjk> {

    @Override
    protected Class<C_Jshrjk> returnType() {
        return C_Jshrjk.class;
    }

    @Override
    protected C_Jshrjk valueOf(String pValue) {
        return C_Jshrjk.valueOf(pValue);
    }

    @Override
    protected String toString(C_Jshrjk pValue) {
        return pValue.getValue();
    }
}
