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
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.id.PKMT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.meta.GenQMT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti;
import yuyu.def.db.type.UserType_C_DsHanyouKokyakuateTuutiKbn;

/**
 * ＤＳ汎用顧客宛通知テーブル テーブルのマッピング情報クラスで、 {@link MT_DsHanyouKokyakuateTuuti} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHanyouKokyakuateTuuti}</td><td colspan="3">ＤＳ汎用顧客宛通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDshanyoukokyakuatetuutikbn dshanyoukokyakuatetuutikbn}</td><td>ＤＳ汎用顧客宛通知区分</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti ○}</td><td align="center">V</td><td>{@link C_DsHanyouKokyakuateTuutiKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHanyouKokyakuateTuuti
 * @see     PKMT_DsHanyouKokyakuateTuuti
 * @see     QMT_DsHanyouKokyakuateTuuti
 * @see     GenQMT_DsHanyouKokyakuateTuuti
 */
@MappedSuperclass
@Table(name=GenMT_DsHanyouKokyakuateTuuti.TABLE_NAME)
@IdClass(value=PKMT_DsHanyouKokyakuateTuuti.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsHanyouKokyakuateTuutiKbn", typeClass=UserType_C_DsHanyouKokyakuateTuutiKbn.class)
})
public abstract class GenMT_DsHanyouKokyakuateTuuti extends AbstractExDBEntity<MT_DsHanyouKokyakuateTuuti, PKMT_DsHanyouKokyakuateTuuti> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsHanyouKokyakuateTuuti";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSHANYOUKOKYAKUATETUUTIKBN = "dshanyoukokyakuatetuutikbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsHanyouKokyakuateTuuti primaryKey;

    public GenMT_DsHanyouKokyakuateTuuti() {
        primaryKey = new PKMT_DsHanyouKokyakuateTuuti();
    }

    public GenMT_DsHanyouKokyakuateTuuti(
        BizDate pDsdatasakuseiymd,
        String pDskokno,
        C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn
    ) {
        primaryKey = new PKMT_DsHanyouKokyakuateTuuti(
            pDsdatasakuseiymd,
            pDskokno,
            pDshanyoukokyakuatetuutikbn
        );
    }

    @Transient
    @Override
    public PKMT_DsHanyouKokyakuateTuuti getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsHanyouKokyakuateTuuti> getMetaClass() {
        return QMT_DsHanyouKokyakuateTuuti.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsHanyouKokyakuateTuuti.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsHanyouKokyakuateTuuti.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Type(type="UserType_C_DsHanyouKokyakuateTuutiKbn")
    @Column(name=GenMT_DsHanyouKokyakuateTuuti.DSHANYOUKOKYAKUATETUUTIKBN)
    public C_DsHanyouKokyakuateTuutiKbn getDshanyoukokyakuatetuutikbn() {
        return getPrimaryKey().getDshanyoukokyakuatetuutikbn();
    }

    public void setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        getPrimaryKey().setDshanyoukokyakuatetuutikbn(pDshanyoukokyakuatetuutikbn);
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
