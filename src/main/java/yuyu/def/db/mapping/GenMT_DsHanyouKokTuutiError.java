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
import yuyu.def.classification.C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.classification.C_DsHanyouKokyakuateTuutiKbn;
import yuyu.def.db.entity.MT_DsHanyouKokTuutiError;
import yuyu.def.db.id.PKMT_DsHanyouKokTuutiError;
import yuyu.def.db.meta.GenQMT_DsHanyouKokTuutiError;
import yuyu.def.db.meta.QMT_DsHanyouKokTuutiError;
import yuyu.def.db.type.UserType_C_DsHagakiSouhuJyoukyouKbn;
import yuyu.def.db.type.UserType_C_DsHanyouKokyakuateTuutiKbn;

/**
 * ＤＳ汎用顧客宛通知エラーテーブル テーブルのマッピング情報クラスで、 {@link MT_DsHanyouKokTuutiError} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link MT_DsHanyouKokTuutiError}</td><td colspan="3">ＤＳ汎用顧客宛通知エラーテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getDsdatasakuseiymd dsdatasakuseiymd}</td><td>ＤＳデータ作成日</td><td align="center">{@link PKMT_DsHanyouKokTuutiError ○}</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getDskoktuutirenno dskoktuutirenno}</td><td>ＤＳ顧客通知連番</td><td align="center">{@link PKMT_DsHanyouKokTuutiError ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDskokno dskokno}</td><td>ＤＳ顧客番号</td><td align="center">{@link PKMT_DsHanyouKokTuutiError ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getDshanyoukokyakuatetuutikbn dshanyoukokyakuatetuutikbn}</td><td>ＤＳ汎用顧客宛通知区分</td><td align="center">{@link PKMT_DsHanyouKokTuutiError ○}</td><td align="center">V</td><td>{@link C_DsHanyouKokyakuateTuutiKbn}</td></tr>
 *  <tr><td>{@link #getDshagakisouhujyoukyoukbn dshagakisouhujyoukyoukbn}</td><td>ＤＳハガキ送付状況区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_DsHagakiSouhuJyoukyouKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     MT_DsHanyouKokTuutiError
 * @see     PKMT_DsHanyouKokTuutiError
 * @see     QMT_DsHanyouKokTuutiError
 * @see     GenQMT_DsHanyouKokTuutiError
 */
@MappedSuperclass
@Table(name=GenMT_DsHanyouKokTuutiError.TABLE_NAME)
@IdClass(value=PKMT_DsHanyouKokTuutiError.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="UserType_C_DsHagakiSouhuJyoukyouKbn", typeClass=UserType_C_DsHagakiSouhuJyoukyouKbn.class),
    @TypeDef(name="UserType_C_DsHanyouKokyakuateTuutiKbn", typeClass=UserType_C_DsHanyouKokyakuateTuutiKbn.class)
})
public abstract class GenMT_DsHanyouKokTuutiError extends AbstractExDBEntity<MT_DsHanyouKokTuutiError, PKMT_DsHanyouKokTuutiError> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "MT_DsHanyouKokTuutiError";
    public static final String DSDATASAKUSEIYMD         = "dsdatasakuseiymd";
    public static final String DSKOKTUUTIRENNO          = "dskoktuutirenno";
    public static final String DSKOKNO                  = "dskokno";
    public static final String DSHANYOUKOKYAKUATETUUTIKBN = "dshanyoukokyakuatetuutikbn";
    public static final String DSHAGAKISOUHUJYOUKYOUKBN = "dshagakisouhujyoukyoukbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKMT_DsHanyouKokTuutiError primaryKey;

    public GenMT_DsHanyouKokTuutiError() {
        primaryKey = new PKMT_DsHanyouKokTuutiError();
    }

    public GenMT_DsHanyouKokTuutiError(
        BizDate pDsdatasakuseiymd,
        String pDskoktuutirenno,
        String pDskokno,
        C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn
    ) {
        primaryKey = new PKMT_DsHanyouKokTuutiError(
            pDsdatasakuseiymd,
            pDskoktuutirenno,
            pDskokno,
            pDshanyoukokyakuatetuutikbn
        );
    }

    @Transient
    @Override
    public PKMT_DsHanyouKokTuutiError getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QMT_DsHanyouKokTuutiError> getMetaClass() {
        return QMT_DsHanyouKokTuutiError.class;
    }

    @Id
    @Type(type="BizDateType")
    @Column(name=GenMT_DsHanyouKokTuutiError.DSDATASAKUSEIYMD)
    public BizDate getDsdatasakuseiymd() {
        return getPrimaryKey().getDsdatasakuseiymd();
    }

    public void setDsdatasakuseiymd(BizDate pDsdatasakuseiymd) {
        getPrimaryKey().setDsdatasakuseiymd(pDsdatasakuseiymd);
    }

    @Id
    @Column(name=GenMT_DsHanyouKokTuutiError.DSKOKTUUTIRENNO)
    public String getDskoktuutirenno() {
        return getPrimaryKey().getDskoktuutirenno();
    }

    public void setDskoktuutirenno(String pDskoktuutirenno) {
        getPrimaryKey().setDskoktuutirenno(pDskoktuutirenno);
    }

    @Id
    @Column(name=GenMT_DsHanyouKokTuutiError.DSKOKNO)
    public String getDskokno() {
        return getPrimaryKey().getDskokno();
    }

    public void setDskokno(String pDskokno) {
        getPrimaryKey().setDskokno(pDskokno);
    }

    @Id
    @Type(type="UserType_C_DsHanyouKokyakuateTuutiKbn")
    @Column(name=GenMT_DsHanyouKokTuutiError.DSHANYOUKOKYAKUATETUUTIKBN)
    public C_DsHanyouKokyakuateTuutiKbn getDshanyoukokyakuatetuutikbn() {
        return getPrimaryKey().getDshanyoukokyakuatetuutikbn();
    }

    public void setDshanyoukokyakuatetuutikbn(C_DsHanyouKokyakuateTuutiKbn pDshanyoukokyakuatetuutikbn) {
        getPrimaryKey().setDshanyoukokyakuatetuutikbn(pDshanyoukokyakuatetuutikbn);
    }

    private C_DsHagakiSouhuJyoukyouKbn dshagakisouhujyoukyoukbn;

    @Type(type="UserType_C_DsHagakiSouhuJyoukyouKbn")
    @Column(name=GenMT_DsHanyouKokTuutiError.DSHAGAKISOUHUJYOUKYOUKBN)
    public C_DsHagakiSouhuJyoukyouKbn getDshagakisouhujyoukyoukbn() {
        return dshagakisouhujyoukyoukbn;
    }

    public void setDshagakisouhujyoukyoukbn(C_DsHagakiSouhuJyoukyouKbn pDshagakisouhujyoukyoukbn) {
        dshagakisouhujyoukyoukbn = pDshagakisouhujyoukyoukbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenMT_DsHanyouKokTuutiError.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenMT_DsHanyouKokTuutiError.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenMT_DsHanyouKokTuutiError.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}