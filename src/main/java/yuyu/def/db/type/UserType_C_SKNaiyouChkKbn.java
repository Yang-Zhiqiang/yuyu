package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SKNaiyouChkKbn;

/**
 * {@link C_SKNaiyouChkKbn 請求内容チェック区分} の Hibernate ユーザー定義型です。<br />
 * 請求内容チェック区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SKNaiyouChkKbn extends AbstractUserType<C_SKNaiyouChkKbn> {

    @Override
    protected Class<C_SKNaiyouChkKbn> returnType() {
        return C_SKNaiyouChkKbn.class;
    }

    @Override
    protected C_SKNaiyouChkKbn valueOf(String pValue) {
        return C_SKNaiyouChkKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SKNaiyouChkKbn pValue) {
        return pValue.getValue();
    }
}
