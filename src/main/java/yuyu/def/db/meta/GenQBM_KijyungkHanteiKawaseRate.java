package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.db.entity.BM_KijyungkHanteiKawaseRate;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_Tuukasyu;

/**
 * 基準額判定用為替レートマスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_KijyungkHanteiKawaseRate extends AbstractExDBTable<BM_KijyungkHanteiKawaseRate> {

    public GenQBM_KijyungkHanteiKawaseRate() {
        this("BM_KijyungkHanteiKawaseRate");
    }

    public GenQBM_KijyungkHanteiKawaseRate(String pAlias) {
        super("BM_KijyungkHanteiKawaseRate", BM_KijyungkHanteiKawaseRate.class, pAlias);
    }

    public String BM_KijyungkHanteiKawaseRate() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_KijyungkHanteiKawaseRate, String> kijunnendo = new ExDBFieldString<>("kijunnendo", this);

    public final ExDBFieldString<BM_KijyungkHanteiKawaseRate, C_Tuukasyu> kyktuukasyu = new ExDBFieldString<>("kyktuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_KijyungkHanteiKawaseRate, BizNumber> kjngkhntiyukawaserate = new ExDBFieldString<>("kjngkhntiyukawaserate", this, BizNumberType.class);
}
