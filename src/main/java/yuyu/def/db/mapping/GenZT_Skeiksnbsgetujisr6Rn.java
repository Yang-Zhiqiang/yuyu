package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.ZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.id.PKZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.GenQZT_Skeiksnbsgetujisr6Rn;
import yuyu.def.db.meta.QZT_Skeiksnbsgetujisr6Rn;

/**
 * 新契約決算ベース月次成立Ｆテーブル６（連） テーブルのマッピング情報クラスで、 {@link ZT_Skeiksnbsgetujisr6Rn} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_Skeiksnbsgetujisr6Rn}</td><td colspan="3">新契約決算ベース月次成立Ｆテーブル６（連）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getZrnktgysyrymd zrnktgysyrymd}</td><td>（連携用）結合用処理日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgysyono zrnktgysyono}</td><td>（連携用）結合用証券番号</td><td align="center">{@link PKZT_Skeiksnbsgetujisr6Rn ○}</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnktgyfilerenno zrnktgyfilerenno}</td><td>（連携用）結合用ファイル連番</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnraysystemhyj zrnraysystemhyj}</td><td>（連携用）ＲＡＹシステム表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrngaikakbn zrngaikakbn}</td><td>（連携用）外貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkawaserate zrnkawaserate}</td><td>（連携用）為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkawaseratetekiyouymd zrnkawaseratetekiyouymd}</td><td>（連携用）為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaserate zrnkykjikawaserate}</td><td>（連携用）契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykjikawaseratetkyuymd zrnkykjikawaseratetkyuymd}</td><td>（連携用）契約時為替レート適用年月日</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnkeiyakujiyoteiriritu zrnkeiyakujiyoteiriritu}</td><td>（連携用）契約時予定利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrntumitateriritu zrntumitateriritu}</td><td>（連携用）積立利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsrkyksjkkktyouseiriritu zrnsrkyksjkkktyouseiriritu}</td><td>（連携用）数理用契約時市場価格調整用利率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnenkdtsbujsitihsyukngk zrnenkdtsbujsitihsyukngk}</td><td>（連携用）円貨建死亡時最低保証金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkaigomaebaraitkykarihyj zrnkaigomaebaraitkykarihyj}</td><td>（連携用）介護前払特約あり表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin1 zrnsuuriyouyobin1}</td><td>（連携用）数理用予備項目Ｎ１</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsibouhyoukbn zrnsibouhyoukbn}</td><td>（連携用）死亡表区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnmvatyouseikou zrnmvatyouseikou}</td><td>（連携用）ＭＶＡ調整項</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnnyuukintuukakbn zrnnyuukintuukakbn}</td><td>（連携用）入金通貨区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnknkykliveonearhyj zrnhtnknkykliveonearhyj}</td><td>（連携用）被転換契約ライブワン有表示</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnliveonepackagesyouhinkbn zrnliveonepackagesyouhinkbn}</td><td>（連携用）ライブワンパッケージ商品区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnhtnkngukisisttkknsnp zrnhtnkngukisisttkknsnp}</td><td>（連携用）被転換合計災疾月換算Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnwyendttargetmokuhyouritu zrnwyendttargetmokuhyouritu}</td><td>（連携用）円建Ｗターゲット目標率</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuurendourate zrnsisuurendourate}</td><td>（連携用）指数連動部分割合</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsisuukbn zrnsisuukbn}</td><td>（連携用）指数区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsrdai1hknkkn zrnsrdai1hknkkn}</td><td>（連携用）数理用第１保険期間</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x2 zrnsuuriyouyobin10x2}</td><td>（連携用）数理用予備項目Ｎ１０＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnsuuriyouyobin10x3 zrnsuuriyouyobin10x3}</td><td>（連携用）数理用予備項目Ｎ１０＿３</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrntmttknzoukaritujygn zrntmttknzoukaritujygn}</td><td>（連携用）積立金増加率上限</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnsetteibairitu zrnsetteibairitu}</td><td>（連携用）設定倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnkykymdsisuu zrnkykymdsisuu}</td><td>（連携用）契約日指数</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnrendouritu zrnrendouritu}</td><td>（連携用）連動率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobin5 zrnyobin5}</td><td>（連携用）予備項目Ｎ５</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrnyobin5x2 zrnyobin5x2}</td><td>（連携用）予備項目Ｎ５＿２</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getZrntuukasyukbn zrntuukasyukbn}</td><td>（連携用）通貨種類区分</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyobiv9x2 zrnyobiv9x2}</td><td>（連携用）予備項目Ｖ９＿２</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 *  <tr><td>{@link #getZrnyendttargetkijyunkingaku zrnyendttargetkijyunkingaku}</td><td>（連携用）円建ターゲット基準金額</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsisuurentumitatekin zrnsisuurentumitatekin}</td><td>（連携用）指数連動部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntirttmtttumitatekin zrntirttmtttumitatekin}</td><td>（連携用）定率積立部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnksjitirttmttkn zrnnksjitirttmttkn}</td><td>（連携用）年金開始時定率積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnnendomatutirttumitatekin zrnnendomatutirttumitatekin}</td><td>（連携用）年度末定率部分積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsyuptumitatekin zrnsyuptumitatekin}</td><td>（連携用）主契約保険料積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatenkgns zrngaikadatenkgns}</td><td>（連携用）外貨建年金原資</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrntumitatekin zrntumitatekin}</td><td>（連携用）積立金</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnkiharaikomip zrnkiharaikomip}</td><td>（連携用）既払込Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrngaikadatesyukeiyakup zrngaikadatesyukeiyakup}</td><td>（連携用）外貨建主契約Ｐ</td><td align="center">&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>{@link #getZrnsitivkisnyukykjikwsrate zrnsitivkisnyukykjikwsrate}</td><td>（連携用）最低Ｖ計算用契約時為替レート</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getZrnyobiv16 zrnyobiv16}</td><td>（連携用）予備項目Ｖ１６</td><td align="center">&nbsp;</td><td align="center">C</td><td>String</td></tr>
 * </table>
 * @see     ZT_Skeiksnbsgetujisr6Rn
 * @see     PKZT_Skeiksnbsgetujisr6Rn
 * @see     QZT_Skeiksnbsgetujisr6Rn
 * @see     GenQZT_Skeiksnbsgetujisr6Rn
 */
@MappedSuperclass
@Table(name=GenZT_Skeiksnbsgetujisr6Rn.TABLE_NAME)
@IdClass(value=PKZT_Skeiksnbsgetujisr6Rn.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class)
})
public abstract class GenZT_Skeiksnbsgetujisr6Rn extends AbstractExDBEntityForZDB<ZT_Skeiksnbsgetujisr6Rn, PKZT_Skeiksnbsgetujisr6Rn> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ZT_Skeiksnbsgetujisr6Rn";
    public static final String ZRNKTGYSYRYMD            = "zrnktgysyrymd";
    public static final String ZRNKTGYSYONO             = "zrnktgysyono";
    public static final String ZRNKTGYFILERENNO         = "zrnktgyfilerenno";
    public static final String ZRNRAYSYSTEMHYJ          = "zrnraysystemhyj";
    public static final String ZRNGAIKAKBN              = "zrngaikakbn";
    public static final String ZRNKAWASERATE            = "zrnkawaserate";
    public static final String ZRNKAWASERATETEKIYOUYMD  = "zrnkawaseratetekiyouymd";
    public static final String ZRNKYKJIKAWASERATE       = "zrnkykjikawaserate";
    public static final String ZRNKYKJIKAWASERATETKYUYMD = "zrnkykjikawaseratetkyuymd";
    public static final String ZRNKEIYAKUJIYOTEIRIRITU  = "zrnkeiyakujiyoteiriritu";
    public static final String ZRNTUMITATERIRITU        = "zrntumitateriritu";
    public static final String ZRNSRKYKSJKKKTYOUSEIRIRITU = "zrnsrkyksjkkktyouseiriritu";
    public static final String ZRNENKDTSBUJSITIHSYUKNGK = "zrnenkdtsbujsitihsyukngk";
    public static final String ZRNKAIGOMAEBARAITKYKARIHYJ = "zrnkaigomaebaraitkykarihyj";
    public static final String ZRNSUURIYOUYOBIN1        = "zrnsuuriyouyobin1";
    public static final String ZRNSIBOUHYOUKBN          = "zrnsibouhyoukbn";
    public static final String ZRNMVATYOUSEIKOU         = "zrnmvatyouseikou";
    public static final String ZRNNYUUKINTUUKAKBN       = "zrnnyuukintuukakbn";
    public static final String ZRNHTNKNKYKLIVEONEARHYJ  = "zrnhtnknkykliveonearhyj";
    public static final String ZRNLIVEONEPACKAGESYOUHINKBN = "zrnliveonepackagesyouhinkbn";
    public static final String ZRNHTNKNGUKISISTTKKNSNP  = "zrnhtnkngukisisttkknsnp";
    public static final String ZRNWYENDTTARGETMOKUHYOURITU = "zrnwyendttargetmokuhyouritu";
    public static final String ZRNSISUURENDOURATE       = "zrnsisuurendourate";
    public static final String ZRNSISUUKBN              = "zrnsisuukbn";
    public static final String ZRNSRDAI1HKNKKN          = "zrnsrdai1hknkkn";
    public static final String ZRNSUURIYOUYOBIN10X2     = "zrnsuuriyouyobin10x2";
    public static final String ZRNSUURIYOUYOBIN10X3     = "zrnsuuriyouyobin10x3";
    public static final String ZRNTMTTKNZOUKARITUJYGN   = "zrntmttknzoukaritujygn";
    public static final String ZRNSETTEIBAIRITU         = "zrnsetteibairitu";
    public static final String ZRNKYKYMDSISUU           = "zrnkykymdsisuu";
    public static final String ZRNRENDOURITU            = "zrnrendouritu";
    public static final String ZRNYOBIN5                = "zrnyobin5";
    public static final String ZRNYOBIN5X2              = "zrnyobin5x2";
    public static final String ZRNTUUKASYUKBN           = "zrntuukasyukbn";
    public static final String ZRNYOBIV9X2              = "zrnyobiv9x2";
    public static final String ZRNYENDTTARGETKIJYUNKINGAKU = "zrnyendttargetkijyunkingaku";
    public static final String ZRNSISUURENTUMITATEKIN   = "zrnsisuurentumitatekin";
    public static final String ZRNTIRTTMTTTUMITATEKIN   = "zrntirttmtttumitatekin";
    public static final String ZRNNKSJITIRTTMTTKN       = "zrnnksjitirttmttkn";
    public static final String ZRNNENDOMATUTIRTTUMITATEKIN = "zrnnendomatutirttumitatekin";
    public static final String ZRNSYUPTUMITATEKIN       = "zrnsyuptumitatekin";
    public static final String ZRNGAIKADATENKGNS        = "zrngaikadatenkgns";
    public static final String ZRNTUMITATEKIN           = "zrntumitatekin";
    public static final String ZRNKIHARAIKOMIP          = "zrnkiharaikomip";
    public static final String ZRNGAIKADATESYUKEIYAKUP  = "zrngaikadatesyukeiyakup";
    public static final String ZRNSITIVKISNYUKYKJIKWSRATE = "zrnsitivkisnyukykjikwsrate";
    public static final String ZRNYOBIV16               = "zrnyobiv16";

    private final PKZT_Skeiksnbsgetujisr6Rn primaryKey;

    public GenZT_Skeiksnbsgetujisr6Rn() {
        primaryKey = new PKZT_Skeiksnbsgetujisr6Rn();
    }

    public GenZT_Skeiksnbsgetujisr6Rn(String pZrnktgysyono) {
        primaryKey = new PKZT_Skeiksnbsgetujisr6Rn(pZrnktgysyono);
    }

    @Transient
    @Override
    public PKZT_Skeiksnbsgetujisr6Rn getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QZT_Skeiksnbsgetujisr6Rn> getMetaClass() {
        return QZT_Skeiksnbsgetujisr6Rn.class;
    }

    private String zrnktgysyrymd;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKTGYSYRYMD)
    public String getZrnktgysyrymd() {
        return zrnktgysyrymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnktgysyrymd(String pZrnktgysyrymd) {
        zrnktgysyrymd = pZrnktgysyrymd;
    }

    @Id
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKTGYSYONO)
    public String getZrnktgysyono() {
        return getPrimaryKey().getZrnktgysyono();
    }

    @Padding(mode = "left", padChar = '0', length = 11)
    public void setZrnktgysyono(String pZrnktgysyono) {
        getPrimaryKey().setZrnktgysyono(pZrnktgysyono);
    }

    private String zrnktgyfilerenno;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKTGYFILERENNO)
    public String getZrnktgyfilerenno() {
        return zrnktgyfilerenno;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnktgyfilerenno(String pZrnktgyfilerenno) {
        zrnktgyfilerenno = pZrnktgyfilerenno;
    }

    private String zrnraysystemhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNRAYSYSTEMHYJ)
    public String getZrnraysystemhyj() {
        return zrnraysystemhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnraysystemhyj(String pZrnraysystemhyj) {
        zrnraysystemhyj = pZrnraysystemhyj;
    }

    private String zrngaikakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNGAIKAKBN)
    public String getZrngaikakbn() {
        return zrngaikakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrngaikakbn(String pZrngaikakbn) {
        zrngaikakbn = pZrngaikakbn;
    }

    private BizNumber zrnkawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKAWASERATE)
    public BizNumber getZrnkawaserate() {
        return zrnkawaserate;
    }

    public void setZrnkawaserate(BizNumber pZrnkawaserate) {
        zrnkawaserate = pZrnkawaserate;
    }

    private String zrnkawaseratetekiyouymd;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKAWASERATETEKIYOUYMD)
    public String getZrnkawaseratetekiyouymd() {
        return zrnkawaseratetekiyouymd;
    }

    public void setZrnkawaseratetekiyouymd(String pZrnkawaseratetekiyouymd) {
        zrnkawaseratetekiyouymd = pZrnkawaseratetekiyouymd;
    }

    private BizNumber zrnkykjikawaserate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKYKJIKAWASERATE)
    public BizNumber getZrnkykjikawaserate() {
        return zrnkykjikawaserate;
    }

    public void setZrnkykjikawaserate(BizNumber pZrnkykjikawaserate) {
        zrnkykjikawaserate = pZrnkykjikawaserate;
    }

    private String zrnkykjikawaseratetkyuymd;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKYKJIKAWASERATETKYUYMD)
    public String getZrnkykjikawaseratetkyuymd() {
        return zrnkykjikawaseratetkyuymd;
    }

    @Padding(mode = "left", padChar = '0', length = 8)
    public void setZrnkykjikawaseratetkyuymd(String pZrnkykjikawaseratetkyuymd) {
        zrnkykjikawaseratetkyuymd = pZrnkykjikawaseratetkyuymd;
    }

    private BizNumber zrnkeiyakujiyoteiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKEIYAKUJIYOTEIRIRITU)
    public BizNumber getZrnkeiyakujiyoteiriritu() {
        return zrnkeiyakujiyoteiriritu;
    }

    public void setZrnkeiyakujiyoteiriritu(BizNumber pZrnkeiyakujiyoteiriritu) {
        zrnkeiyakujiyoteiriritu = pZrnkeiyakujiyoteiriritu;
    }

    private BizNumber zrntumitateriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNTUMITATERIRITU)
    public BizNumber getZrntumitateriritu() {
        return zrntumitateriritu;
    }

    public void setZrntumitateriritu(BizNumber pZrntumitateriritu) {
        zrntumitateriritu = pZrntumitateriritu;
    }

    private BizNumber zrnsrkyksjkkktyouseiriritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSRKYKSJKKKTYOUSEIRIRITU)
    public BizNumber getZrnsrkyksjkkktyouseiriritu() {
        return zrnsrkyksjkkktyouseiriritu;
    }

    public void setZrnsrkyksjkkktyouseiriritu(BizNumber pZrnsrkyksjkkktyouseiriritu) {
        zrnsrkyksjkkktyouseiriritu = pZrnsrkyksjkkktyouseiriritu;
    }

    private Long zrnenkdtsbujsitihsyukngk;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNENKDTSBUJSITIHSYUKNGK)
    public Long getZrnenkdtsbujsitihsyukngk() {
        return zrnenkdtsbujsitihsyukngk;
    }

    public void setZrnenkdtsbujsitihsyukngk(Long pZrnenkdtsbujsitihsyukngk) {
        zrnenkdtsbujsitihsyukngk = pZrnenkdtsbujsitihsyukngk;
    }

    private String zrnkaigomaebaraitkykarihyj;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKAIGOMAEBARAITKYKARIHYJ)
    public String getZrnkaigomaebaraitkykarihyj() {
        return zrnkaigomaebaraitkykarihyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnkaigomaebaraitkykarihyj(String pZrnkaigomaebaraitkykarihyj) {
        zrnkaigomaebaraitkykarihyj = pZrnkaigomaebaraitkykarihyj;
    }

    private String zrnsuuriyouyobin1;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSUURIYOUYOBIN1)
    public String getZrnsuuriyouyobin1() {
        return zrnsuuriyouyobin1;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnsuuriyouyobin1(String pZrnsuuriyouyobin1) {
        zrnsuuriyouyobin1 = pZrnsuuriyouyobin1;
    }

    private String zrnsibouhyoukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSIBOUHYOUKBN)
    public String getZrnsibouhyoukbn() {
        return zrnsibouhyoukbn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsibouhyoukbn(String pZrnsibouhyoukbn) {
        zrnsibouhyoukbn = pZrnsibouhyoukbn;
    }

    private BizNumber zrnmvatyouseikou;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNMVATYOUSEIKOU)
    public BizNumber getZrnmvatyouseikou() {
        return zrnmvatyouseikou;
    }

    public void setZrnmvatyouseikou(BizNumber pZrnmvatyouseikou) {
        zrnmvatyouseikou = pZrnmvatyouseikou;
    }

    private String zrnnyuukintuukakbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNNYUUKINTUUKAKBN)
    public String getZrnnyuukintuukakbn() {
        return zrnnyuukintuukakbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnnyuukintuukakbn(String pZrnnyuukintuukakbn) {
        zrnnyuukintuukakbn = pZrnnyuukintuukakbn;
    }

    private String zrnhtnknkykliveonearhyj;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNHTNKNKYKLIVEONEARHYJ)
    public String getZrnhtnknkykliveonearhyj() {
        return zrnhtnknkykliveonearhyj;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnhtnknkykliveonearhyj(String pZrnhtnknkykliveonearhyj) {
        zrnhtnknkykliveonearhyj = pZrnhtnknkykliveonearhyj;
    }

    private String zrnliveonepackagesyouhinkbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNLIVEONEPACKAGESYOUHINKBN)
    public String getZrnliveonepackagesyouhinkbn() {
        return zrnliveonepackagesyouhinkbn;
    }

    @Padding(mode = "left", padChar = '0', length = 1)
    public void setZrnliveonepackagesyouhinkbn(String pZrnliveonepackagesyouhinkbn) {
        zrnliveonepackagesyouhinkbn = pZrnliveonepackagesyouhinkbn;
    }

    private Long zrnhtnkngukisisttkknsnp;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNHTNKNGUKISISTTKKNSNP)
    public Long getZrnhtnkngukisisttkknsnp() {
        return zrnhtnkngukisisttkknsnp;
    }

    public void setZrnhtnkngukisisttkknsnp(Long pZrnhtnkngukisisttkknsnp) {
        zrnhtnkngukisisttkknsnp = pZrnhtnkngukisisttkknsnp;
    }

    private String zrnwyendttargetmokuhyouritu;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNWYENDTTARGETMOKUHYOURITU)
    public String getZrnwyendttargetmokuhyouritu() {
        return zrnwyendttargetmokuhyouritu;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnwyendttargetmokuhyouritu(String pZrnwyendttargetmokuhyouritu) {
        zrnwyendttargetmokuhyouritu = pZrnwyendttargetmokuhyouritu;
    }

    private String zrnsisuurendourate;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSISUURENDOURATE)
    public String getZrnsisuurendourate() {
        return zrnsisuurendourate;
    }

    @Padding(mode = "left", padChar = '0', length = 3)
    public void setZrnsisuurendourate(String pZrnsisuurendourate) {
        zrnsisuurendourate = pZrnsisuurendourate;
    }

    private String zrnsisuukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSISUUKBN)
    public String getZrnsisuukbn() {
        return zrnsisuukbn;
    }

    public void setZrnsisuukbn(String pZrnsisuukbn) {
        zrnsisuukbn = pZrnsisuukbn;
    }

    private String zrnsrdai1hknkkn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSRDAI1HKNKKN)
    public String getZrnsrdai1hknkkn() {
        return zrnsrdai1hknkkn;
    }

    @Padding(mode = "left", padChar = '0', length = 2)
    public void setZrnsrdai1hknkkn(String pZrnsrdai1hknkkn) {
        zrnsrdai1hknkkn = pZrnsrdai1hknkkn;
    }

    private String zrnsuuriyouyobin10x2;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSUURIYOUYOBIN10X2)
    public String getZrnsuuriyouyobin10x2() {
        return zrnsuuriyouyobin10x2;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x2(String pZrnsuuriyouyobin10x2) {
        zrnsuuriyouyobin10x2 = pZrnsuuriyouyobin10x2;
    }

    private String zrnsuuriyouyobin10x3;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSUURIYOUYOBIN10X3)
    public String getZrnsuuriyouyobin10x3() {
        return zrnsuuriyouyobin10x3;
    }

    @Padding(mode = "left", padChar = '0', length = 10)
    public void setZrnsuuriyouyobin10x3(String pZrnsuuriyouyobin10x3) {
        zrnsuuriyouyobin10x3 = pZrnsuuriyouyobin10x3;
    }

    private BizNumber zrntmttknzoukaritujygn;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNTMTTKNZOUKARITUJYGN)
    public BizNumber getZrntmttknzoukaritujygn() {
        return zrntmttknzoukaritujygn;
    }

    public void setZrntmttknzoukaritujygn(BizNumber pZrntmttknzoukaritujygn) {
        zrntmttknzoukaritujygn = pZrntmttknzoukaritujygn;
    }

    private BizNumber zrnsetteibairitu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSETTEIBAIRITU)
    public BizNumber getZrnsetteibairitu() {
        return zrnsetteibairitu;
    }

    public void setZrnsetteibairitu(BizNumber pZrnsetteibairitu) {
        zrnsetteibairitu = pZrnsetteibairitu;
    }

    private BizNumber zrnkykymdsisuu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKYKYMDSISUU)
    public BizNumber getZrnkykymdsisuu() {
        return zrnkykymdsisuu;
    }

    public void setZrnkykymdsisuu(BizNumber pZrnkykymdsisuu) {
        zrnkykymdsisuu = pZrnkykymdsisuu;
    }

    private BizNumber zrnrendouritu;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNRENDOURITU)
    public BizNumber getZrnrendouritu() {
        return zrnrendouritu;
    }

    public void setZrnrendouritu(BizNumber pZrnrendouritu) {
        zrnrendouritu = pZrnrendouritu;
    }

    private Integer zrnyobin5;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNYOBIN5)
    public Integer getZrnyobin5() {
        return zrnyobin5;
    }

    public void setZrnyobin5(Integer pZrnyobin5) {
        zrnyobin5 = pZrnyobin5;
    }

    private Integer zrnyobin5x2;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNYOBIN5X2)
    public Integer getZrnyobin5x2() {
        return zrnyobin5x2;
    }

    public void setZrnyobin5x2(Integer pZrnyobin5x2) {
        zrnyobin5x2 = pZrnyobin5x2;
    }

    private String zrntuukasyukbn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNTUUKASYUKBN)
    public String getZrntuukasyukbn() {
        return zrntuukasyukbn;
    }

    public void setZrntuukasyukbn(String pZrntuukasyukbn) {
        zrntuukasyukbn = pZrntuukasyukbn;
    }

    private String zrnyobiv9x2;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNYOBIV9X2)
    public String getZrnyobiv9x2() {
        return zrnyobiv9x2;
    }

    public void setZrnyobiv9x2(String pZrnyobiv9x2) {
        zrnyobiv9x2 = pZrnyobiv9x2;
    }

    private Long zrnyendttargetkijyunkingaku;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNYENDTTARGETKIJYUNKINGAKU)
    public Long getZrnyendttargetkijyunkingaku() {
        return zrnyendttargetkijyunkingaku;
    }

    public void setZrnyendttargetkijyunkingaku(Long pZrnyendttargetkijyunkingaku) {
        zrnyendttargetkijyunkingaku = pZrnyendttargetkijyunkingaku;
    }

    private Long zrnsisuurentumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSISUURENTUMITATEKIN)
    public Long getZrnsisuurentumitatekin() {
        return zrnsisuurentumitatekin;
    }

    public void setZrnsisuurentumitatekin(Long pZrnsisuurentumitatekin) {
        zrnsisuurentumitatekin = pZrnsisuurentumitatekin;
    }

    private Long zrntirttmtttumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNTIRTTMTTTUMITATEKIN)
    public Long getZrntirttmtttumitatekin() {
        return zrntirttmtttumitatekin;
    }

    public void setZrntirttmtttumitatekin(Long pZrntirttmtttumitatekin) {
        zrntirttmtttumitatekin = pZrntirttmtttumitatekin;
    }

    private Long zrnnksjitirttmttkn;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNNKSJITIRTTMTTKN)
    public Long getZrnnksjitirttmttkn() {
        return zrnnksjitirttmttkn;
    }

    public void setZrnnksjitirttmttkn(Long pZrnnksjitirttmttkn) {
        zrnnksjitirttmttkn = pZrnnksjitirttmttkn;
    }

    private Long zrnnendomatutirttumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNNENDOMATUTIRTTUMITATEKIN)
    public Long getZrnnendomatutirttumitatekin() {
        return zrnnendomatutirttumitatekin;
    }

    public void setZrnnendomatutirttumitatekin(Long pZrnnendomatutirttumitatekin) {
        zrnnendomatutirttumitatekin = pZrnnendomatutirttumitatekin;
    }

    private Long zrnsyuptumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSYUPTUMITATEKIN)
    public Long getZrnsyuptumitatekin() {
        return zrnsyuptumitatekin;
    }

    public void setZrnsyuptumitatekin(Long pZrnsyuptumitatekin) {
        zrnsyuptumitatekin = pZrnsyuptumitatekin;
    }

    private Long zrngaikadatenkgns;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNGAIKADATENKGNS)
    public Long getZrngaikadatenkgns() {
        return zrngaikadatenkgns;
    }

    public void setZrngaikadatenkgns(Long pZrngaikadatenkgns) {
        zrngaikadatenkgns = pZrngaikadatenkgns;
    }

    private Long zrntumitatekin;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNTUMITATEKIN)
    public Long getZrntumitatekin() {
        return zrntumitatekin;
    }

    public void setZrntumitatekin(Long pZrntumitatekin) {
        zrntumitatekin = pZrntumitatekin;
    }

    private Long zrnkiharaikomip;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNKIHARAIKOMIP)
    public Long getZrnkiharaikomip() {
        return zrnkiharaikomip;
    }

    public void setZrnkiharaikomip(Long pZrnkiharaikomip) {
        zrnkiharaikomip = pZrnkiharaikomip;
    }

    private Long zrngaikadatesyukeiyakup;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNGAIKADATESYUKEIYAKUP)
    public Long getZrngaikadatesyukeiyakup() {
        return zrngaikadatesyukeiyakup;
    }

    public void setZrngaikadatesyukeiyakup(Long pZrngaikadatesyukeiyakup) {
        zrngaikadatesyukeiyakup = pZrngaikadatesyukeiyakup;
    }

    private BizNumber zrnsitivkisnyukykjikwsrate;

    @Type(type="BizNumberType")
    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNSITIVKISNYUKYKJIKWSRATE)
    public BizNumber getZrnsitivkisnyukykjikwsrate() {
        return zrnsitivkisnyukykjikwsrate;
    }

    public void setZrnsitivkisnyukykjikwsrate(BizNumber pZrnsitivkisnyukykjikwsrate) {
        zrnsitivkisnyukykjikwsrate = pZrnsitivkisnyukykjikwsrate;
    }

    private String zrnyobiv16;

    @Column(name=GenZT_Skeiksnbsgetujisr6Rn.ZRNYOBIV16)
    public String getZrnyobiv16() {
        return zrnyobiv16;
    }

    public void setZrnyobiv16(String pZrnyobiv16) {
        zrnyobiv16 = pZrnyobiv16;
    }
}