package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SoukinyoukzchkkekkaKbn;

/**
 * {@link C_SoukinyoukzchkkekkaKbn 送金用口座正当性チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 送金用口座正当性チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SoukinyoukzchkkekkaKbn extends AbstractUserType<C_SoukinyoukzchkkekkaKbn> {

    @Override
    protected Class<C_SoukinyoukzchkkekkaKbn> returnType() {
        return C_SoukinyoukzchkkekkaKbn.class;
    }

    @Override
    protected C_SoukinyoukzchkkekkaKbn valueOf(String pValue) {
        return C_SoukinyoukzchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SoukinyoukzchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
