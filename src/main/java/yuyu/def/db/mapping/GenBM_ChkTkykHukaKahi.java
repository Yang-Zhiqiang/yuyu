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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Channelcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_ChkTkykHukaKahi;
import yuyu.def.db.id.PKBM_ChkTkykHukaKahi;
import yuyu.def.db.meta.GenQBM_ChkTkykHukaKahi;
import yuyu.def.db.meta.QBM_ChkTkykHukaKahi;
import yuyu.def.db.type.UserType_C_Channelcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * 特約付加可否倍率チェックマスタ テーブルのマッピング情報クラスで、 {@link BM_ChkTkykHukaKahi} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_ChkTkykHukaKahi}</td><td colspan="3">特約付加可否倍率チェックマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getTksyouhncd tksyouhncd}</td><td>特約商品コード</td><td align="center">{@link PKBM_ChkTkykHukaKahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhncd syusyouhncd}</td><td>主契約商品コード</td><td align="center">{@link PKBM_ChkTkykHukaKahi ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnofrom syusyouhnsdnofrom}</td><td>（主契約）商品世代番号自</td><td align="center">{@link PKBM_ChkTkykHukaKahi ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyusyouhnsdnoto syusyouhnsdnoto}</td><td>（主契約）商品世代番号至</td><td align="center">{@link PKBM_ChkTkykHukaKahi ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getChannelcd channelcd}</td><td>チャネルコード</td><td align="center">{@link PKBM_ChkTkykHukaKahi ○}</td><td align="center">V</td><td>{@link C_Channelcd}</td></tr>
 *  <tr><td>{@link #getHukakahikbn hukakahikbn}</td><td>付加可否区分</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTkbairituhugou tkbairituhugou}</td><td>特約倍率符号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTkbairitu tkbairitu}</td><td>特約倍率</td><td align="center">&nbsp;</td><td align="center">N</td><td>BizNumber</td></tr>
 *  <tr><td>{@link #getTkhukahissuumu tkhukahissuumu}</td><td>特約付加必須有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 * </table>
 * @see     BM_ChkTkykHukaKahi
 * @see     PKBM_ChkTkykHukaKahi
 * @see     QBM_ChkTkykHukaKahi
 * @see     GenQBM_ChkTkykHukaKahi
 */
@MappedSuperclass
@Table(name=GenBM_ChkTkykHukaKahi.TABLE_NAME)
@IdClass(value=PKBM_ChkTkykHukaKahi.class)
@TypeDefs({
    @TypeDef(name="BizNumberType", typeClass=BizNumberType.class),
    @TypeDef(name="UserType_C_Channelcd", typeClass=UserType_C_Channelcd.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenBM_ChkTkykHukaKahi extends AbstractExDBEntity<BM_ChkTkykHukaKahi, PKBM_ChkTkykHukaKahi> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_ChkTkykHukaKahi";
    public static final String TKSYOUHNCD               = "tksyouhncd";
    public static final String SYUSYOUHNCD              = "syusyouhncd";
    public static final String SYUSYOUHNSDNOFROM        = "syusyouhnsdnofrom";
    public static final String SYUSYOUHNSDNOTO          = "syusyouhnsdnoto";
    public static final String CHANNELCD                = "channelcd";
    public static final String HUKAKAHIKBN              = "hukakahikbn";
    public static final String TKBAIRITUHUGOU           = "tkbairituhugou";
    public static final String TKBAIRITU                = "tkbairitu";
    public static final String TKHUKAHISSUUMU           = "tkhukahissuumu";

    private final PKBM_ChkTkykHukaKahi primaryKey;

    public GenBM_ChkTkykHukaKahi() {
        primaryKey = new PKBM_ChkTkykHukaKahi();
    }

    public GenBM_ChkTkykHukaKahi(
        String pTksyouhncd,
        String pSyusyouhncd,
        Integer pSyusyouhnsdnofrom,
        Integer pSyusyouhnsdnoto,
        C_Channelcd pChannelcd
    ) {
        primaryKey = new PKBM_ChkTkykHukaKahi(
            pTksyouhncd,
            pSyusyouhncd,
            pSyusyouhnsdnofrom,
            pSyusyouhnsdnoto,
            pChannelcd
        );
    }

    @Transient
    @Override
    public PKBM_ChkTkykHukaKahi getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_ChkTkykHukaKahi> getMetaClass() {
        return QBM_ChkTkykHukaKahi.class;
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaKahi.TKSYOUHNCD)
    public String getTksyouhncd() {
        return getPrimaryKey().getTksyouhncd();
    }

    public void setTksyouhncd(String pTksyouhncd) {
        getPrimaryKey().setTksyouhncd(pTksyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaKahi.SYUSYOUHNCD)
    public String getSyusyouhncd() {
        return getPrimaryKey().getSyusyouhncd();
    }

    public void setSyusyouhncd(String pSyusyouhncd) {
        getPrimaryKey().setSyusyouhncd(pSyusyouhncd);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaKahi.SYUSYOUHNSDNOFROM)
    public Integer getSyusyouhnsdnofrom() {
        return getPrimaryKey().getSyusyouhnsdnofrom();
    }

    public void setSyusyouhnsdnofrom(Integer pSyusyouhnsdnofrom) {
        getPrimaryKey().setSyusyouhnsdnofrom(pSyusyouhnsdnofrom);
    }

    @Id
    @Column(name=GenBM_ChkTkykHukaKahi.SYUSYOUHNSDNOTO)
    public Integer getSyusyouhnsdnoto() {
        return getPrimaryKey().getSyusyouhnsdnoto();
    }

    public void setSyusyouhnsdnoto(Integer pSyusyouhnsdnoto) {
        getPrimaryKey().setSyusyouhnsdnoto(pSyusyouhnsdnoto);
    }

    @Id
    @Type(type="UserType_C_Channelcd")
    @Column(name=GenBM_ChkTkykHukaKahi.CHANNELCD)
    public C_Channelcd getChannelcd() {
        return getPrimaryKey().getChannelcd();
    }

    public void setChannelcd(C_Channelcd pChannelcd) {
        getPrimaryKey().setChannelcd(pChannelcd);
    }

    private Integer hukakahikbn;

    @Column(name=GenBM_ChkTkykHukaKahi.HUKAKAHIKBN)
    public Integer getHukakahikbn() {
        return hukakahikbn;
    }

    public void setHukakahikbn(Integer pHukakahikbn) {
        hukakahikbn = pHukakahikbn;
    }

    private String tkbairituhugou;

    @Column(name=GenBM_ChkTkykHukaKahi.TKBAIRITUHUGOU)
    public String getTkbairituhugou() {
        return tkbairituhugou;
    }

    public void setTkbairituhugou(String pTkbairituhugou) {
        tkbairituhugou = pTkbairituhugou;
    }

    private BizNumber tkbairitu;

    @Type(type="BizNumberType")
    @Column(name=GenBM_ChkTkykHukaKahi.TKBAIRITU)
    public BizNumber getTkbairitu() {
        return tkbairitu;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTkbairitu(BizNumber pTkbairitu) {
        tkbairitu = pTkbairitu;
    }

    private C_UmuKbn tkhukahissuumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_ChkTkykHukaKahi.TKHUKAHISSUUMU)
    public C_UmuKbn getTkhukahissuumu() {
        return tkhukahissuumu;
    }

    public void setTkhukahissuumu(C_UmuKbn pTkhukahissuumu) {
        tkhukahissuumu = pTkhukahissuumu;
    }
}
