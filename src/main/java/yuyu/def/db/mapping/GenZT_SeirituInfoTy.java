package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_SeirituInfoTy;
import yuyu.def.db.id.PKZT_SeirituInfoTy;
import yuyu.def.db.meta.GenQZT_SeirituInfoTy;
import yuyu.def.db.meta.QZT_SeirituInfoTy;

/**
 * 成立情報Ｆテーブル（中） テーブルのマッピング情報クラスで、 {@link ZT_SeirituInfoTy} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_SeirituInfoTy}</td><td colspan="3">成立情報Ｆテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtykijyunym ztykijyunym}</td><td>（中継用）基準年月</td><td align="center">{@link PKZT_SeirituInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyseisekiym ztyseisekiym}</td><td>（中継用）成績計上年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyono ztysyono}</td><td>（中継用）証券番号</td><td align="center">{@link PKZT_SeirituInfoTy ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhanbainm ztyhanbainm}</td><td>（中継用）販売名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyatkisisya ztyatkisisya}</td><td>（中継用）扱支社</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknkkn ztyhknkkn}</td><td>（中継用）保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyphrkkikn ztyphrkkikn}</td><td>（中継用）Ｐ払込期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysdpdkbn ztysdpdkbn}</td><td>（中継用）Ｓ建Ｐ建区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkaisuukbn ztyhrkkaisuukbn}</td><td>（中継用）払込回数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrkkeirokbn ztyhrkkeirokbn}</td><td>（中継用）払込経路区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkykryouritukbn ztysinkykryouritukbn}</td><td>（中継用）新契約用料率区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyduketorihouhoukbn ztyduketorihouhoukbn}</td><td>（中継用）Ｄ受取方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykihons9 ztykihons9}</td><td>（中継用）基本Ｓ（９桁）</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhsys ztyhsys}</td><td>（中継用）保障Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytkbriknsnhrkp ztytkbriknsnhrkp}</td><td>（中継用）月払換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtyhhknseikbn ztyhhknseikbn}</td><td>（中継用）被保険者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyaseikbn ztykyksyaseikbn}</td><td>（中継用）契約者性別区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknnen2keta ztyhhknnen2keta}</td><td>（中継用）被保険者年令（２桁）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyanen ztykyksyanen}</td><td>（中継用）契約者年令</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysykgycd ztysykgycd}</td><td>（中継用）職業コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykyksyakikykarihyj ztykyksyakikykarihyj}</td><td>（中継用）契約者既契約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhknsyukigou ztyhknsyukigou}</td><td>（中継用）保険種類記号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyokaipnyuukinhouhoukbn ztysyokaipnyuukinhouhoukbn}</td><td>（中継用）初回Ｐ入金方法区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytoukeiyousinsakbn ztytoukeiyousinsakbn}</td><td>（中継用）統計用診査区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhhknsynensyuukbn ztyhhknsynensyuukbn}</td><td>（中継用）被保険者年収区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyukeiyakup ztysyukeiyakup}</td><td>（中継用）主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtybsudirtnatkikeitaikbn ztybsudirtnatkikeitaikbn}</td><td>（中継用）募集代理店扱形態区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykymd ztykykymd}</td><td>（中継用）契約年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtystdairiseikyuutkykarihyj ztystdairiseikyuutkykarihyj}</td><td>（中継用）指定代理請求特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymannenreihyj ztymannenreihyj}</td><td>（中継用）満年令表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynksyuruikbn1 ztynksyuruikbn1}</td><td>（中継用）年金種類区分（１文字）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtynstkarihyj ztynstkarihyj}</td><td>（中継用）年金支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyaatkioybsydrtencd ztyaatkioybsydrtencd}</td><td>（中継用）Ａ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtybatkioybsydrtencd ztybatkioybsydrtencd}</td><td>（中継用）Ｂ扱者親募集代理店コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysinkeiyakujiyoteiriritu ztysinkeiyakujiyoteiriritu}</td><td>（中継用）新契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysiteituukakihons ztysiteituukakihons}</td><td>（中継用）指定通貨建基本Ｓ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyhrktuukakbn ztyhrktuukakbn}</td><td>（中継用）払込通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysiteituukakbn ztysiteituukakbn}</td><td>（中継用）指定通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhrktuukatukiknznhrkp ztyhrktuukatukiknznhrkp}</td><td>（中継用）払込通貨建月換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysiteituukatukiknznhrkp ztysiteituukatukiknznhrkp}</td><td>（中継用）指定通貨建月換算払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyennyknrate ztyyennyknrate}</td><td>（中継用）円入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtygaikanyknrate ztygaikanyknrate}</td><td>（中継用）外貨入金レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyjyudkaigomehrtkarihyj ztyjyudkaigomehrtkarihyj}</td><td>（中継用）重度介護前払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysyksbyensitihsyutkykrate ztysyksbyensitihsyutkykrate}</td><td>（中継用）初期死亡時円換算最低保証特約用為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysjkkktyouseiriritu ztysjkkktyouseiriritu}</td><td>（中継用）市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytargettkmkht ztytargettkmkht}</td><td>（中継用）ターゲット特約目標値</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyteirituhaibunwari ztyteirituhaibunwari}</td><td>（中継用）定率部分配分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyzenkizennouhyouji ztyzenkizennouhyouji}</td><td>（中継用）全期前納表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwaribikikbn ztypwaribikikbn}</td><td>（中継用）Ｐ割引区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtypwaribikihanteigk ztypwaribikihanteigk}</td><td>（中継用）Ｐ割引判定金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtydai1hknkkn ztydai1hknkkn}</td><td>（中継用）第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykdrtkykarihyj ztykykdrtkykarihyj}</td><td>（中継用）契約者代理特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykzktrkservicetrkninzuu ztykzktrkservicetrkninzuu}</td><td>（中継用）ご家族登録サービス登録人数</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyteikisiharaiarihyj ztyteikisiharaiarihyj}</td><td>（中継用）定期支払特約有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv6 ztyyobiv6}</td><td>（中継用）予備項目Ｖ６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_SeirituInfoTy
 * @see     PKZT_SeirituInfoTy
 * @see     QZT_SeirituInfoTy
 * @see     GenQZT_SeirituInfoTy
 */
@MappedSuperclass
@Table(name=GenZT_SeirituInfoTy.TABLE_NAME)
@IdClass(value=PKZT_SeirituInfoTy.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_SeirituInfoTy extends AbstractExDBEntity<ZT_SeirituInfoTy, PKZT_SeirituInfoTy> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_SeirituInfoTy";
    public static final String ZTYKIJYUNYM              = "ztykijyunym";
    public static final String ZTYSEISEKIYM             = "ztyseisekiym";
    public static final String ZTYSYONO                 = "ztysyono";
    public static final String ZTYHANBAINM              = "ztyhanbainm";
    public static final String ZTYATKISISYA             = "ztyatkisisya";
    public static final String ZTYHKNKKN                = "ztyhknkkn";
    public static final String ZTYPHRKKIKN              = "ztyphrkkikn";
    public static final String ZTYSDPDKBN               = "ztysdpdkbn";
    public static final String ZTYHRKKAISUUKBN          = "ztyhrkkaisuukbn";
    public static final String ZTYHRKKEIROKBN           = "ztyhrkkeirokbn";
    public static final String ZTYSINKYKRYOURITUKBN     = "ztysinkykryouritukbn";
    public static final String ZTYDUKETORIHOUHOUKBN     = "ztyduketorihouhoukbn";
    public static final String ZTYKIHONS9               = "ztykihons9";
    public static final String ZTYHSYS                  = "ztyhsys";
    public static final String ZTYTKBRIKNSNHRKP         = "ztytkbriknsnhrkp";
    public static final String ZTYHHKNSEIKBN            = "ztyhhknseikbn";
    public static final String ZTYKYKSYASEIKBN          = "ztykyksyaseikbn";
    public static final String ZTYHHKNNEN2KETA          = "ztyhhknnen2keta";
    public static final String ZTYKYKSYANEN             = "ztykyksyanen";
    public static final String ZTYSYKGYCD               = "ztysykgycd";
    public static final String ZTYKYKSYAKIKYKARIHYJ     = "ztykyksyakikykarihyj";
    public static final String ZTYHKNSYUKIGOU           = "ztyhknsyukigou";
    public static final String ZTYSYOKAIPNYUUKINHOUHOUKBN = "ztysyokaipnyuukinhouhoukbn";
    public static final String ZTYTOUKEIYOUSINSAKBN     = "ztytoukeiyousinsakbn";
    public static final String ZTYHHKNSYNENSYUUKBN      = "ztyhhknsynensyuukbn";
    public static final String ZTYSYUKEIYAKUP           = "ztysyukeiyakup";
    public static final String ZTYBSUDIRTNATKIKEITAIKBN = "ztybsudirtnatkikeitaikbn";
    public static final String ZTYKYKYMD                = "ztykykymd";
    public static final String ZTYSTDAIRISEIKYUUTKYKARIHYJ = "ztystdairiseikyuutkykarihyj";
    public static final String ZTYMANNENREIHYJ          = "ztymannenreihyj";
    public static final String ZTYNKSYURUIKBN1          = "ztynksyuruikbn1";
    public static final String ZTYNSTKARIHYJ            = "ztynstkarihyj";
    public static final String ZTYAATKIOYBSYDRTENCD     = "ztyaatkioybsydrtencd";
    public static final String ZTYBATKIOYBSYDRTENCD     = "ztybatkioybsydrtencd";
    public static final String ZTYSINKEIYAKUJIYOTEIRIRITU = "ztysinkeiyakujiyoteiriritu";
    public static final String ZTYSITEITUUKAKIHONS      = "ztysiteituukakihons";
    public static final String ZTYHRKTUUKAKBN           = "ztyhrktuukakbn";
    public static final String ZTYSITEITUUKAKBN         = "ztysiteituukakbn";
    public static final String ZTYHRKTUUKATUKIKNZNHRKP  = "ztyhrktuukatukiknznhrkp";
    public static final String ZTYSITEITUUKATUKIKNZNHRKP = "ztysiteituukatukiknznhrkp";
    public static final String ZTYYENNYKNRATE           = "ztyyennyknrate";
    public static final String ZTYGAIKANYKNRATE         = "ztygaikanyknrate";
    public static final String ZTYJYUDKAIGOMEHRTKARIHYJ = "ztyjyudkaigomehrtkarihyj";
    public static final String ZTYSYKSBYENSITIHSYUTKYKRATE = "ztysyksbyensitihsyutkykrate";
    public static final String ZTYSJKKKTYOUSEIRIRITU    = "ztysjkkktyouseiriritu";
    public static final String ZTYTARGETTKMKHT          = "ztytargettkmkht";
    public static final String ZTYTEIRITUHAIBUNWARI     = "ztyteirituhaibunwari";
    public static final String ZTYZENKIZENNOUHYOUJI     = "ztyzenkizennouhyouji";
    public static final String ZTYPWARIBIKIKBN          = "ztypwaribikikbn";
    public static final String ZTYPWARIBIKIHANTEIGK     = "ztypwaribikihanteigk";
    public static final String ZTYDAI1HKNKKN            = "ztydai1hknkkn";
    public static final String ZTYKYKDRTKYKARIHYJ       = "ztykykdrtkykarihyj";
    public static final String ZTYKZKTRKSERVICETRKNINZUU = "ztykzktrkservicetrkninzuu";
    public static final String ZTYTEIKISIHARAIARIHYJ    = "ztyteikisiharaiarihyj";
    public static final String ZTYYOBIV6                = "ztyyobiv6";

    private final PKZT_SeirituInfoTy primaryKey;

    public GenZT_SeirituInfoTy() {
        primaryKey = new PKZT_SeirituInfoTy();
    }

    public GenZT_SeirituInfoTy(String pZtykijyunym, String pZtysyono) {
        primaryKey = new PKZT_SeirituInfoTy(pZtykijyunym, pZtysyono);
    }

    @Transient
    @Override
    public PKZT_SeirituInfoTy getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_SeirituInfoTy> getMetaClass() {
        return QZT_SeirituInfoTy.class;
    }

    @Id
    @Column(name=GenZT_SeirituInfoTy.ZTYKIJYUNYM)
    public String getZtykijyunym() {
        return getPrimaryKey().getZtykijyunym();
    }

    public void setZtykijyunym(String pZtykijyunym) {
        getPrimaryKey().setZtykijyunym(pZtykijyunym);
    }

    private String ztyseisekiym;

    @Column(name=GenZT_SeirituInfoTy.ZTYSEISEKIYM)
    public String getZtyseisekiym() {
        return ztyseisekiym;
    }

    public void setZtyseisekiym(String pZtyseisekiym) {
        ztyseisekiym = pZtyseisekiym;
    }

    @Id
    @Column(name=GenZT_SeirituInfoTy.ZTYSYONO)
    public String getZtysyono() {
        return getPrimaryKey().getZtysyono();
    }

    public void setZtysyono(String pZtysyono) {
        getPrimaryKey().setZtysyono(pZtysyono);
    }

    private String ztyhanbainm;

    @Column(name=GenZT_SeirituInfoTy.ZTYHANBAINM)
    public String getZtyhanbainm() {
        return ztyhanbainm;
    }

    public void setZtyhanbainm(String pZtyhanbainm) {
        ztyhanbainm = pZtyhanbainm;
    }

    private String ztyatkisisya;

    @Column(name=GenZT_SeirituInfoTy.ZTYATKISISYA)
    public String getZtyatkisisya() {
        return ztyatkisisya;
    }

    public void setZtyatkisisya(String pZtyatkisisya) {
        ztyatkisisya = pZtyatkisisya;
    }

    private String ztyhknkkn;

    @Column(name=GenZT_SeirituInfoTy.ZTYHKNKKN)
    public String getZtyhknkkn() {
        return ztyhknkkn;
    }

    public void setZtyhknkkn(String pZtyhknkkn) {
        ztyhknkkn = pZtyhknkkn;
    }

    private String ztyphrkkikn;

    @Column(name=GenZT_SeirituInfoTy.ZTYPHRKKIKN)
    public String getZtyphrkkikn() {
        return ztyphrkkikn;
    }

    public void setZtyphrkkikn(String pZtyphrkkikn) {
        ztyphrkkikn = pZtyphrkkikn;
    }

    private String ztysdpdkbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYSDPDKBN)
    public String getZtysdpdkbn() {
        return ztysdpdkbn;
    }

    public void setZtysdpdkbn(String pZtysdpdkbn) {
        ztysdpdkbn = pZtysdpdkbn;
    }

    private String ztyhrkkaisuukbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYHRKKAISUUKBN)
    public String getZtyhrkkaisuukbn() {
        return ztyhrkkaisuukbn;
    }

    public void setZtyhrkkaisuukbn(String pZtyhrkkaisuukbn) {
        ztyhrkkaisuukbn = pZtyhrkkaisuukbn;
    }

    private String ztyhrkkeirokbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYHRKKEIROKBN)
    public String getZtyhrkkeirokbn() {
        return ztyhrkkeirokbn;
    }

    public void setZtyhrkkeirokbn(String pZtyhrkkeirokbn) {
        ztyhrkkeirokbn = pZtyhrkkeirokbn;
    }

    private String ztysinkykryouritukbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYSINKYKRYOURITUKBN)
    public String getZtysinkykryouritukbn() {
        return ztysinkykryouritukbn;
    }

    public void setZtysinkykryouritukbn(String pZtysinkykryouritukbn) {
        ztysinkykryouritukbn = pZtysinkykryouritukbn;
    }

    private String ztyduketorihouhoukbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYDUKETORIHOUHOUKBN)
    public String getZtyduketorihouhoukbn() {
        return ztyduketorihouhoukbn;
    }

    public void setZtyduketorihouhoukbn(String pZtyduketorihouhoukbn) {
        ztyduketorihouhoukbn = pZtyduketorihouhoukbn;
    }

    private Long ztykihons9;

    @Column(name=GenZT_SeirituInfoTy.ZTYKIHONS9)
    public Long getZtykihons9() {
        return ztykihons9;
    }

    public void setZtykihons9(Long pZtykihons9) {
        ztykihons9 = pZtykihons9;
    }

    private Long ztyhsys;

    @Column(name=GenZT_SeirituInfoTy.ZTYHSYS)
    public Long getZtyhsys() {
        return ztyhsys;
    }

    public void setZtyhsys(Long pZtyhsys) {
        ztyhsys = pZtyhsys;
    }

    private Long ztytkbriknsnhrkp;

    @Column(name=GenZT_SeirituInfoTy.ZTYTKBRIKNSNHRKP)
    public Long getZtytkbriknsnhrkp() {
        return ztytkbriknsnhrkp;
    }

    public void setZtytkbriknsnhrkp(Long pZtytkbriknsnhrkp) {
        ztytkbriknsnhrkp = pZtytkbriknsnhrkp;
    }

    private String ztyhhknseikbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYHHKNSEIKBN)
    public String getZtyhhknseikbn() {
        return ztyhhknseikbn;
    }

    public void setZtyhhknseikbn(String pZtyhhknseikbn) {
        ztyhhknseikbn = pZtyhhknseikbn;
    }

    private String ztykyksyaseikbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYKYKSYASEIKBN)
    public String getZtykyksyaseikbn() {
        return ztykyksyaseikbn;
    }

    public void setZtykyksyaseikbn(String pZtykyksyaseikbn) {
        ztykyksyaseikbn = pZtykyksyaseikbn;
    }

    private String ztyhhknnen2keta;

    @Column(name=GenZT_SeirituInfoTy.ZTYHHKNNEN2KETA)
    public String getZtyhhknnen2keta() {
        return ztyhhknnen2keta;
    }

    public void setZtyhhknnen2keta(String pZtyhhknnen2keta) {
        ztyhhknnen2keta = pZtyhhknnen2keta;
    }

    private String ztykyksyanen;

    @Column(name=GenZT_SeirituInfoTy.ZTYKYKSYANEN)
    public String getZtykyksyanen() {
        return ztykyksyanen;
    }

    public void setZtykyksyanen(String pZtykyksyanen) {
        ztykyksyanen = pZtykyksyanen;
    }

    private String ztysykgycd;

    @Column(name=GenZT_SeirituInfoTy.ZTYSYKGYCD)
    public String getZtysykgycd() {
        return ztysykgycd;
    }

    public void setZtysykgycd(String pZtysykgycd) {
        ztysykgycd = pZtysykgycd;
    }

    private String ztykyksyakikykarihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYKYKSYAKIKYKARIHYJ)
    public String getZtykyksyakikykarihyj() {
        return ztykyksyakikykarihyj;
    }

    public void setZtykyksyakikykarihyj(String pZtykyksyakikykarihyj) {
        ztykyksyakikykarihyj = pZtykyksyakikykarihyj;
    }

    private String ztyhknsyukigou;

    @Column(name=GenZT_SeirituInfoTy.ZTYHKNSYUKIGOU)
    public String getZtyhknsyukigou() {
        return ztyhknsyukigou;
    }

    public void setZtyhknsyukigou(String pZtyhknsyukigou) {
        ztyhknsyukigou = pZtyhknsyukigou;
    }

    private String ztysyokaipnyuukinhouhoukbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYSYOKAIPNYUUKINHOUHOUKBN)
    public String getZtysyokaipnyuukinhouhoukbn() {
        return ztysyokaipnyuukinhouhoukbn;
    }

    public void setZtysyokaipnyuukinhouhoukbn(String pZtysyokaipnyuukinhouhoukbn) {
        ztysyokaipnyuukinhouhoukbn = pZtysyokaipnyuukinhouhoukbn;
    }

    private String ztytoukeiyousinsakbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYTOUKEIYOUSINSAKBN)
    public String getZtytoukeiyousinsakbn() {
        return ztytoukeiyousinsakbn;
    }

    public void setZtytoukeiyousinsakbn(String pZtytoukeiyousinsakbn) {
        ztytoukeiyousinsakbn = pZtytoukeiyousinsakbn;
    }

    private String ztyhhknsynensyuukbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYHHKNSYNENSYUUKBN)
    public String getZtyhhknsynensyuukbn() {
        return ztyhhknsynensyuukbn;
    }

    public void setZtyhhknsynensyuukbn(String pZtyhhknsynensyuukbn) {
        ztyhhknsynensyuukbn = pZtyhhknsynensyuukbn;
    }

    private Long ztysyukeiyakup;

    @Column(name=GenZT_SeirituInfoTy.ZTYSYUKEIYAKUP)
    public Long getZtysyukeiyakup() {
        return ztysyukeiyakup;
    }

    public void setZtysyukeiyakup(Long pZtysyukeiyakup) {
        ztysyukeiyakup = pZtysyukeiyakup;
    }

    private String ztybsudirtnatkikeitaikbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYBSUDIRTNATKIKEITAIKBN)
    public String getZtybsudirtnatkikeitaikbn() {
        return ztybsudirtnatkikeitaikbn;
    }

    public void setZtybsudirtnatkikeitaikbn(String pZtybsudirtnatkikeitaikbn) {
        ztybsudirtnatkikeitaikbn = pZtybsudirtnatkikeitaikbn;
    }

    private String ztykykymd;

    @Column(name=GenZT_SeirituInfoTy.ZTYKYKYMD)
    public String getZtykykymd() {
        return ztykykymd;
    }

    public void setZtykykymd(String pZtykykymd) {
        ztykykymd = pZtykykymd;
    }

    private String ztystdairiseikyuutkykarihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYSTDAIRISEIKYUUTKYKARIHYJ)
    public String getZtystdairiseikyuutkykarihyj() {
        return ztystdairiseikyuutkykarihyj;
    }

    public void setZtystdairiseikyuutkykarihyj(String pZtystdairiseikyuutkykarihyj) {
        ztystdairiseikyuutkykarihyj = pZtystdairiseikyuutkykarihyj;
    }

    private String ztymannenreihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYMANNENREIHYJ)
    public String getZtymannenreihyj() {
        return ztymannenreihyj;
    }

    public void setZtymannenreihyj(String pZtymannenreihyj) {
        ztymannenreihyj = pZtymannenreihyj;
    }

    private String ztynksyuruikbn1;

    @Column(name=GenZT_SeirituInfoTy.ZTYNKSYURUIKBN1)
    public String getZtynksyuruikbn1() {
        return ztynksyuruikbn1;
    }

    public void setZtynksyuruikbn1(String pZtynksyuruikbn1) {
        ztynksyuruikbn1 = pZtynksyuruikbn1;
    }

    private String ztynstkarihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYNSTKARIHYJ)
    public String getZtynstkarihyj() {
        return ztynstkarihyj;
    }

    public void setZtynstkarihyj(String pZtynstkarihyj) {
        ztynstkarihyj = pZtynstkarihyj;
    }

    private String ztyaatkioybsydrtencd;

    @Column(name=GenZT_SeirituInfoTy.ZTYAATKIOYBSYDRTENCD)
    public String getZtyaatkioybsydrtencd() {
        return ztyaatkioybsydrtencd;
    }

    public void setZtyaatkioybsydrtencd(String pZtyaatkioybsydrtencd) {
        ztyaatkioybsydrtencd = pZtyaatkioybsydrtencd;
    }

    private String ztybatkioybsydrtencd;

    @Column(name=GenZT_SeirituInfoTy.ZTYBATKIOYBSYDRTENCD)
    public String getZtybatkioybsydrtencd() {
        return ztybatkioybsydrtencd;
    }

    public void setZtybatkioybsydrtencd(String pZtybatkioybsydrtencd) {
        ztybatkioybsydrtencd = pZtybatkioybsydrtencd;
    }

    private BizNumber ztysinkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYSINKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtysinkeiyakujiyoteiriritu() {
        return ztysinkeiyakujiyoteiriritu;
    }

    public void setZtysinkeiyakujiyoteiriritu(BizNumber pZtysinkeiyakujiyoteiriritu) {
        ztysinkeiyakujiyoteiriritu = pZtysinkeiyakujiyoteiriritu;
    }

    private BizNumber ztysiteituukakihons;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYSITEITUUKAKIHONS)
    public BizNumber getZtysiteituukakihons() {
        return ztysiteituukakihons;
    }

    public void setZtysiteituukakihons(BizNumber pZtysiteituukakihons) {
        ztysiteituukakihons = pZtysiteituukakihons;
    }

    private String ztyhrktuukakbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYHRKTUUKAKBN)
    public String getZtyhrktuukakbn() {
        return ztyhrktuukakbn;
    }

    public void setZtyhrktuukakbn(String pZtyhrktuukakbn) {
        ztyhrktuukakbn = pZtyhrktuukakbn;
    }

    private String ztysiteituukakbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYSITEITUUKAKBN)
    public String getZtysiteituukakbn() {
        return ztysiteituukakbn;
    }

    public void setZtysiteituukakbn(String pZtysiteituukakbn) {
        ztysiteituukakbn = pZtysiteituukakbn;
    }

    private BizNumber ztyhrktuukatukiknznhrkp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYHRKTUUKATUKIKNZNHRKP)
    public BizNumber getZtyhrktuukatukiknznhrkp() {
        return ztyhrktuukatukiknznhrkp;
    }

    public void setZtyhrktuukatukiknznhrkp(BizNumber pZtyhrktuukatukiknznhrkp) {
        ztyhrktuukatukiknznhrkp = pZtyhrktuukatukiknznhrkp;
    }

    private BizNumber ztysiteituukatukiknznhrkp;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYSITEITUUKATUKIKNZNHRKP)
    public BizNumber getZtysiteituukatukiknznhrkp() {
        return ztysiteituukatukiknznhrkp;
    }

    public void setZtysiteituukatukiknznhrkp(BizNumber pZtysiteituukatukiknznhrkp) {
        ztysiteituukatukiknznhrkp = pZtysiteituukatukiknznhrkp;
    }

    private BizNumber ztyyennyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYYENNYKNRATE)
    public BizNumber getZtyyennyknrate() {
        return ztyyennyknrate;
    }

    public void setZtyyennyknrate(BizNumber pZtyyennyknrate) {
        ztyyennyknrate = pZtyyennyknrate;
    }

    private BizNumber ztygaikanyknrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYGAIKANYKNRATE)
    public BizNumber getZtygaikanyknrate() {
        return ztygaikanyknrate;
    }

    public void setZtygaikanyknrate(BizNumber pZtygaikanyknrate) {
        ztygaikanyknrate = pZtygaikanyknrate;
    }

    private String ztyjyudkaigomehrtkarihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYJYUDKAIGOMEHRTKARIHYJ)
    public String getZtyjyudkaigomehrtkarihyj() {
        return ztyjyudkaigomehrtkarihyj;
    }

    public void setZtyjyudkaigomehrtkarihyj(String pZtyjyudkaigomehrtkarihyj) {
        ztyjyudkaigomehrtkarihyj = pZtyjyudkaigomehrtkarihyj;
    }

    private BizNumber ztysyksbyensitihsyutkykrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYSYKSBYENSITIHSYUTKYKRATE)
    public BizNumber getZtysyksbyensitihsyutkykrate() {
        return ztysyksbyensitihsyutkykrate;
    }

    public void setZtysyksbyensitihsyutkykrate(BizNumber pZtysyksbyensitihsyutkykrate) {
        ztysyksbyensitihsyutkykrate = pZtysyksbyensitihsyutkykrate;
    }

    private BizNumber ztysjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYSJKKKTYOUSEIRIRITU)
    public BizNumber getZtysjkkktyouseiriritu() {
        return ztysjkkktyouseiriritu;
    }

    public void setZtysjkkktyouseiriritu(BizNumber pZtysjkkktyouseiriritu) {
        ztysjkkktyouseiriritu = pZtysjkkktyouseiriritu;
    }

    private Integer ztytargettkmkht;

    @Column(name=GenZT_SeirituInfoTy.ZTYTARGETTKMKHT)
    public Integer getZtytargettkmkht() {
        return ztytargettkmkht;
    }

    public void setZtytargettkmkht(Integer pZtytargettkmkht) {
        ztytargettkmkht = pZtytargettkmkht;
    }

    private String ztyteirituhaibunwari;

    @Column(name=GenZT_SeirituInfoTy.ZTYTEIRITUHAIBUNWARI)
    public String getZtyteirituhaibunwari() {
        return ztyteirituhaibunwari;
    }

    public void setZtyteirituhaibunwari(String pZtyteirituhaibunwari) {
        ztyteirituhaibunwari = pZtyteirituhaibunwari;
    }

    private String ztyzenkizennouhyouji;

    @Column(name=GenZT_SeirituInfoTy.ZTYZENKIZENNOUHYOUJI)
    public String getZtyzenkizennouhyouji() {
        return ztyzenkizennouhyouji;
    }

    public void setZtyzenkizennouhyouji(String pZtyzenkizennouhyouji) {
        ztyzenkizennouhyouji = pZtyzenkizennouhyouji;
    }

    private String ztypwaribikikbn;

    @Column(name=GenZT_SeirituInfoTy.ZTYPWARIBIKIKBN)
    public String getZtypwaribikikbn() {
        return ztypwaribikikbn;
    }

    public void setZtypwaribikikbn(String pZtypwaribikikbn) {
        ztypwaribikikbn = pZtypwaribikikbn;
    }

    private BizNumber ztypwaribikihanteigk;

    @Type(type="BizNumberType")
    @Column(name=GenZT_SeirituInfoTy.ZTYPWARIBIKIHANTEIGK)
    public BizNumber getZtypwaribikihanteigk() {
        return ztypwaribikihanteigk;
    }

    public void setZtypwaribikihanteigk(BizNumber pZtypwaribikihanteigk) {
        ztypwaribikihanteigk = pZtypwaribikihanteigk;
    }

    private String ztydai1hknkkn;

    @Column(name=GenZT_SeirituInfoTy.ZTYDAI1HKNKKN)
    public String getZtydai1hknkkn() {
        return ztydai1hknkkn;
    }

    public void setZtydai1hknkkn(String pZtydai1hknkkn) {
        ztydai1hknkkn = pZtydai1hknkkn;
    }

    private String ztykykdrtkykarihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYKYKDRTKYKARIHYJ)
    public String getZtykykdrtkykarihyj() {
        return ztykykdrtkykarihyj;
    }

    public void setZtykykdrtkykarihyj(String pZtykykdrtkykarihyj) {
        ztykykdrtkykarihyj = pZtykykdrtkykarihyj;
    }

    private String ztykzktrkservicetrkninzuu;

    @Column(name=GenZT_SeirituInfoTy.ZTYKZKTRKSERVICETRKNINZUU)
    public String getZtykzktrkservicetrkninzuu() {
        return ztykzktrkservicetrkninzuu;
    }

    public void setZtykzktrkservicetrkninzuu(String pZtykzktrkservicetrkninzuu) {
        ztykzktrkservicetrkninzuu = pZtykzktrkservicetrkninzuu;
    }

    private String ztyteikisiharaiarihyj;

    @Column(name=GenZT_SeirituInfoTy.ZTYTEIKISIHARAIARIHYJ)
    public String getZtyteikisiharaiarihyj() {
        return ztyteikisiharaiarihyj;
    }

    public void setZtyteikisiharaiarihyj(String pZtyteikisiharaiarihyj) {
        ztyteikisiharaiarihyj = pZtyteikisiharaiarihyj;
    }

    private String ztyyobiv6;

    @Column(name=GenZT_SeirituInfoTy.ZTYYOBIV6)
    public String getZtyyobiv6() {
        return ztyyobiv6;
    }

    public void setZtyyobiv6(String pZtyyobiv6) {
        ztyyobiv6 = pZtyyobiv6;
    }
}