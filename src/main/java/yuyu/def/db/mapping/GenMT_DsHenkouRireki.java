package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.MT_DsHenkouRireki;
import yuyu.def.db.id.PKMT_DsHenkouRireki;
import yuyu.def.db.meta.GenQMT_DsHenkouRireki;
import yuyu.def.db.meta.QMT_DsHenkouRireki;
import yuyu.def.db.type.UserType_C_HnkSyuruiKbn;

/**
 * ＤＳ変更履歴テーブル テーブルのマッピング情報クラスで、 {@link MT_DsHenkouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHenkouRireki}</td><td colspan="3">ＤＳ変更履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKMT_DsHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno renno}</td><td>連番</td><td align="center">{@link PKMT_DsHenkouRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTablenm tablenm}</td><td>テーブル名称</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTableid tableid}</td><td>テーブルＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHnksyuruikbn hnksyuruikbn}</td><td>変更種類区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_HnkSyuruiKbn}</td></tr>
 *  <tr><td>{@link #getHanbetukoumokunm hanbetukoumokunm}</td><td>判別項目名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkoukoumokuid henkoukoumokuid}</td><td>変更項目ID</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkoukoumokunm henkoukoumokunm}</td><td>変更項目名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBfrnaiyouoriginal bfrnaiyouoriginal}</td><td>変更前内容原本</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getBfrnaiyou bfrnaiyou}</td><td>変更前内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewnaiyouoriginal newnaiyouoriginal}</td><td>変更後内容原本</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getNewnaiyou newnaiyou}</td><td>変更後内容</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHenkouRireki
 * @see     PKMT_DsHenkouRireki
 * @see     QMT_DsHenkouRireki
 * @see     GenQMT_DsHenkouRireki
 */
@MappedSuperclass
@Table(name=GenMT_DsHenkouRireki.TABLE_NAME)
@IdClass(value=PKMT_DsHenkouRireki.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HnkSyuruiKbn", typeClass=UserType_C_HnkSyuruiKbn.class)
})
public abstract class GenMT_DsHenkouRireki extends AbstractExDBEntity<MT_DsHenkouRireki, PKMT_DsHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsHenkouRireki";
    public static final String DSKOKNO                  = "dskokno";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String RENNO                    = "renno";
    public static final String TABLENM                  = "tablenm";
    public static final String TABLEID                  = "tableid";
    public static final String HNKSYURUIKBN             = "hnksyuruikbn";
    public static final String HANBETUKOUMOKUNM         = "hanbetukoumokunm";
    public static final String HENKOUKOUMOKUID          = "henkoukoumokuid";
    public static final String HENKOUKOUMOKUNM          = "henkoukoumokunm";
    public static final String BFRNAIYOUORIGINAL        = "bfrnaiyouoriginal";
    public static final String BFRNAIYOU                = "bfrnaiyou";
    public static final String NEWNAIYOUORIGINAL        = "newnaiyouoriginal";
    public static final String NEWNAIYOU                = "newnaiyou";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";

    private final PKMT_DsHenkouRireki primaryKey;

    public GenMT_DsHenkouRireki() {
        primaryKey = new PKMT_DsHenkouRireki();
    }

    public GenMT_DsHenkouRireki(
        String pDskokno,
        String pHenkousikibetukey,
        Integer pRenno
    ) {
        primaryKey = new PKMT_DsHenkouRireki(
            pDskokno,
            pHenkousikibetukey,
            pRenno
        );
    }

    @Transient
    @Override
    public PKMT_DsHenkouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsHenkouRireki> getMetaClass() {
        return QMT_DsHenkouRireki.class;
    }

    @Id
    @Column(name=GenMT_DsHenkouRireki.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsHenkouRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Column(name=GenMT_DsHenkouRireki.RENNO)
    public Integer getRenno() {
        return getPrimaryKey().getRenno();
    }

    @Trim("both")
    public void setRenno(Integer pRenno) {
        getPrimaryKey().setRenno(pRenno);
    }

    private String tablenm;

    @Column(name=GenMT_DsHenkouRireki.TABLENM)
    public String getTablenm() {
        return tablenm;
    }

    public void setTablenm(String pTablenm) {
        tablenm = pTablenm;
    }

    private String tableid;

    @Column(name=GenMT_DsHenkouRireki.TABLEID)
    public String getTableid() {
        return tableid;
    }

    public void setTableid(String pTableid) {
        tableid = pTableid;
    }

    private C_HnkSyuruiKbn hnksyuruikbn;

    @Type(type="UserType_C_HnkSyuruiKbn")
    @Column(name=GenMT_DsHenkouRireki.HNKSYURUIKBN)
    public C_HnkSyuruiKbn getHnksyuruikbn() {
        return hnksyuruikbn;
    }

    public void setHnksyuruikbn(C_HnkSyuruiKbn pHnksyuruikbn) {
        hnksyuruikbn = pHnksyuruikbn;
    }

    private String hanbetukoumokunm;

    @Column(name=GenMT_DsHenkouRireki.HANBETUKOUMOKUNM)
    public String getHanbetukoumokunm() {
        return hanbetukoumokunm;
    }

    public void setHanbetukoumokunm(String pHanbetukoumokunm) {
        hanbetukoumokunm = pHanbetukoumokunm;
    }

    private String henkoukoumokuid;

    @Column(name=GenMT_DsHenkouRireki.HENKOUKOUMOKUID)
    public String getHenkoukoumokuid() {
        return henkoukoumokuid;
    }

    public void setHenkoukoumokuid(String pHenkoukoumokuid) {
        henkoukoumokuid = pHenkoukoumokuid;
    }

    private String henkoukoumokunm;

    @Column(name=GenMT_DsHenkouRireki.HENKOUKOUMOKUNM)
    public String getHenkoukoumokunm() {
        return henkoukoumokunm;
    }

    public void setHenkoukoumokunm(String pHenkoukoumokunm) {
        henkoukoumokunm = pHenkoukoumokunm;
    }

    private String bfrnaiyouoriginal;

    @Column(name=GenMT_DsHenkouRireki.BFRNAIYOUORIGINAL)
    public String getBfrnaiyouoriginal() {
        return bfrnaiyouoriginal;
    }

    public void setBfrnaiyouoriginal(String pBfrnaiyouoriginal) {
        bfrnaiyouoriginal = pBfrnaiyouoriginal;
    }

    private String bfrnaiyou;

    @Column(name=GenMT_DsHenkouRireki.BFRNAIYOU)
    public String getBfrnaiyou() {
        return bfrnaiyou;
    }

    public void setBfrnaiyou(String pBfrnaiyou) {
        bfrnaiyou = pBfrnaiyou;
    }

    private String newnaiyouoriginal;

    @Column(name=GenMT_DsHenkouRireki.NEWNAIYOUORIGINAL)
    public String getNewnaiyouoriginal() {
        return newnaiyouoriginal;
    }

    public void setNewnaiyouoriginal(String pNewnaiyouoriginal) {
        newnaiyouoriginal = pNewnaiyouoriginal;
    }

    private String newnaiyou;

    @Column(name=GenMT_DsHenkouRireki.NEWNAIYOU)
    public String getNewnaiyou() {
        return newnaiyou;
    }

    public void setNewnaiyou(String pNewnaiyou) {
        newnaiyou = pNewnaiyou;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsHenkouRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsHenkouRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsHenkouRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }
}
