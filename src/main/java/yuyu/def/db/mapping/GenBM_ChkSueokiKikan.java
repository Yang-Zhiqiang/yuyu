package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_SueokikknsmnKbn;
import yuyu.def.db.entity.BM_ChkSueokiKikan;
import yuyu.def.db.id.PKBM_ChkSueokiKikan;
import yuyu.def.db.meta.GenQBM_ChkSueokiKikan;
import yuyu.def.db.meta.QBM_ChkSueokiKikan;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_SueokikknsmnKbn;

/**
 * 据置期間チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkSueokiKikan} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkSueokiKikan}</td><td colspan="3">据置期間チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkSueokiKikan ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkSueokiKikan ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkSueokiKikan ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_ChkSueokiKikan ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getSueokikkn sueokikkn}</td><td>据置期間</td><td align="center">{@link PKBM_ChkSueokiKikan ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSueokikknsmnkbn sueokikknsmnkbn}</td><td>据置期間歳満期区分</td><td align="center">{@link PKBM_ChkSueokiKikan ○}</td><td align="center">V</td><td>{@link C_SueokikknsmnKbn}</td></tr>
 * </table>
 * @see     BM_ChkSueokiKikan
 * @see     PKBM_ChkSueokiKikan
 * @see     QBM_ChkSueokiKikan
 * @see     GenQBM_ChkSueokiKikan
 */
@MappedSuperclass
@Table(name=GenBM_ChkSueokiKikan.TABLE_NAME)
@IdClass(value=PKBM_ChkSueokiKikan.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_SueokikknsmnKbn", typeClass=UserType_C_SueokikknsmnKbn.class)
})
public abstract class GenBM_ChkSueokiKikan extends AbstractExDBEntity<BM_ChkSueokiKikan, PKBM_ChkSueokiKikan> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkSueokiKikan";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String CHANNELCD                = "channelcd";
    public static final String SUEOKIKKN                = "sueokikkn";
    public static final String SUEOKIKKNSMNKBN          = "sueokikknsmnkbn";

    private final PKBM_ChkSueokiKikan primaryKey;

    public GenBM_ChkSueokiKikan() {
        primaryKey = new PKBM_ChkSueokiKikan();
    }

    public GenBM_ChkSueokiKikan(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        Integer pSueokikkn,
        C_SueokikknsmnKbn pSueokikknsmnkbn
    ) {
        primaryKey = new PKBM_ChkSueokiKikan(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pSueokikkn,
            pSueokikknsmnkbn
        );
    }

    @Transient
    @Override
    public PKBM_ChkSueokiKikan getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkSueokiKikan> getMetaClass() {
        return QBM_ChkSueokiKikan.class;
    }

    @Id
    @Column(name=GenBM_ChkSueokiKikan.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkSueokiKikan.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkSueokiKikan.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_ChkSueokiKikan.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Column(name=GenBM_ChkSueokiKikan.SUEOKIKKN)
    public Integer getSueokikkn() {
        return getPrimaryKey().getSueokikkn();
    }

    public void setSueokikkn(Integer pSueokikkn) {
        getPrimaryKey().setSueokikkn(pSueokikkn);
    }

    @Id
    @Type(type="UserType_C_SueokikknsmnKbn")
    @Column(name=GenBM_ChkSueokiKikan.SUEOKIKKNSMNKBN)
    public C_SueokikknsmnKbn getSueokikknsmnkbn() {
        return getPrimaryKey().getSueokikknsmnkbn();
    }

    public void setSueokikknsmnkbn(C_SueokikknsmnKbn pSueokikknsmnkbn) {
        getPrimaryKey().setSueokikknsmnkbn(pSueokikknsmnkbn);
    }
}