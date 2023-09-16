package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_KeikaKbn;

/**
 * 有効期間経過契約リスト扱者テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHT_YuukoukknKykListAtukaiSya extends AbstractExDBTable<HT_YuukoukknKykListAtukaiSya> {

    public GenQHT_YuukoukknKykListAtukaiSya() {
        this("HT_YuukoukknKykListAtukaiSya");
    }

    public GenQHT_YuukoukknKykListAtukaiSya(String pAlias) {
        super("HT_YuukoukknKykListAtukaiSya", HT_YuukoukknKykListAtukaiSya.class, pAlias);
    }

    public String HT_YuukoukknKykListAtukaiSya() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> mosno = new ExDBFieldString<>("mosno", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, BizDate> tyouhyouymd = new ExDBFieldString<>("tyouhyouymd", this, BizDateType.class);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, C_KeikaKbn> keikakbn = new ExDBFieldString<>("keikakbn", this, UserType_C_KeikaKbn.class);

    public final ExDBFieldNumber<HT_YuukoukknKykListAtukaiSya, Integer> renno = new ExDBFieldNumber<>("renno", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> kinyuucd = new ExDBFieldString<>("kinyuucd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> kinyuusitencd = new ExDBFieldString<>("kinyuusitencd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> drtencd = new ExDBFieldString<>("drtencd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> drtennm = new ExDBFieldString<>("drtennm", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> tratkiagcd = new ExDBFieldString<>("tratkiagcd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> tratkiagnm = new ExDBFieldString<>("tratkiagnm", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> oyadrtennm = new ExDBFieldString<>("oyadrtennm", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> jimusyocd = new ExDBFieldString<>("jimusyocd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> bosyuucd = new ExDBFieldString<>("bosyuucd", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> bosyuutrkno = new ExDBFieldString<>("bosyuutrkno", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> bosyuunm = new ExDBFieldString<>("bosyuunm", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<HT_YuukoukknKykListAtukaiSya, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
