package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.db.entity.HM_SkHokenSyuruiNo;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;

/**
 * 保険種類番号マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_SkHokenSyuruiNo extends AbstractExDBTable<HM_SkHokenSyuruiNo> {

    public GenQHM_SkHokenSyuruiNo() {
        this("HM_SkHokenSyuruiNo");
    }

    public GenQHM_SkHokenSyuruiNo(String pAlias) {
        super("HM_SkHokenSyuruiNo", HM_SkHokenSyuruiNo.class, pAlias);
    }

    public String HM_SkHokenSyuruiNo() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_SkHokenSyuruiNo, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldNumber<HM_SkHokenSyuruiNo, Integer> hknsyuruinosd = new ExDBFieldNumber<>("hknsyuruinosd", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, BizDate> hyoujifromymd = new ExDBFieldString<>("hyoujifromymd", this, BizDateType.class);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, BizDate> hyoujitoymd = new ExDBFieldString<>("hyoujitoymd", this, BizDateType.class);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, String> hknsyuruinm = new ExDBFieldString<>("hknsyuruinm", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, String> hknsyuruinmsyanaidisp = new ExDBFieldString<>("hknsyuruinmsyanaidisp", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, String> hknsyuruiworklist = new ExDBFieldString<>("hknsyuruiworklist", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, C_HknsyuruiNo> daihyouhknsyuruino = new ExDBFieldString<>("daihyouhknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, String> inputctrlsyouhncd = new ExDBFieldString<>("inputctrlsyouhncd", this);

    public final ExDBFieldNumber<HM_SkHokenSyuruiNo, Integer> inputctrlsyouhnsdno = new ExDBFieldNumber<>("inputctrlsyouhnsdno", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, String> dai1hknkknselect = new ExDBFieldString<>("dai1hknkknselect", this);

    public final ExDBFieldString<HM_SkHokenSyuruiNo, String> targettkmkhtselect = new ExDBFieldString<>("targettkmkhtselect", this);

    public final ExDBFieldNumber<HM_SkHokenSyuruiNo, Integer> syohnsortno = new ExDBFieldNumber<>("syohnsortno", this);
}
