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
import yuyu.def.classification.C_SyoruiCdKbn;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.id.PKJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.GenQJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.QJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.type.UserType_C_SyoruiCdKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＫＳ連動済書類情報テーブル テーブルのマッピング情報クラスで、 {@link JT_AksrendouzumiSyoruiImg} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_AksrendouzumiSyoruiImg}</td><td colspan="3">ＡＫＳ連動済書類情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">{@link PKJT_AksrendouzumiSyoruiImg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKJT_AksrendouzumiSyoruiImg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getImageid imageid}</td><td>イメージID</td><td align="center">{@link PKJT_AksrendouzumiSyoruiImg ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyoruiimagepagecnt syoruiimagepagecnt}</td><td>書類イメージページ数</td><td align="center">&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getSyoruiCd syoruiCd}</td><td>書類コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_SyoruiCdKbn}</td></tr>
 *  <tr><td>{@link #getAksrendoupdffilenm aksrendoupdffilenm}</td><td>ＡＫＳ連動用ＰＤＦファイル名</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_AksrendouzumiSyoruiImg
 * @see     PKJT_AksrendouzumiSyoruiImg
 * @see     QJT_AksrendouzumiSyoruiImg
 * @see     GenQJT_AksrendouzumiSyoruiImg
 */
@MappedSuperclass
@Table(name=GenJT_AksrendouzumiSyoruiImg.TABLE_NAME)
@IdClass(value=PKJT_AksrendouzumiSyoruiImg.class)
@TypeDefs({
    @TypeDef(name="UserType_C_SyoruiCdKbn", typeClass=UserType_C_SyoruiCdKbn.class)
})
public abstract class GenJT_AksrendouzumiSyoruiImg extends AbstractExDBEntity<JT_AksrendouzumiSyoruiImg, PKJT_AksrendouzumiSyoruiImg> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JT_AksrendouzumiSyoruiImg";
    public static final String SKNO                     = "skno";
    public static final String SYONO                    = "syono";
    public static final String IMAGEID                  = "imageid";
    public static final String SYORUIIMAGEPAGECNT       = "syoruiimagepagecnt";
    public static final String SYORUICD                 = "syoruiCd";
    public static final String AKSRENDOUPDFFILENM       = "aksrendoupdffilenm";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJT_AksrendouzumiSyoruiImg primaryKey;

    public GenJT_AksrendouzumiSyoruiImg() {
        primaryKey = new PKJT_AksrendouzumiSyoruiImg();
    }

    public GenJT_AksrendouzumiSyoruiImg(
        String pSkno,
        String pSyono,
        String pImageid
    ) {
        primaryKey = new PKJT_AksrendouzumiSyoruiImg(
            pSkno,
            pSyono,
            pImageid
        );
    }

    @Transient
    @Override
    public PKJT_AksrendouzumiSyoruiImg getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJT_AksrendouzumiSyoruiImg> getMetaClass() {
        return QJT_AksrendouzumiSyoruiImg.class;
    }

    @Id
    @Column(name=GenJT_AksrendouzumiSyoruiImg.SKNO)
    public String getSkno() {
        return getPrimaryKey().getSkno();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSkno(String pSkno) {
        getPrimaryKey().setSkno(pSkno);
    }

    @Id
    @Column(name=GenJT_AksrendouzumiSyoruiImg.SYONO)
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
    @Column(name=GenJT_AksrendouzumiSyoruiImg.IMAGEID)
    public String getImageid() {
        return getPrimaryKey().getImageid();
    }

    public void setImageid(String pImageid) {
        getPrimaryKey().setImageid(pImageid);
    }

    private Integer syoruiimagepagecnt;

    @Column(name=GenJT_AksrendouzumiSyoruiImg.SYORUIIMAGEPAGECNT)
    public Integer getSyoruiimagepagecnt() {
        return syoruiimagepagecnt;
    }

    public void setSyoruiimagepagecnt(Integer pSyoruiimagepagecnt) {
        syoruiimagepagecnt = pSyoruiimagepagecnt;
    }

    private C_SyoruiCdKbn syoruiCd;

    @Type(type="UserType_C_SyoruiCdKbn")
    @Column(name=GenJT_AksrendouzumiSyoruiImg.SYORUICD)
    public C_SyoruiCdKbn getSyoruiCd() {
        return syoruiCd;
    }

    public void setSyoruiCd(C_SyoruiCdKbn pSyoruiCd) {
        syoruiCd = pSyoruiCd;
    }

    private String aksrendoupdffilenm;

    @Column(name=GenJT_AksrendouzumiSyoruiImg.AKSRENDOUPDFFILENM)
    public String getAksrendoupdffilenm() {
        return aksrendoupdffilenm;
    }

    public void setAksrendoupdffilenm(String pAksrendoupdffilenm) {
        aksrendoupdffilenm = pAksrendoupdffilenm;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenJT_AksrendouzumiSyoruiImg.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJT_AksrendouzumiSyoruiImg.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJT_AksrendouzumiSyoruiImg.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}