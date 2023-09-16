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
import yuyu.def.classification.C_Huho2kyknoKbn;
import yuyu.def.classification.C_JdTrksPalTrksZanKbn;
import yuyu.def.classification.C_KyknaiyouhaneiErrKbn;
import yuyu.def.classification.C_MQSyorikekkaKbn;
import yuyu.def.classification.C_TorikesiKekkaKbn;
import yuyu.def.db.entity.BT_YoukyuuNoKanri;
import yuyu.def.db.id.PKBT_YoukyuuNoKanri;
import yuyu.def.db.meta.GenQBT_YoukyuuNoKanri;
import yuyu.def.db.meta.QBT_YoukyuuNoKanri;
import yuyu.def.db.type.UserType_C_Huho2kyknoKbn;
import yuyu.def.db.type.UserType_C_JdTrksPalTrksZanKbn;
import yuyu.def.db.type.UserType_C_KyknaiyouhaneiErrKbn;
import yuyu.def.db.type.UserType_C_MQSyorikekkaKbn;
import yuyu.def.db.type.UserType_C_TorikesiKekkaKbn;

/**
 * 要求通番管理テーブル テーブルのマッピング情報クラスで、 {@link BT_YoukyuuNoKanri} のスーパークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_YoukyuuNoKanri}</td><td colspan="3">要求通番管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>{@link #getYoukyuuno youkyuuno}</td><td>要求通番</td><td align="center">{@link PKBT_YoukyuuNoKanri ○}</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getHuho2kyknokbn huho2kyknokbn}</td><td>普保Ⅱ契約番号区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_Huho2kyknoKbn}</td></tr>
 *  <tr><td>{@link #getHuho2kykno huho2kykno}</td><td>普保Ⅱ契約番号</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMqkousinmqsyorikekkakbn mqkousinmqsyorikekkakbn}</td><td>（ＭＱ更新用）ＭＱ処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getMqkousinacserrcd mqkousinacserrcd}</td><td>（ＭＱ更新用）ＡＣＳ基盤エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getMqtrksiraimqsyorikekkakbn mqtrksiraimqsyorikekkakbn}</td><td>（ＭＱ取消依頼用）ＭＱ処理結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_MQSyorikekkaKbn}</td></tr>
 *  <tr><td>{@link #getMqtrksiraiacserrcd mqtrksiraiacserrcd}</td><td>（ＭＱ取消依頼用）ＡＣＳ基盤エラーコード</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getKyknaiyouhaneierrkbn kyknaiyouhaneierrkbn}</td><td>契約内容反映エラー区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_KyknaiyouhaneiErrKbn}</td></tr>
 *  <tr><td>{@link #getTrkskekkakbn trkskekkakbn}</td><td>取消結果区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_TorikesiKekkaKbn}</td></tr>
 *  <tr><td>{@link #getJdtrkspaltrkszankbn jdtrkspaltrkszankbn}</td><td>自動取消用ＰＡＬ取消残区分</td><td align="center">&nbsp;</td><td align="center">V</td><td>{@link C_JdTrksPalTrksZanKbn}</td></tr>
 *  <tr><td>{@link #getGyoumuKousinKinou gyoumuKousinKinou}</td><td>業務用更新機能ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinsyaId gyoumuKousinsyaId}</td><td>業務用更新者ＩＤ</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>{@link #getGyoumuKousinTime gyoumuKousinTime}</td><td>業務用更新時間</td><td align="center">&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BT_YoukyuuNoKanri
 * @see     PKBT_YoukyuuNoKanri
 * @see     QBT_YoukyuuNoKanri
 * @see     GenQBT_YoukyuuNoKanri
 */
@MappedSuperclass
@Table(name=GenBT_YoukyuuNoKanri.TABLE_NAME)
@IdClass(value=PKBT_YoukyuuNoKanri.class)
@TypeDefs({
    @TypeDef(name="UserType_C_Huho2kyknoKbn", typeClass=UserType_C_Huho2kyknoKbn.class),
    @TypeDef(name="UserType_C_JdTrksPalTrksZanKbn", typeClass=UserType_C_JdTrksPalTrksZanKbn.class),
    @TypeDef(name="UserType_C_KyknaiyouhaneiErrKbn", typeClass=UserType_C_KyknaiyouhaneiErrKbn.class),
    @TypeDef(name="UserType_C_MQSyorikekkaKbn", typeClass=UserType_C_MQSyorikekkaKbn.class),
    @TypeDef(name="UserType_C_TorikesiKekkaKbn", typeClass=UserType_C_TorikesiKekkaKbn.class)
})
public abstract class GenBT_YoukyuuNoKanri extends AbstractExDBEntity<BT_YoukyuuNoKanri, PKBT_YoukyuuNoKanri> {

    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME               = "BT_YoukyuuNoKanri";
    public static final String YOUKYUUNO                = "youkyuuno";
    public static final String HUHO2KYKNOKBN            = "huho2kyknokbn";
    public static final String HUHO2KYKNO               = "huho2kykno";
    public static final String MQKOUSINMQSYORIKEKKAKBN  = "mqkousinmqsyorikekkakbn";
    public static final String MQKOUSINACSERRCD         = "mqkousinacserrcd";
    public static final String MQTRKSIRAIMQSYORIKEKKAKBN = "mqtrksiraimqsyorikekkakbn";
    public static final String MQTRKSIRAIACSERRCD       = "mqtrksiraiacserrcd";
    public static final String KYKNAIYOUHANEIERRKBN     = "kyknaiyouhaneierrkbn";
    public static final String TRKSKEKKAKBN             = "trkskekkakbn";
    public static final String JDTRKSPALTRKSZANKBN      = "jdtrkspaltrkszankbn";
    public static final String GYOUMUKOUSINKINOU        = "gyoumuKousinKinou";
    public static final String GYOUMUKOUSINSYAID        = "gyoumuKousinsyaId";
    public static final String GYOUMUKOUSINTIME         = "gyoumuKousinTime";

    private final PKBT_YoukyuuNoKanri primaryKey;

    public GenBT_YoukyuuNoKanri() {
        primaryKey = new PKBT_YoukyuuNoKanri();
    }

    public GenBT_YoukyuuNoKanri(String pYoukyuuno) {
        primaryKey = new PKBT_YoukyuuNoKanri(pYoukyuuno);
    }

    @Transient
    @Override
    public PKBT_YoukyuuNoKanri getPrimaryKey() {
        return primaryKey;
    }

    @Transient
    @Override
    public Class<QBT_YoukyuuNoKanri> getMetaClass() {
        return QBT_YoukyuuNoKanri.class;
    }

    @Id
    @Column(name=GenBT_YoukyuuNoKanri.YOUKYUUNO)
    public String getYoukyuuno() {
        return getPrimaryKey().getYoukyuuno();
    }

    public void setYoukyuuno(String pYoukyuuno) {
        getPrimaryKey().setYoukyuuno(pYoukyuuno);
    }

    private C_Huho2kyknoKbn huho2kyknokbn;

    @Type(type="UserType_C_Huho2kyknoKbn")
    @Column(name=GenBT_YoukyuuNoKanri.HUHO2KYKNOKBN)
    public C_Huho2kyknoKbn getHuho2kyknokbn() {
        return huho2kyknokbn;
    }

    public void setHuho2kyknokbn(C_Huho2kyknoKbn pHuho2kyknokbn) {
        huho2kyknokbn = pHuho2kyknokbn;
    }

    private String huho2kykno;

    @Column(name=GenBT_YoukyuuNoKanri.HUHO2KYKNO)
    public String getHuho2kykno() {
        return huho2kykno;
    }

    public void setHuho2kykno(String pHuho2kykno) {
        huho2kykno = pHuho2kykno;
    }

    private C_MQSyorikekkaKbn mqkousinmqsyorikekkakbn;

    @Type(type="UserType_C_MQSyorikekkaKbn")
    @Column(name=GenBT_YoukyuuNoKanri.MQKOUSINMQSYORIKEKKAKBN)
    public C_MQSyorikekkaKbn getMqkousinmqsyorikekkakbn() {
        return mqkousinmqsyorikekkakbn;
    }

    public void setMqkousinmqsyorikekkakbn(C_MQSyorikekkaKbn pMqkousinmqsyorikekkakbn) {
        mqkousinmqsyorikekkakbn = pMqkousinmqsyorikekkakbn;
    }

    private String mqkousinacserrcd;

    @Column(name=GenBT_YoukyuuNoKanri.MQKOUSINACSERRCD)
    public String getMqkousinacserrcd() {
        return mqkousinacserrcd;
    }

    public void setMqkousinacserrcd(String pMqkousinacserrcd) {
        mqkousinacserrcd = pMqkousinacserrcd;
    }

    private C_MQSyorikekkaKbn mqtrksiraimqsyorikekkakbn;

    @Type(type="UserType_C_MQSyorikekkaKbn")
    @Column(name=GenBT_YoukyuuNoKanri.MQTRKSIRAIMQSYORIKEKKAKBN)
    public C_MQSyorikekkaKbn getMqtrksiraimqsyorikekkakbn() {
        return mqtrksiraimqsyorikekkakbn;
    }

    public void setMqtrksiraimqsyorikekkakbn(C_MQSyorikekkaKbn pMqtrksiraimqsyorikekkakbn) {
        mqtrksiraimqsyorikekkakbn = pMqtrksiraimqsyorikekkakbn;
    }

    private String mqtrksiraiacserrcd;

    @Column(name=GenBT_YoukyuuNoKanri.MQTRKSIRAIACSERRCD)
    public String getMqtrksiraiacserrcd() {
        return mqtrksiraiacserrcd;
    }

    public void setMqtrksiraiacserrcd(String pMqtrksiraiacserrcd) {
        mqtrksiraiacserrcd = pMqtrksiraiacserrcd;
    }

    private C_KyknaiyouhaneiErrKbn kyknaiyouhaneierrkbn;

    @Type(type="UserType_C_KyknaiyouhaneiErrKbn")
    @Column(name=GenBT_YoukyuuNoKanri.KYKNAIYOUHANEIERRKBN)
    public C_KyknaiyouhaneiErrKbn getKyknaiyouhaneierrkbn() {
        return kyknaiyouhaneierrkbn;
    }

    public void setKyknaiyouhaneierrkbn(C_KyknaiyouhaneiErrKbn pKyknaiyouhaneierrkbn) {
        kyknaiyouhaneierrkbn = pKyknaiyouhaneierrkbn;
    }

    private C_TorikesiKekkaKbn trkskekkakbn;

    @Type(type="UserType_C_TorikesiKekkaKbn")
    @Column(name=GenBT_YoukyuuNoKanri.TRKSKEKKAKBN)
    public C_TorikesiKekkaKbn getTrkskekkakbn() {
        return trkskekkakbn;
    }

    public void setTrkskekkakbn(C_TorikesiKekkaKbn pTrkskekkakbn) {
        trkskekkakbn = pTrkskekkakbn;
    }

    private C_JdTrksPalTrksZanKbn jdtrkspaltrkszankbn;

    @Type(type="UserType_C_JdTrksPalTrksZanKbn")
    @Column(name=GenBT_YoukyuuNoKanri.JDTRKSPALTRKSZANKBN)
    public C_JdTrksPalTrksZanKbn getJdtrkspaltrkszankbn() {
        return jdtrkspaltrkszankbn;
    }

    public void setJdtrkspaltrkszankbn(C_JdTrksPalTrksZanKbn pJdtrkspaltrkszankbn) {
        jdtrkspaltrkszankbn = pJdtrkspaltrkszankbn;
    }

    private String gyoumuKousinKinou;

    @Column(name=GenBT_YoukyuuNoKanri.GYOUMUKOUSINKINOU)
    public String getGyoumuKousinKinou() {
        return gyoumuKousinKinou;
    }

    public void setGyoumuKousinKinou(String pGyoumuKousinKinou) {
        gyoumuKousinKinou = pGyoumuKousinKinou;
    }

    private String gyoumuKousinsyaId;

    @Column(name=GenBT_YoukyuuNoKanri.GYOUMUKOUSINSYAID)
    public String getGyoumuKousinsyaId() {
        return gyoumuKousinsyaId;
    }

    public void setGyoumuKousinsyaId(String pGyoumuKousinsyaId) {
        gyoumuKousinsyaId = pGyoumuKousinsyaId;
    }

    private String gyoumuKousinTime;

    @Column(name=GenBT_YoukyuuNoKanri.GYOUMUKOUSINTIME)
    public String getGyoumuKousinTime() {
        return gyoumuKousinTime;
    }

    public void setGyoumuKousinTime(String pGyoumuKousinTime) {
        gyoumuKousinTime = pGyoumuKousinTime;
    }
}
