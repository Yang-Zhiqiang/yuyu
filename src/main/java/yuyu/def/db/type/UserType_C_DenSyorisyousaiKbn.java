package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_DenSyorisyousaiKbn;

/**
 * {@link C_DenSyorisyousaiKbn 伝票用処理詳細区分} の Hibernate ユーザー定義型です。<br />
 * 伝票用処理詳細区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_DenSyorisyousaiKbn extends AbstractUserType<C_DenSyorisyousaiKbn> {

    @Override
    protected Class<C_DenSyorisyousaiKbn> returnType() {
        return C_DenSyorisyousaiKbn.class;
    }

    @Override
    protected C_DenSyorisyousaiKbn valueOf(String pValue) {
        return C_DenSyorisyousaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_DenSyorisyousaiKbn pValue) {
        return pValue.getValue();
    }
}
