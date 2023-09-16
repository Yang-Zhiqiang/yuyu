package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Rendouflg;
import yuyu.def.db.entity.HT_SmbcStyKanri;
import yuyu.def.db.id.PKHT_SmbcStyKanri;
import yuyu.def.db.meta.GenQHT_SmbcStyKanri;
import yuyu.def.db.meta.QHT_SmbcStyKanri;
import yuyu.def.db.type.UserType_C_Rendouflg;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＳＭＢＣ進捗管理テーブル テーブルのマッピング情報クラスで、 {@link HT_SmbcStyKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_SmbcStyKanri}</td><td colspan="3">ＳＭＢＣ進捗管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDatarenymd datarenymd}</td><td>データ連動日</td><td align="center">{@link PKHT_SmbcStyKanri ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDatasakuseirenno datasakuseirenno}</td><td>データ作成連番</td><td align="center">{@link PKHT_SmbcStyKanri ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRendouflg rendouflg}</td><td>連動フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Rendouflg}</td></tr>
 *  <tr><td>{@link #getSmbcdatakbn smbcdatakbn}</td><td>ＳＭＢＣ＿データ区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcdatasakuseiymd smbcdatasakuseiymd}</td><td>ＳＭＢＣ＿データ作成日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbchknkaisyacd smbchknkaisyacd}</td><td>ＳＭＢＣ＿保険会社コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcuktkkanriid smbcuktkkanriid}</td><td>ＳＭＢＣ＿受付管理ID</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihouktkzmymd smbcseihouktkzmymd}</td><td>ＳＭＢＣ＿生保受付済DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihohbymd smbcseihohbymd}</td><td>ＳＭＢＣ＿生保不備DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcbankhnkykflg smbcbankhnkykflg}</td><td>ＳＭＢＣ＿銀行返却フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihohbksyymd smbcseihohbksyymd}</td><td>ＳＭＢＣ＿生保不備解消DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihohjyttykymd smbcseihohjyttykymd}</td><td>ＳＭＢＣ＿生保報状到着DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihonyknzmymd smbcseihonyknzmymd}</td><td>ＳＭＢＣ＿生保入金済DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihosnszmymd smbcseihosnszmymd}</td><td>ＳＭＢＣ＿生保審査済DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihosyknhkkzmymd smbcseihosyknhkkzmymd}</td><td>ＳＭＢＣ＿生保証券発行済DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihosyumoku smbcseihosyumoku}</td><td>ＳＭＢＣ＿生保種目</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihosyurui smbcseihosyurui}</td><td>ＳＭＢＣ＿生保種類</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcsyono smbcsyono}</td><td>ＳＭＢＣ＿証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcsyonoedaban smbcsyonoedaban}</td><td>ＳＭＢＣ＿証券番号枝番</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcjktkflg smbcjktkflg}</td><td>ＳＭＢＣ＿条件付フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihotrksymd smbcseihotrksymd}</td><td>ＳＭＢＣ＿生保取消DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcseihohktymd smbcseihohktymd}</td><td>ＳＭＢＣ＿生保否決DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbckykseiymd smbckykseiymd}</td><td>ＳＭＢＣ＿契約者生年月日</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbckyknmkn smbckyknmkn}</td><td>ＳＭＢＣ＿契約者名（カナ）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcmosuktymd smbcmosuktymd}</td><td>ＳＭＢＣ＿申込書受付DATE</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbcmossyoriflg smbcmossyoriflg}</td><td>ＳＭＢＣ＿申込処理フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSmbckosyaareastyknr smbckosyaareastyknr}</td><td>ＳＭＢＣ＿個社領域（進捗管理）</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_SmbcStyKanri
 * @see     PKHT_SmbcStyKanri
 * @see     QHT_SmbcStyKanri
 * @see     GenQHT_SmbcStyKanri
 */
@MappedSuperclass
@Table(name=GenHT_SmbcStyKanri.TABLE_NAME)
@IdClass(value=PKHT_SmbcStyKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Rendouflg", typeClass=UserType_C_Rendouflg.class)
})
public abstract class GenHT_SmbcStyKanri extends AbstractExDBEntity<HT_SmbcStyKanri, PKHT_SmbcStyKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "HT_SmbcStyKanri";
    public static final String DATARENYMD               = "datarenymd";
    public static final String DATASAKUSEIRENNO         = "datasakuseirenno";
    public static final String SYONO                    = "syono";
    public static final String MOSNO                    = "mosno";
    public static final String RENDOUFLG                = "rendouflg";
    public static final String SMBCDATAKBN              = "smbcdatakbn";
    public static final String SMBCDATASAKUSEIYMD       = "smbcdatasakuseiymd";
    public static final String SMBCHKNKAISYACD          = "smbchknkaisyacd";
    public static final String SMBCUKTKKANRIID          = "smbcuktkkanriid";
    public static final String SMBCSEIHOUKTKZMYMD       = "smbcseihouktkzmymd";
    public static final String SMBCSEIHOHBYMD           = "smbcseihohbymd";
    public static final String SMBCBANKHNKYKFLG         = "smbcbankhnkykflg";
    public static final String SMBCSEIHOHBKSYYMD        = "smbcseihohbksyymd";
    public static final String SMBCSEIHOHJYTTYKYMD      = "smbcseihohjyttykymd";
    public static final String SMBCSEIHONYKNZMYMD       = "smbcseihonyknzmymd";
    public static final String SMBCSEIHOSNSZMYMD        = "smbcseihosnszmymd";
    public static final String SMBCSEIHOSYKNHKKZMYMD    = "smbcseihosyknhkkzmymd";
    public static final String SMBCSEIHOSYUMOKU         = "smbcseihosyumoku";
    public static final String SMBCSEIHOSYURUI          = "smbcseihosyurui";
    public static final String SMBCSYONO                = "smbcsyono";
    public static final String SMBCSYONOEDABAN          = "smbcsyonoedaban";
    public static final String SMBCJKTKFLG              = "smbcjktkflg";
    public static final String SMBCSEIHOTRKSYMD         = "smbcseihotrksymd";
    public static final String SMBCSEIHOHKTYMD          = "smbcseihohktymd";
    public static final String SMBCKYKSEIYMD            = "smbckykseiymd";
    public static final String SMBCKYKNMKN              = "smbckyknmkn";
    public static final String SMBCMOSUKTYMD            = "smbcmosuktymd";
    public static final String SMBCMOSSYORIFLG          = "smbcmossyoriflg";
    public static final String SMBCKOSYAAREASTYKNR      = "smbckosyaareastyknr";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKHT_SmbcStyKanri primaryKey;

    public GenHT_SmbcStyKanri() {
        primaryKey = new PKHT_SmbcStyKanri();
    }

    public GenHT_SmbcStyKanri(BizDate pDatarenymd, BizNumber pDatasakuseirenno) {
        primaryKey = new PKHT_SmbcStyKanri(pDatarenymd, pDatasakuseirenno);
    }

    @Transient
    @Override
    public PKHT_SmbcStyKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QHT_SmbcStyKanri> getMetaClass() {
        return QHT_SmbcStyKanri.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenHT_SmbcStyKanri.DATARENYMD)
    public BizDate getDatarenymd() {
        return getPrimaryKey().getDatarenymd();
    }

    public void setDatarenymd(BizDate pDatarenymd) {
        getPrimaryKey().setDatarenymd(pDatarenymd);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenHT_SmbcStyKanri.DATASAKUSEIRENNO)
    public BizNumber getDatasakuseirenno() {
        return getPrimaryKey().getDatasakuseirenno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setDatasakuseirenno(BizNumber pDatasakuseirenno) {
        getPrimaryKey().setDatasakuseirenno(pDatasakuseirenno);
    }

    private String syono;

    @Column(name=GenHT_SmbcStyKanri.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String mosno;

    @Column(name=GenHT_SmbcStyKanri.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private C_Rendouflg rendouflg;

    @Type(type="UserType_C_Rendouflg")
    @Column(name=GenHT_SmbcStyKanri.RENDOUFLG)
    public C_Rendouflg getRendouflg() {
        return rendouflg;
    }

    public void setRendouflg(C_Rendouflg pRendouflg) {
        rendouflg = pRendouflg;
    }

    private String smbcdatakbn;

    @Column(name=GenHT_SmbcStyKanri.SMBCDATAKBN)
    public String getSmbcdatakbn() {
        return smbcdatakbn;
    }

    public void setSmbcdatakbn(String pSmbcdatakbn) {
        smbcdatakbn = pSmbcdatakbn;
    }

    private String smbcdatasakuseiymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCDATASAKUSEIYMD)
    public String getSmbcdatasakuseiymd() {
        return smbcdatasakuseiymd;
    }

    public void setSmbcdatasakuseiymd(String pSmbcdatasakuseiymd) {
        smbcdatasakuseiymd = pSmbcdatasakuseiymd;
    }

    private String smbchknkaisyacd;

    @Column(name=GenHT_SmbcStyKanri.SMBCHKNKAISYACD)
    public String getSmbchknkaisyacd() {
        return smbchknkaisyacd;
    }

    public void setSmbchknkaisyacd(String pSmbchknkaisyacd) {
        smbchknkaisyacd = pSmbchknkaisyacd;
    }

    private String smbcuktkkanriid;

    @Column(name=GenHT_SmbcStyKanri.SMBCUKTKKANRIID)
    public String getSmbcuktkkanriid() {
        return smbcuktkkanriid;
    }

    public void setSmbcuktkkanriid(String pSmbcuktkkanriid) {
        smbcuktkkanriid = pSmbcuktkkanriid;
    }

    private String smbcseihouktkzmymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOUKTKZMYMD)
    public String getSmbcseihouktkzmymd() {
        return smbcseihouktkzmymd;
    }

    public void setSmbcseihouktkzmymd(String pSmbcseihouktkzmymd) {
        smbcseihouktkzmymd = pSmbcseihouktkzmymd;
    }

    private String smbcseihohbymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOHBYMD)
    public String getSmbcseihohbymd() {
        return smbcseihohbymd;
    }

    public void setSmbcseihohbymd(String pSmbcseihohbymd) {
        smbcseihohbymd = pSmbcseihohbymd;
    }

    private String smbcbankhnkykflg;

    @Column(name=GenHT_SmbcStyKanri.SMBCBANKHNKYKFLG)
    public String getSmbcbankhnkykflg() {
        return smbcbankhnkykflg;
    }

    public void setSmbcbankhnkykflg(String pSmbcbankhnkykflg) {
        smbcbankhnkykflg = pSmbcbankhnkykflg;
    }

    private String smbcseihohbksyymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOHBKSYYMD)
    public String getSmbcseihohbksyymd() {
        return smbcseihohbksyymd;
    }

    public void setSmbcseihohbksyymd(String pSmbcseihohbksyymd) {
        smbcseihohbksyymd = pSmbcseihohbksyymd;
    }

    private String smbcseihohjyttykymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOHJYTTYKYMD)
    public String getSmbcseihohjyttykymd() {
        return smbcseihohjyttykymd;
    }

    public void setSmbcseihohjyttykymd(String pSmbcseihohjyttykymd) {
        smbcseihohjyttykymd = pSmbcseihohjyttykymd;
    }

    private String smbcseihonyknzmymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHONYKNZMYMD)
    public String getSmbcseihonyknzmymd() {
        return smbcseihonyknzmymd;
    }

    public void setSmbcseihonyknzmymd(String pSmbcseihonyknzmymd) {
        smbcseihonyknzmymd = pSmbcseihonyknzmymd;
    }

    private String smbcseihosnszmymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOSNSZMYMD)
    public String getSmbcseihosnszmymd() {
        return smbcseihosnszmymd;
    }

    public void setSmbcseihosnszmymd(String pSmbcseihosnszmymd) {
        smbcseihosnszmymd = pSmbcseihosnszmymd;
    }

    private String smbcseihosyknhkkzmymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOSYKNHKKZMYMD)
    public String getSmbcseihosyknhkkzmymd() {
        return smbcseihosyknhkkzmymd;
    }

    public void setSmbcseihosyknhkkzmymd(String pSmbcseihosyknhkkzmymd) {
        smbcseihosyknhkkzmymd = pSmbcseihosyknhkkzmymd;
    }

    private String smbcseihosyumoku;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOSYUMOKU)
    public String getSmbcseihosyumoku() {
        return smbcseihosyumoku;
    }

    public void setSmbcseihosyumoku(String pSmbcseihosyumoku) {
        smbcseihosyumoku = pSmbcseihosyumoku;
    }

    private String smbcseihosyurui;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOSYURUI)
    public String getSmbcseihosyurui() {
        return smbcseihosyurui;
    }

    public void setSmbcseihosyurui(String pSmbcseihosyurui) {
        smbcseihosyurui = pSmbcseihosyurui;
    }

    private String smbcsyono;

    @Column(name=GenHT_SmbcStyKanri.SMBCSYONO)
    public String getSmbcsyono() {
        return smbcsyono;
    }

    public void setSmbcsyono(String pSmbcsyono) {
        smbcsyono = pSmbcsyono;
    }

    private String smbcsyonoedaban;

    @Column(name=GenHT_SmbcStyKanri.SMBCSYONOEDABAN)
    public String getSmbcsyonoedaban() {
        return smbcsyonoedaban;
    }

    public void setSmbcsyonoedaban(String pSmbcsyonoedaban) {
        smbcsyonoedaban = pSmbcsyonoedaban;
    }

    private String smbcjktkflg;

    @Column(name=GenHT_SmbcStyKanri.SMBCJKTKFLG)
    public String getSmbcjktkflg() {
        return smbcjktkflg;
    }

    public void setSmbcjktkflg(String pSmbcjktkflg) {
        smbcjktkflg = pSmbcjktkflg;
    }

    private String smbcseihotrksymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOTRKSYMD)
    public String getSmbcseihotrksymd() {
        return smbcseihotrksymd;
    }

    public void setSmbcseihotrksymd(String pSmbcseihotrksymd) {
        smbcseihotrksymd = pSmbcseihotrksymd;
    }

    private String smbcseihohktymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCSEIHOHKTYMD)
    public String getSmbcseihohktymd() {
        return smbcseihohktymd;
    }

    public void setSmbcseihohktymd(String pSmbcseihohktymd) {
        smbcseihohktymd = pSmbcseihohktymd;
    }

    private String smbckykseiymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCKYKSEIYMD)
    public String getSmbckykseiymd() {
        return smbckykseiymd;
    }

    public void setSmbckykseiymd(String pSmbckykseiymd) {
        smbckykseiymd = pSmbckykseiymd;
    }

    private String smbckyknmkn;

    @Column(name=GenHT_SmbcStyKanri.SMBCKYKNMKN)
    public String getSmbckyknmkn() {
        return smbckyknmkn;
    }

    public void setSmbckyknmkn(String pSmbckyknmkn) {
        smbckyknmkn = pSmbckyknmkn;
    }

    private String smbcmosuktymd;

    @Column(name=GenHT_SmbcStyKanri.SMBCMOSUKTYMD)
    public String getSmbcmosuktymd() {
        return smbcmosuktymd;
    }

    public void setSmbcmosuktymd(String pSmbcmosuktymd) {
        smbcmosuktymd = pSmbcmosuktymd;
    }

    private String smbcmossyoriflg;

    @Column(name=GenHT_SmbcStyKanri.SMBCMOSSYORIFLG)
    public String getSmbcmossyoriflg() {
        return smbcmossyoriflg;
    }

    public void setSmbcmossyoriflg(String pSmbcmossyoriflg) {
        smbcmossyoriflg = pSmbcmossyoriflg;
    }

    private String smbckosyaareastyknr;

    @Column(name=GenHT_SmbcStyKanri.SMBCKOSYAAREASTYKNR)
    public String getSmbckosyaareastyknr() {
        return smbckosyaareastyknr;
    }

    public void setSmbckosyaareastyknr(String pSmbckosyaareastyknr) {
        smbckosyaareastyknr = pSmbckosyaareastyknr;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenHT_SmbcStyKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenHT_SmbcStyKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenHT_SmbcStyKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}