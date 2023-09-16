package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_LincJyusinTr;

/**
 * ＬＩＮＣ受信内容反映テーブル（取） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_LincJyusinTr extends AbstractExDBTable<ZT_LincJyusinTr> {

    public GenQZT_LincJyusinTr() {
        this("ZT_LincJyusinTr");
    }

    public GenQZT_LincJyusinTr(String pAlias) {
        super("ZT_LincJyusinTr", ZT_LincJyusinTr.class, pAlias);
    }

    public String ZT_LincJyusinTr() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheadergyoumusyubetu = new ExDBFieldString<>("ztrheadergyoumusyubetu", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheaderrecordkbn = new ExDBFieldString<>("ztrheaderrecordkbn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheaderkaisyacd = new ExDBFieldString<>("ztrheaderkaisyacd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheadersousinymd = new ExDBFieldString<>("ztrheadersousinymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheaderdatasyubetu = new ExDBFieldString<>("ztrheaderdatasyubetu", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheaderkaitoukurikosi = new ExDBFieldString<>("ztrheaderkaitoukurikosi", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheadersyusindatasyubetu = new ExDBFieldString<>("ztrheadersyusindatasyubetu", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrheadersyusincircleno = new ExDBFieldString<>("ztrheadersyusincircleno", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsyoriymd = new ExDBFieldString<>("ztrsyoriymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrrenno10 = new ExDBFieldString<>("ztrrenno10", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztryobiv54 = new ExDBFieldString<>("ztryobiv54", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrdatakbn = new ExDBFieldString<>("ztrdatakbn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrrecordsyubetukbn = new ExDBFieldString<>("ztrrecordsyubetukbn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhenkoutype = new ExDBFieldString<>("ztrhenkoutype", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsyorikekkacd = new ExDBFieldString<>("ztrsyorikekkacd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsyorikekkaerrjiyuu = new ExDBFieldString<>("ztrsyorikekkaerrjiyuu", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsyorikekkaerrno = new ExDBFieldString<>("ztrsyorikekkaerrno", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrnayoserecordsuu = new ExDBFieldString<>("ztrnayoserecordsuu", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkanyuusyano = new ExDBFieldString<>("ztrkanyuusyano", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkyoukaisiyouknnm = new ExDBFieldString<>("ztrkyoukaisiyouknnm", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhhknseikbn = new ExDBFieldString<>("ztrhhknseikbn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhhknseiymd = new ExDBFieldString<>("ztrhhknseiymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkykymd = new ExDBFieldString<>("ztrkykymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkyksyhhknsydouituhyouji = new ExDBFieldString<>("ztrkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsousinmotokaisyacd = new ExDBFieldString<>("ztrsousinmotokaisyacd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhhknadrkn = new ExDBFieldString<>("ztrhhknadrkn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsiginyuintkykntgkstr = new ExDBFieldString<>("ztrsiginyuintkykntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsppinyuintkykntgkstr = new ExDBFieldString<>("ztrsppinyuintkykntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsijnbyutkykntgkstr = new ExDBFieldString<>("ztrsijnbyutkykntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsonotatokuyakuntgkstr = new ExDBFieldString<>("ztrsonotatokuyakuntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrtrkmousideymd = new ExDBFieldString<>("ztrtrkmousideymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrlincsyoriymd = new ExDBFieldString<>("ztrlincsyoriymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztryuyusiyouknnm = new ExDBFieldString<>("ztryuyusiyouknnm", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkykkanrino = new ExDBFieldString<>("ztrkykkanrino", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhozenymd = new ExDBFieldString<>("ztrhozenymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkykknnm = new ExDBFieldString<>("ztrkykknnm", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhutuusbsstr = new ExDBFieldString<>("ztrhutuusbsstr", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrsgsbstr = new ExDBFieldString<>("ztrsgsbstr", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkakusyasiyouran = new ExDBFieldString<>("ztrkakusyasiyouran", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrmousideflg = new ExDBFieldString<>("ztrmousideflg", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrmousideflgsetymd = new ExDBFieldString<>("ztrmousideflgsetymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrmousideflgkaijyoymd = new ExDBFieldString<>("ztrmousideflgkaijyoymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrjgyhknflg = new ExDBFieldString<>("ztrjgyhknflg", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrtnknflg = new ExDBFieldString<>("ztrtnknflg", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkyksyaseikbn = new ExDBFieldString<>("ztrkyksyaseikbn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkyksyaseiymd = new ExDBFieldString<>("ztrkyksyaseiymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkykadrkn = new ExDBFieldString<>("ztrkykadrkn", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztryobiv17 = new ExDBFieldString<>("ztryobiv17", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrknjhhknmei30 = new ExDBFieldString<>("ztrknjhhknmei30", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkjkyknm30 = new ExDBFieldString<>("ztrkjkyknm30", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztr15sai1000manflg = new ExDBFieldString<>("ztr15sai1000manflg", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkjhngflg = new ExDBFieldString<>("ztrkjhngflg", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrkykytymd = new ExDBFieldString<>("ztrkykytymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztrhozenytymd = new ExDBFieldString<>("ztrhozenytymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztr15mimantkhukaymd = new ExDBFieldString<>("ztr15mimantkhukaymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztr15mimantkhukayoteiymd = new ExDBFieldString<>("ztr15mimantkhukayoteiymd", this);

    public final ExDBFieldString<ZT_LincJyusinTr, String> ztryobiv46 = new ExDBFieldString<>("ztryobiv46", this);
}
