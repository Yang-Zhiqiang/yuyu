package yuyu.def.db.type;

import jp.co.slcs.swak.db.hibernate.usertype.AbstractUserType;
import yuyu.def.classification.C_KydBosyuuDairitenHyouji;

/**
 * {@link C_KydBosyuuDairitenHyouji 共同募集代理店表示} の Hibernate ユーザー定義型です。<br />
 * 共同募集代理店表示 型フィールドの値を データベースに永続化／データベースから読み出して復元 する際の型変換に利用されます。
 */
public class UserType_C_KydBosyuuDairitenHyouji extends AbstractUserType<C_KydBosyuuDairitenHyouji> {

    @Override
    protected Class<C_KydBosyuuDairitenHyouji> returnType() {
        return C_KydBosyuuDairitenHyouji.class;
    }

    @Override
    protected C_KydBosyuuDairitenHyouji valueOf(String pValue) {
        return C_KydBosyuuDairitenHyouji.valueOf(pValue);
    }

    @Override
    protected String toString(C_KydBosyuuDairitenHyouji pValue) {
        return pValue.getValue();
    }
}
