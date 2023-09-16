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
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateType;
import jp.co.slcs.swak.db.hibernate.usertype.BizDateYMType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_Kjsmhakkouzumiflg;
import yuyu.def.classification.C_Tkiktannaitukisuu;
import yuyu.def.db.entity.IT_BAK_AnsyuKihon;
import yuyu.def.db.id.PKIT_BAK_AnsyuKihon;
import yuyu.def.db.meta.GenQIT_BAK_AnsyuKihon;
import yuyu.def.db.meta.QIT_BAK_AnsyuKihon;
import yuyu.def.db.type.UserType_C_Kjsmhakkouzumiflg;
import yuyu.def.db.type.UserType_C_Tkiktannaitukisuu;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 案内収納基本バックアップテーブル テーブルのマッピング情報クラスで、 {@link IT_BAK_AnsyuKihon} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_AnsyuKihon}</td><td colspan="3">案内収納基本バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">{@link PKIT_BAK_AnsyuKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">{@link PKIT_BAK_AnsyuKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">{@link PKIT_BAK_AnsyuKihon ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getJkipjytym jkipjytym}</td><td>次回Ｐ充当年月</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>{@link #getTkiktannaitukisuu tkiktannaitukisuu}</td><td>定期一括案内月数</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Tkiktannaitukisuu}</td></tr>
 *  <tr><td>{@link #getKjsmhakkouzumiflg kjsmhakkouzumiflg}</td><td>控除証明書発行済フラグ</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Kjsmhakkouzumiflg}</td></tr>
 *  <tr><td>{@link #getSyuharaimanymd syuharaimanymd}</td><td>主契約払満日</td><td align="center">&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_AnsyuKihon
 * @see     PKIT_BAK_AnsyuKihon
 * @see     QIT_BAK_AnsyuKihon
 * @see     GenQIT_BAK_AnsyuKihon
 */
@MappedSuperclass
@Table(name=GenIT_BAK_AnsyuKihon.TABLE_NAME)
@IdClass(value=PKIT_BAK_AnsyuKihon.class)
@TypeDefs({
    @TypeDef(name="BizDateType", typeClass=BizDateType.class),
    @TypeDef(name="BizDateYMType", typeClass=BizDateYMType.class),
    @TypeDef(name="UserType_C_Kjsmhakkouzumiflg", typeClass=UserType_C_Kjsmhakkouzumiflg.class),
    @TypeDef(name="UserType_C_Tkiktannaitukisuu", typeClass=UserType_C_Tkiktannaitukisuu.class)
})
public abstract class GenIT_BAK_AnsyuKihon extends AbstractExDBEntity<IT_BAK_AnsyuKihon, PKIT_BAK_AnsyuKihon> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "IT_BAK_AnsyuKihon";
    public static final String KBNKEY                   = "kbnkey";
    public static final String SYONO                    = "syono";
    public static final String TRKSSIKIBETUKEY          = "trkssikibetukey";
    public static final String JKIPJYTYM                = "jkipjytym";
    public static final String TKIKTANNAITUKISUU        = "tkiktannaitukisuu";
    public static final String KJSMHAKKOUZUMIFLG        = "kjsmhakkouzumiflg";
    public static final String SYUHARAIMANYMD           = "syuharaimanymd";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKIT_BAK_AnsyuKihon primaryKey;

    public GenIT_BAK_AnsyuKihon() {
        primaryKey = new PKIT_BAK_AnsyuKihon();
    }

    public GenIT_BAK_AnsyuKihon(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey
    ) {
        primaryKey = new PKIT_BAK_AnsyuKihon(
            pKbnkey,
            pSyono,
            pTrkssikibetukey
        );
    }

    @Transient
    @Override
    public PKIT_BAK_AnsyuKihon getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QIT_BAK_AnsyuKihon> getMetaClass() {
        return QIT_BAK_AnsyuKihon.class;
    }

    @Id
    @Column(name=GenIT_BAK_AnsyuKihon.KBNKEY)
    public String getKbnkey() {
        return getPrimaryKey().getKbnkey();
    }

    public void setKbnkey(String pKbnkey) {
        getPrimaryKey().setKbnkey(pKbnkey);
    }

    @Id
    @Column(name=GenIT_BAK_AnsyuKihon.SYONO)
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
    @Column(name=GenIT_BAK_AnsyuKihon.TRKSSIKIBETUKEY)
    public String getTrkssikibetukey() {
        return getPrimaryKey().getTrkssikibetukey();
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        getPrimaryKey().setTrkssikibetukey(pTrkssikibetukey);
    }

    private BizDateYM jkipjytym;

    @Type(type="BizDateYMType")
    @Column(name=GenIT_BAK_AnsyuKihon.JKIPJYTYM)
    public BizDateYM getJkipjytym() {
        return jkipjytym;
    }

    @Trim("both")
    public void setJkipjytym(BizDateYM pJkipjytym) {
        jkipjytym = pJkipjytym;
    }

    private C_Tkiktannaitukisuu tkiktannaitukisuu;

    @Type(type="UserType_C_Tkiktannaitukisuu")
    @Column(name=GenIT_BAK_AnsyuKihon.TKIKTANNAITUKISUU)
    public C_Tkiktannaitukisuu getTkiktannaitukisuu() {
        return tkiktannaitukisuu;
    }

    public void setTkiktannaitukisuu(C_Tkiktannaitukisuu pTkiktannaitukisuu) {
        tkiktannaitukisuu = pTkiktannaitukisuu;
    }

    private C_Kjsmhakkouzumiflg kjsmhakkouzumiflg;

    @Type(type="UserType_C_Kjsmhakkouzumiflg")
    @Column(name=GenIT_BAK_AnsyuKihon.KJSMHAKKOUZUMIFLG)
    public C_Kjsmhakkouzumiflg getKjsmhakkouzumiflg() {
        return kjsmhakkouzumiflg;
    }

    public void setKjsmhakkouzumiflg(C_Kjsmhakkouzumiflg pKjsmhakkouzumiflg) {
        kjsmhakkouzumiflg = pKjsmhakkouzumiflg;
    }

    private BizDate syuharaimanymd;

    @Type(type="BizDateType")
    @Column(name=GenIT_BAK_AnsyuKihon.SYUHARAIMANYMD)
    public BizDate getSyuharaimanymd() {
        return syuharaimanymd;
    }

    public void setSyuharaimanymd(BizDate pSyuharaimanymd) {
        syuharaimanymd = pSyuharaimanymd;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenIT_BAK_AnsyuKihon.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenIT_BAK_AnsyuKihon.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenIT_BAK_AnsyuKihon.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}