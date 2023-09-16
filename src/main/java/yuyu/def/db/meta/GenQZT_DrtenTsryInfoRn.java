package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DrtenTsryInfoRn;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店手数料情報Ｆテーブル（連） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenTsryInfoRn extends AbstractExDBTable<ZT_DrtenTsryInfoRn> {

    public GenQZT_DrtenTsryInfoRn() {
        this("ZT_DrtenTsryInfoRn");
    }

    public GenQZT_DrtenTsryInfoRn(String pAlias) {
        super("ZT_DrtenTsryInfoRn", ZT_DrtenTsryInfoRn.class, pAlias);
    }

    public String ZT_DrtenTsryInfoRn() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrndairitencd = new ExDBFieldString<>("zrndairitencd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnbosyuunincd = new ExDBFieldString<>("zrnbosyuunincd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsyono = new ExDBFieldString<>("zrnsyono", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkeiyakukbn = new ExDBFieldString<>("zrnkeiyakukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntokuyakuno = new ExDBFieldString<>("zrntokuyakuno", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnbsyym = new ExDBFieldString<>("zrnbsyym", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkykymd = new ExDBFieldString<>("zrnkykymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkydatkibosyuucd = new ExDBFieldString<>("zrnkydatkibosyuucd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnseiritujibumoncd = new ExDBFieldString<>("zrnseiritujibumoncd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnseiritujiagutiknrcd = new ExDBFieldString<>("zrnseiritujiagutiknrcd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnyobiv1 = new ExDBFieldString<>("zrnyobiv1", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkydeigyouakojincd = new ExDBFieldString<>("zrnkydeigyouakojincd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkydeigyoubkojincd = new ExDBFieldString<>("zrnkydeigyoubkojincd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnskeihyj = new ExDBFieldString<>("zrnskeihyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrndenymd = new ExDBFieldString<>("zrndenymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkikaisyoriymd = new ExDBFieldString<>("zrnkikaisyoriymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsyoricd = new ExDBFieldString<>("zrnsyoricd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntyouseijiyuu = new ExDBFieldString<>("zrntyouseijiyuu", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnnyknmonth = new ExDBFieldString<>("zrnnyknmonth", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsikibetujyunjyo = new ExDBFieldString<>("zrnsikibetujyunjyo", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntnsmacezugkukbn = new ExDBFieldString<>("zrntnsmacezugkukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnacezugkkrykkaisiymd = new ExDBFieldString<>("zrnacezugkkrykkaisiymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnyobiv4 = new ExDBFieldString<>("zrnyobiv4", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnkykmfksnctrlkh = new ExDBFieldNumber<>("zrnkykmfksnctrlkh", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrndairitenatkikeitaikbn = new ExDBFieldString<>("zrndairitenatkikeitaikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, BizNumber> zrnatkiwari = new ExDBFieldString<>("zrnatkiwari", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrndairitenatkinin = new ExDBFieldNumber<>("zrndairitenatkinin", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrntsrkeisansyukykhsyos = new ExDBFieldNumber<>("zrntsrkeisansyukykhsyos", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnhtns = new ExDBFieldNumber<>("zrnhtns", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnkijymods = new ExDBFieldNumber<>("zrnkijymods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnksnbubunmods = new ExDBFieldNumber<>("zrnksnbubunmods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrkijymods = new ExDBFieldNumber<>("zrnbfrkijymods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrksnbubunmods = new ExDBFieldNumber<>("zrnbfrksnbubunmods", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhknsyukigou = new ExDBFieldString<>("zrnhknsyukigou", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhknsyuruikigousedaikbn = new ExDBFieldString<>("zrnhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntksyukgu = new ExDBFieldString<>("zrntksyukgu", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntksyukgusedaikbn = new ExDBFieldString<>("zrntksyukgusedaikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhrkkaisuukbn = new ExDBFieldString<>("zrnhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnannaifuyouriyuukbn = new ExDBFieldString<>("zrnannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhhknnen2keta = new ExDBFieldString<>("zrnhhknnen2keta", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhknkkn = new ExDBFieldString<>("zrnhknkkn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnfstkeijyouhtkm = new ExDBFieldString<>("zrnfstkeijyouhtkm", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntsrytsryhushrkbn = new ExDBFieldString<>("zrntsrytsryhushrkbn", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfritijibrzugkp = new ExDBFieldNumber<>("zrnbfritijibrzugkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmaruteisyuruikigou = new ExDBFieldString<>("zrnmaruteisyuruikigou", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmrtihukakbn = new ExDBFieldString<>("zrnmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsznmrtihukakbn = new ExDBFieldString<>("zrnsznmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnteigenmrtihukakbn = new ExDBFieldString<>("zrnteigenmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsyunyumrtihukakbn = new ExDBFieldString<>("zrnsyunyumrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkzkmrtihukakbn = new ExDBFieldString<>("zrnkzkmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntoksipmrtihukakbn = new ExDBFieldString<>("zrntoksipmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntoksipmrsyhukakbn = new ExDBFieldString<>("zrntoksipmrsyhukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmanskknmrtihukakbn = new ExDBFieldString<>("zrnmanskknmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkigsyunyumrtihukakbn = new ExDBFieldString<>("zrnkigsyunyumrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkigteigenmrtihukakbn = new ExDBFieldString<>("zrnkigteigenmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkignktkhukakbn = new ExDBFieldString<>("zrnkignktkhukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkigmrtihukakbn = new ExDBFieldString<>("zrnkigmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmrtisyukguyobiv1 = new ExDBFieldString<>("zrnmrtisyukguyobiv1", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmrtisyukguyobiv1x2 = new ExDBFieldString<>("zrnmrtisyukguyobiv1x2", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmrtisyukguyobiv1x3 = new ExDBFieldString<>("zrnmrtisyukguyobiv1x3", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmrtisyukguyobiv1x4 = new ExDBFieldString<>("zrnmrtisyukguyobiv1x4", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmrtisyukguyobiv1x5 = new ExDBFieldString<>("zrnmrtisyukguyobiv1x5", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnyobiv1x2 = new ExDBFieldString<>("zrnyobiv1x2", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkyknm = new ExDBFieldString<>("zrnkyknm", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkjkyknm = new ExDBFieldString<>("zrnkjkyknm", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhhknmei = new ExDBFieldString<>("zrnhhknmei", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnknjhhknmei = new ExDBFieldString<>("zrnknjhhknmei", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhrkkeirokbn = new ExDBFieldString<>("zrnhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnanniskcd = new ExDBFieldString<>("zrnanniskcd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkarikeijyoukbn = new ExDBFieldString<>("zrnkarikeijyoukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntuikakeijyouhyj = new ExDBFieldString<>("zrntuikakeijyouhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnksnhyj = new ExDBFieldString<>("zrnksnhyj", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrndai2ksnbubunmods = new ExDBFieldNumber<>("zrndai2ksnbubunmods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrndai2bfrksnbubunmods = new ExDBFieldNumber<>("zrndai2bfrksnbubunmods", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnphrkkikn = new ExDBFieldString<>("zrnphrkkikn", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnjissyuup = new ExDBFieldNumber<>("zrnjissyuup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrngntikktgtiryoutkp = new ExDBFieldNumber<>("zrngntikktgtiryoutkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrgntikktgtiryoutkp = new ExDBFieldNumber<>("zrnbfrgntikktgtiryoutkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrndairitenkbtinfo1 = new ExDBFieldString<>("zrndairitenkbtinfo1", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrndairitenkbtinfo2 = new ExDBFieldString<>("zrndairitenkbtinfo2", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrndairitenkbtinfo3 = new ExDBFieldString<>("zrndairitenkbtinfo3", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnsisttkp = new ExDBFieldNumber<>("zrnsisttkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnreguardtkp = new ExDBFieldNumber<>("zrnreguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnvguardtkp = new ExDBFieldNumber<>("zrnvguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrsisttkp = new ExDBFieldNumber<>("zrnbfrsisttkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrreguardtkp = new ExDBFieldNumber<>("zrnbfrreguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrvguardtkp = new ExDBFieldNumber<>("zrnbfrvguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrngtmtv = new ExDBFieldNumber<>("zrngtmtv", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnsyukeiyakup = new ExDBFieldNumber<>("zrnsyukeiyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrsyup = new ExDBFieldNumber<>("zrnbfrsyup", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, BizNumber> zrndairitentsratkiwari = new ExDBFieldString<>("zrndairitentsratkiwari", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnseirituymd = new ExDBFieldString<>("zrnseirituymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsekininkaisiymd = new ExDBFieldString<>("zrnsekininkaisiymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrncifcd = new ExDBFieldString<>("zrncifcd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnbankboskykkbn = new ExDBFieldString<>("zrnbankboskykkbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkykjiqpackhyj = new ExDBFieldString<>("zrnkykjiqpackhyj", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnitijibrzugkp = new ExDBFieldNumber<>("zrnitijibrzugkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrntuuintokuyakup = new ExDBFieldNumber<>("zrntuuintokuyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrtuuintkp = new ExDBFieldNumber<>("zrnbfrtuuintkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnsougousonsyoutokuyakup = new ExDBFieldNumber<>("zrnsougousonsyoutokuyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrsugusnsyutkp = new ExDBFieldNumber<>("zrnbfrsugusnsyutkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, BizNumber> zrnyoteiriritun5 = new ExDBFieldString<>("zrnyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyouikunenkintokuyakup = new ExDBFieldNumber<>("zrnyouikunenkintokuyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfryoiknktkp = new ExDBFieldNumber<>("zrnbfryoiknktkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrngntikktgtiryoutkntgk = new ExDBFieldNumber<>("zrngntikktgtiryoutkntgk", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkyksyaskinmeino = new ExDBFieldString<>("zrnkyksyaskinmeino", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhhknsakuinmeino = new ExDBFieldString<>("zrnhhknsakuinmeino", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsinkykbosyuoyadrtencd = new ExDBFieldString<>("zrnsinkykbosyuoyadrtencd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, BizNumber> zrnsyouhizeiritu = new ExDBFieldString<>("zrnsyouhizeiritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnmdhnaisyoumeicd = new ExDBFieldString<>("zrnmdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrncoolingofhyj = new ExDBFieldString<>("zrncoolingofhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsaimnkkykhyj = new ExDBFieldString<>("zrnsaimnkkykhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnpjytoym = new ExDBFieldString<>("zrnpjytoym", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnsskhntihrkkisukbn = new ExDBFieldString<>("zrnsskhntihrkkisukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnphenkanarihyj = new ExDBFieldString<>("zrnphenkanarihyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnhjnkykhyj = new ExDBFieldString<>("zrnhjnkykhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnbktgomeisaicalcjyun = new ExDBFieldString<>("zrnbktgomeisaicalcjyun", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnikkatubaraikbn = new ExDBFieldString<>("zrnikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnikkatubaraikaisuu = new ExDBFieldString<>("zrnikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnuktkid = new ExDBFieldString<>("zrnuktkid", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnkigmrsytkp = new ExDBFieldNumber<>("zrnkigmrsytkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrkigmrsytkp = new ExDBFieldNumber<>("zrnbfrkigmrsytkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkigmrsytkphrkkkn = new ExDBFieldString<>("zrnkigmrsytkphrkkkn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnyobiv5 = new ExDBFieldString<>("zrnyobiv5", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnphenkanbfrsyup = new ExDBFieldNumber<>("zrnphenkanbfrsyup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Integer> zrnyobin3 = new ExDBFieldNumber<>("zrnyobin3", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, BizNumber> zrntousyokykjikawaserate = new ExDBFieldString<>("zrntousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11 = new ExDBFieldNumber<>("zrnyobin11", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x2 = new ExDBFieldNumber<>("zrnyobin11x2", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x3 = new ExDBFieldNumber<>("zrnyobin11x3", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x4 = new ExDBFieldNumber<>("zrnyobin11x4", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x5 = new ExDBFieldNumber<>("zrnyobin11x5", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x6 = new ExDBFieldNumber<>("zrnyobin11x6", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x7 = new ExDBFieldNumber<>("zrnyobin11x7", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnyobin11x8 = new ExDBFieldNumber<>("zrnyobin11x8", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnshzirtstkjynymd = new ExDBFieldString<>("zrnshzirtstkjynymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnkyksyaseiymd = new ExDBFieldString<>("zrnkyksyaseiymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrntuukacd = new ExDBFieldString<>("zrntuukacd", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnsyukeiyakupkyktuuka = new ExDBFieldNumber<>("zrnsyukeiyakupkyktuuka", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoRn, Long> zrnbfrsyupkyktuuka = new ExDBFieldNumber<>("zrnbfrsyupkyktuuka", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, BizNumber> zrntekiyoukawaserate7keta = new ExDBFieldString<>("zrntekiyoukawaserate7keta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnyobiv22 = new ExDBFieldString<>("zrnyobiv22", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoRn, String> zrnyobiv83 = new ExDBFieldString<>("zrnyobiv83", this);
}
