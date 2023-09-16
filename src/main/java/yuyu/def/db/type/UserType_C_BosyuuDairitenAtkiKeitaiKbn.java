package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_BosyuuDairitenAtkiKeitaiKbn;

/**
 * {@link C_BosyuuDairitenAtkiKeitaiKbn 募集代理店扱形態区分} の Hibernate ユーザー定義型です。<br />
 * 募集代理店扱形態区分 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_BosyuuDairitenAtkiKeitaiKbn extends AbstractUserType<C_BosyuuDairitenAtkiKeitaiKbn> {

    @Override
    protected Class<C_BosyuuDairitenAtkiKeitaiKbn> returnType() {
        return C_BosyuuDairitenAtkiKeitaiKbn.class;
    }

    @Override
    protected C_BosyuuDairitenAtkiKeitaiKbn valueOf(String pValue) {
        return C_BosyuuDairitenAtkiKeitaiKbn.valueOf(pValue);
    }

    @Override
    protected String toString(C_BosyuuDairitenAtkiKeitaiKbn pValue) {
        return pValue.getValue();
    }
}
