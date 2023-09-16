package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_HnkSyuruiKbn;
import yuyu.def.db.entity.IT_KhHenkouRireki;
import yuyu.def.db.id.PKIT_KhHenkouRireki;
import yuyu.def.db.meta.GenQIT_KhHenkouRireki;
import yuyu.def.db.meta.QIT_KhHenkouRireki;
import yuyu.def.db.type.UserType_C_HnkSyuruiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 契約保全変更履歴テーブル テーブルのマッピング情報クラスで、 {@link IT_KhHenkouRireki} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhHenkouRireki}</td><td colspan="3">契約保全変更履歴テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_KhHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_KhHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHenkousikibetukey henkousikibetukey}</td><td>変更識別キー</td><td align="center">{@link PKIT_KhHenkouRireki ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getRenno3keta renno3keta}</td><td>連番（３桁）</td><td align="center">{@link PKIT_KhHenkouRireki ○}</td><td align="center">N</td><td>Integer</td></tr>
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
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhHenkouRireki
 * @see     PKIT_KhHenkouRireki
 * @see     QIT_KhHenkouRireki
 * @see     GenQIT_KhHenkouRireki
 */
@MappedSuperclass
@Table(name=GenIT_KhHenkouRireki.TABLE_NAME)
@IdClass(value=PKIT_KhHenkouRireki.class)
@TypeDefs({
    @TypeDef(name="UserType_C_HnkSyuruiKbn", typeClass=UserType_C_HnkSyuruiKbn.class)
})
public abstract class GenIT_KhHenkouRireki extends AbstractExDBEntity<IT_KhHenkouRireki, PKIT_KhHenkouRireki> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_KhHenkouRireki";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String HENKOUSIKIBETUKEY        = "henkousikibetukey";
    public static final String RENNO3KETA               = "renno3keta";
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
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_KhHenkouRireki primaryKey;

    public GenIT_KhHenkouRireki() {
        primaryKey = new PKIT_KhHenkouRireki();
    }

    public GenIT_KhHenkouRireki(
        String pKbnkey,
        String pSyono,
        String pHenkousikibetukey,
        Integer pRenno3keta
    ) {
        primaryKey = new PKIT_KhHenkouRireki(
            pKbnkey,
            pSyono,
            pHenkousikibetukey,
            pRenno3keta
        );
    }

    @Transient
    @Override
    public PKIT_KhHenkouRireki getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_KhHenkouRireki> getMetaClass() {
        return QIT_KhHenkouRireki.class;
    }

    @Id
    @Column(name=GenIT_KhHenkouRireki.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_KhHenkouRireki.SYONO)
    @SyoukenNo
    public String getSyono() {
        return getPrimaryKey().getSyono();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        getPrimaryKey().setSyono(pSyono);
    }

    @Id
    @Column(name=GenIT_KhHenkouRireki.HENKOUSIKIBETUKEY)
    public String getHenkousikibetukey() {
        return getPrimaryKey().getHenkousikibetukey();
    }

    public void setHenkousikibetukey(String pHenkousikibetukey) {
        getPrimaryKey().setHenkousikibetukey(pHenkousikibetukey);
    }

    @Id
    @Column(name=GenIT_KhHenkouRireki.RENNO3KETA)
    public Integer getRenno3keta() {
        return getPrimaryKey().getRenno3keta();
    }

    public void setRenno3keta(Integer pRenno3keta) {
        getPrimaryKey().setRenno3keta(pRenno3keta);
    }

    private String tablenm;

    @Column(name=GenIT_KhHenkouRireki.TABLENM)
    public String getTablenm() {
        return tablenm;
    }

    public void setTablenm(String pTablenm) {
        tablenm = pTablenm;
    }

    private String tableid;

    @Column(name=GenIT_KhHenkouRireki.TABLEID)
    public String getTableid() {
        return tableid;
    }

    public void setTableid(String pTableid) {
        tableid = pTableid;
    }

    private C_HnkSyuruiKbn hnksyuruikbn;

    @Type(type="UserType_C_HnkSyuruiKbn")
    @Column(name=GenIT_KhHenkouRireki.HNKSYURUIKBN)
    public C_HnkSyuruiKbn getHnksyuruikbn() {
        return hnksyuruikbn;
    }

    public void setHnksyuruikbn(C_HnkSyuruiKbn pHnksyuruikbn) {
        hnksyuruikbn = pHnksyuruikbn;
    }

    private String hanbetukoumokunm;

    @Column(name=GenIT_KhHenkouRireki.HANBETUKOUMOKUNM)
    public String getHanbetukoumokunm() {
        return hanbetukoumokunm;
    }

    public void setHanbetukoumokunm(String pHanbetukoumokunm) {
        hanbetukoumokunm = pHanbetukoumokunm;
    }

    private String henkoukoumokuid;

    @Column(name=GenIT_KhHenkouRireki.HENKOUKOUMOKUID)
    public String getHenkoukoumokuid() {
        return henkoukoumokuid;
    }

    public void setHenkoukoumokuid(String pHenkoukoumokuid) {
        henkoukoumokuid = pHenkoukoumokuid;
    }

    private String henkoukoumokunm;

    @Column(name=GenIT_KhHenkouRireki.HENKOUKOUMOKUNM)
    public String getHenkoukoumokunm() {
        return henkoukoumokunm;
    }

    public void setHenkoukoumokunm(String pHenkoukoumokunm) {
        henkoukoumokunm = pHenkoukoumokunm;
    }

    private String bfrnaiyouoriginal;

    @Column(name=GenIT_KhHenkouRireki.BFRNAIYOUORIGINAL)
    public String getBfrnaiyouoriginal() {
        return bfrnaiyouoriginal;
    }

    public void setBfrnaiyouoriginal(String pBfrnaiyouoriginal) {
        bfrnaiyouoriginal = pBfrnaiyouoriginal;
    }

    private String bfrnaiyou;

    @Column(name=GenIT_KhHenkouRireki.BFRNAIYOU)
    public String getBfrnaiyou() {
        return bfrnaiyou;
    }

    public void setBfrnaiyou(String pBfrnaiyou) {
        bfrnaiyou = pBfrnaiyou;
    }

    private String newnaiyouoriginal;

    @Column(name=GenIT_KhHenkouRireki.NEWNAIYOUORIGINAL)
    public String getNewnaiyouoriginal() {
        return newnaiyouoriginal;
    }

    public void setNewnaiyouoriginal(String pNewnaiyouoriginal) {
        newnaiyouoriginal = pNewnaiyouoriginal;
    }

    private String newnaiyou;

    @Column(name=GenIT_KhHenkouRireki.NEWNAIYOU)
    public String getNewnaiyou() {
        return newnaiyou;
    }

    public void setNewnaiyou(String pNewnaiyou) {
        newnaiyou = pNewnaiyou;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_KhHenkouRireki.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_KhHenkouRireki.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_KhHenkouRireki.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}