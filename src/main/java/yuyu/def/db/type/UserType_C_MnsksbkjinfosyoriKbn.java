package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_MnsksbkjinfosyoriKbn;

/**
 * {@link C_MnsksbkjinfosyoriKbn 免責・死亡解除情報取得処理区分} の Hibernate ユーザー定義型です。<br />
 * 免責・死亡解除情報取得処理区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_MnsksbkjinfosyoriKbn extends AbstractUserType<C_MnsksbkjinfosyoriKbn> {

    @Override
    protected Class<C_MnsksbkjinfosyoriKbn> returnType() {
        return C_MnsksbkjinfosyoriKbn.class;
    }

    @Override
    protected C_MnsksbkjinfosyoriKbn valueOf(String pValue) {
        return C_MnsksbkjinfosyoriKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_MnsksbkjinfosyoriKbn pValue) {
        return pValue.getValue();
    }
}
