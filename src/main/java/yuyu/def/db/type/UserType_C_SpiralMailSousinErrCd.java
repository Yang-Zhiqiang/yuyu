package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SpiralMailSousinErrCd;

/**
 * {@link C_SpiralMailSousinErrCd ＳＰＩＲＡＬメール送信エラーコード} の Hibernate ユーザー定義型です。<br />
 * ＳＰＩＲＡＬメール送信エラーコード 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SpiralMailSousinErrCd extends AbstractUserType<C_SpiralMailSousinErrCd> {

    @Override
    protected Class<C_SpiralMailSousinErrCd> returnType() {
        return C_SpiralMailSousinErrCd.class;
    }

    @Override
    protected C_SpiralMailSousinErrCd valueOf(String pValue) {
        return C_SpiralMailSousinErrCd.valueOf(pValue);
    }

    @Override
    protected String toString(C_SpiralMailSousinErrCd pValue) {
        return pValue.getValue();
    }
}
