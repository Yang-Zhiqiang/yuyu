package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WebmosuktkKbn;

/**
 * {@link C_WebmosuktkKbn Ｗｅｂ申込受付区分} の Hibernate ユーザー定義型です。<br />
 * Ｗｅｂ申込受付区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WebmosuktkKbn extends AbstractUserType<C_WebmosuktkKbn> {

    @Override
    protected Class<C_WebmosuktkKbn> returnType() {
        return C_WebmosuktkKbn.class;
    }

    @Override
    protected C_WebmosuktkKbn valueOf(String pValue) {
        return C_WebmosuktkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WebmosuktkKbn pValue) {
        return pValue.getValue();
    }
}
