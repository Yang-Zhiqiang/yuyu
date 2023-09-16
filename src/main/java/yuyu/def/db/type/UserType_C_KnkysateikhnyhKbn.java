package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KnkysateikhnyhKbn;

/**
 * {@link C_KnkysateikhnyhKbn 環境査定（基本）要否区分} の Hibernate ユーザー定義型です。<br />
 * 環境査定（基本）要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KnkysateikhnyhKbn extends AbstractUserType<C_KnkysateikhnyhKbn> {

    @Override
    protected Class<C_KnkysateikhnyhKbn> returnType() {
        return C_KnkysateikhnyhKbn.class;
    }

    @Override
    protected C_KnkysateikhnyhKbn valueOf(String pValue) {
        return C_KnkysateikhnyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KnkysateikhnyhKbn pValue) {
        return pValue.getValue();
    }
}
