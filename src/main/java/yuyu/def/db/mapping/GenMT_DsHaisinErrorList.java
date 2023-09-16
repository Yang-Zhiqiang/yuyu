package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.MT_DsHaisinErrorList;
import yuyu.def.db.id.PKMT_DsHaisinErrorList;
import yuyu.def.db.meta.GenQMT_DsHaisinErrorList;
import yuyu.def.db.meta.QMT_DsHaisinErrorList;

/**
 * ＤＳ配信エラーリストテーブル テーブルのマッピング情報クラスで、 {@link MT_DsHaisinErrorList} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHaisinErrorList}</td><td colspan="3">ＤＳ配信エラーリストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsHaisinErrorList ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsHaisinErrorList ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsmailaddressrenban dsmailaddressrenban}</td><td>ＤＳメールアドレス連番</td><td align="center">{@link PKMT_DsHaisinErrorList ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getHaisinjidsmailaddress haisinjidsmailaddress}</td><td>配信時ＤＳメールアドレス</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaisinerrorcount haisinerrorcount}</td><td>配信エラーカウント</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHaisinErrorList
 * @see     PKMT_DsHaisinErrorList
 * @see     QMT_DsHaisinErrorList
 * @see     GenQMT_DsHaisinErrorList
 */
@MappedSuperclass
@Table(name=GenMT_DsHaisinErrorList.TABLE_NAME)
@IdClass(value=PKMT_DsHaisinErrorList.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class)
})
public abstract class GenMT_DsHaisinErrorList extends AbstractExDBEntity<MT_DsHaisinErrorList, PKMT_DsHaisinErrorList> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsHaisinErrorList";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSMAILADDRESSRENBAN      = "dsmailaddressrenban";
    public static final String HAISINJIDSMAILADDRESS    = "haisinjidsmailaddress";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String HAISINERRORCOUNT         = "haisinerrorcount";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsHaisinErrorList primaryKey;

    public GenMT_DsHaisinErrorList() {
        primaryKey = new PKMT_DsHaisinErrorList();
    }

    public GenMT_DsHaisinErrorList(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        Integer pDsmailaddressrenban
    ) {
        primaryKey = new PKMT_DsHaisinErrorList(
            pDsdatasakuseiymd,
            pDskokno,
            pDsmailaddressrenban
        );
    }

    @Transient
    @Override
    public PKMT_DsHaisinErrorList getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsHaisinErrorList> getMetaClass() {
        return QMT_DsHaisinErrorList.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsHaisinErrorList.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsHaisinErrorList.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Column(name=GenMT_DsHaisinErrorList.DSMAILADDRESSRENBAN)
    public Integer getDsmailaddressrenban() {
        return getPrimaryKey().getDsmailaddressrenban();
    }

    public void setDsmailaddressrenban(Integer pDsmailaddressrenban) {
        getPrimaryKey().setDsmailaddressrenban(pDsmailaddressrenban);
    }

    private String haisinjidsmailaddress;

    @Column(name=GenMT_DsHaisinErrorList.HAISINJIDSMAILADDRESS)
    public String getHaisinjidsmailaddress() {
        return haisinjidsmailaddress;
    }

    public void setHaisinjidsmailaddress(String pHaisinjidsmailaddress) {
        haisinjidsmailaddress = pHaisinjidsmailaddress;
    }

    private String dssousinno;

    @Column(name=GenMT_DsHaisinErrorList.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String haisinerrorcount;

    @Column(name=GenMT_DsHaisinErrorList.HAISINERRORCOUNT)
    public String getHaisinerrorcount() {
        return haisinerrorcount;
    }

    public void setHaisinerrorcount(String pHaisinerrorcount) {
        haisinerrorcount = pHaisinerrorcount;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsHaisinErrorList.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsHaisinErrorList.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsHaisinErrorList.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}