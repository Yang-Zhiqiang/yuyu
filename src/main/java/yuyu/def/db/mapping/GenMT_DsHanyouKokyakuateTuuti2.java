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
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.id.PKMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.meta.GenQMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.meta.QMT_DsHanyouKokyakuateTuuti2;
import yuyu.def.db.type.UserType_C_DsHanyouKokyakuateTuutiKbn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＤＳ汎用顧客宛通知２テーブル テーブルのマッピング情報クラスで、 {@link MT_DsHanyouKokyakuateTuuti2} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHanyouKokyakuateTuuti2}</td><td colspan="3">ＤＳ汎用顧客宛通知２テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti2 ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskoktuutirenno dskoktuutirenno}</td><td>ＤＳ顧客通知連番</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti2 ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDshanyoukokyakuatetuutikbn dshanyoukokyakuatetuutikbn}</td><td>ＤＳ汎用顧客宛通知区分</td><td align="center">{@link PKMT_DsHanyouKokyakuateTuuti2 ○}</td><td align="center">V</td><td>{@link C_DsHanyouKokyakuateTuutiKbn}</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDssousinno dssousinno}</td><td>ＤＳ送信番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHanyouKokyakuateTuuti2
 * @see     PKMT_DsHanyouKokyakuateTuuti2
 * @see     QMT_DsHanyouKokyakuateTuuti2
 * @see     GenQMT_DsHanyouKokyakuateTuuti2
 */
@MappedSuperclass
@Table(name=GenMT_DsHanyouKokyakuateTuuti2.TABLE_NAME)
@IdClass(value=PKMT_DsHanyouKokyakuateTuuti2.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsHanyouKokyakuateTuutiKbn", typeClass=UserType_C_DsHanyouKokyakuateTuutiKbn.class)
})
public abstract class GenMT_DsHanyouKokyakuateTuuti2 extends AbstractExDBEntity<MT_DsHanyouKokyakuateTuuti2, PKMT_DsHanyouKokyakuateTuuti2> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsHanyouKokyakuateTuuti2";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKTUUTIRENNO          = "dskoktuutirenno";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSHANYOUKOKYAKUATETUUTIKBN = "dshanyoukokyakuatetuutikbn";
    public static final String SYONO                    = "syono";
    public static final String DSSOUSINNO               = "dssousinno";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsHanyouKokyakuateTuuti2 primaryKey;

    public GenMT_DsHanyouKokyakuateTuuti2() {
        primaryKey = new PKMT_DsHanyouKokyakuateTuuti2();
    }

    public GenMT_DsHanyouKokyakuateTuuti2(
        BizDate pDsdatasakuseiymd,
        String pDskoktuutirenno,
        String pDskokno,
        C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn
    ) {
        primaryKey = new PKMT_DsHanyouKokyakuateTuuti2(
            pDsdatasakuseiymd,
            pDskoktuutirenno,
            pDskokno,
            pDshanyoukokyakuatetuutikbn
        );
    }

    @Transient
    @Override
    public PKMT_DsHanyouKokyakuateTuuti2 getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsHanyouKokyakuateTuuti2> getMetaClass() {
        return QMT_DsHanyouKokyakuateTuuti2.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.DSKOKTUUTIRENNO)
    public String getDskoktuutirenno() {
        return getPrimaryKey().getDskoktuutirenno();
    }

    public void setDskoktuutirenno(String pDskoktuutirenno) {
        getPrimaryKey().setDskoktuutirenno(pDskoktuutirenno);
    }

    @Id
    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Type(type="UserType_C_DsHanyouKokyakuateTuutiKbn")
    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.DSHANYOUKOKYAKUATETUUTIKBN)
    public C_DsHanyouKokyakuateTuutiKbn getDshanyoukokyakuatetuutikbn() {
        return getPrimaryKey().getDshanyoukokyakuatetuutikbn();
    }

    public void setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        getPrimaryKey().setDshanyoukokyakuatetuutikbn(pDshanyoukokyakuatetuutikbn);
    }

    private String syono;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.SYONO)
    @SyoukenNo
    public String getSyono() {
        return syono;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setSyono(String pSyono) {
        syono = pSyono;
    }

    private String dssousinno;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.DSSOUSINNO)
    public String getDssousinno() {
        return dssousinno;
    }

    public void setDssousinno(String pDssousinno) {
        dssousinno = pDssousinno;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsHanyouKokyakuateTuuti2.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}