package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SoukinyoukzinputchkkekkaKbn;

/**
 * {@link C_SoukinyoukzinputchkkekkaKbn 送金用口座入力チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 送金用口座入力チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SoukinyoukzinputchkkekkaKbn extends AbstractUserType<C_SoukinyoukzinputchkkekkaKbn> {

    @Override
    protected Class<C_SoukinyoukzinputchkkekkaKbn> returnType() {
        return C_SoukinyoukzinputchkkekkaKbn.class;
    }

    @Override
    protected C_SoukinyoukzinputchkkekkaKbn valueOf(String pValue) {
        return C_SoukinyoukzinputchkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SoukinyoukzinputchkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
