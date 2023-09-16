package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_LincJyusinRn;

/**
 * ＬＩＮＣ受信内容反映テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_LincJyusinRn extends AbstractExDBTable<ZT_LincJyusinRn> {

    public GenQZT_LincJyusinRn() {
        this("ZT_LincJyusinRn");
    }

    public GenQZT_LincJyusinRn(String pAlias) {
        super("ZT_LincJyusinRn", ZT_LincJyusinRn.class, pAlias);
    }

    public String ZT_LincJyusinRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheadergyoumusyubetu = new ExDBFieldString<>("zrnheadergyoumusyubetu", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheaderrecordkbn = new ExDBFieldString<>("zrnheaderrecordkbn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheaderkaisyacd = new ExDBFieldString<>("zrnheaderkaisyacd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheadersousinymd = new ExDBFieldString<>("zrnheadersousinymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheaderdatasyubetu = new ExDBFieldString<>("zrnheaderdatasyubetu", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheaderkaitoukurikosi = new ExDBFieldString<>("zrnheaderkaitoukurikosi", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheadersyusindatasyubetu = new ExDBFieldString<>("zrnheadersyusindatasyubetu", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnheadersyusincircleno = new ExDBFieldString<>("zrnheadersyusincircleno", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsyoriymd = new ExDBFieldString<>("zrnsyoriymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnrenno10 = new ExDBFieldString<>("zrnrenno10", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnyobiv54 = new ExDBFieldString<>("zrnyobiv54", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrndatakbn = new ExDBFieldString<>("zrndatakbn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnrecordsyubetukbn = new ExDBFieldString<>("zrnrecordsyubetukbn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhenkoutype = new ExDBFieldString<>("zrnhenkoutype", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsyorikekkacd = new ExDBFieldString<>("zrnsyorikekkacd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsyorikekkaerrjiyuu = new ExDBFieldString<>("zrnsyorikekkaerrjiyuu", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsyorikekkaerrno = new ExDBFieldString<>("zrnsyorikekkaerrno", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnnayoserecordsuu = new ExDBFieldString<>("zrnnayoserecordsuu", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkanyuusyano = new ExDBFieldString<>("zrnkanyuusyano", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkyoukaisiyouknnm = new ExDBFieldString<>("zrnkyoukaisiyouknnm", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsousinmotokaisyacd = new ExDBFieldString<>("zrnsousinmotokaisyacd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhhknadrkn = new ExDBFieldString<>("zrnhhknadrkn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsiginyuintkykntgkstr = new ExDBFieldString<>("zrnsiginyuintkykntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsppinyuintkykntgkstr = new ExDBFieldString<>("zrnsppinyuintkykntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsijnbyutkykntgkstr = new ExDBFieldString<>("zrnsijnbyutkykntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsonotatokuyakuntgkstr = new ExDBFieldString<>("zrnsonotatokuyakuntgkstr", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrntrkmousideymd = new ExDBFieldString<>("zrntrkmousideymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnlincsyoriymd = new ExDBFieldString<>("zrnlincsyoriymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnyuyusiyouknnm = new ExDBFieldString<>("zrnyuyusiyouknnm", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkykkanrino = new ExDBFieldString<>("zrnkykkanrino", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhozenymd = new ExDBFieldString<>("zrnhozenymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkykknnm = new ExDBFieldString<>("zrnkykknnm", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhutuusbsstr = new ExDBFieldString<>("zrnhutuusbsstr", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnsgsbstr = new ExDBFieldString<>("zrnsgsbstr", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkakusyasiyouran = new ExDBFieldString<>("zrnkakusyasiyouran", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnmousideflg = new ExDBFieldString<>("zrnmousideflg", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnmousideflgsetymd = new ExDBFieldString<>("zrnmousideflgsetymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnmousideflgkaijyoymd = new ExDBFieldString<>("zrnmousideflgkaijyoymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnjgyhknflg = new ExDBFieldString<>("zrnjgyhknflg", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrntnknflg = new ExDBFieldString<>("zrntnknflg", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkykadrkn = new ExDBFieldString<>("zrnkykadrkn", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnknjhhknmei30 = new ExDBFieldString<>("zrnknjhhknmei30", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkjkyknm30 = new ExDBFieldString<>("zrnkjkyknm30", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrn15sai1000manflg = new ExDBFieldString<>("zrn15sai1000manflg", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkjhngflg = new ExDBFieldString<>("zrnkjhngflg", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnkykytymd = new ExDBFieldString<>("zrnkykytymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnhozenytymd = new ExDBFieldString<>("zrnhozenytymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrn15mimantkhukaymd = new ExDBFieldString<>("zrn15mimantkhukaymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrn15mimantkhukayoteiymd = new ExDBFieldString<>("zrn15mimantkhukayoteiymd", this);

    public final ExDBFieldString<ZT_LincJyusinRn, String> zrnyobiv46 = new ExDBFieldString<>("zrnyobiv46", this);
}
