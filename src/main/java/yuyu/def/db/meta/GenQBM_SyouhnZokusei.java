package yuyu.def.db.meta;

import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.ExDBFieldBizCurrency;
import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.classification.C_DrtSyouhinSikibetuKbn;
import yuyu.def.classification.C_Gwhensyuuoutjyuni;
import yuyu.def.classification.C_HaitouKbn;
import yuyu.def.classification.C_HknkknBunruiKbn;
import yuyu.def.classification.C_HknsyuruiNo;
import yuyu.def.classification.C_IjitoukeiHokensyuruiKbn;
import yuyu.def.classification.C_IsatoukeiHokensyuruicd;
import yuyu.def.classification.C_KahiKbn;
import yuyu.def.classification.C_Kaiyakuhrtype;
import yuyu.def.classification.C_KihonssyuruiKbn;
import yuyu.def.classification.C_KokutiKbn;
import yuyu.def.classification.C_KoujyosyoumeipKbn;
import yuyu.def.classification.C_MousideIkouKbn;
import yuyu.def.classification.C_Nstkumu;
import yuyu.def.classification.C_PWaribikiKbn;
import yuyu.def.classification.C_PtratkituukasiteiKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_ShrtysyhknsyuKbn;
import yuyu.def.classification.C_Sisuukbn;
import yuyu.def.classification.C_Sknenkinsyu;
import yuyu.def.classification.C_SyutkKbn;
import yuyu.def.classification.C_TargetTkHukaKanouKbn;
import yuyu.def.classification.C_TkthknsyruitsnKbn;
import yuyu.def.classification.C_Tuukasyu;
import yuyu.def.classification.C_TyksenhokanhouKbn;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.classification.C_YoteirirituhendouKbn;
import yuyu.def.db.entity.BM_SyouhnZokusei;
import jp.co.slcs.swak.db.hibernate.usertype.BizCurrencyType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import yuyu.def.db.type.UserType_C_DrtSyouhinSikibetuKbn;
import yuyu.def.db.type.UserType_C_Gwhensyuuoutjyuni;
import yuyu.def.db.type.UserType_C_HaitouKbn;
import yuyu.def.db.type.UserType_C_HknkknBunruiKbn;
import yuyu.def.db.type.UserType_C_HknsyuruiNo;
import yuyu.def.db.type.UserType_C_IjitoukeiHokensyuruiKbn;
import yuyu.def.db.type.UserType_C_IsatoukeiHokensyuruicd;
import yuyu.def.db.type.UserType_C_KahiKbn;
import yuyu.def.db.type.UserType_C_Kaiyakuhrtype;
import yuyu.def.db.type.UserType_C_KihonssyuruiKbn;
import yuyu.def.db.type.UserType_C_KokutiKbn;
import yuyu.def.db.type.UserType_C_KoujyosyoumeipKbn;
import yuyu.def.db.type.UserType_C_MousideIkouKbn;
import yuyu.def.db.type.UserType_C_Nstkumu;
import yuyu.def.db.type.UserType_C_PWaribikiKbn;
import yuyu.def.db.type.UserType_C_PtratkituukasiteiKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_ShrtysyhknsyuKbn;
import yuyu.def.db.type.UserType_C_Sisuukbn;
import yuyu.def.db.type.UserType_C_Sknenkinsyu;
import yuyu.def.db.type.UserType_C_SyutkKbn;
import yuyu.def.db.type.UserType_C_TargetTkHukaKanouKbn;
import yuyu.def.db.type.UserType_C_TkthknsyruitsnKbn;
import yuyu.def.db.type.UserType_C_Tuukasyu;
import yuyu.def.db.type.UserType_C_TyksenhokanhouKbn;
import yuyu.def.db.type.UserType_C_UmuKbn;
import yuyu.def.db.type.UserType_C_YoteirirituhendouKbn;

/**
 * 商品属性マスタ のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQBM_SyouhnZokusei extends AbstractExDBTable<BM_SyouhnZokusei> {

    public GenQBM_SyouhnZokusei() {
        this("BM_SyouhnZokusei");
    }

    public GenQBM_SyouhnZokusei(String pAlias) {
        super("BM_SyouhnZokusei", BM_SyouhnZokusei.class, pAlias);
    }

    public String BM_SyouhnZokusei() {
        return getAliasExpression();
    }

    public final ExDBFieldString<BM_SyouhnZokusei, String> syouhncd = new ExDBFieldString<>("syouhncd", this);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> syouhnsdno = new ExDBFieldNumber<>("syouhnsdno", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> ryouritusdno = new ExDBFieldString<>("ryouritusdno", this);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> syohnsortno = new ExDBFieldNumber<>("syohnsortno", this);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> mossyohnsortno = new ExDBFieldNumber<>("mossyohnsortno", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> syouhnnm = new ExDBFieldString<>("syouhnnm", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> syouhnnmryaku = new ExDBFieldString<>("syouhnnmryaku", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> syouhnnmryaku5 = new ExDBFieldString<>("syouhnnmryaku5", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> syouhnnmsyouken = new ExDBFieldString<>("syouhnnmsyouken", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> syouhnnmworklist = new ExDBFieldString<>("syouhnnmworklist", this);

    public final ExDBFieldString<BM_SyouhnZokusei, BizDate> kykfromymd = new ExDBFieldString<>("kykfromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, BizDate> kyktoymd = new ExDBFieldString<>("kyktoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, BizDate> hyoujifromymd = new ExDBFieldString<>("hyoujifromymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, BizDate> hyoujitoymd = new ExDBFieldString<>("hyoujitoymd", this, BizDateType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_SyutkKbn> syutkkbn = new ExDBFieldString<>("syutkkbn", this, UserType_C_SyutkKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_HknsyuruiNo> hknsyuruino = new ExDBFieldString<>("hknsyuruino", this, UserType_C_HknsyuruiNo.class);

    public final ExDBFieldString<BM_SyouhnZokusei, String> toukeiyouhokensyuruikbn = new ExDBFieldString<>("toukeiyouhokensyuruikbn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_IjitoukeiHokensyuruiKbn> ijitoukeihokensyuruikbn = new ExDBFieldString<>("ijitoukeihokensyuruikbn", this, UserType_C_IjitoukeiHokensyuruiKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_IsatoukeiHokensyuruicd> isatoukeihokensyuruicd = new ExDBFieldString<>("isatoukeihokensyuruicd", this, UserType_C_IsatoukeiHokensyuruicd.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_YoteirirituhendouKbn> yoteirirituhendoukbn = new ExDBFieldString<>("yoteirirituhendoukbn", this, UserType_C_YoteirirituhendouKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> yoteirirituhosyoukkn = new ExDBFieldNumber<>("yoteirirituhosyoukkn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> yoteirirituminhosyouritu = new ExDBFieldString<>("yoteirirituminhosyouritu", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> nkgnshosyouritu = new ExDBFieldNumber<>("nkgnshosyouritu", this);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> dai1hknkkn = new ExDBFieldNumber<>("dai1hknkkn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_DrtSyouhinSikibetuKbn> drtsyouhinsikibetukbn = new ExDBFieldString<>("drtsyouhinsikibetukbn", this, UserType_C_DrtSyouhinSikibetuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, String> drthrkhouhoukbn = new ExDBFieldString<>("drthrkhouhoukbn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> drtplannmkbn = new ExDBFieldString<>("drtplannmkbn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Tuukasyu> tuukasyu = new ExDBFieldString<>("tuukasyu", this, UserType_C_Tuukasyu.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_PtratkituukasiteiKbn> ptratkituukasiteikbn = new ExDBFieldString<>("ptratkituukasiteikbn", this, UserType_C_PtratkituukasiteiKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> jikounensuu = new ExDBFieldNumber<>("jikounensuu", this);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> ntgksbairitu = new ExDBFieldString<>("ntgksbairitu", this, BizNumberType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sbhkuktumu = new ExDBFieldString<>("sbhkuktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sbkyuuhukinuktumu = new ExDBFieldString<>("sbkyuuhukinuktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sbhnknuktumu = new ExDBFieldString<>("sbhnknuktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sbuktumu = new ExDBFieldString<>("sbuktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> mnkuktumu = new ExDBFieldString<>("mnkuktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> siteidairiumu = new ExDBFieldString<>("siteidairiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kktumu = new ExDBFieldString<>("kktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> hjyumu = new ExDBFieldString<>("hjyumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> musenumu = new ExDBFieldString<>("musenumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> syokugyoukktumu = new ExDBFieldString<>("syokugyoukktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_KokutiKbn> kokutikbn = new ExDBFieldString<>("kokutikbn", this, UserType_C_KokutiKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sdumu = new ExDBFieldString<>("sdumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> pdumu = new ExDBFieldString<>("pdumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gijipdumu = new ExDBFieldString<>("gijipdumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> hokenkngkyakujyouumu = new ExDBFieldString<>("hokenkngkyakujyouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_HaitouKbn> haitoukbn = new ExDBFieldString<>("haitoukbn", this, UserType_C_HaitouKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> teikisiharaikinumu = new ExDBFieldString<>("teikisiharaikinumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kyhkataumu = new ExDBFieldString<>("kyhkataumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> syukyhkinkataumu = new ExDBFieldString<>("syukyhkinkataumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> rokudaildumu = new ExDBFieldString<>("rokudaildumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> khnkyhkgbairituumu = new ExDBFieldString<>("khnkyhkgbairituumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> itijibrumu = new ExDBFieldString<>("itijibrumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> heijyunbaraiumu = new ExDBFieldString<>("heijyunbaraiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> zennouumu = new ExDBFieldString<>("zennouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> itibuzennoutekiumu = new ExDBFieldString<>("itibuzennoutekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> zenkizennoutekiumu = new ExDBFieldString<>("zenkizennoutekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> ikkatubaraiumu = new ExDBFieldString<>("ikkatubaraiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> teikiikkatubaraiumu = new ExDBFieldString<>("teikiikkatubaraiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_PWaribikiKbn> pwaribikikbn = new ExDBFieldString<>("pwaribikikbn", this, UserType_C_PWaribikiKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> tkjyrmtekiumu = new ExDBFieldString<>("tkjyrmtekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> tkjyskgntekiumu = new ExDBFieldString<>("tkjyskgntekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> htnpbuitekiumu = new ExDBFieldString<>("htnpbuitekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> tokkoudosghtnptekiumu = new ExDBFieldString<>("tokkoudosghtnptekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> jkntekiumu = new ExDBFieldString<>("jkntekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> livtkumu = new ExDBFieldString<>("livtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kzktourokuserviceumu = new ExDBFieldString<>("kzktourokuserviceumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> stdrsktkumu = new ExDBFieldString<>("stdrsktkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kykdrtkykumu = new ExDBFieldString<>("kykdrtkykumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> pmnjtkumu = new ExDBFieldString<>("pmnjtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sknnkaisikitkumu = new ExDBFieldString<>("sknnkaisikitkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gaikatatkiumu = new ExDBFieldString<>("gaikatatkiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> hengakuumu = new ExDBFieldString<>("hengakuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> nsikoutkumu = new ExDBFieldString<>("nsikoutkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Nstkumu> nstkumu = new ExDBFieldString<>("nstkumu", this, UserType_C_Nstkumu.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> syksbyensitihsyutktekiumu = new ExDBFieldString<>("syksbyensitihsyutktekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> jyudkaigomehrtktekiumu = new ExDBFieldString<>("jyudkaigomehrtktekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> stknumu = new ExDBFieldString<>("stknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> apltekiumu = new ExDBFieldString<>("apltekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> jgyiktumu = new ExDBFieldString<>("jgyiktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> hutuusbhsyumu = new ExDBFieldString<>("hutuusbhsyumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sgsbhsyumu = new ExDBFieldString<>("sgsbhsyumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sougouiryhsyumu = new ExDBFieldString<>("sougouiryhsyumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> syuusinhknumu = new ExDBFieldString<>("syuusinhknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> yrhknumu = new ExDBFieldString<>("yrhknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> nkhknumu = new ExDBFieldString<>("nkhknumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sipnyukyhumu = new ExDBFieldString<>("sipnyukyhumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sgnyukyhumu = new ExDBFieldString<>("sgnyukyhumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> sjnyukyhumu = new ExDBFieldString<>("sjnyukyhumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gannyukyhumu = new ExDBFieldString<>("gannyukyhumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kihonsntgkumu = new ExDBFieldString<>("kihonsntgkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gansdkyhumu = new ExDBFieldString<>("gansdkyhumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> ganhsyngumu = new ExDBFieldString<>("ganhsyngumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> eightysaimnrytkumu = new ExDBFieldString<>("eightysaimnrytkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> saiteisknwtkumu = new ExDBFieldString<>("saiteisknwtkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> dountgkchkumu = new ExDBFieldString<>("dountgkchkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> doukknchkumu = new ExDBFieldString<>("doukknchkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> doukatachkumu = new ExDBFieldString<>("doukatachkumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> tyouhukuknyumu = new ExDBFieldString<>("tyouhukuknyumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> stsnumu = new ExDBFieldString<>("stsnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> nkgnstuusanumu = new ExDBFieldString<>("nkgnstuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> nenbtsousbustuusanumu = new ExDBFieldString<>("nenbtsousbustuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> soukktjituhsgktuusanumu = new ExDBFieldString<>("soukktjituhsgktuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> msnynenbtsbustuusanumu = new ExDBFieldString<>("msnynenbtsbustuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kktjituhsgk1tuusanumu = new ExDBFieldString<>("kktjituhsgk1tuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kktjituhsgk2tuusanumu = new ExDBFieldString<>("kktjituhsgk2tuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> itijibrptsnumu = new ExDBFieldString<>("itijibrptsnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_TkthknsyruitsnKbn> tkthknsyruitsnkbn = new ExDBFieldString<>("tkthknsyruitsnkbn", this, UserType_C_TkthknsyruitsnKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> yenhrkgktuusansiyouumu = new ExDBFieldString<>("yenhrkgktuusansiyouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kykdrtentuusanumu = new ExDBFieldString<>("kykdrtentuusanumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> pyennykntktekiumu = new ExDBFieldString<>("pyennykntktekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> yenshrtktekiumu = new ExDBFieldString<>("yenshrtktekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gaikanyuukintktekiumu = new ExDBFieldString<>("gaikanyuukintktekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> knrrenkatasyouhnumu = new ExDBFieldString<>("knrrenkatasyouhnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gstsumu = new ExDBFieldString<>("gstsumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> nenmnryumu = new ExDBFieldString<>("nenmnryumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Kaiyakuhrtype> kaiyakuhrtype = new ExDBFieldString<>("kaiyakuhrtype", this, UserType_C_Kaiyakuhrtype.class);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> kaiyakuhrbairitu = new ExDBFieldString<>("kaiyakuhrbairitu", this, BizNumberType.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> hukkatukanouy = new ExDBFieldNumber<>("hukkatukanouy", this);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> hukkatukanoum = new ExDBFieldNumber<>("hukkatukanoum", this);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> pratetani = new ExDBFieldString<>("pratetani", this, BizNumberType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> vratetani = new ExDBFieldString<>("vratetani", this, BizNumberType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> wratetani = new ExDBFieldString<>("wratetani", this, BizNumberType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_KihonssyuruiKbn> kihonssyuruikbn = new ExDBFieldString<>("kihonssyuruikbn", this, UserType_C_KihonssyuruiKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> gengakukahikbn = new ExDBFieldNumber<>("gengakukahikbn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_KahiKbn> pgengakukahikbn = new ExDBFieldString<>("pgengakukahikbn", this, UserType_C_KahiKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> hjnkykumukbn = new ExDBFieldString<>("hjnkykumukbn", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> creditcardhrtekiumu = new ExDBFieldString<>("creditcardhrtekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kouzahurikaebaraitekiumu = new ExDBFieldString<>("kouzahurikaebaraitekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> tsnshrgndgkhyoujiumu = new ExDBFieldString<>("tsnshrgndgkhyoujiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldBizCurrency<BM_SyouhnZokusei> tsnshrgndgk = new ExDBFieldBizCurrency<>("tsnshrgndgk", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> itjsytkkziumu = new ExDBFieldString<>("itjsytkkziumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gansknnkaisiymdumu = new ExDBFieldString<>("gansknnkaisiymdumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> gansknnkaisikeikanisuu = new ExDBFieldNumber<>("gansknnkaisikeikanisuu", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> gantkhktctrlumu = new ExDBFieldString<>("gantkhktctrlumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> iktpcalcssketasuu = new ExDBFieldNumber<>("iktpcalcssketasuu", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> tratkikanousinsahou = new ExDBFieldString<>("tratkikanousinsahou", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kostratkiumu = new ExDBFieldString<>("kostratkiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> kosmnrynen = new ExDBFieldNumber<>("kosmnrynen", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> shrtysysksumu = new ExDBFieldString<>("shrtysysksumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_ShrtysyhknsyuKbn> shrtysyhknsyukbn = new ExDBFieldString<>("shrtysyhknsyukbn", this, UserType_C_ShrtysyhknsyuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> synndkyfknshrskgnumu = new ExDBFieldString<>("synndkyfknshrskgnumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> dai1hknkknsbsyokuseiumu = new ExDBFieldString<>("dai1hknkknsbsyokuseiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_HknkknBunruiKbn> hknkknbunruikbn = new ExDBFieldString<>("hknkknbunruikbn", this, UserType_C_HknkknBunruiKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> mvatekiumu = new ExDBFieldString<>("mvatekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> mvatekikkn = new ExDBFieldNumber<>("mvatekikkn", this);

    public final ExDBFieldString<BM_SyouhnZokusei, BizNumber> mvatyouseijikou = new ExDBFieldString<>("mvatyouseijikou", this, BizNumberType.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> kaiyakukoujyoritutekiumu = new ExDBFieldString<>("kaiyakukoujyoritutekiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldNumber<BM_SyouhnZokusei, Integer> kaiyakukoujyoritutekikkn = new ExDBFieldNumber<>("kaiyakukoujyoritutekikkn", this);

    public final ExDBFieldBizCurrency<BM_SyouhnZokusei> tkbripfgk = new ExDBFieldBizCurrency<>("tkbripfgk", this);

    public final ExDBFieldBizCurrency<BM_SyouhnZokusei> hnnnbripfgk = new ExDBFieldBizCurrency<>("hnnnbripfgk", this);

    public final ExDBFieldBizCurrency<BM_SyouhnZokusei> nnbripfgk = new ExDBFieldBizCurrency<>("nnbripfgk", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Gwhensyuuoutjyuni> gwhensyuuoutjyuni = new ExDBFieldString<>("gwhensyuuoutjyuni", this, UserType_C_Gwhensyuuoutjyuni.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_KoujyosyoumeipKbn> koujyosyoumeipkbn = new ExDBFieldString<>("koujyosyoumeipkbn", this, UserType_C_KoujyosyoumeipKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> zeiseitekikakuumu = new ExDBFieldString<>("zeiseitekikakuumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> fatcataisyouumu = new ExDBFieldString<>("fatcataisyouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> aeoitaisyouumu = new ExDBFieldString<>("aeoitaisyouumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> houteityotkseiumu = new ExDBFieldString<>("houteityotkseiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Segcd> seg1cd = new ExDBFieldString<>("seg1cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Segcd> seg2cd = new ExDBFieldString<>("seg2cd", this, UserType_C_Segcd.class);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gwhknsyurui = new ExDBFieldString<>("gwhknsyurui", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gwhosyucd = new ExDBFieldString<>("gwhosyucd", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gwsyouhncd = new ExDBFieldString<>("gwsyouhncd", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gwsyouhnnm = new ExDBFieldString<>("gwsyouhnnm", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> hknsyuruikoujyosyoumei = new ExDBFieldString<>("hknsyuruikoujyosyoumei", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Sknenkinsyu> sknenkinsyu = new ExDBFieldString<>("sknenkinsyu", this, UserType_C_Sknenkinsyu.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> nkuktumu = new ExDBFieldString<>("nkuktumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_UmuKbn> tmttknhaibunwarisiteiumu = new ExDBFieldString<>("tmttknhaibunwarisiteiumu", this, UserType_C_UmuKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_TargetTkHukaKanouKbn> targettkhukakanoukbn = new ExDBFieldString<>("targettkhukakanoukbn", this, UserType_C_TargetTkHukaKanouKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_MousideIkouKbn> mousideikoukbn = new ExDBFieldString<>("mousideikoukbn", this, UserType_C_MousideIkouKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, String> yendthnksyouhncd = new ExDBFieldString<>("yendthnksyouhncd", this);

    public final ExDBFieldString<BM_SyouhnZokusei, C_Sisuukbn> sisuukbn = new ExDBFieldString<>("sisuukbn", this, UserType_C_Sisuukbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, C_TyksenhokanhouKbn> tyksenhokanhoukbn = new ExDBFieldString<>("tyksenhokanhoukbn", this, UserType_C_TyksenhokanhouKbn.class);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gyoumuKousinKinou = new ExDBFieldString<>("gyoumuKousinKinou", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gyoumuKousinsyaId = new ExDBFieldString<>("gyoumuKousinsyaId", this);

    public final ExDBFieldString<BM_SyouhnZokusei, String> gyoumuKousinTime = new ExDBFieldString<>("gyoumuKousinTime", this);
}
