package yuyu.def.db.meta;

import jp.co.slcs.swak.db.typesafe.ExDBFieldNumber;
import jp.co.slcs.swak.db.typesafe.ExDBFieldString;
import jp.co.slcs.swak.number.BizNumber;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr5Ty;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;

/**
 * 新契約決算ベース月次成立Ｆテーブル５（中） のエンティティメタデータ定義Beanです。<br/>
 * このソースはツールによる自動生成です。テーブル定義に変更があるとツールにより上書きされます。
 */
public abstract class GenQZT_Skeiksnbsgetujisr5Ty extends AbstractExDBTable<ZT_Skeiksnbsgetujisr5Ty> {

    public GenQZT_Skeiksnbsgetujisr5Ty() {
        this("ZT_Skeiksnbsgetujisr5Ty");
    }

    public GenQZT_Skeiksnbsgetujisr5Ty(String pAlias) {
        super("ZT_Skeiksnbsgetujisr5Ty", ZT_Skeiksnbsgetujisr5Ty.class, pAlias);
    }

    public String ZT_Skeiksnbsgetujisr5Ty() {
        return getAliasExpression();
    }

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyktgysyrymd = new ExDBFieldString<>("ztyktgysyrymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyktgysyono = new ExDBFieldString<>("ztyktgysyono", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyktgyfilerenno = new ExDBFieldString<>("ztyktgyfilerenno", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyaatukaisyabosyuudirtncd = new ExDBFieldString<>("ztyaatukaisyabosyuudirtncd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztybatukaisyabosyuudirtncd = new ExDBFieldString<>("ztybatukaisyabosyuudirtncd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztybosyuukeitaikbn = new ExDBFieldString<>("ztybosyuukeitaikbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztykessankeijyouym = new ExDBFieldString<>("ztykessankeijyouym", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnkntmttsyusnhknarihyj = new ExDBFieldString<>("ztyhtnkntmttsyusnhknarihyj", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztytokubetuhosyoukikan = new ExDBFieldString<>("ztytokubetuhosyoukikan", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeinenbaraikansanp3x1 = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp3x1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhktgtikkikkkn3x1 = new ExDBFieldString<>("ztyhktgtikkikkkn3x1", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztykappadhktgkujygkx1 = new ExDBFieldNumber<>("ztykappadhktgkujygkx1", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeinenbaraikansanp3x2 = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp3x2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhktgtikkikkkn3x2 = new ExDBFieldString<>("ztyhktgtikkikkkn3x2", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztykappadhktgkujygkx2 = new ExDBFieldNumber<>("ztykappadhktgkujygkx2", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeinenbaraikansanp3x3 = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp3x3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhktgtikkikkkn3x3 = new ExDBFieldString<>("ztyhktgtikkikkkn3x3", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztykappadhktgkujygkx3 = new ExDBFieldNumber<>("ztykappadhktgkujygkx3", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeinenbaraikansanp3x4 = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp3x4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhktgtikkikkkn3x4 = new ExDBFieldString<>("ztyhktgtikkikkkn3x4", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztykappadhktgkujygkx4 = new ExDBFieldNumber<>("ztykappadhktgkujygkx4", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeinenbaraikansanp3x5 = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp3x5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhktgtikkikkkn3x5 = new ExDBFieldString<>("ztyhktgtikkikkkn3x5", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztykappadhktgkujygkx5 = new ExDBFieldNumber<>("ztykappadhktgkujygkx5", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeinenbaraikansanp3x6 = new ExDBFieldNumber<>("ztygoukeinenbaraikansanp3x6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhktgtikkikkkn3x6 = new ExDBFieldString<>("ztyhktgtikkikkkn3x6", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztykappadhktgkujygkx6 = new ExDBFieldNumber<>("ztykappadhktgkujygkx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhutihnnnkknnzmkyksyono = new ExDBFieldString<>("ztyhutihnnnkknnzmkyksyono", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztymusymd = new ExDBFieldString<>("ztymusymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztymosnyuuryokuymd = new ExDBFieldString<>("ztymosnyuuryokuymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztymossyosakuseiymd = new ExDBFieldString<>("ztymossyosakuseiymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztykokutiymd = new ExDBFieldString<>("ztykokutiymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2kokutiymd = new ExDBFieldString<>("ztydai2kokutiymd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyjyuuryousyouryakukbn = new ExDBFieldString<>("ztyjyuuryousyouryakukbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkyksyuruikgu = new ExDBFieldString<>("ztysnsniryutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysensiniryoutokuyakukikan = new ExDBFieldString<>("ztysensiniryoutokuyakukikan", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysensiniryoutkykphrkkkn = new ExDBFieldString<>("ztysensiniryoutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysensiniryoutokuyakus = new ExDBFieldNumber<>("ztysensiniryoutokuyakus", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysensiniryoutokuyakup = new ExDBFieldNumber<>("ztysensiniryoutokuyakup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysensiniryoutkykkgusdkbn = new ExDBFieldString<>("ztysensiniryoutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykkguybx1 = new ExDBFieldString<>("ztysnsniryutkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykkguybx2 = new ExDBFieldString<>("ztysnsniryutkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykkguybx3 = new ExDBFieldString<>("ztysnsniryutkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykkguybx4 = new ExDBFieldString<>("ztysnsniryutkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykkguybx5 = new ExDBFieldString<>("ztysnsniryutkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykpwrbkkbn = new ExDBFieldString<>("ztysnsniryutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutktbicdx1 = new ExDBFieldString<>("ztysnsniryutktbicdx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryuhtnpkknx1 = new ExDBFieldString<>("ztysnsniryuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutktbicdx2 = new ExDBFieldString<>("ztysnsniryutktbicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryuhtnpkknx2 = new ExDBFieldString<>("ztysnsniryuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysnsniryutkykkusnmnryoage = new ExDBFieldString<>("ztysnsniryutkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv4x17 = new ExDBFieldString<>("ztyyobiv4x17", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkyksyrikgu = new ExDBFieldString<>("ztydi2snsniryutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkkn = new ExDBFieldString<>("ztydi2snsniryutkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2snsniryutkykphrkkkn = new ExDBFieldString<>("ztydai2snsniryutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydai2sensiniryoutokuyakus = new ExDBFieldNumber<>("ztydai2sensiniryoutokuyakus", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydai2sensiniryoutokuyakup = new ExDBFieldNumber<>("ztydai2sensiniryoutokuyakup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkgusdkbn = new ExDBFieldString<>("ztydi2snsniryutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkguybx1 = new ExDBFieldString<>("ztydi2snsniryutkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkguybx2 = new ExDBFieldString<>("ztydi2snsniryutkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkguybx3 = new ExDBFieldString<>("ztydi2snsniryutkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkguybx4 = new ExDBFieldString<>("ztydi2snsniryutkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykkguybx5 = new ExDBFieldString<>("ztydi2snsniryutkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutkykpwrbkkbn = new ExDBFieldString<>("ztydi2snsniryutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutktbicdx1 = new ExDBFieldString<>("ztydi2snsniryutktbicdx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryuhtnpkknx1 = new ExDBFieldString<>("ztydi2snsniryuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryutktbicdx2 = new ExDBFieldString<>("ztydi2snsniryutktbicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2snsniryuhtnpkknx2 = new ExDBFieldString<>("ztydi2snsniryuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv6x3 = new ExDBFieldString<>("ztyyobiv6x3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhhknnentysihyj = new ExDBFieldString<>("ztyhhknnentysihyj", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztykyksyaagetyouseihyj = new ExDBFieldString<>("ztykyksyaagetyouseihyj", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2hhknnentysihyj = new ExDBFieldString<>("ztydai2hhknnentysihyj", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyhsyumnosjdftmttzndk = new ExDBFieldNumber<>("ztyhsyumnosjdftmttzndk", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyjttkyksyrikgu = new ExDBFieldString<>("ztynyuinhsyujyjttkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyujttkykkkn = new ExDBFieldString<>("ztynyuinhsyujyujttkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyinhsyjyjttkykphrkkkn = new ExDBFieldString<>("ztynyinhsyjyjttkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztynyuinhsyujyujttkyks = new ExDBFieldNumber<>("ztynyuinhsyujyujttkyks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztynyuinhsyujyujttkykp = new ExDBFieldNumber<>("ztynyuinhsyujyujttkykp", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztynyinhsyjyjttkjyrymshytn = new ExDBFieldNumber<>("ztynyinhsyjyjttkjyrymshytn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztynyuinhsyujyujttkyktkjyup = new ExDBFieldNumber<>("ztynyuinhsyujyujttkyktkjyup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyujttktbicdx1 = new ExDBFieldString<>("ztynyuinhsyujyujttktbicdx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyujthtnpkknx1 = new ExDBFieldString<>("ztynyuinhsyujyujthtnpkknx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyujttktbicdx2 = new ExDBFieldString<>("ztynyuinhsyujyujttktbicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyujthtnpkknx2 = new ExDBFieldString<>("ztynyuinhsyujyujthtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyinhsyjyjttkykkgusdkbn = new ExDBFieldString<>("ztynyinhsyjyjttkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyinhsyjyjttkykpwrbkkbn = new ExDBFieldString<>("ztynyinhsyjyjttkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyjttkykkguybx1 = new ExDBFieldString<>("ztynyuinhsyujyjttkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyjttkykkguybx2 = new ExDBFieldString<>("ztynyuinhsyujyjttkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyjttkykkguybx3 = new ExDBFieldString<>("ztynyuinhsyujyjttkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyjttkykkguybx4 = new ExDBFieldString<>("ztynyuinhsyujyjttkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyuinhsyujyjttkykkguybx5 = new ExDBFieldString<>("ztynyuinhsyujyjttkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztynyinhsyjyjtkykksnmnryage = new ExDBFieldString<>("ztynyinhsyjyjtkykksnmnryage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv5x4 = new ExDBFieldString<>("ztyyobiv5x4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyjyjttkyksyrikg = new ExDBFieldString<>("ztydi2nyinhsyjyjttkyksyrikg", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyujyujttkykkkn = new ExDBFieldString<>("ztydi2nyuinhsyujyujttkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyujyjtphrkkkn = new ExDBFieldString<>("ztydi2nyuinhsyujyjtphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydi2nyuinhsyujyujttkyks = new ExDBFieldNumber<>("ztydi2nyuinhsyujyujttkyks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydi2nyuinhsyujyujttkykp = new ExDBFieldNumber<>("ztydi2nyuinhsyujyujttkykp", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztydi2nyhsyjyjttkjyrymshytn = new ExDBFieldNumber<>("ztydi2nyhsyjyjttkjyrymshytn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydi2nyuinhsyujyujttkjyup = new ExDBFieldNumber<>("ztydi2nyuinhsyujyujttkjyup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyutktbicdx1 = new ExDBFieldString<>("ztydi2nyuinhsyutktbicdx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyuhtnpkknx1 = new ExDBFieldString<>("ztydi2nyuinhsyuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyutktbicdx2 = new ExDBFieldString<>("ztydi2nyuinhsyutktbicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyuhtnpkknx2 = new ExDBFieldString<>("ztydi2nyuinhsyuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyujyjtkgusdkbn = new ExDBFieldString<>("ztydi2nyinhsyujyjtkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyuinhsyujyjtpwrbkkbn = new ExDBFieldString<>("ztydi2nyuinhsyujyjtpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyjyjttkykkgybx1 = new ExDBFieldString<>("ztydi2nyinhsyjyjttkykkgybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyjyjttkykkgybx2 = new ExDBFieldString<>("ztydi2nyinhsyjyjttkykkgybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyjyjttkykkgybx3 = new ExDBFieldString<>("ztydi2nyinhsyjyjttkykkgybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyjyjttkykkgybx4 = new ExDBFieldString<>("ztydi2nyinhsyjyjttkykkgybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2nyinhsyjyjttkykkgybx5 = new ExDBFieldString<>("ztydi2nyinhsyjyjttkykkgybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv7x6 = new ExDBFieldString<>("ztyyobiv7x6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv1x4 = new ExDBFieldString<>("ztyyobiv1x4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztywnasitnknkakakujyutukbn = new ExDBFieldString<>("ztywnasitnknkakakujyutukbn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygoukeiwnasitenkankakaku = new ExDBFieldNumber<>("ztygoukeiwnasitenkankakaku", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygukiwnstnknitjbrnknengk = new ExDBFieldNumber<>("ztygukiwnstnknitjbrnknengk", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygukiwnasitnknitjbrtiks = new ExDBFieldNumber<>("ztygukiwnasitnknitjbrtiks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyyobin11x2 = new ExDBFieldNumber<>("ztyyobin11x2", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyyobin11x3 = new ExDBFieldNumber<>("ztyyobin11x3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv9x11 = new ExDBFieldString<>("ztyyobiv9x11", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkyksyuruikgu = new ExDBFieldString<>("ztysuguiryutkyksyuruikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysougouiryoutokuyakukikan = new ExDBFieldString<>("ztysougouiryoutokuyakukikan", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykphrkkkn = new ExDBFieldString<>("ztysuguiryutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztysuguiryutkykntgk = new ExDBFieldNumber<>("ztysuguiryutkykntgk", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysougouiryoutokuyakup = new ExDBFieldNumber<>("ztysougouiryoutokuyakup", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztysuguiryutkjyuryumshyutn = new ExDBFieldNumber<>("ztysuguiryutkjyuryumshyutn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysougouiryoutokujyoup = new ExDBFieldNumber<>("ztysougouiryoutokujyoup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutktbicdx1 = new ExDBFieldString<>("ztysuguiryutktbicdx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryuhtnpkknx1 = new ExDBFieldString<>("ztysuguiryuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutktbicdx2 = new ExDBFieldString<>("ztysuguiryutktbicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryuhtnpkknx2 = new ExDBFieldString<>("ztysuguiryuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkgusdkbn = new ExDBFieldString<>("ztysuguiryutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykpwrbkkbn = new ExDBFieldString<>("ztysuguiryutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkguybx1 = new ExDBFieldString<>("ztysuguiryutkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkguybx2 = new ExDBFieldString<>("ztysuguiryutkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkguybx3 = new ExDBFieldString<>("ztysuguiryutkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkguybx4 = new ExDBFieldString<>("ztysuguiryutkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkguybx5 = new ExDBFieldString<>("ztysuguiryutkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysuguiryutkykkusnmnryoage = new ExDBFieldString<>("ztysuguiryutkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv7x7 = new ExDBFieldString<>("ztyyobiv7x7", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkyksyrikgu = new ExDBFieldString<>("ztydi2suguiryutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkkn = new ExDBFieldString<>("ztydi2suguiryutkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykphrkkkn = new ExDBFieldString<>("ztydi2suguiryutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztydi2suguiryutkykntgk = new ExDBFieldNumber<>("ztydi2suguiryutkykntgk", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydai2sougouiryoutokuyakup = new ExDBFieldNumber<>("ztydai2sougouiryoutokuyakup", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztydi2suguiryutkjyurymshytn = new ExDBFieldNumber<>("ztydi2suguiryutkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydai2sougouiryoutokujyoup = new ExDBFieldNumber<>("ztydai2sougouiryoutokujyoup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutktbicdx1 = new ExDBFieldString<>("ztydi2suguiryutktbicdx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryuhtnpkknx1 = new ExDBFieldString<>("ztydi2suguiryuhtnpkknx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutktbicdx2 = new ExDBFieldString<>("ztydi2suguiryutktbicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryuhtnpkknx2 = new ExDBFieldString<>("ztydi2suguiryuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkgusdkbn = new ExDBFieldString<>("ztydi2suguiryutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykpwrbkkbn = new ExDBFieldString<>("ztydi2suguiryutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkguybx1 = new ExDBFieldString<>("ztydi2suguiryutkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkguybx2 = new ExDBFieldString<>("ztydi2suguiryutkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkguybx3 = new ExDBFieldString<>("ztydi2suguiryutkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkguybx4 = new ExDBFieldString<>("ztydi2suguiryutkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2suguiryutkykkguybx5 = new ExDBFieldString<>("ztydi2suguiryutkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv9x12 = new ExDBFieldString<>("ztyyobiv9x12", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2gannyuintkyksyrikgu = new ExDBFieldString<>("ztydai2gannyuintkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2gannyuintkykkkn = new ExDBFieldString<>("ztydai2gannyuintkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2gannyuintkykphrkkkn = new ExDBFieldString<>("ztydai2gannyuintkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztydai2gannyuintkykntgk = new ExDBFieldNumber<>("ztydai2gannyuintkykntgk", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztydai2gannyuuintokuyakup = new ExDBFieldNumber<>("ztydai2gannyuuintokuyakup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2gannyuintkykkgusdkbn = new ExDBFieldString<>("ztydai2gannyuintkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2gannyuintkykkguyobix1 = new ExDBFieldString<>("ztydi2gannyuintkykkguyobix1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2gannyuintkykkguyobix2 = new ExDBFieldString<>("ztydi2gannyuintkykkguyobix2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2gannyuintkykkguyobix3 = new ExDBFieldString<>("ztydi2gannyuintkykkguyobix3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2gannyuintkykkguyobix4 = new ExDBFieldString<>("ztydi2gannyuintkykkguyobix4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydi2gannyuintkykkguyobix5 = new ExDBFieldString<>("ztydi2gannyuintkykkguyobix5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztydai2gannyuintkykpwrbkkbn = new ExDBFieldString<>("ztydai2gannyuintkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv6x4 = new ExDBFieldString<>("ztyyobiv6x4", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztygukihtnknsuguirytkykntgk = new ExDBFieldNumber<>("ztygukihtnknsuguirytkykntgk", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuusyrikgu = new ExDBFieldString<>("ztyhijynbrimarusyuusyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimrsyukgusdkbn = new ExDBFieldString<>("ztyhijynbrimrsyukgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuukguybx1 = new ExDBFieldString<>("ztyhijynbrimarusyuukguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuukguybx2 = new ExDBFieldString<>("ztyhijynbrimarusyuukguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuukguybx3 = new ExDBFieldString<>("ztyhijynbrimarusyuukguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuukguybx4 = new ExDBFieldString<>("ztyhijynbrimarusyuukguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuukguybx5 = new ExDBFieldString<>("ztyhijynbrimarusyuukguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuukkn = new ExDBFieldString<>("ztyhijynbrimarusyuukkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimrsyphrkkkn = new ExDBFieldString<>("ztyhijynbrimrsyphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyhijynbrimarusyuutkyks = new ExDBFieldNumber<>("ztyhijynbrimarusyuutkyks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyhijynbrimarusyuutkykp = new ExDBFieldNumber<>("ztyhijynbrimarusyuutkykp", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimrsypwrbkkbn = new ExDBFieldString<>("ztyhijynbrimrsypwrbkkbn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyhijynbrimarusyuumods = new ExDBFieldNumber<>("ztyhijynbrimarusyuumods", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimarusyuutkjyukbn = new ExDBFieldString<>("ztyhijynbrimarusyuutkjyukbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrimrsytkjyuskgnkkn = new ExDBFieldString<>("ztyhijynbrimrsytkjyuskgnkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztyhijynbrmrsytkjyurymshytn = new ExDBFieldNumber<>("ztyhijynbrmrsytkjyurymshytn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyhijynbrimarusyuutkjyup = new ExDBFieldNumber<>("ztyhijynbrimarusyuutkjyup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhijynbrmrsytnknygryrtkbn = new ExDBFieldString<>("ztyhijynbrmrsytnknygryrtkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv4x18 = new ExDBFieldString<>("ztyyobiv4x18", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztytokuteijyoutaihushrhyj = new ExDBFieldString<>("ztytokuteijyoutaihushrhyj", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztymosjikaigos = new ExDBFieldNumber<>("ztymosjikaigos", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztymosjidi2hknkknsyuusns = new ExDBFieldNumber<>("ztymosjidi2hknkknsyuusns", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkyksyrikgu = new ExDBFieldString<>("ztygansndntkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykkgusdkbn = new ExDBFieldString<>("ztygansndntkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykkguybx1 = new ExDBFieldString<>("ztygansndntkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykkguybx2 = new ExDBFieldString<>("ztygansndntkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykkguybx3 = new ExDBFieldString<>("ztygansndntkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykkguybx4 = new ExDBFieldString<>("ztygansndntkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykkguybx5 = new ExDBFieldString<>("ztygansndntkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansindantokuyakukikan = new ExDBFieldString<>("ztygansindantokuyakukikan", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykphrkkkn = new ExDBFieldString<>("ztygansndntkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygansindantokuyakus = new ExDBFieldNumber<>("ztygansindantokuyakus", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygansindantokuyakup = new ExDBFieldNumber<>("ztygansindantokuyakup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygansndntkykpwrbkkbn = new ExDBFieldString<>("ztygansndntkykpwrbkkbn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygansndntkyktaikknbbns = new ExDBFieldNumber<>("ztygansndntkyktaikknbbns", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyjyouhinaiganmtkknbbns = new ExDBFieldNumber<>("ztyjyouhinaiganmtkknbbns", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygnsndntkykkusnmnryoage = new ExDBFieldString<>("ztygnsndntkykkusnmnryoage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv10x5 = new ExDBFieldString<>("ztyyobiv10x5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkyksyrikgu = new ExDBFieldString<>("ztyganykbttryutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkgusdkbn = new ExDBFieldString<>("ztyganykbttryutkykkgusdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkguybx1 = new ExDBFieldString<>("ztyganykbttryutkykkguybx1", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkguybx2 = new ExDBFieldString<>("ztyganykbttryutkykkguybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkguybx3 = new ExDBFieldString<>("ztyganykbttryutkykkguybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkguybx4 = new ExDBFieldString<>("ztyganykbttryutkykkguybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkguybx5 = new ExDBFieldString<>("ztyganykbttryutkykkguybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykkkn = new ExDBFieldString<>("ztyganykbttryutkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykphrkkkn = new ExDBFieldString<>("ztyganykbttryutkykphrkkkn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyganykbttryutkyks = new ExDBFieldNumber<>("ztyganykbttryutkyks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyganykbttryutkykp = new ExDBFieldNumber<>("ztyganykbttryutkykp", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyganykbttryutkykpwrbkkbn = new ExDBFieldString<>("ztyganykbttryutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztygnykbttryutkykksnmnryage = new ExDBFieldString<>("ztygnykbttryutkykksnmnryage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv12x11 = new ExDBFieldString<>("ztyyobiv12x11", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygukihtnkngansndntkyks = new ExDBFieldNumber<>("ztygukihtnkngansndntkyks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztygukihtnknganykbttrytkyks = new ExDBFieldNumber<>("ztygukihtnknganykbttrytkyks", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, BizNumber> ztysinkeiyakujiyoteiriritu = new ExDBFieldString<>("ztysinkeiyakujiyoteiriritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztykousinmanryouage = new ExDBFieldString<>("ztykousinmanryouage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyseizonmrtikusnmnryoage = new ExDBFieldString<>("ztyseizonmrtikusnmnryoage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyteigenmrtikusnmnryoage = new ExDBFieldString<>("ztyteigenmrtikusnmnryoage", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtisyri = new ExDBFieldString<>("ztysiktsyunyumrtisyri", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtikgusdikbn = new ExDBFieldString<>("ztysiktsyunyumrtikgusdikbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtikguyobi = new ExDBFieldString<>("ztysiktsyunyumrtikguyobi", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtikguyobix2 = new ExDBFieldString<>("ztysiktsyunyumrtikguyobix2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtikguyobix3 = new ExDBFieldString<>("ztysiktsyunyumrtikguyobix3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtikguyobix4 = new ExDBFieldString<>("ztysiktsyunyumrtikguyobix4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtikguyobix5 = new ExDBFieldString<>("ztysiktsyunyumrtikguyobix5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtiktkbn = new ExDBFieldString<>("ztysiktsyunyumrtiktkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtisyugiktkbn = new ExDBFieldString<>("ztysiktsyunyumrtisyugiktkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyseikatusyuunyuumrtikkn = new ExDBFieldString<>("ztyseikatusyuunyuumrtikkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtiphrikmkbn = new ExDBFieldString<>("ztysiktsyunyumrtiphrikmkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtishrikkn = new ExDBFieldString<>("ztysiktsyunyumrtishrikkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsynyumrtitnknwrbkkbn = new ExDBFieldString<>("ztysiktsynyumrtitnknwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysrsiktsyunyumrtipwrbkkbn = new ExDBFieldString<>("ztysrsiktsyunyumrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtipwrbkkbn = new ExDBFieldString<>("ztysiktsyunyumrtipwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtiksnmnryunn = new ExDBFieldString<>("ztysiktsyunyumrtiksnmnryunn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyunyumrtinnknnngk = new ExDBFieldNumber<>("ztysiktsyunyumrtinnknnngk", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyseikatusyuunyuumrtis = new ExDBFieldNumber<>("ztyseikatusyuunyuumrtis", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyunyumrtiitjknks = new ExDBFieldNumber<>("ztysiktsyunyumrtiitjknks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztyseikatusyuunyuumrtip = new ExDBFieldNumber<>("ztyseikatusyuunyuumrtip", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyunyumrtisyuuseis = new ExDBFieldNumber<>("ztysiktsyunyumrtisyuuseis", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyunyumrtitkjyukbn = new ExDBFieldString<>("ztysiktsyunyumrtitkjyukbn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztysiktsynymrtitkjyrymshytn = new ExDBFieldNumber<>("ztysiktsynymrtitkjyrymshytn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyunyumrtitkjyup = new ExDBFieldNumber<>("ztysiktsyunyumrtitkjyup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv17 = new ExDBFieldString<>("ztyyobiv17", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkyksyrikgu = new ExDBFieldString<>("ztysiktsyuknbyutkyksyrikgu", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkgsdikbn = new ExDBFieldString<>("ztysiktsyuknbyutkykkgsdikbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkguybi = new ExDBFieldString<>("ztysiktsyuknbyutkykkguybi", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkguybix2 = new ExDBFieldString<>("ztysiktsyuknbyutkykkguybix2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkguybix3 = new ExDBFieldString<>("ztysiktsyuknbyutkykkguybix3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkguybix4 = new ExDBFieldString<>("ztysiktsyuknbyutkykkguybix4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkguybix5 = new ExDBFieldString<>("ztysiktsyuknbyutkykkguybix5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykkkn = new ExDBFieldString<>("ztysiktsyuknbyutkykkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykphrkmkkn = new ExDBFieldString<>("ztysiktsyuknbyutkykphrkmkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyknbytyktnknwrbkkbn = new ExDBFieldString<>("ztysiktsyknbytyktnknwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysrsiktsyuknbyutkpwrbkkbn = new ExDBFieldString<>("ztysrsiktsyuknbyutkpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkykpwrbkkbn = new ExDBFieldString<>("ztysiktsyuknbyutkykpwrbkkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyknbytkykkusnmnrynn = new ExDBFieldString<>("ztysiktsyknbytkykkusnmnrynn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyuknbyutkyks = new ExDBFieldNumber<>("ztysiktsyuknbyutkyks", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyuknbyutkykp = new ExDBFieldNumber<>("ztysiktsyuknbyutkykp", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyuknbyutkyktikknars = new ExDBFieldNumber<>("ztysiktsyuknbyutkyktikknars", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyuknbyutkyksyusis = new ExDBFieldNumber<>("ztysiktsyuknbyutkyksyusis", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutkjyukbn = new ExDBFieldString<>("ztysiktsyuknbyutkjyukbn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Integer> ztysiktsyuknbyutkjyrymshytn = new ExDBFieldNumber<>("ztysiktsyuknbyutkjyrymshytn", this);

    public final ExDBFieldNumber<ZT_Skeiksnbsgetujisr5Ty, Long> ztysiktsyuknbyutkjyup = new ExDBFieldNumber<>("ztysiktsyuknbyutkjyup", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutktibicd = new ExDBFieldString<>("ztysiktsyuknbyutktibicd", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyuhtnpkkn = new ExDBFieldString<>("ztysiktsyuknbyuhtnpkkn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyutktibicdx2 = new ExDBFieldString<>("ztysiktsyuknbyutktibicdx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztysiktsyuknbyuhtnpkknx2 = new ExDBFieldString<>("ztysiktsyuknbyuhtnpkknx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv19 = new ExDBFieldString<>("ztyyobiv19", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtisyrkg = new ExDBFieldString<>("ztyhtnknsiktsynymrtisyrkg", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynykgusdikbn = new ExDBFieldString<>("ztyhtnknsiktsynykgusdikbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgyb = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgyb", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx2 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx3 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx4 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx5 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytksyrkg = new ExDBFieldString<>("ztyhtnknsiktsyknbytksyrkg", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbykgsdkbn = new ExDBFieldString<>("ztyhtnknsiktsyknbykgsdkbn", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgyb = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgyb", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx2 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx3 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx4 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx5 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv24 = new ExDBFieldString<>("ztyyobiv24", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtisyrkgx2 = new ExDBFieldString<>("ztyhtnknsiktsynymrtisyrkgx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynykgusdikbnx2 = new ExDBFieldString<>("ztyhtnknsiktsynykgusdikbnx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx6 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx7 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx7", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx8 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx8", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx9 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx9", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx10 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx10", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytksyrkgx2 = new ExDBFieldString<>("ztyhtnknsiktsyknbytksyrkgx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbykgsdkbnx2 = new ExDBFieldString<>("ztyhtnknsiktsyknbykgsdkbnx2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx6 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx7 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx7", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx8 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx8", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx9 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx9", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx10 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx10", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv24x2 = new ExDBFieldString<>("ztyyobiv24x2", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtisyrkgx3 = new ExDBFieldString<>("ztyhtnknsiktsynymrtisyrkgx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynykgusdikbnx3 = new ExDBFieldString<>("ztyhtnknsiktsynykgusdikbnx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx11 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx11", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx12 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx12", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx13 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx13", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx14 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx14", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx15 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx15", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytksyrkgx3 = new ExDBFieldString<>("ztyhtnknsiktsyknbytksyrkgx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbykgsdkbnx3 = new ExDBFieldString<>("ztyhtnknsiktsyknbykgsdkbnx3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx11 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx11", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx12 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx12", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx13 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx13", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx14 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx14", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx15 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx15", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv24x3 = new ExDBFieldString<>("ztyyobiv24x3", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtisyrkgx4 = new ExDBFieldString<>("ztyhtnknsiktsynymrtisyrkgx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynykgusdikbnx4 = new ExDBFieldString<>("ztyhtnknsiktsynykgusdikbnx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx16 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx16", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx17 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx17", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx18 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx18", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx19 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx19", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx20 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx20", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytksyrkgx4 = new ExDBFieldString<>("ztyhtnknsiktsyknbytksyrkgx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbykgsdkbnx4 = new ExDBFieldString<>("ztyhtnknsiktsyknbykgsdkbnx4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx16 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx16", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx17 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx17", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx18 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx18", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx19 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx19", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx20 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx20", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv24x4 = new ExDBFieldString<>("ztyyobiv24x4", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtisyrkgx5 = new ExDBFieldString<>("ztyhtnknsiktsynymrtisyrkgx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynykgusdikbnx5 = new ExDBFieldString<>("ztyhtnknsiktsynykgusdikbnx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx21 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx21", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx22 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx22", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx23 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx23", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx24 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx24", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx25 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx25", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytksyrkgx5 = new ExDBFieldString<>("ztyhtnknsiktsyknbytksyrkgx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbykgsdkbnx5 = new ExDBFieldString<>("ztyhtnknsiktsyknbykgsdkbnx5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx21 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx21", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx22 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx22", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx23 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx23", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx24 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx24", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx25 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx25", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv24x5 = new ExDBFieldString<>("ztyyobiv24x5", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtisyrkgx6 = new ExDBFieldString<>("ztyhtnknsiktsynymrtisyrkgx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynykgusdikbnx6 = new ExDBFieldString<>("ztyhtnknsiktsynykgusdikbnx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx26 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx26", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx27 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx27", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx28 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx28", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx29 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx29", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsynymrtikgybx30 = new ExDBFieldString<>("ztyhtnknsiktsynymrtikgybx30", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytksyrkgx6 = new ExDBFieldString<>("ztyhtnknsiktsyknbytksyrkgx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbykgsdkbnx6 = new ExDBFieldString<>("ztyhtnknsiktsyknbykgsdkbnx6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx26 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx26", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx27 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx27", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx28 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx28", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx29 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx29", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyhtnknsiktsyknbytkkgybx30 = new ExDBFieldString<>("ztyhtnknsiktsyknbytkkgybx30", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv24x6 = new ExDBFieldString<>("ztyyobiv24x6", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, BizNumber> ztykaiyakuhrmkhritu = new ExDBFieldString<>("ztykaiyakuhrmkhritu", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, BizNumber> ztytumitatekinitenmkhyurt = new ExDBFieldString<>("ztytumitatekinitenmkhyurt", this, BizNumberType.class);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv250 = new ExDBFieldString<>("ztyyobiv250", this);

    public final ExDBFieldString<ZT_Skeiksnbsgetujisr5Ty, String> ztyyobiv248 = new ExDBFieldString<>("ztyyobiv248", this);
}
