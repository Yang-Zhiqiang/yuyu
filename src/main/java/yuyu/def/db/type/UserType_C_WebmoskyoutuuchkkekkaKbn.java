package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_WebmoskyoutuuchkkekkaKbn;

/**
 * {@link C_WebmoskyoutuuchkkekkaKbn Ｗｅｂ申込共通チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * Ｗｅｂ申込共通チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_WebmoskyoutuuchkkekkaKbn extends AbstractUserType<C_WebmoskyoutuuchkkekkaKbn> {

    @Override
    protected Class<C_WebmoskyoutuuchkkekkaKbn> returnType() {
        return C_WebmoskyoutuuchkkekkaKbn.class;
    }

    @Override
    protected C_WebmoskyoutuuchkkekkaKbn valueOf(String pValue) {
        return C_WebmoskyoutuuchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_WebmoskyoutuuchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
