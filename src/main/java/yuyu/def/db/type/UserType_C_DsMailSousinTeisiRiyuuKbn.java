package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DsMailSousinTeisiRiyuuKbn;

/**
 * {@link C_DsMailSousinTeisiRiyuuKbn ＤＳメール送信停止理由区分} の Hibernate ユーザー定義型です。<br />
 * ＤＳメール送信停止理由区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DsMailSousinTeisiRiyuuKbn extends AbstractUserType<C_DsMailSousinTeisiRiyuuKbn> {

    @Override
    protected Class<C_DsMailSousinTeisiRiyuuKbn> returnType() {
        return C_DsMailSousinTeisiRiyuuKbn.class;
    }

    @Override
    protected C_DsMailSousinTeisiRiyuuKbn valueOf(String pValue) {
        return C_DsMailSousinTeisiRiyuuKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DsMailSousinTeisiRiyuuKbn pValue) {
        return pValue.getValue();
    }
}
