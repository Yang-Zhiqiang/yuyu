package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KouteiSakuseiKekkaKbn;

/**
 * {@link C_KouteiSakuseiKekkaKbn 工程作成結果区分} の Hibernate ユーザー定義型です。<br />
 * 工程作成結果区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KouteiSakuseiKekkaKbn extends AbstractUserType<C_KouteiSakuseiKekkaKbn> {

    @Override
    protected Class<C_KouteiSakuseiKekkaKbn> returnType() {
        return C_KouteiSakuseiKekkaKbn.class;
    }

    @Override
    protected C_KouteiSakuseiKekkaKbn valueOf(String pValue) {
        return C_KouteiSakuseiKekkaKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_KouteiSakuseiKekkaKbn pValue) {
        return pValue.getValue();
    }
}
