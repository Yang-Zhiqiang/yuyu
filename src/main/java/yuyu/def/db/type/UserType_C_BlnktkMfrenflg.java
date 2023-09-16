package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BlnktkMfrenflg;

/**
 * {@link C_BlnktkMfrenflg ブランク付ＭＦ連動済フラグ} の Hibernate ユーザー定義型です。<br />
 * ブランク付ＭＦ連動済フラグ 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BlnktkMfrenflg extends AbstractUserType<C_BlnktkMfrenflg> {

    @Override
    protected Class<C_BlnktkMfrenflg> returnType() {
        return C_BlnktkMfrenflg.class;
    }

    @Override
    protected C_BlnktkMfrenflg valueOf(String pValue) {
        return C_BlnktkMfrenflg.valueOf(pValue);
    }

    @Override
    protected String toString(C_BlnktkMfrenflg pValue) {
        return pValue.getValue();
    }
}
