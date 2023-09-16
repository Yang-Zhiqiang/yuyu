package yuyu.def.db.mapping;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import yuyu.def.db.entity.AT_HaitaSeigyo;
import yuyu.def.db.id.PKAT_HaitaSeigyo;
import yuyu.def.db.meta.GenQAT_HaitaSeigyo;
import yuyu.def.db.meta.QAT_HaitaSeigyo;

/**
 * 排他制御テーブル テーブルのマッピング情報クラスで、 {@link AT_HaitaSeigyo} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AT_HaitaSeigyo}</td><td colspan="3">排他制御テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getHaitaSyuruiCd haitaSyuruiCd}</td><td>排他種類コード</td><td align="center">{@link PKAT_HaitaSeigyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitaKey haitaKey}</td><td>排他キー</td><td align="center">{@link PKAT_HaitaSeigyo ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitamotoKinouId haitamotoKinouId}</td><td>排他元機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitaUserId haitaUserId}</td><td>排他ユーザーＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitaKaisiTime haitaKaisiTime}</td><td>排他開始時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHaitaUniqueKey haitaUniqueKey}</td><td>排他ユニークキー</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AT_HaitaSeigyo
 * @see     PKAT_HaitaSeigyo
 * @see     QAT_HaitaSeigyo
 * @see     GenQAT_HaitaSeigyo
 */
@MappedSuperclass
@Table(name=GenAT_HaitaSeigyo.TABLE_NAME)
@IdClass(value=PKAT_HaitaSeigyo.class)
public abstract class GenAT_HaitaSeigyo extends AbstractExDBEntity<AT_HaitaSeigyo, PKAT_HaitaSeigyo> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "AT_HaitaSeigyo";
    public static final String HAITASYURUICD            = "haitaSyuruiCd";
    public static final String HAITAKEY                 = "haitaKey";
    public static final String HAITAMOTOKINOUID         = "haitamotoKinouId";
    public static final String HAITAUSERID              = "haitaUserId";
    public static final String HAITAKAISITIME           = "haitaKaisiTime";
    public static final String HAITAUNIQUEKEY           = "haitaUniqueKey";

    private final PKAT_HaitaSeigyo primaryKey;

    public GenAT_HaitaSeigyo() {
        primaryKey = new PKAT_HaitaSeigyo();
    }

    public GenAT_HaitaSeigyo(String pHaitaSyuruiCd, String pHaitaKey) {
        primaryKey = new PKAT_HaitaSeigyo(pHaitaSyuruiCd, pHaitaKey);
    }

    @Transient
    @Override
    public PKAT_HaitaSeigyo getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QAT_HaitaSeigyo> getMetaClass() {
        return QAT_HaitaSeigyo.class;
    }

    @Id
    @Column(name=GenAT_HaitaSeigyo.HAITASYURUICD)
    public String getHaitaSyuruiCd() {
        return getPrimaryKey().getHaitaSyuruiCd();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaSyuruiCd(String pHaitaSyuruiCd) {
        getPrimaryKey().setHaitaSyuruiCd(pHaitaSyuruiCd);
    }

    @Id
    @Column(name=GenAT_HaitaSeigyo.HAITAKEY)
    public String getHaitaKey() {
        return getPrimaryKey().getHaitaKey();
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaKey(String pHaitaKey) {
        getPrimaryKey().setHaitaKey(pHaitaKey);
    }

    private String haitamotoKinouId;

    @Column(name=GenAT_HaitaSeigyo.HAITAMOTOKINOUID)
    public String getHaitamotoKinouId() {
        return haitamotoKinouId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitamotoKinouId(String pHaitamotoKinouId) {
        haitamotoKinouId = pHaitamotoKinouId;
    }

    private String haitaUserId;

    @Column(name=GenAT_HaitaSeigyo.HAITAUSERID)
    public String getHaitaUserId() {
        return haitaUserId;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaUserId(String pHaitaUserId) {
        haitaUserId = pHaitaUserId;
    }

    private String haitaKaisiTime;

    @Column(name=GenAT_HaitaSeigyo.HAITAKAISITIME)
    public String getHaitaKaisiTime() {
        return haitaKaisiTime;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaKaisiTime(String pHaitaKaisiTime) {
        haitaKaisiTime = pHaitaKaisiTime;
    }

    private String haitaUniqueKey;

    @Column(name=GenAT_HaitaSeigyo.HAITAUNIQUEKEY)
    public String getHaitaUniqueKey() {
        return haitaUniqueKey;
    }

    @Trim("both")
    @DataConvert("toSingleByte")
    public void setHaitaUniqueKey(String pHaitaUniqueKey) {
        haitaUniqueKey = pHaitaUniqueKey;
    }
}
