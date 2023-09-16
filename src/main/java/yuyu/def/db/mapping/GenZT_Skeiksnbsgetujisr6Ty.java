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
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr6Ty;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Ty;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（中） テーブルのマッピング情報クラスで、 {@link ZT_Skeiksnbsgetujisr6Ty} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Skeiksnbsgetujisr6Ty}</td><td colspan="3">新契約決算ベース月次成立Ｆテーブル６（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZtyktgysyrymd ztyktgysyrymd}</td><td>（中継用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgysyono ztyktgysyono}</td><td>（中継用）結合用証券番号</td><td align="center">{@link PKZT_Skeiksnbsgetujisr6Ty ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyktgyfilerenno ztyktgyfilerenno}</td><td>（中継用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyraysystemhyj ztyraysystemhyj}</td><td>（中継用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtygaikakbn ztygaikakbn}</td><td>（中継用）外貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykawaserate ztykawaserate}</td><td>（中継用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykawaseratetekiyouymd ztykawaseratetekiyouymd}</td><td>（中継用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykykjikawaserate ztykykjikawaserate}</td><td>（中継用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykjikawaseratetkyuymd ztykykjikawaseratetkyuymd}</td><td>（中継用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtykeiyakujiyoteiriritu ztykeiyakujiyoteiriritu}</td><td>（中継用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtytumitateriritu ztytumitateriritu}</td><td>（中継用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysrkyksjkkktyouseiriritu ztysrkyksjkkktyouseiriritu}</td><td>（中継用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyenkdtsbujsitihsyukngk ztyenkdtsbujsitihsyukngk}</td><td>（中継用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykaigomaebaraitkykarihyj ztykaigomaebaraitkykarihyj}</td><td>（中継用）介護前払特約あり表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin1 ztysuuriyouyobin1}</td><td>（中継用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysibouhyoukbn ztysibouhyoukbn}</td><td>（中継用）死亡表区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtymvatyouseikou ztymvatyouseikou}</td><td>（中継用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtynyuukintuukakbn ztynyuukintuukakbn}</td><td>（中継用）入金通貨区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnknkykliveonearhyj ztyhtnknkykliveonearhyj}</td><td>（中継用）被転換契約ライブワン有表示</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyliveonepackagesyouhinkbn ztyliveonepackagesyouhinkbn}</td><td>（中継用）ライブワンパッケージ商品区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyhtnkngukisisttkknsnp ztyhtnkngukisisttkknsnp}</td><td>（中継用）被転換合計災疾月換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtywyendttargetmokuhyouritu ztywyendttargetmokuhyouritu}</td><td>（中継用）円建Ｗターゲット目標率</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuurendourate ztysisuurendourate}</td><td>（中継用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysisuukbn ztysisuukbn}</td><td>（中継用）指数区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysrdai1hknkkn ztysrdai1hknkkn}</td><td>（中継用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x2 ztysuuriyouyobin10x2}</td><td>（中継用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtysuuriyouyobin10x3 ztysuuriyouyobin10x3}</td><td>（中継用）数理用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtytmttknzoukaritujygn ztytmttknzoukaritujygn}</td><td>（中継用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtysetteibairitu ztysetteibairitu}</td><td>（中継用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtykykymdsisuu ztykykymdsisuu}</td><td>（中継用）契約日指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyrendouritu ztyrendouritu}</td><td>（中継用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobin5 ztyyobin5}</td><td>（中継用）予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtyyobin5x2 ztyyobin5x2}</td><td>（中継用）予備項目Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZtytuukasyukbn ztytuukasyukbn}</td><td>（中継用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyobiv9x2 ztyyobiv9x2}</td><td>（中継用）予備項目Ｖ９＿２</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getZtyyendttargetkijyunkingaku ztyyendttargetkijyunkingaku}</td><td>（中継用）円建ターゲット基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysisuurentumitatekin ztysisuurentumitatekin}</td><td>（中継用）指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytirttmtttumitatekin ztytirttmtttumitatekin}</td><td>（中継用）定率積立部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynksjitirttmttkn ztynksjitirttmttkn}</td><td>（中継用）年金開始時定率積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtynendomatutirttumitatekin ztynendomatutirttumitatekin}</td><td>（中継用）年度末定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysyuptumitatekin ztysyuptumitatekin}</td><td>（中継用）主契約保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatenkgns ztygaikadatenkgns}</td><td>（中継用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtytumitatekin ztytumitatekin}</td><td>（中継用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtykiharaikomip ztykiharaikomip}</td><td>（中継用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtygaikadatesyukeiyakup ztygaikadatesyukeiyakup}</td><td>（中継用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZtysitivkisnyukykjikwsrate ztysitivkisnyukykjikwsrate}</td><td>（中継用）最低Ｖ計算用契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZtyyobiv16 ztyyobiv16}</td><td>（中継用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_Skeiksnbsgetujisr6Ty
 * @see     PKZT_Skeiksnbsgetujisr6Ty
 * @see     QZT_Skeiksnbsgetujisr6Ty
 * @see     GenQZT_Skeiksnbsgetujisr6Ty
 */
@MappedSuperclass
@Table(name=GenZT_Skeiksnbsgetujisr6Ty.TABLE_NAME)
@IdClass(value=PKZT_Skeiksnbsgetujisr6Ty.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Skeiksnbsgetujisr6Ty extends AbstractExDBEntity<ZT_Skeiksnbsgetujisr6Ty, PKZT_Skeiksnbsgetujisr6Ty> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Skeiksnbsgetujisr6Ty";
    public static final String ZTYKTGYSYRYMD            = "ztyktgysyrymd";
    public static final String ZTYKTGYSYONO             = "ztyktgysyono";
    public static final String ZTYKTGYFILERENNO         = "ztyktgyfilerenno";
    public static final String ZTYRAYSYSTEMHYJ          = "ztyraysystemhyj";
    public static final String ZTYGAIKAKBN              = "ztygaikakbn";
    public static final String ZTYKAWASERATE            = "ztykawaserate";
    public static final String ZTYKAWASERATETEKIYOUYMD  = "ztykawaseratetekiyouymd";
    public static final String ZTYKYKJIKAWASERATE       = "ztykykjikawaserate";
    public static final String ZTYKYKJIKAWASERATETKYUYMD = "ztykykjikawaseratetkyuymd";
    public static final String ZTYKEIYAKUJIYOTEIRIRITU  = "ztykeiyakujiyoteiriritu";
    public static final String ZTYTUMITATERIRITU        = "ztytumitateriritu";
    public static final String ZTYSRKYKSJKKKTYOUSEIRIRITU = "ztysrkyksjkkktyouseiriritu";
    public static final String ZTYENKDTSBUJSITIHSYUKNGK = "ztyenkdtsbujsitihsyukngk";
    public static final String ZTYKAIGOMAEBARAITKYKARIHYJ = "ztykaigomaebaraitkykarihyj";
    public static final String ZTYSUURIYOUYOBIN1        = "ztysuuriyouyobin1";
    public static final String ZTYSIBOUHYOUKBN          = "ztysibouhyoukbn";
    public static final String ZTYMVATYOUSEIKOU         = "ztymvatyouseikou";
    public static final String ZTYNYUUKINTUUKAKBN       = "ztynyuukintuukakbn";
    public static final String ZTYHTNKNKYKLIVEONEARHYJ  = "ztyhtnknkykliveonearhyj";
    public static final String ZTYLIVEONEPACKAGESYOUHINKBN = "ztyliveonepackagesyouhinkbn";
    public static final String ZTYHTNKNGUKISISTTKKNSNP  = "ztyhtnkngukisisttkknsnp";
    public static final String ZTYWYENDTTARGETMOKUHYOURITU = "ztywyendttargetmokuhyouritu";
    public static final String ZTYSISUURENDOURATE       = "ztysisuurendourate";
    public static final String ZTYSISUUKBN              = "ztysisuukbn";
    public static final String ZTYSRDAI1HKNKKN          = "ztysrdai1hknkkn";
    public static final String ZTYSUURIYOUYOBIN10X2     = "ztysuuriyouyobin10x2";
    public static final String ZTYSUURIYOUYOBIN10X3     = "ztysuuriyouyobin10x3";
    public static final String ZTYTMTTKNZOUKARITUJYGN   = "ztytmttknzoukaritujygn";
    public static final String ZTYSETTEIBAIRITU         = "ztysetteibairitu";
    public static final String ZTYKYKYMDSISUU           = "ztykykymdsisuu";
    public static final String ZTYRENDOURITU            = "ztyrendouritu";
    public static final String ZTYYOBIN5                = "ztyyobin5";
    public static final String ZTYYOBIN5X2              = "ztyyobin5x2";
    public static final String ZTYTUUKASYUKBN           = "ztytuukasyukbn";
    public static final String ZTYYOBIV9X2              = "ztyyobiv9x2";
    public static final String ZTYYENDTTARGETKIJYUNKINGAKU = "ztyyendttargetkijyunkingaku";
    public static final String ZTYSISUURENTUMITATEKIN   = "ztysisuurentumitatekin";
    public static final String ZTYTIRTTMTTTUMITATEKIN   = "ztytirttmtttumitatekin";
    public static final String ZTYNKSJITIRTTMTTKN       = "ztynksjitirttmttkn";
    public static final String ZTYNENDOMATUTIRTTUMITATEKIN = "ztynendomatutirttumitatekin";
    public static final String ZTYSYUPTUMITATEKIN       = "ztysyuptumitatekin";
    public static final String ZTYGAIKADATENKGNS        = "ztygaikadatenkgns";
    public static final String ZTYTUMITATEKIN           = "ztytumitatekin";
    public static final String ZTYKIHARAIKOMIP          = "ztykiharaikomip";
    public static final String ZTYGAIKADATESYUKEIYAKUP  = "ztygaikadatesyukeiyakup";
    public static final String ZTYSITIVKISNYUKYKJIKWSRATE = "ztysitivkisnyukykjikwsrate";
    public static final String ZTYYOBIV16               = "ztyyobiv16";

    private final PKZT_Skeiksnbsgetujisr6Ty primaryKey;

    public GenZT_Skeiksnbsgetujisr6Ty() {
        primaryKey = new PKZT_Skeiksnbsgetujisr6Ty();
    }

    public GenZT_Skeiksnbsgetujisr6Ty(String pZtyktgysyono) {
        primaryKey = new PKZT_Skeiksnbsgetujisr6Ty(pZtyktgysyono);
    }

    @Transient
    @Override
    public PKZT_Skeiksnbsgetujisr6Ty getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Skeiksnbsgetujisr6Ty> getMetaClass() {
        return QZT_Skeiksnbsgetujisr6Ty.class;
    }

    private String ztyktgysyrymd;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKTGYSYRYMD)
    public String getZtyktgysyrymd() {
        return ztyktgysyrymd;
    }

    public void setZtyktgysyrymd(String pZtyktgysyrymd) {
        ztyktgysyrymd = pZtyktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKTGYSYONO)
    public String getZtyktgysyono() {
        return getPrimaryKey().getZtyktgysyono();
    }

    public void setZtyktgysyono(String pZtyktgysyono) {
        getPrimaryKey().setZtyktgysyono(pZtyktgysyono);
    }

    private String ztyktgyfilerenno;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKTGYFILERENNO)
    public String getZtyktgyfilerenno() {
        return ztyktgyfilerenno;
    }

    public void setZtyktgyfilerenno(String pZtyktgyfilerenno) {
        ztyktgyfilerenno = pZtyktgyfilerenno;
    }

    private String ztyraysystemhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYRAYSYSTEMHYJ)
    public String getZtyraysystemhyj() {
        return ztyraysystemhyj;
    }

    public void setZtyraysystemhyj(String pZtyraysystemhyj) {
        ztyraysystemhyj = pZtyraysystemhyj;
    }

    private String ztygaikakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYGAIKAKBN)
    public String getZtygaikakbn() {
        return ztygaikakbn;
    }

    public void setZtygaikakbn(String pZtygaikakbn) {
        ztygaikakbn = pZtygaikakbn;
    }

    private BizNumber ztykawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKAWASERATE)
    public BizNumber getZtykawaserate() {
        return ztykawaserate;
    }

    public void setZtykawaserate(BizNumber pZtykawaserate) {
        ztykawaserate = pZtykawaserate;
    }

    private String ztykawaseratetekiyouymd;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKAWASERATETEKIYOUYMD)
    public String getZtykawaseratetekiyouymd() {
        return ztykawaseratetekiyouymd;
    }

    public void setZtykawaseratetekiyouymd(String pZtykawaseratetekiyouymd) {
        ztykawaseratetekiyouymd = pZtykawaseratetekiyouymd;
    }

    private BizNumber ztykykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKYKJIKAWASERATE)
    public BizNumber getZtykykjikawaserate() {
        return ztykykjikawaserate;
    }

    public void setZtykykjikawaserate(BizNumber pZtykykjikawaserate) {
        ztykykjikawaserate = pZtykykjikawaserate;
    }

    private String ztykykjikawaseratetkyuymd;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKYKJIKAWASERATETKYUYMD)
    public String getZtykykjikawaseratetkyuymd() {
        return ztykykjikawaseratetkyuymd;
    }

    public void setZtykykjikawaseratetkyuymd(String pZtykykjikawaseratetkyuymd) {
        ztykykjikawaseratetkyuymd = pZtykykjikawaseratetkyuymd;
    }

    private BizNumber ztykeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZtykeiyakujiyoteiriritu() {
        return ztykeiyakujiyoteiriritu;
    }

    public void setZtykeiyakujiyoteiriritu(BizNumber pZtykeiyakujiyoteiriritu) {
        ztykeiyakujiyoteiriritu = pZtykeiyakujiyoteiriritu;
    }

    private BizNumber ztytumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYTUMITATERIRITU)
    public BizNumber getZtytumitateriritu() {
        return ztytumitateriritu;
    }

    public void setZtytumitateriritu(BizNumber pZtytumitateriritu) {
        ztytumitateriritu = pZtytumitateriritu;
    }

    private BizNumber ztysrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZtysrkyksjkkktyouseiriritu() {
        return ztysrkyksjkkktyouseiriritu;
    }

    public void setZtysrkyksjkkktyouseiriritu(BizNumber pZtysrkyksjkkktyouseiriritu) {
        ztysrkyksjkkktyouseiriritu = pZtysrkyksjkkktyouseiriritu;
    }

    private Long ztyenkdtsbujsitihsyukngk;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYENKDTSBUJSITIHSYUKNGK)
    public Long getZtyenkdtsbujsitihsyukngk() {
        return ztyenkdtsbujsitihsyukngk;
    }

    public void setZtyenkdtsbujsitihsyukngk(Long pZtyenkdtsbujsitihsyukngk) {
        ztyenkdtsbujsitihsyukngk = pZtyenkdtsbujsitihsyukngk;
    }

    private String ztykaigomaebaraitkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKAIGOMAEBARAITKYKARIHYJ)
    public String getZtykaigomaebaraitkykarihyj() {
        return ztykaigomaebaraitkykarihyj;
    }

    public void setZtykaigomaebaraitkykarihyj(String pZtykaigomaebaraitkykarihyj) {
        ztykaigomaebaraitkykarihyj = pZtykaigomaebaraitkykarihyj;
    }

    private String ztysuuriyouyobin1;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSUURIYOUYOBIN1)
    public String getZtysuuriyouyobin1() {
        return ztysuuriyouyobin1;
    }

    public void setZtysuuriyouyobin1(String pZtysuuriyouyobin1) {
        ztysuuriyouyobin1 = pZtysuuriyouyobin1;
    }

    private String ztysibouhyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSIBOUHYOUKBN)
    public String getZtysibouhyoukbn() {
        return ztysibouhyoukbn;
    }

    public void setZtysibouhyoukbn(String pZtysibouhyoukbn) {
        ztysibouhyoukbn = pZtysibouhyoukbn;
    }

    private BizNumber ztymvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYMVATYOUSEIKOU)
    public BizNumber getZtymvatyouseikou() {
        return ztymvatyouseikou;
    }

    public void setZtymvatyouseikou(BizNumber pZtymvatyouseikou) {
        ztymvatyouseikou = pZtymvatyouseikou;
    }

    private String ztynyuukintuukakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYNYUUKINTUUKAKBN)
    public String getZtynyuukintuukakbn() {
        return ztynyuukintuukakbn;
    }

    public void setZtynyuukintuukakbn(String pZtynyuukintuukakbn) {
        ztynyuukintuukakbn = pZtynyuukintuukakbn;
    }

    private String ztyhtnknkykliveonearhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYHTNKNKYKLIVEONEARHYJ)
    public String getZtyhtnknkykliveonearhyj() {
        return ztyhtnknkykliveonearhyj;
    }

    public void setZtyhtnknkykliveonearhyj(String pZtyhtnknkykliveonearhyj) {
        ztyhtnknkykliveonearhyj = pZtyhtnknkykliveonearhyj;
    }

    private String ztyliveonepackagesyouhinkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYLIVEONEPACKAGESYOUHINKBN)
    public String getZtyliveonepackagesyouhinkbn() {
        return ztyliveonepackagesyouhinkbn;
    }

    public void setZtyliveonepackagesyouhinkbn(String pZtyliveonepackagesyouhinkbn) {
        ztyliveonepackagesyouhinkbn = pZtyliveonepackagesyouhinkbn;
    }

    private Long ztyhtnkngukisisttkknsnp;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYHTNKNGUKISISTTKKNSNP)
    public Long getZtyhtnkngukisisttkknsnp() {
        return ztyhtnkngukisisttkknsnp;
    }

    public void setZtyhtnkngukisisttkknsnp(Long pZtyhtnkngukisisttkknsnp) {
        ztyhtnkngukisisttkknsnp = pZtyhtnkngukisisttkknsnp;
    }

    private String ztywyendttargetmokuhyouritu;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYWYENDTTARGETMOKUHYOURITU)
    public String getZtywyendttargetmokuhyouritu() {
        return ztywyendttargetmokuhyouritu;
    }

    public void setZtywyendttargetmokuhyouritu(String pZtywyendttargetmokuhyouritu) {
        ztywyendttargetmokuhyouritu = pZtywyendttargetmokuhyouritu;
    }

    private String ztysisuurendourate;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSISUURENDOURATE)
    public String getZtysisuurendourate() {
        return ztysisuurendourate;
    }

    public void setZtysisuurendourate(String pZtysisuurendourate) {
        ztysisuurendourate = pZtysisuurendourate;
    }

    private String ztysisuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSISUUKBN)
    public String getZtysisuukbn() {
        return ztysisuukbn;
    }

    public void setZtysisuukbn(String pZtysisuukbn) {
        ztysisuukbn = pZtysisuukbn;
    }

    private String ztysrdai1hknkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSRDAI1HKNKKN)
    public String getZtysrdai1hknkkn() {
        return ztysrdai1hknkkn;
    }

    public void setZtysrdai1hknkkn(String pZtysrdai1hknkkn) {
        ztysrdai1hknkkn = pZtysrdai1hknkkn;
    }

    private String ztysuuriyouyobin10x2;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSUURIYOUYOBIN10X2)
    public String getZtysuuriyouyobin10x2() {
        return ztysuuriyouyobin10x2;
    }

    public void setZtysuuriyouyobin10x2(String pZtysuuriyouyobin10x2) {
        ztysuuriyouyobin10x2 = pZtysuuriyouyobin10x2;
    }

    private String ztysuuriyouyobin10x3;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSUURIYOUYOBIN10X3)
    public String getZtysuuriyouyobin10x3() {
        return ztysuuriyouyobin10x3;
    }

    public void setZtysuuriyouyobin10x3(String pZtysuuriyouyobin10x3) {
        ztysuuriyouyobin10x3 = pZtysuuriyouyobin10x3;
    }

    private BizNumber ztytmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYTMTTKNZOUKARITUJYGN)
    public BizNumber getZtytmttknzoukaritujygn() {
        return ztytmttknzoukaritujygn;
    }

    public void setZtytmttknzoukaritujygn(BizNumber pZtytmttknzoukaritujygn) {
        ztytmttknzoukaritujygn = pZtytmttknzoukaritujygn;
    }

    private BizNumber ztysetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSETTEIBAIRITU)
    public BizNumber getZtysetteibairitu() {
        return ztysetteibairitu;
    }

    public void setZtysetteibairitu(BizNumber pZtysetteibairitu) {
        ztysetteibairitu = pZtysetteibairitu;
    }

    private BizNumber ztykykymdsisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKYKYMDSISUU)
    public BizNumber getZtykykymdsisuu() {
        return ztykykymdsisuu;
    }

    public void setZtykykymdsisuu(BizNumber pZtykykymdsisuu) {
        ztykykymdsisuu = pZtykykymdsisuu;
    }

    private BizNumber ztyrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYRENDOURITU)
    public BizNumber getZtyrendouritu() {
        return ztyrendouritu;
    }

    public void setZtyrendouritu(BizNumber pZtyrendouritu) {
        ztyrendouritu = pZtyrendouritu;
    }

    private Integer ztyyobin5;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYYOBIN5)
    public Integer getZtyyobin5() {
        return ztyyobin5;
    }

    public void setZtyyobin5(Integer pZtyyobin5) {
        ztyyobin5 = pZtyyobin5;
    }

    private Integer ztyyobin5x2;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYYOBIN5X2)
    public Integer getZtyyobin5x2() {
        return ztyyobin5x2;
    }

    public void setZtyyobin5x2(Integer pZtyyobin5x2) {
        ztyyobin5x2 = pZtyyobin5x2;
    }

    private String ztytuukasyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYTUUKASYUKBN)
    public String getZtytuukasyukbn() {
        return ztytuukasyukbn;
    }

    public void setZtytuukasyukbn(String pZtytuukasyukbn) {
        ztytuukasyukbn = pZtytuukasyukbn;
    }

    private String ztyyobiv9x2;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYYOBIV9X2)
    public String getZtyyobiv9x2() {
        return ztyyobiv9x2;
    }

    public void setZtyyobiv9x2(String pZtyyobiv9x2) {
        ztyyobiv9x2 = pZtyyobiv9x2;
    }

    private Long ztyyendttargetkijyunkingaku;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYYENDTTARGETKIJYUNKINGAKU)
    public Long getZtyyendttargetkijyunkingaku() {
        return ztyyendttargetkijyunkingaku;
    }

    public void setZtyyendttargetkijyunkingaku(Long pZtyyendttargetkijyunkingaku) {
        ztyyendttargetkijyunkingaku = pZtyyendttargetkijyunkingaku;
    }

    private Long ztysisuurentumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSISUURENTUMITATEKIN)
    public Long getZtysisuurentumitatekin() {
        return ztysisuurentumitatekin;
    }

    public void setZtysisuurentumitatekin(Long pZtysisuurentumitatekin) {
        ztysisuurentumitatekin = pZtysisuurentumitatekin;
    }

    private Long ztytirttmtttumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYTIRTTMTTTUMITATEKIN)
    public Long getZtytirttmtttumitatekin() {
        return ztytirttmtttumitatekin;
    }

    public void setZtytirttmtttumitatekin(Long pZtytirttmtttumitatekin) {
        ztytirttmtttumitatekin = pZtytirttmtttumitatekin;
    }

    private Long ztynksjitirttmttkn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYNKSJITIRTTMTTKN)
    public Long getZtynksjitirttmttkn() {
        return ztynksjitirttmttkn;
    }

    public void setZtynksjitirttmttkn(Long pZtynksjitirttmttkn) {
        ztynksjitirttmttkn = pZtynksjitirttmttkn;
    }

    private Long ztynendomatutirttumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYNENDOMATUTIRTTUMITATEKIN)
    public Long getZtynendomatutirttumitatekin() {
        return ztynendomatutirttumitatekin;
    }

    public void setZtynendomatutirttumitatekin(Long pZtynendomatutirttumitatekin) {
        ztynendomatutirttumitatekin = pZtynendomatutirttumitatekin;
    }

    private Long ztysyuptumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSYUPTUMITATEKIN)
    public Long getZtysyuptumitatekin() {
        return ztysyuptumitatekin;
    }

    public void setZtysyuptumitatekin(Long pZtysyuptumitatekin) {
        ztysyuptumitatekin = pZtysyuptumitatekin;
    }

    private Long ztygaikadatenkgns;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYGAIKADATENKGNS)
    public Long getZtygaikadatenkgns() {
        return ztygaikadatenkgns;
    }

    public void setZtygaikadatenkgns(Long pZtygaikadatenkgns) {
        ztygaikadatenkgns = pZtygaikadatenkgns;
    }

    private Long ztytumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYTUMITATEKIN)
    public Long getZtytumitatekin() {
        return ztytumitatekin;
    }

    public void setZtytumitatekin(Long pZtytumitatekin) {
        ztytumitatekin = pZtytumitatekin;
    }

    private Long ztykiharaikomip;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYKIHARAIKOMIP)
    public Long getZtykiharaikomip() {
        return ztykiharaikomip;
    }

    public void setZtykiharaikomip(Long pZtykiharaikomip) {
        ztykiharaikomip = pZtykiharaikomip;
    }

    private Long ztygaikadatesyukeiyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYGAIKADATESYUKEIYAKUP)
    public Long getZtygaikadatesyukeiyakup() {
        return ztygaikadatesyukeiyakup;
    }

    public void setZtygaikadatesyukeiyakup(Long pZtygaikadatesyukeiyakup) {
        ztygaikadatesyukeiyakup = pZtygaikadatesyukeiyakup;
    }

    private BizNumber ztysitivkisnyukykjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYSITIVKISNYUKYKJIKWSRATE)
    public BizNumber getZtysitivkisnyukykjikwsrate() {
        return ztysitivkisnyukykjikwsrate;
    }

    public void setZtysitivkisnyukykjikwsrate(BizNumber pZtysitivkisnyukykjikwsrate) {
        ztysitivkisnyukykjikwsrate = pZtysitivkisnyukykjikwsrate;
    }

    private String ztyyobiv16;

    @Column(name=GenZT_Skeiksnbsgetujisr6Ty.ZTYYOBIV16)
    public String getZtyyobiv16() {
        return ztyyobiv16;
    }

    public void setZtyyobiv16(String pZtyyobiv16) {
        ztyyobiv16 = pZtyyobiv16;
    }
}