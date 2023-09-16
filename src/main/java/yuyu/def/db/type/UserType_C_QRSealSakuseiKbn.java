package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_QRSealSakuseiKbn;

/**
 * {@link C_QRSealSakuseiKbn QRシール用紙作成区分} の Hibernate ユーザー定義型です。<br />
 * QRシール用紙作成区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_QRSealSakuseiKbn extends AbstractUserType<C_QRSealSakuseiKbn> {

    @Override
    protected Class<C_QRSealSakuseiKbn> returnType() {
        return C_QRSealSakuseiKbn.class;
    }

    @Override
    protected C_QRSealSakuseiKbn valueOf(String pValue) {
        return C_QRSealSakuseiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_QRSealSakuseiKbn pValue) {
        return pValue.getValue();
    }
}
