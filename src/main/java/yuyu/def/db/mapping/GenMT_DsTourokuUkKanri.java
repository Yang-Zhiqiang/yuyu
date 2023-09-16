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
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_DsTtdksyubetuKbn;
import yuyu.def.classification.C_TourokustatusKbn;
import yuyu.def.db.entity.MT_DsTourokuUkKanri;
import yuyu.def.db.id.PKMT_DsTourokuUkKanri;
import yuyu.def.db.meta.GenQMT_DsTourokuUkKanri;
import yuyu.def.db.meta.QMT_DsTourokuUkKanri;
import yuyu.def.db.type.UserType_C_DsTtdksyubetuKbn;
import yuyu.def.db.type.UserType_C_TourokustatusKbn;
import yuyu.infr.validation.constraints.MousikomiNo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ登録受付管理テーブル テーブルのマッピング情報クラスで、 {@link MT_DsTourokuUkKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsTourokuUkKanri}</td><td colspan="3">ＤＳ登録受付管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKMT_DsTourokuUkKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDsttdksyubetukbn dsttdksyubetukbn}</td><td>ＤＳ手続種別区分</td><td align="center">{@link PKMT_DsTourokuUkKanri ○}</td><td align="center">V</td><td>{@link C_DsTtdksyubetuKbn}</td></tr>
 *  <tr><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">{@link PKMT_DsTourokuUkKanri ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTourokustatus tourokustatus}</td><td>登録ステータス</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TourokustatusKbn}</td></tr>
 *  <tr><td>{@link #getDsjimukaisiymd dsjimukaisiymd}</td><td>ＤＳ事務開始日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDsjimukanryouymd dsjimukanryouymd}</td><td>ＤＳ事務完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDstourokukanryouymd dstourokukanryouymd}</td><td>ＤＳ登録完了日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsTourokuUkKanri
 * @see     PKMT_DsTourokuUkKanri
 * @see     QMT_DsTourokuUkKanri
 * @see     GenQMT_DsTourokuUkKanri
 */
@MappedSuperclass
@Table(name=GenMT_DsTourokuUkKanri.TABLE_NAME)
@IdClass(value=PKMT_DsTourokuUkKanri.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsTtdksyubetuKbn", typeClass=UserType_C_DsTtdksyubetuKbn.class),
    @TypeDef(name="UserType_C_TourokustatusKbn", typeClass=UserType_C_TourokustatusKbn.class)
})
public abstract class GenMT_DsTourokuUkKanri extends AbstractExDBEntity<MT_DsTourokuUkKanri, PKMT_DsTourokuUkKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsTourokuUkKanri";
    public static final String SYONO                    = "syono";
    public static final String DSTTDKSYUBETUKBN         = "dsttdksyubetukbn";
    public static final String DATARENNO                = "datarenno";
    public static final String DSKOKNO                  = "dskokno";
    public static final String MOSNO                    = "mosno";
    public static final String TOUROKUSTATUS            = "tourokustatus";
    public static final String DSJIMUKAISIYMD           = "dsjimukaisiymd";
    public static final String DSJIMUKANRYOUYMD         = "dsjimukanryouymd";
    public static final String DSTOUROKUKANRYOUYMD      = "dstourokukanryouymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsTourokuUkKanri primaryKey;

    public GenMT_DsTourokuUkKanri() {
        primaryKey = new PKMT_DsTourokuUkKanri();
    }

    public GenMT_DsTourokuUkKanri(
        String pSyono,
        C_DsTtdksyubetuKbn pDsttdksyubetukbn,
        Integer pDatarenno
    ) {
        primaryKey = new PKMT_DsTourokuUkKanri(
            pSyono,
            pDsttdksyubetukbn,
            pDatarenno
        );
    }

    @Transient
    @Override
    public PKMT_DsTourokuUkKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsTourokuUkKanri> getMetaClass() {
        return QMT_DsTourokuUkKanri.class;
    }

    @Id
    @Column(name=GenMT_DsTourokuUkKanri.SYONO)
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
    @Type(type="UserType_C_DsTtdksyubetuKbn")
    @Column(name=GenMT_DsTourokuUkKanri.DSTTDKSYUBETUKBN)
    public C_DsTtdksyubetuKbn getDsttdksyubetukbn() {
        return getPrimaryKey().getDsttdksyubetukbn();
    }

    public void setDsttdksyubetukbn(C_DsTtdksyubetuKbn pDsttdksyubetukbn) {
        getPrimaryKey().setDsttdksyubetukbn(pDsttdksyubetukbn);
    }

    @Id
    @Column(name=GenMT_DsTourokuUkKanri.DATARENNO)
    public Integer getDatarenno() {
        return getPrimaryKey().getDatarenno();
    }

    public void setDatarenno(Integer pDatarenno) {
        getPrimaryKey().setDatarenno(pDatarenno);
    }

    private String dskokno;

    @Column(name=GenMT_DsTourokuUkKanri.DSKOKNO)
    public String getDskokno() {
        return dskokno;
    }

    public void setDskokno(String pDskokno) {
        dskokno = pDskokno;
    }

    private String mosno;

    @Column(name=GenMT_DsTourokuUkKanri.MOSNO)
    @MousikomiNo
    public String getMosno() {
        return mosno;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setMosno(String pMosno) {
        mosno = pMosno;
    }

    private C_TourokustatusKbn tourokustatus;

    @Type(type="UserType_C_TourokustatusKbn")
    @Column(name=GenMT_DsTourokuUkKanri.TOUROKUSTATUS)
    public C_TourokustatusKbn getTourokustatus() {
        return tourokustatus;
    }

    public void setTourokustatus(C_TourokustatusKbn pTourokustatus) {
        tourokustatus = pTourokustatus;
    }

    private BizDate dsjimukaisiymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsTourokuUkKanri.DSJIMUKAISIYMD)
    public BizDate getDsjimukaisiymd() {
        return dsjimukaisiymd;
    }

    public void setDsjimukaisiymd(BizDate pDsjimukaisiymd) {
        dsjimukaisiymd = pDsjimukaisiymd;
    }

    private BizDate dsjimukanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsTourokuUkKanri.DSJIMUKANRYOUYMD)
    public BizDate getDsjimukanryouymd() {
        return dsjimukanryouymd;
    }

    public void setDsjimukanryouymd(BizDate pDsjimukanryouymd) {
        dsjimukanryouymd = pDsjimukanryouymd;
    }

    private BizDate dstourokukanryouymd;

    @Type(type="BizDateType")
    @Column(name=GenMT_DsTourokuUkKanri.DSTOUROKUKANRYOUYMD)
    public BizDate getDstourokukanryouymd() {
        return dstourokukanryouymd;
    }

    public void setDstourokukanryouymd(BizDate pDstourokukanryouymd) {
        dstourokukanryouymd = pDstourokukanryouymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsTourokuUkKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsTourokuUkKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsTourokuUkKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}