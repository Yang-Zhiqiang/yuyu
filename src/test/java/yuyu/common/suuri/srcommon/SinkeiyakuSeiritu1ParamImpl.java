package yuyu.common.suuri.srcommon;

import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.web.ui.AbstractUiBean;

/**
 * 新契約成立１共通テーブルインターフェースの実装クラス
 */
public class SinkeiyakuSeiritu1ParamImpl extends AbstractUiBean
implements SinkeiyakuSeiritu1Param {

    private static final long serialVersionUID = 1L;

    private String pZtyktgysyrymd;
    private String pZtyktgysyono;
    private String pZtyktgyfilerenno;
    private String pZtysyono;
    private String pZtyaatukaisyasisyacd;
    private String pZtymosno;
    private String pZtyhknsyukigou;
    private String pZtykykymd;
    private String pZtyhknkkn;
    private String pZtyphrkkikn;
    private String pZtysaimnkkykhyj;
    private Long pZtykihons;
    private Long pZtysibous;
    private Long pZtygyousekihyoukayouhosyous;
    private Long pZtygukitnknitjbrkhns;
    private Long pZtygukitnknitjbrsbus;
    private Long pZtykktijgukitnknitjbrkhns;
    private Long pZtykktijgukitnknitjbrsbus;
    private Long pZtysyokaiharaikomip;
    private Long pZtysyukeiyakup;
    private String pZtyhrkkaisuukbn;
    private String pZtyhrkkeirokbn;
    private String pZtyryouritukbn;
    private String pZtytksyuannaikykkbn;
    private String pZtysdpdkbn;
    private String pZtyanniskcd;
    private String pZtyduketorihouhoukbn;
    private String pZtykyksyhhknsydouituhyouji;
    private String pZtykyksyakikykarihyj;
    private String pZtytenkankeiyakuhyouji;
    private String pZtyjigyoukeiyakuhyouji;
    private String pZtynenkinzeiseitokuyakukbn;
    private String pZtysyusseimaekanyuukykkbn;
    private String pZtykazokukeiyakuhyouji;
    private String pZtyjikokykhyj;
    private String pZtytuusyoumeisiyouhyouji;
    private String pZtysethokenkbn;
    private String pZtyteikeisyouhinkbn;
    private String pZtysykgycd;
    private Long pZtytokuninbosyuuteate;
    private String pZtyseisekiym;
    private Long pZtyseisekikeijyousyuuseis;
    private String pZtysyuuseissakugenhyouji;
    private String pZtyaatukaisisyatodouhukencd;
    private String pZtyaatukaisosikicd;
    private String pZtyaatukaikojincd;
    private String pZtybatukaisosikicd;
    private String pZtybatukaisyakojincd;
    private String pZtymarutokukbn;
    private String pZtygyoumujyouhyouji;
    private String pZtytuikakeijyoukbn;
    private String pZtyseisekinomikeijyoukbn;
    private String pZtyteikikeijyoukbn;
    private String pZtyhngkmskkatkisykbn;
    private String pZtytnknkyuuyosakugenhyj;
    private String pZtytenkankaisuu;
    private String pZtyhiyubrigssnsikkijyunkbn;
    private String pZtysekininkaisiymd;
    private String pZtykigetusmkrgkykhyj;
    private String pZtyhensyuusyoriymd;
    private String pZtyjisisyaatukaihyouji;
    private String pZtyaatkisytktntusy1atkihyj;
    private String pZtyaatkisytktntusy2atkihyj;
    private String pZtyaatkisyasyokan1atkihyj;
    private String pZtyaatkisyasyokan2atkihyj;
    private String pZtybatkisytktntusy1atkihyj;
    private String pZtybatkisytktntusy2atkihyj;
    private String pZtybatkisyasyokan1atkihyj;
    private String pZtybatkisyasyokan2atkihyj;
    private String pZtykeizokutyuuihyouji;
    private String pZtykeiyakubisiteihyouji;
    private String pZtyjyoukentukihyouji;
    private String pZtytokuninhyouji;
    private String pZtykessantyouseikbn;
    private String pZtyhaneihyouji;
    private String pZtysyukinkbn;
    private String pZtykeiyakusyasyokugyoucd;
    private String pZtyseikeikeirokbn;
    private String pZtydai2seikeikeirokbn;
    private String pZtyteigentokuteisyuruikigou;
    private String pZtyteigentokuteikikan;
    private Long pZtyteigentokuteis;
    private Long pZtyteigentokuteip;
    private String pZtytigntktisdtpdtkbn;
    private Long pZtyteigentokuteisyuuseis;
    private String pZtyteigentktimodssakugenhyj;
    private String pZtyteigentktikgusdkbn;
    private String pZtyyobiv9;
    private String pZtytokuteibuicdx1;
    private String pZtyhtnpkknx1;
    private String pZtytokuteibuicdx2;
    private String pZtyhtnpkknx2;
    private String pZtyhhknmei;
    private String pZtyknjhhknmei;
    private String pZtyhhknseiymd;
    private String pZtyhhknseikbn;
    private String pZtyhhknhnsktodouhukencd;
    private String pZtyhihokensyaagev2;
    private String pZtyhihokensyakikykarihyj;
    private String pZtynobikkosaimankikbn;
    private String pZtyhhknsysysnhonninkknnkbn;
    private String pZtyhhknsysisnhonninkknnkbn;
    private String pZtykzktourokuservicearihyj;
    private String pZtyyobiv4x12;
    private String pZtyhensyuukeiyakusyamei;
    private String pZtyhnsyuknjkyksynm;
    private String pZtykyksyaseiymd;
    private String pZtykyksyaseikbn;
    private String pZtykyksyanen;
    private String pZtyhknsyuruikigousedaikbn;
    private String pZtyknkuzusnzyrt;
    private String pZtyvitdoujimos2kenmeikouhyj;
    private String pZtykikykvitarituikamoshyj;
    private String pZtyhtnknkykvithokenkbn;
    private String pZtykikykvithokenhoyuujkkbn;
    private String pZtyyobiv2x2;
    private String pZtytsnsknewyno;
    private String pZtytsnsknewtikucd;
    private String pZtymossyumtkktymd;
    private String pZtykituenkbn;
    private String pZtytuusinsakijyuusyokbn;
    private String pZtymaruteisyuruikigou;
    private String pZtymaruteikikan;
    private String pZtymaruteiphrkkkn;
    private Long pZtymaruteis;
    private Long pZtymaruteip;
    private Long pZtymaruteisyuuseis;
    private String pZtymaruteisyuuseisskgnhyj;
    private String pZtymaruteitokujyoukbn;
    private String pZtymrtitkjyuskgnkkn;
    private Integer pZtymrtitkjyuryumshyutn;
    private Long pZtymaruteitokujyoup;
    private String pZtysuryumrtipwrbkkbn;
    private String pZtymaruteipwaribikikbn;
    private String pZtymrtitnknyugukbn;
    private String pZtymaruteikigousedaikbn;
    private String pZtymaruteikikousnmnryoage;
    private String pZtyyobiv2;
    private String pZtymaruyousyuruikigou;
    private String pZtymaruyoukikan;
    private Long pZtymaruyous;
    private Long pZtymaruyoup;
    private String pZtymaruyousdatepdatekbn;
    private Long pZtymaruyousyuuseis;
    private String pZtymaruyousyuuseisskgnhyj;
    private String pZtymaruyoukigousedaikbn;
    private String pZtyyobiv9x3;
    private String pZtymarusyuusyuruikigou;
    private String pZtymarusyuukikan;
    private Long pZtymarusyuus;
    private Long pZtymarusyuup;
    private String pZtymarusyuusdatepdatekbn;
    private Long pZtymarusyuusyuuseis;
    private String pZtymarusyuusyuuseisskgnhyj;
    private String pZtymarusyuukigousedaikbn;
    private String pZtyyobiv9x4;
    private String pZtytokuteisyuruikigou;
    private String pZtytokuteikikan;
    private Long pZtytokuteis;
    private Long pZtytokuteip;
    private String pZtytokuteisdatepdatekbn;
    private Long pZtytokuteisyuuseis;
    private String pZtytokuteisyuuseisskgnhyj;
    private String pZtytokuteikigousedaikbn;
    private String pZtyyobiv9x5;
    private String pZtykzkmrtitkyknox1;
    private String pZtykazokumrtisyuruikgux1;
    private String pZtykazokumaruteikikanx1;
    private String pZtykazokumrtiphrkkknx1;
    private Long pZtykazokumaruteisx1;
    private Long pZtykazokumaruteipx1;
    private String pZtykzkmrtihihknsyanmx1;
    private String pZtykzkmrtihihknsyseiymdx1;
    private String pZtykzkmrtihihknsysibtkbnx1;
    private String pZtykazokumrtihihknsyaagex1;
    private Long pZtykzkmrtimodsx1;
    private String pZtykazokumrtimodsskgnhyjx1;
    private String pZtykzkmrtitnknyugukbnx1;
    private String pZtykazokumrtikgusdkbnx1;
    private String pZtykazokumrtiagetyusihyjx1;
    private String pZtykzkmrtikusnmnryoagex1;
    private String pZtyyobiv4;
    private String pZtykzkmrtitkyknox2;
    private String pZtykazokumrtisyuruikgux2;
    private String pZtykazokumaruteikikanx2;
    private String pZtykazokumrtiphrkkknx2;
    private Long pZtykazokumaruteisx2;
    private Long pZtykazokumaruteipx2;
    private String pZtykzkmrtihihknsyanmx2;
    private String pZtykzkmrtihihknsyseiymdx2;
    private String pZtykzkmrtihihknsysibtkbnx2;
    private String pZtykazokumrtihihknsyaagex2;
    private Long pZtykzkmrtimodsx2;
    private String pZtykazokumrtimodsskgnhyjx2;
    private String pZtykzkmrtitnknyugukbnx2;
    private String pZtykazokumrtikgusdkbnx2;
    private String pZtykazokumrtiagetyusihyjx2;
    private String pZtykzkmrtikusnmnryoagex2;
    private String pZtyyobiv4x2;
    private String pZtykzkmrtitkyknox3;
    private String pZtykazokumrtisyuruikgux3;
    private String pZtykazokumaruteikikanx3;
    private String pZtykazokumrtiphrkkknx3;
    private Long pZtykazokumaruteisx3;
    private Long pZtykazokumaruteipx3;
    private String pZtykzkmrtihihknsyanmx3;
    private String pZtykzkmrtihihknsyseiymdx3;
    private String pZtykzkmrtihihknsysibtkbnx3;
    private String pZtykazokumrtihihknsyaagex3;
    private Long pZtykzkmrtimodsx3;
    private String pZtykazokumrtimodsskgnhyjx3;
    private String pZtykzkmrtitnknyugukbnx3;
    private String pZtykazokumrtikgusdkbnx3;
    private String pZtykazokumrtiagetyusihyjx3;
    private String pZtykzkmrtikusnmnryoagex3;
    private String pZtyyobiv4x3;
    private String pZtykzkmrtitkyknox4;
    private String pZtykazokumrtisyuruikgux4;
    private String pZtykazokumaruteikikanx4;
    private String pZtykazokumrtiphrkkknx4;
    private Long pZtykazokumaruteisx4;
    private Long pZtykazokumaruteipx4;
    private String pZtykzkmrtihihknsyanmx4;
    private String pZtykzkmrtihihknsyseiymdx4;
    private String pZtykzkmrtihihknsysibtkbnx4;
    private String pZtykazokumrtihihknsyaagex4;
    private Long pZtykzkmrtimodsx4;
    private String pZtykazokumrtimodsskgnhyjx4;
    private String pZtykzkmrtitnknyugukbnx4;
    private String pZtykazokumrtikgusdkbnx4;
    private String pZtykazokumrtiagetyusihyjx4;
    private String pZtykzkmrtikusnmnryoagex4;
    private String pZtyyobiv4x4;
    private String pZtykzkmrtitkyknox5;
    private String pZtykazokumrtisyuruikgux5;
    private String pZtykazokumaruteikikanx5;
    private String pZtykazokumrtiphrkkknx5;
    private Long pZtykazokumaruteisx5;
    private Long pZtykazokumaruteipx5;
    private String pZtykzkmrtihihknsyanmx5;
    private String pZtykzkmrtihihknsyseiymdx5;
    private String pZtykzkmrtihihknsysibtkbnx5;
    private String pZtykazokumrtihihknsyaagex5;
    private Long pZtykzkmrtimodsx5;
    private String pZtykazokumrtimodsskgnhyjx5;
    private String pZtykzkmrtitnknyugukbnx5;
    private String pZtykazokumrtikgusdkbnx5;
    private String pZtykazokumrtiagetyusihyjx5;
    private String pZtykzkmrtikusnmnryoagex5;
    private String pZtyyobiv4x5;
    private String pZtykzkmrtitkyknox6;
    private String pZtykazokumrtisyuruikgux6;
    private String pZtykazokumaruteikikanx6;
    private String pZtykazokumrtiphrkkknx6;
    private Long pZtykazokumaruteisx6;
    private Long pZtykazokumaruteipx6;
    private String pZtykzkmrtihihknsyanmx6;
    private String pZtykzkmrtihihknsyseiymdx6;
    private String pZtykzkmrtihihknsysibtkbnx6;
    private String pZtykazokumrtihihknsyaagex6;
    private Long pZtykzkmrtimodsx6;
    private String pZtykazokumrtimodsskgnhyjx6;
    private String pZtykzkmrtitnknyugukbnx6;
    private String pZtykazokumrtikgusdkbnx6;
    private String pZtykazokumrtiagetyusihyjx6;
    private String pZtykzkmrtikusnmnryoagex6;
    private String pZtyyobiv4x6;
    private String pZtykzkmrtitkyknox7;
    private String pZtykazokumrtisyuruikgux7;
    private String pZtykazokumaruteikikanx7;
    private String pZtykazokumrtiphrkkknx7;
    private Long pZtykazokumaruteisx7;
    private Long pZtykazokumaruteipx7;
    private String pZtykzkmrtihihknsyanmx7;
    private String pZtykzkmrtihihknsyseiymdx7;
    private String pZtykzkmrtihihknsysibtkbnx7;
    private String pZtykazokumrtihihknsyaagex7;
    private Long pZtykzkmrtimodsx7;
    private String pZtykazokumrtimodsskgnhyjx7;
    private String pZtykzkmrtitnknyugukbnx7;
    private String pZtykazokumrtikgusdkbnx7;
    private String pZtykazokumrtiagetyusihyjx7;
    private String pZtykzkmrtikusnmnryoagex7;
    private String pZtyyobiv4x7;
    private String pZtykzkmrtitkyknox8;
    private String pZtykazokumrtisyuruikgux8;
    private String pZtykazokumaruteikikanx8;
    private String pZtykazokumrtiphrkkknx8;
    private Long pZtykazokumaruteisx8;
    private Long pZtykazokumaruteipx8;
    private String pZtykzkmrtihihknsyanmx8;
    private String pZtykzkmrtihihknsyseiymdx8;
    private String pZtykzkmrtihihknsysibtkbnx8;
    private String pZtykazokumrtihihknsyaagex8;
    private Long pZtykzkmrtimodsx8;
    private String pZtykazokumrtimodsskgnhyjx8;
    private String pZtykzkmrtitnknyugukbnx8;
    private String pZtykazokumrtikgusdkbnx8;
    private String pZtykazokumrtiagetyusihyjx8;
    private String pZtykzkmrtikusnmnryoagex8;
    private String pZtyyobiv4x8;
    private String pZtykzkmrtitkyknox9;
    private String pZtykazokumrtisyuruikgux9;
    private String pZtykazokumaruteikikanx9;
    private String pZtykazokumrtiphrkkknx9;
    private Long pZtykazokumaruteisx9;
    private Long pZtykazokumaruteipx9;
    private String pZtykzkmrtihihknsyanmx9;
    private String pZtykzkmrtihihknsyseiymdx9;
    private String pZtykzkmrtihihknsysibtkbnx9;
    private String pZtykazokumrtihihknsyaagex9;
    private Long pZtykzkmrtimodsx9;
    private String pZtykazokumrtimodsskgnhyjx9;
    private String pZtykzkmrtitnknyugukbnx9;
    private String pZtykazokumrtikgusdkbnx9;
    private String pZtykazokumrtiagetyusihyjx9;
    private String pZtykzkmrtikusnmnryoagex9;
    private String pZtyyobiv4x9;
    private String pZtykzkmrtitkyknox10;
    private String pZtykazokumrtisyuruikgux10;
    private String pZtykazokumaruteikikanx10;
    private String pZtykazokumrtiphrkkknx10;
    private Long pZtykazokumaruteisx10;
    private Long pZtykazokumaruteipx10;
    private String pZtykzkmrtihihknsyanmx10;
    private String pZtykzkmrtihihknsyseiymdx10;
    private String pZtykzkmrtihihknsysibtkbnx10;
    private String pZtykazokumrtihihknsyaagex10;
    private Long pZtykzkmrtimodsx10;
    private String pZtykazokumrtimodsskgnhyjx10;
    private String pZtykzkmrtitnknyugukbnx10;
    private String pZtykazokumrtikgusdkbnx10;
    private String pZtykazokumrtiagetyusihyjx10;
    private String pZtykzkmrtikusnmnryoagex10;
    private String pZtyyobiv4x10;
    private String pZtynkshrtkykhuhokbnx1;
    private String pZtynkshrtkyknksyuruikbnx1;
    private String pZtynkshrtkyknkkknx1;
    private Long pZtynkshrtkyknknengkx1;
    private String pZtynkshrtkykduketorihhkbnx1;
    private String pZtyyobiv10;
    private String pZtynkshrtkykhuhokbnx2;
    private String pZtynkshrtkyknksyuruikbnx2;
    private String pZtynkshrtkyknkkknx2;
    private Long pZtynkshrtkyknknengkx2;
    private String pZtynkshrtkykduketorihhkbnx2;
    private String pZtyyobiv10x2;
    private String pZtysyougaitkyksyuruikgu;
    private String pZtysyougaitokuyakukikan;
    private String pZtysyougaitkykphrkkkn;
    private Long pZtysyougaitokuyakus;
    private Long pZtysyougaitokuyakup;
    private String pZtysyougaitkkatakbn;
    private String pZtysyougaitkykkgusdkbn;
    private String pZtysyugitkykpwrbkkbn;
    private String pZtysyougaitkykkusnmnryoage;
    private String pZtyyobiv5x2;
    private String pZtysigiwrmstkyksyuruikgu;
    private String pZtysigiwrmstkykkkn;
    private String pZtysaigaiwrmstkykphrkkkn;
    private Long pZtysaigaiwarimasitokuyakus;
    private Long pZtysaigaiwarimasitokuyakup;
    private String pZtysaigaiwrmstkykkgusdkbn;
    private String pZtysigiwrmstkykpwrbkkbn;
    private String pZtysigiwrmstkykkusnmnryoage;
    private String pZtyyobiv5x3;
    private String pZtysiginyuintkyksyuruikgu;
    private String pZtysiginyuintkykkkn;
    private String pZtysaigainyuintkykphrkkkn;
    private Integer pZtysiginyuintkykntgk;
    private String pZtysiginyuintkykgtkbn;
    private Long pZtysaigainyuuintokuyakup;
    private String pZtysaigainyuintkykkgusdkbn;
    private String pZtysiginyuintkykpwrbkkbn;
    private String pZtyyobiv7;
    private String pZtysppinyuintkyksyuruikgu;
    private String pZtysppinyuintkykkkn;
    private String pZtysppinyuuintkykphrkkkn;
    private Integer pZtysppinyuintkykntgk;
    private String pZtysppinyuintkykgtkbn;
    private Long pZtysippeinyuuintokuyakup;
    private Integer pZtysppinyuintkjyuryumshyutn;
    private Long pZtysippeinyuuintokujyoup;
    private String pZtysppinyuintktbicdx1;
    private String pZtysppinyuinhtnpkknx1;
    private String pZtysppinyuintktbicdx2;
    private String pZtysppinyuinhtnpkknx2;
    private String pZtysppinyuuintkykkgusdkbn;
    private String pZtysppinyuintkykpwrbkkbn;
    private String pZtyyobiv7x2;
    private String pZtysijnbyutkyksyuruikgu;
    private String pZtyseijinbyoutokuyakukikan;
    private String pZtyseijinbyoutkykphrkkkn;
    private Integer pZtyseijinbyoutokuyakuntgk;
    private Long pZtyseijinbyoutokuyakup;
    private Integer pZtysijnbyutkjyuryumshyutn;
    private Long pZtyseijinbyoutokujyoup;
    private String pZtyseijinbyoutokuteibuicdx1;
    private String pZtyseijinbyouhutanpokikanx1;
    private String pZtyseijinbyoutokuteibuicdx2;
    private String pZtyseijinbyouhutanpokikanx2;
    private String pZtyseijinbyoutkykkgusdkbn;
    private String pZtysijnbyutkykgankyuhgtkbn;
    private String pZtysijnbyutkykpwrbkkbn;
    private String pZtysijnbyutkykkusnmnryoage;
    private String pZtyyobiv4x11;
    private String pZtyheiyoubaraikbn;
    private String pZtyhiyubriaitsyono;
    private String pZtyhiyubriaithrkkeirokbn;
    private Long pZtyheiyoubaraiaitekihons;
    private Long pZtyhiyubrigukitnknitjbrkhns;
    private Long pZtyheiyoubaraiaitesibous;
    private Long pZtyhiyubrigukitnknitjbrsbus;
    private Long pZtyheiyoubaraiaitesyuuseis;
    private Long pZtyheiyoubaraiaitehrkp;
    private Long pZtyhiyubriaitsykykp;
    private Long pZtyheiyoubaraiaitemrtis;
    private Long pZtyhiyubrigukiaitkzkmrtis;
    private String pZtytukibaraikyktenkanhyj;
    private String pZtybonusharaihrkkigetu1;
    private String pZtybonusharaihrkkigetu2;
    private Long pZtyhiyubriaitsiznmrtis;
    private Long pZtyhiyubriaittignmrtis;
    private String pZtytkjykbn;
    private String pZtysakugenkikan;
    private Integer pZtyryoumasihyouten;
    private Long pZtytokujyoup;
    private String pZtyhjncd;
    private String pZtyhjnjigyosyocd;
    private Integer pZtyjyuugyouinsuu;
    private String pZtyiktkaisuu;
    private String pZtyznnkai;
    private String pZtykyktsnatkitkykkbn;
    private String pZtykyktsnatkitkykstagekbn;
    private String pZtypmentokuyakukbn;
    private String pZtyyobiv3;
    private Long pZtytkykznnunyukngk;
    private String pZtysyokaipnyuukinhouhoukbn;
    private String pZtyhtnknkyksyonox1;
    private String pZtyhtnknkykhknsyuruikgux1;
    private String pZtytenkanuketukeymdx1;
    private String pZtyhtnknkykkykymdx1;
    private String pZtyhtnknkykhknkknx1;
    private String pZtyhtnknkykphrkkknx1;
    private String pZtyhtnknkykhrkkaisuukbnx1;
    private String pZtyhtnknkykhrkkeirokbnx1;
    private String pZtytnknuktkzngtkijyuhyjx1;
    private String pZtyhtnknkykmrtisyuruikgux1;
    private String pZtyhtnknkyksyonox2;
    private String pZtyhtnknkykhknsyuruikgux2;
    private String pZtytenkanuketukeymdx2;
    private String pZtyhtnknkykkykymdx2;
    private String pZtyhtnknkykhknkknx2;
    private String pZtyhtnknkykphrkkknx2;
    private String pZtyhtnknkykhrkkaisuukbnx2;
    private String pZtyhtnknkykhrkkeirokbnx2;
    private String pZtytnknuktkzngtkijyuhyjx2;
    private String pZtyhtnknkykmrtisyuruikgux2;
    private String pZtyhtnknkyksyonox3;
    private String pZtyhtnknkykhknsyuruikgux3;
    private String pZtytenkanuketukeymdx3;
    private String pZtyhtnknkykkykymdx3;
    private String pZtyhtnknkykhknkknx3;
    private String pZtyhtnknkykphrkkknx3;
    private String pZtyhtnknkykhrkkaisuukbnx3;
    private String pZtyhtnknkykhrkkeirokbnx3;
    private String pZtytnknuktkzngtkijyuhyjx3;
    private String pZtyhtnknkykmrtisyuruikgux3;
    private String pZtyhtnknkyksyonox4;
    private String pZtyhtnknkykhknsyuruikgux4;
    private String pZtytenkanuketukeymdx4;
    private String pZtyhtnknkykkykymdx4;
    private String pZtyhtnknkykhknkknx4;
    private String pZtyhtnknkykphrkkknx4;
    private String pZtyhtnknkykhrkkaisuukbnx4;
    private String pZtyhtnknkykhrkkeirokbnx4;
    private String pZtytnknuktkzngtkijyuhyjx4;
    private String pZtyhtnknkykmrtisyuruikgux4;
    private String pZtyhtnknkyksyonox5;
    private String pZtyhtnknkykhknsyuruikgux5;
    private String pZtytenkanuketukeymdx5;
    private String pZtyhtnknkykkykymdx5;
    private String pZtyhtnknkykhknkknx5;
    private String pZtyhtnknkykphrkkknx5;
    private String pZtyhtnknkykhrkkaisuukbnx5;
    private String pZtyhtnknkykhrkkeirokbnx5;
    private String pZtytnknuktkzngtkijyuhyjx5;
    private String pZtyhtnknkykmrtisyuruikgux5;
    private String pZtyhtnknkyksyonox6;
    private String pZtyhtnknkykhknsyuruikgux6;
    private String pZtytenkanuketukeymdx6;
    private String pZtyhtnknkykkykymdx6;
    private String pZtyhtnknkykhknkknx6;
    private String pZtyhtnknkykphrkkknx6;
    private String pZtyhtnknkykhrkkaisuukbnx6;
    private String pZtyhtnknkykhrkkeirokbnx6;
    private String pZtytnknuktkzngtkijyuhyjx6;
    private String pZtyhtnknkykmrtisyuruikgux6;
    private Long pZtygukihtnknkykkhns;
    private Long pZtygukihtnknkyksbus;
    private Long pZtygukihtnknkykhntiyup;
    private Long pZtygukihtnknkyksigwrmstkyks;
    private Long pZtygukihtnknkyksyugitkyks;
    private Integer pZtygukihtnknsignyintkykntgk;
    private Integer pZtygukihtnknknkutkykntgk;
    private Long pZtygukihtnknkykmods;
    private Long pZtygoukeitenkankakaku;
    private Long pZtygukitnknjsknnjynbkn;
    private Long pZtygukitnknsisnkstkkngk;
    private Long pZtygukitnknsisnttkekngk;
    private Long pZtygoukeitenkanseisand;
    private Long pZtygukitnknsisnmkikp;
    private Long pZtygukitnknsisnsntkngk;
    private Long pZtygukitnknkhnbbnkiykkujygk;
    private Long pZtygukitnkntikbbnkiykkujygk;
    private Long pZtygukitnknitjbrtiks;
    private String pZtysethokenno;
    private String pZtysckbn;
    private String pZtyenjyosyacd;
    private Long pZtynaibuwarimodosigaku;
    private String pZtykeiyakukakuninsyuruikbn;
    private String pZtysoujikeitenkanhyouji;
    private String pZtytenkanjisketteihouhoukbn;
    private String pZtykeikanensuukbn;
    private String pZtyhtnknkykhhknsytisyukbnx1;
    private String pZtyhtnknkykhhknsytisyukbnx2;
    private String pZtyhtnknkykhhknsytisyukbnx3;
    private String pZtyhtnknkykhhknsytisyukbnx4;
    private String pZtyhtnknkykhhknsytisyukbnx5;
    private String pZtyhtnknkykhhknsytisyukbnx6;
    private Long pZtykktijgukipbbntnkns;
    private Long pZtysyonendosyokaip;
    private Long pZtysyonendo2kaimeikoup;
    private Long pZtyjinendoikoup;
    private Integer pZtysyukeiyakusikyuukisogaku;
    private Integer pZtysykyknenhantatskyuksgk;
    private Integer pZtymaruteisikyuukisogaku;
    private Integer pZtyitjbrzugkskyuksgkx1;
    private Integer pZtyitjbrzugkskyuksgkx2;
    private Integer pZtyitjbrzgknnhntatskyksgkx1;
    private Integer pZtyitjbrzgknnhntatskyksgkx2;
    private Integer pZtykzkmrtiskyuksgk;
    private Integer pZtyitibitjbrskyuksgk;
    private Integer pZtyitbitjbrnnhntatskyuksgk;
    private Integer pZtysykykksnbsyutat;
    private Integer pZtyitjbrzugkksnbsyutatx1;
    private Integer pZtyitjbrzugkksnbsyutatx2;
    private Integer pZtyitibitjbrksnbsyutat;
    private BizNumber pZtyjyunkensuu;
    private BizNumber pZtykansankensuu;
    private String pZtyitibuitijibaraikikan;
    private Long pZtyitibuitijibarais;
    private Long pZtyitibuitijibaraip;
    private String pZtyitibitjbrsdtpdtkbn;
    private Long pZtyitibuitijibaraisyuuseis;
    private String pZtyitibitjbrmodsskgnhyj;
    private String pZtysuuriyousyoriym;
    private String pZtysyosinsinsahouhoukbn;
    private String pZtysaisinsinsahouhoukbn;
    private String pZtyseizonmrtisyuruikgu;
    private String pZtyseizonmaruteikikan;
    private String pZtyseizonmrtiphrkkkn;
    private Long pZtyseizonmaruteis;
    private Long pZtyseizonmaruteip;
    private Long pZtyseizonmaruteisyuuseis;
    private String pZtyseizonmrtimodsskgnhyj;
    private String pZtysiznmrtitkjyukbn;
    private String pZtysiznmrtitkjyuskgnkkn;
    private Integer pZtysiznmrtitkjyuryumshyutn;
    private Long pZtysiznmrtitkjyup;
    private Integer pZtysiznmrtiskyuksgk;
    private String pZtyhtnknkyksiznmrtsyrikgux1;
    private String pZtyhtnknkyksiznmrtsyrikgux2;
    private String pZtyhtnknkyksiznmrtsyrikgux3;
    private String pZtyhtnknkyksiznmrtsyrikgux4;
    private String pZtyhtnknkyksiznmrtsyrikgux5;
    private String pZtyhtnknkyksiznmrtsyrikgux6;
    private String pZtysuryusiznmrtipwrbkkbn;
    private String pZtysiznmrtipwrbkkbn;
    private String pZtysiznmrtitnknyugukbn;
    private String pZtyseizonmrtikgusdkbn;
    private String pZtyyobiv1;
    private String pZtydai2hihokensyamei;
    private String pZtydai2kanjihihokensyamei;
    private String pZtydai2hihokensyaseiymd;
    private String pZtydai2hihokensyaseibetukbn;
    private String pZtydai2hihknsyahnskhkncd;
    private String pZtydai2hhknnen;
    private String pZtydai2hihknsyakikykarihyj;
    private String pZtykyksydi2hihknsyaduithyj;
    private String pZtydai2syosinsinsahouhoukbn;
    private String pZtydai2saisinsinsahouhoukbn;
    private String pZtydai2syokugyoucd;
    private String pZtydai2sakugenkikan;
    private Integer pZtydai2ryoumasihyouten;
    private String pZtymrtidi2skgnkkn;
    private Integer pZtymrtidi2ryumshyutn;
    private String pZtydi2kykkknnsyrikbn;
    private String pZtytignmrtidi2skgnkkn;
    private Integer pZtytignmrtidi2ryumshyutn;
    private String pZtydai2syosinhonninkknnkbn;
    private String pZtydi2sisnhonninkknnkbn;
    private String pZtyyobiv9x6;
    private String pZtydi2syugitkyksyrikgu;
    private String pZtydai2syougaitokuyakukikan;
    private String pZtydi2syugitkykphrkkkn;
    private Long pZtydai2syougaitokuyakus;
    private Long pZtydai2syougaitokuyakup;
    private String pZtydi2syugitkykgtkbn;
    private String pZtydi2syugitkykkgusdkbn;
    private String pZtydi2syugitkykpwrbkkbn;
    private String pZtyyobiv8;
    private String pZtydi2sigiwrmstkyksyrikgu;
    private String pZtydi2sigiwrmstkykkkn;
    private String pZtydi2sigiwrmstkykphrkkkn;
    private Long pZtydi2sigiwrmstkyks;
    private Long pZtydi2sigiwrmstkykp;
    private String pZtydi2sigiwrmstkykkgusdkbn;
    private String pZtydi2sigiwrmstkykpwrbkkbn;
    private String pZtyyobiv9x7;
    private String pZtydi2siginyuintkyksyrikgu;
    private String pZtydi2siginyuintkykkkn;
    private String pZtydi2siginyuintkykphrkkkn;
    private Integer pZtydi2siginyuintkykntgk;
    private Long pZtydi2siginyuintkykp;
    private String pZtydi2siginyuintkykgtkbn;
    private String pZtydi2siginyintkykkgusdkbn;
    private String pZtydi2siginyuintkykpwrbkkbn;
    private String pZtyyobiv10x3;
    private String pZtydi2sppinyuintkyksyrikgu;
    private String pZtydi2sppinyuintkykkkn;
    private String pZtydi2sppinyuintkykphrkkkn;
    private Integer pZtydi2sppinyuintkykntgk;
    private Long pZtydi2sppinyuintkykp;
    private String pZtydi2sppinyuintkykgtkbn;
    private Integer pZtydi2sppinyintkjyryumshytn;
    private Long pZtydi2sppinyuintkjyup;
    private String pZtydi2sppinyuintktbicdx1;
    private String pZtydi2sppinyuinhtnpkknx1;
    private String pZtydi2sppinyuintktbicdx2;
    private String pZtydi2sppinyuinhtnpkknx2;
    private String pZtydi2sppinyintkykkgusdkbn;
    private String pZtydi2sppinyuintkykpwrbkkbn;
    private String pZtyyobiv3x2;
    private String pZtydi2sijnbyutkyksyrikgu;
    private String pZtydi2sijnbyutkykkkn;
    private String pZtydi2sijnbyutkykphrkkkn;
    private Integer pZtydi2sijnbyutkykntgk;
    private Long pZtydai2seijinbyoutokuyakup;
    private Integer pZtydi2sijnbyutkjyurymshytn;
    private Long pZtydai2seijinbyoutokujyoup;
    private String pZtydi2sijnbyutktbicdx1;
    private String pZtydi2sijnbyuhtnpkknx1;
    private String pZtydi2sijnbyutktbicdx2;
    private String pZtydi2sijnbyuhtnpkknx2;
    private String pZtydi2sijnbyutkykkgusdkbn;
    private String pZtydi2sijnbytkykgankyhgtkbn;
    private String pZtydi2sijnbyutkykpwrbkkbn;
    private String pZtyyobiv3x3;
    private String pZtydai2jyoukentukihyouji;
    private String pZtytignmrtisyukgu;
    private String pZtyteigenmaruteikikan;
    private String pZtyteigenmrtiphrkkkn;
    private Long pZtyteigenmaruteis;
    private Long pZtyteigenmaruteip;
    private Long pZtyteigenmaruteisyuuseis;
    private String pZtyteigenmrtimodssakugenhyj;
    private String pZtytignmrtitkjyukbn;
    private String pZtytignmrtitkjyuskgnkkn;
    private Integer pZtytignmrtitkjyuryumshyutn;
    private Long pZtytignmrtitkjyup;
    private Integer pZtytignmrtiskyuksgk;
    private String pZtyhtnknkyktignmrtsyrikgux1;
    private String pZtyhtnknkyktignmrtsyrikgux2;
    private String pZtyhtnknkyktignmrtsyrikgux3;
    private String pZtyhtnknkyktignmrtsyrikgux4;
    private String pZtyhtnknkyktignmrtsyrikgux5;
    private String pZtyhtnknkyktignmrtsyrikgux6;
    private String pZtysuryutignmrtipwrbkkbn;
    private String pZtytignmrtipwrbkkbn;
    private String pZtytignmrtitnknyugukbn;
    private String pZtyteigenmrtikgusdkbn;
    private String pZtyyobiv1x2;
    private String pZtytktsppisetkykkbn;
    private String pZtyjyudmnsiskknsetkykkbn;
    private String pZtyyobiv8x2;
    private String pZtysetaitesyono1;
    private String pZtysetaitehokensyuruikigou1;
    private String pZtysetaitemrtisyuruikgu1;
    private String pZtysetaitesiznmrtisyurui1;
    private String pZtysetaitetignmrtisyurui1;
    private Long pZtysetaitekihonbubuns1;
    private Long pZtysetgukitnknitjbrkhns1;
    private Long pZtysetaitesibous1;
    private Long pZtysetgukitnknitjbrsbus1;
    private Long pZtysetaitesyuuseis1;
    private Long pZtysetaiteharaikomip1;
    private Long pZtysetaitesyukeiyakububunp1;
    private Long pZtysetaitgukikzkmrtis1;
    private String pZtysetaitetenkankykhyj1;
    private Long pZtysetaitesiteimhrkp1;
    private Long pZtysetaitesiteimsykykp1;
    private String pZtysetaitenkmrtisyurui1;
    private String pZtyyobiv18;

    @Override
    public String getZtyktgysyrymd() {
        return pZtyktgysyrymd;
    }
    @Override
    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        this.pZtyktgysyrymd = pZtyktgysyrymd;
    }
    @Override
    public String getZtyktgysyono() {
        return pZtyktgysyono;
    }
    @Override
    public void setZtyktgysyono(String pZtyktgysyono) {
        this.pZtyktgysyono = pZtyktgysyono;
    }
    @Override
    public String getZtyktgyfilerenno() {
        return pZtyktgyfilerenno;
    }
    @Override
    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        this.pZtyktgyfilerenno = pZtyktgyfilerenno;
    }
    @Override
    public String getZtysyono() {
        return pZtysyono;
    }
    @Override
    public void setZtysyono(String pZtysyono) {
        this.pZtysyono = pZtysyono;
    }
    @Override
    public String getZtyaatukaisyasisyacd() {
        return pZtyaatukaisyasisyacd;
    }
    @Override
    public void setZtyaatukaisyasisyacd(String pZtyaatukaisyasisyacd) {
        this.pZtyaatukaisyasisyacd = pZtyaatukaisyasisyacd;
    }
    @Override
    public String getZtymosno() {
        return pZtymosno;
    }
    @Override
    public void setZtymosno(String pZtymosno) {
        this.pZtymosno = pZtymosno;
    }
    @Override
    public String getZtyhknsyukigou() {
        return pZtyhknsyukigou;
    }
    @Override
    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        this.pZtyhknsyukigou = pZtyhknsyukigou;
    }
    @Override
    public String getZtykykymd() {
        return pZtykykymd;
    }
    @Override
    public void setZtykykymd(String pZtykykymd) {
        this.pZtykykymd = pZtykykymd;
    }
    @Override
    public String getZtyhknkkn() {
        return pZtyhknkkn;
    }
    @Override
    public void setZtyhknkkn(String pZtyhknkkn) {
        this.pZtyhknkkn = pZtyhknkkn;
    }
    @Override
    public String getZtyphrkkikn() {
        return pZtyphrkkikn;
    }
    @Override
    public void setZtyphrkkikn(String pZtyphrkkikn) {
        this.pZtyphrkkikn = pZtyphrkkikn;
    }
    @Override
    public String getZtysaimnkkykhyj() {
        return pZtysaimnkkykhyj;
    }
    @Override
    public void setZtysaimnkkykhyj(String pZtysaimnkkykhyj) {
        this.pZtysaimnkkykhyj = pZtysaimnkkykhyj;
    }
    @Override
    public Long getZtykihons() {
        return pZtykihons;
    }
    @Override
    public void setZtykihons(Long pZtykihons) {
        this.pZtykihons = pZtykihons;
    }
    @Override
    public Long getZtysibous() {
        return pZtysibous;
    }
    @Override
    public void setZtysibous(Long pZtysibous) {
        this.pZtysibous = pZtysibous;
    }
    @Override
    public Long getZtygyousekihyoukayouhosyous() {
        return pZtygyousekihyoukayouhosyous;
    }
    @Override
    public void setZtygyousekihyoukayouhosyous(Long pZtygyousekihyoukayouhosyous) {
        this.pZtygyousekihyoukayouhosyous = pZtygyousekihyoukayouhosyous;
    }
    @Override
    public Long getZtygukitnknitjbrkhns() {
        return pZtygukitnknitjbrkhns;
    }
    @Override
    public void setZtygukitnknitjbrkhns(Long pZtygukitnknitjbrkhns) {
        this.pZtygukitnknitjbrkhns = pZtygukitnknitjbrkhns;
    }
    @Override
    public Long getZtygukitnknitjbrsbus() {
        return pZtygukitnknitjbrsbus;
    }
    @Override
    public void setZtygukitnknitjbrsbus(Long pZtygukitnknitjbrsbus) {
        this.pZtygukitnknitjbrsbus = pZtygukitnknitjbrsbus;
    }
    @Override
    public Long getZtykktijgukitnknitjbrkhns() {
        return pZtykktijgukitnknitjbrkhns;
    }
    @Override
    public void setZtykktijgukitnknitjbrkhns(Long pZtykktijgukitnknitjbrkhns) {
        this.pZtykktijgukitnknitjbrkhns = pZtykktijgukitnknitjbrkhns;
    }
    @Override
    public Long getZtykktijgukitnknitjbrsbus() {
        return pZtykktijgukitnknitjbrsbus;
    }
    @Override
    public void setZtykktijgukitnknitjbrsbus(Long pZtykktijgukitnknitjbrsbus) {
        this.pZtykktijgukitnknitjbrsbus = pZtykktijgukitnknitjbrsbus;
    }
    @Override
    public Long getZtysyokaiharaikomip() {
        return pZtysyokaiharaikomip;
    }
    @Override
    public void setZtysyokaiharaikomip(Long pZtysyokaiharaikomip) {
        this.pZtysyokaiharaikomip = pZtysyokaiharaikomip;
    }
    @Override
    public Long getZtysyukeiyakup() {
        return pZtysyukeiyakup;
    }
    @Override
    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        this.pZtysyukeiyakup = pZtysyukeiyakup;
    }
    @Override
    public String getZtyhrkkaisuukbn() {
        return pZtyhrkkaisuukbn;
    }
    @Override
    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        this.pZtyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }
    @Override
    public String getZtyhrkkeirokbn() {
        return pZtyhrkkeirokbn;
    }
    @Override
    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        this.pZtyhrkkeirokbn = pZtyhrkkeirokbn;
    }
    @Override
    public String getZtyryouritukbn() {
        return pZtyryouritukbn;
    }
    @Override
    public void setZtyryouritukbn(String pZtyryouritukbn) {
        this.pZtyryouritukbn = pZtyryouritukbn;
    }
    @Override
    public String getZtytksyuannaikykkbn() {
        return pZtytksyuannaikykkbn;
    }
    @Override
    public void setZtytksyuannaikykkbn(String pZtytksyuannaikykkbn) {
        this.pZtytksyuannaikykkbn = pZtytksyuannaikykkbn;
    }
    @Override
    public String getZtysdpdkbn() {
        return pZtysdpdkbn;
    }
    @Override
    public void setZtysdpdkbn(String pZtysdpdkbn) {
        this.pZtysdpdkbn = pZtysdpdkbn;
    }
    @Override
    public String getZtyanniskcd() {
        return pZtyanniskcd;
    }
    @Override
    public void setZtyanniskcd(String pZtyanniskcd) {
        this.pZtyanniskcd = pZtyanniskcd;
    }
    @Override
    public String getZtyduketorihouhoukbn() {
        return pZtyduketorihouhoukbn;
    }
    @Override
    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        this.pZtyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }
    @Override
    public String getZtykyksyhhknsydouituhyouji() {
        return pZtykyksyhhknsydouituhyouji;
    }
    @Override
    public void setZtykyksyhhknsydouituhyouji(String pZtykyksyhhknsydouituhyouji) {
        this.pZtykyksyhhknsydouituhyouji = pZtykyksyhhknsydouituhyouji;
    }
    @Override
    public String getZtykyksyakikykarihyj() {
        return pZtykyksyakikykarihyj;
    }
    @Override
    public void setZtykyksyakikykarihyj(String pZtykyksyakikykarihyj) {
        this.pZtykyksyakikykarihyj = pZtykyksyakikykarihyj;
    }
    @Override
    public String getZtytenkankeiyakuhyouji() {
        return pZtytenkankeiyakuhyouji;
    }
    @Override
    public void setZtytenkankeiyakuhyouji(String pZtytenkankeiyakuhyouji) {
        this.pZtytenkankeiyakuhyouji = pZtytenkankeiyakuhyouji;
    }
    @Override
    public String getZtyjigyoukeiyakuhyouji() {
        return pZtyjigyoukeiyakuhyouji;
    }
    @Override
    public void setZtyjigyoukeiyakuhyouji(String pZtyjigyoukeiyakuhyouji) {
        this.pZtyjigyoukeiyakuhyouji = pZtyjigyoukeiyakuhyouji;
    }
    @Override
    public String getZtynenkinzeiseitokuyakukbn() {
        return pZtynenkinzeiseitokuyakukbn;
    }
    @Override
    public void setZtynenkinzeiseitokuyakukbn(String pZtynenkinzeiseitokuyakukbn) {
        this.pZtynenkinzeiseitokuyakukbn = pZtynenkinzeiseitokuyakukbn;
    }
    @Override
    public String getZtysyusseimaekanyuukykkbn() {
        return pZtysyusseimaekanyuukykkbn;
    }
    @Override
    public void setZtysyusseimaekanyuukykkbn(String pZtysyusseimaekanyuukykkbn) {
        this.pZtysyusseimaekanyuukykkbn = pZtysyusseimaekanyuukykkbn;
    }
    @Override
    public String getZtykazokukeiyakuhyouji() {
        return pZtykazokukeiyakuhyouji;
    }
    @Override
    public void setZtykazokukeiyakuhyouji(String pZtykazokukeiyakuhyouji) {
        this.pZtykazokukeiyakuhyouji = pZtykazokukeiyakuhyouji;
    }
    @Override
    public String getZtyjikokykhyj() {
        return pZtyjikokykhyj;
    }
    @Override
    public void setZtyjikokykhyj(String pZtyjikokykhyj) {
        this.pZtyjikokykhyj = pZtyjikokykhyj;
    }
    @Override
    public String getZtytuusyoumeisiyouhyouji() {
        return pZtytuusyoumeisiyouhyouji;
    }
    @Override
    public void setZtytuusyoumeisiyouhyouji(String pZtytuusyoumeisiyouhyouji) {
        this.pZtytuusyoumeisiyouhyouji = pZtytuusyoumeisiyouhyouji;
    }
    @Override
    public String getZtysethokenkbn() {
        return pZtysethokenkbn;
    }
    @Override
    public void setZtysethokenkbn(String pZtysethokenkbn) {
        this.pZtysethokenkbn = pZtysethokenkbn;
    }
    @Override
    public String getZtyteikeisyouhinkbn() {
        return pZtyteikeisyouhinkbn;
    }
    @Override
    public void setZtyteikeisyouhinkbn(String pZtyteikeisyouhinkbn) {
        this.pZtyteikeisyouhinkbn = pZtyteikeisyouhinkbn;
    }
    @Override
    public String getZtysykgycd() {
        return pZtysykgycd;
    }
    @Override
    public void setZtysykgycd(String pZtysykgycd) {
        this.pZtysykgycd = pZtysykgycd;
    }
    @Override
    public Long getZtytokuninbosyuuteate() {
        return pZtytokuninbosyuuteate;
    }
    @Override
    public void setZtytokuninbosyuuteate(Long pZtytokuninbosyuuteate) {
        this.pZtytokuninbosyuuteate = pZtytokuninbosyuuteate;
    }
    @Override
    public String getZtyseisekiym() {
        return pZtyseisekiym;
    }
    @Override
    public void setZtyseisekiym(String pZtyseisekiym) {
        this.pZtyseisekiym = pZtyseisekiym;
    }
    @Override
    public Long getZtyseisekikeijyousyuuseis() {
        return pZtyseisekikeijyousyuuseis;
    }
    @Override
    public void setZtyseisekikeijyousyuuseis(Long pZtyseisekikeijyousyuuseis) {
        this.pZtyseisekikeijyousyuuseis = pZtyseisekikeijyousyuuseis;
    }
    @Override
    public String getZtysyuuseissakugenhyouji() {
        return pZtysyuuseissakugenhyouji;
    }
    @Override
    public void setZtysyuuseissakugenhyouji(String pZtysyuuseissakugenhyouji) {
        this.pZtysyuuseissakugenhyouji = pZtysyuuseissakugenhyouji;
    }
    @Override
    public String getZtyaatukaisisyatodouhukencd() {
        return pZtyaatukaisisyatodouhukencd;
    }
    @Override
    public void setZtyaatukaisisyatodouhukencd(String pZtyaatukaisisyatodouhukencd) {
        this.pZtyaatukaisisyatodouhukencd = pZtyaatukaisisyatodouhukencd;
    }
    @Override
    public String getZtyaatukaisosikicd() {
        return pZtyaatukaisosikicd;
    }
    @Override
    public void setZtyaatukaisosikicd(String pZtyaatukaisosikicd) {
        this.pZtyaatukaisosikicd = pZtyaatukaisosikicd;
    }
    @Override
    public String getZtyaatukaikojincd() {
        return pZtyaatukaikojincd;
    }
    @Override
    public void setZtyaatukaikojincd(String pZtyaatukaikojincd) {
        this.pZtyaatukaikojincd = pZtyaatukaikojincd;
    }
    @Override
    public String getZtybatukaisosikicd() {
        return pZtybatukaisosikicd;
    }
    @Override
    public void setZtybatukaisosikicd(String pZtybatukaisosikicd) {
        this.pZtybatukaisosikicd = pZtybatukaisosikicd;
    }
    @Override
    public String getZtybatukaisyakojincd() {
        return pZtybatukaisyakojincd;
    }
    @Override
    public void setZtybatukaisyakojincd(String pZtybatukaisyakojincd) {
        this.pZtybatukaisyakojincd = pZtybatukaisyakojincd;
    }
    @Override
    public String getZtymarutokukbn() {
        return pZtymarutokukbn;
    }
    @Override
    public void setZtymarutokukbn(String pZtymarutokukbn) {
        this.pZtymarutokukbn = pZtymarutokukbn;
    }
    @Override
    public String getZtygyoumujyouhyouji() {
        return pZtygyoumujyouhyouji;
    }
    @Override
    public void setZtygyoumujyouhyouji(String pZtygyoumujyouhyouji) {
        this.pZtygyoumujyouhyouji = pZtygyoumujyouhyouji;
    }
    @Override
    public String getZtytuikakeijyoukbn() {
        return pZtytuikakeijyoukbn;
    }
    @Override
    public void setZtytuikakeijyoukbn(String pZtytuikakeijyoukbn) {
        this.pZtytuikakeijyoukbn = pZtytuikakeijyoukbn;
    }
    @Override
    public String getZtyseisekinomikeijyoukbn() {
        return pZtyseisekinomikeijyoukbn;
    }
    @Override
    public void setZtyseisekinomikeijyoukbn(String pZtyseisekinomikeijyoukbn) {
        this.pZtyseisekinomikeijyoukbn = pZtyseisekinomikeijyoukbn;
    }
    @Override
    public String getZtyteikikeijyoukbn() {
        return pZtyteikikeijyoukbn;
    }
    @Override
    public void setZtyteikikeijyoukbn(String pZtyteikikeijyoukbn) {
        this.pZtyteikikeijyoukbn = pZtyteikikeijyoukbn;
    }
    @Override
    public String getZtyhngkmskkatkisykbn() {
        return pZtyhngkmskkatkisykbn;
    }
    @Override
    public void setZtyhngkmskkatkisykbn(String pZtyhngkmskkatkisykbn) {
        this.pZtyhngkmskkatkisykbn = pZtyhngkmskkatkisykbn;
    }
    @Override
    public String getZtytnknkyuuyosakugenhyj() {
        return pZtytnknkyuuyosakugenhyj;
    }
    @Override
    public void setZtytnknkyuuyosakugenhyj(String pZtytnknkyuuyosakugenhyj) {
        this.pZtytnknkyuuyosakugenhyj = pZtytnknkyuuyosakugenhyj;
    }
    @Override
    public String getZtytenkankaisuu() {
        return pZtytenkankaisuu;
    }
    @Override
    public void setZtytenkankaisuu(String pZtytenkankaisuu) {
        this.pZtytenkankaisuu = pZtytenkankaisuu;
    }
    @Override
    public String getZtyhiyubrigssnsikkijyunkbn() {
        return pZtyhiyubrigssnsikkijyunkbn;
    }
    @Override
    public void setZtyhiyubrigssnsikkijyunkbn(String pZtyhiyubrigssnsikkijyunkbn) {
        this.pZtyhiyubrigssnsikkijyunkbn = pZtyhiyubrigssnsikkijyunkbn;
    }
    @Override
    public String getZtysekininkaisiymd() {
        return pZtysekininkaisiymd;
    }
    @Override
    public void setZtysekininkaisiymd(String pZtysekininkaisiymd) {
        this.pZtysekininkaisiymd = pZtysekininkaisiymd;
    }
    @Override
    public String getZtykigetusmkrgkykhyj() {
        return pZtykigetusmkrgkykhyj;
    }
    @Override
    public void setZtykigetusmkrgkykhyj(String pZtykigetusmkrgkykhyj) {
        this.pZtykigetusmkrgkykhyj = pZtykigetusmkrgkykhyj;
    }
    @Override
    public String getZtyhensyuusyoriymd() {
        return pZtyhensyuusyoriymd;
    }
    @Override
    public void setZtyhensyuusyoriymd(String pZtyhensyuusyoriymd) {
        this.pZtyhensyuusyoriymd = pZtyhensyuusyoriymd;
    }
    @Override
    public String getZtyjisisyaatukaihyouji() {
        return pZtyjisisyaatukaihyouji;
    }
    @Override
    public void setZtyjisisyaatukaihyouji(String pZtyjisisyaatukaihyouji) {
        this.pZtyjisisyaatukaihyouji = pZtyjisisyaatukaihyouji;
    }
    @Override
    public String getZtyaatkisytktntusy1atkihyj() {
        return pZtyaatkisytktntusy1atkihyj;
    }
    @Override
    public void setZtyaatkisytktntusy1atkihyj(String pZtyaatkisytktntusy1atkihyj) {
        this.pZtyaatkisytktntusy1atkihyj = pZtyaatkisytktntusy1atkihyj;
    }
    @Override
    public String getZtyaatkisytktntusy2atkihyj() {
        return pZtyaatkisytktntusy2atkihyj;
    }
    @Override
    public void setZtyaatkisytktntusy2atkihyj(String pZtyaatkisytktntusy2atkihyj) {
        this.pZtyaatkisytktntusy2atkihyj = pZtyaatkisytktntusy2atkihyj;
    }
    @Override
    public String getZtyaatkisyasyokan1atkihyj() {
        return pZtyaatkisyasyokan1atkihyj;
    }
    @Override
    public void setZtyaatkisyasyokan1atkihyj(String pZtyaatkisyasyokan1atkihyj) {
        this.pZtyaatkisyasyokan1atkihyj = pZtyaatkisyasyokan1atkihyj;
    }
    @Override
    public String getZtyaatkisyasyokan2atkihyj() {
        return pZtyaatkisyasyokan2atkihyj;
    }
    @Override
    public void setZtyaatkisyasyokan2atkihyj(String pZtyaatkisyasyokan2atkihyj) {
        this.pZtyaatkisyasyokan2atkihyj = pZtyaatkisyasyokan2atkihyj;
    }
    @Override
    public String getZtybatkisytktntusy1atkihyj() {
        return pZtybatkisytktntusy1atkihyj;
    }
    @Override
    public void setZtybatkisytktntusy1atkihyj(String pZtybatkisytktntusy1atkihyj) {
        this.pZtybatkisytktntusy1atkihyj = pZtybatkisytktntusy1atkihyj;
    }
    @Override
    public String getZtybatkisytktntusy2atkihyj() {
        return pZtybatkisytktntusy2atkihyj;
    }
    @Override
    public void setZtybatkisytktntusy2atkihyj(String pZtybatkisytktntusy2atkihyj) {
        this.pZtybatkisytktntusy2atkihyj = pZtybatkisytktntusy2atkihyj;
    }
    @Override
    public String getZtybatkisyasyokan1atkihyj() {
        return pZtybatkisyasyokan1atkihyj;
    }
    @Override
    public void setZtybatkisyasyokan1atkihyj(String pZtybatkisyasyokan1atkihyj) {
        this.pZtybatkisyasyokan1atkihyj = pZtybatkisyasyokan1atkihyj;
    }
    @Override
    public String getZtybatkisyasyokan2atkihyj() {
        return pZtybatkisyasyokan2atkihyj;
    }
    @Override
    public void setZtybatkisyasyokan2atkihyj(String pZtybatkisyasyokan2atkihyj) {
        this.pZtybatkisyasyokan2atkihyj = pZtybatkisyasyokan2atkihyj;
    }
    @Override
    public String getZtykeizokutyuuihyouji() {
        return pZtykeizokutyuuihyouji;
    }
    @Override
    public void setZtykeizokutyuuihyouji(String pZtykeizokutyuuihyouji) {
        this.pZtykeizokutyuuihyouji = pZtykeizokutyuuihyouji;
    }
    @Override
    public String getZtykeiyakubisiteihyouji() {
        return pZtykeiyakubisiteihyouji;
    }
    @Override
    public void setZtykeiyakubisiteihyouji(String pZtykeiyakubisiteihyouji) {
        this.pZtykeiyakubisiteihyouji = pZtykeiyakubisiteihyouji;
    }
    @Override
    public String getZtyjyoukentukihyouji() {
        return pZtyjyoukentukihyouji;
    }
    @Override
    public void setZtyjyoukentukihyouji(String pZtyjyoukentukihyouji) {
        this.pZtyjyoukentukihyouji = pZtyjyoukentukihyouji;
    }
    @Override
    public String getZtytokuninhyouji() {
        return pZtytokuninhyouji;
    }
    @Override
    public void setZtytokuninhyouji(String pZtytokuninhyouji) {
        this.pZtytokuninhyouji = pZtytokuninhyouji;
    }
    @Override
    public String getZtykessantyouseikbn() {
        return pZtykessantyouseikbn;
    }
    @Override
    public void setZtykessantyouseikbn(String pZtykessantyouseikbn) {
        this.pZtykessantyouseikbn = pZtykessantyouseikbn;
    }
    @Override
    public String getZtyhaneihyouji() {
        return pZtyhaneihyouji;
    }
    @Override
    public void setZtyhaneihyouji(String pZtyhaneihyouji) {
        this.pZtyhaneihyouji = pZtyhaneihyouji;
    }
    @Override
    public String getZtysyukinkbn() {
        return pZtysyukinkbn;
    }
    @Override
    public void setZtysyukinkbn(String pZtysyukinkbn) {
        this.pZtysyukinkbn = pZtysyukinkbn;
    }
    @Override
    public String getZtykeiyakusyasyokugyoucd() {
        return pZtykeiyakusyasyokugyoucd;
    }
    @Override
    public void setZtykeiyakusyasyokugyoucd(String pZtykeiyakusyasyokugyoucd) {
        this.pZtykeiyakusyasyokugyoucd = pZtykeiyakusyasyokugyoucd;
    }
    @Override
    public String getZtyseikeikeirokbn() {
        return pZtyseikeikeirokbn;
    }
    @Override
    public void setZtyseikeikeirokbn(String pZtyseikeikeirokbn) {
        this.pZtyseikeikeirokbn = pZtyseikeikeirokbn;
    }
    @Override
    public String getZtydai2seikeikeirokbn() {
        return pZtydai2seikeikeirokbn;
    }
    @Override
    public void setZtydai2seikeikeirokbn(String pZtydai2seikeikeirokbn) {
        this.pZtydai2seikeikeirokbn = pZtydai2seikeikeirokbn;
    }
    @Override
    public String getZtyteigentokuteisyuruikigou() {
        return pZtyteigentokuteisyuruikigou;
    }
    @Override
    public void setZtyteigentokuteisyuruikigou(String pZtyteigentokuteisyuruikigou) {
        this.pZtyteigentokuteisyuruikigou = pZtyteigentokuteisyuruikigou;
    }
    @Override
    public String getZtyteigentokuteikikan() {
        return pZtyteigentokuteikikan;
    }
    @Override
    public void setZtyteigentokuteikikan(String pZtyteigentokuteikikan) {
        this.pZtyteigentokuteikikan = pZtyteigentokuteikikan;
    }
    @Override
    public Long getZtyteigentokuteis() {
        return pZtyteigentokuteis;
    }
    @Override
    public void setZtyteigentokuteis(Long pZtyteigentokuteis) {
        this.pZtyteigentokuteis = pZtyteigentokuteis;
    }
    @Override
    public Long getZtyteigentokuteip() {
        return pZtyteigentokuteip;
    }
    @Override
    public void setZtyteigentokuteip(Long pZtyteigentokuteip) {
        this.pZtyteigentokuteip = pZtyteigentokuteip;
    }
    @Override
    public String getZtytigntktisdtpdtkbn() {
        return pZtytigntktisdtpdtkbn;
    }
    @Override
    public void setZtytigntktisdtpdtkbn(String pZtytigntktisdtpdtkbn) {
        this.pZtytigntktisdtpdtkbn = pZtytigntktisdtpdtkbn;
    }
    @Override
    public Long getZtyteigentokuteisyuuseis() {
        return pZtyteigentokuteisyuuseis;
    }
    @Override
    public void setZtyteigentokuteisyuuseis(Long pZtyteigentokuteisyuuseis) {
        this.pZtyteigentokuteisyuuseis = pZtyteigentokuteisyuuseis;
    }
    @Override
    public String getZtyteigentktimodssakugenhyj() {
        return pZtyteigentktimodssakugenhyj;
    }
    @Override
    public void setZtyteigentktimodssakugenhyj(String pZtyteigentktimodssakugenhyj) {
        this.pZtyteigentktimodssakugenhyj = pZtyteigentktimodssakugenhyj;
    }
    @Override
    public String getZtyteigentktikgusdkbn() {
        return pZtyteigentktikgusdkbn;
    }
    @Override
    public void setZtyteigentktikgusdkbn(String pZtyteigentktikgusdkbn) {
        this.pZtyteigentktikgusdkbn = pZtyteigentktikgusdkbn;
    }
    @Override
    public String getZtyyobiv9() {
        return pZtyyobiv9;
    }
    @Override
    public void setZtyyobiv9(String pZtyyobiv9) {
        this.pZtyyobiv9 = pZtyyobiv9;
    }
    @Override
    public String getZtytokuteibuicdx1() {
        return pZtytokuteibuicdx1;
    }
    @Override
    public void setZtytokuteibuicdx1(String pZtytokuteibuicdx1) {
        this.pZtytokuteibuicdx1 = pZtytokuteibuicdx1;
    }
    @Override
    public String getZtyhtnpkknx1() {
        return pZtyhtnpkknx1;
    }
    @Override
    public void setZtyhtnpkknx1(String pZtyhtnpkknx1) {
        this.pZtyhtnpkknx1 = pZtyhtnpkknx1;
    }
    @Override
    public String getZtytokuteibuicdx2() {
        return pZtytokuteibuicdx2;
    }
    @Override
    public void setZtytokuteibuicdx2(String pZtytokuteibuicdx2) {
        this.pZtytokuteibuicdx2 = pZtytokuteibuicdx2;
    }
    @Override
    public String getZtyhtnpkknx2() {
        return pZtyhtnpkknx2;
    }
    @Override
    public void setZtyhtnpkknx2(String pZtyhtnpkknx2) {
        this.pZtyhtnpkknx2 = pZtyhtnpkknx2;
    }
    @Override
    public String getZtyhhknmei() {
        return pZtyhhknmei;
    }
    @Override
    public void setZtyhhknmei(String pZtyhhknmei) {
        this.pZtyhhknmei = pZtyhhknmei;
    }
    @Override
    public String getZtyknjhhknmei() {
        return pZtyknjhhknmei;
    }
    @Override
    public void setZtyknjhhknmei(String pZtyknjhhknmei) {
        this.pZtyknjhhknmei = pZtyknjhhknmei;
    }
    @Override
    public String getZtyhhknseiymd() {
        return pZtyhhknseiymd;
    }
    @Override
    public void setZtyhhknseiymd(String pZtyhhknseiymd) {
        this.pZtyhhknseiymd = pZtyhhknseiymd;
    }
    @Override
    public String getZtyhhknseikbn() {
        return pZtyhhknseikbn;
    }
    @Override
    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        this.pZtyhhknseikbn = pZtyhhknseikbn;
    }
    @Override
    public String getZtyhhknhnsktodouhukencd() {
        return pZtyhhknhnsktodouhukencd;
    }
    @Override
    public void setZtyhhknhnsktodouhukencd(String pZtyhhknhnsktodouhukencd) {
        this.pZtyhhknhnsktodouhukencd = pZtyhhknhnsktodouhukencd;
    }
    @Override
    public String getZtyhihokensyaagev2() {
        return pZtyhihokensyaagev2;
    }
    @Override
    public void setZtyhihokensyaagev2(String pZtyhihokensyaagev2) {
        this.pZtyhihokensyaagev2 = pZtyhihokensyaagev2;
    }
    @Override
    public String getZtyhihokensyakikykarihyj() {
        return pZtyhihokensyakikykarihyj;
    }
    @Override
    public void setZtyhihokensyakikykarihyj(String pZtyhihokensyakikykarihyj) {
        this.pZtyhihokensyakikykarihyj = pZtyhihokensyakikykarihyj;
    }
    @Override
    public String getZtynobikkosaimankikbn() {
        return pZtynobikkosaimankikbn;
    }
    @Override
    public void setZtynobikkosaimankikbn(String pZtynobikkosaimankikbn) {
        this.pZtynobikkosaimankikbn = pZtynobikkosaimankikbn;
    }
    @Override
    public String getZtyhhknsysysnhonninkknnkbn() {
        return pZtyhhknsysysnhonninkknnkbn;
    }
    @Override
    public void setZtyhhknsysysnhonninkknnkbn(String pZtyhhknsysysnhonninkknnkbn) {
        this.pZtyhhknsysysnhonninkknnkbn = pZtyhhknsysysnhonninkknnkbn;
    }
    @Override
    public String getZtyhhknsysisnhonninkknnkbn() {
        return pZtyhhknsysisnhonninkknnkbn;
    }
    @Override
    public void setZtyhhknsysisnhonninkknnkbn(String pZtyhhknsysisnhonninkknnkbn) {
        this.pZtyhhknsysisnhonninkknnkbn = pZtyhhknsysisnhonninkknnkbn;
    }
    @Override
    public String getZtyhensyuukeiyakusyamei() {
        return pZtyhensyuukeiyakusyamei;
    }
    @Override
    public void setZtyhensyuukeiyakusyamei(String pZtyhensyuukeiyakusyamei) {
        this.pZtyhensyuukeiyakusyamei = pZtyhensyuukeiyakusyamei;
    }
    @Override
    public String getZtyhnsyuknjkyksynm() {
        return pZtyhnsyuknjkyksynm;
    }
    @Override
    public void setZtyhnsyuknjkyksynm(String pZtyhnsyuknjkyksynm) {
        this.pZtyhnsyuknjkyksynm = pZtyhnsyuknjkyksynm;
    }
    @Override
    public String getZtykyksyaseiymd() {
        return pZtykyksyaseiymd;
    }
    @Override
    public void setZtykyksyaseiymd(String pZtykyksyaseiymd) {
        this.pZtykyksyaseiymd = pZtykyksyaseiymd;
    }
    @Override
    public String getZtykyksyaseikbn() {
        return pZtykyksyaseikbn;
    }
    @Override
    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        this.pZtykyksyaseikbn = pZtykyksyaseikbn;
    }
    @Override
    public String getZtykyksyanen() {
        return pZtykyksyanen;
    }
    @Override
    public void setZtykyksyanen(String pZtykyksyanen) {
        this.pZtykyksyanen = pZtykyksyanen;
    }
    @Override
    public String getZtyhknsyuruikigousedaikbn() {
        return pZtyhknsyuruikigousedaikbn;
    }
    @Override
    public void setZtyhknsyuruikigousedaikbn(String pZtyhknsyuruikigousedaikbn) {
        this.pZtyhknsyuruikigousedaikbn = pZtyhknsyuruikigousedaikbn;
    }
    @Override
    public String getZtyknkuzusnzyrt() {
        return pZtyknkuzusnzyrt;
    }
    @Override
    public void setZtyknkuzusnzyrt(String pZtyknkuzusnzyrt) {
        this.pZtyknkuzusnzyrt = pZtyknkuzusnzyrt;
    }
    @Override
    public String getZtytsnsknewyno() {
        return pZtytsnsknewyno;
    }
    @Override
    public void setZtytsnsknewyno(String pZtytsnsknewyno) {
        this.pZtytsnsknewyno = pZtytsnsknewyno;
    }
    @Override
    public String getZtytsnsknewtikucd() {
        return pZtytsnsknewtikucd;
    }
    @Override
    public void setZtytsnsknewtikucd(String pZtytsnsknewtikucd) {
        this.pZtytsnsknewtikucd = pZtytsnsknewtikucd;
    }
    @Override
    public String getZtymossyumtkktymd() {
        return pZtymossyumtkktymd;
    }
    @Override
    public void setZtymossyumtkktymd(String pZtymossyumtkktymd) {
        this.pZtymossyumtkktymd = pZtymossyumtkktymd;
    }
    @Override
    public String getZtykituenkbn() {
        return pZtykituenkbn;
    }
    @Override
    public void setZtykituenkbn(String pZtykituenkbn) {
        this.pZtykituenkbn = pZtykituenkbn;
    }
    @Override
    public String getZtytuusinsakijyuusyokbn() {
        return pZtytuusinsakijyuusyokbn;
    }
    @Override
    public void setZtytuusinsakijyuusyokbn(String pZtytuusinsakijyuusyokbn) {
        this.pZtytuusinsakijyuusyokbn = pZtytuusinsakijyuusyokbn;
    }
    @Override
    public String getZtymaruteisyuruikigou() {
        return pZtymaruteisyuruikigou;
    }
    @Override
    public void setZtymaruteisyuruikigou(String pZtymaruteisyuruikigou) {
        this.pZtymaruteisyuruikigou = pZtymaruteisyuruikigou;
    }
    @Override
    public String getZtymaruteikikan() {
        return pZtymaruteikikan;
    }
    @Override
    public void setZtymaruteikikan(String pZtymaruteikikan) {
        this.pZtymaruteikikan = pZtymaruteikikan;
    }
    @Override
    public String getZtymaruteiphrkkkn() {
        return pZtymaruteiphrkkkn;
    }
    @Override
    public void setZtymaruteiphrkkkn(String pZtymaruteiphrkkkn) {
        this.pZtymaruteiphrkkkn = pZtymaruteiphrkkkn;
    }
    @Override
    public Long getZtymaruteis() {
        return pZtymaruteis;
    }
    @Override
    public void setZtymaruteis(Long pZtymaruteis) {
        this.pZtymaruteis = pZtymaruteis;
    }
    @Override
    public Long getZtymaruteip() {
        return pZtymaruteip;
    }
    @Override
    public void setZtymaruteip(Long pZtymaruteip) {
        this.pZtymaruteip = pZtymaruteip;
    }
    @Override
    public Long getZtymaruteisyuuseis() {
        return pZtymaruteisyuuseis;
    }
    @Override
    public void setZtymaruteisyuuseis(Long pZtymaruteisyuuseis) {
        this.pZtymaruteisyuuseis = pZtymaruteisyuuseis;
    }
    @Override
    public String getZtymaruteisyuuseisskgnhyj() {
        return pZtymaruteisyuuseisskgnhyj;
    }
    @Override
    public void setZtymaruteisyuuseisskgnhyj(String pZtymaruteisyuuseisskgnhyj) {
        this.pZtymaruteisyuuseisskgnhyj = pZtymaruteisyuuseisskgnhyj;
    }
    @Override
    public String getZtymaruteitokujyoukbn() {
        return pZtymaruteitokujyoukbn;
    }
    @Override
    public void setZtymaruteitokujyoukbn(String pZtymaruteitokujyoukbn) {
        this.pZtymaruteitokujyoukbn = pZtymaruteitokujyoukbn;
    }
    @Override
    public String getZtymrtitkjyuskgnkkn() {
        return pZtymrtitkjyuskgnkkn;
    }
    @Override
    public void setZtymrtitkjyuskgnkkn(String pZtymrtitkjyuskgnkkn) {
        this.pZtymrtitkjyuskgnkkn = pZtymrtitkjyuskgnkkn;
    }
    @Override
    public Integer getZtymrtitkjyuryumshyutn() {
        return pZtymrtitkjyuryumshyutn;
    }
    @Override
    public void setZtymrtitkjyuryumshyutn(Integer pZtymrtitkjyuryumshyutn) {
        this.pZtymrtitkjyuryumshyutn = pZtymrtitkjyuryumshyutn;
    }
    @Override
    public Long getZtymaruteitokujyoup() {
        return pZtymaruteitokujyoup;
    }
    @Override
    public void setZtymaruteitokujyoup(Long pZtymaruteitokujyoup) {
        this.pZtymaruteitokujyoup = pZtymaruteitokujyoup;
    }
    @Override
    public String getZtysuryumrtipwrbkkbn() {
        return pZtysuryumrtipwrbkkbn;
    }
    @Override
    public void setZtysuryumrtipwrbkkbn(String pZtysuryumrtipwrbkkbn) {
        this.pZtysuryumrtipwrbkkbn = pZtysuryumrtipwrbkkbn;
    }
    @Override
    public String getZtymaruteipwaribikikbn() {
        return pZtymaruteipwaribikikbn;
    }
    @Override
    public void setZtymaruteipwaribikikbn(String pZtymaruteipwaribikikbn) {
        this.pZtymaruteipwaribikikbn = pZtymaruteipwaribikikbn;
    }
    @Override
    public String getZtymrtitnknyugukbn() {
        return pZtymrtitnknyugukbn;
    }
    @Override
    public void setZtymrtitnknyugukbn(String pZtymrtitnknyugukbn) {
        this.pZtymrtitnknyugukbn = pZtymrtitnknyugukbn;
    }
    @Override
    public String getZtymaruteikigousedaikbn() {
        return pZtymaruteikigousedaikbn;
    }
    @Override
    public void setZtymaruteikigousedaikbn(String pZtymaruteikigousedaikbn) {
        this.pZtymaruteikigousedaikbn = pZtymaruteikigousedaikbn;
    }
    @Override
    public String getZtymaruteikikousnmnryoage() {
        return pZtymaruteikikousnmnryoage;
    }
    @Override
    public void setZtymaruteikikousnmnryoage(String pZtymaruteikikousnmnryoage) {
        this.pZtymaruteikikousnmnryoage = pZtymaruteikikousnmnryoage;
    }
    @Override
    public String getZtyyobiv2() {
        return pZtyyobiv2;
    }
    @Override
    public void setZtyyobiv2(String pZtyyobiv2) {
        this.pZtyyobiv2 = pZtyyobiv2;
    }
    @Override
    public String getZtymaruyousyuruikigou() {
        return pZtymaruyousyuruikigou;
    }
    @Override
    public void setZtymaruyousyuruikigou(String pZtymaruyousyuruikigou) {
        this.pZtymaruyousyuruikigou = pZtymaruyousyuruikigou;
    }
    @Override
    public String getZtymaruyoukikan() {
        return pZtymaruyoukikan;
    }
    @Override
    public void setZtymaruyoukikan(String pZtymaruyoukikan) {
        this.pZtymaruyoukikan = pZtymaruyoukikan;
    }
    @Override
    public Long getZtymaruyous() {
        return pZtymaruyous;
    }
    @Override
    public void setZtymaruyous(Long pZtymaruyous) {
        this.pZtymaruyous = pZtymaruyous;
    }
    @Override
    public Long getZtymaruyoup() {
        return pZtymaruyoup;
    }
    @Override
    public void setZtymaruyoup(Long pZtymaruyoup) {
        this.pZtymaruyoup = pZtymaruyoup;
    }
    @Override
    public String getZtymaruyousdatepdatekbn() {
        return pZtymaruyousdatepdatekbn;
    }
    @Override
    public void setZtymaruyousdatepdatekbn(String pZtymaruyousdatepdatekbn) {
        this.pZtymaruyousdatepdatekbn = pZtymaruyousdatepdatekbn;
    }
    @Override
    public Long getZtymaruyousyuuseis() {
        return pZtymaruyousyuuseis;
    }
    @Override
    public void setZtymaruyousyuuseis(Long pZtymaruyousyuuseis) {
        this.pZtymaruyousyuuseis = pZtymaruyousyuuseis;
    }
    @Override
    public String getZtymaruyousyuuseisskgnhyj() {
        return pZtymaruyousyuuseisskgnhyj;
    }
    @Override
    public void setZtymaruyousyuuseisskgnhyj(String pZtymaruyousyuuseisskgnhyj) {
        this.pZtymaruyousyuuseisskgnhyj = pZtymaruyousyuuseisskgnhyj;
    }
    @Override
    public String getZtymaruyoukigousedaikbn() {
        return pZtymaruyoukigousedaikbn;
    }
    @Override
    public void setZtymaruyoukigousedaikbn(String pZtymaruyoukigousedaikbn) {
        this.pZtymaruyoukigousedaikbn = pZtymaruyoukigousedaikbn;
    }
    @Override
    public String getZtyyobiv9x3() {
        return pZtyyobiv9x3;
    }
    @Override
    public void setZtyyobiv9x3(String pZtyyobiv9x3) {
        this.pZtyyobiv9x3 = pZtyyobiv9x3;
    }
    @Override
    public String getZtymarusyuusyuruikigou() {
        return pZtymarusyuusyuruikigou;
    }
    @Override
    public void setZtymarusyuusyuruikigou(String pZtymarusyuusyuruikigou) {
        this.pZtymarusyuusyuruikigou = pZtymarusyuusyuruikigou;
    }
    @Override
    public String getZtymarusyuukikan() {
        return pZtymarusyuukikan;
    }
    @Override
    public void setZtymarusyuukikan(String pZtymarusyuukikan) {
        this.pZtymarusyuukikan = pZtymarusyuukikan;
    }
    @Override
    public Long getZtymarusyuus() {
        return pZtymarusyuus;
    }
    @Override
    public void setZtymarusyuus(Long pZtymarusyuus) {
        this.pZtymarusyuus = pZtymarusyuus;
    }
    @Override
    public Long getZtymarusyuup() {
        return pZtymarusyuup;
    }
    @Override
    public void setZtymarusyuup(Long pZtymarusyuup) {
        this.pZtymarusyuup = pZtymarusyuup;
    }
    @Override
    public String getZtymarusyuusdatepdatekbn() {
        return pZtymarusyuusdatepdatekbn;
    }
    @Override
    public void setZtymarusyuusdatepdatekbn(String pZtymarusyuusdatepdatekbn) {
        this.pZtymarusyuusdatepdatekbn = pZtymarusyuusdatepdatekbn;
    }
    @Override
    public Long getZtymarusyuusyuuseis() {
        return pZtymarusyuusyuuseis;
    }
    @Override
    public void setZtymarusyuusyuuseis(Long pZtymarusyuusyuuseis) {
        this.pZtymarusyuusyuuseis = pZtymarusyuusyuuseis;
    }
    @Override
    public String getZtymarusyuusyuuseisskgnhyj() {
        return pZtymarusyuusyuuseisskgnhyj;
    }
    @Override
    public void setZtymarusyuusyuuseisskgnhyj(String pZtymarusyuusyuuseisskgnhyj) {
        this.pZtymarusyuusyuuseisskgnhyj = pZtymarusyuusyuuseisskgnhyj;
    }
    @Override
    public String getZtymarusyuukigousedaikbn() {
        return pZtymarusyuukigousedaikbn;
    }
    @Override
    public void setZtymarusyuukigousedaikbn(String pZtymarusyuukigousedaikbn) {
        this.pZtymarusyuukigousedaikbn = pZtymarusyuukigousedaikbn;
    }
    @Override
    public String getZtyyobiv9x4() {
        return pZtyyobiv9x4;
    }
    @Override
    public void setZtyyobiv9x4(String pZtyyobiv9x4) {
        this.pZtyyobiv9x4 = pZtyyobiv9x4;
    }
    @Override
    public String getZtytokuteisyuruikigou() {
        return pZtytokuteisyuruikigou;
    }
    @Override
    public void setZtytokuteisyuruikigou(String pZtytokuteisyuruikigou) {
        this.pZtytokuteisyuruikigou = pZtytokuteisyuruikigou;
    }
    @Override
    public String getZtytokuteikikan() {
        return pZtytokuteikikan;
    }
    @Override
    public void setZtytokuteikikan(String pZtytokuteikikan) {
        this.pZtytokuteikikan = pZtytokuteikikan;
    }
    @Override
    public Long getZtytokuteis() {
        return pZtytokuteis;
    }
    @Override
    public void setZtytokuteis(Long pZtytokuteis) {
        this.pZtytokuteis = pZtytokuteis;
    }
    @Override
    public Long getZtytokuteip() {
        return pZtytokuteip;
    }
    @Override
    public void setZtytokuteip(Long pZtytokuteip) {
        this.pZtytokuteip = pZtytokuteip;
    }
    @Override
    public String getZtytokuteisdatepdatekbn() {
        return pZtytokuteisdatepdatekbn;
    }
    @Override
    public void setZtytokuteisdatepdatekbn(String pZtytokuteisdatepdatekbn) {
        this.pZtytokuteisdatepdatekbn = pZtytokuteisdatepdatekbn;
    }
    @Override
    public Long getZtytokuteisyuuseis() {
        return pZtytokuteisyuuseis;
    }
    @Override
    public void setZtytokuteisyuuseis(Long pZtytokuteisyuuseis) {
        this.pZtytokuteisyuuseis = pZtytokuteisyuuseis;
    }
    @Override
    public String getZtytokuteisyuuseisskgnhyj() {
        return pZtytokuteisyuuseisskgnhyj;
    }
    @Override
    public void setZtytokuteisyuuseisskgnhyj(String pZtytokuteisyuuseisskgnhyj) {
        this.pZtytokuteisyuuseisskgnhyj = pZtytokuteisyuuseisskgnhyj;
    }
    @Override
    public String getZtytokuteikigousedaikbn() {
        return pZtytokuteikigousedaikbn;
    }
    @Override
    public void setZtytokuteikigousedaikbn(String pZtytokuteikigousedaikbn) {
        this.pZtytokuteikigousedaikbn = pZtytokuteikigousedaikbn;
    }
    @Override
    public String getZtyyobiv9x5() {
        return pZtyyobiv9x5;
    }
    @Override
    public void setZtyyobiv9x5(String pZtyyobiv9x5) {
        this.pZtyyobiv9x5 = pZtyyobiv9x5;
    }
    @Override
    public String getZtykzkmrtitkyknox1() {
        return pZtykzkmrtitkyknox1;
    }
    @Override
    public void setZtykzkmrtitkyknox1(String pZtykzkmrtitkyknox1) {
        this.pZtykzkmrtitkyknox1 = pZtykzkmrtitkyknox1;
    }
    @Override
    public String getZtykazokumrtisyuruikgux1() {
        return pZtykazokumrtisyuruikgux1;
    }
    @Override
    public void setZtykazokumrtisyuruikgux1(String pZtykazokumrtisyuruikgux1) {
        this.pZtykazokumrtisyuruikgux1 = pZtykazokumrtisyuruikgux1;
    }
    @Override
    public String getZtykazokumaruteikikanx1() {
        return pZtykazokumaruteikikanx1;
    }
    @Override
    public void setZtykazokumaruteikikanx1(String pZtykazokumaruteikikanx1) {
        this.pZtykazokumaruteikikanx1 = pZtykazokumaruteikikanx1;
    }
    @Override
    public String getZtykazokumrtiphrkkknx1() {
        return pZtykazokumrtiphrkkknx1;
    }
    @Override
    public void setZtykazokumrtiphrkkknx1(String pZtykazokumrtiphrkkknx1) {
        this.pZtykazokumrtiphrkkknx1 = pZtykazokumrtiphrkkknx1;
    }
    @Override
    public Long getZtykazokumaruteisx1() {
        return pZtykazokumaruteisx1;
    }
    @Override
    public void setZtykazokumaruteisx1(Long pZtykazokumaruteisx1) {
        this.pZtykazokumaruteisx1 = pZtykazokumaruteisx1;
    }
    @Override
    public Long getZtykazokumaruteipx1() {
        return pZtykazokumaruteipx1;
    }
    @Override
    public void setZtykazokumaruteipx1(Long pZtykazokumaruteipx1) {
        this.pZtykazokumaruteipx1 = pZtykazokumaruteipx1;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx1() {
        return pZtykzkmrtihihknsyanmx1;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx1(String pZtykzkmrtihihknsyanmx1) {
        this.pZtykzkmrtihihknsyanmx1 = pZtykzkmrtihihknsyanmx1;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx1() {
        return pZtykzkmrtihihknsyseiymdx1;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx1(String pZtykzkmrtihihknsyseiymdx1) {
        this.pZtykzkmrtihihknsyseiymdx1 = pZtykzkmrtihihknsyseiymdx1;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx1() {
        return pZtykzkmrtihihknsysibtkbnx1;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx1(String pZtykzkmrtihihknsysibtkbnx1) {
        this.pZtykzkmrtihihknsysibtkbnx1 = pZtykzkmrtihihknsysibtkbnx1;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex1() {
        return pZtykazokumrtihihknsyaagex1;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex1(String pZtykazokumrtihihknsyaagex1) {
        this.pZtykazokumrtihihknsyaagex1 = pZtykazokumrtihihknsyaagex1;
    }
    @Override
    public Long getZtykzkmrtimodsx1() {
        return pZtykzkmrtimodsx1;
    }
    @Override
    public void setZtykzkmrtimodsx1(Long pZtykzkmrtimodsx1) {
        this.pZtykzkmrtimodsx1 = pZtykzkmrtimodsx1;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx1() {
        return pZtykazokumrtimodsskgnhyjx1;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx1(String pZtykazokumrtimodsskgnhyjx1) {
        this.pZtykazokumrtimodsskgnhyjx1 = pZtykazokumrtimodsskgnhyjx1;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx1() {
        return pZtykzkmrtitnknyugukbnx1;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx1(String pZtykzkmrtitnknyugukbnx1) {
        this.pZtykzkmrtitnknyugukbnx1 = pZtykzkmrtitnknyugukbnx1;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx1() {
        return pZtykazokumrtikgusdkbnx1;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx1(String pZtykazokumrtikgusdkbnx1) {
        this.pZtykazokumrtikgusdkbnx1 = pZtykazokumrtikgusdkbnx1;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx1() {
        return pZtykazokumrtiagetyusihyjx1;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx1(String pZtykazokumrtiagetyusihyjx1) {
        this.pZtykazokumrtiagetyusihyjx1 = pZtykazokumrtiagetyusihyjx1;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex1() {
        return pZtykzkmrtikusnmnryoagex1;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex1(String pZtykzkmrtikusnmnryoagex1) {
        this.pZtykzkmrtikusnmnryoagex1 = pZtykzkmrtikusnmnryoagex1;
    }
    @Override
    public String getZtyyobiv4() {
        return pZtyyobiv4;
    }
    @Override
    public void setZtyyobiv4(String pZtyyobiv4) {
        this.pZtyyobiv4 = pZtyyobiv4;
    }
    @Override
    public String getZtykzkmrtitkyknox2() {
        return pZtykzkmrtitkyknox2;
    }
    @Override
    public void setZtykzkmrtitkyknox2(String pZtykzkmrtitkyknox2) {
        this.pZtykzkmrtitkyknox2 = pZtykzkmrtitkyknox2;
    }
    @Override
    public String getZtykazokumrtisyuruikgux2() {
        return pZtykazokumrtisyuruikgux2;
    }
    @Override
    public void setZtykazokumrtisyuruikgux2(String pZtykazokumrtisyuruikgux2) {
        this.pZtykazokumrtisyuruikgux2 = pZtykazokumrtisyuruikgux2;
    }
    @Override
    public String getZtykazokumaruteikikanx2() {
        return pZtykazokumaruteikikanx2;
    }
    @Override
    public void setZtykazokumaruteikikanx2(String pZtykazokumaruteikikanx2) {
        this.pZtykazokumaruteikikanx2 = pZtykazokumaruteikikanx2;
    }
    @Override
    public String getZtykazokumrtiphrkkknx2() {
        return pZtykazokumrtiphrkkknx2;
    }
    @Override
    public void setZtykazokumrtiphrkkknx2(String pZtykazokumrtiphrkkknx2) {
        this.pZtykazokumrtiphrkkknx2 = pZtykazokumrtiphrkkknx2;
    }
    @Override
    public Long getZtykazokumaruteisx2() {
        return pZtykazokumaruteisx2;
    }
    @Override
    public void setZtykazokumaruteisx2(Long pZtykazokumaruteisx2) {
        this.pZtykazokumaruteisx2 = pZtykazokumaruteisx2;
    }
    @Override
    public Long getZtykazokumaruteipx2() {
        return pZtykazokumaruteipx2;
    }
    @Override
    public void setZtykazokumaruteipx2(Long pZtykazokumaruteipx2) {
        this.pZtykazokumaruteipx2 = pZtykazokumaruteipx2;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx2() {
        return pZtykzkmrtihihknsyanmx2;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx2(String pZtykzkmrtihihknsyanmx2) {
        this.pZtykzkmrtihihknsyanmx2 = pZtykzkmrtihihknsyanmx2;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx2() {
        return pZtykzkmrtihihknsyseiymdx2;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx2(String pZtykzkmrtihihknsyseiymdx2) {
        this.pZtykzkmrtihihknsyseiymdx2 = pZtykzkmrtihihknsyseiymdx2;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx2() {
        return pZtykzkmrtihihknsysibtkbnx2;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx2(String pZtykzkmrtihihknsysibtkbnx2) {
        this.pZtykzkmrtihihknsysibtkbnx2 = pZtykzkmrtihihknsysibtkbnx2;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex2() {
        return pZtykazokumrtihihknsyaagex2;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex2(String pZtykazokumrtihihknsyaagex2) {
        this.pZtykazokumrtihihknsyaagex2 = pZtykazokumrtihihknsyaagex2;
    }
    @Override
    public Long getZtykzkmrtimodsx2() {
        return pZtykzkmrtimodsx2;
    }
    @Override
    public void setZtykzkmrtimodsx2(Long pZtykzkmrtimodsx2) {
        this.pZtykzkmrtimodsx2 = pZtykzkmrtimodsx2;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx2() {
        return pZtykazokumrtimodsskgnhyjx2;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx2(String pZtykazokumrtimodsskgnhyjx2) {
        this.pZtykazokumrtimodsskgnhyjx2 = pZtykazokumrtimodsskgnhyjx2;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx2() {
        return pZtykzkmrtitnknyugukbnx2;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx2(String pZtykzkmrtitnknyugukbnx2) {
        this.pZtykzkmrtitnknyugukbnx2 = pZtykzkmrtitnknyugukbnx2;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx2() {
        return pZtykazokumrtikgusdkbnx2;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx2(String pZtykazokumrtikgusdkbnx2) {
        this.pZtykazokumrtikgusdkbnx2 = pZtykazokumrtikgusdkbnx2;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx2() {
        return pZtykazokumrtiagetyusihyjx2;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx2(String pZtykazokumrtiagetyusihyjx2) {
        this.pZtykazokumrtiagetyusihyjx2 = pZtykazokumrtiagetyusihyjx2;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex2() {
        return pZtykzkmrtikusnmnryoagex2;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex2(String pZtykzkmrtikusnmnryoagex2) {
        this.pZtykzkmrtikusnmnryoagex2 = pZtykzkmrtikusnmnryoagex2;
    }
    @Override
    public String getZtyyobiv4x2() {
        return pZtyyobiv4x2;
    }
    @Override
    public void setZtyyobiv4x2(String pZtyyobiv4x2) {
        this.pZtyyobiv4x2 = pZtyyobiv4x2;
    }
    @Override
    public String getZtykzkmrtitkyknox3() {
        return pZtykzkmrtitkyknox3;
    }
    @Override
    public void setZtykzkmrtitkyknox3(String pZtykzkmrtitkyknox3) {
        this.pZtykzkmrtitkyknox3 = pZtykzkmrtitkyknox3;
    }
    @Override
    public String getZtykazokumrtisyuruikgux3() {
        return pZtykazokumrtisyuruikgux3;
    }
    @Override
    public void setZtykazokumrtisyuruikgux3(String pZtykazokumrtisyuruikgux3) {
        this.pZtykazokumrtisyuruikgux3 = pZtykazokumrtisyuruikgux3;
    }
    @Override
    public String getZtykazokumaruteikikanx3() {
        return pZtykazokumaruteikikanx3;
    }
    @Override
    public void setZtykazokumaruteikikanx3(String pZtykazokumaruteikikanx3) {
        this.pZtykazokumaruteikikanx3 = pZtykazokumaruteikikanx3;
    }
    @Override
    public String getZtykazokumrtiphrkkknx3() {
        return pZtykazokumrtiphrkkknx3;
    }
    @Override
    public void setZtykazokumrtiphrkkknx3(String pZtykazokumrtiphrkkknx3) {
        this.pZtykazokumrtiphrkkknx3 = pZtykazokumrtiphrkkknx3;
    }
    @Override
    public Long getZtykazokumaruteisx3() {
        return pZtykazokumaruteisx3;
    }
    @Override
    public void setZtykazokumaruteisx3(Long pZtykazokumaruteisx3) {
        this.pZtykazokumaruteisx3 = pZtykazokumaruteisx3;
    }
    @Override
    public Long getZtykazokumaruteipx3() {
        return pZtykazokumaruteipx3;
    }
    @Override
    public void setZtykazokumaruteipx3(Long pZtykazokumaruteipx3) {
        this.pZtykazokumaruteipx3 = pZtykazokumaruteipx3;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx3() {
        return pZtykzkmrtihihknsyanmx3;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx3(String pZtykzkmrtihihknsyanmx3) {
        this.pZtykzkmrtihihknsyanmx3 = pZtykzkmrtihihknsyanmx3;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx3() {
        return pZtykzkmrtihihknsyseiymdx3;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx3(String pZtykzkmrtihihknsyseiymdx3) {
        this.pZtykzkmrtihihknsyseiymdx3 = pZtykzkmrtihihknsyseiymdx3;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx3() {
        return pZtykzkmrtihihknsysibtkbnx3;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx3(String pZtykzkmrtihihknsysibtkbnx3) {
        this.pZtykzkmrtihihknsysibtkbnx3 = pZtykzkmrtihihknsysibtkbnx3;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex3() {
        return pZtykazokumrtihihknsyaagex3;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex3(String pZtykazokumrtihihknsyaagex3) {
        this.pZtykazokumrtihihknsyaagex3 = pZtykazokumrtihihknsyaagex3;
    }
    @Override
    public Long getZtykzkmrtimodsx3() {
        return pZtykzkmrtimodsx3;
    }
    @Override
    public void setZtykzkmrtimodsx3(Long pZtykzkmrtimodsx3) {
        this.pZtykzkmrtimodsx3 = pZtykzkmrtimodsx3;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx3() {
        return pZtykazokumrtimodsskgnhyjx3;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx3(String pZtykazokumrtimodsskgnhyjx3) {
        this.pZtykazokumrtimodsskgnhyjx3 = pZtykazokumrtimodsskgnhyjx3;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx3() {
        return pZtykzkmrtitnknyugukbnx3;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx3(String pZtykzkmrtitnknyugukbnx3) {
        this.pZtykzkmrtitnknyugukbnx3 = pZtykzkmrtitnknyugukbnx3;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx3() {
        return pZtykazokumrtikgusdkbnx3;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx3(String pZtykazokumrtikgusdkbnx3) {
        this.pZtykazokumrtikgusdkbnx3 = pZtykazokumrtikgusdkbnx3;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx3() {
        return pZtykazokumrtiagetyusihyjx3;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx3(String pZtykazokumrtiagetyusihyjx3) {
        this.pZtykazokumrtiagetyusihyjx3 = pZtykazokumrtiagetyusihyjx3;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex3() {
        return pZtykzkmrtikusnmnryoagex3;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex3(String pZtykzkmrtikusnmnryoagex3) {
        this.pZtykzkmrtikusnmnryoagex3 = pZtykzkmrtikusnmnryoagex3;
    }
    @Override
    public String getZtyyobiv4x3() {
        return pZtyyobiv4x3;
    }
    @Override
    public void setZtyyobiv4x3(String pZtyyobiv4x3) {
        this.pZtyyobiv4x3 = pZtyyobiv4x3;
    }
    @Override
    public String getZtykzkmrtitkyknox4() {
        return pZtykzkmrtitkyknox4;
    }
    @Override
    public void setZtykzkmrtitkyknox4(String pZtykzkmrtitkyknox4) {
        this.pZtykzkmrtitkyknox4 = pZtykzkmrtitkyknox4;
    }
    @Override
    public String getZtykazokumrtisyuruikgux4() {
        return pZtykazokumrtisyuruikgux4;
    }
    @Override
    public void setZtykazokumrtisyuruikgux4(String pZtykazokumrtisyuruikgux4) {
        this.pZtykazokumrtisyuruikgux4 = pZtykazokumrtisyuruikgux4;
    }
    @Override
    public String getZtykazokumaruteikikanx4() {
        return pZtykazokumaruteikikanx4;
    }
    @Override
    public void setZtykazokumaruteikikanx4(String pZtykazokumaruteikikanx4) {
        this.pZtykazokumaruteikikanx4 = pZtykazokumaruteikikanx4;
    }
    @Override
    public String getZtykazokumrtiphrkkknx4() {
        return pZtykazokumrtiphrkkknx4;
    }
    @Override
    public void setZtykazokumrtiphrkkknx4(String pZtykazokumrtiphrkkknx4) {
        this.pZtykazokumrtiphrkkknx4 = pZtykazokumrtiphrkkknx4;
    }
    @Override
    public Long getZtykazokumaruteisx4() {
        return pZtykazokumaruteisx4;
    }
    @Override
    public void setZtykazokumaruteisx4(Long pZtykazokumaruteisx4) {
        this.pZtykazokumaruteisx4 = pZtykazokumaruteisx4;
    }
    @Override
    public Long getZtykazokumaruteipx4() {
        return pZtykazokumaruteipx4;
    }
    @Override
    public void setZtykazokumaruteipx4(Long pZtykazokumaruteipx4) {
        this.pZtykazokumaruteipx4 = pZtykazokumaruteipx4;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx4() {
        return pZtykzkmrtihihknsyanmx4;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx4(String pZtykzkmrtihihknsyanmx4) {
        this.pZtykzkmrtihihknsyanmx4 = pZtykzkmrtihihknsyanmx4;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx4() {
        return pZtykzkmrtihihknsyseiymdx4;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx4(String pZtykzkmrtihihknsyseiymdx4) {
        this.pZtykzkmrtihihknsyseiymdx4 = pZtykzkmrtihihknsyseiymdx4;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx4() {
        return pZtykzkmrtihihknsysibtkbnx4;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx4(String pZtykzkmrtihihknsysibtkbnx4) {
        this.pZtykzkmrtihihknsysibtkbnx4 = pZtykzkmrtihihknsysibtkbnx4;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex4() {
        return pZtykazokumrtihihknsyaagex4;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex4(String pZtykazokumrtihihknsyaagex4) {
        this.pZtykazokumrtihihknsyaagex4 = pZtykazokumrtihihknsyaagex4;
    }
    @Override
    public Long getZtykzkmrtimodsx4() {
        return pZtykzkmrtimodsx4;
    }
    @Override
    public void setZtykzkmrtimodsx4(Long pZtykzkmrtimodsx4) {
        this.pZtykzkmrtimodsx4 = pZtykzkmrtimodsx4;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx4() {
        return pZtykazokumrtimodsskgnhyjx4;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx4(String pZtykazokumrtimodsskgnhyjx4) {
        this.pZtykazokumrtimodsskgnhyjx4 = pZtykazokumrtimodsskgnhyjx4;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx4() {
        return pZtykzkmrtitnknyugukbnx4;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx4(String pZtykzkmrtitnknyugukbnx4) {
        this.pZtykzkmrtitnknyugukbnx4 = pZtykzkmrtitnknyugukbnx4;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx4() {
        return pZtykazokumrtikgusdkbnx4;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx4(String pZtykazokumrtikgusdkbnx4) {
        this.pZtykazokumrtikgusdkbnx4 = pZtykazokumrtikgusdkbnx4;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx4() {
        return pZtykazokumrtiagetyusihyjx4;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx4(String pZtykazokumrtiagetyusihyjx4) {
        this.pZtykazokumrtiagetyusihyjx4 = pZtykazokumrtiagetyusihyjx4;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex4() {
        return pZtykzkmrtikusnmnryoagex4;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex4(String pZtykzkmrtikusnmnryoagex4) {
        this.pZtykzkmrtikusnmnryoagex4 = pZtykzkmrtikusnmnryoagex4;
    }
    @Override
    public String getZtyyobiv4x4() {
        return pZtyyobiv4x4;
    }
    @Override
    public void setZtyyobiv4x4(String pZtyyobiv4x4) {
        this.pZtyyobiv4x4 = pZtyyobiv4x4;
    }
    @Override
    public String getZtykzkmrtitkyknox5() {
        return pZtykzkmrtitkyknox5;
    }
    @Override
    public void setZtykzkmrtitkyknox5(String pZtykzkmrtitkyknox5) {
        this.pZtykzkmrtitkyknox5 = pZtykzkmrtitkyknox5;
    }
    @Override
    public String getZtykazokumrtisyuruikgux5() {
        return pZtykazokumrtisyuruikgux5;
    }
    @Override
    public void setZtykazokumrtisyuruikgux5(String pZtykazokumrtisyuruikgux5) {
        this.pZtykazokumrtisyuruikgux5 = pZtykazokumrtisyuruikgux5;
    }
    @Override
    public String getZtykazokumaruteikikanx5() {
        return pZtykazokumaruteikikanx5;
    }
    @Override
    public void setZtykazokumaruteikikanx5(String pZtykazokumaruteikikanx5) {
        this.pZtykazokumaruteikikanx5 = pZtykazokumaruteikikanx5;
    }
    @Override
    public String getZtykazokumrtiphrkkknx5() {
        return pZtykazokumrtiphrkkknx5;
    }
    @Override
    public void setZtykazokumrtiphrkkknx5(String pZtykazokumrtiphrkkknx5) {
        this.pZtykazokumrtiphrkkknx5 = pZtykazokumrtiphrkkknx5;
    }
    @Override
    public Long getZtykazokumaruteisx5() {
        return pZtykazokumaruteisx5;
    }
    @Override
    public void setZtykazokumaruteisx5(Long pZtykazokumaruteisx5) {
        this.pZtykazokumaruteisx5 = pZtykazokumaruteisx5;
    }
    @Override
    public Long getZtykazokumaruteipx5() {
        return pZtykazokumaruteipx5;
    }
    @Override
    public void setZtykazokumaruteipx5(Long pZtykazokumaruteipx5) {
        this.pZtykazokumaruteipx5 = pZtykazokumaruteipx5;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx5() {
        return pZtykzkmrtihihknsyanmx5;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx5(String pZtykzkmrtihihknsyanmx5) {
        this.pZtykzkmrtihihknsyanmx5 = pZtykzkmrtihihknsyanmx5;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx5() {
        return pZtykzkmrtihihknsyseiymdx5;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx5(String pZtykzkmrtihihknsyseiymdx5) {
        this.pZtykzkmrtihihknsyseiymdx5 = pZtykzkmrtihihknsyseiymdx5;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx5() {
        return pZtykzkmrtihihknsysibtkbnx5;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx5(String pZtykzkmrtihihknsysibtkbnx5) {
        this.pZtykzkmrtihihknsysibtkbnx5 = pZtykzkmrtihihknsysibtkbnx5;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex5() {
        return pZtykazokumrtihihknsyaagex5;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex5(String pZtykazokumrtihihknsyaagex5) {
        this.pZtykazokumrtihihknsyaagex5 = pZtykazokumrtihihknsyaagex5;
    }
    @Override
    public Long getZtykzkmrtimodsx5() {
        return pZtykzkmrtimodsx5;
    }
    @Override
    public void setZtykzkmrtimodsx5(Long pZtykzkmrtimodsx5) {
        this.pZtykzkmrtimodsx5 = pZtykzkmrtimodsx5;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx5() {
        return pZtykazokumrtimodsskgnhyjx5;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx5(String pZtykazokumrtimodsskgnhyjx5) {
        this.pZtykazokumrtimodsskgnhyjx5 = pZtykazokumrtimodsskgnhyjx5;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx5() {
        return pZtykzkmrtitnknyugukbnx5;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx5(String pZtykzkmrtitnknyugukbnx5) {
        this.pZtykzkmrtitnknyugukbnx5 = pZtykzkmrtitnknyugukbnx5;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx5() {
        return pZtykazokumrtikgusdkbnx5;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx5(String pZtykazokumrtikgusdkbnx5) {
        this.pZtykazokumrtikgusdkbnx5 = pZtykazokumrtikgusdkbnx5;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx5() {
        return pZtykazokumrtiagetyusihyjx5;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx5(String pZtykazokumrtiagetyusihyjx5) {
        this.pZtykazokumrtiagetyusihyjx5 = pZtykazokumrtiagetyusihyjx5;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex5() {
        return pZtykzkmrtikusnmnryoagex5;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex5(String pZtykzkmrtikusnmnryoagex5) {
        this.pZtykzkmrtikusnmnryoagex5 = pZtykzkmrtikusnmnryoagex5;
    }
    @Override
    public String getZtyyobiv4x5() {
        return pZtyyobiv4x5;
    }
    @Override
    public void setZtyyobiv4x5(String pZtyyobiv4x5) {
        this.pZtyyobiv4x5 = pZtyyobiv4x5;
    }
    @Override
    public String getZtykzkmrtitkyknox6() {
        return pZtykzkmrtitkyknox6;
    }
    @Override
    public void setZtykzkmrtitkyknox6(String pZtykzkmrtitkyknox6) {
        this.pZtykzkmrtitkyknox6 = pZtykzkmrtitkyknox6;
    }
    @Override
    public String getZtykazokumrtisyuruikgux6() {
        return pZtykazokumrtisyuruikgux6;
    }
    @Override
    public void setZtykazokumrtisyuruikgux6(String pZtykazokumrtisyuruikgux6) {
        this.pZtykazokumrtisyuruikgux6 = pZtykazokumrtisyuruikgux6;
    }
    @Override
    public String getZtykazokumaruteikikanx6() {
        return pZtykazokumaruteikikanx6;
    }
    @Override
    public void setZtykazokumaruteikikanx6(String pZtykazokumaruteikikanx6) {
        this.pZtykazokumaruteikikanx6 = pZtykazokumaruteikikanx6;
    }
    @Override
    public String getZtykazokumrtiphrkkknx6() {
        return pZtykazokumrtiphrkkknx6;
    }
    @Override
    public void setZtykazokumrtiphrkkknx6(String pZtykazokumrtiphrkkknx6) {
        this.pZtykazokumrtiphrkkknx6 = pZtykazokumrtiphrkkknx6;
    }
    @Override
    public Long getZtykazokumaruteisx6() {
        return pZtykazokumaruteisx6;
    }
    @Override
    public void setZtykazokumaruteisx6(Long pZtykazokumaruteisx6) {
        this.pZtykazokumaruteisx6 = pZtykazokumaruteisx6;
    }
    @Override
    public Long getZtykazokumaruteipx6() {
        return pZtykazokumaruteipx6;
    }
    @Override
    public void setZtykazokumaruteipx6(Long pZtykazokumaruteipx6) {
        this.pZtykazokumaruteipx6 = pZtykazokumaruteipx6;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx6() {
        return pZtykzkmrtihihknsyanmx6;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx6(String pZtykzkmrtihihknsyanmx6) {
        this.pZtykzkmrtihihknsyanmx6 = pZtykzkmrtihihknsyanmx6;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx6() {
        return pZtykzkmrtihihknsyseiymdx6;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx6(String pZtykzkmrtihihknsyseiymdx6) {
        this.pZtykzkmrtihihknsyseiymdx6 = pZtykzkmrtihihknsyseiymdx6;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx6() {
        return pZtykzkmrtihihknsysibtkbnx6;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx6(String pZtykzkmrtihihknsysibtkbnx6) {
        this.pZtykzkmrtihihknsysibtkbnx6 = pZtykzkmrtihihknsysibtkbnx6;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex6() {
        return pZtykazokumrtihihknsyaagex6;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex6(String pZtykazokumrtihihknsyaagex6) {
        this.pZtykazokumrtihihknsyaagex6 = pZtykazokumrtihihknsyaagex6;
    }
    @Override
    public Long getZtykzkmrtimodsx6() {
        return pZtykzkmrtimodsx6;
    }
    @Override
    public void setZtykzkmrtimodsx6(Long pZtykzkmrtimodsx6) {
        this.pZtykzkmrtimodsx6 = pZtykzkmrtimodsx6;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx6() {
        return pZtykazokumrtimodsskgnhyjx6;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx6(String pZtykazokumrtimodsskgnhyjx6) {
        this.pZtykazokumrtimodsskgnhyjx6 = pZtykazokumrtimodsskgnhyjx6;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx6() {
        return pZtykzkmrtitnknyugukbnx6;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx6(String pZtykzkmrtitnknyugukbnx6) {
        this.pZtykzkmrtitnknyugukbnx6 = pZtykzkmrtitnknyugukbnx6;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx6() {
        return pZtykazokumrtikgusdkbnx6;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx6(String pZtykazokumrtikgusdkbnx6) {
        this.pZtykazokumrtikgusdkbnx6 = pZtykazokumrtikgusdkbnx6;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx6() {
        return pZtykazokumrtiagetyusihyjx6;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx6(String pZtykazokumrtiagetyusihyjx6) {
        this.pZtykazokumrtiagetyusihyjx6 = pZtykazokumrtiagetyusihyjx6;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex6() {
        return pZtykzkmrtikusnmnryoagex6;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex6(String pZtykzkmrtikusnmnryoagex6) {
        this.pZtykzkmrtikusnmnryoagex6 = pZtykzkmrtikusnmnryoagex6;
    }
    @Override
    public String getZtyyobiv4x6() {
        return pZtyyobiv4x6;
    }
    @Override
    public void setZtyyobiv4x6(String pZtyyobiv4x6) {
        this.pZtyyobiv4x6 = pZtyyobiv4x6;
    }
    @Override
    public String getZtykzkmrtitkyknox7() {
        return pZtykzkmrtitkyknox7;
    }
    @Override
    public void setZtykzkmrtitkyknox7(String pZtykzkmrtitkyknox7) {
        this.pZtykzkmrtitkyknox7 = pZtykzkmrtitkyknox7;
    }
    @Override
    public String getZtykazokumrtisyuruikgux7() {
        return pZtykazokumrtisyuruikgux7;
    }
    @Override
    public void setZtykazokumrtisyuruikgux7(String pZtykazokumrtisyuruikgux7) {
        this.pZtykazokumrtisyuruikgux7 = pZtykazokumrtisyuruikgux7;
    }
    @Override
    public String getZtykazokumaruteikikanx7() {
        return pZtykazokumaruteikikanx7;
    }
    @Override
    public void setZtykazokumaruteikikanx7(String pZtykazokumaruteikikanx7) {
        this.pZtykazokumaruteikikanx7 = pZtykazokumaruteikikanx7;
    }
    @Override
    public String getZtykazokumrtiphrkkknx7() {
        return pZtykazokumrtiphrkkknx7;
    }
    @Override
    public void setZtykazokumrtiphrkkknx7(String pZtykazokumrtiphrkkknx7) {
        this.pZtykazokumrtiphrkkknx7 = pZtykazokumrtiphrkkknx7;
    }
    @Override
    public Long getZtykazokumaruteisx7() {
        return pZtykazokumaruteisx7;
    }
    @Override
    public void setZtykazokumaruteisx7(Long pZtykazokumaruteisx7) {
        this.pZtykazokumaruteisx7 = pZtykazokumaruteisx7;
    }
    @Override
    public Long getZtykazokumaruteipx7() {
        return pZtykazokumaruteipx7;
    }
    @Override
    public void setZtykazokumaruteipx7(Long pZtykazokumaruteipx7) {
        this.pZtykazokumaruteipx7 = pZtykazokumaruteipx7;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx7() {
        return pZtykzkmrtihihknsyanmx7;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx7(String pZtykzkmrtihihknsyanmx7) {
        this.pZtykzkmrtihihknsyanmx7 = pZtykzkmrtihihknsyanmx7;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx7() {
        return pZtykzkmrtihihknsyseiymdx7;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx7(String pZtykzkmrtihihknsyseiymdx7) {
        this.pZtykzkmrtihihknsyseiymdx7 = pZtykzkmrtihihknsyseiymdx7;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx7() {
        return pZtykzkmrtihihknsysibtkbnx7;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx7(String pZtykzkmrtihihknsysibtkbnx7) {
        this.pZtykzkmrtihihknsysibtkbnx7 = pZtykzkmrtihihknsysibtkbnx7;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex7() {
        return pZtykazokumrtihihknsyaagex7;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex7(String pZtykazokumrtihihknsyaagex7) {
        this.pZtykazokumrtihihknsyaagex7 = pZtykazokumrtihihknsyaagex7;
    }
    @Override
    public Long getZtykzkmrtimodsx7() {
        return pZtykzkmrtimodsx7;
    }
    @Override
    public void setZtykzkmrtimodsx7(Long pZtykzkmrtimodsx7) {
        this.pZtykzkmrtimodsx7 = pZtykzkmrtimodsx7;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx7() {
        return pZtykazokumrtimodsskgnhyjx7;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx7(String pZtykazokumrtimodsskgnhyjx7) {
        this.pZtykazokumrtimodsskgnhyjx7 = pZtykazokumrtimodsskgnhyjx7;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx7() {
        return pZtykzkmrtitnknyugukbnx7;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx7(String pZtykzkmrtitnknyugukbnx7) {
        this.pZtykzkmrtitnknyugukbnx7 = pZtykzkmrtitnknyugukbnx7;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx7() {
        return pZtykazokumrtikgusdkbnx7;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx7(String pZtykazokumrtikgusdkbnx7) {
        this.pZtykazokumrtikgusdkbnx7 = pZtykazokumrtikgusdkbnx7;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx7() {
        return pZtykazokumrtiagetyusihyjx7;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx7(String pZtykazokumrtiagetyusihyjx7) {
        this.pZtykazokumrtiagetyusihyjx7 = pZtykazokumrtiagetyusihyjx7;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex7() {
        return pZtykzkmrtikusnmnryoagex7;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex7(String pZtykzkmrtikusnmnryoagex7) {
        this.pZtykzkmrtikusnmnryoagex7 = pZtykzkmrtikusnmnryoagex7;
    }
    @Override
    public String getZtyyobiv4x7() {
        return pZtyyobiv4x7;
    }
    @Override
    public void setZtyyobiv4x7(String pZtyyobiv4x7) {
        this.pZtyyobiv4x7 = pZtyyobiv4x7;
    }
    @Override
    public String getZtykzkmrtitkyknox8() {
        return pZtykzkmrtitkyknox8;
    }
    @Override
    public void setZtykzkmrtitkyknox8(String pZtykzkmrtitkyknox8) {
        this.pZtykzkmrtitkyknox8 = pZtykzkmrtitkyknox8;
    }
    @Override
    public String getZtykazokumrtisyuruikgux8() {
        return pZtykazokumrtisyuruikgux8;
    }
    @Override
    public void setZtykazokumrtisyuruikgux8(String pZtykazokumrtisyuruikgux8) {
        this.pZtykazokumrtisyuruikgux8 = pZtykazokumrtisyuruikgux8;
    }
    @Override
    public String getZtykazokumaruteikikanx8() {
        return pZtykazokumaruteikikanx8;
    }
    @Override
    public void setZtykazokumaruteikikanx8(String pZtykazokumaruteikikanx8) {
        this.pZtykazokumaruteikikanx8 = pZtykazokumaruteikikanx8;
    }
    @Override
    public String getZtykazokumrtiphrkkknx8() {
        return pZtykazokumrtiphrkkknx8;
    }
    @Override
    public void setZtykazokumrtiphrkkknx8(String pZtykazokumrtiphrkkknx8) {
        this.pZtykazokumrtiphrkkknx8 = pZtykazokumrtiphrkkknx8;
    }
    @Override
    public Long getZtykazokumaruteisx8() {
        return pZtykazokumaruteisx8;
    }
    @Override
    public void setZtykazokumaruteisx8(Long pZtykazokumaruteisx8) {
        this.pZtykazokumaruteisx8 = pZtykazokumaruteisx8;
    }
    @Override
    public Long getZtykazokumaruteipx8() {
        return pZtykazokumaruteipx8;
    }
    @Override
    public void setZtykazokumaruteipx8(Long pZtykazokumaruteipx8) {
        this.pZtykazokumaruteipx8 = pZtykazokumaruteipx8;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx8() {
        return pZtykzkmrtihihknsyanmx8;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx8(String pZtykzkmrtihihknsyanmx8) {
        this.pZtykzkmrtihihknsyanmx8 = pZtykzkmrtihihknsyanmx8;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx8() {
        return pZtykzkmrtihihknsyseiymdx8;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx8(String pZtykzkmrtihihknsyseiymdx8) {
        this.pZtykzkmrtihihknsyseiymdx8 = pZtykzkmrtihihknsyseiymdx8;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx8() {
        return pZtykzkmrtihihknsysibtkbnx8;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx8(String pZtykzkmrtihihknsysibtkbnx8) {
        this.pZtykzkmrtihihknsysibtkbnx8 = pZtykzkmrtihihknsysibtkbnx8;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex8() {
        return pZtykazokumrtihihknsyaagex8;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex8(String pZtykazokumrtihihknsyaagex8) {
        this.pZtykazokumrtihihknsyaagex8 = pZtykazokumrtihihknsyaagex8;
    }
    @Override
    public Long getZtykzkmrtimodsx8() {
        return pZtykzkmrtimodsx8;
    }
    @Override
    public void setZtykzkmrtimodsx8(Long pZtykzkmrtimodsx8) {
        this.pZtykzkmrtimodsx8 = pZtykzkmrtimodsx8;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx8() {
        return pZtykazokumrtimodsskgnhyjx8;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx8(String pZtykazokumrtimodsskgnhyjx8) {
        this.pZtykazokumrtimodsskgnhyjx8 = pZtykazokumrtimodsskgnhyjx8;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx8() {
        return pZtykzkmrtitnknyugukbnx8;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx8(String pZtykzkmrtitnknyugukbnx8) {
        this.pZtykzkmrtitnknyugukbnx8 = pZtykzkmrtitnknyugukbnx8;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx8() {
        return pZtykazokumrtikgusdkbnx8;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx8(String pZtykazokumrtikgusdkbnx8) {
        this.pZtykazokumrtikgusdkbnx8 = pZtykazokumrtikgusdkbnx8;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx8() {
        return pZtykazokumrtiagetyusihyjx8;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx8(String pZtykazokumrtiagetyusihyjx8) {
        this.pZtykazokumrtiagetyusihyjx8 = pZtykazokumrtiagetyusihyjx8;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex8() {
        return pZtykzkmrtikusnmnryoagex8;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex8(String pZtykzkmrtikusnmnryoagex8) {
        this.pZtykzkmrtikusnmnryoagex8 = pZtykzkmrtikusnmnryoagex8;
    }
    @Override
    public String getZtyyobiv4x8() {
        return pZtyyobiv4x8;
    }
    @Override
    public void setZtyyobiv4x8(String pZtyyobiv4x8) {
        this.pZtyyobiv4x8 = pZtyyobiv4x8;
    }
    @Override
    public String getZtykzkmrtitkyknox9() {
        return pZtykzkmrtitkyknox9;
    }
    @Override
    public void setZtykzkmrtitkyknox9(String pZtykzkmrtitkyknox9) {
        this.pZtykzkmrtitkyknox9 = pZtykzkmrtitkyknox9;
    }
    @Override
    public String getZtykazokumrtisyuruikgux9() {
        return pZtykazokumrtisyuruikgux9;
    }
    @Override
    public void setZtykazokumrtisyuruikgux9(String pZtykazokumrtisyuruikgux9) {
        this.pZtykazokumrtisyuruikgux9 = pZtykazokumrtisyuruikgux9;
    }
    @Override
    public String getZtykazokumaruteikikanx9() {
        return pZtykazokumaruteikikanx9;
    }
    @Override
    public void setZtykazokumaruteikikanx9(String pZtykazokumaruteikikanx9) {
        this.pZtykazokumaruteikikanx9 = pZtykazokumaruteikikanx9;
    }
    @Override
    public String getZtykazokumrtiphrkkknx9() {
        return pZtykazokumrtiphrkkknx9;
    }
    @Override
    public void setZtykazokumrtiphrkkknx9(String pZtykazokumrtiphrkkknx9) {
        this.pZtykazokumrtiphrkkknx9 = pZtykazokumrtiphrkkknx9;
    }
    @Override
    public Long getZtykazokumaruteisx9() {
        return pZtykazokumaruteisx9;
    }
    @Override
    public void setZtykazokumaruteisx9(Long pZtykazokumaruteisx9) {
        this.pZtykazokumaruteisx9 = pZtykazokumaruteisx9;
    }
    @Override
    public Long getZtykazokumaruteipx9() {
        return pZtykazokumaruteipx9;
    }
    @Override
    public void setZtykazokumaruteipx9(Long pZtykazokumaruteipx9) {
        this.pZtykazokumaruteipx9 = pZtykazokumaruteipx9;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx9() {
        return pZtykzkmrtihihknsyanmx9;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx9(String pZtykzkmrtihihknsyanmx9) {
        this.pZtykzkmrtihihknsyanmx9 = pZtykzkmrtihihknsyanmx9;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx9() {
        return pZtykzkmrtihihknsyseiymdx9;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx9(String pZtykzkmrtihihknsyseiymdx9) {
        this.pZtykzkmrtihihknsyseiymdx9 = pZtykzkmrtihihknsyseiymdx9;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx9() {
        return pZtykzkmrtihihknsysibtkbnx9;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx9(String pZtykzkmrtihihknsysibtkbnx9) {
        this.pZtykzkmrtihihknsysibtkbnx9 = pZtykzkmrtihihknsysibtkbnx9;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex9() {
        return pZtykazokumrtihihknsyaagex9;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex9(String pZtykazokumrtihihknsyaagex9) {
        this.pZtykazokumrtihihknsyaagex9 = pZtykazokumrtihihknsyaagex9;
    }
    @Override
    public Long getZtykzkmrtimodsx9() {
        return pZtykzkmrtimodsx9;
    }
    @Override
    public void setZtykzkmrtimodsx9(Long pZtykzkmrtimodsx9) {
        this.pZtykzkmrtimodsx9 = pZtykzkmrtimodsx9;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx9() {
        return pZtykazokumrtimodsskgnhyjx9;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx9(String pZtykazokumrtimodsskgnhyjx9) {
        this.pZtykazokumrtimodsskgnhyjx9 = pZtykazokumrtimodsskgnhyjx9;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx9() {
        return pZtykzkmrtitnknyugukbnx9;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx9(String pZtykzkmrtitnknyugukbnx9) {
        this.pZtykzkmrtitnknyugukbnx9 = pZtykzkmrtitnknyugukbnx9;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx9() {
        return pZtykazokumrtikgusdkbnx9;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx9(String pZtykazokumrtikgusdkbnx9) {
        this.pZtykazokumrtikgusdkbnx9 = pZtykazokumrtikgusdkbnx9;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx9() {
        return pZtykazokumrtiagetyusihyjx9;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx9(String pZtykazokumrtiagetyusihyjx9) {
        this.pZtykazokumrtiagetyusihyjx9 = pZtykazokumrtiagetyusihyjx9;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex9() {
        return pZtykzkmrtikusnmnryoagex9;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex9(String pZtykzkmrtikusnmnryoagex9) {
        this.pZtykzkmrtikusnmnryoagex9 = pZtykzkmrtikusnmnryoagex9;
    }
    @Override
    public String getZtyyobiv4x9() {
        return pZtyyobiv4x9;
    }
    @Override
    public void setZtyyobiv4x9(String pZtyyobiv4x9) {
        this.pZtyyobiv4x9 = pZtyyobiv4x9;
    }
    @Override
    public String getZtykzkmrtitkyknox10() {
        return pZtykzkmrtitkyknox10;
    }
    @Override
    public void setZtykzkmrtitkyknox10(String pZtykzkmrtitkyknox10) {
        this.pZtykzkmrtitkyknox10 = pZtykzkmrtitkyknox10;
    }
    @Override
    public String getZtykazokumrtisyuruikgux10() {
        return pZtykazokumrtisyuruikgux10;
    }
    @Override
    public void setZtykazokumrtisyuruikgux10(String pZtykazokumrtisyuruikgux10) {
        this.pZtykazokumrtisyuruikgux10 = pZtykazokumrtisyuruikgux10;
    }
    @Override
    public String getZtykazokumaruteikikanx10() {
        return pZtykazokumaruteikikanx10;
    }
    @Override
    public void setZtykazokumaruteikikanx10(String pZtykazokumaruteikikanx10) {
        this.pZtykazokumaruteikikanx10 = pZtykazokumaruteikikanx10;
    }
    @Override
    public String getZtykazokumrtiphrkkknx10() {
        return pZtykazokumrtiphrkkknx10;
    }
    @Override
    public void setZtykazokumrtiphrkkknx10(String pZtykazokumrtiphrkkknx10) {
        this.pZtykazokumrtiphrkkknx10 = pZtykazokumrtiphrkkknx10;
    }
    @Override
    public Long getZtykazokumaruteisx10() {
        return pZtykazokumaruteisx10;
    }
    @Override
    public void setZtykazokumaruteisx10(Long pZtykazokumaruteisx10) {
        this.pZtykazokumaruteisx10 = pZtykazokumaruteisx10;
    }
    @Override
    public Long getZtykazokumaruteipx10() {
        return pZtykazokumaruteipx10;
    }
    @Override
    public void setZtykazokumaruteipx10(Long pZtykazokumaruteipx10) {
        this.pZtykazokumaruteipx10 = pZtykazokumaruteipx10;
    }
    @Override
    public String getZtykzkmrtihihknsyanmx10() {
        return pZtykzkmrtihihknsyanmx10;
    }
    @Override
    public void setZtykzkmrtihihknsyanmx10(String pZtykzkmrtihihknsyanmx10) {
        this.pZtykzkmrtihihknsyanmx10 = pZtykzkmrtihihknsyanmx10;
    }
    @Override
    public String getZtykzkmrtihihknsyseiymdx10() {
        return pZtykzkmrtihihknsyseiymdx10;
    }
    @Override
    public void setZtykzkmrtihihknsyseiymdx10(String pZtykzkmrtihihknsyseiymdx10) {
        this.pZtykzkmrtihihknsyseiymdx10 = pZtykzkmrtihihknsyseiymdx10;
    }
    @Override
    public String getZtykzkmrtihihknsysibtkbnx10() {
        return pZtykzkmrtihihknsysibtkbnx10;
    }
    @Override
    public void setZtykzkmrtihihknsysibtkbnx10(String pZtykzkmrtihihknsysibtkbnx10) {
        this.pZtykzkmrtihihknsysibtkbnx10 = pZtykzkmrtihihknsysibtkbnx10;
    }
    @Override
    public String getZtykazokumrtihihknsyaagex10() {
        return pZtykazokumrtihihknsyaagex10;
    }
    @Override
    public void setZtykazokumrtihihknsyaagex10(String pZtykazokumrtihihknsyaagex10) {
        this.pZtykazokumrtihihknsyaagex10 = pZtykazokumrtihihknsyaagex10;
    }
    @Override
    public Long getZtykzkmrtimodsx10() {
        return pZtykzkmrtimodsx10;
    }
    @Override
    public void setZtykzkmrtimodsx10(Long pZtykzkmrtimodsx10) {
        this.pZtykzkmrtimodsx10 = pZtykzkmrtimodsx10;
    }
    @Override
    public String getZtykazokumrtimodsskgnhyjx10() {
        return pZtykazokumrtimodsskgnhyjx10;
    }
    @Override
    public void setZtykazokumrtimodsskgnhyjx10(String pZtykazokumrtimodsskgnhyjx10) {
        this.pZtykazokumrtimodsskgnhyjx10 = pZtykazokumrtimodsskgnhyjx10;
    }
    @Override
    public String getZtykzkmrtitnknyugukbnx10() {
        return pZtykzkmrtitnknyugukbnx10;
    }
    @Override
    public void setZtykzkmrtitnknyugukbnx10(String pZtykzkmrtitnknyugukbnx10) {
        this.pZtykzkmrtitnknyugukbnx10 = pZtykzkmrtitnknyugukbnx10;
    }
    @Override
    public String getZtykazokumrtikgusdkbnx10() {
        return pZtykazokumrtikgusdkbnx10;
    }
    @Override
    public void setZtykazokumrtikgusdkbnx10(String pZtykazokumrtikgusdkbnx10) {
        this.pZtykazokumrtikgusdkbnx10 = pZtykazokumrtikgusdkbnx10;
    }
    @Override
    public String getZtykazokumrtiagetyusihyjx10() {
        return pZtykazokumrtiagetyusihyjx10;
    }
    @Override
    public void setZtykazokumrtiagetyusihyjx10(String pZtykazokumrtiagetyusihyjx10) {
        this.pZtykazokumrtiagetyusihyjx10 = pZtykazokumrtiagetyusihyjx10;
    }
    @Override
    public String getZtykzkmrtikusnmnryoagex10() {
        return pZtykzkmrtikusnmnryoagex10;
    }
    @Override
    public void setZtykzkmrtikusnmnryoagex10(String pZtykzkmrtikusnmnryoagex10) {
        this.pZtykzkmrtikusnmnryoagex10 = pZtykzkmrtikusnmnryoagex10;
    }
    @Override
    public String getZtyyobiv4x10() {
        return pZtyyobiv4x10;
    }
    @Override
    public void setZtyyobiv4x10(String pZtyyobiv4x10) {
        this.pZtyyobiv4x10 = pZtyyobiv4x10;
    }
    @Override
    public String getZtynkshrtkykhuhokbnx1() {
        return pZtynkshrtkykhuhokbnx1;
    }
    @Override
    public void setZtynkshrtkykhuhokbnx1(String pZtynkshrtkykhuhokbnx1) {
        this.pZtynkshrtkykhuhokbnx1 = pZtynkshrtkykhuhokbnx1;
    }
    @Override
    public String getZtynkshrtkyknksyuruikbnx1() {
        return pZtynkshrtkyknksyuruikbnx1;
    }
    @Override
    public void setZtynkshrtkyknksyuruikbnx1(String pZtynkshrtkyknksyuruikbnx1) {
        this.pZtynkshrtkyknksyuruikbnx1 = pZtynkshrtkyknksyuruikbnx1;
    }
    @Override
    public String getZtynkshrtkyknkkknx1() {
        return pZtynkshrtkyknkkknx1;
    }
    @Override
    public void setZtynkshrtkyknkkknx1(String pZtynkshrtkyknkkknx1) {
        this.pZtynkshrtkyknkkknx1 = pZtynkshrtkyknkkknx1;
    }
    @Override
    public Long getZtynkshrtkyknknengkx1() {
        return pZtynkshrtkyknknengkx1;
    }
    @Override
    public void setZtynkshrtkyknknengkx1(Long pZtynkshrtkyknknengkx1) {
        this.pZtynkshrtkyknknengkx1 = pZtynkshrtkyknknengkx1;
    }
    @Override
    public String getZtynkshrtkykduketorihhkbnx1() {
        return pZtynkshrtkykduketorihhkbnx1;
    }
    @Override
    public void setZtynkshrtkykduketorihhkbnx1(String pZtynkshrtkykduketorihhkbnx1) {
        this.pZtynkshrtkykduketorihhkbnx1 = pZtynkshrtkykduketorihhkbnx1;
    }
    @Override
    public String getZtyyobiv10() {
        return pZtyyobiv10;
    }
    @Override
    public void setZtyyobiv10(String pZtyyobiv10) {
        this.pZtyyobiv10 = pZtyyobiv10;
    }
    @Override
    public String getZtynkshrtkykhuhokbnx2() {
        return pZtynkshrtkykhuhokbnx2;
    }
    @Override
    public void setZtynkshrtkykhuhokbnx2(String pZtynkshrtkykhuhokbnx2) {
        this.pZtynkshrtkykhuhokbnx2 = pZtynkshrtkykhuhokbnx2;
    }
    @Override
    public String getZtynkshrtkyknksyuruikbnx2() {
        return pZtynkshrtkyknksyuruikbnx2;
    }
    @Override
    public void setZtynkshrtkyknksyuruikbnx2(String pZtynkshrtkyknksyuruikbnx2) {
        this.pZtynkshrtkyknksyuruikbnx2 = pZtynkshrtkyknksyuruikbnx2;
    }
    @Override
    public String getZtynkshrtkyknkkknx2() {
        return pZtynkshrtkyknkkknx2;
    }
    @Override
    public void setZtynkshrtkyknkkknx2(String pZtynkshrtkyknkkknx2) {
        this.pZtynkshrtkyknkkknx2 = pZtynkshrtkyknkkknx2;
    }
    @Override
    public Long getZtynkshrtkyknknengkx2() {
        return pZtynkshrtkyknknengkx2;
    }
    @Override
    public void setZtynkshrtkyknknengkx2(Long pZtynkshrtkyknknengkx2) {
        this.pZtynkshrtkyknknengkx2 = pZtynkshrtkyknknengkx2;
    }
    @Override
    public String getZtynkshrtkykduketorihhkbnx2() {
        return pZtynkshrtkykduketorihhkbnx2;
    }
    @Override
    public void setZtynkshrtkykduketorihhkbnx2(String pZtynkshrtkykduketorihhkbnx2) {
        this.pZtynkshrtkykduketorihhkbnx2 = pZtynkshrtkykduketorihhkbnx2;
    }
    @Override
    public String getZtyyobiv10x2() {
        return pZtyyobiv10x2;
    }
    @Override
    public void setZtyyobiv10x2(String pZtyyobiv10x2) {
        this.pZtyyobiv10x2 = pZtyyobiv10x2;
    }
    @Override
    public String getZtysyougaitkyksyuruikgu() {
        return pZtysyougaitkyksyuruikgu;
    }
    @Override
    public void setZtysyougaitkyksyuruikgu(String pZtysyougaitkyksyuruikgu) {
        this.pZtysyougaitkyksyuruikgu = pZtysyougaitkyksyuruikgu;
    }
    @Override
    public String getZtysyougaitokuyakukikan() {
        return pZtysyougaitokuyakukikan;
    }
    @Override
    public void setZtysyougaitokuyakukikan(String pZtysyougaitokuyakukikan) {
        this.pZtysyougaitokuyakukikan = pZtysyougaitokuyakukikan;
    }
    @Override
    public String getZtysyougaitkykphrkkkn() {
        return pZtysyougaitkykphrkkkn;
    }
    @Override
    public void setZtysyougaitkykphrkkkn(String pZtysyougaitkykphrkkkn) {
        this.pZtysyougaitkykphrkkkn = pZtysyougaitkykphrkkkn;
    }
    @Override
    public Long getZtysyougaitokuyakus() {
        return pZtysyougaitokuyakus;
    }
    @Override
    public void setZtysyougaitokuyakus(Long pZtysyougaitokuyakus) {
        this.pZtysyougaitokuyakus = pZtysyougaitokuyakus;
    }
    @Override
    public Long getZtysyougaitokuyakup() {
        return pZtysyougaitokuyakup;
    }
    @Override
    public void setZtysyougaitokuyakup(Long pZtysyougaitokuyakup) {
        this.pZtysyougaitokuyakup = pZtysyougaitokuyakup;
    }
    @Override
    public String getZtysyougaitkkatakbn() {
        return pZtysyougaitkkatakbn;
    }
    @Override
    public void setZtysyougaitkkatakbn(String pZtysyougaitkkatakbn) {
        this.pZtysyougaitkkatakbn = pZtysyougaitkkatakbn;
    }
    @Override
    public String getZtysyougaitkykkgusdkbn() {
        return pZtysyougaitkykkgusdkbn;
    }
    @Override
    public void setZtysyougaitkykkgusdkbn(String pZtysyougaitkykkgusdkbn) {
        this.pZtysyougaitkykkgusdkbn = pZtysyougaitkykkgusdkbn;
    }
    @Override
    public String getZtysyugitkykpwrbkkbn() {
        return pZtysyugitkykpwrbkkbn;
    }
    @Override
    public void setZtysyugitkykpwrbkkbn(String pZtysyugitkykpwrbkkbn) {
        this.pZtysyugitkykpwrbkkbn = pZtysyugitkykpwrbkkbn;
    }
    @Override
    public String getZtysyougaitkykkusnmnryoage() {
        return pZtysyougaitkykkusnmnryoage;
    }
    @Override
    public void setZtysyougaitkykkusnmnryoage(String pZtysyougaitkykkusnmnryoage) {
        this.pZtysyougaitkykkusnmnryoage = pZtysyougaitkykkusnmnryoage;
    }
    @Override
    public String getZtyyobiv5x2() {
        return pZtyyobiv5x2;
    }
    @Override
    public void setZtyyobiv5x2(String pZtyyobiv5x2) {
        this.pZtyyobiv5x2 = pZtyyobiv5x2;
    }
    @Override
    public String getZtysigiwrmstkyksyuruikgu() {
        return pZtysigiwrmstkyksyuruikgu;
    }
    @Override
    public void setZtysigiwrmstkyksyuruikgu(String pZtysigiwrmstkyksyuruikgu) {
        this.pZtysigiwrmstkyksyuruikgu = pZtysigiwrmstkyksyuruikgu;
    }
    @Override
    public String getZtysigiwrmstkykkkn() {
        return pZtysigiwrmstkykkkn;
    }
    @Override
    public void setZtysigiwrmstkykkkn(String pZtysigiwrmstkykkkn) {
        this.pZtysigiwrmstkykkkn = pZtysigiwrmstkykkkn;
    }
    @Override
    public String getZtysaigaiwrmstkykphrkkkn() {
        return pZtysaigaiwrmstkykphrkkkn;
    }
    @Override
    public void setZtysaigaiwrmstkykphrkkkn(String pZtysaigaiwrmstkykphrkkkn) {
        this.pZtysaigaiwrmstkykphrkkkn = pZtysaigaiwrmstkykphrkkkn;
    }
    @Override
    public Long getZtysaigaiwarimasitokuyakus() {
        return pZtysaigaiwarimasitokuyakus;
    }
    @Override
    public void setZtysaigaiwarimasitokuyakus(Long pZtysaigaiwarimasitokuyakus) {
        this.pZtysaigaiwarimasitokuyakus = pZtysaigaiwarimasitokuyakus;
    }
    @Override
    public Long getZtysaigaiwarimasitokuyakup() {
        return pZtysaigaiwarimasitokuyakup;
    }
    @Override
    public void setZtysaigaiwarimasitokuyakup(Long pZtysaigaiwarimasitokuyakup) {
        this.pZtysaigaiwarimasitokuyakup = pZtysaigaiwarimasitokuyakup;
    }
    @Override
    public String getZtysaigaiwrmstkykkgusdkbn() {
        return pZtysaigaiwrmstkykkgusdkbn;
    }
    @Override
    public void setZtysaigaiwrmstkykkgusdkbn(String pZtysaigaiwrmstkykkgusdkbn) {
        this.pZtysaigaiwrmstkykkgusdkbn = pZtysaigaiwrmstkykkgusdkbn;
    }
    @Override
    public String getZtysigiwrmstkykpwrbkkbn() {
        return pZtysigiwrmstkykpwrbkkbn;
    }
    @Override
    public void setZtysigiwrmstkykpwrbkkbn(String pZtysigiwrmstkykpwrbkkbn) {
        this.pZtysigiwrmstkykpwrbkkbn = pZtysigiwrmstkykpwrbkkbn;
    }
    @Override
    public String getZtysigiwrmstkykkusnmnryoage() {
        return pZtysigiwrmstkykkusnmnryoage;
    }
    @Override
    public void setZtysigiwrmstkykkusnmnryoage(String pZtysigiwrmstkykkusnmnryoage) {
        this.pZtysigiwrmstkykkusnmnryoage = pZtysigiwrmstkykkusnmnryoage;
    }
    @Override
    public String getZtyyobiv5x3() {
        return pZtyyobiv5x3;
    }
    @Override
    public void setZtyyobiv5x3(String pZtyyobiv5x3) {
        this.pZtyyobiv5x3 = pZtyyobiv5x3;
    }
    @Override
    public String getZtysiginyuintkyksyuruikgu() {
        return pZtysiginyuintkyksyuruikgu;
    }
    @Override
    public void setZtysiginyuintkyksyuruikgu(String pZtysiginyuintkyksyuruikgu) {
        this.pZtysiginyuintkyksyuruikgu = pZtysiginyuintkyksyuruikgu;
    }
    @Override
    public String getZtysiginyuintkykkkn() {
        return pZtysiginyuintkykkkn;
    }
    @Override
    public void setZtysiginyuintkykkkn(String pZtysiginyuintkykkkn) {
        this.pZtysiginyuintkykkkn = pZtysiginyuintkykkkn;
    }
    @Override
    public String getZtysaigainyuintkykphrkkkn() {
        return pZtysaigainyuintkykphrkkkn;
    }
    @Override
    public void setZtysaigainyuintkykphrkkkn(String pZtysaigainyuintkykphrkkkn) {
        this.pZtysaigainyuintkykphrkkkn = pZtysaigainyuintkykphrkkkn;
    }
    @Override
    public Integer getZtysiginyuintkykntgk() {
        return pZtysiginyuintkykntgk;
    }
    @Override
    public void setZtysiginyuintkykntgk(Integer pZtysiginyuintkykntgk) {
        this.pZtysiginyuintkykntgk = pZtysiginyuintkykntgk;
    }
    @Override
    public String getZtysiginyuintkykgtkbn() {
        return pZtysiginyuintkykgtkbn;
    }
    @Override
    public void setZtysiginyuintkykgtkbn(String pZtysiginyuintkykgtkbn) {
        this.pZtysiginyuintkykgtkbn = pZtysiginyuintkykgtkbn;
    }
    @Override
    public Long getZtysaigainyuuintokuyakup() {
        return pZtysaigainyuuintokuyakup;
    }
    @Override
    public void setZtysaigainyuuintokuyakup(Long pZtysaigainyuuintokuyakup) {
        this.pZtysaigainyuuintokuyakup = pZtysaigainyuuintokuyakup;
    }
    @Override
    public String getZtysaigainyuintkykkgusdkbn() {
        return pZtysaigainyuintkykkgusdkbn;
    }
    @Override
    public void setZtysaigainyuintkykkgusdkbn(String pZtysaigainyuintkykkgusdkbn) {
        this.pZtysaigainyuintkykkgusdkbn = pZtysaigainyuintkykkgusdkbn;
    }
    @Override
    public String getZtysiginyuintkykpwrbkkbn() {
        return pZtysiginyuintkykpwrbkkbn;
    }
    @Override
    public void setZtysiginyuintkykpwrbkkbn(String pZtysiginyuintkykpwrbkkbn) {
        this.pZtysiginyuintkykpwrbkkbn = pZtysiginyuintkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv7() {
        return pZtyyobiv7;
    }
    @Override
    public void setZtyyobiv7(String pZtyyobiv7) {
        this.pZtyyobiv7 = pZtyyobiv7;
    }
    @Override
    public String getZtysppinyuintkyksyuruikgu() {
        return pZtysppinyuintkyksyuruikgu;
    }
    @Override
    public void setZtysppinyuintkyksyuruikgu(String pZtysppinyuintkyksyuruikgu) {
        this.pZtysppinyuintkyksyuruikgu = pZtysppinyuintkyksyuruikgu;
    }
    @Override
    public String getZtysppinyuintkykkkn() {
        return pZtysppinyuintkykkkn;
    }
    @Override
    public void setZtysppinyuintkykkkn(String pZtysppinyuintkykkkn) {
        this.pZtysppinyuintkykkkn = pZtysppinyuintkykkkn;
    }
    @Override
    public String getZtysppinyuuintkykphrkkkn() {
        return pZtysppinyuuintkykphrkkkn;
    }
    @Override
    public void setZtysppinyuuintkykphrkkkn(String pZtysppinyuuintkykphrkkkn) {
        this.pZtysppinyuuintkykphrkkkn = pZtysppinyuuintkykphrkkkn;
    }
    @Override
    public Integer getZtysppinyuintkykntgk() {
        return pZtysppinyuintkykntgk;
    }
    @Override
    public void setZtysppinyuintkykntgk(Integer pZtysppinyuintkykntgk) {
        this.pZtysppinyuintkykntgk = pZtysppinyuintkykntgk;
    }
    @Override
    public String getZtysppinyuintkykgtkbn() {
        return pZtysppinyuintkykgtkbn;
    }
    @Override
    public void setZtysppinyuintkykgtkbn(String pZtysppinyuintkykgtkbn) {
        this.pZtysppinyuintkykgtkbn = pZtysppinyuintkykgtkbn;
    }
    @Override
    public Long getZtysippeinyuuintokuyakup() {
        return pZtysippeinyuuintokuyakup;
    }
    @Override
    public void setZtysippeinyuuintokuyakup(Long pZtysippeinyuuintokuyakup) {
        this.pZtysippeinyuuintokuyakup = pZtysippeinyuuintokuyakup;
    }
    @Override
    public Integer getZtysppinyuintkjyuryumshyutn() {
        return pZtysppinyuintkjyuryumshyutn;
    }
    @Override
    public void setZtysppinyuintkjyuryumshyutn(Integer pZtysppinyuintkjyuryumshyutn) {
        this.pZtysppinyuintkjyuryumshyutn = pZtysppinyuintkjyuryumshyutn;
    }
    @Override
    public Long getZtysippeinyuuintokujyoup() {
        return pZtysippeinyuuintokujyoup;
    }
    @Override
    public void setZtysippeinyuuintokujyoup(Long pZtysippeinyuuintokujyoup) {
        this.pZtysippeinyuuintokujyoup = pZtysippeinyuuintokujyoup;
    }
    @Override
    public String getZtysppinyuintktbicdx1() {
        return pZtysppinyuintktbicdx1;
    }
    @Override
    public void setZtysppinyuintktbicdx1(String pZtysppinyuintktbicdx1) {
        this.pZtysppinyuintktbicdx1 = pZtysppinyuintktbicdx1;
    }
    @Override
    public String getZtysppinyuinhtnpkknx1() {
        return pZtysppinyuinhtnpkknx1;
    }
    @Override
    public void setZtysppinyuinhtnpkknx1(String pZtysppinyuinhtnpkknx1) {
        this.pZtysppinyuinhtnpkknx1 = pZtysppinyuinhtnpkknx1;
    }
    @Override
    public String getZtysppinyuintktbicdx2() {
        return pZtysppinyuintktbicdx2;
    }
    @Override
    public void setZtysppinyuintktbicdx2(String pZtysppinyuintktbicdx2) {
        this.pZtysppinyuintktbicdx2 = pZtysppinyuintktbicdx2;
    }
    @Override
    public String getZtysppinyuinhtnpkknx2() {
        return pZtysppinyuinhtnpkknx2;
    }
    @Override
    public void setZtysppinyuinhtnpkknx2(String pZtysppinyuinhtnpkknx2) {
        this.pZtysppinyuinhtnpkknx2 = pZtysppinyuinhtnpkknx2;
    }
    @Override
    public String getZtysppinyuuintkykkgusdkbn() {
        return pZtysppinyuuintkykkgusdkbn;
    }
    @Override
    public void setZtysppinyuuintkykkgusdkbn(String pZtysppinyuuintkykkgusdkbn) {
        this.pZtysppinyuuintkykkgusdkbn = pZtysppinyuuintkykkgusdkbn;
    }
    @Override
    public String getZtysppinyuintkykpwrbkkbn() {
        return pZtysppinyuintkykpwrbkkbn;
    }
    @Override
    public void setZtysppinyuintkykpwrbkkbn(String pZtysppinyuintkykpwrbkkbn) {
        this.pZtysppinyuintkykpwrbkkbn = pZtysppinyuintkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv7x2() {
        return pZtyyobiv7x2;
    }
    @Override
    public void setZtyyobiv7x2(String pZtyyobiv7x2) {
        this.pZtyyobiv7x2 = pZtyyobiv7x2;
    }
    @Override
    public String getZtysijnbyutkyksyuruikgu() {
        return pZtysijnbyutkyksyuruikgu;
    }
    @Override
    public void setZtysijnbyutkyksyuruikgu(String pZtysijnbyutkyksyuruikgu) {
        this.pZtysijnbyutkyksyuruikgu = pZtysijnbyutkyksyuruikgu;
    }
    @Override
    public String getZtyseijinbyoutokuyakukikan() {
        return pZtyseijinbyoutokuyakukikan;
    }
    @Override
    public void setZtyseijinbyoutokuyakukikan(String pZtyseijinbyoutokuyakukikan) {
        this.pZtyseijinbyoutokuyakukikan = pZtyseijinbyoutokuyakukikan;
    }
    @Override
    public String getZtyseijinbyoutkykphrkkkn() {
        return pZtyseijinbyoutkykphrkkkn;
    }
    @Override
    public void setZtyseijinbyoutkykphrkkkn(String pZtyseijinbyoutkykphrkkkn) {
        this.pZtyseijinbyoutkykphrkkkn = pZtyseijinbyoutkykphrkkkn;
    }
    @Override
    public Integer getZtyseijinbyoutokuyakuntgk() {
        return pZtyseijinbyoutokuyakuntgk;
    }
    @Override
    public void setZtyseijinbyoutokuyakuntgk(Integer pZtyseijinbyoutokuyakuntgk) {
        this.pZtyseijinbyoutokuyakuntgk = pZtyseijinbyoutokuyakuntgk;
    }
    @Override
    public Long getZtyseijinbyoutokuyakup() {
        return pZtyseijinbyoutokuyakup;
    }
    @Override
    public void setZtyseijinbyoutokuyakup(Long pZtyseijinbyoutokuyakup) {
        this.pZtyseijinbyoutokuyakup = pZtyseijinbyoutokuyakup;
    }
    @Override
    public Integer getZtysijnbyutkjyuryumshyutn() {
        return pZtysijnbyutkjyuryumshyutn;
    }
    @Override
    public void setZtysijnbyutkjyuryumshyutn(Integer pZtysijnbyutkjyuryumshyutn) {
        this.pZtysijnbyutkjyuryumshyutn = pZtysijnbyutkjyuryumshyutn;
    }
    @Override
    public Long getZtyseijinbyoutokujyoup() {
        return pZtyseijinbyoutokujyoup;
    }
    @Override
    public void setZtyseijinbyoutokujyoup(Long pZtyseijinbyoutokujyoup) {
        this.pZtyseijinbyoutokujyoup = pZtyseijinbyoutokujyoup;
    }
    @Override
    public String getZtyseijinbyoutokuteibuicdx1() {
        return pZtyseijinbyoutokuteibuicdx1;
    }
    @Override
    public void setZtyseijinbyoutokuteibuicdx1(String pZtyseijinbyoutokuteibuicdx1) {
        this.pZtyseijinbyoutokuteibuicdx1 = pZtyseijinbyoutokuteibuicdx1;
    }
    @Override
    public String getZtyseijinbyouhutanpokikanx1() {
        return pZtyseijinbyouhutanpokikanx1;
    }
    @Override
    public void setZtyseijinbyouhutanpokikanx1(String pZtyseijinbyouhutanpokikanx1) {
        this.pZtyseijinbyouhutanpokikanx1 = pZtyseijinbyouhutanpokikanx1;
    }
    @Override
    public String getZtyseijinbyoutokuteibuicdx2() {
        return pZtyseijinbyoutokuteibuicdx2;
    }
    @Override
    public void setZtyseijinbyoutokuteibuicdx2(String pZtyseijinbyoutokuteibuicdx2) {
        this.pZtyseijinbyoutokuteibuicdx2 = pZtyseijinbyoutokuteibuicdx2;
    }
    @Override
    public String getZtyseijinbyouhutanpokikanx2() {
        return pZtyseijinbyouhutanpokikanx2;
    }
    @Override
    public void setZtyseijinbyouhutanpokikanx2(String pZtyseijinbyouhutanpokikanx2) {
        this.pZtyseijinbyouhutanpokikanx2 = pZtyseijinbyouhutanpokikanx2;
    }
    @Override
    public String getZtyseijinbyoutkykkgusdkbn() {
        return pZtyseijinbyoutkykkgusdkbn;
    }
    @Override
    public void setZtyseijinbyoutkykkgusdkbn(String pZtyseijinbyoutkykkgusdkbn) {
        this.pZtyseijinbyoutkykkgusdkbn = pZtyseijinbyoutkykkgusdkbn;
    }
    @Override
    public String getZtysijnbyutkykgankyuhgtkbn() {
        return pZtysijnbyutkykgankyuhgtkbn;
    }
    @Override
    public void setZtysijnbyutkykgankyuhgtkbn(String pZtysijnbyutkykgankyuhgtkbn) {
        this.pZtysijnbyutkykgankyuhgtkbn = pZtysijnbyutkykgankyuhgtkbn;
    }
    @Override
    public String getZtysijnbyutkykpwrbkkbn() {
        return pZtysijnbyutkykpwrbkkbn;
    }
    @Override
    public void setZtysijnbyutkykpwrbkkbn(String pZtysijnbyutkykpwrbkkbn) {
        this.pZtysijnbyutkykpwrbkkbn = pZtysijnbyutkykpwrbkkbn;
    }
    @Override
    public String getZtysijnbyutkykkusnmnryoage() {
        return pZtysijnbyutkykkusnmnryoage;
    }
    @Override
    public void setZtysijnbyutkykkusnmnryoage(String pZtysijnbyutkykkusnmnryoage) {
        this.pZtysijnbyutkykkusnmnryoage = pZtysijnbyutkykkusnmnryoage;
    }
    @Override
    public String getZtyyobiv4x11() {
        return pZtyyobiv4x11;
    }
    @Override
    public void setZtyyobiv4x11(String pZtyyobiv4x11) {
        this.pZtyyobiv4x11 = pZtyyobiv4x11;
    }
    @Override
    public String getZtyheiyoubaraikbn() {
        return pZtyheiyoubaraikbn;
    }
    @Override
    public void setZtyheiyoubaraikbn(String pZtyheiyoubaraikbn) {
        this.pZtyheiyoubaraikbn = pZtyheiyoubaraikbn;
    }
    @Override
    public String getZtyhiyubriaitsyono() {
        return pZtyhiyubriaitsyono;
    }
    @Override
    public void setZtyhiyubriaitsyono(String pZtyhiyubriaitsyono) {
        this.pZtyhiyubriaitsyono = pZtyhiyubriaitsyono;
    }
    @Override
    public String getZtyhiyubriaithrkkeirokbn() {
        return pZtyhiyubriaithrkkeirokbn;
    }
    @Override
    public void setZtyhiyubriaithrkkeirokbn(String pZtyhiyubriaithrkkeirokbn) {
        this.pZtyhiyubriaithrkkeirokbn = pZtyhiyubriaithrkkeirokbn;
    }
    @Override
    public Long getZtyheiyoubaraiaitekihons() {
        return pZtyheiyoubaraiaitekihons;
    }
    @Override
    public void setZtyheiyoubaraiaitekihons(Long pZtyheiyoubaraiaitekihons) {
        this.pZtyheiyoubaraiaitekihons = pZtyheiyoubaraiaitekihons;
    }
    @Override
    public Long getZtyhiyubrigukitnknitjbrkhns() {
        return pZtyhiyubrigukitnknitjbrkhns;
    }
    @Override
    public void setZtyhiyubrigukitnknitjbrkhns(Long pZtyhiyubrigukitnknitjbrkhns) {
        this.pZtyhiyubrigukitnknitjbrkhns = pZtyhiyubrigukitnknitjbrkhns;
    }
    @Override
    public Long getZtyheiyoubaraiaitesibous() {
        return pZtyheiyoubaraiaitesibous;
    }
    @Override
    public void setZtyheiyoubaraiaitesibous(Long pZtyheiyoubaraiaitesibous) {
        this.pZtyheiyoubaraiaitesibous = pZtyheiyoubaraiaitesibous;
    }
    @Override
    public Long getZtyhiyubrigukitnknitjbrsbus() {
        return pZtyhiyubrigukitnknitjbrsbus;
    }
    @Override
    public void setZtyhiyubrigukitnknitjbrsbus(Long pZtyhiyubrigukitnknitjbrsbus) {
        this.pZtyhiyubrigukitnknitjbrsbus = pZtyhiyubrigukitnknitjbrsbus;
    }
    @Override
    public Long getZtyheiyoubaraiaitesyuuseis() {
        return pZtyheiyoubaraiaitesyuuseis;
    }
    @Override
    public void setZtyheiyoubaraiaitesyuuseis(Long pZtyheiyoubaraiaitesyuuseis) {
        this.pZtyheiyoubaraiaitesyuuseis = pZtyheiyoubaraiaitesyuuseis;
    }
    @Override
    public Long getZtyheiyoubaraiaitehrkp() {
        return pZtyheiyoubaraiaitehrkp;
    }
    @Override
    public void setZtyheiyoubaraiaitehrkp(Long pZtyheiyoubaraiaitehrkp) {
        this.pZtyheiyoubaraiaitehrkp = pZtyheiyoubaraiaitehrkp;
    }
    @Override
    public Long getZtyhiyubriaitsykykp() {
        return pZtyhiyubriaitsykykp;
    }
    @Override
    public void setZtyhiyubriaitsykykp(Long pZtyhiyubriaitsykykp) {
        this.pZtyhiyubriaitsykykp = pZtyhiyubriaitsykykp;
    }
    @Override
    public Long getZtyheiyoubaraiaitemrtis() {
        return pZtyheiyoubaraiaitemrtis;
    }
    @Override
    public void setZtyheiyoubaraiaitemrtis(Long pZtyheiyoubaraiaitemrtis) {
        this.pZtyheiyoubaraiaitemrtis = pZtyheiyoubaraiaitemrtis;
    }
    @Override
    public Long getZtyhiyubrigukiaitkzkmrtis() {
        return pZtyhiyubrigukiaitkzkmrtis;
    }
    @Override
    public void setZtyhiyubrigukiaitkzkmrtis(Long pZtyhiyubrigukiaitkzkmrtis) {
        this.pZtyhiyubrigukiaitkzkmrtis = pZtyhiyubrigukiaitkzkmrtis;
    }
    @Override
    public String getZtytukibaraikyktenkanhyj() {
        return pZtytukibaraikyktenkanhyj;
    }
    @Override
    public void setZtytukibaraikyktenkanhyj(String pZtytukibaraikyktenkanhyj) {
        this.pZtytukibaraikyktenkanhyj = pZtytukibaraikyktenkanhyj;
    }
    @Override
    public String getZtybonusharaihrkkigetu1() {
        return pZtybonusharaihrkkigetu1;
    }
    @Override
    public void setZtybonusharaihrkkigetu1(String pZtybonusharaihrkkigetu1) {
        this.pZtybonusharaihrkkigetu1 = pZtybonusharaihrkkigetu1;
    }
    @Override
    public String getZtybonusharaihrkkigetu2() {
        return pZtybonusharaihrkkigetu2;
    }
    @Override
    public void setZtybonusharaihrkkigetu2(String pZtybonusharaihrkkigetu2) {
        this.pZtybonusharaihrkkigetu2 = pZtybonusharaihrkkigetu2;
    }
    @Override
    public Long getZtyhiyubriaitsiznmrtis() {
        return pZtyhiyubriaitsiznmrtis;
    }
    @Override
    public void setZtyhiyubriaitsiznmrtis(Long pZtyhiyubriaitsiznmrtis) {
        this.pZtyhiyubriaitsiznmrtis = pZtyhiyubriaitsiznmrtis;
    }
    @Override
    public Long getZtyhiyubriaittignmrtis() {
        return pZtyhiyubriaittignmrtis;
    }
    @Override
    public void setZtyhiyubriaittignmrtis(Long pZtyhiyubriaittignmrtis) {
        this.pZtyhiyubriaittignmrtis = pZtyhiyubriaittignmrtis;
    }
    @Override
    public String getZtytkjykbn() {
        return pZtytkjykbn;
    }
    @Override
    public void setZtytkjykbn(String pZtytkjykbn) {
        this.pZtytkjykbn = pZtytkjykbn;
    }
    @Override
    public String getZtysakugenkikan() {
        return pZtysakugenkikan;
    }
    @Override
    public void setZtysakugenkikan(String pZtysakugenkikan) {
        this.pZtysakugenkikan = pZtysakugenkikan;
    }
    @Override
    public Integer getZtyryoumasihyouten() {
        return pZtyryoumasihyouten;
    }
    @Override
    public void setZtyryoumasihyouten(Integer pZtyryoumasihyouten) {
        this.pZtyryoumasihyouten = pZtyryoumasihyouten;
    }
    @Override
    public Long getZtytokujyoup() {
        return pZtytokujyoup;
    }
    @Override
    public void setZtytokujyoup(Long pZtytokujyoup) {
        this.pZtytokujyoup = pZtytokujyoup;
    }
    @Override
    public String getZtyhjncd() {
        return pZtyhjncd;
    }
    @Override
    public void setZtyhjncd(String pZtyhjncd) {
        this.pZtyhjncd = pZtyhjncd;
    }
    @Override
    public String getZtyhjnjigyosyocd() {
        return pZtyhjnjigyosyocd;
    }
    @Override
    public void setZtyhjnjigyosyocd(String pZtyhjnjigyosyocd) {
        this.pZtyhjnjigyosyocd = pZtyhjnjigyosyocd;
    }
    @Override
    public Integer getZtyjyuugyouinsuu() {
        return pZtyjyuugyouinsuu;
    }
    @Override
    public void setZtyjyuugyouinsuu(Integer pZtyjyuugyouinsuu) {
        this.pZtyjyuugyouinsuu = pZtyjyuugyouinsuu;
    }
    @Override
    public String getZtyiktkaisuu() {
        return pZtyiktkaisuu;
    }
    @Override
    public void setZtyiktkaisuu(String pZtyiktkaisuu) {
        this.pZtyiktkaisuu = pZtyiktkaisuu;
    }
    @Override
    public String getZtyznnkai() {
        return pZtyznnkai;
    }
    @Override
    public void setZtyznnkai(String pZtyznnkai) {
        this.pZtyznnkai = pZtyznnkai;
    }
    @Override
    public String getZtykyktsnatkitkykkbn() {
        return pZtykyktsnatkitkykkbn;
    }
    @Override
    public void setZtykyktsnatkitkykkbn(String pZtykyktsnatkitkykkbn) {
        this.pZtykyktsnatkitkykkbn = pZtykyktsnatkitkykkbn;
    }
    @Override
    public String getZtykyktsnatkitkykstagekbn() {
        return pZtykyktsnatkitkykstagekbn;
    }
    @Override
    public void setZtykyktsnatkitkykstagekbn(String pZtykyktsnatkitkykstagekbn) {
        this.pZtykyktsnatkitkykstagekbn = pZtykyktsnatkitkykstagekbn;
    }
    @Override
    public String getZtypmentokuyakukbn() {
        return pZtypmentokuyakukbn;
    }
    @Override
    public void setZtypmentokuyakukbn(String pZtypmentokuyakukbn) {
        this.pZtypmentokuyakukbn = pZtypmentokuyakukbn;
    }
    @Override
    public String getZtyyobiv3() {
        return pZtyyobiv3;
    }
    @Override
    public void setZtyyobiv3(String pZtyyobiv3) {
        this.pZtyyobiv3 = pZtyyobiv3;
    }
    @Override
    public Long getZtytkykznnunyukngk() {
        return pZtytkykznnunyukngk;
    }
    @Override
    public void setZtytkykznnunyukngk(Long pZtytkykznnunyukngk) {
        this.pZtytkykznnunyukngk = pZtytkykznnunyukngk;
    }
    @Override
    public String getZtysyokaipnyuukinhouhoukbn() {
        return pZtysyokaipnyuukinhouhoukbn;
    }
    @Override
    public void setZtysyokaipnyuukinhouhoukbn(String pZtysyokaipnyuukinhouhoukbn) {
        this.pZtysyokaipnyuukinhouhoukbn = pZtysyokaipnyuukinhouhoukbn;
    }
    @Override
    public String getZtyhtnknkyksyonox1() {
        return pZtyhtnknkyksyonox1;
    }
    @Override
    public void setZtyhtnknkyksyonox1(String pZtyhtnknkyksyonox1) {
        this.pZtyhtnknkyksyonox1 = pZtyhtnknkyksyonox1;
    }
    @Override
    public String getZtyhtnknkykhknsyuruikgux1() {
        return pZtyhtnknkykhknsyuruikgux1;
    }
    @Override
    public void setZtyhtnknkykhknsyuruikgux1(String pZtyhtnknkykhknsyuruikgux1) {
        this.pZtyhtnknkykhknsyuruikgux1 = pZtyhtnknkykhknsyuruikgux1;
    }
    @Override
    public String getZtytenkanuketukeymdx1() {
        return pZtytenkanuketukeymdx1;
    }
    @Override
    public void setZtytenkanuketukeymdx1(String pZtytenkanuketukeymdx1) {
        this.pZtytenkanuketukeymdx1 = pZtytenkanuketukeymdx1;
    }
    @Override
    public String getZtyhtnknkykkykymdx1() {
        return pZtyhtnknkykkykymdx1;
    }
    @Override
    public void setZtyhtnknkykkykymdx1(String pZtyhtnknkykkykymdx1) {
        this.pZtyhtnknkykkykymdx1 = pZtyhtnknkykkykymdx1;
    }
    @Override
    public String getZtyhtnknkykhknkknx1() {
        return pZtyhtnknkykhknkknx1;
    }
    @Override
    public void setZtyhtnknkykhknkknx1(String pZtyhtnknkykhknkknx1) {
        this.pZtyhtnknkykhknkknx1 = pZtyhtnknkykhknkknx1;
    }
    @Override
    public String getZtyhtnknkykphrkkknx1() {
        return pZtyhtnknkykphrkkknx1;
    }
    @Override
    public void setZtyhtnknkykphrkkknx1(String pZtyhtnknkykphrkkknx1) {
        this.pZtyhtnknkykphrkkknx1 = pZtyhtnknkykphrkkknx1;
    }
    @Override
    public String getZtyhtnknkykhrkkaisuukbnx1() {
        return pZtyhtnknkykhrkkaisuukbnx1;
    }
    @Override
    public void setZtyhtnknkykhrkkaisuukbnx1(String pZtyhtnknkykhrkkaisuukbnx1) {
        this.pZtyhtnknkykhrkkaisuukbnx1 = pZtyhtnknkykhrkkaisuukbnx1;
    }
    @Override
    public String getZtyhtnknkykhrkkeirokbnx1() {
        return pZtyhtnknkykhrkkeirokbnx1;
    }
    @Override
    public void setZtyhtnknkykhrkkeirokbnx1(String pZtyhtnknkykhrkkeirokbnx1) {
        this.pZtyhtnknkykhrkkeirokbnx1 = pZtyhtnknkykhrkkeirokbnx1;
    }
    @Override
    public String getZtytnknuktkzngtkijyuhyjx1() {
        return pZtytnknuktkzngtkijyuhyjx1;
    }
    @Override
    public void setZtytnknuktkzngtkijyuhyjx1(String pZtytnknuktkzngtkijyuhyjx1) {
        this.pZtytnknuktkzngtkijyuhyjx1 = pZtytnknuktkzngtkijyuhyjx1;
    }
    @Override
    public String getZtyhtnknkykmrtisyuruikgux1() {
        return pZtyhtnknkykmrtisyuruikgux1;
    }
    @Override
    public void setZtyhtnknkykmrtisyuruikgux1(String pZtyhtnknkykmrtisyuruikgux1) {
        this.pZtyhtnknkykmrtisyuruikgux1 = pZtyhtnknkykmrtisyuruikgux1;
    }
    @Override
    public String getZtyhtnknkyksyonox2() {
        return pZtyhtnknkyksyonox2;
    }
    @Override
    public void setZtyhtnknkyksyonox2(String pZtyhtnknkyksyonox2) {
        this.pZtyhtnknkyksyonox2 = pZtyhtnknkyksyonox2;
    }
    @Override
    public String getZtyhtnknkykhknsyuruikgux2() {
        return pZtyhtnknkykhknsyuruikgux2;
    }
    @Override
    public void setZtyhtnknkykhknsyuruikgux2(String pZtyhtnknkykhknsyuruikgux2) {
        this.pZtyhtnknkykhknsyuruikgux2 = pZtyhtnknkykhknsyuruikgux2;
    }
    @Override
    public String getZtytenkanuketukeymdx2() {
        return pZtytenkanuketukeymdx2;
    }
    @Override
    public void setZtytenkanuketukeymdx2(String pZtytenkanuketukeymdx2) {
        this.pZtytenkanuketukeymdx2 = pZtytenkanuketukeymdx2;
    }
    @Override
    public String getZtyhtnknkykkykymdx2() {
        return pZtyhtnknkykkykymdx2;
    }
    @Override
    public void setZtyhtnknkykkykymdx2(String pZtyhtnknkykkykymdx2) {
        this.pZtyhtnknkykkykymdx2 = pZtyhtnknkykkykymdx2;
    }
    @Override
    public String getZtyhtnknkykhknkknx2() {
        return pZtyhtnknkykhknkknx2;
    }
    @Override
    public void setZtyhtnknkykhknkknx2(String pZtyhtnknkykhknkknx2) {
        this.pZtyhtnknkykhknkknx2 = pZtyhtnknkykhknkknx2;
    }
    @Override
    public String getZtyhtnknkykphrkkknx2() {
        return pZtyhtnknkykphrkkknx2;
    }
    @Override
    public void setZtyhtnknkykphrkkknx2(String pZtyhtnknkykphrkkknx2) {
        this.pZtyhtnknkykphrkkknx2 = pZtyhtnknkykphrkkknx2;
    }
    @Override
    public String getZtyhtnknkykhrkkaisuukbnx2() {
        return pZtyhtnknkykhrkkaisuukbnx2;
    }
    @Override
    public void setZtyhtnknkykhrkkaisuukbnx2(String pZtyhtnknkykhrkkaisuukbnx2) {
        this.pZtyhtnknkykhrkkaisuukbnx2 = pZtyhtnknkykhrkkaisuukbnx2;
    }
    @Override
    public String getZtyhtnknkykhrkkeirokbnx2() {
        return pZtyhtnknkykhrkkeirokbnx2;
    }
    @Override
    public void setZtyhtnknkykhrkkeirokbnx2(String pZtyhtnknkykhrkkeirokbnx2) {
        this.pZtyhtnknkykhrkkeirokbnx2 = pZtyhtnknkykhrkkeirokbnx2;
    }
    @Override
    public String getZtytnknuktkzngtkijyuhyjx2() {
        return pZtytnknuktkzngtkijyuhyjx2;
    }
    @Override
    public void setZtytnknuktkzngtkijyuhyjx2(String pZtytnknuktkzngtkijyuhyjx2) {
        this.pZtytnknuktkzngtkijyuhyjx2 = pZtytnknuktkzngtkijyuhyjx2;
    }
    @Override
    public String getZtyhtnknkykmrtisyuruikgux2() {
        return pZtyhtnknkykmrtisyuruikgux2;
    }
    @Override
    public void setZtyhtnknkykmrtisyuruikgux2(String pZtyhtnknkykmrtisyuruikgux2) {
        this.pZtyhtnknkykmrtisyuruikgux2 = pZtyhtnknkykmrtisyuruikgux2;
    }
    @Override
    public String getZtyhtnknkyksyonox3() {
        return pZtyhtnknkyksyonox3;
    }
    @Override
    public void setZtyhtnknkyksyonox3(String pZtyhtnknkyksyonox3) {
        this.pZtyhtnknkyksyonox3 = pZtyhtnknkyksyonox3;
    }
    @Override
    public String getZtyhtnknkykhknsyuruikgux3() {
        return pZtyhtnknkykhknsyuruikgux3;
    }
    @Override
    public void setZtyhtnknkykhknsyuruikgux3(String pZtyhtnknkykhknsyuruikgux3) {
        this.pZtyhtnknkykhknsyuruikgux3 = pZtyhtnknkykhknsyuruikgux3;
    }
    @Override
    public String getZtytenkanuketukeymdx3() {
        return pZtytenkanuketukeymdx3;
    }
    @Override
    public void setZtytenkanuketukeymdx3(String pZtytenkanuketukeymdx3) {
        this.pZtytenkanuketukeymdx3 = pZtytenkanuketukeymdx3;
    }
    @Override
    public String getZtyhtnknkykkykymdx3() {
        return pZtyhtnknkykkykymdx3;
    }
    @Override
    public void setZtyhtnknkykkykymdx3(String pZtyhtnknkykkykymdx3) {
        this.pZtyhtnknkykkykymdx3 = pZtyhtnknkykkykymdx3;
    }
    @Override
    public String getZtyhtnknkykhknkknx3() {
        return pZtyhtnknkykhknkknx3;
    }
    @Override
    public void setZtyhtnknkykhknkknx3(String pZtyhtnknkykhknkknx3) {
        this.pZtyhtnknkykhknkknx3 = pZtyhtnknkykhknkknx3;
    }
    @Override
    public String getZtyhtnknkykphrkkknx3() {
        return pZtyhtnknkykphrkkknx3;
    }
    @Override
    public void setZtyhtnknkykphrkkknx3(String pZtyhtnknkykphrkkknx3) {
        this.pZtyhtnknkykphrkkknx3 = pZtyhtnknkykphrkkknx3;
    }
    @Override
    public String getZtyhtnknkykhrkkaisuukbnx3() {
        return pZtyhtnknkykhrkkaisuukbnx3;
    }
    @Override
    public void setZtyhtnknkykhrkkaisuukbnx3(String pZtyhtnknkykhrkkaisuukbnx3) {
        this.pZtyhtnknkykhrkkaisuukbnx3 = pZtyhtnknkykhrkkaisuukbnx3;
    }
    @Override
    public String getZtyhtnknkykhrkkeirokbnx3() {
        return pZtyhtnknkykhrkkeirokbnx3;
    }
    @Override
    public void setZtyhtnknkykhrkkeirokbnx3(String pZtyhtnknkykhrkkeirokbnx3) {
        this.pZtyhtnknkykhrkkeirokbnx3 = pZtyhtnknkykhrkkeirokbnx3;
    }
    @Override
    public String getZtytnknuktkzngtkijyuhyjx3() {
        return pZtytnknuktkzngtkijyuhyjx3;
    }
    @Override
    public void setZtytnknuktkzngtkijyuhyjx3(String pZtytnknuktkzngtkijyuhyjx3) {
        this.pZtytnknuktkzngtkijyuhyjx3 = pZtytnknuktkzngtkijyuhyjx3;
    }
    @Override
    public String getZtyhtnknkykmrtisyuruikgux3() {
        return pZtyhtnknkykmrtisyuruikgux3;
    }
    @Override
    public void setZtyhtnknkykmrtisyuruikgux3(String pZtyhtnknkykmrtisyuruikgux3) {
        this.pZtyhtnknkykmrtisyuruikgux3 = pZtyhtnknkykmrtisyuruikgux3;
    }
    @Override
    public String getZtyhtnknkyksyonox4() {
        return pZtyhtnknkyksyonox4;
    }
    @Override
    public void setZtyhtnknkyksyonox4(String pZtyhtnknkyksyonox4) {
        this.pZtyhtnknkyksyonox4 = pZtyhtnknkyksyonox4;
    }
    @Override
    public String getZtyhtnknkykhknsyuruikgux4() {
        return pZtyhtnknkykhknsyuruikgux4;
    }
    @Override
    public void setZtyhtnknkykhknsyuruikgux4(String pZtyhtnknkykhknsyuruikgux4) {
        this.pZtyhtnknkykhknsyuruikgux4 = pZtyhtnknkykhknsyuruikgux4;
    }
    @Override
    public String getZtytenkanuketukeymdx4() {
        return pZtytenkanuketukeymdx4;
    }
    @Override
    public void setZtytenkanuketukeymdx4(String pZtytenkanuketukeymdx4) {
        this.pZtytenkanuketukeymdx4 = pZtytenkanuketukeymdx4;
    }
    @Override
    public String getZtyhtnknkykkykymdx4() {
        return pZtyhtnknkykkykymdx4;
    }
    @Override
    public void setZtyhtnknkykkykymdx4(String pZtyhtnknkykkykymdx4) {
        this.pZtyhtnknkykkykymdx4 = pZtyhtnknkykkykymdx4;
    }
    @Override
    public String getZtyhtnknkykhknkknx4() {
        return pZtyhtnknkykhknkknx4;
    }
    @Override
    public void setZtyhtnknkykhknkknx4(String pZtyhtnknkykhknkknx4) {
        this.pZtyhtnknkykhknkknx4 = pZtyhtnknkykhknkknx4;
    }
    @Override
    public String getZtyhtnknkykphrkkknx4() {
        return pZtyhtnknkykphrkkknx4;
    }
    @Override
    public void setZtyhtnknkykphrkkknx4(String pZtyhtnknkykphrkkknx4) {
        this.pZtyhtnknkykphrkkknx4 = pZtyhtnknkykphrkkknx4;
    }
    @Override
    public String getZtyhtnknkykhrkkaisuukbnx4() {
        return pZtyhtnknkykhrkkaisuukbnx4;
    }
    @Override
    public void setZtyhtnknkykhrkkaisuukbnx4(String pZtyhtnknkykhrkkaisuukbnx4) {
        this.pZtyhtnknkykhrkkaisuukbnx4 = pZtyhtnknkykhrkkaisuukbnx4;
    }
    @Override
    public String getZtyhtnknkykhrkkeirokbnx4() {
        return pZtyhtnknkykhrkkeirokbnx4;
    }
    @Override
    public void setZtyhtnknkykhrkkeirokbnx4(String pZtyhtnknkykhrkkeirokbnx4) {
        this.pZtyhtnknkykhrkkeirokbnx4 = pZtyhtnknkykhrkkeirokbnx4;
    }
    @Override
    public String getZtytnknuktkzngtkijyuhyjx4() {
        return pZtytnknuktkzngtkijyuhyjx4;
    }
    @Override
    public void setZtytnknuktkzngtkijyuhyjx4(String pZtytnknuktkzngtkijyuhyjx4) {
        this.pZtytnknuktkzngtkijyuhyjx4 = pZtytnknuktkzngtkijyuhyjx4;
    }
    @Override
    public String getZtyhtnknkykmrtisyuruikgux4() {
        return pZtyhtnknkykmrtisyuruikgux4;
    }
    @Override
    public void setZtyhtnknkykmrtisyuruikgux4(String pZtyhtnknkykmrtisyuruikgux4) {
        this.pZtyhtnknkykmrtisyuruikgux4 = pZtyhtnknkykmrtisyuruikgux4;
    }
    @Override
    public String getZtyhtnknkyksyonox5() {
        return pZtyhtnknkyksyonox5;
    }
    @Override
    public void setZtyhtnknkyksyonox5(String pZtyhtnknkyksyonox5) {
        this.pZtyhtnknkyksyonox5 = pZtyhtnknkyksyonox5;
    }
    @Override
    public String getZtyhtnknkykhknsyuruikgux5() {
        return pZtyhtnknkykhknsyuruikgux5;
    }
    @Override
    public void setZtyhtnknkykhknsyuruikgux5(String pZtyhtnknkykhknsyuruikgux5) {
        this.pZtyhtnknkykhknsyuruikgux5 = pZtyhtnknkykhknsyuruikgux5;
    }
    @Override
    public String getZtytenkanuketukeymdx5() {
        return pZtytenkanuketukeymdx5;
    }
    @Override
    public void setZtytenkanuketukeymdx5(String pZtytenkanuketukeymdx5) {
        this.pZtytenkanuketukeymdx5 = pZtytenkanuketukeymdx5;
    }
    @Override
    public String getZtyhtnknkykkykymdx5() {
        return pZtyhtnknkykkykymdx5;
    }
    @Override
    public void setZtyhtnknkykkykymdx5(String pZtyhtnknkykkykymdx5) {
        this.pZtyhtnknkykkykymdx5 = pZtyhtnknkykkykymdx5;
    }
    @Override
    public String getZtyhtnknkykhknkknx5() {
        return pZtyhtnknkykhknkknx5;
    }
    @Override
    public void setZtyhtnknkykhknkknx5(String pZtyhtnknkykhknkknx5) {
        this.pZtyhtnknkykhknkknx5 = pZtyhtnknkykhknkknx5;
    }
    @Override
    public String getZtyhtnknkykphrkkknx5() {
        return pZtyhtnknkykphrkkknx5;
    }
    @Override
    public void setZtyhtnknkykphrkkknx5(String pZtyhtnknkykphrkkknx5) {
        this.pZtyhtnknkykphrkkknx5 = pZtyhtnknkykphrkkknx5;
    }
    @Override
    public String getZtyhtnknkykhrkkaisuukbnx5() {
        return pZtyhtnknkykhrkkaisuukbnx5;
    }
    @Override
    public void setZtyhtnknkykhrkkaisuukbnx5(String pZtyhtnknkykhrkkaisuukbnx5) {
        this.pZtyhtnknkykhrkkaisuukbnx5 = pZtyhtnknkykhrkkaisuukbnx5;
    }
    @Override
    public String getZtyhtnknkykhrkkeirokbnx5() {
        return pZtyhtnknkykhrkkeirokbnx5;
    }
    @Override
    public void setZtyhtnknkykhrkkeirokbnx5(String pZtyhtnknkykhrkkeirokbnx5) {
        this.pZtyhtnknkykhrkkeirokbnx5 = pZtyhtnknkykhrkkeirokbnx5;
    }
    @Override
    public String getZtytnknuktkzngtkijyuhyjx5() {
        return pZtytnknuktkzngtkijyuhyjx5;
    }
    @Override
    public void setZtytnknuktkzngtkijyuhyjx5(String pZtytnknuktkzngtkijyuhyjx5) {
        this.pZtytnknuktkzngtkijyuhyjx5 = pZtytnknuktkzngtkijyuhyjx5;
    }
    @Override
    public String getZtyhtnknkykmrtisyuruikgux5() {
        return pZtyhtnknkykmrtisyuruikgux5;
    }
    @Override
    public void setZtyhtnknkykmrtisyuruikgux5(String pZtyhtnknkykmrtisyuruikgux5) {
        this.pZtyhtnknkykmrtisyuruikgux5 = pZtyhtnknkykmrtisyuruikgux5;
    }
    @Override
    public String getZtyhtnknkyksyonox6() {
        return pZtyhtnknkyksyonox6;
    }
    @Override
    public void setZtyhtnknkyksyonox6(String pZtyhtnknkyksyonox6) {
        this.pZtyhtnknkyksyonox6 = pZtyhtnknkyksyonox6;
    }
    @Override
    public String getZtyhtnknkykhknsyuruikgux6() {
        return pZtyhtnknkykhknsyuruikgux6;
    }
    @Override
    public void setZtyhtnknkykhknsyuruikgux6(String pZtyhtnknkykhknsyuruikgux6) {
        this.pZtyhtnknkykhknsyuruikgux6 = pZtyhtnknkykhknsyuruikgux6;
    }
    @Override
    public String getZtytenkanuketukeymdx6() {
        return pZtytenkanuketukeymdx6;
    }
    @Override
    public void setZtytenkanuketukeymdx6(String pZtytenkanuketukeymdx6) {
        this.pZtytenkanuketukeymdx6 = pZtytenkanuketukeymdx6;
    }
    @Override
    public String getZtyhtnknkykkykymdx6() {
        return pZtyhtnknkykkykymdx6;
    }
    @Override
    public void setZtyhtnknkykkykymdx6(String pZtyhtnknkykkykymdx6) {
        this.pZtyhtnknkykkykymdx6 = pZtyhtnknkykkykymdx6;
    }
    @Override
    public String getZtyhtnknkykhknkknx6() {
        return pZtyhtnknkykhknkknx6;
    }
    @Override
    public void setZtyhtnknkykhknkknx6(String pZtyhtnknkykhknkknx6) {
        this.pZtyhtnknkykhknkknx6 = pZtyhtnknkykhknkknx6;
    }
    @Override
    public String getZtyhtnknkykphrkkknx6() {
        return pZtyhtnknkykphrkkknx6;
    }
    @Override
    public void setZtyhtnknkykphrkkknx6(String pZtyhtnknkykphrkkknx6) {
        this.pZtyhtnknkykphrkkknx6 = pZtyhtnknkykphrkkknx6;
    }
    @Override
    public String getZtyhtnknkykhrkkaisuukbnx6() {
        return pZtyhtnknkykhrkkaisuukbnx6;
    }
    @Override
    public void setZtyhtnknkykhrkkaisuukbnx6(String pZtyhtnknkykhrkkaisuukbnx6) {
        this.pZtyhtnknkykhrkkaisuukbnx6 = pZtyhtnknkykhrkkaisuukbnx6;
    }
    @Override
    public String getZtyhtnknkykhrkkeirokbnx6() {
        return pZtyhtnknkykhrkkeirokbnx6;
    }
    @Override
    public void setZtyhtnknkykhrkkeirokbnx6(String pZtyhtnknkykhrkkeirokbnx6) {
        this.pZtyhtnknkykhrkkeirokbnx6 = pZtyhtnknkykhrkkeirokbnx6;
    }
    @Override
    public String getZtytnknuktkzngtkijyuhyjx6() {
        return pZtytnknuktkzngtkijyuhyjx6;
    }
    @Override
    public void setZtytnknuktkzngtkijyuhyjx6(String pZtytnknuktkzngtkijyuhyjx6) {
        this.pZtytnknuktkzngtkijyuhyjx6 = pZtytnknuktkzngtkijyuhyjx6;
    }
    @Override
    public String getZtyhtnknkykmrtisyuruikgux6() {
        return pZtyhtnknkykmrtisyuruikgux6;
    }
    @Override
    public void setZtyhtnknkykmrtisyuruikgux6(String pZtyhtnknkykmrtisyuruikgux6) {
        this.pZtyhtnknkykmrtisyuruikgux6 = pZtyhtnknkykmrtisyuruikgux6;
    }
    @Override
    public Long getZtygukihtnknkykkhns() {
        return pZtygukihtnknkykkhns;
    }
    @Override
    public void setZtygukihtnknkykkhns(Long pZtygukihtnknkykkhns) {
        this.pZtygukihtnknkykkhns = pZtygukihtnknkykkhns;
    }
    @Override
    public Long getZtygukihtnknkyksbus() {
        return pZtygukihtnknkyksbus;
    }
    @Override
    public void setZtygukihtnknkyksbus(Long pZtygukihtnknkyksbus) {
        this.pZtygukihtnknkyksbus = pZtygukihtnknkyksbus;
    }
    @Override
    public Long getZtygukihtnknkykhntiyup() {
        return pZtygukihtnknkykhntiyup;
    }
    @Override
    public void setZtygukihtnknkykhntiyup(Long pZtygukihtnknkykhntiyup) {
        this.pZtygukihtnknkykhntiyup = pZtygukihtnknkykhntiyup;
    }
    @Override
    public Long getZtygukihtnknkyksigwrmstkyks() {
        return pZtygukihtnknkyksigwrmstkyks;
    }
    @Override
    public void setZtygukihtnknkyksigwrmstkyks(Long pZtygukihtnknkyksigwrmstkyks) {
        this.pZtygukihtnknkyksigwrmstkyks = pZtygukihtnknkyksigwrmstkyks;
    }
    @Override
    public Long getZtygukihtnknkyksyugitkyks() {
        return pZtygukihtnknkyksyugitkyks;
    }
    @Override
    public void setZtygukihtnknkyksyugitkyks(Long pZtygukihtnknkyksyugitkyks) {
        this.pZtygukihtnknkyksyugitkyks = pZtygukihtnknkyksyugitkyks;
    }
    @Override
    public Integer getZtygukihtnknsignyintkykntgk() {
        return pZtygukihtnknsignyintkykntgk;
    }
    @Override
    public void setZtygukihtnknsignyintkykntgk(Integer pZtygukihtnknsignyintkykntgk) {
        this.pZtygukihtnknsignyintkykntgk = pZtygukihtnknsignyintkykntgk;
    }
    @Override
    public Integer getZtygukihtnknknkutkykntgk() {
        return pZtygukihtnknknkutkykntgk;
    }
    @Override
    public void setZtygukihtnknknkutkykntgk(Integer pZtygukihtnknknkutkykntgk) {
        this.pZtygukihtnknknkutkykntgk = pZtygukihtnknknkutkykntgk;
    }
    @Override
    public Long getZtygukihtnknkykmods() {
        return pZtygukihtnknkykmods;
    }
    @Override
    public void setZtygukihtnknkykmods(Long pZtygukihtnknkykmods) {
        this.pZtygukihtnknkykmods = pZtygukihtnknkykmods;
    }
    @Override
    public Long getZtygoukeitenkankakaku() {
        return pZtygoukeitenkankakaku;
    }
    @Override
    public void setZtygoukeitenkankakaku(Long pZtygoukeitenkankakaku) {
        this.pZtygoukeitenkankakaku = pZtygoukeitenkankakaku;
    }
    @Override
    public Long getZtygukitnknjsknnjynbkn() {
        return pZtygukitnknjsknnjynbkn;
    }
    @Override
    public void setZtygukitnknjsknnjynbkn(Long pZtygukitnknjsknnjynbkn) {
        this.pZtygukitnknjsknnjynbkn = pZtygukitnknjsknnjynbkn;
    }
    @Override
    public Long getZtygukitnknsisnkstkkngk() {
        return pZtygukitnknsisnkstkkngk;
    }
    @Override
    public void setZtygukitnknsisnkstkkngk(Long pZtygukitnknsisnkstkkngk) {
        this.pZtygukitnknsisnkstkkngk = pZtygukitnknsisnkstkkngk;
    }
    @Override
    public Long getZtygukitnknsisnttkekngk() {
        return pZtygukitnknsisnttkekngk;
    }
    @Override
    public void setZtygukitnknsisnttkekngk(Long pZtygukitnknsisnttkekngk) {
        this.pZtygukitnknsisnttkekngk = pZtygukitnknsisnttkekngk;
    }
    @Override
    public Long getZtygoukeitenkanseisand() {
        return pZtygoukeitenkanseisand;
    }
    @Override
    public void setZtygoukeitenkanseisand(Long pZtygoukeitenkanseisand) {
        this.pZtygoukeitenkanseisand = pZtygoukeitenkanseisand;
    }
    @Override
    public Long getZtygukitnknsisnmkikp() {
        return pZtygukitnknsisnmkikp;
    }
    @Override
    public void setZtygukitnknsisnmkikp(Long pZtygukitnknsisnmkikp) {
        this.pZtygukitnknsisnmkikp = pZtygukitnknsisnmkikp;
    }
    @Override
    public Long getZtygukitnknsisnsntkngk() {
        return pZtygukitnknsisnsntkngk;
    }
    @Override
    public void setZtygukitnknsisnsntkngk(Long pZtygukitnknsisnsntkngk) {
        this.pZtygukitnknsisnsntkngk = pZtygukitnknsisnsntkngk;
    }
    @Override
    public Long getZtygukitnknkhnbbnkiykkujygk() {
        return pZtygukitnknkhnbbnkiykkujygk;
    }
    @Override
    public void setZtygukitnknkhnbbnkiykkujygk(Long pZtygukitnknkhnbbnkiykkujygk) {
        this.pZtygukitnknkhnbbnkiykkujygk = pZtygukitnknkhnbbnkiykkujygk;
    }
    @Override
    public Long getZtygukitnkntikbbnkiykkujygk() {
        return pZtygukitnkntikbbnkiykkujygk;
    }
    @Override
    public void setZtygukitnkntikbbnkiykkujygk(Long pZtygukitnkntikbbnkiykkujygk) {
        this.pZtygukitnkntikbbnkiykkujygk = pZtygukitnkntikbbnkiykkujygk;
    }
    @Override
    public Long getZtygukitnknitjbrtiks() {
        return pZtygukitnknitjbrtiks;
    }
    @Override
    public void setZtygukitnknitjbrtiks(Long pZtygukitnknitjbrtiks) {
        this.pZtygukitnknitjbrtiks = pZtygukitnknitjbrtiks;
    }
    @Override
    public String getZtysethokenno() {
        return pZtysethokenno;
    }
    @Override
    public void setZtysethokenno(String pZtysethokenno) {
        this.pZtysethokenno = pZtysethokenno;
    }
    @Override
    public String getZtysckbn() {
        return pZtysckbn;
    }
    @Override
    public void setZtysckbn(String pZtysckbn) {
        this.pZtysckbn = pZtysckbn;
    }
    @Override
    public String getZtyenjyosyacd() {
        return pZtyenjyosyacd;
    }
    @Override
    public void setZtyenjyosyacd(String pZtyenjyosyacd) {
        this.pZtyenjyosyacd = pZtyenjyosyacd;
    }
    @Override
    public Long getZtynaibuwarimodosigaku() {
        return pZtynaibuwarimodosigaku;
    }
    @Override
    public void setZtynaibuwarimodosigaku(Long pZtynaibuwarimodosigaku) {
        this.pZtynaibuwarimodosigaku = pZtynaibuwarimodosigaku;
    }
    @Override
    public String getZtykeiyakukakuninsyuruikbn() {
        return pZtykeiyakukakuninsyuruikbn;
    }
    @Override
    public void setZtykeiyakukakuninsyuruikbn(String pZtykeiyakukakuninsyuruikbn) {
        this.pZtykeiyakukakuninsyuruikbn = pZtykeiyakukakuninsyuruikbn;
    }
    @Override
    public String getZtysoujikeitenkanhyouji() {
        return pZtysoujikeitenkanhyouji;
    }
    @Override
    public void setZtysoujikeitenkanhyouji(String pZtysoujikeitenkanhyouji) {
        this.pZtysoujikeitenkanhyouji = pZtysoujikeitenkanhyouji;
    }
    @Override
    public String getZtytenkanjisketteihouhoukbn() {
        return pZtytenkanjisketteihouhoukbn;
    }
    @Override
    public void setZtytenkanjisketteihouhoukbn(String pZtytenkanjisketteihouhoukbn) {
        this.pZtytenkanjisketteihouhoukbn = pZtytenkanjisketteihouhoukbn;
    }
    @Override
    public String getZtykeikanensuukbn() {
        return pZtykeikanensuukbn;
    }
    @Override
    public void setZtykeikanensuukbn(String pZtykeikanensuukbn) {
        this.pZtykeikanensuukbn = pZtykeikanensuukbn;
    }
    @Override
    public String getZtyhtnknkykhhknsytisyukbnx1() {
        return pZtyhtnknkykhhknsytisyukbnx1;
    }
    @Override
    public void setZtyhtnknkykhhknsytisyukbnx1(String pZtyhtnknkykhhknsytisyukbnx1) {
        this.pZtyhtnknkykhhknsytisyukbnx1 = pZtyhtnknkykhhknsytisyukbnx1;
    }
    @Override
    public String getZtyhtnknkykhhknsytisyukbnx2() {
        return pZtyhtnknkykhhknsytisyukbnx2;
    }
    @Override
    public void setZtyhtnknkykhhknsytisyukbnx2(String pZtyhtnknkykhhknsytisyukbnx2) {
        this.pZtyhtnknkykhhknsytisyukbnx2 = pZtyhtnknkykhhknsytisyukbnx2;
    }
    @Override
    public String getZtyhtnknkykhhknsytisyukbnx3() {
        return pZtyhtnknkykhhknsytisyukbnx3;
    }
    @Override
    public void setZtyhtnknkykhhknsytisyukbnx3(String pZtyhtnknkykhhknsytisyukbnx3) {
        this.pZtyhtnknkykhhknsytisyukbnx3 = pZtyhtnknkykhhknsytisyukbnx3;
    }
    @Override
    public String getZtyhtnknkykhhknsytisyukbnx4() {
        return pZtyhtnknkykhhknsytisyukbnx4;
    }
    @Override
    public void setZtyhtnknkykhhknsytisyukbnx4(String pZtyhtnknkykhhknsytisyukbnx4) {
        this.pZtyhtnknkykhhknsytisyukbnx4 = pZtyhtnknkykhhknsytisyukbnx4;
    }
    @Override
    public String getZtyhtnknkykhhknsytisyukbnx5() {
        return pZtyhtnknkykhhknsytisyukbnx5;
    }
    @Override
    public void setZtyhtnknkykhhknsytisyukbnx5(String pZtyhtnknkykhhknsytisyukbnx5) {
        this.pZtyhtnknkykhhknsytisyukbnx5 = pZtyhtnknkykhhknsytisyukbnx5;
    }
    @Override
    public String getZtyhtnknkykhhknsytisyukbnx6() {
        return pZtyhtnknkykhhknsytisyukbnx6;
    }
    @Override
    public void setZtyhtnknkykhhknsytisyukbnx6(String pZtyhtnknkykhhknsytisyukbnx6) {
        this.pZtyhtnknkykhhknsytisyukbnx6 = pZtyhtnknkykhhknsytisyukbnx6;
    }
    @Override
    public Long getZtykktijgukipbbntnkns() {
        return pZtykktijgukipbbntnkns;
    }
    @Override
    public void setZtykktijgukipbbntnkns(Long pZtykktijgukipbbntnkns) {
        this.pZtykktijgukipbbntnkns = pZtykktijgukipbbntnkns;
    }
    @Override
    public Long getZtysyonendosyokaip() {
        return pZtysyonendosyokaip;
    }
    @Override
    public void setZtysyonendosyokaip(Long pZtysyonendosyokaip) {
        this.pZtysyonendosyokaip = pZtysyonendosyokaip;
    }
    @Override
    public Long getZtysyonendo2kaimeikoup() {
        return pZtysyonendo2kaimeikoup;
    }
    @Override
    public void setZtysyonendo2kaimeikoup(Long pZtysyonendo2kaimeikoup) {
        this.pZtysyonendo2kaimeikoup = pZtysyonendo2kaimeikoup;
    }
    @Override
    public Long getZtyjinendoikoup() {
        return pZtyjinendoikoup;
    }
    @Override
    public void setZtyjinendoikoup(Long pZtyjinendoikoup) {
        this.pZtyjinendoikoup = pZtyjinendoikoup;
    }
    @Override
    public Integer getZtysyukeiyakusikyuukisogaku() {
        return pZtysyukeiyakusikyuukisogaku;
    }
    @Override
    public void setZtysyukeiyakusikyuukisogaku(Integer pZtysyukeiyakusikyuukisogaku) {
        this.pZtysyukeiyakusikyuukisogaku = pZtysyukeiyakusikyuukisogaku;
    }
    @Override
    public Integer getZtysykyknenhantatskyuksgk() {
        return pZtysykyknenhantatskyuksgk;
    }
    @Override
    public void setZtysykyknenhantatskyuksgk(Integer pZtysykyknenhantatskyuksgk) {
        this.pZtysykyknenhantatskyuksgk = pZtysykyknenhantatskyuksgk;
    }
    @Override
    public Integer getZtymaruteisikyuukisogaku() {
        return pZtymaruteisikyuukisogaku;
    }
    @Override
    public void setZtymaruteisikyuukisogaku(Integer pZtymaruteisikyuukisogaku) {
        this.pZtymaruteisikyuukisogaku = pZtymaruteisikyuukisogaku;
    }
    @Override
    public Integer getZtyitjbrzugkskyuksgkx1() {
        return pZtyitjbrzugkskyuksgkx1;
    }
    @Override
    public void setZtyitjbrzugkskyuksgkx1(Integer pZtyitjbrzugkskyuksgkx1) {
        this.pZtyitjbrzugkskyuksgkx1 = pZtyitjbrzugkskyuksgkx1;
    }
    @Override
    public Integer getZtyitjbrzugkskyuksgkx2() {
        return pZtyitjbrzugkskyuksgkx2;
    }
    @Override
    public void setZtyitjbrzugkskyuksgkx2(Integer pZtyitjbrzugkskyuksgkx2) {
        this.pZtyitjbrzugkskyuksgkx2 = pZtyitjbrzugkskyuksgkx2;
    }
    @Override
    public Integer getZtyitjbrzgknnhntatskyksgkx1() {
        return pZtyitjbrzgknnhntatskyksgkx1;
    }
    @Override
    public void setZtyitjbrzgknnhntatskyksgkx1(Integer pZtyitjbrzgknnhntatskyksgkx1) {
        this.pZtyitjbrzgknnhntatskyksgkx1 = pZtyitjbrzgknnhntatskyksgkx1;
    }
    @Override
    public Integer getZtyitjbrzgknnhntatskyksgkx2() {
        return pZtyitjbrzgknnhntatskyksgkx2;
    }
    @Override
    public void setZtyitjbrzgknnhntatskyksgkx2(Integer pZtyitjbrzgknnhntatskyksgkx2) {
        this.pZtyitjbrzgknnhntatskyksgkx2 = pZtyitjbrzgknnhntatskyksgkx2;
    }
    @Override
    public Integer getZtykzkmrtiskyuksgk() {
        return pZtykzkmrtiskyuksgk;
    }
    @Override
    public void setZtykzkmrtiskyuksgk(Integer pZtykzkmrtiskyuksgk) {
        this.pZtykzkmrtiskyuksgk = pZtykzkmrtiskyuksgk;
    }
    @Override
    public Integer getZtyitibitjbrskyuksgk() {
        return pZtyitibitjbrskyuksgk;
    }
    @Override
    public void setZtyitibitjbrskyuksgk(Integer pZtyitibitjbrskyuksgk) {
        this.pZtyitibitjbrskyuksgk = pZtyitibitjbrskyuksgk;
    }
    @Override
    public Integer getZtyitbitjbrnnhntatskyuksgk() {
        return pZtyitbitjbrnnhntatskyuksgk;
    }
    @Override
    public void setZtyitbitjbrnnhntatskyuksgk(Integer pZtyitbitjbrnnhntatskyuksgk) {
        this.pZtyitbitjbrnnhntatskyuksgk = pZtyitbitjbrnnhntatskyuksgk;
    }
    @Override
    public Integer getZtysykykksnbsyutat() {
        return pZtysykykksnbsyutat;
    }
    @Override
    public void setZtysykykksnbsyutat(Integer pZtysykykksnbsyutat) {
        this.pZtysykykksnbsyutat = pZtysykykksnbsyutat;
    }
    @Override
    public Integer getZtyitjbrzugkksnbsyutatx1() {
        return pZtyitjbrzugkksnbsyutatx1;
    }
    @Override
    public void setZtyitjbrzugkksnbsyutatx1(Integer pZtyitjbrzugkksnbsyutatx1) {
        this.pZtyitjbrzugkksnbsyutatx1 = pZtyitjbrzugkksnbsyutatx1;
    }
    @Override
    public Integer getZtyitjbrzugkksnbsyutatx2() {
        return pZtyitjbrzugkksnbsyutatx2;
    }
    @Override
    public void setZtyitjbrzugkksnbsyutatx2(Integer pZtyitjbrzugkksnbsyutatx2) {
        this.pZtyitjbrzugkksnbsyutatx2 = pZtyitjbrzugkksnbsyutatx2;
    }
    @Override
    public Integer getZtyitibitjbrksnbsyutat() {
        return pZtyitibitjbrksnbsyutat;
    }
    @Override
    public void setZtyitibitjbrksnbsyutat(Integer pZtyitibitjbrksnbsyutat) {
        this.pZtyitibitjbrksnbsyutat = pZtyitibitjbrksnbsyutat;
    }
    @Override
    public BizNumber getZtyjyunkensuu() {
        return pZtyjyunkensuu;
    }
    @Override
    public void setZtyjyunkensuu(BizNumber pZtyjyunkensuu) {
        this.pZtyjyunkensuu = pZtyjyunkensuu;
    }
    @Override
    public BizNumber getZtykansankensuu() {
        return pZtykansankensuu;
    }
    @Override
    public void setZtykansankensuu(BizNumber pZtykansankensuu) {
        this.pZtykansankensuu = pZtykansankensuu;
    }
    @Override
    public String getZtyitibuitijibaraikikan() {
        return pZtyitibuitijibaraikikan;
    }
    @Override
    public void setZtyitibuitijibaraikikan(String pZtyitibuitijibaraikikan) {
        this.pZtyitibuitijibaraikikan = pZtyitibuitijibaraikikan;
    }
    @Override
    public Long getZtyitibuitijibarais() {
        return pZtyitibuitijibarais;
    }
    @Override
    public void setZtyitibuitijibarais(Long pZtyitibuitijibarais) {
        this.pZtyitibuitijibarais = pZtyitibuitijibarais;
    }
    @Override
    public Long getZtyitibuitijibaraip() {
        return pZtyitibuitijibaraip;
    }
    @Override
    public void setZtyitibuitijibaraip(Long pZtyitibuitijibaraip) {
        this.pZtyitibuitijibaraip = pZtyitibuitijibaraip;
    }
    @Override
    public String getZtyitibitjbrsdtpdtkbn() {
        return pZtyitibitjbrsdtpdtkbn;
    }
    @Override
    public void setZtyitibitjbrsdtpdtkbn(String pZtyitibitjbrsdtpdtkbn) {
        this.pZtyitibitjbrsdtpdtkbn = pZtyitibitjbrsdtpdtkbn;
    }
    @Override
    public Long getZtyitibuitijibaraisyuuseis() {
        return pZtyitibuitijibaraisyuuseis;
    }
    @Override
    public void setZtyitibuitijibaraisyuuseis(Long pZtyitibuitijibaraisyuuseis) {
        this.pZtyitibuitijibaraisyuuseis = pZtyitibuitijibaraisyuuseis;
    }
    @Override
    public String getZtyitibitjbrmodsskgnhyj() {
        return pZtyitibitjbrmodsskgnhyj;
    }
    @Override
    public void setZtyitibitjbrmodsskgnhyj(String pZtyitibitjbrmodsskgnhyj) {
        this.pZtyitibitjbrmodsskgnhyj = pZtyitibitjbrmodsskgnhyj;
    }
    @Override
    public String getZtysuuriyousyoriym() {
        return pZtysuuriyousyoriym;
    }
    @Override
    public void setZtysuuriyousyoriym(String pZtysuuriyousyoriym) {
        this.pZtysuuriyousyoriym = pZtysuuriyousyoriym;
    }
    @Override
    public String getZtysyosinsinsahouhoukbn() {
        return pZtysyosinsinsahouhoukbn;
    }
    @Override
    public void setZtysyosinsinsahouhoukbn(String pZtysyosinsinsahouhoukbn) {
        this.pZtysyosinsinsahouhoukbn = pZtysyosinsinsahouhoukbn;
    }
    @Override
    public String getZtysaisinsinsahouhoukbn() {
        return pZtysaisinsinsahouhoukbn;
    }
    @Override
    public void setZtysaisinsinsahouhoukbn(String pZtysaisinsinsahouhoukbn) {
        this.pZtysaisinsinsahouhoukbn = pZtysaisinsinsahouhoukbn;
    }
    @Override
    public String getZtyseizonmrtisyuruikgu() {
        return pZtyseizonmrtisyuruikgu;
    }
    @Override
    public void setZtyseizonmrtisyuruikgu(String pZtyseizonmrtisyuruikgu) {
        this.pZtyseizonmrtisyuruikgu = pZtyseizonmrtisyuruikgu;
    }
    @Override
    public String getZtyseizonmaruteikikan() {
        return pZtyseizonmaruteikikan;
    }
    @Override
    public void setZtyseizonmaruteikikan(String pZtyseizonmaruteikikan) {
        this.pZtyseizonmaruteikikan = pZtyseizonmaruteikikan;
    }
    @Override
    public String getZtyseizonmrtiphrkkkn() {
        return pZtyseizonmrtiphrkkkn;
    }
    @Override
    public void setZtyseizonmrtiphrkkkn(String pZtyseizonmrtiphrkkkn) {
        this.pZtyseizonmrtiphrkkkn = pZtyseizonmrtiphrkkkn;
    }
    @Override
    public Long getZtyseizonmaruteis() {
        return pZtyseizonmaruteis;
    }
    @Override
    public void setZtyseizonmaruteis(Long pZtyseizonmaruteis) {
        this.pZtyseizonmaruteis = pZtyseizonmaruteis;
    }
    @Override
    public Long getZtyseizonmaruteip() {
        return pZtyseizonmaruteip;
    }
    @Override
    public void setZtyseizonmaruteip(Long pZtyseizonmaruteip) {
        this.pZtyseizonmaruteip = pZtyseizonmaruteip;
    }
    @Override
    public Long getZtyseizonmaruteisyuuseis() {
        return pZtyseizonmaruteisyuuseis;
    }
    @Override
    public void setZtyseizonmaruteisyuuseis(Long pZtyseizonmaruteisyuuseis) {
        this.pZtyseizonmaruteisyuuseis = pZtyseizonmaruteisyuuseis;
    }
    @Override
    public String getZtyseizonmrtimodsskgnhyj() {
        return pZtyseizonmrtimodsskgnhyj;
    }
    @Override
    public void setZtyseizonmrtimodsskgnhyj(String pZtyseizonmrtimodsskgnhyj) {
        this.pZtyseizonmrtimodsskgnhyj = pZtyseizonmrtimodsskgnhyj;
    }
    @Override
    public String getZtysiznmrtitkjyukbn() {
        return pZtysiznmrtitkjyukbn;
    }
    @Override
    public void setZtysiznmrtitkjyukbn(String pZtysiznmrtitkjyukbn) {
        this.pZtysiznmrtitkjyukbn = pZtysiznmrtitkjyukbn;
    }
    @Override
    public String getZtysiznmrtitkjyuskgnkkn() {
        return pZtysiznmrtitkjyuskgnkkn;
    }
    @Override
    public void setZtysiznmrtitkjyuskgnkkn(String pZtysiznmrtitkjyuskgnkkn) {
        this.pZtysiznmrtitkjyuskgnkkn = pZtysiznmrtitkjyuskgnkkn;
    }
    @Override
    public Integer getZtysiznmrtitkjyuryumshyutn() {
        return pZtysiznmrtitkjyuryumshyutn;
    }
    @Override
    public void setZtysiznmrtitkjyuryumshyutn(Integer pZtysiznmrtitkjyuryumshyutn) {
        this.pZtysiznmrtitkjyuryumshyutn = pZtysiznmrtitkjyuryumshyutn;
    }
    @Override
    public Long getZtysiznmrtitkjyup() {
        return pZtysiznmrtitkjyup;
    }
    @Override
    public void setZtysiznmrtitkjyup(Long pZtysiznmrtitkjyup) {
        this.pZtysiznmrtitkjyup = pZtysiznmrtitkjyup;
    }
    @Override
    public Integer getZtysiznmrtiskyuksgk() {
        return pZtysiznmrtiskyuksgk;
    }
    @Override
    public void setZtysiznmrtiskyuksgk(Integer pZtysiznmrtiskyuksgk) {
        this.pZtysiznmrtiskyuksgk = pZtysiznmrtiskyuksgk;
    }
    @Override
    public String getZtyhtnknkyksiznmrtsyrikgux1() {
        return pZtyhtnknkyksiznmrtsyrikgux1;
    }
    @Override
    public void setZtyhtnknkyksiznmrtsyrikgux1(String pZtyhtnknkyksiznmrtsyrikgux1) {
        this.pZtyhtnknkyksiznmrtsyrikgux1 = pZtyhtnknkyksiznmrtsyrikgux1;
    }
    @Override
    public String getZtyhtnknkyksiznmrtsyrikgux2() {
        return pZtyhtnknkyksiznmrtsyrikgux2;
    }
    @Override
    public void setZtyhtnknkyksiznmrtsyrikgux2(String pZtyhtnknkyksiznmrtsyrikgux2) {
        this.pZtyhtnknkyksiznmrtsyrikgux2 = pZtyhtnknkyksiznmrtsyrikgux2;
    }
    @Override
    public String getZtyhtnknkyksiznmrtsyrikgux3() {
        return pZtyhtnknkyksiznmrtsyrikgux3;
    }
    @Override
    public void setZtyhtnknkyksiznmrtsyrikgux3(String pZtyhtnknkyksiznmrtsyrikgux3) {
        this.pZtyhtnknkyksiznmrtsyrikgux3 = pZtyhtnknkyksiznmrtsyrikgux3;
    }
    @Override
    public String getZtyhtnknkyksiznmrtsyrikgux4() {
        return pZtyhtnknkyksiznmrtsyrikgux4;
    }
    @Override
    public void setZtyhtnknkyksiznmrtsyrikgux4(String pZtyhtnknkyksiznmrtsyrikgux4) {
        this.pZtyhtnknkyksiznmrtsyrikgux4 = pZtyhtnknkyksiznmrtsyrikgux4;
    }
    @Override
    public String getZtyhtnknkyksiznmrtsyrikgux5() {
        return pZtyhtnknkyksiznmrtsyrikgux5;
    }
    @Override
    public void setZtyhtnknkyksiznmrtsyrikgux5(String pZtyhtnknkyksiznmrtsyrikgux5) {
        this.pZtyhtnknkyksiznmrtsyrikgux5 = pZtyhtnknkyksiznmrtsyrikgux5;
    }
    @Override
    public String getZtyhtnknkyksiznmrtsyrikgux6() {
        return pZtyhtnknkyksiznmrtsyrikgux6;
    }
    @Override
    public void setZtyhtnknkyksiznmrtsyrikgux6(String pZtyhtnknkyksiznmrtsyrikgux6) {
        this.pZtyhtnknkyksiznmrtsyrikgux6 = pZtyhtnknkyksiznmrtsyrikgux6;
    }
    @Override
    public String getZtysuryusiznmrtipwrbkkbn() {
        return pZtysuryusiznmrtipwrbkkbn;
    }
    @Override
    public void setZtysuryusiznmrtipwrbkkbn(String pZtysuryusiznmrtipwrbkkbn) {
        this.pZtysuryusiznmrtipwrbkkbn = pZtysuryusiznmrtipwrbkkbn;
    }
    @Override
    public String getZtysiznmrtipwrbkkbn() {
        return pZtysiznmrtipwrbkkbn;
    }
    @Override
    public void setZtysiznmrtipwrbkkbn(String pZtysiznmrtipwrbkkbn) {
        this.pZtysiznmrtipwrbkkbn = pZtysiznmrtipwrbkkbn;
    }
    @Override
    public String getZtysiznmrtitnknyugukbn() {
        return pZtysiznmrtitnknyugukbn;
    }
    @Override
    public void setZtysiznmrtitnknyugukbn(String pZtysiznmrtitnknyugukbn) {
        this.pZtysiznmrtitnknyugukbn = pZtysiznmrtitnknyugukbn;
    }
    @Override
    public String getZtyseizonmrtikgusdkbn() {
        return pZtyseizonmrtikgusdkbn;
    }
    @Override
    public void setZtyseizonmrtikgusdkbn(String pZtyseizonmrtikgusdkbn) {
        this.pZtyseizonmrtikgusdkbn = pZtyseizonmrtikgusdkbn;
    }
    @Override
    public String getZtyyobiv1() {
        return pZtyyobiv1;
    }
    @Override
    public void setZtyyobiv1(String pZtyyobiv1) {
        this.pZtyyobiv1 = pZtyyobiv1;
    }
    @Override
    public String getZtydai2hihokensyamei() {
        return pZtydai2hihokensyamei;
    }
    @Override
    public void setZtydai2hihokensyamei(String pZtydai2hihokensyamei) {
        this.pZtydai2hihokensyamei = pZtydai2hihokensyamei;
    }
    @Override
    public String getZtydai2kanjihihokensyamei() {
        return pZtydai2kanjihihokensyamei;
    }
    @Override
    public void setZtydai2kanjihihokensyamei(String pZtydai2kanjihihokensyamei) {
        this.pZtydai2kanjihihokensyamei = pZtydai2kanjihihokensyamei;
    }
    @Override
    public String getZtydai2hihokensyaseiymd() {
        return pZtydai2hihokensyaseiymd;
    }
    @Override
    public void setZtydai2hihokensyaseiymd(String pZtydai2hihokensyaseiymd) {
        this.pZtydai2hihokensyaseiymd = pZtydai2hihokensyaseiymd;
    }
    @Override
    public String getZtydai2hihokensyaseibetukbn() {
        return pZtydai2hihokensyaseibetukbn;
    }
    @Override
    public void setZtydai2hihokensyaseibetukbn(String pZtydai2hihokensyaseibetukbn) {
        this.pZtydai2hihokensyaseibetukbn = pZtydai2hihokensyaseibetukbn;
    }
    @Override
    public String getZtydai2hihknsyahnskhkncd() {
        return pZtydai2hihknsyahnskhkncd;
    }
    @Override
    public void setZtydai2hihknsyahnskhkncd(String pZtydai2hihknsyahnskhkncd) {
        this.pZtydai2hihknsyahnskhkncd = pZtydai2hihknsyahnskhkncd;
    }
    @Override
    public String getZtydai2hhknnen() {
        return pZtydai2hhknnen;
    }
    @Override
    public void setZtydai2hhknnen(String pZtydai2hhknnen) {
        this.pZtydai2hhknnen = pZtydai2hhknnen;
    }
    @Override
    public String getZtydai2hihknsyakikykarihyj() {
        return pZtydai2hihknsyakikykarihyj;
    }
    @Override
    public void setZtydai2hihknsyakikykarihyj(String pZtydai2hihknsyakikykarihyj) {
        this.pZtydai2hihknsyakikykarihyj = pZtydai2hihknsyakikykarihyj;
    }
    @Override
    public String getZtykyksydi2hihknsyaduithyj() {
        return pZtykyksydi2hihknsyaduithyj;
    }
    @Override
    public void setZtykyksydi2hihknsyaduithyj(String pZtykyksydi2hihknsyaduithyj) {
        this.pZtykyksydi2hihknsyaduithyj = pZtykyksydi2hihknsyaduithyj;
    }
    @Override
    public String getZtydai2syosinsinsahouhoukbn() {
        return pZtydai2syosinsinsahouhoukbn;
    }
    @Override
    public void setZtydai2syosinsinsahouhoukbn(String pZtydai2syosinsinsahouhoukbn) {
        this.pZtydai2syosinsinsahouhoukbn = pZtydai2syosinsinsahouhoukbn;
    }
    @Override
    public String getZtydai2saisinsinsahouhoukbn() {
        return pZtydai2saisinsinsahouhoukbn;
    }
    @Override
    public void setZtydai2saisinsinsahouhoukbn(String pZtydai2saisinsinsahouhoukbn) {
        this.pZtydai2saisinsinsahouhoukbn = pZtydai2saisinsinsahouhoukbn;
    }
    @Override
    public String getZtydai2syokugyoucd() {
        return pZtydai2syokugyoucd;
    }
    @Override
    public void setZtydai2syokugyoucd(String pZtydai2syokugyoucd) {
        this.pZtydai2syokugyoucd = pZtydai2syokugyoucd;
    }
    @Override
    public String getZtydai2sakugenkikan() {
        return pZtydai2sakugenkikan;
    }
    @Override
    public void setZtydai2sakugenkikan(String pZtydai2sakugenkikan) {
        this.pZtydai2sakugenkikan = pZtydai2sakugenkikan;
    }
    @Override
    public Integer getZtydai2ryoumasihyouten() {
        return pZtydai2ryoumasihyouten;
    }
    @Override
    public void setZtydai2ryoumasihyouten(Integer pZtydai2ryoumasihyouten) {
        this.pZtydai2ryoumasihyouten = pZtydai2ryoumasihyouten;
    }
    @Override
    public String getZtymrtidi2skgnkkn() {
        return pZtymrtidi2skgnkkn;
    }
    @Override
    public void setZtymrtidi2skgnkkn(String pZtymrtidi2skgnkkn) {
        this.pZtymrtidi2skgnkkn = pZtymrtidi2skgnkkn;
    }
    @Override
    public Integer getZtymrtidi2ryumshyutn() {
        return pZtymrtidi2ryumshyutn;
    }
    @Override
    public void setZtymrtidi2ryumshyutn(Integer pZtymrtidi2ryumshyutn) {
        this.pZtymrtidi2ryumshyutn = pZtymrtidi2ryumshyutn;
    }
    @Override
    public String getZtydi2kykkknnsyrikbn() {
        return pZtydi2kykkknnsyrikbn;
    }
    @Override
    public void setZtydi2kykkknnsyrikbn(String pZtydi2kykkknnsyrikbn) {
        this.pZtydi2kykkknnsyrikbn = pZtydi2kykkknnsyrikbn;
    }
    @Override
    public String getZtytignmrtidi2skgnkkn() {
        return pZtytignmrtidi2skgnkkn;
    }
    @Override
    public void setZtytignmrtidi2skgnkkn(String pZtytignmrtidi2skgnkkn) {
        this.pZtytignmrtidi2skgnkkn = pZtytignmrtidi2skgnkkn;
    }
    @Override
    public Integer getZtytignmrtidi2ryumshyutn() {
        return pZtytignmrtidi2ryumshyutn;
    }
    @Override
    public void setZtytignmrtidi2ryumshyutn(Integer pZtytignmrtidi2ryumshyutn) {
        this.pZtytignmrtidi2ryumshyutn = pZtytignmrtidi2ryumshyutn;
    }
    @Override
    public String getZtydai2syosinhonninkknnkbn() {
        return pZtydai2syosinhonninkknnkbn;
    }
    @Override
    public void setZtydai2syosinhonninkknnkbn(String pZtydai2syosinhonninkknnkbn) {
        this.pZtydai2syosinhonninkknnkbn = pZtydai2syosinhonninkknnkbn;
    }
    @Override
    public String getZtydi2sisnhonninkknnkbn() {
        return pZtydi2sisnhonninkknnkbn;
    }
    @Override
    public void setZtydi2sisnhonninkknnkbn(String pZtydi2sisnhonninkknnkbn) {
        this.pZtydi2sisnhonninkknnkbn = pZtydi2sisnhonninkknnkbn;
    }
    @Override
    public String getZtyyobiv9x6() {
        return pZtyyobiv9x6;
    }
    @Override
    public void setZtyyobiv9x6(String pZtyyobiv9x6) {
        this.pZtyyobiv9x6 = pZtyyobiv9x6;
    }
    @Override
    public String getZtydi2syugitkyksyrikgu() {
        return pZtydi2syugitkyksyrikgu;
    }
    @Override
    public void setZtydi2syugitkyksyrikgu(String pZtydi2syugitkyksyrikgu) {
        this.pZtydi2syugitkyksyrikgu = pZtydi2syugitkyksyrikgu;
    }
    @Override
    public String getZtydai2syougaitokuyakukikan() {
        return pZtydai2syougaitokuyakukikan;
    }
    @Override
    public void setZtydai2syougaitokuyakukikan(String pZtydai2syougaitokuyakukikan) {
        this.pZtydai2syougaitokuyakukikan = pZtydai2syougaitokuyakukikan;
    }
    @Override
    public String getZtydi2syugitkykphrkkkn() {
        return pZtydi2syugitkykphrkkkn;
    }
    @Override
    public void setZtydi2syugitkykphrkkkn(String pZtydi2syugitkykphrkkkn) {
        this.pZtydi2syugitkykphrkkkn = pZtydi2syugitkykphrkkkn;
    }
    @Override
    public Long getZtydai2syougaitokuyakus() {
        return pZtydai2syougaitokuyakus;
    }
    @Override
    public void setZtydai2syougaitokuyakus(Long pZtydai2syougaitokuyakus) {
        this.pZtydai2syougaitokuyakus = pZtydai2syougaitokuyakus;
    }
    @Override
    public Long getZtydai2syougaitokuyakup() {
        return pZtydai2syougaitokuyakup;
    }
    @Override
    public void setZtydai2syougaitokuyakup(Long pZtydai2syougaitokuyakup) {
        this.pZtydai2syougaitokuyakup = pZtydai2syougaitokuyakup;
    }
    @Override
    public String getZtydi2syugitkykgtkbn() {
        return pZtydi2syugitkykgtkbn;
    }
    @Override
    public void setZtydi2syugitkykgtkbn(String pZtydi2syugitkykgtkbn) {
        this.pZtydi2syugitkykgtkbn = pZtydi2syugitkykgtkbn;
    }
    @Override
    public String getZtydi2syugitkykkgusdkbn() {
        return pZtydi2syugitkykkgusdkbn;
    }
    @Override
    public void setZtydi2syugitkykkgusdkbn(String pZtydi2syugitkykkgusdkbn) {
        this.pZtydi2syugitkykkgusdkbn = pZtydi2syugitkykkgusdkbn;
    }
    @Override
    public String getZtydi2syugitkykpwrbkkbn() {
        return pZtydi2syugitkykpwrbkkbn;
    }
    @Override
    public void setZtydi2syugitkykpwrbkkbn(String pZtydi2syugitkykpwrbkkbn) {
        this.pZtydi2syugitkykpwrbkkbn = pZtydi2syugitkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv8() {
        return pZtyyobiv8;
    }
    @Override
    public void setZtyyobiv8(String pZtyyobiv8) {
        this.pZtyyobiv8 = pZtyyobiv8;
    }
    @Override
    public String getZtydi2sigiwrmstkyksyrikgu() {
        return pZtydi2sigiwrmstkyksyrikgu;
    }
    @Override
    public void setZtydi2sigiwrmstkyksyrikgu(String pZtydi2sigiwrmstkyksyrikgu) {
        this.pZtydi2sigiwrmstkyksyrikgu = pZtydi2sigiwrmstkyksyrikgu;
    }
    @Override
    public String getZtydi2sigiwrmstkykkkn() {
        return pZtydi2sigiwrmstkykkkn;
    }
    @Override
    public void setZtydi2sigiwrmstkykkkn(String pZtydi2sigiwrmstkykkkn) {
        this.pZtydi2sigiwrmstkykkkn = pZtydi2sigiwrmstkykkkn;
    }
    @Override
    public String getZtydi2sigiwrmstkykphrkkkn() {
        return pZtydi2sigiwrmstkykphrkkkn;
    }
    @Override
    public void setZtydi2sigiwrmstkykphrkkkn(String pZtydi2sigiwrmstkykphrkkkn) {
        this.pZtydi2sigiwrmstkykphrkkkn = pZtydi2sigiwrmstkykphrkkkn;
    }
    @Override
    public Long getZtydi2sigiwrmstkyks() {
        return pZtydi2sigiwrmstkyks;
    }
    @Override
    public void setZtydi2sigiwrmstkyks(Long pZtydi2sigiwrmstkyks) {
        this.pZtydi2sigiwrmstkyks = pZtydi2sigiwrmstkyks;
    }
    @Override
    public Long getZtydi2sigiwrmstkykp() {
        return pZtydi2sigiwrmstkykp;
    }
    @Override
    public void setZtydi2sigiwrmstkykp(Long pZtydi2sigiwrmstkykp) {
        this.pZtydi2sigiwrmstkykp = pZtydi2sigiwrmstkykp;
    }
    @Override
    public String getZtydi2sigiwrmstkykkgusdkbn() {
        return pZtydi2sigiwrmstkykkgusdkbn;
    }
    @Override
    public void setZtydi2sigiwrmstkykkgusdkbn(String pZtydi2sigiwrmstkykkgusdkbn) {
        this.pZtydi2sigiwrmstkykkgusdkbn = pZtydi2sigiwrmstkykkgusdkbn;
    }
    @Override
    public String getZtydi2sigiwrmstkykpwrbkkbn() {
        return pZtydi2sigiwrmstkykpwrbkkbn;
    }
    @Override
    public void setZtydi2sigiwrmstkykpwrbkkbn(String pZtydi2sigiwrmstkykpwrbkkbn) {
        this.pZtydi2sigiwrmstkykpwrbkkbn = pZtydi2sigiwrmstkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv9x7() {
        return pZtyyobiv9x7;
    }
    @Override
    public void setZtyyobiv9x7(String pZtyyobiv9x7) {
        this.pZtyyobiv9x7 = pZtyyobiv9x7;
    }
    @Override
    public String getZtydi2siginyuintkyksyrikgu() {
        return pZtydi2siginyuintkyksyrikgu;
    }
    @Override
    public void setZtydi2siginyuintkyksyrikgu(String pZtydi2siginyuintkyksyrikgu) {
        this.pZtydi2siginyuintkyksyrikgu = pZtydi2siginyuintkyksyrikgu;
    }
    @Override
    public String getZtydi2siginyuintkykkkn() {
        return pZtydi2siginyuintkykkkn;
    }
    @Override
    public void setZtydi2siginyuintkykkkn(String pZtydi2siginyuintkykkkn) {
        this.pZtydi2siginyuintkykkkn = pZtydi2siginyuintkykkkn;
    }
    @Override
    public String getZtydi2siginyuintkykphrkkkn() {
        return pZtydi2siginyuintkykphrkkkn;
    }
    @Override
    public void setZtydi2siginyuintkykphrkkkn(String pZtydi2siginyuintkykphrkkkn) {
        this.pZtydi2siginyuintkykphrkkkn = pZtydi2siginyuintkykphrkkkn;
    }
    @Override
    public Integer getZtydi2siginyuintkykntgk() {
        return pZtydi2siginyuintkykntgk;
    }
    @Override
    public void setZtydi2siginyuintkykntgk(Integer pZtydi2siginyuintkykntgk) {
        this.pZtydi2siginyuintkykntgk = pZtydi2siginyuintkykntgk;
    }
    @Override
    public Long getZtydi2siginyuintkykp() {
        return pZtydi2siginyuintkykp;
    }
    @Override
    public void setZtydi2siginyuintkykp(Long pZtydi2siginyuintkykp) {
        this.pZtydi2siginyuintkykp = pZtydi2siginyuintkykp;
    }
    @Override
    public String getZtydi2siginyuintkykgtkbn() {
        return pZtydi2siginyuintkykgtkbn;
    }
    @Override
    public void setZtydi2siginyuintkykgtkbn(String pZtydi2siginyuintkykgtkbn) {
        this.pZtydi2siginyuintkykgtkbn = pZtydi2siginyuintkykgtkbn;
    }
    @Override
    public String getZtydi2siginyintkykkgusdkbn() {
        return pZtydi2siginyintkykkgusdkbn;
    }
    @Override
    public void setZtydi2siginyintkykkgusdkbn(String pZtydi2siginyintkykkgusdkbn) {
        this.pZtydi2siginyintkykkgusdkbn = pZtydi2siginyintkykkgusdkbn;
    }
    @Override
    public String getZtydi2siginyuintkykpwrbkkbn() {
        return pZtydi2siginyuintkykpwrbkkbn;
    }
    @Override
    public void setZtydi2siginyuintkykpwrbkkbn(String pZtydi2siginyuintkykpwrbkkbn) {
        this.pZtydi2siginyuintkykpwrbkkbn = pZtydi2siginyuintkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv10x3() {
        return pZtyyobiv10x3;
    }
    @Override
    public void setZtyyobiv10x3(String pZtyyobiv10x3) {
        this.pZtyyobiv10x3 = pZtyyobiv10x3;
    }
    @Override
    public String getZtydi2sppinyuintkyksyrikgu() {
        return pZtydi2sppinyuintkyksyrikgu;
    }
    @Override
    public void setZtydi2sppinyuintkyksyrikgu(String pZtydi2sppinyuintkyksyrikgu) {
        this.pZtydi2sppinyuintkyksyrikgu = pZtydi2sppinyuintkyksyrikgu;
    }
    @Override
    public String getZtydi2sppinyuintkykkkn() {
        return pZtydi2sppinyuintkykkkn;
    }
    @Override
    public void setZtydi2sppinyuintkykkkn(String pZtydi2sppinyuintkykkkn) {
        this.pZtydi2sppinyuintkykkkn = pZtydi2sppinyuintkykkkn;
    }
    @Override
    public String getZtydi2sppinyuintkykphrkkkn() {
        return pZtydi2sppinyuintkykphrkkkn;
    }
    @Override
    public void setZtydi2sppinyuintkykphrkkkn(String pZtydi2sppinyuintkykphrkkkn) {
        this.pZtydi2sppinyuintkykphrkkkn = pZtydi2sppinyuintkykphrkkkn;
    }
    @Override
    public Integer getZtydi2sppinyuintkykntgk() {
        return pZtydi2sppinyuintkykntgk;
    }
    @Override
    public void setZtydi2sppinyuintkykntgk(Integer pZtydi2sppinyuintkykntgk) {
        this.pZtydi2sppinyuintkykntgk = pZtydi2sppinyuintkykntgk;
    }
    @Override
    public Long getZtydi2sppinyuintkykp() {
        return pZtydi2sppinyuintkykp;
    }
    @Override
    public void setZtydi2sppinyuintkykp(Long pZtydi2sppinyuintkykp) {
        this.pZtydi2sppinyuintkykp = pZtydi2sppinyuintkykp;
    }
    @Override
    public String getZtydi2sppinyuintkykgtkbn() {
        return pZtydi2sppinyuintkykgtkbn;
    }
    @Override
    public void setZtydi2sppinyuintkykgtkbn(String pZtydi2sppinyuintkykgtkbn) {
        this.pZtydi2sppinyuintkykgtkbn = pZtydi2sppinyuintkykgtkbn;
    }
    @Override
    public Integer getZtydi2sppinyintkjyryumshytn() {
        return pZtydi2sppinyintkjyryumshytn;
    }
    @Override
    public void setZtydi2sppinyintkjyryumshytn(Integer pZtydi2sppinyintkjyryumshytn) {
        this.pZtydi2sppinyintkjyryumshytn = pZtydi2sppinyintkjyryumshytn;
    }
    @Override
    public Long getZtydi2sppinyuintkjyup() {
        return pZtydi2sppinyuintkjyup;
    }
    @Override
    public void setZtydi2sppinyuintkjyup(Long pZtydi2sppinyuintkjyup) {
        this.pZtydi2sppinyuintkjyup = pZtydi2sppinyuintkjyup;
    }
    @Override
    public String getZtydi2sppinyuintktbicdx1() {
        return pZtydi2sppinyuintktbicdx1;
    }
    @Override
    public void setZtydi2sppinyuintktbicdx1(String pZtydi2sppinyuintktbicdx1) {
        this.pZtydi2sppinyuintktbicdx1 = pZtydi2sppinyuintktbicdx1;
    }
    @Override
    public String getZtydi2sppinyuinhtnpkknx1() {
        return pZtydi2sppinyuinhtnpkknx1;
    }
    @Override
    public void setZtydi2sppinyuinhtnpkknx1(String pZtydi2sppinyuinhtnpkknx1) {
        this.pZtydi2sppinyuinhtnpkknx1 = pZtydi2sppinyuinhtnpkknx1;
    }
    @Override
    public String getZtydi2sppinyuintktbicdx2() {
        return pZtydi2sppinyuintktbicdx2;
    }
    @Override
    public void setZtydi2sppinyuintktbicdx2(String pZtydi2sppinyuintktbicdx2) {
        this.pZtydi2sppinyuintktbicdx2 = pZtydi2sppinyuintktbicdx2;
    }
    @Override
    public String getZtydi2sppinyuinhtnpkknx2() {
        return pZtydi2sppinyuinhtnpkknx2;
    }
    @Override
    public void setZtydi2sppinyuinhtnpkknx2(String pZtydi2sppinyuinhtnpkknx2) {
        this.pZtydi2sppinyuinhtnpkknx2 = pZtydi2sppinyuinhtnpkknx2;
    }
    @Override
    public String getZtydi2sppinyintkykkgusdkbn() {
        return pZtydi2sppinyintkykkgusdkbn;
    }
    @Override
    public void setZtydi2sppinyintkykkgusdkbn(String pZtydi2sppinyintkykkgusdkbn) {
        this.pZtydi2sppinyintkykkgusdkbn = pZtydi2sppinyintkykkgusdkbn;
    }
    @Override
    public String getZtydi2sppinyuintkykpwrbkkbn() {
        return pZtydi2sppinyuintkykpwrbkkbn;
    }
    @Override
    public void setZtydi2sppinyuintkykpwrbkkbn(String pZtydi2sppinyuintkykpwrbkkbn) {
        this.pZtydi2sppinyuintkykpwrbkkbn = pZtydi2sppinyuintkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv3x2() {
        return pZtyyobiv3x2;
    }
    @Override
    public void setZtyyobiv3x2(String pZtyyobiv3x2) {
        this.pZtyyobiv3x2 = pZtyyobiv3x2;
    }
    @Override
    public String getZtydi2sijnbyutkyksyrikgu() {
        return pZtydi2sijnbyutkyksyrikgu;
    }
    @Override
    public void setZtydi2sijnbyutkyksyrikgu(String pZtydi2sijnbyutkyksyrikgu) {
        this.pZtydi2sijnbyutkyksyrikgu = pZtydi2sijnbyutkyksyrikgu;
    }
    @Override
    public String getZtydi2sijnbyutkykkkn() {
        return pZtydi2sijnbyutkykkkn;
    }
    @Override
    public void setZtydi2sijnbyutkykkkn(String pZtydi2sijnbyutkykkkn) {
        this.pZtydi2sijnbyutkykkkn = pZtydi2sijnbyutkykkkn;
    }
    @Override
    public String getZtydi2sijnbyutkykphrkkkn() {
        return pZtydi2sijnbyutkykphrkkkn;
    }
    @Override
    public void setZtydi2sijnbyutkykphrkkkn(String pZtydi2sijnbyutkykphrkkkn) {
        this.pZtydi2sijnbyutkykphrkkkn = pZtydi2sijnbyutkykphrkkkn;
    }
    @Override
    public Integer getZtydi2sijnbyutkykntgk() {
        return pZtydi2sijnbyutkykntgk;
    }
    @Override
    public void setZtydi2sijnbyutkykntgk(Integer pZtydi2sijnbyutkykntgk) {
        this.pZtydi2sijnbyutkykntgk = pZtydi2sijnbyutkykntgk;
    }
    @Override
    public Long getZtydai2seijinbyoutokuyakup() {
        return pZtydai2seijinbyoutokuyakup;
    }
    @Override
    public void setZtydai2seijinbyoutokuyakup(Long pZtydai2seijinbyoutokuyakup) {
        this.pZtydai2seijinbyoutokuyakup = pZtydai2seijinbyoutokuyakup;
    }
    @Override
    public Integer getZtydi2sijnbyutkjyurymshytn() {
        return pZtydi2sijnbyutkjyurymshytn;
    }
    @Override
    public void setZtydi2sijnbyutkjyurymshytn(Integer pZtydi2sijnbyutkjyurymshytn) {
        this.pZtydi2sijnbyutkjyurymshytn = pZtydi2sijnbyutkjyurymshytn;
    }
    @Override
    public Long getZtydai2seijinbyoutokujyoup() {
        return pZtydai2seijinbyoutokujyoup;
    }
    @Override
    public void setZtydai2seijinbyoutokujyoup(Long pZtydai2seijinbyoutokujyoup) {
        this.pZtydai2seijinbyoutokujyoup = pZtydai2seijinbyoutokujyoup;
    }
    @Override
    public String getZtydi2sijnbyutktbicdx1() {
        return pZtydi2sijnbyutktbicdx1;
    }
    @Override
    public void setZtydi2sijnbyutktbicdx1(String pZtydi2sijnbyutktbicdx1) {
        this.pZtydi2sijnbyutktbicdx1 = pZtydi2sijnbyutktbicdx1;
    }
    @Override
    public String getZtydi2sijnbyuhtnpkknx1() {
        return pZtydi2sijnbyuhtnpkknx1;
    }
    @Override
    public void setZtydi2sijnbyuhtnpkknx1(String pZtydi2sijnbyuhtnpkknx1) {
        this.pZtydi2sijnbyuhtnpkknx1 = pZtydi2sijnbyuhtnpkknx1;
    }
    @Override
    public String getZtydi2sijnbyutktbicdx2() {
        return pZtydi2sijnbyutktbicdx2;
    }
    @Override
    public void setZtydi2sijnbyutktbicdx2(String pZtydi2sijnbyutktbicdx2) {
        this.pZtydi2sijnbyutktbicdx2 = pZtydi2sijnbyutktbicdx2;
    }
    @Override
    public String getZtydi2sijnbyuhtnpkknx2() {
        return pZtydi2sijnbyuhtnpkknx2;
    }
    @Override
    public void setZtydi2sijnbyuhtnpkknx2(String pZtydi2sijnbyuhtnpkknx2) {
        this.pZtydi2sijnbyuhtnpkknx2 = pZtydi2sijnbyuhtnpkknx2;
    }
    @Override
    public String getZtydi2sijnbyutkykkgusdkbn() {
        return pZtydi2sijnbyutkykkgusdkbn;
    }
    @Override
    public void setZtydi2sijnbyutkykkgusdkbn(String pZtydi2sijnbyutkykkgusdkbn) {
        this.pZtydi2sijnbyutkykkgusdkbn = pZtydi2sijnbyutkykkgusdkbn;
    }
    @Override
    public String getZtydi2sijnbytkykgankyhgtkbn() {
        return pZtydi2sijnbytkykgankyhgtkbn;
    }
    @Override
    public void setZtydi2sijnbytkykgankyhgtkbn(String pZtydi2sijnbytkykgankyhgtkbn) {
        this.pZtydi2sijnbytkykgankyhgtkbn = pZtydi2sijnbytkykgankyhgtkbn;
    }
    @Override
    public String getZtydi2sijnbyutkykpwrbkkbn() {
        return pZtydi2sijnbyutkykpwrbkkbn;
    }
    @Override
    public void setZtydi2sijnbyutkykpwrbkkbn(String pZtydi2sijnbyutkykpwrbkkbn) {
        this.pZtydi2sijnbyutkykpwrbkkbn = pZtydi2sijnbyutkykpwrbkkbn;
    }
    @Override
    public String getZtyyobiv3x3() {
        return pZtyyobiv3x3;
    }
    @Override
    public void setZtyyobiv3x3(String pZtyyobiv3x3) {
        this.pZtyyobiv3x3 = pZtyyobiv3x3;
    }
    @Override
    public String getZtydai2jyoukentukihyouji() {
        return pZtydai2jyoukentukihyouji;
    }
    @Override
    public void setZtydai2jyoukentukihyouji(String pZtydai2jyoukentukihyouji) {
        this.pZtydai2jyoukentukihyouji = pZtydai2jyoukentukihyouji;
    }
    @Override
    public String getZtytignmrtisyukgu() {
        return pZtytignmrtisyukgu;
    }
    @Override
    public void setZtytignmrtisyukgu(String pZtytignmrtisyukgu) {
        this.pZtytignmrtisyukgu = pZtytignmrtisyukgu;
    }
    @Override
    public String getZtyteigenmaruteikikan() {
        return pZtyteigenmaruteikikan;
    }
    @Override
    public void setZtyteigenmaruteikikan(String pZtyteigenmaruteikikan) {
        this.pZtyteigenmaruteikikan = pZtyteigenmaruteikikan;
    }
    @Override
    public String getZtyteigenmrtiphrkkkn() {
        return pZtyteigenmrtiphrkkkn;
    }
    @Override
    public void setZtyteigenmrtiphrkkkn(String pZtyteigenmrtiphrkkkn) {
        this.pZtyteigenmrtiphrkkkn = pZtyteigenmrtiphrkkkn;
    }
    @Override
    public Long getZtyteigenmaruteis() {
        return pZtyteigenmaruteis;
    }
    @Override
    public void setZtyteigenmaruteis(Long pZtyteigenmaruteis) {
        this.pZtyteigenmaruteis = pZtyteigenmaruteis;
    }
    @Override
    public Long getZtyteigenmaruteip() {
        return pZtyteigenmaruteip;
    }
    @Override
    public void setZtyteigenmaruteip(Long pZtyteigenmaruteip) {
        this.pZtyteigenmaruteip = pZtyteigenmaruteip;
    }
    @Override
    public Long getZtyteigenmaruteisyuuseis() {
        return pZtyteigenmaruteisyuuseis;
    }
    @Override
    public void setZtyteigenmaruteisyuuseis(Long pZtyteigenmaruteisyuuseis) {
        this.pZtyteigenmaruteisyuuseis = pZtyteigenmaruteisyuuseis;
    }
    @Override
    public String getZtyteigenmrtimodssakugenhyj() {
        return pZtyteigenmrtimodssakugenhyj;
    }
    @Override
    public void setZtyteigenmrtimodssakugenhyj(String pZtyteigenmrtimodssakugenhyj) {
        this.pZtyteigenmrtimodssakugenhyj = pZtyteigenmrtimodssakugenhyj;
    }
    @Override
    public String getZtytignmrtitkjyukbn() {
        return pZtytignmrtitkjyukbn;
    }
    @Override
    public void setZtytignmrtitkjyukbn(String pZtytignmrtitkjyukbn) {
        this.pZtytignmrtitkjyukbn = pZtytignmrtitkjyukbn;
    }
    @Override
    public String getZtytignmrtitkjyuskgnkkn() {
        return pZtytignmrtitkjyuskgnkkn;
    }
    @Override
    public void setZtytignmrtitkjyuskgnkkn(String pZtytignmrtitkjyuskgnkkn) {
        this.pZtytignmrtitkjyuskgnkkn = pZtytignmrtitkjyuskgnkkn;
    }
    @Override
    public Integer getZtytignmrtitkjyuryumshyutn() {
        return pZtytignmrtitkjyuryumshyutn;
    }
    @Override
    public void setZtytignmrtitkjyuryumshyutn(Integer pZtytignmrtitkjyuryumshyutn) {
        this.pZtytignmrtitkjyuryumshyutn = pZtytignmrtitkjyuryumshyutn;
    }
    @Override
    public Long getZtytignmrtitkjyup() {
        return pZtytignmrtitkjyup;
    }
    @Override
    public void setZtytignmrtitkjyup(Long pZtytignmrtitkjyup) {
        this.pZtytignmrtitkjyup = pZtytignmrtitkjyup;
    }
    @Override
    public Integer getZtytignmrtiskyuksgk() {
        return pZtytignmrtiskyuksgk;
    }
    @Override
    public void setZtytignmrtiskyuksgk(Integer pZtytignmrtiskyuksgk) {
        this.pZtytignmrtiskyuksgk = pZtytignmrtiskyuksgk;
    }
    @Override
    public String getZtyhtnknkyktignmrtsyrikgux1() {
        return pZtyhtnknkyktignmrtsyrikgux1;
    }
    @Override
    public void setZtyhtnknkyktignmrtsyrikgux1(String pZtyhtnknkyktignmrtsyrikgux1) {
        this.pZtyhtnknkyktignmrtsyrikgux1 = pZtyhtnknkyktignmrtsyrikgux1;
    }
    @Override
    public String getZtyhtnknkyktignmrtsyrikgux2() {
        return pZtyhtnknkyktignmrtsyrikgux2;
    }
    @Override
    public void setZtyhtnknkyktignmrtsyrikgux2(String pZtyhtnknkyktignmrtsyrikgux2) {
        this.pZtyhtnknkyktignmrtsyrikgux2 = pZtyhtnknkyktignmrtsyrikgux2;
    }
    @Override
    public String getZtyhtnknkyktignmrtsyrikgux3() {
        return pZtyhtnknkyktignmrtsyrikgux3;
    }
    @Override
    public void setZtyhtnknkyktignmrtsyrikgux3(String pZtyhtnknkyktignmrtsyrikgux3) {
        this.pZtyhtnknkyktignmrtsyrikgux3 = pZtyhtnknkyktignmrtsyrikgux3;
    }
    @Override
    public String getZtyhtnknkyktignmrtsyrikgux4() {
        return pZtyhtnknkyktignmrtsyrikgux4;
    }
    @Override
    public void setZtyhtnknkyktignmrtsyrikgux4(String pZtyhtnknkyktignmrtsyrikgux4) {
        this.pZtyhtnknkyktignmrtsyrikgux4 = pZtyhtnknkyktignmrtsyrikgux4;
    }
    @Override
    public String getZtyhtnknkyktignmrtsyrikgux5() {
        return pZtyhtnknkyktignmrtsyrikgux5;
    }
    @Override
    public void setZtyhtnknkyktignmrtsyrikgux5(String pZtyhtnknkyktignmrtsyrikgux5) {
        this.pZtyhtnknkyktignmrtsyrikgux5 = pZtyhtnknkyktignmrtsyrikgux5;
    }
    @Override
    public String getZtyhtnknkyktignmrtsyrikgux6() {
        return pZtyhtnknkyktignmrtsyrikgux6;
    }
    @Override
    public void setZtyhtnknkyktignmrtsyrikgux6(String pZtyhtnknkyktignmrtsyrikgux6) {
        this.pZtyhtnknkyktignmrtsyrikgux6 = pZtyhtnknkyktignmrtsyrikgux6;
    }
    @Override
    public String getZtysuryutignmrtipwrbkkbn() {
        return pZtysuryutignmrtipwrbkkbn;
    }
    @Override
    public void setZtysuryutignmrtipwrbkkbn(String pZtysuryutignmrtipwrbkkbn) {
        this.pZtysuryutignmrtipwrbkkbn = pZtysuryutignmrtipwrbkkbn;
    }
    @Override
    public String getZtytignmrtipwrbkkbn() {
        return pZtytignmrtipwrbkkbn;
    }
    @Override
    public void setZtytignmrtipwrbkkbn(String pZtytignmrtipwrbkkbn) {
        this.pZtytignmrtipwrbkkbn = pZtytignmrtipwrbkkbn;
    }
    @Override
    public String getZtytignmrtitnknyugukbn() {
        return pZtytignmrtitnknyugukbn;
    }
    @Override
    public void setZtytignmrtitnknyugukbn(String pZtytignmrtitnknyugukbn) {
        this.pZtytignmrtitnknyugukbn = pZtytignmrtitnknyugukbn;
    }
    @Override
    public String getZtyteigenmrtikgusdkbn() {
        return pZtyteigenmrtikgusdkbn;
    }
    @Override
    public void setZtyteigenmrtikgusdkbn(String pZtyteigenmrtikgusdkbn) {
        this.pZtyteigenmrtikgusdkbn = pZtyteigenmrtikgusdkbn;
    }
    @Override
    public String getZtyyobiv1x2() {
        return pZtyyobiv1x2;
    }
    @Override
    public void setZtyyobiv1x2(String pZtyyobiv1x2) {
        this.pZtyyobiv1x2 = pZtyyobiv1x2;
    }
    @Override
    public String getZtytktsppisetkykkbn() {
        return pZtytktsppisetkykkbn;
    }
    @Override
    public void setZtytktsppisetkykkbn(String pZtytktsppisetkykkbn) {
        this.pZtytktsppisetkykkbn = pZtytktsppisetkykkbn;
    }
    @Override
    public String getZtyjyudmnsiskknsetkykkbn() {
        return pZtyjyudmnsiskknsetkykkbn;
    }
    @Override
    public void setZtyjyudmnsiskknsetkykkbn(String pZtyjyudmnsiskknsetkykkbn) {
        this.pZtyjyudmnsiskknsetkykkbn = pZtyjyudmnsiskknsetkykkbn;
    }
    @Override
    public String getZtyyobiv8x2() {
        return pZtyyobiv8x2;
    }
    @Override
    public void setZtyyobiv8x2(String pZtyyobiv8x2) {
        this.pZtyyobiv8x2 = pZtyyobiv8x2;
    }
    @Override
    public String getZtysetaitesyono1() {
        return pZtysetaitesyono1;
    }
    @Override
    public void setZtysetaitesyono1(String pZtysetaitesyono1) {
        this.pZtysetaitesyono1 = pZtysetaitesyono1;
    }
    @Override
    public String getZtysetaitehokensyuruikigou1() {
        return pZtysetaitehokensyuruikigou1;
    }
    @Override
    public void setZtysetaitehokensyuruikigou1(String pZtysetaitehokensyuruikigou1) {
        this.pZtysetaitehokensyuruikigou1 = pZtysetaitehokensyuruikigou1;
    }
    @Override
    public String getZtysetaitemrtisyuruikgu1() {
        return pZtysetaitemrtisyuruikgu1;
    }
    @Override
    public void setZtysetaitemrtisyuruikgu1(String pZtysetaitemrtisyuruikgu1) {
        this.pZtysetaitemrtisyuruikgu1 = pZtysetaitemrtisyuruikgu1;
    }
    @Override
    public String getZtysetaitesiznmrtisyurui1() {
        return pZtysetaitesiznmrtisyurui1;
    }
    @Override
    public void setZtysetaitesiznmrtisyurui1(String pZtysetaitesiznmrtisyurui1) {
        this.pZtysetaitesiznmrtisyurui1 = pZtysetaitesiznmrtisyurui1;
    }
    @Override
    public String getZtysetaitetignmrtisyurui1() {
        return pZtysetaitetignmrtisyurui1;
    }
    @Override
    public void setZtysetaitetignmrtisyurui1(String pZtysetaitetignmrtisyurui1) {
        this.pZtysetaitetignmrtisyurui1 = pZtysetaitetignmrtisyurui1;
    }
    @Override
    public Long getZtysetaitekihonbubuns1() {
        return pZtysetaitekihonbubuns1;
    }
    @Override
    public void setZtysetaitekihonbubuns1(Long pZtysetaitekihonbubuns1) {
        this.pZtysetaitekihonbubuns1 = pZtysetaitekihonbubuns1;
    }
    @Override
    public Long getZtysetgukitnknitjbrkhns1() {
        return pZtysetgukitnknitjbrkhns1;
    }
    @Override
    public void setZtysetgukitnknitjbrkhns1(Long pZtysetgukitnknitjbrkhns1) {
        this.pZtysetgukitnknitjbrkhns1 = pZtysetgukitnknitjbrkhns1;
    }
    @Override
    public Long getZtysetaitesibous1() {
        return pZtysetaitesibous1;
    }
    @Override
    public void setZtysetaitesibous1(Long pZtysetaitesibous1) {
        this.pZtysetaitesibous1 = pZtysetaitesibous1;
    }
    @Override
    public Long getZtysetgukitnknitjbrsbus1() {
        return pZtysetgukitnknitjbrsbus1;
    }
    @Override
    public void setZtysetgukitnknitjbrsbus1(Long pZtysetgukitnknitjbrsbus1) {
        this.pZtysetgukitnknitjbrsbus1 = pZtysetgukitnknitjbrsbus1;
    }
    @Override
    public Long getZtysetaitesyuuseis1() {
        return pZtysetaitesyuuseis1;
    }
    @Override
    public void setZtysetaitesyuuseis1(Long pZtysetaitesyuuseis1) {
        this.pZtysetaitesyuuseis1 = pZtysetaitesyuuseis1;
    }
    @Override
    public Long getZtysetaiteharaikomip1() {
        return pZtysetaiteharaikomip1;
    }
    @Override
    public void setZtysetaiteharaikomip1(Long pZtysetaiteharaikomip1) {
        this.pZtysetaiteharaikomip1 = pZtysetaiteharaikomip1;
    }
    @Override
    public Long getZtysetaitesyukeiyakububunp1() {
        return pZtysetaitesyukeiyakububunp1;
    }
    @Override
    public void setZtysetaitesyukeiyakububunp1(Long pZtysetaitesyukeiyakububunp1) {
        this.pZtysetaitesyukeiyakububunp1 = pZtysetaitesyukeiyakububunp1;
    }
    @Override
    public Long getZtysetaitgukikzkmrtis1() {
        return pZtysetaitgukikzkmrtis1;
    }
    @Override
    public void setZtysetaitgukikzkmrtis1(Long pZtysetaitgukikzkmrtis1) {
        this.pZtysetaitgukikzkmrtis1 = pZtysetaitgukikzkmrtis1;
    }
    @Override
    public String getZtysetaitetenkankykhyj1() {
        return pZtysetaitetenkankykhyj1;
    }
    @Override
    public void setZtysetaitetenkankykhyj1(String pZtysetaitetenkankykhyj1) {
        this.pZtysetaitetenkankykhyj1 = pZtysetaitetenkankykhyj1;
    }
    @Override
    public Long getZtysetaitesiteimhrkp1() {
        return pZtysetaitesiteimhrkp1;
    }
    @Override
    public void setZtysetaitesiteimhrkp1(Long pZtysetaitesiteimhrkp1) {
        this.pZtysetaitesiteimhrkp1 = pZtysetaitesiteimhrkp1;
    }
    @Override
    public Long getZtysetaitesiteimsykykp1() {
        return pZtysetaitesiteimsykykp1;
    }
    @Override
    public void setZtysetaitesiteimsykykp1(Long pZtysetaitesiteimsykykp1) {
        this.pZtysetaitesiteimsykykp1 = pZtysetaitesiteimsykykp1;
    }
    @Override
    public String getZtysetaitenkmrtisyurui1() {
        return pZtysetaitenkmrtisyurui1;
    }
    @Override
    public void setZtysetaitenkmrtisyurui1(String pZtysetaitenkmrtisyurui1) {
        this.pZtysetaitenkmrtisyurui1 = pZtysetaitenkmrtisyurui1;
    }
    @Override
    public String getZtyyobiv18() {
        return pZtyyobiv18;
    }
    @Override
    public void setZtyyobiv18(String pZtyyobiv18) {
        this.pZtyyobiv18 = pZtyyobiv18;
    }
    @Override
    public String getZtykzktourokuservicearihyj() {
        return pZtykzktourokuservicearihyj;
    }
    @Override
    public void setZtykzktourokuservicearihyj(String pZtykzktourokuservicearihyj) {
        this.pZtykzktourokuservicearihyj = pZtykzktourokuservicearihyj;
    }
    @Override
    public String getZtyyobiv4x12() {
        return pZtyyobiv4x12;
    }
    @Override
    public void setZtyyobiv4x12(String pZtyyobiv4x12) {
        this.pZtyyobiv4x12 = pZtyyobiv4x12;
    }
    @Override
    public String getZtyvitdoujimos2kenmeikouhyj() {
        return pZtyvitdoujimos2kenmeikouhyj;
    }
    @Override
    public void setZtyvitdoujimos2kenmeikouhyj(String pZtyvitdoujimos2kenmeikouhyj) {
        this.pZtyvitdoujimos2kenmeikouhyj = pZtyvitdoujimos2kenmeikouhyj;
    }
    @Override
    public String getZtykikykvitarituikamoshyj() {
        return pZtykikykvitarituikamoshyj;
    }
    @Override
    public void setZtykikykvitarituikamoshyj(String pZtykikykvitarituikamoshyj) {
        this.pZtykikykvitarituikamoshyj = pZtykikykvitarituikamoshyj;
    }
    @Override
    public String getZtyhtnknkykvithokenkbn() {
        return pZtyhtnknkykvithokenkbn;
    }
    @Override
    public void setZtyhtnknkykvithokenkbn(String pZtyhtnknkykvithokenkbn) {
        this.pZtyhtnknkykvithokenkbn = pZtyhtnknkykvithokenkbn;
    }
    @Override
    public String getZtykikykvithokenhoyuujkkbn() {
        return pZtykikykvithokenhoyuujkkbn;
    }
    @Override
    public void setZtykikykvithokenhoyuujkkbn(String pZtykikykvithokenhoyuujkkbn) {
        this.pZtykikykvithokenhoyuujkkbn = pZtykikykvithokenhoyuujkkbn;
    }
    @Override
    public String getZtyyobiv2x2() {
        return pZtyyobiv2x2;
    }
    @Override
    public void setZtyyobiv2x2(String pZtyyobiv2x2) {
        this.pZtyyobiv2x2 = pZtyyobiv2x2;
    }
}

