package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.IT_BAK_KhHenkouRireki;
import yuyu.def.db.type.UserType_C_HnkSyuruiKbn;

/**
 * 契約保全変更履歴バックアップテーブル のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQIT_BAK_KhHenkouRireki extends AbstractExDBTable<IT_BAK_KhHenkouRireki> {

    public GenQIT_BAK_KhHenkouRireki() {
        this("IT_BAK_KhHenkouRireki");
    }

    public GenQIT_BAK_KhHenkouRireki(String pAlias) {
        super("IT_BAK_KhHenkouRireki", IT_BAK_KhHenkouRireki.class, pAlias);
    }

    public String IT_BAK_KhHenkouRireki() {
        return getAliasExpression();
    }

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> kbnkey = new ExDBFieldString<>("kbnkey", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> syono = new ExDBFieldString<>("syono", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> trkssikibetukey = new ExDBFieldString<>("trkssikibetukey", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> henkousikibetukey = new ExDBFieldString<>("henkousikibetukey", this);

    public final ExDBFieldNumber<IT_BAK_KhHenkouRireki, Integer> renno3keta = new ExDBFieldNumber<>("renno3keta", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> tablenm = new ExDBFieldString<>("tablenm", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> tableid = new ExDBFieldString<>("tableid", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, C_HnkSyuruiKbn> hnksyuruikbn = new ExDBFieldString<>("hnksyuruikbn", this, UserType_C_HnkSyuruiKbn.class);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> hanbetukoumokunm = new ExDBFieldString<>("hanbetukoumokunm", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> henkoukoumokuid = new ExDBFieldString<>("henkoukoumokuid", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> henkoukoumokunm = new ExDBFieldString<>("henkoukoumokunm", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> bfrnaiyouoriginal = new ExDBFieldString<>("bfrnaiyouoriginal", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> bfrnaiyou = new ExDBFieldString<>("bfrnaiyou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> newnaiyouoriginal = new ExDBFieldString<>("newnaiyouoriginal", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> newnaiyou = new ExDBFieldString<>("newnaiyou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<IT_BAK_KhHenkouRireki, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
