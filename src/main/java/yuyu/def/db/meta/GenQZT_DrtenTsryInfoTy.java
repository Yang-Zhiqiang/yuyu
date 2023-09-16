package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_DrtenTsryInfoTy;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 代理店手数料情報Ｆテーブル（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_DrtenTsryInfoTy extends AbstractExDBTable<ZT_DrtenTsryInfoTy> {

    public GenQZT_DrtenTsryInfoTy() {
        this("ZT_DrtenTsryInfoTy");
    }

    public GenQZT_DrtenTsryInfoTy(String pAlias) {
        super("ZT_DrtenTsryInfoTy", ZT_DrtenTsryInfoTy.class, pAlias);
    }

    public String ZT_DrtenTsryInfoTy() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztydairitencd = new ExDBFieldString<>("ztydairitencd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztybosyuunincd = new ExDBFieldString<>("ztybosyuunincd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysyono = new ExDBFieldString<>("ztysyono", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykeiyakukbn = new ExDBFieldString<>("ztykeiyakukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytokuyakuno = new ExDBFieldString<>("ztytokuyakuno", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztybsyym = new ExDBFieldString<>("ztybsyym", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykykymd = new ExDBFieldString<>("ztykykymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykydatkibosyuucd = new ExDBFieldString<>("ztykydatkibosyuucd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyseiritujibumoncd = new ExDBFieldString<>("ztyseiritujibumoncd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyseiritujiagutiknrcd = new ExDBFieldString<>("ztyseiritujiagutiknrcd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyyobiv1 = new ExDBFieldString<>("ztyyobiv1", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykydeigyouakojincd = new ExDBFieldString<>("ztykydeigyouakojincd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykydeigyoubkojincd = new ExDBFieldString<>("ztykydeigyoubkojincd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyskeihyj = new ExDBFieldString<>("ztyskeihyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztydenymd = new ExDBFieldString<>("ztydenymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykikaisyoriymd = new ExDBFieldString<>("ztykikaisyoriymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysyoricd = new ExDBFieldString<>("ztysyoricd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytyouseijiyuu = new ExDBFieldString<>("ztytyouseijiyuu", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztynyknmonth = new ExDBFieldString<>("ztynyknmonth", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysikibetujyunjyo = new ExDBFieldString<>("ztysikibetujyunjyo", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytnsmacezugkukbn = new ExDBFieldString<>("ztytnsmacezugkukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyacezugkkrykkaisiymd = new ExDBFieldString<>("ztyacezugkkrykkaisiymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyyobiv4 = new ExDBFieldString<>("ztyyobiv4", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztykykmfksnctrlkh = new ExDBFieldNumber<>("ztykykmfksnctrlkh", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztydairitenatkikeitaikbn = new ExDBFieldString<>("ztydairitenatkikeitaikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, BizNumber> ztyatkiwari = new ExDBFieldString<>("ztyatkiwari", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztydairitenatkinin = new ExDBFieldNumber<>("ztydairitenatkinin", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztytsrkeisansyukykhsyos = new ExDBFieldNumber<>("ztytsrkeisansyukykhsyos", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyhtns = new ExDBFieldNumber<>("ztyhtns", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztykijymods = new ExDBFieldNumber<>("ztykijymods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyksnbubunmods = new ExDBFieldNumber<>("ztyksnbubunmods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrkijymods = new ExDBFieldNumber<>("ztybfrkijymods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrksnbubunmods = new ExDBFieldNumber<>("ztybfrksnbubunmods", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhknsyukigou = new ExDBFieldString<>("ztyhknsyukigou", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhknsyuruikigousedaikbn = new ExDBFieldString<>("ztyhknsyuruikigousedaikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytksyukgu = new ExDBFieldString<>("ztytksyukgu", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytksyukgusedaikbn = new ExDBFieldString<>("ztytksyukgusedaikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhrkkaisuukbn = new ExDBFieldString<>("ztyhrkkaisuukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyannaifuyouriyuukbn = new ExDBFieldString<>("ztyannaifuyouriyuukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhhknnen2keta = new ExDBFieldString<>("ztyhhknnen2keta", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhknkkn = new ExDBFieldString<>("ztyhknkkn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyfstkeijyouhtkm = new ExDBFieldString<>("ztyfstkeijyouhtkm", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytsrytsryhushrkbn = new ExDBFieldString<>("ztytsrytsryhushrkbn", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfritijibrzugkp = new ExDBFieldNumber<>("ztybfritijibrzugkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymaruteisyuruikigou = new ExDBFieldString<>("ztymaruteisyuruikigou", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymrtihukakbn = new ExDBFieldString<>("ztymrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysznmrtihukakbn = new ExDBFieldString<>("ztysznmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyteigenmrtihukakbn = new ExDBFieldString<>("ztyteigenmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysyunyumrtihukakbn = new ExDBFieldString<>("ztysyunyumrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykzkmrtihukakbn = new ExDBFieldString<>("ztykzkmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytoksipmrtihukakbn = new ExDBFieldString<>("ztytoksipmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytoksipmrsyhukakbn = new ExDBFieldString<>("ztytoksipmrsyhukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymanskknmrtihukakbn = new ExDBFieldString<>("ztymanskknmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykigsyunyumrtihukakbn = new ExDBFieldString<>("ztykigsyunyumrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykigteigenmrtihukakbn = new ExDBFieldString<>("ztykigteigenmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykignktkhukakbn = new ExDBFieldString<>("ztykignktkhukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykigmrtihukakbn = new ExDBFieldString<>("ztykigmrtihukakbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymrtisyukguyobiv1 = new ExDBFieldString<>("ztymrtisyukguyobiv1", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymrtisyukguyobiv1x2 = new ExDBFieldString<>("ztymrtisyukguyobiv1x2", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymrtisyukguyobiv1x3 = new ExDBFieldString<>("ztymrtisyukguyobiv1x3", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymrtisyukguyobiv1x4 = new ExDBFieldString<>("ztymrtisyukguyobiv1x4", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymrtisyukguyobiv1x5 = new ExDBFieldString<>("ztymrtisyukguyobiv1x5", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyyobiv1x2 = new ExDBFieldString<>("ztyyobiv1x2", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykyknm = new ExDBFieldString<>("ztykyknm", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykjkyknm = new ExDBFieldString<>("ztykjkyknm", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhhknmei = new ExDBFieldString<>("ztyhhknmei", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyknjhhknmei = new ExDBFieldString<>("ztyknjhhknmei", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhrkkeirokbn = new ExDBFieldString<>("ztyhrkkeirokbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyanniskcd = new ExDBFieldString<>("ztyanniskcd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykarikeijyoukbn = new ExDBFieldString<>("ztykarikeijyoukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytuikakeijyouhyj = new ExDBFieldString<>("ztytuikakeijyouhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyksnhyj = new ExDBFieldString<>("ztyksnhyj", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztydai2ksnbubunmods = new ExDBFieldNumber<>("ztydai2ksnbubunmods", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztydai2bfrksnbubunmods = new ExDBFieldNumber<>("ztydai2bfrksnbubunmods", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyphrkkikn = new ExDBFieldString<>("ztyphrkkikn", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyjissyuup = new ExDBFieldNumber<>("ztyjissyuup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztygntikktgtiryoutkp = new ExDBFieldNumber<>("ztygntikktgtiryoutkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrgntikktgtiryoutkp = new ExDBFieldNumber<>("ztybfrgntikktgtiryoutkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztydairitenkbtinfo1 = new ExDBFieldString<>("ztydairitenkbtinfo1", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztydairitenkbtinfo2 = new ExDBFieldString<>("ztydairitenkbtinfo2", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztydairitenkbtinfo3 = new ExDBFieldString<>("ztydairitenkbtinfo3", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztysisttkp = new ExDBFieldNumber<>("ztysisttkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyreguardtkp = new ExDBFieldNumber<>("ztyreguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyvguardtkp = new ExDBFieldNumber<>("ztyvguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrsisttkp = new ExDBFieldNumber<>("ztybfrsisttkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrreguardtkp = new ExDBFieldNumber<>("ztybfrreguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrvguardtkp = new ExDBFieldNumber<>("ztybfrvguardtkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztygtmtv = new ExDBFieldNumber<>("ztygtmtv", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztysyukeiyakup = new ExDBFieldNumber<>("ztysyukeiyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrsyup = new ExDBFieldNumber<>("ztybfrsyup", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, BizNumber> ztydairitentsratkiwari = new ExDBFieldString<>("ztydairitentsratkiwari", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyseirituymd = new ExDBFieldString<>("ztyseirituymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysekininkaisiymd = new ExDBFieldString<>("ztysekininkaisiymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztycifcd = new ExDBFieldString<>("ztycifcd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztybankboskykkbn = new ExDBFieldString<>("ztybankboskykkbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykykjiqpackhyj = new ExDBFieldString<>("ztykykjiqpackhyj", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyitijibrzugkp = new ExDBFieldNumber<>("ztyitijibrzugkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztytuuintokuyakup = new ExDBFieldNumber<>("ztytuuintokuyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrtuuintkp = new ExDBFieldNumber<>("ztybfrtuuintkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztysougousonsyoutokuyakup = new ExDBFieldNumber<>("ztysougousonsyoutokuyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrsugusnsyutkp = new ExDBFieldNumber<>("ztybfrsugusnsyutkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, BizNumber> ztyyoteiriritun5 = new ExDBFieldString<>("ztyyoteiriritun5", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyouikunenkintokuyakup = new ExDBFieldNumber<>("ztyyouikunenkintokuyakup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfryoiknktkp = new ExDBFieldNumber<>("ztybfryoiknktkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztygntikktgtiryoutkntgk = new ExDBFieldNumber<>("ztygntikktgtiryoutkntgk", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykyksyaskinmeino = new ExDBFieldString<>("ztykyksyaskinmeino", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhhknsakuinmeino = new ExDBFieldString<>("ztyhhknsakuinmeino", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysinkykbosyuoyadrtencd = new ExDBFieldString<>("ztysinkykbosyuoyadrtencd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, BizNumber> ztysyouhizeiritu = new ExDBFieldString<>("ztysyouhizeiritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztymdhnaisyoumeicd = new ExDBFieldString<>("ztymdhnaisyoumeicd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztycoolingofhyj = new ExDBFieldString<>("ztycoolingofhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysaimnkkykhyj = new ExDBFieldString<>("ztysaimnkkykhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztypjytoym = new ExDBFieldString<>("ztypjytoym", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztysskhntihrkkisukbn = new ExDBFieldString<>("ztysskhntihrkkisukbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyphenkanarihyj = new ExDBFieldString<>("ztyphenkanarihyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyhjnkykhyj = new ExDBFieldString<>("ztyhjnkykhyj", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztybktgomeisaicalcjyun = new ExDBFieldString<>("ztybktgomeisaicalcjyun", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyikkatubaraikbn = new ExDBFieldString<>("ztyikkatubaraikbn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyikkatubaraikaisuu = new ExDBFieldString<>("ztyikkatubaraikaisuu", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyuktkid = new ExDBFieldString<>("ztyuktkid", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztykigmrsytkp = new ExDBFieldNumber<>("ztykigmrsytkp", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrkigmrsytkp = new ExDBFieldNumber<>("ztybfrkigmrsytkp", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykigmrsytkphrkkkn = new ExDBFieldString<>("ztykigmrsytkphrkkkn", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyyobiv5 = new ExDBFieldString<>("ztyyobiv5", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyphenkanbfrsyup = new ExDBFieldNumber<>("ztyphenkanbfrsyup", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Integer> ztyyobin3 = new ExDBFieldNumber<>("ztyyobin3", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, BizNumber> ztytousyokykjikawaserate = new ExDBFieldString<>("ztytousyokykjikawaserate", this, BizNumberType.class);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11 = new ExDBFieldNumber<>("ztyyobin11", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x4 = new ExDBFieldNumber<>("ztyyobin11x4", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x5 = new ExDBFieldNumber<>("ztyyobin11x5", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x6 = new ExDBFieldNumber<>("ztyyobin11x6", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x7 = new ExDBFieldNumber<>("ztyyobin11x7", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztyyobin11x8 = new ExDBFieldNumber<>("ztyyobin11x8", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyshzirtstkjynymd = new ExDBFieldString<>("ztyshzirtstkjynymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztykyksyaseiymd = new ExDBFieldString<>("ztykyksyaseiymd", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztytuukacd = new ExDBFieldString<>("ztytuukacd", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztysyukeiyakupkyktuuka = new ExDBFieldNumber<>("ztysyukeiyakupkyktuuka", this);

    public final ExDBFieldNumber<ZT_DrtenTsryInfoTy, Long> ztybfrsyupkyktuuka = new ExDBFieldNumber<>("ztybfrsyupkyktuuka", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, BizNumber> ztytekiyoukawaserate7keta = new ExDBFieldString<>("ztytekiyoukawaserate7keta", this, BizNumberType.class);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyyobiv22 = new ExDBFieldString<>("ztyyobiv22", this);

    public final ExDBFieldString<ZT_DrtenTsryInfoTy, String> ztyyobiv83 = new ExDBFieldString<>("ztyyobiv83", this);
}
