package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_IwssnKykSyoukaiKekkaKbn;

/**
 * {@link C_IwssnKykSyoukaiKekkaKbn 社内用契約内容照会結果区分} の Hibernate ユーザー定義型です。<br />
 * 社内用契約内容照会結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_IwssnKykSyoukaiKekkaKbn extends AbstractUserType<C_IwssnKykSyoukaiKekkaKbn> {

    @Override
    protected Class<C_IwssnKykSyoukaiKekkaKbn> returnType() {
        return C_IwssnKykSyoukaiKekkaKbn.class;
    }

    @Override
    protected C_IwssnKykSyoukaiKekkaKbn valueOf(String pValue) {
        return C_IwssnKykSyoukaiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_IwssnKykSyoukaiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
