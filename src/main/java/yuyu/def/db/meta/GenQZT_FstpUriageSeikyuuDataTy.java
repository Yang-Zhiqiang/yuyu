package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_FstpUriageSeikyuuDataTy;

/**
 * 初回保険料売上請求データテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_FstpUriageSeikyuuDataTy extends AbstractExDBTable<ZT_FstpUriageSeikyuuDataTy> {

    public GenQZT_FstpUriageSeikyuuDataTy() {
        this("ZT_FstpUriageSeikyuuDataTy");
    }

    public GenQZT_FstpUriageSeikyuuDataTy(String pAlias) {
        super("ZT_FstpUriageSeikyuuDataTy", ZT_FstpUriageSeikyuuDataTy.class, pAlias);
    }

    public String ZT_FstpUriageSeikyuuDataTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyrecordkbn = new ExDBFieldString<>("ztyrecordkbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyauthorikbn = new ExDBFieldString<>("ztyauthorikbn", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyuriageseikyuutorihikicd = new ExDBFieldString<>("ztyuriageseikyuutorihikicd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyyobiv14 = new ExDBFieldString<>("ztyyobiv14", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyuriagetaisyouym = new ExDBFieldString<>("ztyuriagetaisyouym", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyuriageymd6keta = new ExDBFieldString<>("ztyuriageymd6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztycreditkigyoucd = new ExDBFieldString<>("ztycreditkigyoucd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztycreditkessaiyouno = new ExDBFieldString<>("ztycreditkessaiyouno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyrecordno = new ExDBFieldString<>("ztyrecordno", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyyobiv3 = new ExDBFieldString<>("ztyyobiv3", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztycardyuukoukigen = new ExDBFieldString<>("ztycardyuukoukigen", this);

    public final ExDBFieldNumber<ZT_FstpUriageSeikyuuDataTy, Long> ztyseikyuukngk11keta = new ExDBFieldNumber<>("ztyseikyuukngk11keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyyobiv2 = new ExDBFieldString<>("ztyyobiv2", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztycreditkaiinnokami6keta = new ExDBFieldString<>("ztycreditkaiinnokami6keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyyobiv6 = new ExDBFieldString<>("ztyyobiv6", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztycreditkaiinnosimo4keta = new ExDBFieldString<>("ztycreditkaiinnosimo4keta", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyuriageseikyuuerrorcd = new ExDBFieldString<>("ztyuriageseikyuuerrorcd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyhurikaekekkacd = new ExDBFieldString<>("ztyhurikaekekkacd", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyfukusuukameitennokey = new ExDBFieldString<>("ztyfukusuukameitennokey", this);

    public final ExDBFieldString<ZT_FstpUriageSeikyuuDataTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);
}
