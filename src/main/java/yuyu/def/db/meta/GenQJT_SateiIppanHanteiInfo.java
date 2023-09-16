package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.JT_SateiIppanHanteiInfo;

/**
 * 査定一般判定情報テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQJT_SateiIppanHanteiInfo extends AbstractExDBTable<JT_SateiIppanHanteiInfo> {

    public GenQJT_SateiIppanHanteiInfo() {
        this("JT_SateiIppanHanteiInfo");
    }

    public GenQJT_SateiIppanHanteiInfo(String pAlias) {
        super("JT_SateiIppanHanteiInfo", JT_SateiIppanHanteiInfo.class, pAlias);
    }

    public String JT_SateiIppanHanteiInfo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> skno = new ExDBFieldString<>("skno", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldNumber<JT_SateiIppanHanteiInfo, Integer> seikyuurirekino = new ExDBFieldNumber<>("seikyuurirekino", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuu1 = new ExDBFieldString<>("ippanhanteitensuu1", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteicomment1 = new ExDBFieldString<>("ippanhanteicomment1", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuu2 = new ExDBFieldString<>("ippanhanteitensuu2", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteicomment2 = new ExDBFieldString<>("ippanhanteicomment2", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuu3 = new ExDBFieldString<>("ippanhanteitensuu3", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteicomment3 = new ExDBFieldString<>("ippanhanteicomment3", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuu4 = new ExDBFieldString<>("ippanhanteitensuu4", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteicomment4 = new ExDBFieldString<>("ippanhanteicomment4", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuu5 = new ExDBFieldString<>("ippanhanteitensuu5", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteicomment5 = new ExDBFieldString<>("ippanhanteicomment5", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuu6 = new ExDBFieldString<>("ippanhanteitensuu6", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteicomment6 = new ExDBFieldString<>("ippanhanteicomment6", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteitensuugoukei = new ExDBFieldString<>("ippanhanteitensuugoukei", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> ippanhanteigoukeicomment = new ExDBFieldString<>("ippanhanteigoukeicomment", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> kossyoricd = new ExDBFieldString<>("kossyoricd", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> kossyorisscd = new ExDBFieldString<>("kossyorisscd", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<JT_SateiIppanHanteiInfo, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
