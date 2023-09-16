package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_QrCodeTaikeiKbn;

/**
 * {@link C_QrCodeTaikeiKbn QRコード体系区分} の Hibernate ユーザー定義型です。<br />
 * QRコード体系区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_QrCodeTaikeiKbn extends AbstractUserType<C_QrCodeTaikeiKbn> {

    @Override
    protected Class<C_QrCodeTaikeiKbn> returnType() {
        return C_QrCodeTaikeiKbn.class;
    }

    @Override
    protected C_QrCodeTaikeiKbn valueOf(String pValue) {
        return C_QrCodeTaikeiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_QrCodeTaikeiKbn pValue) {
        return pValue.getValue();
    }
}
