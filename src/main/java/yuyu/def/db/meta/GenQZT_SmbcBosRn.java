package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import yuyu.def.db.entity.ZT_SmbcBosRn;

/**
 * ＳＭＢＣ募集テーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_SmbcBosRn extends AbstractExDBTable<ZT_SmbcBosRn> {

    public GenQZT_SmbcBosRn() {
        this("ZT_SmbcBosRn");
    }

    public GenQZT_SmbcBosRn(String pAlias) {
        super("ZT_SmbcBosRn", ZT_SmbcBosRn.class, pAlias);
    }

    public String ZT_SmbcBosRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebidkbn = new ExDBFieldString<>("zrnseihowebidkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkojincd = new ExDBFieldString<>("zrnseihowebkojincd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebitijihozonhyouji = new ExDBFieldString<>("zrnseihowebitijihozonhyouji", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebsekno = new ExDBFieldNumber<>("zrnseihowebsekno", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebcalckijyunymd = new ExDBFieldNumber<>("zrnseihowebcalckijyunymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknknnm = new ExDBFieldString<>("zrnseihowebhhknknnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknkjnm = new ExDBFieldString<>("zrnseihowebhhknkjnm", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebhhknseiymd = new ExDBFieldNumber<>("zrnseihowebhhknseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknseikbn = new ExDBFieldString<>("zrnseihowebhhknseikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebmrhkihontikucd = new ExDBFieldString<>("zrnseihowebmrhkihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknadr = new ExDBFieldString<>("zrnseihowebhhknadr", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykknnm = new ExDBFieldString<>("zrnseihowebkykknnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykkjnm = new ExDBFieldString<>("zrnseihowebkykkjnm", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebkyksyaseiymd = new ExDBFieldNumber<>("zrnseihowebkyksyaseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkyksyaseikbn = new ExDBFieldString<>("zrnseihowebkyksyaseikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykkihontikucd = new ExDBFieldString<>("zrnseihowebkykkihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykadr = new ExDBFieldString<>("zrnseihowebkykadr", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebhknsyuruino = new ExDBFieldNumber<>("zrnseihowebhknsyuruino", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhjkktkbn = new ExDBFieldString<>("zrnseihowebhjkktkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebhknkkn = new ExDBFieldNumber<>("zrnseihowebhknkkn", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebphrkkikn = new ExDBFieldNumber<>("zrnseihowebphrkkikn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhrkkaisuukbn = new ExDBFieldString<>("zrnseihowebhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhrkkeirokbn = new ExDBFieldString<>("zrnseihowebhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsdpdkbn = new ExDBFieldString<>("zrnseihowebsdpdkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebkihons = new ExDBFieldNumber<>("zrnseihowebkihons", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebnksyuruikbn = new ExDBFieldString<>("zrnseihowebnksyuruikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihoweblntkkbn = new ExDBFieldString<>("zrnseihoweblntkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebnkshrarihyj = new ExDBFieldString<>("zrnseihowebnkshrarihyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebmosno = new ExDBFieldNumber<>("zrnseihowebmosno", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebsekykkigenymd = new ExDBFieldNumber<>("zrnseihowebsekykkigenymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsksjsitencd = new ExDBFieldString<>("zrnseihowebsksjsitencd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsbuktnrkkbn = new ExDBFieldString<>("zrnseihowebsbuktnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsbukttdkkbn = new ExDBFieldString<>("zrnseihowebsbukttdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsbuktknnm = new ExDBFieldString<>("zrnseihowebsbuktknnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsbuktkjnm = new ExDBFieldString<>("zrnseihowebsbuktkjnm", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebsbuktseiymd = new ExDBFieldNumber<>("zrnseihowebsbuktseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebmosprtzmhyj = new ExDBFieldString<>("zrnseihowebmosprtzmhyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebfstmossksymd = new ExDBFieldNumber<>("zrnseihowebfstmossksymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhnsyukyktdkkbn = new ExDBFieldString<>("zrnseihowebhnsyukyktdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebbsyutrkno = new ExDBFieldString<>("zrnseihowebbsyutrkno", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhjnkitikbn = new ExDBFieldString<>("zrnseihowebhjnkitikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhjnkykhyj = new ExDBFieldString<>("zrnseihowebhjnkykhyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtksykmcd1 = new ExDBFieldString<>("zrnseihowebtksykmcd1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtksykmcd2 = new ExDBFieldString<>("zrnseihowebtksykmcd2", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtksykmcd3 = new ExDBFieldString<>("zrnseihowebtksykmcd3", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtksykmcd4 = new ExDBFieldString<>("zrnseihowebtksykmcd4", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtksykmcd5 = new ExDBFieldString<>("zrnseihowebtksykmcd5", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebteiwkkn = new ExDBFieldNumber<>("zrnseihowebteiwkkn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhkntelno = new ExDBFieldString<>("zrnseihowebhhkntelno", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkyktelno = new ExDBFieldString<>("zrnseihowebkyktelno", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebknhjnnm = new ExDBFieldString<>("zrnseihowebknhjnnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkjhjnnm = new ExDBFieldString<>("zrnseihowebkjhjnnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkndaihyounm = new ExDBFieldString<>("zrnseihowebkndaihyounm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkjdaihyounm = new ExDBFieldString<>("zrnseihowebkjdaihyounm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebdaihyouktgkkbn = new ExDBFieldString<>("zrnseihowebdaihyouktgkkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebsykihrkp1 = new ExDBFieldNumber<>("zrnseihowebsykihrkp1", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebmosp1 = new ExDBFieldNumber<>("zrnseihowebmosp1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtkiyougyoutaikbn = new ExDBFieldString<>("zrnseihowebtkiyougyoutaikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebpaperlessmoshyj = new ExDBFieldString<>("zrnseihowebpaperlessmoshyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebdatasousinzmhyj = new ExDBFieldString<>("zrnseihowebdatasousinzmhyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebdrtnskno = new ExDBFieldString<>("zrnseihowebdrtnskno", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsbnksyukbn = new ExDBFieldString<>("zrnseihowebsbnksyukbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebaatkisyaknyuucd = new ExDBFieldString<>("zrnseihowebaatkisyaknyuucd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkeihidouituhyj = new ExDBFieldString<>("zrnseihowebkeihidouituhyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsiteituukakbn = new ExDBFieldString<>("zrnseihowebsiteituukakbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebnykntuukakbn = new ExDBFieldString<>("zrnseihowebnykntuukakbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtargettkarihyj = new ExDBFieldString<>("zrnseihowebtargettkarihyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebtargettkkbn = new ExDBFieldString<>("zrnseihowebtargettkkbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebtargettkmkht = new ExDBFieldNumber<>("zrnseihowebtargettkmkht", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebnykntuukanykngk = new ExDBFieldNumber<>("zrnseihowebnykntuukanykngk", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebnykntukfsthrkp = new ExDBFieldNumber<>("zrnseihowebnykntukfsthrkp", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebnykntuknexthrkp = new ExDBFieldNumber<>("zrnseihowebnykntuknexthrkp", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebsaimankihyj = new ExDBFieldString<>("zrnseihowebsaimankihyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebrayhyj = new ExDBFieldString<>("zrnseihowebrayhyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebgnykntuknykngk = new ExDBFieldNumber<>("zrnseihowebgnykntuknykngk", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebgnykntukfsthrkp = new ExDBFieldNumber<>("zrnseihowebgnykntukfsthrkp", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebgnykntuknxthrkp = new ExDBFieldNumber<>("zrnseihowebgnykntuknxthrkp", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebgaikakihonp = new ExDBFieldNumber<>("zrnseihowebgaikakihonp", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkaigmehrtkarihyj = new ExDBFieldString<>("zrnseihowebkaigmehrtkarihyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebyenhsyutkarihyj = new ExDBFieldString<>("zrnseihowebyenhsyutkarihyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebgaikakihons = new ExDBFieldNumber<>("zrnseihowebgaikakihons", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebdai1hknkkn = new ExDBFieldNumber<>("zrnseihowebdai1hknkkn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkyksykgycd = new ExDBFieldString<>("zrnseihowebkyksykgycd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkknmskhjnkitikbn = new ExDBFieldString<>("zrnseihowebkknmskhjnkitikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykottmsk = new ExDBFieldString<>("zrnseihowebkykottmsk", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknsykgycd = new ExDBFieldString<>("zrnseihowebhhknsykgycd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhknmskhjnkitikbn = new ExDBFieldString<>("zrnseihowebhknmskhjnkitikbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknottmsk = new ExDBFieldString<>("zrnseihowebhhknottmsk", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhknnensyuukbn = new ExDBFieldString<>("zrnseihowebhhknnensyuukbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplhhknkjnm = new ExDBFieldString<>("zrnseihowebplhhknkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplkykkjnm = new ExDBFieldString<>("zrnseihowebplkykkjnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplhrkkeirokbn = new ExDBFieldString<>("zrnseihowebplhrkkeirokbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplsbuktnrkkbn = new ExDBFieldString<>("zrnseihowebplsbuktnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplsbukttdkkbn = new ExDBFieldString<>("zrnseihowebplsbukttdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplsbuktknnm = new ExDBFieldString<>("zrnseihowebplsbuktknnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplsbuktkjnm = new ExDBFieldString<>("zrnseihowebplsbuktkjnm", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebplsbuktseiymd = new ExDBFieldNumber<>("zrnseihowebplsbuktseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplhhkntelno = new ExDBFieldString<>("zrnseihowebplhhkntelno", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplkyktelno = new ExDBFieldString<>("zrnseihowebplkyktelno", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplkihontikucd = new ExDBFieldString<>("zrnseihowebplkihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebpltsinadrkai = new ExDBFieldString<>("zrnseihowebpltsinadrkai", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplhiikihontikucd = new ExDBFieldString<>("zrnseihowebplhiikihontikucd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebplhhknadr = new ExDBFieldString<>("zrnseihowebplhhknadr", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhnyppltzmhyj = new ExDBFieldString<>("zrnseihowebhnyppltzmhyj", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebssrndhbnwr = new ExDBFieldNumber<>("zrnseihowebssrndhbnwr", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebtrtrndhbnwr = new ExDBFieldNumber<>("zrnseihowebtrtrndhbnwr", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebsueokikkn = new ExDBFieldNumber<>("zrnseihowebsueokikkn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebmnkuktnrkkbn = new ExDBFieldString<>("zrnseihowebmnkuktnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebmnkukttdkkbn = new ExDBFieldString<>("zrnseihowebmnkukttdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebmnkuktknnm = new ExDBFieldString<>("zrnseihowebmnkuktknnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebmnkuktkjnm = new ExDBFieldString<>("zrnseihowebmnkuktkjnm", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebmnkuktseiymd = new ExDBFieldNumber<>("zrnseihowebmnkuktseiymd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebankenkanrino = new ExDBFieldString<>("zrnseihowebankenkanrino", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebikkatup = new ExDBFieldNumber<>("zrnseihowebikkatup", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebikkatubaraikbn = new ExDBFieldString<>("zrnseihowebikkatubaraikbn", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebiktbrikaisuu = new ExDBFieldNumber<>("zrnseihowebiktbrikaisuu", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebzennoup = new ExDBFieldNumber<>("zrnseihowebzennoup", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Long> zrnseihowebgaikazennoup = new ExDBFieldNumber<>("zrnseihowebgaikazennoup", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebzennoukkn = new ExDBFieldNumber<>("zrnseihowebzennoukkn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebzennouhyj = new ExDBFieldString<>("zrnseihowebzennouhyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkydbosyuukjncd = new ExDBFieldString<>("zrnseihowebkydbosyuukjncd", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzktrkmoskbn = new ExDBFieldString<>("zrnseihowebkzktrkmoskbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzktdkkbn1 = new ExDBFieldString<>("zrnseihowebkzktdkkbn1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzkknnm1 = new ExDBFieldString<>("zrnseihowebkzkknnm1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzkkjnm1 = new ExDBFieldString<>("zrnseihowebkzkkjnm1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzkseikbn1 = new ExDBFieldString<>("zrnseihowebkzkseikbn1", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebkzkseiymd1 = new ExDBFieldNumber<>("zrnseihowebkzkseiymd1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzkkykdoukyohyj1 = new ExDBFieldString<>("zrnseihowebkzkkykdoukyohyj1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzkyno1 = new ExDBFieldString<>("zrnseihowebkzkyno1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzkadr1 = new ExDBFieldString<>("zrnseihowebkzkadr1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkzktelno1 = new ExDBFieldString<>("zrnseihowebkzktelno1", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykdrtkkanouhyj = new ExDBFieldString<>("zrnseihowebkykdrtkkanouhyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhkndrtkkanouhyj = new ExDBFieldString<>("zrnseihowebhhkndrtkkanouhyj", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebdrtkkbn = new ExDBFieldString<>("zrnseihowebdrtkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebkykdrnrkkbn = new ExDBFieldString<>("zrnseihowebkykdrnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhkndrnrkkbn = new ExDBFieldString<>("zrnseihowebhhkndrnrkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhkndrtdkkbn = new ExDBFieldString<>("zrnseihowebhhkndrtdkkbn", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhkndrknnm = new ExDBFieldString<>("zrnseihowebhhkndrknnm", this);

    public final ExDBFieldString<ZT_SmbcBosRn, String> zrnseihowebhhkndrkjnm = new ExDBFieldString<>("zrnseihowebhhkndrkjnm", this);

    public final ExDBFieldNumber<ZT_SmbcBosRn, Integer> zrnseihowebhhkndrseiymd = new ExDBFieldNumber<>("zrnseihowebhhkndrseiymd", this);
}
