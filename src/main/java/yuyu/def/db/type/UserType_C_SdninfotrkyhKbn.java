package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_SdninfotrkyhKbn;

/**
 * {@link C_SdninfotrkyhKbn 集団情報登録要否区分} の Hibernate ユーザー定義型です。<br />
 * 集団情報登録要否区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_SdninfotrkyhKbn extends AbstractUserType<C_SdninfotrkyhKbn> {

    @Override
    protected Class<C_SdninfotrkyhKbn> returnType() {
        return C_SdninfotrkyhKbn.class;
    }

    @Override
    protected C_SdninfotrkyhKbn valueOf(String pValue) {
        return C_SdninfotrkyhKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_SdninfotrkyhKbn pValue) {
        return pValue.getValue();
    }
}
