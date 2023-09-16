package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_OnlineLincSousinRn;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_OnlineLincSousinRn extends AbstractExDBTable<ZT_OnlineLincSousinRn> {

    public GenQZT_OnlineLincSousinRn() {
        this("ZT_OnlineLincSousinRn");
    }

    public GenQZT_OnlineLincSousinRn(String pAlias) {
        super("ZT_OnlineLincSousinRn", ZT_OnlineLincSousinRn.class, pAlias);
    }

    public String ZT_OnlineLincSousinRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrndatakbn = new ExDBFieldString<>("zrndatakbn", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnrecordsyubetukbn = new ExDBFieldString<>("zrnrecordsyubetukbn", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhenkoutype = new ExDBFieldString<>("zrnhenkoutype", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsyorikekkacd = new ExDBFieldString<>("zrnsyorikekkacd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsyorikekkaerrjiyuu = new ExDBFieldString<>("zrnsyorikekkaerrjiyuu", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsyorikekkaerrno = new ExDBFieldString<>("zrnsyorikekkaerrno", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnnayoserecordsuu = new ExDBFieldString<>("zrnnayoserecordsuu", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkanyuusyano = new ExDBFieldString<>("zrnkanyuusyano", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkyoukaisiyouknnm = new ExDBFieldString<>("zrnkyoukaisiyouknnm", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhhknseikbn = new ExDBFieldString<>("zrnhhknseikbn", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhhknseiymd = new ExDBFieldString<>("zrnhhknseiymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkyksyhhknsydouituhyouji = new ExDBFieldString<>("zrnkyksyhhknsydouituhyouji", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsousinmotokaisyacd = new ExDBFieldString<>("zrnsousinmotokaisyacd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhhknadrkn = new ExDBFieldString<>("zrnhhknadrkn", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsiginyuintkykntgkstr = new ExDBFieldString<>("zrnsiginyuintkykntgkstr", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsppinyuintkykntgkstr = new ExDBFieldString<>("zrnsppinyuintkykntgkstr", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsijnbyutkykntgkstr = new ExDBFieldString<>("zrnsijnbyutkykntgkstr", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsonotatokuyakuntgkstr = new ExDBFieldString<>("zrnsonotatokuyakuntgkstr", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrntrkmousideymd = new ExDBFieldString<>("zrntrkmousideymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnlincsyoriymd = new ExDBFieldString<>("zrnlincsyoriymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnyuyusiyouknnm = new ExDBFieldString<>("zrnyuyusiyouknnm", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkykkanrino = new ExDBFieldString<>("zrnkykkanrino", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhozenymd = new ExDBFieldString<>("zrnhozenymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkykknnm = new ExDBFieldString<>("zrnkykknnm", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhutuusbsstr = new ExDBFieldString<>("zrnhutuusbsstr", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnsgsbstr = new ExDBFieldString<>("zrnsgsbstr", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkakusyasiyouran = new ExDBFieldString<>("zrnkakusyasiyouran", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnmousideflg = new ExDBFieldString<>("zrnmousideflg", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnmousideflgsetymd = new ExDBFieldString<>("zrnmousideflgsetymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnmousideflgkaijyoymd = new ExDBFieldString<>("zrnmousideflgkaijyoymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnjgyhknflg = new ExDBFieldString<>("zrnjgyhknflg", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrntnknflg = new ExDBFieldString<>("zrntnknflg", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkyksyaseikbn = new ExDBFieldString<>("zrnkyksyaseikbn", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkykadrkn = new ExDBFieldString<>("zrnkykadrkn", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnyobiv17 = new ExDBFieldString<>("zrnyobiv17", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnknjhhknmei30 = new ExDBFieldString<>("zrnknjhhknmei30", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkjkyknm30 = new ExDBFieldString<>("zrnkjkyknm30", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrn15sai1000manflg = new ExDBFieldString<>("zrn15sai1000manflg", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkjhngflg = new ExDBFieldString<>("zrnkjhngflg", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnkykytymd = new ExDBFieldString<>("zrnkykytymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnhozenytymd = new ExDBFieldString<>("zrnhozenytymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrn15mimantkhukaymd = new ExDBFieldString<>("zrn15mimantkhukaymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrn15mimantkhukayoteiymd = new ExDBFieldString<>("zrn15mimantkhukayoteiymd", this);

    public final ExDBFieldString<ZT_OnlineLincSousinRn, String> zrnyobiv46 = new ExDBFieldString<>("zrnyobiv46", this);
}
