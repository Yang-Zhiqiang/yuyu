package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.type.UserType_C_HnkSyuruiKbn;

/**
 * 契約保全変更履歴テーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_KhHenkouRireki extends AbstractExDBTable<IT_KhHenkouRireki> {

    public GenQIT_KhHenkouRireki() {
        this("IT_KhHenkouRireki");
    }

    public GenQIT_KhHenkouRireki(String pAlias) {
        super("IT_KhHenkouRireki", IT_KhHenkouRireki.class, pAlias);
    }

    public String IT_KhHenkouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_KhHenkouRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldNumber<IT_KhHenkouRireki, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> tablenm = new ExDBFieldString<>("tablenm", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> tableid = new ExDBFieldString<>("tableid", this);

    public final ExDBFieldString<IT_KhHenkouRireki, C_HnkSyuruiKbn> hnksyuruikbn = new ExDBFieldString<>("hnksyuruikbn", this, UserType_C_HnkSyuruiKbn.class);

    public final ExDBFieldString<IT_KhHenkouRireki, String> hanbetukoumokunm = new ExDBFieldString<>("hanbetukoumokunm", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> henkoukoumokuid = new ExDBFieldString<>("henkoukoumokuid", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> henkoukoumokunm = new ExDBFieldString<>("henkoukoumokunm", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> bfrnaiyouoriginal = new ExDBFieldString<>("bfrnaiyouoriginal", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> bfrnaiyou = new ExDBFieldString<>("bfrnaiyou", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> newnaiyouoriginal = new ExDBFieldString<>("newnaiyouoriginal", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> newnaiyou = new ExDBFieldString<>("newnaiyou", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_KhHenkouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
