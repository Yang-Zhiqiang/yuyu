package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SouhusakiSiteiKbn;

/**
 * {@link C_SouhusakiSiteiKbn 送付先指定区分} の Hibernate ユーザー定義型です。<br />
 * 送付先指定区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SouhusakiSiteiKbn extends AbstractUserType<C_SouhusakiSiteiKbn> {

    @Override
    protected Class<C_SouhusakiSiteiKbn> returnType() {
        return C_SouhusakiSiteiKbn.class;
    }

    @Override
    protected C_SouhusakiSiteiKbn valueOf(String pValue) {
        return C_SouhusakiSiteiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SouhusakiSiteiKbn pValue) {
        return pValue.getValue();
    }
}
