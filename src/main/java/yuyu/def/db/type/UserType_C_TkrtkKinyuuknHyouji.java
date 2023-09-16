package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_TkrtkKinyuuknHyouji;

/**
 * {@link C_TkrtkKinyuuknHyouji 特例地域金融機関表示} の Hibernate ユーザー定義型です。<br />
 * 特例地域金融機関表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_TkrtkKinyuuknHyouji extends AbstractUserType<C_TkrtkKinyuuknHyouji> {

    @Override
    protected Class<C_TkrtkKinyuuknHyouji> returnType() {
        return C_TkrtkKinyuuknHyouji.class;
    }

    @Override
    protected C_TkrtkKinyuuknHyouji valueOf(String pValue) {
        return C_TkrtkKinyuuknHyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_TkrtkKinyuuknHyouji pValue) {
        return pValue.getValue();
    }
}
