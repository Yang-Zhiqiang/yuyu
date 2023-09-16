package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SystemRenkeiSyoriHousikiKbn;

/**
 * {@link C_SystemRenkeiSyoriHousikiKbn システム間連携用処理方式区分} の Hibernate ユーザー定義型です。<br />
 * システム間連携用処理方式区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SystemRenkeiSyoriHousikiKbn extends AbstractUserType<C_SystemRenkeiSyoriHousikiKbn> {

    @Override
    protected Class<C_SystemRenkeiSyoriHousikiKbn> returnType() {
        return C_SystemRenkeiSyoriHousikiKbn.class;
    }

    @Override
    protected C_SystemRenkeiSyoriHousikiKbn valueOf(String pValue) {
        return C_SystemRenkeiSyoriHousikiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SystemRenkeiSyoriHousikiKbn pValue) {
        return pValue.getValue();
    }
}
