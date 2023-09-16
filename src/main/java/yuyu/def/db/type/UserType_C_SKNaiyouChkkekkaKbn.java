package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SKNaiyouChkkekkaKbn;

/**
 * {@link C_SKNaiyouChkkekkaKbn 請求内容チェック結果区分} の Hibernate ユーザー定義型です。<br />
 * 請求内容チェック結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SKNaiyouChkkekkaKbn extends AbstractUserType<C_SKNaiyouChkkekkaKbn> {

    @Override
    protected Class<C_SKNaiyouChkkekkaKbn> returnType() {
        return C_SKNaiyouChkkekkaKbn.class;
    }

    @Override
    protected C_SKNaiyouChkkekkaKbn valueOf(String pValue) {
        return C_SKNaiyouChkkekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SKNaiyouChkkekkaKbn pValue) {
        return pValue.getValue();
    }
}
