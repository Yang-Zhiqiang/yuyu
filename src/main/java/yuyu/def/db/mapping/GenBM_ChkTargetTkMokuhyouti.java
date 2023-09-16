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
import yuyu.def.db.entity.BM_ChkTargetTkMokuhyouti;
import yuyu.def.db.id.PKBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.GenQBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.meta.QBM_ChkTargetTkMokuhyouti;
import yuyu.def.db.type.UserType_C_Channelcd;

/**
 * ターゲット特約目標値チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkTargetTkMokuhyouti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTargetTkMokuhyouti}</td><td colspan="3">ターゲット特約目標値チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKBM_ChkTargetTkMokuhyouti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkTargetTkMokuhyouti ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkTargetTkMokuhyouti ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_ChkTargetTkMokuhyouti ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getTargettkmokuhyouti targettkmokuhyouti}</td><td>ターゲット特約目標値</td><td align="center">{@link PKBM_ChkTargetTkMokuhyouti ○}</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_ChkTargetTkMokuhyouti
 * @see     PKBM_ChkTargetTkMokuhyouti
 * @see     QBM_ChkTargetTkMokuhyouti
 * @see     GenQBM_ChkTargetTkMokuhyouti
 */
@MappedSuperclass
@Table(name=GenBM_ChkTargetTkMokuhyouti.TABLE_NAME)
@IdClass(value=PKBM_ChkTargetTkMokuhyouti.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class)
})
public abstract class GenBM_ChkTargetTkMokuhyouti extends AbstractExDBEntity<BM_ChkTargetTkMokuhyouti, PKBM_ChkTargetTkMokuhyouti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkTargetTkMokuhyouti";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String CHANNELCD                = "channelcd";
    public static final String TARGETTKMOKUHYOUTI       = "targettkmokuhyouti";

    private final PKBM_ChkTargetTkMokuhyouti primaryKey;

    public GenBM_ChkTargetTkMokuhyouti() {
        primaryKey = new PKBM_ChkTargetTkMokuhyouti();
    }

    public GenBM_ChkTargetTkMokuhyouti(
        String pSyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd,
        Integer pTargettkmokuhyouti
    ) {
        primaryKey = new PKBM_ChkTargetTkMokuhyouti(
            pSyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd,
            pTargettkmokuhyouti
        );
    }

    @Transient
    @Override
    public PKBM_ChkTargetTkMokuhyouti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkTargetTkMokuhyouti> getMetaClass() {
        return QBM_ChkTargetTkMokuhyouti.class;
    }

    @Id
    @Column(name=GenBM_ChkTargetTkMokuhyouti.SYOUHNCD)
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
    @Column(name=GenBM_ChkTargetTkMokuhyouti.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkTargetTkMokuhyouti.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_ChkTargetTkMokuhyouti.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    @Id
    @Column(name=GenBM_ChkTargetTkMokuhyouti.TARGETTKMOKUHYOUTI)
    public Integer getTargettkmokuhyouti() {
        return getPrimaryKey().getTargettkmokuhyouti();
    }

    public void setTargettkmokuhyouti(Integer pTargettkmokuhyouti) {
        getPrimaryKey().setTargettkmokuhyouti(pTargettkmokuhyouti);
    }
}