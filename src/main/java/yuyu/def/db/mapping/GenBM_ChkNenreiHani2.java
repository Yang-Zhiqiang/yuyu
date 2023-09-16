package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.hibernate.usertype.BizNumberType;
import jp.co.slcs.swak.number.BizNumber;
import jp.co.slcs.swak.validation.constraints.Range;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_HknkknsmnKbn;
import yuyu.def.classification.C_HrkkknsmnKbn;
import yuyu.def.classification.C_KataKbn;
import yuyu.def.db.entity.BM_ChkNenreiHani2;
import yuyu.def.db.id.PKBM_ChkNenreiHani2;
import yuyu.def.db.meta.GenQBM_ChkNenreiHani2;
import yuyu.def.db.meta.QBM_ChkNenreiHani2;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_HknkknsmnKbn;
import yuyu.def.db.type.UserType_C_HrkkknsmnKbn;
import yuyu.def.db.type.UserType_C_KataKbn;

/**
 * 年齢範囲チェックマスタ２ テーブルのマッピング情報クラスで、 {@link BM_ChkNenreiHani2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkNenreiHani2}</td><td colspan="3">年齢範囲チェックマスタ２</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknseifrom hhknseifrom}</td><td>被保険者性別自</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHhknseito hhknseito}</td><td>被保険者性別至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyukatakbn syukatakbn}</td><td>主契約型区分</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>{@link C_KataKbn}</td></tr>
 *  <tr><td>{@link #getSyuhknkkn syuhknkkn}</td><td>主契約保険期間</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyuhknkknto syuhknkknto}</td><td>主契約保険期間至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyuhknkknsmnkbn syuhknkknsmnkbn}</td><td>主契約保険期間歳満期区分</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getSyuhrkkkn syuhrkkkn}</td><td>主契約払込期間</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyuhrkkknto syuhrkkknto}</td><td>主契約払込期間至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyuhrkkknsmnkbn syuhrkkknsmnkbn}</td><td>主契約払込期間歳満期区分</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getSyufromnen syufromnen}</td><td>主契約年齢自</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyutonen syutonen}</td><td>主契約年齢至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyuyoteiriritufrom syuyoteiriritufrom}</td><td>主契約予定利率自</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyuyoteirirituto syuyoteirirituto}</td><td>主契約予定利率至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getSyudai1hknkkn syudai1hknkkn}</td><td>主契約第１保険期間</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTokusyuchkno tokusyuchkno}</td><td>特殊チェック番号</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTksyouhncd tksyouhncd}</td><td>特約商品コード</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkhknkkn tkhknkkn}</td><td>特約保険期間</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTkhknkknto tkhknkknto}</td><td>特約保険期間至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkhknkknsmnkbn tkhknkknsmnkbn}</td><td>特約保険期間歳満期区分</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>{@link C_HknkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getTkhrkkkn tkhrkkkn}</td><td>特約払込期間</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTkhrkkknto tkhrkkknto}</td><td>特約払込期間至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkhrkkknsmnkbn tkhrkkknsmnkbn}</td><td>特約払込期間歳満期区分</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">V</td><td>{@link C_HrkkknsmnKbn}</td></tr>
 *  <tr><td>{@link #getTkfromnen tkfromnen}</td><td>特約年齢自</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTktonen tktonen}</td><td>特約年齢至</td><td align="center">{@link PKBM_ChkNenreiHani2 ○}</td><td align="center">N</td><td>BizNumber</td></tr>
 * </table>
 * @see     BM_ChkNenreiHani2
 * @see     PKBM_ChkNenreiHani2
 * @see     QBM_ChkNenreiHani2
 * @see     GenQBM_ChkNenreiHani2
 */
@MappedSuperclass
@Table(name=GenBM_ChkNenreiHani2.TABLE_NAME)
@IdClass(value=PKBM_ChkNenreiHani2.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_HknkknsmnKbn", typeClass=UserType_C_HknkknsmnKbn.class),
    @TypeDef(name="UserType_C_HrkkknsmnKbn", typeClass=UserType_C_HrkkknsmnKbn.class),
    @TypeDef(name="UserType_C_KataKbn", typeClass=UserType_C_KataKbn.class)
})
public abstract class GenBM_ChkNenreiHani2 extends AbstractExDBEntity<BM_ChkNenreiHani2, PKBM_ChkNenreiHani2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkNenreiHani2";
    public static final String CHANNELCD                = "channelcd";
    public static final String SYUSYOUHNCD              = "syusyouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String HHKNSEIFROM              = "hhknseifrom";
    public static final String HHKNSEITO                = "hhknseito";
    public static final String SYUKATAKBN               = "syukatakbn";
    public static final String SYUHKNKKN                = "syuhknkkn";
    public static final String SYUHKNKKNTO              = "syuhknkknto";
    public static final String SYUHKNKKNSMNKBN          = "syuhknkknsmnkbn";
    public static final String SYUHRKKKN                = "syuhrkkkn";
    public static final String SYUHRKKKNTO              = "syuhrkkknto";
    public static final String SYUHRKKKNSMNKBN          = "syuhrkkknsmnkbn";
    public static final String SYUFROMNEN               = "syufromnen";
    public static final String SYUTONEN                 = "syutonen";
    public static final String SYUYOTEIRIRITUFROM       = "syuyoteiriritufrom";
    public static final String SYUYOTEIRIRITUTO         = "syuyoteirirituto";
    public static final String SYUDAI1HKNKKN            = "syudai1hknkkn";
    public static final String TOKUSYUCHKNO             = "tokusyuchkno";
    public static final String TKSYOUHNCD               = "tksyouhncd";
    public static final String TKHKNKKN                 = "tkhknkkn";
    public static final String TKHKNKKNTO               = "tkhknkknto";
    public static final String TKHKNKKNSMNKBN           = "tkhknkknsmnkbn";
    public static final String TKHRKKKN                 = "tkhrkkkn";
    public static final String TKHRKKKNTO               = "tkhrkkknto";
    public static final String TKHRKKKNSMNKBN           = "tkhrkkknsmnkbn";
    public static final String TKFROMNEN                = "tkfromnen";
    public static final String TKTONEN                  = "tktonen";

    private final PKBM_ChkNenreiHani2 primaryKey;

    public GenBM_ChkNenreiHani2() {
        primaryKey = new PKBM_ChkNenreiHani2();
    }

    public GenBM_ChkNenreiHani2(
        C_Channelcd pChannelcd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        Integer pHhknseifrom,
        Integer pHhknseito,
        C_KataKbn pSyukatakbn,
        Integer pSyuhknkkn,
        Integer pSyuhknkknto,
        C_HknkknsmnKbn pSyuhknkknsmnkbn,
        Integer pSyuhrkkkn,
        Integer pSyuhrkkknto,
        C_HrkkknsmnKbn pSyuhrkkknsmnkbn,
        BizNumber pSyufromnen,
        BizNumber pSyutonen,
        BizNumber pSyuyoteiriritufrom,
        BizNumber pSyuyoteirirituto,
        Integer pSyudai1hknkkn,
        BizNumber pTokusyuchkno,
        String pTksyouhncd,
        BizNumber pTkhknkkn,
        Integer pTkhknkknto,
        C_HknkknsmnKbn pTkhknkknsmnkbn,
        BizNumber pTkhrkkkn,
        Integer pTkhrkkknto,
        C_HrkkknsmnKbn pTkhrkkknsmnkbn,
        BizNumber pTkfromnen,
        BizNumber pTktonen
    ) {
        primaryKey = new PKBM_ChkNenreiHani2(
            pChannelcd,
            pSyusyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pHhknseifrom,
            pHhknseito,
            pSyukatakbn,
            pSyuhknkkn,
            pSyuhknkknto,
            pSyuhknkknsmnkbn,
            pSyuhrkkkn,
            pSyuhrkkknto,
            pSyuhrkkknsmnkbn,
            pSyufromnen,
            pSyutonen,
            pSyuyoteiriritufrom,
            pSyuyoteirirituto,
            pSyudai1hknkkn,
            pTokusyuchkno,
            pTksyouhncd,
            pTkhknkkn,
            pTkhknkknto,
            pTkhknkknsmnkbn,
            pTkhrkkkn,
            pTkhrkkknto,
            pTkhrkkknsmnkbn,
            pTkfromnen,
            pTktonen
        );
    }

    @Transient
    @Override
    public PKBM_ChkNenreiHani2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkNenreiHani2> getMetaClass() {
        return QBM_ChkNenreiHani2.class;
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_ChkNenreiHani2.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUSYOUHNCD)
    public String getSyusyouhncd() {
        return getPrimaryKey().getSyusyouhncd();
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        getPrimaryKey().setSyusyouhncd(pSyusyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.HHKNSEIFROM)
    public Integer getHhknseifrom() {
        return getPrimaryKey().getHhknseifrom();
    }

    public void setHhknseifrom(Integer pHhknseifrom) {
        getPrimaryKey().setHhknseifrom(pHhknseifrom);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.HHKNSEITO)
    public Integer getHhknseito() {
        return getPrimaryKey().getHhknseito();
    }

    public void setHhknseito(Integer pHhknseito) {
        getPrimaryKey().setHhknseito(pHhknseito);
    }

    @Id
    @Type(type="UserType_C_KataKbn")
    @Column(name=GenBM_ChkNenreiHani2.SYUKATAKBN)
    public C_KataKbn getSyukatakbn() {
        return getPrimaryKey().getSyukatakbn();
    }

    public void setSyukatakbn(C_KataKbn pSyukatakbn) {
        getPrimaryKey().setSyukatakbn(pSyukatakbn);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUHKNKKN)
    @Range(min="0", max="99")
    public Integer getSyuhknkkn() {
        return getPrimaryKey().getSyuhknkkn();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuhknkkn(Integer pSyuhknkkn) {
        getPrimaryKey().setSyuhknkkn(pSyuhknkkn);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUHKNKKNTO)
    public Integer getSyuhknkknto() {
        return getPrimaryKey().getSyuhknkknto();
    }

    public void setSyuhknkknto(Integer pSyuhknkknto) {
        getPrimaryKey().setSyuhknkknto(pSyuhknkknto);
    }

    @Id
    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenBM_ChkNenreiHani2.SYUHKNKKNSMNKBN)
    public C_HknkknsmnKbn getSyuhknkknsmnkbn() {
        return getPrimaryKey().getSyuhknkknsmnkbn();
    }

    public void setSyuhknkknsmnkbn(C_HknkknsmnKbn pSyuhknkknsmnkbn) {
        getPrimaryKey().setSyuhknkknsmnkbn(pSyuhknkknsmnkbn);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUHRKKKN)
    @Range(min="0", max="99")
    public Integer getSyuhrkkkn() {
        return getPrimaryKey().getSyuhrkkkn();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyuhrkkkn(Integer pSyuhrkkkn) {
        getPrimaryKey().setSyuhrkkkn(pSyuhrkkkn);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUHRKKKNTO)
    public Integer getSyuhrkkknto() {
        return getPrimaryKey().getSyuhrkkknto();
    }

    public void setSyuhrkkknto(Integer pSyuhrkkknto) {
        getPrimaryKey().setSyuhrkkknto(pSyuhrkkknto);
    }

    @Id
    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenBM_ChkNenreiHani2.SYUHRKKKNSMNKBN)
    public C_HrkkknsmnKbn getSyuhrkkknsmnkbn() {
        return getPrimaryKey().getSyuhrkkknsmnkbn();
    }

    public void setSyuhrkkknsmnkbn(C_HrkkknsmnKbn pSyuhrkkknsmnkbn) {
        getPrimaryKey().setSyuhrkkknsmnkbn(pSyuhrkkknsmnkbn);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.SYUFROMNEN)
    public BizNumber getSyufromnen() {
        return getPrimaryKey().getSyufromnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyufromnen(BizNumber pSyufromnen) {
        getPrimaryKey().setSyufromnen(pSyufromnen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.SYUTONEN)
    public BizNumber getSyutonen() {
        return getPrimaryKey().getSyutonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyutonen(BizNumber pSyutonen) {
        getPrimaryKey().setSyutonen(pSyutonen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.SYUYOTEIRIRITUFROM)
    public BizNumber getSyuyoteiriritufrom() {
        return getPrimaryKey().getSyuyoteiriritufrom();
    }

    public void setSyuyoteiriritufrom(BizNumber pSyuyoteiriritufrom) {
        getPrimaryKey().setSyuyoteiriritufrom(pSyuyoteiriritufrom);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.SYUYOTEIRIRITUTO)
    public BizNumber getSyuyoteirirituto() {
        return getPrimaryKey().getSyuyoteirirituto();
    }

    public void setSyuyoteirirituto(BizNumber pSyuyoteirirituto) {
        getPrimaryKey().setSyuyoteirirituto(pSyuyoteirirituto);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.SYUDAI1HKNKKN)
    @Range(min="0", max="99")
    public Integer getSyudai1hknkkn() {
        return getPrimaryKey().getSyudai1hknkkn();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyudai1hknkkn(Integer pSyudai1hknkkn) {
        getPrimaryKey().setSyudai1hknkkn(pSyudai1hknkkn);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.TOKUSYUCHKNO)
    public BizNumber getTokusyuchkno() {
        return getPrimaryKey().getTokusyuchkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTokusyuchkno(BizNumber pTokusyuchkno) {
        getPrimaryKey().setTokusyuchkno(pTokusyuchkno);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.TKSYOUHNCD)
    public String getTksyouhncd() {
        return getPrimaryKey().getTksyouhncd();
    }

    public void setTksyouhncd(String pTksyouhncd) {
        getPrimaryKey().setTksyouhncd(pTksyouhncd);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.TKHKNKKN)
    public BizNumber getTkhknkkn() {
        return getPrimaryKey().getTkhknkkn();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkhknkkn(BizNumber pTkhknkkn) {
        getPrimaryKey().setTkhknkkn(pTkhknkkn);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.TKHKNKKNTO)
    public Integer getTkhknkknto() {
        return getPrimaryKey().getTkhknkknto();
    }

    public void setTkhknkknto(Integer pTkhknkknto) {
        getPrimaryKey().setTkhknkknto(pTkhknkknto);
    }

    @Id
    @Type(type="UserType_C_HknkknsmnKbn")
    @Column(name=GenBM_ChkNenreiHani2.TKHKNKKNSMNKBN)
    public C_HknkknsmnKbn getTkhknkknsmnkbn() {
        return getPrimaryKey().getTkhknkknsmnkbn();
    }

    public void setTkhknkknsmnkbn(C_HknkknsmnKbn pTkhknkknsmnkbn) {
        getPrimaryKey().setTkhknkknsmnkbn(pTkhknkknsmnkbn);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.TKHRKKKN)
    public BizNumber getTkhrkkkn() {
        return getPrimaryKey().getTkhrkkkn();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkhrkkkn(BizNumber pTkhrkkkn) {
        getPrimaryKey().setTkhrkkkn(pTkhrkkkn);
    }

    @Id
    @Column(name=GenBM_ChkNenreiHani2.TKHRKKKNTO)
    public Integer getTkhrkkknto() {
        return getPrimaryKey().getTkhrkkknto();
    }

    public void setTkhrkkknto(Integer pTkhrkkknto) {
        getPrimaryKey().setTkhrkkknto(pTkhrkkknto);
    }

    @Id
    @Type(type="UserType_C_HrkkknsmnKbn")
    @Column(name=GenBM_ChkNenreiHani2.TKHRKKKNSMNKBN)
    public C_HrkkknsmnKbn getTkhrkkknsmnkbn() {
        return getPrimaryKey().getTkhrkkknsmnkbn();
    }

    public void setTkhrkkknsmnkbn(C_HrkkknsmnKbn pTkhrkkknsmnkbn) {
        getPrimaryKey().setTkhrkkknsmnkbn(pTkhrkkknsmnkbn);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.TKFROMNEN)
    public BizNumber getTkfromnen() {
        return getPrimaryKey().getTkfromnen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkfromnen(BizNumber pTkfromnen) {
        getPrimaryKey().setTkfromnen(pTkfromnen);
    }

    @Id
    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkNenreiHani2.TKTONEN)
    public BizNumber getTktonen() {
        return getPrimaryKey().getTktonen();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTktonen(BizNumber pTktonen) {
        getPrimaryKey().setTktonen(pTktonen);
    }
}