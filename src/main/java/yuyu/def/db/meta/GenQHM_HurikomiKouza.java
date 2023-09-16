package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.classification.C_HrkmirninEditPtnKbn;
import yuyu.def.classification.C_NyktyhyoutKbn;
import yuyu.def.classification.C_TaisyouKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_YokinKbn;
import yuyu.def.db.entity.HM_HurikomiKouza;
import yuyu.def.db.type.UserType_C_HrkmirninEditPtnKbn;
import yuyu.def.db.type.UserType_C_NyktyhyoutKbn;
import yuyu.def.db.type.UserType_C_TaisyouKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_YokinKbn;

/**
 * 振込口座マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQHM_HurikomiKouza extends AbstractExDBTable<HM_HurikomiKouza> {

    public GenQHM_HurikomiKouza() {
        this("HM_HurikomiKouza");
    }

    public GenQHM_HurikomiKouza(String pAlias) {
        super("HM_HurikomiKouza", HM_HurikomiKouza.class, pAlias);
    }

    public String HM_HurikomiKouza() {
        return getAliasExpression();
    }

    public final ExDBFieldString<HM_HurikomiKouza, String> bankcd = new ExDBFieldString<>("bankcd", this);

    public final ExDBFieldString<HM_HurikomiKouza, String> sitencd = new ExDBFieldString<>("sitencd", this);

    public final ExDBFieldString<HM_HurikomiKouza, String> kouzano = new ExDBFieldString<>("kouzano", this);

    public final ExDBFieldString<HM_HurikomiKouza, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HM_HurikomiKouza, String> hrkmirnincd = new ExDBFieldString<>("hrkmirnincd", this);

    public final ExDBFieldString<HM_HurikomiKouza, C_YokinKbn> yokinkbn = new ExDBFieldString<>("yokinkbn", this, UserType_C_YokinKbn.class);

    public final ExDBFieldString<HM_HurikomiKouza, String> oyadrtencd = new ExDBFieldString<>("oyadrtencd", this);

    public final ExDBFieldString<HM_HurikomiKouza, String> nyuukinoyadrtennm = new ExDBFieldString<>("nyuukinoyadrtennm", this);

    public final ExDBFieldString<HM_HurikomiKouza, C_TaisyouKbn> oyadrtensyoritarget = new ExDBFieldString<>("oyadrtensyoritarget", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HM_HurikomiKouza, C_TaisyouKbn> jidonykntargethyouji = new ExDBFieldString<>("jidonykntargethyouji", this, UserType_C_TaisyouKbn.class);

    public final ExDBFieldString<HM_HurikomiKouza, C_HrkmirninEditPtnKbn> hrkmirnineditptnkbn = new ExDBFieldString<>("hrkmirnineditptnkbn", this, UserType_C_HrkmirninEditPtnKbn.class);

    public final ExDBFieldString<HM_HurikomiKouza, C_Tuukasyu> siteituuka = new ExDBFieldString<>("siteituuka", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<HM_HurikomiKouza, String> honkouzacd = new ExDBFieldString<>("honkouzacd", this);

    public final ExDBFieldString<HM_HurikomiKouza, C_NyktyhyoutKbn> nyktyhyoutkbn = new ExDBFieldString<>("nyktyhyoutkbn", this, UserType_C_NyktyhyoutKbn.class);
}
