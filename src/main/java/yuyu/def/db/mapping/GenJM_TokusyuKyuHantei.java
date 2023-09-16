package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.JM_TokusyuKyuHantei;
import yuyu.def.db.id.PKJM_TokusyuKyuHantei;
import yuyu.def.db.meta.GenQJM_TokusyuKyuHantei;
import yuyu.def.db.meta.QJM_TokusyuKyuHantei;

/**
 * 特定給付判定マスタ テーブルのマッピング情報クラスで、 {@link JM_TokusyuKyuHantei} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JM_TokusyuKyuHantei}</td><td colspan="3">特定給付判定マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getByoumeitourokuno byoumeitourokuno}</td><td>病名登録番号</td><td align="center">{@link PKJM_TokusyuKyuHantei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">{@link PKJM_TokusyuKyuHantei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyouhnsdno syouhnsdno}</td><td>商品世代番号</td><td align="center">{@link PKJM_TokusyuKyuHantei ○}</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>{@link #getTekiyoukknfrom tekiyoukknfrom}</td><td>適用期間（自）</td><td align="center">{@link PKJM_TokusyuKyuHantei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTekiyoukknkto tekiyoukknkto}</td><td>適用期間（至）</td><td align="center">{@link PKJM_TokusyuKyuHantei ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JM_TokusyuKyuHantei
 * @see     PKJM_TokusyuKyuHantei
 * @see     QJM_TokusyuKyuHantei
 * @see     GenQJM_TokusyuKyuHantei
 */
@MappedSuperclass
@Table(name=GenJM_TokusyuKyuHantei.TABLE_NAME)
@IdClass(value=PKJM_TokusyuKyuHantei.class)
public abstract class GenJM_TokusyuKyuHantei extends AbstractExDBEntity<JM_TokusyuKyuHantei, PKJM_TokusyuKyuHantei> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "JM_TokusyuKyuHantei";
    public static final String BYOUMEITOUROKUNO         = "byoumeitourokuno";
    public static final String SYOUHNCD                 = "syouhncd";
    public static final String SYOUHNSDNO               = "syouhnsdno";
    public static final String TEKIYOUKKNFROM           = "tekiyoukknfrom";
    public static final String TEKIYOUKKNKTO            = "tekiyoukknkto";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKJM_TokusyuKyuHantei primaryKey;

    public GenJM_TokusyuKyuHantei() {
        primaryKey = new PKJM_TokusyuKyuHantei();
    }

    public GenJM_TokusyuKyuHantei(
        String pByoumeitourokuno,
        String pSyouhncd,
        Integer pSyouhnsdno,
        String pTekiyoukknfrom,
        String pTekiyoukknkto
    ) {
        primaryKey = new PKJM_TokusyuKyuHantei(
            pByoumeitourokuno,
            pSyouhncd,
            pSyouhnsdno,
            pTekiyoukknfrom,
            pTekiyoukknkto
        );
    }

    @Transient
    @Override
    public PKJM_TokusyuKyuHantei getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QJM_TokusyuKyuHantei> getMetaClass() {
        return QJM_TokusyuKyuHantei.class;
    }

    @Id
    @Column(name=GenJM_TokusyuKyuHantei.BYOUMEITOUROKUNO)
    public String getByoumeitourokuno() {
        return getPrimaryKey().getByoumeitourokuno();
    }

    public void setByoumeitourokuno(String pByoumeitourokuno) {
        getPrimaryKey().setByoumeitourokuno(pByoumeitourokuno);
    }

    @Id
    @Column(name=GenJM_TokusyuKyuHantei.SYOUHNCD)
    @MaxLength(max=4)
    @SingleByteStrings
    public String getSyouhncd() {
        return getPrimaryKey().getSyouhncd();
    }

    @Trim("right")
    @DataConvert("toSingleByte")
    public void setSyouhncd(String pSyouhncd) {
        getPrimaryKey().setSyouhncd(pSyouhncd);
    }

    @Id
    @Column(name=GenJM_TokusyuKyuHantei.SYOUHNSDNO)
    public Integer getSyouhnsdno() {
        return getPrimaryKey().getSyouhnsdno();
    }

    public void setSyouhnsdno(Integer pSyouhnsdno) {
        getPrimaryKey().setSyouhnsdno(pSyouhnsdno);
    }

    @Id
    @Column(name=GenJM_TokusyuKyuHantei.TEKIYOUKKNFROM)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknfrom() {
        return getPrimaryKey().getTekiyoukknfrom();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknfrom(String pTekiyoukknfrom) {
        getPrimaryKey().setTekiyoukknfrom(pTekiyoukknfrom);
    }

    @Id
    @Column(name=GenJM_TokusyuKyuHantei.TEKIYOUKKNKTO)
    @Length(length=8)
    @SingleByteStrings
    @Digit
    public String getTekiyoukknkto() {
        return getPrimaryKey().getTekiyoukknkto();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setTekiyoukknkto(String pTekiyoukknkto) {
        getPrimaryKey().setTekiyoukknkto(pTekiyoukknkto);
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenJM_TokusyuKyuHantei.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenJM_TokusyuKyuHantei.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
