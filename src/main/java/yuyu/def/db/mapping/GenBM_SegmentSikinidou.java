package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_GkhnkzidourtKbn;
import yuyu.def.classification.C_HijynnykzndkkouzaKbn;
import yuyu.def.classification.C_Segcd;
import yuyu.def.classification.C_UmuKbn;
import yuyu.def.db.entity.BM_SegmentSikinidou;
import yuyu.def.db.id.PKBM_SegmentSikinidou;
import yuyu.def.db.meta.GenQBM_SegmentSikinidou;
import yuyu.def.db.meta.QBM_SegmentSikinidou;
import yuyu.def.db.type.UserType_C_GkhnkzidourtKbn;
import yuyu.def.db.type.UserType_C_HijynnykzndkkouzaKbn;
import yuyu.def.db.type.UserType_C_Segcd;
import yuyu.def.db.type.UserType_C_UmuKbn;

/**
 * セグメントコード別資金移動処理マスタ テーブルのマッピング情報クラスで、 {@link BM_SegmentSikinidou} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_SegmentSikinidou}</td><td colspan="3">セグメントコード別資金移動処理マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSegcd segcd}</td><td>セグメントコード</td><td align="center">{@link PKBM_SegmentSikinidou ○}</td><td align="center">V</td><td>{@link C_Segcd}</td></tr>
 *  <tr><td>{@link #getHijynnykzndkkouzakbn hijynnykzndkkouzakbn}</td><td>平準払入金額残高口座区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HijynnykzndkkouzaKbn}</td></tr>
 *  <tr><td>{@link #getFstpgkhnkzidourt fstpgkhnkzidourt}</td><td>初回Ｐ外貨本口座移動ルート</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GkhnkzidourtKbn}</td></tr>
 *  <tr><td>{@link #getZenkizennougkhnkzidourt zenkizennougkhnkzidourt}</td><td>全期前納外貨本口座移動ルート</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GkhnkzidourtKbn}</td></tr>
 *  <tr><td>{@link #getKeizokupgkhnkzidourt keizokupgkhnkzidourt}</td><td>継続Ｐ外貨本口座移動ルート</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_GkhnkzidourtKbn}</td></tr>
 *  <tr><td>{@link #getSeiymdseitstuityouhnknumu seiymdseitstuityouhnknumu}</td><td>生年月日性訂正追徴返還有無</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_UmuKbn}</td></tr>
 *  <tr><td>{@link #getDaihyousyouhncd daihyousyouhncd}</td><td>代表商品コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_SegmentSikinidou
 * @see     PKBM_SegmentSikinidou
 * @see     QBM_SegmentSikinidou
 * @see     GenQBM_SegmentSikinidou
 */
@MappedSuperclass
@Table(name=GenBM_SegmentSikinidou.TABLE_NAME)
@IdClass(value=PKBM_SegmentSikinidou.class)
@TypeDefs({
    @TypeDef(name="UserType_C_GkhnkzidourtKbn", typeClass=UserType_C_GkhnkzidourtKbn.class),
    @TypeDef(name="UserType_C_HijynnykzndkkouzaKbn", typeClass=UserType_C_HijynnykzndkkouzaKbn.class),
    @TypeDef(name="UserType_C_Segcd", typeClass=UserType_C_Segcd.class),
    @TypeDef(name="UserType_C_UmuKbn", typeClass=UserType_C_UmuKbn.class)
})
public abstract class GenBM_SegmentSikinidou extends AbstractExDBEntity<BM_SegmentSikinidou, PKBM_SegmentSikinidou> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BM_SegmentSikinidou";
    public static final String SEGCD                    = "segcd";
    public static final String HIJYNNYKZNDKKOUZAKBN     = "hijynnykzndkkouzakbn";
    public static final String FSTPGKHNKZIDOURT         = "fstpgkhnkzidourt";
    public static final String ZENKIZENNOUGKHNKZIDOURT  = "zenkizennougkhnkzidourt";
    public static final String KEIZOKUPGKHNKZIDOURT     = "keizokupgkhnkzidourt";
    public static final String SEIYMDSEITSTUITYOUHNKNUMU = "seiymdseitstuityouhnknumu";
    public static final String DAIHYOUSYOUHNCD          = "daihyousyouhncd";

    private final PKBM_SegmentSikinidou primaryKey;

    public GenBM_SegmentSikinidou() {
        primaryKey = new PKBM_SegmentSikinidou();
    }

    public GenBM_SegmentSikinidou(C_Segcd pSegcd) {
        primaryKey = new PKBM_SegmentSikinidou(pSegcd);
    }

    @Transient
    @Override
    public PKBM_SegmentSikinidou getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBM_SegmentSikinidou> getMetaClass() {
        return QBM_SegmentSikinidou.class;
    }

    @Id
    @Type(type="UserType_C_Segcd")
    @Column(name=GenBM_SegmentSikinidou.SEGCD)
    public C_Segcd getSegcd() {
        return getPrimaryKey().getSegcd();
    }

    public void setSegcd(C_Segcd pSegcd) {
        getPrimaryKey().setSegcd(pSegcd);
    }

    private C_HijynnykzndkkouzaKbn hijynnykzndkkouzakbn;

    @Type(type="UserType_C_HijynnykzndkkouzaKbn")
    @Column(name=GenBM_SegmentSikinidou.HIJYNNYKZNDKKOUZAKBN)
    public C_HijynnykzndkkouzaKbn getHijynnykzndkkouzakbn() {
        return hijynnykzndkkouzakbn;
    }

    public void setHijynnykzndkkouzakbn(C_HijynnykzndkkouzaKbn pHijynnykzndkkouzakbn) {
        hijynnykzndkkouzakbn = pHijynnykzndkkouzakbn;
    }

    private C_GkhnkzidourtKbn fstpgkhnkzidourt;

    @Type(type="UserType_C_GkhnkzidourtKbn")
    @Column(name=GenBM_SegmentSikinidou.FSTPGKHNKZIDOURT)
    public C_GkhnkzidourtKbn getFstpgkhnkzidourt() {
        return fstpgkhnkzidourt;
    }

    public void setFstpgkhnkzidourt(C_GkhnkzidourtKbn pFstpgkhnkzidourt) {
        fstpgkhnkzidourt = pFstpgkhnkzidourt;
    }

    private C_GkhnkzidourtKbn zenkizennougkhnkzidourt;

    @Type(type="UserType_C_GkhnkzidourtKbn")
    @Column(name=GenBM_SegmentSikinidou.ZENKIZENNOUGKHNKZIDOURT)
    public C_GkhnkzidourtKbn getZenkizennougkhnkzidourt() {
        return zenkizennougkhnkzidourt;
    }

    public void setZenkizennougkhnkzidourt(C_GkhnkzidourtKbn pZenkizennougkhnkzidourt) {
        zenkizennougkhnkzidourt = pZenkizennougkhnkzidourt;
    }

    private C_GkhnkzidourtKbn keizokupgkhnkzidourt;

    @Type(type="UserType_C_GkhnkzidourtKbn")
    @Column(name=GenBM_SegmentSikinidou.KEIZOKUPGKHNKZIDOURT)
    public C_GkhnkzidourtKbn getKeizokupgkhnkzidourt() {
        return keizokupgkhnkzidourt;
    }

    public void setKeizokupgkhnkzidourt(C_GkhnkzidourtKbn pKeizokupgkhnkzidourt) {
        keizokupgkhnkzidourt = pKeizokupgkhnkzidourt;
    }

    private C_UmuKbn seiymdseitstuityouhnknumu;

    @Type(type="UserType_C_UmuKbn")
    @Column(name=GenBM_SegmentSikinidou.SEIYMDSEITSTUITYOUHNKNUMU)
    public C_UmuKbn getSeiymdseitstuityouhnknumu() {
        return seiymdseitstuityouhnknumu;
    }

    public void setSeiymdseitstuityouhnknumu(C_UmuKbn pSeiymdseitstuityouhnknumu) {
        seiymdseitstuityouhnknumu = pSeiymdseitstuityouhnknumu;
    }

    private String daihyousyouhncd;

    @Column(name=GenBM_SegmentSikinidou.DAIHYOUSYOUHNCD)
    public String getDaihyousyouhncd() {
        return daihyousyouhncd;
    }

    public void setDaihyousyouhncd(String pDaihyousyouhncd) {
        daihyousyouhncd = pDaihyousyouhncd;
    }
}