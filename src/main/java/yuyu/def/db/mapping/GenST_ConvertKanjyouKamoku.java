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
import yuyu.def.classification.C_Kanjyoukmkcd;
import yuyu.def.classification.C_TaisyakuKbn;
import yuyu.def.db.entity.ST_ConvertKanjyouKamoku;
import yuyu.def.db.id.PKST_ConvertKanjyouKamoku;
import yuyu.def.db.meta.GenQST_ConvertKanjyouKamoku;
import yuyu.def.db.meta.QST_ConvertKanjyouKamoku;
import yuyu.def.db.type.UserType_C_Kanjyoukmkcd;
import yuyu.def.db.type.UserType_C_TaisyakuKbn;

/**
 * 勘定科目変換テーブル テーブルのマッピング情報クラスで、 {@link ST_ConvertKanjyouKamoku} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_ConvertKanjyouKamoku}</td><td colspan="3">勘定科目変換テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKanjyoukmkcd kanjyoukmkcd}</td><td>勘定科目コード</td><td align="center">{@link PKST_ConvertKanjyouKamoku ○}</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getTaisyakukbn taisyakukbn}</td><td>貸借区分</td><td align="center">{@link PKST_ConvertKanjyouKamoku ○}</td><td align="center">V</td><td>{@link C_TaisyakuKbn}</td></tr>
 *  <tr><td>{@link #getConvertedkanjyoukmkcd convertedkanjyoukmkcd}</td><td>変換後勘定科目コード</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kanjyoukmkcd}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_ConvertKanjyouKamoku
 * @see     PKST_ConvertKanjyouKamoku
 * @see     QST_ConvertKanjyouKamoku
 * @see     GenQST_ConvertKanjyouKamoku
 */
@MappedSuperclass
@Table(name=GenST_ConvertKanjyouKamoku.TABLE_NAME)
@IdClass(value=PKST_ConvertKanjyouKamoku.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Kanjyoukmkcd", typeClass=UserType_C_Kanjyoukmkcd.class),
    @TypeDef(name="UserType_C_TaisyakuKbn", typeClass=UserType_C_TaisyakuKbn.class)
})
public abstract class GenST_ConvertKanjyouKamoku extends AbstractExDBEntity<ST_ConvertKanjyouKamoku, PKST_ConvertKanjyouKamoku> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "ST_ConvertKanjyouKamoku";
    public static final String KANJYOUKMKCD             = "kanjyoukmkcd";
    public static final String TAISYAKUKBN              = "taisyakukbn";
    public static final String CONVERTEDKANJYOUKMKCD    = "convertedkanjyoukmkcd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKST_ConvertKanjyouKamoku primaryKey;

    public GenST_ConvertKanjyouKamoku() {
        primaryKey = new PKST_ConvertKanjyouKamoku();
    }

    public GenST_ConvertKanjyouKamoku(C_Kanjyoukmkcd pKanjyoukmkcd, C_TaisyakuKbn pTaisyakukbn) {
        primaryKey = new PKST_ConvertKanjyouKamoku(pKanjyoukmkcd, pTaisyakukbn);
    }

    @Transient
    @Override
    public PKST_ConvertKanjyouKamoku getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QST_ConvertKanjyouKamoku> getMetaClass() {
        return QST_ConvertKanjyouKamoku.class;
    }

    @Id
    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenST_ConvertKanjyouKamoku.KANJYOUKMKCD)
    public C_Kanjyoukmkcd getKanjyoukmkcd() {
        return getPrimaryKey().getKanjyoukmkcd();
    }

    public void setKanjyoukmkcd(C_Kanjyoukmkcd pKanjyoukmkcd) {
        getPrimaryKey().setKanjyoukmkcd(pKanjyoukmkcd);
    }

    @Id
    @Type(type="UserType_C_TaisyakuKbn")
    @Column(name=GenST_ConvertKanjyouKamoku.TAISYAKUKBN)
    public C_TaisyakuKbn getTaisyakukbn() {
        return getPrimaryKey().getTaisyakukbn();
    }

    public void setTaisyakukbn(C_TaisyakuKbn pTaisyakukbn) {
        getPrimaryKey().setTaisyakukbn(pTaisyakukbn);
    }

    private C_Kanjyoukmkcd convertedkanjyoukmkcd;

    @Type(type="UserType_C_Kanjyoukmkcd")
    @Column(name=GenST_ConvertKanjyouKamoku.CONVERTEDKANJYOUKMKCD)
    public C_Kanjyoukmkcd getConvertedkanjyoukmkcd() {
        return convertedkanjyoukmkcd;
    }

    public void setConvertedkanjyoukmkcd(C_Kanjyoukmkcd pConvertedkanjyoukmkcd) {
        convertedkanjyoukmkcd = pConvertedkanjyoukmkcd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenST_ConvertKanjyouKamoku.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenST_ConvertKanjyouKamoku.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenST_ConvertKanjyouKamoku.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}