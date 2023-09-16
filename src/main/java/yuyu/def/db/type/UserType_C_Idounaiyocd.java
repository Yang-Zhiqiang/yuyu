package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_Idounaiyocd;

/**
 * {@link C_Idounaiyocd 異動内容コード} の Hibernate ユーザー定義型です。<br />
 * 異動内容コード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_Idounaiyocd extends AbstractUserType<C_Idounaiyocd> {

    @Override
    protected Class<C_Idounaiyocd> returnType() {
        return C_Idounaiyocd.class;
    }

    @Override
    protected C_Idounaiyocd valueOf(String pValue) {
        return C_Idounaiyocd.valueOf(pValue);
    }

    @Override
    protected String toString(C_Idounaiyocd pValue) {
        return pValue.getValue();
    }
}
