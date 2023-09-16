package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KydsskKinyuuknHyouji;

/**
 * {@link C_KydsskKinyuuknHyouji 協同組織金融機関表示} の Hibernate ユーザー定義型です。<br />
 * 協同組織金融機関表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KydsskKinyuuknHyouji extends AbstractUserType<C_KydsskKinyuuknHyouji> {

    @Override
    protected Class<C_KydsskKinyuuknHyouji> returnType() {
        return C_KydsskKinyuuknHyouji.class;
    }

    @Override
    protected C_KydsskKinyuuknHyouji valueOf(String pValue) {
        return C_KydsskKinyuuknHyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_KydsskKinyuuknHyouji pValue) {
        return pValue.getValue();
    }
}
